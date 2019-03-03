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

import com.navercorp.plugin.sample.target.TargetClass04;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  We want to trace {@link TargetClass04#outerMethod(String)} when it's argument starts with "FOO".
 *  In addition, we want to record the return value of {@link TargetClass04#innerMethod(String)}, which is
 *  invoked by <tt>outerMethod()</tt> but don't want to record the invocation of <tt>innerMethod()</tt>.
 *  <p>
 *  We can do this by sharing data between the two interceptors through {@link InterceptorScopeInvocation}. When an
 *  <tt>InterceptorScopeInvocation</tt> is active, interceptors can attach objects to it and share them with other
 *  interceptors within the same scope.<br/>
 *  <tt>InterceptorScopeInvocation</tt> is activated for a scope when the <tt>before()</tt> method of any interceptors
 *  in the scope is invoked, but before the <tt>after()</tt> method is invoked.
 *  
 */
@RestController
public class Sample_04_Interceptors_In_A_Group_Share_Value_IT {

    @RequestMapping("/4")
    public void testTrace() throws Exception {
        String name = "FOOBAR";
        int length = name.length();

        TargetClass04 target = new TargetClass04();
        target.outerMethod(name);
        
    }
}
