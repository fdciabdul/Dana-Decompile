package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.widget.NestedScrollView;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3, FSDispatchDraw {
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    private int[] A;
    private int B;
    private StateCache BottomSheetCardBindingView$watcherCardNumberView$1;
    private long BuiltInFictitiousFunctionClassFactory;
    private int C;
    private boolean D;
    private DesignTool DatabaseTableConfigUtil;
    private StopLogic E;
    private TransitionListener F;
    private int FragmentBottomSheetPaymentSettingBinding;
    private boolean GetContactSyncConfig;
    private CopyOnWriteArrayList<TransitionListener> I;
    private float MyBillsEntityDataFactory;
    private DecelerateInterpolator NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda3;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private float NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Matrix NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private float PlaceComponentResult;
    private KeyCache PrepareContext;
    private int SubSequence;
    private View VerifyPinStateManager$executeRiskChallenge$2$1;
    private long VerifyPinStateManager$executeRiskChallenge$2$2;
    boolean firstDown;
    private ArrayList<MotionHelper> getCallingPid;
    private boolean getErrorConfigVersion;
    private boolean getOnBoardingScenario;
    private ArrayList<MotionHelper> getSupportButtonTintMode;
    private float getValueOfTouchPositionAbsolute;
    private int initRecordTimeStamp;
    private long isLayoutRequested;
    private RectF lookAheadTest;
    int mCurrentState;
    int mDebugPath;
    DevModeDraw mDevModeDraw;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList;
    int mHeightMeasureMode;
    boolean mInTransition;
    boolean mIndirectTransition;
    Interpolator mInterpolator;
    boolean mIsAnimating;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    int mOldHeight;
    int mOldWidth;
    float mPostInterpolationPosition;
    HashMap<View, ViewState> mPreRotate;
    Interpolator mProgressInterpolator;
    int mRotatMode;
    MotionScene mScene;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    Rect mTempRect;
    ArrayList<Integer> mTransitionCompleted;
    float mTransitionGoalPosition;
    float mTransitionLastPosition;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;
    private ArrayList<MotionHelper> moveToNextValue;
    private boolean newProxyInstance;
    private boolean readMicros;
    private int scheduleImpl;
    private Runnable whenAvailable;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public interface MotionTracker {
        float BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent);

        float MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(int i);
    }

    /* loaded from: classes3.dex */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3) {
        if (f > 0.0f) {
            float f4 = f / f3;
            return f2 + ((f * f4) - (((f3 * f4) * f4) / 2.0f)) > 1.0f;
        }
        float f5 = (-f) / f3;
        return f2 + ((f * f5) + (((f3 * f5) * f5) / 2.0f)) < 0.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionController getMotionController(int i) {
        return this.mFrameArrayList.get(findViewById(i));
    }

    public MotionLayout(Context context) {
        super(context);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.scheduleImpl = -1;
        this.mCurrentState = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.FragmentBottomSheetPaymentSettingBinding = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
        this.newProxyInstance = true;
        this.mFrameArrayList = new HashMap<>();
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.getValueOfTouchPositionAbsolute = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.D = false;
        this.E = new StopLogic();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        this.getSupportButtonTintMode = null;
        this.getCallingPid = null;
        this.moveToNextValue = null;
        this.I = null;
        this.initRecordTimeStamp = 0;
        this.isLayoutRequested = -1L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.PrepareContext = new KeyCache();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.whenAvailable = null;
        this.A = null;
        this.mScheduledTransitions = 0;
        this.GetContactSyncConfig = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.getErrorConfigVersion = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.readMicros = false;
        this.lookAheadTest = new RectF();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.mTransitionCompleted = new ArrayList<>();
        KClassImpl$Data$declaredNonStaticMembers$2(null);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.scheduleImpl = -1;
        this.mCurrentState = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.FragmentBottomSheetPaymentSettingBinding = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
        this.newProxyInstance = true;
        this.mFrameArrayList = new HashMap<>();
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.getValueOfTouchPositionAbsolute = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.D = false;
        this.E = new StopLogic();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        this.getSupportButtonTintMode = null;
        this.getCallingPid = null;
        this.moveToNextValue = null;
        this.I = null;
        this.initRecordTimeStamp = 0;
        this.isLayoutRequested = -1L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.PrepareContext = new KeyCache();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.whenAvailable = null;
        this.A = null;
        this.mScheduledTransitions = 0;
        this.GetContactSyncConfig = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.getErrorConfigVersion = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.readMicros = false;
        this.lookAheadTest = new RectF();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.mTransitionCompleted = new ArrayList<>();
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.scheduleImpl = -1;
        this.mCurrentState = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.FragmentBottomSheetPaymentSettingBinding = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
        this.newProxyInstance = true;
        this.mFrameArrayList = new HashMap<>();
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.getValueOfTouchPositionAbsolute = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.D = false;
        this.E = new StopLogic();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        this.getSupportButtonTintMode = null;
        this.getCallingPid = null;
        this.moveToNextValue = null;
        this.I = null;
        this.initRecordTimeStamp = 0;
        this.isLayoutRequested = -1L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.PrepareContext = new KeyCache();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.whenAvailable = null;
        this.A = null;
        this.mScheduledTransitions = 0;
        this.GetContactSyncConfig = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.getErrorConfigVersion = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.readMicros = false;
        this.lookAheadTest = new RectF();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.mTransitionCompleted = new ArrayList<>();
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MotionTracker obtainVelocityTracker() {
        return MyTracker.getAuthRequestContext();
    }

    public void enableTransition(int i, boolean z) {
        MotionScene.Transition transition = getTransition(i);
        if (!z) {
            if (transition == this.mScene.getAuthRequestContext) {
                Iterator<MotionScene.Transition> it = this.mScene.KClassImpl$Data$declaredNonStaticMembers$2(this.mCurrentState).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MotionScene.Transition next = it.next();
                    if (next.BuiltInFictitiousFunctionClassFactory()) {
                        this.mScene.getAuthRequestContext = next;
                        break;
                    }
                }
            }
            transition.scheduleImpl = true;
            return;
        }
        transition.scheduleImpl = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        if (transitionState == TransitionState.FINISHED && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState2 = this.mTransitionState;
        this.mTransitionState = transitionState;
        if (transitionState2 == TransitionState.MOVING && transitionState == TransitionState.MOVING) {
            MyBillsEntityDataFactory();
        }
        int i = AnonymousClass5.KClassImpl$Data$declaredNonStaticMembers$2[transitionState2.ordinal()];
        if (i == 1 || i == 2) {
            if (transitionState == TransitionState.MOVING) {
                MyBillsEntityDataFactory();
            }
            if (transitionState == TransitionState.FINISHED) {
                fireTransitionCompleted();
            }
        } else if (i == 3 && transitionState == TransitionState.FINISHED) {
            fireTransitionCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[TransitionState.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    static class MyTracker implements MotionTracker {
        private static MyTracker KClassImpl$Data$declaredNonStaticMembers$2 = new MyTracker();
        VelocityTracker getAuthRequestContext;

        private MyTracker() {
        }

        public static MyTracker getAuthRequestContext() {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = VelocityTracker.obtain();
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public final void PlaceComponentResult() {
            VelocityTracker velocityTracker = this.getAuthRequestContext;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.getAuthRequestContext = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public final void BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.getAuthRequestContext;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public final void PlaceComponentResult(int i) {
            VelocityTracker velocityTracker = this.getAuthRequestContext;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public final float BuiltInFictitiousFunctionClassFactory() {
            VelocityTracker velocityTracker = this.getAuthRequestContext;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public final float MyBillsEntityDataFactory() {
            VelocityTracker velocityTracker = this.getAuthRequestContext;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }
    }

    void setStartState(int i) {
        if (!isAttachedToWindow()) {
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1.getErrorConfigVersion = i;
            this.BottomSheetCardBindingView$watcherCardNumberView$1.getAuthRequestContext = i;
            return;
        }
        this.mCurrentState = i;
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1.getErrorConfigVersion = i;
            this.BottomSheetCardBindingView$watcherCardNumberView$1.getAuthRequestContext = i2;
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.scheduleImpl = i;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i2;
            motionScene.MyBillsEntityDataFactory(i, i2);
            Model model = this.mModel;
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            model.getAuthRequestContext(this.mScene.getAuthRequestContext(i), this.mScene.getAuthRequestContext(i2));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransition(int i) {
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i);
            this.scheduleImpl = transition.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = transition.getAuthRequestContext;
            if (!isAttachedToWindow()) {
                if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                    this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
                }
                this.BottomSheetCardBindingView$watcherCardNumberView$1.getErrorConfigVersion = this.scheduleImpl;
                this.BottomSheetCardBindingView$watcherCardNumberView$1.getAuthRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                return;
            }
            float f = Float.NaN;
            int i2 = this.mCurrentState;
            if (i2 == this.scheduleImpl) {
                f = 0.0f;
            } else if (i2 == this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                f = 1.0f;
            }
            MotionScene motionScene = this.mScene;
            motionScene.getAuthRequestContext = transition;
            if (transition != null && MotionScene.Transition.scheduleImpl(transition) != null) {
                MotionScene.Transition.scheduleImpl(motionScene.getAuthRequestContext).getAuthRequestContext(motionScene.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            Model model = this.mModel;
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            model.getAuthRequestContext(this.mScene.getAuthRequestContext(this.scheduleImpl), this.mScene.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            rebuildScene();
            if (this.mTransitionLastPosition != f) {
                if (f == 0.0f) {
                    endTrigger(true);
                    this.mScene.getAuthRequestContext(this.scheduleImpl).KClassImpl$Data$declaredNonStaticMembers$2(this);
                } else if (f == 1.0f) {
                    endTrigger(false);
                    this.mScene.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2).KClassImpl$Data$declaredNonStaticMembers$2(this);
                }
            }
            this.mTransitionLastPosition = Float.isNaN(f) ? 0.0f : f;
            if (Float.isNaN(f)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Debug.MyBillsEntityDataFactory());
                sb.append(" transitionToStart ");
                InstrumentInjector.log_v(TAG, sb.toString());
                transitionToStart();
                return;
            }
            setProgress(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransition(MotionScene.Transition transition) {
        MotionScene motionScene = this.mScene;
        motionScene.getAuthRequestContext = transition;
        if (transition != null && MotionScene.Transition.scheduleImpl(transition) != null) {
            MotionScene.Transition.scheduleImpl(motionScene.getAuthRequestContext).getAuthRequestContext(motionScene.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        setState(TransitionState.SETUP);
        int i = this.mCurrentState;
        MotionScene.Transition transition2 = this.mScene.getAuthRequestContext;
        if (i == (transition2 == null ? -1 : MotionScene.Transition.MyBillsEntityDataFactory(transition2))) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = transition.getAuthRequestContext(1) ? -1L : getNanoTime();
        MotionScene.Transition transition3 = this.mScene.getAuthRequestContext;
        int PlaceComponentResult = transition3 == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition3);
        MotionScene.Transition transition4 = this.mScene.getAuthRequestContext;
        int MyBillsEntityDataFactory = transition4 != null ? MotionScene.Transition.MyBillsEntityDataFactory(transition4) : -1;
        if (PlaceComponentResult == this.scheduleImpl && MyBillsEntityDataFactory == this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return;
        }
        this.scheduleImpl = PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory;
        this.mScene.MyBillsEntityDataFactory(PlaceComponentResult, MyBillsEntityDataFactory);
        Model model = this.mModel;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        model.getAuthRequestContext(this.mScene.getAuthRequestContext(this.scheduleImpl), this.mScene.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        Model model2 = this.mModel;
        int i2 = this.scheduleImpl;
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        model2.lookAheadTest = i2;
        model2.getAuthRequestContext = i3;
        this.mModel.BuiltInFictitiousFunctionClassFactory();
        rebuildScene();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i);
                this.mScene = motionScene;
                int i2 = -1;
                if (this.mCurrentState == -1) {
                    MotionScene.Transition transition = motionScene.getAuthRequestContext;
                    this.mCurrentState = transition == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition);
                    MotionScene.Transition transition2 = this.mScene.getAuthRequestContext;
                    this.scheduleImpl = transition2 == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition2);
                    MotionScene.Transition transition3 = this.mScene.getAuthRequestContext;
                    if (transition3 != null) {
                        i2 = MotionScene.Transition.MyBillsEntityDataFactory(transition3);
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i2;
                }
                if (Build.VERSION.SDK_INT >= 19 && !isAttachedToWindow()) {
                    this.mScene = null;
                    return;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        Display display = getDisplay();
                        this.B = display == null ? 0 : display.getRotation();
                    }
                    MotionScene motionScene2 = this.mScene;
                    if (motionScene2 != null) {
                        ConstraintSet authRequestContext = motionScene2.getAuthRequestContext(this.mCurrentState);
                        this.mScene.PlaceComponentResult(this);
                        ArrayList<MotionHelper> arrayList = this.moveToNextValue;
                        if (arrayList != null) {
                            Iterator<MotionHelper> it = arrayList.iterator();
                            while (it.hasNext()) {
                                it.next().onFinishedMotionScene(this);
                            }
                        }
                        if (authRequestContext != null) {
                            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
                        }
                        this.scheduleImpl = this.mCurrentState;
                    }
                    onNewStateAttachHandlers();
                    StateCache stateCache = this.BottomSheetCardBindingView$watcherCardNumberView$1;
                    if (stateCache != null) {
                        if (this.getErrorConfigVersion) {
                            post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MotionLayout.this.BottomSheetCardBindingView$watcherCardNumberView$1.BuiltInFictitiousFunctionClassFactory();
                                }
                            });
                            return;
                        } else {
                            stateCache.BuiltInFictitiousFunctionClassFactory();
                            return;
                        }
                    }
                    MotionScene motionScene3 = this.mScene;
                    if (motionScene3 == null || motionScene3.getAuthRequestContext == null || this.mScene.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 != 4) {
                        return;
                    }
                    transitionToEnd();
                    setState(TransitionState.SETUP);
                    setState(TransitionState.MOVING);
                    return;
                } catch (Exception e) {
                    throw new IllegalArgumentException("unable to parse MotionScene file", e);
                }
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            }
        }
        this.mScene = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i;
        this.scheduleImpl = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getAuthRequestContext(i).KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
    }

    public void setInterpolatedProgress(float f) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator authRequestContext = this.mScene.getAuthRequestContext();
            if (authRequestContext != null) {
                setProgress(authRequestContext.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setProgress(float f, float f2) {
        if (!isAttachedToWindow()) {
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1.lookAheadTest = f;
            this.BottomSheetCardBindingView$watcherCardNumberView$1.moveToNextValue = f2;
            return;
        }
        setProgress(f);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f2;
        if (f2 != 0.0f) {
            animateTo(f2 <= 0.0f ? 0.0f : 1.0f);
        } else if (f == 0.0f || f == 1.0f) {
        } else {
            animateTo(f <= 0.5f ? 0.0f : 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class StateCache {
        float lookAheadTest = Float.NaN;
        float moveToNextValue = Float.NaN;
        int getErrorConfigVersion = -1;
        int getAuthRequestContext = -1;
        final String PlaceComponentResult = "motion.progress";
        final String BuiltInFictitiousFunctionClassFactory = "motion.velocity";
        final String MyBillsEntityDataFactory = "motion.StartState";
        final String KClassImpl$Data$declaredNonStaticMembers$2 = "motion.EndState";

        StateCache() {
        }

        final void BuiltInFictitiousFunctionClassFactory() {
            int i = this.getErrorConfigVersion;
            if (i != -1 || this.getAuthRequestContext != -1) {
                if (i == -1) {
                    MotionLayout.this.transitionToState(this.getAuthRequestContext);
                } else {
                    int i2 = this.getAuthRequestContext;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.moveToNextValue)) {
                if (Float.isNaN(this.lookAheadTest)) {
                    return;
                }
                MotionLayout.this.setProgress(this.lookAheadTest);
                return;
            }
            MotionLayout.this.setProgress(this.lookAheadTest, this.moveToNextValue);
            this.lookAheadTest = Float.NaN;
            this.moveToNextValue = Float.NaN;
            this.getErrorConfigVersion = -1;
            this.getAuthRequestContext = -1;
        }
    }

    public void setTransitionState(Bundle bundle) {
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
        }
        StateCache stateCache = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        stateCache.lookAheadTest = bundle.getFloat("motion.progress");
        stateCache.moveToNextValue = bundle.getFloat("motion.velocity");
        stateCache.getErrorConfigVersion = bundle.getInt("motion.StartState");
        stateCache.getAuthRequestContext = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.BottomSheetCardBindingView$watcherCardNumberView$1.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public Bundle getTransitionState() {
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
        }
        StateCache stateCache = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        stateCache.getAuthRequestContext = MotionLayout.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        stateCache.getErrorConfigVersion = MotionLayout.this.scheduleImpl;
        stateCache.moveToNextValue = MotionLayout.this.getVelocity();
        stateCache.lookAheadTest = MotionLayout.this.getProgress();
        StateCache stateCache2 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", stateCache2.lookAheadTest);
        bundle.putFloat("motion.velocity", stateCache2.moveToNextValue);
        bundle.putInt("motion.StartState", stateCache2.getErrorConfigVersion);
        bundle.putInt("motion.EndState", stateCache2.getAuthRequestContext);
        return bundle;
    }

    public void setProgress(float f) {
        if (f < 0.0f || f > 1.0f) {
            InstrumentInjector.log_w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1.lookAheadTest = f;
            return;
        }
        if (f <= 0.0f) {
            if (this.mTransitionLastPosition == 1.0f && this.mCurrentState == this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.scheduleImpl;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f >= 1.0f) {
            if (this.mTransitionLastPosition == 0.0f && this.mCurrentState == this.scheduleImpl) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.getOnBoardingScenario = true;
        this.mTransitionGoalPosition = f;
        this.mTransitionPosition = f;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = -1L;
        this.BuiltInFictitiousFunctionClassFactory = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        if (r12 != 7) goto L117;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void touchAnimateTo(int r12, float r13, float r14) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f, float f2) {
        int i;
        if (this.mScene == null || this.mTransitionLastPosition == f) {
            return;
        }
        this.D = true;
        this.BuiltInFictitiousFunctionClassFactory = getNanoTime();
        MotionScene motionScene = this.mScene;
        MotionScene.Transition transition = motionScene.getAuthRequestContext;
        if (transition != null) {
            i = MotionScene.Transition.lookAheadTest(transition);
        } else {
            i = motionScene.MyBillsEntityDataFactory;
        }
        this.getValueOfTouchPositionAbsolute = i / 1000.0f;
        this.mTransitionGoalPosition = f;
        this.mInTransition = true;
        StopLogic stopLogic = this.E;
        float f3 = this.mTransitionLastPosition;
        MotionScene motionScene2 = this.mScene;
        MotionScene.Transition transition2 = motionScene2.getAuthRequestContext;
        float f4 = (transition2 == null || MotionScene.Transition.scheduleImpl(transition2) == null) ? 0.0f : MotionScene.Transition.scheduleImpl(motionScene2.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda8;
        MotionScene motionScene3 = this.mScene;
        MotionScene.Transition transition3 = motionScene3.getAuthRequestContext;
        float f5 = (transition3 == null || MotionScene.Transition.scheduleImpl(transition3) == null) ? 0.0f : MotionScene.Transition.scheduleImpl(motionScene3.getAuthRequestContext).isLayoutRequested;
        MotionScene motionScene4 = this.mScene;
        MotionScene.Transition transition4 = motionScene4.getAuthRequestContext;
        float f6 = (transition4 == null || MotionScene.Transition.scheduleImpl(transition4) == null) ? 0.0f : MotionScene.Transition.scheduleImpl(motionScene4.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda7;
        MotionScene motionScene5 = this.mScene;
        MotionScene.Transition transition5 = motionScene5.getAuthRequestContext;
        float f7 = (transition5 == null || MotionScene.Transition.scheduleImpl(transition5) == null) ? 0.0f : MotionScene.Transition.scheduleImpl(motionScene5.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda4;
        MotionScene motionScene6 = this.mScene;
        MotionScene.Transition transition6 = motionScene6.getAuthRequestContext;
        stopLogic.getAuthRequestContext(f3, f, f2, f4, f5, f6, f7, (transition6 == null || MotionScene.Transition.scheduleImpl(transition6) == null) ? 0 : MotionScene.Transition.scheduleImpl(motionScene6.getAuthRequestContext).newProxyInstance);
        int i2 = this.mCurrentState;
        this.mTransitionGoalPosition = f;
        this.mCurrentState = i2;
        this.mInterpolator = this.E;
        this.getOnBoardingScenario = false;
        this.BuiltInFictitiousFunctionClassFactory = getNanoTime();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DecelerateInterpolator extends MotionInterpolator {
        float BuiltInFictitiousFunctionClassFactory;
        float KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        float MyBillsEntityDataFactory = 0.0f;

        DecelerateInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2;
            float f3;
            float f4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (f4 > 0.0f) {
                float f5 = this.BuiltInFictitiousFunctionClassFactory;
                float f6 = f4 / f5;
                if (f6 < f) {
                    f = f6;
                }
                MotionLayout.this.mLastVelocity = f4 - (f5 * f);
                f2 = (this.KClassImpl$Data$declaredNonStaticMembers$2 * f) - (((this.BuiltInFictitiousFunctionClassFactory * f) * f) / 2.0f);
                f3 = this.MyBillsEntityDataFactory;
            } else {
                float f7 = this.BuiltInFictitiousFunctionClassFactory;
                float f8 = (-f4) / f7;
                if (f8 < f) {
                    f = f8;
                }
                MotionLayout.this.mLastVelocity = f4 + (f7 * f);
                f2 = (this.KClassImpl$Data$declaredNonStaticMembers$2 * f) + (((this.BuiltInFictitiousFunctionClassFactory * f) * f) / 2.0f);
                f3 = this.MyBillsEntityDataFactory;
            }
            return f2 + f3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public final float PlaceComponentResult() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    void animateTo(float f) {
        int i;
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        float f2 = this.mTransitionLastPosition;
        float f3 = this.mTransitionPosition;
        if (f2 != f3 && this.getOnBoardingScenario) {
            this.mTransitionLastPosition = f3;
        }
        float f4 = this.mTransitionLastPosition;
        if (f4 == f) {
            return;
        }
        this.D = false;
        this.mTransitionGoalPosition = f;
        MotionScene.Transition transition = motionScene.getAuthRequestContext;
        if (transition != null) {
            i = MotionScene.Transition.lookAheadTest(transition);
        } else {
            i = motionScene.MyBillsEntityDataFactory;
        }
        this.getValueOfTouchPositionAbsolute = i / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.getAuthRequestContext();
        this.getOnBoardingScenario = false;
        this.BuiltInFictitiousFunctionClassFactory = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f4;
        this.mTransitionLastPosition = f4;
        invalidate();
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.whenAvailable = null;
    }

    public void transitionToEnd(Runnable runnable) {
        animateTo(1.0f);
        this.whenAvailable = runnable;
    }

    public void transitionToState(int i) {
        if (!isAttachedToWindow()) {
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1.getAuthRequestContext = i;
            return;
        }
        transitionToState(i, -1, -1);
    }

    public void transitionToState(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = new StateCache();
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1.getAuthRequestContext = i;
            return;
        }
        transitionToState(i, -1, -1, i2);
    }

    public void transitionToState(int i, int i2, int i3) {
        transitionToState(i, i2, i3, -1);
    }

    public void rotateTo(int i, int i2) {
        this.GetContactSyncConfig = true;
        this.C = getWidth();
        this.SubSequence = getHeight();
        int rotation = getDisplay().getRotation();
        this.mRotatMode = (rotation + 1) % 4 <= (this.B + 1) % 4 ? 2 : 1;
        this.B = rotation;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            ViewState viewState = this.mPreRotate.get(childAt);
            if (viewState == null) {
                viewState = new ViewState();
                this.mPreRotate.put(childAt, viewState);
            }
            viewState.getAuthRequestContext = childAt.getLeft();
            viewState.BuiltInFictitiousFunctionClassFactory = childAt.getTop();
            viewState.KClassImpl$Data$declaredNonStaticMembers$2 = childAt.getRight();
            viewState.PlaceComponentResult = childAt.getBottom();
            viewState.MyBillsEntityDataFactory = childAt.getRotation();
        }
        this.scheduleImpl = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        this.mScene.MyBillsEntityDataFactory(-1, i);
        Model model = this.mModel;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        model.getAuthRequestContext((ConstraintSet) null, this.mScene.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.2
            @Override // java.lang.Runnable
            public void run() {
                MotionLayout.this.GetContactSyncConfig = false;
            }
        });
        if (i2 > 0) {
            this.getValueOfTouchPositionAbsolute = i2 / 1000.0f;
        }
    }

    public boolean isInRotation() {
        return this.GetContactSyncConfig;
    }

    public void jumpToState(int i) {
        if (!isAttachedToWindow()) {
            this.mCurrentState = i;
        }
        if (this.scheduleImpl == i) {
            setProgress(0.0f);
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == i) {
            setProgress(1.0f);
        } else {
            setTransition(i, i);
        }
    }

    public void transitionToState(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && motionScene.scheduleImpl != null) {
            StateSet stateSet = this.mScene.scheduleImpl;
            int i7 = this.mCurrentState;
            float f = i2;
            float f2 = i3;
            StateSet.State state = stateSet.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
            if (state == null) {
                i7 = i;
            } else if (f == -1.0f || f2 == -1.0f) {
                if (state.BuiltInFictitiousFunctionClassFactory != i7) {
                    Iterator<StateSet.Variant> it = state.PlaceComponentResult.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (i7 == it.next().KClassImpl$Data$declaredNonStaticMembers$2) {
                                break;
                            }
                        } else {
                            i7 = state.BuiltInFictitiousFunctionClassFactory;
                            break;
                        }
                    }
                }
            } else {
                Iterator<StateSet.Variant> it2 = state.PlaceComponentResult.iterator();
                StateSet.Variant variant = null;
                while (true) {
                    if (it2.hasNext()) {
                        StateSet.Variant next = it2.next();
                        if (next.getAuthRequestContext(f, f2)) {
                            if (i7 == next.KClassImpl$Data$declaredNonStaticMembers$2) {
                                break;
                            }
                            variant = next;
                        }
                    } else if (variant != null) {
                        i7 = variant.KClassImpl$Data$declaredNonStaticMembers$2;
                    } else {
                        i7 = state.BuiltInFictitiousFunctionClassFactory;
                    }
                }
            }
            if (i7 != -1) {
                i = i7;
            }
        }
        int i8 = this.mCurrentState;
        if (i8 == i) {
            return;
        }
        if (this.scheduleImpl == i) {
            animateTo(0.0f);
            if (i4 > 0) {
                this.getValueOfTouchPositionAbsolute = i4 / 1000.0f;
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == i) {
            animateTo(1.0f);
            if (i4 > 0) {
                this.getValueOfTouchPositionAbsolute = i4 / 1000.0f;
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
            if (i8 != -1) {
                setTransition(i8, i);
                animateTo(1.0f);
                this.mTransitionLastPosition = 0.0f;
                transitionToEnd();
                if (i4 > 0) {
                    this.getValueOfTouchPositionAbsolute = i4 / 1000.0f;
                    return;
                }
                return;
            }
            this.D = false;
            this.mTransitionGoalPosition = 1.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionLastPosition = 0.0f;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = getNanoTime();
            this.BuiltInFictitiousFunctionClassFactory = getNanoTime();
            this.getOnBoardingScenario = false;
            this.mInterpolator = null;
            if (i4 == -1) {
                MotionScene motionScene2 = this.mScene;
                MotionScene.Transition transition = motionScene2.getAuthRequestContext;
                if (transition != null) {
                    i6 = MotionScene.Transition.lookAheadTest(transition);
                } else {
                    i6 = motionScene2.MyBillsEntityDataFactory;
                }
                this.getValueOfTouchPositionAbsolute = i6 / 1000.0f;
            }
            this.scheduleImpl = -1;
            this.mScene.MyBillsEntityDataFactory(-1, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            SparseArray sparseArray = new SparseArray();
            if (i4 == 0) {
                MotionScene motionScene3 = this.mScene;
                MotionScene.Transition transition2 = motionScene3.getAuthRequestContext;
                if (transition2 != null) {
                    i5 = MotionScene.Transition.lookAheadTest(transition2);
                } else {
                    i5 = motionScene3.MyBillsEntityDataFactory;
                }
                this.getValueOfTouchPositionAbsolute = i5 / 1000.0f;
            } else if (i4 > 0) {
                this.getValueOfTouchPositionAbsolute = i4 / 1000.0f;
            }
            int childCount = getChildCount();
            this.mFrameArrayList.clear();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                this.mFrameArrayList.put(childAt, new MotionController(childAt));
                sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
            }
            this.mInTransition = true;
            Model model = this.mModel;
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            model.getAuthRequestContext((ConstraintSet) null, this.mScene.getAuthRequestContext(i));
            rebuildScene();
            this.mModel.getAuthRequestContext();
            int childCount2 = getChildCount();
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt2 = getChildAt(i10);
                MotionController motionController = this.mFrameArrayList.get(childAt2);
                if (motionController != null) {
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.isLayoutRequested = 0.0f;
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.PrepareContext = 0.0f;
                    MotionPaths motionPaths = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    float x = childAt2.getX();
                    float y = childAt2.getY();
                    float width = childAt2.getWidth();
                    float height = childAt2.getHeight();
                    motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 = x;
                    motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 = y;
                    motionPaths.newProxyInstance = width;
                    motionPaths.PlaceComponentResult = height;
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda3.KClassImpl$Data$declaredNonStaticMembers$2(childAt2);
                }
            }
            int width2 = getWidth();
            int height2 = getHeight();
            if (this.moveToNextValue != null) {
                for (int i11 = 0; i11 < childCount; i11++) {
                    MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i11));
                    if (motionController2 != null) {
                        this.mScene.getAuthRequestContext(motionController2);
                    }
                }
                Iterator<MotionHelper> it3 = this.moveToNextValue.iterator();
                while (it3.hasNext()) {
                    it3.next().onPreSetup(this, this.mFrameArrayList);
                }
                for (int i12 = 0; i12 < childCount; i12++) {
                    MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i12));
                    if (motionController3 != null) {
                        motionController3.PlaceComponentResult(width2, height2, getNanoTime());
                    }
                }
            } else {
                for (int i13 = 0; i13 < childCount; i13++) {
                    MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i13));
                    if (motionController4 != null) {
                        this.mScene.getAuthRequestContext(motionController4);
                        motionController4.PlaceComponentResult(width2, height2, getNanoTime());
                    }
                }
            }
            MotionScene.Transition transition3 = this.mScene.getAuthRequestContext;
            float initRecordTimeStamp = transition3 != null ? MotionScene.Transition.initRecordTimeStamp(transition3) : 0.0f;
            if (initRecordTimeStamp != 0.0f) {
                float f3 = Float.MAX_VALUE;
                float f4 = -3.4028235E38f;
                for (int i14 = 0; i14 < childCount; i14++) {
                    MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i14));
                    float f5 = motionController5.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8 + motionController5.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    f3 = Math.min(f3, f5);
                    f4 = Math.max(f4, f5);
                }
                for (int i15 = 0; i15 < childCount; i15++) {
                    MotionController motionController6 = this.mFrameArrayList.get(getChildAt(i15));
                    float f6 = motionController6.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    float f7 = motionController6.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    motionController6.NetworkUserEntityData$$ExternalSyntheticLambda6 = 1.0f / (1.0f - initRecordTimeStamp);
                    motionController6.NetworkUserEntityData$$ExternalSyntheticLambda4 = initRecordTimeStamp - ((((f6 + f7) - f3) * initRecordTimeStamp) / (f4 - f3));
                }
            }
            this.mTransitionPosition = 0.0f;
            this.mTransitionLastPosition = 0.0f;
            this.mInTransition = true;
            invalidate();
        }
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f, float f2, float[] fArr, int i) {
        float[] fArr2;
        float f3;
        int i2;
        int i3;
        double[] dArr;
        float f4 = this.mLastVelocity;
        float f5 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f5);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + 1.0E-5f);
            float interpolation2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f4 = (signum * ((interpolation - interpolation2) / 1.0E-5f)) / this.getValueOfTouchPositionAbsolute;
            f5 = interpolation2;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            f4 = ((MotionInterpolator) interpolator).PlaceComponentResult();
        }
        float f6 = f4;
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i & 1) == 0) {
            int width = view.getWidth();
            int height = view.getHeight();
            float authRequestContext = motionController.getAuthRequestContext(f5, motionController.readMicros);
            HashMap<String, ViewSpline> hashMap = motionController.KClassImpl$Data$declaredNonStaticMembers$2;
            ViewSpline viewSpline = hashMap == null ? null : hashMap.get("translationX");
            HashMap<String, ViewSpline> hashMap2 = motionController.KClassImpl$Data$declaredNonStaticMembers$2;
            ViewSpline viewSpline2 = hashMap2 == null ? null : hashMap2.get("translationY");
            HashMap<String, ViewSpline> hashMap3 = motionController.KClassImpl$Data$declaredNonStaticMembers$2;
            ViewSpline viewSpline3 = hashMap3 == null ? null : hashMap3.get("rotation");
            HashMap<String, ViewSpline> hashMap4 = motionController.KClassImpl$Data$declaredNonStaticMembers$2;
            f3 = f6;
            ViewSpline viewSpline4 = hashMap4 == null ? null : hashMap4.get("scaleX");
            HashMap<String, ViewSpline> hashMap5 = motionController.KClassImpl$Data$declaredNonStaticMembers$2;
            ViewSpline viewSpline5 = hashMap5 == null ? null : hashMap5.get("scaleY");
            HashMap<String, ViewOscillator> hashMap6 = motionController.lookAheadTest;
            ViewOscillator viewOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
            HashMap<String, ViewOscillator> hashMap7 = motionController.lookAheadTest;
            ViewOscillator viewOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
            HashMap<String, ViewOscillator> hashMap8 = motionController.lookAheadTest;
            ViewOscillator viewOscillator3 = hashMap8 == null ? null : hashMap8.get("rotation");
            HashMap<String, ViewOscillator> hashMap9 = motionController.lookAheadTest;
            ViewOscillator viewOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
            HashMap<String, ViewOscillator> hashMap10 = motionController.lookAheadTest;
            ViewOscillator viewOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
            VelocityMatrix velocityMatrix = new VelocityMatrix();
            velocityMatrix.BuiltInFictitiousFunctionClassFactory = 0.0f;
            velocityMatrix.getAuthRequestContext = 0.0f;
            velocityMatrix.MyBillsEntityDataFactory = 0.0f;
            velocityMatrix.PlaceComponentResult = 0.0f;
            velocityMatrix.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
            if (viewSpline3 != null) {
                velocityMatrix.BuiltInFictitiousFunctionClassFactory = viewSpline3.MyBillsEntityDataFactory(authRequestContext);
                velocityMatrix.lookAheadTest = viewSpline3.PlaceComponentResult(authRequestContext);
            }
            if (viewSpline != null) {
                velocityMatrix.MyBillsEntityDataFactory = viewSpline.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewSpline2 != null) {
                velocityMatrix.getAuthRequestContext = viewSpline2.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewSpline4 != null) {
                velocityMatrix.KClassImpl$Data$declaredNonStaticMembers$2 = viewSpline4.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewSpline5 != null) {
                velocityMatrix.PlaceComponentResult = viewSpline5.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewOscillator3 != null) {
                velocityMatrix.BuiltInFictitiousFunctionClassFactory = viewOscillator3.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewOscillator != null) {
                velocityMatrix.MyBillsEntityDataFactory = viewOscillator.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewOscillator2 != null) {
                velocityMatrix.getAuthRequestContext = viewOscillator2.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewOscillator4 != null) {
                velocityMatrix.KClassImpl$Data$declaredNonStaticMembers$2 = viewOscillator4.MyBillsEntityDataFactory(authRequestContext);
            }
            if (viewOscillator5 != null) {
                velocityMatrix.PlaceComponentResult = viewOscillator5.MyBillsEntityDataFactory(authRequestContext);
            }
            CurveFit curveFit = motionController.getAuthRequestContext;
            if (curveFit != null) {
                double[] dArr2 = motionController.initRecordTimeStamp;
                if (dArr2.length > 0) {
                    double d = authRequestContext;
                    curveFit.getAuthRequestContext(d, dArr2);
                    motionController.getAuthRequestContext.PlaceComponentResult(d, motionController.GetContactSyncConfig);
                    MotionPaths motionPaths = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(f, f2, fArr, motionController.NetworkUserEntityData$$ExternalSyntheticLambda2, motionController.GetContactSyncConfig, motionController.initRecordTimeStamp);
                }
                velocityMatrix.MyBillsEntityDataFactory(f, f2, width, height, fArr);
                fArr2 = fArr;
            } else {
                if (motionController.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
                    double authRequestContext2 = motionController.getAuthRequestContext(authRequestContext, motionController.readMicros);
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda7[0].PlaceComponentResult(authRequestContext2, motionController.GetContactSyncConfig);
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda7[0].getAuthRequestContext(authRequestContext2, motionController.initRecordTimeStamp);
                    float f7 = motionController.readMicros[0];
                    int i4 = 0;
                    while (true) {
                        dArr = motionController.GetContactSyncConfig;
                        if (i4 >= dArr.length) {
                            break;
                        }
                        double d2 = dArr[i4];
                        double d3 = f7;
                        Double.isNaN(d3);
                        dArr[i4] = d2 * d3;
                        i4++;
                    }
                    MotionPaths motionPaths2 = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(f, f2, fArr, motionController.NetworkUserEntityData$$ExternalSyntheticLambda2, dArr, motionController.initRecordTimeStamp);
                    fArr2 = fArr;
                    i3 = width;
                    i2 = height;
                } else {
                    i2 = height;
                    float f8 = motionController.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7 - motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    i3 = width;
                    float f9 = motionController.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8 - motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    float f10 = motionController.moveToNextValue.newProxyInstance;
                    ViewOscillator viewOscillator6 = viewOscillator5;
                    float f11 = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.newProxyInstance;
                    ViewOscillator viewOscillator7 = viewOscillator4;
                    float f12 = motionController.moveToNextValue.PlaceComponentResult;
                    float f13 = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult;
                    ViewOscillator viewOscillator8 = viewOscillator;
                    ViewOscillator viewOscillator9 = viewOscillator2;
                    float f14 = ((1.0f - f) * f8) + (((f10 - f11) + f8) * f);
                    fArr2 = fArr;
                    fArr2[0] = f14;
                    fArr2[1] = ((1.0f - f2) * f9) + (((f12 - f13) + f9) * f2);
                    velocityMatrix.BuiltInFictitiousFunctionClassFactory = 0.0f;
                    velocityMatrix.getAuthRequestContext = 0.0f;
                    velocityMatrix.MyBillsEntityDataFactory = 0.0f;
                    velocityMatrix.PlaceComponentResult = 0.0f;
                    velocityMatrix.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
                    if (viewSpline3 != null) {
                        velocityMatrix.BuiltInFictitiousFunctionClassFactory = viewSpline3.MyBillsEntityDataFactory(authRequestContext);
                        velocityMatrix.lookAheadTest = viewSpline3.PlaceComponentResult(authRequestContext);
                    }
                    if (viewSpline != null) {
                        velocityMatrix.MyBillsEntityDataFactory = viewSpline.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewSpline2 != null) {
                        velocityMatrix.getAuthRequestContext = viewSpline2.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewSpline4 != null) {
                        velocityMatrix.KClassImpl$Data$declaredNonStaticMembers$2 = viewSpline4.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewSpline5 != null) {
                        velocityMatrix.PlaceComponentResult = viewSpline5.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewOscillator3 != null) {
                        velocityMatrix.BuiltInFictitiousFunctionClassFactory = viewOscillator3.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewOscillator8 != null) {
                        velocityMatrix.MyBillsEntityDataFactory = viewOscillator8.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewOscillator9 != null) {
                        velocityMatrix.getAuthRequestContext = viewOscillator9.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewOscillator7 != null) {
                        velocityMatrix.KClassImpl$Data$declaredNonStaticMembers$2 = viewOscillator7.MyBillsEntityDataFactory(authRequestContext);
                    }
                    if (viewOscillator6 != null) {
                        velocityMatrix.PlaceComponentResult = viewOscillator6.MyBillsEntityDataFactory(authRequestContext);
                    }
                }
                velocityMatrix.MyBillsEntityDataFactory(f, f2, i3, i2, fArr);
            }
        } else {
            fArr2 = fArr;
            f3 = f6;
            motionController.BuiltInFictitiousFunctionClassFactory(f5, f, f2, fArr2);
        }
        if (i < 2) {
            fArr2[0] = fArr2[0] * f3;
            fArr2[1] = fArr2[1] * f3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class Model {
        int getAuthRequestContext;
        int lookAheadTest;
        ConstraintWidgetContainer BuiltInFictitiousFunctionClassFactory = new ConstraintWidgetContainer();
        ConstraintWidgetContainer KClassImpl$Data$declaredNonStaticMembers$2 = new ConstraintWidgetContainer();
        ConstraintSet PlaceComponentResult = null;
        ConstraintSet MyBillsEntityDataFactory = null;

        Model() {
        }

        final void getAuthRequestContext(ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.PlaceComponentResult = constraintSet;
            this.MyBillsEntityDataFactory = constraintSet2;
            this.BuiltInFictitiousFunctionClassFactory = new ConstraintWidgetContainer();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ConstraintWidgetContainer();
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(MotionLayout.this.mLayoutWidget.BuiltInFictitiousFunctionClassFactory());
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(MotionLayout.this.mLayoutWidget.BuiltInFictitiousFunctionClassFactory());
            this.BuiltInFictitiousFunctionClassFactory.getContainerAuth.clear();
            this.KClassImpl$Data$declaredNonStaticMembers$2.getContainerAuth.clear();
            MyBillsEntityDataFactory(MotionLayout.this.mLayoutWidget, this.BuiltInFictitiousFunctionClassFactory);
            MyBillsEntityDataFactory(MotionLayout.this.mLayoutWidget, this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (constraintSet != null) {
                    PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, constraintSet);
                }
                PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, constraintSet2);
            } else {
                PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, constraintSet2);
                if (constraintSet != null) {
                    PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, constraintSet);
                }
            }
            this.BuiltInFictitiousFunctionClassFactory.s = MotionLayout.this.isRtl();
            ConstraintWidgetContainer constraintWidgetContainer = this.BuiltInFictitiousFunctionClassFactory;
            constraintWidgetContainer.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer);
            this.KClassImpl$Data$declaredNonStaticMembers$2.s = MotionLayout.this.isRtl();
            ConstraintWidgetContainer constraintWidgetContainer2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            constraintWidgetContainer2.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer2);
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.BuiltInFictitiousFunctionClassFactory.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                if (layoutParams.height == -2) {
                    this.BuiltInFictitiousFunctionClassFactory.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
            }
        }

        private void PlaceComponentResult(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            ConstraintSet.Constraint constraint;
            ConstraintSet.Constraint constraint2;
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams();
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (constraintSet != null && constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.KClassImpl$Data$declaredNonStaticMembers$2, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getContainerAuth.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.DatabaseTableConfigUtil = true;
                sparseArray.put(((View) next.NetworkUserEntityData$$ExternalSyntheticLambda6).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getContainerAuth.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.NetworkUserEntityData$$ExternalSyntheticLambda6;
                int id2 = view.getId();
                if (constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(id2)) && (constraint2 = constraintSet.getAuthRequestContext.get(Integer.valueOf(id2))) != null) {
                    constraint2.PlaceComponentResult(layoutParams);
                }
                next2.getErrorConfigVersion(constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(view.getId()).BuiltInFictitiousFunctionClassFactory.O);
                next2.lookAheadTest(constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(view.getId()).BuiltInFictitiousFunctionClassFactory.G);
                if (view instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) view;
                    int id3 = constraintHelper.getId();
                    if (constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(id3)) && (constraint = constraintSet.getAuthRequestContext.get(Integer.valueOf(id3))) != null && (next2 instanceof HelperWidget)) {
                        constraintHelper.loadParameters(constraint, (HelperWidget) next2, layoutParams, sparseArray);
                    }
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    layoutParams.resolveLayoutDirection(0);
                }
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(view.getId()).scheduleImpl.PlaceComponentResult == 1) {
                    next2.h = view.getVisibility();
                } else {
                    next2.h = constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(view.getId()).scheduleImpl.MyBillsEntityDataFactory;
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getContainerAuth.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    ConstraintHelper constraintHelper2 = (ConstraintHelper) next3.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    Helper helper = (Helper) next3;
                    constraintHelper2.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    VirtualLayout virtualLayout = (VirtualLayout) helper;
                    for (int i = 0; i < virtualLayout.FlowableCreate$BufferAsyncEmitter; i++) {
                        ConstraintWidget constraintWidget = virtualLayout.z[i];
                        if (constraintWidget != null) {
                            constraintWidget.D = true;
                        }
                    }
                }
            }
        }

        public final void BuiltInFictitiousFunctionClassFactory() {
            BuiltInFictitiousFunctionClassFactory(MotionLayout.this.FragmentBottomSheetPaymentSettingBinding, MotionLayout.this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            MotionLayout.access$1400(MotionLayout.this);
        }

        private void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout.this.mWidthMeasureMode = mode;
            MotionLayout.this.mHeightMeasureMode = mode2;
            MotionLayout.this.getOptimizationLevel();
            MyBillsEntityDataFactory(i, i2);
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MyBillsEntityDataFactory(i, i2);
                MotionLayout motionLayout = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.BuiltInFictitiousFunctionClassFactory;
                motionLayout.mStartWrapWidth = constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2;
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer2 = this.BuiltInFictitiousFunctionClassFactory;
                motionLayout2.mStartWrapHeight = constraintWidgetContainer2.h == 8 ? 0 : constraintWidgetContainer2.C;
                MotionLayout motionLayout3 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                motionLayout3.mEndWrapWidth = constraintWidgetContainer3.h == 8 ? 0 : constraintWidgetContainer3.FlowViewUtil$textChanges$2;
                MotionLayout motionLayout4 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                motionLayout4.mEndWrapHeight = constraintWidgetContainer4.h == 8 ? 0 : constraintWidgetContainer4.C;
                MotionLayout motionLayout5 = MotionLayout.this;
                motionLayout5.mMeasureDuringTransition = (motionLayout5.mStartWrapWidth == MotionLayout.this.mEndWrapWidth && MotionLayout.this.mStartWrapHeight == MotionLayout.this.mEndWrapHeight) ? false : true;
            }
            int i3 = MotionLayout.this.mStartWrapWidth;
            int i4 = MotionLayout.this.mStartWrapHeight;
            if (MotionLayout.this.mWidthMeasureMode == Integer.MIN_VALUE || MotionLayout.this.mWidthMeasureMode == 0) {
                i3 = (int) (MotionLayout.this.mStartWrapWidth + (MotionLayout.this.mPostInterpolationPosition * (MotionLayout.this.mEndWrapWidth - MotionLayout.this.mStartWrapWidth)));
            }
            int i5 = i3;
            if (MotionLayout.this.mHeightMeasureMode == Integer.MIN_VALUE || MotionLayout.this.mHeightMeasureMode == 0) {
                i4 = (int) (MotionLayout.this.mStartWrapHeight + (MotionLayout.this.mPostInterpolationPosition * (MotionLayout.this.mEndWrapHeight - MotionLayout.this.mStartWrapHeight)));
            }
            MotionLayout.this.resolveMeasuredDimension(i, i2, i5, i4, this.BuiltInFictitiousFunctionClassFactory.A() || this.KClassImpl$Data$declaredNonStaticMembers$2.A(), this.BuiltInFictitiousFunctionClassFactory.lookAheadTest() || this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest());
        }

        private void MyBillsEntityDataFactory(int i, int i2) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            if (MotionLayout.this.mCurrentState == MotionLayout.this.getStartState()) {
                MotionLayout motionLayout = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                ConstraintSet constraintSet = this.MyBillsEntityDataFactory;
                int i3 = (constraintSet == null || constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 == 0) ? i : i2;
                ConstraintSet constraintSet2 = this.MyBillsEntityDataFactory;
                motionLayout.resolveSystem(constraintWidgetContainer, optimizationLevel, i3, (constraintSet2 == null || constraintSet2.KClassImpl$Data$declaredNonStaticMembers$2 == 0) ? i2 : i);
                ConstraintSet constraintSet3 = this.PlaceComponentResult;
                if (constraintSet3 != null) {
                    MotionLayout motionLayout2 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.BuiltInFictitiousFunctionClassFactory;
                    int i4 = constraintSet3.KClassImpl$Data$declaredNonStaticMembers$2 == 0 ? i : i2;
                    if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                        i = i2;
                    }
                    motionLayout2.resolveSystem(constraintWidgetContainer2, optimizationLevel, i4, i);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet4 = this.PlaceComponentResult;
            if (constraintSet4 != null) {
                MotionLayout.this.resolveSystem(this.BuiltInFictitiousFunctionClassFactory, optimizationLevel, constraintSet4.KClassImpl$Data$declaredNonStaticMembers$2 == 0 ? i : i2, this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 == 0 ? i2 : i);
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            ConstraintSet constraintSet5 = this.MyBillsEntityDataFactory;
            int i5 = (constraintSet5 == null || constraintSet5.KClassImpl$Data$declaredNonStaticMembers$2 == 0) ? i : i2;
            ConstraintSet constraintSet6 = this.MyBillsEntityDataFactory;
            if (constraintSet6 == null || constraintSet6.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                i = i2;
            }
            motionLayout3.resolveSystem(constraintWidgetContainer3, optimizationLevel, i5, i);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x013e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void getAuthRequestContext() {
            /*
                Method dump skipped, instructions count: 372
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.getAuthRequestContext():void");
        }

        public final boolean getAuthRequestContext(int i, int i2) {
            return (i == this.lookAheadTest && i2 == this.getAuthRequestContext) ? false : true;
        }

        private static void MyBillsEntityDataFactory(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.getContainerAuth;
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getContainerAuth.clear();
            constraintWidgetContainer2.getAuthRequestContext(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = arrayList.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof androidx.constraintlayout.core.widgets.Barrier) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof Placeholder) {
                    constraintWidget = new Placeholder();
                } else if (next instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                hashMap.get(next2).getAuthRequestContext(next2, hashMap);
            }
        }

        private static ConstraintWidget KClassImpl$Data$declaredNonStaticMembers$2(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.NetworkUserEntityData$$ExternalSyntheticLambda6 == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.getContainerAuth;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = arrayList.get(i);
                if (constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda6 == view) {
                    return constraintWidget;
                }
            }
            return null;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (motionScene = this.mScene) != null && motionScene.getAuthRequestContext != null) {
            int i = this.mScene.getAuthRequestContext.getErrorConfigVersion;
            if (i == 0) {
                return;
            }
            if (i == 2) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    this.mFrameArrayList.get(getChildAt(i2)).NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
                return;
            }
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(Debug.MyBillsEntityDataFactory(context, this.scheduleImpl));
        sb.append("->");
        sb.append(Debug.MyBillsEntityDataFactory(context, this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        sb.append(" (pos:");
        sb.append(this.mTransitionLastPosition);
        sb.append(" Dpos/Dt:");
        sb.append(this.mLastVelocity);
        return sb.toString();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        if (this.mScene == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z2 = true;
        boolean z3 = (this.FragmentBottomSheetPaymentSettingBinding == i && this.NetworkUserEntityData$$ExternalSyntheticLambda5 == i2) ? false : true;
        if (this.readMicros) {
            this.readMicros = false;
            onNewStateAttachHandlers();
            PlaceComponentResult();
            z3 = true;
        }
        if (this.mDirtyHierarchy) {
            z3 = true;
        }
        this.FragmentBottomSheetPaymentSettingBinding = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = i2;
        MotionScene.Transition transition = this.mScene.getAuthRequestContext;
        int PlaceComponentResult = transition == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition);
        MotionScene.Transition transition2 = this.mScene.getAuthRequestContext;
        int MyBillsEntityDataFactory = transition2 == null ? -1 : MotionScene.Transition.MyBillsEntityDataFactory(transition2);
        if ((z3 || this.mModel.getAuthRequestContext(PlaceComponentResult, MyBillsEntityDataFactory)) && this.scheduleImpl != -1) {
            super.onMeasure(i, i2);
            Model model = this.mModel;
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            model.getAuthRequestContext(this.mScene.getAuthRequestContext(PlaceComponentResult), this.mScene.getAuthRequestContext(MyBillsEntityDataFactory));
            this.mModel.BuiltInFictitiousFunctionClassFactory();
            Model model2 = this.mModel;
            model2.lookAheadTest = PlaceComponentResult;
            model2.getAuthRequestContext = MyBillsEntityDataFactory;
            z = false;
        } else {
            if (z3) {
                super.onMeasure(i, i2);
            }
            z = true;
        }
        if (this.mMeasureDuringTransition || z) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
            int i3 = (constraintWidgetContainer2.h == 8 ? 0 : constraintWidgetContainer2.FlowViewUtil$textChanges$2) + paddingLeft + paddingRight;
            ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutWidget;
            int i4 = (constraintWidgetContainer3.h == 8 ? 0 : constraintWidgetContainer3.C) + paddingTop + paddingBottom;
            int i5 = this.mWidthMeasureMode;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                i3 = (int) (this.mStartWrapWidth + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r1)));
                requestLayout();
            }
            int i6 = this.mHeightMeasureMode;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                i4 = (int) (this.mStartWrapHeight + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r1)));
                requestLayout();
            }
            setMeasuredDimension(i3, i4);
        }
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        float f = this.mTransitionLastPosition + (!(interpolator instanceof StopLogic) ? ((((float) (nanoTime - this.VerifyPinStateManager$executeRiskChallenge$2$2)) * signum) * 1.0E-9f) / this.getValueOfTouchPositionAbsolute : 0.0f);
        if (this.getOnBoardingScenario) {
            f = this.mTransitionGoalPosition;
        }
        if ((signum <= 0.0f || f < this.mTransitionGoalPosition) && (signum > 0.0f || f > this.mTransitionGoalPosition)) {
            z2 = false;
        } else {
            f = this.mTransitionGoalPosition;
        }
        if (interpolator != null && !z2) {
            if (this.D) {
                f = interpolator.getInterpolation(((float) (nanoTime - this.BuiltInFictitiousFunctionClassFactory)) * 1.0E-9f);
            } else {
                f = interpolator.getInterpolation(f);
            }
        }
        if ((signum > 0.0f && f >= this.mTransitionGoalPosition) || (signum <= 0.0f && f <= this.mTransitionGoalPosition)) {
            f = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.mProgressInterpolator;
        if (interpolator2 != null) {
            f = interpolator2.getInterpolation(f);
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.BuiltInFictitiousFunctionClassFactory(childAt, f, nanoTime2, this.PrepareContext);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        MotionScene motionScene = this.mScene;
        return (motionScene == null || motionScene.getAuthRequestContext == null || this.mScene.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 == null || (this.mScene.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0 & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f = this.mScrollTargetDT;
            if (f != 0.0f) {
                float f2 = this.mScrollTargetDX / f;
                float f3 = this.mScrollTargetDY / f;
                MotionScene.Transition transition = motionScene.getAuthRequestContext;
                if (transition == null || MotionScene.Transition.scheduleImpl(transition) == null) {
                    return;
                }
                TouchResponse scheduleImpl = MotionScene.Transition.scheduleImpl(motionScene.getAuthRequestContext);
                scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                float progress = scheduleImpl.GetContactSyncConfig.getProgress();
                scheduleImpl.GetContactSyncConfig.getAnchorDpDt(scheduleImpl.FragmentBottomSheetPaymentSettingBinding, progress, scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda3, scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5, scheduleImpl.MyBillsEntityDataFactory);
                float f4 = scheduleImpl.readMicros;
                float[] fArr = scheduleImpl.MyBillsEntityDataFactory;
                float f5 = f4 != 0.0f ? (f2 * f4) / fArr[0] : (f3 * scheduleImpl.getSupportButtonTintMode) / fArr[1];
                if (!Float.isNaN(f5)) {
                    progress += f5 / 3.0f;
                }
                if (progress != 0.0f) {
                    boolean z = progress != 1.0f;
                    int i2 = scheduleImpl.DatabaseTableConfigUtil;
                    if ((i2 != 3) && z) {
                        scheduleImpl.GetContactSyncConfig.touchAnimateTo(i2, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f5);
                    }
                }
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.mUndergoingMotion || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.mUndergoingMotion = false;
    }

    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View view, int i, int i2, int[] iArr, int i3) {
        MotionScene.Transition transition;
        ?? r1;
        float f;
        float f2;
        TouchResponse touchResponse;
        int i4;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.getAuthRequestContext) == null || !transition.BuiltInFictitiousFunctionClassFactory()) {
            return;
        }
        int i5 = -1;
        if (!transition.BuiltInFictitiousFunctionClassFactory() || (touchResponse = transition.NetworkUserEntityData$$ExternalSyntheticLambda2) == null || (i4 = touchResponse.SubSequence) == -1 || view.getId() == i4) {
            if (motionScene.MyBillsEntityDataFactory()) {
                TouchResponse touchResponse2 = transition.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (touchResponse2 != null && (touchResponse2.NetworkUserEntityData$$ExternalSyntheticLambda0 & 4) != 0) {
                    i5 = i2;
                }
                float f3 = this.mTransitionPosition;
                if ((f3 == 1.0f || f3 == 0.0f) && view.canScrollVertically(i5)) {
                    return;
                }
            }
            if (transition.NetworkUserEntityData$$ExternalSyntheticLambda2 != null && (transition.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0 & 1) != 0) {
                float f4 = i;
                float f5 = i2;
                MotionScene.Transition transition2 = motionScene.getAuthRequestContext;
                if (transition2 == null || MotionScene.Transition.scheduleImpl(transition2) == null) {
                    f2 = 0.0f;
                } else {
                    TouchResponse scheduleImpl = MotionScene.Transition.scheduleImpl(motionScene.getAuthRequestContext);
                    scheduleImpl.GetContactSyncConfig.getAnchorDpDt(scheduleImpl.FragmentBottomSheetPaymentSettingBinding, scheduleImpl.GetContactSyncConfig.getProgress(), scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda3, scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5, scheduleImpl.MyBillsEntityDataFactory);
                    float f6 = scheduleImpl.readMicros;
                    if (f6 != 0.0f) {
                        float[] fArr = scheduleImpl.MyBillsEntityDataFactory;
                        if (fArr[0] == 0.0f) {
                            fArr[0] = 1.0E-7f;
                        }
                        f2 = (f4 * f6) / fArr[0];
                    } else {
                        float[] fArr2 = scheduleImpl.MyBillsEntityDataFactory;
                        if (fArr2[1] == 0.0f) {
                            fArr2[1] = 1.0E-7f;
                        }
                        f2 = (f5 * scheduleImpl.getSupportButtonTintMode) / fArr2[1];
                    }
                }
                float f7 = this.mTransitionLastPosition;
                if ((f7 <= 0.0f && f2 < 0.0f) || (f7 >= 1.0f && f2 > 0.0f)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                            @Override // java.lang.Runnable
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            float f8 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f9 = i;
            this.mScrollTargetDX = f9;
            float f10 = i2;
            this.mScrollTargetDY = f10;
            double d = nanoTime - this.mScrollTargetTime;
            Double.isNaN(d);
            this.mScrollTargetDT = (float) (d * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            MotionScene.Transition transition3 = motionScene.getAuthRequestContext;
            if (transition3 != null && MotionScene.Transition.scheduleImpl(transition3) != null) {
                TouchResponse scheduleImpl2 = MotionScene.Transition.scheduleImpl(motionScene.getAuthRequestContext);
                float progress = scheduleImpl2.GetContactSyncConfig.getProgress();
                if (!scheduleImpl2.KClassImpl$Data$declaredNonStaticMembers$2) {
                    scheduleImpl2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    scheduleImpl2.GetContactSyncConfig.setProgress(progress);
                }
                scheduleImpl2.GetContactSyncConfig.getAnchorDpDt(scheduleImpl2.FragmentBottomSheetPaymentSettingBinding, progress, scheduleImpl2.NetworkUserEntityData$$ExternalSyntheticLambda3, scheduleImpl2.NetworkUserEntityData$$ExternalSyntheticLambda5, scheduleImpl2.MyBillsEntityDataFactory);
                float f11 = scheduleImpl2.readMicros;
                float[] fArr3 = scheduleImpl2.MyBillsEntityDataFactory;
                if (Math.abs((f11 * fArr3[0]) + (scheduleImpl2.getSupportButtonTintMode * fArr3[1])) < 0.01d) {
                    float[] fArr4 = scheduleImpl2.MyBillsEntityDataFactory;
                    fArr4[0] = 0.01f;
                    fArr4[1] = 0.01f;
                }
                float f12 = scheduleImpl2.readMicros;
                if (f12 != 0.0f) {
                    f = (f9 * f12) / scheduleImpl2.MyBillsEntityDataFactory[0];
                } else {
                    f = (f10 * scheduleImpl2.getSupportButtonTintMode) / scheduleImpl2.MyBillsEntityDataFactory[1];
                }
                float max = Math.max(Math.min(progress + f, 1.0f), 0.0f);
                if (max != scheduleImpl2.GetContactSyncConfig.getProgress()) {
                    scheduleImpl2.GetContactSyncConfig.setProgress(max);
                }
            }
            if (f8 != this.mTransitionPosition) {
                iArr[0] = i;
                r1 = 1;
                iArr[1] = i2;
            } else {
                r1 = 1;
            }
            evaluate(false);
            if (iArr[0] == 0 && iArr[r1] == 0) {
                return;
            }
            this.mUndergoingMotion = r1;
        }
    }

    /* loaded from: classes3.dex */
    class DevModeDraw {
        Paint DatabaseTableConfigUtil;
        Path GetContactSyncConfig;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda0;
        int[] NetworkUserEntityData$$ExternalSyntheticLambda1;
        Paint NetworkUserEntityData$$ExternalSyntheticLambda2;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda7;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda8;
        int PrepareContext;
        Paint initRecordTimeStamp;
        Paint isLayoutRequested;
        DashPathEffect lookAheadTest;
        int moveToNextValue;
        Paint scheduleImpl;
        final int getAuthRequestContext = -21965;
        final int PlaceComponentResult = -2067046;
        final int KClassImpl$Data$declaredNonStaticMembers$2 = -13391360;
        final int MyBillsEntityDataFactory = 1996488704;
        final int BuiltInFictitiousFunctionClassFactory = 10;
        Rect getErrorConfigVersion = new Rect();
        boolean newProxyInstance = false;

        public DevModeDraw() {
            this.PrepareContext = 1;
            Paint paint = new Paint();
            this.initRecordTimeStamp = paint;
            paint.setAntiAlias(true);
            this.initRecordTimeStamp.setColor(-21965);
            this.initRecordTimeStamp.setStrokeWidth(2.0f);
            this.initRecordTimeStamp.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = paint2;
            paint2.setAntiAlias(true);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(-2067046);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setStrokeWidth(2.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.DatabaseTableConfigUtil = paint3;
            paint3.setAntiAlias(true);
            this.DatabaseTableConfigUtil.setColor(-13391360);
            this.DatabaseTableConfigUtil.setStrokeWidth(2.0f);
            this.DatabaseTableConfigUtil.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.isLayoutRequested = paint4;
            paint4.setAntiAlias(true);
            this.isLayoutRequested.setColor(-13391360);
            this.isLayoutRequested.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[8];
            Paint paint5 = new Paint();
            this.scheduleImpl = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.lookAheadTest = dashPathEffect;
            this.DatabaseTableConfigUtil.setPathEffect(dashPathEffect);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[100];
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new int[50];
            if (this.newProxyInstance) {
                this.initRecordTimeStamp.setStrokeWidth(8.0f);
                this.scheduleImpl.setStrokeWidth(8.0f);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.setStrokeWidth(8.0f);
                this.PrepareContext = 4;
            }
        }

        public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas, int i, int i2, MotionController motionController) {
            if (i == 4) {
                KClassImpl$Data$declaredNonStaticMembers$2(canvas);
            }
            if (i == 2) {
                MyBillsEntityDataFactory(canvas);
            }
            if (i == 3) {
                getAuthRequestContext(canvas);
            }
            canvas.drawLines(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.initRecordTimeStamp);
            PlaceComponentResult(canvas, i, i2, motionController);
        }

        private void PlaceComponentResult(Canvas canvas, int i, int i2, MotionController motionController) {
            int i3;
            int i4;
            float f;
            float f2;
            if (motionController.getSupportButtonTintMode != null) {
                i3 = motionController.getSupportButtonTintMode.getWidth();
                i4 = motionController.getSupportButtonTintMode.getHeight();
            } else {
                i3 = 0;
                i4 = 0;
            }
            for (int i5 = 1; i5 < i2 - 1; i5++) {
                if (i != 4 || this.NetworkUserEntityData$$ExternalSyntheticLambda1[i5 - 1] != 0) {
                    float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    int i6 = i5 * 2;
                    float f3 = fArr[i6];
                    float f4 = fArr[i6 + 1];
                    this.GetContactSyncConfig.reset();
                    this.GetContactSyncConfig.moveTo(f3, f4 + 10.0f);
                    this.GetContactSyncConfig.lineTo(f3 + 10.0f, f4);
                    this.GetContactSyncConfig.lineTo(f3, f4 - 10.0f);
                    this.GetContactSyncConfig.lineTo(f3 - 10.0f, f4);
                    this.GetContactSyncConfig.close();
                    int i7 = i5 - 1;
                    motionController.newProxyInstance.get(i7);
                    if (i == 4) {
                        int i8 = this.NetworkUserEntityData$$ExternalSyntheticLambda1[i7];
                        if (i8 == 1) {
                            MyBillsEntityDataFactory(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (i8 == 0) {
                            KClassImpl$Data$declaredNonStaticMembers$2(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (i8 == 2) {
                            f = f4;
                            f2 = f3;
                            KClassImpl$Data$declaredNonStaticMembers$2(canvas, f3 - 0.0f, f4 - 0.0f, i3, i4);
                            canvas.drawPath(this.GetContactSyncConfig, this.scheduleImpl);
                        }
                        f = f4;
                        f2 = f3;
                        canvas.drawPath(this.GetContactSyncConfig, this.scheduleImpl);
                    } else {
                        f = f4;
                        f2 = f3;
                    }
                    if (i == 2) {
                        MyBillsEntityDataFactory(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 3) {
                        KClassImpl$Data$declaredNonStaticMembers$2(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 6) {
                        KClassImpl$Data$declaredNonStaticMembers$2(canvas, f2 - 0.0f, f - 0.0f, i3, i4);
                    }
                    canvas.drawPath(this.GetContactSyncConfig, this.scheduleImpl);
                }
            }
            float[] fArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                float[] fArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
        }

        private void MyBillsEntityDataFactory(Canvas canvas) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.DatabaseTableConfigUtil);
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.moveToNextValue; i++) {
                int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1[i];
                if (i2 == 1) {
                    z = true;
                }
                if (i2 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                MyBillsEntityDataFactory(canvas);
            }
            if (z2) {
                getAuthRequestContext(canvas);
            }
        }

        private void MyBillsEntityDataFactory(Canvas canvas, float f, float f2) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            StringBuilder sb = new StringBuilder();
            sb.append(((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            String obj = sb.toString();
            this.isLayoutRequested.getTextBounds(obj, 0, obj.length(), this.getErrorConfigVersion);
            canvas.drawTextOnPath(obj, path, (hypot2 / 2.0f) - (this.getErrorConfigVersion.width() / 2), -20.0f, this.isLayoutRequested);
            canvas.drawLine(f, f2, f10, f11, this.DatabaseTableConfigUtil);
        }

        private void getAuthRequestContext(Canvas canvas) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.DatabaseTableConfigUtil);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.DatabaseTableConfigUtil);
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, float f, float f2) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            StringBuilder sb = new StringBuilder();
            Double.isNaN((min2 * 100.0f) / Math.abs(f5 - f3));
            sb.append(((int) (r14 + 0.5d)) / 100.0f);
            String obj = sb.toString();
            this.isLayoutRequested.getTextBounds(obj, 0, obj.length(), this.getErrorConfigVersion);
            canvas.drawText(obj, ((min2 / 2.0f) - (this.getErrorConfigVersion.width() / 2)) + min, f2 - 20.0f, this.isLayoutRequested);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.DatabaseTableConfigUtil);
            StringBuilder sb2 = new StringBuilder();
            Double.isNaN((max2 * 100.0f) / Math.abs(f6 - f4));
            sb2.append(((int) (r2 + 0.5d)) / 100.0f);
            String obj2 = sb2.toString();
            this.isLayoutRequested.getTextBounds(obj2, 0, obj2.length(), this.getErrorConfigVersion);
            canvas.drawText(obj2, f + 5.0f, max - ((max2 / 2.0f) - (this.getErrorConfigVersion.height() / 2)), this.isLayoutRequested);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.DatabaseTableConfigUtil);
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, float f, float f2, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            Double.isNaN(((f - (i / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i));
            sb.append(((int) (r2 + 0.5d)) / 100.0f);
            String obj = sb.toString();
            this.isLayoutRequested.getTextBounds(obj, 0, obj.length(), this.getErrorConfigVersion);
            canvas.drawText(obj, ((f / 2.0f) - (this.getErrorConfigVersion.width() / 2)) + 0.0f, f2 - 20.0f, this.isLayoutRequested);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.DatabaseTableConfigUtil);
            StringBuilder sb2 = new StringBuilder();
            Double.isNaN(((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i2));
            sb2.append(((int) (r2 + 0.5d)) / 100.0f);
            String obj2 = sb2.toString();
            this.isLayoutRequested.getTextBounds(obj2, 0, obj2.length(), this.getErrorConfigVersion);
            canvas.drawText(obj2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.getErrorConfigVersion.height() / 2)), this.isLayoutRequested);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.DatabaseTableConfigUtil);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x058a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109  */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dispatchDraw(android.graphics.Canvas r30) {
        /*
            Method dump skipped, instructions count: 1419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endTrigger(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i));
            if (motionController != null && ApiDowngradeConstant.JsonKeys.BUTTON.equals(Debug.MyBillsEntityDataFactory(motionController.getSupportButtonTintMode)) && motionController.DatabaseTableConfigUtil != null) {
                int i2 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = motionController.DatabaseTableConfigUtil;
                    if (i2 < keyTriggerArr.length) {
                        keyTriggerArr[i2].BuiltInFictitiousFunctionClassFactory(z ? -100.0f : 100.0f, motionController.getSupportButtonTintMode);
                        i2++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void evaluate(boolean r22) {
        /*
            Method dump skipped, instructions count: 637
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.evaluate(boolean):void");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.mLastLayoutWidth != i5 || this.mLastLayoutHeight != i6) {
                rebuildScene();
                evaluate(true);
            }
            this.mLastLayoutWidth = i5;
            this.mLastLayoutHeight = i6;
            this.mOldWidth = i5;
            this.mOldHeight = i6;
        } finally {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet) {
        MotionScene motionScene;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.NearbyPlaceEntityRepository$$ExternalSyntheticLambda0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.CustomPopMenuExtension) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.getPaymentSuccess) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.access$setServices$p) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R.styleable.UCropFragment) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == R.styleable.SafeKeyGenerator$PoolableDigestContainer) {
                    if (this.mDebugPath == 0) {
                        this.mDebugPath = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.NearbyPlaceEntityRepository$$ExternalSyntheticLambda2) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.mScene == null) {
                InstrumentInjector.log_e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            getAuthRequestContext();
        }
        if (this.mCurrentState != -1 || (motionScene = this.mScene) == null) {
            return;
        }
        MotionScene.Transition transition = motionScene.getAuthRequestContext;
        this.mCurrentState = transition == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition);
        MotionScene.Transition transition2 = this.mScene.getAuthRequestContext;
        this.scheduleImpl = transition2 == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition2);
        MotionScene.Transition transition3 = this.mScene.getAuthRequestContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = transition3 != null ? MotionScene.Transition.MyBillsEntityDataFactory(transition3) : -1;
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.PlaceComponentResult(isRtl());
        rebuildScene();
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    private void getAuthRequestContext() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            InstrumentInjector.log_e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        MotionScene.Transition transition = motionScene.getAuthRequestContext;
        int PlaceComponentResult = transition == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition);
        MotionScene motionScene2 = this.mScene;
        MotionScene.Transition transition2 = motionScene2.getAuthRequestContext;
        ConstraintSet authRequestContext = motionScene2.getAuthRequestContext(transition2 == null ? -1 : MotionScene.Transition.PlaceComponentResult(transition2));
        String MyBillsEntityDataFactory = Debug.MyBillsEntityDataFactory(getContext(), PlaceComponentResult);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id2 = childAt.getId();
            if (id2 == -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("CHECK: ");
                sb.append(MyBillsEntityDataFactory);
                sb.append(" ALL VIEWS SHOULD HAVE ID's ");
                sb.append(childAt.getClass().getName());
                sb.append(" does not!");
                InstrumentInjector.log_w(TAG, sb.toString());
            }
            if ((authRequestContext.getAuthRequestContext.containsKey(Integer.valueOf(id2)) ? authRequestContext.getAuthRequestContext.get(Integer.valueOf(id2)) : null) == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CHECK: ");
                sb2.append(MyBillsEntityDataFactory);
                sb2.append(" NO CONSTRAINTS for ");
                sb2.append(Debug.MyBillsEntityDataFactory(childAt));
                InstrumentInjector.log_w(TAG, sb2.toString());
            }
        }
        Integer[] numArr = (Integer[]) authRequestContext.getAuthRequestContext.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            String MyBillsEntityDataFactory2 = Debug.MyBillsEntityDataFactory(getContext(), i4);
            if (findViewById(iArr[i3]) == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CHECK: ");
                sb3.append(MyBillsEntityDataFactory);
                sb3.append(" NO View matches id ");
                sb3.append(MyBillsEntityDataFactory2);
                InstrumentInjector.log_w(TAG, sb3.toString());
            }
            if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i4).BuiltInFictitiousFunctionClassFactory.G == -1) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("CHECK: ");
                sb4.append(MyBillsEntityDataFactory);
                sb4.append("(");
                sb4.append(MyBillsEntityDataFactory2);
                sb4.append(") no LAYOUT_HEIGHT");
                InstrumentInjector.log_w(TAG, sb4.toString());
            }
            if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i4).BuiltInFictitiousFunctionClassFactory.O == -1) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CHECK: ");
                sb5.append(MyBillsEntityDataFactory);
                sb5.append("(");
                sb5.append(MyBillsEntityDataFactory2);
                sb5.append(") no LAYOUT_HEIGHT");
                InstrumentInjector.log_w(TAG, sb5.toString());
            }
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it = this.mScene.GetContactSyncConfig.iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            if (next == this.mScene.getAuthRequestContext) {
                InstrumentInjector.log_v(TAG, "CHECK: CURRENT");
            }
            if (next.MyBillsEntityDataFactory == next.getAuthRequestContext) {
                InstrumentInjector.log_e(TAG, "CHECK: start and end constraint set should not be the same!");
            }
            int i5 = next.MyBillsEntityDataFactory;
            int i6 = next.getAuthRequestContext;
            String MyBillsEntityDataFactory3 = Debug.MyBillsEntityDataFactory(getContext(), i5);
            String MyBillsEntityDataFactory4 = Debug.MyBillsEntityDataFactory(getContext(), i6);
            if (sparseIntArray.get(i5) == i6) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("CHECK: two transitions with the same start and end ");
                sb6.append(MyBillsEntityDataFactory3);
                sb6.append("->");
                sb6.append(MyBillsEntityDataFactory4);
                InstrumentInjector.log_e(TAG, sb6.toString());
            }
            if (sparseIntArray2.get(i6) == i5) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("CHECK: you can't have reverse transitions");
                sb7.append(MyBillsEntityDataFactory3);
                sb7.append("->");
                sb7.append(MyBillsEntityDataFactory4);
                InstrumentInjector.log_e(TAG, sb7.toString());
            }
            sparseIntArray.put(i5, i6);
            sparseIntArray2.put(i6, i5);
            if (this.mScene.getAuthRequestContext(i5) == null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(" no such constraintSetStart ");
                sb8.append(MyBillsEntityDataFactory3);
                InstrumentInjector.log_e(TAG, sb8.toString());
            }
            if (this.mScene.getAuthRequestContext(i6) == null) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(" no such constraintSetEnd ");
                sb9.append(MyBillsEntityDataFactory3);
                InstrumentInjector.log_e(TAG, sb9.toString());
            }
        }
    }

    public void setDebugMode(int i) {
        this.mDebugPath = i;
        invalidate();
    }

    public void getDebugMode(boolean z) {
        this.mDebugPath = z ? 2 : 1;
        invalidate();
    }

    private boolean BuiltInFictitiousFunctionClassFactory(View view, MotionEvent motionEvent, float f, float f2) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f, f2);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f, -f2);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f, f2);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new Matrix();
        }
        matrix.invert(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        obtain.transform(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, View view, MotionEvent motionEvent) {
        boolean z;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (KClassImpl$Data$declaredNonStaticMembers$2((r3.getLeft() + f) - view.getScrollX(), (r3.getTop() + f2) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            this.lookAheadTest.set(f, f2, (view.getRight() + f) - view.getLeft(), (view.getBottom() + f2) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.lookAheadTest.contains(motionEvent.getX(), motionEvent.getY())) && BuiltInFictitiousFunctionClassFactory(view, motionEvent, -f, -f2)) {
                return true;
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponse;
        int i;
        RectF BuiltInFictitiousFunctionClassFactory;
        ViewTransition viewTransition;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.newProxyInstance) {
            if (motionScene.NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
                ViewTransitionController viewTransitionController = this.mScene.NetworkUserEntityData$$ExternalSyntheticLambda2;
                int currentState = viewTransitionController.getAuthRequestContext.getCurrentState();
                if (currentState != -1) {
                    if (viewTransitionController.BuiltInFictitiousFunctionClassFactory == null) {
                        viewTransitionController.BuiltInFictitiousFunctionClassFactory = new HashSet<>();
                        Iterator<ViewTransition> it = viewTransitionController.moveToNextValue.iterator();
                        while (it.hasNext()) {
                            ViewTransition next = it.next();
                            int childCount = viewTransitionController.getAuthRequestContext.getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = viewTransitionController.getAuthRequestContext.getChildAt(i2);
                                if (next.KClassImpl$Data$declaredNonStaticMembers$2(childAt)) {
                                    childAt.getId();
                                    viewTransitionController.BuiltInFictitiousFunctionClassFactory.add(childAt);
                                }
                            }
                        }
                    }
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    Rect rect = new Rect();
                    int action = motionEvent.getAction();
                    ArrayList<ViewTransition.Animate> arrayList = viewTransitionController.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        Iterator<ViewTransition.Animate> it2 = viewTransitionController.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                        while (it2.hasNext()) {
                            ViewTransition.Animate next2 = it2.next();
                            if (action != 1) {
                                if (action == 2) {
                                    next2.getErrorConfigVersion.getSupportButtonTintMode.getHitRect(next2.moveToNextValue);
                                    if (!next2.moveToNextValue.contains((int) x, (int) y) && !next2.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                                        next2.KClassImpl$Data$declaredNonStaticMembers$2();
                                    }
                                }
                            } else if (!next2.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                                next2.KClassImpl$Data$declaredNonStaticMembers$2();
                            }
                        }
                    }
                    if (action == 0 || action == 1) {
                        ConstraintSet constraintSet = viewTransitionController.getAuthRequestContext.getConstraintSet(currentState);
                        Iterator<ViewTransition> it3 = viewTransitionController.moveToNextValue.iterator();
                        while (it3.hasNext()) {
                            ViewTransition next3 = it3.next();
                            if (next3.KClassImpl$Data$declaredNonStaticMembers$2(action)) {
                                Iterator<View> it4 = viewTransitionController.BuiltInFictitiousFunctionClassFactory.iterator();
                                while (it4.hasNext()) {
                                    View next4 = it4.next();
                                    if (next3.KClassImpl$Data$declaredNonStaticMembers$2(next4)) {
                                        next4.getHitRect(rect);
                                        if (rect.contains((int) x, (int) y)) {
                                            viewTransition = next3;
                                            next3.KClassImpl$Data$declaredNonStaticMembers$2(viewTransitionController, viewTransitionController.getAuthRequestContext, currentState, constraintSet, next4);
                                        } else {
                                            viewTransition = next3;
                                        }
                                        next3 = viewTransition;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            MotionScene.Transition transition = this.mScene.getAuthRequestContext;
            if (transition != null && transition.BuiltInFictitiousFunctionClassFactory() && (touchResponse = transition.NetworkUserEntityData$$ExternalSyntheticLambda2) != null && ((motionEvent.getAction() != 0 || (BuiltInFictitiousFunctionClassFactory = touchResponse.BuiltInFictitiousFunctionClassFactory(this, new RectF())) == null || BuiltInFictitiousFunctionClassFactory.contains(motionEvent.getX(), motionEvent.getY())) && (i = touchResponse.SubSequence) != -1)) {
                View view = this.VerifyPinStateManager$executeRiskChallenge$2$1;
                if (view == null || view.getId() != i) {
                    this.VerifyPinStateManager$executeRiskChallenge$2$1 = findViewById(i);
                }
                if (this.VerifyPinStateManager$executeRiskChallenge$2$1 != null) {
                    this.lookAheadTest.set(r1.getLeft(), this.VerifyPinStateManager$executeRiskChallenge$2$1.getTop(), this.VerifyPinStateManager$executeRiskChallenge$2$1.getRight(), this.VerifyPinStateManager$executeRiskChallenge$2$1.getBottom());
                    if (this.lookAheadTest.contains(motionEvent.getX(), motionEvent.getY()) && !KClassImpl$Data$declaredNonStaticMembers$2(this.VerifyPinStateManager$executeRiskChallenge$2$1.getLeft(), this.VerifyPinStateManager$executeRiskChallenge$2$1.getTop(), this.VerifyPinStateManager$executeRiskChallenge$2$1, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.newProxyInstance && motionScene.PlaceComponentResult()) {
            MotionScene.Transition transition = this.mScene.getAuthRequestContext;
            if (transition != null && !transition.BuiltInFictitiousFunctionClassFactory()) {
                return super.onTouchEvent(motionEvent);
            }
            this.mScene.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent, getCurrentState(), this);
            if (this.mScene.getAuthRequestContext.getAuthRequestContext(4)) {
                return this.mScene.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i;
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            this.B = display.getRotation();
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (i = this.mCurrentState) != -1) {
            ConstraintSet authRequestContext = motionScene.getAuthRequestContext(i);
            this.mScene.PlaceComponentResult(this);
            ArrayList<MotionHelper> arrayList = this.moveToNextValue;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onFinishedMotionScene(this);
                }
            }
            if (authRequestContext != null) {
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
            this.scheduleImpl = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (stateCache != null) {
            if (this.getErrorConfigVersion) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.BottomSheetCardBindingView$watcherCardNumberView$1.BuiltInFictitiousFunctionClassFactory();
                    }
                });
                return;
            } else {
                stateCache.BuiltInFictitiousFunctionClassFactory();
                return;
            }
        }
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 == null || motionScene2.getAuthRequestContext == null || this.mScene.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 != 4) {
            return;
        }
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.PlaceComponentResult(isRtl());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNewStateAttachHandlers() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        View view;
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 == null) {
            return;
        }
        if (motionScene2.BuiltInFictitiousFunctionClassFactory(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i = this.mCurrentState;
        if (i != -1) {
            MotionScene motionScene3 = this.mScene;
            Iterator<MotionScene.Transition> it = motionScene3.GetContactSyncConfig.iterator();
            while (it.hasNext()) {
                MotionScene.Transition next = it.next();
                if (MotionScene.Transition.GetContactSyncConfig(next).size() > 0) {
                    Iterator it2 = MotionScene.Transition.GetContactSyncConfig(next).iterator();
                    while (it2.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it2.next()).BuiltInFictitiousFunctionClassFactory(this);
                    }
                }
            }
            Iterator<MotionScene.Transition> it3 = motionScene3.PlaceComponentResult.iterator();
            while (it3.hasNext()) {
                MotionScene.Transition next2 = it3.next();
                if (MotionScene.Transition.GetContactSyncConfig(next2).size() > 0) {
                    Iterator it4 = MotionScene.Transition.GetContactSyncConfig(next2).iterator();
                    while (it4.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it4.next()).BuiltInFictitiousFunctionClassFactory(this);
                    }
                }
            }
            Iterator<MotionScene.Transition> it5 = motionScene3.GetContactSyncConfig.iterator();
            while (it5.hasNext()) {
                MotionScene.Transition next3 = it5.next();
                if (MotionScene.Transition.GetContactSyncConfig(next3).size() > 0) {
                    Iterator it6 = MotionScene.Transition.GetContactSyncConfig(next3).iterator();
                    while (it6.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it6.next()).MyBillsEntityDataFactory(this, i, next3);
                    }
                }
            }
            Iterator<MotionScene.Transition> it7 = motionScene3.PlaceComponentResult.iterator();
            while (it7.hasNext()) {
                MotionScene.Transition next4 = it7.next();
                if (MotionScene.Transition.GetContactSyncConfig(next4).size() > 0) {
                    Iterator it8 = MotionScene.Transition.GetContactSyncConfig(next4).iterator();
                    while (it8.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it8.next()).MyBillsEntityDataFactory(this, i, next4);
                    }
                }
            }
        }
        if (!this.mScene.PlaceComponentResult() || (transition = (motionScene = this.mScene).getAuthRequestContext) == null || MotionScene.Transition.scheduleImpl(transition) == null) {
            return;
        }
        TouchResponse scheduleImpl = MotionScene.Transition.scheduleImpl(motionScene.getAuthRequestContext);
        int i2 = scheduleImpl.FragmentBottomSheetPaymentSettingBinding;
        if (i2 != -1) {
            view = scheduleImpl.GetContactSyncConfig.findViewById(i2);
            if (view == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("cannot find TouchAnchorId @id/");
                sb.append(Debug.MyBillsEntityDataFactory(scheduleImpl.GetContactSyncConfig.getContext(), scheduleImpl.FragmentBottomSheetPaymentSettingBinding));
                InstrumentInjector.log_e("TouchResponse", sb.toString());
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void getAuthRequestContext(NestedScrollView nestedScrollView2, int i3, int i4, int i5, int i6) {
                }
            });
        }
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAnchorDpDt(int i, float f, float f2, float f3, float[] fArr) {
        String resourceName;
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.BuiltInFictitiousFunctionClassFactory(f, f2, f3, fArr);
            float y = viewById.getY();
            this.MyBillsEntityDataFactory = f;
            this.PlaceComponentResult = y;
            return;
        }
        if (viewById == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            resourceName = sb.toString();
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("WARNING could not find view id ");
        sb2.append(resourceName);
        InstrumentInjector.log_w(TAG, sb2.toString());
    }

    public long getTransitionTimeMs() {
        int i;
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            MotionScene.Transition transition = motionScene.getAuthRequestContext;
            if (transition != null) {
                i = MotionScene.Transition.lookAheadTest(transition);
            } else {
                i = motionScene.MyBillsEntityDataFactory;
            }
            this.getValueOfTouchPositionAbsolute = i / 1000.0f;
        }
        return this.getValueOfTouchPositionAbsolute * 1000.0f;
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.F = transitionListener;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.I == null) {
            this.I = new CopyOnWriteArrayList<>();
        }
        this.I.add(transitionListener);
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.I;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    public void fireTrigger(int i, boolean z, float f) {
        TransitionListener transitionListener = this.F;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i, z, f);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.I;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i, z, f);
            }
        }
    }

    private void MyBillsEntityDataFactory() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.F == null && ((copyOnWriteArrayList = this.I) == null || copyOnWriteArrayList.isEmpty())) || this.NetworkUserEntityData$$ExternalSyntheticLambda3 == this.mTransitionPosition) {
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 != -1) {
            TransitionListener transitionListener = this.F;
            if (transitionListener != null) {
                transitionListener.onTransitionStarted(this, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.I;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(this, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
            }
            this.mIsAnimating = true;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = -1;
        float f = this.mTransitionPosition;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = f;
        TransitionListener transitionListener2 = this.F;
        if (transitionListener2 != null) {
            transitionListener2.onTransitionChange(this, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2, f);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList3 = this.I;
        if (copyOnWriteArrayList3 != null) {
            Iterator<TransitionListener> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionChange(this, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    protected void fireTransitionCompleted() {
        int i;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.F != null || ((copyOnWriteArrayList = this.I) != null && !copyOnWriteArrayList.isEmpty())) && this.NetworkUserEntityData$$ExternalSyntheticLambda4 == -1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.mCurrentState;
            if (this.mTransitionCompleted.isEmpty()) {
                i = -1;
            } else {
                ArrayList<Integer> arrayList = this.mTransitionCompleted;
                i = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i2 = this.mCurrentState;
            if (i != i2 && i2 != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i2));
            }
        }
        PlaceComponentResult();
        Runnable runnable = this.whenAvailable;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.A;
        if (iArr == null || this.mScheduledTransitions <= 0) {
            return;
        }
        transitionToState(iArr[0]);
        int[] iArr2 = this.A;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.mScheduledTransitions--;
    }

    private void PlaceComponentResult() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.F == null && ((copyOnWriteArrayList = this.I) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.mIsAnimating = false;
        Iterator<Integer> it = this.mTransitionCompleted.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TransitionListener transitionListener = this.F;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, next.intValue());
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.I;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionCompleted(this, next.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    public DesignTool getDesignTool() {
        if (this.DatabaseTableConfigUtil == null) {
            this.DatabaseTableConfigUtil = new DesignTool(this);
        }
        return this.DatabaseTableConfigUtil;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.I == null) {
                this.I = new CopyOnWriteArrayList<>();
            }
            this.I.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.getSupportButtonTintMode == null) {
                    this.getSupportButtonTintMode = new ArrayList<>();
                }
                this.getSupportButtonTintMode.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.getCallingPid == null) {
                    this.getCallingPid = new ArrayList<>();
                }
                this.getCallingPid.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.moveToNextValue == null) {
                    this.moveToNextValue = new ArrayList<>();
                }
                this.moveToNextValue.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.getSupportButtonTintMode;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.getCallingPid;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList = this.getSupportButtonTintMode;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.getSupportButtonTintMode.get(i).setProgress(f);
            }
        }
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList = this.getCallingPid;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.getCallingPid.get(i).setProgress(f);
            }
        }
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        int size = motionScene.KClassImpl$Data$declaredNonStaticMembers$2.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = motionScene.KClassImpl$Data$declaredNonStaticMembers$2.keyAt(i);
        }
        return iArr;
    }

    public ConstraintSet getConstraintSet(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getAuthRequestContext(i);
    }

    public ConstraintSet cloneConstraintSet(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet authRequestContext = motionScene.getAuthRequestContext(i);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        return constraintSet;
    }

    @Deprecated
    public void rebuildMotion() {
        InstrumentInjector.log_e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.BuiltInFictitiousFunctionClassFactory();
        invalidate();
    }

    public void updateState(int i, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.KClassImpl$Data$declaredNonStaticMembers$2.put(i, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i) {
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
    }

    public void updateStateAnimate(int i, ConstraintSet constraintSet, int i2) {
        if (this.mScene != null && this.mCurrentState == i) {
            updateState(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a1ba7, getConstraintSet(i));
            setState(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a1ba7, -1, -1);
            updateState(i, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(this.mScene, R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a1ba7, i);
            transition.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.max(i2, 8);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void scheduleTransitionTo(int i) {
        if (getCurrentState() == -1) {
            transitionToState(i);
            return;
        }
        int[] iArr = this.A;
        if (iArr == null) {
            this.A = new int[4];
        } else if (iArr.length <= this.mScheduledTransitions) {
            this.A = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.A;
        int i2 = this.mScheduledTransitions;
        this.mScheduledTransitions = i2 + 1;
        iArr2[i2] = i;
    }

    public void updateState() {
        Model model = this.mModel;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        model.getAuthRequestContext(this.mScene.getAuthRequestContext(this.scheduleImpl), this.mScene.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        rebuildScene();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.GetContactSyncConfig;
    }

    public int getStartState() {
        return this.scheduleImpl;
    }

    public int getEndState() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public void setTransitionDuration(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            InstrumentInjector.log_e(TAG, "MotionScene not defined");
            return;
        }
        MotionScene.Transition transition = motionScene.getAuthRequestContext;
        if (transition == null) {
            motionScene.MyBillsEntityDataFactory = i;
        } else {
            transition.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.max(i, 8);
        }
    }

    public MotionScene.Transition getTransition(int i) {
        Iterator<MotionScene.Transition> it = this.mScene.GetContactSyncConfig.iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            if (MotionScene.Transition.NetworkUserEntityData$$ExternalSyntheticLambda2(next) == i) {
                return next;
            }
        }
        return null;
    }

    int lookUpConstraintId(String str) {
        Integer num;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (num = motionScene.BuiltInFictitiousFunctionClassFactory.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    String getConstraintSetNames(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        for (Map.Entry<String, Integer> entry : motionScene.BuiltInFictitiousFunctionClassFactory.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == i) {
                return entry.getKey();
            }
        }
        return null;
    }

    void disableAutoTransition(boolean z) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.moveToNextValue = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.newProxyInstance = z;
    }

    public boolean isInteractionEnabled() {
        return this.newProxyInstance;
    }

    public void viewTransition(int i, View... viewArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            InstrumentInjector.log_e(TAG, " no motionScene");
            return;
        }
        ViewTransitionController viewTransitionController = motionScene.NetworkUserEntityData$$ExternalSyntheticLambda2;
        ArrayList arrayList = new ArrayList();
        Iterator<ViewTransition> it = viewTransitionController.moveToNextValue.iterator();
        ViewTransition viewTransition = null;
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.KClassImpl$Data$declaredNonStaticMembers$2 == i) {
                for (View view : viewArr) {
                    if (next.PlaceComponentResult(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    View[] viewArr2 = (View[]) arrayList.toArray(new View[0]);
                    int currentState = viewTransitionController.getAuthRequestContext.getCurrentState();
                    if (next.GetContactSyncConfig == 2) {
                        next.KClassImpl$Data$declaredNonStaticMembers$2(viewTransitionController, viewTransitionController.getAuthRequestContext, currentState, null, viewArr2);
                    } else if (currentState == -1) {
                        String str = viewTransitionController.PlaceComponentResult;
                        StringBuilder sb = new StringBuilder();
                        sb.append("No support for ViewTransition within transition yet. Currently: ");
                        sb.append(viewTransitionController.getAuthRequestContext.toString());
                        InstrumentInjector.log_w(str, sb.toString());
                    } else {
                        ConstraintSet constraintSet = viewTransitionController.getAuthRequestContext.getConstraintSet(currentState);
                        if (constraintSet != null) {
                            next.KClassImpl$Data$declaredNonStaticMembers$2(viewTransitionController, viewTransitionController.getAuthRequestContext, currentState, constraintSet, viewArr2);
                        }
                    }
                    arrayList.clear();
                }
                viewTransition = next;
            }
        }
        if (viewTransition == null) {
            InstrumentInjector.log_e(viewTransitionController.PlaceComponentResult, " Could not find ViewTransition");
        }
    }

    public void enableViewTransition(int i, boolean z) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            Iterator<ViewTransition> it = motionScene.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue.iterator();
            while (it.hasNext()) {
                ViewTransition next = it.next();
                if (next.KClassImpl$Data$declaredNonStaticMembers$2 == i) {
                    next.getAuthRequestContext = !z;
                    return;
                }
            }
        }
    }

    public boolean isViewTransitionEnabled(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.BuiltInFictitiousFunctionClassFactory(i);
        }
        return false;
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.KClassImpl$Data$declaredNonStaticMembers$2(i, motionController);
        }
        return false;
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.getErrorConfigVersion;
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.getErrorConfigVersion = z;
    }

    static /* synthetic */ void access$1400(MotionLayout motionLayout) {
        int childCount = motionLayout.getChildCount();
        motionLayout.mModel.getAuthRequestContext();
        boolean z = true;
        motionLayout.mInTransition = true;
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = motionLayout.getChildAt(i2);
            sparseArray.put(childAt.getId(), motionLayout.mFrameArrayList.get(childAt));
        }
        int width = motionLayout.getWidth();
        int height = motionLayout.getHeight();
        MotionScene.Transition transition = motionLayout.mScene.getAuthRequestContext;
        int NetworkUserEntityData$$ExternalSyntheticLambda0 = transition != null ? MotionScene.Transition.NetworkUserEntityData$$ExternalSyntheticLambda0(transition) : -1;
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                MotionController motionController = motionLayout.mFrameArrayList.get(motionLayout.getChildAt(i3));
                if (motionController != null) {
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda8 = NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[motionLayout.mFrameArrayList.size()];
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            MotionController motionController2 = motionLayout.mFrameArrayList.get(motionLayout.getChildAt(i5));
            if (motionController2.NetworkUserEntityData$$ExternalSyntheticLambda5.getAuthRequestContext != -1) {
                sparseBooleanArray.put(motionController2.NetworkUserEntityData$$ExternalSyntheticLambda5.getAuthRequestContext, true);
                iArr[i4] = motionController2.NetworkUserEntityData$$ExternalSyntheticLambda5.getAuthRequestContext;
                i4++;
            }
        }
        if (motionLayout.moveToNextValue != null) {
            for (int i6 = 0; i6 < i4; i6++) {
                MotionController motionController3 = motionLayout.mFrameArrayList.get(motionLayout.findViewById(iArr[i6]));
                if (motionController3 != null) {
                    motionLayout.mScene.getAuthRequestContext(motionController3);
                }
            }
            Iterator<MotionHelper> it = motionLayout.moveToNextValue.iterator();
            while (it.hasNext()) {
                it.next().onPreSetup(motionLayout, motionLayout.mFrameArrayList);
            }
            for (int i7 = 0; i7 < i4; i7++) {
                MotionController motionController4 = motionLayout.mFrameArrayList.get(motionLayout.findViewById(iArr[i7]));
                if (motionController4 != null) {
                    float f = motionLayout.getValueOfTouchPositionAbsolute;
                    motionController4.PlaceComponentResult(width, height, motionLayout.getNanoTime());
                }
            }
        } else {
            for (int i8 = 0; i8 < i4; i8++) {
                MotionController motionController5 = motionLayout.mFrameArrayList.get(motionLayout.findViewById(iArr[i8]));
                if (motionController5 != null) {
                    motionLayout.mScene.getAuthRequestContext(motionController5);
                    float f2 = motionLayout.getValueOfTouchPositionAbsolute;
                    motionController5.PlaceComponentResult(width, height, motionLayout.getNanoTime());
                }
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = motionLayout.getChildAt(i9);
            MotionController motionController6 = motionLayout.mFrameArrayList.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                motionLayout.mScene.getAuthRequestContext(motionController6);
                float f3 = motionLayout.getValueOfTouchPositionAbsolute;
                motionController6.PlaceComponentResult(width, height, motionLayout.getNanoTime());
            }
        }
        MotionScene.Transition transition2 = motionLayout.mScene.getAuthRequestContext;
        float initRecordTimeStamp = transition2 != null ? MotionScene.Transition.initRecordTimeStamp(transition2) : 0.0f;
        if (initRecordTimeStamp != 0.0f) {
            boolean z2 = ((double) initRecordTimeStamp) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            float abs = Math.abs(initRecordTimeStamp);
            float f4 = -3.4028235E38f;
            float f5 = Float.MAX_VALUE;
            int i10 = 0;
            float f6 = Float.MAX_VALUE;
            float f7 = -3.4028235E38f;
            while (true) {
                if (i10 >= childCount) {
                    z = false;
                    break;
                }
                MotionController motionController7 = motionLayout.mFrameArrayList.get(motionLayout.getChildAt(i10));
                if (!Float.isNaN(motionController7.isLayoutRequested)) {
                    break;
                }
                float f8 = motionController7.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7;
                float f9 = motionController7.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8;
                float f10 = z2 ? f9 - f8 : f9 + f8;
                f6 = Math.min(f6, f10);
                f7 = Math.max(f7, f10);
                i10++;
            }
            if (!z) {
                while (i < childCount) {
                    MotionController motionController8 = motionLayout.mFrameArrayList.get(motionLayout.getChildAt(i));
                    float f11 = motionController8.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    float f12 = motionController8.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    float f13 = z2 ? f12 - f11 : f12 + f11;
                    motionController8.NetworkUserEntityData$$ExternalSyntheticLambda6 = 1.0f / (1.0f - abs);
                    motionController8.NetworkUserEntityData$$ExternalSyntheticLambda4 = abs - (((f13 - f6) * abs) / (f7 - f6));
                    i++;
                }
                return;
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                MotionController motionController9 = motionLayout.mFrameArrayList.get(motionLayout.getChildAt(i11));
                if (!Float.isNaN(motionController9.isLayoutRequested)) {
                    f5 = Math.min(f5, motionController9.isLayoutRequested);
                    f4 = Math.max(f4, motionController9.isLayoutRequested);
                }
            }
            while (i < childCount) {
                MotionController motionController10 = motionLayout.mFrameArrayList.get(motionLayout.getChildAt(i));
                if (!Float.isNaN(motionController10.isLayoutRequested)) {
                    motionController10.NetworkUserEntityData$$ExternalSyntheticLambda6 = 1.0f / (1.0f - abs);
                    if (z2) {
                        motionController10.NetworkUserEntityData$$ExternalSyntheticLambda4 = abs - (((f4 - motionController10.isLayoutRequested) / (f4 - f5)) * abs);
                    } else {
                        motionController10.NetworkUserEntityData$$ExternalSyntheticLambda4 = abs - (((motionController10.isLayoutRequested - f5) * abs) / (f4 - f5));
                    }
                }
                i++;
            }
        }
    }

    static /* synthetic */ Rect access$2000(MotionLayout motionLayout, ConstraintWidget constraintWidget) {
        motionLayout.mTempRect.top = constraintWidget.DatabaseTableConfigUtil();
        motionLayout.mTempRect.left = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda1();
        motionLayout.mTempRect.right = (constraintWidget.h == 8 ? 0 : constraintWidget.FlowViewUtil$textChanges$2) + motionLayout.mTempRect.left;
        motionLayout.mTempRect.bottom = (constraintWidget.h != 8 ? constraintWidget.C : 0) + motionLayout.mTempRect.top;
        return motionLayout.mTempRect;
    }
}
