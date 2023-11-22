package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int[] NetworkUserEntityData$$ExternalSyntheticLambda8 = {16842919};
    private static final int[] PrepareContext = new int[0];
    private final int BottomSheetCardBindingView$watcherCardNumberView$1;
    float BuiltInFictitiousFunctionClassFactory;
    int DatabaseTableConfigUtil;
    private final Runnable FragmentBottomSheetPaymentSettingBinding;
    int MyBillsEntityDataFactory;
    float NetworkUserEntityData$$ExternalSyntheticLambda1;
    final ValueAnimator NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Drawable NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final StateListDrawable NetworkUserEntityData$$ExternalSyntheticLambda6;
    int NetworkUserEntityData$$ExternalSyntheticLambda7;
    int PlaceComponentResult;
    private final int SubSequence;
    int getAuthRequestContext;
    private final int getCallingPid;
    final int getErrorConfigVersion;
    private final RecyclerView.OnScrollListener getSupportButtonTintMode;
    final StateListDrawable initRecordTimeStamp;
    RecyclerView moveToNextValue;
    final Drawable newProxyInstance;
    private final int whenAvailable;
    int scheduleImpl = 0;
    int lookAheadTest = 0;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    int GetContactSyncConfig = 0;
    private int isLayoutRequested = 0;
    private final int[] readMicros = new int[2];
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda3 = new int[2];

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ofFloat;
        this.MyBillsEntityDataFactory = 0;
        this.FragmentBottomSheetPaymentSettingBinding = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            @Override // java.lang.Runnable
            public void run() {
                FastScroller fastScroller = FastScroller.this;
                int i4 = fastScroller.MyBillsEntityDataFactory;
                if (i4 == 1) {
                    fastScroller.NetworkUserEntityData$$ExternalSyntheticLambda2.cancel();
                } else if (i4 != 2) {
                    return;
                }
                fastScroller.MyBillsEntityDataFactory = 3;
                ValueAnimator valueAnimator = fastScroller.NetworkUserEntityData$$ExternalSyntheticLambda2;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                fastScroller.NetworkUserEntityData$$ExternalSyntheticLambda2.setDuration(500L);
                fastScroller.NetworkUserEntityData$$ExternalSyntheticLambda2.start();
            }
        };
        this.getSupportButtonTintMode = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i4, int i5) {
                FastScroller fastScroller = FastScroller.this;
                int computeHorizontalScrollOffset = recyclerView2.computeHorizontalScrollOffset();
                int computeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                int computeVerticalScrollRange = fastScroller.moveToNextValue.computeVerticalScrollRange();
                int i6 = fastScroller.lookAheadTest;
                fastScroller.NetworkUserEntityData$$ExternalSyntheticLambda0 = computeVerticalScrollRange - i6 > 0 && i6 >= fastScroller.getErrorConfigVersion;
                int computeHorizontalScrollRange = fastScroller.moveToNextValue.computeHorizontalScrollRange();
                int i7 = fastScroller.scheduleImpl;
                boolean z = computeHorizontalScrollRange - i7 > 0 && i7 >= fastScroller.getErrorConfigVersion;
                fastScroller.KClassImpl$Data$declaredNonStaticMembers$2 = z;
                boolean z2 = fastScroller.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (!z2 && !z) {
                    if (fastScroller.GetContactSyncConfig != 0) {
                        fastScroller.BuiltInFictitiousFunctionClassFactory(0);
                        return;
                    }
                    return;
                }
                if (z2) {
                    float f = i6;
                    fastScroller.DatabaseTableConfigUtil = (int) ((f * (computeVerticalScrollOffset + (f / 2.0f))) / computeVerticalScrollRange);
                    fastScroller.NetworkUserEntityData$$ExternalSyntheticLambda7 = Math.min(i6, (i6 * i6) / computeVerticalScrollRange);
                }
                if (fastScroller.KClassImpl$Data$declaredNonStaticMembers$2) {
                    float f2 = computeHorizontalScrollOffset;
                    float f3 = i7;
                    fastScroller.PlaceComponentResult = (int) ((f3 * (f2 + (f3 / 2.0f))) / computeHorizontalScrollRange);
                    fastScroller.getAuthRequestContext = Math.min(i7, (i7 * i7) / computeHorizontalScrollRange);
                }
                int i8 = fastScroller.GetContactSyncConfig;
                if (i8 == 0 || i8 == 1) {
                    fastScroller.BuiltInFictitiousFunctionClassFactory(1);
                }
            }
        };
        this.initRecordTimeStamp = stateListDrawable;
        this.newProxyInstance = drawable;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = stateListDrawable2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = drawable2;
        this.SubSequence = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = Math.max(i, drawable.getIntrinsicWidth());
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.getCallingPid = Math.max(i, drawable2.getIntrinsicWidth());
        this.getErrorConfigVersion = i2;
        this.whenAvailable = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        RecyclerView recyclerView2 = this.moveToNextValue;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.moveToNextValue.removeOnItemTouchListener(this);
                this.moveToNextValue.removeOnScrollListener(this.getSupportButtonTintMode);
                this.moveToNextValue.removeCallbacks(this.FragmentBottomSheetPaymentSettingBinding);
            }
            this.moveToNextValue = recyclerView;
            recyclerView.addItemDecoration(this);
            this.moveToNextValue.addOnItemTouchListener(this);
            this.moveToNextValue.addOnScrollListener(this.getSupportButtonTintMode);
        }
    }

    final void BuiltInFictitiousFunctionClassFactory(int i) {
        if (i == 2 && this.GetContactSyncConfig != 2) {
            this.initRecordTimeStamp.setState(NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.moveToNextValue.removeCallbacks(this.FragmentBottomSheetPaymentSettingBinding);
        }
        if (i != 0) {
            MyBillsEntityDataFactory();
        } else {
            this.moveToNextValue.invalidate();
        }
        if (this.GetContactSyncConfig == 2 && i != 2) {
            this.initRecordTimeStamp.setState(PrepareContext);
            this.moveToNextValue.removeCallbacks(this.FragmentBottomSheetPaymentSettingBinding);
            this.moveToNextValue.postDelayed(this.FragmentBottomSheetPaymentSettingBinding, 1200L);
        } else if (i == 1) {
            this.moveToNextValue.removeCallbacks(this.FragmentBottomSheetPaymentSettingBinding);
            this.moveToNextValue.postDelayed(this.FragmentBottomSheetPaymentSettingBinding, 1500L);
        }
        this.GetContactSyncConfig = i;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return ViewCompat.initRecordTimeStamp(this.moveToNextValue) == 1;
    }

    private void MyBillsEntityDataFactory() {
        int i = this.MyBillsEntityDataFactory;
        if (i != 0) {
            if (i != 3) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.cancel();
        }
        this.MyBillsEntityDataFactory = 1;
        ValueAnimator valueAnimator = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setDuration(500L);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setStartDelay(0L);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.scheduleImpl != this.moveToNextValue.getWidth() || this.lookAheadTest != this.moveToNextValue.getHeight()) {
            this.scheduleImpl = this.moveToNextValue.getWidth();
            this.lookAheadTest = this.moveToNextValue.getHeight();
            BuiltInFictitiousFunctionClassFactory(0);
        } else if (this.MyBillsEntityDataFactory != 0) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                int i = this.scheduleImpl;
                int i2 = this.SubSequence;
                int i3 = i - i2;
                int i4 = this.DatabaseTableConfigUtil;
                int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                int i6 = i4 - (i5 / 2);
                this.initRecordTimeStamp.setBounds(0, 0, i2, i5);
                this.newProxyInstance.setBounds(0, 0, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.lookAheadTest);
                if (BuiltInFictitiousFunctionClassFactory()) {
                    this.newProxyInstance.draw(canvas);
                    canvas.translate(this.SubSequence, i6);
                    canvas.scale(-1.0f, 1.0f);
                    this.initRecordTimeStamp.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-this.SubSequence, -i6);
                } else {
                    canvas.translate(i3, 0.0f);
                    this.newProxyInstance.draw(canvas);
                    canvas.translate(0.0f, i6);
                    this.initRecordTimeStamp.draw(canvas);
                    canvas.translate(-i3, -i6);
                }
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                int i7 = this.lookAheadTest;
                int i8 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                int i9 = this.PlaceComponentResult;
                int i10 = this.getAuthRequestContext;
                this.NetworkUserEntityData$$ExternalSyntheticLambda6.setBounds(0, 0, i10, i8);
                this.NetworkUserEntityData$$ExternalSyntheticLambda5.setBounds(0, 0, this.scheduleImpl, this.getCallingPid);
                canvas.translate(0.0f, i7 - i8);
                this.NetworkUserEntityData$$ExternalSyntheticLambda5.draw(canvas);
                canvas.translate(i9 - (i10 / 2), 0.0f);
                this.NetworkUserEntityData$$ExternalSyntheticLambda6.draw(canvas);
                canvas.translate(-r2, -r7);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean MyBillsEntityDataFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.GetContactSyncConfig;
        if (i == 1) {
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(motionEvent.getX(), motionEvent.getY());
            boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!KClassImpl$Data$declaredNonStaticMembers$2 && !MyBillsEntityDataFactory) {
                return false;
            }
            if (MyBillsEntityDataFactory) {
                this.isLayoutRequested = 1;
                this.BuiltInFictitiousFunctionClassFactory = (int) motionEvent.getX();
            } else if (KClassImpl$Data$declaredNonStaticMembers$2) {
                this.isLayoutRequested = 2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) motionEvent.getY();
            }
            BuiltInFictitiousFunctionClassFactory(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.GetContactSyncConfig == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(motionEvent.getX(), motionEvent.getY());
            boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(motionEvent.getX(), motionEvent.getY());
            if (KClassImpl$Data$declaredNonStaticMembers$2 || MyBillsEntityDataFactory) {
                if (MyBillsEntityDataFactory) {
                    this.isLayoutRequested = 1;
                    this.BuiltInFictitiousFunctionClassFactory = (int) motionEvent.getX();
                } else if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.isLayoutRequested = 2;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) motionEvent.getY();
                }
                BuiltInFictitiousFunctionClassFactory(2);
            }
        } else if (motionEvent.getAction() == 1 && this.GetContactSyncConfig == 2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0.0f;
            this.BuiltInFictitiousFunctionClassFactory = 0.0f;
            BuiltInFictitiousFunctionClassFactory(1);
            this.isLayoutRequested = 0;
        } else if (motionEvent.getAction() == 2 && this.GetContactSyncConfig == 2) {
            MyBillsEntityDataFactory();
            if (this.isLayoutRequested == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                int i = this.whenAvailable;
                iArr[0] = i;
                iArr[1] = this.scheduleImpl - i;
                float max = Math.max(iArr[0], Math.min(iArr[1], x));
                if (Math.abs(this.PlaceComponentResult - max) >= 2.0f) {
                    int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, max, iArr, this.moveToNextValue.computeHorizontalScrollRange(), this.moveToNextValue.computeHorizontalScrollOffset(), this.scheduleImpl);
                    if (BuiltInFictitiousFunctionClassFactory != 0) {
                        this.moveToNextValue.scrollBy(BuiltInFictitiousFunctionClassFactory, 0);
                    }
                    this.BuiltInFictitiousFunctionClassFactory = max;
                }
            }
            if (this.isLayoutRequested == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.readMicros;
                int i2 = this.whenAvailable;
                iArr2[0] = i2;
                iArr2[1] = this.lookAheadTest - i2;
                float max2 = Math.max(iArr2[0], Math.min(iArr2[1], y));
                if (Math.abs(this.DatabaseTableConfigUtil - max2) >= 2.0f) {
                    int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, max2, iArr2, this.moveToNextValue.computeVerticalScrollRange(), this.moveToNextValue.computeVerticalScrollOffset(), this.lookAheadTest);
                    if (BuiltInFictitiousFunctionClassFactory2 != 0) {
                        this.moveToNextValue.scrollBy(0, BuiltInFictitiousFunctionClassFactory2);
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = max2;
                }
            }
        }
    }

    private static int BuiltInFictitiousFunctionClassFactory(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
        if (!BuiltInFictitiousFunctionClassFactory() ? f >= this.scheduleImpl - this.SubSequence : f <= this.SubSequence) {
            int i = this.DatabaseTableConfigUtil;
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7 / 2;
            if (f2 >= i - i2 && f2 <= i + i2) {
                return true;
            }
        }
        return false;
    }

    private boolean MyBillsEntityDataFactory(float f, float f2) {
        if (f2 >= this.lookAheadTest - this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            int i = this.PlaceComponentResult;
            int i2 = this.getAuthRequestContext / 2;
            if (f >= i - i2 && f <= i + i2) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes6.dex */
    class AnimatorListener extends AnimatorListenerAdapter {
        private boolean BuiltInFictitiousFunctionClassFactory = false;

        AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                this.BuiltInFictitiousFunctionClassFactory = false;
            } else if (((Float) FastScroller.this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller.this.MyBillsEntityDataFactory = 0;
                FastScroller.this.BuiltInFictitiousFunctionClassFactory(0);
            } else {
                FastScroller.this.MyBillsEntityDataFactory = 2;
                FastScroller.this.moveToNextValue.invalidate();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
    }

    /* loaded from: classes6.dex */
    class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.initRecordTimeStamp.setAlpha(floatValue);
            FastScroller.this.newProxyInstance.setAlpha(floatValue);
            FastScroller.this.moveToNextValue.invalidate();
        }
    }
}
