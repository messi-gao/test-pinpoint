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

import com.navercorp.plugin.sample.target.TargetClass09;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * We want to record the value of <tt>hiddenField</tt> field in {@link TargetClass09}. So we have added a getter for
 * it during class transformation.
 *
 * @author Jongho Moon
 */
@RestController
public class Sample_09_Adding_Getter_IT {

    @RequestMapping("/9")
    public void test() throws Exception {
        String name = "Pinpoint";

        TargetClass09 target = new TargetClass09(name);
        target.targetMethod();
        
    }
}
