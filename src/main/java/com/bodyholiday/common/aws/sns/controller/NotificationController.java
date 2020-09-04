package com.bodyholiday.common.aws.sns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bodyholiday.common.aws.sns.service.PublisherService;

@RestController
@RequestMapping("/sns/notification")
public class NotificationController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping(value = "/publish", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> publishNotification(@RequestBody String message, @RequestParam(name = "snstopic") String topicArn) {

        try {
            publisherService.publish(topicArn, message);
            return new ResponseEntity<String>(message,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}










