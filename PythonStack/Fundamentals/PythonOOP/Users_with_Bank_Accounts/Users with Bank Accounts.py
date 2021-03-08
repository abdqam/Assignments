class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)

    def make_deposite(self, amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        print(f"User:{self.name}, Balance: ${self.account.display_account_info()}")


    def transfer_money(self, other_user, amount):
        self.account.withdraw(amount)
        other_user.account.deposit(amount)
        print(f"${amount} transfered from {self.name} to {other_user.name}")
        return self

class BankAccount:
    def __init__(self, int_rate, balance):
        self.balance = balance
        self.int_rate = int_rate

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if self.balance <= 0:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
            return self
        else:
            self.balance -= amount
        return self

    def display_account_info(self):
        print(f"Balance: ${self.balance}")
        return self.balance

    def yield_interest(self):
        self.balance += self.balance*self.int_rate
        return self


user1 = User("jhon","jhon@email.com")
user2 = User("micheal","micheal@email.com")
user3 = User("kara","kara@email.com")

user1.make_deposite(500).make_deposite(200).make_deposite(400).make_withdrawal(300).display_user_balance()
user2.make_deposite(300).make_deposite(400).make_withdrawal(250).display_user_balance()
user3.make_deposite(250).make_withdrawal(300).make_withdrawal(100).make_withdrawal(50).display_user_balance()
user1.transfer_money(user3,250).display_user_balance()
user3.display_user_balance()

account1=BankAccount(0.01,1000)
account2=BankAccount(0.03,100)
account1.deposit(300).deposit(300).deposit(300).withdraw(450).yield_interest().display_account_info()
account2.deposit(300).deposit(300).withdraw(250).withdraw(250).withdraw(250).withdraw(250).yield_interest().display_account_info()