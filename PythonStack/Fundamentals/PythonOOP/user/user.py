class user:
    def __init__(self):
        self.name = "user"
        self.email = "user@email.com"
        self.account_balance = 0

    def make_deposite(self, amount):
        self.account_balance += amount

    def make_withdrawal(self, amount):
        self.account_balance -= amount

    def display_user_balance(self):
        print(f"User:{self.name}, Balance: ${self.account_balance}")
    def transfer_money(self, other_user, amount):
        other_user.account_balance+=amount
        self.account_balance-=amount


user1 = user()
user1.name="jhon"
user2 = user()
user2.name="micheal"
user3 = user()
user3.name="kara"

user1.make_deposite(500)
user1.make_deposite(200)
user1.make_deposite(400)
user1.make_withdrawal(300)
user1.display_user_balance()
user2.make_deposite(300)
user2.make_deposite(400)
user2.make_withdrawal(250)
user2.display_user_balance()
user3.make_deposite(250)
user3.make_withdrawal(300)
user3.make_withdrawal(100)
user3.make_withdrawal(50)
user3.display_user_balance()
user1.transfer_money(user3,250)
user1.display_user_balance()
user3.display_user_balance()