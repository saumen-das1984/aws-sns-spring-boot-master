package com.bodyholiday.common.aws.sns.service.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.bodyholiday.common.aws.sns.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmazonSNSPublisherService implements PublisherService {

    private AmazonSNS amazonSNS;

    @Autowired
    public AmazonSNSPublisherService(BasicSessionCredentials sessionCredentials) {
    	System.out.println("sessionCredentials "+sessionCredentials);
        this.amazonSNS = AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(sessionCredentials)).build();
    }

    @Override
    public void publish(String topicArn, String message) throws Exception {

    	System.out.println("topicArn : "+topicArn);
    	System.out.println("message : "+message);
        
        PublishRequest publishRequest = new PublishRequest(topicArn, message);
        PublishResult publishResult = this.amazonSNS.publish(publishRequest);

        System.out.println("MessageId - " + publishResult.getMessageId());

    }

}
