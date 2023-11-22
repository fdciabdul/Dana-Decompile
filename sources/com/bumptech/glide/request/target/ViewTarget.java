package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static int BuiltInFictitiousFunctionClassFactory = R.id.KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean getAuthRequestContext;
    private View.OnAttachStateChangeListener KClassImpl$Data$declaredNonStaticMembers$2;
    protected final T MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    private boolean lookAheadTest;
    private final SizeDeterminer scheduleImpl;

    public ViewTarget(T t) {
        this.MyBillsEntityDataFactory = (T) Preconditions.PlaceComponentResult(t);
        this.scheduleImpl = new SizeDeterminer(t);
    }

    /* renamed from: com.bumptech.glide.request.target.ViewTarget$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        final /* synthetic */ ViewTarget PlaceComponentResult;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Request request = this.PlaceComponentResult.getRequest();
            if (request == null || !request.MyBillsEntityDataFactory()) {
                return;
            }
            request.PlaceComponentResult();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTarget viewTarget = this.PlaceComponentResult;
            Request request = viewTarget.getRequest();
            if (request != null) {
                viewTarget.PlaceComponentResult = true;
                request.KClassImpl$Data$declaredNonStaticMembers$2();
                viewTarget.PlaceComponentResult = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onAttachStateChangeListener == null || this.lookAheadTest) {
            return;
        }
        this.MyBillsEntityDataFactory.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.lookAheadTest = true;
    }

    public final T PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        SizeDeterminer sizeDeterminer = this.scheduleImpl;
        int BuiltInFictitiousFunctionClassFactory2 = sizeDeterminer.BuiltInFictitiousFunctionClassFactory();
        int KClassImpl$Data$declaredNonStaticMembers$2 = sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2();
        if (SizeDeterminer.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, KClassImpl$Data$declaredNonStaticMembers$2)) {
            sizeReadyCallback.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, KClassImpl$Data$declaredNonStaticMembers$2);
            return;
        }
        if (!sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2.contains(sizeReadyCallback)) {
            sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2.add(sizeReadyCallback);
        }
        if (sizeDeterminer.getAuthRequestContext == null) {
            ViewTreeObserver viewTreeObserver = sizeDeterminer.BuiltInFictitiousFunctionClassFactory.getViewTreeObserver();
            SizeDeterminer.SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminer.SizeDeterminerLayoutListener(sizeDeterminer);
            sizeDeterminer.getAuthRequestContext = sizeDeterminerLayoutListener;
            viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2.remove(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onLoadCleared(drawable);
        this.scheduleImpl.MyBillsEntityDataFactory();
        if (this.PlaceComponentResult || (onAttachStateChangeListener = this.KClassImpl$Data$declaredNonStaticMembers$2) == null || !this.lookAheadTest) {
            return;
        }
        this.MyBillsEntityDataFactory.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.lookAheadTest = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.MyBillsEntityDataFactory);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SizeDeterminer {
        static Integer MyBillsEntityDataFactory;
        final View BuiltInFictitiousFunctionClassFactory;
        final List<SizeReadyCallback> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        boolean PlaceComponentResult;
        SizeDeterminerLayoutListener getAuthRequestContext;

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        SizeDeterminer(View view) {
            this.BuiltInFictitiousFunctionClassFactory = view;
        }

        final void MyBillsEntityDataFactory() {
            ViewTreeObserver viewTreeObserver = this.BuiltInFictitiousFunctionClassFactory.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.getAuthRequestContext);
            }
            this.getAuthRequestContext = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        }

        static boolean PlaceComponentResult(int i, int i2) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i) && KClassImpl$Data$declaredNonStaticMembers$2(i2);
        }

        final int KClassImpl$Data$declaredNonStaticMembers$2() {
            int paddingTop = this.BuiltInFictitiousFunctionClassFactory.getPaddingTop();
            int paddingBottom = this.BuiltInFictitiousFunctionClassFactory.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.BuiltInFictitiousFunctionClassFactory.getLayoutParams();
            return PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop + paddingBottom);
        }

        final int BuiltInFictitiousFunctionClassFactory() {
            int paddingLeft = this.BuiltInFictitiousFunctionClassFactory.getPaddingLeft();
            int paddingRight = this.BuiltInFictitiousFunctionClassFactory.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.BuiltInFictitiousFunctionClassFactory.getLayoutParams();
            return PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft + paddingRight);
        }

        private int PlaceComponentResult(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.BuiltInFictitiousFunctionClassFactory.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                InstrumentInjector.log_i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = this.BuiltInFictitiousFunctionClassFactory.getContext();
            if (MyBillsEntityDataFactory == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.PlaceComponentResult((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                MyBillsEntityDataFactory = Integer.valueOf(Math.max(point.x, point.y));
            }
            return MyBillsEntityDataFactory.intValue();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> getAuthRequestContext;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.getAuthRequestContext = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    InstrumentInjector.log_v("ViewTarget", sb.toString());
                }
                SizeDeterminer sizeDeterminer = this.getAuthRequestContext.get();
                if (sizeDeterminer == null || sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    return true;
                }
                int BuiltInFictitiousFunctionClassFactory = sizeDeterminer.BuiltInFictitiousFunctionClassFactory();
                int KClassImpl$Data$declaredNonStaticMembers$2 = sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2();
                if (SizeDeterminer.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2)) {
                    Iterator it = new ArrayList(sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2).iterator();
                    while (it.hasNext()) {
                        ((SizeReadyCallback) it.next()).BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    sizeDeterminer.MyBillsEntityDataFactory();
                    return true;
                }
                return true;
            }
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public Request getRequest() {
        Object tag = this.MyBillsEntityDataFactory.getTag(BuiltInFictitiousFunctionClassFactory);
        if (tag != null) {
            if (tag instanceof Request) {
                return (Request) tag;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        getAuthRequestContext = true;
        this.MyBillsEntityDataFactory.setTag(BuiltInFictitiousFunctionClassFactory, request);
    }
}
