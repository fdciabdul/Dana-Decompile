package androidx.constraintlayout.core.motion;

import com.alipay.mobile.zebra.data.ZebraData;
import java.util.LinkedHashMap;

/* loaded from: classes6.dex */
public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static String[] BuiltInFictitiousFunctionClassFactory = {"position", "x", "y", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "pathRotate"};
    float GetContactSyncConfig;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    float NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda3;
    float PlaceComponentResult;
    float scheduleImpl;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1 = 1.0f;
    int getErrorConfigVersion = 0;
    private boolean DatabaseTableConfigUtil = false;
    private float initRecordTimeStamp = 0.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda4 = 0.0f;
    private float FragmentBottomSheetPaymentSettingBinding = 0.0f;
    public float moveToNextValue = 0.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda5 = 1.0f;
    private float readMicros = 1.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda8 = Float.NaN;
    private float PrepareContext = Float.NaN;
    private float getCallingPid = 0.0f;
    private float getSupportButtonTintMode = 0.0f;
    private float whenAvailable = 0.0f;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    private float isLayoutRequested = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda6 = Float.NaN;
    private int newProxyInstance = -1;
    LinkedHashMap<String, CustomVariable> getAuthRequestContext = new LinkedHashMap<>();
    int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    double[] lookAheadTest = new double[18];
    double[] MyBillsEntityDataFactory = new double[18];

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.NetworkUserEntityData$$ExternalSyntheticLambda3, motionConstrainedPoint.NetworkUserEntityData$$ExternalSyntheticLambda3);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(MotionWidget motionWidget) {
        float f = motionWidget.PlaceComponentResult.PlaceComponentResult;
        float f2 = motionWidget.PlaceComponentResult.initRecordTimeStamp;
        float f3 = motionWidget.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 - motionWidget.PlaceComponentResult.PlaceComponentResult;
        float f4 = motionWidget.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory - motionWidget.PlaceComponentResult.initRecordTimeStamp;
        this.GetContactSyncConfig = f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f2;
        this.scheduleImpl = f3;
        this.PlaceComponentResult = f4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = motionWidget.MyBillsEntityDataFactory.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = motionWidget.MyBillsEntityDataFactory.PlaceComponentResult != 4 ? 0.0f : motionWidget.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
        this.DatabaseTableConfigUtil = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = motionWidget.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.FragmentBottomSheetPaymentSettingBinding = motionWidget.PlaceComponentResult.getErrorConfigVersion;
        this.moveToNextValue = motionWidget.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = motionWidget.PlaceComponentResult.GetContactSyncConfig;
        this.readMicros = motionWidget.PlaceComponentResult.DatabaseTableConfigUtil;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = motionWidget.PlaceComponentResult.scheduleImpl;
        this.PrepareContext = motionWidget.PlaceComponentResult.lookAheadTest;
        this.getCallingPid = motionWidget.PlaceComponentResult.isLayoutRequested;
        this.getSupportButtonTintMode = motionWidget.PlaceComponentResult.newProxyInstance;
        this.whenAvailable = motionWidget.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8;
        for (String str : motionWidget.PlaceComponentResult.getAuthRequestContext.keySet()) {
            CustomVariable customVariable = motionWidget.PlaceComponentResult.getAuthRequestContext.get(str);
            if (customVariable != null && customVariable.PlaceComponentResult()) {
                this.getAuthRequestContext.put(str, customVariable);
            }
        }
    }
}
