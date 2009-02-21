/*
 * Copyright 2005-2010 the original author or authors.
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
package org.dozer.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.dozer.AbstractDozerTest;
import org.dozer.util.DestBeanCreator;
import org.dozer.vo.TestObject;
import org.dozer.vo.TestObjectPrime;
import org.junit.Test;

/**
 * @author tierney.matt
 */
public class DestBeanCreatorTest extends AbstractDozerTest {

  @Test
  public void testCreatDestBeanNoFactory() throws Exception {
    TestObject bean = (TestObject) DestBeanCreator.create(null, null, TestObject.class, null, null, null, null);

    assertNotNull(bean);
    assertNull(bean.getCreatedByFactoryName());
  }

  @Test
  public void testCreatBeanFromFactory() throws Exception {
    String factoryName = "org.dozer.functional_tests.support.SampleCustomBeanFactory";
    TestObject bean = (TestObject) DestBeanCreator.create(new TestObjectPrime(), TestObjectPrime.class, TestObject.class, null,
        factoryName, null, null);

    assertNotNull(bean);
    assertEquals(factoryName, bean.getCreatedByFactoryName());
  }

}