class BankAccount:
    def __init__(self, int_rate, balance):
        self.balance = 0.0
        self.int_rate = 0.01

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if self.balance <= 0:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        else:
            self.balance -= amount
        return self

    def display_account_info(self):
        print(f"Balance: ${self.balance}")

    def yield_interest(self):
        self.balance += self.balance*self.int_rate
        return self

account1=BankAccount(0.01,1000)
account2=BankAccount(0.03,100)
account1.deposit(300).deposit(300).deposit(300).withdraw(450).yield_interest().display_account_info()
account2.deposit(300).deposit(300).withdraw(250).withdraw(250).withdraw(250).withdraw(250).yield_interest().display_account_info()