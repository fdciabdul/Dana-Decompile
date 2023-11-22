package com.alipay.plus.android.config.sdk.delegate;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.utils.MiscUtils;

/* loaded from: classes7.dex */
public abstract class ConfigIdentifierProvider {
    public String getConfigUserId(Context context) {
        String utdId = getUtdId(context);
        if (TextUtils.isEmpty(utdId)) {
            return "";
        }
        String md5 = MiscUtils.md5(utdId);
        return md5.length() >= 16 ? md5.substring(0, 16).toUpperCase() : "";
    }

    public abstract String getUtdId(Context context);
}
