package com.alipay.imobile.magenerator.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public final class h extends u {
    private static boolean a(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        int length = charSequence.length();
        while (i < i3 && i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (charAt != 241) {
                    return false;
                }
                i3++;
            }
            i++;
        }
        return i3 <= length;
    }

    @Override // com.alipay.imobile.magenerator.a.u, com.alipay.imobile.magenerator.a.ab
    public final c a(String str, a aVar, int i, int i2, Map map) {
        if (aVar == a.CODE_128) {
            return super.a(str, aVar, i, i2, map);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can only encode CODE_128, but got ");
        sb.append(aVar);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.alipay.imobile.magenerator.a.u
    public final boolean[] a(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            StringBuilder sb = new StringBuilder();
            sb.append("Contents length should be between 1 and 80 characters, but got ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bad character in input: ");
                        sb2.append(charAt);
                        throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i3 < length) {
            int i7 = 100;
            int i8 = a(str, i3, i5 == 99 ? 2 : 4) ? 99 : 100;
            if (i8 == i5) {
                switch (str.charAt(i3)) {
                    case 241:
                        i7 = 102;
                        break;
                    case 242:
                        i7 = 97;
                        break;
                    case 243:
                        i7 = 96;
                        break;
                    case 244:
                        break;
                    default:
                        if (i5 == 100) {
                            i7 = str.charAt(i3) - ' ';
                            break;
                        } else {
                            i7 = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3++;
                            break;
                        }
                }
                i3++;
                i8 = i7;
            } else if (i5 != 0) {
                i5 = i8;
            } else if (i8 == 100) {
                i5 = i8;
                i8 = 104;
            } else {
                i5 = i8;
                i8 = 105;
            }
            arrayList.add(g.f7012a[i8]);
            i4 += i8 * i6;
            if (i3 != 0) {
                i6++;
            }
        }
        int[][] iArr = g.f7012a;
        arrayList.add(iArr[i4 % 103]);
        arrayList.add(iArr[106]);
        int i9 = 0;
        for (int[] iArr2 : arrayList) {
            for (int i10 : iArr2) {
                i9 += i10;
            }
        }
        boolean[] zArr = new boolean[i9];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i += u.a(zArr, i, (int[]) it.next(), true);
        }
        return zArr;
    }
}
