package com.otaliastudios.cameraview.engine.options;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.mappers.Camera1Mapper;
import com.otaliastudios.cameraview.internal.utils.CamcorderProfiles;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class Camera1Options extends CameraOptions {
    public Camera1Options(Camera.Parameters parameters, int i, boolean z) {
        Camera1Mapper.PlaceComponentResult();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            Facing facing = (Facing) Camera1Mapper.MyBillsEntityDataFactory(Camera1Mapper.BuiltInFictitiousFunctionClassFactory, Integer.valueOf(cameraInfo.facing));
            if (facing != null) {
                this.getErrorConfigVersion.add(facing);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            Iterator<String> it = supportedWhiteBalance.iterator();
            while (it.hasNext()) {
                WhiteBalance whiteBalance = (WhiteBalance) Camera1Mapper.MyBillsEntityDataFactory(Camera1Mapper.getAuthRequestContext, it.next());
                if (whiteBalance != null) {
                    this.isLayoutRequested.add(whiteBalance);
                }
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(Flash.OFF);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            Iterator<String> it2 = supportedFlashModes.iterator();
            while (it2.hasNext()) {
                Flash flash = (Flash) Camera1Mapper.MyBillsEntityDataFactory(Camera1Mapper.PlaceComponentResult, it2.next());
                if (flash != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(flash);
                }
            }
        }
        this.scheduleImpl.add(Hdr.OFF);
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            Iterator<String> it3 = supportedSceneModes.iterator();
            while (it3.hasNext()) {
                Hdr hdr = (Hdr) Camera1Mapper.MyBillsEntityDataFactory(Camera1Mapper.KClassImpl$Data$declaredNonStaticMembers$2, it3.next());
                if (hdr != null) {
                    this.scheduleImpl.add(hdr);
                }
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = parameters.isZoomSupported();
        this.BuiltInFictitiousFunctionClassFactory = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parameters.getMinExposureCompensation() * exposureCompensationStep;
        this.MyBillsEntityDataFactory = parameters.getMaxExposureCompensation() * exposureCompensationStep;
        this.getAuthRequestContext = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera.Size size : parameters.getSupportedPictureSizes()) {
            int i3 = z ? size.height : size.width;
            int i4 = z ? size.width : size.height;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(new Size(i3, i4));
            this.DatabaseTableConfigUtil.add(AspectRatio.BuiltInFictitiousFunctionClassFactory(i3, i4));
        }
        CamcorderProfile KClassImpl$Data$declaredNonStaticMembers$2 = CamcorderProfiles.KClassImpl$Data$declaredNonStaticMembers$2(i, new Size(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Size size2 = new Size(KClassImpl$Data$declaredNonStaticMembers$2.videoFrameWidth, KClassImpl$Data$declaredNonStaticMembers$2.videoFrameHeight);
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera.Size size3 : supportedVideoSizes) {
                if (size3.width <= size2.BuiltInFictitiousFunctionClassFactory && size3.height <= size2.getAuthRequestContext) {
                    int i5 = z ? size3.height : size3.width;
                    int i6 = z ? size3.width : size3.height;
                    this.GetContactSyncConfig.add(new Size(i5, i6));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(AspectRatio.BuiltInFictitiousFunctionClassFactory(i5, i6));
                }
            }
        } else {
            for (Camera.Size size4 : parameters.getSupportedPreviewSizes()) {
                if (size4.width <= size2.BuiltInFictitiousFunctionClassFactory && size4.height <= size2.getAuthRequestContext) {
                    int i7 = z ? size4.height : size4.width;
                    int i8 = z ? size4.width : size4.height;
                    this.GetContactSyncConfig.add(new Size(i7, i8));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(AspectRatio.BuiltInFictitiousFunctionClassFactory(i7, i8));
                }
            }
        }
        this.lookAheadTest = Float.MAX_VALUE;
        this.PlaceComponentResult = -3.4028235E38f;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            float f = iArr[0] / 1000.0f;
            this.lookAheadTest = Math.min(this.lookAheadTest, f);
            this.PlaceComponentResult = Math.max(this.PlaceComponentResult, iArr[1] / 1000.0f);
        }
        this.initRecordTimeStamp.add(PictureFormat.JPEG);
        this.moveToNextValue.add(17);
    }
}
