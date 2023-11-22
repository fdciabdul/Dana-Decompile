package id.dana.core.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import id.dana.core.ui.BaseViewBindingFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/core/ui/adapter/BaseViewPager2StateAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "()I", "", "Lid/dana/core/ui/BaseViewBindingFragment;", "getAuthRequestContext", "Ljava/util/List;", "Landroidx/fragment/app/FragmentManager;", "p0", "Landroidx/lifecycle/Lifecycle;", "p1", "p2", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseViewPager2StateAdapter extends FragmentStateAdapter {
    public List<? extends BaseViewBindingFragment<?>> getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPager2StateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<? extends BaseViewBindingFragment<?>> list) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(lifecycle, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.getAuthRequestContext.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final /* synthetic */ Fragment KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.getAuthRequestContext.get(i);
    }
}
