package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabs;
import id.dana.kyb.model.KybPageInfo;
import id.dana.lib.gcontainer.GContainer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\t\u001a\u00020\b2\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u00032\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0003H\u0087\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/contract/deeplink/path/FeaturePocket;", "", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "p0", "", "", "p1", "", "getAuthRequestContext", "(Landroid/app/Activity;Ljava/util/Map;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeaturePocket {
    public static final FeaturePocket INSTANCE = new FeaturePocket();

    private FeaturePocket() {
    }

    @JvmStatic
    public static final void getAuthRequestContext(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get(HomeTabActivity.WALLET_SECTION);
        String str2 = str != null ? str : "";
        if (GContainer.isOpeningH5()) {
            GContainer.closeAllContainers();
        }
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        HomeTabActivity.Companion.BuiltInFictitiousFunctionClassFactory(p0, HomeTabs.POCKET, new KybPageInfo(false, false, null, false, 15, null), str2);
    }
}
