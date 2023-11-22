package com.alipay.mobile.security.zim.api;

import android.content.Context;
import com.alipay.mobile.security.zim.biz.ZimPlatform;

/* loaded from: classes7.dex */
public class ZIMFacadeBuilder {
    public static ZIMFacade create(Context context) {
        if (context == null) {
            throw new RuntimeException("context Can't be null");
        }
        return new ZimPlatform(context);
    }
}
