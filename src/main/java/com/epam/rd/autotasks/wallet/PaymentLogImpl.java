package com.epam.rd.autotasks.wallet;

import java.util.ArrayList;
import java.util.List;

public class PaymentLogImpl implements PaymentLog{
    List<String> log=new ArrayList<>();
    @Override
    public void add(Account account, String recipient, long amount) {
        log.add("Account"+account+"recipient"+recipient+"amount"+amount);
    }
}
