package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    final FragmentManager BuiltInFictitiousFunctionClassFactory;
    final LongSparseArray<Fragment> KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    private final LongSparseArray<Integer> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Lifecycle PlaceComponentResult;
    private FragmentMaxLifecycleEnforcer getAuthRequestContext;
    private boolean moveToNextValue;
    private final LongSparseArray<Fragment.SavedState> scheduleImpl;

    public abstract Fragment KClassImpl$Data$declaredNonStaticMembers$2(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(FragmentViewHolder fragmentViewHolder, int i) {
        final FragmentViewHolder fragmentViewHolder2 = fragmentViewHolder;
        long itemId = fragmentViewHolder2.getItemId();
        int id2 = ((FrameLayout) fragmentViewHolder2.itemView).getId();
        Long authRequestContext = getAuthRequestContext(id2);
        if (authRequestContext != null && authRequestContext.longValue() != itemId) {
            BuiltInFictitiousFunctionClassFactory(authRequestContext.longValue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(authRequestContext.longValue());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(itemId, Integer.valueOf(id2));
        long itemId2 = getItemId(i);
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(itemId2)) {
            Fragment KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(i);
            KClassImpl$Data$declaredNonStaticMembers$2.setInitialSavedState(this.scheduleImpl.MyBillsEntityDataFactory(itemId2, null));
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(itemId2, KClassImpl$Data$declaredNonStaticMembers$2);
        }
        final FrameLayout frameLayout = (FrameLayout) fragmentViewHolder2.itemView;
        if (ViewCompat.C(frameLayout)) {
            if (frameLayout.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1
                {
                    FragmentStateAdapter.this = this;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (frameLayout.getParent() != null) {
                        frameLayout.removeOnLayoutChangeListener(this);
                        FragmentStateAdapter.this.BuiltInFictitiousFunctionClassFactory(fragmentViewHolder2);
                    }
                }
            });
        }
        PlaceComponentResult();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        BuiltInFictitiousFunctionClassFactory(fragmentViewHolder);
        PlaceComponentResult();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long authRequestContext = getAuthRequestContext(((FrameLayout) fragmentViewHolder.itemView).getId());
        if (authRequestContext != null) {
            BuiltInFictitiousFunctionClassFactory(authRequestContext.longValue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(authRequestContext.longValue());
        }
    }

    public FragmentStateAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LongSparseArray<>();
        this.scheduleImpl = new LongSparseArray<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LongSparseArray<>();
        this.MyBillsEntityDataFactory = false;
        this.moveToNextValue = false;
        this.BuiltInFictitiousFunctionClassFactory = fragmentManager;
        this.PlaceComponentResult = lifecycle;
        super.setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Preconditions.getAuthRequestContext(this.getAuthRequestContext == null);
        final FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.getAuthRequestContext = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.BuiltInFictitiousFunctionClassFactory = FragmentMaxLifecycleEnforcer.MyBillsEntityDataFactory(recyclerView);
        ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                fragmentMaxLifecycleEnforcer.BuiltInFictitiousFunctionClassFactory(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                fragmentMaxLifecycleEnforcer.BuiltInFictitiousFunctionClassFactory(false);
            }
        };
        fragmentMaxLifecycleEnforcer.getAuthRequestContext = onPageChangeCallback;
        fragmentMaxLifecycleEnforcer.BuiltInFictitiousFunctionClassFactory.registerOnPageChangeCallback(onPageChangeCallback);
        DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                fragmentMaxLifecycleEnforcer.BuiltInFictitiousFunctionClassFactory(true);
            }
        };
        fragmentMaxLifecycleEnforcer.MyBillsEntityDataFactory = dataSetChangeObserver;
        FragmentStateAdapter.this.registerAdapterDataObserver(dataSetChangeObserver);
        fragmentMaxLifecycleEnforcer.PlaceComponentResult = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
            @Override // androidx.view.LifecycleEventObserver
            public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                fragmentMaxLifecycleEnforcer.BuiltInFictitiousFunctionClassFactory(false);
            }
        };
        FragmentStateAdapter.this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(fragmentMaxLifecycleEnforcer.PlaceComponentResult);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = this.getAuthRequestContext;
        FragmentMaxLifecycleEnforcer.MyBillsEntityDataFactory(recyclerView).unregisterOnPageChangeCallback(fragmentMaxLifecycleEnforcer.getAuthRequestContext);
        FragmentStateAdapter.this.unregisterAdapterDataObserver(fragmentMaxLifecycleEnforcer.MyBillsEntityDataFactory);
        FragmentStateAdapter.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(fragmentMaxLifecycleEnforcer.PlaceComponentResult);
        fragmentMaxLifecycleEnforcer.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext = null;
    }

    final void PlaceComponentResult() {
        if (!this.moveToNextValue || BuiltInFictitiousFunctionClassFactory()) {
            return;
        }
        ArraySet arraySet = new ArraySet();
        int i = 0;
        int i2 = 0;
        while (true) {
            LongSparseArray<Fragment> longSparseArray = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            if (i2 >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                break;
            }
            LongSparseArray<Fragment> longSparseArray2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (longSparseArray2.MyBillsEntityDataFactory) {
                longSparseArray2.BuiltInFictitiousFunctionClassFactory();
            }
            long j = longSparseArray2.PlaceComponentResult[i2];
            if (!KClassImpl$Data$declaredNonStaticMembers$2(j)) {
                arraySet.add(Long.valueOf(j));
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(j);
            }
            i2++;
        }
        if (!this.MyBillsEntityDataFactory) {
            this.moveToNextValue = false;
            while (true) {
                LongSparseArray<Fragment> longSparseArray3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (longSparseArray3.MyBillsEntityDataFactory) {
                    longSparseArray3.BuiltInFictitiousFunctionClassFactory();
                }
                if (i >= longSparseArray3.KClassImpl$Data$declaredNonStaticMembers$2) {
                    break;
                }
                LongSparseArray<Fragment> longSparseArray4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (longSparseArray4.MyBillsEntityDataFactory) {
                    longSparseArray4.BuiltInFictitiousFunctionClassFactory();
                }
                long j2 = longSparseArray4.PlaceComponentResult[i];
                if (!MyBillsEntityDataFactory(j2)) {
                    arraySet.add(Long.valueOf(j2));
                }
                i++;
            }
        }
        Iterator<E> it = arraySet.iterator();
        while (it.hasNext()) {
            BuiltInFictitiousFunctionClassFactory(((Long) it.next()).longValue());
        }
    }

    private boolean MyBillsEntityDataFactory(long j) {
        View getAuthRequestContext;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(j)) {
            return true;
        }
        Fragment MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(j, null);
        return (MyBillsEntityDataFactory == null || (getAuthRequestContext = MyBillsEntityDataFactory.getGetAuthRequestContext()) == null || getAuthRequestContext.getParent() == null) ? false : true;
    }

    private Long getAuthRequestContext(int i) {
        Long l = null;
        int i2 = 0;
        while (true) {
            LongSparseArray<Integer> longSparseArray = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            if (i2 >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                return l;
            }
            LongSparseArray<Integer> longSparseArray2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (longSparseArray2.MyBillsEntityDataFactory) {
                longSparseArray2.BuiltInFictitiousFunctionClassFactory();
            }
            if (((Integer) longSparseArray2.BuiltInFictitiousFunctionClassFactory[i2]).intValue() == i) {
                if (l != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                LongSparseArray<Integer> longSparseArray3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (longSparseArray3.MyBillsEntityDataFactory) {
                    longSparseArray3.BuiltInFictitiousFunctionClassFactory();
                }
                l = Long.valueOf(longSparseArray3.PlaceComponentResult[i2]);
            }
            i2++;
        }
    }

    final void BuiltInFictitiousFunctionClassFactory(final FragmentViewHolder fragmentViewHolder) {
        final Fragment MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(fragmentViewHolder.getItemId(), null);
        if (MyBillsEntityDataFactory == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        final FrameLayout frameLayout = (FrameLayout) fragmentViewHolder.itemView;
        View getAuthRequestContext = MyBillsEntityDataFactory.getGetAuthRequestContext();
        if (!MyBillsEntityDataFactory.isAdded() && getAuthRequestContext != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (!MyBillsEntityDataFactory.isAdded() || getAuthRequestContext != null) {
            if (MyBillsEntityDataFactory.isAdded() && getAuthRequestContext.getParent() != null) {
                if (getAuthRequestContext.getParent() != frameLayout) {
                    BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, frameLayout);
                    return;
                }
                return;
            } else if (MyBillsEntityDataFactory.isAdded()) {
                BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, frameLayout);
                return;
            } else if (BuiltInFictitiousFunctionClassFactory()) {
                if (this.BuiltInFictitiousFunctionClassFactory.isDestroyed()) {
                    return;
                }
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                    {
                        FragmentStateAdapter.this = this;
                    }

                    @Override // androidx.view.LifecycleEventObserver
                    public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        if (FragmentStateAdapter.this.BuiltInFictitiousFunctionClassFactory()) {
                            return;
                        }
                        lifecycleOwner.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this);
                        if (ViewCompat.C((FrameLayout) fragmentViewHolder.itemView)) {
                            FragmentStateAdapter.this.BuiltInFictitiousFunctionClassFactory(fragmentViewHolder);
                        }
                    }
                });
                return;
            } else {
                this.BuiltInFictitiousFunctionClassFactory.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
                    {
                        FragmentStateAdapter.this = this;
                    }

                    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
                    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
                        if (fragment == MyBillsEntityDataFactory) {
                            fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                            FragmentStateAdapter.BuiltInFictitiousFunctionClassFactory(view, frameLayout);
                        }
                    }
                }, false);
                FragmentTransaction beginTransaction = this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
                StringBuilder sb = new StringBuilder();
                sb.append(f.f7258a);
                sb.append(fragmentViewHolder.getItemId());
                beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(0, MyBillsEntityDataFactory, sb.toString(), 1);
                beginTransaction.PlaceComponentResult(MyBillsEntityDataFactory, Lifecycle.State.STARTED).BuiltInFictitiousFunctionClassFactory();
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(false);
                return;
            }
        }
        this.BuiltInFictitiousFunctionClassFactory.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
            {
                FragmentStateAdapter.this = this;
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
                if (fragment == MyBillsEntityDataFactory) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.BuiltInFictitiousFunctionClassFactory(view, frameLayout);
                }
            }
        }, false);
    }

    static void BuiltInFictitiousFunctionClassFactory(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    private void BuiltInFictitiousFunctionClassFactory(long j) {
        ViewParent parent;
        Fragment MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(j, null);
        if (MyBillsEntityDataFactory == null) {
            return;
        }
        if (MyBillsEntityDataFactory.getGetAuthRequestContext() != null && (parent = MyBillsEntityDataFactory.getGetAuthRequestContext().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!KClassImpl$Data$declaredNonStaticMembers$2(j)) {
            this.scheduleImpl.PlaceComponentResult(j);
        }
        if (!MyBillsEntityDataFactory.isAdded()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(j);
        } else if (BuiltInFictitiousFunctionClassFactory()) {
            this.moveToNextValue = true;
        } else {
            if (MyBillsEntityDataFactory.isAdded() && KClassImpl$Data$declaredNonStaticMembers$2(j)) {
                this.scheduleImpl.getAuthRequestContext(j, this.BuiltInFictitiousFunctionClassFactory.saveFragmentInstanceState(MyBillsEntityDataFactory));
            }
            this.BuiltInFictitiousFunctionClassFactory.beginTransaction().KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory();
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(j);
        }
    }

    final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.isStateSaved();
    }

    public boolean KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        return j >= 0 && j < ((long) getPlaceComponentResult());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable KClassImpl$Data$declaredNonStaticMembers$2() {
        Bundle bundle = new Bundle(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() + this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2());
        int i = 0;
        int i2 = 0;
        while (true) {
            LongSparseArray<Fragment> longSparseArray = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            if (i2 >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                break;
            }
            LongSparseArray<Fragment> longSparseArray2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (longSparseArray2.MyBillsEntityDataFactory) {
                longSparseArray2.BuiltInFictitiousFunctionClassFactory();
            }
            long j = longSparseArray2.PlaceComponentResult[i2];
            Fragment MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(j, null);
            if (MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.isAdded()) {
                StringBuilder sb = new StringBuilder();
                sb.append("f#");
                sb.append(j);
                this.BuiltInFictitiousFunctionClassFactory.putFragment(bundle, sb.toString(), MyBillsEntityDataFactory);
            }
            i2++;
        }
        while (true) {
            LongSparseArray<Fragment.SavedState> longSparseArray3 = this.scheduleImpl;
            if (longSparseArray3.MyBillsEntityDataFactory) {
                longSparseArray3.BuiltInFictitiousFunctionClassFactory();
            }
            if (i >= longSparseArray3.KClassImpl$Data$declaredNonStaticMembers$2) {
                return bundle;
            }
            LongSparseArray<Fragment.SavedState> longSparseArray4 = this.scheduleImpl;
            if (longSparseArray4.MyBillsEntityDataFactory) {
                longSparseArray4.BuiltInFictitiousFunctionClassFactory();
            }
            long j2 = longSparseArray4.PlaceComponentResult[i];
            if (KClassImpl$Data$declaredNonStaticMembers$2(j2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("s#");
                sb2.append(j2);
                bundle.putParcelable(sb2.toString(), this.scheduleImpl.MyBillsEntityDataFactory(j2, null));
            }
            i++;
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void getAuthRequestContext(Parcelable parcelable) {
        if (!this.scheduleImpl.PlaceComponentResult() || !this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (BuiltInFictitiousFunctionClassFactory(str, "f#")) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(Long.parseLong(str.substring(2)), this.BuiltInFictitiousFunctionClassFactory.getFragment(bundle, str));
            } else {
                if (!BuiltInFictitiousFunctionClassFactory(str, "s#")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected key in savedState: ");
                    sb.append(str);
                    throw new IllegalArgumentException(sb.toString());
                }
                long parseLong = Long.parseLong(str.substring(2));
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (KClassImpl$Data$declaredNonStaticMembers$2(parseLong)) {
                    this.scheduleImpl.getAuthRequestContext(parseLong, savedState);
                }
            }
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()) {
            return;
        }
        this.moveToNextValue = true;
        this.MyBillsEntityDataFactory = true;
        PlaceComponentResult();
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
            {
                FragmentStateAdapter.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter.this.MyBillsEntityDataFactory = false;
                FragmentStateAdapter.this.PlaceComponentResult();
            }
        };
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            {
                FragmentStateAdapter.this = this;
            }

            @Override // androidx.view.LifecycleEventObserver
            public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    lifecycleOwner.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this);
                }
            }
        });
        handler.postDelayed(runnable, 10000L);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    /* loaded from: classes3.dex */
    public class FragmentMaxLifecycleEnforcer {
        ViewPager2 BuiltInFictitiousFunctionClassFactory;
        RecyclerView.AdapterDataObserver MyBillsEntityDataFactory;
        LifecycleEventObserver PlaceComponentResult;
        ViewPager2.OnPageChangeCallback getAuthRequestContext;
        private long getErrorConfigVersion = -1;

        FragmentMaxLifecycleEnforcer() {
            FragmentStateAdapter.this = r3;
        }

        final void BuiltInFictitiousFunctionClassFactory(boolean z) {
            int currentItem;
            if (FragmentStateAdapter.this.BuiltInFictitiousFunctionClassFactory() || this.BuiltInFictitiousFunctionClassFactory.getScrollState() != 0 || FragmentStateAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult() || FragmentStateAdapter.this.getPlaceComponentResult() == 0 || (currentItem = this.BuiltInFictitiousFunctionClassFactory.getCurrentItem()) >= FragmentStateAdapter.this.getPlaceComponentResult()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if (itemId != this.getErrorConfigVersion || z) {
                Fragment fragment = null;
                Fragment MyBillsEntityDataFactory = FragmentStateAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(itemId, null);
                if (MyBillsEntityDataFactory == null || !MyBillsEntityDataFactory.isAdded()) {
                    return;
                }
                this.getErrorConfigVersion = itemId;
                FragmentTransaction beginTransaction = FragmentStateAdapter.this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
                int i = 0;
                while (true) {
                    LongSparseArray<Fragment> longSparseArray = FragmentStateAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (longSparseArray.MyBillsEntityDataFactory) {
                        longSparseArray.BuiltInFictitiousFunctionClassFactory();
                    }
                    if (i >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                        break;
                    }
                    LongSparseArray<Fragment> longSparseArray2 = FragmentStateAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (longSparseArray2.MyBillsEntityDataFactory) {
                        longSparseArray2.BuiltInFictitiousFunctionClassFactory();
                    }
                    long j = longSparseArray2.PlaceComponentResult[i];
                    LongSparseArray<Fragment> longSparseArray3 = FragmentStateAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (longSparseArray3.MyBillsEntityDataFactory) {
                        longSparseArray3.BuiltInFictitiousFunctionClassFactory();
                    }
                    Fragment fragment2 = (Fragment) longSparseArray3.BuiltInFictitiousFunctionClassFactory[i];
                    if (fragment2.isAdded()) {
                        if (j != this.getErrorConfigVersion) {
                            beginTransaction.PlaceComponentResult(fragment2, Lifecycle.State.STARTED);
                        } else {
                            fragment = fragment2;
                        }
                        fragment2.setMenuVisibility(j == this.getErrorConfigVersion);
                    }
                    i++;
                }
                if (fragment != null) {
                    beginTransaction.PlaceComponentResult(fragment, Lifecycle.State.RESUMED);
                }
                if (beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    return;
                }
                beginTransaction.BuiltInFictitiousFunctionClassFactory();
            }
        }

        static ViewPager2 MyBillsEntityDataFactory(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected ViewPager2 instance. Got: ");
            sb.append(parent);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        /* synthetic */ DataSetChangeObserver(byte b) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return FragmentViewHolder.PlaceComponentResult(viewGroup);
    }
}
