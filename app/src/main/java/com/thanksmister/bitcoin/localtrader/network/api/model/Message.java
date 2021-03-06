/*
 * Copyright (c) 2018 ThanksMister LLC
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
 *
 */
package com.thanksmister.bitcoin.localtrader.network.api.model;

public class Message {
    public String id;
    public String msg;
    public String contact_id;
    public String created_at;
    public Boolean is_admin;
    public String attachment_name;
    public String attachment_type;
    public String attachment_url;
    public Sender sender = new Sender();
    public boolean seen = false;

    public class Sender {
        public String id;
        public String name;
        public String username;
        public String trade_count;
        public String last_seen_on;
    }
}
