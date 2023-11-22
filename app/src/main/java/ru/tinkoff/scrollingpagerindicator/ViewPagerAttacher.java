package ru.tinkoff.scrollingpagerindicator;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

/* loaded from: classes9.dex */
public class ViewPagerAttacher implements ScrollingPagerIndicator.PagerAttacher<ViewPager> {
    private ViewPager.OnPageChangeListener BuiltInFictitiousFunctionClassFactory;
    private PagerAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    private ViewPager MyBillsEntityDataFactory;
    private DataSetObserver getAuthRequestContext;

    @Override // ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.PagerAttacher
    public final /* synthetic */ void PlaceComponentResult(final ScrollingPagerIndicator scrollingPagerIndicator, ViewPager viewPager) {
        final ViewPager viewPager2 = viewPager;
        PagerAdapter adapter = viewPager2.getAdapter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = adapter;
        if (adapter == null) {
            throw new IllegalStateException("Set adapter before call attachToPager() method");
        }
        this.MyBillsEntityDataFactory = viewPager2;
        scrollingPagerIndicator.setDotCount(adapter.getCount());
        scrollingPagerIndicator.setCurrentPosition(viewPager2.getCurrentItem());
        DataSetObserver dataSetObserver = new DataSetObserver() { // from class: ru.tinkoff.scrollingpagerindicator.ViewPagerAttacher.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                scrollingPagerIndicator.reattach();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                onChanged();
            }
        };
        this.getAuthRequestContext = dataSetObserver;
        this.KClassImpl$Data$declaredNonStaticMembers$2.registerDataSetObserver(dataSetObserver);
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: ru.tinkoff.scrollingpagerindicator.ViewPagerAttacher.2
            boolean MyBillsEntityDataFactory = true;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (f < 0.0f) {
                    f = 0.0f;
                } else if (f > 1.0f) {
                    f = 1.0f;
                }
                scrollingPagerIndicator.onPageScrolled(i, f);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (this.MyBillsEntityDataFactory) {
                    scrollingPagerIndicator.setDotCount(ViewPagerAttacher.this.KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                    scrollingPagerIndicator.setCurrentPosition(viewPager2.getCurrentItem());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                this.MyBillsEntityDataFactory = i == 0;
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = onPageChangeListener;
        viewPager2.addOnPageChangeListener(onPageChangeListener);
    }

    @Override // ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.PagerAttacher
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.unregisterDataSetObserver(this.getAuthRequestContext);
        this.MyBillsEntityDataFactory.removeOnPageChangeListener(this.BuiltInFictitiousFunctionClassFactory);
    }
}
