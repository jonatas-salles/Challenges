import os
import shutil

print("Digite o caminho que deseja organizar: ")
path = input("> ")
try:
    files = os.listdir(path)

    for file in files:
        name, extension = os.path.splitext(file)
        extension = extension[1:]

        if os.path.exists(path + '/' + extension):
            shutil.move(path + '/' + file, path + '/' + extension + '/' + file)
        
        else:
            os.makedirs(path + '/' + extension)
            print(path + '/' + extension)
            shutil.move(path + '/' + file, path + '/' + extension)

    print("Arquivos organizados com sucesso!")
except:
    print("Erro! Verifique as entradas e tente novamente...")