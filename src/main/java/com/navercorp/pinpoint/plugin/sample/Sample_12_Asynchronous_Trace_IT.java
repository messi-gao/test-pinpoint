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

import com.navercorp.plugin.sample.target.TargetClass12_AsyncInitiator;
import com.navercorp.plugin.sample.target.TargetClass12_Future;
import com.navercorp.plugin.sample.target.TargetClass12_Worker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 *  
 * 
 * @see Sample_12_Asynchronous_Trace_IT
 * @author Jongho Moon
 */
@RestController
public class Sample_12_Asynchronous_Trace_IT {

    @RequestMapping("/12")
    public void test() throws Exception {
        TargetClass12_AsyncInitiator initiator = new TargetClass12_AsyncInitiator();
        TargetClass12_Future future = initiator.asyncHello("Pinpoint");
        String result = future.get();
        

        
        
        Method hello = TargetClass12_AsyncInitiator.class.getMethod("asyncHello", String.class);
        Method run = TargetClass12_Worker.class.getMethod("run");
        Method get = TargetClass12_Future.class.getMethod("get");

    }
}
