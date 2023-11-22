package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes7.dex */
public final class Base64Utils {
    private static final int FLAG_DEFAULT = 0;
    private static final int FLAG_URL = 10;
    private static final int FLAG_URL_NOPADDING = 11;
    private static final String TAG = "Base64Utils";

    public static String encode(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 0);
        }
        return null;
    }

    public static String encodeUrlSafe(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 10);
        }
        return null;
    }

    public static String encodeUrlSafeNoPadding(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 11);
        }
        return null;
    }

    public static byte[] decode(String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            try {
                return Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("decode failed : ");
                sb.append(e.getMessage());
                HMSLog.e(TAG, sb.toString());
            }
        }
        return bArr;
    }

    public static byte[] decodeUrlSafe(String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            try {
                return Base64.decode(str, 10);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("decodeUrlSafe failed : ");
                sb.append(e.getMessage());
                HMSLog.e(TAG, sb.toString());
            }
        }
        return bArr;
    }

    public static byte[] decodeUrlSafeNoPadding(String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            try {
                return Base64.decode(str, 11);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("decodeUrlSafeNoPadding failed : ");
                sb.append(e.getMessage());
                HMSLog.e(TAG, sb.toString());
            }
        }
        return bArr;
    }
}
