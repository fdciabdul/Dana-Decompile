package com.alipay.iap.android.common.securityprofiles.extractor;

import android.content.Context;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.iap.android.common.securityprofiles.profile.SyncProfile;
import com.alipay.iap.android.common.securityprofiles.provider.ProfileProvider;
import com.alipay.iap.android.common.securityprofiles.utils.ProfileUtils;

/* loaded from: classes3.dex */
public abstract class ProfileExtractor {
    public static final String KEY_AMCS_RPC_PROFILES = "amcsRpcProfiles";
    public static final String KEY_DEFAULT_RPC_PROFILES = "defaultRpcProfiles";
    public static final String KEY_SYNC_PROFILES = "syncProfiles";
    protected String mAuthCode;
    protected Context mContext;
    protected ProfileProvider mProfileProvider;

    protected abstract ProfileProvider createProfileProvider();

    public ProfileExtractor(Context context, String str) {
        this.mContext = context;
        this.mAuthCode = str;
    }

    public ProfileProvider getProfileProvider() {
        if (this.mProfileProvider == null) {
            this.mProfileProvider = createProfileProvider();
        }
        return this.mProfileProvider;
    }

    public String getProfileData(String str) {
        return getProfileProvider().getProfileData(this.mContext, str);
    }

    public RpcProfile createDefaultRpcProfile(String str) {
        return createRpcProfile(str, KEY_DEFAULT_RPC_PROFILES);
    }

    public RpcProfile createAmcsRpcProfile(String str) {
        return createRpcProfile(str, KEY_AMCS_RPC_PROFILES);
    }

    public RpcProfile createRpcProfile(String str, String str2) {
        return ProfileUtils.createRpcProfile(this.mContext, getProfileProvider(), this.mAuthCode, str, str2);
    }

    public SyncProfile createSyncProfile(String str) {
        return ProfileUtils.createSyncProfile(this.mContext, getProfileProvider(), this.mAuthCode, str, KEY_SYNC_PROFILES);
    }
}
