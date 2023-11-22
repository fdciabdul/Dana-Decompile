package okhttp3.internal;

import android.view.KeyEvent;
import android.view.View;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.cashier.view.InputCardNumberView;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;
import o.E;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

/* loaded from: classes.dex */
public final class Util {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    public static final String[] EMPTY_STRING_ARRAY;
    public static final Charset ISO_8859_1;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    public static final Comparator<String> NATURAL_ORDER;
    private static int PlaceComponentResult;
    public static final TimeZone UTC;
    private static final Charset UTF_16_BE;
    private static final ByteString UTF_16_BE_BOM;
    private static final Charset UTF_16_LE;
    private static final ByteString UTF_16_LE_BOM;
    private static final Charset UTF_32_BE;
    private static final ByteString UTF_32_BE_BOM;
    private static final Charset UTF_32_LE;
    private static final ByteString UTF_32_LE_BOM;
    public static final Charset UTF_8;
    private static final ByteString UTF_8_BOM;
    private static final Pattern VERIFY_AS_IP_ADDRESS;
    private static final Method addSuppressedExceptionMethod;
    private static int getAuthRequestContext;

    public static int decodeHexDigit(char c) {
        if (c >= '0') {
            if ((c <= '9' ? (char) 22 : 'Z') != 'Z') {
                int i = c - '0';
                int i2 = getAuthRequestContext + 105;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                return i;
            }
        }
        char c2 = 'A';
        if (c >= 'a') {
            if (!(c > 'f')) {
                c2 = 'a';
                return (c - c2) + 10;
            }
        }
        if (c >= 'A') {
            int i4 = MyBillsEntityDataFactory + 77;
            getAuthRequestContext = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 5 : 'B') == 5) {
                if (c > '\r') {
                    return -1;
                }
            } else if (c > 'F') {
                return -1;
            }
            return (c - c2) + 10;
        }
        return -1;
    }

    static void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory = (char) 40513;
        KClassImpl$Data$declaredNonStaticMembers$2 = 4360990799332652212L;
        PlaceComponentResult = -956812108;
    }

    static {
        getAuthRequestContext();
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_STRING_ARRAY = new String[0];
        Method method = null;
        EMPTY_RESPONSE = ResponseBody.create((MediaType) null, bArr);
        EMPTY_REQUEST = RequestBody.create((MediaType) null, bArr);
        UTF_8_BOM = ByteString.decodeHex("efbbbf");
        UTF_16_BE_BOM = ByteString.decodeHex("feff");
        UTF_16_LE_BOM = ByteString.decodeHex("fffe");
        UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
        UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
        Object[] objArr = new Object[1];
        a(new char[]{36628, 42837, 4692, 32051, 51606}, new char[]{55935, 17566, 11306, 42332}, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 23597), new char[]{0, 0, 0, 0}, View.resolveSizeAndState(0, 0, 0) + 709140186, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        UTF_16_BE = Charset.forName("UTF-16BE");
        UTF_16_LE = Charset.forName("UTF-16LE");
        UTF_32_BE = Charset.forName("UTF-32BE");
        UTF_32_LE = Charset.forName("UTF-32LE");
        UTC = DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("GMT");
        NATURAL_ORDER = new Comparator<String>() { // from class: okhttp3.internal.Util.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        };
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
            int i = MyBillsEntityDataFactory + 57;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception unused) {
        }
        addSuppressedExceptionMethod = method;
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        int i3 = getAuthRequestContext + 63;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    public static void addSuppressedIfPossible(Throwable th, Throwable th2) {
        Method method = addSuppressedExceptionMethod;
        if ((method != null ? '7' : 'Q') != '7') {
            return;
        }
        try {
            int i = MyBillsEntityDataFactory + 109;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            try {
                method.invoke(th, th2);
                int i3 = MyBillsEntityDataFactory + 89;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if (!((j2 | j3) < 0)) {
            if ((j2 <= j ? 'E' : InputCardNumberView.DIVIDER) == 'E') {
                int i = MyBillsEntityDataFactory + 9;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                if (j - j2 >= j3) {
                    int i3 = MyBillsEntityDataFactory + 89;
                    getAuthRequestContext = i3 % 128;
                    if ((i3 % 2 != 0 ? '\t' : 'R') != '\t') {
                        return;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static boolean equal(Object obj, Object obj2) {
        int i = MyBillsEntityDataFactory + 85;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if ((obj != obj2 ? Typography.dollar : '!') == '$') {
            int i3 = MyBillsEntityDataFactory + 39;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            if (obj == null) {
                return false;
            }
            int i5 = getAuthRequestContext + 87;
            MyBillsEntityDataFactory = i5 % 128;
            int i6 = i5 % 2;
            try {
                if ((!obj.equals(obj2) ? (char) 11 : 'G') == 11) {
                    return false;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        int i = MyBillsEntityDataFactory + 29;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if ((closeable != null ? '?' : (char) 6) != 6) {
            int i3 = MyBillsEntityDataFactory + 49;
            getAuthRequestContext = i3 % 128;
            try {
                if (i3 % 2 != 0) {
                    closeable.close();
                    int i4 = 15 / 0;
                } else {
                    closeable.close();
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        int i = MyBillsEntityDataFactory + 95;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '?' : Typography.less) == '?') {
            Object obj = null;
            obj.hashCode();
            if (socket == null) {
                return;
            }
        } else if (socket == null) {
            return;
        }
        try {
            socket.close();
            int i2 = MyBillsEntityDataFactory + 107;
            getAuthRequestContext = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 63 / 0;
            }
        } catch (AssertionError e) {
            if (!isAndroidGetsocknameError(e)) {
                throw e;
            }
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if ((serverSocket != null ? '8' : 'R') == 'R') {
            int i = MyBillsEntityDataFactory + 115;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return;
        }
        int i3 = getAuthRequestContext + 83;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        try {
            serverSocket.close();
            int i5 = getAuthRequestContext + 97;
            MyBillsEntityDataFactory = i5 % 128;
            if (i5 % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static boolean discard(Source source, int i, TimeUnit timeUnit) {
        try {
            int i2 = MyBillsEntityDataFactory + 9;
            try {
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                try {
                    boolean skipAll = skipAll(source, i, timeUnit);
                    int i4 = MyBillsEntityDataFactory + 115;
                    getAuthRequestContext = i4 % 128;
                    if (!(i4 % 2 != 0)) {
                        return skipAll;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                    return skipAll;
                } catch (IOException unused) {
                    return false;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static boolean skipAll(Source source, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = (source.timeout().hasDeadline() ? 'F' : JSONLexer.EOI) != 26 ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i)) + nanoTime);
        try {
            try {
                Buffer buffer = new Buffer();
                while (true) {
                    if (source.read(buffer, 8192L) == -1) {
                        break;
                    }
                    try {
                        buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(buffer.getAuthRequestContext);
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
                try {
                    if (deadlineNanoTime == LongCompanionObject.MAX_VALUE) {
                        int i2 = MyBillsEntityDataFactory + 69;
                        getAuthRequestContext = i2 % 128;
                        int i3 = i2 % 2;
                        source.timeout().clearDeadline();
                        if (i3 != 0) {
                            int i4 = 85 / 0;
                        }
                    } else {
                        source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                    }
                    return true;
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (InterruptedIOException unused) {
                if (deadlineNanoTime == LongCompanionObject.MAX_VALUE) {
                    source.timeout().clearDeadline();
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                return false;
            } catch (Throwable th) {
                if (deadlineNanoTime == LongCompanionObject.MAX_VALUE) {
                    source.timeout().clearDeadline();
                    int i5 = MyBillsEntityDataFactory + 83;
                    getAuthRequestContext = i5 % 128;
                    int i6 = i5 % 2;
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                throw th;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public static <T> List<T> immutableList(List<T> list) {
        try {
            List<T> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
            int i = MyBillsEntityDataFactory + 93;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return unmodifiableList;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if ((!r0) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
    
        if (r2.isEmpty() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r2 = java.util.Collections.unmodifiableMap(new java.util.LinkedHashMap(r2));
        r0 = okhttp3.internal.Util.MyBillsEntityDataFactory + 121;
        okhttp3.internal.Util.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return java.util.Collections.emptyMap();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <K, V> java.util.Map<K, V> immutableMap(java.util.Map<K, V> r2) {
        /*
            int r0 = okhttp3.internal.Util.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L44
            int r0 = r0 + 13
            int r1 = r0 % 128
            okhttp3.internal.Util.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L44
            int r0 = r0 % 2
            r1 = 19
            if (r0 == 0) goto L11
            r0 = 45
            goto L13
        L11:
            r0 = 19
        L13:
            if (r0 == r1) goto L25
            boolean r0 = r2.isEmpty()
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L1f
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            if (r0 == 0) goto L2b
            goto L30
        L23:
            r2 = move-exception
            throw r2
        L25:
            boolean r0 = r2.isEmpty()     // Catch: java.lang.Exception -> L44
            if (r0 == 0) goto L30
        L2b:
            java.util.Map r2 = java.util.Collections.emptyMap()     // Catch: java.lang.Exception -> L44
            goto L43
        L30:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>(r2)
            java.util.Map r2 = java.util.Collections.unmodifiableMap(r0)
            int r0 = okhttp3.internal.Util.MyBillsEntityDataFactory
            int r0 = r0 + 121
            int r1 = r0 % 128
            okhttp3.internal.Util.getAuthRequestContext = r1
            int r0 = r0 % 2
        L43:
            return r2
        L44:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.immutableMap(java.util.Map):java.util.Map");
    }

    public static <T> List<T> immutableList(T... tArr) {
        int i = MyBillsEntityDataFactory + 123;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
        int i3 = getAuthRequestContext + 37;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? '?' : (char) 19) != 19) {
            Object obj = null;
            obj.hashCode();
            return unmodifiableList;
        }
        return unmodifiableList;
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: okhttp3.internal.Util.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
        try {
            int i = MyBillsEntityDataFactory + 117;
            getAuthRequestContext = i % 128;
            if (i % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return threadFactory;
            }
            return threadFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (!(i >= length)) {
                    int i2 = MyBillsEntityDataFactory + 87;
                    getAuthRequestContext = i2 % 128;
                    if (i2 % 2 != 0) {
                        int i3 = 37 / 0;
                        if (comparator.compare(str, strArr2[i]) == 0) {
                            break;
                        }
                        i++;
                    } else if (comparator.compare(str, strArr2[i]) == 0) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            arrayList.add(str);
        }
        String[] strArr3 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        int i4 = getAuthRequestContext + 1;
        MyBillsEntityDataFactory = i4 % 128;
        int i5 = i4 % 2;
        return strArr3;
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        try {
            int i = getAuthRequestContext + 57;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
        if (strArr != null && strArr2 != null) {
            if (strArr.length != 0) {
                if (strArr2.length != 0) {
                    int length = strArr.length;
                    int i3 = 0;
                    loop0: while (true) {
                        if ((i3 < length ? 'L' : Typography.amp) != 'L') {
                            break;
                        }
                        int i4 = MyBillsEntityDataFactory + 55;
                        getAuthRequestContext = i4 % 128;
                        int i5 = i4 % 2;
                        String str = strArr[i3];
                        int length2 = strArr2.length;
                        int i6 = getAuthRequestContext + 103;
                        MyBillsEntityDataFactory = i6 % 128;
                        int i7 = i6 % 2;
                        for (int i8 = 0; i8 < length2; i8++) {
                            int i9 = MyBillsEntityDataFactory + 33;
                            getAuthRequestContext = i9 % 128;
                            if (i9 % 2 != 0) {
                                int compare = comparator.compare(str, strArr2[i8]);
                                Object obj = null;
                                obj.hashCode();
                                if (!(compare != 0)) {
                                    break loop0;
                                }
                            } else if (comparator.compare(str, strArr2[i8]) == 0) {
                                break loop0;
                            }
                            throw e;
                        }
                        i3++;
                    }
                    int i10 = MyBillsEntityDataFactory + 5;
                    try {
                        getAuthRequestContext = i10 % 128;
                        int i11 = i10 % 2;
                        return true;
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
        }
        return false;
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z) {
        String host;
        try {
            int i = MyBillsEntityDataFactory + 23;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                if (httpUrl.host().contains(":")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    sb.append(httpUrl.host());
                    sb.append("]");
                    host = sb.toString();
                    int i3 = MyBillsEntityDataFactory + 51;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                } else {
                    host = httpUrl.host();
                }
                if (!z) {
                    int i5 = MyBillsEntityDataFactory + 73;
                    getAuthRequestContext = i5 % 128;
                    int i6 = i5 % 2;
                    if (httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
                        return host;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(host);
                sb2.append(":");
                sb2.append(httpUrl.port());
                return sb2.toString();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if ((r0 == null) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        if (r5.getMessage() != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        if (r5.getMessage().contains("getsockname failed") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        r3 = 'V';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        if (r3 == 'V') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        r5 = okhttp3.internal.Util.getAuthRequestContext + 87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        okhttp3.internal.Util.MyBillsEntityDataFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if ((r5 % 2) != 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isAndroidGetsocknameError(java.lang.AssertionError r5) {
        /*
            java.lang.Throwable r0 = r5.getCause()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La
            r0 = 0
            goto Lb
        La:
            r0 = 1
        Lb:
            if (r0 == 0) goto Le
            goto L52
        Le:
            int r0 = okhttp3.internal.Util.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L60
            r3 = 29
            int r0 = r0 + r3
            int r4 = r0 % 128
            okhttp3.internal.Util.getAuthRequestContext = r4     // Catch: java.lang.Exception -> L5e
            int r0 = r0 % 2
            if (r0 == 0) goto L2d
            java.lang.String r0 = r5.getMessage()
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L27
            r0 = 0
            goto L28
        L27:
            r0 = 1
        L28:
            if (r0 == 0) goto L33
            goto L52
        L2b:
            r5 = move-exception
            throw r5
        L2d:
            java.lang.String r0 = r5.getMessage()
            if (r0 == 0) goto L52
        L33:
            java.lang.String r5 = r5.getMessage()
            java.lang.String r0 = "getsockname failed"
            boolean r5 = r5.contains(r0)
            r0 = 86
            if (r5 == 0) goto L43
            r3 = 86
        L43:
            if (r3 == r0) goto L46
            goto L52
        L46:
            int r5 = okhttp3.internal.Util.getAuthRequestContext     // Catch: java.lang.Exception -> L60
            int r5 = r5 + 87
            int r0 = r5 % 128
            okhttp3.internal.Util.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L60
            int r5 = r5 % 2
            if (r5 != 0) goto L53
        L52:
            r1 = 0
        L53:
            int r5 = okhttp3.internal.Util.MyBillsEntityDataFactory
            int r5 = r5 + 121
            int r0 = r5 % 128
            okhttp3.internal.Util.getAuthRequestContext = r0
            int r5 = r5 % 2
            return r1
        L5e:
            r5 = move-exception
            throw r5
        L60:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.isAndroidGetsocknameError(java.lang.AssertionError):boolean");
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        int i = 0;
        int i2 = MyBillsEntityDataFactory + 19;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((i < length ? (char) 29 : '7') != 29) {
                return -1;
            }
            int i4 = getAuthRequestContext + 69;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
            if ((comparator.compare(strArr[i], str) == 0 ? '+' : Typography.dollar) != '$') {
                int i6 = getAuthRequestContext + 49;
                MyBillsEntityDataFactory = i6 % 128;
                int i7 = i6 % 2;
                return i;
            }
            i++;
        }
    }

    public static String[] concat(String[] strArr, String str) {
        int i = getAuthRequestContext + 121;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? 'B' : (char) 28) != 'B') {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = str;
            return strArr2;
        }
        int length2 = strArr.length >> 1;
        String[] strArr3 = new String[length2];
        System.arraycopy(strArr, 1, strArr3, 0, strArr.length);
        strArr3[length2 * 1] = str;
        return strArr3;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        while (i < i2) {
            int i3 = MyBillsEntityDataFactory + 97;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            char charAt = str.charAt(i);
            if (charAt != '\t') {
                if (charAt == '\n') {
                    continue;
                } else {
                    if ((charAt != '\f') && charAt != '\r' && charAt != ' ') {
                        int i5 = MyBillsEntityDataFactory + 121;
                        getAuthRequestContext = i5 % 128;
                        if (i5 % 2 != 0) {
                            Object obj = null;
                            obj.hashCode();
                            return i;
                        }
                        return i;
                    }
                }
            }
            i++;
        }
        int i6 = getAuthRequestContext + 39;
        MyBillsEntityDataFactory = i6 % 128;
        int i7 = i6 % 2;
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (true) {
            if (i3 < i) {
                return i;
            }
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n') {
                int i4 = MyBillsEntityDataFactory + 47;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
                if ((charAt != '\f') && charAt != '\r') {
                    if ((charAt != ' ' ? (char) 30 : ')') != ')') {
                        return i3 + 1;
                    }
                }
            }
            i3--;
            try {
                int i6 = MyBillsEntityDataFactory + 79;
                getAuthRequestContext = i6 % 128;
                int i7 = i6 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public static String trimSubstring(String str, int i, int i2) {
        int i3 = MyBillsEntityDataFactory + 85;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 != 0)) {
            try {
                int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i, i2);
                return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i2));
            } catch (Exception e) {
                throw e;
            }
        }
        int skipLeadingAsciiWhitespace2 = skipLeadingAsciiWhitespace(str, i, i2);
        String substring = str.substring(skipLeadingAsciiWhitespace2, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace2, i2));
        Object[] objArr = null;
        int length = objArr.length;
        return substring;
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (true) {
            if ((i < i2 ? '_' : 'G') == 'G') {
                return i2;
            }
            if (!(str2.indexOf(str.charAt(i)) == -1)) {
                int i3 = getAuthRequestContext + 125;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return i;
            }
            i++;
            try {
                int i5 = MyBillsEntityDataFactory + 5;
                getAuthRequestContext = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        while (true) {
            if (!(i < i2)) {
                return i2;
            }
            int i3 = getAuthRequestContext + 29;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            try {
                if ((str.charAt(i) == c ? 'a' : Typography.dollar) == 'a') {
                    int i5 = getAuthRequestContext + 15;
                    MyBillsEntityDataFactory = i5 % 128;
                    int i6 = i5 % 2;
                    int i7 = getAuthRequestContext + 95;
                    MyBillsEntityDataFactory = i7 % 128;
                    int i8 = i7 % 2;
                    return i;
                }
                i++;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String canonicalizeHost(java.lang.String r3) {
        /*
            java.lang.String r0 = ":"
            boolean r0 = r3.contains(r0)
            r1 = 0
            if (r0 == 0) goto L79
            java.lang.String r0 = "["
            boolean r0 = r3.startsWith(r0)
            r2 = 0
            if (r0 == 0) goto L2d
            java.lang.String r0 = "]"
            boolean r0 = r3.endsWith(r0)     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L1d
            r0 = 37
            goto L1e
        L1d:
            r0 = 0
        L1e:
            if (r0 == 0) goto L2d
            int r0 = r3.length()
            r2 = 1
            int r0 = r0 - r2
            java.net.InetAddress r0 = decodeIpv6(r3, r2, r0)
            goto L35
        L2b:
            r3 = move-exception
            throw r3
        L2d:
            int r0 = r3.length()
            java.net.InetAddress r0 = decodeIpv6(r3, r2, r0)
        L35:
            if (r0 != 0) goto L4f
            int r3 = okhttp3.internal.Util.getAuthRequestContext
            int r3 = r3 + 39
            int r0 = r3 % 128
            okhttp3.internal.Util.MyBillsEntityDataFactory = r0
            int r3 = r3 % 2
            r0 = 7
            if (r3 != 0) goto L46
            r3 = 7
            goto L48
        L46:
            r3 = 63
        L48:
            if (r3 == r0) goto L4b
            return r1
        L4b:
            int r3 = r1.length     // Catch: java.lang.Throwable -> L4d
            return r1
        L4d:
            r3 = move-exception
            throw r3
        L4f:
            byte[] r0 = r0.getAddress()
            int r1 = r0.length
            r2 = 16
            if (r1 != r2) goto L5d
            java.lang.String r3 = inet6AddressToAscii(r0)
            return r3
        L5d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid IPv6 address: '"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = "'"
            r0.append(r3)
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        L79:
            java.lang.String r3 = java.net.IDN.toASCII(r3)     // Catch: java.lang.IllegalArgumentException -> La6
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.IllegalArgumentException -> La6
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch: java.lang.IllegalArgumentException -> La6
            boolean r0 = r3.isEmpty()     // Catch: java.lang.IllegalArgumentException -> La6
            if (r0 == 0) goto L8a
            return r1
        L8a:
            boolean r0 = containsInvalidHostnameAsciiCodes(r3)     // Catch: java.lang.IllegalArgumentException -> La6
            if (r0 == 0) goto La5
            int r3 = okhttp3.internal.Util.getAuthRequestContext
            int r3 = r3 + 21
            int r0 = r3 % 128
            okhttp3.internal.Util.MyBillsEntityDataFactory = r0
            int r3 = r3 % 2
            int r3 = okhttp3.internal.Util.MyBillsEntityDataFactory
            int r3 = r3 + 79
            int r0 = r3 % 128
            okhttp3.internal.Util.getAuthRequestContext = r0
            int r3 = r3 % 2
            return r1
        La5:
            return r3
        La6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.canonicalizeHost(java.lang.String):java.lang.String");
    }

    private static boolean containsInvalidHostnameAsciiCodes(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt > 31) {
                if (charAt < 127) {
                    try {
                        int i2 = MyBillsEntityDataFactory + 123;
                        getAuthRequestContext = i2 % 128;
                        int i3 = i2 % 2;
                        if ((" #%/:?@[\\]".indexOf(charAt) != -1 ? '@' : 'J') != 'J') {
                            return true;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            int i4 = getAuthRequestContext + 87;
            MyBillsEntityDataFactory = i4 % 128;
            if (i4 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                return true;
            }
            return true;
        }
        return false;
    }

    public static int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if ((i < length ? ')' : 'K') == ')') {
                char charAt = str.charAt(i);
                if (charAt <= 31) {
                    break;
                }
                try {
                    int i2 = MyBillsEntityDataFactory + 33;
                    getAuthRequestContext = i2 % 128;
                    int i3 = i2 % 2;
                    if (charAt >= 127) {
                        break;
                    }
                    int i4 = getAuthRequestContext + 53;
                    MyBillsEntityDataFactory = i4 % 128;
                    int i5 = i4 % 2;
                    i++;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                return -1;
            }
        }
        int i6 = getAuthRequestContext + 51;
        MyBillsEntityDataFactory = i6 % 128;
        int i7 = i6 % 2;
        return i;
    }

    public static boolean verifyAsIpAddress(String str) {
        int i = MyBillsEntityDataFactory + 95;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 31 : (char) 30) != 31) {
            return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
        }
        int i2 = 33 / 0;
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }

    public static String format(String str, Object... objArr) {
        String format;
        int i = MyBillsEntityDataFactory + 117;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            format = String.format(Locale.US, str, objArr);
            int i2 = 22 / 0;
        } else {
            format = String.format(Locale.US, str, objArr);
        }
        int i3 = MyBillsEntityDataFactory + 111;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 21 : 'E') != 21) {
            return format;
        }
        int i4 = 49 / 0;
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r1 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r6 = okhttp3.internal.Util.getAuthRequestContext + 67;
        okhttp3.internal.Util.MyBillsEntityDataFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if ((r6 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        r6 = 25 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        return okhttp3.internal.Util.UTF_8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        return okhttp3.internal.Util.UTF_8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r5.PlaceComponentResult(okhttp3.internal.Util.UTF_16_BE_BOM) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r6 = okhttp3.internal.Util.getAuthRequestContext + 17;
        okhttp3.internal.Util.MyBillsEntityDataFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if ((r6 % 2) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r6 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
    
        r6 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
    
        if (r6 == 'F') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        return okhttp3.internal.Util.UTF_16_BE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
        r5 = okhttp3.internal.Util.UTF_16_BE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        r6 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008f, code lost:
    
        if (r5.PlaceComponentResult(okhttp3.internal.Util.UTF_16_LE_BOM) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
    
        return okhttp3.internal.Util.UTF_16_LE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a2, code lost:
    
        if (r5.PlaceComponentResult(okhttp3.internal.Util.UTF_32_BE_BOM) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a4, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ae, code lost:
    
        return okhttp3.internal.Util.UTF_32_BE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b6, code lost:
    
        if (r5.PlaceComponentResult(okhttp3.internal.Util.UTF_32_LE_BOM) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b8, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b9, code lost:
    
        if (r2 == true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bb, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00be, code lost:
    
        r6 = okhttp3.internal.Util.getAuthRequestContext + 67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c2, code lost:
    
        okhttp3.internal.Util.MyBillsEntityDataFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c8, code lost:
    
        if ((r6 % 2) != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
    
        r6 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cd, code lost:
    
        r6 = 'Z';
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cf, code lost:
    
        if (r6 == 'Z') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d1, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
        r5 = okhttp3.internal.Util.UTF_32_LE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00db, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e1, code lost:
    
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0(r0.size());
        r5 = okhttp3.internal.Util.UTF_32_LE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00eb, code lost:
    
        r6 = okhttp3.internal.Util.MyBillsEntityDataFactory + 49;
        okhttp3.internal.Util.getAuthRequestContext = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f5, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f6, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r5.PlaceComponentResult(r0) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.charset.Charset bomAwareCharset(okio.BufferedSource r5, java.nio.charset.Charset r6) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.bomAwareCharset(okio.BufferedSource, java.nio.charset.Charset):java.nio.charset.Charset");
    }

    public static int checkDuration(String str, long j, TimeUnit timeUnit) {
        if (!(j >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" < 0");
            throw new IllegalArgumentException(sb.toString());
        }
        if ((timeUnit != null ? '9' : Typography.amp) == '&') {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" too large.");
            throw new IllegalArgumentException(sb2.toString());
        }
        int i = MyBillsEntityDataFactory + 7;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0 ? millis == 0 : millis == 0) {
            try {
                int i2 = MyBillsEntityDataFactory + 11;
                getAuthRequestContext = i2 % 128;
                if (i2 % 2 == 0 ? j > 0 : j > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(" too small.");
                    throw new IllegalArgumentException(sb3.toString());
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = (int) millis;
        int i4 = getAuthRequestContext + 85;
        MyBillsEntityDataFactory = i4 % 128;
        int i5 = i4 % 2;
        return i3;
    }

    public static AssertionError assertionError(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
            int i = MyBillsEntityDataFactory + 41;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (IllegalStateException unused) {
        }
        try {
            int i3 = getAuthRequestContext + 85;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return assertionError;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        if (decodeIpv4Suffix(r16, r9, r18, r3, r7 >>> 2) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0087, code lost:
    
        if ((!decodeIpv4Suffix(r16, r9, r18, r3, r7 + (-2))) != true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
    
        r7 = r7 + 2;
        r0 = okhttp3.internal.Util.getAuthRequestContext + 9;
        okhttp3.internal.Util.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        if (r7 == r2) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        r0 = okhttp3.internal.Util.getAuthRequestContext + 123;
        okhttp3.internal.Util.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
    
        if ((r0 % 2) != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a2, code lost:
    
        r0 = 7 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
    
        if (r8 != (-1)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a9, code lost:
    
        if (r8 != (-1)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ab, code lost:
    
        r0 = okhttp3.internal.Util.getAuthRequestContext + 119;
        okhttp3.internal.Util.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b4, code lost:
    
        if ((r0 % 2) != 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b8, code lost:
    
        r0 = 26 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b9, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bd, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00be, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (r2 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ce, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d4, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0133, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress decodeIpv6(java.lang.String r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0072 A[EDGE_INSN: B:66:0x0072->B:45:0x0072 BREAK  A[LOOP:1: B:17:0x002c->B:43:0x006e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean decodeIpv4Suffix(java.lang.String r8, int r9, int r10, byte[] r11, int r12) {
        /*
            r0 = r12
        L1:
            r1 = 1
            r2 = 0
            if (r9 >= r10) goto L89
            int r3 = r11.length
            if (r0 != r3) goto L9
            return r2
        L9:
            if (r0 == r12) goto L2a
            int r3 = okhttp3.internal.Util.MyBillsEntityDataFactory
            int r3 = r3 + 59
            int r4 = r3 % 128
            okhttp3.internal.Util.getAuthRequestContext = r4
            int r3 = r3 % 2
            char r3 = r8.charAt(r9)
            r4 = 46
            r5 = 15
            if (r3 == r4) goto L22
            r3 = 15
            goto L24
        L22:
            r3 = 11
        L24:
            if (r3 == r5) goto L29
            int r9 = r9 + 1
            goto L2a
        L29:
            return r2
        L2a:
            r3 = r9
            r4 = 0
        L2c:
            if (r3 >= r10) goto L72
            int r5 = okhttp3.internal.Util.getAuthRequestContext
            int r5 = r5 + 17
            int r6 = r5 % 128
            okhttp3.internal.Util.MyBillsEntityDataFactory = r6
            int r5 = r5 % 2
            r6 = 48
            if (r5 != 0) goto L44
            char r5 = r8.charAt(r3)
            r7 = 6
            if (r5 < r7) goto L72
            goto L4a
        L44:
            char r5 = r8.charAt(r3)
            if (r5 < r6) goto L72
        L4a:
            r7 = 57
            if (r5 > r7) goto L72
            if (r4 != 0) goto L61
            if (r9 == r3) goto L61
            int r8 = okhttp3.internal.Util.getAuthRequestContext     // Catch: java.lang.Exception -> L5f
            int r8 = r8 + 3
            int r9 = r8 % 128
            okhttp3.internal.Util.MyBillsEntityDataFactory = r9     // Catch: java.lang.Exception -> L5d
            int r8 = r8 % 2
            return r2
        L5d:
            r8 = move-exception
            throw r8
        L5f:
            r8 = move-exception
            throw r8
        L61:
            int r4 = r4 * 10
            int r4 = r4 + r5
            int r4 = r4 - r6
            r5 = 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L6b
            r5 = 1
            goto L6c
        L6b:
            r5 = 0
        L6c:
            if (r5 == r1) goto L71
            int r3 = r3 + 1
            goto L2c
        L71:
            return r2
        L72:
            int r9 = r3 - r9
            if (r9 != 0) goto L81
            int r8 = okhttp3.internal.Util.getAuthRequestContext
            int r8 = r8 + 117
            int r9 = r8 % 128
            okhttp3.internal.Util.MyBillsEntityDataFactory = r9
            int r8 = r8 % 2
            return r2
        L81:
            byte r9 = (byte) r4
            r11[r0] = r9
            int r0 = r0 + 1
            r9 = r3
            goto L1
        L89:
            int r12 = r12 + 4
            if (r0 == r12) goto L8e
            return r2
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.decodeIpv4Suffix(java.lang.String, int, int, byte[], int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d A[LOOP:1: B:6:0x000a->B:23:0x003d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0042 A[EDGE_INSN: B:73:0x0042->B:26:0x0042 BREAK  A[LOOP:1: B:6:0x000a->B:23:0x003d], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String inet6AddressToAscii(byte[] r8) {
        /*
            Method dump skipped, instructions count: 179
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.inet6AddressToAscii(byte[]):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if ((r1 instanceof javax.net.ssl.X509TrustManager ? 'E' : '+') != '+') goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static javax.net.ssl.X509TrustManager platformTrustManager() {
        /*
            int r0 = okhttp3.internal.Util.getAuthRequestContext     // Catch: java.lang.Exception -> L6f
            int r0 = r0 + 9
            int r1 = r0 % 128
            okhttp3.internal.Util.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L6f
            int r0 = r0 % 2
            java.lang.String r0 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch: java.security.GeneralSecurityException -> L67
            javax.net.ssl.TrustManagerFactory r0 = javax.net.ssl.TrustManagerFactory.getInstance(r0)     // Catch: java.security.GeneralSecurityException -> L67
            r1 = 0
            r0.init(r1)     // Catch: java.security.GeneralSecurityException -> L67
            javax.net.ssl.TrustManager[] r0 = r0.getTrustManagers()     // Catch: java.security.GeneralSecurityException -> L67
            int r1 = r0.length     // Catch: java.security.GeneralSecurityException -> L67
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L21
            r1 = 1
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == 0) goto L4c
            int r1 = okhttp3.internal.Util.MyBillsEntityDataFactory
            int r1 = r1 + 93
            int r4 = r1 % 128
            okhttp3.internal.Util.getAuthRequestContext = r4
            int r1 = r1 % 2
            if (r1 == 0) goto L31
            r2 = 0
        L31:
            if (r2 == 0) goto L3a
            r1 = r0[r3]     // Catch: java.security.GeneralSecurityException -> L67
            boolean r2 = r1 instanceof javax.net.ssl.X509TrustManager     // Catch: java.security.GeneralSecurityException -> L67
            if (r2 == 0) goto L4c
            goto L49
        L3a:
            r1 = r0[r3]     // Catch: java.security.GeneralSecurityException -> L67
            boolean r2 = r1 instanceof javax.net.ssl.X509TrustManager     // Catch: java.security.GeneralSecurityException -> L67
            r3 = 43
            if (r2 == 0) goto L45
            r2 = 69
            goto L47
        L45:
            r2 = 43
        L47:
            if (r2 == r3) goto L4c
        L49:
            javax.net.ssl.X509TrustManager r1 = (javax.net.ssl.X509TrustManager) r1     // Catch: java.security.GeneralSecurityException -> L67
            return r1
        L4c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.security.GeneralSecurityException -> L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.security.GeneralSecurityException -> L67
            r2.<init>()     // Catch: java.security.GeneralSecurityException -> L67
            java.lang.String r3 = "Unexpected default trust managers:"
            r2.append(r3)     // Catch: java.security.GeneralSecurityException -> L67
            java.lang.String r0 = java.util.Arrays.toString(r0)     // Catch: java.security.GeneralSecurityException -> L67
            r2.append(r0)     // Catch: java.security.GeneralSecurityException -> L67
            java.lang.String r0 = r2.toString()     // Catch: java.security.GeneralSecurityException -> L67
            r1.<init>(r0)     // Catch: java.security.GeneralSecurityException -> L67
            throw r1     // Catch: java.security.GeneralSecurityException -> L67
        L67:
            r0 = move-exception
            java.lang.String r1 = "No System TLS"
            java.lang.AssertionError r0 = assertionError(r1, r0)
            throw r0
        L6f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.platformTrustManager():javax.net.ssl.X509TrustManager");
    }

    public static Headers toHeaders(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        Iterator<Header> it = list.iterator();
        int i = getAuthRequestContext + 25;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        while (true) {
            try {
                if ((it.hasNext() ? (char) 24 : Typography.quote) == 24) {
                    int i3 = getAuthRequestContext + 93;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    Header next = it.next();
                    Internal.instance.addLenient(builder, next.name.utf8(), next.value.utf8());
                } else {
                    return builder.build();
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $11 + 19;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
                int i4 = $10 + 59;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                cArr4[i7] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
