package com.alipay.imobile.magenerator.a;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f7014a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    static int a(int i) {
        int[] iArr = f7014a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static int a(b bVar, m mVar, y yVar, e eVar) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            q.a(bVar, mVar, yVar, i3, eVar);
            int a2 = a(eVar);
            if (a2 < i) {
                i2 = i3;
                i = a2;
            }
        }
        return i2;
    }

    private static int a(e eVar) {
        return p.a(eVar) + p.b(eVar) + p.c(eVar) + p.d(eVar);
    }

    static b a(b bVar, int i, int i2, int i3) {
        if (bVar.b() == i2) {
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i, i2, i3, i7, iArr, iArr2);
                int i8 = iArr[0];
                byte[] bArr = new byte[i8];
                bVar.a(i4 * 8, bArr, 0, i8);
                byte[] a2 = a(bArr, iArr2[0]);
                arrayList.add(new d(bArr, a2));
                i5 = Math.max(i5, i8);
                i6 = Math.max(i6, a2.length);
                i4 += iArr[0];
            }
            if (i2 == i4) {
                b bVar2 = new b();
                for (int i9 = 0; i9 < i5; i9++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a3 = ((d) it.next()).a();
                        if (i9 < a3.length) {
                            bVar2.a(a3[i9], 8);
                        }
                    }
                }
                for (int i10 = 0; i10 < i6; i10++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] b = ((d) it2.next()).b();
                        if (i10 < b.length) {
                            bVar2.a(b[i10], 8);
                        }
                    }
                }
                if (i == bVar2.b()) {
                    return bVar2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Interleaving error: ");
                sb.append(i);
                sb.append(" and ");
                sb.append(bVar2.b());
                sb.append(" differ.");
                throw new ac(sb.toString());
            }
            throw new ac("Data bytes does not match offset");
        }
        throw new ac("Number of bits and data bytes does not match");
    }

    private static r a(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return a(str) ? r.KANJI : r.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (a(charAt) == -1) {
                return r.BYTE;
            } else {
                z = true;
            }
        }
        return z ? r.ALPHANUMERIC : z2 ? r.NUMERIC : r.BYTE;
    }

    public static v a(String str, m mVar, Map map) {
        f a2;
        String str2 = map == null ? null : (String) map.get(j.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        r a3 = a(str, str2);
        b bVar = new b();
        r rVar = r.BYTE;
        if (a3 == rVar && !"ISO-8859-1".equals(str2) && (a2 = f.a(str2)) != null) {
            a(a2, bVar);
        }
        a(a3, bVar);
        b bVar2 = new b();
        a(str, a3, bVar2, str2);
        y a4 = a(bVar.a() + a3.a(a(bVar.a() + a3.a(y.a(1)) + bVar2.a(), mVar)) + bVar2.a(), mVar);
        b bVar3 = new b();
        bVar3.a(bVar);
        a(a3 == rVar ? bVar2.b() : str.length(), a4, a3, bVar3);
        bVar3.a(bVar2);
        aa a5 = a4.a(mVar);
        int b = a4.b() - a5.c();
        a(b, bVar3);
        b a6 = a(bVar3, a4.b(), b, a5.b());
        v vVar = new v();
        vVar.a(mVar);
        vVar.a(a3);
        vVar.a(a4);
        int c = a4.c();
        e eVar = new e(c, c);
        int a7 = a(a6, mVar, a4, eVar);
        vVar.a(a7);
        q.a(a6, mVar, a4, a7, eVar);
        vVar.a(eVar);
        return vVar;
    }

    private static y a(int i, m mVar) {
        for (int i2 = 2; i2 <= 40; i2++) {
            y a2 = y.a(i2);
            if (a2.b() - a2.a(mVar).c() >= (i + 7) / 8) {
                return a2;
            }
        }
        throw new ac("Data too big");
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new ac("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i2 / i3;
        int i9 = i8 + 1;
        int i10 = i7 - i8;
        int i11 = (i7 + 1) - i9;
        if (i10 != i11) {
            throw new ac("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new ac("RS blocks mismatch");
        }
        if (i != ((i8 + i10) * i6) + ((i9 + i11) * i5)) {
            throw new ac("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i8;
            iArr2[0] = i10;
            return;
        }
        iArr[0] = i9;
        iArr2[0] = i11;
    }

    static void a(int i, b bVar) {
        int i2 = i * 8;
        if (bVar.a() > i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("data bits cannot fit in the QR Code");
            sb.append(bVar.a());
            sb.append(" > ");
            sb.append(i2);
            throw new ac(sb.toString());
        }
        for (int i3 = 0; i3 < 4 && bVar.a() < i2; i3++) {
            bVar.a(false);
        }
        int a2 = bVar.a() & 7;
        if (a2 > 0) {
            while (a2 < 8) {
                bVar.a(false);
                a2++;
            }
        }
        int b = bVar.b();
        for (int i4 = 0; i4 < i - b; i4++) {
            bVar.a((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (bVar.a() != i2) {
            throw new ac("Bits size does not equal capacity");
        }
    }

    static void a(int i, y yVar, r rVar, b bVar) {
        int a2 = rVar.a(yVar);
        int i2 = 1 << a2;
        if (i < i2) {
            bVar.a(i, a2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(" is bigger than ");
        sb.append(i2 - 1);
        throw new ac(sb.toString());
    }

    private static void a(f fVar, b bVar) {
        bVar.a(r.ECI.a(), 4);
        bVar.a(fVar.a(), 8);
    }

    static void a(r rVar, b bVar) {
        bVar.a(rVar.a(), 4);
    }

    static void a(CharSequence charSequence, b bVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bVar.a((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bVar.a((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bVar.a(charAt, 4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[LOOP:0: B:4:0x0008->B:18:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.lang.String r6, com.alipay.imobile.magenerator.a.b r7) {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            r3 = -1
            r4 = 33088(0x8140, float:4.6366E-41)
            if (r2 < r4) goto L23
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L23
            goto L30
        L23:
            r4 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r4) goto L32
            r4 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r4) goto L32
            r4 = 49472(0xc140, float:6.9325E-41)
        L30:
            int r2 = r2 - r4
            goto L33
        L32:
            r2 = -1
        L33:
            if (r2 == r3) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.alipay.imobile.magenerator.a.ac r6 = new com.alipay.imobile.magenerator.a.ac
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.alipay.imobile.magenerator.a.ac r7 = new com.alipay.imobile.magenerator.a.ac
            r7.<init>(r6)
            goto L55
        L54:
            throw r7
        L55:
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.magenerator.a.k.a(java.lang.String, com.alipay.imobile.magenerator.a.b):void");
    }

    static void a(String str, b bVar, String str2) {
        try {
            for (byte b : str.getBytes(str2)) {
                bVar.a(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new ac(e);
        }
    }

    static void a(String str, r rVar, b bVar, String str2) {
        int i = l.f7015a[rVar.ordinal()];
        if (i == 1) {
            a((CharSequence) str, bVar);
        } else if (i == 2) {
            b(str, bVar);
        } else if (i == 3) {
            a(str, bVar, str2);
        } else if (i == 4) {
            a(str, bVar);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid mode: ");
            sb.append(rVar);
            throw new ac(sb.toString());
        }
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new x(n.e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void b(CharSequence charSequence, b bVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a2 = a(charSequence.charAt(i));
            if (a2 == -1) {
                throw new ac();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int a3 = a(charSequence.charAt(i2));
                if (a3 == -1) {
                    throw new ac();
                }
                bVar.a((a2 * 45) + a3, 11);
                i += 2;
            } else {
                bVar.a(a2, 6);
                i = i2;
            }
        }
    }
}
