package com.iap.ac.android.acs.plugin.utils;

/* loaded from: classes8.dex */
public class ErrorCodeConvertUtil {
    public static final int CODE_API_BANNED = 101;
    public static final int CODE_COLLECTED = 100001;
    public static final int CODE_COLLECT_CONTENT_DIFF = 100003;
    public static final int CODE_COLLECT_COUNT_DIFF = 100002;
    public static final int CODE_COLLECT_LIMIT = 100000;
    public static final int CODE_NETWORK_ERROR = 100;
    public static final int CODE_PARAMETER_INVALID = 2;
    public static final int CODE_UNKNOWN_ERROR = 3;
    public static final String MSG_API_BANNED = "API is banned";
    public static final String MSG_NETWORK_ERROR = "Network error";
    public static final String MSG_PARAMETER_INVALID = "Parameters is invalid";
    public static final String MSG_UNKNOWN_ERROR = "Unknown error";
    public static final int NATIVE_API_IS_BANNED = 10100;
    public static final int NATIVE_LACK_COMPONENT = 10107;
    public static final int NATIVE_NETWORK_ERROR = 10104;
    public static final int NATIVE_PARAMETER_INVALID = 10102;
    public static final int NATIVE_SERVER_ERROR = 10105;
    public static final int NATIVE_SPI_NOT_IMPLEMENTED = 10103;
    public static final int NATIVE_UNKNOW_ERROR = 10106;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void callback2Failure(int r2, java.lang.String r3, com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback r4) {
        /*
            r0 = 10100(0x2774, float:1.4153E-41)
            if (r2 == r0) goto L28
            switch(r2) {
                case 10102: goto L10;
                case 10103: goto L24;
                case 10104: goto Lb;
                case 10105: goto L24;
                case 10106: goto L24;
                case 10107: goto L24;
                default: goto L7;
            }
        L7:
            switch(r2) {
                case 100000: goto L20;
                case 100001: goto L1c;
                case 100002: goto L18;
                case 100003: goto L14;
                default: goto La;
            }
        La:
            goto L24
        Lb:
            r2 = 100
            java.lang.String r3 = "Network error"
            goto L2c
        L10:
            r2 = 2
            java.lang.String r3 = "Parameters is invalid"
            goto L2c
        L14:
            r2 = 100003(0x186a3, float:1.40134E-40)
            goto L2c
        L18:
            r2 = 100002(0x186a2, float:1.40133E-40)
            goto L2c
        L1c:
            r2 = 100001(0x186a1, float:1.40131E-40)
            goto L2c
        L20:
            r2 = 100000(0x186a0, float:1.4013E-40)
            goto L2c
        L24:
            r2 = 3
            java.lang.String r3 = "Unknown error"
            goto L2c
        L28:
            r2 = 101(0x65, float:1.42E-43)
            java.lang.String r3 = "API is banned"
        L2c:
            if (r4 == 0) goto L48
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "error"
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L3e
            java.lang.String r2 = "errorMessage"
            r0.put(r2, r3)     // Catch: org.json.JSONException -> L3e
            goto L45
        L3e:
            java.lang.String r2 = "ErrorCodeConvertUtil"
            java.lang.String r3 = "JSONObject put exception"
            com.iap.ac.android.common.log.ACLog.e(r2, r3)
        L45:
            r4.onResult(r0)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.utils.ErrorCodeConvertUtil.callback2Failure(int, java.lang.String, com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback):void");
    }
}
