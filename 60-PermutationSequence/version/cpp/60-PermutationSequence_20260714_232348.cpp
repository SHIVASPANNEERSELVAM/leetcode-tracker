// Last updated: 7/14/2026, 11:23:48 PM
1class Solution {
2public:
3    // Our recursive function that will complete the ans string.
4	// v - is our current array = [1,2,3,4]
5	// ans is the answer string, n and k are current values of n and k
6	// factVal is an array containing the factorial of all integers from 0-9 to get factorial in O(1) time.
7	// That means I have stored all the factorials in this array before hand to avoid calculation. You can also write factorial funciton if you want.
8	
9    void setPerm(vector<int>& v,string& ans,int n,int k,vector<int>& factVal){
10       // if there is only one element left append it to our ans (Base case)
11	   if(n==1){
12            ans+=to_string(v.back());
13            return;
14        }
15		
16		// We are calculating the required index.  factVal[n-1] means for n =  4 => factVal[3] = 6.
17        // 15 / 6 = 2 will the index for k =15 and n = 4.
18		int index = (k/factVal[n-1]);
19        // if k is a multiple of elements of partition then decrement the index (Corner case I was talking about)
20		if(k % factVal[n-1] == 0){
21            index--;
22        }
23		
24		ans+= to_string(v[index]);  // add value to string
25        v.erase(v.begin() + index);  // remove element from array
26        k -= factVal[n-1] * index;   // adjust value of k; k = 15 - 6*2 = 3.
27		// Recursive call with n=n-1 as one element is added we need remaing.
28        setPerm(v,ans,n-1,k,factVal);
29    }
30    
31    string getPermutation(int n, int k) {
32        if(n==1) return "1";
33		//Factorials of 0-9 stored in the array. factVal[3] = 6. (3! = 6)
34        vector<int>factVal = {1,1,2,6,24,120,720,5040,40320,362880};
35        string ans = "";
36        vector<int> v;
37		// Fill the array with all elements
38        for(int i=1;i<=n;i++) v.emplace_back(i);
39        setPerm(v,ans,n,k,factVal);
40        return ans;
41    }
42};