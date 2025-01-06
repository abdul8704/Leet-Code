# def consecutive(self, first, last, k):
#         # real = ((last -n + 1)/2 ) * (n+last)
#         # expected = ((k+1) / 2) * ((2*n)+k)
#         # return real == expected
        
         
#         gap = k - 1
#         expected = ((gap + 1) / 2) * (2*first + gap)
        
     
# x =[2, 3, 4]

# print(consecutive(x[0], x[0+(3-1)], 3))
gap = 2
first = 3
expected = ((gap + 1) / 2) * (2*first + gap)
print(expected)