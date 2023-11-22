package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f62a;

    /* renamed from: a  reason: collision with other field name */
    private b f64a;

    /* renamed from: a  reason: collision with other field name */
    private d f65a;
    private String l;

    /* renamed from: l  reason: collision with other field name */
    private boolean f66l;
    private String m;

    /* renamed from: m  reason: collision with other field name */
    private boolean f67m;
    private Context mContext;
    private boolean n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7691o;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences.Editor f7690a = null;

    /* renamed from: a  reason: collision with other field name */
    private b.a f63a = null;

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0150 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016c A[Catch: Exception -> 0x0176, TRY_LEAVE, TryCatch #1 {Exception -> 0x0176, blocks: (B:80:0x0168, B:82:0x016c), top: B:88:0x0168 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(android.content.Context r10, java.lang.String r11, java.lang.String r12, boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.c.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    private d a(String str) {
        File m250a = m250a(str);
        if (m250a != null) {
            d dVar = new d(m250a.getAbsolutePath());
            this.f65a = dVar;
            return dVar;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m250a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        if (sharedPreferences == null || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        a2.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                a2.a(key, (String) value);
            } else if (value instanceof Integer) {
                a2.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                a2.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                a2.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                a2.a(key, ((Boolean) value).booleanValue());
            }
        }
        a2.commit();
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.clear();
        for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        edit.commit();
    }

    private boolean h() {
        b bVar = this.f64a;
        if (bVar != null) {
            boolean g = bVar.g();
            if (!g) {
                commit();
            }
            return g;
        }
        return false;
    }

    private void k() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f7690a == null && (sharedPreferences = this.f62a) != null) {
            this.f7690a = sharedPreferences.edit();
        }
        if (this.n && this.f63a == null && (bVar = this.f64a) != null) {
            this.f63a = bVar.a();
        }
        h();
    }

    public void putString(String str, String str2) {
        if (com.ta.utdid2.a.a.e.isEmpty(str) || str.equals(SecurityConstants.KEY_TEXT)) {
            return;
        }
        k();
        SharedPreferences.Editor editor = this.f7690a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f63a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) {
        if (com.ta.utdid2.a.a.e.isEmpty(str) || str.equals(SecurityConstants.KEY_TEXT)) {
            return;
        }
        k();
        SharedPreferences.Editor editor = this.f7690a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f63a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(4:3|(1:7)|8|(9:10|11|(1:15)|16|17|18|19|(4:21|(2:23|(2:25|(3:27|(1:29)(1:31)|30))(2:32|(1:36)))|37|(3:43|44|(1:46)))|49))|53|11|(2:13|15)|16|17|18|19|(0)|49) */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean commit() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r6.f7690a
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r6.f7691o
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r6.f62a
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r6.f7690a
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = 0
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r6.f62a
            if (r1 == 0) goto L31
            android.content.Context r1 = r6.mContext
            if (r1 == 0) goto L31
            java.lang.String r2 = r6.l
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r6.f62a = r1
        L31:
            r1 = 0
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L37
            goto L38
        L37:
        L38:
            boolean r2 = com.ta.utdid2.a.a.e.isEmpty(r1)
            if (r2 != 0) goto L9b
            java.lang.String r2 = "mounted"
            boolean r4 = r1.equals(r2)
            if (r4 == 0) goto L7d
            com.ta.utdid2.b.a.b r4 = r6.f64a
            if (r4 != 0) goto L72
            java.lang.String r4 = r6.m
            com.ta.utdid2.b.a.d r4 = r6.a(r4)
            if (r4 == 0) goto L7d
            java.lang.String r5 = r6.l
            com.ta.utdid2.b.a.b r4 = r4.a(r5, r3)
            r6.f64a = r4
            boolean r5 = r6.f7691o
            if (r5 != 0) goto L64
            android.content.SharedPreferences r5 = r6.f62a
            r6.a(r5, r4)
            goto L69
        L64:
            android.content.SharedPreferences r5 = r6.f62a
            r6.a(r4, r5)
        L69:
            com.ta.utdid2.b.a.b r4 = r6.f64a
            com.ta.utdid2.b.a.b$a r4 = r4.a()
            r6.f63a = r4
            goto L7d
        L72:
            com.ta.utdid2.b.a.b$a r4 = r6.f63a
            if (r4 == 0) goto L7d
            boolean r4 = r4.commit()
            if (r4 != 0) goto L7d
            r0 = 0
        L7d:
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L8f
            java.lang.String r2 = "mounted_ro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L9b
            com.ta.utdid2.b.a.b r1 = r6.f64a
            if (r1 == 0) goto L9b
        L8f:
            com.ta.utdid2.b.a.d r1 = r6.f65a     // Catch: java.lang.Exception -> L9b
            if (r1 == 0) goto L9b
            java.lang.String r2 = r6.l     // Catch: java.lang.Exception -> L9b
            com.ta.utdid2.b.a.b r1 = r1.a(r2, r3)     // Catch: java.lang.Exception -> L9b
            r6.f64a = r1     // Catch: java.lang.Exception -> L9b
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.c.commit():boolean");
    }

    public String getString(String str) {
        h();
        SharedPreferences sharedPreferences = this.f62a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!com.ta.utdid2.a.a.e.isEmpty(string)) {
                return string;
            }
        }
        b bVar = this.f64a;
        return bVar != null ? bVar.getString(str, "") : "";
    }
}
