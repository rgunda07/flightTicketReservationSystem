package com.example.flightticketreservationsystem.domains;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dynamoDBConfig {

//    @Value("${aws.dynamodb.endpoint}")
//    private String dynamoDbEndpoint;

    @Value("${aws.region}")
    private String region;

//    @Value("${aws.accessKeyId}")
//    private String awsAccessKeyId;
//
//    @Value("${aws.secretKey}")
//    private String awsSecretKey;


    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
        builder.withRegion(region);
        return builder.build();
    }
//    @Bean
//    public AmazonDynamoDB amazonDynamoDB() {
//        return AmazonDynamoDBClientBuilder.standard()
//                .withEndpointConfiguration(
//                        new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, region))
//                .withCredentials(new AWSStaticCredentialsProvider(
//                        new BasicAWSCredentials(awsAccessKeyId, awsSecretKey)))
//                .build();
//    }
}

