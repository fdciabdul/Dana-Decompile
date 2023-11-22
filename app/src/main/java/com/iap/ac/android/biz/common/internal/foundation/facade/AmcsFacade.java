package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.content.Context;
import com.alibaba.griver.base.common.constants.AMCSConstants;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.utils.SignatureUtils;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.rpc.multigateway.RpcGatewayController;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.rpc.AmcsRpcUtils;
import com.iap.ac.config.lite.utils.ConfigUtils;

/* loaded from: classes8.dex */
public class AmcsFacade extends BaseFacade {
    public static boolean mInitialized;

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public void initComponent(Context context, String str, CommonConfig commonConfig) {
        super.initComponent(context, str, commonConfig);
        synchronized (this) {
            mInitialized = false;
            if (Utils.checkClassExist(AMCSConstants.AMCS_LITE_MAIN_CLASS) && Utils.checkClassExist("com.iap.ac.config.lite.ConfigCenterContext") && Utils.checkClassExist("com.iap.ac.config.lite.rpc.AmcsRpcUtils") && Utils.checkClassExist("com.iap.ac.config.lite.utils.ConfigUtils") && Utils.checkClassExist("com.iap.ac.android.rpc.multigateway.RpcGatewayController")) {
                ConfigCenter configCenter = ConfigCenter.getInstance(str);
                RpcAppInfo rpcAppInfo = new RpcAppInfo();
                rpcAppInfo.rpcGateWayUrl = commonConfig.amcsGatewayUrl;
                if ("SANDBOX".equals(commonConfig.envType)) {
                    rpcAppInfo.appId = String.format(CommonConfig.SANDBOXMOCK, commonConfig.appId);
                    StringBuilder sb = new StringBuilder();
                    sb.append(rpcAppInfo.appId);
                    sb.append("_ANDROID");
                    rpcAppInfo.appKey = sb.toString();
                } else {
                    rpcAppInfo.appId = commonConfig.appId;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(commonConfig.appId);
                    sb2.append("_ANDROID");
                    rpcAppInfo.appKey = sb2.toString();
                }
                rpcAppInfo.authCode = SignatureUtils.getAuthCodeForSecurityGuard(context, "0a6a", commonConfig.envType, commonConfig.gpSignature);
                rpcAppInfo.addHeader("workspaceId", commonConfig.getWorkspaceId());
                ConfigCenterContext configCenterContext = new ConfigCenterContext(context, rpcAppInfo, commonConfig.envType, "", commonConfig.getWorkspaceId(), commonConfig.appId, null);
                AmcsRpcUtils.initializeRpcGateway(RpcGatewayController.getGatewayController(str), configCenterContext.getRpcProfile(), commonConfig.envType);
                configCenter.initialize(configCenterContext);
                ConfigUtils.setConfigProxy(str);
                ACLog.i(Constants.TAG, String.format("AMCS(%s,%s) component initialize finish", this.mBizCode, commonConfig.envType));
                mInitialized = true;
                ConfigCenter.getInstance(str).refreshConfig();
                return;
            }
            ACLog.e(Constants.TAG, "AMCS init error, without dependent libraries");
        }
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public boolean isInitialized() {
        return mInitialized;
    }
}
