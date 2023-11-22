package com.iap.ac.android.biz.common.spi;

import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.BaseService;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;

/* loaded from: classes3.dex */
public class AclBaseImpl {
    public final String ACL_MANAGER_PACKAGE_NAME = "com.alipay.iap.android.wallet.acl.WalletServiceManager";
    public final String ACL_METHOD_PAY = "pay";
    public final String ACL_METHOD_GET_AUTH_CODE = Constants.JS_API_GET_AUTH_CODE;
    public final String ACL_METHOD_SCAN = "scan";
    public final String ACL_METHOD_OPEN_SCHEME = "openScheme";
    public final String ACL_METHOD_OPEN_BIZ_SCENE = "openBizScene";
    public final String ACL_METHOD_GET_OPEN_USER_INFO = Constants.JS_API_GET_OPEN_USER_INFO;
    public final String ACL_METHOD_GET_OPEN_ID = "getOpenId";
    public final String ACL_METHOD_SHOW_AUTH_PAGE = Constants.JS_API_GET_AUTH_CODE;
    public final String ACL_METHOD_FETCH_TRUST_CREDITIAL = "fetchTrustLoginCredentials";

    public <T extends BaseService> T getAclService(Class<? extends T> cls) {
        try {
            return (T) WalletServiceManager.getInstance().getService(cls);
        } catch (WalletServiceManager.ServiceNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getAclService exception: ");
            sb.append(e);
            ACLog.e(com.iap.ac.android.biz.common.constants.Constants.TAG, sb.toString());
            return null;
        }
    }

    public void handleForAclCallError(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("AclHandleError, method: ");
        sb.append(str);
        sb.append(", msg: ");
        sb.append(str2);
        ACLog.e(com.iap.ac.android.biz.common.constants.Constants.TAG, sb.toString());
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_ACL_CALL_FAIL).addParams("resultMessage", str2).addParams("method", str).setEventType(LogEventType.CRUCIAL_LOG).event();
    }

    public boolean isAclAvailable() {
        return Utils.checkClassExist("com.alipay.iap.android.wallet.acl.WalletServiceManager");
    }
}
