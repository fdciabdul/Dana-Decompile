package com.akamai.botman;

import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.util.Observable;

/* loaded from: classes3.dex */
final class m extends Observable implements SensorEventListener {
    private Sensor BuiltInFictitiousFunctionClassFactory;
    private SensorManager MyBillsEntityDataFactory;
    private Sensor PlaceComponentResult;
    private Sensor getAuthRequestContext;
    private HandlerThread moveToNextValue;
    private boolean lookAheadTest = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    private boolean getErrorConfigVersion = false;
    private boolean scheduleImpl = false;
    private boolean GetContactSyncConfig = false;
    boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private long NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private float[] DatabaseTableConfigUtil = new float[3];
    private float[] initRecordTimeStamp = new float[3];

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Application application) {
        try {
            this.MyBillsEntityDataFactory = (SensorManager) application.getSystemService("sensor");
        } catch (NullPointerException e) {
            ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception on getting sensor service", e);
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
        }
    }

    public final boolean getAuthRequestContext() throws Exception {
        this.BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getDefaultSensor(1);
        this.PlaceComponentResult = this.MyBillsEntityDataFactory.getDefaultSensor(2);
        HandlerThread handlerThread = new HandlerThread("CYFOrientationListener");
        this.moveToNextValue = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.moveToNextValue.getLooper());
        this.lookAheadTest = this.MyBillsEntityDataFactory.registerListener(this, this.BuiltInFictitiousFunctionClassFactory, 3, handler);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.MyBillsEntityDataFactory.registerListener(this, this.PlaceComponentResult, 3, handler);
        if (Build.VERSION.SDK_INT >= 9) {
            Sensor defaultSensor = this.MyBillsEntityDataFactory.getDefaultSensor(9);
            this.getAuthRequestContext = defaultSensor;
            this.getErrorConfigVersion = this.MyBillsEntityDataFactory.registerListener(this, defaultSensor, 3, handler);
        }
        if (this.getErrorConfigVersion) {
            this.MyBillsEntityDataFactory.unregisterListener(this, this.BuiltInFictitiousFunctionClassFactory);
            this.lookAheadTest = false;
            d.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
        } else {
            d.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = SystemClock.uptimeMillis();
        if ((this.lookAheadTest || this.getErrorConfigVersion) && this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return true;
        }
        ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Failed to register orientation listener", new Throwable[0]);
        PlaceComponentResult();
        return false;
    }

    public final void PlaceComponentResult() throws Exception {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.MyBillsEntityDataFactory.unregisterListener(this, this.PlaceComponentResult);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }
        if (this.getErrorConfigVersion) {
            this.MyBillsEntityDataFactory.unregisterListener(this, this.getAuthRequestContext);
            this.getErrorConfigVersion = false;
        }
        if (this.lookAheadTest) {
            this.MyBillsEntityDataFactory.unregisterListener(this, this.BuiltInFictitiousFunctionClassFactory);
            this.lookAheadTest = false;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        HandlerThread handlerThread = this.moveToNextValue;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            this.moveToNextValue.quitSafely();
        } else {
            this.moveToNextValue.quit();
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2 && sensorEvent.accuracy == 0) {
                ah.MyBillsEntityDataFactory("OrientationListener", "Unreliable orientation sensor data...", new Throwable[0]);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 9) {
                this.DatabaseTableConfigUtil = (float[]) sensorEvent.values.clone();
                this.scheduleImpl = true;
            } else if (type == 1) {
                this.DatabaseTableConfigUtil = (float[]) sensorEvent.values.clone();
                this.scheduleImpl = true;
            } else if (type == 2) {
                this.initRecordTimeStamp = (float[]) sensorEvent.values.clone();
                this.GetContactSyncConfig = true;
            }
            if (this.scheduleImpl && this.GetContactSyncConfig) {
                long j = sensorEvent.timestamp;
                if (uptimeMillis - this.NetworkUserEntityData$$ExternalSyntheticLambda1 >= 100 || d.BuiltInFictitiousFunctionClassFactory == 1) {
                    boolean z = d.BuiltInFictitiousFunctionClassFactory != 0;
                    d.BuiltInFictitiousFunctionClassFactory = 0;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = uptimeMillis;
                    setChanged();
                    notifyObservers(new l(this.DatabaseTableConfigUtil, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda1, z ? 2 : 1));
                    this.scheduleImpl = false;
                    this.GetContactSyncConfig = false;
                }
            }
        } catch (Exception e) {
            ah.MyBillsEntityDataFactory("OrientationListener", "Exception in processing orientation event", e);
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
        }
    }
}
