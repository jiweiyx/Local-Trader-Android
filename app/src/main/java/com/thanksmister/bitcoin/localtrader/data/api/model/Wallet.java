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
package com.thanksmister.bitcoin.localtrader.data.api.model;

import android.graphics.Bitmap;

import com.thanksmister.bitcoin.localtrader.utils.Calculations;
import com.thanksmister.bitcoin.localtrader.utils.ISO8601;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Wallet
{
    public String id;
    public String message;
    public Bitmap qrImage;
    public List<Transaction> sent_transactions = Collections.emptyList();
    public List<Transaction> receiving_transactions = Collections.emptyList();
   
    public Total total = new Total();
    public Address address = new Address();

    public class Total {
        public String balance;
        public String sendable;
    }
    
    public class Address {
        public String address;
        public String received;
    }

    public List<Transaction> getTransactions()
    {
        ArrayList<Transaction> transactions = new ArrayList<>();
        if(!sent_transactions.isEmpty()) {
            transactions.addAll(sent_transactions);
        }

        if(!receiving_transactions.isEmpty()) {
            transactions.addAll(receiving_transactions);
        }
        
        Collections.sort(transactions, sortByDate);
        
        return  transactions;
    }

    static final Comparator<Transaction> sortByDate = (ord1, ord2) -> {
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = (ISO8601.toCalendar(ord1.created_at).getTime());
            d2 = (ISO8601.toCalendar(ord2.created_at).getTime());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        if(d1 == null || d2 == null)
            return -1;

        return (d1.getTime() > d2.getTime() ? -1 : 1);     //descending
    };
}
