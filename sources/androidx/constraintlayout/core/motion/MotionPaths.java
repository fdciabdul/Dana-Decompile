package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import com.alipay.mobile.zebra.data.ZebraData;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    static String[] getAuthRequestContext = {"position", "x", "y", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "pathRotate"};
    public float KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    Easing NetworkUserEntityData$$ExternalSyntheticLambda0;
    public float NetworkUserEntityData$$ExternalSyntheticLambda7;
    public float NetworkUserEntityData$$ExternalSyntheticLambda8;
    public float PrepareContext;
    public float isLayoutRequested;
    public float newProxyInstance;
    int moveToNextValue = 0;
    float scheduleImpl = Float.NaN;
    float initRecordTimeStamp = Float.NaN;
    int getErrorConfigVersion = -1;
    int BuiltInFictitiousFunctionClassFactory = -1;
    float NetworkUserEntityData$$ExternalSyntheticLambda2 = Float.NaN;
    Motion DatabaseTableConfigUtil = null;
    HashMap<String, CustomVariable> PlaceComponentResult = new HashMap<>();
    int lookAheadTest = 0;
    double[] NetworkUserEntityData$$ExternalSyntheticLambda1 = new double[18];
    double[] GetContactSyncConfig = new double[18];

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.newProxyInstance, motionPaths.newProxyInstance);
    }

    public final void MyBillsEntityDataFactory(MotionWidget motionWidget) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Easing.PlaceComponentResult(motionWidget.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2);
        this.getErrorConfigVersion = motionWidget.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = motionWidget.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        this.scheduleImpl = motionWidget.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
        this.moveToNextValue = motionWidget.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
        this.MyBillsEntityDataFactory = motionWidget.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        this.initRecordTimeStamp = motionWidget.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        for (String str : motionWidget.PlaceComponentResult.getAuthRequestContext.keySet()) {
            CustomVariable customVariable = motionWidget.PlaceComponentResult.getAuthRequestContext.get(str);
            if (customVariable != null && customVariable.PlaceComponentResult()) {
                this.PlaceComponentResult.put(str, customVariable);
            }
        }
    }
}
