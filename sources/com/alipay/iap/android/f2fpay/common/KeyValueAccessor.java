package com.alipay.iap.android.f2fpay.common;

import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class KeyValueAccessor {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f6955a;
    private String b;

    public KeyValueAccessor(SharedPreferences sharedPreferences, String str) {
        this.f6955a = sharedPreferences;
        this.b = str;
    }

    protected String generateKey(String str) {
        if (this.b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append("_");
            sb.append(str);
            return sb.toString();
        }
        return str;
    }

    public boolean getBoolean(String str, boolean z) {
        boolean z2;
        synchronized (this.f6955a) {
            z2 = this.f6955a.getBoolean(generateKey(str), z);
        }
        return z2;
    }

    public int getInt(String str, int i) {
        int i2;
        synchronized (this.f6955a) {
            i2 = this.f6955a.getInt(generateKey(str), i);
        }
        return i2;
    }

    public String getString(String str, String str2) {
        String string;
        synchronized (this.f6955a) {
            string = this.f6955a.getString(generateKey(str), str2);
        }
        return string;
    }

    public void save(String str, int i) {
        synchronized (this.f6955a) {
            this.f6955a.edit().putInt(generateKey(str), i).commit();
        }
    }

    public void save(String str, String str2) {
        synchronized (this.f6955a) {
            this.f6955a.edit().putString(generateKey(str), str2).commit();
        }
    }

    public void save(String str, boolean z) {
        synchronized (this.f6955a) {
            this.f6955a.edit().putBoolean(generateKey(str), z).commit();
        }
    }
}
