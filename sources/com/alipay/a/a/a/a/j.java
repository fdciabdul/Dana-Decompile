package com.alipay.a.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* loaded from: classes3.dex */
public final class j extends o {

    /* renamed from: a  reason: collision with root package name */
    String f6835a;
    byte[] b;
    boolean e;
    ArrayList<Header> d = new ArrayList<>();
    private Map<String, String> h = new HashMap();
    String c = "application/x-www-form-urlencoded";

    public j(String str) {
        this.f6835a = str;
    }

    public final void a(Header header) {
        this.d.add(header);
    }

    public final void a(String str, String str2) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.h.put(str, str2);
    }

    public final String a(String str) {
        Map<String, String> map = this.h;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final int hashCode() {
        Map<String, String> map = this.h;
        int hashCode = (map == null || !map.containsKey("id")) ? 1 : this.h.get("id").hashCode() + 31;
        String str = this.f6835a;
        return (hashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            j jVar = (j) obj;
            byte[] bArr = this.b;
            if (bArr == null) {
                if (jVar.b != null) {
                    return false;
                }
            } else if (!bArr.equals(jVar.b)) {
                return false;
            }
            String str = this.f6835a;
            if (str == null) {
                if (jVar.f6835a != null) {
                    return false;
                }
            } else if (!str.equals(jVar.f6835a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f6835a, this.d);
    }
}
