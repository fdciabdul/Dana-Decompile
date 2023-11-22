package com.alipay.imobile.network.quake.transport.http;

import java.net.URL;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new a();

    /* loaded from: classes3.dex */
    class a implements CookieJar {
        a() {
        }

        @Override // com.alipay.imobile.network.quake.transport.http.CookieJar
        public List<Cookie> loadForRequest(URL url) {
            return Collections.emptyList();
        }

        @Override // com.alipay.imobile.network.quake.transport.http.CookieJar
        public void saveFromResponse(URL url, List<Cookie> list) {
        }
    }

    List<Cookie> loadForRequest(URL url);

    void saveFromResponse(URL url, List<Cookie> list);
}
