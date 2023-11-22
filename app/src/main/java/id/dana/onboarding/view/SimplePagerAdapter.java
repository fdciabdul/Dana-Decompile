package id.dana.onboarding.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u001a¢\u0006\u0004\b!\u0010\"J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0018\u001a\u00020\u001aX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/onboarding/view/SimplePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/ViewGroup;", "p0", "", "p1", "", "p2", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "Landroid/view/View;", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "", "Lid/dana/onboarding/view/SimpleView;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/onboarding/view/SimplePagerAdapter$OnItemClickListener;", "Lid/dana/onboarding/view/SimplePagerAdapter$OnItemClickListener;", "MyBillsEntityDataFactory", "Ljava/util/List;", "<init>", "(Landroid/content/Context;)V", "OnItemClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SimplePagerAdapter extends PagerAdapter {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public OnItemClickListener PlaceComponentResult;
    private List<? extends SimpleView> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/view/SimplePagerAdapter$OnItemClickListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void BuiltInFictitiousFunctionClassFactory(int p0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View p0, Object p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return p0 == p1;
    }

    public SimplePagerAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends SimpleView> p0) {
        this.MyBillsEntityDataFactory = p0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<? extends SimpleView> list = this.MyBillsEntityDataFactory;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup p0, int p1, Object p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        p0.removeView((View) p2);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SimplePagerAdapter simplePagerAdapter, int i) {
        Intrinsics.checkNotNullParameter(simplePagerAdapter, "");
        OnItemClickListener onItemClickListener = simplePagerAdapter.PlaceComponentResult;
        if (onItemClickListener != null) {
            onItemClickListener.BuiltInFictitiousFunctionClassFactory(i);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int p0) {
        List<? extends SimpleView> list = this.MyBillsEntityDataFactory;
        SimpleView simpleView = list != null ? (SimpleView) CollectionsKt.getOrNull(list, p0) : null;
        return simpleView != null ? simpleView.getKClassImpl$Data$declaredNonStaticMembers$2() : null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup p0, final int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<? extends SimpleView> list = this.MyBillsEntityDataFactory;
        SimpleView simpleView = list != null ? (SimpleView) CollectionsKt.getOrNull(list, p1) : null;
        if (simpleView != null) {
            simpleView.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, p0);
            View m_ = simpleView.m_();
            if (m_ != null) {
                m_.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.view.SimplePagerAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SimplePagerAdapter.KClassImpl$Data$declaredNonStaticMembers$2(SimplePagerAdapter.this, p1);
                    }
                });
                p0.addView(m_);
                return m_;
            }
        }
        Object instantiateItem = super.instantiateItem(p0, p1);
        Intrinsics.checkNotNullExpressionValue(instantiateItem, "");
        return instantiateItem;
    }
}
