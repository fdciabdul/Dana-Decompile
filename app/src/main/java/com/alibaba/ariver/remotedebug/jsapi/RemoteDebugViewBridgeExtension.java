package com.alibaba.ariver.remotedebug.jsapi;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.core.RemoteDebugViewProxy;
import com.alibaba.ariver.remotedebug.view.ActionEventListener;
import com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView;
import com.alibaba.ariver.remotedebug.view.IDebugStateView;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class RemoteDebugViewBridgeExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private IDebugStateView f6191a;
    private IDebugInfoPanelView b;
    private WeakReference<Page> c;
    private WeakReference<Page> d;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        if (r7.equals("connected") != false) goto L34;
     */
    @com.alibaba.ariver.kernel.api.annotation.ThreadType(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.UI)
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter
    @com.alibaba.ariver.kernel.api.annotation.AutoCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse showRemoteDebugPanel(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode(com.alibaba.ariver.app.api.Page.class) com.alibaba.ariver.app.api.Page r6, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"status"}) java.lang.String r7, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"text"}) java.lang.String r8, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"buttonTitle"}) java.lang.String r9) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r1 = "AriverAPI:RemoteDebugViewBridgeExtension"
            r2 = 2
            if (r0 == 0) goto L13
            java.lang.String r6 = "status is empty"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r6)
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse$Error r6 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.newError(r2, r6)
            return r6
        L13:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L23
            java.lang.String r6 = "text is empty"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r6)
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse$Error r6 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.newError(r2, r6)
            return r6
        L23:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L33
            java.lang.String r6 = "buttonTitle is empty"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r6)
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse$Error r6 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.newError(r2, r6)
            return r6
        L33:
            com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView r0 = r5.b(r6)
            if (r0 != 0) goto L43
            java.lang.String r6 = "panelView is null."
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r6)
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse$Error r6 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.newError(r2, r6)
            return r6
        L43:
            int r1 = r7.hashCode()
            r3 = -1381388741(0xffffffffada9ae3b, float:-1.929045E-11)
            r4 = 1
            if (r1 == r3) goto L6a
            r3 = -775651656(0xffffffffd1c47eb8, float:-1.05492447E11)
            if (r1 == r3) goto L60
            r3 = -579210487(0xffffffffdd79f309, float:-1.12567183E18)
            if (r1 != r3) goto L74
            java.lang.String r1 = "connected"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L74
            goto L75
        L60:
            java.lang.String r1 = "connecting"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L74
            r2 = 0
            goto L75
        L6a:
            java.lang.String r1 = "disconnected"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L74
            r2 = 1
            goto L75
        L74:
            r2 = -1
        L75:
            if (r2 == 0) goto L81
            if (r2 == r4) goto L7d
            r0.setStateConnected()
            goto L84
        L7d:
            r0.setStateConnectFailed()
            goto L84
        L81:
            r0.setStateConnecting()
        L84:
            r0.setStateText(r8)
            r0.setExitText(r9)
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference
            r7.<init>(r6)
            r5.d = r7
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r6 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.SUCCESS
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.remotedebug.jsapi.RemoteDebugViewBridgeExtension.showRemoteDebugPanel(com.alibaba.ariver.app.api.Page, java.lang.String, java.lang.String, java.lang.String):com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse");
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showRemoteDebugMask(@BindingNode(Page.class) Page page, @BindingParam({"text"}) String str, @BindingParam({"buttonTitle"}) String str2, @BindingParam({"hide"}) boolean z) {
        IDebugStateView a2 = a(page);
        if (a2 == null) {
            RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "maskView is null.");
            return BridgeResponse.newError(2, "maskView is null");
        }
        if (!z) {
            if (TextUtils.isEmpty(str)) {
                RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "text is empty");
                return BridgeResponse.newError(2, "text is empty");
            } else if (TextUtils.isEmpty(str2)) {
                RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "buttonTitle is empty");
                return BridgeResponse.newError(2, "buttonTitle is empty");
            } else {
                a2.setStateText(str);
                a2.setExitText(str2);
                a2.setShown(true);
            }
        } else {
            a2.setShown(false);
        }
        this.c = new WeakReference<>(page);
        return BridgeResponse.SUCCESS;
    }

    private IDebugStateView a(Page page) {
        Activity activity;
        if (this.f6191a == null) {
            RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "create panelView.");
            if (page.getPageContext() != null && (activity = page.getPageContext().getActivity()) != null) {
                b(activity, page.getApp());
            }
            RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "create panelView error!");
        }
        return this.f6191a;
    }

    private IDebugInfoPanelView b(Page page) {
        Activity activity;
        if (this.b == null) {
            RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "create panelView.");
            if (page.getPageContext() != null && (activity = page.getPageContext().getActivity()) != null) {
                a(activity, page.getApp());
            }
            RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "create panelView error!");
        }
        return this.b;
    }

    private void a(Activity activity, App app) {
        if (activity == null || app == null) {
            return;
        }
        RemoteDebugViewProxy remoteDebugViewProxy = (RemoteDebugViewProxy) RVProxy.get(RemoteDebugViewProxy.class);
        IDebugInfoPanelView createDebugInfoPanelView = remoteDebugViewProxy.createDebugInfoPanelView(activity, app);
        this.b = createDebugInfoPanelView;
        remoteDebugViewProxy.addDebugInfoPanelToUI(activity, app, createDebugInfoPanelView);
        this.b.setActionEventListener(new ActionEventListener() { // from class: com.alibaba.ariver.remotedebug.jsapi.RemoteDebugViewBridgeExtension.1
            @Override // com.alibaba.ariver.remotedebug.view.ActionEventListener
            public void exitRemoteDebug() {
                if (RemoteDebugViewBridgeExtension.this.d == null || RemoteDebugViewBridgeExtension.this.d.get() == null) {
                    RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "mPanelPageRef or page is null");
                } else {
                    EngineUtils.sendToRender(((Page) RemoteDebugViewBridgeExtension.this.d.get()).getRender(), "tinyRemoteDebugPanelButtonClick", null, null);
                }
            }
        });
    }

    private void b(Activity activity, App app) {
        if (activity == null || app == null) {
            return;
        }
        RemoteDebugViewProxy remoteDebugViewProxy = (RemoteDebugViewProxy) RVProxy.get(RemoteDebugViewProxy.class);
        IDebugStateView createDebugStateView = remoteDebugViewProxy.createDebugStateView(activity, app);
        this.f6191a = createDebugStateView;
        remoteDebugViewProxy.addDebugStateViewToUI(activity, app, createDebugStateView);
        this.f6191a.setActionEventListener(new ActionEventListener() { // from class: com.alibaba.ariver.remotedebug.jsapi.RemoteDebugViewBridgeExtension.2
            @Override // com.alibaba.ariver.remotedebug.view.ActionEventListener
            public void exitRemoteDebug() {
                if (RemoteDebugViewBridgeExtension.this.c == null || RemoteDebugViewBridgeExtension.this.c.get() == null) {
                    RVLogger.d("AriverAPI:RemoteDebugViewBridgeExtension", "mMaskPageRef or page is null");
                } else {
                    EngineUtils.sendToRender(((Page) RemoteDebugViewBridgeExtension.this.c.get()).getRender(), "tinyRemoteDebugMaskButtonClick", null, null);
                }
            }
        });
    }
}
