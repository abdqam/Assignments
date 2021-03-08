from flask import Flask,  render_template
app = Flask(__name__)


@app.route('/')
def welcome():
    return  "Welcome to Playgoround!!"
@app.route('/play')
def playground():
    return  render_template('Playground.html',num=3,color='aqua')

@app.route('/play/<int:number>')
def playground_num(number):
    return  render_template('Playground.html',num=number,color='aqua')

@app.route('/play/<int:number>/<col>')
def playground_num_col(number,col):
    return  render_template('Playground.html',num=number,color=col)
if __name__ == "__main__":
    app.run(debug=True)
