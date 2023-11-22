package com.alipay.plus.android.config.sdk.utils;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.extractor.ConfigProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.extractor.SecurityProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.iap.android.common.securityprofiles.profile.SyncProfile;
import com.alipay.iap.android.common.utils.MiscUtils;
import com.alipay.plus.android.config.sdk.a.e;

/* loaded from: classes7.dex */
public class ConfigProfileUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7391a = e.a("ConfigProfileUtils");

    public static ProfileExtractor createAssetFileExtractor(Context context, String str, String str2) {
        return new ConfigProfileExtractor(context, str, MiscUtils.getAssetContent(context, str2));
    }

    public static RpcProfile createRpcProfile(ProfileExtractor profileExtractor, String str, String str2) {
        RpcProfile createAmcsRpcProfile = profileExtractor.createAmcsRpcProfile(str);
        if (createAmcsRpcProfile == null) {
            String str3 = f7391a;
            LoggerWrapper.e(str3, String.format("Cannot extract Amcs RpcProfile! environment = %s, authCode = %s.", str, str2));
            LoggerWrapper.e(str3, "Will retrieve prod environment RpcProfile!");
            return profileExtractor.createAmcsRpcProfile("prod");
        }
        return createAmcsRpcProfile;
    }

    public static RpcProfile createRpcProfileByMultipleEnvironment(Context context, String str, String str2, String str3) {
        String replace = str2.replace("-", "");
        RpcProfile createAmcsRpcProfile = new SecurityProfileExtractor(context, str3).createAmcsRpcProfile(str);
        if (createAmcsRpcProfile == null) {
            createAmcsRpcProfile = new RpcProfile();
            LoggerWrapper.e(f7391a, "Use mocked RpcProfile!!");
        } else {
            createAmcsRpcProfile.productId = String.format("%s_android_%s", createAmcsRpcProfile.appId, replace);
        }
        createAmcsRpcProfile.environment = replace;
        createAmcsRpcProfile.authCode = str3;
        return createAmcsRpcProfile;
    }

    public static SyncProfile createSyncProfile(ProfileExtractor profileExtractor, String str, String str2) {
        SyncProfile createSyncProfile = profileExtractor.createSyncProfile(str);
        if (createSyncProfile == null) {
            String str3 = f7391a;
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
}
