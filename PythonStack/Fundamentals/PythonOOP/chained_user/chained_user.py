class user:
    def __init__(self):
        self.name = "user"
        self.email = "user@email.com"
        self.account_balance = 0

    def make_deposite(self, amount):
        self.account_balance += amount
        return self

    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self

    def display_user_balance(self):
        print(f"User:{self.name}, Balance: ${self.account_balance}")
    def transfer_money(self, other_user, amount):
        other_user.account_balance+=amount
        self.account_balance-=amount
        print(f"${amount} transfered from {self.name} to {other_user.name}")
        return self


user1 = user()
user1.name="jhon"
user2 = user()
user2.name="micheal"
user3 = user()
user3.name="kara"

user1.make_deposite(500).make_deposite(200).make_deposite(400).make_withdrawal(300).display_user_balance()
user2.make_deposite(300).make_deposite(400).make_withdrawal(250).display_user_balance()
user3.make_deposite(250).make_withdrawal(300).make_withdrawal(100).make_withdrawal(50).display_user_balance()
user1.transfer_money(user3,250).display_user_balance()
user3.display_user_balance()