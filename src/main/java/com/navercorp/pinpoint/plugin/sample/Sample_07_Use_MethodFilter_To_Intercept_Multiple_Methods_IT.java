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

import com.navercorp.plugin.sample.target.TargetClass07;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * Intercept public methods by using {@link MethodFilter}.
 * 
 * @author Jongho Moon
 */
@RestController
public class Sample_07_Use_MethodFilter_To_Intercept_Multiple_Methods_IT {

    @RequestMapping("/7")
    public void test() throws Exception {
        TargetClass07 target = new TargetClass07();
        
        target.recordMe();
        target.recordMe(0);
        target.recordMe("maru");
        
        target.logMe();
        target.logMe("morae");
        
        Method recordMe0 = TargetClass07.class.getDeclaredMethod("recordMe");
        Method recordMe1 = TargetClass07.class.getDeclaredMethod("recordMe", int.class);
        Method recordMe2 = TargetClass07.class.getDeclaredMethod("recordMe", String.class);
    }
}
