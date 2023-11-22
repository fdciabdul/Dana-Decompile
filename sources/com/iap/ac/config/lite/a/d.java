package com.iap.ac.config.lite.a;

/* loaded from: classes3.dex */
public class d {
    public static boolean a(int i) {
        if (i >= 0 && i <= 15) {
            return (i <= 0 || i > 4) && i < 12;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DNS Header Flag");
        sb.append(i);
        sb.append("is out of range");
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) throws Exception {
        if (j < 0 || j > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid DNS TTL: ");
            sb.append(j);
            throw new a(sb.toString());
        }
    }
}
