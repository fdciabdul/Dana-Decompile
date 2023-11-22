package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int lookAheadTest = ViewConfiguration.getTapTimeout();
    boolean BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    boolean MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    public boolean PlaceComponentResult;
    private Runnable PrepareContext;
    boolean getAuthRequestContext;
    final View moveToNextValue;
    private int scheduleImpl;
    final ClampedScroller KClassImpl$Data$declaredNonStaticMembers$2 = new ClampedScroller();
    private final Interpolator getErrorConfigVersion = new AccelerateInterpolator();
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda7 = {0.0f, 0.0f};
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] isLayoutRequested = {0.0f, 0.0f};
    private float[] GetContactSyncConfig = {0.0f, 0.0f};
    private float[] initRecordTimeStamp = {Float.MAX_VALUE, Float.MAX_VALUE};

    static float KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        if (f > 1.0f) {
            return 1.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(int i);

    public abstract void getAuthRequestContext(int i);

    public AutoScrollHelper(View view) {
        this.moveToNextValue = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float[] fArr = this.initRecordTimeStamp;
        float f = i / 1000.0f;
        fArr[0] = f;
        fArr[1] = f;
        float[] fArr2 = this.GetContactSyncConfig;
        float f2 = i2 / 1000.0f;
        fArr2[0] = f2;
        fArr2[1] = f2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
        float[] fArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.isLayoutRequested;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.scheduleImpl = lookAheadTest;
        this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 500;
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = 500;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 == 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.PlaceComponentResult
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L19
            if (r0 == r2) goto L15
            r3 = 2
            if (r0 == r3) goto L1d
            r6 = 3
            if (r0 != r6) goto L7c
        L15:
            r5.KClassImpl$Data$declaredNonStaticMembers$2()
            goto L7c
        L19:
            r5.MyBillsEntityDataFactory = r2
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
        L1d:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.moveToNextValue
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.PlaceComponentResult(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.moveToNextValue
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.PlaceComponentResult(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            r7.lookAheadTest = r0
            r7.GetContactSyncConfig = r6
            boolean r6 = r5.getAuthRequestContext
            if (r6 != 0) goto L7c
            boolean r6 = r5.getAuthRequestContext()
            if (r6 == 0) goto L7c
            java.lang.Runnable r6 = r5.PrepareContext
            if (r6 != 0) goto L60
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r6 = new androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable
            r6.<init>()
            r5.PrepareContext = r6
        L60:
            r5.getAuthRequestContext = r2
            r5.BuiltInFictitiousFunctionClassFactory = r2
            boolean r6 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r6 != 0) goto L75
            int r6 = r5.scheduleImpl
            if (r6 <= 0) goto L75
            android.view.View r7 = r5.moveToNextValue
            java.lang.Runnable r0 = r5.PrepareContext
            long r3 = (long) r6
            androidx.core.view.ViewCompat.PlaceComponentResult(r7, r0, r3)
            goto L7a
        L75:
            java.lang.Runnable r6 = r5.PrepareContext
            r6.run()
        L7a:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
        L7c:
            boolean r6 = r5.DatabaseTableConfigUtil
            if (r6 == 0) goto L85
            boolean r6 = r5.getAuthRequestContext
            if (r6 == 0) goto L85
            r1 = 1
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    final boolean getAuthRequestContext() {
        ClampedScroller clampedScroller = this.KClassImpl$Data$declaredNonStaticMembers$2;
        float f = clampedScroller.GetContactSyncConfig;
        int abs = (int) (f / Math.abs(f));
        float f2 = clampedScroller.lookAheadTest;
        int abs2 = (int) (f2 / Math.abs(f2));
        return abs != 0 && KClassImpl$Data$declaredNonStaticMembers$2(abs);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = 0;
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.getAuthRequestContext = false;
            return;
        }
        ClampedScroller clampedScroller = this.KClassImpl$Data$declaredNonStaticMembers$2;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - clampedScroller.getErrorConfigVersion);
        int i3 = clampedScroller.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        clampedScroller.getAuthRequestContext = i;
        clampedScroller.NetworkUserEntityData$$ExternalSyntheticLambda0 = clampedScroller.BuiltInFictitiousFunctionClassFactory(currentAnimationTimeMillis);
        clampedScroller.scheduleImpl = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float PlaceComponentResult(int r5, float r6, float r7, float r8) {
        /*
            r4 = this;
            float[] r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            r0 = r0[r5]
            float[] r1 = r4.NetworkUserEntityData$$ExternalSyntheticLambda1
            r1 = r1[r5]
            float r0 = r0 * r7
            r2 = 0
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 <= 0) goto L10
            goto L17
        L10:
            int r1 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r1 >= 0) goto L16
            r1 = 0
            goto L17
        L16:
            r1 = r0
        L17:
            float r0 = r4.PlaceComponentResult(r6, r1)
            float r7 = r7 - r6
            float r6 = r4.PlaceComponentResult(r7, r1)
            float r6 = r6 - r0
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 >= 0) goto L32
            android.view.animation.Interpolator r1 = r4.getErrorConfigVersion
            float r6 = -r6
            float r6 = r1.getInterpolation(r6)
            float r6 = -r6
            goto L3c
        L32:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L4a
            android.view.animation.Interpolator r1 = r4.getErrorConfigVersion
            float r6 = r1.getInterpolation(r6)
        L3c:
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 <= 0) goto L43
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L4b
        L43:
            int r0 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r0 >= 0) goto L48
            goto L4b
        L48:
            r7 = r6
            goto L4b
        L4a:
            r7 = 0
        L4b:
            int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r6 != 0) goto L50
            return r2
        L50:
            float[] r6 = r4.isLayoutRequested
            r6 = r6[r5]
            float[] r0 = r4.GetContactSyncConfig
            r0 = r0[r5]
            float[] r1 = r4.initRecordTimeStamp
            r5 = r1[r5]
            float r6 = r6 * r8
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 <= 0) goto L6f
            float r7 = r7 * r6
            int r6 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r6 <= 0) goto L69
            return r5
        L69:
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 >= 0) goto L6e
            return r0
        L6e:
            return r7
        L6f:
            float r7 = -r7
            float r7 = r7 * r6
            int r6 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r6 <= 0) goto L78
            r0 = r5
            goto L7e
        L78:
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 >= 0) goto L7d
            goto L7e
        L7d:
            r0 = r7
        L7e:
            float r5 = -r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.PlaceComponentResult(int, float, float, float):float");
    }

    private float PlaceComponentResult(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.getAuthRequestContext && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    /* loaded from: classes3.dex */
    class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AutoScrollHelper.this.getAuthRequestContext) {
                if (AutoScrollHelper.this.BuiltInFictitiousFunctionClassFactory) {
                    AutoScrollHelper.this.BuiltInFictitiousFunctionClassFactory = false;
                    ClampedScroller clampedScroller = AutoScrollHelper.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    clampedScroller.getErrorConfigVersion = currentAnimationTimeMillis;
                    clampedScroller.scheduleImpl = -1L;
                    clampedScroller.PlaceComponentResult = currentAnimationTimeMillis;
                    clampedScroller.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.5f;
                    clampedScroller.MyBillsEntityDataFactory = 0;
                    clampedScroller.BuiltInFictitiousFunctionClassFactory = 0;
                }
                ClampedScroller clampedScroller2 = AutoScrollHelper.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (clampedScroller2.BuiltInFictitiousFunctionClassFactory() || !AutoScrollHelper.this.getAuthRequestContext()) {
                    AutoScrollHelper.this.getAuthRequestContext = false;
                    return;
                }
                if (AutoScrollHelper.this.MyBillsEntityDataFactory) {
                    AutoScrollHelper.this.MyBillsEntityDataFactory = false;
                    AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    autoScrollHelper.moveToNextValue.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (clampedScroller2.PlaceComponentResult == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                float BuiltInFictitiousFunctionClassFactory = clampedScroller2.BuiltInFictitiousFunctionClassFactory(currentAnimationTimeMillis2);
                long j = clampedScroller2.PlaceComponentResult;
                clampedScroller2.PlaceComponentResult = currentAnimationTimeMillis2;
                float f = ((float) (currentAnimationTimeMillis2 - j)) * (((-4.0f) * BuiltInFictitiousFunctionClassFactory * BuiltInFictitiousFunctionClassFactory) + (BuiltInFictitiousFunctionClassFactory * 4.0f));
                clampedScroller2.MyBillsEntityDataFactory = (int) (clampedScroller2.lookAheadTest * f);
                clampedScroller2.BuiltInFictitiousFunctionClassFactory = (int) (f * clampedScroller2.GetContactSyncConfig);
                int i = clampedScroller2.MyBillsEntityDataFactory;
                AutoScrollHelper.this.getAuthRequestContext(clampedScroller2.BuiltInFictitiousFunctionClassFactory);
                ViewCompat.PlaceComponentResult(AutoScrollHelper.this.moveToNextValue, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ClampedScroller {
        float GetContactSyncConfig;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        float NetworkUserEntityData$$ExternalSyntheticLambda0;
        int getAuthRequestContext;
        float lookAheadTest;
        int moveToNextValue;
        long getErrorConfigVersion = Long.MIN_VALUE;
        long scheduleImpl = -1;
        long PlaceComponentResult = 0;
        int MyBillsEntityDataFactory = 0;
        int BuiltInFictitiousFunctionClassFactory = 0;

        ClampedScroller() {
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.scheduleImpl > 0 && AnimationUtils.currentAnimationTimeMillis() > this.scheduleImpl + ((long) this.getAuthRequestContext);
        }

        final float BuiltInFictitiousFunctionClassFactory(long j) {
            long j2 = this.getErrorConfigVersion;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.scheduleImpl;
            if (j3 < 0 || j < j3) {
                return AutoScrollHelper.KClassImpl$Data$declaredNonStaticMembers$2(((float) (j - j2)) / this.moveToNextValue) * 0.5f;
            }
            float f = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            return (1.0f - f) + (f * AutoScrollHelper.KClassImpl$Data$declaredNonStaticMembers$2(((float) (j - j3)) / this.getAuthRequestContext));
        }
    }
}
