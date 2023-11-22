package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes3.dex */
final class FakeDrag {
    private float BuiltInFictitiousFunctionClassFactory;
    private final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private VelocityTracker NetworkUserEntityData$$ExternalSyntheticLambda0;
    private long PlaceComponentResult;
    private int getAuthRequestContext;
    private final ViewPager2 getErrorConfigVersion;
    private final ScrollEventAdapter lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.getErrorConfigVersion = viewPager2;
        this.lookAheadTest = scrollEventAdapter;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        if (this.lookAheadTest.getAuthRequestContext()) {
            return false;
        }
        this.MyBillsEntityDataFactory = 0;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.PlaceComponentResult = SystemClock.uptimeMillis();
        VelocityTracker velocityTracker = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (velocityTracker == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = VelocityTracker.obtain();
            this.getAuthRequestContext = ViewConfiguration.get(this.getErrorConfigVersion.getContext()).getScaledMaximumFlingVelocity();
        } else {
            velocityTracker.clear();
        }
        ScrollEventAdapter scrollEventAdapter = this.lookAheadTest;
        scrollEventAdapter.getAuthRequestContext = 4;
        scrollEventAdapter.BuiltInFictitiousFunctionClassFactory(true);
        if (!this.lookAheadTest.BuiltInFictitiousFunctionClassFactory()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.stopScroll();
        }
        long j = this.PlaceComponentResult;
        MotionEvent obtain = MotionEvent.obtain(j, j, 0, 0.0f, 0.0f, 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.addMovement(obtain);
        obtain.recycle();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(float f) {
        if (this.lookAheadTest.PlaceComponentResult()) {
            float f2 = this.BuiltInFictitiousFunctionClassFactory - f;
            this.BuiltInFictitiousFunctionClassFactory = f2;
            int round = Math.round(f2 - this.MyBillsEntityDataFactory);
            this.MyBillsEntityDataFactory += round;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z = this.getErrorConfigVersion.getOrientation() == 0;
            int i = z ? round : 0;
            int i2 = z ? 0 : round;
            float f3 = z ? this.BuiltInFictitiousFunctionClassFactory : 0.0f;
            float f4 = z ? 0.0f : this.BuiltInFictitiousFunctionClassFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2.scrollBy(i, i2);
            MotionEvent obtain = MotionEvent.obtain(this.PlaceComponentResult, uptimeMillis, 2, f3, f4, 0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.addMovement(obtain);
            obtain.recycle();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        if (this.lookAheadTest.PlaceComponentResult()) {
            ScrollEventAdapter scrollEventAdapter = this.lookAheadTest;
            if (!scrollEventAdapter.getAuthRequestContext() || scrollEventAdapter.BuiltInFictitiousFunctionClassFactory) {
                scrollEventAdapter.BuiltInFictitiousFunctionClassFactory = false;
                scrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
                if (scrollEventAdapter.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                    if (scrollEventAdapter.moveToNextValue.BuiltInFictitiousFunctionClassFactory != scrollEventAdapter.MyBillsEntityDataFactory) {
                        int i = scrollEventAdapter.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
                        ViewPager2.OnPageChangeCallback onPageChangeCallback = scrollEventAdapter.PlaceComponentResult;
                        if (onPageChangeCallback != null) {
                            onPageChangeCallback.onPageSelected(i);
                        }
                    }
                    scrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2(0);
                    scrollEventAdapter.MyBillsEntityDataFactory();
                } else {
                    scrollEventAdapter.KClassImpl$Data$declaredNonStaticMembers$2(2);
                }
            }
            VelocityTracker velocityTracker = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            velocityTracker.computeCurrentVelocity(1000, this.getAuthRequestContext);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                return true;
            }
            this.getErrorConfigVersion.snapToPage();
            return true;
        }
        return false;
    }
}
