package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    private Fragment BuiltInFictitiousFunctionClassFactory;
    private FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private final int PlaceComponentResult;
    private final FragmentManager getAuthRequestContext;

    public abstract Fragment MyBillsEntityDataFactory(int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, (byte) 0);
    }

    private FragmentPagerAdapter(FragmentManager fragmentManager, byte b) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext = fragmentManager;
        this.PlaceComponentResult = 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ViewPager with adapter ");
        sb.append(this);
        sb.append(" requires a view id");
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.beginTransaction();
        }
        long j = i;
        Fragment findFragmentByTag = this.getAuthRequestContext.findFragmentByTag(getAuthRequestContext(viewGroup.getId(), j));
        if (findFragmentByTag == null) {
            findFragmentByTag = MyBillsEntityDataFactory(i);
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup.getId(), findFragmentByTag, getAuthRequestContext(viewGroup.getId(), j), 1);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(new FragmentTransaction.Op(7, findFragmentByTag));
        }
        if (findFragmentByTag != this.BuiltInFictitiousFunctionClassFactory) {
            findFragmentByTag.setMenuVisibility(false);
            if (this.PlaceComponentResult == 1) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(findFragmentByTag, Lifecycle.State.STARTED);
            } else {
                findFragmentByTag.setUserVisibleHint(false);
            }
        }
        return findFragmentByTag;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.beginTransaction();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(fragment);
        if (fragment.equals(this.BuiltInFictitiousFunctionClassFactory)) {
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.BuiltInFictitiousFunctionClassFactory;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.PlaceComponentResult == 1) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.beginTransaction();
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, Lifecycle.State.STARTED);
                } else {
                    this.BuiltInFictitiousFunctionClassFactory.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.PlaceComponentResult == 1) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.beginTransaction();
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.BuiltInFictitiousFunctionClassFactory = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentTransaction != null) {
            if (!this.MyBillsEntityDataFactory) {
                try {
                    this.MyBillsEntityDataFactory = true;
                    fragmentTransaction.MyBillsEntityDataFactory();
                } finally {
                    this.MyBillsEntityDataFactory = false;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getGetAuthRequestContext() == view;
    }

    private static String getAuthRequestContext(int i, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("android:switcher:");
        sb.append(i);
        sb.append(":");
        sb.append(j);
        return sb.toString();
    }
}
