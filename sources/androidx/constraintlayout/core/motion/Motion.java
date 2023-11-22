package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class Motion implements TypedValues {
    public MotionWidget moveToNextValue;
    Rect NetworkUserEntityData$$ExternalSyntheticLambda0 = new Rect();
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    public MotionPaths scheduleImpl = new MotionPaths();
    public MotionPaths PlaceComponentResult = new MotionPaths();
    public MotionConstrainedPoint getErrorConfigVersion = new MotionConstrainedPoint();
    public MotionConstrainedPoint MyBillsEntityDataFactory = new MotionConstrainedPoint();
    float BuiltInFictitiousFunctionClassFactory = Float.NaN;
    float getAuthRequestContext = 0.0f;
    float KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
    private int lookAheadTest = 4;
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda3 = new float[4];
    private ArrayList<MotionPaths> GetContactSyncConfig = new ArrayList<>();
    private float[] FragmentBottomSheetPaymentSettingBinding = new float[1];
    private ArrayList<MotionKey> NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList<>();
    private int DatabaseTableConfigUtil = -1;
    private int isLayoutRequested = -1;
    private MotionWidget newProxyInstance = null;
    private int PrepareContext = -1;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7 = Float.NaN;
    private DifferentialInterpolator NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
    private boolean initRecordTimeStamp = false;

    /* renamed from: androidx.constraintlayout.core.motion.Motion$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 implements DifferentialInterpolator {
    }

    public Motion(MotionWidget motionWidget) {
        this.moveToNextValue = motionWidget;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" start: x: ");
        sb.append(this.scheduleImpl.isLayoutRequested);
        sb.append(" y: ");
        sb.append(this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(" end: x: ");
        sb.append(this.PlaceComponentResult.isLayoutRequested);
        sb.append(" y: ");
        sb.append(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8);
        return sb.toString();
    }
}
