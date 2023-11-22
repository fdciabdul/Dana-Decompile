package com.alipay.mobile.verifyidentity.business.face.product;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.VIRespone;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.base.product.SecVIModule;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VerifyResponseCallBack;
import com.alipay.mobile.verifyidentity.uitools.JsonUtils;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.connect.api.ConnectFacade;
import com.ap.zoloz.hummer.connect.api.ConnectRequest;
import com.ap.zoloz.hummer.connect.api.ConnectResponse;
import com.ap.zoloz.hummer.connect.api.IConnectCallback;
import com.fullstory.instrumentation.InstrumentInjector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class FaceModule extends SecVIModule {
    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public String getProductName() {
        return null;
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void setProductName() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void stop() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.SecVIModule
    public void start(final Context context, final Message message, final IProduct.ICallback iCallback) {
        try {
            JSONObject jSONObject = new JSONObject(message.getData());
            String string = JsonUtils.getString(jSONObject, "code");
            String string2 = JsonUtils.getString(jSONObject, "zolozConnectId");
            String string3 = JsonUtils.getString(jSONObject, "zolozConfiguration");
            StringBuilder sb = new StringBuilder();
            sb.append("FaceModule  code  ");
            sb.append(string);
            sb.append("  verifyCode  ");
            sb.append(message.getVerifyCode());
            sb.append(" zolozConnectId  ");
            sb.append(string2);
            sb.append(" zolozConfiguration  ");
            sb.append(string3);
            InstrumentInjector.log_e("king", sb.toString());
            if (string.equals("AWAKE_ZOLOZ") && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                ConnectRequest connectRequest = new ConnectRequest();
                connectRequest.connectId = string2;
                connectRequest.connectConfig = string3;
                connectRequest.bizConfig.put(HummerConstants.HUMMER_CONFIG_PATH, "config_connect");
                connectRequest.bizConfig.put(HummerConstants.HUMMER_CONTEXT, context);
                ConnectFacade.getInstance().startConnect(connectRequest, new IConnectCallback() { // from class: com.alipay.mobile.verifyidentity.business.face.product.FaceModule.1
                    @Override // com.ap.zoloz.hummer.connect.api.IConnectCallback
                    public void onCompletion(ConnectResponse connectResponse) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("connectResponse.code   ");
                        sb2.append(connectResponse.code);
                        InstrumentInjector.log_e("king", sb2.toString());
                        if (connectResponse.code == 1000) {
                            FaceModule.this.cherckFaceVerifyResult(context, message, iCallback);
                        } else if (connectResponse.code == 2006) {
                            FaceModule.this.cherckFaceVerifyResult(context, message, iCallback);
                        } else if (connectResponse.code == 1003) {
                            message.setNextStep("");
                            VIRespone vIRespone = new VIRespone(1003);
                            vIRespone.setMessage(message);
                            vIRespone.setVerifyId(message.getVerifyId());
                            vIRespone.setResponseMessage(message);
                            IProduct.ICallback iCallback2 = iCallback;
                            if (iCallback2 != null) {
                                iCallback2.onResult(FaceModule.this, vIRespone);
                            }
                        } else {
                            message.setNextStep("");
                            VIRespone vIRespone2 = new VIRespone(1001);
                            vIRespone2.setMessage(message);
                            vIRespone2.setVerifyId(message.getVerifyId());
                            vIRespone2.setResponseMessage(message);
                            IProduct.ICallback iCallback3 = iCallback;
                            if (iCallback3 != null) {
                                iCallback3.onResult(FaceModule.this, vIRespone2);
                            }
                        }
                    }
                });
            } else if (message.getVerifyCode().equals("SUCCESS")) {
                InstrumentInjector.log_e("king", " server open face success");
                message.setNextStep("");
                VIRespone vIRespone = new VIRespone(1000);
                vIRespone.setMessage(message);
                vIRespone.setVerifyId(message.getVerifyId());
                vIRespone.setResponseMessage(message);
                if (iCallback != null) {
                    iCallback.onResult(this, vIRespone);
                }
            } else {
                InstrumentInjector.log_e("king", " server open face fail");
                message.setNextStep("");
                VIRespone vIRespone2 = new VIRespone(1001);
                vIRespone2.setMessage(message);
                vIRespone2.setVerifyId(message.getVerifyId());
                vIRespone2.setResponseMessage(message);
                if (iCallback != null) {
                    iCallback.onResult(this, vIRespone2);
                }
            }
        } catch (JSONException unused) {
            message.setNextStep("");
            VIRespone vIRespone3 = new VIRespone(1001);
            vIRespone3.setMessage(message);
            vIRespone3.setVerifyId(message.getVerifyId());
            vIRespone3.setResponseMessage(message);
            if (iCallback != null) {
                iCallback.onResult(this, vIRespone3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cherckFaceVerifyResult(Context context, final Message message, final IProduct.ICallback iCallback) {
        InstrumentInjector.log_e("king", " cherckFaceVerifyResult   ");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", "");
        } catch (JSONException unused) {
        }
        VIEngine.verifyRequest((Activity) context, message.getVerifyId(), message.getNextStep(), jSONObject.toString(), new VerifyResponseCallBack() { // from class: com.alipay.mobile.verifyidentity.business.face.product.FaceModule.2
            @Override // com.alipay.mobile.verifyidentity.framework.engine.VerifyResponseCallBack
            public void verifyRequestSuccess(MICRpcResponse mICRpcResponse) {
                if (mICRpcResponse == null) {
                    String[] strArr = {"a3.b2.c2", "1", ""};
                    message.setNextStep("");
                    VIRespone vIRespone = new VIRespone(1001);
                    vIRespone.setMessage(message);
                    vIRespone.setVerifyId(message.getVerifyId());
                    vIRespone.setResponseMessage(message);
                    IProduct.ICallback iCallback2 = iCallback;
                    if (iCallback2 != null) {
                        iCallback2.onResult(FaceModule.this, vIRespone);
                    }
                    ClientLogKitManager.getClientLogKit().log("event", strArr, null, "", "", "", message.getVerifyId(), false);
                    return;
                }
                ClientLogKitManager.getClientLogKit().log("event", new String[]{"a3.b2.c2", "0", ""}, null, "", "", "", message.getVerifyId(), false);
                if (mICRpcResponse.verifySuccess) {
                    message.setNextStep("");
                    VIRespone vIRespone2 = new VIRespone(1000);
                    vIRespone2.setMessage(message);
                    vIRespone2.setVerifyId(message.getVerifyId());
                    vIRespone2.setResponseMessage(mICRpcResponse.convertToMessage());
                    IProduct.ICallback iCallback3 = iCallback;
                    if (iCallback3 != null) {
                        iCallback3.onResult(FaceModule.this, vIRespone2);
                        return;
                    }
                    return;
                }
                message.setNextStep("");
                VIRespone vIRespone3 = new VIRespone(1001);
                vIRespone3.setMessage(message);
                vIRespone3.setVerifyId(message.getVerifyId());
                vIRespone3.setResponseMessage(mICRpcResponse.convertToMessage());
                IProduct.ICallback iCallback4 = iCallback;
                if (iCallback4 != null) {
                    iCallback4.onResult(FaceModule.this, vIRespone3);
                }
            }

            @Override // com.alipay.mobile.verifyidentity.framework.engine.VerifyResponseCallBack
            public void verifyRequestFail() {
                message.setNextStep("");
                VIRespone vIRespone = new VIRespone(1001);
                vIRespone.setMessage(message);
                vIRespone.setVerifyId(message.getVerifyId());
                vIRespone.setResponseMessage(message);
                IProduct.ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onResult(FaceModule.this, vIRespone);
                }
            }
        });
    }
}
