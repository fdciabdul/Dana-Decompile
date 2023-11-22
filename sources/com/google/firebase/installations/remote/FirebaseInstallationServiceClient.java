package com.google.firebase.installations.remote;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Ascii;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import o.D;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FirebaseInstallationServiceClient {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String API_KEY_HEADER = "x-goog-api-key";
    public static final int BuiltInFictitiousFunctionClassFactory;
    private static final String CACHE_CONTROL_DIRECTIVE = "no-cache";
    private static final String CACHE_CONTROL_HEADER_KEY = "Cache-Control";
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
    private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
    private static final Pattern EXPIRATION_TIMESTAMP_PATTERN;
    private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
    private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
    private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
    private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
    private static final String FIS_TAG = "Firebase-Installations";
    private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final String HEART_BEAT_HEADER = "x-firebase-client";
    private static final String JSON_CONTENT_TYPE = "application/json";
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static final int MAX_RETRIES = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static final int NETWORK_TIMEOUT_MILLIS = 10000;
    static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
    private static int PlaceComponentResult = 1;
    private static final String SDK_VERSION_PREFIX = "a:";
    private static final int TRAFFIC_STATS_CREATE_INSTALLATION_TAG = 32769;
    private static final int TRAFFIC_STATS_DELETE_INSTALLATION_TAG = 32770;
    private static final int TRAFFIC_STATS_FIREBASE_INSTALLATIONS_TAG = 32768;
    private static final int TRAFFIC_STATS_GENERATE_AUTH_TOKEN_TAG = 32771;
    private static final Charset UTF_8;
    private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
    private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
    private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
    private static long getAuthRequestContext;
    private final Context context;
    private final Provider<HeartBeatController> heartBeatProvider;
    private final RequestLimiter requestLimiter;
    private boolean shouldServerErrorRetry;

    static void PlaceComponentResult() {
        getAuthRequestContext = 5137741498749659817L;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0037 -> B:14:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L5e
            int r0 = r0 + 37
            int r1 = r0 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            byte[] r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r9 = r9 * 3
            int r9 = 16 - r9
            int r7 = r7 * 12
            int r7 = r7 + 4
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 51
            if (r0 != 0) goto L23
            r3 = 51
            goto L25
        L23:
            r3 = 89
        L25:
            r4 = 0
            if (r3 == r2) goto L31
            r2 = r1
            r3 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r6 = r8
            r8 = r7
            r7 = r6
            goto L47
        L31:
            r8 = r7
            r2 = r1
            r3 = 0
            r1 = r0
            r0 = r10
            r10 = r9
        L37:
            int r9 = -r9
            int r7 = r7 + r9
            int r8 = r8 + 1
            int r7 = r7 + 2
            int r9 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory
            int r9 = r9 + 109
            int r5 = r9 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult = r5
            int r9 = r9 % 2
        L47:
            byte r9 = (byte) r7
            r2[r3] = r9
            int r9 = r3 + 1
            if (r3 != r10) goto L56
            java.lang.String r7 = new java.lang.String
            r7.<init>(r2, r4)
            r0[r4] = r7
            return
        L56:
            r3 = r1[r8]
            r6 = r3
            r3 = r9
            r9 = r6
            goto L37
        L5c:
            r7 = move-exception
            throw r7
        L5e:
            r7 = move-exception
            goto L61
        L60:
            throw r7
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.b(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if ((r4 < 200) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        if ((r4 >= 20273 ? 'J' : 'X') != 'J') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
    
        if (r4 >= 300) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        r4 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory + 103;
        com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isSuccessfulResponseCode(int r4) {
        /*
            int r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult     // Catch: java.lang.Exception -> L3c
            int r0 = r0 + 29
            int r1 = r0 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L3c
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r2) goto L1d
            r0 = 200(0xc8, float:2.8E-43)
            if (r4 < r0) goto L19
            r0 = 0
            goto L1a
        L19:
            r0 = 1
        L1a:
            if (r0 == 0) goto L2b
            goto L31
        L1d:
            r0 = 20273(0x4f31, float:2.8409E-41)
            r3 = 74
            if (r4 < r0) goto L26
            r0 = 74
            goto L28
        L26:
            r0 = 88
        L28:
            if (r0 == r3) goto L2b
            goto L31
        L2b:
            r0 = 300(0x12c, float:4.2E-43)
            if (r4 >= r0) goto L31
            r1 = 1
            goto L3b
        L31:
            int r4 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory
            int r4 = r4 + 103
            int r0 = r4 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult = r0
            int r4 = r4 % 2
        L3b:
            return r1
        L3c:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.isSuccessfulResponseCode(int):boolean");
    }

    static {
        PlaceComponentResult();
        KClassImpl$Data$declaredNonStaticMembers$2 = new byte[]{11, Ascii.GS, 107, 8, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        BuiltInFictitiousFunctionClassFactory = 62;
        EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
        Object[] objArr = new Object[1];
        a(1 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{2263, 2178, 7793, 30547, 7053, 38379, 63844, 47511, 44643}, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        int i = MyBillsEntityDataFactory + 9;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    public FirebaseInstallationServiceClient(Context context, Provider<HeartBeatController> provider) {
        try {
            this.context = context;
            this.heartBeatProvider = provider;
            this.requestLimiter = new RequestLimiter();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        if (r15 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        if (r15 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r5.addRequestProperty(com.google.firebase.installations.remote.FirebaseInstallationServiceClient.X_ANDROID_IID_MIGRATION_KEY, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c0, code lost:
    
        logBadConfigError();
        r11 = com.google.firebase.installations.remote.InstallationResponse.builder().setResponseCode(com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG).build();
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0 A[EDGE_INSN: B:70:0x00c0->B:51:0x00c0 BREAK  A[LOOP:0: B:9:0x0021->B:58:0x00e9], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.firebase.installations.remote.InstallationResponse createFirebaseInstallation(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) throws com.google.firebase.installations.FirebaseInstallationsException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.createFirebaseInstallation(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.google.firebase.installations.remote.InstallationResponse");
    }

    private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        int i = PlaceComponentResult + 3;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            try {
                writeRequestBodyToOutputStream(httpURLConnection, getJsonBytes(buildCreateFirebaseInstallationRequestBody(str, str2)));
                int i3 = MyBillsEntityDataFactory + 107;
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 != 0) {
                    return;
                }
                int i4 = 46 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static byte[] getJsonBytes(JSONObject jSONObject) throws IOException {
        int i = PlaceComponentResult + 33;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String jSONObject2 = jSONObject.toString();
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1, new char[]{2263, 2178, 7793, 30547, 7053, 38379, 63844, 47511, 44643}, objArr);
        byte[] bytes = jSONObject2.getBytes(((String) objArr[0]).intern());
        int i3 = MyBillsEntityDataFactory + 107;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return bytes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r2 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
    
        if (r2 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = new java.util.zip.GZIPOutputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r0.write(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory + 117;
        com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        r0.close();
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        throw new java.io.IOException("Cannot send request to FIS servers. No OutputStream available.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void writeRequestBodyToOutputStream(java.net.URLConnection r2, byte[] r3) throws java.io.IOException {
        /*
            int r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult
            int r0 = r0 + 39
            int r1 = r0 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 34
            if (r0 == 0) goto L11
            r0 = 90
            goto L13
        L11:
            r0 = 34
        L13:
            java.io.OutputStream r2 = r2.getOutputStream()
            if (r0 == r1) goto L22
            r0 = 28
            int r0 = r0 / 0
            if (r2 == 0) goto L45
            goto L24
        L20:
            r2 = move-exception
            throw r2
        L22:
            if (r2 == 0) goto L45
        L24:
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream
            r0.<init>(r2)
            r0.write(r3)     // Catch: java.lang.Throwable -> L3d
            r0.close()     // Catch: java.io.IOException -> L3c
            r2.close()     // Catch: java.io.IOException -> L3c
            int r2 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory
            int r2 = r2 + 117
            int r3 = r2 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult = r3
            int r2 = r2 % 2
        L3c:
            return
        L3d:
            r3 = move-exception
            r0.close()     // Catch: java.io.IOException -> L44
            r2.close()     // Catch: java.io.IOException -> L44
        L44:
            throw r3
        L45:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Cannot send request to FIS servers. No OutputStream available."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.writeRequestBodyToOutputStream(java.net.URLConnection, byte[]):void");
    }

    private static JSONObject buildCreateFirebaseInstallationRequestBody(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", FIREBASE_INSTALLATION_AUTH_VERSION);
            jSONObject.put("sdkVersion", "a:17.0.3");
            try {
                int i = PlaceComponentResult + 23;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return jSONObject;
            } catch (Exception e) {
                throw e;
            }
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) throws IOException {
        try {
            int i = MyBillsEntityDataFactory + 57;
            PlaceComponentResult = i % 128;
            if ((i % 2 == 0 ? Typography.amp : 'E') != '&') {
                writeRequestBodyToOutputStream(httpURLConnection, getJsonBytes(buildGenerateAuthTokenRequestBody()));
                return;
            }
            writeRequestBodyToOutputStream(httpURLConnection, getJsonBytes(buildGenerateAuthTokenRequestBody()));
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private static JSONObject buildGenerateAuthTokenRequestBody() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:17.0.3");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            int i = PlaceComponentResult + 19;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return jSONObject2;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
    
        if ((r5 >= 28104 ? '\n' : '\r') == '\n') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
    
        if (r5 >= 500) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
    
        if (r5 >= 600) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a3, code lost:
    
        logBadConfigError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00af, code lost:
    
        throw new com.google.firebase.installations.FirebaseInstallationsException("Bad config while trying to delete FID", com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bf, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteFirebaseInstallation(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) throws com.google.firebase.installations.FirebaseInstallationsException {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.deleteFirebaseInstallation(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private URL getFullyQualifiedRequestUri(String str) throws FirebaseInstallationsException {
        try {
            URL url = new URL(String.format("https://%s/%s/%s", FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, str));
            int i = PlaceComponentResult + 31;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? '2' : 'Y') != '2') {
                return url;
            }
            int i2 = 46 / 0;
            return url;
        } catch (MalformedURLException e) {
            throw new FirebaseInstallationsException(e.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.firebase.installations.remote.TokenResult generateAuthToken(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) throws com.google.firebase.installations.FirebaseInstallationsException {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.generateAuthToken(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.google.firebase.installations.remote.TokenResult");
    }

    private static void logBadConfigError() {
        int i = PlaceComponentResult + 109;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        InstrumentInjector.log_e(FIS_TAG, "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
        try {
            int i3 = MyBillsEntityDataFactory + 83;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private HttpURLConnection openHttpURLConnection(URL url, String str) throws FirebaseInstallationsException {
        int i = MyBillsEntityDataFactory + 19;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) InstrumentInjector.urlconnection_wrapInstance(url.openConnection());
            httpURLConnection.setConnectTimeout(10000);
            int i3 = 0;
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.addRequestProperty(X_ANDROID_PACKAGE_HEADER_KEY, this.context.getPackageName());
            HeartBeatController heartBeatController = this.heartBeatProvider.get();
            if (!(heartBeatController == null)) {
                int i4 = PlaceComponentResult + 121;
                MyBillsEntityDataFactory = i4 % 128;
                Object[] objArr = null;
                try {
                    if (i4 % 2 != 0) {
                        httpURLConnection.addRequestProperty(HEART_BEAT_HEADER, (String) Tasks.await(heartBeatController.getHeartBeatsHeader()));
                        int length = objArr.length;
                    } else {
                        httpURLConnection.addRequestProperty(HEART_BEAT_HEADER, (String) Tasks.await(heartBeatController.getHeartBeatsHeader()));
                    }
                    int i5 = MyBillsEntityDataFactory + 91;
                    i3 = i5 % 128;
                    PlaceComponentResult = i3;
                    int i6 = i5 % 2;
                } catch (InterruptedException e) {
                    try {
                        byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                        byte b2 = (byte) (b - 1);
                        Object[] objArr2 = new Object[1];
                        b(b, b2, b2, objArr2);
                        Class<?> cls = Class.forName((String) objArr2[i3]);
                        byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                        byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                        Object[] objArr3 = new Object[1];
                        b(b3, b4, b4, objArr3);
                        ((Thread) cls.getMethod((String) objArr3[i3], null).invoke(null, null)).interrupt();
                        InstrumentInjector.log_w("ContentValues", "Failed to get heartbeats header", e);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (ExecutionException e2) {
                    InstrumentInjector.log_w("ContentValues", "Failed to get heartbeats header", e2);
                }
            }
            httpURLConnection.addRequestProperty(X_ANDROID_CERT_HEADER_KEY, getFingerprintHashForPackage());
            httpURLConnection.addRequestProperty(API_KEY_HEADER, str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.firebase.installations.remote.InstallationResponse readCreateResponse(java.net.HttpURLConnection r9) throws java.lang.AssertionError, java.io.IOException {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.readCreateResponse(java.net.HttpURLConnection):com.google.firebase.installations.remote.InstallationResponse");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x0080
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private com.google.firebase.installations.remote.TokenResult readGenerateAuthTokenResponse(java.net.HttpURLConnection r7) throws java.lang.AssertionError, java.io.IOException {
        /*
            r6 = this;
            java.io.InputStream r7 = r7.getInputStream()
            android.util.JsonReader r0 = new android.util.JsonReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.nio.charset.Charset r2 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.UTF_8
            r1.<init>(r7, r2)
            r0.<init>(r1)
            com.google.firebase.installations.remote.TokenResult$Builder r1 = com.google.firebase.installations.remote.TokenResult.builder()
            r0.beginObject()
        L17:
            boolean r2 = r0.hasNext()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L21
            r2 = 1
            goto L22
        L21:
            r2 = 0
        L22:
            if (r2 == r4) goto L38
            r0.endObject()
            r0.close()
            r7.close()
            com.google.firebase.installations.remote.TokenResult$ResponseCode r7 = com.google.firebase.installations.remote.TokenResult.ResponseCode.OK
            com.google.firebase.installations.remote.TokenResult$Builder r7 = r1.setResponseCode(r7)
            com.google.firebase.installations.remote.TokenResult r7 = r7.build()
            return r7
        L38:
            java.lang.String r2 = r0.nextName()
            java.lang.String r5 = "token"
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L46
            goto L47
        L46:
            r3 = 1
        L47:
            if (r3 == 0) goto L82
            java.lang.String r3 = "expiresIn"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L7e
            r3 = 51
            if (r2 == 0) goto L56
            r2 = 72
            goto L58
        L56:
            r2 = 51
        L58:
            if (r2 == r3) goto L70
            int r2 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory
            int r2 = r2 + 53
            int r3 = r2 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult = r3
            int r2 = r2 % 2
            java.lang.String r2 = r0.nextString()
            long r2 = parseTokenExpirationTimestamp(r2)
            r1.setTokenExpirationTimestamp(r2)
            goto L17
        L70:
            r0.skipValue()
            int r2 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult
            int r2 = r2 + 7
            int r3 = r2 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r3
            int r2 = r2 % 2
            goto L17
        L7e:
            r7 = move-exception
            throw r7
        L80:
            r7 = move-exception
            throw r7
        L82:
            java.lang.String r2 = r0.nextString()
            r1.setToken(r2)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.readGenerateAuthTokenResponse(java.net.HttpURLConnection):com.google.firebase.installations.remote.TokenResult");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Could not get fingerprint hash for package: ");
        r0.append(r5.context.getPackageName());
        com.fullstory.instrumentation.InstrumentInjector.log_e("ContentValues", r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult + 9;
        com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if ((r0 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        r0 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        r0 = '9';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r0 == 11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        return com.google.android.gms.common.util.Hex.bytesToStringUppercase(r0, false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getFingerprintHashForPackage() {
        /*
            r5 = this;
            int r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult
            int r0 = r0 + 69
            int r1 = r0 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = "ContentValues"
            r4 = 0
            if (r0 == r1) goto L2a
            android.content.Context r0 = r5.context     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            java.lang.String r1 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            byte[] r0 = com.google.android.gms.common.util.AndroidUtilsLight.getPackageCertificateHashBytes(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            r1 = 98
            int r1 = r1 / r2
            if (r0 != 0) goto L6c
            goto L36
        L26:
            r0 = move-exception
            throw r0
        L28:
            r0 = move-exception
            goto L71
        L2a:
            android.content.Context r0 = r5.context     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            java.lang.String r1 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            byte[] r0 = com.google.android.gms.common.util.AndroidUtilsLight.getPackageCertificateHashBytes(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            if (r0 != 0) goto L6c
        L36:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            r0.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            java.lang.String r1 = "Could not get fingerprint hash for package: "
            r0.append(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.Context r1 = r5.context     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            java.lang.String r1 = r1.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            r0.append(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            java.lang.String r0 = r0.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            com.fullstory.instrumentation.InstrumentInjector.log_e(r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            int r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult
            int r0 = r0 + 9
            int r1 = r0 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 11
            if (r0 == 0) goto L61
            r0 = 11
            goto L63
        L61:
            r0 = 57
        L63:
            if (r0 == r1) goto L66
            return r4
        L66:
            r4.hashCode()     // Catch: java.lang.Throwable -> L6a
            return r4
        L6a:
            r0 = move-exception
            throw r0
        L6c:
            java.lang.String r0 = com.google.android.gms.common.util.Hex.bytesToStringUppercase(r0, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            return r0
        L71:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No such package: "
            r1.append(r2)
            android.content.Context r2 = r5.context
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.fullstory.instrumentation.InstrumentInjector.log_e(r3, r1, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.getFingerprintHashForPackage():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r3 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
    
        if (r3.length() == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r0 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        r0 = java.lang.Long.parseLong(r3.substring(0, r3.length() - 1));
        r3 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult + 41;
        com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if (r3 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static long parseTokenExpirationTimestamp(java.lang.String r3) {
        /*
            int r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult
            int r0 = r0 + 115
            int r1 = r0 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 16
            if (r0 == 0) goto L11
            r0 = 16
            goto L13
        L11:
            r0 = 45
        L13:
            java.lang.String r2 = "Invalid Expiration Timestamp."
            if (r0 == r1) goto L27
            java.util.regex.Pattern r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.EXPIRATION_TIMESTAMP_PATTERN
            java.util.regex.Matcher r0 = r0.matcher(r3)
            boolean r0 = r0.matches()
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r2)
            if (r3 == 0) goto L5f
            goto L3a
        L27:
            java.util.regex.Pattern r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.EXPIRATION_TIMESTAMP_PATTERN
            java.util.regex.Matcher r0 = r0.matcher(r3)
            boolean r0 = r0.matches()
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r2)
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L5f
        L3a:
            int r0 = r3.length()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L44
            r0 = 1
            goto L45
        L44:
            r0 = 0
        L45:
            if (r0 == 0) goto L5f
            int r0 = r3.length()
            int r0 = r0 - r1
            java.lang.String r3 = r3.substring(r2, r0)
            long r0 = java.lang.Long.parseLong(r3)
            int r3 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult
            int r3 = r3 + 41
            int r2 = r3 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r2
            int r3 = r3 % 2
            goto L61
        L5f:
            r0 = 0
        L61:
            return r0
        L62:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.parseTokenExpirationTimestamp(java.lang.String):long");
    }

    private static void logFisCommunicationError(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        String readErrorResponse = readErrorResponse(httpURLConnection);
        if (!TextUtils.isEmpty(readErrorResponse)) {
            int i = PlaceComponentResult + 25;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? '+' : '#') != '+') {
                InstrumentInjector.log_w(FIS_TAG, readErrorResponse);
                InstrumentInjector.log_w(FIS_TAG, availableFirebaseOptions(str, str2, str3));
            } else {
                try {
                    InstrumentInjector.log_w(FIS_TAG, readErrorResponse);
                    try {
                        InstrumentInjector.log_w(FIS_TAG, availableFirebaseOptions(str, str2, str3));
                        Object obj = null;
                        obj.hashCode();
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        int i2 = PlaceComponentResult + 57;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if ((android.text.TextUtils.isEmpty(r5) ? '8' : com.alibaba.fastjson.parser.JSONLexer.EOI) != '8') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append(", ");
        r6.append(r5);
        r5 = r6.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String availableFirebaseOptions(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult     // Catch: java.lang.Exception -> L6a
            int r0 = r0 + 63
            int r1 = r0 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L68
            r1 = 2
            int r0 = r0 % r1
            r2 = 60
            if (r0 == 0) goto L11
            r0 = 69
            goto L13
        L11:
            r0 = 60
        L13:
            r3 = 0
            r4 = 1
            if (r0 == r2) goto L2e
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r4] = r6
            r0[r3] = r7
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r7 = 56
            if (r6 == 0) goto L29
            r6 = 56
            goto L2b
        L29:
            r6 = 26
        L2b:
            if (r6 == r7) goto L3b
            goto L3e
        L2e:
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L6a
            r0[r3] = r6
            r0[r4] = r7
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L68
            if (r6 == 0) goto L3e
        L3b:
            java.lang.String r5 = ""
            goto L4f
        L3e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = ", "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
        L4f:
            r0[r1] = r5
            java.lang.String r5 = "Firebase options used while communicating with Firebase server APIs: %s, %s%s"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            int r6 = com.google.firebase.installations.remote.FirebaseInstallationServiceClient.PlaceComponentResult
            int r6 = r6 + 15
            int r7 = r6 % 128
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.MyBillsEntityDataFactory = r7
            int r6 = r6 % r1
            if (r6 == 0) goto L67
            r6 = 0
            int r6 = r6.length     // Catch: java.lang.Throwable -> L65
            return r5
        L65:
            r5 = move-exception
            throw r5
        L67:
            return r5
        L68:
            r5 = move-exception
            throw r5
        L6a:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.availableFirebaseOptions(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String readErrorResponse(HttpURLConnection httpURLConnection) {
        int i = PlaceComponentResult + 15;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        InputStream errorStream = httpURLConnection.getErrorStream();
        Object obj = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, UTF_8));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (!(readLine != null)) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                    }
                    String format = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    return format;
                } catch (IOException unused2) {
                    bufferedReader.close();
                    return null;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                return null;
            }
        }
        int i3 = MyBillsEntityDataFactory + 37;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            obj.hashCode();
            return null;
        }
        return null;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            int i2 = $11 + 63;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length ? (char) 23 : '\f') == '\f') {
                    String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                    int i4 = $10 + 75;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                    objArr[0] = str;
                    return;
                }
                int i6 = $11 + 107;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
