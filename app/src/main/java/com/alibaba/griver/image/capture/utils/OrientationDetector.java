package com.alibaba.griver.image.capture.utils;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class OrientationDetector {

    /* renamed from: a  reason: collision with root package name */
    private static OrientationDetector f6565a;
    private static int b;
    private int c = 0;
    private OrientationListener d;

    /* loaded from: classes6.dex */
    interface OrientationListener {
        boolean isAvailable();

        void register();

        void unregister();
    }

    private OrientationDetector(Context context) {
        this.d = null;
        try {
            if (!isTablet(context)) {
                MySensorEventListener mySensorEventListener = new MySensorEventListener(context);
                this.d = mySensorEventListener;
                if (mySensorEventListener.isAvailable()) {
                    return;
                }
                RVLogger.d("OrientationDetector", "MySensorEventListener not available.");
                this.d = new MyOrientationEventListener(context);
                return;
            }
            this.d = new MyTabOrientationListener(context);
        } catch (Exception e) {
            RVLogger.e("OrientationDetector", "OrientationDetector constrcuction exception:", e);
        }
    }

    public static OrientationDetector getInstance(Context context) {
        if (context instanceof Activity) {
            b = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        }
        Context applicationContext = context.getApplicationContext();
        if (f6565a == null) {
            synchronized (OrientationDetector.class) {
                if (f6565a == null) {
                    f6565a = new OrientationDetector(applicationContext);
                }
            }
        }
        return f6565a;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    public void register() {
        OrientationListener orientationListener = this.d;
        if (orientationListener != null) {
            orientationListener.register();
        }
    }

    public void unregister() {
        OrientationListener orientationListener = this.d;
        if (orientationListener != null) {
            orientationListener.unregister();
        }
    }

    public int getDevOrientation() {
        StringBuilder sb = new StringBuilder();
        sb.append("getDevOrientation:");
        sb.append(this.c);
        RVLogger.d("OrientationDetector", sb.toString());
        return this.c;
    }

    /* loaded from: classes6.dex */
    class MyOrientationEventListener extends OrientationEventListener implements OrientationListener {
        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public boolean isAvailable() {
            return true;
        }

        public MyOrientationEventListener(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int i2;
            if (i != -1) {
                if (i > 340 || i < 20) {
                    i2 = 0;
                } else if (i > 70 && i < 110) {
                    i2 = 90;
                } else if (i > 160 && i < 200) {
                    i2 = 180;
                } else if (i <= 250 || i >= 290) {
                    return;
                } else {
                    i2 = 270;
                }
                if (i2 != OrientationDetector.this.c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("old phone onOrientationChanged:");
                    sb.append(i2);
                    RVLogger.d("OrientationDetector", sb.toString());
                }
                OrientationDetector.this.c = i2;
                return;
            }
            RVLogger.d("OrientationDetector", "ORIENTATION_UNKNOWN");
        }

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public void register() {
            enable();
        }

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public void unregister() {
            disable();
        }
    }

    /* loaded from: classes6.dex */
    class MySensorEventListener implements OrientationListener {

        /* renamed from: a  reason: collision with root package name */
        private Sensor f6566a;
        private Sensor b;
        private SensorManager e;
        private float[] c = new float[3];
        private float[] d = new float[3];
        final SensorEventListener mEventListener = new SensorEventListener() { // from class: com.alibaba.griver.image.capture.utils.OrientationDetector.MySensorEventListener.1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == 2) {
                    MySensorEventListener.this.d = sensorEvent.values;
                }
                if (sensorEvent.sensor.getType() == 1) {
                    MySensorEventListener.this.c = sensorEvent.values;
                }
                MySensorEventListener.this.a();
            }
        };

        public MySensorEventListener(Context context) {
            SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
            this.e = sensorManager;
            this.f6566a = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor = this.e.getDefaultSensor(2);
            this.b = defaultSensor;
            if (this.f6566a == null || defaultSensor == null) {
                RVLogger.e("OrientationDetector", "get mMSensor or mASensor failed!");
            }
            RVLogger.d("OrientationDetector", "MySensorEventListener constructed.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            float[] fArr = new float[9];
            SensorManager.getRotationMatrix(fArr, null, this.c, this.d);
            SensorManager.getOrientation(fArr, new float[3]);
            float degrees = (float) Math.toDegrees(r0[1]);
            float degrees2 = (float) Math.toDegrees(r0[2]);
            int i = OrientationDetector.this.c;
            if (degrees < -30.0f && degrees > -150.0f) {
                i = 0;
            } else if (degrees > 30.0f && degrees < 150.0f) {
                i = 180;
            } else if (degrees2 > 30.0f) {
                i = 90;
            } else if (degrees2 < -30.0f) {
                i = 270;
            }
            if (i != OrientationDetector.this.c) {
                StringBuilder sb = new StringBuilder();
                sb.append("phone orientation changed to ");
                sb.append(i);
                RVLogger.d("OrientationDetector", sb.toString());
            }
            OrientationDetector.this.c = i;
        }

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public void register() {
            if (!this.e.registerListener(this.mEventListener, this.f6566a, 3)) {
                RVLogger.e("OrientationDetector", "registerListener mASensor failed!");
            }
            if (this.e.registerListener(this.mEventListener, this.b, 3)) {
                return;
            }
            RVLogger.e("OrientationDetector", "registerListener mMSensor failed!");
        }

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public void unregister() {
            try {
                if (this.f6566a == null || this.b == null) {
                    return;
                }
                this.e.unregisterListener(this.mEventListener);
                RVLogger.d("OrientationDetector", "OrientationDetector unregister.");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("unregister exp=");
                sb.append(e.toString());
                RVLogger.d("OrientationDetector", sb.toString());
            }
        }

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public boolean isAvailable() {
            return (this.f6566a == null || this.b == null) ? false : true;
        }
    }

    /* loaded from: classes6.dex */
    class MyTabOrientationListener implements OrientationListener {

        /* renamed from: a  reason: collision with root package name */
        private Sensor f6567a;
        private SensorManager c;
        private float[] b = new float[3];
        final SensorEventListener mEventListener = new SensorEventListener() { // from class: com.alibaba.griver.image.capture.utils.OrientationDetector.MyTabOrientationListener.1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == 3) {
                    MyTabOrientationListener.this.b = sensorEvent.values;
                    MyTabOrientationListener.this.a();
                }
            }
        };

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public boolean isAvailable() {
            return true;
        }

        public MyTabOrientationListener(Context context) {
            SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
            this.c = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(3);
            this.f6567a = defaultSensor;
            if (defaultSensor == null) {
                RVLogger.e("OrientationDetector", "get mSensor failed!");
            }
            RVLogger.d("OrientationDetector", "MyTabOrientationListener constructed.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            float f;
            float[] fArr = this.b;
            float f2 = fArr[1];
            float f3 = fArr[2];
            int i = OrientationDetector.b;
            if (i != 0) {
                if (i == 1) {
                    float[] fArr2 = this.b;
                    f2 = fArr2[2];
                    f = fArr2[1];
                } else if (i == 2) {
                    float[] fArr3 = this.b;
                    f2 = -fArr3[2];
                    f = fArr3[1];
                } else if (i == 3) {
                    float[] fArr4 = this.b;
                    f2 = -fArr4[2];
                    f3 = fArr4[1];
                }
                f3 = -f;
            } else {
                float[] fArr5 = this.b;
                f2 = fArr5[1];
                f3 = fArr5[2];
            }
            int i2 = OrientationDetector.this.c;
            if (f2 > 30.0f) {
                i2 = 0;
            } else if (f2 < -30.0f) {
                i2 = 180;
            } else if (f3 < -30.0f) {
                i2 = 270;
            } else if (f3 > 30.0f) {
                i2 = 90;
            }
            if (i2 != OrientationDetector.this.c) {
                StringBuilder sb = new StringBuilder();
                sb.append("tablet orientation changed to ");
                sb.append(i2);
                RVLogger.d("OrientationDetector", sb.toString());
            }
            OrientationDetector.this.c = i2;
        }

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public void register() {
            if (this.c.registerListener(this.mEventListener, this.f6567a, 3)) {
                return;
            }
            RVLogger.e("OrientationDetector", "registerListener mSensor failed!");
        }

        @Override // com.alibaba.griver.image.capture.utils.OrientationDetector.OrientationListener
        public void unregister() {
            if (this.f6567a != null) {
                this.c.unregisterListener(this.mEventListener);
                RVLogger.d("OrientationDetector", "OrientationDetector unregister.");
            }
        }
    }
}
