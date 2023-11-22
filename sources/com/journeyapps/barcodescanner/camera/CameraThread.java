package com.journeyapps.barcodescanner.camera;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes3.dex */
public class CameraThread {
    private static CameraThread BuiltInFictitiousFunctionClassFactory;
    public Handler KClassImpl$Data$declaredNonStaticMembers$2;
    HandlerThread MyBillsEntityDataFactory;
    public int PlaceComponentResult = 0;
    public final Object getAuthRequestContext = new Object();

    public static CameraThread getAuthRequestContext() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new CameraThread();
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private CameraThread() {
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.getAuthRequestContext) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                if (this.PlaceComponentResult <= 0) {
                    throw new IllegalStateException("CameraThread is not open");
                }
                HandlerThread handlerThread = new HandlerThread("CameraThread");
                this.MyBillsEntityDataFactory = handlerThread;
                handlerThread.start();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new Handler(this.MyBillsEntityDataFactory.getLooper());
            }
        }
    }
}
