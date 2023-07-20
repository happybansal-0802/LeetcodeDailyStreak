We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
  Solution:
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length<=1)
        return asteroids;
        Stack<Integer> stack=new Stack<>();
        for(int asteroid:asteroids){
            if(asteroid >0){
                stack.push(asteroid);
            }
            else{
                while(!stack.isEmpty() && stack.peek()>0&&Math.abs(stack.peek())<Math.abs(asteroid))
                stack.pop();
                if(stack.isEmpty()||stack.peek()<0)
                stack.push(asteroid);
                else if(stack.peek()==Math.abs(asteroid))
                stack.pop();
            }
        }
        int[] output=new int[stack.size()];
        for(int i=output.length-1; i>=0; i--)
        output[i]=stack.pop();
        return output;

    }
}
