package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class Carousel extends MotionHelper {
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private int BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    private int GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private MotionLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7;
    private float PlaceComponentResult;
    private int PrepareContext;
    private int getAuthRequestContext;
    private Adapter getErrorConfigVersion;
    private int initRecordTimeStamp;
    private float isLayoutRequested;
    private final ArrayList<View> lookAheadTest;
    int mLastStartId;
    Runnable mUpdateRunnable;
    private int moveToNextValue;
    private int scheduleImpl;

    /* loaded from: classes6.dex */
    public interface Adapter {
        int MyBillsEntityDataFactory();
    }

    public Carousel(Context context) {
        super(context);
        this.getErrorConfigVersion = null;
        this.lookAheadTest = new ArrayList<>();
        this.DatabaseTableConfigUtil = 0;
        this.scheduleImpl = 0;
        this.getAuthRequestContext = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.MyBillsEntityDataFactory = -1;
        this.GetContactSyncConfig = -1;
        this.initRecordTimeStamp = -1;
        this.PlaceComponentResult = 0.9f;
        this.PrepareContext = 0;
        this.BuiltInFictitiousFunctionClassFactory = 4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 1;
        this.isLayoutRequested = 2.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.moveToNextValue = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.setProgress(0.0f);
                Carousel.this.getAuthRequestContext();
                Adapter unused = Carousel.this.getErrorConfigVersion;
                int unused2 = Carousel.this.scheduleImpl;
                float velocity = Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.getVelocity();
                if (Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda7 != 2 || velocity <= Carousel.this.isLayoutRequested || Carousel.this.scheduleImpl >= Carousel.this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1) {
                    return;
                }
                float f = Carousel.this.PlaceComponentResult;
                if (Carousel.this.scheduleImpl != 0 || Carousel.this.DatabaseTableConfigUtil <= Carousel.this.scheduleImpl) {
                    if (Carousel.this.scheduleImpl != Carousel.this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1 || Carousel.this.DatabaseTableConfigUtil >= Carousel.this.scheduleImpl) {
                        final float f2 = velocity * f;
                        Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.touchAnimateTo(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getErrorConfigVersion = null;
        this.lookAheadTest = new ArrayList<>();
        this.DatabaseTableConfigUtil = 0;
        this.scheduleImpl = 0;
        this.getAuthRequestContext = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.MyBillsEntityDataFactory = -1;
        this.GetContactSyncConfig = -1;
        this.initRecordTimeStamp = -1;
        this.PlaceComponentResult = 0.9f;
        this.PrepareContext = 0;
        this.BuiltInFictitiousFunctionClassFactory = 4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 1;
        this.isLayoutRequested = 2.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.moveToNextValue = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.setProgress(0.0f);
                Carousel.this.getAuthRequestContext();
                Adapter unused = Carousel.this.getErrorConfigVersion;
                int unused2 = Carousel.this.scheduleImpl;
                float velocity = Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.getVelocity();
                if (Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda7 != 2 || velocity <= Carousel.this.isLayoutRequested || Carousel.this.scheduleImpl >= Carousel.this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1) {
                    return;
                }
                float f = Carousel.this.PlaceComponentResult;
                if (Carousel.this.scheduleImpl != 0 || Carousel.this.DatabaseTableConfigUtil <= Carousel.this.scheduleImpl) {
                    if (Carousel.this.scheduleImpl != Carousel.this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1 || Carousel.this.DatabaseTableConfigUtil >= Carousel.this.scheduleImpl) {
                        final float f2 = velocity * f;
                        Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.touchAnimateTo(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
        getAuthRequestContext(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getErrorConfigVersion = null;
        this.lookAheadTest = new ArrayList<>();
        this.DatabaseTableConfigUtil = 0;
        this.scheduleImpl = 0;
        this.getAuthRequestContext = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.MyBillsEntityDataFactory = -1;
        this.GetContactSyncConfig = -1;
        this.initRecordTimeStamp = -1;
        this.PlaceComponentResult = 0.9f;
        this.PrepareContext = 0;
        this.BuiltInFictitiousFunctionClassFactory = 4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 1;
        this.isLayoutRequested = 2.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.moveToNextValue = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.setProgress(0.0f);
                Carousel.this.getAuthRequestContext();
                Adapter unused = Carousel.this.getErrorConfigVersion;
                int unused2 = Carousel.this.scheduleImpl;
                float velocity = Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.getVelocity();
                if (Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda7 != 2 || velocity <= Carousel.this.isLayoutRequested || Carousel.this.scheduleImpl >= Carousel.this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1) {
                    return;
                }
                float f = Carousel.this.PlaceComponentResult;
                if (Carousel.this.scheduleImpl != 0 || Carousel.this.DatabaseTableConfigUtil <= Carousel.this.scheduleImpl) {
                    if (Carousel.this.scheduleImpl != Carousel.this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1 || Carousel.this.DatabaseTableConfigUtil >= Carousel.this.scheduleImpl) {
                        final float f2 = velocity * f;
                        Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.NetworkUserEntityData$$ExternalSyntheticLambda1.touchAnimateTo(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
        getAuthRequestContext(context, attributeSet);
    }

    private void getAuthRequestContext(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.newProxyInstance) {
                    this.getAuthRequestContext = obtainStyledAttributes.getResourceId(index, this.getAuthRequestContext);
                } else if (index == R.styleable.isLayoutRequested) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getResourceId(index, this.MyBillsEntityDataFactory);
                } else if (index == R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(index, this.BuiltInFictitiousFunctionClassFactory);
                } else if (index == R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                    this.GetContactSyncConfig = obtainStyledAttributes.getResourceId(index, this.GetContactSyncConfig);
                } else if (index == R.styleable.FragmentBottomSheetPaymentSettingBinding) {
                    this.initRecordTimeStamp = obtainStyledAttributes.getResourceId(index, this.initRecordTimeStamp);
                } else if (index == R.styleable.readMicros) {
                    this.PlaceComponentResult = obtainStyledAttributes.getFloat(index, this.PlaceComponentResult);
                } else if (index == R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda4) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getInt(index, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                } else if (index == R.styleable.SubSequence) {
                    this.isLayoutRequested = obtainStyledAttributes.getFloat(index, this.isLayoutRequested);
                } else if (index == R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getBoolean(index, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setAdapter(Adapter adapter) {
        this.getErrorConfigVersion = adapter;
    }

    public int getCount() {
        Adapter adapter = this.getErrorConfigVersion;
        if (adapter != null) {
            return adapter.MyBillsEntityDataFactory();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.scheduleImpl;
    }

    public void transitionToIndex(int i, int i2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Math.max(0, Math.min(getCount() - 1, i));
        int max = Math.max(0, i2);
        this.moveToNextValue = max;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setTransitionDuration(max);
        if (i < this.scheduleImpl) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.transitionToState(this.GetContactSyncConfig, this.moveToNextValue);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.transitionToState(this.initRecordTimeStamp, this.moveToNextValue);
        }
    }

    public void jumpToIndex(int i) {
        this.scheduleImpl = Math.max(0, Math.min(getCount() - 1, i));
        refresh();
    }

    public void refresh() {
        int size = this.lookAheadTest.size();
        for (int i = 0; i < size; i++) {
            View view = this.lookAheadTest.get(i);
            if (this.getErrorConfigVersion.MyBillsEntityDataFactory() == 0) {
                getAuthRequestContext(view, this.BuiltInFictitiousFunctionClassFactory);
            } else {
                getAuthRequestContext(view, 0);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.rebuildScene();
        getAuthRequestContext();
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
        this.mLastStartId = i;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        int i2 = this.scheduleImpl;
        this.DatabaseTableConfigUtil = i2;
        if (i == this.initRecordTimeStamp) {
            this.scheduleImpl = i2 + 1;
        } else if (i == this.GetContactSyncConfig) {
            this.scheduleImpl = i2 - 1;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (this.scheduleImpl >= this.getErrorConfigVersion.MyBillsEntityDataFactory()) {
                this.scheduleImpl = 0;
            }
            if (this.scheduleImpl < 0) {
                this.scheduleImpl = this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1;
            }
        } else {
            if (this.scheduleImpl >= this.getErrorConfigVersion.MyBillsEntityDataFactory()) {
                this.scheduleImpl = this.getErrorConfigVersion.MyBillsEntityDataFactory() - 1;
            }
            if (this.scheduleImpl < 0) {
                this.scheduleImpl = 0;
            }
        }
        if (this.DatabaseTableConfigUtil != this.scheduleImpl) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.post(this.mUpdateRunnable);
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, boolean z) {
        MotionLayout motionLayout;
        MotionScene.Transition transition;
        if (i == -1 || (motionLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda1) == null || (transition = motionLayout.getTransition(i)) == null || z == transition.BuiltInFictitiousFunctionClassFactory()) {
            return false;
        }
        transition.scheduleImpl = !z;
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        TouchResponse touchResponse;
        TouchResponse touchResponse2;
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i = 0; i < this.mCount; i++) {
                int i2 = this.mIds[i];
                View viewById = motionLayout.getViewById(i2);
                if (this.getAuthRequestContext == i2) {
                    this.PrepareContext = i;
                }
                this.lookAheadTest.add(viewById);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = motionLayout;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == 2) {
                MotionScene.Transition transition = motionLayout.getTransition(this.MyBillsEntityDataFactory);
                if (transition != null && (touchResponse2 = transition.NetworkUserEntityData$$ExternalSyntheticLambda2) != null) {
                    touchResponse2.DatabaseTableConfigUtil = 5;
                }
                MotionScene.Transition transition2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
                if (transition2 != null && (touchResponse = transition2.NetworkUserEntityData$$ExternalSyntheticLambda2) != null) {
                    touchResponse.DatabaseTableConfigUtil = 5;
                }
            }
            getAuthRequestContext();
        }
    }

    private boolean getAuthRequestContext(View view, int i) {
        MotionLayout motionLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (motionLayout == null) {
            return false;
        }
        boolean z = false;
        for (int i2 : motionLayout.getConstraintSetIds()) {
            z |= PlaceComponentResult(i2, view, i);
        }
        return z;
    }

    private boolean PlaceComponentResult(int i, View view, int i2) {
        ConstraintSet constraintSet = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getConstraintSet(i);
        if (constraintSet == null) {
            return false;
        }
        int id2 = view.getId();
        ConstraintSet.Constraint constraint = constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(id2)) ? constraintSet.getAuthRequestContext.get(Integer.valueOf(id2)) : null;
        if (constraint == null) {
            return false;
        }
        constraint.scheduleImpl.PlaceComponentResult = 1;
        view.setVisibility(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext() {
        Adapter adapter = this.getErrorConfigVersion;
        if (adapter == null || this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null || adapter.MyBillsEntityDataFactory() == 0) {
            return;
        }
        int size = this.lookAheadTest.size();
        for (int i = 0; i < size; i++) {
            View view = this.lookAheadTest.get(i);
            int i2 = (this.scheduleImpl + i) - this.PrepareContext;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                if (i2 < 0) {
                    int i3 = this.BuiltInFictitiousFunctionClassFactory;
                    if (i3 != 4) {
                        getAuthRequestContext(view, i3);
                    } else {
                        getAuthRequestContext(view, 0);
                    }
                    if (i2 % this.getErrorConfigVersion.MyBillsEntityDataFactory() != 0) {
                        int MyBillsEntityDataFactory = i2 % this.getErrorConfigVersion.MyBillsEntityDataFactory();
                    }
                } else if (i2 >= this.getErrorConfigVersion.MyBillsEntityDataFactory()) {
                    if (i2 != this.getErrorConfigVersion.MyBillsEntityDataFactory() && i2 > this.getErrorConfigVersion.MyBillsEntityDataFactory()) {
                        int MyBillsEntityDataFactory2 = i2 % this.getErrorConfigVersion.MyBillsEntityDataFactory();
                    }
                    int i4 = this.BuiltInFictitiousFunctionClassFactory;
                    if (i4 != 4) {
                        getAuthRequestContext(view, i4);
                    } else {
                        getAuthRequestContext(view, 0);
                    }
                } else {
                    getAuthRequestContext(view, 0);
                }
            } else if (i2 < 0) {
                getAuthRequestContext(view, this.BuiltInFictitiousFunctionClassFactory);
            } else if (i2 >= this.getErrorConfigVersion.MyBillsEntityDataFactory()) {
                getAuthRequestContext(view, this.BuiltInFictitiousFunctionClassFactory);
            } else {
                getAuthRequestContext(view, 0);
            }
        }
        int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i5 != -1 && i5 != this.scheduleImpl) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Carousel.this.m6xc943cdea();
                }
            });
        } else if (i5 == this.scheduleImpl) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == -1 || this.MyBillsEntityDataFactory == -1) {
            InstrumentInjector.log_w("Carousel", "No backward or forward transitions defined for Carousel!");
        } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            int MyBillsEntityDataFactory3 = this.getErrorConfigVersion.MyBillsEntityDataFactory();
            if (this.scheduleImpl == 0) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, false);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, true);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.setTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (this.scheduleImpl == MyBillsEntityDataFactory3 - 1) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, false);
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, true);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setTransition(this.MyBillsEntityDataFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateItems$0$androidx-constraintlayout-helper-widget-Carousel  reason: not valid java name */
    public /* synthetic */ void m6xc943cdea() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setTransitionDuration(this.moveToNextValue);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 < this.scheduleImpl) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.transitionToState(this.GetContactSyncConfig, this.moveToNextValue);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.transitionToState(this.initRecordTimeStamp, this.moveToNextValue);
        }
    }
}
