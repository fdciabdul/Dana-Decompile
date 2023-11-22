package id.dana.requestmoney.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/requestmoney/adapter/BaseFragmentPagerStateAdapterV2;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "()I", "p0", "Landroidx/fragment/app/Fragment;", "getAuthRequestContext", "(I)Landroidx/fragment/app/Fragment;", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/FragmentManager;", "p1", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseFragmentPagerStateAdapterV2 extends FragmentStatePagerAdapter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<? extends Fragment> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFragmentPagerStateAdapterV2(FragmentManager fragmentManager, List<? extends Fragment> list) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getAuthRequestContext(int p0) {
        return this.BuiltInFictitiousFunctionClassFactory.get(p0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.BuiltInFictitiousFunctionClassFactory.size();
    }
}
