package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class GhostViewHolder extends FrameLayout {
    boolean BuiltInFictitiousFunctionClassFactory;
    ViewGroup PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.PlaceComponentResult = viewGroup;
        viewGroup.setTag(R.id.PlaceComponentResult, this);
        ViewGroupUtils.getAuthRequestContext(this.PlaceComponentResult).getAuthRequestContext(this);
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.PlaceComponentResult.setTag(R.id.PlaceComponentResult, null);
            ViewGroupUtils.getAuthRequestContext(this.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(this);
            this.BuiltInFictitiousFunctionClassFactory = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewHolder MyBillsEntityDataFactory(ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.PlaceComponentResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (!arrayList.isEmpty() && !arrayList2.isEmpty() && arrayList.get(0) == arrayList2.get(0)) {
            int min = Math.min(arrayList.size(), arrayList2.size());
            for (int i = 1; i < min; i++) {
                View view = arrayList.get(i);
                View view2 = arrayList2.get(i);
                if (view != view2) {
                    return PlaceComponentResult(view, view2);
                }
            }
            if (arrayList2.size() != min) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            getAuthRequestContext((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean PlaceComponentResult(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(ViewGroupUtils.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup, i));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                return true;
            }
        }
        return true;
    }
}
