package com.iap.ac.android.acs.operation.utils;

import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.model.acl.AclMiniProgramMetaData;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AclAPIContextUtils {
    public static final String AC_MERCHANT_ID = "merchantId";

    public static AclAPIContext createAclAPIContext(IAPConnectPluginContext iAPConnectPluginContext) {
        String str = iAPConnectPluginContext.miniProgramAppID;
        JSONObject jSONObject = iAPConnectPluginContext.acParams;
        String optString = jSONObject != null ? jSONObject.optString("merchantId") : null;
        StringBuilder sb = new StringBuilder();
        sb.append("ApiContextUtils#createAclApiContext, appId: ");
        sb.append(str);
        sb.append(", merchantId: ");
        sb.append(optString);
        ACLog.d("IAPConnectPlugin", sb.toString());
        return new AclAPIContext("AlipayConnect", new AclMiniProgramMetaData(str, optString), new HashMap());
    }
}
