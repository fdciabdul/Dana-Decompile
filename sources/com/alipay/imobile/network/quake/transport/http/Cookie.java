package com.alipay.imobile.network.quake.transport.http;

import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.imobile.network.quake.transport.HttpDate;
import com.alipay.imobile.network.quake.util.b;
import com.alipay.imobile.network.quake.util.e;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes3.dex */
public final class Cookie {
    private static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f7063a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        String f7064a;
        String b;
        String d;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        long c = 253402300799999L;
        String e = "/";

        private Builder a(String str, boolean z) {
            if (str != null) {
                String c = e.c(str);
                if (c != null) {
                    this.d = c;
                    this.i = z;
                    return this;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected domain: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new IllegalArgumentException("domain == null");
        }

        public final Cookie build() {
            return new Cookie(this);
        }

        public final Builder domain(String str) {
            return a(str, false);
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > 253402300799999L) {
                j = 253402300799999L;
            }
            this.c = j;
            this.h = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            return a(str, true);
        }

        public final Builder httpOnly() {
            this.g = true;
            return this;
        }

        public final Builder name(String str) {
            if (str != null) {
                if (str.trim().equals(str)) {
                    this.f7064a = str;
                    return this;
                }
                throw new IllegalArgumentException("name is not trimmed");
            }
            throw new NullPointerException("name == null");
        }

        public final Builder path(String str) {
            if (str.startsWith("/")) {
                this.e = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public final Builder secure() {
            this.f = true;
            return this;
        }

        public final Builder value(String str) {
            if (str != null) {
                if (str.trim().equals(str)) {
                    this.b = str;
                    return this;
                }
                throw new IllegalArgumentException("value is not trimmed");
            }
            throw new NullPointerException("value == null");
        }
    }

    private static boolean a(URL url, String str) {
        String host = url.getHost();
        if (host.equals(str)) {
            return true;
        }
        return host.endsWith(str) && host.charAt((host.length() - str.length()) - 1) == '.' && !b.a(host);
    }

    private static boolean b(URL url, String str) {
        String path = url.getPath();
        if (path.equals(str)) {
            return true;
        }
        if (path.startsWith(str)) {
            return str.endsWith("/") || path.charAt(str.length()) == '/';
        }
        return false;
    }

    public static Cookie parse(URL url, String str) {
        return a(System.currentTimeMillis(), url, str);
    }

    public static List<Cookie> parseAll(URL url, List<String> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(url, list.get(i));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public final String domain() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return cookie.f7063a.equals(this.f7063a) && cookie.b.equals(this.b) && cookie.d.equals(this.d) && cookie.e.equals(this.e) && cookie.c == this.c && cookie.f == this.f && cookie.g == this.g && cookie.h == this.h && cookie.i == this.i;
        }
        return false;
    }

    public final long expiresAt() {
        return this.c;
    }

    public final int hashCode() {
        int hashCode = this.f7063a.hashCode();
        int hashCode2 = this.b.hashCode();
        int hashCode3 = this.d.hashCode();
        int hashCode4 = this.e.hashCode();
        long j2 = this.c;
        return ((((((((((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    public final boolean hostOnly() {
        return this.i;
    }

    public final boolean httpOnly() {
        return this.g;
    }

    public final boolean matches(URL url) {
        boolean a2;
        if (this.i) {
            a2 = url.getHost().equals(this.d);
        } else {
            a2 = a(url, this.d);
        }
        if (a2 && b(url, this.e)) {
            return !this.f || "https".equals(url.getProtocol());
        }
        return false;
    }

    public final String name() {
        return this.f7063a;
    }

    public final String path() {
        return this.e;
    }

    public final boolean persistent() {
        return this.h;
    }

    public final boolean secure() {
        return this.f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7063a);
        sb.append('=');
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public final String value() {
        return this.b;
    }

    private Cookie(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f7063a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.i = z3;
        this.h = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.alipay.imobile.network.quake.transport.http.Cookie a(long r23, java.net.URL r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.transport.http.Cookie.a(long, java.net.URL, java.lang.String):com.alipay.imobile.network.quake.transport.http.Cookie");
    }

    private static long b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                return parseLong;
            }
            return Long.MIN_VALUE;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (str.startsWith("-")) {
                    return Long.MIN_VALUE;
                }
                return LongCompanionObject.MAX_VALUE;
            }
            throw e;
        }
    }

    private Cookie(Builder builder) {
        String str = builder.f7064a;
        if (str != null) {
            String str2 = builder.b;
            if (str2 != null) {
                String str3 = builder.d;
                if (str3 != null) {
                    this.f7063a = str;
                    this.b = str2;
                    this.c = builder.c;
                    this.d = str3;
                    this.e = builder.e;
                    this.f = builder.f;
                    this.g = builder.g;
                    this.h = builder.h;
                    this.i = builder.i;
                    return;
                }
                throw new IllegalArgumentException("builder.domain == null");
            }
            throw new IllegalArgumentException("builder.value == null");
        }
        throw new IllegalArgumentException("builder.name == null");
    }

    private static long a(String str, int i, int i2) {
        int a2 = a(str, i, i2, false);
        Matcher matcher = m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a2 < i2) {
            int a3 = a(str, a2 + 1, i2, true);
            matcher.region(a2, a3);
            if (i4 == -1 && matcher.usePattern(m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    Pattern pattern = k;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(j).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            a2 = a(str, a3 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += SecExceptionCode.SEC_ERROR_AVMP;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 >= 1601) {
            if (i6 != -1) {
                if (i5 <= 0 || i5 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 0 || i4 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i7 < 0 || i7 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i8 >= 0 && i8 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(e.f7080a);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i3);
                    gregorianCalendar.set(2, i6 - 1);
                    gregorianCalendar.set(5, i5);
                    gregorianCalendar.set(11, i4);
                    gregorianCalendar.set(12, i7);
                    gregorianCalendar.set(13, i8);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static String a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String c = e.c(str);
            if (c != null) {
                return c;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }
}
