package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.cashier.view.InputCardNumberView;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import o.E;

/* loaded from: classes8.dex */
public class y {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final Pattern BuiltInFictitiousFunctionClassFactory;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final Pattern MyBillsEntityDataFactory;
    public static final Pattern PlaceComponentResult;
    private static long getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    private static int lookAheadTest;
    private static char moveToNextValue;

    /* loaded from: classes8.dex */
    public static final class a extends FilterInputStream {
        private boolean BuiltInFictitiousFunctionClassFactory;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) {
            int read;
            if (this.BuiltInFictitiousFunctionClassFactory || (read = super.read(bArr, i, i2)) == -1) {
                this.BuiltInFictitiousFunctionClassFactory = true;
                return -1;
            }
            return read;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public Map<String, String> PlaceComponentResult;
        public int getAuthRequestContext;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.getAuthRequestContext), this.PlaceComponentResult.toString());
        }
    }

    static {
        PlaceComponentResult();
        PlaceComponentResult = Pattern.compile("([^\\s;]+)(.*)");
        MyBillsEntityDataFactory = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
        BuiltInFictitiousFunctionClassFactory = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
        int i = lookAheadTest + 65;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? (char) 5 : ')') != 5) {
            return;
        }
        int i2 = 7 / 0;
    }

    private static String BuiltInFictitiousFunctionClassFactory(Context context, URL url, String str) {
        InputStream inputStream;
        try {
            inputStream = MyBillsEntityDataFactory(context, url);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 == read) {
                    h.MyBillsEntityDataFactory((Closeable) inputStream);
                    return sb.toString();
                }
                int i = getErrorConfigVersion + 103;
                lookAheadTest = i % 128;
                if (i % 2 != 0) {
                    sb.append(cArr, 1, read);
                } else {
                    sb.append(cArr, 0, read);
                }
                try {
                    int i2 = getErrorConfigVersion + 103;
                    lookAheadTest = i2 % 128;
                    int i3 = i2 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            h.MyBillsEntityDataFactory((Closeable) inputStream);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean BuiltInFictitiousFunctionClassFactory(android.content.Context r6) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L55
            int r3 = com.xiaomi.push.y.lookAheadTest
            r4 = 23
            int r3 = r3 + r4
            int r5 = r3 % 128
            com.xiaomi.push.y.getErrorConfigVersion = r5
            int r3 = r3 % 2
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 40
            if (r3 < r4) goto L20
            r3 = 40
            goto L22
        L20:
            r3 = 34
        L22:
            if (r3 == r5) goto L29
            boolean r0 = MyBillsEntityDataFactory(r6)
            goto L56
        L29:
            int r3 = com.xiaomi.push.y.lookAheadTest
            int r3 = r3 + 101
            int r4 = r3 % 128
            com.xiaomi.push.y.getErrorConfigVersion = r4
            int r3 = r3 % 2
            android.net.Network r3 = r0.getActiveNetwork()     // Catch: java.lang.Exception -> L55
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r3)     // Catch: java.lang.Exception -> L55
            if (r0 == 0) goto L3f
            r3 = 0
            goto L40
        L3f:
            r3 = 1
        L40:
            if (r3 == r1) goto L55
            int r3 = com.xiaomi.push.y.getErrorConfigVersion     // Catch: java.lang.Exception -> L53
            int r3 = r3 + 97
            int r4 = r3 % 128
            com.xiaomi.push.y.lookAheadTest = r4     // Catch: java.lang.Exception -> L73
            int r3 = r3 % 2
            r3 = 16
            boolean r0 = r0.hasCapability(r3)     // Catch: java.lang.Exception -> L55
            goto L56
        L53:
            r6 = move-exception
            throw r6
        L55:
            r0 = 0
        L56:
            if (r0 == 0) goto L75
            boolean r6 = PlaceComponentResult(r6)
            r0 = 41
            if (r6 == 0) goto L63
            r6 = 41
            goto L65
        L63:
            r6 = 19
        L65:
            if (r6 == r0) goto L68
            goto L75
        L68:
            int r6 = com.xiaomi.push.y.getErrorConfigVersion     // Catch: java.lang.Exception -> L73
            int r6 = r6 + 51
            int r0 = r6 % 128
            com.xiaomi.push.y.lookAheadTest = r0     // Catch: java.lang.Exception -> L73
            int r6 = r6 % 2
            goto L76
        L73:
            r6 = move-exception
            throw r6
        L75:
            r1 = 0
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.y.BuiltInFictitiousFunctionClassFactory(android.content.Context):boolean");
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        ConnectivityManager connectivityManager;
        int i = lookAheadTest + 67;
        getErrorConfigVersion = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            boolean authRequestContext = getAuthRequestContext(context);
            int length = objArr.length;
            if (authRequestContext) {
                return "wifi";
            }
        } else {
            if (getAuthRequestContext(context)) {
                return "wifi";
            }
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if ((connectivityManager == null ? '\t' : (char) 3) != 3) {
            return "";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if ((activeNetworkInfo == null ? '2' : 'F') == '2') {
            int i2 = getErrorConfigVersion + 51;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(activeNetworkInfo.getTypeName());
            sb.append("-");
            sb.append(activeNetworkInfo.getSubtypeName());
            sb.append("-");
            sb.append(activeNetworkInfo.getExtraInfo());
            String lowerCase = sb.toString().toLowerCase();
            int i4 = lookAheadTest + 35;
            getErrorConfigVersion = i4 % 128;
            if (i4 % 2 == 0) {
                objArr.hashCode();
                return lowerCase;
            }
            return lowerCase;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    private static w MyBillsEntityDataFactory(String str, String str2, String str3) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        w wVar = new w();
        Closeable closeable = null;
        try {
            try {
                HttpURLConnection PlaceComponentResult2 = PlaceComponentResult(MyBillsEntityDataFactory(str));
                PlaceComponentResult2.setConnectTimeout(10000);
                PlaceComponentResult2.setReadTimeout(15000);
                PlaceComponentResult2.setRequestMethod(str2);
                if (!TextUtils.isEmpty(str3)) {
                    int i = getErrorConfigVersion + 111;
                    lookAheadTest = i % 128;
                    try {
                        if ((i % 2 != 0 ? 'N' : 'C') != 'N') {
                            PlaceComponentResult2.setDoOutput(true);
                            byte[] bytes = str3.getBytes();
                            OutputStream outputStream = PlaceComponentResult2.getOutputStream();
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            str3 = outputStream;
                        } else {
                            PlaceComponentResult2.setDoOutput(false);
                            byte[] bytes2 = str3.getBytes();
                            OutputStream outputStream2 = PlaceComponentResult2.getOutputStream();
                            outputStream2.write(bytes2, 1, bytes2.length);
                            outputStream2.flush();
                            str3 = outputStream2;
                        }
                        str3.close();
                    } catch (IOException e) {
                        e = e;
                        closeable = str3;
                        bufferedReader = null;
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("err while request ");
                            sb.append(str);
                            sb.append(":");
                            sb.append(e.getClass().getSimpleName());
                            throw new IOException(sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            h.MyBillsEntityDataFactory(closeable);
                            h.MyBillsEntityDataFactory(bufferedReader2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = null;
                        closeable = str3;
                        try {
                            throw new IOException(th.getMessage());
                        } catch (Throwable th3) {
                            th = th3;
                            h.MyBillsEntityDataFactory(closeable);
                            h.MyBillsEntityDataFactory(bufferedReader2);
                            throw th;
                        }
                    }
                }
                wVar.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2.getResponseCode();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Http POST Response Code: ");
                sb2.append(wVar.KClassImpl$Data$declaredNonStaticMembers$2);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                int i2 = 0;
                while (true) {
                    String headerFieldKey = PlaceComponentResult2.getHeaderFieldKey(i2);
                    String headerField = PlaceComponentResult2.getHeaderField(i2);
                    if (!(headerFieldKey != null) && headerField == null) {
                        try {
                            break;
                        } catch (IOException unused) {
                            bufferedReader2 = new BufferedReader(new InputStreamReader(new a(PlaceComponentResult2.getErrorStream())));
                        }
                    } else {
                        wVar.MyBillsEntityDataFactory.put(headerFieldKey, headerField);
                        i2 = i2 + 1 + 1;
                    }
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(new a(PlaceComponentResult2.getInputStream())));
                try {
                    String readLine = bufferedReader2.readLine();
                    StringBuffer stringBuffer = new StringBuffer();
                    String property = System.getProperty("line.separator");
                    while (readLine != null) {
                        int i3 = getErrorConfigVersion + 103;
                        lookAheadTest = i3 % 128;
                        if (i3 % 2 != 0) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                            readLine = bufferedReader2.readLine();
                            closeable.hashCode();
                        } else {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                            readLine = bufferedReader2.readLine();
                        }
                    }
                    wVar.BuiltInFictitiousFunctionClassFactory = stringBuffer.toString();
                    bufferedReader2.close();
                    h.MyBillsEntityDataFactory((Closeable) null);
                    h.MyBillsEntityDataFactory((Closeable) null);
                    return wVar;
                } catch (IOException e2) {
                    bufferedReader = bufferedReader2;
                    e = e2;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("err while request ");
                    sb3.append(str);
                    sb3.append(":");
                    sb3.append(e.getClass().getSimpleName());
                    throw new IOException(sb3.toString());
                } catch (Throwable th4) {
                    th = th4;
                    throw new IOException(th.getMessage());
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader2 = null;
        }
    }

    private static InputStream MyBillsEntityDataFactory(Context context, URL url) {
        try {
            int i = getErrorConfigVersion + 59;
            lookAheadTest = i % 128;
            return MyBillsEntityDataFactory(context, url, (i % 2 != 0 ? '/' : InputCardNumberView.DIVIDER) == '/', null, null);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if ((r0 != null) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        r0 = new java.net.URL(PlaceComponentResult(r1.toString()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        java.net.HttpURLConnection.setFollowRedirects(true);
        r0 = PlaceComponentResult(r0);
        r0.setConnectTimeout(10000);
        r0.setReadTimeout(15000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        if (android.text.TextUtils.isEmpty(null) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        r2 = com.xiaomi.push.y.getErrorConfigVersion + 45;
        com.xiaomi.push.y.lookAheadTest = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        r0.setRequestProperty(com.google.common.net.HttpHeaders.USER_AGENT, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        return new com.xiaomi.push.y.a(r0.getInputStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        throw new java.io.IOException(r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("IOException:");
        r1.append(r0.getClass().getSimpleName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008d, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
    
        throw new java.lang.IllegalArgumentException("url");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
    
        throw new java.lang.IllegalArgumentException(com.ap.zoloz.hummer.biz.HummerConstants.CONTEXT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if ((r0 != null) == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.InputStream MyBillsEntityDataFactory(android.content.Context r0, java.net.URL r1, boolean r2, java.lang.String r3, java.lang.String r4) {
        /*
            int r2 = com.xiaomi.push.y.lookAheadTest
            int r2 = r2 + 67
            int r3 = r2 % 128
            com.xiaomi.push.y.getErrorConfigVersion = r3
            int r2 = r2 % 2
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L10
            r2 = 1
            goto L11
        L10:
            r2 = 0
        L11:
            if (r2 == r4) goto L19
            if (r0 == 0) goto L16
            r3 = 1
        L16:
            if (r3 != r4) goto L98
            goto L21
        L19:
            r2 = 98
            int r2 = r2 / r3
            if (r0 == 0) goto L1f
            r3 = 1
        L1f:
            if (r3 == 0) goto L98
        L21:
            if (r1 == 0) goto L90
            java.net.URL r0 = new java.net.URL
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = PlaceComponentResult(r1)     // Catch: java.lang.Exception -> L8c
            r0.<init>(r1)     // Catch: java.lang.Exception -> L8c
            java.net.HttpURLConnection.setFollowRedirects(r4)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            java.net.HttpURLConnection r0 = PlaceComponentResult(r0)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            r1 = 15000(0x3a98, float:2.102E-41)
            r0.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            if (r2 != 0) goto L57
            int r2 = com.xiaomi.push.y.getErrorConfigVersion
            int r2 = r2 + 45
            int r3 = r2 % 128
            com.xiaomi.push.y.lookAheadTest = r3
            int r2 = r2 % 2
            java.lang.String r2 = "User-Agent"
            r0.setRequestProperty(r2, r1)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
        L57:
            com.xiaomi.push.y$a r1 = new com.xiaomi.push.y$a     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L6c
            return r1
        L61:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            throw r1
        L6c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "IOException:"
            r1.append(r2)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r1.append(r0)
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8c:
            r0 = move-exception
            throw r0
        L8e:
            r0 = move-exception
            throw r0
        L90:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "url"
            r0.<init>(r1)
            throw r0
        L98:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "context"
            r0.<init>(r1)
            throw r0
        La0:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.y.MyBillsEntityDataFactory(android.content.Context, java.net.URL, boolean, java.lang.String, java.lang.String):java.io.InputStream");
    }

    private static String MyBillsEntityDataFactory(Map<String, String> map) {
        Object[] objArr = null;
        if ((map != null ? '\'' : '#') == '\'' && map.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                if ((it.hasNext() ? (char) 11 : (char) 21) != 11) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                if ((next.getKey() != null ? 'L' : 'Y') != 'Y') {
                    int i = lookAheadTest + 47;
                    getErrorConfigVersion = i % 128;
                    if (i % 2 == 0) {
                        String value = next.getValue();
                        int length = objArr.length;
                        if ((value != null ? Typography.quote : '%') == '%') {
                            continue;
                        }
                        try {
                            String key = next.getKey();
                            Object[] objArr2 = new Object[1];
                            a(new char[]{1205, 14922, 25986, 52986, 45057}, new char[]{52052, 29910, 26085, 8060}, (char) (31845 - TextUtils.indexOf("", "", 0, 0)), new char[]{16990, 16126, 23568, 28753}, AndroidCharacter.getMirror('0') - 10597, objArr2);
                            stringBuffer.append(URLEncoder.encode(key, ((String) objArr2[0]).intern()));
                            stringBuffer.append("=");
                            String value2 = next.getValue();
                            Object[] objArr3 = new Object[1];
                            a(new char[]{1205, 14922, 25986, 52986, 45057}, new char[]{52052, 29910, 26085, 8060}, (char) (31844 - TextUtils.lastIndexOf("", '0', 0)), new char[]{16990, 16126, 23568, 28753}, ((byte) KeyEvent.getModifierMetaStateMask()) - 445327668, objArr3);
                            stringBuffer.append(URLEncoder.encode(value2, ((String) objArr3[0]).intern()));
                            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                            objArr = null;
                        } catch (UnsupportedEncodingException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to convert from params map to string: ");
                            sb.append(e);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("map: ");
                            sb2.append(map.toString());
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                            return null;
                        }
                    } else {
                        if (next.getValue() == null) {
                            continue;
                        }
                        String key2 = next.getKey();
                        Object[] objArr22 = new Object[1];
                        a(new char[]{1205, 14922, 25986, 52986, 45057}, new char[]{52052, 29910, 26085, 8060}, (char) (31845 - TextUtils.indexOf("", "", 0, 0)), new char[]{16990, 16126, 23568, 28753}, AndroidCharacter.getMirror('0') - 10597, objArr22);
                        stringBuffer.append(URLEncoder.encode(key2, ((String) objArr22[0]).intern()));
                        stringBuffer.append("=");
                        String value22 = next.getValue();
                        Object[] objArr32 = new Object[1];
                        a(new char[]{1205, 14922, 25986, 52986, 45057}, new char[]{52052, 29910, 26085, 8060}, (char) (31844 - TextUtils.lastIndexOf("", '0', 0)), new char[]{16990, 16126, 23568, 28753}, ((byte) KeyEvent.getModifierMetaStateMask()) - 445327668, objArr32);
                        stringBuffer.append(URLEncoder.encode(value22, ((String) objArr32[0]).intern()));
                        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                        objArr = null;
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                int i2 = lookAheadTest + 75;
                getErrorConfigVersion = i2 % 128;
                int i3 = i2 % 2;
            }
            return stringBuffer.toString();
        }
        return null;
    }

    private static URL MyBillsEntityDataFactory(String str) {
        URL url = new URL(str);
        int i = lookAheadTest + 95;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        return url;
    }

    public static boolean MyBillsEntityDataFactory(Context context) {
        try {
            if ((moveToNextValue(context) >= 0 ? ')' : (char) 28) == ')') {
                int i = lookAheadTest + 37;
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                return true;
            }
            try {
                int i3 = getErrorConfigVersion + 103;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String PlaceComponentResult(String str) {
        int i = getErrorConfigVersion + 99;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        if (!(!TextUtils.isEmpty(str))) {
            int i3 = getErrorConfigVersion + 69;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return null;
        }
        int i5 = lookAheadTest + 81;
        getErrorConfigVersion = i5 % 128;
        int i6 = i5 % 2;
        String format = String.format("%s&key=%s", str, ac.BuiltInFictitiousFunctionClassFactory(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
        int i7 = lookAheadTest + 103;
        getErrorConfigVersion = i7 % 128;
        int i8 = i7 % 2;
        return format;
    }

    private static HttpURLConnection PlaceComponentResult(URL url) {
        int i = getErrorConfigVersion + 111;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        SemanticAttributes.FaasTriggerValues.HTTP.equals(url.getProtocol());
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection())));
        int i3 = lookAheadTest + 103;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? '_' : 'S') != 'S') {
            Object obj = null;
            obj.hashCode();
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    static void PlaceComponentResult() {
        moveToNextValue = (char) 13492;
        getAuthRequestContext = 5536056537665402602L;
        KClassImpl$Data$declaredNonStaticMembers$2 = -956812108;
    }

    public static boolean PlaceComponentResult(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if ((networkInfo != null ? 'N' : (char) 2) != 'N') {
            return false;
        }
        try {
            int i = getErrorConfigVersion + 39;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            if (!networkInfo.isConnected()) {
                return false;
            }
            int i3 = getErrorConfigVersion + 85;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public static w getAuthRequestContext(String str, Map<String, String> map) {
        w MyBillsEntityDataFactory2;
        int i = getErrorConfigVersion + 77;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            try {
                MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(str, "POST", MyBillsEntityDataFactory(map));
            } catch (Exception e) {
                throw e;
            }
        } else {
            MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(str, "POST", MyBillsEntityDataFactory(map));
            int i2 = 85 / 0;
        }
        int i3 = lookAheadTest + 1;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return MyBillsEntityDataFactory2;
    }

    public static String getAuthRequestContext(Context context, URL url) {
        Object obj;
        int i = lookAheadTest + 41;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? '[' : '\\') != '\\') {
            Object[] objArr = new Object[1];
            a(new char[]{1205, 14922, 25986, 52986, 45057}, new char[]{52052, 29910, 26085, 8060}, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22105), new char[]{16990, 16126, 23568, 28753}, (-445327669) << (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr);
            obj = objArr[0];
        } else {
            Object[] objArr2 = new Object[1];
            a(new char[]{1205, 14922, 25986, 52986, 45057}, new char[]{52052, 29910, 26085, 8060}, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 31844), new char[]{16990, 16126, 23568, 28753}, (-445327669) + (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr2);
            obj = objArr2[0];
        }
        return BuiltInFictitiousFunctionClassFactory(context, url, ((String) obj).intern());
    }

    public static boolean getAuthRequestContext(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                int i = lookAheadTest + 103;
                getErrorConfigVersion = i % 128;
                if (i % 2 == 0) {
                    Object obj = null;
                    obj.hashCode();
                    return false;
                }
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if ((activeNetworkInfo == null ? (char) 28 : 'N') == 28) {
                int i2 = getErrorConfigVersion + 117;
                lookAheadTest = i2 % 128;
                return i2 % 2 != 0;
            }
            if (!(1 == activeNetworkInfo.getType())) {
                return false;
            }
            int i3 = getErrorConfigVersion + 53;
            lookAheadTest = i3 % 128;
            if (i3 % 2 == 0) {
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int moveToNextValue(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager != null)) {
                int i = lookAheadTest + 49;
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if ((activeNetworkInfo == null ? ';' : 'D') != 'D') {
                return -1;
            }
            try {
                int type = activeNetworkInfo.getType();
                int i3 = getErrorConfigVersion + 67;
                lookAheadTest = i3 % 128;
                if (i3 % 2 != 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return type;
                }
                return type;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception unused) {
            return -1;
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
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? 'T' : (char) 19) != 'T') {
                break;
            }
            int i2 = $10 + 93;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L))) ^ ((char) (moveToNextValue ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
            int i6 = $10 + 35;
            $11 = i6 % 128;
            int i7 = i6 % 2;
        }
        String str = new String(cArr6);
        int i8 = $10 + 67;
        $11 = i8 % 128;
        if ((i8 % 2 == 0 ? '/' : (char) 20) == 20) {
            objArr[0] = str;
            return;
        }
        int i9 = 11 / 0;
        objArr[0] = str;
    }
}
