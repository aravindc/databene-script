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

import org.databene.script.Expression;

/**
 * Abstract {@link Expression} that serves as parent class for expressions that evaluate a single term.<br/>
 * <br/>
 * Created at 06.10.2009 14:26:04
 * @since 0.5.0
 * @author Volker Bergmann
 */

public abstract class UnaryExpression<E> implements WrapperExpression<E> {

	protected String symbol;
	protected Expression<?> term;

	public UnaryExpression(String symbol, Expression<?> term) {
		this.symbol = symbol;
	    this.term = term;
    }
	
	@Override
	public boolean isConstant() {
	    return term.isConstant();
	}
	
	@Override
	public Expression<?>[] getSourceExpressions() {
		return new Expression[] { term };
	}
	
	@Override
	public String toString() {
		return symbol + "(" + term + ")";
	}
	
}
