package fsimpl;

import android.content.Context;
import com.fullstory.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes.dex */
public class bG {

    /* renamed from: a  reason: collision with root package name */
    private static bG f7873a;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private String k = null;
    private int l = 24;
    private int m = 34;
    private int n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f7874o = 10;
    private boolean p = false;
    private String q = null;
    private String r = null;
    private boolean s = false;
    private boolean t = true;
    private boolean u = true;
    private boolean v = false;
    private String w = null;
    private boolean x = true;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private int G = 0;
    private boolean H = false;
    private byte I = 0;
    private boolean J = true;
    private boolean K = false;
    private boolean L = false;
    private Map M = new HashMap();
    private Map N = new HashMap();
    private Map O = new HashMap();
    private Map P = new HashMap();

    private bG() {
    }

    private static byte a(Properties properties, byte b) {
        return !properties.containsKey("com.fullstory.ASYNC_ENABLED") ? b : Boolean.parseBoolean(properties.getProperty("com.fullstory.ASYNC_ENABLED", Boolean.toString(false))) ? (byte) 2 : (byte) 1;
    }

    public static bG a(Context context) {
        bG bGVar;
        synchronized (bG.class) {
            if (f7873a == null) {
                f7873a = new bG().c(context);
            }
            bGVar = f7873a;
        }
        return bGVar;
    }

    private bG a(InputStream inputStream) {
        String obj;
        Properties properties = new Properties();
        properties.load(inputStream);
        this.b = properties.getProperty("com.fullstory.BUILD_ID", this.b);
        this.q = properties.getProperty("com.fullstory.LOG_LEVEL", this.q);
        this.r = properties.getProperty("com.fullstory.LOGCAT_LEVEL", this.r);
        this.h = Boolean.parseBoolean(properties.getProperty("com.fullstory.HANS", Boolean.toString(this.h)));
        this.c = properties.getProperty("com.fullstory.SERVER", this.c);
        this.e = properties.getProperty("com.fullstory.APP_SERVER", this.e);
        this.d = properties.getProperty("com.fullstory.APP_SCHEME", this.d);
        String property = properties.getProperty("com.fullstory.RECORDER", this.f);
        this.f = property;
        this.j = property.startsWith("http://localhost");
        this.k = properties.getProperty("com.fullstory.ORG", this.k);
        this.l = Integer.parseInt(properties.getProperty("com.fullstory.MIN_API", Integer.toString(this.l)));
        this.m = Integer.parseInt(properties.getProperty("com.fullstory.MAX_API", Integer.toString(this.m)));
        this.p = Boolean.parseBoolean(properties.getProperty("com.fullstory.VERBOSE_LOGGING", Boolean.toString(this.p)));
        this.n = Integer.parseInt(properties.getProperty("com.fullstory.SESSION_SETUP_DELAY_MS", Integer.toString(this.n)));
        this.s = Boolean.parseBoolean(properties.getProperty("com.fullstory.ENHANCED_REACT_NATIVE_SUPPORT", Boolean.toString(this.s)));
        this.C = Boolean.parseBoolean(properties.getProperty("com.fullstory.IS_REACT_NATIVE", Boolean.toString(this.C)));
        this.D = Boolean.parseBoolean(properties.getProperty("com.fullstory.IS_CORDOVA", Boolean.toString(this.D)));
        this.E = Boolean.parseBoolean(properties.getProperty("com.fullstory.IS_IONIC", Boolean.toString(this.E)));
        this.F = Boolean.parseBoolean(properties.getProperty("com.fullstory.IS_CAPACITOR", Boolean.toString(this.F)));
        this.t = Boolean.parseBoolean(properties.getProperty("com.fullstory.RECORD_ON_START", Boolean.toString(this.t)));
        this.f7874o = Integer.parseInt(properties.getProperty("com.fullstory.LOW_MEMORY_PERCENT", Integer.toString(this.f7874o)));
        this.v = Boolean.parseBoolean(properties.getProperty("com.fullstory.MASK_ASSETS", Boolean.toString(this.v)));
        this.x = Boolean.parseBoolean(properties.getProperty("com.fullstory.BUG_REPORTING_ENABLED", Boolean.toString(this.x)));
        this.y = Boolean.parseBoolean(properties.getProperty("com.fullstory.COMPOSE_SUPPORT", Boolean.toString(this.y)));
        this.z = Boolean.parseBoolean(properties.getProperty("com.fullstory.FRAGMENT_SUPPORT", Boolean.toString(this.z)));
        this.A = Boolean.parseBoolean(properties.getProperty("com.fullstory.OKHTTP_SUPPORT", Boolean.toString(this.A)));
        this.B = Boolean.parseBoolean(properties.getProperty("com.fullstory.URLCONNECTION_SUPPORT", Boolean.toString(this.B)));
        this.G = Integer.parseInt(properties.getProperty("com.fullstory.COMPOSE_SELECTOR_VERSION", Integer.toString(this.G)));
        this.K = Boolean.parseBoolean(properties.getProperty("com.fullstory.LOG_PRIVACY_RULES", Boolean.toString(this.K)));
        this.w = properties.getProperty("com.fullstory.USER_ID", this.w);
        this.J = Boolean.parseBoolean(properties.getProperty("com.fullstory.WEBVIEW_INJECTION", Boolean.toString(this.J)));
        this.H = Boolean.parseBoolean(properties.getProperty("com.fullstory.PREVIEW_MODE_ENABLED", Boolean.toString(this.H)));
        this.I = a(properties, this.I);
        this.g = Boolean.parseBoolean(properties.getProperty("com.fullstory.USE_PROXY_SERVER", Boolean.toString(this.g)));
        int i = this.f7874o;
        if (i <= 0 || i > 100) {
            this.f7874o = 10;
        }
        for (String str : properties.getProperty("com.fullstory.INTERNAL_FLAGS", "").split(",")) {
            if (!str.isEmpty()) {
                if (str.equalsIgnoreCase("unmasked")) {
                    if (this.h) {
                        this.u = false;
                    }
                } else if (str.equalsIgnoreCase("enableAssertions")) {
                    if (!C0350eu.f7977a) {
                        C0350eu.f7977a = true;
                        obj = "Enabling assertions due to internal flag...";
                        Log.e(obj);
                    }
                } else if (str.equalsIgnoreCase("disableAssertions")) {
                    if (!C0350eu.f7977a) {
                        C0350eu.f7977a = false;
                        obj = "Disabling assertions due to internal flag...";
                        Log.e(obj);
                    }
                } else if (str.equalsIgnoreCase("useLocalProps")) {
                    this.i = true;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown internal flag, ignored: ");
                    sb.append(str);
                    obj = sb.toString();
                    Log.e(obj);
                }
            }
        }
        return this;
    }

    private static int b(String str) {
        return Integer.parseInt(str, 16);
    }

    private bG c(Context context) {
        try {
            InputStream open = context.getAssets().open("fs-config.properties");
            try {
                bG a2 = a(open);
                if (open != null) {
                    open.close();
                }
                if (a2.i) {
                    try {
                        File externalFilesDir = context.getExternalFilesDir(null);
                        if (externalFilesDir != null && externalFilesDir.exists()) {
                            File file = new File(externalFilesDir, "fs-config.properties");
                            if (file.exists()) {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                try {
                                    a2 = a(fileInputStream);
                                    fileInputStream.close();
                                } catch (Throwable th) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused) {
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        cS.a("Error initializing configuration", th2);
                        return null;
                    }
                }
                if (a2.w != null) {
                    new P(context).a("FullStoryUserId", a2.w);
                }
                return a2;
            } catch (Throwable th3) {
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th3;
            }
        } catch (Throwable th4) {
            cS.a("Error initializing configuration", th4);
            return null;
        }
    }

    public Map A() {
        return this.N;
    }

    public Map B() {
        return this.P;
    }

    public boolean C() {
        return this.C;
    }

    public boolean D() {
        return this.D;
    }

    public boolean E() {
        return this.E;
    }

    public boolean F() {
        return this.F;
    }

    public boolean G() {
        return this.H;
    }

    public byte H() {
        return this.I;
    }

    public boolean I() {
        return this.J;
    }

    public boolean J() {
        return this.K;
    }

    public boolean K() {
        return this.g;
    }

    public String a(String str) {
        return (str == null || this.j || K()) ? this.f : str;
    }

    public void a() {
        Log.i("*** Configuration:");
        StringBuilder sb = new StringBuilder();
        sb.append("  buildId = ");
        sb.append(this.b);
        Log.i(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("  serverRoot = ");
        sb2.append(this.c);
        Log.i(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("  appServerRoot = ");
        sb3.append(this.e);
        Log.i(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("  recorderRoot = ");
        sb4.append(this.f);
        Log.i(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("  isRecorderLocal = ");
        sb5.append(this.j);
        Log.i(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("  orgId = ");
        sb6.append(this.k);
        Log.i(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("  minApi = ");
        sb7.append(this.l);
        Log.i(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("  maxApi = ");
        sb8.append(this.m);
        Log.i(sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("  verboseLogging = ");
        sb9.append(this.p);
        Log.i(sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("  sessionSetupDelayMs = ");
        sb10.append(this.n);
        Log.i(sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append("  masked = ");
        sb11.append(this.u);
        Log.i(sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append("  mask assets = ");
        sb12.append(this.v);
        Log.i(sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append("  appScheme = ");
        sb13.append(this.d);
        Log.i(sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append("  isFromHans = ");
        sb14.append(this.h);
        Log.i(sb14.toString());
        StringBuilder sb15 = new StringBuilder();
        sb15.append("  enhancedReactNativeSupport = ");
        sb15.append(this.s);
        Log.i(sb15.toString());
        StringBuilder sb16 = new StringBuilder();
        sb16.append("  logLevel = ");
        sb16.append(this.q);
        Log.i(sb16.toString());
        StringBuilder sb17 = new StringBuilder();
        sb17.append("  parsed logLevel = ");
        sb17.append(Log.getLevel());
        Log.i(sb17.toString());
        StringBuilder sb18 = new StringBuilder();
        sb18.append("  logcatLevel = ");
        sb18.append(this.r);
        Log.i(sb18.toString());
        StringBuilder sb19 = new StringBuilder();
        sb19.append("  parsed logcatLevel = ");
        sb19.append(Log.getLogcatLevel());
        Log.i(sb19.toString());
        StringBuilder sb20 = new StringBuilder();
        sb20.append("  low mem % = ");
        sb20.append(this.f7874o);
        Log.i(sb20.toString());
        StringBuilder sb21 = new StringBuilder();
        sb21.append("  bugReportingEnabled = ");
        sb21.append(this.x);
        Log.i(sb21.toString());
        StringBuilder sb22 = new StringBuilder();
        sb22.append("  composeSupport = ");
        sb22.append(this.y);
        Log.i(sb22.toString());
        StringBuilder sb23 = new StringBuilder();
        sb23.append("  fragmentSupport = ");
        sb23.append(this.z);
        Log.i(sb23.toString());
        StringBuilder sb24 = new StringBuilder();
        sb24.append("  okHttpSupport = ");
        sb24.append(this.A);
        Log.i(sb24.toString());
        StringBuilder sb25 = new StringBuilder();
        sb25.append("  urlConnectionSupport = ");
        sb25.append(this.B);
        Log.i(sb25.toString());
        StringBuilder sb26 = new StringBuilder();
        sb26.append("  composeSelectorVersion = ");
        sb26.append(this.G);
        Log.i(sb26.toString());
        StringBuilder sb27 = new StringBuilder();
        sb27.append("  webViewInjectionEnabled = ");
        sb27.append(this.J);
        Log.i(sb27.toString());
        StringBuilder sb28 = new StringBuilder();
        sb28.append("  isLogPrivacyRules = ");
        sb28.append(this.K);
        Log.i(sb28.toString());
        StringBuilder sb29 = new StringBuilder();
        sb29.append("  previewModeEnabled = ");
        sb29.append(this.H);
        Log.i(sb29.toString());
        StringBuilder sb30 = new StringBuilder();
        sb30.append("  viewScanType = ");
        sb30.append(cM.a(this.I));
        Log.i(sb30.toString());
        StringBuilder sb31 = new StringBuilder();
        sb31.append("  useProxyServer = ");
        sb31.append(this.g);
        Log.i(sb31.toString());
    }

    public boolean b() {
        return this.h;
    }

    public boolean b(Context context) {
        synchronized (this) {
            if (this.L) {
                return true;
            }
            try {
                InputStream open = context.getAssets().open("fs-mapping.properties");
                try {
                    Properties properties = new Properties();
                    properties.load(open);
                    for (Map.Entry entry : properties.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        if (str.startsWith("mapping-fsclass:")) {
                            this.P.put(Integer.valueOf(b(str.substring(16))), str2);
                        }
                        if (str.startsWith("mapping-name:")) {
                            this.M.put(str2, Integer.valueOf(b(str.substring(13))));
                        }
                        if (str.startsWith("mapping-sha256:")) {
                            this.O.put(Integer.valueOf(b(str.substring(15))), str2);
                        }
                        if (str.startsWith("asset:")) {
                            this.N.put(str.substring(6), Integer.valueOf(b(str2)));
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Loaded mappings: ");
                    sb.append(this.b);
                    sb.append(", ");
                    sb.append(this.c);
                    Log.d(sb.toString());
                    this.L = true;
                    if (open != null) {
                        open.close();
                    }
                    return true;
                } catch (Throwable th) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                cS.a("Error initializing configuration", th2);
                return false;
            }
        }
    }

    public boolean c() {
        return this.u;
    }

    public boolean d() {
        return this.v;
    }

    public int e() {
        return this.n;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        String str = this.d;
        return str == null ? "" : str;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        return this.f;
    }

    public String j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public int l() {
        return this.m;
    }

    public boolean m() {
        return this.p;
    }

    public boolean n() {
        return this.s;
    }

    public String o() {
        return this.q;
    }

    public String p() {
        return this.r;
    }

    public boolean q() {
        return this.t;
    }

    public int r() {
        return this.f7874o;
    }

    public boolean s() {
        return this.x;
    }

    public boolean t() {
        return this.y;
    }

    public int u() {
        return this.G;
    }

    public boolean v() {
        return this.A;
    }

    public boolean w() {
        return this.B;
    }

    public boolean x() {
        return this.z;
    }

    public Map y() {
        return this.M;
    }

    public Map z() {
        return this.O;
    }
}
