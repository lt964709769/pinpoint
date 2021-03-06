/*
 * Copyright 2019 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.collector.config;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class StatReceiverConfigurationTest {

    @Test
    public void properties() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("collector.receiver.stat.grpc", "");
        properties.setProperty("collector.receiver.stat.grpc.ip", "9.9.9.9");
        properties.setProperty("collector.receiver.stat.grpc.port", "1111");
        properties.setProperty("collector.receiver.stat.grpc.worker.threadSize", "99");
        properties.setProperty("collector.receiver.stat.grpc.worker.queueSize", "9999");
        properties.setProperty("collector.receiver.stat.grpc.worker.monitor", "false");
        properties.setProperty("collector.receiver.stat.grpc.keepalive.time", "3");
        properties.setProperty("collector.receiver.stat.grpc.keepalive.timeout", "7");

        StatReceiverConfiguration configuration = new StatReceiverConfiguration(properties, new DeprecatedConfiguration());
        assertEquals(Boolean.FALSE, configuration.isGrpcEnable());
        assertEquals("9.9.9.9", configuration.getGrpcBindIp());
        assertEquals(1111, configuration.getGrpcBindPort());
        assertEquals(99, configuration.getGrpcWorkerThreadSize());
        assertEquals(9999, configuration.getGrpcWorkerQueueSize());
        assertEquals(Boolean.FALSE, configuration.isGrpcWorkerMonitorEnable());
        assertEquals(3, configuration.getGrpcKeepAliveTime());
        assertEquals(7, configuration.getGrpcKeepAliveTimeout());
    }
}