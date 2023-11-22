package com.ta.audid.f;

import android.content.Context;
import android.graphics.ImageFormat;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import com.ta.audid.g.m;
import java.util.List;
import o.E;

/* loaded from: classes.dex */
public class g implements Runnable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static long PlaceComponentResult;
    private static char getAuthRequestContext;
    private static volatile boolean h;
    private Context mContext;

    static {
        MyBillsEntityDataFactory();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
    }

    static void MyBillsEntityDataFactory() {
        getAuthRequestContext = (char) 13492;
        PlaceComponentResult = -4929159075110410588L;
        BuiltInFictitiousFunctionClassFactory = -956812108;
    }

    public g(Context context) {
        this.mContext = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        MyBillsEntityDataFactory = i % 128;
        try {
            if ((i % 2 == 0 ? 'a' : 'K') != 'a') {
                f();
            } else {
                f();
                Object obj = null;
                obj.hashCode();
            }
            int i2 = MyBillsEntityDataFactory + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Throwable th) {
            m.e("", th, new Object[0]);
        }
    }

    private void f() {
        m.d();
        if (com.ta.audid.g.g.isConnectInternet(this.mContext)) {
            if ((!h ? 'A' : 'Q') != 'Q') {
                int i = MyBillsEntityDataFactory + 55;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                h = true;
                if ((!com.ta.audid.g.f.d() ? JSONLexer.EOI : 'P') == 26) {
                    m.d("", "Other Process is Uploading");
                    h = false;
                    com.ta.audid.g.f.i();
                    return;
                }
                int i3 = 0;
                while (true) {
                    if ((i3 <= 0 ? '%' : ';') != '%') {
                        break;
                    }
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
                    MyBillsEntityDataFactory = i4 % 128;
                    if (i4 % 2 != 0) {
                        if (c()) {
                            break;
                        }
                    } else {
                        try {
                            boolean c = c();
                            Object[] objArr = null;
                            int length = objArr.length;
                            if (c) {
                                break;
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                    Thread.sleep(1000L);
                    i3++;
                }
                h = false;
                com.ta.audid.g.f.i();
            }
            int i5 = MyBillsEntityDataFactory + 11;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private boolean c() {
        m.d();
        List<com.ta.audid.e.b> list = com.ta.audid.e.d.a().get(4);
        try {
            try {
                if (list != null) {
                    int i = MyBillsEntityDataFactory + 71;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    if (list.size() != 0) {
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
                        MyBillsEntityDataFactory = i3 % 128;
                        int i4 = i3 % 2;
                        String a2 = a(list);
                        if (TextUtils.isEmpty(a2)) {
                            m.d("postData is empty", new Object[0]);
                            int i5 = MyBillsEntityDataFactory + 123;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                            int i6 = i5 % 2;
                            return true;
                        }
                        if (a(a2)) {
                            com.ta.audid.e.d.a().delete(list);
                            m.d("", "upload success");
                        } else {
                            m.d("", "upload fail");
                        }
                        return false;
                    }
                }
                m.d("log is empty", new Object[0]);
                int i7 = MyBillsEntityDataFactory + 51;
                KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                int i8 = i7 % 2;
                return true;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private boolean a(String str) {
        String str2 = "";
        b a2 = c.a("https://audid-api.taobao.com/v2.0/a/audid/req/", str, true);
        try {
            byte[] bArr = a2.data;
            Object[] objArr = new Object[1];
            b(new char[]{43912, 37396, 31702, 64282, 28277}, new char[]{7128, 11453, 6070, 19941}, (char) ((Process.myPid() >> 22) + 58647), new char[]{37392, 6238, 16873, 34589}, ImageFormat.getBitsPerPixel(0) - 1238581988, objArr);
            str2 = new String(bArr, ((String) objArr[0]).intern());
        } catch (Exception e) {
            m.d("", e);
        }
        if ((b.a(str2, a2.h) ? '^' : (char) 6) != '^') {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return false;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        MyBillsEntityDataFactory = i3 % 128;
        boolean z = i3 % 2 == 0;
        boolean a3 = a.a(a.a(str2).f7677a);
        if (z) {
            int i4 = 58 / 0;
            return a3;
        }
        return a3;
    }

    private String a(List<com.ta.audid.e.b> list) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if ((list != null ? 'R' : '\\') == 'R') {
            if (!(list.size() == 0)) {
                try {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    String E = com.ta.audid.c.a.a().E();
                    if (TextUtils.isEmpty(E)) {
                        int i5 = MyBillsEntityDataFactory + 19;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        int i6 = i5 % 2;
                        return null;
                    }
                    String b = com.ta.audid.e.c.b(E);
                    StringBuilder sb = new StringBuilder();
                    sb.append(b);
                    int i7 = 0;
                    while (true) {
                        if ((i7 < list.size() ? (char) 15 : (char) 23) != 15) {
                            break;
                        }
                        String H = list.get(i7).H();
                        sb.append("\n");
                        sb.append(H);
                        i7++;
                        int i8 = MyBillsEntityDataFactory + 113;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                        int i9 = i8 % 2;
                    }
                    if (m.isDebug()) {
                        int i10 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
                        MyBillsEntityDataFactory = i10 % 128;
                        int i11 = i10 % 2;
                        m.m249a("", sb.toString());
                    }
                    try {
                        return com.ta.audid.e.e.e(sb.toString());
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        return null;
    }

    private static void b(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 < length3)) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i2 = $11 + 103;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
            int i6 = $10 + 67;
            $11 = i6 % 128;
            int i7 = i6 % 2;
        }
    }
}
