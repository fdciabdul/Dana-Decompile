package com.alibaba.griver.image.framework.utils;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import id.dana.util.permission.ManifestPermission;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class PermissionHelper {
    public static final int PERMISSION_ACQUIRE_AUDIO = 1;
    public static final int PERMISSION_REQUEST_CODE_AUDIO_REOPEN = 4;
    public static final int PERMISSION_REQUEST_CODE_VIDEO_AUDIO = 2;

    public static void acquirePermissions(int... iArr) {
        XPermissionHelper.acquirePermissions(iArr);
    }

    public static boolean hasPermission(String str) {
        return XPermissionHelper.hasPermission(str);
    }

    public static boolean checkVideoPermission(int i, boolean z) {
        return hasPermission("android.permission.CAMERA") && (i != 0 || z || hasPermission(ManifestPermission.RECORD_AUDIO));
    }

    public static void requireVideoPermission(Object obj, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"android.permission.CAMERA", ManifestPermission.RECORD_AUDIO};
        for (int i3 = 0; i3 < 2; i3++) {
            String str = strArr[i3];
            if (!hasPermission(str) && (i != 1 || !str.equals(ManifestPermission.RECORD_AUDIO))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        if (obj instanceof Activity) {
            ActivityCompat.BuiltInFictitiousFunctionClassFactory((Activity) obj, strArr2, i2);
        }
    }
}
