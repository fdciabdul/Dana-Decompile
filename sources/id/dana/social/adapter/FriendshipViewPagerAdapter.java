package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.social.base.FriendshipListBaseFragment;
import id.dana.social.utils.FriendshipListFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u0006\u0010\n\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/social/adapter/FriendshipViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "()I", "p0", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "(I)Landroidx/fragment/app/Fragment;", "Landroid/view/ViewGroup;", "p1", "", "p2", "", "setPrimaryItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Ljava/util/ArrayList;", "Lid/dana/social/base/FriendshipListBaseFragment;", "Lkotlin/collections/ArrayList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/ArrayList;", "PlaceComponentResult", "Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendshipViewPagerAdapter extends FragmentPagerAdapter {
    private final FriendshipListBaseFragment.ShowSnackbarInterface BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ArrayList<FriendshipListBaseFragment> PlaceComponentResult;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendshipViewPagerAdapter(FragmentManager fragmentManager, FriendshipListBaseFragment.ShowSnackbarInterface showSnackbarInterface) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(showSnackbarInterface, "");
        this.BuiltInFictitiousFunctionClassFactory = showSnackbarInterface;
        this.PlaceComponentResult = new ArrayList<>();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final Fragment MyBillsEntityDataFactory(int p0) {
        FriendshipListFactory.Companion companion = FriendshipListFactory.INSTANCE;
        FriendshipListBaseFragment BuiltInFictitiousFunctionClassFactory = FriendshipListFactory.Companion.BuiltInFictitiousFunctionClassFactory(p0, this.BuiltInFictitiousFunctionClassFactory);
        this.PlaceComponentResult.add(BuiltInFictitiousFunctionClassFactory);
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup p0, int p1, Object p2) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        super.setPrimaryItem(p0, p1, p2);
        int size = this.PlaceComponentResult.size();
        int i = 0;
        while (i < size) {
            FriendshipListBaseFragment friendshipListBaseFragment = this.PlaceComponentResult.get(i);
            boolean z = p1 == i;
            if (((RecyclerView) friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1153_paymentsettingpresenter_getautorouteinitialstate_1)) != null && (recyclerView = (RecyclerView) friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1153_paymentsettingpresenter_getautorouteinitialstate_1)) != null) {
                recyclerView.setNestedScrollingEnabled(z);
            }
            i++;
        }
        p0.requestLayout();
    }
}
