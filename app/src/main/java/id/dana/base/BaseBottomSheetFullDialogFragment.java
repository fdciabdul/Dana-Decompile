package id.dana.base;

import android.app.Dialog;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\f"}, d2 = {"Lid/dana/base/BaseBottomSheetFullDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "p0", "p1", "", "initBottomSheet", "(II)V", "onShow", "()V", "onStart", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseBottomSheetFullDialogFragment extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    public View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    protected float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void initBottomSheet(int p0, int p1) {
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        super.initBottomSheet(p0, p1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        final View findViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
        ViewGroup.LayoutParams layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        final View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: id.dana.base.BaseBottomSheetFullDialogFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseBottomSheetFullDialogFragment.BuiltInFictitiousFunctionClassFactory(view, findViewById);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        ViewGroup.LayoutParams layoutParams = ((View) parent).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).lookAheadTest;
        if (behavior == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        }
        ((BottomSheetBehavior) behavior).setPeekHeight(view.getMeasuredHeight());
        ViewParent parent2 = view2 != null ? view2.getParent() : null;
        if (parent2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        ((View) parent2).setBackgroundColor(0);
    }
}
