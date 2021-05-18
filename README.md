# Concurrent Wallet

Create a wallet which allows using multiple accounts and serve payment
on an account which can handle it. Wallet must be concurrent.

You can find interfaces `Account`, `PaymentLog` and `Wallet`, as well as
`ShortageOfMoneyException` and `WalletFactory` in [com.epam.rd.autotasks.wallet](src/main/java/com/epam/rd/autotasks/wallet) package.

There is no need to implement `Account` and `PaymentLog` interfaces.
They are presented to just provide an API to you. However, you may want to implement them during your local testing.
`ShortageOfMoneyException` does not require any changes.

`WalletFactory` provides the only method - `wallet(List<Account>,PaymentLog)`,
which creates a new instance of `Wallet` and passes the provided accounts and log to it.
You need to return your implementation of `Wallet` here.

`Wallet` interface has the only method `pay(String, long)`,
which you need to implement.
This method must find an account which balance exceeds requested amount,
decrease accounts balance on this amount and log this operation by sending
the passed recipient and amount to payment log. If no account can handle a payment, throw
a `ShortageOfMoneyException` including information about recipient and requested amount.
Also be aware that this method must work correctly in multi-threaded environment, because it'll be called from multiple threads simultaneously.

To complete the task you need to
- implement `Wallet` interface
- specify your implementation in `WalletFactory`
- ensure, that your oultion passes tests
