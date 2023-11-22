package id.dana.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/base/BaseFragmentPagerStateAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "()I", "", "Lid/dana/base/BaseFragment;", "getAuthRequestContext", "Ljava/util/List;", "Landroidx/fragment/app/FragmentManager;", "p0", "p1", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseFragmentPagerStateAdapter extends FragmentStatePagerAdapter {
    public List<? extends BaseFragment> getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFragmentPagerStateAdapter(FragmentManager fragmentManager, List<? extends BaseFragment> list) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.getAuthRequestContext.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public final /* synthetic */ Fragment getAuthRequestContext(int i) {
        return this.getAuthRequestContext.get(i);
    }
}
