import os

path = os.path.abspath(os.getcwd())
venv = False

def createProject(project_name, directory, venv):

    main_path = os.path.join(directory, project_name)
    os.mkdir(main_path)
    with open(f"{main_path}/README.md", "w") as readme:
        readme.write(f'# {project_name}')

    if(venv == True):
        os.system(f'cd {main_path} & py -m venv .venv')
        with open(f"{main_path}/.gitignore.txt", "w") as gitignore:
            gitignore.write(f'.venv')
    else:
        open(f"{main_path}/.gitignore.txt", "w")
    
    app_path = os.path.join(main_path, 'app')
    os.mkdir(app_path)
    open(f"{app_path}/__init__.py", "w")

    tests_path = os.path.join(main_path, 'tests')
    os.mkdir(tests_path)
    open(f"{tests_path}/__init__.py", "w")
    open(f"{tests_path}/test_app.py", "w")

    print("="*30)
    print(f"PROJECT CREATED AT {main_path}")
    if(venv == True):
        print(f"TO ACTIVATE VENV TYPE -> .\.venv\Scripts\Activate.ps1 <- IN TERMINAL")
    print("="*30)

# TERMINAL INTERFACE
print("="*30)
print(f"CURRENTLY WORKING ON | {path} | WANT TO CHANGE THE PATH? Y/N")
option = input("> ")

if(option.lower() == "y"):
    print("="*30)
    print("INSERT THE PATH YOU WANT TO SAVE YOUR PROJECT")
    path = input("> ")

print("="*30)
print("PROJECT NAME (LEAVE IT EMPTY FOR DEFAULT = project)")
project_name = input("> ")

print("="*30)
print(f"CREATE VIRTUAL ENVIRONMENT -> .VENV? Y/N")
option = input("> ")

if(option.lower() == "y"):
    venv = True

if(project_name == ''):
    project_name = "project"

createProject(project_name, path, venv)