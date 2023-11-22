package com.google.firebase.crashlytics.internal.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.crashlytics.internal.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import o.E;

/* loaded from: classes7.dex */
public class HttpGetRequest {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -956812108;
    private static final String METHOD_GET = "GET";
    private static int MyBillsEntityDataFactory = 1;
    private static long PlaceComponentResult = -1457685886462628092L;
    private static final int READ_BUFFER_SIZE = 8192;
    private static char getAuthRequestContext = 13492;
    private final Map<String, String> headers = new HashMap();
    private final Map<String, String> queryParams;
    private final String url;

    public HttpGetRequest(String str, Map<String, String> map) {
        this.url = str;
        this.queryParams = map;
    }

    public HttpGetRequest header(String str, String str2) {
        try {
            int i = MyBillsEntityDataFactory + 11;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            try {
                this.headers.put(str, str2);
                int i3 = BuiltInFictitiousFunctionClassFactory + 15;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 == 0 ? '\t' : 'M') != 'M') {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return this;
                }
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public HttpGetRequest header(Map.Entry<String, String> entry) {
        int i = MyBillsEntityDataFactory + 125;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            HttpGetRequest header = header(entry.getKey(), entry.getValue());
            int i3 = BuiltInFictitiousFunctionClassFactory + 25;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 == 0 ? '.' : ';') != ';') {
                Object obj = null;
                obj.hashCode();
                return header;
            }
            return header;
        } catch (Exception e) {
            throw e;
        }
    }

    public HttpResponse execute() throws IOException {
        Throwable th;
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream = null;
        String readStream = null;
        inputStream = null;
        try {
            String createUrlWithParams = createUrlWithParams(this.url, this.queryParams);
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("GET Request URL: ");
            sb.append(createUrlWithParams);
            logger.v(sb.toString());
            httpsURLConnection = (HttpsURLConnection) InstrumentInjector.urlconnection_wrapInstance(new URL(createUrlWithParams).openConnection());
            try {
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod("GET");
                Iterator<Map.Entry<String, String>> it = this.headers.entrySet().iterator();
                while (true) {
                    if (!(it.hasNext())) {
                        break;
                    }
                    try {
                        int i = MyBillsEntityDataFactory + 85;
                        try {
                            BuiltInFictitiousFunctionClassFactory = i % 128;
                            if (i % 2 != 0) {
                                Map.Entry<String, String> next = it.next();
                                httpsURLConnection.addRequestProperty(next.getKey(), next.getValue());
                                int i2 = 66 / 0;
                            } else {
                                Map.Entry<String, String> next2 = it.next();
                                httpsURLConnection.addRequestProperty(next2.getKey(), next2.getValue());
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        readStream = readStream(inputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            int i3 = BuiltInFictitiousFunctionClassFactory + 61;
                            MyBillsEntityDataFactory = i3 % 128;
                            int i4 = i3 % 2;
                            httpsURLConnection.disconnect();
                            int i5 = BuiltInFictitiousFunctionClassFactory + 15;
                            MyBillsEntityDataFactory = i5 % 128;
                            int i6 = i5 % 2;
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    int i7 = MyBillsEntityDataFactory + 35;
                    BuiltInFictitiousFunctionClassFactory = i7 % 128;
                    if ((i7 % 2 != 0 ? 'I' : ':') != ':') {
                        inputStream2.close();
                        int i8 = 25 / 0;
                    } else {
                        inputStream2.close();
                    }
                }
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                return new HttpResponse(responseCode, readStream);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpsURLConnection = null;
        }
    }

    private String createUrlWithParams(String str, Map<String, String> map) {
        String createParamsString = createParamsString(map);
        if (!(!createParamsString.isEmpty())) {
            int i = MyBillsEntityDataFactory + 95;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if ((i % 2 != 0 ? '%' : (char) 14) == '%') {
                int i2 = 92 / 0;
            }
            return str;
        } else if (!str.contains("?")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?");
            sb.append(createParamsString);
            String obj = sb.toString();
            int i3 = BuiltInFictitiousFunctionClassFactory + 77;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return obj;
        } else {
            try {
                if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(ContainerUtils.FIELD_DELIMITER);
                    sb2.append(createParamsString);
                    createParamsString = sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(createParamsString);
                return sb3.toString();
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private String createParamsString(Map<String, String> map) {
        String value;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                Map.Entry<String, String> next = it.next();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(next.getKey());
                sb2.append("=");
                if (next.getValue() == null) {
                    value = "";
                } else {
                    int i = BuiltInFictitiousFunctionClassFactory + 9;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    value = next.getValue();
                }
                sb2.append(value);
                sb.append(sb2.toString());
                while (it.hasNext()) {
                    Map.Entry<String, String> next2 = it.next();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(ContainerUtils.FIELD_DELIMITER);
                    sb3.append(next2.getKey());
                    sb3.append("=");
                    if (next2.getValue() != null) {
                        int i3 = MyBillsEntityDataFactory + 89;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        if (!(i3 % 2 != 0)) {
                            str = next2.getValue();
                        } else {
                            str = next2.getValue();
                            int i4 = 13 / 0;
                        }
                        int i5 = MyBillsEntityDataFactory + 19;
                        BuiltInFictitiousFunctionClassFactory = i5 % 128;
                        int i6 = i5 % 2;
                    } else {
                        str = "";
                    }
                    sb3.append(str);
                    sb.append(sb3.toString());
                    int i7 = BuiltInFictitiousFunctionClassFactory + 113;
                    MyBillsEntityDataFactory = i7 % 128;
                    int i8 = i7 % 2;
                }
                return sb.toString();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private String readStream(InputStream inputStream) throws IOException {
        Object[] objArr = new Object[1];
        a(new char[]{37550, 15220, 4, 40240, 53844}, new char[]{60214, 26066, 27576, 8587}, (char) (TextUtils.lastIndexOf("", '0', 0) + 35692), new char[]{23472, 2483, 6254, 55104}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1201286422, objArr);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, ((String) objArr[0]).intern()));
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        int i = MyBillsEntityDataFactory + 71;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        while (true) {
            int read = bufferedReader.read(cArr);
            if ((read != -1 ? '\r' : '\b') == '\r') {
                int i3 = MyBillsEntityDataFactory + 1;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
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
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? '8' : '?') == '8') {
                int i2 = $11 + 15;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i6 = $10 + 1;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
