package com.alibaba.griver.image.capture.meta;

import android.graphics.Rect;
import android.hardware.Camera;
import java.util.Map;

/* loaded from: classes6.dex */
public class CameraParams {
    public static final String FLASH_MODE_AUTO = "auto";
    public static final String FLASH_MODE_OFF = "off";
    public static final String FLASH_MODE_ON = "on";
    public static final int REC_TYPE_DEFAULT = 0;
    public static final int REC_TYPE_FALCON_LOOKS = 2;
    public static final int REC_TYPE_LIVE = 1;
    public static final int REC_TYPE_OMX_VIDEO = 3;
    private Camera.Size c;
    public Map<String, String> exif;
    public int recordType = 0;
    public boolean bZoomEnable = true;
    public boolean mIgnoreOrientation = false;
    public boolean mLandscapeVideo = false;
    public boolean autoRotateTakenPicture = true;
    public int mMode = 0;
    public Rect mCropRect = null;
    public Rect mSrcRect = null;
    public int mActivityRotation = -1;
    public boolean audioPermissionDelay = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f6564a = false;
    private boolean b = false;
    private boolean d = true;
    private String e = "";
    private boolean f = true;
    private boolean g = false;

    public boolean isEnableEventBus() {
        return this.g;
    }

    public String getFlashMode() {
        return this.e;
    }

    public void enableBeauty(boolean z) {
        this.f6564a = z;
    }

    public boolean isDefaultCameraFront() {
        return this.b;
    }

    public void setDefaultCameraFront(boolean z) {
        this.b = z;
    }

    public Camera.Size getPictureSize() {
        return this.c;
    }

    public boolean isConvertPicture() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CameraParams{, mBeautyEnable=");
        sb.append(this.f6564a);
        sb.append(", bZoomEnable=");
        sb.append(this.bZoomEnable);
        sb.append(", mDefaultCameraFront=");
        sb.append(this.b);
        sb.append(", mPictureSize=");
        sb.append(this.c);
        sb.append(", mConvertPicture=");
        sb.append(this.d);
        sb.append(", mIgnoreOrientation=");
        sb.append(this.mIgnoreOrientation);
        sb.append(", mLandscapeVideo=");
        sb.append(this.mLandscapeVideo);
        sb.append(", exif=");
        sb.append(this.exif);
        sb.append(", autoRotateTakenPicture=");
        sb.append(this.autoRotateTakenPicture);
        sb.append(", mActivityRotation=");
        sb.append(this.mActivityRotation);
        sb.append(",eEBus = ");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
