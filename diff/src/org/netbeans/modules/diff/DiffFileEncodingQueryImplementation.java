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
package org.netbeans.modules.diff;

import org.netbeans.spi.queries.FileEncodingQueryImplementation;
import org.netbeans.modules.diff.builtin.ContextualPatch;
import org.openide.filesystems.FileObject;

import java.nio.charset.Charset;
import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * FEQ for .patch and .diff files generated by the IDE.
 * 
 * @author Maros Sandor
 */
@org.openide.util.lookup.ServiceProvider(service=org.netbeans.spi.queries.FileEncodingQueryImplementation.class)
public class DiffFileEncodingQueryImplementation extends FileEncodingQueryImplementation {

    public Charset getEncoding(FileObject file) {
        if (!"text/x-diff".equals(file.getMIMEType())) return null;
        return generatedByIDE(file) ? Charset.forName("UTF-8") : null;
    }

    private boolean generatedByIDE(FileObject file) {
        if (file.getSize() <= ContextualPatch.MAGIC.length()) return false;
        byte [] buffer = new byte[ContextualPatch.MAGIC.length()];
        InputStream is = null;
        try {
            is = file.getInputStream();
            int n = is.read(buffer);
            return n > 0 && ContextualPatch.MAGIC.startsWith(new String(buffer, 0, n, "US-ASCII"));
        } catch (IOException e) {
            Logger.getLogger(DiffFileEncodingQueryImplementation.class.getName()).log(Level.INFO, "FEQ failed", e);
        } finally {
            if (is != null) try { is.close(); } catch (IOException e) {}
        }
        return false;
    }
}
