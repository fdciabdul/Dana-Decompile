package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: classes3.dex */
public class StopLogic extends MotionInterpolator {
    private StopLogicEngine BuiltInFictitiousFunctionClassFactory;
    private StopEngine MyBillsEntityDataFactory;
    private SpringStopEngine PlaceComponentResult;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.BuiltInFictitiousFunctionClassFactory = stopLogicEngine;
        this.MyBillsEntityDataFactory = stopLogicEngine;
    }

    public final void PlaceComponentResult(float f, float f2, float f3, float f4, float f5, float f6) {
        StopLogicEngine stopLogicEngine = this.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = stopLogicEngine;
        stopLogicEngine.getAuthRequestContext = false;
        stopLogicEngine.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        boolean z = f > f2;
        stopLogicEngine.MyBillsEntityDataFactory = z;
        if (z) {
            stopLogicEngine.getAuthRequestContext(-f3, f - f2, f5, f6, f4);
        } else {
            stopLogicEngine.getAuthRequestContext(f3, f2 - f, f5, f6, f4);
        }
    }

    public final void getAuthRequestContext(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.PlaceComponentResult;
        this.MyBillsEntityDataFactory = springStopEngine;
        springStopEngine.lookAheadTest = f2;
        springStopEngine.KClassImpl$Data$declaredNonStaticMembers$2 = f6;
        springStopEngine.PlaceComponentResult = false;
        springStopEngine.moveToNextValue = f;
        springStopEngine.MyBillsEntityDataFactory = f3;
        springStopEngine.scheduleImpl = f5;
        springStopEngine.getErrorConfigVersion = f4;
        springStopEngine.NetworkUserEntityData$$ExternalSyntheticLambda0 = f7;
        springStopEngine.BuiltInFictitiousFunctionClassFactory = i;
        springStopEngine.getAuthRequestContext = 0.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(f);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public final float PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getAuthRequestContext();
    }
}
