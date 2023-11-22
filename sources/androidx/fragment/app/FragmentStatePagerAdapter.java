package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.view.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    private FragmentTransaction BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Fragment MyBillsEntityDataFactory;
    private final FragmentManager PlaceComponentResult;
    private final int getAuthRequestContext;
    private ArrayList<Fragment> getErrorConfigVersion;
    private ArrayList<Fragment.SavedState> lookAheadTest;

    public abstract Fragment getAuthRequestContext(int i);

    @Deprecated
    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public FragmentStatePagerAdapter(FragmentManager fragmentManager, int i) {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.lookAheadTest = new ArrayList<>();
        this.getErrorConfigVersion = new ArrayList<>();
        this.MyBillsEntityDataFactory = null;
        this.PlaceComponentResult = fragmentManager;
        this.getAuthRequestContext = i;
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
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.getErrorConfigVersion.size() <= i || (fragment = this.getErrorConfigVersion.get(i)) == null) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.beginTransaction();
            }
            Fragment authRequestContext = getAuthRequestContext(i);
            if (this.lookAheadTest.size() > i && (savedState = this.lookAheadTest.get(i)) != null) {
                authRequestContext.setInitialSavedState(savedState);
            }
            while (this.getErrorConfigVersion.size() <= i) {
                this.getErrorConfigVersion.add(null);
            }
            authRequestContext.setMenuVisibility(false);
            if (this.getAuthRequestContext == 0) {
                authRequestContext.setUserVisibleHint(false);
            }
            this.getErrorConfigVersion.set(i, authRequestContext);
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup.getId(), authRequestContext, null, 1);
            if (this.getAuthRequestContext == 1) {
                this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(authRequestContext, Lifecycle.State.STARTED);
            }
            return authRequestContext;
        }
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.beginTransaction();
        }
        while (this.lookAheadTest.size() <= i) {
            this.lookAheadTest.add(null);
        }
        this.lookAheadTest.set(i, fragment.isAdded() ? this.PlaceComponentResult.saveFragmentInstanceState(fragment) : null);
        this.getErrorConfigVersion.set(i, null);
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(fragment);
        if (fragment.equals(this.MyBillsEntityDataFactory)) {
            this.MyBillsEntityDataFactory = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.MyBillsEntityDataFactory;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.getAuthRequestContext == 1) {
                    if (this.BuiltInFictitiousFunctionClassFactory == null) {
                        this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.beginTransaction();
                    }
                    this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.MyBillsEntityDataFactory, Lifecycle.State.STARTED);
                } else {
                    this.MyBillsEntityDataFactory.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.getAuthRequestContext == 1) {
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.beginTransaction();
                }
                this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.MyBillsEntityDataFactory = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.BuiltInFictitiousFunctionClassFactory;
        if (fragmentTransaction != null) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    fragmentTransaction.MyBillsEntityDataFactory();
                } finally {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                }
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getGetAuthRequestContext() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        if (this.lookAheadTest.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.lookAheadTest.size()];
            this.lookAheadTest.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.getErrorConfigVersion.size(); i++) {
            Fragment fragment = this.getErrorConfigVersion.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(f.f7258a);
                sb.append(i);
                this.PlaceComponentResult.putFragment(bundle, sb.toString(), fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.lookAheadTest.clear();
            this.getErrorConfigVersion.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.lookAheadTest.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(f.f7258a)) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.PlaceComponentResult.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.getErrorConfigVersion.size() <= parseInt) {
                            this.getErrorConfigVersion.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.getErrorConfigVersion.set(parseInt, fragment);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Bad fragment at key ");
                        sb.append(str);
                        InstrumentInjector.log_w("FragmentStatePagerAdapt", sb.toString());
                    }
                }
            }
        }
    }
}
