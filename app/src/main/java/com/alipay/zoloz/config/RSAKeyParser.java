package com.alipay.zoloz.config;

import android.content.Context;
import com.alipay.mobile.security.bio.utils.FileUtil;

/* loaded from: classes7.dex */
public class RSAKeyParser {
    public static String getPublicKey(Context context, int i) {
        byte[] assetsData;
        try {
            if (i == 0) {
                assetsData = FileUtil.getAssetsData(context, "bid-log-key-public.key");
            } else {
                assetsData = FileUtil.getAssetsData(context, "bid-log-key-public_t.key");
            }
            return new String(assetsData);
        } catch (Exception unused) {
            return "";
        }
    }
}
