package id.dana.referral.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.referral.model.ReferralBannerContent;
import id.dana.referral.view.ReferralBannerView;
import id.dana.richview.CircularPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/referral/adapter/ReferralBannerAdapter;", "Lid/dana/richview/CircularPagerAdapter;", "Lid/dana/referral/model/ReferralBannerContent;", "", "p0", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "PlaceComponentResult", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "Lid/dana/onboarding/view/BaseSimpleView;", "MyBillsEntityDataFactory", "Ljava/util/List;", "Landroid/content/Context;", "", "<init>", "(Landroid/content/Context;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralBannerAdapter extends CircularPagerAdapter<ReferralBannerContent> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private List<BaseSimpleView> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferralBannerAdapter(Context context, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    @Override // id.dana.richview.CircularPagerAdapter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<ReferralBannerContent> p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        Intrinsics.checkNotNull(p0);
        Iterator<ReferralBannerContent> it = p0.iterator();
        while (it.hasNext()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(new ReferralBannerView(it.next().scheduleImpl));
        }
        super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.richview.CircularPagerAdapter
    public final View PlaceComponentResult(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        BaseSimpleView baseSimpleView = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        Context context = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(context, "");
        baseSimpleView.KClassImpl$Data$declaredNonStaticMembers$2(context, viewGroup);
        View view = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).MyBillsEntityDataFactory;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }
}
