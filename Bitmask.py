while True :
    try :
        line = input().split(" ")
        N = int(line[0])
        L = int(line[1])
        U = int(line[2])
        # print("Sample: ", N, L, U)
        bitmask = 0;
        i = 31
        while (i >= 0) :
        # for i in range(32) :
            # if ((bitmask + (1<<i)) <= U) :
            #     bitmask += 1<<i
            # elif (N & (1<<i)) :
            #     t = bitmask + (1<<i)
            #     if (t <= L) :
            #         bitmask += 1<<i
            if(N & (1<<i)) :
                tb = bitmask + (1<<i);
                if(tb <= L) :
                    bitmask += 1<<i;
            else :
                tb = bitmask + (1<<i);
                if(tb <= U) :
                    bitmask += 1<<i;
                # print(bitmask)
            i -= 1
        print(bitmask)
    except EOFError :
        break
    