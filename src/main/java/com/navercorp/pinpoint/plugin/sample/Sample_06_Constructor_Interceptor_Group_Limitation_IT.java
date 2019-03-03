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

import com.navercorp.plugin.sample.target.TargetClass06;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;

@RestController
public class Sample_06_Constructor_Interceptor_Group_Limitation_IT {
    
    @RequestMapping("/6")
    public void test() throws Exception {
        // Invoke 0-arg constructor. It calls 1-arg constructor.
        TargetClass06 target = new TargetClass06();
        

        Constructor<?> targetConstructor0 = TargetClass06.class.getConstructor();
        Constructor<?> targetConstructor1 = TargetClass06.class.getConstructor(int.class);

    }
}
