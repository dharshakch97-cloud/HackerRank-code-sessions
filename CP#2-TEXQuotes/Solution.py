c = 0
while True:
    n = input()
    a = []
    for i in n:
        if i == "\"":
            if c == 0:
                a.append("``")
                c = 1
            else:
                a.append("''")
                c = 0
        else:
            a.append(i)
    print("".join(a))