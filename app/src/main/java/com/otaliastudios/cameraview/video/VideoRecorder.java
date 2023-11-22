package com.otaliastudios.cameraview.video;

import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.VideoResult;

/* loaded from: classes8.dex */
public abstract class VideoRecorder {
    private static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("VideoRecorder");
    private final VideoResultListener BuiltInFictitiousFunctionClassFactory;
    protected Exception lookAheadTest;
    VideoResult.Stub scheduleImpl;
    private final Object PlaceComponentResult = new Object();
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

    /* loaded from: classes8.dex */
    public interface VideoResultListener {
        void PlaceComponentResult(VideoResult.Stub stub, Exception exc);

        void SummaryVoucherView$$ExternalSyntheticLambda2();

        void isLayoutRequested();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BuiltInFictitiousFunctionClassFactory() {
    }

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2();

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoRecorder(VideoResultListener videoResultListener) {
        this.BuiltInFictitiousFunctionClassFactory = videoResultListener;
    }

    public final void PlaceComponentResult(VideoResult.Stub stub) {
        synchronized (this.PlaceComponentResult) {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i != 0) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "start:", "called twice, or while stopping! Ignoring. state:", Integer.valueOf(i));
                return;
            }
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "start:", "Changed state to STATE_RECORDING");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            this.scheduleImpl = stub;
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final void MyBillsEntityDataFactory(boolean z) {
        synchronized (this.PlaceComponentResult) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "stop:", "called twice, or called before start! Ignoring. isCameraShutdown:", Boolean.valueOf(z));
                return;
            }
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "stop:", "Changed state to STATE_STOPPING");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
            KClassImpl$Data$declaredNonStaticMembers$2(z);
        }
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        boolean z;
        synchronized (this.PlaceComponentResult) {
            z = this.KClassImpl$Data$declaredNonStaticMembers$2 != 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void PlaceComponentResult() {
        synchronized (this.PlaceComponentResult) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                CameraLogger cameraLogger = MyBillsEntityDataFactory;
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchResult:", "Changed state to STATE_IDLE.");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                BuiltInFictitiousFunctionClassFactory();
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchResult:", "About to dispatch result:", this.scheduleImpl, this.lookAheadTest);
                VideoResultListener videoResultListener = this.BuiltInFictitiousFunctionClassFactory;
                if (videoResultListener != null) {
                    videoResultListener.PlaceComponentResult(this.scheduleImpl, this.lookAheadTest);
                }
                this.scheduleImpl = null;
                this.lookAheadTest = null;
                return;
            }
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, "dispatchResult:", "Called, but not recording! Aborting.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void scheduleImpl() {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchVideoRecordingStart:", "About to dispatch.");
        VideoResultListener videoResultListener = this.BuiltInFictitiousFunctionClassFactory;
        if (videoResultListener != null) {
            videoResultListener.SummaryVoucherView$$ExternalSyntheticLambda2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext() {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchVideoRecordingEnd:", "About to dispatch.");
        VideoResultListener videoResultListener = this.BuiltInFictitiousFunctionClassFactory;
        if (videoResultListener != null) {
            videoResultListener.isLayoutRequested();
        }
    }
}
