/**
 * Copyright 2014 https://github.com/lioolli/pinpoint-plugin-samplehttps://github.com/lioolli/pinpoint-plugin-sampleNAVER Corp.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.navercorp.pinpoint.plugin.sample;

import com.navercorp.plugin.sample.target.TargetClass03;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Both {@link TargetClass03#invoke()} and {@link TargetClass03#invoke(int)} have interceptors injected and are traced.
 * <p>
 * But these interceptors share the same interceptor scope and their execution policies are set to BOUNDARY telling them
 * to <em>execute only when no other interceptor in the same scope is active</em>.
 * <p>
 * So in {@link #testA()}, only {@link TargetClass03#invoke()} is recorded and in {@link #testB()}, only
 * {@link TargetClass03#invoke(int)} is recorded.
 *
 * @author Jongho Moon
 */
@RestController
public class Sample_03_Use_Interceptor_Group_To_Prevent_Duplicated_Trace_IT {

    @RequestMapping("/3A")
    public void testA() throws Exception {
        TargetClass03 target = new TargetClass03();
        target.invoke();

    }

    @RequestMapping("/3B")
    public void testB() throws Exception {
        TargetClass03 target = new TargetClass03();
        target.invoke(3);

    }
}
