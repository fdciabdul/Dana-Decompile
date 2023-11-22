package id.dana.animation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.animation.tab.HomeTabs;
import id.dana.base.BaseFragment;
import id.dana.kyb.model.KybPageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public class HomeFragmentStateAdapter extends FragmentStateAdapter {
    final List<BaseFragment> getAuthRequestContext;
    private final List<Long> lookAheadTest;

    private HomeFragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<BaseFragment> list, List<Long> list2) {
        super(fragmentManager, lifecycle);
        this.getAuthRequestContext = list;
        this.lookAheadTest = list2;
    }

    public static HomeFragmentStateAdapter MyBillsEntityDataFactory(HomeTabs homeTabs, FragmentManager fragmentManager, Lifecycle lifecycle, HomeFragmentListener homeFragmentListener, KybPageInfo kybPageInfo) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(HomeTabFragment.BuiltInFictitiousFunctionClassFactory(homeTabs, homeFragmentListener, kybPageInfo));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((Fragment) it.next()).hashCode()));
        }
        return new HomeFragmentStateAdapter(fragmentManager, lifecycle, arrayList, arrayList2);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        return this.lookAheadTest.contains(Long.valueOf(j));
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.lookAheadTest.get(i).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(BaseFragment baseFragment, Function1<Integer, Boolean> function1) {
        if (this.getAuthRequestContext.size() <= 2) {
            if (this.getAuthRequestContext.size() == 1) {
                getAuthRequestContext(baseFragment, 1);
            } else if (function1.invoke(1).booleanValue()) {
            } else {
                getAuthRequestContext(baseFragment, 2);
            }
        } else if (function1.invoke(2).booleanValue()) {
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(baseFragment, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(BaseFragment baseFragment, Function1<Integer, Boolean> function1) {
        if ((this.getAuthRequestContext.size() <= 0 || !(this.getAuthRequestContext.get(0) instanceof HomeTabFragment)) && this.getAuthRequestContext.size() > 0 && !function1.invoke(0).booleanValue() && !(this.getAuthRequestContext.get(0) instanceof HomeTabFragment)) {
            KClassImpl$Data$declaredNonStaticMembers$2(baseFragment, 0);
        } else {
            getAuthRequestContext(baseFragment, 0);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(BaseFragment baseFragment, int i) {
        this.getAuthRequestContext.remove(i);
        this.getAuthRequestContext.add(i, baseFragment);
        this.lookAheadTest.set(i, Long.valueOf(baseFragment.hashCode()));
        notifyItemChanged(i);
    }

    private void getAuthRequestContext(BaseFragment baseFragment, int i) {
        this.getAuthRequestContext.add(i, baseFragment);
        this.lookAheadTest.add(i, Long.valueOf(baseFragment.hashCode()));
        notifyItemInserted(i);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.getAuthRequestContext.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.getAuthRequestContext.size();
    }
}
