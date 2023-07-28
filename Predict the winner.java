You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.
  Solution:
class Solution {
   public int findsum(int i , int j , int nums[]){
    
    if(i > j){
        return 0;
    }
    if(i == j){
        return nums[i];
    }
    
    int take = nums[i] + Math.min(findsum(i+2 ,j , nums ) , findsum(i+1 , j-1 , nums));
    
     int nottake = nums[j] + Math.min(findsum(i ,j -2, nums ) , findsum(i+1 , j-1 , nums));
    
    
   return Math.max(take , nottake); 
    
}




public boolean PredictTheWinner(int[] nums) {
    
    
    int totalscore = 0;
    
    for(int i : nums){
        totalscore = totalscore+i;
    }
    
    
   int firstPlayerSum = findsum(0 , nums.length-1 , nums); 
    
    int secondPlayerSum = totalscore-firstPlayerSum;
    
    
    
    return firstPlayerSum >= secondPlayerSum;
    
    
}
}
