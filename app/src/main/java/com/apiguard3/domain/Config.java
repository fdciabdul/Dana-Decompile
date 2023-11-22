package com.apiguard3.domain;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.URLUtil;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.apiguard3.internal.AGState;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.onContextItemSelected;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.writeReplace;
import com.apiguard3.url_matcher.UriFilter;
import id.dana.cashier.view.InputCardNumberView;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Config implements Serializable {
    private static final Integer AGState;
    public static final String APIGuard;
    private static long analyzeResponse = 0;
    private static long generateHeaders = 0;
    private static int getRequestHeaders = 0;
    private static final Map<String, onContextItemSelected> getSharedInstance;
    private static int initialize = 0;
    private static int log = 1;
    private static char parseResponseHeaders = 0;
    private static final long serialVersionUID = 623200184570711875L;
    private static Config valueOf;
    private static final String values;
    private Map<String, String> cvmCodeMap;
    private Map<String, String> cvmDigestMap;

    /* renamed from: id  reason: collision with root package name */
    private String f7412id;
    private String kernel;
    private String kernelId;
    private String kernelPatch;
    private String nativeSignalHeaderPrefix;
    private Integer rtd;
    private Integer support;
    private String updateHeaderName;
    private String updateURL;
    private Map<String, String> updateURLMap;
    private UriFilter uriBypass2;
    private com.apiguard3.network.UriFilter uriFilter;
    private UriFilter uriFilter2;
    private String version;
    private Boolean storePersistentID = null;
    private Boolean cvmEnabled = null;
    private Boolean nativeHeaderCachingEnabled = null;
    private Integer debugLevel = Integer.valueOf(ConfigInstance.ConfigSerializationProxy.values.values.AGState());
    private int urlXsumMaxLength = -1;
    private int bodyXsumMaxLength = -1;
    private long minUpdateIntervalInMilliseconds = 60000;
    private long maxUpdateIntervalInMilliseconds = 28800000;
    private long ttlInMilliSeconds = -1;
    private long updateTimeoutInMilliseconds = 28800000;

    static void Config() {
        analyzeResponse = -6546133225953104307L;
        initialize = 0;
        parseResponseHeaders = (char) 50951;
        generateHeaders = 0L;
    }

    static {
        Config();
        Object[] objArr = new Object[1];
        AGState("깿釯酿", 7983920 - TextUtils.indexOf("", "", 0, 0), "ゐ秓戀쪢", (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 41570), "\u0000\u0000\u0000\u0000", objArr);
        APIGuard = ((String) objArr[0]).intern();
        ExpandableListView.getPackedPositionChild(0L);
        View.MeasureSpec.makeMeasureSpec(0, 0);
        AGState = Integer.valueOf(ConfigInstance.ConfigSerializationProxy.values.valueOf.AGState());
        try {
            getSharedInstance = Collections.unmodifiableMap((Map) ((Class) AGState.values(1543 - Gravity.getAbsoluteGravity(0, 0), 29 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getDeclaredConstructor(null).newInstance(null));
            values = null;
            int i = getRequestHeaders + 55;
            log = i % 128;
            if (i % 2 != 0) {
                return;
            }
            throw new ArithmeticException();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static Config values() {
        Config config;
        synchronized (Config.class) {
            getRequestHeaders = (log + 111) % 128;
            if (valueOf == null) {
                Config config2 = new Config();
                valueOf = config2;
                Object[] objArr = new Object[1];
                APIGuard("\uee15漹\uecb4樳\ueb41", (ViewConfiguration.getLongPressTimeout() >> 16) + 33113, objArr);
                config2.updateHeaderName = ((String) objArr[0]).intern();
                Config config3 = valueOf;
                Object[] objArr2 = new Object[1];
                APIGuard("\uee15✙", (ViewConfiguration.getWindowTouchSlop() >> 8) + 51577, objArr2);
                config3.nativeSignalHeaderPrefix = ((String) objArr2[0]).intern();
                Config config4 = valueOf;
                config4.ttlInMilliSeconds = 86400000L;
                config4.updateTimeoutInMilliseconds = 60000L;
                config4.minUpdateIntervalInMilliseconds = 300000L;
                config4.maxUpdateIntervalInMilliseconds = 28800000L;
                config4.urlXsumMaxLength = 1024;
                config4.bodyXsumMaxLength = 1024;
                config4.kernelPatch = values;
                config4.debugLevel = Integer.valueOf(ConfigInstance.ConfigSerializationProxy.values.values.AGState());
                valueOf.uriFilter = com.apiguard3.network.UriFilter.values();
                valueOf.uriFilter2 = UriFilter.values();
                valueOf.uriBypass2 = UriFilter.values();
                valueOf.nativeHeaderCachingEnabled = Boolean.FALSE;
                valueOf.support = 255;
                valueOf.rtd = 255;
            }
            config = valueOf;
            log = (getRequestHeaders + 105) % 128;
        }
        return config;
    }

    public boolean APIGuard() {
        int i = getRequestHeaders;
        int i2 = i + 55;
        log = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        Boolean bool = this.storePersistentID;
        if (bool == null) {
            return false;
        }
        log = (i + 19) % 128;
        boolean booleanValue = bool.booleanValue();
        getRequestHeaders = (log + 93) % 128;
        return booleanValue;
    }

    public boolean getSharedInstance() {
        Boolean bool = this.cvmEnabled;
        if (bool != null) {
            getRequestHeaders = (log + 39) % 128;
            return bool.booleanValue();
        }
        int i = log + 81;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            throw new NullPointerException();
        }
        return false;
    }

    public boolean AGState() {
        log = (getRequestHeaders + 45) % 128;
        boolean booleanValue = this.nativeHeaderCachingEnabled.booleanValue();
        int i = getRequestHeaders + 31;
        log = i % 128;
        if ((i % 2 == 0 ? '9' : Typography.amp) != '9') {
            return booleanValue;
        }
        throw new NullPointerException();
    }

    public void AGState(boolean z) {
        int i = getRequestHeaders + 61;
        log = i % 128;
        char c = i % 2 == 0 ? (char) 6 : '1';
        this.nativeHeaderCachingEnabled = Boolean.valueOf(z);
        if (c != 6) {
            return;
        }
        throw null;
    }

    public String valueOf() {
        int i = getRequestHeaders + 75;
        int i2 = i % 128;
        log = i2;
        if (i % 2 == 0) {
            throw null;
        }
        String str = this.version;
        getRequestHeaders = (i2 + 37) % 128;
        return str;
    }

    public void APIGuard(String str) {
        int i = getRequestHeaders;
        log = (i + 63) % 128;
        this.version = str;
        int i2 = i + 113;
        log = i2 % 128;
        if (i2 % 2 == 0) {
            throw new NullPointerException();
        }
    }

    public String analyzeResponse() {
        int i = log;
        int i2 = i + 39;
        getRequestHeaders = i2 % 128;
        if (!(i2 % 2 == 0)) {
            throw new NullPointerException();
        }
        String str = this.kernel;
        getRequestHeaders = (i + 115) % 128;
        return str;
    }

    public void valueOf(String str) {
        log = (getRequestHeaders + 115) % 128;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = log;
        getRequestHeaders = (i + 89) % 128;
        this.kernel = str;
        getRequestHeaders = (i + 53) % 128;
    }

    public String parseResponseHeaders() {
        int i = getRequestHeaders + 121;
        int i2 = i % 128;
        log = i2;
        if (i % 2 == 0) {
            throw null;
        }
        String str = this.kernelPatch;
        getRequestHeaders = (i2 + 91) % 128;
        return str;
    }

    public void values(String str) {
        int i = (getRequestHeaders + 119) % 128;
        log = i;
        this.kernelPatch = str;
        int i2 = i + 91;
        getRequestHeaders = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        throw new ArithmeticException();
    }

    public String generateHeaders() {
        int i = (getRequestHeaders + 59) % 128;
        log = i;
        String str = this.f7412id;
        int i2 = i + 73;
        getRequestHeaders = i2 % 128;
        if ((i2 % 2 != 0 ? InputCardNumberView.DIVIDER : (char) 23) != ' ') {
            return str;
        }
        throw new NullPointerException();
    }

    public void getSharedInstance(String str) {
        int i = (getRequestHeaders + 43) % 128;
        log = i;
        this.f7412id = str;
        int i2 = i + 7;
        getRequestHeaders = i2 % 128;
        if ((i2 % 2 != 0 ? Typography.amp : (char) 3) != '&') {
            return;
        }
        throw new NullPointerException();
    }

    public String initialize() {
        int i = log;
        getRequestHeaders = (i + 13) % 128;
        String str = this.kernelId;
        getRequestHeaders = (i + 123) % 128;
        return str;
    }

    public void AGState(String str) {
        log = (getRequestHeaders + 87) % 128;
        if ((!TextUtils.isEmpty(str) ? '(' : Typography.quote) == '(') {
            int i = getRequestHeaders + 3;
            log = i % 128;
            boolean z = i % 2 != 0;
            this.kernelId = str;
            if (z) {
                return;
            }
            throw new NullPointerException();
        }
    }

    public String getRequestHeaders() {
        int i = log + 89;
        int i2 = i % 128;
        getRequestHeaders = i2;
        if (!(i % 2 == 0)) {
            throw new ArithmeticException();
        }
        String str = this.updateURL;
        int i3 = i2 + 121;
        log = i3 % 128;
        if (i3 % 2 != 0) {
            return str;
        }
        throw new ArithmeticException();
    }

    public boolean getRequestHeaders(String str) {
        if ((analyzeResponse(str) ? '-' : 'M') == 'M') {
            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.getSharedInstance);
            getRequestHeaders = (log + 39) % 128;
            return false;
        }
        int i = log + 125;
        getRequestHeaders = i % 128;
        if (!(i % 2 != 0)) {
            this.updateURL = str;
            return true;
        }
        this.updateURL = str;
        return true;
    }

    public Map<String, String> APIGuard$Callback() {
        int i = getRequestHeaders + 113;
        int i2 = i % 128;
        log = i2;
        if (i % 2 == 0) {
            throw new ArithmeticException();
        }
        Map<String, String> map = this.updateURLMap;
        getRequestHeaders = (i2 + 97) % 128;
        return map;
    }

    public void valueOf(Map<String, String> map) {
        int i = getRequestHeaders + 109;
        log = i % 128;
        boolean z = i % 2 != 0;
        this.updateURLMap = map;
        if (z) {
            return;
        }
        throw new ArithmeticException();
    }

    public Map<String, String> getState() {
        int i = getRequestHeaders + 85;
        int i2 = i % 128;
        log = i2;
        if ((i % 2 == 0 ? (char) 30 : 'D') != 'D') {
            throw new NullPointerException();
        }
        Map<String, String> map = this.cvmCodeMap;
        getRequestHeaders = (i2 + 77) % 128;
        return map;
    }

    public void AGState(Map<String, String> map) {
        int i = (getRequestHeaders + 59) % 128;
        log = i;
        this.cvmCodeMap = map;
        int i2 = i + 61;
        getRequestHeaders = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        throw null;
    }

    public void APIGuard(Map<String, String> map) {
        int i = getRequestHeaders;
        int i2 = i + 97;
        log = i2 % 128;
        char c = i2 % 2 == 0 ? (char) 6 : '(';
        this.cvmDigestMap = map;
        if (c == 6) {
            throw new ArithmeticException();
        }
        log = (i + 51) % 128;
    }

    public long log() {
        int i = log;
        int i2 = i + 31;
        getRequestHeaders = i2 % 128;
        if (!(i2 % 2 == 0)) {
            throw new NullPointerException();
        }
        long j = this.ttlInMilliSeconds;
        int i3 = i + 49;
        getRequestHeaders = i3 % 128;
        if (i3 % 2 == 0) {
            return j;
        }
        throw new NullPointerException();
    }

    public Long checkCertificates() {
        int i = log;
        getRequestHeaders = (i + 17) % 128;
        long j = this.updateTimeoutInMilliseconds;
        getRequestHeaders = (i + 97) % 128;
        return Long.valueOf(j);
    }

    public Long updateKernel() {
        int i = getRequestHeaders;
        log = (i + 71) % 128;
        long j = this.minUpdateIntervalInMilliseconds;
        int i2 = i + 45;
        log = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        return Long.valueOf(j);
    }

    public Long APIGuard$InitializationCallback() {
        int i = log;
        getRequestHeaders = (i + 121) % 128;
        long j = this.maxUpdateIntervalInMilliseconds;
        getRequestHeaders = (i + 59) % 128;
        return Long.valueOf(j);
    }

    private void parseResponseHeaders(String str) {
        int i = (log + 33) % 128;
        getRequestHeaders = i;
        if ((str == null ? (char) 1 : 'I') != 'I') {
            log = (i + 105) % 128;
            Object[] objArr = new Object[1];
            APIGuard("\uee15漹\uecb4樳\ueb41", 33114 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr);
            str = ((String) objArr[0]).intern();
        }
        this.updateHeaderName = str;
    }

    public String pushMinPayload() {
        int i = getRequestHeaders + 79;
        int i2 = i % 128;
        log = i2;
        if ((i % 2 == 0 ? '6' : (char) 25) == '6') {
            throw new ArithmeticException();
        }
        String str = this.updateHeaderName;
        int i3 = i2 + 115;
        getRequestHeaders = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return str;
        }
        throw new NullPointerException();
    }

    public void initialize(String str) {
        int i = log;
        int i2 = i + 23;
        getRequestHeaders = i2 % 128;
        if (i2 % 2 != 0) {
            throw new ArithmeticException();
        }
        if (!(str == null)) {
            this.nativeSignalHeaderPrefix = str;
            getRequestHeaders = (i + 27) % 128;
            return;
        }
        readResolve.values(ConfigInstance.ConfigSerializationProxy.values.AGState, writeReplace.getRequestHeaders.getSharedInstance.getSharedInstance());
        Object[] objArr = new Object[1];
        APIGuard("\uee15✙", View.getDefaultSize(0, 0) + 51577, objArr);
        this.nativeSignalHeaderPrefix = ((String) objArr[0]).intern();
    }

    public String onInitializationFailure() {
        int i = (log + 41) % 128;
        getRequestHeaders = i;
        String str = this.nativeSignalHeaderPrefix;
        int i2 = i + 53;
        log = i2 % 128;
        if (i2 % 2 == 0) {
            throw new ArithmeticException();
        }
        return str;
    }

    private void getSharedInstance(com.apiguard3.network.UriFilter uriFilter) {
        int i = getRequestHeaders + 65;
        log = i % 128;
        char c = i % 2 == 0 ? '!' : '#';
        this.uriFilter = uriFilter;
        if (c == '#') {
            return;
        }
        throw new NullPointerException();
    }

    public UriFilter onInitializationSuccess() {
        int i = getRequestHeaders + 89;
        int i2 = i % 128;
        log = i2;
        if (i % 2 == 0) {
            throw null;
        }
        UriFilter uriFilter = this.uriFilter2;
        int i3 = i2 + 33;
        getRequestHeaders = i3 % 128;
        if ((i3 % 2 != 0 ? 'U' : (char) 31) != 'U') {
            return uriFilter;
        }
        throw new ArithmeticException();
    }

    public UriFilter BuildConfig() {
        int i = getRequestHeaders;
        log = (i + 77) % 128;
        UriFilter uriFilter = this.uriBypass2;
        int i2 = i + 115;
        log = i2 % 128;
        if (i2 % 2 != 0) {
            return uriFilter;
        }
        throw null;
    }

    public void values(UriFilter uriFilter) {
        int i = (getRequestHeaders + 111) % 128;
        log = i;
        this.uriFilter2 = uriFilter;
        getRequestHeaders = (i + 97) % 128;
    }

    public void getSharedInstance(UriFilter uriFilter) {
        int i = log + 87;
        getRequestHeaders = i % 128;
        char c = i % 2 != 0 ? '8' : '9';
        this.uriBypass2 = uriFilter;
        if (c == '9') {
            return;
        }
        throw new NullPointerException();
    }

    public Integer send() {
        int i = getRequestHeaders;
        int i2 = i + 111;
        log = i2 % 128;
        if (i2 % 2 != 0) {
            Integer num = this.debugLevel;
            if (num != null) {
                log = (i + 47) % 128;
                return num;
            }
            return Integer.valueOf(ConfigInstance.ConfigSerializationProxy.values.values.AGState());
        }
        throw null;
    }

    public void APIGuard(Integer num) {
        log = (getRequestHeaders + 61) % 128;
        if ((num.intValue() >= 0 ? (char) 29 : ')') == 29) {
            int i = log + 65;
            getRequestHeaders = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
            if ((num.intValue() > AGState.intValue() ? (char) 19 : (char) 15) == 15) {
                this.debugLevel = num;
                return;
            }
        }
        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.rm);
    }

    private void AGState(Long l) {
        getRequestHeaders = (log + 25) % 128;
        if (l.longValue() <= 0) {
            return;
        }
        int i = log + 11;
        getRequestHeaders = i % 128;
        if ((i % 2 != 0 ? 'E' : (char) 21) == 'E') {
            this.ttlInMilliSeconds = l.longValue();
            throw new ArithmeticException();
        }
        this.ttlInMilliSeconds = l.longValue();
        log = (getRequestHeaders + 51) % 128;
    }

    private void getSharedInstance(Long l) {
        if (l.longValue() > 0) {
            int i = log + 13;
            getRequestHeaders = i % 128;
            boolean z = i % 2 != 0;
            this.updateTimeoutInMilliseconds = l.longValue();
            if (z) {
                throw new ArithmeticException();
            }
        }
        log = (getRequestHeaders + 39) % 128;
    }

    private void APIGuard(Long l) {
        getRequestHeaders = (log + 125) % 128;
        if (l.longValue() > 0) {
            int i = log + 39;
            getRequestHeaders = i % 128;
            if ((i % 2 != 0 ? '+' : 'Y') == '+') {
                this.minUpdateIntervalInMilliseconds = l.longValue();
                throw null;
            }
            this.minUpdateIntervalInMilliseconds = l.longValue();
        }
        int i2 = log + 77;
        getRequestHeaders = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        throw new NullPointerException();
    }

    private void values(Long l) {
        int i = getRequestHeaders + 43;
        log = i % 128;
        if (i % 2 != 0) {
            if ((l.longValue() > 0 ? Typography.quote : (char) 2) != '\"') {
                return;
            }
        } else if (l.longValue() <= 0) {
            return;
        }
        int i2 = getRequestHeaders + 109;
        log = i2 % 128;
        if (i2 % 2 != 0) {
            this.maxUpdateIntervalInMilliseconds = l.longValue();
        } else {
            this.maxUpdateIntervalInMilliseconds = l.longValue();
            throw new ArithmeticException();
        }
    }

    private void valueOf(int i) {
        int i2 = log + 75;
        getRequestHeaders = i2 % 128;
        char c = i2 % 2 != 0 ? 'U' : (char) 21;
        this.urlXsumMaxLength = i;
        if (c == 21) {
            return;
        }
        throw null;
    }

    public int AnalysesEntry() {
        int i = getRequestHeaders + 53;
        log = i % 128;
        if ((i % 2 == 0 ? (char) 11 : '9') == '9') {
            return this.bodyXsumMaxLength;
        }
        throw new NullPointerException();
    }

    private void getSharedInstance(int i) {
        int i2 = (log + 41) % 128;
        getRequestHeaders = i2;
        this.bodyXsumMaxLength = i;
        int i3 = i2 + 73;
        log = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        throw new NullPointerException();
    }

    public Boolean getVersion() {
        Integer num = this.support;
        boolean z = false;
        if (num != null) {
            if ((num.intValue() & 1) == 0) {
                getRequestHeaders = (log + 93) % 128;
                z = true;
            }
            return Boolean.valueOf(z);
        }
        Boolean bool = Boolean.FALSE;
        int i = log + 13;
        getRequestHeaders = i % 128;
        if (i % 2 == 0) {
            return bool;
        }
        throw new NullPointerException();
    }

    public void APIGuard(int i) {
        int i2 = log + 35;
        getRequestHeaders = i2 % 128;
        char c = i2 % 2 != 0 ? 'L' : Typography.quote;
        this.support = Integer.valueOf(i);
        if (c != 'L') {
            return;
        }
        throw null;
    }

    public void values(int i) {
        getRequestHeaders = (log + 27) % 128;
        this.rtd = Integer.valueOf(i);
        getRequestHeaders = (log + 17) % 128;
    }

    public int clearCallback() {
        int i = getRequestHeaders + 21;
        log = i % 128;
        if (!(i % 2 != 0)) {
            throw new ArithmeticException();
        }
        int intValue = this.rtd.intValue();
        getRequestHeaders = (log + 75) % 128;
        return intValue;
    }

    private Config ScoredEntry() {
        com.apiguard3.network.UriFilter valueOf2;
        Config config = new Config();
        config.version = this.version;
        config.f7412id = this.f7412id;
        config.kernel = this.kernel;
        config.kernelId = this.kernelId;
        config.kernelPatch = this.kernelPatch;
        config.updateURL = this.updateURL;
        if (this.updateURLMap != null) {
            config.updateURLMap = new HashMap(this.updateURLMap);
        }
        config.updateHeaderName = this.updateHeaderName;
        config.nativeSignalHeaderPrefix = this.nativeSignalHeaderPrefix;
        config.ttlInMilliSeconds = this.ttlInMilliSeconds;
        config.updateTimeoutInMilliseconds = this.updateTimeoutInMilliseconds;
        config.minUpdateIntervalInMilliseconds = this.minUpdateIntervalInMilliseconds;
        config.maxUpdateIntervalInMilliseconds = this.maxUpdateIntervalInMilliseconds;
        config.urlXsumMaxLength = this.urlXsumMaxLength;
        config.bodyXsumMaxLength = this.bodyXsumMaxLength;
        com.apiguard3.network.UriFilter uriFilter = this.uriFilter;
        UriFilter uriFilter2 = null;
        if (uriFilter == null) {
            log = (getRequestHeaders + 15) % 128;
            valueOf2 = null;
        } else {
            valueOf2 = uriFilter.valueOf();
        }
        config.uriFilter = valueOf2;
        UriFilter uriFilter3 = this.uriFilter2;
        config.uriFilter2 = uriFilter3 != null ? uriFilter3.AGState() : null;
        UriFilter uriFilter4 = this.uriBypass2;
        if (!(uriFilter4 == null)) {
            uriFilter2 = uriFilter4.AGState();
        } else {
            getRequestHeaders = (log + 5) % 128;
        }
        config.uriBypass2 = uriFilter2;
        config.storePersistentID = this.storePersistentID;
        config.cvmEnabled = this.cvmEnabled;
        config.debugLevel = this.debugLevel;
        config.nativeHeaderCachingEnabled = this.nativeHeaderCachingEnabled;
        config.support = this.support;
        config.rtd = this.rtd;
        if ((this.cvmCodeMap != null ? 'K' : (char) 21) != 21) {
            int i = log + 123;
            getRequestHeaders = i % 128;
            if (i % 2 != 0) {
                throw new NullPointerException();
            } else if (this.cvmDigestMap != null) {
                config.cvmCodeMap = new HashMap(this.cvmCodeMap);
                config.cvmDigestMap = new HashMap(this.cvmDigestMap);
            }
        }
        log = (getRequestHeaders + 115) % 128;
        return config;
    }

    private Config AGState(Config config) throws IllegalArgumentException {
        Config values2;
        if ((config != null ? 'c' : '9') != '9') {
            getRequestHeaders = (log + 103) % 128;
            values2 = config.ScoredEntry();
        } else {
            values2 = values();
        }
        String str = this.kernelId;
        if ((str == null ? ';' : 'c') != 'c' && this.kernel != null) {
            Object[] objArr = new Object[1];
            AGState("ᢕ灏ঞꑳ톿⩓\uf697볮闟₀헡쪫ꊱ훛艂魍䮉铁犳⦶륒奀맥ꀪ♜\u0fe1⚕獜⪔Л첞ꫫ䣞疢猱綠\uf6a0", 1801715283 - (ViewConfiguration.getTouchSlop() >> 8), "卜揾ѫᧄ", (char) (ViewConfiguration.getFadingEdgeLength() >> 16), "\u0000\u0000\u0000\u0000", objArr);
            throw new IllegalArgumentException(((String) objArr[0]).intern());
        }
        String str2 = this.version;
        if (str2 != null) {
            values2.version = str2;
        }
        String str3 = this.f7412id;
        if (str3 != null) {
            values2.f7412id = str3;
        }
        if (str != null) {
            int i = log + 17;
            getRequestHeaders = i % 128;
            if (i % 2 != 0) {
                values2.kernelId = str;
                throw null;
            }
            values2.kernelId = str;
        }
        String str4 = this.kernel;
        if (str4 != null) {
            values2.kernel = str4;
        }
        String str5 = this.kernelPatch;
        if (str5 != null) {
            log = (getRequestHeaders + 87) % 128;
            values2.kernelPatch = str5;
        } else if (this.kernel != null) {
            values2.kernelPatch = values;
        }
        com.apiguard3.network.UriFilter uriFilter = this.uriFilter;
        if (!(uriFilter == null)) {
            values2.uriFilter = uriFilter.valueOf();
        }
        String str6 = this.updateURL;
        if (str6 != null) {
            values2.updateURL = str6;
        }
        Map<String, String> map = this.updateURLMap;
        if (map != null) {
            values2.updateURLMap = map;
        }
        String str7 = this.updateHeaderName;
        if (str7 != null) {
            values2.updateHeaderName = str7;
        }
        String str8 = this.nativeSignalHeaderPrefix;
        if (str8 != null) {
            log = (getRequestHeaders + 69) % 128;
            values2.nativeSignalHeaderPrefix = str8;
        }
        long j = this.ttlInMilliSeconds;
        if (j > 0) {
            values2.ttlInMilliSeconds = j;
        }
        long j2 = this.updateTimeoutInMilliseconds;
        if (j2 > 0) {
            int i2 = getRequestHeaders + 41;
            log = i2 % 128;
            if (i2 % 2 == 0) {
                values2.updateTimeoutInMilliseconds = j2;
                throw new ArithmeticException();
            }
            values2.updateTimeoutInMilliseconds = j2;
        }
        long j3 = this.minUpdateIntervalInMilliseconds;
        if (j3 > 0) {
            values2.minUpdateIntervalInMilliseconds = j3;
        }
        long j4 = this.maxUpdateIntervalInMilliseconds;
        if (j4 > 0) {
            values2.maxUpdateIntervalInMilliseconds = j4;
        }
        int i3 = this.urlXsumMaxLength;
        if (i3 >= 0) {
            values2.urlXsumMaxLength = i3;
        }
        int i4 = this.bodyXsumMaxLength;
        if (i4 >= 0) {
            values2.bodyXsumMaxLength = i4;
        }
        UriFilter uriFilter2 = this.uriFilter2;
        if (uriFilter2 != null) {
            values2.uriFilter2 = uriFilter2;
        }
        UriFilter uriFilter3 = this.uriBypass2;
        if (uriFilter3 != null) {
            int i5 = log + 55;
            getRequestHeaders = i5 % 128;
            if (i5 % 2 != 0) {
                values2.uriBypass2 = uriFilter3;
                throw null;
            }
            values2.uriBypass2 = uriFilter3;
        }
        Boolean bool = this.storePersistentID;
        if (bool != null) {
            values2.storePersistentID = bool;
        }
        Boolean bool2 = this.cvmEnabled;
        if (bool2 != null) {
            values2.cvmEnabled = bool2;
        }
        Integer num = this.debugLevel;
        if (num != null) {
            values2.APIGuard(num);
        }
        Boolean bool3 = this.nativeHeaderCachingEnabled;
        if (bool3 != null) {
            values2.AGState(bool3.booleanValue());
        }
        Integer num2 = this.support;
        if (num2 != null) {
            values2.APIGuard(num2.intValue());
        }
        Integer num3 = this.rtd;
        if (num3 != null) {
            values2.values(num3.intValue());
        }
        if ((values2.version != null) && values2.f7412id != null && values2.kernelId != null && values2.kernel != null && values2.uriFilter != null && values2.updateURL != null) {
            int i6 = getRequestHeaders;
            log = (i6 + 23) % 128;
            if (values2.updateURLMap != null) {
                String str9 = values2.updateHeaderName;
                if ((str9 != null ? 'M' : ';') == 'M' && values2.nativeSignalHeaderPrefix != null) {
                    int i7 = i6 + 73;
                    int i8 = i7 % 128;
                    log = i8;
                    if (i7 % 2 == 0) {
                        long j5 = values2.ttlInMilliSeconds;
                        throw new ArithmeticException();
                    } else if (-1 != values2.ttlInMilliSeconds && -1 != values2.updateTimeoutInMilliseconds) {
                        int i9 = i8 + 3;
                        getRequestHeaders = i9 % 128;
                        if (i9 % 2 != 0) {
                            long j6 = values2.minUpdateIntervalInMilliseconds;
                            throw new NullPointerException();
                        } else if (-1 != values2.minUpdateIntervalInMilliseconds && -1 != values2.maxUpdateIntervalInMilliseconds && -1 != values2.urlXsumMaxLength) {
                            if ((-1 != values2.bodyXsumMaxLength ? (char) 16 : '%') == 16) {
                                if ((values2.uriFilter2 != null) && values2.uriBypass2 != null) {
                                    if (str9.isEmpty()) {
                                        Object[] objArr2 = new Object[1];
                                        APIGuard("\uee26럁巭\ue398覌⾬\uf51b魇ⅵ윘洶㌺\ud8c4纸қꪏ炼ᙐ뱊䉴\ue859踾吪\ufdcf菰⦬쾊閫㭂셜朣ഒ파礲Ớ꒶䫨Ⴠ뚭屓\ue249衩⸒", 23017 - View.combineMeasuredStates(0, 0), objArr2);
                                        throw new IllegalArgumentException(((String) objArr2[0]).intern());
                                    } else if (values2.nativeSignalHeaderPrefix.isEmpty()) {
                                        Object[] objArr3 = new Object[1];
                                        APIGuard("\uee23呿骟생ݷ䶷뎟\uf67b㲼拁ꤝ\uefbd嗅顚\udeafӵ䬜놪\uf7fe㨖怑ꛬ\ued0e单駠\udc76Ɏ䣹輪\uf55e㯗縨ꑌ\uea88儮霴\udd80Β䙩貉\uf2d9㥳羶", TextUtils.getOffsetBefore("", 0) + 47699, objArr3);
                                        throw new IllegalArgumentException(((String) objArr3[0]).intern());
                                    } else {
                                        if (!(this.cvmCodeMap == null) && this.cvmDigestMap != null) {
                                            int i10 = log + 103;
                                            getRequestHeaders = i10 % 128;
                                            if (i10 % 2 != 0) {
                                                Map<String, String> map2 = values2.cvmCodeMap;
                                                throw new ArithmeticException();
                                            }
                                            if (values2.cvmCodeMap == null) {
                                                values2.cvmCodeMap = new HashMap();
                                            }
                                            if (values2.cvmDigestMap == null) {
                                                values2.cvmDigestMap = new HashMap();
                                            }
                                            for (String str10 : this.cvmCodeMap.keySet()) {
                                                try {
                                                    String str11 = this.cvmCodeMap.get(str10);
                                                    String str12 = this.cvmDigestMap.get(str10);
                                                    String str13 = values2.cvmDigestMap.get(str10);
                                                    if ((str13 == null) || !str13.equalsIgnoreCase(str12)) {
                                                        values2.cvmCodeMap.put(str10, str11);
                                                        values2.cvmDigestMap.put(str10, str12);
                                                    }
                                                } catch (Exception unused) {
                                                    readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.E$CvmPayloadSerializationProxy);
                                                }
                                            }
                                        }
                                        return values2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Object[] objArr4 = new Object[1];
        APIGuard("\uee04釮ᆴ酅ᄔ鄼ჯ邳ၑ逝ၯ鏡Ꮎ鍊ጝ錧ዺ銥ቕ鈛ሽ闵ᖼ镈ᕕ锻ᓯ钷ᑂ鐝ᐭ韷ឈ靄", ExpandableListView.getPackedPositionType(0L) + 32717, objArr4);
        throw new IllegalArgumentException(((String) objArr4[0]).intern());
    }

    static Integer[] generateHeaders(String str) throws APIGuard {
        try {
            Object[] objArr = new Object[1];
            AGState("䮡\u1259", KeyEvent.keyCodeFromString(""), "\u008a渨蔢䒠", (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 41093), "\u0000\u0000\u0000\u0000", objArr);
            String[] split = str.split(((String) objArr[0]).intern());
            if (split.length <= 0) {
                Object[] objArr2 = new Object[1];
                AGState("徕⼥ᲁ\udd12졇ĝᇘ㥒梒䓘ﯥ⊑뾊晘豓ﾰ迅", (-28082553) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), "蜷卾\uf0feᩭ", (char) (28144 - (ViewConfiguration.getWindowTouchSlop() >> 8)), "\u0000\u0000\u0000\u0000", objArr2);
                throw new APIGuard(((String) objArr2[0]).intern());
            }
            Integer[] numArr = new Integer[split.length];
            int i = 0;
            while (true) {
                if (i < split.length) {
                    log = (getRequestHeaders + 49) % 128;
                    numArr[i] = Integer.valueOf(Integer.parseInt(split[i]));
                    i++;
                } else {
                    getRequestHeaders = (log + 91) % 128;
                    return numArr;
                }
            }
        } catch (Exception unused) {
            Object[] objArr3 = new Object[1];
            AGState("徕⼥ᲁ\udd12졇ĝᇘ㥒梒䓘ﯥ⊑뾊晘豓ﾰ迅", (-28082553) - (ViewConfiguration.getPressedStateDuration() >> 16), "蜷卾\uf0feᩭ", (char) (28144 - KeyEvent.getDeadChar(0, 0)), "\u0000\u0000\u0000\u0000", objArr3);
            throw new APIGuard(((String) objArr3[0]).intern());
        }
    }

    public static Config AGState(String str, Config config) throws APIGuard, JSONException {
        Config AGState2 = AGState(new JSONObject(str), config);
        log = (getRequestHeaders + 97) % 128;
        return AGState2;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x04a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0304 A[Catch: Exception -> 0x04af, APIGuard -> 0x04b7, TryCatch #7 {APIGuard -> 0x04b7, Exception -> 0x04af, blocks: (B:11:0x0075, B:13:0x0150, B:15:0x0177, B:17:0x01a9, B:19:0x01d9, B:21:0x0209, B:23:0x023f, B:25:0x0267, B:31:0x028d, B:33:0x02d4, B:38:0x0304, B:40:0x0327, B:42:0x034b), top: B:141:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x034b A[Catch: Exception -> 0x04af, APIGuard -> 0x04b7, TRY_LEAVE, TryCatch #7 {APIGuard -> 0x04b7, Exception -> 0x04af, blocks: (B:11:0x0075, B:13:0x0150, B:15:0x0177, B:17:0x01a9, B:19:0x01d9, B:21:0x0209, B:23:0x023f, B:25:0x0267, B:31:0x028d, B:33:0x02d4, B:38:0x0304, B:40:0x0327, B:42:0x034b), top: B:141:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0451  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.apiguard3.domain.Config AGState(org.json.JSONObject r34, com.apiguard3.domain.Config r35) throws com.apiguard3.domain.APIGuard {
        /*
            Method dump skipped, instructions count: 1225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.AGState(org.json.JSONObject, com.apiguard3.domain.Config):com.apiguard3.domain.Config");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if ((r11.length != 3 ? '^' : '8') != '^') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if ((r11.length != 2 ? ':' : '4') != '4') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        com.apiguard3.internal.readResolve.valueOf(com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.values, com.apiguard3.internal.writeReplace.APIGuard.gt);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        r0 = android.util.Base64.decode(r11[0], 10);
        r4 = android.util.Base64.decode(r11[1], 10);
        r11 = com.apiguard3.domain.Config.getSharedInstance.get(r11[2]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
    
        if (r11 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        com.apiguard3.internal.readResolve.valueOf(com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.values, com.apiguard3.internal.writeReplace.APIGuard.f7415de);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
    
        r11 = r11.AGState(r0, r4);
        r1 = new java.lang.Object[1];
        APIGuard("\uee18\uf7ac\udd61ꍿ袡", (android.view.ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6581, r1);
        r0 = new java.lang.String(r11, java.nio.charset.Charset.forName(((java.lang.String) r1[0]).intern()));
        r11 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.APIGuard;
        r1 = new java.lang.StringBuilder();
        r2 = new java.lang.Object[1];
        AGState("༰홂Ł⬛㟎咳险ῗⓥີ◿\uee80딧\ue712赐醗覎ᥪ砫꡴", android.graphics.Color.blue(0), "涺巈胻曤", (char) (android.view.ViewConfiguration.getScrollBarFadeDuration() >> 16), "\u0000\u0000\u0000\u0000", r2);
        r1.append(((java.lang.String) r2[0]).intern());
        r1.append(r0);
        com.apiguard3.internal.readResolve.values(r11, r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e7, code lost:
    
        r11 = new org.json.JSONObject(r0);
        r0 = r11.keys();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f4, code lost:
    
        if (r0.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f6, code lost:
    
        com.apiguard3.domain.Config.log = (com.apiguard3.domain.Config.getRequestHeaders + 111) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fe, code lost:
    
        r1 = r0.next();
        r10.accumulate(r1, r11.get(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x010c, code lost:
    
        com.apiguard3.internal.readResolve.valueOf(com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.values, com.apiguard3.internal.writeReplace.APIGuard.gc);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject AGState(org.json.JSONObject r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.AGState(org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    private static String values(JSONObject jSONObject, String str) throws JSONException {
        int i = getRequestHeaders + 35;
        log = i % 128;
        if (i % 2 == 0) {
            jSONObject.has(str);
            throw new NullPointerException();
        }
        String str2 = jSONObject.has(str) ? (String) jSONObject.get(str) : null;
        getRequestHeaders = (log + 87) % 128;
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Integer APIGuard(org.json.JSONObject r11) {
        /*
            int r0 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r1 = android.view.ViewConfiguration.getTapTimeout()
            int r1 = r1 >> 16
            int r1 = r1 + 11316
            char r5 = (char) r1
            r1 = 1
            java.lang.Object[] r8 = new java.lang.Object[r1]
            int r3 = r0 >> 16
            java.lang.String r2 = "擟峩"
            java.lang.String r4 = "䠔骭㒋ࠬ"
            java.lang.String r6 = "\u0000\u0000\u0000\u0000"
            r7 = r8
            AGState(r2, r3, r4, r5, r6, r7)
            r0 = 0
            r2 = r8[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = r11.has(r2)
            r3 = 0
            if (r2 == 0) goto L70
            int r2 = android.view.ViewConfiguration.getDoubleTapTimeout()     // Catch: java.lang.Exception -> L64
            java.lang.String r4 = ""
            int r4 = android.view.MotionEvent.axisFromString(r4)     // Catch: java.lang.Exception -> L64
            int r4 = 11315 - r4
            char r8 = (char) r4     // Catch: java.lang.Exception -> L64
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L64
            java.lang.String r5 = "擟峩"
            int r6 = r2 >> 16
            java.lang.String r7 = "䠔骭㒋ࠬ"
            java.lang.String r9 = "\u0000\u0000\u0000\u0000"
            r10 = r4
            AGState(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L64
            r2 = r4[r0]     // Catch: java.lang.Exception -> L64
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L64
            java.lang.String r2 = r2.intern()     // Catch: java.lang.Exception -> L64
            int r11 = r11.getInt(r2)     // Catch: java.lang.Exception -> L64
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Exception -> L64
            int r2 = com.apiguard3.domain.Config.getRequestHeaders
            int r2 = r2 + 39
            int r2 = r2 % 128
            com.apiguard3.domain.Config.log = r2
            goto L71
        L64:
            r11 = move-exception
            com.apiguard3.internal.ConfigInstance$ConfigSerializationProxy$values r2 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.values
            com.apiguard3.internal.writeReplace$APIGuard r4 = com.apiguard3.internal.writeReplace.APIGuard.rm
            java.lang.String r11 = r11.toString()
            com.apiguard3.internal.readResolve.getSharedInstance(r2, r4, r11)
        L70:
            r11 = r3
        L71:
            int r2 = com.apiguard3.domain.Config.getRequestHeaders
            int r2 = r2 + 125
            int r4 = r2 % 128
            com.apiguard3.domain.Config.log = r4
            int r2 = r2 % 2
            if (r2 != 0) goto L7e
            r0 = 1
        L7e:
            if (r0 == r1) goto L81
            return r11
        L81:
            throw r3     // Catch: java.lang.Throwable -> L82
        L82:
            r11 = move-exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.APIGuard(org.json.JSONObject):java.lang.Integer");
    }

    private static Boolean getSharedInstance(JSONObject jSONObject) {
        getRequestHeaders = (log + 73) % 128;
        Object[] objArr = new Object[1];
        AGState("\uf7ac璜隼k\uef5d节Ḯ⟠", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1, "쭋爅\ue689耬", (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), "\u0000\u0000\u0000\u0000", objArr);
        Boolean bool = null;
        if ((jSONObject.has(((String) objArr[0]).intern()) ? '.' : 'I') == '.') {
            try {
                Object[] objArr2 = new Object[1];
                AGState("\uf7ac璜隼k\uef5d节Ḯ⟠", TextUtils.getTrimmedLength(""), "쭋爅\ue689耬", (char) (ViewConfiguration.getLongPressTimeout() >> 16), "\u0000\u0000\u0000\u0000", objArr2);
                bool = Boolean.valueOf(jSONObject.getBoolean(((String) objArr2[0]).intern()));
                getRequestHeaders = (log + 19) % 128;
            } catch (Exception e) {
                readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.BHT, e.toString());
            }
        }
        return bool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        if ((r10.has(((java.lang.String) r6[0]).intern()) ? 'Z' : '+') != 'Z') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:
    
        if (r10.has(((java.lang.String) r6[0]).intern()) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean values(org.json.JSONObject r10) {
        /*
            int r0 = com.apiguard3.domain.Config.getRequestHeaders
            int r0 = r0 + 95
            int r1 = r0 % 128
            com.apiguard3.domain.Config.log = r1
            int r0 = r0 % 2
            r1 = 67
            if (r0 != 0) goto L11
            r0 = 44
            goto L13
        L11:
            r0 = 67
        L13:
            r2 = 1
            r3 = 0
            java.lang.String r4 = "\uee28\udc8e譶瘨⒕ፉ\ude00負筨"
            r5 = 0
            if (r0 == r1) goto L44
            float r0 = android.media.AudioTrack.getMinVolume()
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r7 = 519(0x207, float:7.27E-43)
            r8 = 1073741824(0x40000000, float:2.0)
            r9 = 90
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            int r0 = r7 >>> r0
            APIGuard(r4, r0, r6)
            r0 = r6[r5]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            boolean r0 = r10.has(r0)
            if (r0 == 0) goto L3f
            r0 = 90
            goto L41
        L3f:
            r0 = 43
        L41:
            if (r0 == r9) goto L60
            goto L8f
        L44:
            float r0 = android.media.AudioTrack.getMinVolume()
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r7 = 0
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            int r0 = 12973 - r0
            APIGuard(r4, r0, r6)
            r0 = r6[r5]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            boolean r0 = r10.has(r0)
            if (r0 == 0) goto L8f
        L60:
            int r0 = android.graphics.Color.alpha(r5)     // Catch: java.lang.Exception -> L83
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L83
            int r0 = r0 + 12973
            APIGuard(r4, r0, r2)     // Catch: java.lang.Exception -> L83
            r0 = r2[r5]     // Catch: java.lang.Exception -> L83
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L83
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> L83
            boolean r10 = r10.getBoolean(r0)     // Catch: java.lang.Exception -> L83
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Exception -> L83
            int r10 = com.apiguard3.domain.Config.log
            int r10 = r10 + r1
            int r10 = r10 % 128
            com.apiguard3.domain.Config.getRequestHeaders = r10
            goto L8f
        L83:
            r10 = move-exception
            com.apiguard3.internal.ConfigInstance$ConfigSerializationProxy$values r0 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.values
            com.apiguard3.internal.writeReplace$APIGuard r1 = com.apiguard3.internal.writeReplace.APIGuard.UriFilter$UrlTest
            java.lang.String r10 = r10.toString()
            com.apiguard3.internal.readResolve.getSharedInstance(r0, r1, r10)
        L8f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.values(org.json.JSONObject):java.lang.Boolean");
    }

    private static Integer AGState(JSONObject jSONObject) {
        String obj;
        Object[] objArr = new Object[1];
        AGState("嚓䨱\u0ee0\u0e79愠ઈꅙ", 234818978 - Color.green(0), "ꋒ－\uee0d봻", (char) (ViewConfiguration.getEdgeSlop() >> 16), "\u0000\u0000\u0000\u0000", objArr);
        Integer num = null;
        if ((jSONObject.has(((String) objArr[0]).intern()) ? (char) 24 : '\b') == 24) {
            log = (getRequestHeaders + 17) % 128;
            try {
                Object[] objArr2 = new Object[1];
                AGState("嚓䨱\u0ee0\u0e79愠ઈꅙ", 234818978 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), "ꋒ－\uee0d봻", (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), "\u0000\u0000\u0000\u0000", objArr2);
                num = Integer.valueOf(jSONObject.getInt(((String) objArr2[0]).intern()));
            } catch (JSONException e) {
                readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.UrlMatcher, e.getMessage());
            }
        }
        ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.AGState;
        writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.UrlMatcher;
        if (num != null) {
            obj = num.toString();
        } else {
            Object[] objArr3 = new Object[1];
            APIGuard("\uee03뇟其", 24510 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr3);
            obj = ((String) objArr3[0]).intern();
            log = (getRequestHeaders + 53) % 128;
        }
        readResolve.getSharedInstance(valuesVar, aPIGuard, obj);
        getRequestHeaders = (log + 119) % 128;
        return num;
    }

    private static Integer getRequestHeaders(JSONObject jSONObject) throws APIGuard {
        log = (getRequestHeaders + 99) % 128;
        Integer num = -1;
        int maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        Object[] objArr = new Object[1];
        AGState("뇒͈㱵侔浸毙⫁\udea7饰☦Ḝ辇붔\ue51d鮞抛붌", 670174084 - (maximumFlingVelocity >> 16), "蒔\uf20b㠧〈", (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 10551), "\u0000\u0000\u0000\u0000", objArr);
        if (jSONObject.has(((String) objArr[0]).intern())) {
            try {
                int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
                Object[] objArr2 = new Object[1];
                AGState("뇒͈㱵侔浸毙⫁\udea7饰☦Ḝ辇붔\ue51d鮞抛붌", 670174084 - (scrollBarFadeDuration >> 16), "蒔\uf20b㠧〈", (char) (10551 - MotionEvent.axisFromString("")), "\u0000\u0000\u0000\u0000", objArr2);
                num = Integer.valueOf(jSONObject.getInt(((String) objArr2[0]).intern()));
                if (num.intValue() < 0) {
                    throw new APIGuard(writeReplace.valueOf.parseResponseHeaders);
                }
            } catch (Exception unused) {
                throw new APIGuard(writeReplace.valueOf.parseResponseHeaders);
            }
        }
        log = (getRequestHeaders + 31) % 128;
        return num;
    }

    private static Integer generateHeaders(JSONObject jSONObject) throws APIGuard {
        log = (getRequestHeaders + 115) % 128;
        Integer num = -1;
        Object[] objArr = new Object[1];
        AGState("ⴧꕉ࠻纄ุ騨ﱠ뚇ᓠ㳜湤\uf2d0䣥烙\udd4b䭉퍵\ufd4c", ImageFormat.getBitsPerPixel(0) + 1, "承\u0bdb蘗娛", (char) ((ViewConfiguration.getTapTimeout() >> 16) + 7046), "\u0000\u0000\u0000\u0000", objArr);
        if ((jSONObject.has(((String) objArr[0]).intern()) ? 'I' : (char) 23) != 23) {
            getRequestHeaders = (log + 65) % 128;
            try {
                Object[] objArr2 = new Object[1];
                AGState("ⴧꕉ࠻纄ุ騨ﱠ뚇ᓠ㳜湤\uf2d0䣥烙\udd4b䭉퍵\ufd4c", ViewConfiguration.getJumpTapTimeout() >> 16, "承\u0bdb蘗娛", (char) (TextUtils.lastIndexOf("", '0', 0) + 7047), "\u0000\u0000\u0000\u0000", objArr2);
                num = Integer.valueOf(jSONObject.getInt(((String) objArr2[0]).intern()));
                if (num.intValue() < 0) {
                    throw new APIGuard(writeReplace.valueOf.parseResponseHeaders);
                }
            } catch (Exception unused) {
                throw new APIGuard(writeReplace.valueOf.initialize);
            }
        }
        return num;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0059, code lost:
    
        if (r9.has(((java.lang.String) r3[1]).intern()) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005b, code lost:
    
        r1 = new java.lang.Object[1];
        APIGuard("\uee20椻\ue01b筝\uf261䵚쒦徘횐凋ꣅ⏄물㈔赹ѵ齑", android.graphics.drawable.Drawable.resolveOpacity(0, 0) + 34583, r1);
        r0 = java.lang.Long.valueOf(r9.getLong(((java.lang.String) r1[0]).intern()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0080, code lost:
    
        if (r0.longValue() <= 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
    
        throw new com.apiguard3.domain.APIGuard(com.apiguard3.internal.writeReplace.valueOf.getRequestHeaders);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
    
        throw new com.apiguard3.domain.APIGuard(com.apiguard3.internal.writeReplace.valueOf.getRequestHeaders);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
    
        if (r9.has(((java.lang.String) r3[0]).intern()) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Long parseResponseHeaders(org.json.JSONObject r9) throws com.apiguard3.domain.APIGuard {
        /*
            int r0 = com.apiguard3.domain.Config.getRequestHeaders
            int r0 = r0 + 123
            int r1 = r0 % 128
            com.apiguard3.domain.Config.log = r1
            int r0 = r0 % 2
            r1 = 10
            if (r0 != 0) goto L11
            r0 = 10
            goto L13
        L11:
            r0 = 39
        L13:
            r2 = 34584(0x8718, float:4.8463E-41)
            java.lang.String r3 = ""
            r4 = -1
            java.lang.String r6 = "\uee20椻\ue01b筝\uf261䵚쒦徘횐凋ꣅ⏄물㈔赹ѵ齑"
            r7 = 1
            r8 = 0
            if (r0 == r1) goto L3e
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            int r1 = android.view.MotionEvent.axisFromString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r7]
            int r1 = r1 + r2
            APIGuard(r6, r1, r3)
            r1 = r3[r8]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            boolean r1 = r9.has(r1)
            if (r1 == 0) goto L93
            goto L5b
        L3e:
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            int r1 = android.view.MotionEvent.axisFromString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r8]
            int r1 = r2 >>> r1
            APIGuard(r6, r1, r3)
            r1 = r3[r7]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            boolean r1 = r9.has(r1)
            if (r1 == 0) goto L93
        L5b:
            int r0 = android.graphics.drawable.Drawable.resolveOpacity(r8, r8)     // Catch: java.lang.Exception -> L8b
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L8b
            r2 = 34583(0x8717, float:4.8461E-41)
            int r0 = r0 + r2
            APIGuard(r6, r0, r1)     // Catch: java.lang.Exception -> L8b
            r0 = r1[r8]     // Catch: java.lang.Exception -> L8b
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L8b
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> L8b
            long r0 = r9.getLong(r0)     // Catch: java.lang.Exception -> L8b
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Exception -> L8b
            long r1 = r0.longValue()     // Catch: java.lang.Exception -> L8b
            r3 = 0
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 <= 0) goto L83
            goto L93
        L83:
            com.apiguard3.domain.APIGuard r9 = new com.apiguard3.domain.APIGuard     // Catch: java.lang.Exception -> L8b
            com.apiguard3.internal.writeReplace$valueOf r0 = com.apiguard3.internal.writeReplace.valueOf.getRequestHeaders     // Catch: java.lang.Exception -> L8b
            r9.<init>(r0)     // Catch: java.lang.Exception -> L8b
            throw r9     // Catch: java.lang.Exception -> L8b
        L8b:
            com.apiguard3.domain.APIGuard r9 = new com.apiguard3.domain.APIGuard
            com.apiguard3.internal.writeReplace$valueOf r0 = com.apiguard3.internal.writeReplace.valueOf.getRequestHeaders
            r9.<init>(r0)
            throw r9
        L93:
            int r9 = com.apiguard3.domain.Config.getRequestHeaders
            int r9 = r9 + 115
            int r1 = r9 % 128
            com.apiguard3.domain.Config.log = r1
            int r9 = r9 % 2
            if (r9 != 0) goto La0
            goto La1
        La0:
            r7 = 0
        La1:
            if (r7 != 0) goto La4
            return r0
        La4:
            r9 = 0
            throw r9     // Catch: java.lang.Throwable -> La6
        La6:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.parseResponseHeaders(org.json.JSONObject):java.lang.Long");
    }

    private static Long initialize(JSONObject jSONObject) throws APIGuard {
        Long l = -1L;
        AGState("햠\ue67b걺屩쪠ᒘ厴칁霚１揣沈崬鉨", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), "廏綌\ue3ae쾽", (char) (48611 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), "\u0000\u0000\u0000\u0000", new Object[1]);
        if ((!jSONObject.has(((String) r11[0]).intern())) == false) {
            log = (getRequestHeaders + 89) % 128;
            try {
                Object[] objArr = new Object[1];
                AGState("햠\ue67b걺屩쪠ᒘ厴칁霚１揣沈崬鉨", ViewConfiguration.getScrollBarSize() >> 8, "廏綌\ue3ae쾽", (char) (TextUtils.indexOf("", "", 0, 0) + 48611), "\u0000\u0000\u0000\u0000", objArr);
                l = Long.valueOf(jSONObject.getLong(((String) objArr[0]).intern()));
                if (l.longValue() <= 0) {
                    throw new APIGuard(writeReplace.valueOf.analyzeResponse);
                }
            } catch (Exception unused) {
                throw new APIGuard(writeReplace.valueOf.analyzeResponse);
            }
        }
        getRequestHeaders = (log + 41) % 128;
        return l;
    }

    private static Long analyzeResponse(JSONObject jSONObject) throws APIGuard {
        Long l = -1L;
        Object[] objArr = new Object[1];
        AGState("儱ꊯ⯳⩂\ua8cb䮜齧Პ\uf446\ueec5砸膏ᢉ", 972475513 - View.MeasureSpec.getMode(0), "礷\uf6cc䈹㴌", (char) (3138 - (ViewConfiguration.getLongPressTimeout() >> 16)), "\u0000\u0000\u0000\u0000", objArr);
        if (jSONObject.has(((String) objArr[0]).intern())) {
            log = (getRequestHeaders + 15) % 128;
            try {
                int rgb = Color.rgb(0, 0, 0);
                Object[] objArr2 = new Object[1];
                AGState("儱ꊯ⯳⩂\ua8cb䮜齧Პ\uf446\ueec5砸膏ᢉ", rgb + 989252729, "礷\uf6cc䈹㴌", (char) (3138 - ExpandableListView.getPackedPositionType(0L)), "\u0000\u0000\u0000\u0000", objArr2);
                l = Long.valueOf(jSONObject.getLong(((String) objArr2[0]).intern()));
                if (l.longValue() <= 0) {
                    throw new APIGuard(writeReplace.valueOf.generateHeaders);
                }
            } catch (Exception unused) {
                throw new APIGuard(writeReplace.valueOf.generateHeaders);
            }
        }
        getRequestHeaders = (log + 101) % 128;
        return l;
    }

    private static Long checkCertificates(JSONObject jSONObject) throws APIGuard {
        log = (getRequestHeaders + 57) % 128;
        Long l = -1L;
        Object[] objArr = new Object[1];
        APIGuard("\uee39犖흿", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 40110, objArr);
        if (jSONObject.has(((String) objArr[0]).intern())) {
            getRequestHeaders = (log + 45) % 128;
            try {
                Object[] objArr2 = new Object[1];
                APIGuard("\uee39犖흿", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 40110, objArr2);
                l = Long.valueOf(jSONObject.getLong(((String) objArr2[0]).intern()));
                if (l.longValue() <= 0) {
                    throw new APIGuard(writeReplace.valueOf.AGState);
                }
                getRequestHeaders = (log + 47) % 128;
            } catch (Exception unused) {
                throw new APIGuard(writeReplace.valueOf.AGState);
            }
        }
        return l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004f, code lost:
    
        if (r8.has(((java.lang.String) r7[0]).intern()) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        r0 = com.apiguard3.domain.Config.getRequestHeaders + 101;
        com.apiguard3.domain.Config.log = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        if ((r0 % 2) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        r0 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        r0 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if (r0 == 2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        r1 = new java.lang.Object[1];
        APIGuard("\uee38⚼缫랯창ҭ崞閘ꨉ", 51328 - android.text.TextUtils.lastIndexOf("", '0', 0, 0), r1);
        r4 = (java.lang.String) r8.get(((java.lang.String) r1[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0086, code lost:
    
        if (analyzeResponse(r4) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0089, code lost:
    
        r1 = new java.lang.Object[1];
        APIGuard("\uee38⚼缫랯창ҭ崞閘ꨉ", 51328 % android.text.TextUtils.lastIndexOf("", 6, 1, 1), r1);
        r4 = (java.lang.String) r8.get(((java.lang.String) r1[1]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
    
        if (analyzeResponse(r4) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
    
        throw new com.apiguard3.domain.APIGuard(com.apiguard3.internal.writeReplace.valueOf.getState);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b2, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if ((!r8.has(((java.lang.String) r7[0]).intern())) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String updateKernel(org.json.JSONObject r8) throws org.json.JSONException, com.apiguard3.domain.APIGuard {
        /*
            int r0 = com.apiguard3.domain.Config.getRequestHeaders
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.apiguard3.domain.Config.log = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r4 = 0
            r5 = 51329(0xc881, float:7.1927E-41)
            java.lang.String r6 = "\uee38⚼缫랯창ҭ崞閘ꨉ"
            if (r0 == 0) goto L37
            int r0 = android.os.Process.myTid()
            java.lang.Object[] r7 = new java.lang.Object[r3]
            int r0 = r0 + 57
            int r0 = r0 + r5
            APIGuard(r6, r0, r7)
            r0 = r7[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            boolean r0 = r8.has(r0)
            r0 = r0 ^ r3
            if (r0 == 0) goto L51
            goto Lb2
        L37:
            int r0 = android.os.Process.myTid()
            java.lang.Object[] r7 = new java.lang.Object[r3]
            int r0 = r0 >> 22
            int r0 = r0 + r5
            APIGuard(r6, r0, r7)
            r0 = r7[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            boolean r0 = r8.has(r0)
            if (r0 == 0) goto Lb2
        L51:
            int r0 = com.apiguard3.domain.Config.getRequestHeaders
            int r0 = r0 + 101
            int r4 = r0 % 128
            com.apiguard3.domain.Config.log = r4
            int r0 = r0 % r1
            if (r0 != 0) goto L5e
            r0 = 2
            goto L60
        L5e:
            r0 = 59
        L60:
            r4 = 51328(0xc880, float:7.1926E-41)
            java.lang.String r5 = ""
            if (r0 == r1) goto L89
            r0 = 48
            int r0 = android.text.TextUtils.lastIndexOf(r5, r0, r2, r2)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            int r4 = r4 - r0
            APIGuard(r6, r4, r1)
            r0 = r1[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.Object r8 = r8.get(r0)
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
            boolean r8 = analyzeResponse(r4)
            if (r8 == 0) goto Laa
            goto Lb2
        L89:
            r0 = 6
            int r0 = android.text.TextUtils.lastIndexOf(r5, r0, r3, r3)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            int r4 = r4 % r0
            APIGuard(r6, r4, r1)
            r0 = r1[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.Object r8 = r8.get(r0)
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
            boolean r8 = analyzeResponse(r4)
            if (r8 == 0) goto Laa
            goto Lb2
        Laa:
            com.apiguard3.domain.APIGuard r8 = new com.apiguard3.domain.APIGuard
            com.apiguard3.internal.writeReplace$valueOf r0 = com.apiguard3.internal.writeReplace.valueOf.getState
            r8.<init>(r0)
            throw r8
        Lb2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.updateKernel(org.json.JSONObject):java.lang.String");
    }

    private static String getState(JSONObject jSONObject) throws APIGuard, JSONException {
        String str;
        Object[] objArr = new Object[1];
        AGState("釙蕿兯\ue1c8ʞ\ue24e\uef96엳", Gravity.getAbsoluteGravity(0, 0), "蒶햵ᵖ⦞", (char) Color.alpha(0), "\u0000\u0000\u0000\u0000", objArr);
        if ((jSONObject.has(((String) objArr[0]).intern()) ? (char) 20 : 'L') != 'L') {
            getRequestHeaders = (log + 111) % 128;
            Object[] objArr2 = new Object[1];
            AGState("헭\uee98绺㊊\uea0b悙", MotionEvent.axisFromString("") + 1, "↰Ꮉ雋\uf4e5", (char) (ExpandableListView.getPackedPositionGroup(0L) + 58774), "\u0000\u0000\u0000\u0000", objArr2);
            if (!jSONObject.has(((String) objArr2[0]).intern())) {
                throw new APIGuard(writeReplace.valueOf.checkCertificates);
            }
            Object[] objArr3 = new Object[1];
            AGState("釙蕿兯\ue1c8ʞ\ue24e\uef96엳", TextUtils.indexOf("", "", 0), "蒶햵ᵖ⦞", (char) KeyEvent.keyCodeFromString(""), "\u0000\u0000\u0000\u0000", objArr3);
            str = (String) jSONObject.get(((String) objArr3[0]).intern());
        } else {
            str = null;
        }
        int i = log + 109;
        getRequestHeaders = i % 128;
        if ((i % 2 != 0 ? Typography.greater : 'P') != '>') {
            return str;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0075, code lost:
    
        if (r14.has(((java.lang.String) r1[0]).intern()) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a0, code lost:
    
        if (r14.has(((java.lang.String) r2[0]).intern()) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a2, code lost:
    
        r2 = new java.lang.Object[1];
        AGState("헭\uee98绺㊊\uea0b悙", android.view.ViewConfiguration.getScrollDefaultDelay() >> 16, "↰Ꮉ雋\uf4e5", (char) (58773 - android.widget.ExpandableListView.getPackedPositionChild(0)), "\u0000\u0000\u0000\u0000", r2);
        r14 = (java.lang.String) r14.get(((java.lang.String) r2[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00d3, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f5, code lost:
    
        throw new com.apiguard3.domain.APIGuard(com.apiguard3.internal.writeReplace.valueOf.log);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fd, code lost:
    
        throw new com.apiguard3.domain.APIGuard(com.apiguard3.internal.writeReplace.valueOf.updateKernel);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String log(org.json.JSONObject r14) throws com.apiguard3.domain.APIGuard, org.json.JSONException {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.log(org.json.JSONObject):java.lang.String");
    }

    static Map<String, String> valueOf(JSONObject jSONObject) {
        if (jSONObject == null) {
            int i = log + 81;
            getRequestHeaders = i % 128;
            if (i % 2 == 0) {
                return Collections.emptyMap();
            }
            Collections.emptyMap();
            throw new NullPointerException();
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        log = (getRequestHeaders + 103) % 128;
        while (true) {
            if ((keys.hasNext() ? (char) 5 : '\r') == '\r') {
                return hashMap;
            }
            int i2 = getRequestHeaders + 105;
            log = i2 % 128;
            if (i2 % 2 == 0) {
                String next = keys.next();
                hashMap.put(next, (String) jSONObject.get(next));
                throw new ArithmeticException();
                break;
            }
            String next2 = keys.next();
            try {
                hashMap.put(next2, (String) jSONObject.get(next2));
                log = (getRequestHeaders + 35) % 128;
            } catch (JSONException unused) {
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.onInitializationFailure);
            }
            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.onInitializationFailure);
        }
    }

    static Map<String, String> getSharedInstance(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            getRequestHeaders = (log + 99) % 128;
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if ((keys.hasNext() ? JSONLexer.EOI : (char) 6) == 6) {
                return hashMap;
            }
            getRequestHeaders = (log + 113) % 128;
            String next = keys.next();
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if ((optJSONObject != null ? '@' : '8') != '8') {
                    getRequestHeaders = (log + 1) % 128;
                    hashMap.put(next, (String) optJSONObject.get(str));
                    log = (getRequestHeaders + 77) % 128;
                }
            } catch (JSONException unused) {
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.E$CvmPayloadSerializationProxy);
            }
        }
    }

    static boolean values(Integer[] numArr) {
        if ((numArr != null ? '+' : 'Z') == '+') {
            if ((numArr.length == 0 ? 'D' : '=') != 'D') {
                try {
                    Object[] objArr = new Object[1];
                    AGState("깿釯酿", 7983920 - (Process.myTid() >> 22), "ゐ秓戀쪢", (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 41570), "\u0000\u0000\u0000\u0000", objArr);
                    if ((getSharedInstance(generateHeaders(((String) objArr[0]).intern()), numArr) <= 0 ? (char) 7 : (char) 1) != 1) {
                        log = (getRequestHeaders + 15) % 128;
                        return true;
                    }
                } catch (APIGuard unused) {
                }
                return false;
            }
        }
        getRequestHeaders = (log + 45) % 128;
        return false;
    }

    static int getSharedInstance(Integer[] numArr, Integer[] numArr2) {
        int i;
        int max = Math.max(numArr.length, numArr2.length);
        int i2 = 0;
        while (true) {
            if ((i2 < max ? (char) 17 : InputCardNumberView.DIVIDER) != 17) {
                return 0;
            }
            int intValue = i2 >= numArr.length ? 0 : numArr[i2].intValue();
            if (i2 < numArr2.length) {
                log = (getRequestHeaders + 59) % 128;
                i = numArr2[i2].intValue();
            } else {
                i = 0;
            }
            if ((intValue > i ? '#' : (char) 15) == '#') {
                return 1;
            }
            if (intValue < i) {
                int i3 = getRequestHeaders + 91;
                log = i3 % 128;
                if (i3 % 2 != 0) {
                    return -1;
                }
                throw null;
            }
            i2++;
        }
    }

    public boolean pushMaxPayload() {
        log = (getRequestHeaders + 63) % 128;
        try {
            if (!TextUtils.isEmpty(this.version)) {
                getRequestHeaders = (log + 63) % 128;
                if (values(generateHeaders(this.version)) && !TextUtils.isEmpty(this.kernel) && !TextUtils.isEmpty(this.kernelId) && (!TextUtils.isEmpty(this.f7412id)) != false) {
                    if ((!TextUtils.isEmpty(this.updateURL) ? 'B' : (char) 16) != 16) {
                        if (!(this.updateURLMap == null) && -1 != this.updateTimeoutInMilliseconds) {
                            if (-1 != this.minUpdateIntervalInMilliseconds) {
                                int i = getRequestHeaders + 85;
                                log = i % 128;
                                if ((i % 2 == 0 ? '@' : 'U') != '@') {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        } catch (APIGuard e) {
            readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.valueOf.APIGuard, e.getMessage());
            return false;
        }
    }

    private static boolean analyzeResponse(String str) {
        log = (getRequestHeaders + 121) % 128;
        try {
            if ((!((Boolean) ((Class) AGState.values(6573 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (Color.blue(0) + 1941))).getMethod("getSharedInstance", null).invoke(null, null)).booleanValue()) != false) {
                int i = log + 107;
                getRequestHeaders = i % 128;
                if ((i % 2 != 0 ? 'V' : (char) 27) == 'V') {
                    URLUtil.isHttpsUrl(str);
                    throw null;
                }
                if ((URLUtil.isHttpsUrl(str) ? '2' : 'S') == 'S') {
                    int i2 = getRequestHeaders + 63;
                    log = i2 % 128;
                    if (i2 % 2 != 0) {
                        return false;
                    }
                    throw null;
                }
            }
            return true;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void APIGuard(java.lang.String r7, int r8, java.lang.Object[] r9) {
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
            long r5 = com.apiguard3.domain.Config.analyzeResponse     // Catch: java.lang.Throwable -> L3d
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
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.APIGuard(java.lang.String, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r12 = r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void AGState(java.lang.String r8, int r9, java.lang.String r10, char r11, java.lang.String r12, java.lang.Object[] r13) {
        /*
            if (r12 == 0) goto L6
            char[] r12 = r12.toCharArray()
        L6:
            char[] r12 = (char[]) r12
            if (r10 == 0) goto Le
            char[] r10 = r10.toCharArray()
        Le:
            char[] r10 = (char[]) r10
            if (r8 == 0) goto L16
            char[] r8 = r8.toCharArray()
        L16:
            char[] r8 = (char[]) r8
            java.lang.Object r0 = com.apiguard3.internal.setForegroundGravity.AGState
            monitor-enter(r0)
            java.lang.Object r10 = r10.clone()     // Catch: java.lang.Throwable -> L94
            char[] r10 = (char[]) r10     // Catch: java.lang.Throwable -> L94
            java.lang.Object r12 = r12.clone()     // Catch: java.lang.Throwable -> L94
            char[] r12 = (char[]) r12     // Catch: java.lang.Throwable -> L94
            r1 = 0
            char r2 = r10[r1]     // Catch: java.lang.Throwable -> L94
            r11 = r11 ^ r2
            char r11 = (char) r11     // Catch: java.lang.Throwable -> L94
            r10[r1] = r11     // Catch: java.lang.Throwable -> L94
            r11 = 2
            char r2 = r12[r11]     // Catch: java.lang.Throwable -> L94
            char r9 = (char) r9     // Catch: java.lang.Throwable -> L94
            int r2 = r2 + r9
            char r9 = (char) r2     // Catch: java.lang.Throwable -> L94
            r12[r11] = r9     // Catch: java.lang.Throwable -> L94
            int r9 = r8.length     // Catch: java.lang.Throwable -> L94
            char[] r2 = new char[r9]     // Catch: java.lang.Throwable -> L94
            com.apiguard3.internal.setForegroundGravity.valueOf = r1     // Catch: java.lang.Throwable -> L94
        L3b:
            int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            if (r3 >= r9) goto L8b
            int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r3 = r3 + r11
            int r3 = r3 % 4
            int r4 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r4 = r4 + 3
            int r4 = r4 % 4
            int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r5 = r5 % 4
            char r5 = r10[r5]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 * 32718
            char r6 = r12[r3]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 + r6
            r6 = 65535(0xffff, float:9.1834E-41)
            int r5 = r5 % r6
            char r5 = (char) r5     // Catch: java.lang.Throwable -> L94
            com.apiguard3.internal.setForegroundGravity.APIGuard = r5     // Catch: java.lang.Throwable -> L94
            char r5 = r10[r4]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 * 32718
            char r3 = r12[r3]     // Catch: java.lang.Throwable -> L94
            int r5 = r5 + r3
            int r5 = r5 / r6
            char r3 = (char) r5     // Catch: java.lang.Throwable -> L94
            r12[r4] = r3     // Catch: java.lang.Throwable -> L94
            char r3 = com.apiguard3.internal.setForegroundGravity.APIGuard     // Catch: java.lang.Throwable -> L94
            r10[r4] = r3     // Catch: java.lang.Throwable -> L94
            int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
            char r5 = r8[r5]     // Catch: java.lang.Throwable -> L94
            char r4 = r10[r4]     // Catch: java.lang.Throwable -> L94
            r4 = r4 ^ r5
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L94
            long r6 = com.apiguard3.domain.Config.generateHeaders     // Catch: java.lang.Throwable -> L94
            long r4 = r4 ^ r6
            int r6 = com.apiguard3.domain.Config.initialize     // Catch: java.lang.Throwable -> L94
            long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
            long r4 = r4 ^ r6
            char r6 = com.apiguard3.domain.Config.parseResponseHeaders     // Catch: java.lang.Throwable -> L94
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
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.Config.AGState(java.lang.String, int, java.lang.String, char, java.lang.String, java.lang.Object[]):void");
    }
}
