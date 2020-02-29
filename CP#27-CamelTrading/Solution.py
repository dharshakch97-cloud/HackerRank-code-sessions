tc = int(input())
for i in range(tc) :
    exp = input()
    minimum = eval(exp);
    maximum = 1
    exp_split = exp.split("*")
    for j in exp_split :
        temp = eval(j)
        maximum = maximum * temp
    print("The maximum and minimum are", maximum , "and" , str(minimum) + ".") 
    