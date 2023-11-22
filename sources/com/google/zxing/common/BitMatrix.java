package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        int i3 = (i + 31) / 32;
        this.rowSize = i3;
        this.bits = new int[i3 * i2];
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public static BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        BitMatrix bitMatrix = new BitMatrix(length2, length);
        for (int i = 0; i < length; i++) {
            boolean[] zArr2 = zArr[i];
            for (int i2 = 0; i2 < length2; i2++) {
                if (zArr2[i2]) {
                    bitMatrix.set(i2, i);
                }
            }
        }
        return bitMatrix;
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '\n' || str.charAt(i) == '\r') {
                if (i4 > i5) {
                    if (i2 == -1) {
                        i2 = i4 - i5;
                    } else if (i4 - i5 != i2) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i3++;
                    i5 = i4;
                }
                i++;
            } else {
                if (str.substring(i, str2.length() + i).equals(str2)) {
                    i += str2.length();
                    zArr[i4] = true;
                } else if (str.substring(i, str3.length() + i).equals(str3)) {
                    i += str3.length();
                    zArr[i4] = false;
                } else {
                    StringBuilder sb = new StringBuilder("illegal character encountered: ");
                    sb.append(str.substring(i));
                    throw new IllegalArgumentException(sb.toString());
                }
                i4++;
            }
        }
        if (i4 > i5) {
            int i6 = i4 - i5;
            if (i2 == -1) {
                i2 = i6;
            } else if (i6 != i2) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i3++;
        }
        BitMatrix bitMatrix = new BitMatrix(i2, i3);
        for (int i7 = 0; i7 < i4; i7++) {
            if (zArr[i7]) {
                bitMatrix.set(i7 % i2, i7 / i2);
            }
        }
        return bitMatrix;
    }

    public final boolean get(int i, int i2) {
        return ((this.bits[(i2 * this.rowSize) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public final void set(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public final void unset(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = ((1 << (i & 31)) ^ (-1)) & iArr[i3];
    }

    public final void flip(int i, int i2) {
        int i3 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public final void xor(BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        BitArray bitArray = new BitArray(this.width);
        for (int i = 0; i < this.height; i++) {
            int i2 = this.rowSize;
            int[] bitArray2 = bitMatrix.getRow(i, bitArray).getBitArray();
            for (int i3 = 0; i3 < this.rowSize; i3++) {
                int[] iArr = this.bits;
                int i4 = (i2 * i) + i3;
                iArr[i4] = iArr[i4] ^ bitArray2[i3];
            }
        }
    }

    public final void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public final void setRegion(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.height || i5 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.rowSize;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.bits;
                int i9 = (i8 / 32) + (i7 * i2);
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public final BitArray getRow(int i, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i2 = this.rowSize;
        for (int i3 = 0; i3 < this.rowSize; i3++) {
            bitArray.setBulk(i3 << 5, this.bits[(i * i2) + i3]);
        }
        return bitArray;
    }

    public final void setRow(int i, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i2 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, i * i2, i2);
    }

    public final void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int i = 0; i < (height + 1) / 2; i++) {
            bitArray = getRow(i, bitArray);
            int i2 = (height - 1) - i;
            bitArray2 = getRow(i2, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i, bitArray2);
            setRow(i2, bitArray);
        }
    }

    public final int[] getEnclosingRectangle() {
        int i = this.width;
        int i2 = this.height;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.height; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.rowSize;
                if (i6 < i7) {
                    int i8 = this.bits[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 << 5;
                        int i10 = 31;
                        if (i9 < i) {
                            int i11 = 0;
                            while ((i8 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i9;
                            if (i12 < i) {
                                i = i12;
                            }
                        }
                        if (i9 + 31 > i3) {
                            while ((i8 >>> i10) == 0) {
                                i10--;
                            }
                            int i13 = i9 + i10;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        if (i3 < i || i4 < i2) {
            return null;
        }
        return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
    }

    public final int[] getTopLeftOnBit() {
        int[] iArr;
        int i = 0;
        while (true) {
            iArr = this.bits;
            if (i >= iArr.length || iArr[i] != 0) {
                break;
            }
            i++;
        }
        if (i == iArr.length) {
            return null;
        }
        int i2 = this.rowSize;
        int i3 = i / i2;
        int i4 = 0;
        while ((iArr[i] << (31 - i4)) == 0) {
            i4++;
        }
        return new int[]{((i % i2) << 5) + i4, i3};
    }

    public final int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.rowSize;
        int i2 = length / i;
        int i3 = 31;
        while ((this.bits[length] >>> i3) == 0) {
            i3--;
        }
        return new int[]{((length % i) << 5) + i3, i2};
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getRowSize() {
        return this.rowSize;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof BitMatrix) {
            BitMatrix bitMatrix = (BitMatrix) obj;
            return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.width;
        return (((((((i * 31) + i) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public final String toString() {
        return toString("X ", "  ");
    }

    public final String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    @Deprecated
    public final String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                sb.append(get(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public final BitMatrix m228clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }
}
