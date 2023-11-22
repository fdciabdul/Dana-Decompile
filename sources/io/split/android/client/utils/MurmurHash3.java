package io.split.android.client.utils;

import java.math.BigInteger;

/* loaded from: classes6.dex */
public final class MurmurHash3 {
    private static final long C1 = -8663945395140668459L;
    private static final long C2 = 5545529020109919103L;
    private static final int M = 5;
    private static final int N1 = 1390208809;
    private static final int N2 = 944331445;
    private static final int R1 = 31;
    private static final int R2 = 27;
    private static final int R3 = 33;

    /* loaded from: classes9.dex */
    public static final class LongPair {
        public long val1;
        public long val2;
    }

    public static int fmix32(int i) {
        int i2 = (i ^ (i >>> 16)) * (-2048144789);
        int i3 = (i2 ^ (i2 >>> 13)) * (-1028477387);
        return i3 ^ (i3 >>> 16);
    }

    public static long fmix64(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    public static long getLongLittleEndian(byte[] bArr, int i) {
        return (bArr[i + 7] << 56) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static long murmurhash3_x86_32(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = i;
        int i6 = i3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < i4) {
            int i10 = i5 + 1;
            int charAt = charSequence.charAt(i5);
            int i11 = 24;
            if (charAt < 128) {
                i11 = 8;
            } else if (charAt < 2048) {
                charAt = (charAt >> 6) | 192 | (((charAt & 63) | 128) << 8);
                i11 = 16;
            } else if (charAt < 55296 || charAt > 57343 || i10 >= i4) {
                charAt = ((((charAt >> 6) & 63) | 128) << 8) | (charAt >> 12) | 224 | (((charAt & 63) | 128) << 16);
            } else {
                int charAt2 = ((charAt - 55232) << 10) + (charSequence.charAt(i10) & 1023);
                charAt = (((charAt2 & 63) | 128) << 24) | ((((charAt2 >> 6) & 63) | 128) << 16) | ((((charAt2 >> 12) & 63) | 128) << 8) | (((charAt2 >> 18) | 240) & 255);
                i10++;
                i11 = 32;
            }
            int i12 = (charAt << i8) | i9;
            i8 += i11;
            if (i8 >= 32) {
                int i13 = i12 * (-862048943);
                int i14 = (((i13 << 15) | (i13 >>> 17)) * 461845907) ^ i6;
                i8 -= 32;
                i7 += 4;
                i6 = (((i14 << 13) | (i14 >>> 19)) * 5) - 430675100;
                i9 = i8 != 0 ? charAt >>> (i11 - i8) : 0;
            } else {
                i9 = i12;
            }
            i5 = i10;
        }
        if (i8 > 0) {
            i7 += i8 >> 3;
            int i15 = i9 * (-862048943);
            i6 ^= ((i15 << 15) | (i15 >>> 17)) * 461845907;
        }
        int i16 = i6 ^ i7;
        int i17 = (i16 ^ (i16 >>> 16)) * (-2048144789);
        int i18 = (i17 ^ (i17 >>> 13)) * (-1028477387);
        return (i18 ^ (i18 >>> 16)) & 4294967295L;
    }

    private static long getLittleEndianLong(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    public static BigInteger[] unsignedHash128x64(byte[] bArr) {
        long[] hash128x64 = hash128x64(bArr);
        return new BigInteger[]{new BigInteger(Long.toBinaryString(hash128x64[0]), 2), new BigInteger(Long.toBinaryString(hash128x64[1]), 2)};
    }

    public static long[] hash128x64(byte[] bArr) {
        return hash128x64(bArr, 0, bArr.length, 0L);
    }

    public static long[] hash128x64(byte[] bArr, int i, int i2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        byte[] bArr2 = bArr;
        int i3 = i2 >> 4;
        long j9 = j;
        long j10 = j9;
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i + (i4 << 4);
            long littleEndianLong = getLittleEndianLong(bArr2, i5);
            long littleEndianLong2 = getLittleEndianLong(bArr2, i5 + 8);
            long rotateLeft = ((Long.rotateLeft((Long.rotateLeft(littleEndianLong * C1, 31) * C2) ^ j9, 27) + j10) * 5) + 1390208809;
            i4++;
            j10 = ((Long.rotateLeft(j10 ^ (Long.rotateLeft(C2 * littleEndianLong2, 33) * C1), 31) + rotateLeft) * 5) + 944331445;
            j9 = rotateLeft;
            bArr2 = bArr;
        }
        long j11 = 0;
        switch ((i + i2) - (i + (i3 << 4))) {
            case 1:
                j2 = j9;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 2:
                j2 = j9;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 3:
                j2 = j9;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 4:
                j2 = j9;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 5:
                j2 = j9;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 6:
                j2 = j9;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 7:
                j2 = j9;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 8:
                j2 = j9;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 9:
                j2 = j9;
                j3 = 0;
                j10 = (Long.rotateLeft((j3 ^ (bArr[r0 + 8] & 255)) * C2, 33) * C1) ^ j10;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 10:
                j2 = j9;
                j4 = 0;
                j3 = j4 ^ ((bArr[r0 + 9] & 255) << 8);
                j10 = (Long.rotateLeft((j3 ^ (bArr[r0 + 8] & 255)) * C2, 33) * C1) ^ j10;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 11:
                j2 = j9;
                j5 = 0;
                j4 = j5 ^ ((bArr[r0 + 10] & 255) << 16);
                j3 = j4 ^ ((bArr[r0 + 9] & 255) << 8);
                j10 = (Long.rotateLeft((j3 ^ (bArr[r0 + 8] & 255)) * C2, 33) * C1) ^ j10;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 12:
                j2 = j9;
                j6 = 0;
                j5 = j6 ^ ((bArr[r0 + 11] & 255) << 24);
                j4 = j5 ^ ((bArr[r0 + 10] & 255) << 16);
                j3 = j4 ^ ((bArr[r0 + 9] & 255) << 8);
                j10 = (Long.rotateLeft((j3 ^ (bArr[r0 + 8] & 255)) * C2, 33) * C1) ^ j10;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 13:
                j2 = j9;
                j7 = 0;
                j6 = j7 ^ ((bArr[r0 + 12] & 255) << 32);
                j5 = j6 ^ ((bArr[r0 + 11] & 255) << 24);
                j4 = j5 ^ ((bArr[r0 + 10] & 255) << 16);
                j3 = j4 ^ ((bArr[r0 + 9] & 255) << 8);
                j10 = (Long.rotateLeft((j3 ^ (bArr[r0 + 8] & 255)) * C2, 33) * C1) ^ j10;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 14:
                j8 = 0;
                j2 = j9;
                j7 = ((bArr[r0 + 13] & 255) << 40) ^ j8;
                j6 = j7 ^ ((bArr[r0 + 12] & 255) << 32);
                j5 = j6 ^ ((bArr[r0 + 11] & 255) << 24);
                j4 = j5 ^ ((bArr[r0 + 10] & 255) << 16);
                j3 = j4 ^ ((bArr[r0 + 9] & 255) << 8);
                j10 = (Long.rotateLeft((j3 ^ (bArr[r0 + 8] & 255)) * C2, 33) * C1) ^ j10;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
            case 15:
                j8 = ((bArr[r0 + 14] & 255) << 48) ^ 0;
                j2 = j9;
                j7 = ((bArr[r0 + 13] & 255) << 40) ^ j8;
                j6 = j7 ^ ((bArr[r0 + 12] & 255) << 32);
                j5 = j6 ^ ((bArr[r0 + 11] & 255) << 24);
                j4 = j5 ^ ((bArr[r0 + 10] & 255) << 16);
                j3 = j4 ^ ((bArr[r0 + 9] & 255) << 8);
                j10 = (Long.rotateLeft((j3 ^ (bArr[r0 + 8] & 255)) * C2, 33) * C1) ^ j10;
                j11 = ((bArr[r0 + 7] & 255) << 56) ^ 0;
                j11 ^= (bArr[r0 + 6] & 255) << 48;
                j11 ^= (bArr[r0 + 5] & 255) << 40;
                j11 ^= (bArr[r0 + 4] & 255) << 32;
                j11 ^= (bArr[r0 + 3] & 255) << 24;
                j11 ^= (bArr[r0 + 2] & 255) << 16;
                j11 ^= (bArr[r0 + 1] & 255) << 8;
                j9 = j2 ^ (Long.rotateLeft((j11 ^ (bArr[r0] & 255)) * C1, 31) * C2);
                break;
        }
        long j12 = i2;
        long j13 = j12 ^ j10;
        long j14 = (j12 ^ j9) + j13;
        long fmix64 = fmix64(j14);
        long fmix642 = fmix64(j13 + j14);
        long j15 = fmix64 + fmix642;
        return new long[]{j15, fmix642 + j15};
    }
}
