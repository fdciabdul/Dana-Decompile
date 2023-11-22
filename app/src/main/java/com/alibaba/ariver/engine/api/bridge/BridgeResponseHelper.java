package com.alibaba.ariver.engine.api.bridge;

import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.proxy.RVBridgeCallContextHandleProxy;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.fastjson.JSONObject;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;

/* loaded from: classes2.dex */
public class BridgeResponseHelper {

    /* renamed from: a  reason: collision with root package name */
    private SendToNativeCallback f6018a;
    private Extension b;
    private boolean c;

    public BridgeResponseHelper(final SendToNativeCallback sendToNativeCallback) {
        this.f6018a = new SendToNativeCallback() { // from class: com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject, boolean z) {
                SendToNativeCallback sendToNativeCallback2;
                if ((!BridgeResponseHelper.this.c || z) && (sendToNativeCallback2 = sendToNativeCallback) != null) {
                    sendToNativeCallback2.onCallback(jSONObject, z);
                }
            }
        };
    }

    public void setTargetExtension(Extension extension) {
        this.b = extension;
    }

    public SendToNativeCallback getInnerBridgeResponse() {
        return this.f6018a;
    }

    protected void executeSendBack(JSONObject jSONObject, boolean z) {
        Extension extension;
        if (this.f6018a != null) {
            if (RVKernelUtils.isDebug() && (extension = this.b) != null && jSONObject != null) {
                jSONObject.put(RVConstants.PKG_EXT_PREFIX, (Object) extension.getClass().getName());
            }
            this.f6018a.onCallback(jSONObject, z);
        }
    }

    public void sendBridgeResult(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        executeSendBack(jSONObject, false);
    }

    public void sendBridgeResult(JSONObject jSONObject) {
        executeSendBack(jSONObject, false);
    }

    public void sendBridgeResultWithCallbackKept(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        executeSendBack(jSONObject, true);
    }

    public void sendBridgeResultWithCallbackKept(JSONObject jSONObject) {
        executeSendBack(jSONObject, true);
    }

    public void sendSuccess() {
        sendBridgeResult(new JSONObject());
    }

    public void sendError(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", (Object) str);
        jSONObject.put("errorMessage", (Object) str);
        jSONObject.put("error", (Object) Integer.valueOf(i));
        executeSendBack(jSONObject, false);
    }

    public void sendError(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", (Object) str);
        jSONObject.put("errorMessage", (Object) str);
        jSONObject.put("error", (Object) Integer.valueOf(i));
        jSONObject.put(BranchLinkConstant.OauthParams.SIGNATURE, (Object) str2);
        executeSendBack(jSONObject, false);
    }

    public void sendNoRigHtToInvoke() {
        sendError(4, ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).getResourceString("ariver_engine_api_forbidden_error"));
    }

    public void sendNoRigHtToInvoke(String str) {
        sendError(4, ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).getResourceString("ariver_engine_api_forbidden_error"), str);
    }

    public void sendNotFound() {
        sendError(1, "not implemented");
    }

    public void sendNoRigHtToInvoke4NewJSAPIPermission() {
        sendError(4, "new jsapi permission deny");
    }

    public void sendNotGrantPermission() {
        sendError(5, ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).getResourceString("ariver_engine_api_authorization_error"));
    }

    public void sendUserNotGrantPermission() {
        sendError(2001, ((RVBridgeCallContextHandleProxy) RVProxy.get(RVBridgeCallContextHandleProxy.class)).getResourceString("ariver_engine_api_user_not_grant"));
    }

    public void sendTimeout() {
        sendError(9, TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        this.c = true;
    }

    public void sendSilentDenyPermission() {
        sendError(2002, "user does not allow authorization");
    }
}
