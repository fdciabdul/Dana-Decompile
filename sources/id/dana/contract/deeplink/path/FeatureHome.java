package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabs;
import id.dana.kyb.model.KybPageInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureHome;", "", "Landroid/app/Activity;", "p0", "Lid/dana/home/tab/HomeTabs;", "p1", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Lid/dana/home/tab/HomeTabs;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureHome {
    @Inject
    public FeatureHome() {
    }

    public static void MyBillsEntityDataFactory(Activity p0, HomeTabs p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        HomeTabActivity.Companion.getAuthRequestContext(p0, p1, new KybPageInfo(false, false, null, false, 15, null));
    }
}
