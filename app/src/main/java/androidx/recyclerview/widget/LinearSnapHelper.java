package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class LinearSnapHelper extends SnapHelper {
    private OrientationHelper MyBillsEntityDataFactory;
    private OrientationHelper getAuthRequestContext;

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int[] getAuthRequestContext(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            OrientationHelper orientationHelper = this.MyBillsEntityDataFactory;
            if (orientationHelper == null || orientationHelper.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                this.MyBillsEntityDataFactory = OrientationHelper.BuiltInFictitiousFunctionClassFactory(layoutManager);
            }
            OrientationHelper orientationHelper2 = this.MyBillsEntityDataFactory;
            iArr[0] = (orientationHelper2.getAuthRequestContext(view) + (orientationHelper2.MyBillsEntityDataFactory(view) / 2)) - (orientationHelper2.moveToNextValue() + (orientationHelper2.scheduleImpl() / 2));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            OrientationHelper orientationHelper3 = this.getAuthRequestContext;
            if (orientationHelper3 == null || orientationHelper3.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                this.getAuthRequestContext = OrientationHelper.getAuthRequestContext(layoutManager);
            }
            OrientationHelper orientationHelper4 = this.getAuthRequestContext;
            iArr[1] = (orientationHelper4.getAuthRequestContext(view) + (orientationHelper4.MyBillsEntityDataFactory(view) / 2)) - (orientationHelper4.moveToNextValue() + (orientationHelper4.scheduleImpl() / 2));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int PlaceComponentResult(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View PlaceComponentResult;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (PlaceComponentResult = PlaceComponentResult(layoutManager)) == null || (position = layoutManager.getPosition(PlaceComponentResult)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            OrientationHelper orientationHelper = this.MyBillsEntityDataFactory;
            if (orientationHelper == null || orientationHelper.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                this.MyBillsEntityDataFactory = OrientationHelper.BuiltInFictitiousFunctionClassFactory(layoutManager);
            }
            i4 = BuiltInFictitiousFunctionClassFactory(layoutManager, this.MyBillsEntityDataFactory, i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            OrientationHelper orientationHelper2 = this.getAuthRequestContext;
            if (orientationHelper2 == null || orientationHelper2.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                this.getAuthRequestContext = OrientationHelper.getAuthRequestContext(layoutManager);
            }
            i5 = BuiltInFictitiousFunctionClassFactory(layoutManager, this.getAuthRequestContext, 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        int i7 = i6 >= 0 ? i6 : 0;
        return i7 >= itemCount ? i3 : i7;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final View PlaceComponentResult(RecyclerView.LayoutManager layoutManager) {
        if (!layoutManager.canScrollVertically()) {
            if (layoutManager.canScrollHorizontally()) {
                OrientationHelper orientationHelper = this.MyBillsEntityDataFactory;
                if (orientationHelper == null || orientationHelper.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                    this.MyBillsEntityDataFactory = OrientationHelper.BuiltInFictitiousFunctionClassFactory(layoutManager);
                }
                return KClassImpl$Data$declaredNonStaticMembers$2(layoutManager, this.MyBillsEntityDataFactory);
            }
            return null;
        }
        OrientationHelper orientationHelper2 = this.getAuthRequestContext;
        if (orientationHelper2 == null || orientationHelper2.BuiltInFictitiousFunctionClassFactory != layoutManager) {
            this.getAuthRequestContext = OrientationHelper.getAuthRequestContext(layoutManager);
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(layoutManager, this.getAuthRequestContext);
    }

    private int BuiltInFictitiousFunctionClassFactory(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int[] authRequestContext = getAuthRequestContext(i, i2);
        int childCount = layoutManager.getChildCount();
        float f = 1.0f;
        if (childCount != 0) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            View view = null;
            View view2 = null;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = layoutManager.getChildAt(i5);
                int position = layoutManager.getPosition(childAt);
                if (position != -1) {
                    if (position < i3) {
                        view = childAt;
                        i3 = position;
                    }
                    if (position > i4) {
                        view2 = childAt;
                        i4 = position;
                    }
                }
            }
            if (view != null && view2 != null) {
                int max = Math.max(orientationHelper.PlaceComponentResult(view), orientationHelper.PlaceComponentResult(view2)) - Math.min(orientationHelper.getAuthRequestContext(view), orientationHelper.getAuthRequestContext(view2));
                if (max != 0) {
                    f = (max * 1.0f) / ((i4 - i3) + 1);
                }
            }
        }
        if (f <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(authRequestContext[0]) > Math.abs(authRequestContext[1]) ? authRequestContext[0] : authRequestContext[1]) / f);
    }

    private static View KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int moveToNextValue = orientationHelper.moveToNextValue();
        int scheduleImpl = orientationHelper.scheduleImpl() / 2;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs((orientationHelper.getAuthRequestContext(childAt) + (orientationHelper.MyBillsEntityDataFactory(childAt) / 2)) - (moveToNextValue + scheduleImpl));
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }
}
