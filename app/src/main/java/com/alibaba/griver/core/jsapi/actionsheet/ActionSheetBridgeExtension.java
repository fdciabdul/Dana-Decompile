package com.alibaba.griver.core.jsapi.actionsheet;

import android.app.Dialog;
import com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.point.PageBackInterceptPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class ActionSheetBridgeExtension implements PageBackInterceptPoint, BridgeExtension {
    private static final String TAG = "AriverAPI:ActionSheetBridgeExtension";
    private ActionSheetPoint actionSheetPoint;
    private WeakReference<Dialog> mDialogReference;
    private boolean sheetVisible = false;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.point.PageBackInterceptPoint
    public boolean interceptBackEvent(GoBackCallback goBackCallback) {
        return hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hide() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.mDialogReference;
        if (weakReference == null || (dialog = weakReference.get()) == null || !dialog.isShowing()) {
            return false;
        }
        dialog.cancel();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    @com.alibaba.ariver.kernel.api.annotation.ThreadType(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.UI)
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void actionSheet(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext(required = true) com.alibaba.ariver.engine.api.bridge.model.ApiContext r17, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode(com.alibaba.ariver.app.api.Page.class) com.alibaba.ariver.app.api.Page r18, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"title"}) java.lang.String r19, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"cancelBtn"}) java.lang.String r20, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"btns"}) com.alibaba.fastjson.JSONArray r21, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"badges"}) com.alibaba.fastjson.JSONArray r22, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback final com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r23) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.actionsheet.ActionSheetBridgeExtension.actionSheet(com.alibaba.ariver.engine.api.bridge.model.ApiContext, com.alibaba.ariver.app.api.Page, java.lang.String, java.lang.String, com.alibaba.fastjson.JSONArray, com.alibaba.fastjson.JSONArray, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback):void");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        hide();
        ActionSheetPoint actionSheetPoint = this.actionSheetPoint;
        if (actionSheetPoint != null) {
            actionSheetPoint.onRelease();
        }
    }
}
