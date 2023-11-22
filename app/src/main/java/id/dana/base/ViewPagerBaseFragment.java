package id.dana.base;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import id.dana.utils.ViewPager2Adapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0002\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0004\b\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015"}, d2 = {"Lid/dana/base/ViewPagerBaseFragment;", "Lid/dana/base/BaseFragment;", "getAuthRequestContext", "()Lid/dana/base/BaseFragment;", "", "MyBillsEntityDataFactory", "()I", "p0", "BuiltInFictitiousFunctionClassFactory", "(I)Lid/dana/base/BaseFragment;", "", "onBackPressed", "()Z", "Landroidx/viewpager2/widget/ViewPager2;", "Lid/dana/base/BaseFragmentViewPager2StateAdapter;", "p1", "", "(Landroidx/viewpager2/widget/ViewPager2;Lid/dana/base/BaseFragmentViewPager2StateAdapter;)V", "PlaceComponentResult", "(I)V", "Lid/dana/utils/ViewPager2Adapter;", "Lid/dana/utils/ViewPager2Adapter;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ViewPagerBaseFragment extends BaseFragment {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ViewPager2Adapter BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    public void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.clear();
    }

    public View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        BuiltInFictitiousFunctionClassFactory();
    }

    public final void getAuthRequestContext(ViewPager2 p0, BaseFragmentViewPager2StateAdapter p1) {
        ViewPager2Adapter viewPager2Adapter = null;
        if (p0 != null && p1 != null) {
            ViewPager2Adapter.Companion companion = ViewPager2Adapter.INSTANCE;
            viewPager2Adapter = ViewPager2Adapter.Companion.PlaceComponentResult(p0, p1);
        }
        this.BuiltInFictitiousFunctionClassFactory = viewPager2Adapter;
    }

    public final int MyBillsEntityDataFactory() {
        ViewPager2Adapter viewPager2Adapter = this.BuiltInFictitiousFunctionClassFactory;
        if (viewPager2Adapter != null) {
            return viewPager2Adapter.getAuthRequestContext.getCurrentItem();
        }
        return 0;
    }

    public final void PlaceComponentResult(int p0) {
        ViewPager2Adapter viewPager2Adapter = this.BuiltInFictitiousFunctionClassFactory;
        if (viewPager2Adapter != null) {
            viewPager2Adapter.getAuthRequestContext.setCurrentItem(p0);
        }
    }

    public final BaseFragment getAuthRequestContext() {
        ViewPager2Adapter viewPager2Adapter = this.BuiltInFictitiousFunctionClassFactory;
        if (viewPager2Adapter == null || viewPager2Adapter.MyBillsEntityDataFactory.getPlaceComponentResult() == 0) {
            return null;
        }
        BaseFragmentViewPager2StateAdapter baseFragmentViewPager2StateAdapter = viewPager2Adapter.MyBillsEntityDataFactory;
        return baseFragmentViewPager2StateAdapter.PlaceComponentResult.get(viewPager2Adapter.getAuthRequestContext.getCurrentItem());
    }

    public final BaseFragment BuiltInFictitiousFunctionClassFactory(int p0) {
        ViewPager2Adapter viewPager2Adapter = this.BuiltInFictitiousFunctionClassFactory;
        if (viewPager2Adapter == null || viewPager2Adapter.MyBillsEntityDataFactory.getPlaceComponentResult() == 0) {
            return null;
        }
        return viewPager2Adapter.MyBillsEntityDataFactory.PlaceComponentResult.get(p0);
    }

    @Override // id.dana.base.BaseFragment
    public boolean onBackPressed() {
        ViewPager2Adapter viewPager2Adapter = this.BuiltInFictitiousFunctionClassFactory;
        return viewPager2Adapter != null && viewPager2Adapter.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ BaseFragment KClassImpl$Data$declaredNonStaticMembers$2(ViewPagerBaseFragment viewPagerBaseFragment) {
        ViewPager2Adapter viewPager2Adapter = viewPagerBaseFragment.BuiltInFictitiousFunctionClassFactory;
        if (viewPager2Adapter == null || viewPager2Adapter.MyBillsEntityDataFactory.getPlaceComponentResult() == 0) {
            return null;
        }
        BaseFragmentViewPager2StateAdapter baseFragmentViewPager2StateAdapter = viewPager2Adapter.MyBillsEntityDataFactory;
        return baseFragmentViewPager2StateAdapter.PlaceComponentResult.get(viewPager2Adapter.getAuthRequestContext.getCurrentItem());
    }
}
