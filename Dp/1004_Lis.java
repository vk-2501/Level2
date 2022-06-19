public class 1004_Lis{
    //MEMO
    public int lengthOfLIS(int[] nums,int i,int[] dp){
        if(dp[i]!=0)
        return dp[i];


        int longestlen=0;
        for(int j=i-1;j>=0;j--){
            if(nusm[j]<nums[i]){
                int len=lengthOfLIS(nums,j,dp);
                longestlen=Math.max(longestlen,len);
            }
        }
        return dp[i]=longestlen+1;
    }

    public int lengthOfLIS_tabu_LR(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        int len=0;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            len=Math.max(len,dp[i]);
        }
       return len;
    }


    public int lengthOfLIS(int[] nums){
        int len=0;
        int [] dp=int[nums.length];
        for(int i=0;i<nums.length;i++){
            len=Math.max(len,lengthOfLIS(nums,i,dp));

        }
        return len;
    }

    //minimum no of deletions to make the array sorted
    public int minDeletions(int[] nums){
        int n=nums.length;
        int len=0;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            len=Math.max(len,dp[i]);
        }
        return n-len;
    }

    // https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1/
    public int maxSum_tabu(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            dp[i]=nums[i];
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+nums[i]);
                }
            }
            sum=Math.max(sum,dp[i]);
        }
       return sum;
    }


    //Longest Bitonic Subsequence--UPHILL
    public static int[] LIS_LR(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];

        int len=0;
        for(int i=0;i<n;i++){
            dp[i]=arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            len=Math.max(len,dp[i]);
        }
        return dp;
    }

    public static int[] LIS_RL(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];

        int len=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            len=Math.max(len,dp[i]);
        }
        return dp;
    }

    public static int bitonicSeq_downHill(int[] arr){
        int len=0;
        int[] LIS=LIS_LR(arr);
        int[] LDS=LIS_RL(arr);
        for(int i=0;i<arr.length;i++){
            len=Math.max(len,LIS[i]+LDS[i]-1);
        }
        return len;
    }

    //Longest Bitonic Subsequence--DOWNHILL
    public static int[] LDS_LR(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];

        int len=0;
        for(int i=0;i<n;i++){
            dp[i]=arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            len=Math.max(len,dp[i]);
        }
        return dp;
    }

    public static int[] LDS_RL(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];

        int len=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            len=Math.max(len,dp[i]);
        }
        return dp;
    }

    public static int bitonicSeq_upHill(int[] arr){
        int len=0;
        int[] LDS1=LDS_LR(arr);
        int[] LDS2=LDS_RL(arr);
        for(int i=0;i<arr.length;i++){
            len=Math.max(len,LDS1[i]+LDS2[i]-1);
        }
        return len;
    }


    // Number of Longest Increasing Subsequence
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        
        int maxLen=0;
        int maxCount=0;
        
        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
            for(int j=i-1;j>=0;j--){
            if(nums[i]>nums[j]){
                if(dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                }
                else if(dp[j]+1==dp[i]){
                    count[i]+=count[j];
                }
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
                maxCount=count[i];
            }
            else if(dp[i]==maxLen){
                maxCount+=count[i];
            }
        }
        return maxCount;
    }
    


    // https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
    public static int bridgeBuildin(int[][] nums){

        Arrays.sort(nums,(a,b)->{
            return a[0]-b[0];//this-other gives default behaviour
            //other-this gives reverse default behaviour
        });

        int n=nums.length;
        int[] dp=new int[n];
        int len=0;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j][0]<nums[i][0] && nums[j][1]<nums[i][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            len=Math.max(len,dp[i]);
        }
        return len;
      }


}   