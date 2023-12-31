package com.alipay.zoloz.zface.ui.util;

import android.os.Build;
import com.alipay.zoloz.hardware.camera.utils.AndroidCameraUtil;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class EnvCheck {
    private static final int ANDROID_VERSION_4_3 = 18;
    private final String[] SUPPORT_CPU_API = {"armeabi-v7a", "arm64-v8a", ResourceAttributes.HostArchValues.X86, "x86_64"};

    /* loaded from: classes7.dex */
    public enum EnvErrorType {
        ENV_SUCCESS,
        ENV_ERROR_LOW_OS,
        ENV_ERROR_UNSUPPORTED_CPU,
        ENV_ERROR_NO_FRONT_CAMERA
    }

    public EnvErrorType check(boolean z) {
        if (Build.VERSION.SDK_INT < 18) {
            return EnvErrorType.ENV_ERROR_LOW_OS;
        }
        if (!Arrays.asList(this.SUPPORT_CPU_API).contains(Build.CPU_ABI)) {
            return EnvErrorType.ENV_ERROR_UNSUPPORTED_CPU;
        }
        if (!z && AndroidCameraUtil.findFacingCamera() == -1) {
            return EnvErrorType.ENV_ERROR_NO_FRONT_CAMERA;
        }
        return EnvErrorType.ENV_SUCCESS;
    }
}
