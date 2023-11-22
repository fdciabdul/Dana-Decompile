package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

/* loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private Runnable MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    final View getAuthRequestContext;
    private Runnable getErrorConfigVersion;
    private final int[] lookAheadTest = new int[2];
    private final float moveToNextValue;

    public abstract ShowableListMenu getAuthRequestContext();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public ForwardingListener(View view) {
        this.getAuthRequestContext = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.moveToNextValue = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = tapTimeout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.BuiltInFictitiousFunctionClassFactory;
        if (z2) {
            if (!BuiltInFictitiousFunctionClassFactory(motionEvent) && BuiltInFictitiousFunctionClassFactory()) {
                z = false;
            }
            z = true;
        } else {
            z = PlaceComponentResult(motionEvent) && MyBillsEntityDataFactory();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.getAuthRequestContext.onTouchEvent(obtain);
                obtain.recycle();
                z = true;
            }
        }
        this.BuiltInFictitiousFunctionClassFactory = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.PlaceComponentResult = -1;
        Runnable runnable = this.MyBillsEntityDataFactory;
        if (runnable != null) {
            this.getAuthRequestContext.removeCallbacks(runnable);
        }
    }

    protected boolean MyBillsEntityDataFactory() {
        ShowableListMenu authRequestContext = getAuthRequestContext();
        if (authRequestContext == null || authRequestContext.PlaceComponentResult()) {
            return true;
        }
        authRequestContext.a_();
        return true;
    }

    protected boolean BuiltInFictitiousFunctionClassFactory() {
        ShowableListMenu authRequestContext = getAuthRequestContext();
        if (authRequestContext == null || !authRequestContext.PlaceComponentResult()) {
            return true;
        }
        authRequestContext.getAuthRequestContext();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r1 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean PlaceComponentResult(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.getAuthRequestContext
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.PlaceComponentResult
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.moveToNextValue
            boolean r6 = PlaceComponentResult(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.KClassImpl$Data$declaredNonStaticMembers$2()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.KClassImpl$Data$declaredNonStaticMembers$2()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.PlaceComponentResult = r6
            java.lang.Runnable r6 = r5.MyBillsEntityDataFactory
            if (r6 != 0) goto L52
            androidx.appcompat.widget.ForwardingListener$DisallowIntercept r6 = new androidx.appcompat.widget.ForwardingListener$DisallowIntercept
            r6.<init>()
            r5.MyBillsEntityDataFactory = r6
        L52:
            java.lang.Runnable r6 = r5.MyBillsEntityDataFactory
            int r1 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.getErrorConfigVersion
            if (r6 != 0) goto L65
            androidx.appcompat.widget.ForwardingListener$TriggerLongPress r6 = new androidx.appcompat.widget.ForwardingListener$TriggerLongPress
            r6.<init>()
            r5.getErrorConfigVersion = r6
        L65:
            java.lang.Runnable r6 = r5.getErrorConfigVersion
            int r1 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.PlaceComponentResult(android.view.MotionEvent):boolean");
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        Runnable runnable = this.getErrorConfigVersion;
        if (runnable != null) {
            this.getAuthRequestContext.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.MyBillsEntityDataFactory;
        if (runnable2 != null) {
            this.getAuthRequestContext.removeCallbacks(runnable2);
        }
    }

    void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        View view = this.getAuthRequestContext;
        if (view.isEnabled() && !view.isLongClickable() && MyBillsEntityDataFactory()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.getAuthRequestContext;
        ShowableListMenu authRequestContext = getAuthRequestContext();
        if (authRequestContext != null && authRequestContext.PlaceComponentResult() && (dropDownListView = (DropDownListView) authRequestContext.getListView()) != null && dropDownListView.isShown()) {
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            getAuthRequestContext(view, obtainNoHistory);
            PlaceComponentResult(dropDownListView, obtainNoHistory);
            boolean onForwardedEvent = dropDownListView.onForwardedEvent(obtainNoHistory, this.PlaceComponentResult);
            obtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (onForwardedEvent && z) {
                return true;
            }
        }
        return false;
    }

    private static boolean PlaceComponentResult(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean PlaceComponentResult(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.lookAheadTest);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    private boolean getAuthRequestContext(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.lookAheadTest);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.getAuthRequestContext.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.PlaceComponentResult();
        }
    }
}
