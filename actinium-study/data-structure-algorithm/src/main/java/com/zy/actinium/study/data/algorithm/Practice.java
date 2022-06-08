package com.zy.actinium.study.data.algorithm;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/10/22 13:48
 */
public class Practice {
    private static final int[] ARR = {-4,-2,18, 2, 9, 4, 6, 7, 8, 3, 10, 12, 13, 15, 5};

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 时间复杂度为 O(n) 并且只使用常数级别额外空间。
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //过滤负数
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        //数组内缺失的数字对应的索引 i 是不会被赋值为负数的，一直都是正数。
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                int abs = Math.abs(nums[num - 1]);
                nums[num - 1] = -abs;
            }
        }

        //第一个正数，返回对应的索引 i+1 即为最小的缺失正整数。
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
