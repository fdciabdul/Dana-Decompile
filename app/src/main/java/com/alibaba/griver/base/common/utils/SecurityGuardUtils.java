package com.alibaba.griver.base.common.utils;

import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor;

/* loaded from: classes6.dex */
public class SecurityGuardUtils {
    public static String getExtraData(String str, String str2) throws Exception {
        JSONObject parseObject = JSON.parseObject(getSecurityExtraData(GriverEnv.getApplicationContext(), str, ProfileExtractor.KEY_DEFAULT_RPC_PROFILES));
        return (JSONUtils.contains(parseObject, "prod") && JSONUtils.contains(parseObject.getJSONObject("prod"), "extras")) ? parseObject.getJSONObject("prod").getJSONObject("extras").getString(str2) : "";
    }

    public static String getSecurityExtraData(Context context, String str, String str2) throws Exception {
        IStaticDataStoreComponent staticDataStoreComp;
        if (!ReflectUtils.classExist(SecurityConstants.SG_CLASS) || (staticDataStoreComp = SecurityGuardManager.getInstance(context).getStaticDataStoreComp()) == null) {
            return null;
        }
        return staticDataStoreComp.getExtraData(str2, str);
    }
}
