package com.huawei.hms.hatool;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: classes8.dex */
public abstract class a0 {

    /* loaded from: classes8.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return t0.getAuthRequestContext(inputStream);
            } catch (IOException unused) {
                int responseCode = httpURLConnection.getResponseCode();
                StringBuilder sb = new StringBuilder();
                sb.append("When Response Content From Connection inputStream operation exception! ");
                sb.append(responseCode);
                y.moveToNextValue("hmsSdk", sb.toString());
                t0.PlaceComponentResult(inputStream);
                return "";
            }
        } finally {
            t0.PlaceComponentResult(inputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f A[Catch: all -> 0x0141, IOException -> 0x0147, UnknownHostException -> 0x015f, ConnectException -> 0x0177, SSLHandshakeException -> 0x018f, SSLPeerUnverifiedException -> 0x01a7, SecurityException -> 0x01bf, a -> 0x01d7, TryCatch #11 {IOException -> 0x0147, blocks: (B:7:0x0017, B:9:0x001e, B:10:0x0026, B:12:0x003f, B:22:0x005f, B:23:0x006b, B:24:0x0072, B:20:0x0059, B:25:0x0073, B:27:0x009b, B:29:0x00a1, B:30:0x00a9, B:32:0x00af, B:34:0x00bd, B:36:0x00c3), top: B:141:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b A[Catch: all -> 0x0141, IOException -> 0x0147, UnknownHostException -> 0x015f, ConnectException -> 0x0177, SSLHandshakeException -> 0x018f, SSLPeerUnverifiedException -> 0x01a7, SecurityException -> 0x01bf, a -> 0x01d7, TryCatch #11 {IOException -> 0x0147, blocks: (B:7:0x0017, B:9:0x001e, B:10:0x0026, B:12:0x003f, B:22:0x005f, B:23:0x006b, B:24:0x0072, B:20:0x0059, B:25:0x0073, B:27:0x009b, B:29:0x00a1, B:30:0x00a9, B:32:0x00af, B:34:0x00bd, B:36:0x00c3), top: B:141:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cf A[Catch: all -> 0x012c, IOException -> 0x0130, UnknownHostException -> 0x0132, ConnectException -> 0x0134, SSLHandshakeException -> 0x0136, SSLPeerUnverifiedException -> 0x0138, SecurityException -> 0x013b, a -> 0x013e, TRY_ENTER, TRY_LEAVE, TryCatch #10 {a -> 0x013e, SecurityException -> 0x013b, ConnectException -> 0x0134, UnknownHostException -> 0x0132, SSLHandshakeException -> 0x0136, SSLPeerUnverifiedException -> 0x0138, IOException -> 0x0130, all -> 0x012c, blocks: (B:39:0x00cf, B:44:0x00e0), top: B:150:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0 A[Catch: all -> 0x012c, IOException -> 0x0130, UnknownHostException -> 0x0132, ConnectException -> 0x0134, SSLHandshakeException -> 0x0136, SSLPeerUnverifiedException -> 0x0138, SecurityException -> 0x013b, a -> 0x013e, TRY_ENTER, TRY_LEAVE, TryCatch #10 {a -> 0x013e, SecurityException -> 0x013b, ConnectException -> 0x0134, UnknownHostException -> 0x0132, SSLHandshakeException -> 0x0136, SSLPeerUnverifiedException -> 0x0138, IOException -> 0x0130, all -> 0x012c, blocks: (B:39:0x00cf, B:44:0x00e0), top: B:150:0x00cd }] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.hatool.b0 getAuthRequestContext(java.lang.String r9, byte[] r10, java.util.Map<java.lang.String, java.lang.String> r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.a0.getAuthRequestContext(java.lang.String, byte[], java.util.Map, java.lang.String):com.huawei.hms.hatool.b0");
    }
}
