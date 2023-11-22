package com.otaliastudios.cameraview.internal.utils;

import android.media.CamcorderProfile;
import android.os.Build;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class CamcorderProfiles {
    private static Map<Size, Integer> KClassImpl$Data$declaredNonStaticMembers$2;
    private static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("CamcorderProfiles");

    static {
        HashMap hashMap = new HashMap();
        KClassImpl$Data$declaredNonStaticMembers$2 = hashMap;
        hashMap.put(new Size(176, 144), 2);
        KClassImpl$Data$declaredNonStaticMembers$2.put(new Size(320, 240), 7);
        KClassImpl$Data$declaredNonStaticMembers$2.put(new Size(352, 288), 3);
        KClassImpl$Data$declaredNonStaticMembers$2.put(new Size(720, 480), 4);
        KClassImpl$Data$declaredNonStaticMembers$2.put(new Size(APEncodeOptions.DEFAULT_MAX_LEN, 720), 5);
        KClassImpl$Data$declaredNonStaticMembers$2.put(new Size(1920, 1080), 6);
        if (Build.VERSION.SDK_INT >= 21) {
            KClassImpl$Data$declaredNonStaticMembers$2.put(new Size(3840, 2160), 8);
        }
    }

    public static CamcorderProfile MyBillsEntityDataFactory(String str, Size size) {
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2(Integer.parseInt(str), size);
        } catch (NumberFormatException unused) {
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(2, "NumberFormatException for Camera2 id:", str);
            return CamcorderProfile.get(0);
        }
    }

    public static CamcorderProfile KClassImpl$Data$declaredNonStaticMembers$2(int i, Size size) {
        long j = size.BuiltInFictitiousFunctionClassFactory;
        long j2 = size.getAuthRequestContext;
        ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.keySet());
        final long j3 = j * j2;
        Collections.sort(arrayList, new Comparator<Size>() { // from class: com.otaliastudios.cameraview.internal.utils.CamcorderProfiles.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Size size2, Size size3) {
                Size size4 = size2;
                Size size5 = size3;
                long abs = Math.abs((size4.BuiltInFictitiousFunctionClassFactory * size4.getAuthRequestContext) - j3);
                long abs2 = Math.abs((size5.BuiltInFictitiousFunctionClassFactory * size5.getAuthRequestContext) - j3);
                if (abs < abs2) {
                    return -1;
                }
                return abs == abs2 ? 0 : 1;
            }
        });
        while (arrayList.size() > 0) {
            int intValue = KClassImpl$Data$declaredNonStaticMembers$2.get((Size) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, intValue)) {
                return CamcorderProfile.get(i, intValue);
            }
        }
        return CamcorderProfile.get(i, 0);
    }
}
