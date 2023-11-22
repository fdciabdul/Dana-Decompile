package okhttp3.logging;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;

/* loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 0;
    private static final Charset UTF8;
    private static boolean getAuthRequestContext = false;
    private static int lookAheadTest = 1;
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* loaded from: classes2.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: classes6.dex */
    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor.Logger.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String str) {
                Platform.get().log(4, str, null);
            }
        };

        void log(String str);
    }

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = new char[]{39777, 39776, 39790, 39689, 39804};
        KClassImpl$Data$declaredNonStaticMembers$2 = true;
        getAuthRequestContext = true;
        PlaceComponentResult = 909155124;
    }

    static {
        MyBillsEntityDataFactory();
        Object[] objArr = new Object[1];
        a(TextUtils.lastIndexOf("", '0', 0, 0) + 128, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
        UTF8 = Charset.forName(((String) objArr[0]).intern());
        int i = MyBillsEntityDataFactory + 121;
        lookAheadTest = i % 128;
        int i2 = i % 2;
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.headersToRedact = Collections.emptySet();
        this.level = Level.NONE;
        this.logger = logger;
    }

    public final void redactHeader(String str) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
        int i = lookAheadTest + 123;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        int i = MyBillsEntityDataFactory + 23;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        if (!(level == null)) {
            int i3 = MyBillsEntityDataFactory + 9;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 27 : (char) 17) != 17) {
                this.level = level;
                int i4 = 74 / 0;
            } else {
                this.level = level;
            }
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public final Level getLevel() {
        int i = lookAheadTest + 9;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Level level = this.level;
            int i3 = MyBillsEntityDataFactory + 71;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? '%' : Typography.amp) != '%') {
                return level;
            }
            Object obj = null;
            obj.hashCode();
            return level;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0252, code lost:
    
        r0 = r21.proceed(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x025c, code lost:
    
        r3 = java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(java.lang.System.nanoTime() - r3);
        r5 = r0.body();
        r8 = r5.contentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x026d, code lost:
    
        if (r8 == (-1)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x026f, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append(r8);
        r6.append("-byte");
        r6 = r6.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0281, code lost:
    
        r6 = "unknown-length";
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0283, code lost:
    
        r15 = r20.logger;
        r12 = new java.lang.StringBuilder();
        r12.append("<-- ");
        r12.append(r0.code());
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02a0, code lost:
    
        if (r0.message().isEmpty() == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02a2, code lost:
    
        r18 = r8;
        r8 = true;
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02a7, code lost:
    
        r18 = r8;
        r8 = true;
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02ab, code lost:
    
        if (r11 == r8) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02ad, code lost:
    
        r9 = new java.lang.StringBuilder();
        r9.append(id.dana.cashier.view.InputCardNumberView.DIVIDER);
        r9.append(r0.message());
        r9 = r9.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02c3, code lost:
    
        r9 = okhttp3.logging.HttpLoggingInterceptor.lookAheadTest + 5;
        okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory = r9 % 128;
        r9 = r9 % 2;
        r9 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02ce, code lost:
    
        r12.append(r9);
        r12.append(id.dana.cashier.view.InputCardNumberView.DIVIDER);
        r12.append(r0.request().url());
        r12.append(" (");
        r12.append(r3);
        r12.append("ms");
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02ec, code lost:
    
        if (r2 != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02ee, code lost:
    
        r3 = new java.lang.StringBuilder();
        r3.append(", ");
        r3.append(r6);
        r3.append(" body");
        r3 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0305, code lost:
    
        r3 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0306, code lost:
    
        r12.append(r3);
        r12.append(')');
        r15.log(r12.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0315, code lost:
    
        if (r2 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0317, code lost:
    
        r2 = r0.headers();
        r3 = r2.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0322, code lost:
    
        if (r4 >= r3) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0324, code lost:
    
        r9 = 'b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0327, code lost:
    
        r9 = 'P';
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0329, code lost:
    
        if (r9 == 'b') goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x032b, code lost:
    
        if (r7 == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x032d, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x032f, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0330, code lost:
    
        if (r3 == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if ((r2 == okhttp3.logging.HttpLoggingInterceptor.Level.NONE ? 'K' : '0') != 'K') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0336, code lost:
    
        if (okhttp3.internal.http.HttpHeaders.hasBody(r0) == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0340, code lost:
    
        if (bodyHasUnknownEncoding(r0.headers()) == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0342, code lost:
    
        r20.logger.log("<-- END HTTP (encoded body omitted)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x034b, code lost:
    
        r3 = r5.source();
        r3.getErrorConfigVersion(kotlin.jvm.internal.LongCompanionObject.MAX_VALUE);
        r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0367, code lost:
    
        if (com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP.equalsIgnoreCase(r2.get("Content-Encoding")) == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0369, code lost:
    
        r6 = r3.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x036b, code lost:
    
        r12 = new okio.GzipSource(r3.clone());
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0374, code lost:
    
        r3 = new okio.Buffer();
        r3.BuiltInFictitiousFunctionClassFactory(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x037c, code lost:
    
        r12.close();
        r2 = java.lang.Long.valueOf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0385, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0387, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0388, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0389, code lost:
    
        if (r12 != null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x038b, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x038d, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x038e, code lost:
    
        if (r3 != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0390, code lost:
    
        r2 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory + 73;
        okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x039a, code lost:
    
        if ((r2 % 2) == 0) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x039c, code lost:
    
        r12.close();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03a0, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03a7, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03aa, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03ab, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03ac, code lost:
    
        r4 = okhttp3.logging.HttpLoggingInterceptor.UTF8;
        r5 = r5.contentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03b2, code lost:
    
        if (r5 == null) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03b4, code lost:
    
        r4 = r5.charset(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03bc, code lost:
    
        if (isPlaintext(r3) != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03be, code lost:
    
        r20.logger.log(r13);
        r2 = r20.logger;
        r4 = new java.lang.StringBuilder();
        r4.append("<-- END HTTP (binary ");
        r4.append(r3.getAuthRequestContext);
        r4.append("-byte body omitted)");
        r2.log(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03de, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03e3, code lost:
    
        if (r18 == 0) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03e5, code lost:
    
        r5 = okhttp3.logging.HttpLoggingInterceptor.lookAheadTest + 3;
        okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03f1, code lost:
    
        if ((r5 % 2) == 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r2 == r7) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03f3, code lost:
    
        r5 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03f6, code lost:
    
        r5 = '4';
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03f8, code lost:
    
        if (r5 == 15) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03fa, code lost:
    
        r20.logger.log(r13);
        r20.logger.log(r3.clone().getAuthRequestContext(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x040d, code lost:
    
        r20.logger.log(r13);
        r20.logger.log(r3.clone().getAuthRequestContext(r4));
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0420, code lost:
    
        r4 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0427, code lost:
    
        if (r2 == null) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0429, code lost:
    
        r5 = r20.logger;
        r6 = new java.lang.StringBuilder();
        r6.append("<-- END HTTP (");
        r6.append(r3.getAuthRequestContext);
        r6.append("-byte, ");
        r6.append(r2);
        r6.append("-gzipped-byte body)");
        r5.log(r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x044d, code lost:
    
        r2 = r20.logger;
        r5 = new java.lang.StringBuilder();
        r5.append("<-- END HTTP (");
        r5.append(r3.getAuthRequestContext);
        r5.append("-byte body)");
        r2.log(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0469, code lost:
    
        r20.logger.log("<-- END HTTP");
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0471, code lost:
    
        logHeader(r2, r4);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x047b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x047c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x047d, code lost:
    
        r0 = r20.logger;
        r3 = new java.lang.StringBuilder();
        r3.append("<-- HTTP FAILED: ");
        r3.append(r0);
        r0.log(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0494, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        return r21.proceed(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0495, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0496, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        if (r2 != okhttp3.logging.HttpLoggingInterceptor.Level.BODY) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        if (r7 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        if (r8 == true) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if (r2 == okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        r8 = r6.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        if (r8 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r9 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        r9 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory + 5;
        okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r9 % 128;
        r9 = r9 % 2;
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006a, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        r10 = r21.connection();
        r11 = new java.lang.StringBuilder();
        r11.append("--> ");
        r11.append(r6.method());
        r11.append(id.dana.cashier.view.InputCardNumberView.DIVIDER);
        r11.append(r6.url());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        if (r10 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0090, code lost:
    
        r14 = new java.lang.StringBuilder();
        r14.append(" ");
        r14.append(r10.protocol());
        r10 = r14.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a6, code lost:
    
        r10 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a7, code lost:
    
        r11.append(r10);
        r10 = r11.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b2, code lost:
    
        if (r2 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b4, code lost:
    
        if (r9 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
    
        r15 = new java.lang.StringBuilder();
        r15.append(r10);
        r15.append(" (");
        r16 = "";
        r15.append(r8.contentLength());
        r15.append("-byte body)");
        r10 = r15.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
    
        r16 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d4, code lost:
    
        r20.logger.log(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
    
        if (r2 == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00df, code lost:
    
        if (r9 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e1, code lost:
    
        r15 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory + 29;
        okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r15 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ed, code lost:
    
        if ((r15 % 2) != 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ef, code lost:
    
        r15 = '*';
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f2, code lost:
    
        r15 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
    
        if (r15 == '*') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fa, code lost:
    
        if (r8.contentType() == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0102, code lost:
    
        r15 = 2 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0103, code lost:
    
        if (r8.contentType() == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0105, code lost:
    
        r4 = r20.logger;
        r15 = new java.lang.StringBuilder();
        r15.append("Content-Type: ");
        r15.append(r8.contentType());
        r4.log(r15.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0125, code lost:
    
        if (r8.contentLength() == (-1)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0127, code lost:
    
        r3 = r20.logger;
        r4 = new java.lang.StringBuilder();
        r4.append("Content-Length: ");
        r4.append(r8.contentLength());
        r3.log(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0145, code lost:
    
        r3 = r6.headers();
        r4 = r3.size();
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        if (r12 >= r4) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0150, code lost:
    
        r13 = okhttp3.logging.HttpLoggingInterceptor.lookAheadTest + 109;
        okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory = r13 % 128;
        r13 = r13 % 2;
        r13 = r3.name(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0164, code lost:
    
        if ("Content-Type".equalsIgnoreCase(r13) != false) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x016c, code lost:
    
        if (com.google.common.net.HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(r13) != false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x016e, code lost:
    
        r13 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory + 97;
        okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r13 % 128;
        r13 = r13 % 2;
        logHeader(r3, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017b, code lost:
    
        if (r13 != 0) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x017d, code lost:
    
        r13 = r5.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0182, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0187, code lost:
    
        if (r7 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0189, code lost:
    
        if (r9 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0193, code lost:
    
        if (bodyHasUnknownEncoding(r6.headers()) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0195, code lost:
    
        r4 = r20.logger;
        r8 = new java.lang.StringBuilder();
        r8.append("--> END ");
        r8.append(r6.method());
        r8.append(" (encoded body omitted)");
        r4.log(r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b4, code lost:
    
        r4 = new okio.Buffer();
        r8.writeTo(r4);
        r9 = okhttp3.logging.HttpLoggingInterceptor.UTF8;
        r12 = r8.contentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c2, code lost:
    
        if (r12 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c4, code lost:
    
        r9 = r12.charset(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c8, code lost:
    
        r13 = r16;
        r20.logger.log(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d3, code lost:
    
        if (isPlaintext(r4) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d5, code lost:
    
        r20.logger.log(r4.getAuthRequestContext(r9));
        r4 = r20.logger;
        r9 = new java.lang.StringBuilder();
        r9.append("--> END ");
        r9.append(r6.method());
        r9.append(" (");
        r15 = r6;
        r9.append(r8.contentLength());
        r9.append("-byte body)");
        r4.log(r9.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0205, code lost:
    
        r15 = r6;
        r4 = r20.logger;
        r5 = new java.lang.StringBuilder();
        r5.append("--> END ");
        r5.append(r15.method());
        r5.append(" (binary ");
        r5.append(r8.contentLength());
        r5.append("-byte body omitted)");
        r4.log(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x022e, code lost:
    
        r15 = r6;
        r13 = r16;
        r4 = r20.logger;
        r5 = new java.lang.StringBuilder();
        r5.append("--> END ");
        r5.append(r15.method());
        r4.log(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x024a, code lost:
    
        r15 = r6;
        r13 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x024d, code lost:
    
        r3 = java.lang.System.nanoTime();
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response intercept(okhttp3.Interceptor.Chain r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if ((!r3.headersToRedact.contains(r4.name(r5))) != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r0 = okhttp3.logging.HttpLoggingInterceptor.lookAheadTest + 11;
        okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
        r0 = "██";
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        r0 = r4.value(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        r1 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory + 75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r0 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void logHeader(okhttp3.Headers r4, int r5) {
        /*
            r3 = this;
            int r0 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory
            int r0 = r0 + 99
            int r1 = r0 % 128
            okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L1d
            java.util.Set<java.lang.String> r0 = r3.headersToRedact
            java.lang.String r1 = r4.name(r5)
            boolean r0 = r0.contains(r1)
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L3c
            goto L2f
        L1b:
            r4 = move-exception
            throw r4
        L1d:
            java.util.Set<java.lang.String> r0 = r3.headersToRedact     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = r4.name(r5)     // Catch: java.lang.Exception -> L6a
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Exception -> L6a
            r1 = 1
            if (r0 == 0) goto L2c
            r0 = 0
            goto L2d
        L2c:
            r0 = 1
        L2d:
            if (r0 == r1) goto L3c
        L2f:
            int r0 = okhttp3.logging.HttpLoggingInterceptor.lookAheadTest
            int r0 = r0 + 11
            int r1 = r0 % 128
            okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r0 = "██"
            goto L4a
        L3c:
            java.lang.String r0 = r4.value(r5)
            int r1 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L68
            int r1 = r1 + 75
            int r2 = r1 % 128
            okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r2     // Catch: java.lang.Exception -> L68
            int r1 = r1 % 2
        L4a:
            okhttp3.logging.HttpLoggingInterceptor$Logger r1 = r3.logger
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r4.name(r5)
            r2.append(r4)
            java.lang.String r4 = ": "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r4 = r2.toString()
            r1.log(r4)
            return
        L68:
            r4 = move-exception
            throw r4
        L6a:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.logHeader(okhttp3.Headers, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d5, code lost:
    
        if ((r4 <= 57343) != false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean isPlaintext(okio.Buffer r16) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.isPlaintext(okio.Buffer):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r4 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if ((r4.equalsIgnoreCase(com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP)) != true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean bodyHasUnknownEncoding(okhttp3.Headers r4) {
        /*
            int r0 = okhttp3.logging.HttpLoggingInterceptor.lookAheadTest     // Catch: java.lang.Exception -> L53
            int r0 = r0 + 75
            int r1 = r0 % 128
            okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L53
            int r0 = r0 % 2
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r4 = r4.get(r0)
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L16
            r2 = 0
            goto L17
        L16:
            r2 = 1
        L17:
            if (r2 == r1) goto L46
            java.lang.String r2 = "identity"
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 != 0) goto L46
            int r2 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory
            int r2 = r2 + 45
            int r3 = r2 % 128
            okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r3
            int r2 = r2 % 2
            java.lang.String r3 = "gzip"
            if (r2 != 0) goto L3a
            boolean r4 = r4.equalsIgnoreCase(r3)
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L38
            if (r4 != 0) goto L46
            goto L45
        L38:
            r4 = move-exception
            throw r4
        L3a:
            boolean r4 = r4.equalsIgnoreCase(r3)
            if (r4 != 0) goto L42
            r4 = 0
            goto L43
        L42:
            r4 = 1
        L43:
            if (r4 == r1) goto L46
        L45:
            r0 = 1
        L46:
            int r4 = okhttp3.logging.HttpLoggingInterceptor.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L53
            int r4 = r4 + 61
            int r1 = r4 % 128
            okhttp3.logging.HttpLoggingInterceptor.lookAheadTest = r1     // Catch: java.lang.Exception -> L51
            int r4 = r4 % 2
            return r0
        L51:
            r4 = move-exception
            throw r4
        L53:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.bodyHasUnknownEncoding(okhttp3.Headers):boolean");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        int length;
        char[] cArr2;
        int i4;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = BuiltInFictitiousFunctionClassFactory;
        if (cArr3 != null) {
            int i5 = $10 + 101;
            $11 = i5 % 128;
            if (i5 % 2 == 0) {
                length = cArr3.length;
                cArr2 = new char[length];
                i4 = 1;
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
                i4 = 0;
            }
            while (true) {
                if ((i4 < length ? '5' : ',') == ',') {
                    break;
                }
                cArr2[i4] = (char) (cArr3[i4] ^ 4571606982258105150L);
                i4++;
            }
            cArr3 = cArr2;
        }
        int i6 = (int) (4571606982258105150L ^ PlaceComponentResult);
        if (!getAuthRequestContext) {
            try {
                if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        int i7 = $10 + 89;
                        $11 = i7 % 128;
                        if ((i7 % 2 == 0 ? (char) 25 : '\f') != 25) {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                            i3 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                        } else {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult * 0) + bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] / i6);
                            i3 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >>> 1;
                        }
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i3;
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                try {
                    int i8 = $10 + 35;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        int i10 = $10 + 97;
                        $11 = i10 % 128;
                        if (i10 % 2 == 0) {
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult * 0) * bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] % i] << i6);
                            i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory << 1;
                        } else {
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                            i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                        }
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                    }
                    objArr[0] = new String(cArr5);
                    return;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
        }
    }
}
