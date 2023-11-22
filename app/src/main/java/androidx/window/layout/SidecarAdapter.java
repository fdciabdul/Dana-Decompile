package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import id.dana.data.constant.BranchLinkConstant;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\f\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0010\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\bJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/SidecarAdapter;", "", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "(Landroidx/window/core/SpecificationComputer$VerificationMode;)V", "isEqualSidecarDeviceState", "", "first", "Landroidx/window/sidecar/SidecarDeviceState;", "second", "isEqualSidecarDisplayFeature", "Landroidx/window/sidecar/SidecarDisplayFeature;", "isEqualSidecarDisplayFeatures", "", "isEqualSidecarWindowLayoutInfo", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "translate", "Landroidx/window/layout/DisplayFeature;", BranchLinkConstant.PathTarget.FEATURE, "deviceState", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "extensionInfo", "state", "sidecarDisplayFeatures", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SidecarAdapter {
    private final SpecificationComputer.VerificationMode BuiltInFictitiousFunctionClassFactory;
    public static final Companion MyBillsEntityDataFactory = new Companion(0);
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "SidecarAdapter";

    public SidecarAdapter() {
        this((byte) 0);
    }

    public /* synthetic */ SidecarAdapter(byte b) {
        this(SpecificationComputer.VerificationMode.QUIET);
    }

    private SidecarAdapter(SpecificationComputer.VerificationMode verificationMode) {
        Intrinsics.checkNotNullParameter(verificationMode, "");
        this.BuiltInFictitiousFunctionClassFactory = verificationMode;
    }

    private List<DisplayFeature> PlaceComponentResult(List<SidecarDisplayFeature> list, SidecarDeviceState sidecarDeviceState) {
        HardwareFoldingFeature.Type BuiltInFictitiousFunctionClassFactory;
        FoldingFeature.State state;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
        ArrayList arrayList = new ArrayList();
        for (SidecarDisplayFeature sidecarDisplayFeature : list) {
            Intrinsics.checkNotNullParameter(sidecarDisplayFeature, "");
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
            SpecificationComputer.Companion companion = SpecificationComputer.INSTANCE;
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(str, "");
            SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) SpecificationComputer.Companion.MyBillsEntityDataFactory(sidecarDisplayFeature, str, this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext("Type must be either TYPE_FOLD or TYPE_HINGE", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature3) {
                    Intrinsics.checkNotNullParameter(sidecarDisplayFeature3, "");
                    boolean z = true;
                    if (sidecarDisplayFeature3.getType() != 1 && sidecarDisplayFeature3.getType() != 2) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            }).getAuthRequestContext("Feature bounds must not be 0", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature3) {
                    Intrinsics.checkNotNullParameter(sidecarDisplayFeature3, "");
                    return Boolean.valueOf((sidecarDisplayFeature3.getRect().width() == 0 && sidecarDisplayFeature3.getRect().height() == 0) ? false : true);
                }
            }).getAuthRequestContext("TYPE_FOLD must have 0 area", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature3) {
                    Intrinsics.checkNotNullParameter(sidecarDisplayFeature3, "");
                    boolean z = true;
                    if (sidecarDisplayFeature3.getType() == 1 && sidecarDisplayFeature3.getRect().width() != 0 && sidecarDisplayFeature3.getRect().height() != 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            }).getAuthRequestContext("Feature be pinned to either left or top", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$4
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature3) {
                    Intrinsics.checkNotNullParameter(sidecarDisplayFeature3, "");
                    return Boolean.valueOf(sidecarDisplayFeature3.getRect().left == 0 || sidecarDisplayFeature3.getRect().top == 0);
                }
            }).BuiltInFictitiousFunctionClassFactory();
            HardwareFoldingFeature hardwareFoldingFeature = null;
            if (sidecarDisplayFeature2 != null) {
                int type = sidecarDisplayFeature2.getType();
                if (type == 1) {
                    HardwareFoldingFeature.Type.Companion companion2 = HardwareFoldingFeature.Type.INSTANCE;
                    BuiltInFictitiousFunctionClassFactory = HardwareFoldingFeature.Type.Companion.BuiltInFictitiousFunctionClassFactory();
                } else if (type == 2) {
                    HardwareFoldingFeature.Type.Companion companion3 = HardwareFoldingFeature.Type.INSTANCE;
                    BuiltInFictitiousFunctionClassFactory = HardwareFoldingFeature.Type.Companion.getAuthRequestContext();
                }
                Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
                int PlaceComponentResult = Companion.PlaceComponentResult(sidecarDeviceState);
                if (PlaceComponentResult < 0 || PlaceComponentResult > 4) {
                    PlaceComponentResult = 0;
                }
                if (PlaceComponentResult != 0 && PlaceComponentResult != 1) {
                    if (PlaceComponentResult == 2) {
                        state = FoldingFeature.State.MyBillsEntityDataFactory;
                    } else if (PlaceComponentResult == 3) {
                        state = FoldingFeature.State.BuiltInFictitiousFunctionClassFactory;
                    } else if (PlaceComponentResult != 4) {
                        state = FoldingFeature.State.BuiltInFictitiousFunctionClassFactory;
                    }
                    Rect rect = sidecarDisplayFeature.getRect();
                    Intrinsics.checkNotNullExpressionValue(rect, "");
                    hardwareFoldingFeature = new HardwareFoldingFeature(new Bounds(rect), BuiltInFictitiousFunctionClassFactory, state);
                }
            }
            if (hardwareFoldingFeature != null) {
                arrayList.add(hardwareFoldingFeature);
            }
        }
        return arrayList;
    }

    public final WindowLayoutInfo MyBillsEntityDataFactory(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
        if (sidecarWindowLayoutInfo == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
        int PlaceComponentResult = Companion.PlaceComponentResult(sidecarDeviceState);
        if (PlaceComponentResult < 0 || PlaceComponentResult > 4) {
            PlaceComponentResult = 0;
        }
        Companion.getAuthRequestContext(sidecarDeviceState2, PlaceComponentResult);
        return new WindowLayoutInfo(PlaceComponentResult(Companion.getAuthRequestContext(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (Intrinsics.areEqual(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
        int PlaceComponentResult = Companion.PlaceComponentResult(sidecarDeviceState);
        if (PlaceComponentResult < 0 || PlaceComponentResult > 4) {
            PlaceComponentResult = 0;
        }
        Intrinsics.checkNotNullParameter(sidecarDeviceState2, "");
        int PlaceComponentResult2 = Companion.PlaceComponentResult(sidecarDeviceState2);
        if (PlaceComponentResult2 < 0 || PlaceComponentResult2 > 4) {
            PlaceComponentResult2 = 0;
        }
        return PlaceComponentResult == PlaceComponentResult2;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (Intrinsics.areEqual(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        return MyBillsEntityDataFactory(Companion.getAuthRequestContext(sidecarWindowLayoutInfo), Companion.getAuthRequestContext(sidecarWindowLayoutInfo2));
    }

    private static boolean MyBillsEntityDataFactory(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!PlaceComponentResult(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean PlaceComponentResult(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (Intrinsics.areEqual(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return Intrinsics.areEqual(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0007J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/SidecarAdapter$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getRawSidecarDevicePosture", "", "sidecarDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "getSidecarDevicePosture", "getSidecarDevicePosture$window_release", "getSidecarDisplayFeatures", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "info", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "setSidecarDevicePosture", "", "posture", "setSidecarDisplayFeatures", "displayFeatures", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(byte b) {
            this();
        }

        private Companion() {
        }

        public static List<SidecarDisplayFeature> getAuthRequestContext(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            Intrinsics.checkNotNullParameter(sidecarWindowLayoutInfo, "");
            try {
                List<SidecarDisplayFeature> list = sidecarWindowLayoutInfo.displayFeatures;
                return list == null ? CollectionsKt.emptyList() : list;
            } catch (NoSuchFieldError unused) {
                try {
                    Object invoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(sidecarWindowLayoutInfo, new Object[0]);
                    if (invoke != null) {
                        return (List) invoke;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return CollectionsKt.emptyList();
                }
            }
        }

        public static int PlaceComponentResult(SidecarDeviceState sidecarDeviceState) {
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                try {
                    Object invoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                    if (invoke != null) {
                        return ((Integer) invoke).intValue();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return 0;
                }
            }
        }

        public static void getAuthRequestContext(SidecarDeviceState sidecarDeviceState, int i) {
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "");
            try {
                sidecarDeviceState.posture = i;
            } catch (NoSuchFieldError unused) {
                try {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i));
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }
        }
    }
}
