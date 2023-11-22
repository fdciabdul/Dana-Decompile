package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static float lookAheadTest = 0.001f;
    private final ArrayRow NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected final Cache PlaceComponentResult;
    private final int initRecordTimeStamp = -1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = 16;
    private int DatabaseTableConfigUtil = 16;
    int[] KClassImpl$Data$declaredNonStaticMembers$2 = new int[16];
    int[] getErrorConfigVersion = new int[16];
    int[] moveToNextValue = new int[16];
    float[] NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[16];
    int[] scheduleImpl = new int[16];
    int[] MyBillsEntityDataFactory = new int[16];
    int getAuthRequestContext = 0;
    int BuiltInFictitiousFunctionClassFactory = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = arrayRow;
        this.PlaceComponentResult = cache;
        PlaceComponentResult();
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final int MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final SolverVariable KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = this.getAuthRequestContext;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.BuiltInFictitiousFunctionClassFactory;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[this.moveToNextValue[i3]];
            }
            i3 = this.MyBillsEntityDataFactory[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float getAuthRequestContext(int i) {
        int i2 = this.getAuthRequestContext;
        int i3 = this.BuiltInFictitiousFunctionClassFactory;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.NetworkUserEntityData$$ExternalSyntheticLambda0[i3];
            }
            i3 = this.MyBillsEntityDataFactory[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final boolean PlaceComponentResult(SolverVariable solverVariable) {
        return KClassImpl$Data$declaredNonStaticMembers$2(solverVariable) != -1;
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable solverVariable) {
        if (this.getAuthRequestContext != 0 && solverVariable != null) {
            int i = solverVariable.BuiltInFictitiousFunctionClassFactory;
            int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2[i % this.DatabaseTableConfigUtil];
            if (i2 == -1) {
                return -1;
            }
            if (this.moveToNextValue[i2] == i) {
                return i2;
            }
            do {
                i2 = this.getErrorConfigVersion[i2];
                if (i2 == -1) {
                    break;
                }
            } while (this.moveToNextValue[i2] != i);
            if (i2 != -1 && this.moveToNextValue[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float MyBillsEntityDataFactory(SolverVariable solverVariable) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(solverVariable);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != -1) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0[KClassImpl$Data$declaredNonStaticMembers$2];
        }
        return 0.0f;
    }

    public String toString() {
        String obj;
        String obj2;
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" { ");
        String obj3 = sb.toString();
        int i = this.getAuthRequestContext;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(i2);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj3);
                sb2.append(KClassImpl$Data$declaredNonStaticMembers$2);
                sb2.append(" = ");
                sb2.append(getAuthRequestContext(i2));
                sb2.append(" ");
                String obj4 = sb2.toString();
                int KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj4);
                sb3.append("[p: ");
                String obj5 = sb3.toString();
                if (this.scheduleImpl[KClassImpl$Data$declaredNonStaticMembers$22] != -1) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(obj5);
                    sb4.append(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[this.moveToNextValue[this.scheduleImpl[KClassImpl$Data$declaredNonStaticMembers$22]]]);
                    obj = sb4.toString();
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(obj5);
                    sb5.append("none");
                    obj = sb5.toString();
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(obj);
                sb6.append(", n: ");
                String obj6 = sb6.toString();
                if (this.MyBillsEntityDataFactory[KClassImpl$Data$declaredNonStaticMembers$22] != -1) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(obj6);
                    sb7.append(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[this.moveToNextValue[this.MyBillsEntityDataFactory[KClassImpl$Data$declaredNonStaticMembers$22]]]);
                    obj2 = sb7.toString();
                } else {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(obj6);
                    sb8.append("none");
                    obj2 = sb8.toString();
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append(obj2);
                sb9.append("]");
                obj3 = sb9.toString();
            }
        }
        StringBuilder sb10 = new StringBuilder();
        sb10.append(obj3);
        sb10.append(" }");
        return sb10.toString();
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void PlaceComponentResult() {
        int i = this.getAuthRequestContext;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(i2);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
        }
        for (int i3 = 0; i3 < this.NetworkUserEntityData$$ExternalSyntheticLambda2; i3++) {
            this.moveToNextValue[i3] = -1;
            this.getErrorConfigVersion[i3] = -1;
        }
        for (int i4 = 0; i4 < this.DatabaseTableConfigUtil; i4++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2[i4] = -1;
        }
        this.getAuthRequestContext = 0;
        this.BuiltInFictitiousFunctionClassFactory = -1;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2 * 2;
        this.moveToNextValue = Arrays.copyOf(this.moveToNextValue, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Arrays.copyOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0, i);
        this.scheduleImpl = Arrays.copyOf(this.scheduleImpl, i);
        this.MyBillsEntityDataFactory = Arrays.copyOf(this.MyBillsEntityDataFactory, i);
        this.getErrorConfigVersion = Arrays.copyOf(this.getErrorConfigVersion, i);
        for (int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2; i2 < i; i2++) {
            this.moveToNextValue[i2] = -1;
            this.getErrorConfigVersion[i2] = -1;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
    }

    private void getAuthRequestContext(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.BuiltInFictitiousFunctionClassFactory % this.DatabaseTableConfigUtil;
        int[] iArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.getErrorConfigVersion;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                }
                i3 = i4;
            }
            iArr[i3] = i;
        }
        this.getErrorConfigVersion[i] = -1;
    }

    private void getAuthRequestContext(SolverVariable solverVariable) {
        int[] iArr;
        int i;
        int i2 = solverVariable.BuiltInFictitiousFunctionClassFactory % this.DatabaseTableConfigUtil;
        int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2[i2];
        if (i3 == -1) {
            return;
        }
        int i4 = solverVariable.BuiltInFictitiousFunctionClassFactory;
        if (this.moveToNextValue[i3] == i4) {
            int[] iArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int[] iArr3 = this.getErrorConfigVersion;
            iArr2[i2] = iArr3[i3];
            iArr3[i3] = -1;
            return;
        }
        while (true) {
            iArr = this.getErrorConfigVersion;
            i = iArr[i3];
            if (i == -1 || this.moveToNextValue[i] == i4) {
                break;
            }
            i3 = i;
        }
        if (i == -1 || this.moveToNextValue[i] != i4) {
            return;
        }
        iArr[i3] = iArr[i];
        iArr[i] = -1;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i, SolverVariable solverVariable, float f) {
        this.moveToNextValue[i] = solverVariable.BuiltInFictitiousFunctionClassFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0[i] = f;
        this.scheduleImpl[i] = -1;
        this.MyBillsEntityDataFactory[i] = -1;
        solverVariable.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8++;
        this.getAuthRequestContext++;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void getAuthRequestContext(SolverVariable solverVariable, float f) {
        float f2 = lookAheadTest;
        if (f > (-f2) && f < f2) {
            getAuthRequestContext(solverVariable, true);
            return;
        }
        if (this.getAuthRequestContext == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(0, solverVariable, f);
            getAuthRequestContext(solverVariable, 0);
            this.BuiltInFictitiousFunctionClassFactory = 0;
            return;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(solverVariable);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != -1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0[KClassImpl$Data$declaredNonStaticMembers$2] = f;
            return;
        }
        if (this.getAuthRequestContext + 1 >= this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        int i = this.getAuthRequestContext;
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            if (this.moveToNextValue[i2] == solverVariable.BuiltInFictitiousFunctionClassFactory) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2] = f;
                return;
            }
            if (this.moveToNextValue[i2] < solverVariable.BuiltInFictitiousFunctionClassFactory) {
                i3 = i2;
            }
            i2 = this.MyBillsEntityDataFactory[i2];
            if (i2 == -1) {
                break;
            }
        }
        BuiltInFictitiousFunctionClassFactory(i3, solverVariable, f);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float getAuthRequestContext(SolverVariable solverVariable, boolean z) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(solverVariable);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
            return 0.0f;
        }
        getAuthRequestContext(solverVariable);
        float f = this.NetworkUserEntityData$$ExternalSyntheticLambda0[KClassImpl$Data$declaredNonStaticMembers$2];
        if (this.BuiltInFictitiousFunctionClassFactory == KClassImpl$Data$declaredNonStaticMembers$2) {
            this.BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory[KClassImpl$Data$declaredNonStaticMembers$2];
        }
        this.moveToNextValue[KClassImpl$Data$declaredNonStaticMembers$2] = -1;
        int[] iArr = this.scheduleImpl;
        int i = iArr[KClassImpl$Data$declaredNonStaticMembers$2];
        if (i != -1) {
            int[] iArr2 = this.MyBillsEntityDataFactory;
            iArr2[i] = iArr2[KClassImpl$Data$declaredNonStaticMembers$2];
        }
        int i2 = this.MyBillsEntityDataFactory[KClassImpl$Data$declaredNonStaticMembers$2];
        if (i2 != -1) {
            iArr[i2] = iArr[KClassImpl$Data$declaredNonStaticMembers$2];
        }
        this.getAuthRequestContext--;
        solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8--;
        if (z) {
            solverVariable.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        return f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void PlaceComponentResult(SolverVariable solverVariable, float f, boolean z) {
        float f2 = lookAheadTest;
        if (f <= (-f2) || f >= f2) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(solverVariable);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                getAuthRequestContext(solverVariable, f);
                return;
            }
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            float f3 = fArr[KClassImpl$Data$declaredNonStaticMembers$2] + f;
            fArr[KClassImpl$Data$declaredNonStaticMembers$2] = f3;
            float f4 = lookAheadTest;
            if (f3 <= (-f4) || f3 >= f4) {
                return;
            }
            fArr[KClassImpl$Data$declaredNonStaticMembers$2] = 0.0f;
            getAuthRequestContext(solverVariable, z);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float MyBillsEntityDataFactory(ArrayRow arrayRow, boolean z) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(arrayRow.PlaceComponentResult);
        float f = KClassImpl$Data$declaredNonStaticMembers$2 != -1 ? this.NetworkUserEntityData$$ExternalSyntheticLambda0[KClassImpl$Data$declaredNonStaticMembers$2] : 0.0f;
        getAuthRequestContext(arrayRow.PlaceComponentResult, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.BuiltInFictitiousFunctionClassFactory;
        int i = solverVariableValues.getAuthRequestContext;
        int i2 = solverVariableValues.BuiltInFictitiousFunctionClassFactory;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (solverVariableValues.moveToNextValue[i4] != -1) {
                PlaceComponentResult(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[solverVariableValues.moveToNextValue[i4]], solverVariableValues.NetworkUserEntityData$$ExternalSyntheticLambda0[i4] * f, z);
                i3++;
            }
            i4++;
        }
        return f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void getAuthRequestContext() {
        int i = this.getAuthRequestContext;
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.MyBillsEntityDataFactory[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void PlaceComponentResult(float f) {
        int i = this.getAuthRequestContext;
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            fArr[i2] = fArr[i2] / f;
            i2 = this.MyBillsEntityDataFactory[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(int i, SolverVariable solverVariable, float f) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                i2 = -1;
                break;
            } else if (this.moveToNextValue[i2] == -1) {
                break;
            } else {
                i2++;
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2(i2, solverVariable, f);
        if (i != -1) {
            this.scheduleImpl[i2] = i;
            int[] iArr = this.MyBillsEntityDataFactory;
            iArr[i2] = iArr[i];
            iArr[i] = i2;
        } else {
            this.scheduleImpl[i2] = -1;
            if (this.getAuthRequestContext > 0) {
                this.MyBillsEntityDataFactory[i2] = this.BuiltInFictitiousFunctionClassFactory;
                this.BuiltInFictitiousFunctionClassFactory = i2;
            } else {
                this.MyBillsEntityDataFactory[i2] = -1;
            }
        }
        int i3 = this.MyBillsEntityDataFactory[i2];
        if (i3 != -1) {
            this.scheduleImpl[i3] = i2;
        }
        getAuthRequestContext(solverVariable, i2);
    }
}
