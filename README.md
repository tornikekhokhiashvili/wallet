# Concurrent Wallet
Create a wallet that allows using multiple accounts and process payments using a suitable account from the available ones. The wallet must be concurrent. 

You can find the interfaces `Account`, `PaymentLog`, and `Wallet`, as well as
`ShortageOfMoneyException` and `WalletFactory`, in the package [com.epam.rd.autotasks.wallet](src/main/java/com/epam/rd/autotasks/wallet).

There is no need to implement the `Account` and `PaymentLog` interfaces.
They are presented just to provide an API to you. However, you may want to implement them during your local testing.
`ShortageOfMoneyException` does not require any changes.

`WalletFactory` provides the only method - `wallet(List<Account> accounts, PaymentLog paymentLog)`,
that creates a new instance of `Wallet` and passes a list of accounts to it as well as the payment log.
You need to return your implementation of `Wallet` here.

The `Wallet` interface has the only method `pay(String recipient, long amount)`, that you need to implement.
This method must find an account whose balance exceeds the requested amount, 
then decrease the amount on the account balance by the specified amount, 
and log this operation by sending information about the recipient and the amount to the payment log. 
If no account can handle the payment, throw `ShortageOfMoneyException` including information about the recipient and the requested amount.
Also, be aware that this method must work correctly in a multi-threaded environment because it will be called from multiple threads simultaneously. 

To complete the task you need to
- implement the `Wallet` interface
- specify your implementation in `WalletFactory`
- ensure that your solution passes the tests
