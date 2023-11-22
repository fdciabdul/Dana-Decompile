package com.iap.ac.android.common.errorcode;

import com.iap.ac.android.common.a.a;

/* loaded from: classes8.dex */
public class IAPAECodeEncoding {
    public static final String IAP_ERROR_IDENTITY = "AE";
    public static final String IAP_ERROR_VERSION = "1";
    public static final String IAP_MOBILE_IDENTITY = "02221000";
    public static final String IAP_NETWORK_ERROR = createErrorCode("000");
    public static final String IAP_NETWORK_UNAVAILABLE_ERROR = createErrorCode("001");
    public static final String IAP_REQUEST_TIMEOUT = createErrorCode("002");
    public static final String IAP_RPC_DATA_PARSE_FAILED_ERROR = createErrorCode("003");
    public static final String IAP_ILLEGAL_ARGUMENT = createErrorCode("004");
    public static final String IAP_GATEWAY_OVERFLOW_ERROR = createErrorCode("020");
    public static final String IAP_COMMON_BIZ_ERROR = createErrorCode("050");

    public static String createErrorCode(String str) {
        return createErrorCode(str, null, null);
    }

    public static String createErrorCode(String str, IAPErrorLevel iAPErrorLevel, IAPErrorType iAPErrorType) {
        if (str == null) {
            return null;
        }
        if (iAPErrorLevel == null) {
            iAPErrorLevel = IAPErrorLevel.error;
        }
        if (iAPErrorType == null) {
            iAPErrorType = IAPErrorType.system;
        }
        StringBuilder a2 = a.a("AE1");
        a2.append(iAPErrorLevel.getValue());
        a2.append(iAPErrorType.getValue());
        a2.append(IAP_MOBILE_IDENTITY);
        a2.append(str);
        return a2.toString();
    }

    public static String createErrorCode(String str, IAPErrorLevel iAPErrorLevel) {
        return createErrorCode(str, iAPErrorLevel, null);
    }

    public static String createErrorCode(String str, IAPErrorType iAPErrorType) {
        return createErrorCode(str, null, iAPErrorType);
    }
}
