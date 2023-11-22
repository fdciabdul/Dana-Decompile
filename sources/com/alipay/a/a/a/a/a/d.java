package com.alipay.a.a.a.a.a;

import com.alipay.a.a.a.a.s;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d extends a {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {40, 6, -7, -65, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 73;

    private static void c(int i, int i2, short s, Object[] objArr) {
        int i3 = (i * 7) + 99;
        int i4 = (i2 * 3) + 13;
        int i5 = 16 - (s * 12);
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            i5++;
            int i8 = i5 + i7 + 2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i7 = i7;
            i3 = i8;
        }
        while (true) {
            int i9 = i6 + 1;
            bArr2[i9] = (byte) i3;
            if (i9 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i5];
            Object[] objArr2 = objArr;
            int i10 = i3;
            int i11 = i7;
            i5++;
            int i12 = i10 + b + 2;
            objArr = objArr2;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i9;
            i7 = i11;
            i3 = i12;
        }
    }

    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.a.a.a.a.a.c
    public final Object a() {
        try {
            String str = new String(this.b);
            StringBuilder sb = new StringBuilder("threadid = ");
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[15];
                byte b2 = b;
                Object[] objArr = new Object[1];
                c(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                Object[] objArr2 = new Object[1];
                c(b3, b3, BuiltInFictitiousFunctionClassFactory[15], objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
                sb.append("; rpc response:  ");
                sb.append(str);
                InstrumentInjector.log_v("HttpCaller", sb.toString());
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("resultStatus");
                if (i != 1000) {
                    throw new s(Integer.valueOf(i), jSONObject.optString("tips"));
                } else if (this.f6818a == String.class) {
                    return jSONObject.optString("result");
                } else {
                    return com.alipay.b.a.e.a(jSONObject.optString("result"), this.f6818a);
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("response  =");
            sb2.append(new String(this.b));
            sb2.append(":");
            sb2.append(e);
            throw new s(10, sb2.toString() == null ? "" : e.getMessage());
        }
    }
}
