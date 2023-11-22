package com.akamai.botman;

import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.HandlerThread;
import java.util.Observable;

/* loaded from: classes3.dex */
final class i extends Observable implements SensorEventListener {
    HandlerThread BuiltInFictitiousFunctionClassFactory;
    Sensor KClassImpl$Data$declaredNonStaticMembers$2;
    SensorManager MyBillsEntityDataFactory;
    Sensor PlaceComponentResult;
    long getAuthRequestContext = 0;
    boolean moveToNextValue = false;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    boolean getErrorConfigVersion = false;
    boolean lookAheadTest = false;
    boolean scheduleImpl = false;
    private float GetContactSyncConfig = -1.0f;
    private float initRecordTimeStamp = -1.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2 = -1.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda8 = -1.0f;
    private float PrepareContext = -1.0f;
    private float isLayoutRequested = -1.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7 = -1.0f;
    private float newProxyInstance = -1.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda6 = -1.0f;
    float DatabaseTableConfigUtil = 0.0f;
    private final float[] NetworkUserEntityData$$ExternalSyntheticLambda5 = {0.0f, 0.0f, 0.0f};
    int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public i(Application application) {
        try {
            this.MyBillsEntityDataFactory = (SensorManager) application.getSystemService("sensor");
        } catch (Exception e) {
            ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception on getting sensor service", e);
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
        }
    }

    public final void PlaceComponentResult() throws Exception {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.MyBillsEntityDataFactory.unregisterListener(this, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }
        if (this.moveToNextValue) {
            this.MyBillsEntityDataFactory.unregisterListener(this, this.PlaceComponentResult);
            this.moveToNextValue = false;
        }
        this.scheduleImpl = false;
        HandlerThread handlerThread = this.BuiltInFictitiousFunctionClassFactory;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            this.BuiltInFictitiousFunctionClassFactory.quitSafely();
        } else {
            this.BuiltInFictitiousFunctionClassFactory.quit();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v17 com.akamai.botman.k, still in use, count: 2, list:
          (r10v17 com.akamai.botman.k) from 0x0163: MOVE (r0v25 com.akamai.botman.k) = (r10v17 com.akamai.botman.k)
          (r10v17 com.akamai.botman.k) from 0x015f: MOVE (r0v32 com.akamai.botman.k) = (r10v17 com.akamai.botman.k)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:81)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:441)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:95)
        */
    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(android.hardware.SensorEvent r24) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.i.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
