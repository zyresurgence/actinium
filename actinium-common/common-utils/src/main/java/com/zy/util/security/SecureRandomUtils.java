package com.zy.util.security;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Neo
 */
public class SecureRandomUtils {
    private static final SecureRandom secureRandom = new SecureRandom();

    private static final int BOUND = 2147483647;

    public SecureRandomUtils() {
    }

    public static String base64UniqueSecureRandom(int secureRandomSize) {
        byte[] bytes = uniqueSecureRandom(secureRandomSize);
        return Base64.encodeBase64URLSafeString(bytes);
    }

    public static void nextBytes(byte[] bytes) {
        secureRandom.nextBytes(bytes);
    }

    public static int nextInt() {
        return secureRandom.nextInt();
    }

    public static int nextInt(int start, int end) {
        String msg;
        if (end < start) {
            msg = "Start value must be smaller or equal to end value.";
            throw new IllegalArgumentException(msg);
        } else if (start < 0) {
            msg = "Both range values must be non-negative.";
            throw new IllegalArgumentException(msg);
        } else {
            return start == end ? start : start + secureRandom.nextInt(end - start);
        }
    }

    public static byte[] secureRandom(int size) {
        byte[] bytes = new byte[size];
        secureRandom.nextBytes(bytes);
        return bytes;
    }

    public static int secureRandomInt() {
        return secureRandom.nextInt();
    }

    public static long secureRandomLong() {
        return secureRandom.nextLong();
    }

    public static int secureRandomPositiveInt() {
        int value;
        for(value = 0; value == 0; value = secureRandom.nextInt(BOUND)) {
        }

        return value;
    }

    public static byte[] uniqueSecureRandom(int secureRandomSize) {
        if (secureRandomSize < 4) {
            secureRandomSize = 4;
        }

        UUID uuid = UUID.randomUUID();
        byte[] random = secureRandom(secureRandomSize);
        int bufferSize = 16 + secureRandomSize;
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[bufferSize]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.put(random);
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }
}
