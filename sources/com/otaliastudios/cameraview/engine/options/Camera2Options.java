package com.otaliastudios.cameraview.engine.options;

import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.mappers.Camera2Mapper;
import com.otaliastudios.cameraview.internal.utils.CamcorderProfiles;
import com.otaliastudios.cameraview.size.AspectRatio;

/* loaded from: classes8.dex */
public class Camera2Options extends CameraOptions {
    public Camera2Options(CameraManager cameraManager, String str, boolean z, int i) throws CameraAccessException {
        Camera2Mapper.getAuthRequestContext();
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String str2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str2).get(CameraCharacteristics.LENS_FACING);
            if (num != null) {
                Facing facing = (Facing) Camera2Mapper.getAuthRequestContext(Camera2Mapper.BuiltInFictitiousFunctionClassFactory, Integer.valueOf(num.intValue()));
                if (facing != null) {
                    this.getErrorConfigVersion.add(facing);
                }
            }
        }
        for (int i2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            WhiteBalance whiteBalance = (WhiteBalance) Camera2Mapper.getAuthRequestContext(Camera2Mapper.MyBillsEntityDataFactory, Integer.valueOf(i2));
            if (whiteBalance != null) {
                this.isLayoutRequested.add(whiteBalance);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(Flash.OFF);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool != null && bool.booleanValue()) {
            for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAll(Camera2Mapper.BuiltInFictitiousFunctionClassFactory(i3));
            }
        }
        this.scheduleImpl.add(Hdr.OFF);
        for (int i4 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            Hdr hdr = (Hdr) Camera2Mapper.getAuthRequestContext(Camera2Mapper.getAuthRequestContext, Integer.valueOf(i4));
            if (hdr != null) {
                this.scheduleImpl.add(hdr);
            }
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        boolean z2 = true;
        if (f != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = f.floatValue() > 1.0f;
        }
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.BuiltInFictitiousFunctionClassFactory = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (range != null && rational != null && rational.floatValue() != 0.0f) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ((Integer) range.getLower()).intValue() / rational.floatValue();
            this.MyBillsEntityDataFactory = ((Integer) range.getUpper()).intValue() / rational.floatValue();
        }
        this.getAuthRequestContext = (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0.0f || this.MyBillsEntityDataFactory == 0.0f) ? false : true;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
        }
        int[] outputFormats = streamConfigurationMap.getOutputFormats();
        int length = outputFormats.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z2 = false;
                break;
            } else if (outputFormats[i5] == i) {
                break;
            } else {
                i5++;
            }
        }
        if (!z2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Picture format not supported: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        for (Size size : streamConfigurationMap.getOutputSizes(i)) {
            int height = z ? size.getHeight() : size.getWidth();
            int width = z ? size.getWidth() : size.getHeight();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(new com.otaliastudios.cameraview.size.Size(height, width));
            this.DatabaseTableConfigUtil.add(AspectRatio.BuiltInFictitiousFunctionClassFactory(height, width));
        }
        CamcorderProfile MyBillsEntityDataFactory = CamcorderProfiles.MyBillsEntityDataFactory(str, new com.otaliastudios.cameraview.size.Size(Integer.MAX_VALUE, Integer.MAX_VALUE));
        com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(MyBillsEntityDataFactory.videoFrameWidth, MyBillsEntityDataFactory.videoFrameHeight);
        for (Size size3 : streamConfigurationMap.getOutputSizes(MediaRecorder.class)) {
            if (size3.getWidth() <= size2.BuiltInFictitiousFunctionClassFactory && size3.getHeight() <= size2.getAuthRequestContext) {
                int height2 = z ? size3.getHeight() : size3.getWidth();
                int width2 = z ? size3.getWidth() : size3.getHeight();
                this.GetContactSyncConfig.add(new com.otaliastudios.cameraview.size.Size(height2, width2));
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(AspectRatio.BuiltInFictitiousFunctionClassFactory(height2, width2));
            }
        }
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            this.lookAheadTest = Float.MAX_VALUE;
            this.PlaceComponentResult = -3.4028235E38f;
            for (Range range2 : rangeArr) {
                this.lookAheadTest = Math.min(this.lookAheadTest, ((Integer) range2.getLower()).intValue());
                this.PlaceComponentResult = Math.max(this.PlaceComponentResult, ((Integer) range2.getUpper()).intValue());
            }
        } else {
            this.lookAheadTest = 0.0f;
            this.PlaceComponentResult = 0.0f;
        }
        this.initRecordTimeStamp.add(PictureFormat.JPEG);
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i6 : iArr) {
                if (i6 == 3) {
                    this.initRecordTimeStamp.add(PictureFormat.DNG);
                }
            }
        }
        this.moveToNextValue.add(35);
        for (int i7 : streamConfigurationMap.getOutputFormats()) {
            if (ImageFormat.getBitsPerPixel(i7) > 0) {
                this.moveToNextValue.add(Integer.valueOf(i7));
            }
        }
    }
}
