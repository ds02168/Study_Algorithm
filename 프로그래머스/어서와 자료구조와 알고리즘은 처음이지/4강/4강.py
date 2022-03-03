def sum(n):
    print(n)
    if n <= 1:
        return n
    else:
        return n + sum(n-1)

a = int(input("number: "))
print(sum(a))
