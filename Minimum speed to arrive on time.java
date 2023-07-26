You are given a floating-point number hour, representing the amount of time you have to reach the office. To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.

Each train can only depart at an integer hour, so you may need to wait in between each train ride.

For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.

Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
  Solution:
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<dist.length-1) return -1;
        int l = 0;
        int r = 10000000;
        int m;
        int ans = -1;
        while(l<=r){
            m = (l+r)/2;            
            if(check(dist, hour, m)){
                ans = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return ans;
    }

    public boolean check(int [] dist, double hour, double speed){
       
        double time = 0;
        int i = 0;
        while(time<=hour && i<dist.length-1){
            time += Math.ceil(dist[i]/speed);
            i++;
        }
        time +=dist[dist.length-1]/speed;
        return (time<=hour);
    }
}
