package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes3.dex */
public abstract class WidgetRun implements Dependency {
    RunGroup NetworkUserEntityData$$ExternalSyntheticLambda0;
    ConstraintWidget NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected ConstraintWidget.DimensionBehaviour PlaceComponentResult;
    public int moveToNextValue;
    public DimensionDependency getAuthRequestContext = new DimensionDependency(this);
    public int getErrorConfigVersion = 0;
    boolean lookAheadTest = false;
    public DependencyNode NetworkUserEntityData$$ExternalSyntheticLambda1 = new DependencyNode(this);
    public DependencyNode MyBillsEntityDataFactory = new DependencyNode(this);
    protected RunType scheduleImpl = RunType.NONE;

    /* loaded from: classes3.dex */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void BuiltInFictitiousFunctionClassFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void KClassImpl$Data$declaredNonStaticMembers$2();

    abstract void MyBillsEntityDataFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean NetworkUserEntityData$$ExternalSyntheticLambda0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void PlaceComponentResult();

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void lookAheadTest() {
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = constraintWidget;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static DependencyNode BuiltInFictitiousFunctionClassFactory(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.moveToNextValue == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.moveToNextValue.lookAheadTest;
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[constraintAnchor.moveToNextValue.getErrorConfigVersion.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return constraintWidget.n.MyBillsEntityDataFactory;
                    }
                    return constraintWidget.n.BuiltInFictitiousFunctionClassFactory;
                }
                return constraintWidget.n.NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
            return constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
        }
        return constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        float f;
        int i2;
        int i3;
        DependencyNode BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(constraintAnchor);
        DependencyNode BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(constraintAnchor2);
        if (BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 && BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            int MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil + constraintAnchor.MyBillsEntityDataFactory();
            int MyBillsEntityDataFactory2 = BuiltInFictitiousFunctionClassFactory2.DatabaseTableConfigUtil - constraintAnchor2.MyBillsEntityDataFactory();
            int i4 = MyBillsEntityDataFactory2 - MyBillsEntityDataFactory;
            if (!this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i5 = this.moveToNextValue;
                if (i5 == 0) {
                    i2 = i4;
                } else if (i5 == 1) {
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(Math.min(KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.initRecordTimeStamp, i), i4));
                } else if (i5 != 2) {
                    if (i5 == 3 && (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue != 3 || this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.moveToNextValue != 3)) {
                        ConstraintWidget constraintWidget = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        if ((i == 0 ? constraintWidget.n : constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda0).getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                            float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.SubSequence;
                            if (i == 1) {
                                i3 = (int) ((r3.getAuthRequestContext.DatabaseTableConfigUtil / f2) + 0.5f);
                            } else {
                                i3 = (int) ((f2 * r3.getAuthRequestContext.DatabaseTableConfigUtil) + 0.5f);
                            }
                            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i3);
                        }
                    }
                } else {
                    ConstraintWidget constraintWidget2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W;
                    if (constraintWidget2 != null) {
                        if ((i == 0 ? constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda0 : constraintWidget2.n).getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                            ConstraintWidget constraintWidget3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                            i2 = (int) ((r3.getAuthRequestContext.DatabaseTableConfigUtil * (i == 0 ? constraintWidget3.S : constraintWidget3.R)) + 0.5f);
                        }
                    }
                }
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(i2, i));
            }
            if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                if (this.getAuthRequestContext.DatabaseTableConfigUtil == i4) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2);
                    return;
                }
                ConstraintWidget constraintWidget4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (i == 0) {
                    f = constraintWidget4.BottomSheetCardBindingView$watcherCardNumberView$1;
                } else {
                    f = constraintWidget4.e;
                }
                if (BuiltInFictitiousFunctionClassFactory == BuiltInFictitiousFunctionClassFactory2) {
                    MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
                    MyBillsEntityDataFactory2 = BuiltInFictitiousFunctionClassFactory2.DatabaseTableConfigUtil;
                    f = 0.5f;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory((int) (MyBillsEntityDataFactory + 0.5f + (((MyBillsEntityDataFactory2 - MyBillsEntityDataFactory) - this.getAuthRequestContext.DatabaseTableConfigUtil) * f)));
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil + this.getAuthRequestContext.DatabaseTableConfigUtil);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        int max;
        if (i2 == 0) {
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.O;
            max = Math.max(this.NetworkUserEntityData$$ExternalSyntheticLambda2.P, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.Q;
            max = Math.max(this.NetworkUserEntityData$$ExternalSyntheticLambda2.SummaryVoucherView$$ExternalSyntheticLambda0, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static DependencyNode getAuthRequestContext(ConstraintAnchor constraintAnchor, int i) {
        if (constraintAnchor.moveToNextValue == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.moveToNextValue.lookAheadTest;
        WidgetRun widgetRun = i == 0 ? constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda0 : constraintWidget.n;
        int i2 = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[constraintAnchor.moveToNextValue.getErrorConfigVersion.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.MyBillsEntityDataFactory;
        }
        return widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.getErrorConfigVersion.add(dependencyNode2);
        dependencyNode.getErrorConfigVersion.add(this.getAuthRequestContext);
        dependencyNode.MyBillsEntityDataFactory = i;
        dependencyNode.getAuthRequestContext = dimensionDependency;
        dependencyNode2.BuiltInFictitiousFunctionClassFactory.add(dependencyNode);
        dimensionDependency.BuiltInFictitiousFunctionClassFactory.add(dependencyNode);
    }

    public long getAuthRequestContext() {
        if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return this.getAuthRequestContext.DatabaseTableConfigUtil;
        }
        return 0L;
    }

    public final boolean getErrorConfigVersion() {
        return this.lookAheadTest;
    }
}
