package com.otaliastudios.cameraview.engine.mappers;

import android.util.Pair;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class Camera2Mapper {
    public static final Map<Facing, Integer> BuiltInFictitiousFunctionClassFactory;
    public static final Map<WhiteBalance, Integer> MyBillsEntityDataFactory;
    private static Camera2Mapper PlaceComponentResult;
    public static final Map<Hdr, Integer> getAuthRequestContext;

    public static Camera2Mapper getAuthRequestContext() {
        if (PlaceComponentResult == null) {
            PlaceComponentResult = new Camera2Mapper();
        }
        return PlaceComponentResult;
    }

    static {
        HashMap hashMap = new HashMap();
        BuiltInFictitiousFunctionClassFactory = hashMap;
        HashMap hashMap2 = new HashMap();
        MyBillsEntityDataFactory = hashMap2;
        HashMap hashMap3 = new HashMap();
        getAuthRequestContext = hashMap3;
        hashMap.put(Facing.BACK, 1);
        hashMap.put(Facing.FRONT, 0);
        hashMap2.put(WhiteBalance.AUTO, 1);
        hashMap2.put(WhiteBalance.CLOUDY, 6);
        hashMap2.put(WhiteBalance.DAYLIGHT, 5);
        hashMap2.put(WhiteBalance.FLUORESCENT, 3);
        hashMap2.put(WhiteBalance.INCANDESCENT, 2);
        hashMap3.put(Hdr.OFF, 0);
        hashMap3.put(Hdr.ON, 18);
    }

    private Camera2Mapper() {
    }

    /* renamed from: com.otaliastudios.cameraview.engine.mappers.Camera2Mapper$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[Flash.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Flash.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Flash.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Flash.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Flash.TORCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static List<Pair<Integer, Integer>> PlaceComponentResult(Flash flash) {
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[flash.ordinal()];
        if (i == 1) {
            arrayList.add(new Pair(3, 0));
        } else if (i == 2) {
            arrayList.add(new Pair(2, 0));
            arrayList.add(new Pair(4, 0));
        } else if (i == 3) {
            arrayList.add(new Pair(1, 0));
            arrayList.add(new Pair(0, 0));
        } else if (i == 4) {
            arrayList.add(new Pair(1, 2));
            arrayList.add(new Pair(0, 2));
        }
        return arrayList;
    }

    public static int getAuthRequestContext(Facing facing) {
        return BuiltInFictitiousFunctionClassFactory.get(facing).intValue();
    }

    public static int getAuthRequestContext(WhiteBalance whiteBalance) {
        return MyBillsEntityDataFactory.get(whiteBalance).intValue();
    }

    public static int MyBillsEntityDataFactory(Hdr hdr) {
        return getAuthRequestContext.get(hdr).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
    
        if (r2 != 4) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Set<com.otaliastudios.cameraview.controls.Flash> BuiltInFictitiousFunctionClassFactory(int r2) {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r2 == 0) goto L20
            r1 = 1
            if (r2 == r1) goto L20
            r1 = 2
            if (r2 == r1) goto L1a
            r1 = 3
            if (r2 == r1) goto L14
            r1 = 4
            if (r2 == r1) goto L1a
            goto L2a
        L14:
            com.otaliastudios.cameraview.controls.Flash r2 = com.otaliastudios.cameraview.controls.Flash.ON
            r0.add(r2)
            goto L2a
        L1a:
            com.otaliastudios.cameraview.controls.Flash r2 = com.otaliastudios.cameraview.controls.Flash.AUTO
            r0.add(r2)
            goto L2a
        L20:
            com.otaliastudios.cameraview.controls.Flash r2 = com.otaliastudios.cameraview.controls.Flash.OFF
            r0.add(r2)
            com.otaliastudios.cameraview.controls.Flash r2 = com.otaliastudios.cameraview.controls.Flash.TORCH
            r0.add(r2)
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.engine.mappers.Camera2Mapper.BuiltInFictitiousFunctionClassFactory(int):java.util.Set");
    }

    public static <C extends Control, T> C getAuthRequestContext(Map<C, T> map, T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }
}
