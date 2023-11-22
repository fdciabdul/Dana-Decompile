package com.ta.audid.d;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f7674a;

    /* loaded from: classes.dex */
    static class b {
        public int a(Context context, String str, String str2) {
            return 1;
        }

        public String permissionToOp(String str) {
            return null;
        }

        private b() {
        }
    }

    /* renamed from: com.ta.audid.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0148a extends b {
        private C0148a() {
            super();
        }

        @Override // com.ta.audid.d.a.b
        public String permissionToOp(String str) {
            return com.ta.audid.d.b.permissionToOp(str);
        }

        @Override // com.ta.audid.d.a.b
        public int a(Context context, String str, String str2) {
            return com.ta.audid.d.b.a(context, str, str2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f7674a = new C0148a();
        } else {
            f7674a = new b();
        }
    }

    public static String permissionToOp(String str) {
        return f7674a.permissionToOp(str);
    }

    public static int a(Context context, String str, String str2) {
        return f7674a.a(context, str, str2);
    }
}
