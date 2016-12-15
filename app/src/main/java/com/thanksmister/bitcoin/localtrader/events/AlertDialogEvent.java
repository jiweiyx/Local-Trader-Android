/*
 * Copyright (c) 2015 ThanksMister LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed 
 * under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package com.thanksmister.bitcoin.localtrader.events;

public class AlertDialogEvent 
{
    public final String message;
    public final String title;
    public final boolean cancelable;

    public AlertDialogEvent(final String title, final String message)
    {
        this.title = title;
        this.message = message;
        this.cancelable = true;
    }

    public AlertDialogEvent(final String title, final String message, final boolean cancelable)
    {
        this.title = title;
        this.message = message;
        this.cancelable = cancelable;
    }
}
