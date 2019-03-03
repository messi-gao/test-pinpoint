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

import com.navercorp.plugin.sample.target.TargetClass10_Consumer;
import com.navercorp.plugin.sample.target.TargetClass10_Message;
import com.navercorp.plugin.sample.target.TargetClass10_Producer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * We want to trace {@link TargetClass10_Consumer#consume(TargetClass10_Message)} with producer name.
 * But we can not retrieve the producer name in the method.
 * So we intercept {@link TargetClass10_Producer#produce()} to inject producer name into the returning
 * {@link TargetClass10_Message} instance.
 * 
 * @author Jongho Moon
 */
@RestController
public class Sample_10_Adding_Field_IT {

    @RequestMapping("/10")
    public void test() throws Exception {
        String name = "Pinpoint";
        
        TargetClass10_Producer producer = new TargetClass10_Producer(name);
        TargetClass10_Consumer consumer = new TargetClass10_Consumer();
        
        consumer.consume(producer.produce());


    }
}
