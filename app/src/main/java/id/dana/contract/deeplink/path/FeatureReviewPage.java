package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.nearbyme.merchantreview.MyReviewListActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u0003H\u0087\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureReviewPage;", "", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureReviewPage {
    public static final FeatureReviewPage INSTANCE = new FeatureReviewPage();

    private FeatureReviewPage() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyReviewListActivity.Companion companion = MyReviewListActivity.INSTANCE;
        MyReviewListActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(p0, "Deeplink");
    }
}
