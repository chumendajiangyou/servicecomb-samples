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

package org.apache.servicecomb.samples.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(path = "/consumer/")
public interface ConsumerService {
  @GetMapping("/sayHello")
  String sayHello(@RequestParam("name") String name);

  @GetMapping("/exampleConfig")
  String exampleConfig();

  @RequestMapping(value = "/saveFile",method = RequestMethod.POST,
          consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  String saveFile(@RequestAttribute("fileType") int fileType,
                  @RequestPart("file") MultipartFile file);

  @RequestMapping(value = "/saveFileR",method = RequestMethod.POST,
          consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  String saveFileR(@RequestAttribute("fileType") int fileType,
                   @RequestPart("file") MultipartFile file);
}
