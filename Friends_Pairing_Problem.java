//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class Friends_Pairing_Problem
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends

//User function Template for Java

class Solution
{
    static Map<Integer, Long> memo = new HashMap<>();
    long M = 1000000007;
    public long countFriendsPairings(int n) 
    { 
       // base case 
       if(n==1||n==2){
           return Long.valueOf(n);
       }
       
       if(memo.containsKey(n)){
           return memo.get(n);
       }
       
       //make choices
       long single = countFriendsPairings(n-1);
       long pair = (n-1)*countFriendsPairings(n-2);
       long tot = (single + pair) % M;
       memo.put(n, tot);
       return tot;
    }
}    
 
