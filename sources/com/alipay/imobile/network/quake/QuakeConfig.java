package com.alipay.imobile.network.quake;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.transport.TrafficFlowMonitor;
import com.alipay.imobile.network.quake.transport.http.CookieJar;
import com.alipay.imobile.network.quake.transport.http.JavaNetCookieJar;
import com.alipay.imobile.network.quake.transport.strategy.DefaultRetryPolicy;
import com.alipay.imobile.network.quake.transport.strategy.RetryPolicy;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class QuakeConfig {

    /* renamed from: a  reason: collision with root package name */
    private String f7028a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private String g;
    private String h;
    private String i;
    private int j;
    private CookieJar k;
    private TrafficFlowMonitor l;
    private Map<String, String> m;
    private CookieManager n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends CookieHandler {
        a() {
        }

        @Override // java.net.CookieHandler
        public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
            if (uri == null) {
                return null;
            }
            String cookie = QuakeConfig.this.n.getCookie(uri.toString());
            if (TextUtils.isEmpty(cookie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(cookie);
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", arrayList);
            return hashMap;
        }

        @Override // java.net.CookieHandler
        public void put(URI uri, Map<String, List<String>> map) throws IOException {
            if (uri == null || map == null || map.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<String> it2 = it.next().getValue().iterator();
                while (it2.hasNext()) {
                    QuakeConfig.this.n.setCookie(uri.toString(), it2.next());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                QuakeConfig.this.n.flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
        }
    }

    public QuakeConfig(QuakeConfig quakeConfig) {
        this(quakeConfig.f7028a, quakeConfig.b, quakeConfig.c, quakeConfig.d, quakeConfig.j);
    }

    private void b() {
        this.k = new JavaNetCookieJar(new java.net.CookieManager());
    }

    public QuakeConfig cookieJar(CookieJar cookieJar) {
        this.k = cookieJar;
        return this;
    }

    public String getAppId() {
        return this.f7028a;
    }

    public String getAppKeyForSecurityGuard() {
        return this.b;
    }

    public String getAuthCodeForSecurityGuard() {
        return this.c;
    }

    public int getConcurrentRequestNumber() {
        return this.j;
    }

    public CookieJar getCookieJar() {
        return this.k;
    }

    public Map<String, String> getExternalInfo() {
        return this.m;
    }

    public String getGwUrl() {
        return this.d;
    }

    public RetryPolicy getRetryPolicy() {
        return new DefaultRetryPolicy(this.e, this.f, 1.0f);
    }

    public String getTenantId() {
        return this.i;
    }

    public TrafficFlowMonitor getTrafficFlowMonitor() {
        return this.l;
    }

    public String getVersion() {
        return this.g;
    }

    public String getWorkspaceId() {
        return this.h;
    }

    public void setAppId(String str) {
        this.f7028a = str;
    }

    public void setAppKeyForSecurityGuard(String str) {
        String str2 = Quake.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("set app key=");
        sb.append(str);
        LoggerWrapper.d(str2, sb.toString());
        this.b = str;
    }

    public void setAuthCodeForSecurityGuard(String str) {
        String str2 = Quake.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("set auth code=");
        sb.append(str);
        LoggerWrapper.d(str2, sb.toString());
        this.c = str;
    }

    public void setConcurrentRequestNumber(int i) {
        this.j = i;
    }

    public void setExternalInfo(Map<String, String> map) {
        this.m = map;
    }

    public void setGateWayUrl(String str) {
        String str2 = Quake.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("set gateway url=");
        sb.append(str);
        LoggerWrapper.d(str2, sb.toString());
        this.d = str;
    }

    public void setNumRetries(int i) {
        this.f = i;
    }

    public void setTenantId(String str) {
        this.i = str;
    }

    public void setTimeoutMs(int i) {
        this.e = i;
    }

    public void setVersion(String str) {
        this.g = str;
    }

    public void setWorkspaceId(String str) {
        this.h = str;
    }

    public QuakeConfig trafficFlowMonitor(TrafficFlowMonitor trafficFlowMonitor) {
        this.l = trafficFlowMonitor;
        return this;
    }

    public QuakeConfig(String str, String str2) {
        this(str, "", str2, 4);
    }

    private void a() {
        this.n = CookieManager.getInstance();
        this.k = new JavaNetCookieJar(new a());
    }

    public QuakeConfig(String str, String str2, String str3) {
        this(str, str2, str3, 4);
    }

    public QuakeConfig(String str, String str2, String str3, int i) {
        this(str, str2, "", str3, i);
    }

    public QuakeConfig(String str, String str2, String str3, String str4, int i) {
        this.e = 10000;
        this.f = 0;
        this.f7028a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.j = i;
        this.l = null;
        try {
            a();
        } catch (Throwable th) {
            LoggerWrapper.e(Quake.TAG, "buildDefaultCookieJar error", th);
            b();
        }
    }
}
