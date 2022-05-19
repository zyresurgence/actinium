package com.zy.util.math;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtils.class);

    /**
     * 查找第一个缺失的整数。
     *
     * @param from    有效整数起始值。
     * @param numbers
     * @return
     */
    public static int firstMissingPositive(int from, int[] numbers) {
        // Normalize parameters.

        if (from < 0) {
            String msg = "\"from\" is less than 0.";
            throw new IllegalArgumentException(msg);
        }
        if (numbers.length == 0) {
            LOGGER.warn("\"numbers\" is empty.");
            return from;
        }

        // Find first missing positive.

        int n = numbers.length;
        int max = n - 1 + from;
        for (int i = 0; i < n; ++i) {
            while (numbers[i] >= from && numbers[i] <= max && numbers[numbers[i] - from] != numbers[i]) {
                int temp = numbers[numbers[i] - from];
                numbers[numbers[i] - from] = numbers[i];
                numbers[i] = temp;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (numbers[i] != i + from) {
                return i + from;
            }
        }

        return n + from;
    }
}
