package org.example.arr;

public class Tmp {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        // 左闭右闭
        while (right >= left) {
            middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return left;
    }

    public static int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;

        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] newArr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                newArr[i] = nums[right] * nums[right];
                right--;
            } else {
                newArr[i] = nums[left] * nums[left];
                left++;
            }
        }
        return newArr;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                min = Math.min((right - left + 1), min);
                sum = sum - nums[left];
                if (left == right) {
                    break;
                }
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int index = 1;
        int left = 0;
        int top = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = left; j < n - i - 1; j++) {
                arr[i][j] = index++;
            }
            for (int j = top; j < n - i - 1; j++) {
                arr[j][n - i - 1] = index++;
            }
            for (int j = n - 1 - i; j > i; j--) {
                arr[n - i - 1][j] = index++;
            }
            for (int j = n - 1 - i; j > top; j--) {
                arr[j][i] = index++;
            }
            left++;
            top++;
        }
        if (n % 2 == 1) {
            arr[n / 2][n / 2] = index;
        }

        return arr;
    }


    public static void main(String[] args) {

        //        int[] nums = {1, 3, 5, 6};
        //        System.out.println(searchInsert(nums, 4));

        //        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        //        System.out.println(removeElement(nums, 2));
        //        Arrays.stream(nums).asLongStream().forEach(System.out::println);

        //        int[] nums = {-5,-3,-2,-1};
        //        Arrays.stream(sortedSquares(nums)).asLongStream().forEach(System.out::println);

        //
        // int[] nums = {2, 3, 1, 2, 4, 3};
        // System.out.println(minSubArrayLen(7, nums));

        int n = 4;
        int[][] arr = generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
