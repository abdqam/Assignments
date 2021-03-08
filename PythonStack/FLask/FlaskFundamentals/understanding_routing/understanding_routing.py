from flask import Flask
app = Flask(__name__)
@app.route('/')
def hello():
    return "Hello World!"
@app.route('/dojo')
def dojo():
    return "Dojo!"
@app.route('/say/<word>')
def word(word):
    return f"Hi {word}"
@app.route('/<int:num>/<word>')
def num_word(num=1,word='word'):
    return f"{word} "*num

if __name__=="__main__":
    app.run(debug=True)