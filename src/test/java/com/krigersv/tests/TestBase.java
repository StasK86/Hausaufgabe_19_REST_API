package com.krigersv.tests;

import com.krigersv.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestBase {
    protected static final ApiConfig config = ConfigFactory.create(ApiConfig.class);
}
