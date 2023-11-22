package id.dana.social;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013"}, d2 = {"Lid/dana/social/BaseTabFragmentAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "Landroidx/fragment/app/Fragment;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "", "getCount", "()I", "MyBillsEntityDataFactory", "(I)Landroidx/fragment/app/Fragment;", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "", "getAuthRequestContext", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BaseTabFragmentAdapter extends FragmentPagerAdapter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final List<String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<Fragment> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTabFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.MyBillsEntityDataFactory = new ArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final Fragment MyBillsEntityDataFactory(int p0) {
        return this.MyBillsEntityDataFactory.get(p0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.MyBillsEntityDataFactory.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int p0) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0);
    }

    public final void BuiltInFictitiousFunctionClassFactory(Fragment p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.add(p0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.add(p1);
    }
}
