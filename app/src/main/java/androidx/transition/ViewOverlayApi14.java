package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewOverlayApi14 implements ViewOverlayImpl {
    protected OverlayViewGroup BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.BuiltInFictitiousFunctionClassFactory = new OverlayViewGroup(context, viewGroup, view, this);
    }

    static ViewGroup MyBillsEntityDataFactory(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewOverlayApi14 BuiltInFictitiousFunctionClassFactory(View view) {
        ViewGroup MyBillsEntityDataFactory = MyBillsEntityDataFactory(view);
        if (MyBillsEntityDataFactory != null) {
            int childCount = MyBillsEntityDataFactory.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = MyBillsEntityDataFactory.getChildAt(i);
                if (childAt instanceof OverlayViewGroup) {
                    return ((OverlayViewGroup) childAt).getAuthRequestContext;
                }
            }
            return new ViewGroupOverlayApi14(MyBillsEntityDataFactory.getContext(), MyBillsEntityDataFactory, view);
        }
        return null;
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void MyBillsEntityDataFactory(Drawable drawable) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void getAuthRequestContext(Drawable drawable) {
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class OverlayViewGroup extends ViewGroup implements FSDispatchDraw {
        static Method PlaceComponentResult;
        View BuiltInFictitiousFunctionClassFactory;
        ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;
        ArrayList<Drawable> MyBillsEntityDataFactory;
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        ViewOverlayApi14 getAuthRequestContext;

        public void PlaceComponentResult(Canvas canvas) {
            if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
                return;
            }
            super.dispatchDraw(canvas);
        }

        public boolean PlaceComponentResult(Canvas canvas, View view, long j) {
            if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
                return false;
            }
            return super.drawChild(canvas, view, j);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean drawChild(Canvas canvas, View view, long j) {
            return PlaceComponentResult(canvas, view, j);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            try {
                PlaceComponentResult = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.MyBillsEntityDataFactory = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
            this.BuiltInFictitiousFunctionClassFactory = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.getAuthRequestContext = viewOverlayApi14;
        }

        public void getAuthRequestContext(Drawable drawable) {
            MyBillsEntityDataFactory();
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new ArrayList<>();
            }
            if (this.MyBillsEntityDataFactory.contains(drawable)) {
                return;
            }
            this.MyBillsEntityDataFactory.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void BuiltInFictitiousFunctionClassFactory(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.MyBillsEntityDataFactory;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.MyBillsEntityDataFactory) != null && arrayList.contains(drawable));
        }

        public void PlaceComponentResult(View view) {
            MyBillsEntityDataFactory();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.KClassImpl$Data$declaredNonStaticMembers$2 && viewGroup.getParent() != null && ViewCompat.C(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getLocationOnScreen(iArr2);
                    ViewCompat.PlaceComponentResult(view, iArr[0] - iArr2[0]);
                    ViewCompat.BuiltInFictitiousFunctionClassFactory(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public void MyBillsEntityDataFactory(View view) {
            super.removeView(view);
            BuiltInFictitiousFunctionClassFactory();
        }

        private void MyBillsEntityDataFactory() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void BuiltInFictitiousFunctionClassFactory() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.MyBillsEntityDataFactory;
                if (arrayList == null || arrayList.size() == 0) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.removeView(this);
                }
            }
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getLocationOnScreen(new int[2]);
            this.BuiltInFictitiousFunctionClassFactory.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.BuiltInFictitiousFunctionClassFactory.getWidth(), this.BuiltInFictitiousFunctionClassFactory.getHeight()));
            PlaceComponentResult(canvas);
            ArrayList<Drawable> arrayList = this.MyBillsEntityDataFactory;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.MyBillsEntityDataFactory.get(i).draw(canvas);
            }
        }

        private void MyBillsEntityDataFactory(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.KClassImpl$Data$declaredNonStaticMembers$2.getLocationOnScreen(iArr2);
            this.BuiltInFictitiousFunctionClassFactory.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    MyBillsEntityDataFactory(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }
    }
}
