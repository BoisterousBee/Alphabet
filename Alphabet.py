# Alphabet.py - Etude 11 - Oliver O'Connor - 6529968
import sys
import string
words = []
allowed = set(string.ascii_lowercase + string.ascii_uppercase + "'")
with open(sys.argv[1]) as filename:
        for line in filename:
            for word in line.split():
               words.append(word)
tempwords = []
for x in words:
    if x.startswith('"'):
        x = x[1 : : ]
    if x[-1] == '"' or x[-1] == '.' or x[-1] == ',' or x[-1] == ';' or x[-1] == ':' or x[-1] == '?' or x[-1] == '!':
        x = x[:-1:]
    tempwords.append(x)
words = tempwords
tempwords = []
for x in words:
    if set(x) <= allowed:
        tempwords.append(x)
    words = tempwords
words = tempwords
tempwords = []
for x in words:
    count = 0
    for i in x:
        if i == "'":
            count = count + 1
    if count == 0:
        tempwords.append(x)
    elif count == 1:
        if x[0] != "'":
            tempwords.append(x)
words = tempwords
tempwords = []
for x in words:
    count = 0
    for i in x:
        if i.isupper():
            count = count + 1
    if count == 0:
        tempwords.append(x)
    elif count == 1:
        if x[0].isupper():
            tempwords.append(x)
words = tempwords
tempwords = []
for x in words:
    tempwords.append(x.lower())
words = tempwords
finalWords = list(dict.fromkeys(words))
finalWords.sort()
tempwords = []
for x in finalWords:
    if x != "":
        tempwords.append(x)
finalWords = tempwords
for x in finalWords:
    print(x)