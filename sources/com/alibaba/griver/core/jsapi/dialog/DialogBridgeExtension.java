package com.alibaba.griver.core.jsapi.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverWhiteScreenStageMonitor;
import com.alibaba.griver.core.R;

/* loaded from: classes2.dex */
public class DialogBridgeExtension implements BridgeExtension {
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

    private void trackWhiteAlert(Page page, String str, String str2) {
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverWhiteScreenStageMonitor.getMonitorToken(page.getApp(), page.getPageURI()));
        if (stageMonitor != null) {
            stageMonitor.addParam(GriverMonitorConstants.KEY_IS_ALERTING, Boolean.TRUE);
            stageMonitor.addParam(GriverMonitorConstants.KEY_ALERT_TITLE, str);
            stageMonitor.addParam(GriverMonitorConstants.KEY_ALERT_MESSAGE, str2);
        }
    }

    public void removeTrackWhiteAlert(Page page) {
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverWhiteScreenStageMonitor.getMonitorToken(page.getApp(), page.getPageURI()));
        if (stageMonitor != null) {
            stageMonitor.addParam(GriverMonitorConstants.KEY_IS_ALERTING, Boolean.FALSE);
            stageMonitor.removeParam(GriverMonitorConstants.KEY_ALERT_TITLE);
            stageMonitor.removeParam(GriverMonitorConstants.KEY_ALERT_MESSAGE);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void alert(@BindingNode(Page.class) final Page page, @BindingParam(name = {"title"}) String str, @BindingParam(name = {"message"}) String str2, @BindingParam(name = {"button"}) String str3, @BindingParam(name = {"align"}) String str4, @BindingParam(name = {"confirmColor"}) String str5, @BindingParam(name = {"cancelColor"}) String str6, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page.getPageContext() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        if (TextUtils.isEmpty(str3) && GriverEnv.getResources() != null) {
            str3 = GriverEnv.getResources().getString(R.string.griver_base_ok);
        }
        String str7 = str3;
        DialogPoint dialogPoint = (DialogPoint) ExtensionPoint.as(DialogPoint.class).node(page).create();
        CreateDialogParam createDialogParam = new CreateDialogParam(str, str2, str7, null, str4);
        createDialogParam.positiveTextColor = str5;
        createDialogParam.cancelColor = str6;
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                DialogBridgeExtension.this.removeTrackWhiteAlert(page);
                bridgeCallback.sendBridgeResponse(null);
            }
        };
        createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                DialogBridgeExtension.this.removeTrackWhiteAlert(page);
                bridgeCallback.sendBridgeResponse(null);
            }
        };
        Dialog createDialog = dialogPoint.createDialog(page.getPageContext().getActivity(), createDialogParam);
        if (createDialog != null) {
            createDialog.show();
            ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).applyShow(createDialog, createDialogParam);
            trackWhiteAlert(page, str, str2);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void confirm(@BindingNode(Page.class) final Page page, @BindingParam(name = {"title"}) String str, @BindingParam(name = {"message"}) String str2, @BindingParam(name = {"okButton"}) String str3, @BindingParam(name = {"cancelButton"}) String str4, @BindingParam(name = {"align"}) String str5, @BindingParam(name = {"confirmColor"}) String str6, @BindingParam(name = {"cancelColor"}) String str7, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page.getPageContext() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        Resources resources = GriverEnv.getResources();
        String string = (!TextUtils.isEmpty(str3) || resources == null) ? str3 : resources.getString(R.string.griver_base_ok);
        String string2 = (!TextUtils.isEmpty(str4) || resources == null) ? str4 : resources.getString(R.string.griver_base_cancel);
        DialogPoint dialogPoint = (DialogPoint) ExtensionPoint.as(DialogPoint.class).node(page).create();
        CreateDialogParam createDialogParam = new CreateDialogParam(str, str2, string, string2, str5);
        createDialogParam.positiveTextColor = str6;
        createDialogParam.cancelColor = str7;
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObject);
                DialogBridgeExtension.this.removeTrackWhiteAlert(page);
            }
        };
        createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
                DialogBridgeExtension.this.removeTrackWhiteAlert(page);
            }
        };
        createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ok", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
        Dialog createDialog = dialogPoint.createDialog(page.getPageContext().getActivity(), createDialogParam);
        if (createDialog != null) {
            createDialog.show();
            ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).applyShow(createDialog, createDialogParam);
            trackWhiteAlert(page, str, str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (android.text.TextUtils.equals(r15, "确定") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (android.text.TextUtils.equals(r5, "取消") != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @com.alibaba.ariver.kernel.api.annotation.ThreadType(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.UI)
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prompt(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode(com.alibaba.ariver.app.api.Page.class) final com.alibaba.ariver.app.api.Page r12, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"title"}) java.lang.String r13, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"message"}) java.lang.String r14, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"okButton"}) java.lang.String r15, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"cancelButton"}) java.lang.String r16, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"placeholder"}) java.lang.String r17, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"confirmColor"}) java.lang.String r18, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"cancelColor"}) java.lang.String r19, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"align"}) java.lang.String r20, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback final com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r21) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r21
            if (r1 == 0) goto Lbe
            com.alibaba.ariver.app.api.PageContext r3 = r12.getPageContext()
            if (r3 == 0) goto Lbe
            boolean r3 = r12.isDestroyed()
            if (r3 != 0) goto Lbe
            boolean r3 = r12.isExited()
            if (r3 != 0) goto Lbe
            android.content.res.Resources r3 = com.alibaba.griver.base.common.env.GriverEnv.getResources()
            boolean r4 = android.text.TextUtils.isEmpty(r15)
            if (r4 != 0) goto L2c
            java.lang.String r4 = "确定"
            r5 = r15
            boolean r4 = android.text.TextUtils.equals(r15, r4)
            if (r4 == 0) goto L37
            goto L2d
        L2c:
            r5 = r15
        L2d:
            if (r3 == 0) goto L37
            int r4 = com.alibaba.griver.core.R.string.griver_base_ok
            java.lang.String r4 = r3.getString(r4)
            r8 = r4
            goto L38
        L37:
            r8 = r5
        L38:
            boolean r4 = android.text.TextUtils.isEmpty(r16)
            if (r4 != 0) goto L49
            java.lang.String r4 = "取消"
            r5 = r16
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L55
            goto L4b
        L49:
            r5 = r16
        L4b:
            if (r3 == 0) goto L55
            int r4 = com.alibaba.griver.core.R.string.griver_base_cancel
            java.lang.String r4 = r3.getString(r4)
            r9 = r4
            goto L56
        L55:
            r9 = r5
        L56:
            java.lang.String r4 = "请输入内容"
            r5 = r14
            boolean r4 = android.text.TextUtils.equals(r14, r4)
            if (r4 == 0) goto L68
            if (r3 == 0) goto L68
            int r4 = com.alibaba.griver.core.R.string.griver_core_prompt_message_placeholder
            java.lang.String r3 = r3.getString(r4)
            goto L69
        L68:
            r3 = r5
        L69:
            com.alibaba.griver.api.ui.dialog.GriverCreatePromptParam r4 = new com.alibaba.griver.api.ui.dialog.GriverCreatePromptParam
            r5 = r4
            r6 = r13
            r7 = r3
            r10 = r17
            r5.<init>(r6, r7, r8, r9, r10)
            r5 = r20
            r4.setAlign(r5)
            r5 = r18
            r4.positiveTextColor = r5
            r5 = r19
            r4.cancelColor = r5
            com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension$6 r5 = new com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension$6
            r5.<init>()
            r4.positiveListener = r5
            com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension$7 r5 = new com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension$7
            r5.<init>()
            r4.negativeListener = r5
            com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension$8 r5 = new com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension$8
            r5.<init>()
            r4.cancelListener = r5
            java.lang.Class<com.alibaba.griver.api.ui.dialog.GriverPromptExtension> r2 = com.alibaba.griver.api.ui.dialog.GriverPromptExtension.class
            java.lang.Object r2 = com.alibaba.ariver.kernel.common.RVProxy.get(r2)
            com.alibaba.griver.api.ui.dialog.GriverPromptExtension r2 = (com.alibaba.griver.api.ui.dialog.GriverPromptExtension) r2
            com.alibaba.ariver.app.api.PageContext r5 = r12.getPageContext()
            android.app.Activity r5 = r5.getActivity()
            android.app.Dialog r2 = r2.createDialog(r5, r4)
            if (r2 == 0) goto Lbd
            r2.show()
            java.lang.Class<com.alibaba.griver.api.ui.dialog.GriverPromptExtension> r5 = com.alibaba.griver.api.ui.dialog.GriverPromptExtension.class
            java.lang.Object r5 = com.alibaba.ariver.kernel.common.RVProxy.get(r5)
            com.alibaba.griver.api.ui.dialog.GriverPromptExtension r5 = (com.alibaba.griver.api.ui.dialog.GriverPromptExtension) r5
            r5.applyShow(r2, r4)
            r2 = r13
            r11.trackWhiteAlert(r12, r13, r3)
        Lbd:
            return
        Lbe:
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r1 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.UNKNOWN_ERROR
            r2.sendBridgeResponse(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension.prompt(com.alibaba.ariver.app.api.Page, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback):void");
    }
}
