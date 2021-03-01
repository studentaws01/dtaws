package com.aerospike.userdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "aerospike")
public class AerospikeConfigurationProperties {
    private String host;
    private int port;
    private String namespace;
}