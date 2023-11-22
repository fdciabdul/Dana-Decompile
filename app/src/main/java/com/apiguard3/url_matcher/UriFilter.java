package com.apiguard3.url_matcher;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.writeReplace;
import com.apiguard3.url_matcher.MatchConfig;
import com.apiguard3.url_matcher.MatchesConfig;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class UriFilter implements Serializable {
    public static final String AGState;
    private static int APIGuard = 1;
    private static final long serialVersionUID = -2530827875991961122L;
    private static long valueOf;
    private static int values;
    private final List<UrlMatcherConfig> matchers;

    static {
        valueOf();
        Object[] objArr = new Object[1];
        values("\ue1f4䮚뗇ὥ䤩닯᳷䚕끋ᨦ䟸놺ᯁ䔜꽓ᢴ䊄갪ᙨ䁌궋៴䅴ꬾᔞ绠ꢔቨ簢ꧽᏊ緖꜍ᅠ窥ꓫ\u0edb硝ꉱ\u0fe1秧ꎯഝ眕", 43573 - TextUtils.getOffsetBefore("", 0), objArr);
        AGState = ((String) objArr[0]).intern();
        APIGuard = (values + 79) % 128;
    }

    static void valueOf() {
        valueOf = 1470597669494972815L;
    }

    public UriFilter() {
        this.matchers = new ArrayList();
    }

    public UriFilter(JSONArray jSONArray) {
        this();
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                this.matchers.add(new UrlMatcherConfig(new UrlMatcher(optJSONObject)));
            }
        }
    }

    public boolean equals(Object obj) {
        int i = APIGuard;
        int i2 = i + 71;
        values = i2 % 128;
        if (i2 % 2 != 0) {
            throw new NullPointerException();
        } else if (this == obj) {
            return true;
        } else {
            if (!(obj == null)) {
                values = (i + 69) % 128;
                if ((getClass() != obj.getClass() ? '%' : '0') != '%') {
                    return this.matchers.equals(((UriFilter) obj).matchers);
                }
            }
            int i3 = APIGuard + 81;
            values = i3 % 128;
            if ((i3 % 2 != 0 ? 'Z' : '7') == '7') {
                return false;
            }
            throw null;
        }
    }

    public int hashCode() {
        int i = APIGuard + 109;
        values = i % 128;
        int hashCode = i % 2 != 0 ? 30526 >> this.matchers.hashCode() : this.matchers.hashCode() + 527;
        values = (APIGuard + 17) % 128;
        return hashCode;
    }

    public boolean APIGuard() {
        APIGuard = (values + 81) % 128;
        if ((this.matchers.size() != 0 ? '\f' : 'R') != '\f') {
            APIGuard = (values + 49) % 128;
            return false;
        }
        int i = APIGuard + 59;
        values = i % 128;
        return !(i % 2 != 0);
    }

    public boolean APIGuard(URL url) {
        if (url == null) {
            return false;
        }
        Iterator<UrlMatcherConfig> it = this.matchers.iterator();
        while ((!it.hasNext()) != true) {
            int i = values + 13;
            APIGuard = i % 128;
            if (!(i % 2 == 0)) {
                if (APIGuard(url, it.next()).booleanValue()) {
                    return true;
                }
            } else {
                APIGuard(url, it.next());
                throw new NullPointerException();
            }
        }
        APIGuard = (values + 41) % 128;
        return false;
    }

    public UriFilter AGState() {
        UriFilter uriFilter = new UriFilter();
        Iterator<UrlMatcherConfig> it = this.matchers.iterator();
        APIGuard = (values + 99) % 128;
        while (true) {
            if ((it.hasNext() ? '4' : Typography.quote) == '\"') {
                return uriFilter;
            }
            int i = values + 25;
            APIGuard = i % 128;
            if ((i % 2 == 0 ? 'C' : (char) 2) == 2) {
                uriFilter.AGState(it.next().parseResponseHeaders());
            } else {
                uriFilter.AGState(it.next().parseResponseHeaders());
                throw new ArithmeticException();
            }
        }
    }

    public void AGState(UrlMatcherConfig urlMatcherConfig) {
        values = (APIGuard + 107) % 128;
        this.matchers.add(urlMatcherConfig);
        values = (APIGuard + 119) % 128;
    }

    public static UriFilter values() {
        try {
            Object[] objArr = new Object[1];
            values("\ue1f4䮚뗇ὥ䤩닯᳷䚕끋ᨦ䟸놺ᯁ䔜꽓ᢴ䊄갪ᙨ䁌궋៴䅴ꬾᔞ绠ꢔቨ簢ꧽᏊ緖꜍ᅠ窥ꓫ\u0edb硝ꉱ\u0fe1秧ꎯഝ眕", MotionEvent.axisFromString("") + 43574, objArr);
            JSONObject jSONObject = new JSONObject(((String) objArr[0]).intern());
            Object[] objArr2 = new Object[1];
            values("\ue1faદ㝐⏘䲊礤旙躗묥ꞎ", 60251 - Gravity.getAbsoluteGravity(0, 0), objArr2);
            UriFilter uriFilter = new UriFilter(jSONObject.optJSONArray(((String) objArr2[0]).intern()));
            int i = values + 31;
            APIGuard = i % 128;
            if ((i % 2 == 0 ? '\t' : '9') != '\t') {
                return uriFilter;
            }
            throw new ArithmeticException();
        } catch (JSONException unused) {
            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.APIGuard;
            Object[] objArr3 = new Object[1];
            values("\ue1ca⥺烶롍쏋\u0b3a动騻ꖉ\ued5a㑺翨蝺컊ᙜ⇬椼날\uf800Ι䫿鉷\uddff\ue543ⲗ琫뿽윴ຆ嘐慨꣩\uf043㯖䌕誽툩ᶇ┧沝럫ｮۈ乒馁", View.resolveSizeAndState(0, 0, 0) + 51341, objArr3);
            readResolve.values(valuesVar, ((String) objArr3[0]).intern());
            return null;
        }
    }

    static Boolean APIGuard(URL url, UrlMatcherConfig urlMatcherConfig) {
        boolean z;
        MatchesConfig valueOf2 = urlMatcherConfig.valueOf();
        if (AGState(urlMatcherConfig.AGState(), url.getHost()).booleanValue()) {
            if ((AGState(urlMatcherConfig.APIGuard(), url.getPath()).booleanValue() ? '-' : '7') != '7') {
                values = (APIGuard + 9) % 128;
                if ((AGState(urlMatcherConfig.getSharedInstance(), url.getQuery()).booleanValue() ? '1' : '\n') != '\n') {
                    int i = values + 15;
                    APIGuard = i % 128;
                    char c = i % 2 == 0 ? 'S' : '=';
                    Boolean AGState2 = AGState(valueOf2, url.getProtocol());
                    if (c == 'S') {
                        throw null;
                    } else if (AGState2.booleanValue()) {
                        APIGuard = (values + 57) % 128;
                        z = true;
                        APIGuard = (values + 107) % 128;
                        return Boolean.valueOf(z);
                    }
                }
            }
        }
        z = false;
        APIGuard = (values + 107) % 128;
        return Boolean.valueOf(z);
    }

    static Boolean AGState(MatchesConfig matchesConfig, String str) {
        APIGuard = (values + 35) % 128;
        if ((str == null ? 'E' : (char) 19) == 'E') {
            str = "";
        }
        List<MatchConfig> AGState2 = matchesConfig.AGState();
        int i = AnonymousClass1.values[matchesConfig.valueOf().ordinal()];
        if (i != 1) {
            if (i == 2) {
                Iterator<MatchConfig> it = AGState2.iterator();
                while (it.hasNext()) {
                    if (!AGState(it.next(), str).booleanValue()) {
                        APIGuard = (values + 77) % 128;
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            } else if (i != 3) {
                if (i != 4) {
                    readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.clearCallback);
                    return Boolean.FALSE;
                }
                Iterator<MatchConfig> it2 = AGState2.iterator();
                while (it2.hasNext()) {
                    if (AGState(it2.next(), str).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            } else {
                Iterator<MatchConfig> it3 = AGState2.iterator();
                while (it3.hasNext()) {
                    values = (APIGuard + 107) % 128;
                    if (AGState(it3.next(), str).booleanValue()) {
                        values = (APIGuard + 115) % 128;
                        Boolean bool = Boolean.TRUE;
                        int i2 = values + 3;
                        APIGuard = i2 % 128;
                        if (i2 % 2 != 0) {
                            return bool;
                        }
                        throw new ArithmeticException();
                    }
                    APIGuard = (values + 105) % 128;
                }
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    static Boolean AGState(MatchConfig matchConfig, String str) {
        boolean equals;
        if (matchConfig.AGState().booleanValue()) {
            int i = values + 59;
            APIGuard = i % 128;
            if (i % 2 != 0) {
                str = str.toLowerCase();
            } else {
                throw new ArithmeticException();
            }
        }
        String APIGuard2 = matchConfig.APIGuard();
        int i2 = AnonymousClass1.getSharedInstance[matchConfig.getSharedInstance().ordinal()];
        if (i2 == 1) {
            equals = str.equals(APIGuard2);
        } else if (i2 == 2) {
            equals = str.startsWith(APIGuard2);
        } else if (i2 == 3) {
            equals = str.contains(APIGuard2);
        } else if (i2 == 4) {
            equals = str.endsWith(APIGuard2);
        } else {
            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.onInitializationSuccess);
            return Boolean.FALSE;
        }
        char c = matchConfig.valueOf().booleanValue() != equals ? '@' : (char) 21;
        if (c != 21) {
            int i3 = values + 113;
            APIGuard = i3 % 128;
            r6 = !(i3 % 2 == 0);
        }
        return Boolean.valueOf(r6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apiguard3.url_matcher.UriFilter$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        private static int AGState = 0;
        static final /* synthetic */ int[] getSharedInstance;
        private static int valueOf = 1;
        static final /* synthetic */ int[] values;

        static {
            int[] iArr = new int[MatchConfig.Match.values().length];
            getSharedInstance = iArr;
            try {
                iArr[MatchConfig.Match.values.ordinal()] = 1;
                AGState = (valueOf + 123) % 128;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getSharedInstance[MatchConfig.Match.getSharedInstance.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getSharedInstance[MatchConfig.Match.APIGuard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getSharedInstance[MatchConfig.Match.valueOf.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MatchesConfig.Matches.values().length];
            values = iArr2;
            try {
                iArr2[MatchesConfig.Matches.values.ordinal()] = 1;
                valueOf = (AGState + 53) % 128;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                values[MatchesConfig.Matches.AGState.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                values[MatchesConfig.Matches.APIGuard.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                values[MatchesConfig.Matches.valueOf.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L6
            char[] r7 = r7.toCharArray()
        L6:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.apiguard3.internal.setForeground.valueOf
            monitor-enter(r0)
            com.apiguard3.internal.setForeground.APIGuard = r8     // Catch: java.lang.Throwable -> L3d
            int r8 = r7.length     // Catch: java.lang.Throwable -> L3d
            char[] r8 = new char[r8]     // Catch: java.lang.Throwable -> L3d
            r1 = 0
            com.apiguard3.internal.setForeground.values = r1     // Catch: java.lang.Throwable -> L3d
        L13:
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = r7.length     // Catch: java.lang.Throwable -> L3d
            if (r2 >= r3) goto L34
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            char r3 = r7[r3]     // Catch: java.lang.Throwable -> L3d
            int r4 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r5 = com.apiguard3.internal.setForeground.APIGuard     // Catch: java.lang.Throwable -> L3d
            int r4 = r4 * r5
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L3d
            long r5 = com.apiguard3.url_matcher.UriFilter.valueOf     // Catch: java.lang.Throwable -> L3d
            long r3 = r3 ^ r5
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L3d
            char r3 = (char) r4     // Catch: java.lang.Throwable -> L3d
            r8[r2] = r3     // Catch: java.lang.Throwable -> L3d
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r2 = r2 + 1
            com.apiguard3.internal.setForeground.values = r2     // Catch: java.lang.Throwable -> L3d
            goto L13
        L34:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L3d
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            r9[r1] = r7
            return
        L3d:
            r7 = move-exception
            monitor-exit(r0)
            goto L41
        L40:
            throw r7
        L41:
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.url_matcher.UriFilter.values(java.lang.String, int, java.lang.Object[]):void");
    }
}
