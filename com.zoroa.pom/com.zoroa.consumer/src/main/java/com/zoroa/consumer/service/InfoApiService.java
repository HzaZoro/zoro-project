package com.zoroa.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.zoroa.api.service.InfoService;
import com.zoroa.consumer.config.LogLevelConfig;

@FeignClient(value="provide-service",configuration=LogLevelConfig.class)
public interface InfoApiService extends InfoService{

}
