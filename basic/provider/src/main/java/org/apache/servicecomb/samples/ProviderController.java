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

package org.apache.servicecomb.samples;

import org.apache.servicecomb.config.DynamicProperties;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.samples.api.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@RestSchema(schemaId = "ProviderController", schemaInterface = ProviderService.class)
public class ProviderController implements ProviderService {
  private DynamicProperties dynamicProperties;

  private String example;

  @Autowired
  public ProviderController(DynamicProperties dynamicProperties) {
    this.dynamicProperties = dynamicProperties;
    this.example = this.dynamicProperties.getStringProperty("basic.example",
        value -> this.example = value, "not set");
  }

  @Override
  public String sayHello(String name) {
    return "Hello " + name;
  }

  @Override
  public String exampleConfig() {
    return example;
  }

  @Override
  public String saveFile(int fileType, MultipartFile file) {
    return fileType + file.getOriginalFilename();
  }
}
