package com.alipay.zoloz.zface.presenter;

import com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView;
import com.alipay.zoloz.zface.beans.AlertData;
import com.alipay.zoloz.zface.beans.FaceRemoteConfig;
import java.util.Map;

/* loaded from: classes7.dex */
public class ZFacePresenter extends ZFaceBasePresenter {
    public ZFacePresenter(ZFaceCallback zFaceCallback, String str, AbsSurfaceView absSurfaceView) {
        super(zFaceCallback, str, absSurfaceView);
        attachView();
    }

    public void stopProcess() {
        super.pause();
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceBasePresenter
    public AlertData getAlertData(int i) {
        return super.getAlertData(i);
    }

    public FaceRemoteConfig getRemoteConfig() {
        return super.getFaceRemoteConfig();
    }

    public void release() {
        unAttachView();
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceBasePresenter
    public void record(String str, Map<String, String> map) {
        super.record(str, map);
    }
}
