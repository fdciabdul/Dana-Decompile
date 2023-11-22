package com.ap.zoloz.hummer.h5;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Base64;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.security.bio.security.AESEncrypt;
import com.alipay.mobile.security.bio.security.RSAEncrypt;
import com.alipay.mobile.security.bio.security.RandomHelper;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.rpc.BioRPCService;
import com.alipay.mobile.security.bio.utils.ScreenUtil;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.verifyidentity.base.message.MessageConstants;
import com.alipay.zoloz.hardware.camera.CameraData;
import com.alipay.zoloz.hardware.camera.ICameraCallback;
import com.alipay.zoloz.hardware.camera.widget.PermissionCameraSurfaceView;
import com.alipay.zoloz.toyger.blob.BitmapHelper;
import com.alipay.zoloz.toyger.h5.ToygerH5Service;
import com.ap.zoloz.hummer.api.BaseFacade;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.biz.HummerLogger;
import com.ap.zoloz.hummer.common.AlertManager;
import com.ap.zoloz.hummer.common.IAlertCallback;
import com.ap.zoloz.hummer.common.RecordManager;
import com.ap.zoloz.hummer.rpc.IRpcCallback;
import com.ap.zoloz.hummer.rpc.RpcManager;
import com.ap.zoloz.hummer.rpc.RpcResponse;
import com.zoloz.zhub.common.factor.facade.HummerGWFacade;
import com.zoloz.zhub.common.factor.facade.HummerH5Facade;
import com.zoloz.zhub.common.factor.model.FactorNextResponse;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ZolozFoundationHandler {
    public static final String TAG = "ZolozFoundationHandler";
    private static final String ZIM_IDENTIFY_ACTION = "action";
    private static final String ZIM_IDENTIFY_GET_META_INFO = "getMetaInfo";
    private static final String ZLZ_FOUNDATION_GET_BLOB = "getImgBlob";
    private static final String ZLZ_FOUNDATION_HIDE_LOADING_DIALOG = "hideLoadingDialog";
    private static final String ZLZ_FOUNDATION_INIT = "init";
    private static final String ZLZ_FOUNDATION_LOGGING = "logging";
    private static final String ZLZ_FOUNDATION_LOG_MESS = "logMessage";
    private static final String ZLZ_FOUNDATION_LOG_SEED_ID = "logSeedID";
    private static final String ZLZ_FOUNDATION_MESSAGE = "message";
    private static final String ZLZ_FOUNDATION_NEGATIVE = "negative";
    private static final String ZLZ_FOUNDATION_POSITIVE = "positive";
    private static final String ZLZ_FOUNDATION_RELEASE = "release";
    private static final String ZLZ_FOUNDATION_SCREEN_BRIGHTNESS = "setScreenBrightness";
    private static final String ZLZ_FOUNDATION_SEND_RPC = "sendRpc";
    private static final String ZLZ_FOUNDATION_SHOW_ALERT = "showAlert";
    private static final String ZLZ_FOUNDATION_SHOW_LOADING_DIALOG = "showLoadingDialog";
    private static final String ZLZ_FOUNDATION_TITLE = "title";
    private IH5HandlerCallback mIH5HandlerCallback;
    private int mImgWidth = 0;
    private int mImgHeight = 0;
    private PermissionCameraSurfaceView cameraSurfaceView = null;
    private ICameraCallback iCameraCallback = null;
    private byte[] mYuvData = null;
    private final Object mLock = new Object();
    private boolean needCallback = false;

    public void identify(JSONObject jSONObject, Context context, final IH5HandlerCallback iH5HandlerCallback) {
        if (jSONObject == null || context == null) {
            return;
        }
        this.mIH5HandlerCallback = iH5HandlerCallback;
        StringBuilder sb = new StringBuilder();
        sb.append(" jsapi");
        sb.append(jSONObject.toJSONString());
        HummerLogger.i(TAG, sb.toString());
        String string = jSONObject.getString("action");
        if (StringUtil.isNullorEmpty(string) || iH5HandlerCallback == null) {
            return;
        }
        if ("logging".equals(string)) {
            RecordManager.getInstance().record(jSONObject.getString("logSeedID"), (Map) JSONObject.toJavaObject(jSONObject.getJSONObject("logMessage"), Map.class), jSONObject.getString(MessageConstants.KEY_PRODUCT_NAME));
            iH5HandlerCallback.onCompletion(new JSONObject());
        } else if ("sendRpc".equals(string)) {
            RpcManager.getInstance().sendRpc(new IRpcCallback() { // from class: com.ap.zoloz.hummer.h5.ZolozFoundationHandler.1
                @Override // com.ap.zoloz.hummer.rpc.IRpcCallback
                public void onCompletion(RpcResponse rpcResponse) {
                    if (rpcResponse == null || HummerConstants.NETWOTK_EXCEPTION.equals(rpcResponse.exception)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("success", (Object) Boolean.FALSE);
                        iH5HandlerCallback.onCompletion(jSONObject2);
                        return;
                    }
                    FactorNextResponse factorNextResponse = rpcResponse.factorNextResponse;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("success", (Object) Boolean.TRUE);
                    jSONObject3.put(HummerConstants.NEXT_RESPONSE, (Object) factorNextResponse);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ZolozFoundationHandler sendBridgeResult ");
                    sb2.append(jSONObject3.toString());
                    HummerLogger.i(sb2.toString());
                    iH5HandlerCallback.onCompletion(jSONObject3);
                }
            }, RpcManager.getInstance().formatRequest(jSONObject.getString("factorNextRequest")));
        } else if ("showAlert".equals(string)) {
            AlertManager.getInstance().alert(jSONObject.getString("title"), jSONObject.getString("message"), jSONObject.getString("positive"), jSONObject.getString("negative"), new IAlertCallback() { // from class: com.ap.zoloz.hummer.h5.ZolozFoundationHandler.2
                @Override // com.ap.zoloz.hummer.common.IAlertCallback
                public void onPositive() {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("positive", (Object) Boolean.TRUE);
                    iH5HandlerCallback.onCompletion(jSONObject2);
                }

                @Override // com.ap.zoloz.hummer.common.IAlertCallback
                public void onNegative() {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("positive", (Object) Boolean.FALSE);
                    iH5HandlerCallback.onCompletion(jSONObject2);
                }
            });
        } else if ("showLoadingDialog".equals(string)) {
            AlertManager.getInstance().showProgressDialog("", false, new DialogInterface.OnCancelListener() { // from class: com.ap.zoloz.hummer.h5.ZolozFoundationHandler.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            }, true);
        } else if ("hideLoadingDialog".equals(string)) {
            AlertManager.getInstance().dismissDialog();
        } else if ("init".equals(string)) {
            String string2 = jSONObject.getString(HummerConstants.HUMMER_ID);
            String string3 = jSONObject.getString(HummerConstants.GATEWAY_URL_KEY);
            String string4 = jSONObject.getString("WORKSPACE_ID");
            String string5 = jSONObject.getString("APP_ID");
            JSONObject jSONObject2 = new JSONObject();
            if (StringUtil.isNullorEmpty(string2) || StringUtil.isNullorEmpty(string3) || StringUtil.isNullorEmpty(string4) || StringUtil.isNullorEmpty(string5)) {
                jSONObject2.put("success", (Object) Boolean.FALSE);
                iH5HandlerCallback.onCompletion(jSONObject2);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(HummerConstants.HUMMER_ID, string2);
            RecordManager.getInstance().init(context.getApplicationContext(), hashMap);
            BioRPCService bioRPCService = (BioRPCService) BioServiceManager.getLocalService(context.getApplicationContext(), BioRPCService.class);
            bioRPCService.setRemoteUrl(string3);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("WORKSPACE_ID", string4);
            hashMap2.put("APP_ID", string5);
            bioRPCService.setExtProperties(hashMap2);
            RpcManager.getInstance().init((HummerGWFacade) bioRPCService.getRpcProxy(HummerH5Facade.class));
            AlertManager.getInstance().setContext(context);
            jSONObject2.put("success", (Object) Boolean.TRUE);
            iH5HandlerCallback.onCompletion(jSONObject2);
        } else if ("release".equals(string)) {
            RpcManager.getInstance().release();
            RecordManager.getInstance().release();
            AlertManager.getInstance().release();
            release();
            iH5HandlerCallback.onCompletion(new JSONObject());
        } else if (ZLZ_FOUNDATION_SCREEN_BRIGHTNESS.equals(string)) {
            int intValue = jSONObject.getInteger("brightness").intValue();
            int screenBrightness = ScreenUtil.getScreenBrightness(context);
            if (intValue > screenBrightness) {
                ScreenUtil.setScreenBrightness((Activity) context, intValue);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("originalBrightness", (Object) Integer.valueOf(screenBrightness));
            iH5HandlerCallback.onCompletion(jSONObject3);
        } else if (ZLZ_FOUNDATION_GET_BLOB.equals(string)) {
            try {
                PermissionCameraSurfaceView permissionCameraSurfaceView = this.cameraSurfaceView;
                int cameraViewRotation = permissionCameraSurfaceView != null ? 360 - permissionCameraSurfaceView.getCameraInterface().getCameraViewRotation() : 0;
                HashMap<String, Object> generateH5Blob = ToygerH5Service.generateH5Blob(this.mImgHeight, this.mImgWidth, cameraViewRotation, jSONObject.getInteger("desiredWidth").intValue(), jSONObject.getFloat("ratio").floatValue(), this.mYuvData, BaseFacade.getPublicKey(context.getApplicationContext(), jSONObject.getInteger("env").intValue()));
                byte[] bArr = (byte[]) generateH5Blob.get("content");
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("content", (Object) new String(bArr));
                jSONObject4.put("key", (Object) Base64.encodeToString((byte[]) generateH5Blob.get("key"), 10));
                iH5HandlerCallback.onCompletion(jSONObject4);
            } catch (OutOfMemoryError e) {
                HummerLogger.e(e.toString());
                iH5HandlerCallback.onCompletion(new JSONObject());
            }
        } else if ("openCamera".equals(string)) {
            this.needCallback = true;
            this.mImgWidth = jSONObject.getInteger("imgWidth").intValue();
            this.mImgHeight = jSONObject.getInteger("imgHeight").intValue();
            ViewGroup viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            PermissionCameraSurfaceView permissionCameraSurfaceView2 = new PermissionCameraSurfaceView(context);
            this.cameraSurfaceView = permissionCameraSurfaceView2;
            viewGroup.addView(permissionCameraSurfaceView2, 0);
            ICameraCallback iCameraCallback = new ICameraCallback() { // from class: com.ap.zoloz.hummer.h5.ZolozFoundationHandler.4
                @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
                public void onSurfaceCreated() {
                }

                @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
                public void onSurfaceDestroyed() {
                }

                @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
                public void onSurfaceChanged(double d, double d2) {
                    if (ZolozFoundationHandler.this.cameraSurfaceView == null) {
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = ZolozFoundationHandler.this.cameraSurfaceView.getLayoutParams();
                    int width = ZolozFoundationHandler.this.cameraSurfaceView.getWidth();
                    int height = ZolozFoundationHandler.this.cameraSurfaceView.getHeight();
                    double d3 = width;
                    Double.isNaN(d3);
                    int i = (int) ((d3 / d) * d2);
                    if (i >= height) {
                        layoutParams.height = i;
                    } else {
                        double d4 = height;
                        Double.isNaN(d4);
                        int i2 = (int) ((d4 / d2) * d);
                        if (i2 >= width) {
                            layoutParams.width = i2;
                        }
                    }
                    ZolozFoundationHandler.this.cameraSurfaceView.setLayoutParams(layoutParams);
                }

                @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
                public void onError(int i) {
                    if (ZolozFoundationHandler.this.needCallback) {
                        ZolozFoundationHandler.this.needCallback = false;
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("success", (Object) Boolean.FALSE);
                        iH5HandlerCallback.onCompletion(jSONObject5);
                    }
                }

                @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
                public void onPreviewFrame(CameraData cameraData) {
                    if (ZolozFoundationHandler.this.cameraSurfaceView == null) {
                        return;
                    }
                    synchronized (ZolozFoundationHandler.this.mLock) {
                        try {
                            JSONObject jSONObject5 = new JSONObject();
                            ZolozFoundationHandler.this.mYuvData = cameraData.getColorData().array();
                            jSONObject5.put("frame", (Object) Base64.encodeToString(BitmapHelper.rotateYUVImage(ZolozFoundationHandler.this.mYuvData, cameraData.getColorWidth(), cameraData.getColorHeight(), ZolozFoundationHandler.this.cameraSurfaceView.getCameraInterface().getCameraViewRotation(), 100), 0));
                            ZolozFoundationHandler.this.mIH5HandlerCallback.onCompletion(jSONObject5);
                        } catch (OutOfMemoryError e2) {
                            HummerLogger.e(e2.toString());
                            ZolozFoundationHandler.this.mIH5HandlerCallback.onCompletion(new JSONObject());
                        }
                    }
                }

                @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
                public void onSuccess() {
                    if (ZolozFoundationHandler.this.needCallback) {
                        ZolozFoundationHandler.this.needCallback = false;
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("success", (Object) Boolean.TRUE);
                        iH5HandlerCallback.onCompletion(jSONObject5);
                    }
                }
            };
            this.iCameraCallback = iCameraCallback;
            this.cameraSurfaceView.init(this.mImgHeight, this.mImgWidth, true, iCameraCallback);
        } else if ("getCameraFrame".equals(string)) {
            PermissionCameraSurfaceView permissionCameraSurfaceView3 = this.cameraSurfaceView;
            if (permissionCameraSurfaceView3 != null) {
                permissionCameraSurfaceView3.getCameraInterface().setOntShotPreviewCallback();
            }
        } else if ("pausePreview".equals(string)) {
            PermissionCameraSurfaceView permissionCameraSurfaceView4 = this.cameraSurfaceView;
            if (permissionCameraSurfaceView4 != null) {
                permissionCameraSurfaceView4.getCameraInterface().stopPreview();
            }
        } else if ("resumePreview".equals(string)) {
            PermissionCameraSurfaceView permissionCameraSurfaceView5 = this.cameraSurfaceView;
            if (permissionCameraSurfaceView5 != null) {
                permissionCameraSurfaceView5.getCameraInterface().setCallback(this.iCameraCallback);
                this.cameraSurfaceView.getCameraInterface().resumePreview();
            }
        } else if ("encryptLog".equals(string)) {
            int intValue2 = jSONObject.getInteger("env").intValue();
            String string6 = jSONObject.getString("log");
            try {
                RSAPublicKey loadPublicKeyByStr = RSAEncrypt.loadPublicKeyByStr(BaseFacade.getPublicKey(context.getApplicationContext(), intValue2));
                byte[] random = RandomHelper.random(16);
                byte[] encrypt = RSAEncrypt.encrypt(loadPublicKeyByStr, random);
                byte[] encrypt2 = AESEncrypt.encrypt(string6.getBytes(), random);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("behavLogSig", (Object) Base64.encodeToString(encrypt, 10));
                jSONObject5.put("behavLog", (Object) Base64.encodeToString(encrypt2, 10));
                iH5HandlerCallback.onCompletion(jSONObject5);
            } catch (Exception e2) {
                HummerLogger.e(e2.toString());
                iH5HandlerCallback.onCompletion(new JSONObject());
            }
        }
    }

    private void release() {
        PermissionCameraSurfaceView permissionCameraSurfaceView = this.cameraSurfaceView;
        if (permissionCameraSurfaceView != null) {
            permissionCameraSurfaceView.getCameraInterface().releaseCamera();
            this.cameraSurfaceView = null;
        }
        this.mYuvData = null;
        this.iCameraCallback = null;
        this.mIH5HandlerCallback = null;
    }
}
