package com.aerospike.userdemo.configuration;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import com.aerospike.client.Host;
import com.aerospike.userdemo.repositories.AerospikeUserRepository;


@Configuration
@EnableConfigurationProperties(AerospikeConfigurationProperties.class)
@EnableAerospikeRepositories(basePackageClasses = AerospikeUserRepository.class)
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {
    @Autowired
    private AerospikeConfigurationProperties aerospikeConfigurationProperties;
    @Override
    protected Collection<Host> getHosts() {
        return Collections.singleton(new Host(aerospikeConfigurationProperties.getHost(), aerospikeConfigurationProperties.getPort()));
    }
    @Override
    protected String nameSpace() {
        return aerospikeConfigurationProperties.getNamespace();
    }
}
