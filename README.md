# Concurrent Wallet

Create a wallet which allows using multiple accounts and serve payment
on an account which can handle it. Wallet must be concurrent.

You can find interfaces `Account`, `PaymentLog` and `Wallet`, as well as
`ShortageOfMoneyException` and `WalletFactory`.

`Account` and `PaymentLog` interface may not be implemented, because
their implementation does not affect final score. They just provide an API
to you. However, you may want to implement them during your local testing.
`ShortageOfMoneyException` does not require any changes.

`WalletFactory` provides only one method - `wallet(List<Account>,PaymentLog)`,
which creates a new instance of `Wallet` interface and passes the provided
accounts and log to it.
You need to return your implementation of `Wallet` here.

`Wallet` interface has only one method `pay(String, long)`,
which you need to implement.
This method must find an account which balance exceeds requested amount,
decrease accounts balance on this amount and log this operation by sending
the passed recipient and amount to payment log. If no account is found,
then `ShortageOfMoneyException` must be thrown with information about
recipient and requested amount. Any other exception will be considered as
invalid. Also be aware that this method must work
correctly in multi-threaded environment, because it'll be called by multiple
threads simultaneously.

To complete the task you need to
- implement `Wallet` interface
- specify your implementation in `WalletFactory`
- pass tests