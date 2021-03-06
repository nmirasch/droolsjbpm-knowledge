/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
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

package org.kie.api.runtime.rule;

import java.io.Externalizable;
import java.io.Serializable;

/**
 * An interface for accumulate external function implementations
 */
public interface AccumulateFunction extends Externalizable {

    /**
     * Creates and returns a new context object
     * @return new context object
     */
    Serializable createContext();

    /**
     * Initializes the accumulator
     * @param context
     * @throws Exception
     */
    void init(Serializable context) throws Exception;

    /**
     * Executes the accumulation action
     * @param context
     * @param value
     */
    void accumulate(Serializable context,
                    Object value);

    /**
     * Reverses the accumulation action
     * @param context
     * @param value
     * @throws Exception
     */
    void reverse(Serializable context,
                 Object value) throws Exception;

    /**
     * @return the current value in this accumulation session
     * @throws Exception
     */
    Object getResult(Serializable context) throws Exception;

    /**
     * @return true if the function supports reverse, otherwise false
     */
    boolean supportsReverse();

    /**
     * @return the class type of the result of this function
     */
    Class<?> getResultType();

}
