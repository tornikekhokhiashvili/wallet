package com.epam.rd.autotasks.wallet;

import java.util.List;
import java.util.concurrent.Semaphore;

public class WalletImpl implements Wallet {
    final List<Account> accounts;
    final PaymentLog log;
    Semaphore semaphore=new Semaphore(1);

    public WalletImpl(List<Account> accounts, PaymentLog log) {
        this.accounts = accounts;
        this.log = log;
    }

    @Override
    public void pay(String recipient, long amount) throws Exception {
    semaphore.acquire();
    int count=0;
    for (Account account:accounts){
        if (account.balance()<amount){
            count++;
        }
    }
    if (count==accounts.size()){
        semaphore.release();
        throw new ShortageOfMoneyException(recipient,amount);
    }
    for (Account account:accounts){
        if(account.balance()>=amount){
            account.pay(amount);
            log.add(account,recipient,amount);
            break;
        }
    }
    semaphore.release();
    }

}
