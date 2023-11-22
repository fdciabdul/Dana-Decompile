package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import com.alibaba.griver.image.capture.meta.CameraParams;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.fullstory.instrumentation.InstrumentInjector;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import id.dana.cashier.view.InputCardNumberView;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class CameraConfigurationUtils {
    private static final Pattern getAuthRequestContext = Pattern.compile(";");

    private CameraConfigurationUtils() {
    }

    public static void getAuthRequestContext(Camera.Parameters parameters, CameraSettings.FocusMode focusMode, boolean z) {
        String authRequestContext;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (z || focusMode == CameraSettings.FocusMode.AUTO) {
            authRequestContext = getAuthRequestContext("focus mode", supportedFocusModes, "auto");
        } else if (focusMode == CameraSettings.FocusMode.CONTINUOUS) {
            authRequestContext = getAuthRequestContext("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
        } else if (focusMode == CameraSettings.FocusMode.INFINITY) {
            authRequestContext = getAuthRequestContext("focus mode", supportedFocusModes, "infinity");
        } else {
            authRequestContext = focusMode == CameraSettings.FocusMode.MACRO ? getAuthRequestContext("focus mode", supportedFocusModes, "macro") : null;
        }
        if (!z && authRequestContext == null) {
            authRequestContext = getAuthRequestContext("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (authRequestContext != null) {
            if (authRequestContext.equals(parameters.getFocusMode())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Focus mode already set to ");
                sb.append(authRequestContext);
                InstrumentInjector.log_i("CameraConfiguration", sb.toString());
                return;
            }
            parameters.setFocusMode(authRequestContext);
        }
    }

    public static void MyBillsEntityDataFactory(Camera.Parameters parameters, boolean z) {
        String authRequestContext;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            authRequestContext = getAuthRequestContext("flash mode", supportedFlashModes, "torch", CameraParams.FLASH_MODE_ON);
        } else {
            authRequestContext = getAuthRequestContext("flash mode", supportedFlashModes, "off");
        }
        if (authRequestContext != null) {
            if (authRequestContext.equals(parameters.getFlashMode())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Flash mode already set to ");
                sb.append(authRequestContext);
                InstrumentInjector.log_i("CameraConfiguration", sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting flash mode to ");
            sb2.append(authRequestContext);
            InstrumentInjector.log_i("CameraConfiguration", sb2.toString());
            parameters.setFlashMode(authRequestContext);
        }
    }

    public static void PlaceComponentResult(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int round = Math.round((z ? 0.0f : 1.5f) / exposureCompensationStep);
                float f = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Exposure compensation already set to ");
                    sb.append(max);
                    sb.append(" / ");
                    sb.append(f);
                    InstrumentInjector.log_i("CameraConfiguration", sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting exposure compensation to ");
                sb2.append(max);
                sb2.append(" / ");
                sb2.append(f);
                InstrumentInjector.log_i("CameraConfiguration", sb2.toString());
                parameters.setExposureCompensation(max);
                return;
            }
        }
        InstrumentInjector.log_i("CameraConfiguration", "Camera does not support exposure compensation");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Old focus areas: ");
            sb.append(PlaceComponentResult(parameters.getFocusAreas()));
            InstrumentInjector.log_i("CameraConfiguration", sb.toString());
            List<Camera.Area> singletonList = Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting focus area to : ");
            sb2.append(PlaceComponentResult(singletonList));
            InstrumentInjector.log_i("CameraConfiguration", sb2.toString());
            parameters.setFocusAreas(singletonList);
            return;
        }
        InstrumentInjector.log_i("CameraConfiguration", "Device does not support focus areas");
    }

    public static void getAuthRequestContext(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Old metering areas: ");
            sb.append(parameters.getMeteringAreas());
            InstrumentInjector.log_i("CameraConfiguration", sb.toString());
            List<Camera.Area> singletonList = Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting metering area to : ");
            sb2.append(PlaceComponentResult(singletonList));
            InstrumentInjector.log_i("CameraConfiguration", sb2.toString());
            parameters.setMeteringAreas(singletonList);
            return;
        }
        InstrumentInjector.log_i("CameraConfiguration", "Device does not support metering areas");
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported()) {
            if (parameters.getVideoStabilization()) {
                InstrumentInjector.log_i("CameraConfiguration", "Video stabilization already enabled");
                return;
            }
            InstrumentInjector.log_i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
            return;
        }
        InstrumentInjector.log_i("CameraConfiguration", "This device does not support video stabilization");
    }

    public static void BuiltInFictitiousFunctionClassFactory(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            InstrumentInjector.log_i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String authRequestContext = getAuthRequestContext("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (authRequestContext != null) {
            parameters.setSceneMode(authRequestContext);
        }
    }

    public static void MyBillsEntityDataFactory(Camera.Parameters parameters) {
        if (ZolozEkycH5Handler.HUMMER_FOUNDATION_NEGATIVE.equals(parameters.getColorEffect())) {
            InstrumentInjector.log_i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String authRequestContext = getAuthRequestContext("color effect", parameters.getSupportedColorEffects(), ZolozEkycH5Handler.HUMMER_FOUNDATION_NEGATIVE);
        if (authRequestContext != null) {
            parameters.setColorEffect(authRequestContext);
        }
    }

    private static String getAuthRequestContext(String str, Collection<String> collection, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("Requesting ");
        sb.append(str);
        sb.append(" value from among: ");
        sb.append(Arrays.toString(strArr));
        InstrumentInjector.log_i("CameraConfiguration", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Supported ");
        sb2.append(str);
        sb2.append(" values: ");
        sb2.append(collection);
        InstrumentInjector.log_i("CameraConfiguration", sb2.toString());
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Can set ");
                    sb3.append(str);
                    sb3.append(" to: ");
                    sb3.append(str2);
                    InstrumentInjector.log_i("CameraConfiguration", sb3.toString());
                    return str2;
                }
            }
        }
        InstrumentInjector.log_i("CameraConfiguration", "No supported values match");
        return null;
    }

    private static String PlaceComponentResult(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(InputCardNumberView.DIVIDER);
        }
        return sb.toString();
    }

    public static void PlaceComponentResult(Camera.Parameters parameters) {
        String str;
        int[] iArr;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        StringBuilder sb = new StringBuilder();
        sb.append("Supported FPS ranges: ");
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            str = "[]";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            Iterator<int[]> it = supportedPreviewFpsRange.iterator();
            while (it.hasNext()) {
                sb2.append(Arrays.toString(it.next()));
                if (it.hasNext()) {
                    sb2.append(", ");
                }
            }
            sb2.append(']');
            str = sb2.toString();
        }
        sb.append(str);
        InstrumentInjector.log_i("CameraConfiguration", sb.toString());
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator<int[]> it2 = supportedPreviewFpsRange.iterator();
        while (true) {
            iArr = null;
            if (!it2.hasNext()) {
                break;
            }
            iArr = it2.next();
            int i = iArr[0];
            int i2 = iArr[1];
            if (i >= 10000 && i2 <= 20000) {
                break;
            }
        }
        if (iArr == null) {
            InstrumentInjector.log_i("CameraConfiguration", "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("FPS range already set to ");
            sb3.append(Arrays.toString(iArr));
            InstrumentInjector.log_i("CameraConfiguration", sb3.toString());
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Setting FPS range to ");
        sb4.append(Arrays.toString(iArr));
        InstrumentInjector.log_i("CameraConfiguration", sb4.toString());
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }
}
