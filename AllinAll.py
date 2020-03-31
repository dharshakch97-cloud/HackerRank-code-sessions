while True :
    try :
        line = input().split(" ")
        str1 = line[0]
        str2 = line[1]
        i = 0
        for j in range(len(str2)) :
            if i == len(str1) :
                break
            if str1[i] == str2[j]:
                i += 1
        if i == len(str1) :
            print("Yes")
        else :
            print("No")
    except EOFError :
        break