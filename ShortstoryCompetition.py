from math import ceil
while True :
    try :
        n, l, c = map(int, input().split())
        line = input()
        max_charcount = 0
        lines = 1
        for i in line.split() :
            if (len(i) + max_charcount <= c) :
                max_charcount += len(i) + 1
            else :
                max_charcount = 0
                max_charcount += len(i) + 1
                lines += 1
        pages = ceil(lines/l)
        print(pages)
    except EOFError :
        break