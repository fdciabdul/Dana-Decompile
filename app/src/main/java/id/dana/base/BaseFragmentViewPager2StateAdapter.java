package id.dana.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/base/BaseFragmentViewPager2StateAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "()I", "", "Lid/dana/base/BaseFragment;", "getAuthRequestContext", "Ljava/util/List;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentManager;", "p0", "Landroidx/lifecycle/Lifecycle;", "p1", "p2", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseFragmentViewPager2StateAdapter extends FragmentStateAdapter {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<? extends BaseFragment> PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFragmentViewPager2StateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<? extends BaseFragment> list) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(lifecycle, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        return this.PlaceComponentResult.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final /* synthetic */ Fragment KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.PlaceComponentResult.get(i);
    }
}
