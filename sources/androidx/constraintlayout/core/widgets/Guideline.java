package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Guideline extends ConstraintWidget {
    public boolean t;
    protected float s = -1.0f;
    protected int MyBillsEntityDataFactory = -1;

    /* renamed from: o  reason: collision with root package name */
    protected int f5943o = -1;
    protected boolean PlaceComponentResult = true;
    public ConstraintAnchor getAuthRequestContext = this.f5939a;
    public int BuiltInFictitiousFunctionClassFactory = 0;
    private int r = 0;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean MyBillsEntityDataFactory() {
        return true;
    }

    public Guideline() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.getAuthRequestContext);
        int length = this.J.length;
        for (int i = 0; i < length; i++) {
            this.J[i] = this.getAuthRequestContext;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void getAuthRequestContext(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.getAuthRequestContext(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.s = guideline.s;
        this.MyBillsEntityDataFactory = guideline.MyBillsEntityDataFactory;
        this.f5943o = guideline.f5943o;
        this.PlaceComponentResult = guideline.PlaceComponentResult;
        NetworkUserEntityData$$ExternalSyntheticLambda2(guideline.BuiltInFictitiousFunctionClassFactory);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda2(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory == i) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
        if (this.BuiltInFictitiousFunctionClassFactory == 1) {
            this.getAuthRequestContext = this.I;
        } else {
            this.getAuthRequestContext = this.f5939a;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.getAuthRequestContext);
        int length = this.J.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.J[i2] = this.getAuthRequestContext;
        }
    }

    /* renamed from: androidx.constraintlayout.core.widgets.Guideline$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                PlaceComponentResult[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final ConstraintAnchor BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type type) {
        int i = AnonymousClass1.PlaceComponentResult[type.ordinal()];
        if (i == 1 || i == 2) {
            if (this.BuiltInFictitiousFunctionClassFactory == 1) {
                return this.getAuthRequestContext;
            }
            return null;
        } else if ((i == 3 || i == 4) && this.BuiltInFictitiousFunctionClassFactory == 0) {
            return this.getAuthRequestContext;
        } else {
            return null;
        }
    }

    public final void PlaceComponentResult(float f) {
        if (f > -1.0f) {
            this.s = f;
            this.MyBillsEntityDataFactory = -1;
            this.f5943o = -1;
        }
    }

    public final void DatabaseTableConfigUtil(int i) {
        if (i >= 0) {
            this.s = -1.0f;
            this.MyBillsEntityDataFactory = i;
            this.f5943o = -1;
        }
    }

    public final void initRecordTimeStamp(int i) {
        if (i >= 0) {
            this.s = -1.0f;
            this.MyBillsEntityDataFactory = -1;
            this.f5943o = i;
        }
    }

    public final float lookAheadTest() {
        return this.s;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.f5943o;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean PlaceComponentResult() {
        return this.t;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean getAuthRequestContext() {
        return this.t;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void KClassImpl$Data$declaredNonStaticMembers$2(LinearSystem linearSystem, boolean z) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.W;
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor BuiltInFictitiousFunctionClassFactory = constraintWidgetContainer.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor BuiltInFictitiousFunctionClassFactory2 = constraintWidgetContainer.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT);
        boolean z2 = true;
        boolean z3 = this.W != null && this.W.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.BuiltInFictitiousFunctionClassFactory == 0) {
            BuiltInFictitiousFunctionClassFactory = constraintWidgetContainer.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP);
            BuiltInFictitiousFunctionClassFactory2 = constraintWidgetContainer.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM);
            if (this.W == null || this.W.getNameOrBuilderList[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z2 = false;
            }
        } else {
            z2 = z3;
        }
        if (this.t && this.getAuthRequestContext.getAuthRequestContext()) {
            SolverVariable PlaceComponentResult = linearSystem.PlaceComponentResult(this.getAuthRequestContext);
            ConstraintAnchor constraintAnchor = this.getAuthRequestContext;
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult);
            if (this.MyBillsEntityDataFactory != -1) {
                if (z2) {
                    linearSystem.PlaceComponentResult(linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2), PlaceComponentResult, 0, 5);
                }
            } else if (this.f5943o != -1 && z2) {
                SolverVariable PlaceComponentResult2 = linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2);
                linearSystem.PlaceComponentResult(PlaceComponentResult, linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory), 0, 5);
                linearSystem.PlaceComponentResult(PlaceComponentResult2, PlaceComponentResult, 0, 5);
            }
            this.t = false;
        } else if (this.MyBillsEntityDataFactory != -1) {
            SolverVariable PlaceComponentResult3 = linearSystem.PlaceComponentResult(this.getAuthRequestContext);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3, linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory), this.MyBillsEntityDataFactory, 8);
            if (z2) {
                linearSystem.PlaceComponentResult(linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2), PlaceComponentResult3, 0, 5);
            }
        } else if (this.f5943o == -1) {
            if (this.s != -1.0f) {
                linearSystem.getAuthRequestContext(LinearSystem.BuiltInFictitiousFunctionClassFactory(linearSystem, linearSystem.PlaceComponentResult(this.getAuthRequestContext), linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2), this.s));
            }
        } else {
            SolverVariable PlaceComponentResult4 = linearSystem.PlaceComponentResult(this.getAuthRequestContext);
            SolverVariable PlaceComponentResult5 = linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult4, PlaceComponentResult5, -this.f5943o, 8);
            if (z2) {
                linearSystem.PlaceComponentResult(PlaceComponentResult4, linearSystem.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory), 0, 5);
                linearSystem.PlaceComponentResult(PlaceComponentResult5, PlaceComponentResult4, 0, 5);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void MyBillsEntityDataFactory(boolean z) {
        if (this.W == null) {
            return;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
        if (this.BuiltInFictitiousFunctionClassFactory == 1) {
            moveToNextValue(KClassImpl$Data$declaredNonStaticMembers$2);
            GetContactSyncConfig(0);
            ConstraintWidget constraintWidget = this.W;
            lookAheadTest(constraintWidget.h == 8 ? 0 : constraintWidget.C);
            getErrorConfigVersion(0);
            return;
        }
        moveToNextValue(0);
        GetContactSyncConfig(KClassImpl$Data$declaredNonStaticMembers$2);
        ConstraintWidget constraintWidget2 = this.W;
        getErrorConfigVersion(constraintWidget2.h == 8 ? 0 : constraintWidget2.FlowViewUtil$textChanges$2);
        lookAheadTest(0);
    }
}
