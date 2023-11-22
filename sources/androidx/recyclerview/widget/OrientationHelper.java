package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public abstract class OrientationHelper {
    protected final RecyclerView.LayoutManager BuiltInFictitiousFunctionClassFactory;
    final Rect KClassImpl$Data$declaredNonStaticMembers$2;
    public int PlaceComponentResult;

    public abstract int BuiltInFictitiousFunctionClassFactory();

    public abstract int BuiltInFictitiousFunctionClassFactory(View view);

    public abstract int KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract int KClassImpl$Data$declaredNonStaticMembers$2(View view);

    public abstract int MyBillsEntityDataFactory();

    public abstract int MyBillsEntityDataFactory(View view);

    public abstract int PlaceComponentResult();

    public abstract int PlaceComponentResult(View view);

    public abstract void PlaceComponentResult(int i);

    public abstract int getAuthRequestContext();

    public abstract int getAuthRequestContext(View view);

    public abstract int moveToNextValue();

    public abstract int moveToNextValue(View view);

    public abstract int scheduleImpl();

    /* synthetic */ OrientationHelper(RecyclerView.LayoutManager layoutManager, byte b) {
        this(layoutManager);
    }

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.PlaceComponentResult = Integer.MIN_VALUE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Rect();
        this.BuiltInFictitiousFunctionClassFactory = layoutManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.OrientationHelper$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends OrientationHelper {
        AnonymousClass1(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, (byte) 0);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory.getWidth() - this.BuiltInFictitiousFunctionClassFactory.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int MyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.getWidth();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final void PlaceComponentResult(int i) {
            this.BuiltInFictitiousFunctionClassFactory.offsetChildrenHorizontal(i);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int moveToNextValue() {
            return this.BuiltInFictitiousFunctionClassFactory.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int MyBillsEntityDataFactory(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int PlaceComponentResult(View view) {
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getAuthRequestContext(View view) {
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int BuiltInFictitiousFunctionClassFactory(View view) {
            this.BuiltInFictitiousFunctionClassFactory.getTransformedBoundingBox(view, true, this.KClassImpl$Data$declaredNonStaticMembers$2);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.right;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int moveToNextValue(View view) {
            this.BuiltInFictitiousFunctionClassFactory.getTransformedBoundingBox(view, true, this.KClassImpl$Data$declaredNonStaticMembers$2);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.left;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int scheduleImpl() {
            return (this.BuiltInFictitiousFunctionClassFactory.getWidth() - this.BuiltInFictitiousFunctionClassFactory.getPaddingLeft()) - this.BuiltInFictitiousFunctionClassFactory.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int PlaceComponentResult() {
            return this.BuiltInFictitiousFunctionClassFactory.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.getHeightMode();
        }
    }

    public static OrientationHelper BuiltInFictitiousFunctionClassFactory(RecyclerView.LayoutManager layoutManager) {
        return new AnonymousClass1(layoutManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.OrientationHelper$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 extends OrientationHelper {
        AnonymousClass2(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, (byte) 0);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory.getHeight() - this.BuiltInFictitiousFunctionClassFactory.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int MyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.getHeight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final void PlaceComponentResult(int i) {
            this.BuiltInFictitiousFunctionClassFactory.offsetChildrenVertical(i);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int moveToNextValue() {
            return this.BuiltInFictitiousFunctionClassFactory.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int MyBillsEntityDataFactory(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int PlaceComponentResult(View view) {
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getAuthRequestContext(View view) {
            return this.BuiltInFictitiousFunctionClassFactory.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int BuiltInFictitiousFunctionClassFactory(View view) {
            this.BuiltInFictitiousFunctionClassFactory.getTransformedBoundingBox(view, true, this.KClassImpl$Data$declaredNonStaticMembers$2);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.bottom;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int moveToNextValue(View view) {
            this.BuiltInFictitiousFunctionClassFactory.getTransformedBoundingBox(view, true, this.KClassImpl$Data$declaredNonStaticMembers$2);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.top;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int scheduleImpl() {
            return (this.BuiltInFictitiousFunctionClassFactory.getHeight() - this.BuiltInFictitiousFunctionClassFactory.getPaddingTop()) - this.BuiltInFictitiousFunctionClassFactory.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int PlaceComponentResult() {
            return this.BuiltInFictitiousFunctionClassFactory.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.getWidthMode();
        }
    }

    public static OrientationHelper getAuthRequestContext(RecyclerView.LayoutManager layoutManager) {
        return new AnonymousClass2(layoutManager);
    }

    public static OrientationHelper PlaceComponentResult(RecyclerView.LayoutManager layoutManager, int i) {
        if (i != 0) {
            if (i != 1) {
                throw new IllegalArgumentException("invalid orientation");
            }
            return new AnonymousClass2(layoutManager);
        }
        return new AnonymousClass1(layoutManager);
    }
}
