Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
  Solution:
class KthLargest {
  private PriorityQueue<Integer> heap = new PriorityQueue<>();
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (var n : nums) add(n);
  }
  
  public int add(int val) {
    heap.offer(val);
    if (heap.size() > k) heap.poll();
    return heap.peek();
  }
}
