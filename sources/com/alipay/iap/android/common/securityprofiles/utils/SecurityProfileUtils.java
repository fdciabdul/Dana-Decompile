package com.alipay.iap.android.common.securityprofiles.utils;

import android.content.Context;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.iap.android.common.securityprofiles.profile.SyncProfile;
import com.alipay.iap.android.common.securityprofiles.provider.SecurityGuardProfileProvider;

/* loaded from: classes3.dex */
public class SecurityProfileUtils {
    private static final String TAG = "SecurityProfileUtils";

    public static String getSecurityExtraData(Context context, String str, String str2) {
        try {
            IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(context).getStaticDataStoreComp();
            if (staticDataStoreComp != null) {
                return staticDataStoreComp.getExtraData(str2, str);
            }
            return null;
        } catch (Exception e) {
            LoggerWrapper.e(TAG, "Cannot getSecurityExtraData!", e);
            return null;
        }
    }

    public static RpcProfile createRpcProfile(Context context, String str, String str2, String str3) {
        return ProfileUtils.createRpcProfile(context, new SecurityGuardProfileProvider(str), str, str2, str3);
    }

    public static SyncProfile createSyncProfile(Context context, String str, String str2) {
        return ProfileUtils.createSyncProfile(context, new SecurityGuardProfileProvider(str), str, str2, ProfileExtractor.KEY_SYNC_PROFILES);
    }
}
