package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class StopLogicEngine implements StopEngine {
    private int BuiltInFictitiousFunctionClassFactory;
    private String DatabaseTableConfigUtil;
    private float GetContactSyncConfig;
    public float KClassImpl$Data$declaredNonStaticMembers$2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float PlaceComponentResult;
    private float getErrorConfigVersion;
    private float initRecordTimeStamp;
    private float lookAheadTest;
    private float moveToNextValue;
    private float scheduleImpl;
    public boolean MyBillsEntityDataFactory = false;
    public boolean getAuthRequestContext = false;

    private float KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        float f2 = this.scheduleImpl;
        if (f <= f2) {
            float f3 = this.getErrorConfigVersion;
            return f3 + (((this.initRecordTimeStamp - f3) * f) / f2);
        }
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i == 1) {
            return 0.0f;
        }
        float f4 = f - f2;
        float f5 = this.lookAheadTest;
        if (f4 < f5) {
            float f6 = this.initRecordTimeStamp;
            return f6 + (((this.GetContactSyncConfig - f6) * f4) / f5);
        } else if (i == 2) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        } else {
            float f7 = f4 - f5;
            float f8 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (f7 < f8) {
                float f9 = this.GetContactSyncConfig;
                return f9 - ((f7 * f9) / f8);
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory ? -KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult) : KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
    }

    public final void getAuthRequestContext(float f, float f2, float f3, float f4, float f5) {
        this.getAuthRequestContext = false;
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.getErrorConfigVersion = f;
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < 0.0f) {
            float sqrt = (float) Math.sqrt((f2 - ((((-f) / f3) * f) / 2.0f)) * f3);
            if (sqrt < f4) {
                this.DatabaseTableConfigUtil = "backward accelerate, decelerate";
                this.BuiltInFictitiousFunctionClassFactory = 2;
                this.getErrorConfigVersion = f;
                this.initRecordTimeStamp = sqrt;
                this.GetContactSyncConfig = 0.0f;
                float f8 = (sqrt - f) / f3;
                this.scheduleImpl = f8;
                this.lookAheadTest = sqrt / f3;
                this.moveToNextValue = ((f + sqrt) * f8) / 2.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f2;
                return;
            }
            this.DatabaseTableConfigUtil = "backward accelerate cruse decelerate";
            this.BuiltInFictitiousFunctionClassFactory = 3;
            this.getErrorConfigVersion = f;
            this.initRecordTimeStamp = f4;
            this.GetContactSyncConfig = f4;
            float f9 = (f4 - f) / f3;
            this.scheduleImpl = f9;
            float f10 = f4 / f3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f10;
            float f11 = ((f + f4) * f9) / 2.0f;
            float f12 = (f10 * f4) / 2.0f;
            this.lookAheadTest = ((f2 - f11) - f12) / f4;
            this.moveToNextValue = f11;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2 - f12;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f2;
        } else if (f7 >= f2) {
            this.DatabaseTableConfigUtil = "hard stop";
            this.BuiltInFictitiousFunctionClassFactory = 1;
            this.getErrorConfigVersion = f;
            this.initRecordTimeStamp = 0.0f;
            this.moveToNextValue = f2;
            this.scheduleImpl = (2.0f * f2) / f;
        } else {
            float f13 = f2 - f7;
            float f14 = f13 / f;
            if (f14 + f6 < f5) {
                this.DatabaseTableConfigUtil = "cruse decelerate";
                this.BuiltInFictitiousFunctionClassFactory = 2;
                this.getErrorConfigVersion = f;
                this.initRecordTimeStamp = f;
                this.GetContactSyncConfig = 0.0f;
                this.moveToNextValue = f13;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2;
                this.scheduleImpl = f14;
                this.lookAheadTest = f6;
                return;
            }
            float sqrt2 = (float) Math.sqrt((f3 * f2) + ((f * f) / 2.0f));
            float f15 = (sqrt2 - f) / f3;
            this.scheduleImpl = f15;
            float f16 = sqrt2 / f3;
            this.lookAheadTest = f16;
            if (sqrt2 < f4) {
                this.DatabaseTableConfigUtil = "accelerate decelerate";
                this.BuiltInFictitiousFunctionClassFactory = 2;
                this.getErrorConfigVersion = f;
                this.initRecordTimeStamp = sqrt2;
                this.GetContactSyncConfig = 0.0f;
                this.scheduleImpl = f15;
                this.lookAheadTest = f16;
                this.moveToNextValue = ((f + sqrt2) * f15) / 2.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2;
                return;
            }
            this.DatabaseTableConfigUtil = "accelerate cruse decelerate";
            this.BuiltInFictitiousFunctionClassFactory = 3;
            this.getErrorConfigVersion = f;
            this.initRecordTimeStamp = f4;
            this.GetContactSyncConfig = f4;
            float f17 = (f4 - f) / f3;
            this.scheduleImpl = f17;
            float f18 = f4 / f3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f18;
            float f19 = ((f + f4) * f17) / 2.0f;
            float f20 = (f18 * f4) / 2.0f;
            this.lookAheadTest = ((f2 - f19) - f20) / f4;
            this.moveToNextValue = f19;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2 - f20;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f2;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float BuiltInFictitiousFunctionClassFactory(float f) {
        float f2;
        this.getAuthRequestContext = false;
        float f3 = this.scheduleImpl;
        if (f <= f3) {
            float f4 = this.getErrorConfigVersion;
            f2 = (f4 * f) + ((((this.initRecordTimeStamp - f4) * f) * f) / (f3 * 2.0f));
        } else {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            if (i == 1) {
                f2 = this.moveToNextValue;
            } else {
                float f5 = f - f3;
                float f6 = this.lookAheadTest;
                if (f5 < f6) {
                    float f7 = this.moveToNextValue;
                    float f8 = this.initRecordTimeStamp;
                    f2 = f7 + (f8 * f5) + ((((this.GetContactSyncConfig - f8) * f5) * f5) / (f6 * 2.0f));
                } else if (i == 2) {
                    f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else {
                    float f9 = f5 - f6;
                    float f10 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (f9 <= f10) {
                        float f11 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        float f12 = this.GetContactSyncConfig * f9;
                        f2 = (f11 + f12) - ((f12 * f9) / (f10 * 2.0f));
                    } else {
                        this.getAuthRequestContext = true;
                        f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    }
                }
            }
        }
        this.PlaceComponentResult = f;
        return this.MyBillsEntityDataFactory ? this.KClassImpl$Data$declaredNonStaticMembers$2 - f2 : this.KClassImpl$Data$declaredNonStaticMembers$2 + f2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final boolean getAuthRequestContext() {
        return (this.MyBillsEntityDataFactory ? -KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult) : KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult)) < 1.0E-5f && Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda1 - this.PlaceComponentResult) < 1.0E-5f;
    }
}
