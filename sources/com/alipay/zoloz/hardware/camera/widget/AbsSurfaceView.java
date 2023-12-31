package com.alipay.zoloz.hardware.camera.widget;

import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;
import com.alipay.zoloz.hardware.camera.ICameraCallback;
import com.alipay.zoloz.hardware.camera.ICameraInterface;

/* loaded from: classes7.dex */
public interface AbsSurfaceView {
    ICameraInterface getCameraInterface();

    void init(DeviceSetting[] deviceSettingArr);

    void setCameraCallback(ICameraCallback iCameraCallback);
}
