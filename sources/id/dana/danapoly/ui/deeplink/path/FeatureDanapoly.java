package id.dana.danapoly.ui.deeplink.path;

import android.app.Activity;
import id.dana.danapoly.ui.model.DanapolyDeeplinkModel;
import id.dana.danapoly.ui.splash.DanapolySplashActivity;
import id.dana.network.util.DanaH5Helper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u000b\u001a\u00020\t2\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u00032\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0087\u0002¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danapoly/ui/deeplink/path/FeatureDanapoly;", "", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "p0", "", "", "p1", "Lkotlin/Function0;", "", "p2", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureDanapoly {
    public static final FeatureDanapoly INSTANCE = new FeatureDanapoly();

    private FeatureDanapoly() {
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Activity p0, Map<String, String> p1, Function0<Unit> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String str = p1.get("service_status");
        Unit unit = null;
        if (!Intrinsics.areEqual(str, "enabled")) {
            if (Intrinsics.areEqual(str, "maintenance")) {
                String str2 = p1.get("service_link");
                String str3 = str2;
                if ((!(str3 == null || str3.length() == 0)) == false) {
                    str2 = null;
                }
                String str4 = str2;
                if (str4 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://m.dana.id");
                    sb.append(str4);
                    DanaH5Helper.INSTANCE.openUrl(p0, sb.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    p2.invoke();
                    return;
                }
                return;
            }
            p2.invoke();
            return;
        }
        DanapolyDeeplinkModel danapolyDeeplinkModel = new DanapolyDeeplinkModel(p1.get("prizeEn"), p1.get("prizeId"), p1.get("typeEn"), p1.get("typeId"), p1.get("lastEventId"), p1.get("redirection"));
        DanapolySplashActivity.Companion companion = DanapolySplashActivity.INSTANCE;
        DanapolySplashActivity.Companion.PlaceComponentResult(p0, danapolyDeeplinkModel.isDareNotification() || danapolyDeeplinkModel.isWinnerNotification() ? danapolyDeeplinkModel : null);
    }
}
