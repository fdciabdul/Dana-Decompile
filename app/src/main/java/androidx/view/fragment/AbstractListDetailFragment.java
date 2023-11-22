package androidx.view.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.view.C0212R;
import androidx.view.LifecycleOwner;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.fragment.NavHostFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001e"}, d2 = {"Landroidx/navigation/fragment/AbstractListDetailFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "Landroid/os/Bundle;", "p2", "Landroid/view/View;", "PlaceComponentResult", "()Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/os/Bundle;)V", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewStateRestored", "Landroidx/navigation/fragment/NavHostFragment;", "MyBillsEntityDataFactory", "Landroidx/navigation/fragment/NavHostFragment;", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "<init>", "()V", "InnerOnBackPressedCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class AbstractListDetailFragment extends Fragment {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private OnBackPressedCallback PlaceComponentResult;
    private NavHostFragment MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    public abstract View PlaceComponentResult();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\tR\u0014\u0010\b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000f"}, d2 = {"Landroidx/navigation/fragment/AbstractListDetailFragment$InnerOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$PanelSlideListener;", "", "handleOnBackPressed", "()V", "Landroid/view/View;", "p0", "getAuthRequestContext", "(Landroid/view/View;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p1", "PlaceComponentResult", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "<init>", "(Landroidx/slidingpanelayout/widget/SlidingPaneLayout;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final SlidingPaneLayout getAuthRequestContext;

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public final void PlaceComponentResult(View view) {
            Intrinsics.checkNotNullParameter(view, "");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(SlidingPaneLayout slidingPaneLayout) {
            super(true);
            Intrinsics.checkNotNullParameter(slidingPaneLayout, "");
            this.getAuthRequestContext = slidingPaneLayout;
            slidingPaneLayout.addPanelSlideListener(this);
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            this.getAuthRequestContext.closePane();
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(View p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public final void getAuthRequestContext(View p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context p0, AttributeSet p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        super.onInflate(p0, p1, p2);
        TypedArray obtainStyledAttributes = p0.obtainStyledAttributes(p1, C0212R.styleable.lookAheadTest);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        int resourceId = obtainStyledAttributes.getResourceId(C0212R.styleable.scheduleImpl, 0);
        if (resourceId != 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = resourceId;
        }
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        NavHostFragment navHostFragment;
        Intrinsics.checkNotNullParameter(p0, "");
        if (p2 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = p2.getInt("android-support-nav:fragment:graphId");
        }
        final SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(p0.getContext());
        slidingPaneLayout.setId(R.id.res_0x7f0a123c_kclassimpl_data_declarednonstaticmembers_2);
        View PlaceComponentResult = PlaceComponentResult();
        if (!Intrinsics.areEqual(PlaceComponentResult, slidingPaneLayout) && !Intrinsics.areEqual(PlaceComponentResult.getParent(), slidingPaneLayout)) {
            slidingPaneLayout.addView(PlaceComponentResult);
        }
        Context context = p0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(R.id.sliding_pane_detail_container);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(p0.getContext().getResources().getDimensionPixelSize(R.dimen.PlaceComponentResult_res_0x7f070378));
        layoutParams.MyBillsEntityDataFactory = 1.0f;
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(R.id.sliding_pane_detail_container);
        if (findFragmentById != null) {
            navHostFragment = (NavHostFragment) findFragmentById;
        } else {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                NavHostFragment.Companion companion = NavHostFragment.INSTANCE;
                navHostFragment = NavHostFragment.Companion.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                navHostFragment = new NavHostFragment();
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "");
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
            beginTransaction.isLayoutRequested = true;
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(R.id.sliding_pane_detail_container, navHostFragment, null, 1);
            beginTransaction.getAuthRequestContext();
        }
        this.MyBillsEntityDataFactory = navHostFragment;
        this.PlaceComponentResult = new InnerOnBackPressedCallback(slidingPaneLayout);
        SlidingPaneLayout slidingPaneLayout2 = slidingPaneLayout;
        if (!ViewCompat.getValueOfTouchPositionAbsolute(slidingPaneLayout2) || slidingPaneLayout2.isLayoutRequested()) {
            slidingPaneLayout2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.navigation.fragment.AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View p02, int p12, int p22, int p3, int p4, int p5, int p6, int p7, int p8) {
                    OnBackPressedCallback onBackPressedCallback;
                    Intrinsics.checkParameterIsNotNull(p02, "");
                    p02.removeOnLayoutChangeListener(this);
                    onBackPressedCallback = AbstractListDetailFragment.this.PlaceComponentResult;
                    Intrinsics.checkNotNull(onBackPressedCallback);
                    onBackPressedCallback.setEnabled(slidingPaneLayout.isSlideable() && slidingPaneLayout.isOpen());
                }
            });
        } else {
            OnBackPressedCallback onBackPressedCallback = this.PlaceComponentResult;
            Intrinsics.checkNotNull(onBackPressedCallback);
            onBackPressedCallback.setEnabled(slidingPaneLayout.isSlideable() && slidingPaneLayout.isOpen());
        }
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        OnBackPressedCallback onBackPressedCallback2 = this.PlaceComponentResult;
        Intrinsics.checkNotNull(onBackPressedCallback2);
        onBackPressedDispatcher.PlaceComponentResult(viewLifecycleOwner, onBackPressedCallback2);
        return slidingPaneLayout2;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        View childAt = ((SlidingPaneLayout) requireView()).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "");
        Intrinsics.checkNotNullParameter(childAt, "");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle p0) {
        super.onViewStateRestored(p0);
        OnBackPressedCallback onBackPressedCallback = this.PlaceComponentResult;
        Intrinsics.checkNotNull(onBackPressedCallback);
        onBackPressedCallback.setEnabled(((SlidingPaneLayout) requireView()).isSlideable() && ((SlidingPaneLayout) requireView()).isOpen());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onSaveInstanceState(p0);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0) {
            p0.putInt("android-support-nav:fragment:graphId", i);
        }
    }
}
