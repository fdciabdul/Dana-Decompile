package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import com.alibaba.griver.image.capture.meta.CameraParams;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.zxing.client.android.AmbientLightManager;
import com.journeyapps.barcodescanner.Size;
import com.journeyapps.barcodescanner.SourceData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class CameraManager {
    static final String getAuthRequestContext = "CameraManager";
    AutoFocusManager BuiltInFictitiousFunctionClassFactory;
    private String GetContactSyncConfig;
    Camera KClassImpl$Data$declaredNonStaticMembers$2;
    AmbientLightManager MyBillsEntityDataFactory;
    public DisplayConfiguration NetworkUserEntityData$$ExternalSyntheticLambda0;
    Size NetworkUserEntityData$$ExternalSyntheticLambda2;
    Camera.CameraInfo PlaceComponentResult;
    Size getErrorConfigVersion;
    boolean moveToNextValue;
    Context scheduleImpl;
    public CameraSettings NetworkUserEntityData$$ExternalSyntheticLambda1 = new CameraSettings();
    int initRecordTimeStamp = -1;
    final CameraPreviewCallback lookAheadTest = new CameraPreviewCallback();

    /* loaded from: classes3.dex */
    final class CameraPreviewCallback implements Camera.PreviewCallback {
        Size MyBillsEntityDataFactory;
        PreviewCallback getAuthRequestContext;

        public CameraPreviewCallback() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            Size size = this.MyBillsEntityDataFactory;
            PreviewCallback previewCallback = this.getAuthRequestContext;
            if (size == null || previewCallback == null) {
                InstrumentInjector.log_d(CameraManager.getAuthRequestContext, "Got preview callback, but no handler or resolution available");
                if (previewCallback != null) {
                    previewCallback.MyBillsEntityDataFactory();
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                SourceData sourceData = new SourceData(bArr, size.MyBillsEntityDataFactory, size.KClassImpl$Data$declaredNonStaticMembers$2, camera.getParameters().getPreviewFormat(), CameraManager.this.initRecordTimeStamp);
                if (CameraManager.this.PlaceComponentResult.facing == 1) {
                    sourceData.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
                previewCallback.PlaceComponentResult(sourceData);
            } catch (RuntimeException e) {
                InstrumentInjector.log_e(CameraManager.getAuthRequestContext, "Camera preview failed", e);
                previewCallback.MyBillsEntityDataFactory();
            }
        }
    }

    public CameraManager(Context context) {
        this.scheduleImpl = context;
    }

    public final boolean MyBillsEntityDataFactory() {
        int i = this.initRecordTimeStamp;
        if (i != -1) {
            return i % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public final void PlaceComponentResult(boolean z) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            try {
                if (z != getAuthRequestContext()) {
                    AutoFocusManager autoFocusManager = this.BuiltInFictitiousFunctionClassFactory;
                    if (autoFocusManager != null) {
                        autoFocusManager.getAuthRequestContext();
                    }
                    Camera.Parameters parameters = this.KClassImpl$Data$declaredNonStaticMembers$2.getParameters();
                    CameraConfigurationUtils.MyBillsEntityDataFactory(parameters, z);
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext()) {
                        CameraConfigurationUtils.PlaceComponentResult(parameters, z);
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2.setParameters(parameters);
                    AutoFocusManager autoFocusManager2 = this.BuiltInFictitiousFunctionClassFactory;
                    if (autoFocusManager2 != null) {
                        autoFocusManager2.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            } catch (RuntimeException e) {
                InstrumentInjector.log_e(getAuthRequestContext, "Failed to set torch", e);
            }
        }
    }

    private boolean getAuthRequestContext() {
        String flashMode;
        Camera.Parameters parameters = this.KClassImpl$Data$declaredNonStaticMembers$2.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return CameraParams.FLASH_MODE_ON.equals(flashMode) || "torch".equals(flashMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        Camera.Parameters parameters = this.KClassImpl$Data$declaredNonStaticMembers$2.getParameters();
        String str = this.GetContactSyncConfig;
        if (str == null) {
            this.GetContactSyncConfig = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        if (parameters == null) {
            InstrumentInjector.log_w(getAuthRequestContext, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str2 = getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append("Initial camera parameters: ");
        sb.append(parameters.flatten());
        InstrumentInjector.log_i(str2, sb.toString());
        if (z) {
            InstrumentInjector.log_w(str2, "In camera config safe mode -- most settings will not be honored");
        }
        CameraConfigurationUtils.getAuthRequestContext(parameters, this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory, z);
        if (!z) {
            CameraConfigurationUtils.MyBillsEntityDataFactory(parameters, false);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest()) {
                CameraConfigurationUtils.MyBillsEntityDataFactory(parameters);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult()) {
                CameraConfigurationUtils.BuiltInFictitiousFunctionClassFactory(parameters);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory() && Build.VERSION.SDK_INT >= 15) {
                CameraConfigurationUtils.NetworkUserEntityData$$ExternalSyntheticLambda0(parameters);
                CameraConfigurationUtils.KClassImpl$Data$declaredNonStaticMembers$2(parameters);
                CameraConfigurationUtils.getAuthRequestContext(parameters);
            }
        }
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new Size(previewSize.width, previewSize.height);
                arrayList.add(new Size(previewSize.width, previewSize.height));
            }
        } else {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new Size(size.width, size.height));
            }
        }
        Size size2 = null;
        if (arrayList.size() == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        } else {
            DisplayConfiguration displayConfiguration = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            Size size3 = displayConfiguration.BuiltInFictitiousFunctionClassFactory;
            if (size3 != null) {
                size2 = MyBillsEntityDataFactory ? new Size(size3.KClassImpl$Data$declaredNonStaticMembers$2, size3.MyBillsEntityDataFactory) : size3;
            }
            Size KClassImpl$Data$declaredNonStaticMembers$2 = displayConfiguration.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, size2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = KClassImpl$Data$declaredNonStaticMembers$2;
            parameters.setPreviewSize(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (Build.DEVICE.equals("glass-1")) {
            CameraConfigurationUtils.PlaceComponentResult(parameters);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Final camera parameters: ");
        sb2.append(parameters.flatten());
        InstrumentInjector.log_i(str2, sb2.toString());
        this.KClassImpl$Data$declaredNonStaticMembers$2.setParameters(parameters);
    }
}
