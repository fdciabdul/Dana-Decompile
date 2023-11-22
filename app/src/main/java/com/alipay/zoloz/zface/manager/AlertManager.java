package com.alipay.zoloz.zface.manager;

import com.alipay.mobile.security.bio.config.bean.AlertConfig;
import com.alipay.mobile.security.bio.config.bean.FaceTips;
import com.alipay.mobile.security.bio.constants.ZcodeConstants;
import com.alipay.zoloz.zface.beans.AlertData;
import com.alipay.zoloz.zface.beans.FaceRemoteConfig;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;

/* loaded from: classes7.dex */
public class AlertManager {
    public static final int ALERT_TYPE_CAMERA_NO_DEVICE = 3;
    public static final int ALERT_TYPE_CAMERA_OPEN_FAIL = 4;
    public static final int ALERT_TYPE_CAMERA_STREAM_ERROR = 5;
    public static final int ALERT_TYPE_INIT_TOYGER_FAIL = 10;
    public static final int ALERT_TYPE_LIVENESS_ERROR = 9;
    public static final int ALERT_TYPE_NET_ERROR = 1;
    public static final int ALERT_TYPE_RECO_OVER_TIME = 8;
    public static final int ALERT_TYPE_RECO_TIME_OUT = 7;
    public static final int ALERT_TYPE_SERVER_FAIL = 11;
    public static final int ALERT_TYPE_SERVER_RETRY = 0;
    public static final int ALERT_TYPE_SYSTEM_ERROR = 2;
    public static final int ALERT_TYPE_USER_BACK = 6;
    private FaceTips faceTips;

    public AlertManager(FaceRemoteConfig faceRemoteConfig) {
        if (faceRemoteConfig != null) {
            this.faceTips = faceRemoteConfig.getFaceTips();
        }
    }

    public AlertData parseAlertData(int i) {
        AlertConfig failNoRetryAlert;
        AlertConfig cameraNoPermissionAlert;
        AlertData alertData = new AlertData();
        switch (i) {
            case 0:
                failNoRetryAlert = this.faceTips.getFailNoRetryAlert();
                alertData.subCode = ZcodeConstants.ZCODE_RETRY_ALERT;
                alertData.scene = "serverFail";
                break;
            case 1:
                failNoRetryAlert = this.faceTips.getNetworkErrorAlert();
                alertData.subCode = ZcodeConstants.ZCODE_NETWORK_ERROR;
                alertData.scene = "networkFail";
                break;
            case 2:
            default:
                failNoRetryAlert = this.faceTips.getSystemErrorAlert();
                alertData.subCode = ZcodeConstants.ZCODE_SYSTEM_EXC;
                alertData.scene = "systemErr";
                break;
            case 3:
                cameraNoPermissionAlert = this.faceTips.getCameraNoPermissionAlert();
                alertData.subCode = ZcodeConstants.ZCODE_ERROR_CAMERA_NO_DEVICE;
                alertData.scene = "cameraInitError";
                failNoRetryAlert = cameraNoPermissionAlert;
                break;
            case 4:
                cameraNoPermissionAlert = this.faceTips.getCameraNoPermissionAlert();
                alertData.subCode = ZcodeConstants.ZCODE_ERROR_CAMERA_OPEN_FAILED;
                alertData.scene = "cameraInitError";
                failNoRetryAlert = cameraNoPermissionAlert;
                break;
            case 5:
                cameraNoPermissionAlert = this.faceTips.getCameraNoPermissionAlert();
                alertData.subCode = ZcodeConstants.ZCODE_ERROR_CAMERA_STREAM_ERROR;
                alertData.scene = "cameraInitError";
                failNoRetryAlert = cameraNoPermissionAlert;
                break;
            case 6:
                failNoRetryAlert = this.faceTips.getExitAlert();
                alertData.subCode = ZcodeConstants.ZCODE_USER_BACK;
                alertData.scene = "clickXback";
                break;
            case 7:
                failNoRetryAlert = this.faceTips.getTimeoutAlert();
                alertData.subCode = ZcodeConstants.ZCODE_OVER_TIME;
                alertData.scene = TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT;
                break;
            case 8:
                failNoRetryAlert = this.faceTips.getLimitAlert();
                alertData.subCode = ZcodeConstants.ZCODE_OUT_TIME;
                alertData.scene = "retryOverMax";
                break;
            case 9:
                failNoRetryAlert = this.faceTips.getFailAlert();
                alertData.subCode = ZcodeConstants.ZCODE_LIVENESS_ERROR;
                alertData.scene = "livnessFail";
                break;
            case 10:
                failNoRetryAlert = this.faceTips.getSystemErrorAlert();
                alertData.subCode = ZcodeConstants.ZCODE_INIT_TOYGER_ERROR;
                alertData.scene = "loadAlgorithmErr";
                break;
        }
        alertData.subMsg = ZcodeConstants.getMessage(alertData.subCode);
        alertData.type = i;
        alertData.title = failNoRetryAlert.getTitle();
        alertData.subTitle = failNoRetryAlert.getMessage();
        alertData.leftBtnText = failNoRetryAlert.getLeftButtonText();
        alertData.rightBtnText = failNoRetryAlert.getRightButtonText();
        alertData.errorCode = failNoRetryAlert.getReturnCode();
        return alertData;
    }
}
