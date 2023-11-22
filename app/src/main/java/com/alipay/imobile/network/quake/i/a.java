package com.alipay.imobile.network.quake.i;

/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final String f7052a;
    private final String b;

    public a(String str, String str2) {
        if (str != null) {
            this.f7052a = str;
            this.b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    private static int a(int i, int i2) {
        return (i * 37) + i2;
    }

    public String a() {
        return this.f7052a;
    }

    public String b() {
        return this.b;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f7052a.equals(aVar.f7052a)) {
                String str = this.b;
                String str2 = aVar.b;
                if (str == null) {
                    if (str2 != null) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return a(a(17, this.f7052a), this.b);
    }

    public String toString() {
        int length = this.f7052a.length();
        String str = this.b;
        if (str != null) {
            length += str.length() + 1;
        }
        b bVar = new b(length);
        bVar.a(this.f7052a);
        if (this.b != null) {
            bVar.a("=");
            bVar.a(this.b);
        }
        return bVar.toString();
    }

    public static int a(int i, Object obj) {
        return a(i, obj != null ? obj.hashCode() : 0);
    }
}
