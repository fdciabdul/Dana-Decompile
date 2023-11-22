package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.Oscillator;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MotionController {
    float BuiltInFictitiousFunctionClassFactory;
    private HashMap<String, ViewTimeCycle> C;
    KeyTrigger[] DatabaseTableConfigUtil;
    double[] GetContactSyncConfig;
    HashMap<String, ViewSpline> KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    int[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    CurveFit[] NetworkUserEntityData$$ExternalSyntheticLambda7;
    float PlaceComponentResult;
    CurveFit getAuthRequestContext;
    private String[] getCallingPid;
    int getErrorConfigVersion;
    View getSupportButtonTintMode;
    double[] initRecordTimeStamp;
    HashMap<String, ViewOscillator> lookAheadTest;
    private int[] whenAvailable;
    Rect FragmentBottomSheetPaymentSettingBinding = new Rect();
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    private int B = -1;
    public MotionPaths NetworkUserEntityData$$ExternalSyntheticLambda5 = new MotionPaths();
    public MotionPaths moveToNextValue = new MotionPaths();
    MotionConstrainedPoint NetworkUserEntityData$$ExternalSyntheticLambda3 = new MotionConstrainedPoint();
    MotionConstrainedPoint scheduleImpl = new MotionConstrainedPoint();
    float isLayoutRequested = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda4 = 0.0f;
    float NetworkUserEntityData$$ExternalSyntheticLambda6 = 1.0f;
    private int SubSequence = 4;
    private float[] getValueOfTouchPositionAbsolute = new float[4];
    ArrayList<MotionPaths> newProxyInstance = new ArrayList<>();
    float[] readMicros = new float[1];
    public ArrayList<Key> NetworkUserEntityData$$ExternalSyntheticLambda1 = new ArrayList<>();
    int NetworkUserEntityData$$ExternalSyntheticLambda8 = Key.PlaceComponentResult;
    private int E = Key.PlaceComponentResult;
    private View getOnBoardingScenario = null;
    private int VerifyPinStateManager$executeRiskChallenge$2$1 = Key.PlaceComponentResult;
    private float A = Float.NaN;
    private Interpolator BottomSheetCardBindingView$watcherCardNumberView$1 = null;
    boolean PrepareContext = false;

    public MotionController(View view) {
        this.getSupportButtonTintMode = view;
        this.getErrorConfigVersion = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.MyBillsEntityDataFactory = ((ConstraintLayout.LayoutParams) layoutParams).DatabaseTableConfigUtil;
        }
    }

    public final void MyBillsEntityDataFactory(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7[0].getAuthRequestContext(d, dArr);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7[0].PlaceComponentResult(d, dArr2);
        float f = 0.0f;
        Arrays.fill(fArr2, 0.0f);
        MotionPaths motionPaths = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        float f2 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
        float f3 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
        float f4 = motionPaths.newProxyInstance;
        float f5 = motionPaths.PlaceComponentResult;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f9 = (float) dArr[i];
            float f10 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f2 = f9;
                f = f10;
            } else if (i2 == 2) {
                f3 = f9;
                f6 = f10;
            } else if (i2 == 3) {
                f4 = f9;
                f7 = f10;
            } else if (i2 == 4) {
                f5 = f9;
                f8 = f10;
            }
        }
        float f11 = 2.0f;
        float f12 = (f7 / 2.0f) + f;
        float f13 = (f8 / 2.0f) + f6;
        MotionController motionController = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.MyBillsEntityDataFactory(d, fArr3, fArr4);
            float f14 = fArr3[0];
            float f15 = fArr3[1];
            float f16 = fArr4[0];
            float f17 = fArr4[1];
            double d2 = f14;
            double d3 = f2;
            double d4 = f3;
            double sin = Math.sin(d4);
            double d5 = f4 / 2.0f;
            Double.isNaN(d3);
            Double.isNaN(d2);
            Double.isNaN(d5);
            float f18 = (float) ((d2 + (sin * d3)) - d5);
            double d6 = f15;
            double cos = Math.cos(d4);
            double d7 = f5 / 2.0f;
            Double.isNaN(d3);
            Double.isNaN(d6);
            Double.isNaN(d7);
            float f19 = (float) ((d6 - (d3 * cos)) - d7);
            double d8 = f16;
            double d9 = f;
            double sin2 = Math.sin(d4);
            double cos2 = Math.cos(d4);
            double d10 = f6;
            Double.isNaN(d9);
            Double.isNaN(d8);
            Double.isNaN(d10);
            float f20 = (float) (d8 + (sin2 * d9) + (cos2 * d10));
            double d11 = f17;
            double cos3 = Math.cos(d4);
            double sin3 = Math.sin(d4);
            Double.isNaN(d9);
            Double.isNaN(d11);
            Double.isNaN(d10);
            f3 = f19;
            f13 = (float) ((d11 - (d9 * cos3)) + (sin3 * d10));
            f2 = f18;
            f11 = 2.0f;
            f12 = f20;
        }
        fArr[0] = f2 + (f4 / f11) + 0.0f;
        fArr[1] = f3 + (f5 / f11) + 0.0f;
        fArr2[0] = f12;
        fArr2[1] = f13;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void PlaceComponentResult(int i, int i2, long j) {
        String str;
        String str2;
        ArrayList arrayList;
        float f;
        int i3;
        double[] dArr;
        ViewOscillator viewOscillator;
        Iterator<Key> it;
        Object obj;
        Object obj2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        char c;
        float f2;
        float f3;
        ViewOscillator viewOscillator2;
        Iterator<String> it2;
        String str10;
        double d;
        String str11;
        String str12;
        double[] dArr2;
        double[][] dArr3;
        int i4;
        float[] fArr;
        ConstraintAttribute constraintAttribute;
        HashMap<String, ViewTimeCycle> hashMap;
        Iterator<String> it3;
        Object obj3;
        Object obj4;
        String str13;
        String str14;
        char c2;
        Iterator<String> it4;
        ViewTimeCycle MyBillsEntityDataFactory;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        Iterator<String> it5;
        ViewSpline KClassImpl$Data$declaredNonStaticMembers$2;
        ConstraintAttribute constraintAttribute3;
        Iterator<Key> it6;
        String str15;
        String str16;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != Key.PlaceComponentResult) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        MotionConstrainedPoint motionConstrainedPoint = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        MotionConstrainedPoint motionConstrainedPoint2 = this.scheduleImpl;
        String str17 = "alpha";
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.getAuthRequestContext, motionConstrainedPoint2.getAuthRequestContext)) {
            hashSet2.add("alpha");
        }
        String str18 = "elevation";
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.PlaceComponentResult, motionConstrainedPoint2.PlaceComponentResult)) {
            hashSet2.add("elevation");
        }
        int i5 = motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda3;
        int i6 = motionConstrainedPoint2.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (i5 != i6 && motionConstrainedPoint.GetContactSyncConfig == 0 && (i5 == 0 || i6 == 0)) {
            hashSet2.add("alpha");
        }
        String str19 = "rotation";
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.initRecordTimeStamp, motionConstrainedPoint2.initRecordTimeStamp)) {
            hashSet2.add("rotation");
        }
        String str20 = "transitionPathRotate";
        if (!Float.isNaN(motionConstrainedPoint.lookAheadTest) || !Float.isNaN(motionConstrainedPoint2.lookAheadTest)) {
            hashSet2.add("transitionPathRotate");
        }
        String str21 = "progress";
        if (!Float.isNaN(motionConstrainedPoint.getErrorConfigVersion) || !Float.isNaN(motionConstrainedPoint2.getErrorConfigVersion)) {
            hashSet2.add("progress");
        }
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda1, motionConstrainedPoint2.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            hashSet2.add("rotationX");
        }
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.isLayoutRequested, motionConstrainedPoint2.isLayoutRequested)) {
            hashSet2.add("rotationY");
        }
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda0, motionConstrainedPoint2.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            hashSet2.add("transformPivotX");
        }
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.scheduleImpl, motionConstrainedPoint2.scheduleImpl)) {
            hashSet2.add("transformPivotY");
        }
        String str22 = "scaleX";
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.PrepareContext, motionConstrainedPoint2.PrepareContext)) {
            hashSet2.add("scaleX");
        }
        Object obj5 = "rotationX";
        String str23 = "scaleY";
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda8, motionConstrainedPoint2.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            hashSet2.add("scaleY");
        }
        Object obj6 = "rotationY";
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda7, motionConstrainedPoint2.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            hashSet2.add("translationX");
        }
        Object obj7 = "translationX";
        String str24 = "translationY";
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.newProxyInstance, motionConstrainedPoint2.newProxyInstance)) {
            hashSet2.add("translationY");
        }
        if (MotionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2(motionConstrainedPoint.FragmentBottomSheetPaymentSettingBinding, motionConstrainedPoint2.FragmentBottomSheetPaymentSettingBinding)) {
            hashSet2.add("translationZ");
        }
        ArrayList<Key> arrayList2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (arrayList2 != null) {
            Iterator<Key> it7 = arrayList2.iterator();
            ArrayList arrayList3 = null;
            while (it7.hasNext()) {
                Key next = it7.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    it6 = it7;
                    str16 = str24;
                    MotionPaths motionPaths = new MotionPaths(i, i2, keyPosition, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.moveToNextValue);
                    int binarySearch = Collections.binarySearch(this.newProxyInstance, motionPaths);
                    if (binarySearch == 0) {
                        StringBuilder sb = new StringBuilder();
                        str15 = str21;
                        sb.append(" KeyPath position \"");
                        sb.append(motionPaths.PrepareContext);
                        sb.append("\" outside of range");
                        InstrumentInjector.log_e("MotionController", sb.toString());
                    } else {
                        str15 = str21;
                    }
                    this.newProxyInstance.add((-binarySearch) - 1, motionPaths);
                    if (keyPosition.newProxyInstance != Key.PlaceComponentResult) {
                        this.B = keyPosition.newProxyInstance;
                    }
                } else {
                    it6 = it7;
                    str15 = str21;
                    str16 = str24;
                    if (next instanceof KeyCycle) {
                        next.PlaceComponentResult(hashSet3);
                    } else if (next instanceof KeyTimeCycle) {
                        next.PlaceComponentResult(hashSet);
                    } else if (next instanceof KeyTrigger) {
                        ArrayList arrayList4 = arrayList3 == null ? new ArrayList() : arrayList3;
                        arrayList4.add((KeyTrigger) next);
                        arrayList3 = arrayList4;
                    } else {
                        next.MyBillsEntityDataFactory(hashMap2);
                        next.PlaceComponentResult(hashSet2);
                    }
                }
                str21 = str15;
                it7 = it6;
                str24 = str16;
            }
            str = str21;
            str2 = str24;
            arrayList = arrayList3;
        } else {
            str = "progress";
            str2 = "translationY";
            arrayList = null;
        }
        if (arrayList != null) {
            this.DatabaseTableConfigUtil = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap<>();
            Iterator<String> it8 = hashSet2.iterator();
            while (it8.hasNext()) {
                String next2 = it8.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str25 = next2.split(",")[1];
                    Iterator<Key> it9 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.iterator();
                    while (it9.hasNext()) {
                        Iterator<String> it10 = it8;
                        Key next3 = it9.next();
                        Iterator<Key> it11 = it9;
                        if (next3.MyBillsEntityDataFactory != null && (constraintAttribute3 = next3.MyBillsEntityDataFactory.get(str25)) != null) {
                            sparseArray.append(next3.BuiltInFictitiousFunctionClassFactory, constraintAttribute3);
                        }
                        it8 = it10;
                        it9 = it11;
                    }
                    it5 = it8;
                    KClassImpl$Data$declaredNonStaticMembers$2 = ViewSpline.PlaceComponentResult(next2, sparseArray);
                } else {
                    it5 = it8;
                    KClassImpl$Data$declaredNonStaticMembers$2 = ViewSpline.KClassImpl$Data$declaredNonStaticMembers$2(next2);
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = next2;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.put(next2, KClassImpl$Data$declaredNonStaticMembers$2);
                }
                it8 = it5;
            }
            ArrayList<Key> arrayList5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (arrayList5 != null) {
                Iterator<Key> it12 = arrayList5.iterator();
                while (it12.hasNext()) {
                    Key next4 = it12.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 0);
            this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 100);
            for (String str26 : this.KClassImpl$Data$declaredNonStaticMembers$2.keySet()) {
                int intValue = (!hashMap2.containsKey(str26) || (num = hashMap2.get(str26)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.KClassImpl$Data$declaredNonStaticMembers$2.get(str26);
                if (viewSpline != null) {
                    viewSpline.MyBillsEntityDataFactory(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.C == null) {
                this.C = new HashMap<>();
            }
            Iterator<String> it13 = hashSet.iterator();
            while (it13.hasNext()) {
                String next5 = it13.next();
                if (!this.C.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str27 = next5.split(",")[1];
                        Iterator<Key> it14 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.iterator();
                        while (it14.hasNext()) {
                            Key next6 = it14.next();
                            Iterator<String> it15 = it13;
                            if (next6.MyBillsEntityDataFactory != null && (constraintAttribute2 = next6.MyBillsEntityDataFactory.get(str27)) != null) {
                                sparseArray2.append(next6.BuiltInFictitiousFunctionClassFactory, constraintAttribute2);
                            }
                            it13 = it15;
                        }
                        it4 = it13;
                        MyBillsEntityDataFactory = ViewTimeCycle.getAuthRequestContext(next5, sparseArray2);
                    } else {
                        it4 = it13;
                        MyBillsEntityDataFactory = ViewTimeCycle.MyBillsEntityDataFactory(next5, j);
                    }
                    if (MyBillsEntityDataFactory != null) {
                        MyBillsEntityDataFactory.PlaceComponentResult(next5);
                        this.C.put(next5, MyBillsEntityDataFactory);
                    }
                    it13 = it4;
                }
            }
            ArrayList<Key> arrayList6 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (arrayList6 != null) {
                Iterator<Key> it16 = arrayList6.iterator();
                while (it16.hasNext()) {
                    Key next7 = it16.next();
                    if (next7 instanceof KeyTimeCycle) {
                        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) next7;
                        HashMap<String, ViewTimeCycle> hashMap3 = this.C;
                        Iterator<String> it17 = hashMap3.keySet().iterator();
                        while (it17.hasNext()) {
                            String next8 = it17.next();
                            ViewTimeCycle viewTimeCycle = hashMap3.get(next8);
                            if (viewTimeCycle != null) {
                                if (next8.startsWith("CUSTOM")) {
                                    ConstraintAttribute constraintAttribute4 = keyTimeCycle.MyBillsEntityDataFactory.get(next8.substring(7));
                                    if (constraintAttribute4 != null) {
                                        hashMap = hashMap3;
                                        ((ViewTimeCycle.CustomSet) viewTimeCycle).getAuthRequestContext(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, constraintAttribute4, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                        it16 = it16;
                                        hashMap3 = hashMap;
                                    }
                                } else {
                                    Iterator<Key> it18 = it16;
                                    hashMap = hashMap3;
                                    next8.hashCode();
                                    switch (next8.hashCode()) {
                                        case -1249320806:
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            if (next8.equals(obj3)) {
                                                c2 = 0;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -1249320805:
                                            it3 = it17;
                                            Object obj8 = obj6;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            if (next8.equals(obj8)) {
                                                obj6 = obj8;
                                                obj3 = obj5;
                                                c2 = 1;
                                                break;
                                            } else {
                                                obj6 = obj8;
                                                obj3 = obj5;
                                                c2 = 65535;
                                                break;
                                            }
                                        case -1225497657:
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            it3 = it17;
                                            obj3 = obj5;
                                            if (next8.equals(obj4)) {
                                                c2 = 2;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -1225497656:
                                            str13 = str;
                                            str14 = str2;
                                            it3 = it17;
                                            obj3 = obj5;
                                            if (next8.equals(str14)) {
                                                obj4 = obj7;
                                                c2 = 3;
                                                break;
                                            } else {
                                                obj4 = obj7;
                                                c2 = 65535;
                                                break;
                                            }
                                        case -1225497655:
                                            str13 = str;
                                            if (next8.equals("translationZ")) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str14 = str2;
                                                c2 = 4;
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        case -1001078227:
                                            str13 = str;
                                            if (next8.equals(str13)) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str14 = str2;
                                                c2 = 5;
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        case -908189618:
                                            if (next8.equals("scaleX")) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str13 = str;
                                                str14 = str2;
                                                c2 = 6;
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        case -908189617:
                                            if (next8.equals("scaleY")) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str13 = str;
                                                str14 = str2;
                                                c2 = 7;
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        case -40300674:
                                            if (next8.equals("rotation")) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str13 = str;
                                                str14 = str2;
                                                c2 = '\b';
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        case -4379043:
                                            if (next8.equals("elevation")) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str13 = str;
                                                str14 = str2;
                                                c2 = '\t';
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        case 37232917:
                                            if (next8.equals("transitionPathRotate")) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str13 = str;
                                                str14 = str2;
                                                c2 = '\n';
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        case 92909918:
                                            if (next8.equals("alpha")) {
                                                it3 = it17;
                                                obj3 = obj5;
                                                obj4 = obj7;
                                                str13 = str;
                                                str14 = str2;
                                                c2 = 11;
                                                break;
                                            }
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                        default:
                                            it3 = it17;
                                            obj3 = obj5;
                                            obj4 = obj7;
                                            str13 = str;
                                            str14 = str2;
                                            c2 = 65535;
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.initRecordTimeStamp)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.initRecordTimeStamp, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 1:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.DatabaseTableConfigUtil)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.DatabaseTableConfigUtil, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 2:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda7, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 3:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.newProxyInstance)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.newProxyInstance, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 4:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.PrepareContext)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.PrepareContext, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 5:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda0, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 6:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.GetContactSyncConfig)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.GetContactSyncConfig, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 7:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda1, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case '\b':
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.lookAheadTest)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.lookAheadTest, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case '\t':
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.moveToNextValue)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.moveToNextValue, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case '\n':
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            if (!Float.isNaN(keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda2, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                            }
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                        case 11:
                                            if (Float.isNaN(keyTimeCycle.getErrorConfigVersion)) {
                                                str = str13;
                                                str2 = str14;
                                                obj5 = obj3;
                                                obj7 = obj4;
                                                hashMap3 = hashMap;
                                                it16 = it18;
                                                it17 = it3;
                                                break;
                                            } else {
                                                obj5 = obj3;
                                                obj7 = obj4;
                                                str2 = str14;
                                                str = str13;
                                                viewTimeCycle.MyBillsEntityDataFactory(keyTimeCycle.BuiltInFictitiousFunctionClassFactory, keyTimeCycle.getErrorConfigVersion, keyTimeCycle.isLayoutRequested, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                                it16 = it18;
                                                it17 = it3;
                                                hashMap3 = hashMap;
                                                break;
                                            }
                                        default:
                                            str = str13;
                                            str2 = str14;
                                            obj5 = obj3;
                                            obj7 = obj4;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("UNKNOWN addValues \"");
                                            sb2.append(next8);
                                            sb2.append("\"");
                                            InstrumentInjector.log_e("KeyTimeCycles", sb2.toString());
                                            it16 = it18;
                                            it17 = it3;
                                            hashMap3 = hashMap;
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (String str28 : this.C.keySet()) {
                this.C.get(str28).PlaceComponentResult(hashMap2.containsKey(str28) ? hashMap2.get(str28).intValue() : 0);
            }
        }
        int size = this.newProxyInstance.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        motionPathsArr[size - 1] = this.moveToNextValue;
        if (this.newProxyInstance.size() > 0 && this.B == -1) {
            this.B = 0;
        }
        Iterator<MotionPaths> it19 = this.newProxyInstance.iterator();
        int i7 = 1;
        while (it19.hasNext()) {
            motionPathsArr[i7] = it19.next();
            i7++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str29 : this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.keySet()) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda5.BuiltInFictitiousFunctionClassFactory.containsKey(str29)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CUSTOM,");
                sb3.append(str29);
                if (!hashSet2.contains(sb3.toString())) {
                    hashSet4.add(str29);
                }
            }
        }
        String[] strArr = (String[]) hashSet4.toArray(new String[0]);
        this.getCallingPid = strArr;
        this.whenAvailable = new int[strArr.length];
        int i8 = 0;
        while (true) {
            String[] strArr2 = this.getCallingPid;
            if (i8 < strArr2.length) {
                String str30 = strArr2[i8];
                this.whenAvailable[i8] = 0;
                int i9 = 0;
                while (true) {
                    if (i9 >= size) {
                        break;
                    } else if (!motionPathsArr[i9].BuiltInFictitiousFunctionClassFactory.containsKey(str30) || (constraintAttribute = motionPathsArr[i9].BuiltInFictitiousFunctionClassFactory.get(str30)) == null) {
                        i9++;
                    } else {
                        int[] iArr = this.whenAvailable;
                        int i10 = iArr[i8];
                        int i11 = ConstraintAttribute.AnonymousClass1.PlaceComponentResult[constraintAttribute.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
                        iArr[i8] = i10 + ((i11 == 4 || i11 == 5) ? 4 : 1);
                    }
                }
                i8++;
            } else {
                boolean z = motionPathsArr[0].scheduleImpl != Key.PlaceComponentResult;
                int length = this.getCallingPid.length + 18;
                boolean[] zArr = new boolean[length];
                int i12 = 1;
                while (i12 < size) {
                    MotionPaths motionPaths2 = motionPathsArr[i12];
                    MotionPaths motionPaths3 = motionPathsArr[i12 - 1];
                    String str31 = str23;
                    boolean KClassImpl$Data$declaredNonStaticMembers$22 = MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7, motionPaths3.NetworkUserEntityData$$ExternalSyntheticLambda7);
                    String str32 = str19;
                    boolean KClassImpl$Data$declaredNonStaticMembers$23 = MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8, motionPaths3.NetworkUserEntityData$$ExternalSyntheticLambda8);
                    zArr[0] = zArr[0] | MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(motionPaths2.PrepareContext, motionPaths3.PrepareContext);
                    boolean z2 = KClassImpl$Data$declaredNonStaticMembers$23 | KClassImpl$Data$declaredNonStaticMembers$22 | z;
                    zArr[1] = zArr[1] | z2;
                    zArr[2] = z2 | zArr[2];
                    zArr[3] = zArr[3] | MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(motionPaths2.newProxyInstance, motionPaths3.newProxyInstance);
                    zArr[4] = zArr[4] | MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(motionPaths2.PlaceComponentResult, motionPaths3.PlaceComponentResult);
                    i12++;
                    str22 = str22;
                    str23 = str31;
                    str19 = str32;
                    str18 = str18;
                }
                String str33 = str18;
                String str34 = str19;
                String str35 = str23;
                String str36 = str22;
                int i13 = 0;
                for (int i14 = 1; i14 < length; i14++) {
                    if (zArr[i14]) {
                        i13++;
                    }
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new int[i13];
                int max = Math.max(2, i13);
                this.initRecordTimeStamp = new double[max];
                this.GetContactSyncConfig = new double[max];
                int i15 = 0;
                for (int i16 = 1; i16 < length; i16++) {
                    if (zArr[i16]) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2[i15] = i16;
                        i15++;
                    }
                }
                double[][] dArr4 = (double[][]) Array.newInstance(Double.TYPE, size, this.NetworkUserEntityData$$ExternalSyntheticLambda2.length);
                double[] dArr5 = new double[size];
                for (int i17 = 0; i17 < size; i17++) {
                    MotionPaths motionPaths4 = motionPathsArr[i17];
                    double[] dArr6 = dArr4[i17];
                    int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    float[] fArr2 = {motionPaths4.PrepareContext, motionPaths4.NetworkUserEntityData$$ExternalSyntheticLambda7, motionPaths4.NetworkUserEntityData$$ExternalSyntheticLambda8, motionPaths4.newProxyInstance, motionPaths4.PlaceComponentResult, motionPaths4.NetworkUserEntityData$$ExternalSyntheticLambda0};
                    int i18 = 0;
                    int i19 = 0;
                    while (i18 < iArr2.length) {
                        if (iArr2[i18] < 6) {
                            fArr = fArr2;
                            dArr6[i19] = fArr2[r14];
                            i19++;
                        } else {
                            fArr = fArr2;
                        }
                        i18++;
                        fArr2 = fArr;
                    }
                    dArr5[i17] = motionPathsArr[i17].isLayoutRequested;
                }
                int i20 = 0;
                while (true) {
                    int[] iArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (i20 < iArr3.length) {
                        if (iArr3[i20] < MotionPaths.MyBillsEntityDataFactory.length) {
                            String str37 = MotionPaths.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda2[i20]];
                            for (int i21 = 0; i21 < size; i21++) {
                                double d2 = dArr4[i21][i20];
                            }
                        }
                        i20++;
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new CurveFit[this.getCallingPid.length + 1];
                        int i22 = 0;
                        while (true) {
                            String[] strArr3 = this.getCallingPid;
                            if (i22 < strArr3.length) {
                                String str38 = strArr3[i22];
                                int i23 = 0;
                                int i24 = 0;
                                double[] dArr7 = null;
                                double[][] dArr8 = null;
                                while (i23 < size) {
                                    if (motionPathsArr[i23].BuiltInFictitiousFunctionClassFactory(str38)) {
                                        if (dArr8 == null) {
                                            dArr7 = new double[size];
                                            ConstraintAttribute constraintAttribute5 = motionPathsArr[i23].BuiltInFictitiousFunctionClassFactory.get(str38);
                                            if (constraintAttribute5 == null) {
                                                i4 = 0;
                                            } else {
                                                int i25 = ConstraintAttribute.AnonymousClass1.PlaceComponentResult[constraintAttribute5.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
                                                i4 = (i25 == 4 || i25 == 5) ? 4 : 1;
                                            }
                                            dArr8 = (double[][]) Array.newInstance(Double.TYPE, size, i4);
                                        }
                                        dArr7[i24] = motionPathsArr[i23].isLayoutRequested;
                                        MotionPaths motionPaths5 = motionPathsArr[i23];
                                        double[] dArr9 = dArr8[i24];
                                        ConstraintAttribute constraintAttribute6 = motionPaths5.BuiltInFictitiousFunctionClassFactory.get(str38);
                                        if (constraintAttribute6 != null) {
                                            str12 = str38;
                                            int i26 = ConstraintAttribute.AnonymousClass1.PlaceComponentResult[constraintAttribute6.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
                                            dArr2 = dArr7;
                                            if (((i26 == 4 || i26 == 5) ? (char) 4 : (char) 1) == 1) {
                                                dArr3 = dArr8;
                                                dArr9[0] = constraintAttribute6.PlaceComponentResult();
                                            } else {
                                                dArr3 = dArr8;
                                                int i27 = ConstraintAttribute.AnonymousClass1.PlaceComponentResult[constraintAttribute6.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
                                                int i28 = (i27 == 4 || i27 == 5) ? 4 : 1;
                                                float[] fArr3 = new float[i28];
                                                constraintAttribute6.getAuthRequestContext(fArr3);
                                                int i29 = 0;
                                                int i30 = 0;
                                                while (i29 < i28) {
                                                    dArr9[i30] = fArr3[i29];
                                                    i29++;
                                                    i30++;
                                                    fArr3 = fArr3;
                                                }
                                            }
                                        } else {
                                            str12 = str38;
                                            dArr2 = dArr7;
                                            dArr3 = dArr8;
                                        }
                                        i24++;
                                        dArr7 = dArr2;
                                        dArr8 = dArr3;
                                    } else {
                                        str12 = str38;
                                    }
                                    i23++;
                                    str38 = str12;
                                }
                                i22++;
                                this.NetworkUserEntityData$$ExternalSyntheticLambda7[i22] = CurveFit.PlaceComponentResult(this.B, Arrays.copyOf(dArr7, i24), (double[][]) Arrays.copyOf(dArr8, i24));
                            } else {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda7[0] = CurveFit.PlaceComponentResult(this.B, dArr5, dArr4);
                                if (motionPathsArr[0].scheduleImpl != Key.PlaceComponentResult) {
                                    int[] iArr4 = new int[size];
                                    double[] dArr10 = new double[size];
                                    double[][] dArr11 = (double[][]) Array.newInstance(Double.TYPE, size, 2);
                                    for (int i31 = 0; i31 < size; i31++) {
                                        iArr4[i31] = motionPathsArr[i31].scheduleImpl;
                                        dArr10[i31] = motionPathsArr[i31].isLayoutRequested;
                                        dArr11[i31][0] = motionPathsArr[i31].NetworkUserEntityData$$ExternalSyntheticLambda7;
                                        dArr11[i31][1] = motionPathsArr[i31].NetworkUserEntityData$$ExternalSyntheticLambda8;
                                    }
                                    this.getAuthRequestContext = CurveFit.KClassImpl$Data$declaredNonStaticMembers$2(iArr4, dArr10, dArr11);
                                }
                                float f4 = Float.NaN;
                                this.lookAheadTest = new HashMap<>();
                                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                                    Iterator<String> it20 = hashSet3.iterator();
                                    while (it20.hasNext()) {
                                        String next9 = it20.next();
                                        ViewOscillator BuiltInFictitiousFunctionClassFactory = ViewOscillator.BuiltInFictitiousFunctionClassFactory(next9);
                                        if (BuiltInFictitiousFunctionClassFactory != null) {
                                            if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() && Float.isNaN(f4)) {
                                                float[] fArr4 = new float[2];
                                                int i32 = 0;
                                                float f5 = 0.0f;
                                                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                                                double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                                                while (i32 < 100) {
                                                    float f6 = i32 * 0.01010101f;
                                                    String str39 = str17;
                                                    double d5 = f6;
                                                    Easing easing = this.NetworkUserEntityData$$ExternalSyntheticLambda5.moveToNextValue;
                                                    Iterator<String> it21 = it20;
                                                    Iterator<MotionPaths> it22 = this.newProxyInstance.iterator();
                                                    float f7 = Float.NaN;
                                                    float f8 = 0.0f;
                                                    while (it22.hasNext()) {
                                                        Iterator<MotionPaths> it23 = it22;
                                                        MotionPaths next10 = it22.next();
                                                        double d6 = d5;
                                                        if (next10.moveToNextValue != null) {
                                                            if (next10.isLayoutRequested < f6) {
                                                                Easing easing2 = next10.moveToNextValue;
                                                                f8 = next10.isLayoutRequested;
                                                                easing = easing2;
                                                            } else if (Float.isNaN(f7)) {
                                                                f7 = next10.isLayoutRequested;
                                                            }
                                                        }
                                                        it22 = it23;
                                                        d5 = d6;
                                                    }
                                                    double d7 = d5;
                                                    if (easing != null) {
                                                        if (Float.isNaN(f7)) {
                                                            f7 = 1.0f;
                                                        }
                                                        d = (((float) easing.getAuthRequestContext((f6 - f8) / r31)) * (f7 - f8)) + f8;
                                                    } else {
                                                        d = d7;
                                                    }
                                                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[0].getAuthRequestContext(d, this.initRecordTimeStamp);
                                                    this.NetworkUserEntityData$$ExternalSyntheticLambda5.BuiltInFictitiousFunctionClassFactory(d, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.initRecordTimeStamp, fArr4, 0);
                                                    if (i32 > 0) {
                                                        double d8 = f5;
                                                        double d9 = fArr4[1];
                                                        str11 = next9;
                                                        double d10 = fArr4[0];
                                                        Double.isNaN(d9);
                                                        Double.isNaN(d10);
                                                        double hypot = Math.hypot(d3 - d9, d4 - d10);
                                                        Double.isNaN(d8);
                                                        f5 = (float) (d8 + hypot);
                                                    } else {
                                                        str11 = next9;
                                                    }
                                                    d4 = fArr4[0];
                                                    d3 = fArr4[1];
                                                    i32++;
                                                    it20 = it21;
                                                    str17 = str39;
                                                    next9 = str11;
                                                }
                                                it2 = it20;
                                                str10 = str17;
                                                f4 = f5;
                                            } else {
                                                it2 = it20;
                                                str10 = str17;
                                                next9 = next9;
                                            }
                                            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = next9;
                                            this.lookAheadTest.put(next9, BuiltInFictitiousFunctionClassFactory);
                                            it20 = it2;
                                            str17 = str10;
                                        }
                                    }
                                    String str40 = str17;
                                    Iterator<Key> it24 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.iterator();
                                    while (it24.hasNext()) {
                                        Key next11 = it24.next();
                                        if (next11 instanceof KeyCycle) {
                                            KeyCycle keyCycle = (KeyCycle) next11;
                                            HashMap<String, ViewOscillator> hashMap4 = this.lookAheadTest;
                                            Iterator<String> it25 = hashMap4.keySet().iterator();
                                            while (it25.hasNext()) {
                                                String next12 = it25.next();
                                                if (next12.startsWith("CUSTOM")) {
                                                    ConstraintAttribute constraintAttribute7 = keyCycle.MyBillsEntityDataFactory.get(next12.substring(7));
                                                    if (constraintAttribute7 != null && constraintAttribute7.NetworkUserEntityData$$ExternalSyntheticLambda0 == ConstraintAttribute.AttributeType.FLOAT_TYPE && (viewOscillator = hashMap4.get(next12)) != null) {
                                                        viewOscillator.KClassImpl$Data$declaredNonStaticMembers$2(keyCycle.BuiltInFictitiousFunctionClassFactory, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda4, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda0, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda5, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda6, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda3, constraintAttribute7.PlaceComponentResult(), constraintAttribute7);
                                                    }
                                                } else {
                                                    next12.hashCode();
                                                    switch (next12.hashCode()) {
                                                        case -1249320806:
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            if (next12.equals(obj)) {
                                                                c = 0;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case -1249320805:
                                                            it = it24;
                                                            Object obj9 = obj6;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            if (next12.equals(obj9)) {
                                                                obj6 = obj9;
                                                                obj = obj5;
                                                                c = 1;
                                                                break;
                                                            } else {
                                                                obj6 = obj9;
                                                                obj = obj5;
                                                                c = 65535;
                                                                break;
                                                            }
                                                        case -1225497657:
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            it = it24;
                                                            obj = obj5;
                                                            if (next12.equals(obj2)) {
                                                                c = 2;
                                                                break;
                                                            }
                                                            c = 65535;
                                                            break;
                                                        case -1225497656:
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            it = it24;
                                                            obj = obj5;
                                                            if (next12.equals(str6)) {
                                                                obj2 = obj7;
                                                                c = 3;
                                                                break;
                                                            } else {
                                                                obj2 = obj7;
                                                                c = 65535;
                                                                break;
                                                            }
                                                        case -1225497655:
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            if (next12.equals("translationZ")) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str6 = str2;
                                                                c = 4;
                                                                break;
                                                            }
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str6 = str2;
                                                            c = 65535;
                                                            break;
                                                        case -1001078227:
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            if (next12.equals(str3)) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str6 = str2;
                                                                c = 5;
                                                                break;
                                                            }
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str6 = str2;
                                                            c = 65535;
                                                            break;
                                                        case -908189618:
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            if (next12.equals(str5)) {
                                                                str3 = str;
                                                                str6 = str2;
                                                                c = 6;
                                                                break;
                                                            } else {
                                                                str3 = str;
                                                                str6 = str2;
                                                                c = 65535;
                                                                break;
                                                            }
                                                        case -908189617:
                                                            str4 = str40;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            if (next12.equals(str7)) {
                                                                str5 = str36;
                                                                str6 = str2;
                                                                c = 7;
                                                                break;
                                                            } else {
                                                                str5 = str36;
                                                                str6 = str2;
                                                                c = 65535;
                                                                break;
                                                            }
                                                        case -40300674:
                                                            str4 = str40;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            if (next12.equals(str8)) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                c = '\b';
                                                                break;
                                                            } else {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                c = 65535;
                                                                break;
                                                            }
                                                        case -4379043:
                                                            str4 = str40;
                                                            str9 = str33;
                                                            if (next12.equals(str9)) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                str8 = str34;
                                                                c = '\t';
                                                                break;
                                                            } else {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                str8 = str34;
                                                                c = 65535;
                                                                break;
                                                            }
                                                        case 37232917:
                                                            str4 = str40;
                                                            if (next12.equals(str20)) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                str8 = str34;
                                                                str9 = str33;
                                                                c = '\n';
                                                                break;
                                                            }
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            c = 65535;
                                                            break;
                                                        case 92909918:
                                                            str4 = str40;
                                                            if (next12.equals(str4)) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                str8 = str34;
                                                                str9 = str33;
                                                                c = 11;
                                                                break;
                                                            }
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            c = 65535;
                                                            break;
                                                        case 156108012:
                                                            if (next12.equals("waveOffset")) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str4 = str40;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                str8 = str34;
                                                                str9 = str33;
                                                                c = '\f';
                                                                break;
                                                            }
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            c = 65535;
                                                            break;
                                                        case 1530034690:
                                                            if (next12.equals("wavePhase")) {
                                                                it = it24;
                                                                obj = obj5;
                                                                obj2 = obj7;
                                                                str3 = str;
                                                                str4 = str40;
                                                                str5 = str36;
                                                                str6 = str2;
                                                                str7 = str35;
                                                                str8 = str34;
                                                                str9 = str33;
                                                                c = '\r';
                                                                break;
                                                            }
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            c = 65535;
                                                            break;
                                                        default:
                                                            it = it24;
                                                            obj = obj5;
                                                            obj2 = obj7;
                                                            str3 = str;
                                                            str4 = str40;
                                                            str5 = str36;
                                                            str6 = str2;
                                                            str7 = str35;
                                                            str8 = str34;
                                                            str9 = str33;
                                                            c = 65535;
                                                            break;
                                                    }
                                                    switch (c) {
                                                        case 0:
                                                            obj5 = obj;
                                                            f2 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 1:
                                                            obj5 = obj;
                                                            f2 = keyCycle.DatabaseTableConfigUtil;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 2:
                                                            obj5 = obj;
                                                            f2 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda8;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 3:
                                                            obj5 = obj;
                                                            f2 = keyCycle.isLayoutRequested;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 4:
                                                            obj5 = obj;
                                                            f2 = keyCycle.PrepareContext;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 5:
                                                            obj5 = obj;
                                                            f2 = keyCycle.getErrorConfigVersion;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 6:
                                                            obj5 = obj;
                                                            f2 = keyCycle.GetContactSyncConfig;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 7:
                                                            obj5 = obj;
                                                            f2 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda2;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case '\b':
                                                            obj5 = obj;
                                                            f2 = keyCycle.initRecordTimeStamp;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case '\t':
                                                            obj5 = obj;
                                                            f2 = keyCycle.lookAheadTest;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case '\n':
                                                            obj5 = obj;
                                                            f2 = keyCycle.newProxyInstance;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case 11:
                                                            obj5 = obj;
                                                            f2 = keyCycle.moveToNextValue;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case '\f':
                                                            obj5 = obj;
                                                            f2 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        case '\r':
                                                            obj5 = obj;
                                                            f2 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda3;
                                                            f3 = f2;
                                                            str40 = str4;
                                                            break;
                                                        default:
                                                            obj5 = obj;
                                                            if (next12.startsWith("CUSTOM")) {
                                                                str40 = str4;
                                                            } else {
                                                                StringBuilder sb4 = new StringBuilder();
                                                                str40 = str4;
                                                                sb4.append("  UNKNOWN  ");
                                                                sb4.append(next12);
                                                                InstrumentInjector.log_v("WARNING! KeyCycle", sb4.toString());
                                                            }
                                                            f3 = Float.NaN;
                                                            break;
                                                    }
                                                    if (Float.isNaN(f3) || (viewOscillator2 = hashMap4.get(next12)) == null) {
                                                        it24 = it;
                                                        str33 = str9;
                                                        str34 = str8;
                                                        str35 = str7;
                                                        str36 = str5;
                                                        str = str3;
                                                        str2 = str6;
                                                    } else {
                                                        int i33 = keyCycle.BuiltInFictitiousFunctionClassFactory;
                                                        int i34 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda4;
                                                        String str41 = str9;
                                                        String str42 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                                        HashMap<String, ViewOscillator> hashMap5 = hashMap4;
                                                        int i35 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda5;
                                                        Iterator<String> it26 = it25;
                                                        String str43 = str8;
                                                        String str44 = str7;
                                                        KeyCycle keyCycle2 = keyCycle;
                                                        String str45 = str20;
                                                        viewOscillator2.PlaceComponentResult.add(new KeyCycleOscillator.WavePoint(i33, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda6, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda3, f3));
                                                        if (i35 != -1) {
                                                            viewOscillator2.MyBillsEntityDataFactory = i35;
                                                        }
                                                        viewOscillator2.NetworkUserEntityData$$ExternalSyntheticLambda0 = i34;
                                                        viewOscillator2.getErrorConfigVersion = str42;
                                                        it24 = it;
                                                        str2 = str6;
                                                        str33 = str41;
                                                        hashMap4 = hashMap5;
                                                        it25 = it26;
                                                        str34 = str43;
                                                        str35 = str44;
                                                        keyCycle = keyCycle2;
                                                        str20 = str45;
                                                        str36 = str5;
                                                        str = str3;
                                                    }
                                                    obj7 = obj2;
                                                }
                                            }
                                        }
                                    }
                                    for (final ViewOscillator viewOscillator3 : this.lookAheadTest.values()) {
                                        int size2 = viewOscillator3.PlaceComponentResult.size();
                                        if (size2 != 0) {
                                            Collections.sort(viewOscillator3.PlaceComponentResult, new Comparator<KeyCycleOscillator.WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
                                                @Override // java.util.Comparator
                                                public /* bridge */ /* synthetic */ int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                                                    return Integer.compare(wavePoint.getAuthRequestContext, wavePoint2.getAuthRequestContext);
                                                }
                                            });
                                            double[] dArr12 = new double[size2];
                                            double[][] dArr13 = (double[][]) Array.newInstance(Double.TYPE, size2, 3);
                                            viewOscillator3.BuiltInFictitiousFunctionClassFactory = new KeyCycleOscillator.CycleOscillator(viewOscillator3.NetworkUserEntityData$$ExternalSyntheticLambda0, viewOscillator3.getErrorConfigVersion, viewOscillator3.MyBillsEntityDataFactory, size2);
                                            Iterator<KeyCycleOscillator.WavePoint> it27 = viewOscillator3.PlaceComponentResult.iterator();
                                            int i36 = 0;
                                            while (it27.hasNext()) {
                                                KeyCycleOscillator.WavePoint next13 = it27.next();
                                                double d11 = next13.BuiltInFictitiousFunctionClassFactory;
                                                Double.isNaN(d11);
                                                dArr12[i36] = d11 * 0.01d;
                                                dArr13[i36][0] = next13.PlaceComponentResult;
                                                dArr13[i36][1] = next13.MyBillsEntityDataFactory;
                                                dArr13[i36][2] = next13.KClassImpl$Data$declaredNonStaticMembers$2;
                                                KeyCycleOscillator.CycleOscillator cycleOscillator = viewOscillator3.BuiltInFictitiousFunctionClassFactory;
                                                int i37 = next13.getAuthRequestContext;
                                                float f9 = next13.BuiltInFictitiousFunctionClassFactory;
                                                float f10 = next13.MyBillsEntityDataFactory;
                                                float f11 = next13.KClassImpl$Data$declaredNonStaticMembers$2;
                                                float f12 = next13.PlaceComponentResult;
                                                double[] dArr14 = cycleOscillator.lookAheadTest;
                                                Iterator<KeyCycleOscillator.WavePoint> it28 = it27;
                                                double d12 = i37;
                                                Double.isNaN(d12);
                                                dArr14[i36] = d12 / 100.0d;
                                                cycleOscillator.getAuthRequestContext[i36] = f9;
                                                cycleOscillator.BuiltInFictitiousFunctionClassFactory[i36] = f10;
                                                cycleOscillator.getErrorConfigVersion[i36] = f11;
                                                cycleOscillator.NetworkUserEntityData$$ExternalSyntheticLambda1[i36] = f12;
                                                i36++;
                                                it27 = it28;
                                                dArr12 = dArr12;
                                            }
                                            double[] dArr15 = dArr12;
                                            KeyCycleOscillator.CycleOscillator cycleOscillator2 = viewOscillator3.BuiltInFictitiousFunctionClassFactory;
                                            cycleOscillator2.KClassImpl$Data$declaredNonStaticMembers$2 = f4;
                                            double[][] dArr16 = (double[][]) Array.newInstance(Double.TYPE, cycleOscillator2.lookAheadTest.length, 3);
                                            float[] fArr5 = cycleOscillator2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                            cycleOscillator2.moveToNextValue = new double[fArr5.length + 2];
                                            cycleOscillator2.NetworkUserEntityData$$ExternalSyntheticLambda0 = new double[fArr5.length + 2];
                                            if (cycleOscillator2.lookAheadTest[0] > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                                cycleOscillator2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, cycleOscillator2.getAuthRequestContext[0]);
                                            }
                                            double[] dArr17 = cycleOscillator2.lookAheadTest;
                                            int length2 = dArr17.length - 1;
                                            if (dArr17[length2] < 1.0d) {
                                                cycleOscillator2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(1.0d, cycleOscillator2.getAuthRequestContext[length2]);
                                            }
                                            for (int i38 = 0; i38 < dArr16.length; i38++) {
                                                double[] dArr18 = dArr16[i38];
                                                dArr18[0] = cycleOscillator2.BuiltInFictitiousFunctionClassFactory[i38];
                                                dArr18[1] = cycleOscillator2.getErrorConfigVersion[i38];
                                                dArr18[2] = cycleOscillator2.NetworkUserEntityData$$ExternalSyntheticLambda1[i38];
                                                cycleOscillator2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(cycleOscillator2.lookAheadTest[i38], cycleOscillator2.getAuthRequestContext[i38]);
                                            }
                                            Oscillator oscillator = cycleOscillator2.PlaceComponentResult;
                                            int i39 = 0;
                                            double d13 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                                            while (true) {
                                                float[] fArr6 = oscillator.scheduleImpl;
                                                if (i39 < fArr6.length) {
                                                    double d14 = fArr6[i39];
                                                    Double.isNaN(d14);
                                                    d13 += d14;
                                                    i39++;
                                                } else {
                                                    double d15 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                                                    int i40 = 1;
                                                    while (true) {
                                                        float[] fArr7 = oscillator.scheduleImpl;
                                                        if (i40 < fArr7.length) {
                                                            int i41 = i40 - 1;
                                                            float f13 = (fArr7[i41] + fArr7[i40]) / 2.0f;
                                                            double[] dArr19 = oscillator.moveToNextValue;
                                                            double d16 = dArr19[i40];
                                                            double d17 = dArr19[i41];
                                                            double d18 = f13;
                                                            Double.isNaN(d18);
                                                            d15 += (d16 - d17) * d18;
                                                            i40++;
                                                            f4 = f4;
                                                        } else {
                                                            f = f4;
                                                            int i42 = 0;
                                                            while (true) {
                                                                float[] fArr8 = oscillator.scheduleImpl;
                                                                if (i42 < fArr8.length) {
                                                                    double d19 = fArr8[i42];
                                                                    Double.isNaN(d19);
                                                                    fArr8[i42] = (float) (d19 * (d13 / d15));
                                                                    i42++;
                                                                    dArr15 = dArr15;
                                                                } else {
                                                                    double[] dArr20 = dArr15;
                                                                    oscillator.BuiltInFictitiousFunctionClassFactory[0] = 0.0d;
                                                                    int i43 = 1;
                                                                    while (true) {
                                                                        float[] fArr9 = oscillator.scheduleImpl;
                                                                        if (i43 < fArr9.length) {
                                                                            int i44 = i43 - 1;
                                                                            float f14 = (fArr9[i44] + fArr9[i43]) / 2.0f;
                                                                            double[] dArr21 = oscillator.moveToNextValue;
                                                                            double d20 = dArr21[i43];
                                                                            double d21 = dArr21[i44];
                                                                            double[] dArr22 = oscillator.BuiltInFictitiousFunctionClassFactory;
                                                                            double d22 = dArr22[i44];
                                                                            double d23 = f14;
                                                                            Double.isNaN(d23);
                                                                            dArr22[i43] = d22 + ((d20 - d21) * d23);
                                                                            i43++;
                                                                        } else {
                                                                            oscillator.MyBillsEntityDataFactory = true;
                                                                            double[] dArr23 = cycleOscillator2.lookAheadTest;
                                                                            if (dArr23.length > 1) {
                                                                                i3 = 0;
                                                                                cycleOscillator2.MyBillsEntityDataFactory = CurveFit.PlaceComponentResult(0, dArr23, dArr16);
                                                                                dArr = dArr20;
                                                                            } else {
                                                                                i3 = 0;
                                                                                cycleOscillator2.MyBillsEntityDataFactory = null;
                                                                                dArr = dArr20;
                                                                            }
                                                                            viewOscillator3.getAuthRequestContext = CurveFit.PlaceComponentResult(i3, dArr, dArr13);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            f = f4;
                                        }
                                        f4 = f;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" start: x: ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(" y: ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(" end: x: ");
        sb.append(this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(" y: ");
        sb.append(this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8);
        return sb.toString();
    }

    private void PlaceComponentResult(MotionPaths motionPaths) {
        float x = (int) this.getSupportButtonTintMode.getX();
        float y = (int) this.getSupportButtonTintMode.getY();
        float width = this.getSupportButtonTintMode.getWidth();
        float height = this.getSupportButtonTintMode.getHeight();
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 = x;
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 = y;
        motionPaths.newProxyInstance = width;
        motionPaths.PlaceComponentResult = height;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ViewState viewState, View view, int i, int i2, int i3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.isLayoutRequested = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.PrepareContext = 0.0f;
        Rect rect = new Rect();
        if (i == 1) {
            int i4 = viewState.getAuthRequestContext;
            int i5 = viewState.KClassImpl$Data$declaredNonStaticMembers$2;
            rect.left = ((viewState.BuiltInFictitiousFunctionClassFactory + viewState.PlaceComponentResult) - (viewState.KClassImpl$Data$declaredNonStaticMembers$2 - viewState.getAuthRequestContext)) / 2;
            rect.top = i2 - (((i4 + i5) + (viewState.PlaceComponentResult - viewState.BuiltInFictitiousFunctionClassFactory)) / 2);
            rect.right = rect.left + (viewState.KClassImpl$Data$declaredNonStaticMembers$2 - viewState.getAuthRequestContext);
            rect.bottom = rect.top + (viewState.PlaceComponentResult - viewState.BuiltInFictitiousFunctionClassFactory);
        } else if (i == 2) {
            int i6 = viewState.getAuthRequestContext;
            int i7 = viewState.KClassImpl$Data$declaredNonStaticMembers$2;
            rect.left = i3 - (((viewState.BuiltInFictitiousFunctionClassFactory + viewState.PlaceComponentResult) + (viewState.KClassImpl$Data$declaredNonStaticMembers$2 - viewState.getAuthRequestContext)) / 2);
            rect.top = ((i6 + i7) - (viewState.PlaceComponentResult - viewState.BuiltInFictitiousFunctionClassFactory)) / 2;
            rect.right = rect.left + (viewState.KClassImpl$Data$declaredNonStaticMembers$2 - viewState.getAuthRequestContext);
            rect.bottom = rect.top + (viewState.PlaceComponentResult - viewState.BuiltInFictitiousFunctionClassFactory);
        }
        MotionPaths motionPaths = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        float f = rect.left;
        float f2 = rect.top;
        float width = rect.width();
        float height = rect.height();
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 = f;
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 = f2;
        motionPaths.newProxyInstance = width;
        motionPaths.PlaceComponentResult = height;
        MotionConstrainedPoint motionConstrainedPoint = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        float f3 = viewState.MyBillsEntityDataFactory;
        float f4 = rect.left;
        float f5 = rect.top;
        float width2 = rect.width();
        float height2 = rect.height();
        motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda5 = f4;
        motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda4 = f5;
        motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda6 = width2;
        motionConstrainedPoint.KClassImpl$Data$declaredNonStaticMembers$2 = height2;
        motionConstrainedPoint.PlaceComponentResult(view);
        motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.NaN;
        motionConstrainedPoint.scheduleImpl = Float.NaN;
        if (i == 1) {
            motionConstrainedPoint.initRecordTimeStamp = f3 - 90.0f;
        } else if (i == 2) {
            motionConstrainedPoint.initRecordTimeStamp = f3 + 90.0f;
        }
    }

    private static void getAuthRequestContext(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left;
            int i5 = rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - (((i4 + i5) + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i == 2) {
            int i6 = rect.left;
            int i7 = rect.right;
            rect2.left = i2 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = ((i6 + i7) - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i == 3) {
            int i8 = rect.left + rect.right;
            int i9 = rect.top;
            int i10 = rect.bottom;
            rect2.left = ((rect.height() / 2) + rect.top) - (i8 / 2);
            rect2.top = i3 - ((i8 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i == 4) {
            int i11 = rect.left;
            int i12 = rect.right;
            rect2.left = i2 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = ((i11 + i12) - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    public final void PlaceComponentResult(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        Interpolator loadInterpolator;
        int i3 = constraintSet.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i3 != 0) {
            getAuthRequestContext(rect, this.FragmentBottomSheetPaymentSettingBinding, i3, i, i2);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.isLayoutRequested = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.PrepareContext = 0.0f;
        PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        MotionPaths motionPaths = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        float f = rect.left;
        float f2 = rect.top;
        float width = rect.width();
        float height = rect.height();
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 = f;
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 = f2;
        motionPaths.newProxyInstance = width;
        motionPaths.PlaceComponentResult = height;
        ConstraintSet.Constraint KClassImpl$Data$declaredNonStaticMembers$2 = constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
        this.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.KClassImpl$Data$declaredNonStaticMembers$2(rect, constraintSet, i3, this.getErrorConfigVersion);
        this.E = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.scheduleImpl;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.initRecordTimeStamp;
        this.A = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.GetContactSyncConfig;
        Context context = this.getSupportButtonTintMode.getContext();
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.scheduleImpl;
        if (i4 == -2) {
            loadInterpolator = AnimationUtils.loadInterpolator(context, i5);
        } else if (i4 == -1) {
            final Easing PlaceComponentResult = Easing.PlaceComponentResult(str);
            loadInterpolator = new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f3) {
                    return (float) PlaceComponentResult.getAuthRequestContext(f3);
                }
            };
        } else if (i4 == 0) {
            loadInterpolator = new AccelerateDecelerateInterpolator();
        } else if (i4 == 1) {
            loadInterpolator = new AccelerateInterpolator();
        } else if (i4 == 2) {
            loadInterpolator = new DecelerateInterpolator();
        } else if (i4 == 4) {
            loadInterpolator = new BounceInterpolator();
        } else {
            loadInterpolator = i4 != 5 ? null : new OvershootInterpolator();
        }
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = loadInterpolator;
    }

    public final void BuiltInFictitiousFunctionClassFactory(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        int i3 = constraintSet.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i3 != 0) {
            getAuthRequestContext(rect, this.FragmentBottomSheetPaymentSettingBinding, i3, i, i2);
            rect = this.FragmentBottomSheetPaymentSettingBinding;
        }
        this.moveToNextValue.isLayoutRequested = 1.0f;
        this.moveToNextValue.PrepareContext = 1.0f;
        PlaceComponentResult(this.moveToNextValue);
        MotionPaths motionPaths = this.moveToNextValue;
        float f = rect.left;
        float f2 = rect.top;
        float width = rect.width();
        float height = rect.height();
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 = f;
        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 = f2;
        motionPaths.newProxyInstance = width;
        motionPaths.PlaceComponentResult = height;
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion));
        this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(rect, constraintSet, i3, this.getErrorConfigVersion);
    }

    public final float getAuthRequestContext(float f, float[] fArr) {
        float f2 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f3 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (f3 != 1.0d) {
                float f4 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (f < f4) {
                    f = 0.0f;
                }
                if (f > f4 && f < 1.0d) {
                    f = Math.min((f - f4) * f3, 1.0f);
                }
            }
        }
        Easing easing = this.NetworkUserEntityData$$ExternalSyntheticLambda5.moveToNextValue;
        float f5 = Float.NaN;
        Iterator<MotionPaths> it = this.newProxyInstance.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (next.moveToNextValue != null) {
                if (next.isLayoutRequested < f) {
                    easing = next.moveToNextValue;
                    f2 = next.isLayoutRequested;
                } else if (Float.isNaN(f5)) {
                    f5 = next.isLayoutRequested;
                }
            }
        }
        if (easing != null) {
            float f6 = (Float.isNaN(f5) ? 1.0f : f5) - f2;
            double d = (f - f2) / f6;
            f = (((float) easing.getAuthRequestContext(d)) * f6) + f2;
            if (fArr != null) {
                fArr[0] = (float) easing.BuiltInFictitiousFunctionClassFactory(d);
            }
        }
        return f;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(View view, float f, long j, KeyCache keyCache) {
        boolean z;
        View view2;
        float f2;
        char c;
        ViewTimeCycle.PathRotate pathRotate;
        double d;
        float f3;
        float f4;
        double d2;
        float f5;
        boolean z2;
        float f6;
        float f7;
        MotionController motionController = this;
        View view3 = view;
        ViewTimeCycle.PathRotate pathRotate2 = null;
        float authRequestContext = motionController.getAuthRequestContext(f, null);
        if (motionController.VerifyPinStateManager$executeRiskChallenge$2$1 != Key.PlaceComponentResult) {
            float f8 = 1.0f / motionController.VerifyPinStateManager$executeRiskChallenge$2$1;
            float floor = (float) Math.floor(authRequestContext / f8);
            float f9 = (authRequestContext % f8) / f8;
            if (!Float.isNaN(motionController.A)) {
                f9 = (f9 + motionController.A) % 1.0f;
            }
            Interpolator interpolator = motionController.BottomSheetCardBindingView$watcherCardNumberView$1;
            if (interpolator != null) {
                f7 = interpolator.getInterpolation(f9);
            } else {
                f7 = ((double) f9) > 0.5d ? 1.0f : 0.0f;
            }
            authRequestContext = (f7 * f8) + (floor * f8);
        }
        float f10 = authRequestContext;
        HashMap<String, ViewSpline> hashMap = motionController.KClassImpl$Data$declaredNonStaticMembers$2;
        if (hashMap != null) {
            Iterator<ViewSpline> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().MyBillsEntityDataFactory(view3, f10);
            }
        }
        HashMap<String, ViewTimeCycle> hashMap2 = motionController.C;
        if (hashMap2 != null) {
            ViewTimeCycle.PathRotate pathRotate3 = null;
            boolean z3 = false;
            for (ViewTimeCycle viewTimeCycle : hashMap2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate3 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    z3 |= viewTimeCycle.MyBillsEntityDataFactory(view, f10, j, keyCache);
                }
            }
            pathRotate2 = pathRotate3;
            z = z3;
        } else {
            z = false;
        }
        CurveFit[] curveFitArr = motionController.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (curveFitArr != null) {
            double d3 = f10;
            curveFitArr[0].getAuthRequestContext(d3, motionController.initRecordTimeStamp);
            motionController.NetworkUserEntityData$$ExternalSyntheticLambda7[0].PlaceComponentResult(d3, motionController.GetContactSyncConfig);
            CurveFit curveFit = motionController.getAuthRequestContext;
            if (curveFit != null) {
                double[] dArr = motionController.initRecordTimeStamp;
                if (dArr.length > 0) {
                    curveFit.getAuthRequestContext(d3, dArr);
                    motionController.getAuthRequestContext.PlaceComponentResult(d3, motionController.GetContactSyncConfig);
                }
            }
            if (motionController.PrepareContext) {
                pathRotate = pathRotate2;
                d = d3;
                f3 = f10;
            } else {
                MotionPaths motionPaths = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5;
                int[] iArr = motionController.NetworkUserEntityData$$ExternalSyntheticLambda2;
                double[] dArr2 = motionController.initRecordTimeStamp;
                double[] dArr3 = motionController.GetContactSyncConfig;
                boolean z4 = motionController.NetworkUserEntityData$$ExternalSyntheticLambda0;
                float f11 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
                float f12 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
                float f13 = motionPaths.newProxyInstance;
                float f14 = motionPaths.PlaceComponentResult;
                if (iArr.length != 0) {
                    f5 = f11;
                    if (motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda1.length <= iArr[iArr.length - 1]) {
                        int i = iArr[iArr.length - 1] + 1;
                        motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda1 = new double[i];
                        motionPaths.initRecordTimeStamp = new double[i];
                    }
                } else {
                    f5 = f11;
                }
                float f15 = f12;
                Arrays.fill(motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda1, Double.NaN);
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    double[] dArr4 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int i3 = iArr[i2];
                    dArr4[i3] = dArr2[i2];
                    motionPaths.initRecordTimeStamp[i3] = dArr3[i2];
                }
                f3 = f10;
                float f16 = f5;
                float f17 = f13;
                float f18 = Float.NaN;
                int i4 = 0;
                float f19 = 0.0f;
                float f20 = 0.0f;
                float f21 = 0.0f;
                pathRotate = pathRotate2;
                float f22 = 0.0f;
                while (true) {
                    double[] dArr5 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int length = dArr5.length;
                    double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    z2 = z4;
                    if (i4 >= length) {
                        break;
                    }
                    if (Double.isNaN(dArr5[i4])) {
                        f6 = f22;
                    } else {
                        if (!Double.isNaN(motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda1[i4])) {
                            d4 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda1[i4] + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                        float f23 = (float) d4;
                        f6 = f22;
                        float f24 = (float) motionPaths.initRecordTimeStamp[i4];
                        if (i4 == 1) {
                            f19 = f24;
                            f16 = f23;
                        } else if (i4 == 2) {
                            f22 = f24;
                            f15 = f23;
                            i4++;
                            z4 = z2;
                        } else if (i4 == 3) {
                            f20 = f24;
                            f17 = f23;
                        } else if (i4 == 4) {
                            f21 = f24;
                            f14 = f23;
                        } else if (i4 == 5) {
                            f18 = f23;
                        }
                    }
                    f22 = f6;
                    i4++;
                    z4 = z2;
                }
                float f25 = f22;
                MotionController motionController2 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (motionController2 != null) {
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    motionController2.MyBillsEntityDataFactory(d3, fArr, fArr2);
                    float f26 = fArr[0];
                    float f27 = fArr[1];
                    float f28 = fArr2[0];
                    float f29 = fArr2[1];
                    double d5 = f26;
                    d = d3;
                    double d6 = f16;
                    double d7 = f15;
                    double sin = Math.sin(d7);
                    float f30 = f18;
                    double d8 = f17 / 2.0f;
                    Double.isNaN(d6);
                    Double.isNaN(d5);
                    Double.isNaN(d8);
                    float f31 = (float) ((d5 + (sin * d6)) - d8);
                    double d9 = f27;
                    double cos = Math.cos(d7);
                    double d10 = f14 / 2.0f;
                    Double.isNaN(d6);
                    Double.isNaN(d9);
                    Double.isNaN(d10);
                    float f32 = (float) ((d9 - (cos * d6)) - d10);
                    double d11 = f28;
                    double d12 = f19;
                    double sin2 = Math.sin(d7);
                    double cos2 = Math.cos(d7);
                    double d13 = f25;
                    Double.isNaN(d12);
                    Double.isNaN(d11);
                    Double.isNaN(d6);
                    Double.isNaN(d13);
                    float f33 = (float) (d11 + (sin2 * d12) + (cos2 * d6 * d13));
                    double d14 = f29;
                    double cos3 = Math.cos(d7);
                    double sin3 = Math.sin(d7);
                    Double.isNaN(d12);
                    Double.isNaN(d14);
                    Double.isNaN(d6);
                    Double.isNaN(d13);
                    float f34 = (float) ((d14 - (d12 * cos3)) + (d6 * sin3 * d13));
                    if (dArr3.length >= 2) {
                        dArr3[0] = f33;
                        dArr3[1] = f34;
                    }
                    if (Float.isNaN(f30)) {
                        view3 = view;
                    } else {
                        double d15 = f30;
                        double degrees = Math.toDegrees(Math.atan2(f34, f33));
                        Double.isNaN(d15);
                        view3 = view;
                        view3.setRotation((float) (d15 + degrees));
                    }
                    f15 = f32;
                    f16 = f31;
                } else {
                    d = d3;
                    if (!Float.isNaN(f18)) {
                        double d16 = f18;
                        double degrees2 = Math.toDegrees(Math.atan2(f25 + (f21 / 2.0f), f19 + (f20 / 2.0f)));
                        Double.isNaN(d16);
                        view3.setRotation((float) (d16 + degrees2 + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                    }
                }
                if (view3 instanceof FloatLayout) {
                    ((FloatLayout) view3).layout(f16, f15, f17 + f16, f14 + f15);
                } else {
                    float f35 = f16 + 0.5f;
                    int i5 = (int) f35;
                    float f36 = f15 + 0.5f;
                    int i6 = (int) f36;
                    int i7 = (int) (f35 + f17);
                    int i8 = (int) (f36 + f14);
                    int i9 = i7 - i5;
                    int i10 = i8 - i6;
                    if (((i9 == view.getMeasuredWidth() && i10 == view.getMeasuredHeight()) ? false : true) || z2) {
                        view3.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                    view3.layout(i5, i6, i7, i8);
                }
                motionController = this;
                motionController.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            }
            if (motionController.E != Key.PlaceComponentResult) {
                if (motionController.getOnBoardingScenario == null) {
                    motionController.getOnBoardingScenario = ((View) view.getParent()).findViewById(motionController.E);
                }
                if (motionController.getOnBoardingScenario != null) {
                    float top = (r1.getTop() + motionController.getOnBoardingScenario.getBottom()) / 2.0f;
                    float left = (motionController.getOnBoardingScenario.getLeft() + motionController.getOnBoardingScenario.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        float left2 = view.getLeft();
                        float top2 = view.getTop();
                        view3.setPivotX(left - left2);
                        view3.setPivotY(top - top2);
                    }
                }
            }
            HashMap<String, ViewSpline> hashMap3 = motionController.KClassImpl$Data$declaredNonStaticMembers$2;
            if (hashMap3 != null) {
                for (ViewSpline viewSpline : hashMap3.values()) {
                    if (viewSpline instanceof ViewSpline.PathRotate) {
                        double[] dArr6 = motionController.GetContactSyncConfig;
                        if (dArr6.length > 1) {
                            view3.setRotation(((ViewSpline.PathRotate) viewSpline).PlaceComponentResult(f3) + ((float) Math.toDegrees(Math.atan2(dArr6[1], dArr6[0]))));
                        }
                    }
                }
            }
            float f37 = f3;
            if (pathRotate != null) {
                double[] dArr7 = motionController.GetContactSyncConfig;
                f4 = f37;
                d2 = d;
                c = 1;
                z |= pathRotate.BuiltInFictitiousFunctionClassFactory(view, keyCache, f37, j, dArr7[0], dArr7[1]);
            } else {
                f4 = f37;
                d2 = d;
                c = 1;
            }
            int i11 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = motionController.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (i11 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i11].KClassImpl$Data$declaredNonStaticMembers$2(d2, motionController.getValueOfTouchPositionAbsolute);
                CustomSupport.getAuthRequestContext(motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.BuiltInFictitiousFunctionClassFactory.get(motionController.getCallingPid[i11 - 1]), view, motionController.getValueOfTouchPositionAbsolute);
                i11++;
            }
            view2 = view;
            if (motionController.NetworkUserEntityData$$ExternalSyntheticLambda3.GetContactSyncConfig == 0) {
                if (f4 <= 0.0f) {
                    view2.setVisibility(motionController.NetworkUserEntityData$$ExternalSyntheticLambda3.NetworkUserEntityData$$ExternalSyntheticLambda3);
                } else if (f4 >= 1.0f) {
                    view2.setVisibility(motionController.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda3);
                } else if (motionController.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda3 != motionController.NetworkUserEntityData$$ExternalSyntheticLambda3.NetworkUserEntityData$$ExternalSyntheticLambda3) {
                    view2.setVisibility(0);
                }
            }
            if (motionController.DatabaseTableConfigUtil != null) {
                int i12 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = motionController.DatabaseTableConfigUtil;
                    if (i12 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i12].BuiltInFictitiousFunctionClassFactory(f4, view2);
                    i12++;
                }
            }
            f2 = f4;
        } else {
            view2 = view3;
            f2 = f10;
            c = 1;
            float f38 = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda7 + ((motionController.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7 - motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda7) * f2) + 0.5f;
            int i13 = (int) f38;
            float f39 = motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda8 + ((motionController.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8 - motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda8) * f2) + 0.5f;
            int i14 = (int) f39;
            int i15 = (int) (f38 + motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.newProxyInstance + ((motionController.moveToNextValue.newProxyInstance - motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.newProxyInstance) * f2));
            int i16 = (int) (f39 + motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult + ((motionController.moveToNextValue.PlaceComponentResult - motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult) * f2));
            if (motionController.moveToNextValue.newProxyInstance != motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.newProxyInstance || motionController.moveToNextValue.PlaceComponentResult != motionController.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult || motionController.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i15 - i13, 1073741824), View.MeasureSpec.makeMeasureSpec(i16 - i14, 1073741824));
                motionController.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            }
            view2.layout(i13, i14, i15, i16);
        }
        HashMap<String, ViewOscillator> hashMap4 = motionController.lookAheadTest;
        if (hashMap4 != null) {
            for (ViewOscillator viewOscillator : hashMap4.values()) {
                if (!(viewOscillator instanceof ViewOscillator.PathRotateSet)) {
                    viewOscillator.MyBillsEntityDataFactory(view2, f2);
                } else {
                    double[] dArr8 = motionController.GetContactSyncConfig;
                    view2.setRotation(((ViewOscillator.PathRotateSet) viewOscillator).PlaceComponentResult(f2) + ((float) Math.toDegrees(Math.atan2(dArr8[c], dArr8[0]))));
                }
            }
        }
        return z;
    }

    public final void BuiltInFictitiousFunctionClassFactory(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float authRequestContext = getAuthRequestContext(f, this.readMicros);
        CurveFit[] curveFitArr = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int i = 0;
        if (curveFitArr != null) {
            double d = authRequestContext;
            curveFitArr[0].PlaceComponentResult(d, this.GetContactSyncConfig);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7[0].getAuthRequestContext(d, this.initRecordTimeStamp);
            float f4 = this.readMicros[0];
            while (true) {
                dArr = this.GetContactSyncConfig;
                if (i >= dArr.length) {
                    break;
                }
                double d2 = dArr[i];
                double d3 = f4;
                Double.isNaN(d3);
                dArr[i] = d2 * d3;
                i++;
            }
            CurveFit curveFit = this.getAuthRequestContext;
            if (curveFit != null) {
                double[] dArr2 = this.initRecordTimeStamp;
                if (dArr2.length > 0) {
                    curveFit.getAuthRequestContext(d, dArr2);
                    this.getAuthRequestContext.PlaceComponentResult(d, this.GetContactSyncConfig);
                    MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(f2, f3, fArr, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.GetContactSyncConfig, this.initRecordTimeStamp);
                    return;
                }
                return;
            }
            MotionPaths.KClassImpl$Data$declaredNonStaticMembers$2(f2, f3, fArr, this.NetworkUserEntityData$$ExternalSyntheticLambda2, dArr, this.initRecordTimeStamp);
            return;
        }
        float f5 = this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7 - this.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda7;
        float f6 = this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8 - this.NetworkUserEntityData$$ExternalSyntheticLambda5.NetworkUserEntityData$$ExternalSyntheticLambda8;
        float f7 = this.moveToNextValue.newProxyInstance;
        float f8 = this.NetworkUserEntityData$$ExternalSyntheticLambda5.newProxyInstance;
        float f9 = this.moveToNextValue.PlaceComponentResult;
        float f10 = this.NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult;
        fArr[0] = ((1.0f - f2) * f5) + (((f7 - f8) + f5) * f2);
        fArr[1] = ((1.0f - f3) * f6) + (((f9 - f10) + f6) * f3);
    }
}
