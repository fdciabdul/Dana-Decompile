package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.alipay.mobile.zebra.data.BoxData;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class MotionScene {
    int MyBillsEntityDataFactory;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Transition NetworkUserEntityData$$ExternalSyntheticLambda1;
    final ViewTransitionController NetworkUserEntityData$$ExternalSyntheticLambda2;
    private MotionLayout.MotionTracker NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final MotionLayout NetworkUserEntityData$$ExternalSyntheticLambda8;
    private MotionEvent PrepareContext;
    Transition getAuthRequestContext;
    float getErrorConfigVersion;
    private int isLayoutRequested;
    float lookAheadTest;
    StateSet scheduleImpl;
    boolean moveToNextValue = false;
    ArrayList<Transition> GetContactSyncConfig = new ArrayList<>();
    ArrayList<Transition> PlaceComponentResult = new ArrayList<>();
    SparseArray<ConstraintSet> KClassImpl$Data$declaredNonStaticMembers$2 = new SparseArray<>();
    HashMap<String, Integer> BuiltInFictitiousFunctionClassFactory = new HashMap<>();
    private SparseIntArray initRecordTimeStamp = new SparseIntArray();
    private boolean DatabaseTableConfigUtil = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
    private boolean newProxyInstance = false;

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0012, code lost:
    
        if (r2 != (-1)) goto L134;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.scheduleImpl
            r1 = -1
            if (r0 == 0) goto L15
            int r0 = r0.getAuthRequestContext(r7)
            if (r0 != r1) goto Lc
            r0 = r7
        Lc:
            androidx.constraintlayout.widget.StateSet r2 = r6.scheduleImpl
            int r2 = r2.getAuthRequestContext(r8)
            if (r2 == r1) goto L16
            goto L17
        L15:
            r0 = r7
        L16:
            r2 = r8
        L17:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.getAuthRequestContext
            if (r3 == 0) goto L2a
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.MyBillsEntityDataFactory(r3)
            if (r3 != r8) goto L2a
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.getAuthRequestContext
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.PlaceComponentResult(r3)
            if (r3 != r7) goto L2a
            return
        L2a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.GetContactSyncConfig
            java.util.Iterator r3 = r3.iterator()
        L30:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L6a
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.MyBillsEntityDataFactory(r4)
            if (r5 != r2) goto L48
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.PlaceComponentResult(r4)
            if (r5 == r0) goto L54
        L48:
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.MyBillsEntityDataFactory(r4)
            if (r5 != r8) goto L30
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.PlaceComponentResult(r4)
            if (r5 != r7) goto L30
        L54:
            r6.getAuthRequestContext = r4
            if (r4 == 0) goto L69
            androidx.constraintlayout.motion.widget.TouchResponse r7 = androidx.constraintlayout.motion.widget.MotionScene.Transition.scheduleImpl(r4)
            if (r7 == 0) goto L69
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.getAuthRequestContext
            androidx.constraintlayout.motion.widget.TouchResponse r7 = androidx.constraintlayout.motion.widget.MotionScene.Transition.scheduleImpl(r7)
            boolean r8 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0
            r7.getAuthRequestContext(r8)
        L69:
            return
        L6a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.PlaceComponentResult
            java.util.Iterator r3 = r3.iterator()
        L72:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L86
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.MyBillsEntityDataFactory(r4)
            if (r5 != r8) goto L72
            r7 = r4
            goto L72
        L86:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.PlaceComponentResult(r8, r0)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.BuiltInFictitiousFunctionClassFactory(r8, r2)
            if (r0 == r1) goto L98
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r7 = r6.GetContactSyncConfig
            r7.add(r8)
        L98:
            r6.getAuthRequestContext = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.MyBillsEntityDataFactory(int, int):void");
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(MotionLayout motionLayout, int i) {
        Transition transition;
        if (KClassImpl$Data$declaredNonStaticMembers$2() || this.moveToNextValue) {
            return false;
        }
        Iterator<Transition> it = this.GetContactSyncConfig.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.KClassImpl$Data$declaredNonStaticMembers$2 != 0 && ((transition = this.getAuthRequestContext) != next || !transition.getAuthRequestContext(2))) {
                if (i == next.MyBillsEntityDataFactory && (next.KClassImpl$Data$declaredNonStaticMembers$2 == 4 || next.KClassImpl$Data$declaredNonStaticMembers$2 == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.KClassImpl$Data$declaredNonStaticMembers$2 == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                } else if (i == next.getAuthRequestContext && (next.KClassImpl$Data$declaredNonStaticMembers$2 == 3 || next.KClassImpl$Data$declaredNonStaticMembers$2 == 1)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.KClassImpl$Data$declaredNonStaticMembers$2 == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6 != null;
    }

    public final void PlaceComponentResult(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        Transition transition = this.getAuthRequestContext;
        if (transition == null || transition.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            return;
        }
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(i);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, MotionController motionController) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory(i, motionController);
    }

    /* loaded from: classes3.dex */
    public static class Transition {
        int BuiltInFictitiousFunctionClassFactory;
        private int DatabaseTableConfigUtil;
        ArrayList<TransitionOnClick> GetContactSyncConfig;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        int NetworkUserEntityData$$ExternalSyntheticLambda1;
        public TouchResponse NetworkUserEntityData$$ExternalSyntheticLambda2;
        private int NetworkUserEntityData$$ExternalSyntheticLambda7;
        int PlaceComponentResult;
        int getAuthRequestContext;
        int getErrorConfigVersion;
        private boolean initRecordTimeStamp;
        private final MotionScene isLayoutRequested;
        String lookAheadTest;
        ArrayList<KeyFrames> moveToNextValue;
        private float newProxyInstance;
        public boolean scheduleImpl;

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return !this.scheduleImpl;
        }

        public final boolean getAuthRequestContext(int i) {
            return (i & this.NetworkUserEntityData$$ExternalSyntheticLambda7) != 0;
        }

        /* loaded from: classes3.dex */
        public static class TransitionOnClick implements View.OnClickListener {
            int BuiltInFictitiousFunctionClassFactory;
            private final Transition KClassImpl$Data$declaredNonStaticMembers$2;
            int getAuthRequestContext;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.BuiltInFictitiousFunctionClassFactory = -1;
                this.getAuthRequestContext = 17;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.DaggerMerchantManagementComponent$MerchantManagementComponentImpl$SSLPinningRepositoryProvider);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.startApp) {
                        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getResourceId(index, this.BuiltInFictitiousFunctionClassFactory);
                    } else if (index == R.styleable.DaggerNewPromoCenterComponent$NewPromoCenterComponentImpl$OauthRepositoryProvider) {
                        this.getAuthRequestContext = obtainStyledAttributes.getInt(index, this.getAuthRequestContext);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View] */
            public final void MyBillsEntityDataFactory(MotionLayout motionLayout, int i, Transition transition) {
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                MotionLayout motionLayout2 = motionLayout;
                if (i2 != -1) {
                    motionLayout2 = motionLayout.findViewById(i2);
                }
                if (motionLayout2 != null) {
                    int i3 = transition.MyBillsEntityDataFactory;
                    int i4 = transition.getAuthRequestContext;
                    if (i3 == -1) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    int i5 = this.getAuthRequestContext;
                    int i6 = i5 & 1;
                    boolean z = false;
                    boolean z2 = i6 != 0 && i == i3;
                    boolean z3 = (i5 & 256) != 0 && i == i3;
                    boolean z4 = i6 != 0 && i == i3;
                    boolean z5 = (i5 & 16) != 0 && i == i4;
                    if ((i5 & 4096) != 0 && i == i4) {
                        z = true;
                    }
                    if ((z2 | z3 | z4 | z5) || z) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("OnClick could not find id ");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                InstrumentInjector.log_e(TypedValues.MotionScene.PlaceComponentResult, sb.toString());
            }

            public final void BuiltInFictitiousFunctionClassFactory(MotionLayout motionLayout) {
                int i = this.BuiltInFictitiousFunctionClassFactory;
                if (i == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i);
                if (findViewById == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" (*)  could not find id ");
                    sb.append(this.BuiltInFictitiousFunctionClassFactory);
                    InstrumentInjector.log_e(TypedValues.MotionScene.PlaceComponentResult, sb.toString());
                    return;
                }
                findViewById.setOnClickListener(null);
            }

            private boolean KClassImpl$Data$declaredNonStaticMembers$2(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (transition2 == transition) {
                    return true;
                }
                int i = transition2.getAuthRequestContext;
                int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                return i2 == -1 ? motionLayout.mCurrentState != i : motionLayout.mCurrentState == i2 || motionLayout.mCurrentState == i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory != -1) {
                        Transition transition = this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested.getAuthRequestContext;
                        int i = this.getAuthRequestContext;
                        boolean z = false;
                        boolean z2 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                        boolean z3 = ((i & 16) == 0 && (i & 4096) == 0) ? false : true;
                        if (z2 && z3) {
                            Transition transition2 = this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested.getAuthRequestContext;
                            Transition transition3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (transition2 != transition3) {
                                motionLayout.setTransition(transition3);
                            }
                            if (motionLayout.getCurrentState() == motionLayout.getEndState() || motionLayout.getProgress() > 0.5f) {
                                z3 = true;
                            } else {
                                z3 = false;
                                z = true;
                            }
                        } else {
                            z = z2;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$2(transition, motionLayout)) {
                            if (z && (this.getAuthRequestContext & 1) != 0) {
                                motionLayout.setTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
                                motionLayout.transitionToEnd();
                                return;
                            } else if (z3 && (this.getAuthRequestContext & 16) != 0) {
                                motionLayout.setTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
                                motionLayout.transitionToStart();
                                return;
                            } else if (z && (this.getAuthRequestContext & 256) != 0) {
                                motionLayout.setTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
                                motionLayout.setProgress(1.0f);
                                return;
                            } else if (!z3 || (this.getAuthRequestContext & 4096) == 0) {
                                return;
                            } else {
                                motionLayout.setTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
                                motionLayout.setProgress(0.0f);
                                return;
                            }
                        }
                        return;
                    }
                    int currentState = motionLayout.getCurrentState();
                    if (currentState == -1) {
                        motionLayout.transitionToState(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
                        return;
                    }
                    Transition transition4 = new Transition(this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    transition4.MyBillsEntityDataFactory = currentState;
                    transition4.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    motionLayout.setTransition(transition4);
                    motionLayout.transitionToEnd();
                }
            }
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.DatabaseTableConfigUtil = -1;
            this.initRecordTimeStamp = false;
            this.getAuthRequestContext = -1;
            this.MyBillsEntityDataFactory = -1;
            this.PlaceComponentResult = 0;
            this.lookAheadTest = null;
            this.BuiltInFictitiousFunctionClassFactory = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 400;
            this.newProxyInstance = 0.0f;
            this.moveToNextValue = new ArrayList<>();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            this.GetContactSyncConfig = new ArrayList<>();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.scheduleImpl = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
            this.getErrorConfigVersion = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
            this.isLayoutRequested = motionScene;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = motionScene.MyBillsEntityDataFactory;
            if (transition != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = transition.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.PlaceComponentResult = transition.PlaceComponentResult;
                this.lookAheadTest = transition.lookAheadTest;
                this.BuiltInFictitiousFunctionClassFactory = transition.BuiltInFictitiousFunctionClassFactory;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = transition.NetworkUserEntityData$$ExternalSyntheticLambda0;
                this.moveToNextValue = transition.moveToNextValue;
                this.newProxyInstance = transition.newProxyInstance;
                this.getErrorConfigVersion = transition.getErrorConfigVersion;
            }
        }

        public Transition(MotionScene motionScene, int i, int i2) {
            this.DatabaseTableConfigUtil = -1;
            this.initRecordTimeStamp = false;
            this.getAuthRequestContext = -1;
            this.MyBillsEntityDataFactory = -1;
            this.PlaceComponentResult = 0;
            this.lookAheadTest = null;
            this.BuiltInFictitiousFunctionClassFactory = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 400;
            this.newProxyInstance = 0.0f;
            this.moveToNextValue = new ArrayList<>();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            this.GetContactSyncConfig = new ArrayList<>();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.scheduleImpl = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
            this.getErrorConfigVersion = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
            this.DatabaseTableConfigUtil = -1;
            this.isLayoutRequested = motionScene;
            this.MyBillsEntityDataFactory = i;
            this.getAuthRequestContext = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = motionScene.MyBillsEntityDataFactory;
            this.getErrorConfigVersion = motionScene.isLayoutRequested;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.DatabaseTableConfigUtil = -1;
            this.initRecordTimeStamp = false;
            this.getAuthRequestContext = -1;
            this.MyBillsEntityDataFactory = -1;
            this.PlaceComponentResult = 0;
            this.lookAheadTest = null;
            this.BuiltInFictitiousFunctionClassFactory = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 400;
            this.newProxyInstance = 0.0f;
            this.moveToNextValue = new ArrayList<>();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            this.GetContactSyncConfig = new ArrayList<>();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.scheduleImpl = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
            this.getErrorConfigVersion = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = motionScene.MyBillsEntityDataFactory;
            this.getErrorConfigVersion = motionScene.isLayoutRequested;
            this.isLayoutRequested = motionScene;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.f32zipTUPTUsU);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Base64$Encoder) {
                    this.getAuthRequestContext = obtainStyledAttributes.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.getAuthRequestContext);
                    if (BoxData.ATTR_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.PlaceComponentResult(context, this.getAuthRequestContext);
                        motionScene.KClassImpl$Data$declaredNonStaticMembers$2.append(this.getAuthRequestContext, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.getAuthRequestContext = motionScene.MyBillsEntityDataFactory(context, this.getAuthRequestContext);
                    }
                } else if (index == R.styleable.onExtrasChanged) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getResourceId(index, this.MyBillsEntityDataFactory);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.MyBillsEntityDataFactory);
                    if (BoxData.ATTR_LAYOUT.equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.PlaceComponentResult(context, this.MyBillsEntityDataFactory);
                        motionScene.KClassImpl$Data$declaredNonStaticMembers$2.append(this.MyBillsEntityDataFactory, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.MyBillsEntityDataFactory = motionScene.MyBillsEntityDataFactory(context, this.MyBillsEntityDataFactory);
                    }
                } else if (index == R.styleable.f21appendFractionalimpl) {
                    TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                    if (peekValue.type == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.BuiltInFictitiousFunctionClassFactory = resourceId;
                        if (resourceId != -1) {
                            this.PlaceComponentResult = -2;
                        }
                    } else if (peekValue.type == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.lookAheadTest = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getResourceId(index, -1);
                                this.PlaceComponentResult = -2;
                            } else {
                                this.PlaceComponentResult = -1;
                            }
                        }
                    } else {
                        this.PlaceComponentResult = obtainStyledAttributes.getInteger(index, this.PlaceComponentResult);
                    }
                } else if (index == R.styleable.finishAllInQueue) {
                    int i2 = obtainStyledAttributes.getInt(index, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i2;
                    if (i2 < 8) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 8;
                    }
                } else if (index == R.styleable.applicableTo) {
                    this.newProxyInstance = obtainStyledAttributes.getFloat(index, this.newProxyInstance);
                } else if (index == R.styleable.f15$r8$lambda$qmdIr_afOVXAEsfbNmN85QfJBE) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInteger(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.setSortingCode) {
                    this.DatabaseTableConfigUtil = obtainStyledAttributes.getResourceId(index, this.DatabaseTableConfigUtil);
                } else if (index == R.styleable.MarkwonHtmlParser) {
                    this.scheduleImpl = obtainStyledAttributes.getBoolean(index, this.scheduleImpl);
                } else if (index == R.styleable.SidePropagation) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getInteger(index, -1);
                } else if (index == R.styleable.getTopUpConsult) {
                    this.getErrorConfigVersion = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.CashierDailyLimitVerifyFragment) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getInteger(index, 0);
                }
            }
            if (this.MyBillsEntityDataFactory == -1) {
                this.initRecordTimeStamp = true;
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        this.scheduleImpl = null;
        this.getAuthRequestContext = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.MyBillsEntityDataFactory = 400;
        this.isLayoutRequested = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = motionLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ViewTransitionController(motionLayout);
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            Transition transition = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    char c = 2;
                    if (eventType == 2) {
                        String name = xml.getName();
                        if (this.DatabaseTableConfigUtil) {
                            PrintStream printStream = System.out;
                            StringBuilder sb = new StringBuilder();
                            sb.append("parsing = ");
                            sb.append(name);
                            printStream.println(sb.toString());
                        }
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1239391468:
                                if (name.equals("KeyFrameSet")) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -687739768:
                                if (name.equals("Include")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 61998586:
                                if (name.equals("ViewTransition")) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 269306229:
                                if (name.equals("Transition")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 312750793:
                                if (name.equals("OnClick")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 327855227:
                                if (name.equals("OnSwipe")) {
                                    break;
                                }
                                c = 65535;
                                break;
                            case 793277014:
                                if (name.equals(TypedValues.MotionScene.PlaceComponentResult)) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1942574248:
                                if (name.equals("include")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xml), R.styleable.getProcessor);
                                int indexCount = obtainStyledAttributes.getIndexCount();
                                for (int i2 = 0; i2 < indexCount; i2++) {
                                    int index = obtainStyledAttributes.getIndex(i2);
                                    if (index == R.styleable.f26isFirebaseLoginPerformanceTrackerOn$lambda162) {
                                        int i3 = obtainStyledAttributes.getInt(index, this.MyBillsEntityDataFactory);
                                        this.MyBillsEntityDataFactory = i3;
                                        if (i3 < 8) {
                                            this.MyBillsEntityDataFactory = 8;
                                        }
                                    } else if (index == R.styleable.getLogRequests) {
                                        this.isLayoutRequested = obtainStyledAttributes.getInteger(index, 0);
                                    }
                                }
                                obtainStyledAttributes.recycle();
                                break;
                            case 1:
                                ArrayList<Transition> arrayList = this.GetContactSyncConfig;
                                transition = new Transition(this, context, xml);
                                arrayList.add(transition);
                                if (this.getAuthRequestContext == null && !transition.initRecordTimeStamp) {
                                    this.getAuthRequestContext = transition;
                                    if (transition.NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
                                        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                    }
                                }
                                if (transition.initRecordTimeStamp) {
                                    if (transition.getAuthRequestContext == -1) {
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = transition;
                                    } else {
                                        this.PlaceComponentResult.add(transition);
                                    }
                                    this.GetContactSyncConfig.remove(transition);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (transition == null) {
                                    String resourceEntryName = context.getResources().getResourceEntryName(i);
                                    int lineNumber = xml.getLineNumber();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(" OnSwipe (");
                                    sb2.append(resourceEntryName);
                                    sb2.append(".xml:");
                                    sb2.append(lineNumber);
                                    sb2.append(")");
                                    InstrumentInjector.log_v(TypedValues.MotionScene.PlaceComponentResult, sb2.toString());
                                }
                                if (transition != null) {
                                    transition.NetworkUserEntityData$$ExternalSyntheticLambda2 = new TouchResponse(context, this.NetworkUserEntityData$$ExternalSyntheticLambda8, xml);
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (transition != null) {
                                    transition.GetContactSyncConfig.add(new Transition.TransitionOnClick(context, transition, xml));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                this.scheduleImpl = new StateSet(context, xml);
                                break;
                            case 5:
                                PlaceComponentResult(context, xml);
                                break;
                            case 6:
                            case 7:
                                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(Xml.asAttributeSet(xml), R.styleable.DaggerStickySummaryComponent$StickySummaryComponentImpl$PostExecutionThreadProvider);
                                int indexCount2 = obtainStyledAttributes2.getIndexCount();
                                for (int i4 = 0; i4 < indexCount2; i4++) {
                                    int index2 = obtainStyledAttributes2.getIndex(i4);
                                    if (index2 == R.styleable.mergeValueAndBytes) {
                                        MyBillsEntityDataFactory(context, obtainStyledAttributes2.getResourceId(index2, -1));
                                    }
                                }
                                obtainStyledAttributes2.recycle();
                                break;
                            case '\b':
                                KeyFrames keyFrames = new KeyFrames(context, xml);
                                if (transition != null) {
                                    transition.moveToNextValue.add(keyFrames);
                                    break;
                                } else {
                                    break;
                                }
                            case '\t':
                                ViewTransition viewTransition = new ViewTransition(context, xml);
                                ViewTransitionController viewTransitionController = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                                viewTransitionController.moveToNextValue.add(viewTransition);
                                viewTransitionController.BuiltInFictitiousFunctionClassFactory = null;
                                if (viewTransition.getErrorConfigVersion == 4) {
                                    viewTransitionController.PlaceComponentResult(viewTransition, true);
                                    break;
                                } else if (viewTransition.getErrorConfigVersion == 5) {
                                    viewTransitionController.PlaceComponentResult(viewTransition, false);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (IOException | XmlPullParserException unused) {
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.put(R.id.getAuthRequestContext, new ConstraintSet());
        this.BuiltInFictitiousFunctionClassFactory.put("motion_base", Integer.valueOf(R.id.getAuthRequestContext));
    }

    private int PlaceComponentResult(Context context, String str) {
        int i;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DatabaseTableConfigUtil) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("id getMap res = ");
                sb.append(i);
                printStream.println(sb.toString());
            }
        } else {
            i = -1;
        }
        if (i == -1) {
            if (str != null && str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            InstrumentInjector.log_e(TypedValues.MotionScene.PlaceComponentResult, "error in parsing id");
            return i;
        }
        return i;
    }

    public int MyBillsEntityDataFactory(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return PlaceComponentResult(context, xml);
                }
            }
            return -1;
        } catch (IOException | XmlPullParserException unused) {
            return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int PlaceComponentResult(Context context, XmlPullParser xmlPullParser) {
        char c;
        char c2;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.PlaceComponentResult = false;
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (this.DatabaseTableConfigUtil) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("id string = ");
                sb.append(attributeValue);
                printStream.println(sb.toString());
            }
            attributeName.hashCode();
            int hashCode = attributeName.hashCode();
            if (hashCode == -1496482599) {
                if (attributeName.equals("deriveConstraintsFrom")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != -1153153640) {
                if (hashCode == 3355 && attributeName.equals("id")) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (attributeName.equals("constraintRotate")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c == 0) {
                i2 = PlaceComponentResult(context, attributeValue);
            } else if (c == 1) {
                try {
                    constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.parseInt(attributeValue);
                } catch (NumberFormatException unused) {
                    attributeValue.hashCode();
                    switch (attributeValue.hashCode()) {
                        case -768416914:
                            if (attributeValue.equals("x_left")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3317767:
                            if (attributeValue.equals("left")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3387192:
                            if (attributeValue.equals("none")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 108511772:
                            if (attributeValue.equals("right")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1954540437:
                            if (attributeValue.equals("x_right")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    if (c2 == 0) {
                        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 = 4;
                    } else if (c2 == 1) {
                        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
                    } else if (c2 == 2) {
                        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                    } else if (c2 == 3) {
                        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                    } else if (c2 == 4) {
                        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2 = 3;
                    }
                }
            } else if (c == 2) {
                i = PlaceComponentResult(context, attributeValue);
                HashMap<String, Integer> hashMap = this.BuiltInFictitiousFunctionClassFactory;
                if (attributeValue == null) {
                    attributeValue = "";
                } else {
                    int indexOf = attributeValue.indexOf(47);
                    if (indexOf >= 0) {
                        attributeValue = attributeValue.substring(indexOf + 1);
                    }
                }
                hashMap.put(attributeValue, Integer.valueOf(i));
                constraintSet.BuiltInFictitiousFunctionClassFactory = Debug.MyBillsEntityDataFactory(context, i);
            }
        }
        if (i != -1) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.mDebugPath != 0) {
                constraintSet.moveToNextValue = true;
            }
            constraintSet.getAuthRequestContext(context, xmlPullParser);
            if (i2 != -1) {
                this.initRecordTimeStamp.put(i, i2);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(i, constraintSet);
        }
        return i;
    }

    public final ConstraintSet getAuthRequestContext(int i) {
        int authRequestContext;
        if (this.DatabaseTableConfigUtil) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("id ");
            sb.append(i);
            printStream.println(sb.toString());
            PrintStream printStream2 = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("size ");
            sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2.size());
            printStream2.println(sb2.toString());
        }
        StateSet stateSet = this.scheduleImpl;
        if (stateSet != null && (authRequestContext = stateSet.getAuthRequestContext(i)) != -1) {
            i = authRequestContext;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(i) == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Warning could not find ConstraintSet id/");
            sb3.append(Debug.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8.getContext(), i));
            sb3.append(" In MotionScene");
            InstrumentInjector.log_e(TypedValues.MotionScene.PlaceComponentResult, sb3.toString());
            SparseArray<ConstraintSet> sparseArray = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
    }

    public final void getAuthRequestContext(MotionController motionController) {
        Transition transition = this.getAuthRequestContext;
        if (transition != null) {
            Iterator it = transition.moveToNextValue.iterator();
            while (it.hasNext()) {
                ((KeyFrames) it.next()).BuiltInFictitiousFunctionClassFactory(motionController);
            }
            return;
        }
        Transition transition2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (transition2 != null) {
            Iterator it2 = transition2.moveToNextValue.iterator();
            while (it2.hasNext()) {
                ((KeyFrames) it2.next()).BuiltInFictitiousFunctionClassFactory(motionController);
            }
        }
    }

    public final boolean PlaceComponentResult() {
        Iterator<Transition> it = this.GetContactSyncConfig.iterator();
        while (it.hasNext()) {
            if (it.next().NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
                return true;
            }
        }
        Transition transition = this.getAuthRequestContext;
        return (transition == null || transition.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:729:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:730:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:733:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:734:0x04d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(android.view.MotionEvent r29, int r30, androidx.constraintlayout.motion.widget.MotionLayout r31) {
        /*
            Method dump skipped, instructions count: 1958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.KClassImpl$Data$declaredNonStaticMembers$2(android.view.MotionEvent, int, androidx.constraintlayout.motion.widget.MotionLayout):void");
    }

    public final Interpolator getAuthRequestContext() {
        int i = this.getAuthRequestContext.PlaceComponentResult;
        if (i != -2) {
            if (i == -1) {
                final Easing PlaceComponentResult = Easing.PlaceComponentResult(this.getAuthRequestContext.lookAheadTest);
                return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f) {
                        return (float) PlaceComponentResult.getAuthRequestContext(f);
                    }
                };
            } else if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    return null;
                                }
                                return new AnticipateInterpolator();
                            }
                            return new OvershootInterpolator();
                        }
                        return new BounceInterpolator();
                    }
                    return new DecelerateInterpolator();
                }
                return new AccelerateInterpolator();
            } else {
                return new AccelerateDecelerateInterpolator();
            }
        }
        return AnimationUtils.loadInterpolator(this.NetworkUserEntityData$$ExternalSyntheticLambda8.getContext(), this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
    }

    public final boolean MyBillsEntityDataFactory() {
        Transition transition = this.getAuthRequestContext;
        if (transition == null || transition.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            return false;
        }
        return this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult();
    }

    public final void PlaceComponentResult(MotionLayout motionLayout) {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            int keyAt = this.KClassImpl$Data$declaredNonStaticMembers$2.keyAt(i);
            if (MyBillsEntityDataFactory(keyAt)) {
                InstrumentInjector.log_e(TypedValues.MotionScene.PlaceComponentResult, "Cannot be derived from yourself");
                return;
            }
            BuiltInFictitiousFunctionClassFactory(keyAt, motionLayout);
        }
    }

    private boolean MyBillsEntityDataFactory(int i) {
        int i2 = this.initRecordTimeStamp.get(i);
        int size = this.initRecordTimeStamp.size();
        while (i2 > 0) {
            if (i2 == i || size < 0) {
                return true;
            }
            i2 = this.initRecordTimeStamp.get(i2);
            size--;
        }
        return false;
    }

    private void BuiltInFictitiousFunctionClassFactory(int i, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        constraintSet.MyBillsEntityDataFactory = constraintSet.BuiltInFictitiousFunctionClassFactory;
        int i2 = this.initRecordTimeStamp.get(i);
        if (i2 > 0) {
            BuiltInFictitiousFunctionClassFactory(i2, motionLayout);
            ConstraintSet constraintSet2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i2);
            if (constraintSet2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("ERROR! invalid deriveConstraintsFrom: @id/");
                sb.append(Debug.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8.getContext(), i2));
                InstrumentInjector.log_e(TypedValues.MotionScene.PlaceComponentResult, sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(constraintSet.MyBillsEntityDataFactory);
            sb2.append("/");
            sb2.append(constraintSet2.MyBillsEntityDataFactory);
            constraintSet.MyBillsEntityDataFactory = sb2.toString();
            for (Integer num : constraintSet2.getAuthRequestContext.keySet()) {
                int intValue = num.intValue();
                ConstraintSet.Constraint constraint = constraintSet2.getAuthRequestContext.get(num);
                if (!constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(intValue))) {
                    constraintSet.getAuthRequestContext.put(Integer.valueOf(intValue), new ConstraintSet.Constraint());
                }
                ConstraintSet.Constraint constraint2 = constraintSet.getAuthRequestContext.get(Integer.valueOf(intValue));
                if (constraint2 != null) {
                    if (!constraint2.BuiltInFictitiousFunctionClassFactory.getValueOfTouchPositionAbsolute) {
                        constraint2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(constraint.BuiltInFictitiousFunctionClassFactory);
                    }
                    if (!constraint2.scheduleImpl.BuiltInFictitiousFunctionClassFactory) {
                        constraint2.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(constraint.scheduleImpl);
                    }
                    if (!constraint2.moveToNextValue.BuiltInFictitiousFunctionClassFactory) {
                        constraint2.moveToNextValue.MyBillsEntityDataFactory(constraint.moveToNextValue);
                    }
                    if (!constraint2.getErrorConfigVersion.getAuthRequestContext) {
                        constraint2.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(constraint.getErrorConfigVersion);
                    }
                    for (String str : constraint.PlaceComponentResult.keySet()) {
                        if (!constraint2.PlaceComponentResult.containsKey(str)) {
                            constraint2.PlaceComponentResult.put(str, constraint.PlaceComponentResult.get(str));
                        }
                    }
                }
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(constraintSet.MyBillsEntityDataFactory);
            sb3.append("  layout");
            constraintSet.MyBillsEntityDataFactory = sb3.toString();
            int childCount = motionLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = motionLayout.getChildAt(i3);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                int id2 = childAt.getId();
                if (constraintSet.PlaceComponentResult && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(id2))) {
                    constraintSet.getAuthRequestContext.put(Integer.valueOf(id2), new ConstraintSet.Constraint());
                }
                ConstraintSet.Constraint constraint3 = constraintSet.getAuthRequestContext.get(Integer.valueOf(id2));
                if (constraint3 != null) {
                    if (!constraint3.BuiltInFictitiousFunctionClassFactory.getValueOfTouchPositionAbsolute) {
                        constraint3.KClassImpl$Data$declaredNonStaticMembers$2(id2, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            constraint3.BuiltInFictitiousFunctionClassFactory.J = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                constraint3.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper = barrier.getAllowsGoneWidget();
                                constraint3.BuiltInFictitiousFunctionClassFactory.F = barrier.getType();
                                constraint3.BuiltInFictitiousFunctionClassFactory.I = barrier.getMargin();
                            }
                        }
                        constraint3.BuiltInFictitiousFunctionClassFactory.getValueOfTouchPositionAbsolute = true;
                    }
                    if (!constraint3.scheduleImpl.BuiltInFictitiousFunctionClassFactory) {
                        constraint3.scheduleImpl.MyBillsEntityDataFactory = childAt.getVisibility();
                        constraint3.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = childAt.getAlpha();
                        constraint3.scheduleImpl.BuiltInFictitiousFunctionClassFactory = true;
                    }
                    if (Build.VERSION.SDK_INT >= 17 && !constraint3.moveToNextValue.BuiltInFictitiousFunctionClassFactory) {
                        constraint3.moveToNextValue.BuiltInFictitiousFunctionClassFactory = true;
                        constraint3.moveToNextValue.MyBillsEntityDataFactory = childAt.getRotation();
                        constraint3.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = childAt.getRotationX();
                        constraint3.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = childAt.getRotationY();
                        constraint3.moveToNextValue.moveToNextValue = childAt.getScaleX();
                        constraint3.moveToNextValue.lookAheadTest = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (pivotX != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || pivotY != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            constraint3.moveToNextValue.getErrorConfigVersion = pivotX;
                            constraint3.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1 = pivotY;
                        }
                        constraint3.moveToNextValue.initRecordTimeStamp = childAt.getTranslationX();
                        constraint3.moveToNextValue.DatabaseTableConfigUtil = childAt.getTranslationY();
                        if (Build.VERSION.SDK_INT >= 21) {
                            constraint3.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2 = childAt.getTranslationZ();
                            if (constraint3.moveToNextValue.getAuthRequestContext) {
                                constraint3.moveToNextValue.PlaceComponentResult = childAt.getElevation();
                            }
                        }
                    }
                }
            }
        }
        for (ConstraintSet.Constraint constraint4 : constraintSet.getAuthRequestContext.values()) {
            if (constraint4.MyBillsEntityDataFactory != null) {
                if (constraint4.getAuthRequestContext != null) {
                    Iterator<Integer> it = constraintSet.getAuthRequestContext.keySet().iterator();
                    while (it.hasNext()) {
                        int intValue2 = it.next().intValue();
                        ConstraintSet.Constraint constraint5 = constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(intValue2)) ? constraintSet.getAuthRequestContext.get(Integer.valueOf(intValue2)) : null;
                        if (constraint5.BuiltInFictitiousFunctionClassFactory.H != null && constraint4.getAuthRequestContext.matches(constraint5.BuiltInFictitiousFunctionClassFactory.H)) {
                            constraint4.MyBillsEntityDataFactory.getAuthRequestContext(constraint5);
                            constraint5.PlaceComponentResult.putAll((HashMap) constraint4.PlaceComponentResult.clone());
                        }
                    }
                } else {
                    int i4 = constraint4.KClassImpl$Data$declaredNonStaticMembers$2;
                    constraint4.MyBillsEntityDataFactory.getAuthRequestContext(constraintSet.getAuthRequestContext.containsKey(Integer.valueOf(i4)) ? constraintSet.getAuthRequestContext.get(Integer.valueOf(i4)) : null);
                }
            }
        }
    }

    public final List<Transition> KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int authRequestContext;
        StateSet stateSet = this.scheduleImpl;
        if (stateSet != null && (authRequestContext = stateSet.getAuthRequestContext(i)) != -1) {
            i = authRequestContext;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.GetContactSyncConfig.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.MyBillsEntityDataFactory == i || next.getAuthRequestContext == i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
