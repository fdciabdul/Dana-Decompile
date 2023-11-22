package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.backend.cct.BuildConfig;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.retries.RetryStrategy;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.common.net.HttpHeaders;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import kotlin.text.Typography;
import o.getCallingPid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class CctTransportBackend implements TransportBackend {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String ACCEPT_ENCODING_HEADER_KEY = "Accept-Encoding";
    static final String API_KEY_HEADER_KEY = "X-Goog-Api-Key";
    private static final int CONNECTION_TIME_OUT = 30000;
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final int INVALID_VERSION_CODE = -1;
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static final String KEY_APPLICATION_BUILD = "application_build";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_FINGERPRINT = "fingerprint";
    private static final String KEY_HARDWARE = "hardware";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_MCC_MNC = "mcc_mnc";
    static final String KEY_MOBILE_SUBTYPE = "mobile-subtype";
    private static final String KEY_MODEL = "model";
    static final String KEY_NETWORK_TYPE = "net-type";
    private static final String KEY_OS_BUILD = "os-uild";
    private static final String KEY_PRODUCT = "product";
    private static final String KEY_SDK_VERSION = "sdk-version";
    private static final String KEY_TIMEZONE_OFFSET = "tz-offset";
    private static final String LOG_TAG = "CctTransportBackend";
    private static char[] MyBillsEntityDataFactory = {42068, 37257, 37346, 42070, 37274, 37275, 42065, 37367, 42071};
    private static int PlaceComponentResult = 0;
    private static final int READ_TIME_OUT = 130000;
    private static char getAuthRequestContext = 42070;
    private final Context applicationContext;
    private final ConnectivityManager connectivityManager;
    private final DataEncoder dataEncoder;
    final URL endPoint;
    private final int readTimeout;
    private final Clock uptimeClock;
    private final Clock wallTimeClock;

    public static /* synthetic */ HttpResponse $r8$lambda$bLAzIpNF4NtapXlUpPVGhzxyNT8(CctTransportBackend cctTransportBackend, HttpRequest httpRequest) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        HttpResponse doSend = cctTransportBackend.doSend(httpRequest);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return doSend;
    }

    private static URL parseUrlOrThrow(String str) {
        try {
            URL url = new URL(str);
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                try {
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return url;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (MalformedURLException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid url: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString(), e3);
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i) {
        this.dataEncoder = BatchedLogRequest.createDataEncoder();
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, READ_TIME_OUT);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        int i = PlaceComponentResult + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        boolean z = i % 2 == 0;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (z) {
            int i2 = 80 / 0;
        }
        return telephonyManager;
    }

    private static int getPackageVersionCode(Context context) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        PlaceComponentResult = i % 128;
        try {
            int i2 = ((i % 2 != 0 ? (char) 20 : '7') != 20 ? context.getPackageManager().getPackageInfo(context.getPackageName(), 0) : context.getPackageManager().getPackageInfo(context.getPackageName(), 0)).versionCode;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return i2;
            }
            int i4 = 44 / 0;
            return i2;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.e(LOG_TAG, "Unable to find version code for package", e);
            return -1;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public final EventInternal decorate(EventInternal eventInternal) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        EventInternal build = eventInternal.toBuilder().addMetadata(KEY_SDK_VERSION, Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata(KEY_HARDWARE, Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata(KEY_PRODUCT, Build.PRODUCT).addMetadata(KEY_OS_BUILD, Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata(KEY_FINGERPRINT, Build.FINGERPRINT).addMetadata(KEY_TIMEZONE_OFFSET, getTzOffset()).addMetadata(KEY_NETWORK_TYPE, getNetTypeValue(activeNetworkInfo)).addMetadata(KEY_MOBILE_SUBTYPE, getNetSubtypeValue(activeNetworkInfo)).addMetadata("country", Locale.getDefault().getCountry()).addMetadata("locale", Locale.getDefault().getLanguage()).addMetadata(KEY_MCC_MNC, getTelephonyManager(this.applicationContext).getSimOperator()).addMetadata(KEY_APPLICATION_BUILD, Integer.toString(getPackageVersionCode(this.applicationContext))).build();
        try {
            int i3 = PlaceComponentResult + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return build;
            }
            return build;
        } catch (Exception e) {
            throw e;
        }
    }

    private static int getNetTypeValue(NetworkInfo networkInfo) {
        int i = PlaceComponentResult + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if ((networkInfo == null ? 'L' : 'E') != 'E') {
            int value = NetworkConnectionInfo.NetworkType.NONE.getValue();
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return value;
            } catch (Exception e) {
                throw e;
            }
        }
        return networkInfo.getType();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if ((r4 == null) != true) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        if (r4 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        r4 = com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        if ((r4 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        r4 = com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        return com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        r4 = r4.getSubtype();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        if (r4 != (-1)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        r4 = com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult + 1;
        com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if ((r4 % 2) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
    
        r4 = com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
    
        return com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0069, code lost:
    
        if (com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.forNumber(r4) != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        r4 = com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult = r4 % 128;
        r4 = r4 % 2;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0076, code lost:
    
        r0 = com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0080, code lost:
    
        if ((r0 % 2) == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
    
        r0 = 79 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0088, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int getNetSubtypeValue(android.net.NetworkInfo r4) {
        /*
            int r0 = com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L89
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L89
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == r2) goto L21
            r0 = 23
            int r0 = r0 / r1
            if (r4 != 0) goto L1b
            r0 = 1
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == r2) goto L23
            goto L40
        L1f:
            r4 = move-exception
            throw r4
        L21:
            if (r4 != 0) goto L40
        L23:
            int r4 = com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 57
            int r0 = r4 % 128
            com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L39
            com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype r4 = com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE
            int r4 = r4.getValue()
            int r0 = r3.length     // Catch: java.lang.Throwable -> L37
            goto L3f
        L37:
            r4 = move-exception
            throw r4
        L39:
            com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype r4 = com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE
            int r4 = r4.getValue()
        L3f:
            return r4
        L40:
            int r4 = r4.getSubtype()
            r0 = -1
            if (r4 != r0) goto L65
            int r4 = com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult
            int r4 = r4 + r2
            int r0 = r4 % 128
            com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r4 = r4 % 2
            if (r4 != 0) goto L5e
            com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype r4 = com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.COMBINED     // Catch: java.lang.Exception -> L89
            int r4 = r4.getValue()
            r3.hashCode()     // Catch: java.lang.Throwable -> L5c
            return r4
        L5c:
            r4 = move-exception
            throw r4
        L5e:
            com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype r4 = com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.COMBINED     // Catch: java.lang.Exception -> L89
            int r4 = r4.getValue()     // Catch: java.lang.Exception -> L89
            return r4
        L65:
            com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype r0 = com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.forNumber(r4)
            if (r0 != 0) goto L76
            int r4 = com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 27
            int r0 = r4 % 128
            com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult = r0
            int r4 = r4 % 2
            r4 = 0
        L76:
            int r0 = com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 51
            int r2 = r0 % 128
            com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L88
            r0 = 79
            int r0 = r0 / r1
            return r4
        L86:
            r4 = move-exception
            throw r4
        L88:
            return r4
        L89:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.CctTransportBackend.getNetSubtypeValue(android.net.NetworkInfo):int");
    }

    private BatchedLogRequest getRequestBody(BackendRequest backendRequest) {
        LogEvent.Builder protoBuilder;
        HashMap hashMap = new HashMap();
        int i = PlaceComponentResult + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        for (EventInternal eventInternal : backendRequest.getEvents()) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            String transportName = eventInternal.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(eventInternal);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder clientInfo = LogRequest.builder().setQosTier(QosTier.DEFAULT).setRequestTimeMs(this.wallTimeClock.getTime()).setRequestUptimeMs(this.uptimeClock.getTime()).setClientInfo(ClientInfo.builder().setClientType(ClientInfo.ClientType.ANDROID_FIREBASE).setAndroidClientInfo(AndroidClientInfo.builder().setSdkVersion(Integer.valueOf(eventInternal2.getInteger(KEY_SDK_VERSION))).setModel(eventInternal2.get("model")).setHardware(eventInternal2.get(KEY_HARDWARE)).setDevice(eventInternal2.get("device")).setProduct(eventInternal2.get(KEY_PRODUCT)).setOsBuild(eventInternal2.get(KEY_OS_BUILD)).setManufacturer(eventInternal2.get("manufacturer")).setFingerprint(eventInternal2.get(KEY_FINGERPRINT)).setCountry(eventInternal2.get("country")).setLocale(eventInternal2.get("locale")).setMccMnc(eventInternal2.get(KEY_MCC_MNC)).setApplicationBuild(eventInternal2.get(KEY_APPLICATION_BUILD)).build()).build());
            try {
                clientInfo.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                clientInfo.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = ((List) entry.getValue()).iterator();
            while (true) {
                if (!(!it.hasNext())) {
                    EventInternal eventInternal3 = (EventInternal) it.next();
                    EncodedPayload encodedPayload = eventInternal3.getEncodedPayload();
                    Encoding encoding = encodedPayload.getEncoding();
                    if (encoding.equals(Encoding.of("proto"))) {
                        protoBuilder = LogEvent.protoBuilder(encodedPayload.getBytes());
                    } else if (encoding.equals(Encoding.of("json"))) {
                        byte[] bytes = encodedPayload.getBytes();
                        Object[] objArr = new Object[1];
                        a(new char[]{5, 3, 2, 0, 13837}, (byte) (107 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), TextUtils.getCapsMode("", 0, 0) + 5, objArr);
                        protoBuilder = LogEvent.jsonBuilder(new String(bytes, Charset.forName(((String) objArr[0]).intern())));
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                        PlaceComponentResult = i5 % 128;
                        int i6 = i5 % 2;
                    } else {
                        Logging.w(LOG_TAG, "Received event of unsupported encoding %s. Skipping...", encoding);
                        int i7 = PlaceComponentResult + 9;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                        int i8 = i7 % 2;
                    }
                    protoBuilder.setEventTimeMs(eventInternal3.getEventMillis()).setEventUptimeMs(eventInternal3.getUptimeMillis()).setTimezoneOffsetSeconds(eventInternal3.getLong(KEY_TIMEZONE_OFFSET)).setNetworkConnectionInfo(NetworkConnectionInfo.builder().setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(eventInternal3.getInteger(KEY_NETWORK_TYPE))).setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal3.getInteger(KEY_MOBILE_SUBTYPE))).build());
                    if ((eventInternal3.getCode() != null ? (char) 29 : '\n') != '\n') {
                        protoBuilder.setEventCode(eventInternal3.getCode());
                    }
                    arrayList3.add(protoBuilder.build());
                }
            }
            clientInfo.setLogEvents(arrayList3);
            arrayList2.add(clientInfo.build());
        }
        return BatchedLogRequest.create(arrayList2);
    }

    private HttpResponse doSend(HttpRequest httpRequest) throws IOException {
        Logging.i(LOG_TAG, "Making request to: %s", httpRequest.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) InstrumentInjector.urlconnection_wrapInstance(httpRequest.url.openConnection());
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, String.format("datatransport/%s android/", BuildConfig.VERSION_NAME));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        if (httpRequest.apiKey != null) {
            int i = PlaceComponentResult + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 == 0) {
                httpURLConnection.setRequestProperty(API_KEY_HEADER_KEY, httpRequest.apiKey);
                int i2 = 72 / 0;
            } else {
                httpURLConnection.setRequestProperty(API_KEY_HEADER_KEY, httpRequest.apiKey);
            }
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.dataEncoder.encode(httpRequest.requestBody, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        try {
                            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                            PlaceComponentResult = i3 % 128;
                            if ((i3 % 2 != 0 ? Typography.amp : '@') != '@') {
                                outputStream.close();
                                int i4 = 90 / 0;
                            } else {
                                outputStream.close();
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Logging.i(LOG_TAG, "Status Code: %d", Integer.valueOf(responseCode));
                    Logging.d(LOG_TAG, "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    Logging.d(LOG_TAG, "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode != 302) {
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                        PlaceComponentResult = i5 % 128;
                        int i6 = i5 % 2;
                        if (responseCode != 301) {
                            if (responseCode != 307) {
                                if (responseCode != 200) {
                                    return new HttpResponse(responseCode, null, 0L);
                                }
                                InputStream inputStream = httpURLConnection.getInputStream();
                                try {
                                    InputStream maybeUnGzip = maybeUnGzip(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                                    try {
                                        HttpResponse httpResponse = new HttpResponse(responseCode, null, LogResponse.fromJson(new BufferedReader(new InputStreamReader(maybeUnGzip))).getNextRequestWaitMillis());
                                        if (maybeUnGzip != null) {
                                            int i7 = PlaceComponentResult + 109;
                                            KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                                            int i8 = i7 % 2;
                                            maybeUnGzip.close();
                                        }
                                        if ((inputStream != null ? (char) 29 : 'b') != 'b') {
                                            inputStream.close();
                                        }
                                        return httpResponse;
                                    } finally {
                                    }
                                } catch (Throwable th) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e2) {
            e = e2;
            Logging.e(LOG_TAG, "Couldn't encode request, returning with 400", e);
            return new HttpResponse(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            Logging.e(LOG_TAG, "Couldn't open connection, returning with 500", e);
            return new HttpResponse(500, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            Logging.e(LOG_TAG, "Couldn't open connection, returning with 500", e);
            return new HttpResponse(500, null, 0L);
        } catch (IOException e5) {
            e = e5;
            Logging.e(LOG_TAG, "Couldn't encode request, returning with 400", e);
            return new HttpResponse(400, null, 0L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if ("gzip".equals(r4) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if ("gzip".equals(r4) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        return new java.util.zip.GZIPInputStream(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        r4 = com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult + 101;
        com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.InputStream maybeUnGzip(java.io.InputStream r3, java.lang.String r4) throws java.io.IOException {
        /*
            int r0 = com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult
            int r0 = r0 + 3
            int r1 = r0 % 128
            com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 29
            if (r0 != 0) goto L11
            r0 = 51
            goto L13
        L11:
            r0 = 29
        L13:
            java.lang.String r2 = "gzip"
            if (r0 == r1) goto L24
            boolean r4 = r2.equals(r4)
            r0 = 76
            int r0 = r0 / 0
            if (r4 == 0) goto L30
            goto L2a
        L22:
            r3 = move-exception
            throw r3
        L24:
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L30
        L2a:
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream
            r4.<init>(r3)
            return r4
        L30:
            int r4 = com.google.android.datatransport.cct.CctTransportBackend.PlaceComponentResult
            int r4 = r4 + 101
            int r0 = r4 % 128
            com.google.android.datatransport.cct.CctTransportBackend.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r4 = r4 % 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.CctTransportBackend.maybeUnGzip(java.io.InputStream, java.lang.String):java.io.InputStream");
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public final BackendResponse send(BackendRequest backendRequest) {
        String aPIKey;
        BatchedLogRequest requestBody = getRequestBody(backendRequest);
        URL url = this.endPoint;
        String str = null;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
                    PlaceComponentResult = i % 128;
                    if ((i % 2 != 0 ? '\r' : '/') != '/') {
                        aPIKey = fromByteArray.getAPIKey();
                        str.hashCode();
                    } else {
                        aPIKey = fromByteArray.getAPIKey();
                    }
                    str = aPIKey;
                }
                if ((fromByteArray.getEndPoint() != null ? (char) 24 : (char) 28) != 28) {
                    int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                    PlaceComponentResult = i2 % 128;
                    int i3 = i2 % 2;
                    url = parseUrlOrThrow(fromByteArray.getEndPoint());
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.fatalError();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.retry(5, new HttpRequest(url, requestBody, str), new Function() { // from class: com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0
                @Override // com.google.android.datatransport.runtime.retries.Function
                public final Object apply(Object obj) {
                    return CctTransportBackend.$r8$lambda$bLAzIpNF4NtapXlUpPVGhzxyNT8(CctTransportBackend.this, (CctTransportBackend.HttpRequest) obj);
                }
            }, new RetryStrategy() { // from class: com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda1
                @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
                public final Object shouldRetry(Object obj, Object obj2) {
                    return CctTransportBackend.lambda$send$0((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
                }
            });
            if (!(httpResponse.code != 200)) {
                int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
                PlaceComponentResult = i6 % 128;
                if (i6 % 2 != 0) {
                    int i7 = 16 / 0;
                    return BackendResponse.ok(httpResponse.nextRequestMillis);
                }
                return BackendResponse.ok(httpResponse.nextRequestMillis);
            }
            if (httpResponse.code < 500) {
                if (httpResponse.code != 404) {
                    return httpResponse.code == 400 ? BackendResponse.invalidPayload() : BackendResponse.fatalError();
                }
                int i8 = PlaceComponentResult + 37;
                KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                int i9 = i8 % 2;
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.e(LOG_TAG, "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HttpRequest lambda$send$0(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpResponse.redirectUrl == null) {
            return null;
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Logging.d(LOG_TAG, "Following redirect to: %s", httpResponse.redirectUrl);
        HttpRequest withUrl = httpRequest.withUrl(httpResponse.redirectUrl);
        int i3 = PlaceComponentResult + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return withUrl;
    }

    static long getTzOffset() {
        int offset;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 14 : Typography.less) != '<') {
            try {
                Calendar.getInstance();
                offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) >>> 18952;
            } catch (Exception e) {
                throw e;
            }
        } else {
            Calendar.getInstance();
            offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        }
        long j = offset;
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class HttpResponse {
        final int code;
        final long nextRequestMillis;
        final URL redirectUrl;

        HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class HttpRequest {
        final String apiKey;
        final BatchedLogRequest requestBody;
        final URL url;

        HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.url = url;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }

        final HttpRequest withUrl(URL url) {
            return new HttpRequest(url, this.requestBody, this.apiKey);
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        int length;
        char[] cArr2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr3 = MyBillsEntityDataFactory;
        if (cArr3 != null) {
            int i3 = $11 + 73;
            $10 = i3 % 128;
            if (i3 % 2 != 0) {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            int i4 = 0;
            while (i4 < length) {
                int i5 = $11 + 123;
                $10 = i5 % 128;
                if (!(i5 % 2 == 0)) {
                    try {
                        cArr2[i4] = (char) (cArr3[i4] / (-1549216646985767851L));
                        i4 += 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    cArr2[i4] = (char) (cArr3[i4] ^ (-1549216646985767851L));
                    i4++;
                }
            }
            cArr3 = cArr2;
        }
        char c = (char) ((-1549216646985767851L) ^ getAuthRequestContext);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i6 = $10 + 87;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                int i8 = $10 + 39;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        try {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr3[i10];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i11];
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        int i12 = $11 + 105;
                        $10 = i12 % 128;
                        int i13 = i12 % 2;
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr3[i14];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i15];
                    } else {
                        int i16 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i17 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr3[i16];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i17];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i18 = 0; i18 < i; i18++) {
            cArr4[i18] = (char) (cArr4[i18] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
