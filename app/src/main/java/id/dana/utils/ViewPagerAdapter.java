package id.dana.utils;

import androidx.viewpager.widget.ViewPager;
import id.dana.base.BaseFragmentPagerStateAdapter;

/* loaded from: classes5.dex */
public class ViewPagerAdapter {
    public BaseFragmentPagerStateAdapter MyBillsEntityDataFactory;
    public ViewPager PlaceComponentResult;

    private ViewPagerAdapter(ViewPager viewPager, BaseFragmentPagerStateAdapter baseFragmentPagerStateAdapter) {
        viewPager.setAdapter(baseFragmentPagerStateAdapter);
        this.PlaceComponentResult = viewPager;
        this.MyBillsEntityDataFactory = baseFragmentPagerStateAdapter;
    }

    public static ViewPagerAdapter BuiltInFictitiousFunctionClassFactory(ViewPager viewPager, BaseFragmentPagerStateAdapter baseFragmentPagerStateAdapter) {
        return new ViewPagerAdapter(viewPager, baseFragmentPagerStateAdapter);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        BaseFragmentPagerStateAdapter baseFragmentPagerStateAdapter = this.MyBillsEntityDataFactory;
        return baseFragmentPagerStateAdapter.getAuthRequestContext.get(this.PlaceComponentResult.getCurrentItem()).onBackPressed();
    }
}
