package com.iap.ac.android.biz.common.internal.rpc;

import android.os.Build;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.risk.RiskControlManager;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;
import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class ACRpcInterceptor implements RpcInterceptor {
    public static final String TAG = "ACRpcInterceptor";
    public static List<String> operationTypeList;

    static {
        ArrayList arrayList = new ArrayList();
        operationTypeList = arrayList;
        arrayList.add(Constants.OperationType.AUTH_LOGIN);
        operationTypeList.add(Constants.OperationType.HOLD_LOGIN);
        operationTypeList.add(Constants.OperationType.CODE_SCAN);
        operationTypeList.add(Constants.OperationType.CPM_ENCODE);
        operationTypeList.add("ac.mobilepayment.instorepayment.cpm.init");
        operationTypeList.add("ac.mobilepayment.instorepayment.cpm.invalidate");
    }

    public MobileEnvInfo generateMobileEnvInfo(MobileEnvInfo mobileEnvInfo, String str) {
        String str2;
        List<String> list;
        if (mobileEnvInfo == null) {
            mobileEnvInfo = new MobileEnvInfo();
        }
        String tokenId = RiskControlManager.getInstance().getTokenId();
        if (!TextUtils.isEmpty(tokenId) && (list = operationTypeList) != null && list.contains(str)) {
            mobileEnvInfo.tokenId = tokenId;
        }
        mobileEnvInfo.terminalType = "APP";
        mobileEnvInfo.osType = "android";
        mobileEnvInfo.sourcePlatform = "MAIN_APP";
        mobileEnvInfo.osVersion = Build.VERSION.RELEASE;
        mobileEnvInfo.sdkVersion = "2.37.0";
        try {
            str2 = ACManager.getInstance().getContext().getPackageManager().getPackageInfo(ACManager.getInstance().getContext().getPackageName(), 0).versionName;
        } catch (Exception unused) {
            ACLog.e(TAG, "Exception at getting appVersionName");
            str2 = "";
        }
        mobileEnvInfo.appVersion = str2;
        mobileEnvInfo.extendInfo = new HashMap();
        mobileEnvInfo.extendInfo.put(FoundationProxy.COMPONENT_INSTANCE_ID, InstanceInfo.getInstanceId(ACManager.getInstance().getContext()));
        return mobileEnvInfo;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        Object obj;
        if (rpcRequest == null || (obj = rpcRequest.request) == null || !(obj instanceof BaseRpcRequest)) {
            return;
        }
        BaseRpcRequest baseRpcRequest = (BaseRpcRequest) obj;
        baseRpcRequest.envInfo = generateMobileEnvInfo(baseRpcRequest.envInfo, rpcRequest.operationType);
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }
}
