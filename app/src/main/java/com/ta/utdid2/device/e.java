package com.ta.utdid2.device;

/* loaded from: classes.dex */
public class e {
    public String n(String str) {
        return com.ta.utdid2.a.a.a.k(str);
    }

    public String o(String str) {
        String k = com.ta.utdid2.a.a.a.k(str);
        if (com.ta.utdid2.a.a.e.isEmpty(k)) {
            return null;
        }
        try {
            return new String(com.ta.utdid2.a.a.b.decode(k, 0));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
