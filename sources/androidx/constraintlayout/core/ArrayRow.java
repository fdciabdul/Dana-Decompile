package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ArrayRow implements LinearSystem.Row {
    public ArrayRowVariables BuiltInFictitiousFunctionClassFactory;
    SolverVariable PlaceComponentResult = null;
    public float KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
    boolean getAuthRequestContext = false;
    ArrayList<SolverVariable> lookAheadTest = new ArrayList<>();
    boolean MyBillsEntityDataFactory = false;

    /* loaded from: classes3.dex */
    public interface ArrayRowVariables {
        SolverVariable KClassImpl$Data$declaredNonStaticMembers$2(int i);

        float MyBillsEntityDataFactory(ArrayRow arrayRow, boolean z);

        float MyBillsEntityDataFactory(SolverVariable solverVariable);

        int MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(float f);

        void PlaceComponentResult(SolverVariable solverVariable, float f, boolean z);

        boolean PlaceComponentResult(SolverVariable solverVariable);

        float getAuthRequestContext(int i);

        float getAuthRequestContext(SolverVariable solverVariable, boolean z);

        void getAuthRequestContext();

        void getAuthRequestContext(SolverVariable solverVariable, float f);
    }

    public ArrayRow() {
    }

    public ArrayRow(Cache cache) {
        this.BuiltInFictitiousFunctionClassFactory = new ArrayLinkedVariables(this, cache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        SolverVariable solverVariable = this.PlaceComponentResult;
        return solverVariable != null && (solverVariable.initRecordTimeStamp == SolverVariable.Type.UNRESTRICTED || this.KClassImpl$Data$declaredNonStaticMembers$2 >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(SolverVariable solverVariable) {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(solverVariable);
    }

    public final ArrayRow PlaceComponentResult(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
        if (!z) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, 1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, 1.0f);
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, 1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, -1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, -1.0f);
        }
        return this;
    }

    public final ArrayRow MyBillsEntityDataFactory(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
        if (!z) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, 1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, -1.0f);
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, 1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, -1.0f);
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, 1.0f);
        }
        return this;
    }

    public final ArrayRow KClassImpl$Data$declaredNonStaticMembers$2(LinearSystem linearSystem, int i) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(linearSystem.PlaceComponentResult(i), 1.0f);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(linearSystem.PlaceComponentResult(i), -1.0f);
        return this;
    }

    public final ArrayRow getAuthRequestContext(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -1.0f);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, 1.0f);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, f);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable4, -f);
        return this;
    }

    public final ArrayRow MyBillsEntityDataFactory(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, 0.5f);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable4, 0.5f);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -0.5f);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, -0.5f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -f;
        return this;
    }

    private static boolean PlaceComponentResult(SolverVariable solverVariable) {
        return solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8 <= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.PlaceComponentResult;
        if (solverVariable2 != null) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, -1.0f);
            this.PlaceComponentResult.getAuthRequestContext = -1;
            this.PlaceComponentResult = null;
        }
        float authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, true) * (-1.0f);
        this.PlaceComponentResult = solverVariable;
        if (authRequestContext == 1.0f) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 /= authRequestContext;
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(authRequestContext);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult == null && this.KClassImpl$Data$declaredNonStaticMembers$2 == 0.0f && this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() == 0;
    }

    public void MyBillsEntityDataFactory(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 += arrayRow.KClassImpl$Data$declaredNonStaticMembers$2 * this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(arrayRow, z);
        if (z) {
            arrayRow.PlaceComponentResult.PlaceComponentResult(this);
        }
        if (LinearSystem.getAuthRequestContext && this.PlaceComponentResult != null && this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() == 0) {
            this.MyBillsEntityDataFactory = true;
            linearSystem.scheduleImpl = true;
        }
    }

    public final void MyBillsEntityDataFactory(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable == null || !solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 += solverVariable.KClassImpl$Data$declaredNonStaticMembers$2 * this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(solverVariable);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, z);
        if (z) {
            solverVariable.PlaceComponentResult(this);
        }
        if (LinearSystem.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() == 0) {
            this.MyBillsEntityDataFactory = true;
            linearSystem.scheduleImpl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SolverVariable BuiltInFictitiousFunctionClassFactory(boolean[] zArr, SolverVariable solverVariable) {
        int MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            float authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(i);
            if (authRequestContext < 0.0f) {
                SolverVariable KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i);
                if ((zArr == null || !zArr[KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory]) && KClassImpl$Data$declaredNonStaticMembers$2 != solverVariable && ((KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp == SolverVariable.Type.SLACK || KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp == SolverVariable.Type.ERROR) && authRequestContext < f)) {
                    f = authRequestContext;
                    solverVariable2 = KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
        }
        return solverVariable2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable MyBillsEntityDataFactory(boolean[] zArr) {
        return BuiltInFictitiousFunctionClassFactory(zArr, null);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        this.PlaceComponentResult = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public final void KClassImpl$Data$declaredNonStaticMembers$2(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.PlaceComponentResult = null;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            for (int i = 0; i < arrayRow.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(); i++) {
                this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(arrayRow.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i), arrayRow.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(i), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable solverVariable) {
        float f;
        if (solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda1 != 1) {
            if (solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda1 == 2) {
                f = 1000.0f;
            } else if (solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda1 == 3) {
                f = 1000000.0f;
            } else if (solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda1 == 4) {
                f = 1.0E9f;
            } else if (solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda1 == 5) {
                f = 1.0E12f;
            }
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, f);
        }
        f = 1.0f;
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, f);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public final SolverVariable getAuthRequestContext() {
        return this.PlaceComponentResult;
    }

    public final void BuiltInFictitiousFunctionClassFactory(LinearSystem linearSystem) {
        if (linearSystem.GetContactSyncConfig.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            for (int i = 0; i < MyBillsEntityDataFactory; i++) {
                SolverVariable KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i);
                if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext != -1 || KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 || KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) {
                    this.lookAheadTest.add(KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
            int size = this.lookAheadTest.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    SolverVariable solverVariable = this.lookAheadTest.get(i2);
                    if (solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                        MyBillsEntityDataFactory(linearSystem, solverVariable, true);
                    } else if (!solverVariable.scheduleImpl) {
                        MyBillsEntityDataFactory(linearSystem, linearSystem.GetContactSyncConfig[solverVariable.getAuthRequestContext], true);
                    } else if (solverVariable != null && solverVariable.scheduleImpl) {
                        float MyBillsEntityDataFactory2 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(solverVariable);
                        this.KClassImpl$Data$declaredNonStaticMembers$2 += solverVariable.DatabaseTableConfigUtil * MyBillsEntityDataFactory2;
                        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, true);
                        solverVariable.PlaceComponentResult(this);
                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(linearSystem.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda2], MyBillsEntityDataFactory2, true);
                        if (LinearSystem.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() == 0) {
                            this.MyBillsEntityDataFactory = true;
                            linearSystem.scheduleImpl = true;
                        }
                    }
                }
                this.lookAheadTest.clear();
            } else {
                z = true;
            }
        }
        if (LinearSystem.getAuthRequestContext && this.PlaceComponentResult != null && this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() == 0) {
            this.MyBillsEntityDataFactory = true;
            linearSystem.scheduleImpl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        boolean PlaceComponentResult;
        boolean PlaceComponentResult2;
        int MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        SolverVariable solverVariable = null;
        boolean z = false;
        SolverVariable solverVariable2 = null;
        boolean z2 = false;
        boolean z3 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < MyBillsEntityDataFactory; i++) {
            float authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(i);
            SolverVariable KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i);
            if (KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    PlaceComponentResult2 = PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (f > authRequestContext) {
                    PlaceComponentResult2 = PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (!z2 && PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    f = authRequestContext;
                    solverVariable = KClassImpl$Data$declaredNonStaticMembers$2;
                    z2 = true;
                }
                z2 = PlaceComponentResult2;
                f = authRequestContext;
                solverVariable = KClassImpl$Data$declaredNonStaticMembers$2;
            } else if (solverVariable == null && authRequestContext < 0.0f) {
                if (solverVariable2 == null) {
                    PlaceComponentResult = PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (f2 > authRequestContext) {
                    PlaceComponentResult = PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (!z3 && PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    f2 = authRequestContext;
                    solverVariable2 = KClassImpl$Data$declaredNonStaticMembers$2;
                    z3 = true;
                }
                z3 = PlaceComponentResult;
                f2 = authRequestContext;
                solverVariable2 = KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
        if (solverVariable == null) {
            solverVariable = solverVariable2;
        }
        if (solverVariable == null) {
            z = true;
        } else {
            getAuthRequestContext(solverVariable);
        }
        if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() == 0) {
            this.MyBillsEntityDataFactory = true;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r9 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r9.PlaceComponentResult
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L15
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.constraintlayout.core.SolverVariable r1 = r9.PlaceComponentResult
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L15:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L42
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L43
        L42:
            r1 = 0
        L43:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r9.BuiltInFictitiousFunctionClassFactory
            int r5 = r5.MyBillsEntityDataFactory()
        L49:
            if (r2 >= r5) goto Ld6
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r9.BuiltInFictitiousFunctionClassFactory
            androidx.constraintlayout.core.SolverVariable r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            if (r6 == 0) goto Ld2
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r9.BuiltInFictitiousFunctionClassFactory
            float r7 = r7.getAuthRequestContext(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 == 0) goto Ld2
            java.lang.String r6 = r6.toString()
            if (r1 != 0) goto L79
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto La4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto La0
        L79:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 <= 0) goto L8f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto La4
        L8f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        La0:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r7 = r7 * r1
        La4:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto Lba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto Ld1
        Lba:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        Ld1:
            r1 = 1
        Ld2:
            int r2 = r2 + 1
            goto L49
        Ld6:
            if (r1 != 0) goto Le9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        Le9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.toString():java.lang.String");
    }
}
