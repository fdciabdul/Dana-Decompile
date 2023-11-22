package com.iap.ac.android.biz.common.spi;

import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.MiniProgramMetaData;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.model.acl.AclMiniProgramMetaData;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class APIContextFactory {
    public static APIContext convertToAPIContext(AclAPIContext aclAPIContext) {
        MiniProgramMetaData miniProgramMetaData = null;
        if (aclAPIContext == null) {
            ACLog.i(Constants.TAG, "convertToAPIContext AclAPIContext is null");
            return new APIContext("AlipayConnect", null, new HashMap());
        }
        String source = aclAPIContext.getSource();
        ACLog.i(Constants.TAG, String.format("convertToAPIContext source = %s", source));
        AclMiniProgramMetaData aclMiniProgramMetaData = aclAPIContext.getAclMiniProgramMetaData();
        if (aclMiniProgramMetaData != null) {
            String appId = aclMiniProgramMetaData.getAppId();
            String merchantId = aclMiniProgramMetaData.getMerchantId();
            ACLog.i(Constants.TAG, String.format("convertToAPIContext appId = %s, merchantId = %s", appId, merchantId));
            miniProgramMetaData = new MiniProgramMetaData(appId, merchantId);
        }
        return new APIContext(source, miniProgramMetaData, aclAPIContext.getExtendedInfo());
    }

    public static AclAPIContext createACAPIContext() {
        return new AclAPIContext("AlipayConnect", null, new HashMap());
    }

    public static AclAPIContext createACMiniProgramAPIContext(String str, String str2) {
        ACLog.i(Constants.TAG, String.format("createACMiniProgramAPIContext appId = %s, merchantId = %s", str, str2));
        return new AclAPIContext("AlipayConnect", new AclMiniProgramMetaData(str, str2), new HashMap());
    }
}
