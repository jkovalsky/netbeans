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

package org.netbeans.modules.maven.configurations;

import javax.swing.JComponent;
import org.netbeans.modules.maven.NbMavenProjectImpl;
import org.netbeans.modules.maven.api.customizer.ModelHandle2;
import static org.netbeans.modules.maven.configurations.Bundle.*;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author mkleint
 */
@ProjectCustomizer.CompositeCategoryProvider.Registration(projectType="org-netbeans-modules-maven", position=212)
public class ConfigurationsPanelProvider implements ProjectCustomizer.CompositeCategoryProvider {

    @Override
    @Messages("TIT_Configurations=Configurations")
    public ProjectCustomizer.Category createCategory(Lookup context) {
        return ProjectCustomizer.Category.create(
                ModelHandle2.PANEL_CONFIGURATION, 
                TIT_Configurations(), 
                null);
    }
    
    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        ModelHandle2 handle = context.lookup(ModelHandle2.class);
        NbMavenProjectImpl project = context.lookup(NbMavenProjectImpl.class);
        return new ConfigurationsPanel(handle, project);
    }

}
