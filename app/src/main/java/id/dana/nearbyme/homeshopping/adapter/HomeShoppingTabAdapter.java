package id.dana.nearbyme.homeshopping.adapter;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import id.dana.nearbyme.homeshopping.model.HomeShoppingModel;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncFragment;
import id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/homeshopping/adapter/HomeShoppingTabAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "p0", "Landroidx/fragment/app/Fragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)Landroidx/fragment/app/Fragment;", "getItemCount", "()I", "Lid/dana/nearbyme/homeshopping/model/HomeShoppingModel;", "getAuthRequestContext", "Lid/dana/nearbyme/homeshopping/model/HomeShoppingModel;", "p1", "<init>", "(Landroidx/fragment/app/Fragment;Lid/dana/nearbyme/homeshopping/model/HomeShoppingModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeShoppingTabAdapter extends FragmentStateAdapter {
    private final HomeShoppingModel getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeShoppingTabAdapter(Fragment fragment, HomeShoppingModel homeShoppingModel) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "");
        Intrinsics.checkNotNullParameter(homeShoppingModel, "");
        this.getAuthRequestContext = homeShoppingModel;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        if (p0 == 0) {
            HomeShoppingTutorialFragment homeShoppingTutorialFragment = new HomeShoppingTutorialFragment();
            homeShoppingTutorialFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("HOME_SHOPPING_TUTORIAL_DATA_KEY", this.getAuthRequestContext)));
            return homeShoppingTutorialFragment;
        } else if (p0 == 1) {
            HomeShoppingTncFragment homeShoppingTncFragment = new HomeShoppingTncFragment();
            homeShoppingTncFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("HOME_SHOPPING_TNC_DATA_KEY", this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2)));
            return homeShoppingTncFragment;
        } else {
            return new Fragment();
        }
    }
}
