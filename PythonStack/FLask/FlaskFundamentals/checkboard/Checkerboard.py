from flask import Flask , render_template
app = Flask(__name__)
@app.route('/')
def defult_value():
    return render_template('Checkerboard.html',rows=int(8),columns=int(8))
@app.route('/<int:number_row>')
def control_rows():
    return render_template('Checkerboard.html',rows=int(4),columns=int(8))
@app.route('/<int:row_number>/<int:column_number>')
def countrol_row_coulom(row_number,column_number):
    return render_template('Checkerboard.html',rows=row_number,columns=column_number)
@app.route('/<int:row_number>/<int:column_number>/<color1>/<color2>')
def countrol_row_coulom_color(row_number,column_number,color1,color2):
    return render_template('Checkerboard.html',rows=row_number,columns=column_number,color1=color1,color2=color2)
if __name__ == '__main__':
    app.run(debug=True)  