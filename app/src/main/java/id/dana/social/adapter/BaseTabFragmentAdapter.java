package id.dana.social.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lid/dana/social/adapter/BaseTabFragmentAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "fragmentContentDescription", "", "", "fragmentList", "Landroidx/fragment/app/Fragment;", "fragmentTitleList", "addItem", "", "fragment", "title", "contentDescription", "clearItems", GriverLaunchParams.CREATE_FRAGMENT, "position", "", "getContentDescription", "getItem", "getItemCount", "getItemOrNull", "getPageTitle", "", "getPosition", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BaseTabFragmentAdapter extends FragmentStateAdapter {
    public final List<Fragment> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final List<String> getAuthRequestContext;
    public final List<String> moveToNextValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTabFragmentAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(lifecycle, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
        this.moveToNextValue = new ArrayList();
        this.getAuthRequestContext = new ArrayList();
    }

    public final void PlaceComponentResult(Fragment fragment, String str, String str2) {
        Intrinsics.checkNotNullParameter(fragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(fragment);
        this.moveToNextValue.add(str);
        this.getAuthRequestContext.add(str2);
        notifyItemInserted(this.NetworkUserEntityData$$ExternalSyntheticLambda0.indexOf(fragment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i);
    }
}
