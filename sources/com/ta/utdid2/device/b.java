package com.ta.utdid2.device;

import android.content.Context;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f7696a;
    static final Object d = new Object();

    static long a(a aVar) {
        if (aVar != null) {
            String format = String.format("%s%s%s%s%s", aVar.getUtdid(), aVar.getDeviceId(), Long.valueOf(aVar.b()), aVar.getImsi(), aVar.getImei());
            if (com.ta.utdid2.a.a.e.isEmpty(format)) {
                return 0L;
            }
            Adler32 adler32 = new Adler32();
            adler32.reset();
            adler32.update(format.getBytes());
            return adler32.getValue();
        }
        return 0L;
    }

    private static a a(Context context) {
        if (context != null) {
            synchronized (d) {
                String value = c.a(context).getValue();
                if (com.ta.utdid2.a.a.e.isEmpty(value)) {
                    return null;
                }
                if (value.endsWith("\n")) {
                    value = value.substring(0, value.length() - 1);
                }
                a aVar = new a();
                long currentTimeMillis = System.currentTimeMillis();
                String imei = com.ta.utdid2.a.a.d.getImei(context);
                String imsi = com.ta.utdid2.a.a.d.getImsi(context);
                aVar.j(imei);
                aVar.setImei(imei);
                aVar.c(currentTimeMillis);
                aVar.setImsi(imsi);
                aVar.k(value);
                aVar.b(a(aVar));
                return aVar;
            }
        }
        return null;
    }

    public static a b(Context context) {
        synchronized (b.class) {
            a aVar = f7696a;
            if (aVar != null) {
                return aVar;
            }
            if (context != null) {
                a a2 = a(context);
                f7696a = a2;
                return a2;
            }
            return null;
        }
    }
}
