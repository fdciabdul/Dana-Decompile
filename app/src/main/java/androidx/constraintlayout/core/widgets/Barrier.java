package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Barrier extends HelperWidget {
    public int PlaceComponentResult = 0;
    public boolean getAuthRequestContext = true;
    public int BuiltInFictitiousFunctionClassFactory = 0;
    boolean MyBillsEntityDataFactory = false;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean MyBillsEntityDataFactory() {
        return true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void getAuthRequestContext(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.getAuthRequestContext(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.PlaceComponentResult = barrier.PlaceComponentResult;
        this.getAuthRequestContext = barrier.getAuthRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = barrier.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Barrier] ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(" {");
        String obj = sb.toString();
        for (int i = 0; i < this.FlowableCreate$BufferAsyncEmitter; i++) {
            ConstraintWidget constraintWidget = this.z[i];
            if (i > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(", ");
                obj = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append(constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda4);
            obj = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(obj);
        sb4.append("}");
        return sb4.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void lookAheadTest() {
        for (int i = 0; i < this.FlowableCreate$BufferAsyncEmitter; i++) {
            ConstraintWidget constraintWidget = this.z[i];
            if (this.getAuthRequestContext || constraintWidget.MyBillsEntityDataFactory()) {
                int i2 = this.PlaceComponentResult;
                if (i2 == 0 || i2 == 1) {
                    constraintWidget.KClassImpl$Data$declaredNonStaticMembers$2(0, true);
                } else if (i2 == 2 || i2 == 3) {
                    constraintWidget.KClassImpl$Data$declaredNonStaticMembers$2(1, true);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void KClassImpl$Data$declaredNonStaticMembers$2(LinearSystem linearSystem, boolean z) {
        boolean z2;
        int i;
        int i2;
        int i3;
        this.J[0] = this.I;
        this.J[2] = this.f5939a;
        this.J[1] = this.c;
        this.J[3] = this.isLayoutRequested;
        for (int i4 = 0; i4 < this.J.length; i4++) {
            this.J[i4].NetworkUserEntityData$$ExternalSyntheticLambda0 = linearSystem.PlaceComponentResult(this.J[i4]);
        }
        int i5 = this.PlaceComponentResult;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.J[this.PlaceComponentResult];
        if (!this.MyBillsEntityDataFactory) {
            BuiltInFictitiousFunctionClassFactory();
        }
        if (this.MyBillsEntityDataFactory) {
            this.MyBillsEntityDataFactory = false;
            int i6 = this.PlaceComponentResult;
            if (i6 == 0 || i6 == 1) {
                linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.I.NetworkUserEntityData$$ExternalSyntheticLambda0, this.m);
                linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.c.NetworkUserEntityData$$ExternalSyntheticLambda0, this.m);
                return;
            } else if (i6 == 2 || i6 == 3) {
                linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, this.k);
                linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, this.k);
                return;
            } else {
                return;
            }
        }
        for (int i7 = 0; i7 < this.FlowableCreate$BufferAsyncEmitter; i7++) {
            ConstraintWidget constraintWidget = this.z[i7];
            if ((this.getAuthRequestContext || constraintWidget.MyBillsEntityDataFactory()) && ((((i2 = this.PlaceComponentResult) == 0 || i2 == 1) && constraintWidget.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.I.moveToNextValue != null && constraintWidget.c.moveToNextValue != null) || (((i3 = this.PlaceComponentResult) == 2 || i3 == 3) && constraintWidget.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f5939a.moveToNextValue != null && constraintWidget.isLayoutRequested.moveToNextValue != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = this.I.KClassImpl$Data$declaredNonStaticMembers$2() || this.c.KClassImpl$Data$declaredNonStaticMembers$2();
        boolean z4 = this.f5939a.KClassImpl$Data$declaredNonStaticMembers$2() || this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2();
        int i8 = !z2 && (((i = this.PlaceComponentResult) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4)))) ? 5 : 4;
        for (int i9 = 0; i9 < this.FlowableCreate$BufferAsyncEmitter; i9++) {
            ConstraintWidget constraintWidget2 = this.z[i9];
            if (this.getAuthRequestContext || constraintWidget2.MyBillsEntityDataFactory()) {
                SolverVariable PlaceComponentResult = linearSystem.PlaceComponentResult(constraintWidget2.J[this.PlaceComponentResult]);
                constraintWidget2.J[this.PlaceComponentResult].NetworkUserEntityData$$ExternalSyntheticLambda0 = PlaceComponentResult;
                int i10 = (constraintWidget2.J[this.PlaceComponentResult].moveToNextValue == null || constraintWidget2.J[this.PlaceComponentResult].moveToNextValue.lookAheadTest != this) ? 0 : constraintWidget2.J[this.PlaceComponentResult].getAuthRequestContext + 0;
                int i11 = this.PlaceComponentResult;
                if (i11 == 0 || i11 == 2) {
                    SolverVariable solverVariable = constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    int i12 = this.BuiltInFictitiousFunctionClassFactory - i10;
                    ArrayRow MyBillsEntityDataFactory = linearSystem.MyBillsEntityDataFactory();
                    SolverVariable authRequestContext = linearSystem.getAuthRequestContext();
                    authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory(solverVariable, PlaceComponentResult, authRequestContext, i12);
                    linearSystem.getAuthRequestContext(MyBillsEntityDataFactory);
                } else {
                    SolverVariable solverVariable2 = constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    int i13 = this.BuiltInFictitiousFunctionClassFactory + i10;
                    ArrayRow MyBillsEntityDataFactory2 = linearSystem.MyBillsEntityDataFactory();
                    SolverVariable authRequestContext2 = linearSystem.getAuthRequestContext();
                    authRequestContext2.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
                    MyBillsEntityDataFactory2.PlaceComponentResult(solverVariable2, PlaceComponentResult, authRequestContext2, i13);
                    linearSystem.getAuthRequestContext(MyBillsEntityDataFactory2);
                }
                linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory + i10, i8);
            }
        }
        int i14 = this.PlaceComponentResult;
        if (i14 == 0) {
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.c.NetworkUserEntityData$$ExternalSyntheticLambda0, this.I.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 8);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.I.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.c.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 4);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.I.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.I.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 0);
        } else if (i14 == 1) {
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.I.NetworkUserEntityData$$ExternalSyntheticLambda0, this.c.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 8);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.I.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.I.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 4);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.I.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.c.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 0);
        } else if (i14 == 2) {
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, this.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 8);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 4);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 0);
        } else if (i14 == 3) {
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 8);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 4);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, this.W.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 0);
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        int i;
        int i2;
        boolean z = true;
        for (int i3 = 0; i3 < this.FlowableCreate$BufferAsyncEmitter; i3++) {
            ConstraintWidget constraintWidget = this.z[i3];
            if ((this.getAuthRequestContext || constraintWidget.MyBillsEntityDataFactory()) && ((((i = this.PlaceComponentResult) == 0 || i == 1) && !constraintWidget.PlaceComponentResult()) || (((i2 = this.PlaceComponentResult) == 2 || i2 == 3) && !constraintWidget.getAuthRequestContext()))) {
                z = false;
            }
        }
        if (!z || this.FlowableCreate$BufferAsyncEmitter <= 0) {
            return false;
        }
        int i4 = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.FlowableCreate$BufferAsyncEmitter; i5++) {
            ConstraintWidget constraintWidget2 = this.z[i5];
            if (this.getAuthRequestContext || constraintWidget2.MyBillsEntityDataFactory()) {
                if (!z2) {
                    int i6 = this.PlaceComponentResult;
                    if (i6 == 0) {
                        ConstraintAnchor BuiltInFictitiousFunctionClassFactory = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT);
                        if (BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                            i4 = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                            z2 = true;
                        }
                        i4 = 0;
                        z2 = true;
                    } else if (i6 == 1) {
                        ConstraintAnchor BuiltInFictitiousFunctionClassFactory2 = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT);
                        if (BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2) {
                            i4 = BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult;
                            z2 = true;
                        }
                        i4 = 0;
                        z2 = true;
                    } else if (i6 == 2) {
                        ConstraintAnchor BuiltInFictitiousFunctionClassFactory3 = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP);
                        if (BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2) {
                            i4 = BuiltInFictitiousFunctionClassFactory3.PlaceComponentResult;
                            z2 = true;
                        }
                        i4 = 0;
                        z2 = true;
                    } else {
                        if (i6 == 3) {
                            ConstraintAnchor BuiltInFictitiousFunctionClassFactory4 = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM);
                            if (BuiltInFictitiousFunctionClassFactory4.KClassImpl$Data$declaredNonStaticMembers$2) {
                                i4 = BuiltInFictitiousFunctionClassFactory4.PlaceComponentResult;
                            }
                            i4 = 0;
                        }
                        z2 = true;
                    }
                }
                int i7 = this.PlaceComponentResult;
                if (i7 == 0) {
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory5 = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT);
                    i4 = Math.min(i4, !BuiltInFictitiousFunctionClassFactory5.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory5.PlaceComponentResult);
                } else if (i7 == 1) {
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory6 = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT);
                    i4 = Math.max(i4, !BuiltInFictitiousFunctionClassFactory6.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory6.PlaceComponentResult);
                } else if (i7 == 2) {
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory7 = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP);
                    i4 = Math.min(i4, !BuiltInFictitiousFunctionClassFactory7.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory7.PlaceComponentResult);
                } else if (i7 == 3) {
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory8 = constraintWidget2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM);
                    i4 = Math.max(i4, !BuiltInFictitiousFunctionClassFactory8.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory8.PlaceComponentResult);
                }
            }
        }
        int i8 = i4 + this.BuiltInFictitiousFunctionClassFactory;
        int i9 = this.PlaceComponentResult;
        if (i9 == 0 || i9 == 1) {
            PlaceComponentResult(i8, i8);
        } else {
            getAuthRequestContext(i8, i8);
        }
        this.MyBillsEntityDataFactory = true;
        return true;
    }
}
