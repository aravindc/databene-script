/*
 * Copyright (C) 2011-2014 Volker Bergmann (volker.bergmann@bergmann-it.de).
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.databene.script.expression;

import static org.junit.Assert.*;

import org.databene.script.DefaultScriptContext;
import org.databene.script.Expression;
import org.databene.script.QNInvocationExpression;
import org.databene.script.ScriptContext;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the {@link QNInvocationExpression}.<br/><br/>
 * Created: 18.05.2011 16:50:14
 * @since 0.6.6
 * @author Volker Bergmann
 */
public class QNInvocationExpressionTest {

	private ScriptContext context;
	
	@Before
	public void setup() {
		context = new DefaultScriptContext();
	}

	@Test
	public void testClass() {
		check("Hello Alice", "org.databene.script.ScriptTestUtil.sayHello", "Alice");
	}

	@Test
	public void testImportedClass() {
		context.importClass("org.databene.script.*");
		check("Hello Alice", "ScriptTestUtil.sayHello", "Alice");
	}

	private void check(Object expected, String qn, String arg) {
		QNInvocationExpression ex = new QNInvocationExpression(
				qn.split("\\."), new Expression<?>[] { ExpressionUtil.constant(arg) });
		Object actual = ex.evaluate(context);
		assertEquals(expected, actual);
	}

}
