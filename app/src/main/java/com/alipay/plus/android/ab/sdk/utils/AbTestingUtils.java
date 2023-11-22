package com.alipay.plus.android.ab.sdk.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.profile.SyncProfile;
import com.alipay.plus.android.config.sdk.a.e;

/* loaded from: classes7.dex */
public class AbTestingUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7349a = e.a("AbTestingUtils");

    public static SyncProfile createSyncProfile(ProfileExtractor profileExtractor, String str, String str2) {
        SyncProfile createSyncProfile = profileExtractor.createSyncProfile(str);
        if (createSyncProfile == null) {
            String str3 = f7349a;
            LoggerWrapper.e(str3, String.format("Cannot extract SyncProfile! environment = %s, authCode = %s.", str, str2));
            LoggerWrapper.e(str3, "Will retrieve prod environment SyncProfile!");
            SyncProfile createSyncProfile2 = profileExtractor.createSyncProfile("prod");
            if (createSyncProfile2 == null) {
                LoggerWrapper.e(str3, "Cannot get prod SyncProfile!!");
            }
            return createSyncProfile2;
        }
        return createSyncProfile;
    }

    public static String toJSONString(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return JSONObject.toJSONString(obj);
        } catch (Throwable th) {
            String str = f7349a;
            StringBuilder sb = new StringBuilder();
            sb.append("toJSONString failed. error = ");
            sb.append(th.getMessage());
            LoggerWrapper.e(str, sb.toString());
            return null;
        }
    }
}
