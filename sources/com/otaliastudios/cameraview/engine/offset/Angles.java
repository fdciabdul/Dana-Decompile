package com.otaliastudios.cameraview.engine.offset;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.controls.Facing;

/* loaded from: classes2.dex */
public class Angles {
    private static final CameraLogger BuiltInFictitiousFunctionClassFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("Angles");
    private Facing MyBillsEntityDataFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public int getAuthRequestContext = 0;
    public int PlaceComponentResult = 0;

    public final void MyBillsEntityDataFactory(Facing facing, int i) {
        getAuthRequestContext(i);
        this.MyBillsEntityDataFactory = facing;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        if (facing == Facing.FRONT) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ((360 - this.KClassImpl$Data$declaredNonStaticMembers$2) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
        }
        PlaceComponentResult();
    }

    public final void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "Angles changed:", "sensorOffset:", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), "displayOffset:", Integer.valueOf(this.getAuthRequestContext), "deviceOrientation:", Integer.valueOf(this.PlaceComponentResult));
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2(Reference reference, Reference reference2, Axis axis) {
        int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(reference, reference2);
        return (axis == Axis.RELATIVE_TO_SENSOR && this.MyBillsEntityDataFactory == Facing.FRONT) ? ((360 - BuiltInFictitiousFunctionClassFactory2) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE : BuiltInFictitiousFunctionClassFactory2;
    }

    private int BuiltInFictitiousFunctionClassFactory(Reference reference, Reference reference2) {
        if (reference == reference2) {
            return 0;
        }
        if (reference2 != Reference.BASE) {
            if (reference == Reference.BASE) {
                int i = AnonymousClass1.PlaceComponentResult[reference2.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unknown reference: ");
                            sb.append(reference2);
                            throw new RuntimeException(sb.toString());
                        }
                        return ((360 - this.KClassImpl$Data$declaredNonStaticMembers$2) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
                    }
                    return (this.PlaceComponentResult + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
                }
                return ((360 - this.getAuthRequestContext) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
            }
            return ((BuiltInFictitiousFunctionClassFactory(Reference.BASE, reference2) - BuiltInFictitiousFunctionClassFactory(Reference.BASE, reference)) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
        }
        return ((360 - BuiltInFictitiousFunctionClassFactory(reference2, reference)) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.otaliastudios.cameraview.engine.offset.Angles$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Reference.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Reference.VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Reference.OUTPUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[Reference.SENSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final boolean PlaceComponentResult(Reference reference, Reference reference2) {
        return KClassImpl$Data$declaredNonStaticMembers$2(reference, reference2, Axis.ABSOLUTE) % 180 != 0;
    }

    public static void getAuthRequestContext(int i) {
        if (i == 0 || i == 90 || i == 180 || i == 270) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("This value is not sanitized: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
}
