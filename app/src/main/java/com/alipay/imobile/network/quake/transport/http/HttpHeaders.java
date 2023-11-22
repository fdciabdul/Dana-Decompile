package com.alipay.imobile.network.quake.transport.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class HttpHeaders {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f7065a;

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f7066a = new ArrayList(20);

        private void b(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (charAt <= 31 || charAt >= 127) {
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            char charAt2 = str2.charAt(i2);
                            if (charAt2 <= 31 || charAt2 >= 127) {
                                throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("value == null");
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("name == null");
        }

        public final Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected header: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }

        public final HttpHeaders build() {
            return new HttpHeaders(this);
        }

        public final String get(String str) {
            for (int size = this.f7066a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f7066a.get(size))) {
                    return this.f7066a.get(size + 1);
                }
            }
            return null;
        }

        public final Builder removeAll(String str) {
            int i = 0;
            while (i < this.f7066a.size()) {
                if (str.equalsIgnoreCase(this.f7066a.get(i))) {
                    this.f7066a.remove(i);
                    this.f7066a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final Builder set(String str, String str2) {
            b(str, str2);
            removeAll(str);
            a(str, str2);
            return this;
        }

        final Builder a(String str, String str2) {
            this.f7066a.add(str);
            this.f7066a.add(str2.trim());
            return this;
        }

        public final Builder add(String str, String str2) {
            b(str, str2);
            return a(str, str2);
        }
    }

    public String a(int i) {
        return this.f7065a[i * 2];
    }

    public int b() {
        return this.f7065a.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b = b();
        for (int i = 0; i < b; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    private HttpHeaders(Builder builder) {
        this.f7065a = (String[]) builder.f7066a.toArray(new String[builder.f7066a.size()]);
    }

    public List<String> a(String str) {
        int b = b();
        ArrayList arrayList = null;
        for (int i = 0; i < b; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String b(int i) {
        return this.f7065a[(i * 2) + 1];
    }

    public Builder a() {
        Builder builder = new Builder();
        Collections.addAll(builder.f7066a, this.f7065a);
        return builder;
    }
}
