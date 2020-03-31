def get_cross_candidates(before):
    candidates = []
    l = len(before)
    if l > 3:
        t1 = before[1]+before[0]+before[l-1]+before[1]
        t2 = before[l-1]+before[0]+before[l-2]+before[0]
        if t1 <= t2:
            candidates = [
                    (before[0], before[1]), 
                    (before[0],), 
                    (before[l-2], before[l-1]), 
                    (before[1],)]
        else:
            candidates = [
                    (before[0], before[l-2]),
                    (before[0],), 
                    (before[0], before[l-1]),
                    (before[0],)]  
        before.pop()
        before.pop()

    elif l == 3:
        candidates = [
                (before[0], before[1]), 
                (before[0],), 
                (before[0], before[2])]
        before[:] = []
        
    elif l == 2:
        candidates = [(before[0], before[1])]
        before[:] = []
    
    else:
        candidates = [(before[0],)]
        before[:] = []

    return candidates


def cross_strat(people):
    order = []
    # Before bridge
    before = sorted(people)
    seconds = 0
    while len(before):
        candidates = get_cross_candidates(before)
        for c in candidates:
            seconds += max(c)
            order.append(c)
    return seconds, order

if __name__ == '__main__':
    tc = int(input())
    for i in range(tc):
        input()
        # people = load_case()
        n = int(input())
        people = []
        for p in range(n):
            pl = int(input())
            people.append(pl)

        seconds, order = cross_strat(people)
        print(seconds)
        for p in order:
            print(" ".join(map(str, p)))
        if(i < tc - 1): 
            print('')