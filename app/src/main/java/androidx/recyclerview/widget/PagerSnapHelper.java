package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class PagerSnapHelper extends SnapHelper {
    private OrientationHelper MyBillsEntityDataFactory;
    private OrientationHelper PlaceComponentResult;

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
            OrientationHelper orientationHelper3 = this.PlaceComponentResult;
            if (orientationHelper3 == null || orientationHelper3.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                this.PlaceComponentResult = OrientationHelper.getAuthRequestContext(layoutManager);
            }
            OrientationHelper orientationHelper4 = this.PlaceComponentResult;
            iArr[1] = (orientationHelper4.getAuthRequestContext(view) + (orientationHelper4.MyBillsEntityDataFactory(view) / 2)) - (orientationHelper4.moveToNextValue() + (orientationHelper4.scheduleImpl() / 2));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View PlaceComponentResult(RecyclerView.LayoutManager layoutManager) {
        if (!layoutManager.canScrollVertically()) {
            if (layoutManager.canScrollHorizontally()) {
                OrientationHelper orientationHelper = this.MyBillsEntityDataFactory;
                if (orientationHelper == null || orientationHelper.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                    this.MyBillsEntityDataFactory = OrientationHelper.BuiltInFictitiousFunctionClassFactory(layoutManager);
                }
                return MyBillsEntityDataFactory(layoutManager, this.MyBillsEntityDataFactory);
            }
            return null;
        }
        OrientationHelper orientationHelper2 = this.PlaceComponentResult;
        if (orientationHelper2 == null || orientationHelper2.BuiltInFictitiousFunctionClassFactory != layoutManager) {
            this.PlaceComponentResult = OrientationHelper.getAuthRequestContext(layoutManager);
        }
        return MyBillsEntityDataFactory(layoutManager, this.PlaceComponentResult);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int PlaceComponentResult(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        OrientationHelper orientationHelper;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (!layoutManager.canScrollVertically()) {
            if (layoutManager.canScrollHorizontally()) {
                OrientationHelper orientationHelper2 = this.MyBillsEntityDataFactory;
                if (orientationHelper2 == null || orientationHelper2.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                    this.MyBillsEntityDataFactory = OrientationHelper.BuiltInFictitiousFunctionClassFactory(layoutManager);
                }
                orientationHelper = this.MyBillsEntityDataFactory;
            } else {
                orientationHelper = null;
            }
        } else {
            OrientationHelper orientationHelper3 = this.PlaceComponentResult;
            if (orientationHelper3 == null || orientationHelper3.BuiltInFictitiousFunctionClassFactory != layoutManager) {
                this.PlaceComponentResult = OrientationHelper.getAuthRequestContext(layoutManager);
            }
            orientationHelper = this.PlaceComponentResult;
        }
        if (orientationHelper == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        View view2 = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int authRequestContext = (orientationHelper.getAuthRequestContext(childAt) + (orientationHelper.MyBillsEntityDataFactory(childAt) / 2)) - (orientationHelper.moveToNextValue() + (orientationHelper.scheduleImpl() / 2));
                if (authRequestContext <= 0 && authRequestContext > i3) {
                    view2 = childAt;
                    i3 = authRequestContext;
                }
                if (authRequestContext >= 0 && authRequestContext < i4) {
                    view = childAt;
                    i4 = authRequestContext;
                }
            }
        }
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(layoutManager, i, i2);
        if (!KClassImpl$Data$declaredNonStaticMembers$2 || view == null) {
            if (KClassImpl$Data$declaredNonStaticMembers$2 || view2 == null) {
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    view = view2;
                }
                if (view == null) {
                    return -1;
                }
                int position = layoutManager.getPosition(view) + (BuiltInFictitiousFunctionClassFactory(layoutManager) == KClassImpl$Data$declaredNonStaticMembers$2 ? -1 : 1);
                if (position < 0 || position >= itemCount) {
                    return -1;
                }
                return position;
            }
            return layoutManager.getPosition(view2);
        }
        return layoutManager.getPosition(view);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        return layoutManager.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        return (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(layoutManager.getItemCount() - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected final RecyclerView.SmoothScroller KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.BuiltInFictitiousFunctionClassFactory.getContext()) { // from class: androidx.recyclerview.widget.PagerSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                    int[] authRequestContext = pagerSnapHelper.getAuthRequestContext(pagerSnapHelper.BuiltInFictitiousFunctionClassFactory.getLayoutManager(), view);
                    int i = authRequestContext[0];
                    int i2 = authRequestContext[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
                        action.BuiltInFictitiousFunctionClassFactory = i;
                        action.getAuthRequestContext = i2;
                        action.MyBillsEntityDataFactory = calculateTimeForDeceleration;
                        action.KClassImpl$Data$declaredNonStaticMembers$2 = decelerateInterpolator;
                        action.PlaceComponentResult = true;
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int calculateTimeForScrolling(int i) {
                    return Math.min(100, super.calculateTimeForScrolling(i));
                }
            };
        }
        return null;
    }

    private static View MyBillsEntityDataFactory(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
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
