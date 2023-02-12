package com.lsh.opennlp.controller;

import com.lsh.opennlp.service.OpenNLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 22:59
 * @Desc:
 */
@RestController
public class OpenNLPController {

    @Autowired
    OpenNLPService openNLPService;

    @GetMapping("/text")
    public String sentence(String sentence){
        openNLPService.sentence(sentence);
        return "";
    }
}
