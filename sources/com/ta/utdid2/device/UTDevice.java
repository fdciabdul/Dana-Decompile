package com.ta.utdid2.device;

import android.content.Context;

/* loaded from: classes.dex */
public class UTDevice {
    @Deprecated
    public static String getUtdid(Context context) {
        if (context == null) {
            return "ffffffffffffffffffffffff";
        }
        com.ta.audid.a.a().a(context);
        if (com.ta.audid.a.a().m236a()) {
            return v(context);
        }
        com.ta.audid.a.a().init();
        return com.ta.audid.c.a.a().getUtdid();
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        if (context == null) {
            return "ffffffffffffffffffffffff";
        }
        com.ta.audid.a.a().a(context);
        if (com.ta.audid.a.a().m236a()) {
            return w(context);
        }
        com.ta.audid.a.a().init();
        return com.ta.audid.c.a.a().C();
    }

    private static String v(Context context) {
        a b = b.b(context);
        return (b == null || com.ta.utdid2.a.a.e.isEmpty(b.getUtdid())) ? "ffffffffffffffffffffffff" : b.getUtdid();
    }

    private static String w(Context context) {
        String ad = c.a(context).ad();
        return (ad == null || com.ta.utdid2.a.a.e.isEmpty(ad)) ? "ffffffffffffffffffffffff" : ad;
    }
}
