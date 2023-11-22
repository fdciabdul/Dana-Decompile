package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class PriorityGoalRow extends ArrayRow {
    private SolverVariable[] GetContactSyncConfig;
    private SolverVariable[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    Cache getErrorConfigVersion;
    GoalVariableAccessor moveToNextValue;
    private int scheduleImpl;

    /* loaded from: classes3.dex */
    class GoalVariableAccessor {
        SolverVariable BuiltInFictitiousFunctionClassFactory;
        PriorityGoalRow PlaceComponentResult;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.PlaceComponentResult = priorityGoalRow;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable solverVariable, float f) {
            boolean z = true;
            if (!this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) {
                for (int i = 0; i < 9; i++) {
                    float f2 = solverVariable.PlaceComponentResult[i];
                    if (f2 != 0.0f) {
                        float f3 = f2 * f;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult[i] = f3;
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult[i] = 0.0f;
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                fArr[i2] = fArr[i2] + (solverVariable.PlaceComponentResult[i2] * f);
                if (Math.abs(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult[i2]) < 1.0E-4f) {
                    this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult[i2] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                PriorityGoalRow.this.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            for (int i = 8; i >= 0; i--) {
                float f = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean getAuthRequestContext(SolverVariable solverVariable) {
            for (int i = 8; i >= 0; i--) {
                float f = solverVariable.PlaceComponentResult[i];
                float f2 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult[i];
                if (f2 != f) {
                    return f2 < f;
                }
            }
            return false;
        }

        public String toString() {
            String str = "[ ";
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult[i]);
                    sb.append(" ");
                    str = sb.toString();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("] ");
            sb2.append(this.BuiltInFictitiousFunctionClassFactory);
            return sb2.toString();
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.scheduleImpl = 128;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable[128];
        this.GetContactSyncConfig = new SolverVariable[128];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.moveToNextValue = new GoalVariableAccessor(this);
        this.getErrorConfigVersion = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1 == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public final SolverVariable MyBillsEntityDataFactory(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.NetworkUserEntityData$$ExternalSyntheticLambda1; i2++) {
            SolverVariable solverVariable = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2];
            if (!zArr[solverVariable.BuiltInFictitiousFunctionClassFactory]) {
                this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = solverVariable;
                if (i == -1) {
                    if (!this.moveToNextValue.BuiltInFictitiousFunctionClassFactory()) {
                    }
                    i = i2;
                } else {
                    if (!this.moveToNextValue.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0[i])) {
                    }
                    i = i2;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable solverVariable) {
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = solverVariable;
        Arrays.fill(this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, 0.0f);
        solverVariable.PlaceComponentResult[solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda1] = 1.0f;
        MyBillsEntityDataFactory(solverVariable);
    }

    private final void MyBillsEntityDataFactory(SolverVariable solverVariable) {
        int i;
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        SolverVariable[] solverVariableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (i2 + 1 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = solverVariableArr2;
            this.GetContactSyncConfig = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i4;
        if (i4 > 1 && solverVariableArr3[i4 - 1].BuiltInFictitiousFunctionClassFactory > solverVariable.BuiltInFictitiousFunctionClassFactory) {
            int i5 = 0;
            while (true) {
                i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (i5 >= i) {
                    break;
                }
                this.GetContactSyncConfig[i5] = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i5];
                i5++;
            }
            Arrays.sort(this.GetContactSyncConfig, 0, i, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public /* bridge */ /* synthetic */ int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.BuiltInFictitiousFunctionClassFactory - solverVariable3.BuiltInFictitiousFunctionClassFactory;
                }
            });
            for (int i6 = 0; i6 < this.NetworkUserEntityData$$ExternalSyntheticLambda1; i6++) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0[i6] = this.GetContactSyncConfig[i6];
            }
        }
        solverVariable.MyBillsEntityDataFactory = true;
        solverVariable.getAuthRequestContext(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0[i] == solverVariable) {
                while (true) {
                    int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1 - 1;
                    if (i < i2) {
                        SolverVariable[] solverVariableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        int i3 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i3];
                        i = i3;
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i2;
                        solverVariable.MyBillsEntityDataFactory = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final void MyBillsEntityDataFactory(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.PlaceComponentResult;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.BuiltInFictitiousFunctionClassFactory;
        int MyBillsEntityDataFactory = arrayRowVariables.MyBillsEntityDataFactory();
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            SolverVariable KClassImpl$Data$declaredNonStaticMembers$2 = arrayRowVariables.KClassImpl$Data$declaredNonStaticMembers$2(i);
            float authRequestContext = arrayRowVariables.getAuthRequestContext(i);
            this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
            if (this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(solverVariable, authRequestContext)) {
                MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 += arrayRow.KClassImpl$Data$declaredNonStaticMembers$2 * authRequestContext;
        }
        PlaceComponentResult(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" goal -> (");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(") : ");
        String obj = sb.toString();
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda1; i++) {
            this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(this.moveToNextValue);
            sb2.append(" ");
            obj = sb2.toString();
        }
        return obj;
    }
}
