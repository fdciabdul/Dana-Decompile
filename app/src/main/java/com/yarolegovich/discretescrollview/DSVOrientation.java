package com.yarolegovich.discretescrollview;

import android.graphics.Point;
import android.view.View;

/* loaded from: classes8.dex */
public enum DSVOrientation {
    HORIZONTAL { // from class: com.yarolegovich.discretescrollview.DSVOrientation.1
        @Override // com.yarolegovich.discretescrollview.DSVOrientation
        final Helper createHelper() {
            return new HorizontalHelper();
        }
    },
    VERTICAL { // from class: com.yarolegovich.discretescrollview.DSVOrientation.2
        @Override // com.yarolegovich.discretescrollview.DSVOrientation
        final Helper createHelper() {
            return new VerticalHelper();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface Helper {
        float BuiltInFictitiousFunctionClassFactory(Point point, int i, int i2);

        int BuiltInFictitiousFunctionClassFactory(int i, int i2);

        void BuiltInFictitiousFunctionClassFactory(int i, RecyclerViewProxy recyclerViewProxy);

        void BuiltInFictitiousFunctionClassFactory(Point point, int i, Point point2);

        void BuiltInFictitiousFunctionClassFactory(Direction direction, int i, Point point);

        int KClassImpl$Data$declaredNonStaticMembers$2(int i);

        int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2);

        boolean MyBillsEntityDataFactory();

        boolean MyBillsEntityDataFactory(Point point, int i, int i2, int i3, int i4);

        boolean MyBillsEntityDataFactory(DiscreteScrollLayoutManager discreteScrollLayoutManager);

        boolean PlaceComponentResult();

        int getAuthRequestContext(int i);

        int getAuthRequestContext(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Helper createHelper();

    /* loaded from: classes8.dex */
    protected static class HorizontalHelper implements Helper {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean MyBillsEntityDataFactory() {
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean PlaceComponentResult() {
            return true;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int getAuthRequestContext(int i) {
            return 0;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int getAuthRequestContext(int i, int i2) {
            return i;
        }

        protected HorizontalHelper() {
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final void BuiltInFictitiousFunctionClassFactory(Point point, int i, Point point2) {
            point2.set(point.x - i, point.y);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final void BuiltInFictitiousFunctionClassFactory(Direction direction, int i, Point point) {
            point.set(point.x + direction.applyTo(i), point.y);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean MyBillsEntityDataFactory(Point point, int i, int i2, int i3, int i4) {
            return point.x - i < i3 + i4 && point.x + i > (-i4);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final float BuiltInFictitiousFunctionClassFactory(Point point, int i, int i2) {
            return i - point.x;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean MyBillsEntityDataFactory(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View childAt = discreteScrollLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildAt(0);
            RecyclerViewProxy recyclerViewProxy = discreteScrollLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda1;
            View childAt2 = recyclerViewProxy.getAuthRequestContext.getChildAt(recyclerViewProxy.getAuthRequestContext.getChildCount() - 1);
            return (discreteScrollLayoutManager.getDecoratedLeft(childAt) > (-discreteScrollLayoutManager.BuiltInFictitiousFunctionClassFactory()) && discreteScrollLayoutManager.getPosition(childAt) > 0) || (discreteScrollLayoutManager.getDecoratedRight(childAt2) < discreteScrollLayoutManager.getWidth() + discreteScrollLayoutManager.BuiltInFictitiousFunctionClassFactory() && discreteScrollLayoutManager.getPosition(childAt2) < discreteScrollLayoutManager.getItemCount() - 1);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final void BuiltInFictitiousFunctionClassFactory(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.getAuthRequestContext.offsetChildrenHorizontal(i);
        }
    }

    /* loaded from: classes8.dex */
    protected static class VerticalHelper implements Helper {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            return i2;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return 0;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            return i2;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean MyBillsEntityDataFactory() {
            return true;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean PlaceComponentResult() {
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int getAuthRequestContext(int i) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final int getAuthRequestContext(int i, int i2) {
            return i2;
        }

        protected VerticalHelper() {
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final void BuiltInFictitiousFunctionClassFactory(Point point, int i, Point point2) {
            point2.set(point.x, point.y - i);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final void BuiltInFictitiousFunctionClassFactory(Direction direction, int i, Point point) {
            point.set(point.x, point.y + direction.applyTo(i));
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final float BuiltInFictitiousFunctionClassFactory(Point point, int i, int i2) {
            return i2 - point.y;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean MyBillsEntityDataFactory(Point point, int i, int i2, int i3, int i4) {
            return point.y - i2 < i3 + i4 && point.y + i2 > (-i4);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final boolean MyBillsEntityDataFactory(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View childAt = discreteScrollLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getChildAt(0);
            RecyclerViewProxy recyclerViewProxy = discreteScrollLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda1;
            View childAt2 = recyclerViewProxy.getAuthRequestContext.getChildAt(recyclerViewProxy.getAuthRequestContext.getChildCount() - 1);
            return (discreteScrollLayoutManager.getDecoratedTop(childAt) > (-discreteScrollLayoutManager.BuiltInFictitiousFunctionClassFactory()) && discreteScrollLayoutManager.getPosition(childAt) > 0) || (discreteScrollLayoutManager.getDecoratedBottom(childAt2) < discreteScrollLayoutManager.getHeight() + discreteScrollLayoutManager.BuiltInFictitiousFunctionClassFactory() && discreteScrollLayoutManager.getPosition(childAt2) < discreteScrollLayoutManager.getItemCount() - 1);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public final void BuiltInFictitiousFunctionClassFactory(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.getAuthRequestContext.offsetChildrenVertical(i);
        }
    }
}
