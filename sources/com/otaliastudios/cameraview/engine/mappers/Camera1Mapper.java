package com.otaliastudios.cameraview.engine.mappers;

import android.os.Build;
import com.alibaba.griver.image.capture.meta.CameraParams;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class Camera1Mapper {
    public static final Map<Facing, Integer> BuiltInFictitiousFunctionClassFactory;
    public static final Map<Hdr, String> KClassImpl$Data$declaredNonStaticMembers$2;
    private static Camera1Mapper MyBillsEntityDataFactory;
    public static final Map<Flash, String> PlaceComponentResult;
    public static final Map<WhiteBalance, String> getAuthRequestContext;

    public static Camera1Mapper PlaceComponentResult() {
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = new Camera1Mapper();
        }
        return MyBillsEntityDataFactory;
    }

    static {
        HashMap hashMap = new HashMap();
        PlaceComponentResult = hashMap;
        HashMap hashMap2 = new HashMap();
        getAuthRequestContext = hashMap2;
        HashMap hashMap3 = new HashMap();
        BuiltInFictitiousFunctionClassFactory = hashMap3;
        HashMap hashMap4 = new HashMap();
        KClassImpl$Data$declaredNonStaticMembers$2 = hashMap4;
        hashMap.put(Flash.OFF, "off");
        hashMap.put(Flash.ON, CameraParams.FLASH_MODE_ON);
        hashMap.put(Flash.AUTO, "auto");
        hashMap.put(Flash.TORCH, "torch");
        hashMap3.put(Facing.BACK, 0);
        hashMap3.put(Facing.FRONT, 1);
        hashMap2.put(WhiteBalance.AUTO, "auto");
        hashMap2.put(WhiteBalance.INCANDESCENT, "incandescent");
        hashMap2.put(WhiteBalance.FLUORESCENT, "fluorescent");
        hashMap2.put(WhiteBalance.DAYLIGHT, "daylight");
        hashMap2.put(WhiteBalance.CLOUDY, "cloudy-daylight");
        hashMap4.put(Hdr.OFF, "auto");
        if (Build.VERSION.SDK_INT >= 17) {
            hashMap4.put(Hdr.ON, "hdr");
        } else {
            hashMap4.put(Hdr.ON, "hdr");
        }
    }

    private Camera1Mapper() {
    }

    public static String PlaceComponentResult(Flash flash) {
        return PlaceComponentResult.get(flash);
    }

    public static int MyBillsEntityDataFactory(Facing facing) {
        return BuiltInFictitiousFunctionClassFactory.get(facing).intValue();
    }

    public static String BuiltInFictitiousFunctionClassFactory(WhiteBalance whiteBalance) {
        return getAuthRequestContext.get(whiteBalance);
    }

    public static String getAuthRequestContext(Hdr hdr) {
        return KClassImpl$Data$declaredNonStaticMembers$2.get(hdr);
    }

    public static <C extends Control, T> C MyBillsEntityDataFactory(Map<C, T> map, T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }
}
