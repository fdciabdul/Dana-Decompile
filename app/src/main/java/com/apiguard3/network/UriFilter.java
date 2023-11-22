package com.apiguard3.network;

import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class UriFilter implements Serializable {
    private static int AGState = 0;
    private static char APIGuard = 0;
    private static int getSharedInstance = 0;
    private static int parseResponseHeaders = 1;
    private static final long serialVersionUID = -1274302831362763316L;
    private static long valueOf;
    public static final String values;
    private final ArrayList<UrlTest> bypassMatchers;
    private final ArrayList<UrlTest> filterMatchers;

    static {
        getSharedInstance();
        Object[] objArr = new Object[1];
        APIGuard((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 51301), View.MeasureSpec.makeMeasureSpec(0, 0), "\ueb5e᳑〼䛴ྣᬂ壧鬇ꈷ邕崖ᨡڮ퇁鏗垰閩学\ue550ﰺ㇖ﾩ莎絣Ѥ\uf165쎄ெ\ue41d臒⑩嶱\u0fec禾潶炁\udfa1䓛፰泄ꕈ햇", "\u0000\u0000\u0000\u0000", "ﰠག搕ೈ", objArr);
        values = ((String) objArr[0]).intern();
        int i = getSharedInstance + 11;
        parseResponseHeaders = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        throw new NullPointerException();
    }

    static void getSharedInstance() {
        AGState = 0;
        APIGuard = (char) 4074;
        valueOf = 0L;
    }

    /* loaded from: classes7.dex */
    class UrlTest implements Serializable {
        private static int AGState = 1;
        private static int getSharedInstance = 0;
        private static final long serialVersionUID = 6812434843444644337L;
        final Pattern domain;
        final String domainRegex;
        final Pattern path;
        final String pathRegex;
        final Pattern port;
        final String portRegex;
        final Pattern queryString;
        final String queryStringRegex;
        final Pattern scheme;
        final String schemeRegex;

        UrlTest(String str, String str2, String str3, String str4, String str5) {
            this.schemeRegex = str;
            this.domainRegex = str2;
            this.pathRegex = str3;
            this.queryStringRegex = str4;
            this.portRegex = str5;
            this.scheme = AGState(str);
            this.domain = AGState(str2);
            this.path = AGState(str3);
            this.queryString = AGState(str4);
            this.port = AGState(str5);
        }

        UrlTest(UriFilter uriFilter) {
            this(null, null, null, null, null);
        }

        UrlTest(UrlMatcherSpec urlMatcherSpec) {
            this.schemeRegex = urlMatcherSpec.AGState;
            this.domainRegex = urlMatcherSpec.valueOf;
            this.pathRegex = urlMatcherSpec.getSharedInstance;
            this.queryStringRegex = urlMatcherSpec.APIGuard;
            this.portRegex = urlMatcherSpec.values;
            this.scheme = AGState(urlMatcherSpec.AGState);
            this.domain = AGState(urlMatcherSpec.valueOf);
            this.path = AGState(urlMatcherSpec.getSharedInstance);
            this.queryString = AGState(urlMatcherSpec.APIGuard);
            this.port = AGState(urlMatcherSpec.values);
        }

        public UrlTest AGState() {
            UrlTest urlTest = new UrlTest(this.schemeRegex, this.domainRegex, this.pathRegex, this.queryStringRegex, this.portRegex);
            int i = getSharedInstance + 23;
            AGState = i % 128;
            if (i % 2 == 0) {
                throw new NullPointerException();
            }
            return urlTest;
        }

        Pattern AGState(String str) {
            int i = getSharedInstance + 85;
            int i2 = i % 128;
            AGState = i2;
            if (i % 2 == 0) {
                throw new ArithmeticException();
            }
            if ((str == null ? (char) 20 : (char) 11) != 11) {
                int i3 = i2 + 57;
                getSharedInstance = i3 % 128;
                if (i3 % 2 == 0) {
                    return null;
                }
                throw new NullPointerException();
            }
            return Pattern.compile(str);
        }
    }

    /* loaded from: classes7.dex */
    class UrlMatcherSpec {
        private static int analyzeResponse = 182;
        String AGState;
        String APIGuard;
        String getSharedInstance;
        String valueOf;
        String values;

        UrlMatcherSpec(JSONObject jSONObject) {
            if (jSONObject != null) {
                Object[] objArr = new Object[1];
                AGState(View.MeasureSpec.makeMeasureSpec(0, 0) + 6, 1 - (ViewConfiguration.getFadingEdgeLength() >> 16), "\u000b�\u0005�\u0000\ufffb", true, 286 - TextUtils.getOffsetBefore("", 0), objArr);
                if (jSONObject.has(((String) objArr[0]).intern())) {
                    Object[] objArr2 = new Object[1];
                    AGState(6 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getEdgeSlop() >> 16) + 1, "\u000b�\u0005�\u0000\ufffb", true, (Process.myTid() >> 22) + 286, objArr2);
                    this.AGState = jSONObject.optString(((String) objArr2[0]).intern());
                }
                Object[] objArr3 = new Object[1];
                AGState(ExpandableListView.getPackedPositionGroup(0L) + 6, 1 - (Process.myPid() >> 22), "\u0005\ufffb\u0006\u0004\ufff8\u0000", false, View.resolveSize(0, 0) + 287, objArr3);
                if (jSONObject.has(((String) objArr3[0]).intern())) {
                    Object[] objArr4 = new Object[1];
                    AGState(6 - TextUtils.indexOf("", "", 0, 0), -TextUtils.lastIndexOf("", '0'), "\u0005\ufffb\u0006\u0004\ufff8\u0000", false, 287 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr4);
                    this.valueOf = jSONObject.optString(((String) objArr4[0]).intern());
                }
                Object[] objArr5 = new Object[1];
                AGState(4 - (Process.myPid() >> 22), ((Process.getThreadPriority(0) + 20) >> 6) + 1, "\u0005�\t\ufff6", true, 289 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr5);
                if (jSONObject.has(((String) objArr5[0]).intern())) {
                    Object[] objArr6 = new Object[1];
                    AGState(4 - (ViewConfiguration.getTouchSlop() >> 8), 1 - ((Process.getThreadPriority(0) + 20) >> 6), "\u0005�\t\ufff6", true, 289 - (ViewConfiguration.getLongPressTimeout() >> 16), objArr6);
                    this.getSharedInstance = jSONObject.optString(((String) objArr6[0]).intern());
                }
                Object[] objArr7 = new Object[1];
                AGState(11 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 10 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), "\u0005\t\ufff9\u0006\r\uffe7\b\u0006�\u0002\ufffb", false, View.combineMeasuredStates(0, 0) + 290, objArr7);
                if (jSONObject.has(((String) objArr7[0]).intern())) {
                    Object[] objArr8 = new Object[1];
                    AGState(11 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 11 - View.resolveSizeAndState(0, 0, 0), "\u0005\t\ufff9\u0006\r\uffe7\b\u0006�\u0002\ufffb", false, View.resolveSizeAndState(0, 0, 0) + 290, objArr8);
                    this.APIGuard = jSONObject.optString(((String) objArr8[0]).intern());
                }
                Object[] objArr9 = new Object[1];
                AGState(5 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 2 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), "\u0001\u0003\uffff\ufffe", false, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 295, objArr9);
                if (jSONObject.has(((String) objArr9[0]).intern())) {
                    Object[] objArr10 = new Object[1];
                    AGState(4 - (KeyEvent.getMaxKeyCode() >> 16), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1, "\u0001\u0003\uffff\ufffe", false, 295 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr10);
                    this.values = jSONObject.optString(((String) objArr10[0]).intern());
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r8 = r8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void AGState(int r6, int r7, java.lang.String r8, boolean r9, int r10, java.lang.Object[] r11) {
            /*
                if (r8 == 0) goto L6
                char[] r8 = r8.toCharArray()
            L6:
                char[] r8 = (char[]) r8
                java.lang.Object r0 = com.apiguard3.internal.setForegroundTintList.getSharedInstance
                monitor-enter(r0)
                char[] r1 = new char[r6]     // Catch: java.lang.Throwable -> L75
                r2 = 0
                com.apiguard3.internal.setForegroundTintList.APIGuard = r2     // Catch: java.lang.Throwable -> L75
            L10:
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                if (r3 >= r6) goto L33
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                char r3 = r8[r3]     // Catch: java.lang.Throwable -> L75
                com.apiguard3.internal.setForegroundTintList.values = r3     // Catch: java.lang.Throwable -> L75
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r4 = com.apiguard3.internal.setForegroundTintList.values     // Catch: java.lang.Throwable -> L75
                int r4 = r4 + r10
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                r1[r3] = r4     // Catch: java.lang.Throwable -> L75
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                char r4 = r1[r3]     // Catch: java.lang.Throwable -> L75
                int r5 = com.apiguard3.network.UriFilter.UrlMatcherSpec.analyzeResponse     // Catch: java.lang.Throwable -> L75
                int r4 = r4 - r5
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                r1[r3] = r4     // Catch: java.lang.Throwable -> L75
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r3 = r3 + 1
                com.apiguard3.internal.setForegroundTintList.APIGuard = r3     // Catch: java.lang.Throwable -> L75
                goto L10
            L33:
                if (r7 <= 0) goto L4e
                com.apiguard3.internal.setForegroundTintList.AGState = r7     // Catch: java.lang.Throwable -> L75
                char[] r7 = new char[r6]     // Catch: java.lang.Throwable -> L75
                java.lang.System.arraycopy(r1, r2, r7, r2, r6)     // Catch: java.lang.Throwable -> L75
                int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                int r8 = r6 - r8
                int r10 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                java.lang.System.arraycopy(r7, r2, r1, r8, r10)     // Catch: java.lang.Throwable -> L75
                int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                int r10 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                int r10 = r6 - r10
                java.lang.System.arraycopy(r7, r8, r1, r2, r10)     // Catch: java.lang.Throwable -> L75
            L4e:
                if (r9 == 0) goto L6c
                char[] r7 = new char[r6]     // Catch: java.lang.Throwable -> L75
                com.apiguard3.internal.setForegroundTintList.APIGuard = r2     // Catch: java.lang.Throwable -> L75
            L54:
                int r8 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                if (r8 >= r6) goto L6b
                int r8 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r9 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r9 = r6 - r9
                int r9 = r9 + (-1)
                char r9 = r1[r9]     // Catch: java.lang.Throwable -> L75
                r7[r8] = r9     // Catch: java.lang.Throwable -> L75
                int r8 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r8 = r8 + 1
                com.apiguard3.internal.setForegroundTintList.APIGuard = r8     // Catch: java.lang.Throwable -> L75
                goto L54
            L6b:
                r1 = r7
            L6c:
                java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L75
                r6.<init>(r1)     // Catch: java.lang.Throwable -> L75
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L75
                r11[r2] = r6
                return
            L75:
                r6 = move-exception
                monitor-exit(r0)
                goto L79
            L78:
                throw r6
            L79:
                goto L78
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.network.UriFilter.UrlMatcherSpec.AGState(int, int, java.lang.String, boolean, int, java.lang.Object[]):void");
        }
    }

    public UriFilter(JSONObject jSONObject) {
        Object[] objArr = new Object[1];
        APIGuard((char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1200892818, "〯炚캇\ueaec췃싦\ue4c5\udf59뎤", "\u0000\u0000\u0000\u0000", "澜比ꊸ녮", objArr);
        JSONArray optJSONArray = jSONObject.optJSONArray(((String) objArr[0]).intern());
        if (optJSONArray == null) {
            ArrayList<UrlTest> arrayList = new ArrayList<>();
            this.filterMatchers = arrayList;
            arrayList.add(new UrlTest(this));
        } else {
            this.filterMatchers = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.filterMatchers.add(new UrlTest(new UrlMatcherSpec(optJSONArray.optJSONObject(i))));
            }
        }
        Object[] objArr2 = new Object[1];
        APIGuard((char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), View.resolveSizeAndState(0, 0, 0) + 1549506123, "\ue96eꐹ⟬ਜ਼섩\u2e54ꂺᒈ瘅", "\u0000\u0000\u0000\u0000", "䯲宖ﵜ슴", objArr2);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(((String) objArr2[0]).intern());
        if (optJSONArray2 == null) {
            this.bypassMatchers = new ArrayList<>();
            return;
        }
        this.bypassMatchers = new ArrayList<>(optJSONArray2.length());
        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
            this.bypassMatchers.add(new UrlTest(new UrlMatcherSpec(optJSONArray2.optJSONObject(i2))));
        }
    }

    public static UriFilter values() {
        try {
            Object[] objArr = new Object[1];
            APIGuard((char) (51299 - TextUtils.indexOf((CharSequence) "", '0', 0)), (-1) - ImageFormat.getBitsPerPixel(0), "\ueb5e᳑〼䛴ྣᬂ壧鬇ꈷ邕崖ᨡڮ퇁鏗垰閩学\ue550ﰺ㇖ﾩ莎絣Ѥ\uf165쎄ெ\ue41d臒⑩嶱\u0fec禾潶炁\udfa1䓛፰泄ꕈ햇", "\u0000\u0000\u0000\u0000", "ﰠག搕ೈ", objArr);
            UriFilter uriFilter = new UriFilter(new JSONObject(((String) objArr[0]).intern()));
            int i = getSharedInstance + 61;
            parseResponseHeaders = i % 128;
            if (i % 2 == 0) {
                throw new NullPointerException();
            }
            return uriFilter;
        } catch (JSONException unused) {
            return null;
        }
    }

    private UriFilter() {
        this.filterMatchers = new ArrayList<>();
        this.bypassMatchers = new ArrayList<>();
    }

    public UriFilter valueOf() {
        UriFilter uriFilter = new UriFilter();
        Iterator<UrlTest> it = this.filterMatchers.iterator();
        getSharedInstance = (parseResponseHeaders + 13) % 128;
        while (true) {
            if ((it.hasNext() ? (char) 3 : (char) 5) != 5) {
                int i = parseResponseHeaders + 93;
                getSharedInstance = i % 128;
                if ((i % 2 != 0 ? 'Z' : (char) 20) != 20) {
                    uriFilter.filterMatchers.add(it.next().AGState());
                    throw new NullPointerException();
                }
                uriFilter.filterMatchers.add(it.next().AGState());
            } else {
                Iterator<UrlTest> it2 = this.bypassMatchers.iterator();
                while (true) {
                    if ((it2.hasNext() ? 'Q' : '\\') == '\\') {
                        return uriFilter;
                    }
                    parseResponseHeaders = (getSharedInstance + 85) % 128;
                    uriFilter.bypassMatchers.add(it2.next().AGState());
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r12 = r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void APIGuard(char r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Object[] r13) {
        /*
            if (r12 == 0) goto L6
            char[] r12 = r12.toCharArray()
        L6:
            char[] r12 = (char[]) r12
            if (r11 == 0) goto Le
            char[] r11 = r11.toCharArray()
        Le:
            char[] r11 = (char[]) r11
            if (r10 == 0) goto L16
            char[] r10 = r10.toCharArray()
        L16:
            char[] r10 = (char[]) r10
            java.lang.Object r0 = com.apiguard3.internal.setForegroundGravity.AGState
            monitor-enter(r0)
            java.lang.Object r12 = r12.clone()     // Catch: java.lang.Throwable -> L94
            char[] r12 = (char[]) r12     // Catch: java.lang.Throwable -> L94
            java.lang.Object r11 = r11.clone()     // Catch: java.lang.Throwable -> L94
            char[] r11 = (char[]) r11     // Catch: java.lang.Throwable -> L94
            r1 = 0
            char r2 = r12[r1]     // Catch: java.lang.Throwable -> L94
            r8 = r8 ^ r2
            char r8 = (char) r8     // Catch: java.lang.Throwable -> L94
            r12[r1] = r8     // Catch: java.lang.Throwable -> L94
            r8 = 2
            char r2 = r11[r8]     // Catch: java.lang.Throwable -> L94
            char r9 = (char) r9     // Catch: java.lang.Throwable -> L94
            int r2 = r2 + r9
            char r9 = (char) r2     // Catch: java.lang.Throwable -> L94
            r11[r8] = r9     // Catch: java.lang.Throwable -> L94
            int r9 = r10.length     // Catch: java.lang.Throwable -> L94
            char[] r2 = new char[r9]     // Catch: java.lang.Throwable -> L94
            com.apiguard3.internal.setForegroundGravity.valueOf = r1     // Catch: java.lang.Throwable -> L94
        L3b:
            int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            if (r3 >= r9) goto L8b
            int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r3 = r3 + r8
            int r3 = r3 % 4
            int r4 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r4 = r4 + 3
            int r4 = r4 % 4
            int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r5 = r5 % 4
            char r5 = r12[r5]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 * 32718
            char r6 = r11[r3]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 + r6
            r6 = 65535(0xffff, float:9.1834E-41)
            int r5 = r5 % r6
            char r5 = (char) r5     // Catch: java.lang.Throwable -> L94
            com.apiguard3.internal.setForegroundGravity.APIGuard = r5     // Catch: java.lang.Throwable -> L94
            char r5 = r12[r4]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 * 32718
            char r3 = r11[r3]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 + r3
            int r5 = r5 / r6
            char r3 = (char) r5     // Catch: java.lang.Throwable -> L94
            r11[r4] = r3     // Catch: java.lang.Throwable -> L94
            char r3 = com.apiguard3.internal.setForegroundGravity.APIGuard     // Catch: java.lang.Throwable -> L94
            r12[r4] = r3     // Catch: java.lang.Throwable -> L94
            int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            char r5 = r10[r5]     // Catch: java.lang.Throwable -> L94
            char r4 = r12[r4]     // Catch: java.lang.Throwable -> L94
            r4 = r4 ^ r5
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L94
            long r6 = com.apiguard3.network.UriFilter.valueOf     // Catch: java.lang.Throwable -> L94
            long r4 = r4 ^ r6
            int r6 = com.apiguard3.network.UriFilter.AGState     // Catch: java.lang.Throwable -> L94
            long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
            long r4 = r4 ^ r6
            char r6 = com.apiguard3.network.UriFilter.APIGuard     // Catch: java.lang.Throwable -> L94
            long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
            long r4 = r4 ^ r6
            int r5 = (int) r4     // Catch: java.lang.Throwable -> L94
            char r4 = (char) r5     // Catch: java.lang.Throwable -> L94
            r2[r3] = r4     // Catch: java.lang.Throwable -> L94
            int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r3 = r3 + 1
            com.apiguard3.internal.setForegroundGravity.valueOf = r3     // Catch: java.lang.Throwable -> L94
            goto L3b
        L8b:
            java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L94
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L94
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
            r13[r1] = r8
            return
        L94:
            r8 = move-exception
            monitor-exit(r0)
            goto L98
        L97:
            throw r8
        L98:
            goto L97
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.network.UriFilter.APIGuard(char, int, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void");
    }
}
