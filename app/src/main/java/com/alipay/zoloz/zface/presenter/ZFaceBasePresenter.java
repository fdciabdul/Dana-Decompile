package com.alipay.zoloz.zface.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipay.mobile.security.bio.api.BioResponse;
import com.alipay.mobile.security.bio.config.Constant;
import com.alipay.mobile.security.bio.constants.CodeConstants;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioAppManager;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadCallBack;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.bio.service.BioUploadService;
import com.alipay.mobile.security.bio.service.local.apsecurity.ApSecurityService;
import com.alipay.mobile.security.bio.utils.NetworkUtil;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.security.bio.workspace.BioFragmentResponse;
import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;
import com.alipay.zoloz.hardware.camera.CameraData;
import com.alipay.zoloz.hardware.camera.CameraParams;
import com.alipay.zoloz.hardware.camera.ICameraCallback;
import com.alipay.zoloz.hardware.camera.ICameraInterface;
import com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.alipay.zoloz.toyger.algorithm.ToygerCameraConfig;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.alipay.zoloz.toyger.face.LivenessAction;
import com.alipay.zoloz.toyger.face.ToygerFaceAttr;
import com.alipay.zoloz.toyger.face.ToygerFaceCallback;
import com.alipay.zoloz.toyger.face.ToygerFaceService;
import com.alipay.zoloz.toyger.face.ToygerFaceState;
import com.alipay.zoloz.toyger.monitor.NineshotService;
import com.alipay.zoloz.toyger.upload.UploadContent;
import com.alipay.zoloz.zface.beans.AlertData;
import com.alipay.zoloz.zface.beans.FaceRemoteConfig;
import com.alipay.zoloz.zface.beans.FrameStateData;
import com.alipay.zoloz.zface.beans.PreviewData;
import com.alipay.zoloz.zface.beans.UploadData;
import com.alipay.zoloz.zface.manager.AlertManager;
import com.alipay.zoloz.zface.manager.UploadManager;
import com.alipay.zoloz.zface.services.TimeRecord;
import com.alipay.zoloz.zface.services.ToygerIspService;
import com.alipay.zoloz.zface.services.ZFaceRecordService;
import com.alipay.zoloz.zface.utils.Tools;
import com.alipay.zoloz.zface.utils.ToygerMonitor;
import id.dana.sendmoney.summary.SummaryActivity;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class ZFaceBasePresenter implements BioUploadCallBack, ICameraCallback, ToygerFaceCallback {
    private static final String TAG = "ZFaceCore";
    private Context context;
    private AlertManager mAlertManager;
    private BioAppDescription mBioAppDescription;
    private BioUploadService mBioUploadService;
    private ICameraInterface mCameraInterface;
    private ToygerMonitor mFpsMonitor;
    private ToygerFaceAttr mHighQualityAttr;
    private LocalBroadcastManager mLocalBroadcastManager;
    private FaceRemoteConfig mRemoteConfig;
    private ToygerIspService mToygerIspService;
    private UploadContent mUploadContent;
    private UploadManager mUploadManager;
    private ZFaceRecordService mZFaceRecordService;
    private ZFaceCallback view;
    private ToygerFaceService mToygerFaceService = new ToygerFaceService();
    private NineshotService mNineshotService = null;
    private DeviceSetting mDeviceSetting = null;
    private int mAlgorithAngle = 270;
    private boolean isAttached = false;
    private boolean isPaused = false;
    private int cameraFrameCount = 0;
    private int tgFrameCount = 0;
    private boolean isFirstFrame = true;
    private PreviewData mPreviewData = new PreviewData();

    @Override // com.alipay.zoloz.toyger.face.ToygerFaceCallback, com.alipay.zoloz.toyger.ToygerCallback
    public boolean onComplete(int i, byte[] bArr, byte[] bArr2, boolean z) {
        return false;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSuccess() {
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSurfaceDestroyed() {
    }

    @Override // com.alipay.zoloz.toyger.ToygerCallback
    public /* bridge */ /* synthetic */ boolean onStateUpdated(ToygerFaceState toygerFaceState, ToygerFaceAttr toygerFaceAttr, Map map) {
        return onStateUpdated2(toygerFaceState, toygerFaceAttr, (Map<String, Object>) map);
    }

    public ZFaceBasePresenter(ZFaceCallback zFaceCallback, String str, AbsSurfaceView absSurfaceView) {
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        BioAppDescription bioAppDescription = ((BioAppManager) currentInstance.getBioService(BioAppManager.class)).getBioAppDescription(str);
        this.mBioAppDescription = bioAppDescription;
        if (bioAppDescription != null) {
            try {
                FaceRemoteConfig faceRemoteConfig = (FaceRemoteConfig) JSON.parseObject(bioAppDescription.getCfg(), FaceRemoteConfig.class);
                this.mRemoteConfig = faceRemoteConfig;
                backPreviewSetting(faceRemoteConfig);
            } catch (Exception e) {
                e.getMessage();
                this.mRemoteConfig = new FaceRemoteConfig();
            }
            this.view = zFaceCallback;
            this.mAlertManager = new AlertManager(this.mRemoteConfig);
            this.mZFaceRecordService = (ZFaceRecordService) currentInstance.getBioService(ZFaceRecordService.class);
            recordExtEntrySDK();
            this.context = currentInstance.getBioApplicationContext();
            BioUploadService bioUploadService = (BioUploadService) currentInstance.getBioService(BioUploadService.class);
            this.mBioUploadService = bioUploadService;
            bioUploadService.addCallBack(this);
            this.mToygerIspService = (ToygerIspService) currentInstance.getBioService(ToygerIspService.class);
            this.mUploadManager = new UploadManager(currentInstance, this.mToygerFaceService, this.mRemoteConfig, this.mBioAppDescription);
            this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(this.context);
            this.mCameraInterface = absSurfaceView.getCameraInterface();
            initRotation();
            absSurfaceView.setCameraCallback(this);
            ICameraInterface iCameraInterface = this.mCameraInterface;
            if (iCameraInterface != null) {
                iCameraInterface.setCallback(this);
            }
            absSurfaceView.init(this.mRemoteConfig.getDeviceSettings());
            if (this.mCameraInterface != null) {
                ToygerCameraConfig toygerCameraConfig = new ToygerCameraConfig();
                CameraParams cameraParams = this.mCameraInterface.getCameraParams();
                if (cameraParams != null) {
                    toygerCameraConfig.colorIntrin = cameraParams.color_intrin;
                    toygerCameraConfig.depthIntrin = cameraParams.depth_intrin;
                    toygerCameraConfig.color2depthExtrin = cameraParams.extrin;
                    toygerCameraConfig.isAligned = cameraParams.isAligned;
                }
                toygerCameraConfig.roiRect = this.mCameraInterface.getROI();
            }
        }
    }

    private void backPreviewSetting(FaceRemoteConfig faceRemoteConfig) {
        DeviceSetting[] deviceSettings = faceRemoteConfig.getDeviceSettings();
        if (deviceSettings == null || deviceSettings.length == 0) {
            return;
        }
        DeviceSetting deviceSetting = deviceSettings[0];
        if (deviceSetting.getCameraID() == 0) {
            deviceSetting.setCameraPreviewMinSize(600);
            deviceSetting.setCameraPreviewMaxSize(1080);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startToyger() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.zface.presenter.ZFaceBasePresenter.startToyger():void");
    }

    private DeviceSetting[] convert(DeviceSetting[] deviceSettingArr) {
        if (deviceSettingArr == null) {
            return null;
        }
        int length = deviceSettingArr.length;
        DeviceSetting[] deviceSettingArr2 = new DeviceSetting[length];
        for (int i = 0; i < length; i++) {
            DeviceSetting deviceSetting = new DeviceSetting();
            deviceSettingArr2[i] = deviceSetting;
            deviceSetting.setDisplayAuto(deviceSettingArr[i].isDisplayAuto());
            deviceSettingArr2[i].setDisplayAngle(deviceSettingArr[i].getDisplayAngle());
            deviceSettingArr2[i].setAlgorithmAuto(deviceSettingArr[i].isAlgorithmAuto());
            deviceSettingArr2[i].setAlgorithmAngle(deviceSettingArr[i].getAlgorithmAngle());
            deviceSettingArr2[i].setCameraAuto(deviceSettingArr[i].isCameraAuto());
            deviceSettingArr2[i].setCameraID(deviceSettingArr[i].getCameraID());
            deviceSettingArr2[i].setMaxApiLevel(deviceSettingArr[i].getMaxApiLevel());
            deviceSettingArr2[i].setMinApiLevel(deviceSettingArr[i].getMinApiLevel());
        }
        return deviceSettingArr2;
    }

    private void initRotation() {
        DeviceSetting[] deviceSettings = this.mRemoteConfig.getDeviceSettings();
        if (deviceSettings != null && deviceSettings.length > 0) {
            this.mDeviceSetting = deviceSettings[0];
        } else {
            this.mDeviceSetting = new DeviceSetting();
        }
        ICameraInterface iCameraInterface = this.mCameraInterface;
        int cameraViewRotation = (360 - (iCameraInterface != null ? iCameraInterface.getCameraViewRotation() : 0)) % AUScreenAdaptTool.WIDTH_BASE;
        if (this.mDeviceSetting.isAlgorithmAuto()) {
            this.mAlgorithAngle = cameraViewRotation;
        } else {
            this.mAlgorithAngle = this.mDeviceSetting.getAlgorithmAngle();
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioUploadCallBack
    public boolean onResponse(BioUploadResult bioUploadResult) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(bioUploadResult.productRetCode);
        hashMap.put("serverReturnCode", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bioUploadResult.productRetCode);
        hashMap.put("code", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(bioUploadResult.productRetCode);
        hashMap.put("productRetCode", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(bioUploadResult.validationRetCode);
        hashMap.put("validationRetCode", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(bioUploadResult.hasNext);
        hashMap.put("hasNext", sb5.toString());
        if (bioUploadResult.extParams != null && !bioUploadResult.extParams.isEmpty()) {
            hashMap.putAll(bioUploadResult.extParams);
        }
        hashMap.put("networkResult", bioUploadResult.productRetCode == 1001 ? "yes" : "no");
        hashMap.put("timecost", String.valueOf(TimeRecord.getInstance().getTimeInterval("uploadStart")));
        if (hashMap.containsKey("avatar")) {
            hashMap.remove("avatar");
        }
        record("uploadEnd", hashMap);
        int i = bioUploadResult.productRetCode;
        if (i == 1001) {
            UploadData uploadData = new UploadData(bioUploadResult);
            if (this.isAttached) {
                this.view.onUploadSuccess(uploadData);
            }
        } else if (i == 2001) {
            AlertData alertData = new AlertData();
            alertData.type = 11;
            alertData.subCode = bioUploadResult.subCode;
            alertData.subMsg = bioUploadResult.subMsg;
            BioFragmentResponse bioFragmentResponse = new BioFragmentResponse();
            bioFragmentResponse.isSucess = false;
            bioFragmentResponse.suggest = bioUploadResult.productRetCode;
            bioFragmentResponse.errorCode = 208;
            bioFragmentResponse.resultMessage = bioUploadResult.subMsg;
            bioFragmentResponse.subCode = bioUploadResult.subCode;
            bioFragmentResponse.subMsg = bioUploadResult.subMsg;
            bioFragmentResponse.ext.put(BioDetector.EXT_KEY_UPLOAD_RESPONSE, JSON.toJSONString(bioUploadResult));
            BioResponse bioResponse = new BioResponse();
            bioResponse.setSuccess(bioFragmentResponse.isSucess);
            bioResponse.setToken(bioFragmentResponse.token);
            bioResponse.subCode = bioFragmentResponse.subCode;
            bioResponse.subMsg = bioFragmentResponse.subMsg;
            bioResponse.setResultMessage(bioFragmentResponse.resultMessage);
            bioResponse.setResult(bioFragmentResponse.errorCode);
            bioResponse.setTag(this.mBioAppDescription.getTag());
            if (bioFragmentResponse.ext != null) {
                bioResponse.setExt(bioFragmentResponse.ext);
            }
            sendResponse(bioResponse);
            if (this.isAttached) {
                this.view.onErrorEvent(alertData);
            }
        } else if (i != 2002) {
            if (i == 3001 || i == 3002) {
                if (this.isAttached) {
                    this.view.onErrorEvent(this.mAlertManager.parseAlertData(1));
                }
            } else if (this.isAttached) {
                AlertData parseAlertData = this.mAlertManager.parseAlertData(2);
                parseAlertData.subCode = bioUploadResult.subCode;
                parseAlertData.subMsg = bioUploadResult.subMsg;
                this.view.onErrorEvent(parseAlertData);
            }
        } else if (this.isAttached) {
            this.view.onErrorEvent(this.mAlertManager.parseAlertData(0));
        }
        return false;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSurfaceCreated() {
        this.mZFaceRecordService.write(ZFaceRecordService.IMAGE_CAPTURE_START);
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSurfaceChanged(double d, double d2) {
        ICameraInterface iCameraInterface = this.mCameraInterface;
        int cameraViewRotation = (360 - (iCameraInterface != null ? iCameraInterface.getCameraViewRotation() : 0)) % AUScreenAdaptTool.WIDTH_BASE;
        this.view.onSurfaceviewInit(d, d2);
        if (this.mDeviceSetting.isAlgorithmAuto()) {
            this.mAlgorithAngle = cameraViewRotation;
        } else {
            this.mAlgorithAngle = this.mDeviceSetting.getAlgorithmAngle();
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onError(int i) {
        AlertData parseAlertData;
        if (i == -1) {
            parseAlertData = this.mAlertManager.parseAlertData(5);
        } else {
            parseAlertData = this.mAlertManager.parseAlertData(4);
        }
        ZFaceCallback zFaceCallback = this.view;
        if (zFaceCallback != null) {
            zFaceCallback.onErrorEvent(parseAlertData);
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onPreviewFrame(CameraData cameraData) {
        ToygerFaceService toygerFaceService;
        if (this.isFirstFrame) {
            if (this.mCameraInterface != null) {
                ToygerCameraConfig toygerCameraConfig = new ToygerCameraConfig();
                CameraParams cameraParams = this.mCameraInterface.getCameraParams();
                if (cameraParams != null) {
                    toygerCameraConfig.colorIntrin = cameraParams.color_intrin;
                    toygerCameraConfig.depthIntrin = cameraParams.depth_intrin;
                    toygerCameraConfig.color2depthExtrin = cameraParams.extrin;
                    toygerCameraConfig.isAligned = cameraParams.isAligned;
                }
                toygerCameraConfig.roiRect = this.mCameraInterface.getROI();
            }
            this.isFirstFrame = false;
        }
        if (!this.isPaused) {
            this.cameraFrameCount++;
        }
        if (!this.mToygerIspService.isInitialized()) {
            this.mToygerIspService.init(cameraData.getColorWidth(), cameraData.getColorHeight(), cameraData.getPreviewWidth(), cameraData.getPreviewHeight(), cameraData.getColorFrameMode());
        }
        try {
            ByteBuffer colorData = cameraData.getColorData();
            if (this.isAttached) {
                this.mPreviewData.rgbData = colorData;
                this.mPreviewData.frameMode = cameraData.getColorFrameMode();
                this.mPreviewData.rotation = this.mAlgorithAngle;
                this.view.onPreviewFrame(this.mPreviewData);
            }
            TGFrame tGFrame = colorData != null ? new TGFrame(colorData, cameraData.getColorWidth(), cameraData.getColorHeight(), this.mAlgorithAngle, cameraData.getColorFrameMode(), 0) : null;
            if (this.isPaused || (toygerFaceService = this.mToygerFaceService) == null || tGFrame == null || !toygerFaceService.processImage(tGFrame)) {
                return;
            }
            onProcessOneImageFinish(tGFrame);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void onProcessOneImageFinish(TGFrame tGFrame) {
        NineshotService nineshotService = this.mNineshotService;
        if (nineshotService != null) {
            nineshotService.shootFrame(tGFrame);
        }
    }

    @Override // com.alipay.zoloz.toyger.face.ToygerFaceCallback
    public boolean onComplete(int i, List<byte[]> list, byte[] bArr, boolean z) {
        if (this.isPaused) {
            return false;
        }
        recordImageCaptureEnd(SummaryActivity.CHECKED);
        pause();
        if (this.isAttached) {
            Tools.runMainLooper(new Runnable() { // from class: com.alipay.zoloz.zface.presenter.ZFaceBasePresenter.1
                {
                    ZFaceBasePresenter.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ZFaceBasePresenter.this.view.onFrameComplete();
                }
            });
        }
        UploadContent uploadContent = new UploadContent(list.get(list.size() - 1), bArr, z);
        HashMap hashMap = new HashMap();
        hashMap.put("bis_action", "live_body_end");
        hashMap.put("timecost", String.valueOf(TimeRecord.getInstance().getTimeInterval(ZFaceRecordService.LIVEBODY_START)));
        record(ZFaceRecordService.LIVEBODY_END, hashMap);
        TimeRecord.getInstance().recordTime("uploadStart");
        HashMap hashMap2 = new HashMap();
        if (this.mHighQualityAttr != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mHighQualityAttr.quality);
            hashMap2.put("faceQuality", sb.toString());
        }
        if (uploadContent.content != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(uploadContent.content.length / 1024.0f);
            hashMap2.put("payload", sb2.toString());
        }
        record("uploadStart", hashMap2);
        this.mUploadContent = uploadContent;
        this.mUploadManager.uploadFaceInfo(uploadContent);
        uploadOtherFaceInfo(list, bArr, z);
        return true;
    }

    private void uploadOtherFaceInfo(List<byte[]> list, byte[] bArr, boolean z) {
        if (list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                this.mUploadManager.uploadOtherFaceInfo(new UploadContent(list.get(i), bArr, z));
            }
        }
        uploadNineshoot();
    }

    private void uploadNineshoot() {
        byte[] content;
        NineshotService nineshotService = this.mNineshotService;
        if (nineshotService == null || !nineshotService.isNeedUpload() || (content = this.mNineshotService.getContent()) == null) {
            return;
        }
        this.mUploadManager.uploadNineShoot(new UploadContent(content, this.mNineshotService.getKey(), this.mNineshotService.isUtf8()));
    }

    public void retryUpload() {
        UploadContent uploadContent = this.mUploadContent;
        if (uploadContent != null) {
            this.mUploadManager.uploadFaceInfo(uploadContent);
        }
    }

    @Override // com.alipay.zoloz.toyger.ToygerCallback
    public boolean onHighQualityFrame(Bitmap bitmap, ToygerFaceAttr toygerFaceAttr) {
        this.mHighQualityAttr = toygerFaceAttr;
        if (this.isAttached) {
            this.view.onFrameQualify(bitmap, toygerFaceAttr);
            return true;
        }
        return true;
    }

    /* renamed from: onStateUpdated */
    public boolean onStateUpdated2(ToygerFaceState toygerFaceState, ToygerFaceAttr toygerFaceAttr, Map<String, Object> map) {
        if (this.isPaused) {
            return false;
        }
        this.tgFrameCount++;
        this.mFpsMonitor.oneFrameUpdate(this.mZFaceRecordService);
        TGFrame tGFrame = (TGFrame) map.remove(ToygerFaceService.KEY_TOYGER_FRAME);
        if (tGFrame != null) {
            this.mToygerIspService.adjustIsp(tGFrame, toygerFaceState, toygerFaceAttr);
        }
        FrameStateData frameStateData = new FrameStateData();
        frameStateData.uiDesState = toygerFaceState.getMessageCode();
        frameStateData.attr = toygerFaceAttr;
        frameStateData.tgFaceState = toygerFaceState;
        frameStateData.extMap = map;
        if (this.isAttached) {
            this.view.onFrameStateUpdate(frameStateData);
        }
        return true;
    }

    @Override // com.alipay.zoloz.toyger.ToygerCallback
    public boolean onEvent(final int i, final Map<String, Object> map) {
        switch (i) {
            case -13:
                String str = (String) map.get("result");
                HashMap hashMap = new HashMap();
                hashMap.put("algoKeys", str);
                record(ZFaceRecordService.FACE_INFO_KEY, hashMap);
                return false;
            case -12:
                String str2 = (String) map.get("result");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("algoDetails", str2);
                record(ZFaceRecordService.FACE_STATUS_CHANGE, hashMap2);
                return false;
            case -11:
            case -10:
                Tools.runMainLooper(new Runnable() { // from class: com.alipay.zoloz.zface.presenter.ZFaceBasePresenter.5
                    {
                        ZFaceBasePresenter.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (ZFaceBasePresenter.this.isAttached) {
                            ZFaceBasePresenter.this.view.onEvent(i, map);
                        }
                    }
                });
                break;
            case -9:
            case -8:
            case -5:
            case 0:
            default:
                return false;
            case -7:
                Object obj = map.get("seed");
                if (obj != null) {
                    Map<String, String> hashMap3 = new HashMap<>();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        hashMap3.put(entry.getKey(), String.valueOf(entry.getValue()));
                    }
                    record(String.valueOf(obj), hashMap3);
                    return false;
                }
                return false;
            case -6:
                StringUtil.map2String(map);
                break;
            case -4:
                Tools.runMainLooper(new Runnable() { // from class: com.alipay.zoloz.zface.presenter.ZFaceBasePresenter.4
                    {
                        ZFaceBasePresenter.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (ZFaceBasePresenter.this.isAttached) {
                            ZFaceBasePresenter.this.view.onErrorEvent(ZFaceBasePresenter.this.mAlertManager.parseAlertData(10));
                        }
                    }
                });
                break;
            case -3:
                recordImageCaptureEnd("false");
                Object obj2 = map.get("data");
                if (obj2 != null) {
                    this.mUploadManager.uploadOtherFaceInfo(new UploadContent((byte[]) obj2, (byte[]) map.get("key"), ((Boolean) map.get("utf8")).booleanValue()));
                }
                Tools.runMainLooper(new Runnable() { // from class: com.alipay.zoloz.zface.presenter.ZFaceBasePresenter.3
                    {
                        ZFaceBasePresenter.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (ZFaceBasePresenter.this.isAttached) {
                            ZFaceBasePresenter.this.view.onErrorEvent(ZFaceBasePresenter.this.mAlertManager.parseAlertData(9));
                        }
                    }
                });
                break;
            case -2:
                Tools.runMainLooper(new Runnable() { // from class: com.alipay.zoloz.zface.presenter.ZFaceBasePresenter.2
                    {
                        ZFaceBasePresenter.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (ZFaceBasePresenter.this.isAttached) {
                            ZFaceBasePresenter.this.view.onErrorEvent(ZFaceBasePresenter.this.mAlertManager.parseAlertData(2));
                        }
                    }
                });
                break;
            case -1:
                break;
            case 1:
                this.mFpsMonitor.initEnd();
                return false;
        }
        return true;
    }

    private void recordImageCaptureEnd(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        StringBuilder sb = new StringBuilder();
        sb.append(this.cameraFrameCount);
        hashMap.put("frameCount", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.tgFrameCount);
        hashMap.put("tgFrameCount", sb2.toString());
        ZFaceRecordService zFaceRecordService = this.mZFaceRecordService;
        if (zFaceRecordService != null) {
            zFaceRecordService.write(ZFaceRecordService.IMAGE_CAPTURE_END, hashMap);
        }
    }

    public void sendResponseWithSubcode(int i, String str, String str2) {
        BioResponse bioResponse = new BioResponse();
        bioResponse.setSuccess(false);
        bioResponse.setResult(i);
        bioResponse.subCode = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = CodeConstants.getMessage(bioResponse.subCode);
        }
        bioResponse.subMsg = str2;
        bioResponse.setResultMessage("");
        sendResponse(bioResponse);
    }

    public void sendResponse(BioResponse bioResponse) {
        uploadNineshoot();
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(bioResponse != null ? Integer.valueOf(bioResponse.getResult()) : "");
        hashMap.put("returncode", sb.toString());
        this.mZFaceRecordService.write(ZFaceRecordService.CALLBACK_VERIFY_SYSTEM, hashMap);
        bioResponse.setTag(this.mBioAppDescription.getTag());
        Intent intent = new Intent(Constant.BIOLOGY_CALLBACK_ACTION);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BIOLOGY_INTENT_ACTION_REV, JSON.toJSONString(bioResponse));
        intent.putExtras(bundle);
        this.mLocalBroadcastManager.sendBroadcast(intent);
        if (this.isAttached) {
            this.view.handleFinish(true);
        }
    }

    public void clearUpload() {
        BioUploadService bioUploadService = this.mBioUploadService;
        if (bioUploadService != null) {
            bioUploadService.clearUp();
        }
    }

    public void attachView() {
        this.isAttached = true;
    }

    public void unAttachView() {
        uploadNineshoot();
        NineshotService nineshotService = this.mNineshotService;
        if (nineshotService != null) {
            nineshotService.release();
            this.mNineshotService = null;
        }
        HashMap hashMap = new HashMap();
        ICameraInterface iCameraInterface = this.mCameraInterface;
        String cameraSN = iCameraInterface == null ? "" : iCameraInterface.getCameraSN();
        ICameraInterface iCameraInterface2 = this.mCameraInterface;
        String firmwareVersion = iCameraInterface2 != null ? iCameraInterface2.getFirmwareVersion() : "";
        hashMap.put("cameraSN", cameraSN);
        hashMap.put("cameraVN", firmwareVersion);
        Map<String, String> addActionNameToLog = addActionNameToLog(hashMap);
        ZFaceRecordService zFaceRecordService = this.mZFaceRecordService;
        if (zFaceRecordService != null) {
            zFaceRecordService.write(ZFaceRecordService.EXIT_SDK, addActionNameToLog);
        }
        this.isAttached = false;
        ToygerFaceService toygerFaceService = this.mToygerFaceService;
        if (toygerFaceService != null) {
            toygerFaceService.reset();
            this.mToygerFaceService.release();
            this.mToygerFaceService = null;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("module", BlobStatic.META_TYPE_FACE);
        record("ztech_exit", hashMap2);
        ICameraInterface iCameraInterface3 = this.mCameraInterface;
        if (iCameraInterface3 != null) {
            iCameraInterface3.releaseCamera();
            this.mCameraInterface = null;
        }
        UploadManager uploadManager = this.mUploadManager;
        if (uploadManager != null) {
            uploadManager.destroy();
            this.mUploadManager = null;
        }
        BioUploadService bioUploadService = this.mBioUploadService;
        if (bioUploadService != null) {
            bioUploadService.clearUp();
            this.mBioUploadService = null;
        }
    }

    public FaceRemoteConfig getFaceRemoteConfig() {
        return this.mRemoteConfig;
    }

    public List<LivenessAction> getLivenessActions() {
        ToygerFaceService toygerFaceService = this.mToygerFaceService;
        if (toygerFaceService != null) {
            return toygerFaceService.getLivenessActions();
        }
        return null;
    }

    public void retry(int i) {
        this.isPaused = false;
        ZFaceRecordService zFaceRecordService = this.mZFaceRecordService;
        if (zFaceRecordService != null) {
            zFaceRecordService.retry();
        }
        ToygerFaceService toygerFaceService = this.mToygerFaceService;
        if (toygerFaceService != null) {
            toygerFaceService.reset();
            this.mToygerFaceService.setRetryTimes(i);
        }
        NineshotService nineshotService = this.mNineshotService;
        if (nineshotService != null) {
            nineshotService.reset();
        }
        record(ZFaceRecordService.DETECT_COND_START, null);
    }

    public void pause() {
        this.isPaused = true;
    }

    public AlertData getAlertData(int i) {
        AlertManager alertManager = this.mAlertManager;
        if (alertManager == null) {
            return null;
        }
        return alertManager.parseAlertData(i);
    }

    private void recordExtEntrySDK() {
        ApSecurityService apSecurityService;
        if (this.mBioAppDescription == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mRemoteConfig.getSceneEnv().getSceneCode());
        hashMap.put("sceneId", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mRemoteConfig.getUi());
        hashMap.put("uiVersion", sb2.toString());
        hashMap.put("verifyId", this.mBioAppDescription.getExtProperty().get(BioDetector.EXT_KEY_VERIFYID));
        String staticApDidToken = ApSecurityService.getStaticApDidToken();
        if (TextUtils.isEmpty(staticApDidToken) && (apSecurityService = (ApSecurityService) BioServiceManager.getCurrentInstance().getBioService(ApSecurityService.class)) != null) {
            staticApDidToken = apSecurityService.getApDidToken();
        }
        hashMap.put("APDIDTOKEN", staticApDidToken);
        hashMap.put("TOKEN_ID", this.mBioAppDescription.getExtProperty().get("TOKEN_ID"));
        hashMap.put("product", "toyger");
        hashMap.put("bioType", "facedetect");
        hashMap.put("networkType", NetworkUtil.getNetworkType(this.context));
        this.mZFaceRecordService.addExtProperties(hashMap);
        this.mZFaceRecordService.write(ZFaceRecordService.ENTRY_SDK, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("module", BlobStatic.META_TYPE_FACE);
        record("ztech_enter", hashMap2);
    }

    public void record(String str, Map<String, String> map) {
        ZFaceRecordService zFaceRecordService = this.mZFaceRecordService;
        if (zFaceRecordService != null) {
            zFaceRecordService.write(str, map);
        }
    }

    public BioAppDescription getBioAppDescription() {
        return this.mBioAppDescription;
    }

    private Map<String, String> addActionNameToLog(Map<String, String> map) {
        if (this.isAttached && !StringUtil.isNullorEmpty(this.view.getCurrentActionName())) {
            map.put("actionName", this.view.getCurrentActionName());
        }
        return map;
    }
}
