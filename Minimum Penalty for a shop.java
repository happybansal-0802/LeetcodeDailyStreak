You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':

if the ith character is 'Y', it means that customers come at the ith hour
whereas 'N' indicates that no customers come at the ith hour.
If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:

For every hour when the shop is open and no customers come, the penalty increases by 1.
For every hour when the shop is closed and customers come, the penalty increases by 1.
Return the earliest hour at which the shop must be closed to incur a minimum penalty.

Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
  Solution:
  public class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int Y = 0;

        for (int i = 0; i < n; i++) {
            Y += (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int min_p = n;
        int hour = n;
        int y_found = 0;
        int n_found = 0;

        for (int h = 0; h <= n; h++) {
            int y_remaining = Y - y_found;
            int pen = y_remaining + n_found;

            if (pen < min_p) {
                hour = h;
                min_p = pen;
            }

            if (h < n && customers.charAt(h) == 'N') {
                n_found++;
            }

            if (h < n && customers.charAt(h) == 'Y') {
                y_found++;
            }
        }

        return hour;
    }
}
