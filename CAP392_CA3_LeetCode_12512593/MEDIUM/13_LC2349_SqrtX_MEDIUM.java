CAP392_CA3_LeetCode
Q2349
import java.util.*;

class NumberContainers {

    HashMap<Integer, Integer> indexToNum;
    HashMap<Integer, TreeSet<Integer>> numToIndices;

    public NumberContainers() {
        indexToNum = new HashMap<>();
        numToIndices = new HashMap<>();
    }

    public void change(int index, int number) {

        if (indexToNum.containsKey(index)) {
            int oldNum = indexToNum.get(index);

            if (numToIndices.containsKey(oldNum)) {
                numToIndices.get(oldNum).remove(index);
            }
        }

        indexToNum.put(index, number);

        numToIndices.putIfAbsent(number, new TreeSet<>());
        numToIndices.get(number).add(index);
    }

    public int find(int number) {

        if (!numToIndices.containsKey(number) ||
            numToIndices.get(number).isEmpty()) {
            return -1;
        }

        return numToIndices.get(number).first();
    }
}


