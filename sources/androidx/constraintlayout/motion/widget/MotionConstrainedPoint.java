package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.alipay.mobile.zebra.data.ZebraData;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static String[] BuiltInFictitiousFunctionClassFactory = {"position", "x", "y", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "pathRotate"};
    float KClassImpl$Data$declaredNonStaticMembers$2;
    int NetworkUserEntityData$$ExternalSyntheticLambda3;
    float NetworkUserEntityData$$ExternalSyntheticLambda4;
    float NetworkUserEntityData$$ExternalSyntheticLambda5;
    float NetworkUserEntityData$$ExternalSyntheticLambda6;
    private float getCallingPid;
    private Easing readMicros;
    float getAuthRequestContext = 1.0f;
    int GetContactSyncConfig = 0;
    private boolean getSupportButtonTintMode = false;
    float PlaceComponentResult = 0.0f;
    float initRecordTimeStamp = 0.0f;
    float NetworkUserEntityData$$ExternalSyntheticLambda1 = 0.0f;
    public float isLayoutRequested = 0.0f;
    float PrepareContext = 1.0f;
    float NetworkUserEntityData$$ExternalSyntheticLambda8 = 1.0f;
    float NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.NaN;
    float scheduleImpl = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
    float newProxyInstance = 0.0f;
    float FragmentBottomSheetPaymentSettingBinding = 0.0f;
    private int SubSequence = 0;
    float lookAheadTest = Float.NaN;
    float getErrorConfigVersion = Float.NaN;
    private int whenAvailable = -1;
    LinkedHashMap<String, ConstraintAttribute> MyBillsEntityDataFactory = new LinkedHashMap<>();
    int moveToNextValue = 0;
    double[] DatabaseTableConfigUtil = new double[18];
    double[] NetworkUserEntityData$$ExternalSyntheticLambda2 = new double[18];

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.getCallingPid, motionConstrainedPoint.getCallingPid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    public final void PlaceComponentResult(View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = view.getVisibility();
        this.getAuthRequestContext = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.getSupportButtonTintMode = false;
        if (Build.VERSION.SDK_INT >= 21) {
            this.PlaceComponentResult = view.getElevation();
        }
        this.initRecordTimeStamp = view.getRotation();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view.getRotationX();
        this.isLayoutRequested = view.getRotationY();
        this.PrepareContext = view.getScaleX();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = view.getScaleY();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view.getPivotX();
        this.scheduleImpl = view.getPivotY();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = view.getTranslationX();
        this.newProxyInstance = view.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21) {
            this.FragmentBottomSheetPaymentSettingBinding = view.getTranslationZ();
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(HashMap<String, ViewSpline> hashMap, int i) {
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(str);
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c = '\r';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda1) ? 0.0f : this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    break;
                case 1:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.isLayoutRequested) ? 0.0f : this.isLayoutRequested);
                    break;
                case 2:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda7) ? 0.0f : this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                    break;
                case 3:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.newProxyInstance) ? 0.0f : this.newProxyInstance);
                    break;
                case 4:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.FragmentBottomSheetPaymentSettingBinding) ? 0.0f : this.FragmentBottomSheetPaymentSettingBinding);
                    break;
                case 5:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.getErrorConfigVersion) ? 0.0f : this.getErrorConfigVersion);
                    break;
                case 6:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.PrepareContext) ? 1.0f : this.PrepareContext);
                    break;
                case 7:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda8) ? 1.0f : this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                    break;
                case '\b':
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda0) ? 0.0f : this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    break;
                case '\t':
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.scheduleImpl) ? 0.0f : this.scheduleImpl);
                    break;
                case '\n':
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.initRecordTimeStamp) ? 0.0f : this.initRecordTimeStamp);
                    break;
                case 11:
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.PlaceComponentResult) ? 0.0f : this.PlaceComponentResult);
                    break;
                case '\f':
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.lookAheadTest) ? 0.0f : this.lookAheadTest);
                    break;
                case '\r':
                    viewSpline.MyBillsEntityDataFactory(i, Float.isNaN(this.getAuthRequestContext) ? 1.0f : this.getAuthRequestContext);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.MyBillsEntityDataFactory.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.MyBillsEntityDataFactory.get(str2);
                            if (!(viewSpline instanceof ViewSpline.CustomSet)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                sb.append(" ViewSpline not a CustomSet frame = ");
                                sb.append(i);
                                sb.append(", value");
                                sb.append(constraintAttribute.PlaceComponentResult());
                                sb.append(viewSpline);
                                InstrumentInjector.log_e("MotionPaths", sb.toString());
                                break;
                            } else {
                                ((ViewSpline.CustomSet) viewSpline).moveToNextValue.append(i, constraintAttribute);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("UNKNOWN spline ");
                        sb2.append(str);
                        InstrumentInjector.log_e("MotionPaths", sb2.toString());
                        break;
                    }
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        float x = view.getX();
        float y = view.getY();
        float width = view.getWidth();
        float height = view.getHeight();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = x;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = y;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = width;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = height;
        PlaceComponentResult(view);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        float f = rect.left;
        float f2 = rect.top;
        float width = rect.width();
        float height = rect.height();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = f2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = width;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = height;
        ConstraintSet.Constraint KClassImpl$Data$declaredNonStaticMembers$2 = constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(i2);
        this.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.MyBillsEntityDataFactory;
        this.getAuthRequestContext = (KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.MyBillsEntityDataFactory == 0 || this.GetContactSyncConfig != 0) ? KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 : 0.0f;
        this.getSupportButtonTintMode = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.getAuthRequestContext;
        this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.PlaceComponentResult;
        this.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.MyBillsEntityDataFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2;
        this.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.moveToNextValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.getErrorConfigVersion;
        this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.initRecordTimeStamp;
        this.newProxyInstance = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.DatabaseTableConfigUtil;
        this.FragmentBottomSheetPaymentSettingBinding = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.readMicros = Easing.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.DatabaseTableConfigUtil);
        this.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.lookAheadTest;
        this.SubSequence = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.MyBillsEntityDataFactory;
        this.whenAvailable = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.PlaceComponentResult;
        this.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.getAuthRequestContext;
        for (String str : KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.keySet()) {
            ConstraintAttribute constraintAttribute = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.get(str);
            if (constraintAttribute.MyBillsEntityDataFactory()) {
                this.MyBillsEntityDataFactory.put(str, constraintAttribute);
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            float f3 = this.initRecordTimeStamp + 90.0f;
            this.initRecordTimeStamp = f3;
            if (f3 > 180.0f) {
                this.initRecordTimeStamp = f3 - 360.0f;
                return;
            }
            return;
        }
        this.initRecordTimeStamp -= 90.0f;
    }
}
