package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.zxing.client.android.AmbientLightManager;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.camera.open.OpenCameraInterface;
import com.journeyapps.barcodescanner.Size;
import com.journeyapps.barcodescanner.Util;

/* loaded from: classes3.dex */
public class CameraInstance {
    static final String KClassImpl$Data$declaredNonStaticMembers$2 = "CameraInstance";
    public CameraManager BuiltInFictitiousFunctionClassFactory;
    public Handler DatabaseTableConfigUtil;
    public Handler NetworkUserEntityData$$ExternalSyntheticLambda0;
    public CameraSurface NetworkUserEntityData$$ExternalSyntheticLambda2;
    public CameraThread PlaceComponentResult;
    public DisplayConfiguration getErrorConfigVersion;
    public boolean moveToNextValue = false;
    public boolean MyBillsEntityDataFactory = true;
    public CameraSettings getAuthRequestContext = new CameraSettings();
    public Runnable initRecordTimeStamp = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                InstrumentInjector.log_d(CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2, "Opening camera");
                CameraManager cameraManager = CameraInstance.this.BuiltInFictitiousFunctionClassFactory;
                Camera open = OpenCameraInterface.open(cameraManager.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2);
                cameraManager.KClassImpl$Data$declaredNonStaticMembers$2 = open;
                if (open == null) {
                    throw new RuntimeException("Failed to open camera");
                }
                int cameraId = OpenCameraInterface.getCameraId(cameraManager.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                cameraManager.PlaceComponentResult = cameraInfo;
                Camera.getCameraInfo(cameraId, cameraInfo);
            } catch (Exception e) {
                CameraInstance.MyBillsEntityDataFactory(CameraInstance.this, e);
                InstrumentInjector.log_e(CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2, "Failed to open camera", e);
            }
        }
    };
    public Runnable scheduleImpl = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.2
        /* JADX WARN: Can't wrap try/catch for region: R(13:4|(2:5|6)|(10:(2:9|(2:11|(1:13)(1:14))(1:37))(1:38)|15|(1:17)(1:36)|18|20|21|22|(1:24)(1:31)|25|(2:27|28)(1:30))|39|15|(0)(0)|18|20|21|22|(0)(0)|25|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
        
            r0.BuiltInFictitiousFunctionClassFactory(true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        
            com.fullstory.instrumentation.InstrumentInjector.log_w(com.journeyapps.barcodescanner.camera.CameraManager.getAuthRequestContext, "Camera rejected even safe-mode parameters! No configuration");
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0034 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:5:0x0015, B:17:0x002e, B:19:0x0034, B:21:0x0049, B:20:0x0040), top: B:42:0x0015, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0040 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:5:0x0015, B:17:0x002e, B:19:0x0034, B:21:0x0049, B:20:0x0040), top: B:42:0x0015, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[Catch: Exception -> 0x00c5, TryCatch #2 {Exception -> 0x00c5, blocks: (B:2:0x0000, B:28:0x0076, B:29:0x007d, B:31:0x0089, B:33:0x0099, B:35:0x00a7, B:32:0x008e, B:23:0x0067, B:37:0x00bd, B:38:0x00c4, B:5:0x0015, B:17:0x002e, B:19:0x0034, B:21:0x0049, B:20:0x0040, B:26:0x0072), top: B:44:0x0000, inners: #0, #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008e A[Catch: Exception -> 0x00c5, TryCatch #2 {Exception -> 0x00c5, blocks: (B:2:0x0000, B:28:0x0076, B:29:0x007d, B:31:0x0089, B:33:0x0099, B:35:0x00a7, B:32:0x008e, B:23:0x0067, B:37:0x00bd, B:38:0x00c4, B:5:0x0015, B:17:0x002e, B:19:0x0034, B:21:0x0049, B:20:0x0040, B:26:0x0072), top: B:44:0x0000, inners: #0, #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a7 A[Catch: Exception -> 0x00c5, TryCatch #2 {Exception -> 0x00c5, blocks: (B:2:0x0000, B:28:0x0076, B:29:0x007d, B:31:0x0089, B:33:0x0099, B:35:0x00a7, B:32:0x008e, B:23:0x0067, B:37:0x00bd, B:38:0x00c4, B:5:0x0015, B:17:0x002e, B:19:0x0034, B:21:0x0049, B:20:0x0040, B:26:0x0072), top: B:44:0x0000, inners: #0, #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = com.journeyapps.barcodescanner.camera.CameraInstance.MyBillsEntityDataFactory()     // Catch: java.lang.Exception -> Lc5
                java.lang.String r1 = "Configuring camera"
                com.fullstory.instrumentation.InstrumentInjector.log_d(r0, r1)     // Catch: java.lang.Exception -> Lc5
                com.journeyapps.barcodescanner.camera.CameraInstance r0 = com.journeyapps.barcodescanner.camera.CameraInstance.this     // Catch: java.lang.Exception -> Lc5
                com.journeyapps.barcodescanner.camera.CameraManager r0 = com.journeyapps.barcodescanner.camera.CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2(r0)     // Catch: java.lang.Exception -> Lc5
                android.hardware.Camera r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Lc5
                if (r1 == 0) goto Lbd
                r1 = 1
                r2 = 0
                com.journeyapps.barcodescanner.camera.DisplayConfiguration r3 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L67
                int r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L67
                if (r3 == 0) goto L2d
                if (r3 == r1) goto L2a
                r4 = 2
                if (r3 == r4) goto L27
                r4 = 3
                if (r3 == r4) goto L24
                goto L2d
            L24:
                r3 = 270(0x10e, float:3.78E-43)
                goto L2e
            L27:
                r3 = 180(0xb4, float:2.52E-43)
                goto L2e
            L2a:
                r3 = 90
                goto L2e
            L2d:
                r3 = 0
            L2e:
                android.hardware.Camera$CameraInfo r4 = r0.PlaceComponentResult     // Catch: java.lang.Exception -> L67
                int r4 = r4.facing     // Catch: java.lang.Exception -> L67
                if (r4 != r1) goto L40
                android.hardware.Camera$CameraInfo r4 = r0.PlaceComponentResult     // Catch: java.lang.Exception -> L67
                int r4 = r4.orientation     // Catch: java.lang.Exception -> L67
                int r4 = r4 + r3
                int r4 = r4 % 360
                int r3 = 360 - r4
                int r3 = r3 % 360
                goto L49
            L40:
                android.hardware.Camera$CameraInfo r4 = r0.PlaceComponentResult     // Catch: java.lang.Exception -> L67
                int r4 = r4.orientation     // Catch: java.lang.Exception -> L67
                int r4 = r4 - r3
                int r4 = r4 + 360
                int r3 = r4 % 360
            L49:
                java.lang.String r4 = com.journeyapps.barcodescanner.camera.CameraManager.getAuthRequestContext     // Catch: java.lang.Exception -> L67
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L67
                r5.<init>()     // Catch: java.lang.Exception -> L67
                java.lang.String r6 = "Camera Display Orientation: "
                r5.append(r6)     // Catch: java.lang.Exception -> L67
                r5.append(r3)     // Catch: java.lang.Exception -> L67
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L67
                com.fullstory.instrumentation.InstrumentInjector.log_i(r4, r5)     // Catch: java.lang.Exception -> L67
                r0.initRecordTimeStamp = r3     // Catch: java.lang.Exception -> L67
                android.hardware.Camera r4 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L67
                r4.setDisplayOrientation(r3)     // Catch: java.lang.Exception -> L67
                goto L6e
            L67:
                java.lang.String r3 = com.journeyapps.barcodescanner.camera.CameraManager.getAuthRequestContext     // Catch: java.lang.Exception -> Lc5
                java.lang.String r4 = "Failed to set rotation."
                com.fullstory.instrumentation.InstrumentInjector.log_w(r3, r4)     // Catch: java.lang.Exception -> Lc5
            L6e:
                r0.BuiltInFictitiousFunctionClassFactory(r2)     // Catch: java.lang.Exception -> L72
                goto L7d
            L72:
                r0.BuiltInFictitiousFunctionClassFactory(r1)     // Catch: java.lang.Exception -> L76
                goto L7d
            L76:
                java.lang.String r1 = com.journeyapps.barcodescanner.camera.CameraManager.getAuthRequestContext     // Catch: java.lang.Exception -> Lc5
                java.lang.String r2 = "Camera rejected even safe-mode parameters! No configuration"
                com.fullstory.instrumentation.InstrumentInjector.log_w(r1, r2)     // Catch: java.lang.Exception -> Lc5
            L7d:
                android.hardware.Camera r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Lc5
                android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch: java.lang.Exception -> Lc5
                android.hardware.Camera$Size r1 = r1.getPreviewSize()     // Catch: java.lang.Exception -> Lc5
                if (r1 != 0) goto L8e
                com.journeyapps.barcodescanner.Size r1 = r0.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> Lc5
                r0.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> Lc5
                goto L99
            L8e:
                com.journeyapps.barcodescanner.Size r2 = new com.journeyapps.barcodescanner.Size     // Catch: java.lang.Exception -> Lc5
                int r3 = r1.width     // Catch: java.lang.Exception -> Lc5
                int r1 = r1.height     // Catch: java.lang.Exception -> Lc5
                r2.<init>(r3, r1)     // Catch: java.lang.Exception -> Lc5
                r0.getErrorConfigVersion = r2     // Catch: java.lang.Exception -> Lc5
            L99:
                com.journeyapps.barcodescanner.camera.CameraManager$CameraPreviewCallback r1 = r0.lookAheadTest     // Catch: java.lang.Exception -> Lc5
                com.journeyapps.barcodescanner.Size r0 = r0.getErrorConfigVersion     // Catch: java.lang.Exception -> Lc5
                r1.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> Lc5
                com.journeyapps.barcodescanner.camera.CameraInstance r0 = com.journeyapps.barcodescanner.camera.CameraInstance.this     // Catch: java.lang.Exception -> Lc5
                android.os.Handler r0 = com.journeyapps.barcodescanner.camera.CameraInstance.getAuthRequestContext(r0)     // Catch: java.lang.Exception -> Lc5
                if (r0 == 0) goto Ld4
                com.journeyapps.barcodescanner.camera.CameraInstance r0 = com.journeyapps.barcodescanner.camera.CameraInstance.this     // Catch: java.lang.Exception -> Lc5
                android.os.Handler r0 = com.journeyapps.barcodescanner.camera.CameraInstance.getAuthRequestContext(r0)     // Catch: java.lang.Exception -> Lc5
                int r1 = com.google.zxing.client.android.R.id.zxing_prewiew_size_ready     // Catch: java.lang.Exception -> Lc5
                com.journeyapps.barcodescanner.camera.CameraInstance r2 = com.journeyapps.barcodescanner.camera.CameraInstance.this     // Catch: java.lang.Exception -> Lc5
                com.journeyapps.barcodescanner.Size r2 = com.journeyapps.barcodescanner.camera.CameraInstance.MyBillsEntityDataFactory(r2)     // Catch: java.lang.Exception -> Lc5
                android.os.Message r0 = r0.obtainMessage(r1, r2)     // Catch: java.lang.Exception -> Lc5
                r0.sendToTarget()     // Catch: java.lang.Exception -> Lc5
                return
            Lbd:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> Lc5
                java.lang.String r1 = "Camera not open"
                r0.<init>(r1)     // Catch: java.lang.Exception -> Lc5
                throw r0     // Catch: java.lang.Exception -> Lc5
            Lc5:
                r0 = move-exception
                com.journeyapps.barcodescanner.camera.CameraInstance r1 = com.journeyapps.barcodescanner.camera.CameraInstance.this
                com.journeyapps.barcodescanner.camera.CameraInstance.MyBillsEntityDataFactory(r1, r0)
                java.lang.String r1 = com.journeyapps.barcodescanner.camera.CameraInstance.MyBillsEntityDataFactory()
                java.lang.String r2 = "Failed to configure camera"
                com.fullstory.instrumentation.InstrumentInjector.log_e(r1, r2, r0)
            Ld4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.journeyapps.barcodescanner.camera.CameraInstance.AnonymousClass2.run():void");
        }
    };
    public Runnable GetContactSyncConfig = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                InstrumentInjector.log_d(CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2, "Starting preview");
                CameraManager cameraManager = CameraInstance.this.BuiltInFictitiousFunctionClassFactory;
                CameraSurface cameraSurface = CameraInstance.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                Camera camera = cameraManager.KClassImpl$Data$declaredNonStaticMembers$2;
                SurfaceHolder surfaceHolder = cameraSurface.KClassImpl$Data$declaredNonStaticMembers$2;
                if (surfaceHolder != null) {
                    camera.setPreviewDisplay(surfaceHolder);
                } else {
                    camera.setPreviewTexture(cameraSurface.MyBillsEntityDataFactory);
                }
                CameraManager cameraManager2 = CameraInstance.this.BuiltInFictitiousFunctionClassFactory;
                Camera camera2 = cameraManager2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (camera2 == null || cameraManager2.moveToNextValue) {
                    return;
                }
                camera2.startPreview();
                cameraManager2.moveToNextValue = true;
                cameraManager2.BuiltInFictitiousFunctionClassFactory = new AutoFocusManager(cameraManager2.KClassImpl$Data$declaredNonStaticMembers$2, cameraManager2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                AmbientLightManager ambientLightManager = new AmbientLightManager(cameraManager2.scheduleImpl, cameraManager2, cameraManager2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                cameraManager2.MyBillsEntityDataFactory = ambientLightManager;
                ambientLightManager.start();
            } catch (Exception e) {
                CameraInstance.MyBillsEntityDataFactory(CameraInstance.this, e);
                InstrumentInjector.log_e(CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2, "Failed to start preview", e);
            }
        }
    };
    public Runnable lookAheadTest = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.4
        @Override // java.lang.Runnable
        public void run() {
            try {
                InstrumentInjector.log_d(CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2, "Closing camera");
                CameraManager cameraManager = CameraInstance.this.BuiltInFictitiousFunctionClassFactory;
                AutoFocusManager autoFocusManager = cameraManager.BuiltInFictitiousFunctionClassFactory;
                if (autoFocusManager != null) {
                    autoFocusManager.getAuthRequestContext();
                    cameraManager.BuiltInFictitiousFunctionClassFactory = null;
                }
                AmbientLightManager ambientLightManager = cameraManager.MyBillsEntityDataFactory;
                if (ambientLightManager != null) {
                    ambientLightManager.stop();
                    cameraManager.MyBillsEntityDataFactory = null;
                }
                Camera camera = cameraManager.KClassImpl$Data$declaredNonStaticMembers$2;
                if (camera != null && cameraManager.moveToNextValue) {
                    camera.stopPreview();
                    cameraManager.lookAheadTest.getAuthRequestContext = null;
                    cameraManager.moveToNextValue = false;
                }
                CameraManager cameraManager2 = CameraInstance.this.BuiltInFictitiousFunctionClassFactory;
                Camera camera2 = cameraManager2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (camera2 != null) {
                    camera2.release();
                    cameraManager2.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                }
            } catch (Exception e) {
                InstrumentInjector.log_e(CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2, "Failed to close camera", e);
            }
            CameraInstance.PlaceComponentResult(CameraInstance.this);
            CameraInstance.this.DatabaseTableConfigUtil.sendEmptyMessage(R.id.zxing_camera_closed);
            CameraThread cameraThread = CameraInstance.this.PlaceComponentResult;
            synchronized (cameraThread.getAuthRequestContext) {
                int i = cameraThread.PlaceComponentResult - 1;
                cameraThread.PlaceComponentResult = i;
                if (i == 0) {
                    synchronized (cameraThread.getAuthRequestContext) {
                        cameraThread.MyBillsEntityDataFactory.quit();
                        cameraThread.MyBillsEntityDataFactory = null;
                        cameraThread.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    }
                }
            }
        }
    };

    static /* synthetic */ boolean PlaceComponentResult(CameraInstance cameraInstance) {
        cameraInstance.MyBillsEntityDataFactory = true;
        return true;
    }

    public CameraInstance(Context context) {
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        this.PlaceComponentResult = CameraThread.getAuthRequestContext();
        CameraManager cameraManager = new CameraManager(context);
        this.BuiltInFictitiousFunctionClassFactory = cameraManager;
        cameraManager.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.getAuthRequestContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Handler();
    }

    public final void BuiltInFictitiousFunctionClassFactory(final boolean z) {
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        if (this.moveToNextValue) {
            CameraThread cameraThread = this.PlaceComponentResult;
            Runnable runnable = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CameraInstance cameraInstance = CameraInstance.this;
                    cameraInstance.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(z);
                }
            };
            synchronized (cameraThread.getAuthRequestContext) {
                cameraThread.KClassImpl$Data$declaredNonStaticMembers$2();
                cameraThread.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    static /* synthetic */ void MyBillsEntityDataFactory(CameraInstance cameraInstance, Exception exc) {
        Handler handler = cameraInstance.DatabaseTableConfigUtil;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    static /* synthetic */ Size MyBillsEntityDataFactory(CameraInstance cameraInstance) {
        CameraManager cameraManager = cameraInstance.BuiltInFictitiousFunctionClassFactory;
        if (cameraManager.getErrorConfigVersion == null) {
            return null;
        }
        if (cameraManager.MyBillsEntityDataFactory()) {
            Size size = cameraManager.getErrorConfigVersion;
            return new Size(size.KClassImpl$Data$declaredNonStaticMembers$2, size.MyBillsEntityDataFactory);
        }
        return cameraManager.getErrorConfigVersion;
    }
}
