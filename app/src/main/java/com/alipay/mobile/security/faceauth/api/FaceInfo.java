package com.alipay.mobile.security.faceauth.api;

import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes7.dex */
public class FaceInfo {
    public float eyeLeftOcclussion;
    public float eyeRightOcclussion;
    public Rect faceSize;
    public boolean hasFace;
    public float mouthOcclussion;
    public RectF position;
    public float yaw = 0.0f;
    public float pitch = 0.0f;
    public float gaussianBlur = 0.0f;
    public float motionBlur = 0.0f;
    public float brightness = 0.0f;
    public float wearGlass = 0.0f;
    public float faceQuality = 0.0f;
    public float leftEyeHWRatio = 0.0f;
    public float rightEyeHWRatio = 0.0f;
    public float mouthHWRatio = 0.0f;
    public float integrity = 0.0f;
    public boolean pitch3d = false;
    public boolean notVideo = false;
    public boolean mouthOpen = false;
    public boolean eyeBlink = false;
    public float smoothYaw = 0.0f;
    public float smoothPitch = 0.0f;
    public float eyeLeftDet = 0.0f;
    public float eyeRightDet = 0.0f;
    public float mouthDet = 0.0f;
    public float smoothQuality = 0.0f;
}
