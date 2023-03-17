from flask import Flask, render_template, request, redirect, url_for
from user import User

app = Flask(__name__, template_folder="templates")

@app.route("/", methods = ["GET", "POST"])
def register():
    global new_user
    
    if request.method == "POST":
        name = request.form['name']
        email = request.form['email']
        password = request.form['password']

        new_user = User(name, email, password)

        return redirect(url_for("print_user"))
    
    return render_template("register.html")
 
@app.route("/output")
def print_user():
    return render_template("output.html", 
                           username=new_user.username, 
                           email=new_user.email, 
                           password=new_user.password
                           )

app.run()
