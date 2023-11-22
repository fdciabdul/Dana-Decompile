package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.TypedValue;
import android.util.Xml;
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
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ViewTransition {
    private static String DatabaseTableConfigUtil = "ViewTransition";
    ConstraintSet.Constraint BuiltInFictitiousFunctionClassFactory;
    private int FragmentBottomSheetPaymentSettingBinding;
    int GetContactSyncConfig;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private String NetworkUserEntityData$$ExternalSyntheticLambda6;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    Context PlaceComponentResult;
    private int PrepareContext;
    boolean getAuthRequestContext;
    int getErrorConfigVersion;
    private String initRecordTimeStamp;
    private int isLayoutRequested = -1;
    int lookAheadTest;
    KeyFrames moveToNextValue;
    private int newProxyInstance;
    int scheduleImpl;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewTransition(");
        sb.append(Debug.MyBillsEntityDataFactory(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2));
        sb.append(")");
        return sb.toString();
    }

    public ViewTransition(Context context, XmlPullParser xmlPullParser) {
        char c;
        this.getErrorConfigVersion = -1;
        this.getAuthRequestContext = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
        this.newProxyInstance = -1;
        this.FragmentBottomSheetPaymentSettingBinding = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        this.initRecordTimeStamp = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        this.MyBillsEntityDataFactory = -1;
        this.PrepareContext = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = -1;
        this.lookAheadTest = -1;
        this.scheduleImpl = -1;
        this.PlaceComponentResult = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (name.equals("ConstraintOverride")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 366511058:
                            if (name.equals("CustomMethod")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1791837707:
                            if (name.equals("CustomAttribute")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c == 0) {
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.internalNextDouble);
                        int indexCount = obtainStyledAttributes.getIndexCount();
                        for (int i = 0; i < indexCount; i++) {
                            int index = obtainStyledAttributes.getIndex(i);
                            if (index == R.styleable.glClear) {
                                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                            } else if (index == R.styleable.setChipIcon) {
                                if (MotionLayout.IS_IN_EDIT_MODE) {
                                    int resourceId = obtainStyledAttributes.getResourceId(index, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda5 = resourceId;
                                    if (resourceId == -1) {
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = obtainStyledAttributes.getString(index);
                                    }
                                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda6 = obtainStyledAttributes.getString(index);
                                } else {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda5 = obtainStyledAttributes.getResourceId(index, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
                                }
                            } else if (index == R.styleable.OkHttpExporterBuilder) {
                                this.getErrorConfigVersion = obtainStyledAttributes.getInt(index, this.getErrorConfigVersion);
                            } else if (index == R.styleable.SaveNumberOfLocationPermissionShownData) {
                                this.getAuthRequestContext = obtainStyledAttributes.getBoolean(index, this.getAuthRequestContext);
                            } else if (index == R.styleable.toHeaders) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainStyledAttributes.getInt(index, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                            } else if (index == R.styleable.isLoggedIn) {
                                this.newProxyInstance = obtainStyledAttributes.getInt(index, this.newProxyInstance);
                            } else if (index == R.styleable.setEmojiReplaceStrategy) {
                                this.FragmentBottomSheetPaymentSettingBinding = obtainStyledAttributes.getInt(index, this.FragmentBottomSheetPaymentSettingBinding);
                            } else if (index == R.styleable.plusDays) {
                                this.GetContactSyncConfig = obtainStyledAttributes.getInt(index, this.GetContactSyncConfig);
                            } else if (index == R.styleable.consultFaceAuthPopUpToBackend) {
                                TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                                if (peekValue.type == 1) {
                                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = resourceId2;
                                    if (resourceId2 != -1) {
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -2;
                                    }
                                } else if (peekValue.type == 3) {
                                    String string = obtainStyledAttributes.getString(index);
                                    this.initRecordTimeStamp = string;
                                    if (string != null && string.indexOf("/") > 0) {
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getResourceId(index, -1);
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -2;
                                    } else {
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
                                    }
                                } else {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getInteger(index, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                }
                            } else if (index == R.styleable.getExpandedTitleMarginTop) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getResourceId(index, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                            } else if (index == R.styleable.SaveFaceAuthSuggestionState_Factory) {
                                this.MyBillsEntityDataFactory = obtainStyledAttributes.getResourceId(index, this.MyBillsEntityDataFactory);
                            } else if (index == R.styleable.f13$r8$lambda$bz5qHtCn1w1Tjnl791aJH1_RVY) {
                                this.PrepareContext = obtainStyledAttributes.getResourceId(index, this.PrepareContext);
                            } else if (index == R.styleable.setMaxXAxisRange) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getResourceId(index, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                            } else if (index == R.styleable.HorizontalQuestAdapter$DividerViewHolder) {
                                this.scheduleImpl = obtainStyledAttributes.getResourceId(index, this.scheduleImpl);
                            } else if (index == R.styleable.getColorLong) {
                                this.lookAheadTest = obtainStyledAttributes.getInteger(index, this.lookAheadTest);
                            }
                        }
                        obtainStyledAttributes.recycle();
                    } else if (c == 1) {
                        this.moveToNextValue = new KeyFrames(context, xmlPullParser);
                    } else if (c == 2) {
                        this.BuiltInFictitiousFunctionClassFactory = ConstraintSet.MyBillsEntityDataFactory(context, xmlPullParser);
                    } else if (c == 3 || c == 4) {
                        ConstraintAttribute.MyBillsEntityDataFactory(context, xmlPullParser, this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
                    } else {
                        String str = DatabaseTableConfigUtil;
                        StringBuilder sb = new StringBuilder();
                        sb.append(Debug.PlaceComponentResult());
                        sb.append(" unknown tag ");
                        sb.append(name);
                        InstrumentInjector.log_e(str, sb.toString());
                        String str2 = DatabaseTableConfigUtil;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(".xml:");
                        sb2.append(xmlPullParser.getLineNumber());
                        InstrumentInjector.log_e(str2, sb2.toString());
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("ViewTransition".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException | XmlPullParserException unused) {
        }
    }

    /* loaded from: classes3.dex */
    public static class Animate {
        float BuiltInFictitiousFunctionClassFactory;
        private final int DatabaseTableConfigUtil;
        private final int GetContactSyncConfig;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        long NetworkUserEntityData$$ExternalSyntheticLambda0;
        ViewTransitionController NetworkUserEntityData$$ExternalSyntheticLambda1;
        Interpolator getAuthRequestContext;
        MotionController getErrorConfigVersion;
        int initRecordTimeStamp;
        float lookAheadTest;
        long scheduleImpl;
        KeyCache PlaceComponentResult = new KeyCache();
        boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        Rect moveToNextValue = new Rect();

        Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = viewTransitionController;
            this.getErrorConfigVersion = motionController;
            this.MyBillsEntityDataFactory = i;
            this.initRecordTimeStamp = i2;
            long nanoTime = System.nanoTime();
            this.scheduleImpl = nanoTime;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = nanoTime;
            ViewTransitionController viewTransitionController2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (viewTransitionController2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                viewTransitionController2.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
            }
            viewTransitionController2.KClassImpl$Data$declaredNonStaticMembers$2.add(this);
            this.getAuthRequestContext = interpolator;
            this.DatabaseTableConfigUtil = i4;
            this.GetContactSyncConfig = i5;
            if (i3 == 3) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            this.BuiltInFictitiousFunctionClassFactory = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                MyBillsEntityDataFactory();
            } else {
                getAuthRequestContext();
            }
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            int i = this.initRecordTimeStamp;
            if (i != -1) {
                this.BuiltInFictitiousFunctionClassFactory = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.invalidate();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = System.nanoTime();
        }

        public final void MyBillsEntityDataFactory() {
            long nanoTime = System.nanoTime();
            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = nanoTime;
            float f = this.lookAheadTest;
            double d = nanoTime - j;
            Double.isNaN(d);
            float f2 = f - (((float) (d * 1.0E-6d)) * this.BuiltInFictitiousFunctionClassFactory);
            this.lookAheadTest = f2;
            if (f2 < 0.0f) {
                this.lookAheadTest = 0.0f;
            }
            Interpolator interpolator = this.getAuthRequestContext;
            float interpolation = interpolator == null ? this.lookAheadTest : interpolator.getInterpolation(this.lookAheadTest);
            MotionController motionController = this.getErrorConfigVersion;
            boolean BuiltInFictitiousFunctionClassFactory = motionController.BuiltInFictitiousFunctionClassFactory(motionController.getSupportButtonTintMode, interpolation, nanoTime, this.PlaceComponentResult);
            if (this.lookAheadTest <= 0.0f) {
                if (this.DatabaseTableConfigUtil != -1) {
                    this.getErrorConfigVersion.getSupportButtonTintMode.setTag(this.DatabaseTableConfigUtil, Long.valueOf(System.nanoTime()));
                }
                if (this.GetContactSyncConfig != -1) {
                    this.getErrorConfigVersion.getSupportButtonTintMode.setTag(this.GetContactSyncConfig, null);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory.add(this);
            }
            if (this.lookAheadTest > 0.0f || BuiltInFictitiousFunctionClassFactory) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.invalidate();
            }
        }

        public final void getAuthRequestContext() {
            long nanoTime = System.nanoTime();
            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = nanoTime;
            float f = this.lookAheadTest;
            double d = nanoTime - j;
            Double.isNaN(d);
            float f2 = f + (((float) (d * 1.0E-6d)) * this.BuiltInFictitiousFunctionClassFactory);
            this.lookAheadTest = f2;
            if (f2 >= 1.0f) {
                this.lookAheadTest = 1.0f;
            }
            Interpolator interpolator = this.getAuthRequestContext;
            float interpolation = interpolator == null ? this.lookAheadTest : interpolator.getInterpolation(this.lookAheadTest);
            MotionController motionController = this.getErrorConfigVersion;
            boolean BuiltInFictitiousFunctionClassFactory = motionController.BuiltInFictitiousFunctionClassFactory(motionController.getSupportButtonTintMode, interpolation, nanoTime, this.PlaceComponentResult);
            if (this.lookAheadTest >= 1.0f) {
                if (this.DatabaseTableConfigUtil != -1) {
                    this.getErrorConfigVersion.getSupportButtonTintMode.setTag(this.DatabaseTableConfigUtil, Long.valueOf(System.nanoTime()));
                }
                if (this.GetContactSyncConfig != -1) {
                    this.getErrorConfigVersion.getSupportButtonTintMode.setTag(this.GetContactSyncConfig, null);
                }
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory.add(this);
                }
            }
            if (this.lookAheadTest < 1.0f || BuiltInFictitiousFunctionClassFactory) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.invalidate();
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i, ConstraintSet constraintSet, final View... viewArr) {
        if (this.getAuthRequestContext) {
            return;
        }
        int i2 = this.GetContactSyncConfig;
        Interpolator interpolator = null;
        if (i2 == 2) {
            View view = viewArr[0];
            MotionController motionController = new MotionController(view);
            motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.isLayoutRequested = 0.0f;
            motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.PrepareContext = 0.0f;
            motionController.PrepareContext = true;
            MotionPaths motionPaths = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5;
            float x = view.getX();
            float y = view.getY();
            float width = view.getWidth();
            float height = view.getHeight();
            motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 = x;
            motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 = y;
            motionPaths.newProxyInstance = width;
            motionPaths.PlaceComponentResult = height;
            MotionPaths motionPaths2 = motionController.moveToNextValue;
            float x2 = view.getX();
            float y2 = view.getY();
            float width2 = view.getWidth();
            float height2 = view.getHeight();
            motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7 = x2;
            motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8 = y2;
            motionPaths2.newProxyInstance = width2;
            motionPaths2.PlaceComponentResult = height2;
            motionController.NetworkUserEntityData$$ExternalSyntheticLambda3.KClassImpl$Data$declaredNonStaticMembers$2(view);
            motionController.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(view);
            ArrayList<Key> arrayList = this.moveToNextValue.PlaceComponentResult.get(-1);
            if (arrayList != null) {
                motionController.NetworkUserEntityData$$ExternalSyntheticLambda1.addAll(arrayList);
            }
            motionController.PlaceComponentResult(motionLayout.getWidth(), motionLayout.getHeight(), System.nanoTime());
            int i3 = this.newProxyInstance;
            int i4 = this.FragmentBottomSheetPaymentSettingBinding;
            int i5 = this.getErrorConfigVersion;
            Context context = motionLayout.getContext();
            int i6 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (i6 == -2) {
                interpolator = AnimationUtils.loadInterpolator(context, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            } else if (i6 == -1) {
                final Easing PlaceComponentResult = Easing.PlaceComponentResult(this.initRecordTimeStamp);
                interpolator = new Interpolator() { // from class: androidx.constraintlayout.motion.widget.ViewTransition.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f) {
                        return (float) PlaceComponentResult.getAuthRequestContext(f);
                    }
                };
            } else if (i6 == 0) {
                interpolator = new AccelerateDecelerateInterpolator();
            } else if (i6 == 1) {
                interpolator = new AccelerateInterpolator();
            } else if (i6 == 2) {
                interpolator = new DecelerateInterpolator();
            } else if (i6 == 4) {
                interpolator = new BounceInterpolator();
            } else if (i6 == 5) {
                interpolator = new OvershootInterpolator();
            } else if (i6 == 6) {
                interpolator = new AnticipateInterpolator();
            }
            new Animate(viewTransitionController, motionController, i3, i4, i5, interpolator, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory);
            return;
        }
        if (i2 == 1) {
            for (int i7 : motionLayout.getConstraintSetIds()) {
                if (i7 != i) {
                    ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i7);
                    for (View view2 : viewArr) {
                        int id2 = view2.getId();
                        ConstraintSet.Constraint constraint = constraintSet2.getAuthRequestContext.containsKey(Integer.valueOf(id2)) ? constraintSet2.getAuthRequestContext.get(Integer.valueOf(id2)) : null;
                        ConstraintSet.Constraint constraint2 = this.BuiltInFictitiousFunctionClassFactory;
                        if (constraint2 != null) {
                            ConstraintSet.Constraint.Delta delta = constraint2.MyBillsEntityDataFactory;
                            if (delta != null) {
                                delta.getAuthRequestContext(constraint);
                            }
                            constraint.PlaceComponentResult.putAll(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
                        }
                    }
                }
            }
        }
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.KClassImpl$Data$declaredNonStaticMembers$2(constraintSet);
        for (View view3 : viewArr) {
            int id3 = view3.getId();
            ConstraintSet.Constraint constraint3 = constraintSet3.getAuthRequestContext.containsKey(Integer.valueOf(id3)) ? constraintSet3.getAuthRequestContext.get(Integer.valueOf(id3)) : null;
            ConstraintSet.Constraint constraint4 = this.BuiltInFictitiousFunctionClassFactory;
            if (constraint4 != null) {
                ConstraintSet.Constraint.Delta delta2 = constraint4.MyBillsEntityDataFactory;
                if (delta2 != null) {
                    delta2.getAuthRequestContext(constraint3);
                }
                constraint3.PlaceComponentResult.putAll(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
            }
        }
        motionLayout.updateState(i, constraintSet3);
        motionLayout.updateState(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a1ba7, constraintSet);
        motionLayout.setState(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a1ba7, -1, -1);
        MotionScene.Transition transition = new MotionScene.Transition(motionLayout.mScene, R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a1ba7, i);
        for (View view4 : viewArr) {
            int i8 = this.newProxyInstance;
            if (i8 != -1) {
                transition.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.max(i8, 8);
            }
            transition.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int i9 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            String str = this.initRecordTimeStamp;
            int i10 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            transition.PlaceComponentResult = i9;
            transition.lookAheadTest = str;
            transition.BuiltInFictitiousFunctionClassFactory = i10;
            int id4 = view4.getId();
            KeyFrames keyFrames = this.moveToNextValue;
            if (keyFrames != null) {
                ArrayList<Key> arrayList2 = keyFrames.PlaceComponentResult.get(-1);
                KeyFrames keyFrames2 = new KeyFrames();
                Iterator<Key> it = arrayList2.iterator();
                while (it.hasNext()) {
                    Key clone = it.next().clone();
                    clone.KClassImpl$Data$declaredNonStaticMembers$2 = id4;
                    keyFrames2.KClassImpl$Data$declaredNonStaticMembers$2(clone);
                }
                transition.moveToNextValue.add(keyFrames2);
            }
        }
        motionLayout.setTransition(transition);
        motionLayout.transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.ViewTransition$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ViewTransition viewTransition = ViewTransition.this;
                View[] viewArr2 = viewArr;
                if (viewTransition.NetworkUserEntityData$$ExternalSyntheticLambda0 != -1) {
                    for (View view5 : viewArr2) {
                        view5.setTag(viewTransition.NetworkUserEntityData$$ExternalSyntheticLambda0, Long.valueOf(System.nanoTime()));
                    }
                }
                if (viewTransition.MyBillsEntityDataFactory != -1) {
                    for (View view6 : viewArr2) {
                        view6.setTag(viewTransition.MyBillsEntityDataFactory, null);
                    }
                }
            }
        });
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda5 == -1 && this.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) && PlaceComponentResult(view)) {
            if (view.getId() == this.NetworkUserEntityData$$ExternalSyntheticLambda5) {
                return true;
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda6 != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).DatabaseTableConfigUtil) != null && str.matches(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = this.getErrorConfigVersion;
        return i2 == 1 ? i == 0 : i2 == 2 ? i == 1 : i2 == 3 && i == 0;
    }

    public final boolean MyBillsEntityDataFactory() {
        return !this.getAuthRequestContext;
    }

    public final boolean PlaceComponentResult(View view) {
        int i = this.PrepareContext;
        boolean z = i == -1 || view.getTag(i) != null;
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        return z && (i2 == -1 || view.getTag(i2) == null);
    }
}
