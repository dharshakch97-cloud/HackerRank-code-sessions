tc = int(input())
for i in range(tc) :
    n = int(input())
    prices = list(map(int, input().split()))
    # print(prices)
    prices.sort()
    # prices.reverse()
    # print(prices)
    discount = 0
    for i in range(len(prices) - 3, -1, -3) :
        discount += prices[i]
    print(discount)
