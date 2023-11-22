package com.alipay.imobile.magenerator.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.Map;
import o.D;

/* loaded from: classes6.dex */
public class ad extends i {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 0;
    private static int PlaceComponentResult = 1;
    private static ad b;
    private static final String c;
    private static int getAuthRequestContext;

    /* renamed from: a  reason: collision with root package name */
    private w f7005a = new w();

    static {
        PlaceComponentResult();
        b = new ad();
        c = "ad";
        try {
            int i = PlaceComponentResult + 15;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private ad() {
    }

    static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = -5707841022066861925L;
    }

    private Bitmap a(c cVar) {
        int i;
        int a2 = cVar.a();
        int b2 = cVar.b();
        int[] iArr = new int[a2 * b2];
        int i2 = getAuthRequestContext + 3;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        int i4 = 0;
        while (true) {
            if (i4 >= b2) {
                Bitmap createBitmap = Bitmap.createBitmap(a2, b2, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, a2, 0, 0, a2, b2);
                int i5 = PlaceComponentResult + 77;
                getAuthRequestContext = i5 % 128;
                int i6 = i5 % 2;
                return createBitmap;
            }
            int i7 = 0;
            while (true) {
                if ((i7 < a2 ? '\b' : '9') != '\b') {
                    break;
                }
                if (!cVar.a(i7, i4)) {
                    i = -1;
                } else {
                    int i8 = PlaceComponentResult + 35;
                    getAuthRequestContext = i8 % 128;
                    int i9 = i8 % 2;
                    i = -16777216;
                }
                iArr[(i4 * a2) + i7] = i;
                i7++;
            }
            i4++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r15.a(r4, r1) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if ((!r5) != true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r5 = r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap a(com.alipay.imobile.magenerator.a.c r15, int r16, int r17) {
        /*
            r14 = this;
            r0 = r15
            int r1 = com.alipay.imobile.magenerator.a.ad.PlaceComponentResult
            int r1 = r1 + 19
            int r2 = r1 % 128
            com.alipay.imobile.magenerator.a.ad.getAuthRequestContext = r2
            int r1 = r1 % 2
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L23
            int r1 = r15.a()     // Catch: java.lang.Exception -> L20
            int r4 = r15.b()     // Catch: java.lang.Exception -> L20
            int r5 = r1 + r4
            int[] r5 = new int[r5]     // Catch: java.lang.Exception -> L20
            r12 = r1
            r13 = r4
            r7 = r5
            r1 = 1
            goto L33
        L20:
            r0 = move-exception
            goto L88
        L23:
            int r1 = r15.a()
            int r4 = r15.b()
            int r5 = r1 * r4
            int[] r5 = new int[r5]
            r12 = r1
            r13 = r4
            r7 = r5
            r1 = 0
        L33:
            if (r1 >= r13) goto L76
            r4 = 0
        L36:
            if (r4 >= r12) goto L73
            int r5 = com.alipay.imobile.magenerator.a.ad.getAuthRequestContext
            int r5 = r5 + 107
            int r6 = r5 % 128
            com.alipay.imobile.magenerator.a.ad.PlaceComponentResult = r6
            int r5 = r5 % 2
            r6 = 8
            if (r5 != 0) goto L49
            r5 = 8
            goto L4b
        L49:
            r5 = 55
        L4b:
            if (r5 == r6) goto L54
            boolean r5 = r15.a(r4, r1)
            if (r5 == 0) goto L66
            goto L63
        L54:
            boolean r5 = r15.a(r4, r1)
            r6 = 0
            r6.hashCode()     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L60
            r5 = 0
            goto L61
        L60:
            r5 = 1
        L61:
            if (r5 == r3) goto L66
        L63:
            r5 = r16
            goto L68
        L66:
            r5 = r17
        L68:
            int r6 = r1 * r12
            int r6 = r6 + r4
            r7[r6] = r5
            int r4 = r4 + 1
            goto L36
        L70:
            r0 = move-exception
            r1 = r0
            throw r1
        L73:
            int r1 = r1 + 1
            goto L33
        L76:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L20
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r12, r13, r0)     // Catch: java.lang.Exception -> L85
            r8 = 0
            r10 = 0
            r11 = 0
            r6 = r0
            r9 = r12
            r6.setPixels(r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> L20
            return r0
        L85:
            r0 = move-exception
            r1 = r0
            throw r1
        L88:
            goto L8a
        L89:
            throw r0
        L8a:
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.magenerator.a.ad.a(com.alipay.imobile.magenerator.a.c, int, int):android.graphics.Bitmap");
    }

    public static ad a() {
        int i = PlaceComponentResult + 123;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ad adVar = b;
        int i3 = getAuthRequestContext + 113;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return adVar;
    }

    private static String a(CharSequence charSequence) {
        int i = getAuthRequestContext + 49;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
        }
        int i2 = 0;
        while (true) {
            if ((i2 < charSequence.length() ? 'M' : (char) 4) != 'M') {
                return null;
            }
            if ((charSequence.charAt(i2) > 255 ? '\b' : '\\') == '\b') {
                Object[] objArr = new Object[1];
                d(1 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{56532, 62334, 56449, 58969, 56679, 51705, 63431, 35213, 35104}, objArr);
                return ((String) objArr[0]).intern();
            }
            i2++;
            int i3 = PlaceComponentResult + 5;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    private void a(Bitmap bitmap, Bitmap bitmap2, String str, int i, Map map) {
        int i2;
        try {
            int i3 = PlaceComponentResult + 47;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            try {
                v a2 = k.a(str, m.H, map);
                int a3 = a2.a().a();
                int b2 = a2.b().b();
                int i5 = i / b2;
                int i6 = b2 * i5;
                int i7 = (i - i6) / 2;
                int i8 = a3 + 5;
                int i9 = i5 * i8;
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = i9 * 1.0f;
                if (!(width > height)) {
                    int i10 = (int) ((f * width) / height);
                    i2 = i9;
                    i9 = i10;
                } else {
                    int i11 = PlaceComponentResult + 67;
                    getAuthRequestContext = i11 % 128;
                    int i12 = i11 % 2;
                    i2 = (int) ((f * height) / width);
                    int i13 = PlaceComponentResult + 43;
                    getAuthRequestContext = i13 % 128;
                    int i14 = i13 % 2;
                }
                int i15 = i7 + (i6 / 2);
                int i16 = (i15 - (i9 / 2)) - (((1 - (i8 % 2)) * i5) / 2);
                int i17 = (i15 - (i2 / 2)) - (((1 - (i8 % 2)) * i5) / 2);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                bitmapDrawable.setBounds(i16, i17, i9 + i16, i2 + i17);
                bitmapDrawable.draw(new Canvas(bitmap2));
            } catch (ac unused) {
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Bitmap a(String str, int i) {
        c cVar;
        HashMap hashMap = new HashMap();
        String a2 = a(str);
        if (!(a2 == null)) {
            int i2 = getAuthRequestContext + 19;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            try {
                hashMap.put(j.CHARACTER_SET, a2);
                hashMap.put(j.ERROR_CORRECTION, m.M);
                hashMap.put(j.MARGIN, 0);
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            cVar = this.f7005a.a(str, a.QR_CODE, i, i, hashMap);
            int i4 = PlaceComponentResult + 65;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
        } catch (ac unused) {
            cVar = null;
        }
        return a(cVar);
    }

    public Bitmap a(String str, int i, int i2) {
        int i3 = PlaceComponentResult + 1;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        Bitmap a2 = a(str, a.CODE_128, i, i2);
        int i5 = PlaceComponentResult + 111;
        getAuthRequestContext = i5 % 128;
        int i6 = i5 % 2;
        return a2;
    }

    public Bitmap a(String str, int i, int i2, int i3) {
        int i4 = PlaceComponentResult + 5;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        Bitmap a2 = a(str, i, i2, i3, (Bitmap) null);
        int i6 = PlaceComponentResult + 65;
        getAuthRequestContext = i6 % 128;
        if (i6 % 2 != 0) {
            int i7 = 84 / 0;
            return a2;
        }
        return a2;
    }

    public Bitmap a(String str, int i, int i2, int i3, int i4) {
        int i5 = PlaceComponentResult + 9;
        getAuthRequestContext = i5 % 128;
        int i6 = i5 % 2;
        try {
            Bitmap a2 = a(str, a.CODE_128, i, i2, i3, i4);
            int i7 = getAuthRequestContext + 17;
            PlaceComponentResult = i7 % 128;
            if ((i7 % 2 == 0 ? (char) 25 : 'V') != 'V') {
                Object obj = null;
                obj.hashCode();
                return a2;
            }
            return a2;
        } catch (Exception e) {
            throw e;
        }
    }

    public Bitmap a(String str, int i, int i2, int i3, Bitmap bitmap) {
        HashMap hashMap = new HashMap();
        hashMap.put(j.ERROR_CORRECTION, m.H);
        hashMap.put(j.MARGIN, 0);
        String a2 = a(str);
        if (!(a2 == null)) {
            hashMap.put(j.CHARACTER_SET, a2);
        }
        c cVar = null;
        try {
            cVar = this.f7005a.a(str, a.QR_CODE, i, i, hashMap);
            int i4 = PlaceComponentResult + 35;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
        } catch (ac unused) {
        }
        Bitmap a3 = a(cVar, i2, i3);
        if (bitmap != null) {
            int i6 = PlaceComponentResult + 85;
            getAuthRequestContext = i6 % 128;
            if ((i6 % 2 != 0 ? '*' : 'E') != 'E') {
                a(bitmap, a3, str, i, hashMap);
                int i7 = 96 / 0;
            } else {
                a(bitmap, a3, str, i, hashMap);
            }
        }
        return a3;
    }

    public Bitmap a(String str, a aVar, int i, int i2) {
        Bitmap bitmap;
        Object[] objArr = null;
        try {
            bitmap = a(new s().a(str, aVar, i, i2));
        } catch (ac e) {
            InstrumentInjector.log_e(c, e.getMessage());
            bitmap = null;
        }
        int i3 = getAuthRequestContext + 31;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 == 0 ? 'S' : '(') != 'S') {
            return bitmap;
        }
        int length = objArr.length;
        return bitmap;
    }

    public Bitmap a(String str, a aVar, int i, int i2, int i3, int i4) {
        int i5;
        try {
            c a2 = new s().a(str, aVar, i, i2);
            int a3 = a2.a();
            int b2 = a2.b();
            int[] iArr = new int[a3 * b2];
            int i6 = 0;
            while (true) {
                if ((i6 < b2 ? 'B' : (char) 18) != 'B') {
                    Bitmap createBitmap = Bitmap.createBitmap(a3, b2, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr, 0, a3, 0, 0, a3, b2);
                    return createBitmap;
                }
                int i7 = 0;
                while (true) {
                    if (!(i7 < a3)) {
                        break;
                    }
                    int i8 = getAuthRequestContext + 85;
                    PlaceComponentResult = i8 % 128;
                    int i9 = i8 % 2;
                    if (a2.a(i7, i6)) {
                        i5 = i3;
                    } else {
                        int i10 = PlaceComponentResult + 105;
                        getAuthRequestContext = i10 % 128;
                        int i11 = i10 % 2;
                        i5 = i4;
                    }
                    iArr[(i6 * a3) + i7] = i5;
                    i7++;
                }
                i6++;
            }
        } catch (ac e) {
            InstrumentInjector.log_e(c, e.getMessage());
            return null;
        }
    }

    private static void d(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            try {
                char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L, cArr, i);
                d.MyBillsEntityDataFactory = 4;
                while (true) {
                    if (d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$2.length) {
                        break;
                    }
                    int i2 = $11 + 61;
                    $10 = i2 % 128;
                    int i3 = i2 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                    int i4 = $11 + 51;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                }
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                int i6 = $10 + 11;
                $11 = i6 % 128;
                if (!(i6 % 2 == 0)) {
                    objArr[0] = str;
                    return;
                }
                int i7 = 16 / 0;
                objArr[0] = str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
