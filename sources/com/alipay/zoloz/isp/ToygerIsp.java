package com.alipay.zoloz.isp;

import android.graphics.Rect;
import com.alipay.streammedia.devicesengine.DevicesNativeEngineApi;
import com.alipay.streammedia.devicesengine.camera.FaceRectParams;
import com.alipay.streammedia.devicesengine.camera.ImageParams;
import com.alipay.streammedia.devicesengine.camera.IspAdjustResult;
import com.fullstory.instrumentation.InstrumentInjector;
import tv.danmaku.ijk.media.player.IjkLibLoader;

/* loaded from: classes7.dex */
public class ToygerIsp {
    private static final String TAG = "ToygerIsp";
    private DevicesNativeEngineApi mEngineApi;

    static {
        try {
            DevicesNativeEngineApi.loadLibrariesOnce((IjkLibLoader) null);
        } catch (Throwable th) {
            InstrumentInjector.log_w(TAG, th);
        }
    }

    public void init(int i, int i2, int i3, int i4, int i5, float[] fArr, float[][][] fArr2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.mEngineApi = new DevicesNativeEngineApi();
            ImageParams imageParams = new ImageParams();
            imageParams.orgWidth = i;
            imageParams.orgHeight = i2;
            imageParams.dispWidth = i3;
            imageParams.dispHeight = i4;
            this.mEngineApi.ispCreate(imageParams, fArr, fArr2, convert(i5));
        } catch (Throwable th) {
            InstrumentInjector.log_w(TAG, th);
            this.mEngineApi = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ToygerIsp.init(): mEngineApi=");
        sb.append(this.mEngineApi);
        sb.append(", cost ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ms.");
        InstrumentInjector.log_e(TAG, sb.toString());
    }

    private DevicesNativeEngineApi.ImageType convert(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return DevicesNativeEngineApi.ImageType.RGB_24;
                        }
                        return DevicesNativeEngineApi.ImageType.NV21;
                    }
                    return DevicesNativeEngineApi.ImageType.RGBA;
                }
                return DevicesNativeEngineApi.ImageType.BGR_24;
            }
            return DevicesNativeEngineApi.ImageType.BGR_24;
        }
        return DevicesNativeEngineApi.ImageType.NV21;
    }

    public IspResult adjustIsp(byte[] bArr, short[] sArr, Rect rect, long j, int i) {
        IspResult ispResult;
        if (this.mEngineApi != null) {
            try {
                FaceRectParams faceRectParams = new FaceRectParams();
                faceRectParams.setX(rect.left);
                faceRectParams.setY(rect.top);
                faceRectParams.setWidth(rect.right - rect.left);
                faceRectParams.setHeight(rect.bottom - rect.top);
                IspAdjustResult ispAdjust = this.mEngineApi.ispAdjust(bArr, sArr, faceRectParams, j, i);
                ispResult = new IspResult(ispAdjust.needSet, ispAdjust.exposureTime, ispAdjust.ISO);
            } catch (Throwable th) {
                InstrumentInjector.log_w(TAG, th);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ToygerIsp.adjustIsp(), ispResult=");
            sb.append(ispResult);
            InstrumentInjector.log_i(TAG, sb.toString());
            return ispResult;
        }
        ispResult = null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ToygerIsp.adjustIsp(), ispResult=");
        sb2.append(ispResult);
        InstrumentInjector.log_i(TAG, sb2.toString());
        return ispResult;
    }

    public void release() {
        DevicesNativeEngineApi devicesNativeEngineApi = this.mEngineApi;
        if (devicesNativeEngineApi != null) {
            try {
                devicesNativeEngineApi.ispDestory();
            } catch (Throwable th) {
                InstrumentInjector.log_w(TAG, th);
            }
        }
    }
}
