package com.alipay.imobile.magenerator.a;

/* loaded from: classes6.dex */
final class p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(e eVar) {
        return a(eVar, true) + a(eVar, false);
    }

    private static int a(e eVar, boolean z) {
        int a2 = z ? eVar.a() : eVar.b();
        int b = z ? eVar.b() : eVar.a();
        byte[][] c = eVar.c();
        int i = 0;
        for (int i2 = 0; i2 < a2; i2++) {
            byte b2 = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < b; i4++) {
                byte b3 = z ? c[i2][i4] : c[i4][i2];
                if (b3 == b2) {
                    i3++;
                } else {
                    if (i3 >= 5) {
                        i += (i3 - 5) + 3;
                    }
                    b2 = b3;
                    i3 = 1;
                }
            }
            if (i3 >= 5) {
                i += (i3 - 5) + 3;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(int i, int i2, int i3) {
        int i4;
        int i5;
        switch (i) {
            case 0:
                i3 += i2;
                i4 = i3 & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i3 /= 2;
                i2 /= 3;
                i3 += i2;
                i4 = i3 & 1;
                break;
            case 5:
                int i6 = i3 * i2;
                i4 = (i6 & 1) + (i6 % 3);
                break;
            case 6:
                int i7 = i3 * i2;
                i5 = (i7 & 1) + (i7 % 3);
                i4 = i5 & 1;
                break;
            case 7:
                i5 = ((i3 * i2) % 3) + ((i3 + i2) & 1);
                i4 = i5 & 1;
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid mask pattern: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
        return i4 == 0;
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (i >= 0 && i < bArr.length && bArr[i] == 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2][i] == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(e eVar) {
        byte[][] c = eVar.c();
        int b = eVar.b();
        int a2 = eVar.a();
        int i = 0;
        for (int i2 = 0; i2 < a2 - 1; i2++) {
            int i3 = 0;
            while (i3 < b - 1) {
                byte[] bArr = c[i2];
                byte b2 = bArr[i3];
                int i4 = i3 + 1;
                if (b2 == bArr[i4]) {
                    byte[] bArr2 = c[i2 + 1];
                    if (b2 == bArr2[i3] && b2 == bArr2[i4]) {
                        i++;
                    }
                }
                i3 = i4;
            }
        }
        return i * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(e eVar) {
        byte[][] c = eVar.c();
        int b = eVar.b();
        int a2 = eVar.a();
        int i = 0;
        for (int i2 = 0; i2 < a2; i2++) {
            for (int i3 = 0; i3 < b; i3++) {
                byte[] bArr = c[i2];
                int i4 = i3 + 6;
                if (i4 < b && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (a(bArr, i3 - 4, i3) || a(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                int i5 = i2 + 6;
                if (i5 < a2 && c[i2][i3] == 1 && c[i2 + 1][i3] == 0 && c[i2 + 2][i3] == 1 && c[i2 + 3][i3] == 1 && c[i2 + 4][i3] == 1 && c[i2 + 5][i3] == 0 && c[i5][i3] == 1 && (a(c, i3, i2 - 4, i2) || a(c, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(e eVar) {
        byte[][] c = eVar.c();
        int b = eVar.b();
        int a2 = eVar.a();
        int i = 0;
        for (int i2 = 0; i2 < a2; i2++) {
            byte[] bArr = c[i2];
            for (int i3 = 0; i3 < b; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int a3 = eVar.a() * eVar.b();
        return ((Math.abs((i * 2) - a3) * 10) / a3) * 10;
    }
}
