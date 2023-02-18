import hashlib

text = input('Type in the text to generate the hash: ')

choice = input("""
        [1] MD5
        [2] SHA1
        [3] SHA256
        [4] SHA512
""")

if choice == "1":
    result = hashlib.md5(text.encode('utf-8'))
    hashType = 'MD5'
elif choice == "2": 
    result = hashlib.sha1(text.encode('utf-8'))
    hashType = 'SHA1'
elif choice == "3": 
    result = hashlib.sha256(text.encode('utf-8'))
    hashType = 'SHA256'
elif choice == "4":
    result = hashlib.sha512(text.encode('utf-8'))
    hashType = 'SHA512'
else:
    print('Something went wrong... Try again!')
    exit()

print(f"The hash {hashType} of the string is: {result.hexdigest()}")
