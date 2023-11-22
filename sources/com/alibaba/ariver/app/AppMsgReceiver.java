package com.alibaba.ariver.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.bridge.remote.RemoteCallbackPool;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.extension.AppModelInitPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareAppInfoGetPoint;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class AppMsgReceiver implements IpcMessageHandler {

    /* renamed from: a */
    private AppNode f5955a;

    public AppMsgReceiver(AppNode appNode) {
        this.f5955a = appNode;
    }

    private void a(EntryInfo entryInfo) {
        if (this.f5955a.getSplashView() != null) {
            this.f5955a.getSplashView().showLoading(entryInfo);
        }
    }

    private void b(EntryInfo entryInfo) {
        if (this.f5955a.getSplashView() != null) {
            this.f5955a.getSplashView().update(entryInfo);
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        Page pageByNodeId;
        ResourceContext resourceContext;
        Message message = ipcMessage.bizMsg;
        boolean z = message.arg1 == 1;
        StringBuilder sb = new StringBuilder();
        sb.append("handle ipc msg: ");
        sb.append(message.what);
        sb.append(" fromPending: ");
        sb.append(z);
        RVLogger.d("AriverApp:AppMsgReceiver", sb.toString());
        EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(message.getData(), RVConstants.EXTRA_ENTRY_INFO);
        HashMap hashMap = null;
        switch (message.what) {
            case 0:
                boolean z2 = BundleUtils.getBoolean(message.getData(), RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, false);
                if (entryInfo != null) {
                    this.f5955a.setData(EntryInfo.class, entryInfo);
                }
                this.f5955a.getSceneParams().putBoolean(RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, z2);
                a(entryInfo);
                return;
            case 1:
                if (entryInfo != null) {
                    this.f5955a.setData(EntryInfo.class, entryInfo);
                }
                AppModel appModel = (AppModel) BundleUtils.getParcelable(message.getData(), "appInfo");
                PrepareAppInfoGetPoint prepareAppInfoGetPoint = (PrepareAppInfoGetPoint) ExtensionPoint.as(PrepareAppInfoGetPoint.class).node(this.f5955a).create();
                AppNode appNode = this.f5955a;
                prepareAppInfoGetPoint.onAppPrepare(appNode, appNode.getStartParams(), this.f5955a.getSceneParams(), appModel);
                b(entryInfo);
                return;
            case 2:
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppMsgReceiver_handleEnterApp);
                this.f5955a.putBooleanValue(RVConstants.EXTRA_RECEIVED_PREPARE_FINISH, true);
                a(message.getData());
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppMsgReceiver_handleEnterApp);
                return;
            case 3:
                String string = BundleUtils.getString(message.getData(), RVConstants.EXTRA_PREPARE_EXCEPTION_CODE);
                String string2 = BundleUtils.getString(message.getData(), RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE);
                Bundle bundle = message.getData().getBundle(RVConstants.EXTRA_PREPARE_EXCEPTION_EXTRAS);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("prepareFail client with code: ");
                sb2.append(string);
                sb2.append(", msg: ");
                sb2.append(string2);
                sb2.append(", splashView: ");
                sb2.append(this.f5955a.getSplashView());
                RVLogger.d("AriverApp:AppMsgReceiver", sb2.toString());
                if (this.f5955a.getSplashView() != null) {
                    if (bundle != null) {
                        hashMap = new HashMap();
                        for (String str : bundle.keySet()) {
                            if (str != null) {
                                hashMap.put(str, bundle.getString(str));
                            }
                        }
                    }
                    this.f5955a.getSplashView().showError(string, string2, hashMap);
                }
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.f5955a.getActivePage(), ErrId.RV_TYPE_APP_PREPARE_ERROR, string, string2, null, null);
                PrepareData prepareData = (PrepareData) BundleUtils.getParcelable(message.getData(), RVConstants.EXTRA_PREPARE_DATA);
                Event error = ((EventTracker) RVProxy.get(EventTracker.class)).error(this.f5955a, "ResPrepareFail", string);
                if (error == null || prepareData == null) {
                    return;
                }
                a(string, prepareData, error);
                return;
            case 4:
                String string3 = BundleUtils.getString(message.getData(), RVConstants.EXTRA_PREPARE_ABORT_REASON);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("force finish for reason: ");
                sb3.append(string3);
                RVLogger.d("AriverApp:AppMsgReceiver", sb3.toString());
                this.f5955a.exit();
                return;
            case 5:
                if (this.f5955a.getSplashView() != null) {
                    this.f5955a.getSplashView().exit(null);
                    return;
                }
                return;
            case 6:
            default:
                return;
            case 7:
                JSONObject unmarshallJSONObject = JSONUtils.unmarshallJSONObject(BundleUtils.getByteArray(message.getData(), "data"));
                boolean z3 = BundleUtils.getBoolean(message.getData(), "keepCallback", false);
                SendToNativeCallback callback = RemoteCallbackPool.getInstance().getCallback(BundleUtils.getLong(message.getData(), IpcMessageConstants.EXTRA_NODE_ID), BundleUtils.getString(message.getData(), "clientId"), !z3);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("SERVER_MSG_REMOTE_API_CALLBACK found callback: ");
                sb4.append(callback != null);
                sb4.append(", keepCallback: ");
                sb4.append(z3);
                RVLogger.d("AriverApp:AppMsgReceiver", sb4.toString());
                if (callback != null) {
                    callback.onCallback(unmarshallJSONObject, z3);
                    return;
                }
                return;
            case 8:
                final NativeCallContext nativeCallContext = (NativeCallContext) message.getData().getParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_CONTEXT);
                boolean z4 = message.getData().getBoolean(IpcMessageConstants.EXTRA_REMOTE_CALL_NEED_PERMISSION, true);
                if (nativeCallContext == null) {
                    RVLogger.w("AriverApp:AppMsgReceiver", "SERVER_MSG_REMOTE_API_CALL callContext == null!!");
                    return;
                }
                Node node = nativeCallContext.getNode();
                if (node != null) {
                    if (!(node instanceof App) && (pageByNodeId = this.f5955a.getPageByNodeId(node.getNodeId())) != null) {
                        nativeCallContext.setNode(pageByNodeId);
                    } else {
                        nativeCallContext.setNode(this.f5955a);
                    }
                }
                SendToNativeCallback sendToNativeCallback = new SendToNativeCallback() { // from class: com.alibaba.ariver.app.AppMsgReceiver.1
                    {
                        AppMsgReceiver.this = this;
                    }

                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                    public void onCallback(JSONObject jSONObject, boolean z5) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("clientId", nativeCallContext.getId());
                        bundle2.putByteArray(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_DATA, JSONUtils.marshallJSONObject(jSONObject));
                        bundle2.putBoolean(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_KEEP, z5);
                        IpcClientUtils.sendMsgToServerByApp(AppMsgReceiver.this.f5955a, 7, bundle2);
                    }
                };
                if (!this.f5955a.isExited()) {
                    this.f5955a.getEngineProxy().getBridge().sendToNative(nativeCallContext, sendToNativeCallback, z4);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", (Object) "remote App already exited!");
                sendToNativeCallback.onCallback(jSONObject, false);
                return;
            case 9:
                String string4 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_EVENT);
                final String string5 = BundleUtils.getString(message.getData(), "clientId");
                AppUtils.sendToApp(this.f5955a, string4, JSONUtils.unmarshallJSONObject(BundleUtils.getByteArray(message.getData(), "data")), new SendToRenderCallback() { // from class: com.alibaba.ariver.app.AppMsgReceiver.2
                    {
                        AppMsgReceiver.this = this;
                    }

                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                    public void onCallBack(JSONObject jSONObject2) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("clientId", string5);
                        IpcClientUtils.sendMsgToServerByApp(AppMsgReceiver.this.f5955a, 7, bundle2);
                    }
                });
                return;
            case 10:
                Node child = this.f5955a.getChild(BundleUtils.getLong(message.getData(), IpcMessageConstants.EXTRA_PAGE_NODE_ID));
                if (child instanceof Page) {
                    ((Page) child).exit(false);
                    return;
                }
                return;
            case 11:
                Intent intent = (Intent) BundleUtils.getParcelable(message.getData(), "intent");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SERVER_MSG_START_ACTIVITY: ");
                sb5.append(intent);
                RVLogger.d("AriverApp:AppMsgReceiver", sb5.toString());
                if (intent != null) {
                    if (this.f5955a.getActivePage() != null && this.f5955a.getActivePage().getPageContext() != null && this.f5955a.getActivePage().getPageContext().getActivity() != null) {
                        RVLogger.d("AriverApp:AppMsgReceiver", "SERVER_MSG_START_ACTIVITY use activity to start!");
                        this.f5955a.getActivePage().getPageContext().getActivity().startActivityForResult(intent, 1024);
                        return;
                    } else if (this.f5955a.getAppContext() != null) {
                        RVLogger.d("AriverApp:AppMsgReceiver", "SERVER_MSG_START_ACTIVITY use context to start!");
                        this.f5955a.getAppContext().getContext().startActivity(intent);
                        return;
                    } else {
                        RVLogger.d("AriverApp:AppMsgReceiver", "SERVER_MSG_START_ACTIVITY cannot find activity to start!");
                        return;
                    }
                }
                return;
            case 12:
                String string6 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_STUB_NAME);
                long j = BundleUtils.getLong(message.getData(), IpcMessageConstants.EXTRA_STUB_TS);
                if (j == 0) {
                    j = SystemClock.elapsedRealtime();
                }
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, string6, j);
                return;
            case 13:
                ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage("66666692");
                if (resourcePackage != null) {
                    resourcePackage.reload();
                    return;
                }
                return;
            case 14:
                AppModel appModel2 = (AppModel) BundleUtils.getParcelable(message.getData(), IpcMessageConstants.EXTRA_FALLBACK_APP_MODEL);
                if (appModel2 == null || !TextUtils.equals(appModel2.getAppId(), this.f5955a.getAppId()) || (resourceContext = ResourceContextManager.getInstance().get(this.f5955a.getAppId(), this.f5955a.getStartToken())) == null) {
                    return;
                }
                resourceContext.getOnlineResourceFetcher().startFallback(appModel2);
                return;
            case 15:
                AppModel appModel3 = (AppModel) BundleUtils.getParcelable(message.getData(), "appInfo");
                if (appModel3 != null) {
                    ((AppModelInitPoint) ExtensionPoint.as(AppModelInitPoint.class).node(this.f5955a).create()).onGetAppInfo(appModel3);
                    return;
                }
                return;
            case 16:
                String string7 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_STUB_NAME);
                String string8 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_ATTR_VALUE);
                if (TextUtils.isEmpty(string7) || TextUtils.isEmpty(string8)) {
                    return;
                }
                ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.f5955a, string7, string8);
                return;
        }
    }

    private void a(Bundle bundle) {
        PrepareData prepareData;
        boolean z = BundleUtils.getBoolean(this.f5955a.getSceneParams(), RVConstants.EXTRA_PREPARE_NEED_WAIT_IPC, false);
        StringBuilder sb = new StringBuilder();
        sb.append("handleEnterApp needWaitIpc: ");
        sb.append(z);
        RVLogger.d("AriverApp:AppMsgReceiver", sb.toString());
        Bundle bundle2 = (Bundle) BundleUtils.getParcelable(bundle, "startParams");
        Bundle bundle3 = (Bundle) BundleUtils.getParcelable(bundle, RVConstants.EXTRA_SCENE_PARAMS);
        RVPerformanceTracker rVPerformanceTracker = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
        AppNode appNode = this.f5955a;
        rVPerformanceTracker.track(appNode, appNode.getStartUrl(), PerfId.jumpAppStart, this.f5955a.getSceneParams().getLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP));
        long j = this.f5955a.getSceneParams().getLong(RVConstants.EXTRA_START_ACTIVITY_TIMESTAMP);
        RVPerformanceTracker rVPerformanceTracker2 = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
        AppNode appNode2 = this.f5955a;
        rVPerformanceTracker2.track(appNode2, appNode2.getStartUrl(), PerfId.startActivity, j);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_StartNebulaActivity, j);
        long j2 = BundleUtils.getLong(bundle3, RVConstants.EXTRA_SETUP_TIMESTAMP);
        RVPerformanceTracker rVPerformanceTracker3 = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
        AppNode appNode3 = this.f5955a;
        rVPerformanceTracker3.track(appNode3, appNode3.getStartUrl(), PerfId.setupStart, j2);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_SetupStart, j2);
        if (z) {
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_PrepareIPCFinish);
            if (bundle2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("handleEnterApp with new startParam: ");
                sb2.append(bundle2);
                RVLogger.d("AriverApp:AppMsgReceiver", sb2.toString());
                this.f5955a.getStartParams().putAll(bundle2);
            }
            if (bundle3 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("handleEnterApp with new sceneParam: ");
                sb3.append(bundle3);
                RVLogger.d("AriverApp:AppMsgReceiver", sb3.toString());
                String string = BundleUtils.getString(bundle3, "appType", "WEB_TINY");
                StringBuilder sb4 = new StringBuilder();
                sb4.append("handleEnterApp with new appType: ");
                sb4.append(string);
                RVLogger.d("AriverApp:AppMsgReceiver", sb4.toString());
                String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_setNewTypeH5", "yes");
                if ("WEB_H5".equals(string) && "yes".equals(configWithProcessCache)) {
                    this.f5955a.setAppType(string);
                }
                this.f5955a.getSceneParams().putAll(bundle3);
            }
            String configWithProcessCache2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_notStartWhenDestroyed", null);
            if (this.f5955a.isDestroyed() && !"NO".equalsIgnoreCase(configWithProcessCache2)) {
                RVLogger.w("AriverApp:AppMsgReceiver", "app is destroyed");
            } else {
                this.f5955a.start();
            }
        }
        long j3 = BundleUtils.getLong(bundle3, RVConstants.EXTRA_SETUP_END_TIMESTAMP, 0L);
        Event stub = j3 > 0 ? ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_SetupEnd, j3) : null;
        if (stub == null || (prepareData = (PrepareData) BundleUtils.getParcelable(bundle, RVConstants.EXTRA_PREPARE_DATA)) == null) {
            return;
        }
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_Resource_PrepareStart, prepareData.getBeginTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_Resource_PrepareFinish, prepareData.getEndTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.f5955a, TrackId.Cost_Resource_Rpc, prepareData.getRequestEndTime() - prepareData.getRequestBeginTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_Rpc_Start, prepareData.getRequestBeginTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_Rpc_End, prepareData.getRequestEndTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.f5955a, TrackId.Cost_Resource_Download, prepareData.getDownloadEndTime() - prepareData.getDownloadTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.f5955a, TrackId.Cost_Resource_UnZip, prepareData.getInstallEndTime() - prepareData.getInstallTime());
        if (prepareData.getData() != null) {
            if (BundleUtils.getBoolean(prepareData.getData(), TrackId.Stub_CCDN_PREPARE_FAIL, false)) {
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.Stub_CCDN_PREPARE_FAIL);
            }
            if (BundleUtils.getBoolean(prepareData.getData(), TrackId.ATTR_START_WITH_SUBPACKAGE, false)) {
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f5955a, TrackId.ATTR_START_WITH_SUBPACKAGE);
            }
            long j4 = BundleUtils.getLong(prepareData.getData(), TrackId.Stub_CCDN_PREPARE_START, 0L);
            long j5 = BundleUtils.getLong(prepareData.getData(), TrackId.Stub_CCDN_PREPARE_END, 0L);
            if (j4 != 0 && j5 != 0) {
                ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.f5955a, TrackId.Cost_CCDN_Prepare, j5 - j4);
            }
            String string2 = BundleUtils.getString(prepareData.getData(), TrackId.ATTR_HIGHEST_VERSION, "");
            if (!TextUtils.isEmpty(string2)) {
                ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.f5955a, TrackId.ATTR_HIGHEST_VERSION, string2);
            }
        }
        a("1", prepareData, stub);
    }

    private void a(String str, PrepareData prepareData, Event event) {
        HashMap hashMap = new HashMap();
        hashMap.put("res_errc", str);
        hashMap.put("res_req", prepareData.getRequestMode());
        hashMap.put("res_off", prepareData.getOfflineMode());
        hashMap.put("res_nbu", prepareData.getNbUrl());
        hashMap.put("res_rpc", Boolean.toString(prepareData.getRequestEndTime() > 0));
        hashMap.put("res_dl", Boolean.toString(prepareData.getDownloadEndTime() > 0));
        hashMap.put("res_info_exist", String.valueOf(prepareData.getOriginHasAppInfo()));
        event.setAttrData(hashMap);
    }
}
