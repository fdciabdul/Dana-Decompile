package com.alibaba.griver.device.jsapi.sensor;

import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.BridgeUtils;
import com.alibaba.griver.device.R;
import com.alipay.mobile.security.bio.api.BioDetector;

/* loaded from: classes2.dex */
public class DeviceOrientationBridgeExtension implements SensorEventListener, BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f6519a;
    private float[] b;
    private float[] c;
    private boolean d = false;
    private App e;
    private long f;
    private long g;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse startDeviceMotionListening(@BindingNode(App.class) App app, @BindingParam(stringDefault = "ui", value = {"interval"}) String str, @BindingParam({"monitorInterval"}) int i) {
        this.e = app;
        if (!BridgeUtils.contextIsValid(null)) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        Application applicationContext = GriverEnv.getApplicationContext();
        if (this.f6519a == null) {
            return new BridgeResponse.Error(1001, applicationContext.getString(R.string.griver_system_not_support_ability));
        }
        if (this.d) {
            return BridgeResponse.SUCCESS;
        }
        this.d = true;
        int i2 = 3;
        if (TextUtils.equals(str, "normal")) {
            this.g = 200L;
        } else if (TextUtils.equals(str, "game")) {
            this.g = 20L;
            i2 = 1;
        } else if (TextUtils.equals(str, BioDetector.EXT_KEY_UI)) {
            this.g = 60L;
            i2 = 2;
        }
        if (i > 0) {
            this.g = i;
        }
        Sensor defaultSensor = this.f6519a.getDefaultSensor(1);
        Sensor defaultSensor2 = this.f6519a.getDefaultSensor(2);
        this.f6519a.registerListener(this, defaultSensor, i2);
        this.f6519a.registerListener(this, defaultSensor2, i2);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse stopDeviceMotionListening() {
        if (!BridgeUtils.contextIsValid(null)) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        Application applicationContext = GriverEnv.getApplicationContext();
        SensorManager sensorManager = this.f6519a;
        if (sensorManager == null) {
            return new BridgeResponse.Error(1001, applicationContext.getString(R.string.griver_system_not_support_ability));
        }
        this.g = 0L;
        if (this.d) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = this.f6519a.getDefaultSensor(2);
            this.f6519a.unregisterListener(this, defaultSensor);
            this.f6519a.unregisterListener(this, defaultSensor2);
            this.d = false;
            return new BridgeResponse.NamedValue("success", Boolean.TRUE);
        }
        return new BridgeResponse.Error(10000, applicationContext.getString(R.string.griver_listen_orientation_not_enable));
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService != null) {
            this.f6519a = (SensorManager) rVEnvironmentService.getApplicationContext().getSystemService("sensor");
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.e = null;
        SensorManager sensorManager = this.f6519a;
        if (sensorManager != null && this.d) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = this.f6519a.getDefaultSensor(2);
            this.f6519a.unregisterListener(this, defaultSensor);
            this.f6519a.unregisterListener(this, defaultSensor2);
            this.d = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        if (sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
            this.b = sensorEvent.values;
        } else if (sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
            this.c = sensorEvent.values;
        }
        float[] fArr2 = this.b;
        if (fArr2 == null || (fArr = this.c) == null) {
            return;
        }
        float[] fArr3 = new float[3];
        float[] fArr4 = new float[9];
        SensorManager.getRotationMatrix(fArr4, null, fArr2, fArr);
        SensorManager.getOrientation(fArr4, fArr3);
        double d = fArr3[0];
        float f = fArr3[1];
        float f2 = fArr3[2];
        if (System.currentTimeMillis() - this.f < this.g) {
            return;
        }
        this.f = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        Double.isNaN(d);
        jSONObject.put("alpha", (Object) Double.valueOf(d + 3.141592653589793d));
        jSONObject.put("beta", (Object) Float.valueOf(f));
        jSONObject.put("gamma", (Object) Float.valueOf(f2));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        App app = this.e;
        if (app != null) {
            EngineUtils.sendToRender(app.getActivePage().getRender(), "deviceMotionChange", jSONObject2, null);
        }
    }
}
