/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.tomcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.tomcat.domain.Name;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Component
public class HelloWorldService {


    @Autowired
    private NameRepository nameRepository;

    public void insertMessage(){
	Name name = new Name();
	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String s = formatter.format(new Date());
	name.setValue(s);
	nameRepository.save(name);
    }
   
    public String getHelloMessage() {
        Iterator<Name> names = nameRepository.findAll().iterator();
        StringBuilder nameString = new StringBuilder();
        while(names.hasNext()){
        	nameString.append("Hello what time is it? It's " + names.next().getValue() + "<br>");
        }
        return nameString.toString();
    }

}
