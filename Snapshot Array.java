Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id.
  Solution:
class SnapshotArray {
    TreeMap<Integer, Integer>[] Tm;
    int snap_id = 0;
    public SnapshotArray(int length) {
        Tm = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            Tm[i] = new TreeMap<Integer, Integer>();
            Tm[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        Tm[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return Tm[index].floorEntry(snap_id).getValue();
    }
}
