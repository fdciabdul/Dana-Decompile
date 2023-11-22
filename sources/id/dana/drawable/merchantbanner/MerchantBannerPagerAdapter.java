package id.dana.drawable.merchantbanner;

import android.content.Context;
import id.dana.onboarding.view.SimplePagerAdapter;
import id.dana.onboarding.view.SimpleView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/nearbyrevamp/merchantbanner/MerchantBannerPagerAdapter;", "Lid/dana/onboarding/view/SimplePagerAdapter;", "", "p0", "", "getItemPosition", "(Ljava/lang/Object;)I", "", "Lid/dana/onboarding/view/SimpleView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantBannerPagerAdapter extends SimplePagerAdapter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private List<SimpleView> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return -2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantBannerPagerAdapter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.onboarding.view.SimplePagerAdapter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends SimpleView> p0) {
        if (p0 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.toMutableList((Collection) p0);
            super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            notifyDataSetChanged();
        }
    }
}
