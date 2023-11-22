package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.a;

/* loaded from: classes8.dex */
public class SafeBundle {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f7502a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f7502a.containsKey(str);
        } catch (Exception unused) {
            a.a("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f7502a.get(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get exception: ");
            sb.append(e.getMessage());
            a.a("SafeBundle", sb.toString(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f7502a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f7502a.getString(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getString exception: ");
            sb.append(e.getMessage());
            a.a("SafeBundle", sb.toString(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f7502a.isEmpty();
        } catch (Exception unused) {
            a.a("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f7502a.size();
        } catch (Exception unused) {
            a.a("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f7502a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f7502a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i) {
        try {
            return this.f7502a.getInt(str, i);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getInt exception: ");
            sb.append(e.getMessage());
            a.a("SafeBundle", sb.toString(), true);
            return i;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f7502a.getString(str, str2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getString exception: ");
            sb.append(e.getMessage());
            a.a("SafeBundle", sb.toString(), true);
            return str2;
        }
    }
}
