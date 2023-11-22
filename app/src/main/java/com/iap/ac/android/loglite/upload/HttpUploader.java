package com.iap.ac.android.loglite.upload;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.appender.MdapFileLogAppender;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.core.LogEncryptClient;
import com.iap.ac.android.loglite.utils.BizCodeMatchUtils;
import com.iap.ac.android.loglite.utils.FileUtil;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import o.C;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class HttpUploader {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 52409;
    private static char MyBillsEntityDataFactory = 17633;
    private static char PlaceComponentResult = 4297;
    private static char getAuthRequestContext = 42002;
    private static int getErrorConfigVersion = 1;

    public final void a(File file, String str) throws IllegalStateException {
        try {
            String readFile = FileUtil.readFile(file);
            if (!TextUtils.isEmpty(readFile)) {
                if (AnalyticsContext.getInstance().isNeedEncryptLog()) {
                    String[] split = readFile.split(LoggerFactory.LOG_SPLITER);
                    LogEncryptClient logEncryptClient = AnalyticsContext.getInstance().getLogEncryptClient();
                    StringBuilder sb = new StringBuilder();
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.startsWith(MdapFileLogAppender.ENCRYPT_SIGN)) {
                                try {
                                    String decrypt = logEncryptClient.decrypt(str2.substring(2));
                                    if (!TextUtils.isEmpty(decrypt)) {
                                        sb.append(decrypt);
                                    }
                                } catch (Throwable unused) {
                                }
                            } else {
                                sb.append(str2);
                                sb.append(MasLog.Constant.GAP);
                            }
                        }
                    }
                    readFile = sb.toString();
                }
                byte[] gzipDataByString = LoggingUtil.gzipDataByString(readFile);
                String a2 = a(file.getName());
                HashMap hashMap = new HashMap();
                hashMap.put("Content-type", "text/xml");
                hashMap.put("Content-Encoding", HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
                hashMap.put("bizCode", a2);
                hashMap.put("productId", AnalyticsContext.getInstance().getProductId());
                hashMap.put("event", "default");
                hashMap.put("productVersion", AnalyticsContext.getInstance().getContextInfo().b);
                if (BizCodeMatchUtils.a() && AnalyticsContext.getInstance().getConfigurationManager().f) {
                    if (OKHttpUpload.c == null) {
                        synchronized (OKHttpUpload.class) {
                            if (OKHttpUpload.c == null) {
                                OKHttpUpload.c = new OKHttpUpload();
                            }
                        }
                    }
                    OKHttpUpload oKHttpUpload = OKHttpUpload.c;
                    if (!TextUtils.isEmpty(str) && gzipDataByString.length > 0) {
                        Request.Builder builder = new Request.Builder();
                        builder.url(str);
                        hashMap.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(gzipDataByString.length));
                        hashMap.put("accept", "*/*");
                        hashMap.put("connection", HttpHeaders.KEEP_ALIVE);
                        Object[] objArr = new Object[1];
                        b(4 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{42619, 52090, 4308, 30143, 30153, 64843}, objArr);
                        hashMap.put(HttpHeaders.ACCEPT_CHARSET, ((String) objArr[0]).intern());
                        for (Map.Entry entry : hashMap.entrySet()) {
                            builder.header((String) entry.getKey(), String.valueOf(entry.getValue()));
                        }
                        try {
                            Response execute = oKHttpUpload.f7599a.newCall(builder.method("POST", RequestBody.create(OKHttpUpload.b, gzipDataByString)).build()).execute();
                            int code = execute.code();
                            if (code != 200 && code != 202 && code != 201) {
                                throw new IllegalStateException("Okhttp POST request error");
                            }
                            execute.body().byteStream();
                        } catch (IOException e) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Okhttp POST request error: ");
                            sb2.append(e.getMessage());
                            throw new IllegalStateException(sb2.toString());
                        }
                    }
                } else {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection())));
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setReadTimeout(20000);
                        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(gzipDataByString.length));
                        for (String str3 : hashMap.keySet()) {
                            httpURLConnection.setRequestProperty(str3, (String) hashMap.get(str3));
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        bufferedOutputStream.write(gzipDataByString);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (200 == responseCode) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            Object[] objArr2 = new Object[1];
                            b(5 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{42619, 52090, 4308, 30143, 30153, 64843}, objArr2);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, ((String) objArr2[0]).intern()));
                            do {
                            } while (bufferedReader.readLine() != null);
                            bufferedReader.close();
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("response code is ");
                            sb3.append(responseCode);
                            throw new IllegalStateException(sb3.toString());
                        }
                    } catch (Throwable th) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("POST request error: ");
                        sb4.append(th);
                        throw new IllegalStateException(sb4.toString(), th);
                    }
                }
                try {
                    file.delete();
                    return;
                } catch (Throwable th2) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("delete file error: ");
                    sb5.append(th2);
                    throw new IllegalStateException(sb5.toString(), th2);
                }
            }
            file.delete();
            throw new IllegalStateException("file content is empty");
        } catch (Throwable th3) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("read file error: ");
            sb6.append(th3);
            throw new IllegalStateException(sb6.toString(), th3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x001d, code lost:
    
        if ((!r0 ? '?' : ',') != '?') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002c, code lost:
    
        if ((!r5.endsWith("crash")) != true) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = com.iap.ac.android.loglite.upload.HttpUploader.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 35
            int r1 = r0 % 128
            com.iap.ac.android.loglite.upload.HttpUploader.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = "crash"
            if (r0 != 0) goto L22
            boolean r0 = r5.endsWith(r2)
            int r3 = r1.length     // Catch: java.lang.Throwable -> L20
            r3 = 63
            if (r0 != 0) goto L1b
            r0 = 63
            goto L1d
        L1b:
            r0 = 44
        L1d:
            if (r0 == r3) goto L2f
            goto L42
        L20:
            r5 = move-exception
            throw r5
        L22:
            boolean r0 = r5.endsWith(r2)
            r3 = 1
            if (r0 != 0) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            if (r0 == r3) goto L2f
            goto L42
        L2f:
            java.lang.String r0 = "$=$"
            int r0 = r5.indexOf(r0)     // Catch: java.lang.Exception -> L3c
            int r0 = r0 + 3
            java.lang.String r2 = r5.substring(r0)     // Catch: java.lang.Exception -> L3c
            goto L42
        L3c:
            r5 = move-exception
            java.lang.String r0 = "HttpUploader"
            com.iap.ac.android.loglite.utils.LoggerWrapper.w(r0, r5)
        L42:
            int r5 = com.iap.ac.android.loglite.upload.HttpUploader.getErrorConfigVersion
            int r5 = r5 + 71
            int r0 = r5 % 128
            com.iap.ac.android.loglite.upload.HttpUploader.BuiltInFictitiousFunctionClassFactory = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L52
            int r5 = r1.length     // Catch: java.lang.Throwable -> L50
            return r2
        L50:
            r5 = move-exception
            throw r5
        L52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.loglite.upload.HttpUploader.a(java.lang.String):java.lang.String");
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if (!(c.BuiltInFictitiousFunctionClassFactory >= cArr.length)) {
                int i2 = $10 + 51;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = 0;
                while (true) {
                    if (!(i5 < 16)) {
                        break;
                    }
                    int i6 = $11 + 87;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i5++;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
