import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void lengthOfLIS(int[] arr) {
        List<List<Integer>> LIS = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            LIS.add(new ArrayList<>());
        }
        LIS.get(0).add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //arr[j] < arr[i] số trước nhỏ hơn số hiện tại
                //LIS.get(j).size() > LIS.get(i).size() mảng  thứ j có kích thước lớn hơn mảng thứ i
                if (arr[j] < arr[i] && LIS.get(j).size() > LIS.get(i).size()) {
                    //
                    LIS.set(i, new ArrayList<>(LIS.get(j)));
                }
            }
            LIS.get(i).add(arr[i]);
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (LIS.get(j).size() < LIS.get(i).size()) {
                j = i;
            }
        }

        System.out.print(LIS.get(j));
    }
    public static void main(String[] args) {
        int[] a = {100, 2, 9,33,21, 50, 41, 9, 80};
        lengthOfLIS(a);
    }
}


