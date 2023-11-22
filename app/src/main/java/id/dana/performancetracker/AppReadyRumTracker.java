package id.dana.performancetracker;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.rum.Rum;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007J;\u0010\n\u001a\u00020\u00022*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t0\b\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\f\u0010\u0007J\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/performancetracker/AppReadyRumTracker;", "", "", "getAuthRequestContext", "()V", "", "p0", "(Ljava/lang/String;)V", "", "Lkotlin/Pair;", "MyBillsEntityDataFactory", "([Lkotlin/Pair;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "", "Z", "PlaceComponentResult", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppReadyRumTracker {
    public static final AppReadyRumTracker INSTANCE = new AppReadyRumTracker();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static boolean PlaceComponentResult;

    private AppReadyRumTracker() {
    }

    @JvmStatic
    public static final void getAuthRequestContext() {
        if (PlaceComponentResult) {
            return;
        }
        PlaceComponentResult = true;
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(TrackerKey.Event.APP_READY);
    }

    @JvmStatic
    public static final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum BuiltInFictitiousFunctionClassFactory = Rum.Companion.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        sb.append("App Ready.");
        sb.append(p0);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(sb.toString(), TrackerKey.Event.APP_READY);
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum BuiltInFictitiousFunctionClassFactory = Rum.Companion.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        sb.append("App Ready.");
        sb.append(p0);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(sb.toString());
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Pair<String, ? extends Object>... p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(TrackerKey.Event.APP_READY, (Pair[]) Arrays.copyOf(p0, p0.length)).PlaceComponentResult();
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult = false;
    }
}
