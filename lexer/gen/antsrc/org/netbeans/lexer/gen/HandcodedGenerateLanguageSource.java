/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.lexer.gen;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import org.netbeans.modules.lexer.gen.handcoded.HandcodedLanguageGenerator;
import org.xml.sax.SAXException;

/**
 * Generate language source from information contained
 * in xxxConstants class generated by JavaCC and
 * possibly the language description xml file if it's present.
 *
 * @author Miloslav Metelka
 */
public class HandcodedGenerateLanguageSource extends GenerateLanguageSource {
    
    protected String generate(String langClassName, String lexerClassName,
    String tokenTypesClassName, File langDescFile)
    throws SAXException, IOException {
        
        HandcodedLanguageGenerator generator = new HandcodedLanguageGenerator();
        return generator.generate(langClassName, lexerClassName, null, langDescFile);
    }
            
}
