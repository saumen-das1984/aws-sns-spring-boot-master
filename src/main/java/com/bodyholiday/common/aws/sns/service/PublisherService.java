package com.bodyholiday.common.aws.sns.service;

public interface PublisherService {
   
    void publish(String topicArn, String message) throws Exception;

}
