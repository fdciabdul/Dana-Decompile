package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static float KClassImpl$Data$declaredNonStaticMembers$2 = 0.001f;
    protected final Cache MyBillsEntityDataFactory;
    private final ArrayRow NetworkUserEntityData$$ExternalSyntheticLambda1;
    int getAuthRequestContext = 0;
    private int BuiltInFictitiousFunctionClassFactory = 8;
    private SolverVariable PlaceComponentResult = null;
    private int[] lookAheadTest = new int[8];
    private int[] NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[8];
    private float[] moveToNextValue = new float[8];
    private int getErrorConfigVersion = -1;
    private int DatabaseTableConfigUtil = -1;
    private boolean scheduleImpl = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = arrayRow;
        this.MyBillsEntityDataFactory = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void getAuthRequestContext(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            getAuthRequestContext(solverVariable, true);
            return;
        }
        int i = this.getErrorConfigVersion;
        if (i == -1) {
            this.getErrorConfigVersion = 0;
            this.moveToNextValue[0] = f;
            this.lookAheadTest[0] = solverVariable.BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0[this.getErrorConfigVersion] = -1;
            solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8++;
            solverVariable.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getAuthRequestContext++;
            if (this.scheduleImpl) {
                return;
            }
            int i2 = this.DatabaseTableConfigUtil + 1;
            this.DatabaseTableConfigUtil = i2;
            int[] iArr = this.lookAheadTest;
            if (i2 >= iArr.length) {
                this.scheduleImpl = true;
                this.DatabaseTableConfigUtil = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.getAuthRequestContext; i4++) {
            if (this.lookAheadTest[i] == solverVariable.BuiltInFictitiousFunctionClassFactory) {
                this.moveToNextValue[i] = f;
                return;
            }
            if (this.lookAheadTest[i] < solverVariable.BuiltInFictitiousFunctionClassFactory) {
                i3 = i;
            }
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
        int i5 = this.DatabaseTableConfigUtil;
        if (this.scheduleImpl) {
            int[] iArr2 = this.lookAheadTest;
            if (iArr2[i5] != -1) {
                i5 = iArr2.length;
            }
        } else {
            i5++;
        }
        int[] iArr3 = this.lookAheadTest;
        if (i5 >= iArr3.length && this.getAuthRequestContext < iArr3.length) {
            int i6 = 0;
            while (true) {
                int[] iArr4 = this.lookAheadTest;
                if (i6 >= iArr4.length) {
                    break;
                } else if (iArr4[i6] == -1) {
                    i5 = i6;
                    break;
                } else {
                    i6++;
                }
            }
        }
        int[] iArr5 = this.lookAheadTest;
        if (i5 >= iArr5.length) {
            i5 = iArr5.length;
            int i7 = this.BuiltInFictitiousFunctionClassFactory * 2;
            this.BuiltInFictitiousFunctionClassFactory = i7;
            this.scheduleImpl = false;
            this.DatabaseTableConfigUtil = i5 - 1;
            this.moveToNextValue = Arrays.copyOf(this.moveToNextValue, i7);
            this.lookAheadTest = Arrays.copyOf(this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Arrays.copyOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory);
        }
        this.lookAheadTest[i5] = solverVariable.BuiltInFictitiousFunctionClassFactory;
        this.moveToNextValue[i5] = f;
        if (i3 != -1) {
            int[] iArr6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            iArr6[i5] = iArr6[i3];
            iArr6[i3] = i5;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0[i5] = this.getErrorConfigVersion;
            this.getErrorConfigVersion = i5;
        }
        solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8++;
        solverVariable.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        int i8 = this.getAuthRequestContext + 1;
        this.getAuthRequestContext = i8;
        if (!this.scheduleImpl) {
            this.DatabaseTableConfigUtil++;
        }
        int[] iArr7 = this.lookAheadTest;
        if (i8 >= iArr7.length) {
            this.scheduleImpl = true;
        }
        if (this.DatabaseTableConfigUtil >= iArr7.length) {
            this.scheduleImpl = true;
            this.DatabaseTableConfigUtil = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void PlaceComponentResult(SolverVariable solverVariable, float f, boolean z) {
        float f2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (f <= (-f2) || f >= f2) {
            int i = this.getErrorConfigVersion;
            if (i == -1) {
                this.getErrorConfigVersion = 0;
                this.moveToNextValue[0] = f;
                this.lookAheadTest[0] = solverVariable.BuiltInFictitiousFunctionClassFactory;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0[this.getErrorConfigVersion] = -1;
                solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8++;
                solverVariable.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                this.getAuthRequestContext++;
                if (this.scheduleImpl) {
                    return;
                }
                int i2 = this.DatabaseTableConfigUtil + 1;
                this.DatabaseTableConfigUtil = i2;
                int[] iArr = this.lookAheadTest;
                if (i2 >= iArr.length) {
                    this.scheduleImpl = true;
                    this.DatabaseTableConfigUtil = iArr.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.getAuthRequestContext; i4++) {
                if (this.lookAheadTest[i] == solverVariable.BuiltInFictitiousFunctionClassFactory) {
                    float[] fArr = this.moveToNextValue;
                    float f3 = fArr[i] + f;
                    float f4 = KClassImpl$Data$declaredNonStaticMembers$2;
                    if (f3 > (-f4) && f3 < f4) {
                        f3 = 0.0f;
                    }
                    fArr[i] = f3;
                    if (f3 == 0.0f) {
                        if (i == this.getErrorConfigVersion) {
                            this.getErrorConfigVersion = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
                        } else {
                            int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            iArr2[i3] = iArr2[i];
                        }
                        if (z) {
                            solverVariable.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        }
                        if (this.scheduleImpl) {
                            this.DatabaseTableConfigUtil = i;
                        }
                        solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8--;
                        this.getAuthRequestContext--;
                        return;
                    }
                    return;
                }
                if (this.lookAheadTest[i] < solverVariable.BuiltInFictitiousFunctionClassFactory) {
                    i3 = i;
                }
                i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
            }
            int i5 = this.DatabaseTableConfigUtil;
            if (this.scheduleImpl) {
                int[] iArr3 = this.lookAheadTest;
                if (iArr3[i5] != -1) {
                    i5 = iArr3.length;
                }
            } else {
                i5++;
            }
            int[] iArr4 = this.lookAheadTest;
            if (i5 >= iArr4.length && this.getAuthRequestContext < iArr4.length) {
                int i6 = 0;
                while (true) {
                    int[] iArr5 = this.lookAheadTest;
                    if (i6 >= iArr5.length) {
                        break;
                    } else if (iArr5[i6] == -1) {
                        i5 = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            int[] iArr6 = this.lookAheadTest;
            if (i5 >= iArr6.length) {
                i5 = iArr6.length;
                int i7 = this.BuiltInFictitiousFunctionClassFactory * 2;
                this.BuiltInFictitiousFunctionClassFactory = i7;
                this.scheduleImpl = false;
                this.DatabaseTableConfigUtil = i5 - 1;
                this.moveToNextValue = Arrays.copyOf(this.moveToNextValue, i7);
                this.lookAheadTest = Arrays.copyOf(this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Arrays.copyOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory);
            }
            this.lookAheadTest[i5] = solverVariable.BuiltInFictitiousFunctionClassFactory;
            this.moveToNextValue[i5] = f;
            if (i3 != -1) {
                int[] iArr7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                iArr7[i5] = iArr7[i3];
                iArr7[i3] = i5;
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0[i5] = this.getErrorConfigVersion;
                this.getErrorConfigVersion = i5;
            }
            solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8++;
            solverVariable.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getAuthRequestContext++;
            if (!this.scheduleImpl) {
                this.DatabaseTableConfigUtil++;
            }
            int i8 = this.DatabaseTableConfigUtil;
            int[] iArr8 = this.lookAheadTest;
            if (i8 >= iArr8.length) {
                this.scheduleImpl = true;
                this.DatabaseTableConfigUtil = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float MyBillsEntityDataFactory(ArrayRow arrayRow, boolean z) {
        float MyBillsEntityDataFactory = MyBillsEntityDataFactory(arrayRow.PlaceComponentResult);
        getAuthRequestContext(arrayRow.PlaceComponentResult, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.BuiltInFictitiousFunctionClassFactory;
        int MyBillsEntityDataFactory2 = arrayRowVariables.MyBillsEntityDataFactory();
        for (int i = 0; i < MyBillsEntityDataFactory2; i++) {
            SolverVariable KClassImpl$Data$declaredNonStaticMembers$22 = arrayRowVariables.KClassImpl$Data$declaredNonStaticMembers$2(i);
            PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, arrayRowVariables.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22) * MyBillsEntityDataFactory, z);
        }
        return MyBillsEntityDataFactory;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float getAuthRequestContext(SolverVariable solverVariable, boolean z) {
        if (this.PlaceComponentResult == solverVariable) {
            this.PlaceComponentResult = null;
        }
        int i = this.getErrorConfigVersion;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.getAuthRequestContext) {
            if (this.lookAheadTest[i] == solverVariable.BuiltInFictitiousFunctionClassFactory) {
                if (i == this.getErrorConfigVersion) {
                    this.getErrorConfigVersion = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
                } else {
                    int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
                solverVariable.NetworkUserEntityData$$ExternalSyntheticLambda8--;
                this.getAuthRequestContext--;
                this.lookAheadTest[i] = -1;
                if (this.scheduleImpl) {
                    this.DatabaseTableConfigUtil = i;
                }
                return this.moveToNextValue[i];
            }
            i2++;
            i3 = i;
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void PlaceComponentResult() {
        int i = this.getErrorConfigVersion;
        for (int i2 = 0; i != -1 && i2 < this.getAuthRequestContext; i2++) {
            SolverVariable solverVariable = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2[this.lookAheadTest[i]];
            if (solverVariable != null) {
                solverVariable.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
        this.getErrorConfigVersion = -1;
        this.DatabaseTableConfigUtil = -1;
        this.scheduleImpl = false;
        this.getAuthRequestContext = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final boolean PlaceComponentResult(SolverVariable solverVariable) {
        int i = this.getErrorConfigVersion;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.getAuthRequestContext; i2++) {
            if (this.lookAheadTest[i] == solverVariable.BuiltInFictitiousFunctionClassFactory) {
                return true;
            }
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void getAuthRequestContext() {
        int i = this.getErrorConfigVersion;
        for (int i2 = 0; i != -1 && i2 < this.getAuthRequestContext; i2++) {
            float[] fArr = this.moveToNextValue;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void PlaceComponentResult(float f) {
        int i = this.getErrorConfigVersion;
        for (int i2 = 0; i != -1 && i2 < this.getAuthRequestContext; i2++) {
            float[] fArr = this.moveToNextValue;
            fArr[i] = fArr[i] / f;
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final int MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final SolverVariable KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = this.getErrorConfigVersion;
        for (int i3 = 0; i2 != -1 && i3 < this.getAuthRequestContext; i3++) {
            if (i3 == i) {
                return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2[this.lookAheadTest[i2]];
            }
            i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float getAuthRequestContext(int i) {
        int i2 = this.getErrorConfigVersion;
        for (int i3 = 0; i2 != -1 && i3 < this.getAuthRequestContext; i3++) {
            if (i3 == i) {
                return this.moveToNextValue[i2];
            }
            i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float MyBillsEntityDataFactory(SolverVariable solverVariable) {
        int i = this.getErrorConfigVersion;
        for (int i2 = 0; i != -1 && i2 < this.getAuthRequestContext; i2++) {
            if (this.lookAheadTest[i] == solverVariable.BuiltInFictitiousFunctionClassFactory) {
                return this.moveToNextValue[i];
            }
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
        return 0.0f;
    }

    public String toString() {
        int i = this.getErrorConfigVersion;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.getAuthRequestContext; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" -> ");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(this.moveToNextValue[i]);
            sb2.append(" : ");
            String obj2 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj2);
            sb3.append(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2[this.lookAheadTest[i]]);
            str = sb3.toString();
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        }
        return str;
    }
}
