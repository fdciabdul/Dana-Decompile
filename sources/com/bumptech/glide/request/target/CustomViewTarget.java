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

/* loaded from: classes3.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    private static final int getAuthRequestContext = R.id.KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean BuiltInFictitiousFunctionClassFactory;
    protected final T KClassImpl$Data$declaredNonStaticMembers$2;
    private View.OnAttachStateChangeListener MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    private final SizeDeterminer getErrorConfigVersion;

    public void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
    }

    protected abstract void MyBillsEntityDataFactory(Drawable drawable);

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    public CustomViewTarget(T t) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (T) Preconditions.PlaceComponentResult(t);
        this.getErrorConfigVersion = new SizeDeterminer(t);
    }

    /* renamed from: com.bumptech.glide.request.target.CustomViewTarget$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        final /* synthetic */ CustomViewTarget PlaceComponentResult;

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
            CustomViewTarget customViewTarget = this.PlaceComponentResult;
            Request request = customViewTarget.getRequest();
            if (request != null) {
                customViewTarget.PlaceComponentResult = true;
                request.KClassImpl$Data$declaredNonStaticMembers$2();
                customViewTarget.PlaceComponentResult = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        SizeDeterminer sizeDeterminer = this.getErrorConfigVersion;
        int BuiltInFictitiousFunctionClassFactory = sizeDeterminer.BuiltInFictitiousFunctionClassFactory();
        int KClassImpl$Data$declaredNonStaticMembers$2 = sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2();
        if (SizeDeterminer.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2)) {
            sizeReadyCallback.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2);
            return;
        }
        if (!sizeDeterminer.BuiltInFictitiousFunctionClassFactory.contains(sizeReadyCallback)) {
            sizeDeterminer.BuiltInFictitiousFunctionClassFactory.add(sizeReadyCallback);
        }
        if (sizeDeterminer.getAuthRequestContext == null) {
            ViewTreeObserver viewTreeObserver = sizeDeterminer.MyBillsEntityDataFactory.getViewTreeObserver();
            SizeDeterminer.SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminer.SizeDeterminerLayoutListener(sizeDeterminer);
            sizeDeterminer.getAuthRequestContext = sizeDeterminerLayoutListener;
            viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory.remove(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        this.getErrorConfigVersion.getAuthRequestContext();
        MyBillsEntityDataFactory(drawable);
        if (this.PlaceComponentResult || (onAttachStateChangeListener = this.MyBillsEntityDataFactory) == null || !this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    static final class SizeDeterminer {
        static Integer PlaceComponentResult;
        final List<SizeReadyCallback> BuiltInFictitiousFunctionClassFactory = new ArrayList();
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final View MyBillsEntityDataFactory;
        SizeDeterminerLayoutListener getAuthRequestContext;

        private static boolean MyBillsEntityDataFactory(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        SizeDeterminer(View view) {
            this.MyBillsEntityDataFactory = view;
        }

        final void getAuthRequestContext() {
            ViewTreeObserver viewTreeObserver = this.MyBillsEntityDataFactory.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.getAuthRequestContext);
            }
            this.getAuthRequestContext = null;
            this.BuiltInFictitiousFunctionClassFactory.clear();
        }

        static boolean getAuthRequestContext(int i, int i2) {
            return MyBillsEntityDataFactory(i) && MyBillsEntityDataFactory(i2);
        }

        final int KClassImpl$Data$declaredNonStaticMembers$2() {
            int paddingTop = this.MyBillsEntityDataFactory.getPaddingTop();
            int paddingBottom = this.MyBillsEntityDataFactory.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.MyBillsEntityDataFactory.getLayoutParams();
            return PlaceComponentResult(this.MyBillsEntityDataFactory.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop + paddingBottom);
        }

        final int BuiltInFictitiousFunctionClassFactory() {
            int paddingLeft = this.MyBillsEntityDataFactory.getPaddingLeft();
            int paddingRight = this.MyBillsEntityDataFactory.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.MyBillsEntityDataFactory.getLayoutParams();
            return PlaceComponentResult(this.MyBillsEntityDataFactory.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft + paddingRight);
        }

        private int PlaceComponentResult(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 && this.MyBillsEntityDataFactory.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.MyBillsEntityDataFactory.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                InstrumentInjector.log_i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = this.MyBillsEntityDataFactory.getContext();
            if (PlaceComponentResult == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.PlaceComponentResult((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                PlaceComponentResult = Integer.valueOf(Math.max(point.x, point.y));
            }
            return PlaceComponentResult.intValue();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> BuiltInFictitiousFunctionClassFactory;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    InstrumentInjector.log_v("CustomViewTarget", sb.toString());
                }
                SizeDeterminer sizeDeterminer = this.BuiltInFictitiousFunctionClassFactory.get();
                if (sizeDeterminer == null || sizeDeterminer.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                    return true;
                }
                int BuiltInFictitiousFunctionClassFactory = sizeDeterminer.BuiltInFictitiousFunctionClassFactory();
                int KClassImpl$Data$declaredNonStaticMembers$2 = sizeDeterminer.KClassImpl$Data$declaredNonStaticMembers$2();
                if (SizeDeterminer.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2)) {
                    Iterator it = new ArrayList(sizeDeterminer.BuiltInFictitiousFunctionClassFactory).iterator();
                    while (it.hasNext()) {
                        ((SizeReadyCallback) it.next()).BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    sizeDeterminer.getAuthRequestContext();
                    return true;
                }
                return true;
            }
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        Object tag = this.KClassImpl$Data$declaredNonStaticMembers$2.getTag(getAuthRequestContext);
        if (tag != null) {
            if (tag instanceof Request) {
                return (Request) tag;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.MyBillsEntityDataFactory;
        if (onAttachStateChangeListener != null && !this.BuiltInFictitiousFunctionClassFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(Request request) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setTag(getAuthRequestContext, request);
    }
}
