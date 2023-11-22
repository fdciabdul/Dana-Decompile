package com.alipay.imobile.network.quake.transport.http;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.transport.http.Cookie;
import com.alipay.imobile.network.quake.util.e;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class JavaNetCookieJar implements CookieJar {

    /* renamed from: a  reason: collision with root package name */
    private final CookieHandler f7070a;

    public JavaNetCookieJar(CookieHandler cookieHandler) {
        this.f7070a = cookieHandler;
    }

    private List<Cookie> a(URL url, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int a2 = e.a(str, i, length, ";,");
            int a3 = e.a(str, i, a2, '=');
            String c = e.c(str, i, a3);
            if (!c.startsWith("$")) {
                String c2 = a3 < a2 ? e.c(str, a3 + 1, a2) : "";
                if (c2.startsWith("\"") && c2.endsWith("\"")) {
                    c2 = c2.substring(1, c2.length() - 1);
                }
                arrayList.add(new Cookie.Builder().name(c).value(c2).domain(url.getHost()).build());
            }
            i = a2 + 1;
        }
        return arrayList;
    }

    @Override // com.alipay.imobile.network.quake.transport.http.CookieJar
    public final List<Cookie> loadForRequest(URL url) {
        String str = Quake.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("load cookie for url=");
        sb.append(url.toString());
        LoggerWrapper.d(str, sb.toString());
        try {
            Map<String, List<String>> map = this.f7070a.get(url.toURI(), Collections.emptyMap());
            ArrayList arrayList = null;
            if (map == null) {
                return Collections.emptyList();
            }
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key) || "Set-Cookie".equalsIgnoreCase(key) || com.google.common.net.HttpHeaders.SET_COOKIE2.equalsIgnoreCase(key)) {
                    if (!entry.getValue().isEmpty()) {
                        for (String str2 : entry.getValue()) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.addAll(a(url, str2));
                        }
                    }
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        } catch (IOException | URISyntaxException e) {
            String str3 = Quake.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Loading cookies failed for ");
            sb2.append(url.toString());
            LoggerWrapper.w(str3, sb2.toString(), e);
            return Collections.emptyList();
        }
    }

    @Override // com.alipay.imobile.network.quake.transport.http.CookieJar
    public final void saveFromResponse(URL url, List<Cookie> list) {
        String str = Quake.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("save cookie for url=");
        sb.append(url.toString());
        LoggerWrapper.d(str, sb.toString());
        if (this.f7070a != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Cookie> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            try {
                this.f7070a.put(url.toURI(), Collections.singletonMap("Set-cookie", arrayList));
            } catch (IOException | URISyntaxException e) {
                String str2 = Quake.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Saving cookies failed for ");
                sb2.append(url.toString());
                LoggerWrapper.w(str2, sb2.toString(), e);
            }
        }
    }
}
