package com.apiguard3.url_matcher;

import android.text.TextUtils;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.readResolve;
import java.io.Serializable;
import kotlin.text.Typography;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class UrlMatcherConfig implements Serializable {
    private static int analyzeResponse = 1;
    private static int getRequestHeaders = 0;
    private static long parseResponseHeaders = 1809778141080297885L;
    private static final long serialVersionUID = -4792909588470935642L;
    private transient MatchesConfig AGState;
    private transient MatchesConfig APIGuard;
    private String domainStr;
    private transient MatchesConfig getSharedInstance;
    private String pathStr;
    private String portStr;
    private String queryStr;
    private String schemeStr;
    private transient MatchesConfig valueOf;
    private transient MatchesConfig values;

    UrlMatcherConfig() {
    }

    public UrlMatcherConfig(UrlMatcher urlMatcher) {
        this.schemeStr = urlMatcher.values();
        this.domainStr = urlMatcher.APIGuard();
        this.portStr = urlMatcher.valueOf();
        this.pathStr = urlMatcher.AGState();
        this.queryStr = urlMatcher.getSharedInstance();
        this.values = valueOf();
        this.getSharedInstance = AGState();
        this.AGState = values();
        this.APIGuard = APIGuard();
        this.valueOf = getSharedInstance();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            getRequestHeaders = (analyzeResponse + 93) % 128;
            return true;
        }
        if ((obj != null) && getClass() == obj.getClass()) {
            UrlMatcherConfig urlMatcherConfig = (UrlMatcherConfig) obj;
            if ((TextUtils.equals(this.schemeStr, urlMatcherConfig.schemeStr) ? 'V' : 'B') == 'V') {
                getRequestHeaders = (analyzeResponse + 107) % 128;
                if (TextUtils.equals(this.domainStr, urlMatcherConfig.domainStr) && (!TextUtils.equals(this.portStr, urlMatcherConfig.portStr)) != true && TextUtils.equals(this.pathStr, urlMatcherConfig.pathStr)) {
                    int i = getRequestHeaders + 89;
                    analyzeResponse = i % 128;
                    if (i % 2 == 0) {
                        TextUtils.equals(this.queryStr, urlMatcherConfig.queryStr);
                        throw null;
                    } else if (TextUtils.equals(this.queryStr, urlMatcherConfig.queryStr)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if ((r9.schemeStr == null ? 29 : '%') != 29) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int hashCode() {
        /*
            r9 = this;
            int r0 = com.apiguard3.url_matcher.UrlMatcherConfig.getRequestHeaders
            int r0 = r0 + 101
            int r1 = r0 % 128
            com.apiguard3.url_matcher.UrlMatcherConfig.analyzeResponse = r1
            int r0 = r0 % 2
            r1 = 27105(0x69e1, float:3.7982E-41)
            r2 = 527(0x20f, float:7.38E-43)
            r3 = 0
            if (r0 != 0) goto L1f
            java.lang.String r0 = r9.schemeStr
            r2 = 29
            if (r0 != 0) goto L1a
            r0 = 29
            goto L1c
        L1a:
            r0 = 37
        L1c:
            if (r0 == r2) goto L2e
            goto L32
        L1f:
            java.lang.String r0 = r9.schemeStr
            r1 = 27
            if (r0 != 0) goto L28
            r0 = 68
            goto L2a
        L28:
            r0 = 27
        L2a:
            if (r0 == r1) goto L30
            r1 = 527(0x20f, float:7.38E-43)
        L2e:
            r0 = 0
            goto L38
        L30:
            r1 = 527(0x20f, float:7.38E-43)
        L32:
            java.lang.String r0 = r9.schemeStr
            int r0 = r0.hashCode()
        L38:
            java.lang.String r2 = r9.domainStr
            r4 = 1
            if (r2 != 0) goto L3f
            r5 = 1
            goto L41
        L3f:
            r5 = 48
        L41:
            if (r5 == r4) goto L48
            int r2 = r2.hashCode()
            goto L49
        L48:
            r2 = 0
        L49:
            java.lang.String r5 = r9.portStr
            if (r5 != 0) goto L4f
            r6 = 1
            goto L50
        L4f:
            r6 = 0
        L50:
            if (r6 == r4) goto L57
            int r5 = r5.hashCode()
            goto L58
        L57:
            r5 = 0
        L58:
            java.lang.String r6 = r9.pathStr
            r7 = 11
            if (r6 != 0) goto L61
            r8 = 11
            goto L63
        L61:
            r8 = 23
        L63:
            if (r8 == r7) goto L72
            int r4 = r6.hashCode()
            int r6 = com.apiguard3.url_matcher.UrlMatcherConfig.analyzeResponse
            int r6 = r6 + 5
            int r6 = r6 % 128
            com.apiguard3.url_matcher.UrlMatcherConfig.getRequestHeaders = r6
            goto L7a
        L72:
            int r6 = com.apiguard3.url_matcher.UrlMatcherConfig.analyzeResponse
            int r6 = r6 + r4
            int r6 = r6 % 128
            com.apiguard3.url_matcher.UrlMatcherConfig.getRequestHeaders = r6
            r4 = 0
        L7a:
            java.lang.String r6 = r9.queryStr
            if (r6 == 0) goto L82
            int r3 = r6.hashCode()
        L82:
            int r1 = r1 + r0
            int r1 = r1 * 31
            int r1 = r1 + r2
            int r1 = r1 * 31
            int r1 = r1 + r5
            int r1 = r1 * 31
            int r1 = r1 + r4
            int r1 = r1 * 31
            int r1 = r1 + r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.url_matcher.UrlMatcherConfig.hashCode():int");
    }

    public MatchesConfig valueOf() {
        int i = analyzeResponse;
        getRequestHeaders = (i + 99) % 128;
        MatchesConfig matchesConfig = this.values;
        if ((matchesConfig == null ? 'S' : '*') != 'S') {
            getRequestHeaders = (i + 25) % 128;
            return matchesConfig;
        }
        int i2 = i + 107;
        getRequestHeaders = i2 % 128;
        if (i2 % 2 == 0) {
            return APIGuard(this.schemeStr);
        }
        APIGuard(this.schemeStr);
        throw new ArithmeticException();
    }

    public MatchesConfig AGState() {
        int i = getRequestHeaders;
        analyzeResponse = (i + 125) % 128;
        MatchesConfig matchesConfig = this.getSharedInstance;
        if ((matchesConfig == null ? (char) 19 : 'Y') == 19) {
            analyzeResponse = (i + 19) % 128;
            return APIGuard(this.domainStr);
        }
        int i2 = i + 97;
        analyzeResponse = i2 % 128;
        if ((i2 % 2 == 0 ? '0' : (char) 16) != '0') {
            return matchesConfig;
        }
        throw new ArithmeticException();
    }

    public MatchesConfig values() {
        int i = (analyzeResponse + 73) % 128;
        getRequestHeaders = i;
        MatchesConfig matchesConfig = this.AGState;
        if (!(matchesConfig != null)) {
            return APIGuard(this.portStr);
        }
        int i2 = i + 25;
        analyzeResponse = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.greater : (char) 27) == 27) {
            return matchesConfig;
        }
        throw new ArithmeticException();
    }

    public MatchesConfig APIGuard() {
        MatchesConfig matchesConfig = this.APIGuard;
        if (matchesConfig != null) {
            int i = getRequestHeaders + 19;
            analyzeResponse = i % 128;
            if (i % 2 != 0) {
                return matchesConfig;
            }
            throw new ArithmeticException();
        }
        int i2 = analyzeResponse + 55;
        getRequestHeaders = i2 % 128;
        if ((i2 % 2 != 0 ? '?' : '\b') == '\b') {
            return APIGuard(this.pathStr);
        }
        APIGuard(this.pathStr);
        throw null;
    }

    public MatchesConfig getSharedInstance() {
        int i = (getRequestHeaders + 23) % 128;
        analyzeResponse = i;
        MatchesConfig matchesConfig = this.valueOf;
        if (matchesConfig != null) {
            return matchesConfig;
        }
        int i2 = i + 91;
        getRequestHeaders = i2 % 128;
        if ((i2 % 2 != 0 ? '=' : ';') == ';') {
            MatchesConfig APIGuard = APIGuard(this.queryStr);
            getRequestHeaders = (analyzeResponse + 63) % 128;
            return APIGuard;
        }
        APIGuard(this.queryStr);
        throw null;
    }

    public UrlMatcherConfig parseResponseHeaders() {
        UrlMatcherConfig urlMatcherConfig = new UrlMatcherConfig();
        urlMatcherConfig.schemeStr = this.schemeStr;
        urlMatcherConfig.domainStr = this.domainStr;
        urlMatcherConfig.portStr = this.portStr;
        urlMatcherConfig.pathStr = this.pathStr;
        urlMatcherConfig.queryStr = this.queryStr;
        analyzeResponse = (getRequestHeaders + 21) % 128;
        return urlMatcherConfig;
    }

    MatchesConfig APIGuard(String str) {
        if (!(str == null)) {
            int i = getRequestHeaders + 125;
            analyzeResponse = i % 128;
            if (i % 2 == 0) {
                throw null;
            }
            try {
                if (!str.isEmpty()) {
                    try {
                        MatchesConfig matchesConfig = new MatchesConfig(new JSONArray(str));
                        getRequestHeaders = (analyzeResponse + 37) % 128;
                        return matchesConfig;
                    } catch (Exception unused) {
                        ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.APIGuard;
                        Object[] objArr = new Object[1];
                        APIGuard("\ue779\ue73c籩肳槏\udd86쏻起慿员䥪ˬ\uebf8튀탴顐瑆䣢噀ᆝﻝ읭\uddd7霏䜝㷥掬\ueca0솢둔\ue924戳䩵㋃為ﮢ풿ꤽ\uf60e", -TextUtils.lastIndexOf("", '0'), objArr);
                        readResolve.values(valuesVar, ((String) objArr[0]).intern());
                        return new MatchesConfig(null);
                    }
                }
            } catch (Throwable unused2) {
                return new MatchesConfig(null);
            }
        }
        return new MatchesConfig();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r8 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void APIGuard(java.lang.String r8, int r9, java.lang.Object[] r10) {
        /*
            if (r8 == 0) goto L6
            char[] r8 = r8.toCharArray()
        L6:
            char[] r8 = (char[]) r8
            java.lang.Object r0 = com.apiguard3.internal.setForegroundTintBlendMode.getSharedInstance
            monitor-enter(r0)
            long r1 = com.apiguard3.url_matcher.UrlMatcherConfig.parseResponseHeaders     // Catch: java.lang.Throwable -> L4a
            char[] r8 = com.apiguard3.internal.setForegroundTintBlendMode.APIGuard(r1, r8, r9)     // Catch: java.lang.Throwable -> L4a
            r9 = 4
            com.apiguard3.internal.setForegroundTintBlendMode.valueOf = r9     // Catch: java.lang.Throwable -> L4a
        L14:
            int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
            int r2 = r8.length     // Catch: java.lang.Throwable -> L4a
            if (r1 >= r2) goto L3e
            int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
            int r1 = r1 - r9
            com.apiguard3.internal.setForegroundTintBlendMode.APIGuard = r1     // Catch: java.lang.Throwable -> L4a
            int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
            int r2 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
            char r2 = r8[r2]     // Catch: java.lang.Throwable -> L4a
            int r3 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
            int r3 = r3 % r9
            char r3 = r8[r3]     // Catch: java.lang.Throwable -> L4a
            r2 = r2 ^ r3
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L4a
            int r4 = com.apiguard3.internal.setForegroundTintBlendMode.APIGuard     // Catch: java.lang.Throwable -> L4a
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L4a
            long r6 = com.apiguard3.url_matcher.UrlMatcherConfig.parseResponseHeaders     // Catch: java.lang.Throwable -> L4a
            long r4 = r4 * r6
            long r2 = r2 ^ r4
            int r3 = (int) r2     // Catch: java.lang.Throwable -> L4a
            char r2 = (char) r3     // Catch: java.lang.Throwable -> L4a
            r8[r1] = r2     // Catch: java.lang.Throwable -> L4a
            int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
            int r1 = r1 + 1
            com.apiguard3.internal.setForegroundTintBlendMode.valueOf = r1     // Catch: java.lang.Throwable -> L4a
            goto L14
        L3e:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L4a
            int r2 = r8.length     // Catch: java.lang.Throwable -> L4a
            int r2 = r2 - r9
            r1.<init>(r8, r9, r2)     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            r10[r8] = r1
            return
        L4a:
            r8 = move-exception
            monitor-exit(r0)
            goto L4e
        L4d:
            throw r8
        L4e:
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.url_matcher.UrlMatcherConfig.APIGuard(java.lang.String, int, java.lang.Object[]):void");
    }
}
