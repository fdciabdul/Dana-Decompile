package com.otaliastudios.cameraview.frame;

import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
public class Frame {
    private static final CameraLogger getErrorConfigVersion = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("Frame");
    public final Class<?> MyBillsEntityDataFactory;
    private final FrameManager scheduleImpl;
    Object getAuthRequestContext = null;
    public long moveToNextValue = -1;
    long PlaceComponentResult = -1;
    int BuiltInFictitiousFunctionClassFactory = 0;
    Size lookAheadTest = null;
    int KClassImpl$Data$declaredNonStaticMembers$2 = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Frame(FrameManager frameManager) {
        this.scheduleImpl = frameManager;
        this.MyBillsEntityDataFactory = frameManager.PlaceComponentResult;
    }

    private boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext != null;
    }

    public final void getAuthRequestContext() {
        if (MyBillsEntityDataFactory()) {
            return;
        }
        getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(3, "Frame is dead! time:", Long.valueOf(this.moveToNextValue), "lastTime:", Long.valueOf(this.PlaceComponentResult));
        throw new RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
    }

    public boolean equals(Object obj) {
        return (obj instanceof Frame) && ((Frame) obj).moveToNextValue == this.moveToNextValue;
    }

    public final void PlaceComponentResult() {
        if (MyBillsEntityDataFactory()) {
            getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(0, "Frame with time", Long.valueOf(this.moveToNextValue), "is being released.");
            Object obj = this.getAuthRequestContext;
            this.getAuthRequestContext = null;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.moveToNextValue = -1L;
            this.lookAheadTest = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.scheduleImpl.MyBillsEntityDataFactory(this, obj);
        }
    }
}
