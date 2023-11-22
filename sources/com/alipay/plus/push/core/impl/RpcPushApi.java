package com.alipay.plus.push.core.impl;

import android.text.TextUtils;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.plus.push.core.ICallback;
import com.alipay.plus.push.core.PushConfig;
import com.alipay.plus.push.core.rpc.ResultPbPB;
import com.alipay.plus.push.core.rpc.bind.PushBindFacade;
import com.alipay.plus.push.core.rpc.bind.pb.BindInfoReqPbPB;
import com.alipay.plus.push.core.rpc.bind.pb.UnbindReqPbPB;
import com.alipay.plus.push.core.rpc.report.DeviceReportFacade;
import com.alipay.plus.push.core.rpc.report.pb.DeviceInfoReqPbPB;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;

/* loaded from: classes7.dex */
public class RpcPushApi {
    private static String TAG = "RpcPushApi";

    public static void bind(final String str, final String str2, final ICallback iCallback) {
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<ResultPbPB>() { // from class: com.alipay.plus.push.core.impl.RpcPushApi.1
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(ResultPbPB resultPbPB) {
                ICallback.this.onSuccess(resultPbPB);
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                ICallback.this.onFailed(null, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final ResultPbPB execute() throws Exception {
                PushBindFacade pushBindFacade = (PushBindFacade) RPCProxyHost.getInterfaceProxy(PushBindFacade.class);
                if (pushBindFacade != null) {
                    BindInfoReqPbPB bindInfoReqPbPB = new BindInfoReqPbPB();
                    bindInfoReqPbPB.userId = str;
                    bindInfoReqPbPB.deliveryToken = str2;
                    bindInfoReqPbPB.osType = 1;
                    bindInfoReqPbPB.workspaceId = PushConfig.workSpaceId;
                    bindInfoReqPbPB.appId = PushConfig.appId;
                    ResultPbPB bind = pushBindFacade.bind(bindInfoReqPbPB);
                    if (bind.success.booleanValue()) {
                        ICallback.this.onSuccess(bind);
                    } else {
                        ICallback.this.onFailed(bind.code, bind.message);
                    }
                    return bind;
                }
                return null;
            }
        });
    }

    public static void unbind(final String str, final String str2, final ICallback iCallback) {
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<ResultPbPB>() { // from class: com.alipay.plus.push.core.impl.RpcPushApi.2
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(ResultPbPB resultPbPB) {
                ICallback.this.onSuccess(resultPbPB);
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                ICallback.this.onFailed(null, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final ResultPbPB execute() throws Exception {
                PushBindFacade pushBindFacade = (PushBindFacade) RPCProxyHost.getInterfaceProxy(PushBindFacade.class);
                if (pushBindFacade != null) {
                    UnbindReqPbPB unbindReqPbPB = new UnbindReqPbPB();
                    unbindReqPbPB.userId = str;
                    unbindReqPbPB.deliveryToken = str2;
                    unbindReqPbPB.workspaceId = PushConfig.workSpaceId;
                    unbindReqPbPB.appId = PushConfig.appId;
                    ResultPbPB unbind = pushBindFacade.unbind(unbindReqPbPB);
                    if (unbind.success.booleanValue()) {
                        ICallback.this.onSuccess(unbind);
                    } else {
                        ICallback.this.onFailed(unbind.code, unbind.message);
                    }
                    return unbind;
                }
                return null;
            }
        });
    }

    public static void report(final String str, final String str2, final String str3, final Integer num, final ICallback iCallback) {
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<ResultPbPB>() { // from class: com.alipay.plus.push.core.impl.RpcPushApi.3
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onSuccess(ResultPbPB resultPbPB) {
                ICallback.this.onSuccess(resultPbPB);
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public final void onFailure(IAPError iAPError) {
                ICallback.this.onFailed(null, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public final ResultPbPB execute() throws Exception {
                DeviceReportFacade deviceReportFacade = (DeviceReportFacade) RPCProxyHost.getInterfaceProxy(DeviceReportFacade.class);
                if (deviceReportFacade != null) {
                    DeviceInfoReqPbPB deviceInfoReqPbPB = new DeviceInfoReqPbPB();
                    deviceInfoReqPbPB.appVersion = "1";
                    if (!TextUtils.isEmpty(str2)) {
                        deviceInfoReqPbPB.channel = str2;
                    }
                    deviceInfoReqPbPB.workspaceId = PushConfig.workSpaceId;
                    deviceInfoReqPbPB.connectType = "WIFI";
                    deviceInfoReqPbPB.deliveryToken = str;
                    Integer num2 = num;
                    if (num2 != null) {
                        deviceInfoReqPbPB.thirdChannel = num2;
                    }
                    deviceInfoReqPbPB.thirdChannelDeviceToken = str3;
                    deviceInfoReqPbPB.imsi = "imsi";
                    deviceInfoReqPbPB.imei = "imei";
                    deviceInfoReqPbPB.model = H5GetLogInfoBridge.RESULT_MODEL;
                    deviceInfoReqPbPB.osType = 1;
                    deviceInfoReqPbPB.appId = PushConfig.appId;
                    ResultPbPB report = deviceReportFacade.report(deviceInfoReqPbPB);
                    if (report.success.booleanValue()) {
                        ICallback.this.onSuccess(report);
                    } else {
                        ICallback.this.onFailed(report.code, report.message);
                    }
                    return report;
                }
                return null;
            }
        });
    }
}
