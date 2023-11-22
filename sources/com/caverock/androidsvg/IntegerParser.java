package com.caverock.androidsvg;

/* loaded from: classes3.dex */
class IntegerParser {
    private int pos;
    private long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntegerParser(long j, int i) {
        this.value = j;
        this.pos = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEndPos() {
        return this.pos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IntegerParser parseInt(String str, int i, int i2, boolean z) {
        if (i >= i2) {
            return null;
        }
        if (z) {
            char charAt = str.charAt(i);
            if (charAt != '+') {
                r1 = charAt == '-';
            }
            i++;
        }
        long j = 0;
        int i3 = i;
        while (i3 < i2) {
            char charAt2 = str.charAt(i3);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            long j2 = j * 10;
            long j3 = (long) (charAt2 - '0');
            if (r1) {
                j = j2 - j3;
                if (j < -2147483648L) {
                    return null;
                }
            } else {
                j = j2 + j3;
                if (j > 2147483647L) {
                    return null;
                }
            }
            i3++;
        }
        if (i3 == i) {
            return null;
        }
        return new IntegerParser(j, i3);
    }

    public int value() {
        return (int) this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IntegerParser parseHex(String str, int i, int i2) {
        long j;
        int i3;
        long j2;
        long j3;
        if (i >= i2) {
            return null;
        }
        long j4 = 0;
        int i4 = i;
        while (i4 < i2) {
            char charAt = str.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j = j4 * 16;
                    i3 = charAt - 'A';
                } else if (charAt < 'a' || charAt > 'f') {
                    break;
                } else {
                    j = j4 * 16;
                    i3 = charAt - 'a';
                }
                j2 = j + i3;
                j3 = 10;
            } else {
                j2 = j4 * 16;
                j3 = (long) (charAt - '0');
            }
            j4 = j2 + j3;
            if (j4 > 4294967295L) {
                return null;
            }
            i4++;
        }
        if (i4 == i) {
            return null;
        }
        return new IntegerParser(j4, i4);
    }
}
