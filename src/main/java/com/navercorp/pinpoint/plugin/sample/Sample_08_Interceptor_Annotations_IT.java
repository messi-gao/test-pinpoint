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

import com.navercorp.plugin.sample.target.TargetClass08;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author Jongho Moon
 */
@RestController
public class Sample_08_Interceptor_Annotations_IT {

    @RequestMapping("/8")
    public void test() throws Exception {
        TargetClass08 target = new TargetClass08();
        
        target.targetMethod("NAVER");
        target.targetMethod();
        
        Method targetMethod0 = TargetClass08.class.getDeclaredMethod("targetMethod");
        Method targetMethod1 = TargetClass08.class.getDeclaredMethod("targetMethod", String.class);
        
    }
}
