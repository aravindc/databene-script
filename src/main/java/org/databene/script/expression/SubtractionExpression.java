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

import org.databene.commons.Context;
import org.databene.script.Expression;
import org.databene.script.math.ArithmeticEngine;

/**
 * Numerical {@link Expression} that performs a subtraction.<br/><br/>
 * Created: 24.11.2010 14:04:08
 * @since 0.5.8
 * @author Volker Bergmann
 */
public class SubtractionExpression extends CompositeExpression<Object, Object> {
	
	@SuppressWarnings("unchecked")
	public SubtractionExpression() {
		super("-");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SubtractionExpression(String symbol, Expression... terms) {
		super(symbol, terms);
	}

	@Override
	public Object evaluate(Context context) {
		Object result = terms[0].evaluate(context);
		for (int i = 1; i < terms.length; i++)
			result = ArithmeticEngine.defaultInstance().subtract(result, terms[i].evaluate(context));
		return result;
	}
	
}
