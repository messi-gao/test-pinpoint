/**
 * Copyright 2014 NAVER Corp.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.navercorp.pinpoint.plugin.sample;

import com.navercorp.plugin.sample.target.TargetClass14_Request;
import com.navercorp.plugin.sample.target.TargetClass14_Server;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *  
 * 
 * @see Sample_14_RPC_Server_IT
 * @author Jongho Moon
 */
@RestController
public class Sample_14_RPC_Server_IT {

    @RequestMapping("/14A")
    public void test() throws Exception {
        Map<String, String> metadatas = new HashMap<String, String>();
        metadatas.put("_SAMPLE_TRASACTION_ID", "frontend.agent^1234567890^123");
        metadatas.put("_SAMPLE_SPAN_ID", "9876543210");
        metadatas.put("_SAMPLE_PARENT_SPAN_ID", "1357913579");
        metadatas.put("_SAMPLE_PARENT_APPLICATION_NAME", "sample.client");
        metadatas.put("_SAMPLE_PARENT_APPLICATION_TYPE", "1000");
        metadatas.put("_SAMPLE_FLAGS", "0");
        
        TargetClass14_Server server = new TargetClass14_Server("1.2.3.4");
        TargetClass14_Request request = new TargetClass14_Request("5.6.7.8", "sample.pinpoint.navercorp.com", "hello", "pinpoint", metadatas);
        
        server.process(request);
        
        Method process = TargetClass14_Server.class.getMethod("process", TargetClass14_Request.class);

    }

    @RequestMapping("/14B")
    public void testDoNotTrace() throws Exception {
        Map<String, String> metadatas = new HashMap<String, String>();
        metadatas.put("_SAMPLE_DO_NOT_TRACE", "1");
        
        TargetClass14_Server server = new TargetClass14_Server("1.2.3.4");
        TargetClass14_Request request = new TargetClass14_Request("5.6.7.8", "sample.pinpoint.navercorp.com", "hello", "pinpoint", metadatas);
        
        server.process(request);
        

    }
}
