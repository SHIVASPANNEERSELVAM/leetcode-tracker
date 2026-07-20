# Last updated: 7/20/2026, 4:25:29 PM
1class Solution(object):
2    def countPrimes(self, n):
3        if n < 2:
4            return 0
5
6        sieve = [True] * n
7        sieve[0] = sieve[1] = False
8
9        i = 2
10        while i * i < n:
11            if sieve[i]:
12                for j in range(i * i, n, i):
13                    sieve[j] = False
14            i += 1
15
16        return sum(sieve)