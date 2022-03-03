import time


def rec(n):
    if n<= 1:
        return n
    else:
        return rec(n-1) + rec(n-2);

def iter(n):
    if n<=1 :
        return n;
    else:
        i=2
        t0 = 0
        t1 = 1
        while i<= n:
            t0,t1 = t1, t0+t1
            i += 1
        return t1

while True:
    nbr = int(input("Enter a number: "))
    if nbr == -1:
        break
     ts = time.time()
     fibo = iter(nbr)
     ts = time.time() - ts
     print("Interative version: %d (%.3f)" % (fibo,ts))
     ts = time.time()
     fibo = rec(nbr)
     ts = time.time() - ts
     print("Recursive version% %d (%.3f)" % (fibo,ts))
