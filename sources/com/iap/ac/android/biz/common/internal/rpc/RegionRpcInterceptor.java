package com.iap.ac.android.biz.common.internal.rpc;

import android.os.Build;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;
import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class RegionRpcInterceptor implements RpcInterceptor {
    public static final String KEY_APPID = "appId";
    public static final String KEY_LANGUAGE = "language";
    public static final String TAG = "RegionRpcInterceptor";

    public MobileEnvInfo generateMobileEnvInfo(MobileEnvInfo mobileEnvInfo) {
        String str;
        String str2;
        String str3 = "";
        if (mobileEnvInfo == null) {
            mobileEnvInfo = new MobileEnvInfo();
        }
        mobileEnvInfo.tokenId = InstanceInfo.getInstanceId(ACManager.getInstance().getContext());
        mobileEnvInfo.terminalType = "APP";
        mobileEnvInfo.osType = "android";
        mobileEnvInfo.sourcePlatform = "MAIN_APP";
        mobileEnvInfo.osVersion = Build.VERSION.RELEASE;
        mobileEnvInfo.sdkVersion = "2.37.0";
        mobileEnvInfo.manufacturer = Build.MANUFACTURER;
        try {
            str = ACManager.getInstance().getContext().getPackageManager().getPackageInfo(ACManager.getInstance().getContext().getPackageName(), 0).versionName;
        } catch (Exception unused) {
            ACLog.e(TAG, "An exception occurred while obtaining appVersionName");
            str = "";
        }
        try {
            HashMap<String, String> griverConfig = WebContainer.getInstance("ac_biz").getGriverConfig();
            if (griverConfig != null) {
                str2 = griverConfig.get("appId");
                try {
                    str3 = griverConfig.get("language");
                } catch (Throwable unused2) {
                    ACLog.e(TAG, "An exception occurred while obtaining saasRelatedClient");
                    mobileEnvInfo.locale = str3;
                    mobileEnvInfo.appVersion = str;
                    mobileEnvInfo.extendInfo = new HashMap();
                    mobileEnvInfo.extendInfo.put("saasRelatedClient", str2);
                    return mobileEnvInfo;
                }
            } else {
                str2 = "";
            }
        } catch (Throwable unused3) {
            str2 = "";
        }
        mobileEnvInfo.locale = str3;
        mobileEnvInfo.appVersion = str;
        mobileEnvInfo.extendInfo = new HashMap();
        mobileEnvInfo.extendInfo.put("saasRelatedClient", str2);
        return mobileEnvInfo;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        if (rpcRequest == null) {
            return;
        }
        Object obj = rpcRequest.request;
        if (obj instanceof BaseRpcRequest) {
            BaseRpcRequest baseRpcRequest = (BaseRpcRequest) obj;
            baseRpcRequest.envInfo = generateMobileEnvInfo(baseRpcRequest.envInfo);
        }
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }
}
