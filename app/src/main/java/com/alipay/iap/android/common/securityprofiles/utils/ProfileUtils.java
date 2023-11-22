package com.alipay.iap.android.common.securityprofiles.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.iap.android.common.securityprofiles.profile.SyncProfile;
import com.alipay.iap.android.common.securityprofiles.provider.ProfileProvider;
import com.alipay.iap.android.common.utils.MiscUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ProfileUtils {
    private static final String TAG = "ProfileUtils";

    private ProfileUtils() {
    }

    private static JSONObject getProfilesInfo(Context context, ProfileProvider profileProvider, String str, String str2) {
        String profileData = profileProvider.getProfileData(context, str2);
        if (TextUtils.isEmpty(profileData)) {
            return null;
        }
        LoggerWrapper.d(TAG, String.format("getProfilesInfo: environment = %s, key = %s, extraData = %s", str, str2, profileData));
        try {
            return new JSONObject(new JSONObject(profileData).optString(str));
        } catch (Exception e) {
            LoggerWrapper.e(TAG, "Cannot parse params from securityGuard extra data!", e);
            return null;
        }
    }

    public static RpcProfile createRpcProfile(Context context, ProfileProvider profileProvider, String str, String str2, String str3) {
        JSONObject profilesInfo = getProfilesInfo(context, profileProvider, str2, str3);
        if (profilesInfo == null) {
            return null;
        }
        RpcProfile rpcProfile = new RpcProfile();
        rpcProfile.authCode = str;
        rpcProfile.environment = str2;
        rpcProfile.extras = parseExtras(profilesInfo);
        try {
            rpcProfile.appId = profilesInfo.optString("appId");
            rpcProfile.appKey = profilesInfo.optString("appKey");
            rpcProfile.productId = profilesInfo.optString("productId");
            rpcProfile.gatewayUrl = profilesInfo.optString("gatewayUrl");
        } catch (Exception e) {
            LoggerWrapper.w(TAG, "Cannot parse Rpc Profiles!", e);
        }
        return rpcProfile;
    }

    private static Map<String, String> parseExtras(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("extras");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
        }
        return hashMap;
    }

    public static SyncProfile createSyncProfile(Context context, ProfileProvider profileProvider, String str, String str2, String str3) {
        JSONObject profilesInfo = getProfilesInfo(context, profileProvider, str2, str3);
        if (profilesInfo == null) {
            return null;
        }
        SyncProfile syncProfile = new SyncProfile();
        syncProfile.authCode = str;
        syncProfile.environment = str2;
        syncProfile.productVersion = MiscUtils.getVersionName(context);
        syncProfile.extras = parseExtras(profilesInfo);
        try {
            syncProfile.productId = profilesInfo.optString("productId");
            syncProfile.appId = profilesInfo.optString("appId");
            syncProfile.appKey = profilesInfo.optString("appKey");
            syncProfile.workspaceId = profilesInfo.optString("workspaceId");
            syncProfile.syncServerAddress = profilesInfo.optString("server");
            syncProfile.syncServerPort = profilesInfo.optString("port");
        } catch (Exception e) {
            LoggerWrapper.w(TAG, "Cannot parse Sync Profiles!", e);
        }
        return syncProfile;
    }
}
