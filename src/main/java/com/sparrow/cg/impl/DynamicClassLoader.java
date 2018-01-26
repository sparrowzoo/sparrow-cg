/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sparrow.cg.impl;

import com.sparrow.constant.magic.DIGIT;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author harry
 */
public class DynamicClassLoader extends URLClassLoader {
    public DynamicClassLoader(ClassLoader classLoader) {
        super(new URL[DIGIT.ZERO], classLoader);
    }

    public Class<?> findClassByClassName(String className)
        throws ClassNotFoundException {
        return this.findClass(className);
    }

    public Class<?> loadClass(String fullName, JavaClassFileObject jco) {
        byte[] classData = jco.getBytes();
        return this.defineClass(fullName, classData, DIGIT.ZERO, classData.length);
    }
}
