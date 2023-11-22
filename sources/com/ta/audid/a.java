package com.ta.audid;

import android.content.Context;
import android.text.TextUtils;
import com.ta.audid.f.d;
import com.ta.audid.f.e;
import com.ta.audid.g.m;
import java.io.File;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f7670a = new a();

    /* renamed from: a  reason: collision with other field name */
    private String f41a = "testKey";
    private String b = "";
    private Context mContext = null;

    /* renamed from: a  reason: collision with other field name */
    private com.ta.audid.b.a f39a = null;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f42a = false;

    /* renamed from: a  reason: collision with other field name */
    private File f40a = null;

    /* renamed from: b  reason: collision with other field name */
    private boolean f43b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;

    /* renamed from: a  reason: collision with other field name */
    private long f38a = 0;

    private a() {
    }

    public static a a() {
        return f7670a;
    }

    public void init() {
        synchronized (this) {
            if (!this.f42a) {
                com.ta.audid.filesync.a.a().b(this.mContext);
                this.f39a = new com.ta.audid.b.a(this.mContext, "utdid.db");
                d.a(this.mContext).start();
                this.d = com.ta.audid.d.d.h(this.mContext);
                this.e = com.ta.audid.d.d.i(this.mContext);
                this.f42a = true;
            }
        }
    }

    public void a(Context context) {
        synchronized (this) {
            if (this.mContext == null) {
                if (context == null) {
                    return;
                }
                if (context.getApplicationContext() != null) {
                    this.mContext = context.getApplicationContext();
                } else {
                    this.mContext = context;
                }
            }
        }
    }

    @Deprecated
    public void a(boolean z) {
        synchronized (this) {
            try {
                this.c = z;
                m.d("", Boolean.valueOf(z));
                if (z) {
                    d.a(this.mContext).stop();
                    com.ta.audid.filesync.a.a().c(this.mContext);
                } else {
                    com.ta.audid.filesync.a.a().b(this.mContext);
                    d.a(this.mContext).start();
                }
                if (this.f40a == null) {
                    this.f40a = new File(e.R());
                }
                boolean exists = this.f40a.exists();
                if (z && !exists) {
                    this.f40a.createNewFile();
                } else if (!z && exists) {
                    this.f40a.delete();
                }
            } catch (Exception e) {
                m.d("", e);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m236a() {
        synchronized (this) {
            try {
                if (this.f43b) {
                    m.d("", Boolean.valueOf(this.c));
                    return this.c;
                }
                try {
                    if (this.f40a == null) {
                        this.f40a = new File(e.R());
                    }
                    if (this.f40a.exists()) {
                        this.c = true;
                        m.d("", "old mode file");
                        return this.c;
                    }
                } catch (Exception e) {
                    m.d("", e);
                }
                this.f43b = true;
                this.c = false;
                m.d("", "new mode file");
                return this.c;
            } finally {
                this.f43b = true;
            }
        }
    }

    public void setDebug(boolean z) {
        m.setDebug(z);
    }

    public Context getContext() {
        return this.mContext;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.ta.audid.b.a m234a() {
        return this.f39a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f41a = str;
    }

    public String getAppkey() {
        return this.f41a;
    }

    public void setAppChannel(String str) {
        this.b = str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m235a() {
        return this.b;
    }

    public void a(long j) {
        this.f38a = j - System.currentTimeMillis();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m233a() {
        return System.currentTimeMillis() + this.f38a;
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(m233a());
        return sb.toString();
    }
}
