You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.

 Solution:
class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        for(int i = 0; i < salary.length; i++){
            minSalary = Math.min(minSalary, salary[i]);
            maxSalary = Math.max(maxSalary, salary[i]);
        }
        double sum =0;
        for(int i =0; i< salary.length; i++){
            if(minSalary !=salary[i] && maxSalary != salary[i]){
                sum +=salary[i];
            }
        }
        return sum / (salary.length - 2);
        
    }
}
