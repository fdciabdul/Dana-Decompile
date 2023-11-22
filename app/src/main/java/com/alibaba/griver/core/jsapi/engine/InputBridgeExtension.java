package com.alibaba.griver.core.jsapi.engine;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes2.dex */
public class InputBridgeExtension implements BridgeExtension {
    private static final String TAG = "AriverAPI:InputBridgeExtension";

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

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse toggleSoftInput(@BindingApiContext ApiContext apiContext) {
        ((InputMethodManager) apiContext.getActivity().getSystemService("input_method")).toggleSoftInput(0, 2);
        RVLogger.d(TAG, "toggleSoftInput success ");
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showSoftInput(@BindingParam({"show"}) boolean z, @BindingParam({"show"}) String str, @BindingApiContext ApiContext apiContext) {
        InputMethodManager inputMethodManager = (InputMethodManager) apiContext.getActivity().getSystemService("input_method");
        View internalView = apiContext.getInternalView();
        if (internalView == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                inputMethodManager.showSoftInput(internalView, 2);
                RVLogger.d(TAG, "showSoftInput  show ");
            } else {
                inputMethodManager.hideSoftInputFromWindow(internalView.getWindowToken(), 0);
                RVLogger.d(TAG, "showSoftInput  hide ");
            }
            return BridgeResponse.SUCCESS;
        }
        RVLogger.e(TAG, "you should specify whether to or not to show soft input");
        return new BridgeResponse.Error(2, "error not set \"show\" key  ");
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse inputFocus4Android(@BindingApiContext ApiContext apiContext, @BindingParam({"coordinateX"}) String str, @BindingParam({"coordinateY"}) String str2) {
        View internalView = apiContext.getInternalView();
        if (internalView == null) {
            RVLogger.d(TAG, "inputFocus4Android realWebView == null");
            return BridgeResponse.SUCCESS;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("x ");
        sb.append(str);
        sb.append(", y ");
        sb.append(str2);
        RVLogger.d(TAG, sb.toString());
        try {
            float floatValue = Float.valueOf(str).floatValue();
            float floatValue2 = Float.valueOf(str2).floatValue();
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, floatValue, floatValue2, 0);
            long j = uptimeMillis + 300;
            MotionEvent obtain2 = MotionEvent.obtain(j, j, 1, floatValue, floatValue2, 0);
            internalView.dispatchTouchEvent(obtain);
            internalView.dispatchTouchEvent(obtain2);
            obtain.recycle();
            obtain2.recycle();
            return BridgeResponse.SUCCESS;
        } catch (Throwable th) {
            RVLogger.e(TAG, "inputFocus4Android exception ", th);
            return BridgeResponse.INVALID_PARAM;
        }
    }
}
