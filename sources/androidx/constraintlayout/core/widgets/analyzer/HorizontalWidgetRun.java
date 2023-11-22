package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes3.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] BuiltInFictitiousFunctionClassFactory = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest = DependencyNode.Type.LEFT;
        this.MyBillsEntityDataFactory.lookAheadTest = DependencyNode.Type.RIGHT;
        this.getErrorConfigVersion = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HorizontalRun ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda4);
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory();
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        this.getAuthRequestContext.MyBillsEntityDataFactory();
        this.lookAheadTest = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void MyBillsEntityDataFactory() {
        this.lookAheadTest = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.NetworkUserEntityData$$ExternalSyntheticLambda2.N == 0;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    final void BuiltInFictitiousFunctionClassFactory() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.access$throwIllegalArgumentType) {
            DimensionDependency dimensionDependency = this.getAuthRequestContext;
            ConstraintWidget constraintWidget3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            dimensionDependency.BuiltInFictitiousFunctionClassFactory(constraintWidget3.h == 8 ? 0 : constraintWidget3.FlowViewUtil$textChanges$2);
        }
        if (!this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getNameOrBuilderList[0];
            if (this.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || (constraintWidget2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W) == null || (constraintWidget2.getNameOrBuilderList[0] != ConstraintWidget.DimensionBehaviour.FIXED && constraintWidget2.getNameOrBuilderList[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    if (this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.FIXED) {
                        DimensionDependency dimensionDependency2 = this.getAuthRequestContext;
                        ConstraintWidget constraintWidget4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        dimensionDependency2.BuiltInFictitiousFunctionClassFactory(constraintWidget4.h == 8 ? 0 : constraintWidget4.FlowViewUtil$textChanges$2);
                    }
                } else {
                    int i = constraintWidget2.h != 8 ? constraintWidget2.FlowViewUtil$textChanges$2 : 0;
                    int MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda2.I.MyBillsEntityDataFactory();
                    int MyBillsEntityDataFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.c.MyBillsEntityDataFactory();
                    DependencyNode dependencyNode = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    DependencyNode dependencyNode2 = constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int MyBillsEntityDataFactory3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.I.MyBillsEntityDataFactory();
                    dependencyNode.getErrorConfigVersion.add(dependencyNode2);
                    dependencyNode.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory3;
                    dependencyNode2.BuiltInFictitiousFunctionClassFactory.add(dependencyNode);
                    DependencyNode dependencyNode3 = this.MyBillsEntityDataFactory;
                    DependencyNode dependencyNode4 = constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
                    int i2 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.c.MyBillsEntityDataFactory();
                    dependencyNode3.getErrorConfigVersion.add(dependencyNode4);
                    dependencyNode3.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
                    dependencyNode4.BuiltInFictitiousFunctionClassFactory.add(dependencyNode3);
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory((i - MyBillsEntityDataFactory) - MyBillsEntityDataFactory2);
                    return;
                }
            }
        } else if (this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W) != null && (constraintWidget.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidget.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            DependencyNode dependencyNode5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            DependencyNode dependencyNode6 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int MyBillsEntityDataFactory4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.I.MyBillsEntityDataFactory();
            dependencyNode5.getErrorConfigVersion.add(dependencyNode6);
            dependencyNode5.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory4;
            dependencyNode6.BuiltInFictitiousFunctionClassFactory.add(dependencyNode5);
            DependencyNode dependencyNode7 = this.MyBillsEntityDataFactory;
            DependencyNode dependencyNode8 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
            int i3 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.c.MyBillsEntityDataFactory();
            dependencyNode7.getErrorConfigVersion.add(dependencyNode8);
            dependencyNode7.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            dependencyNode8.BuiltInFictitiousFunctionClassFactory.add(dependencyNode7);
            return;
        }
        if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.NetworkUserEntityData$$ExternalSyntheticLambda2.access$throwIllegalArgumentType) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].moveToNextValue != null && this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].moveToNextValue != null) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.newProxyInstance()) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].MyBillsEntityDataFactory();
                    this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].MyBillsEntityDataFactory();
                    return;
                }
                DependencyNode BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0]);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    DependencyNode dependencyNode9 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int MyBillsEntityDataFactory5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].MyBillsEntityDataFactory();
                    dependencyNode9.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory2);
                    dependencyNode9.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory5;
                    BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory.add(dependencyNode9);
                }
                DependencyNode BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1]);
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    DependencyNode dependencyNode10 = this.MyBillsEntityDataFactory;
                    int i4 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].MyBillsEntityDataFactory();
                    dependencyNode10.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory3);
                    dependencyNode10.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
                    BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory.add(dependencyNode10);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult = true;
                this.MyBillsEntityDataFactory.PlaceComponentResult = true;
                return;
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].moveToNextValue != null) {
                DependencyNode BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0]);
                if (BuiltInFictitiousFunctionClassFactory4 != null) {
                    DependencyNode dependencyNode11 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int MyBillsEntityDataFactory6 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].MyBillsEntityDataFactory();
                    dependencyNode11.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory4);
                    dependencyNode11.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory6;
                    BuiltInFictitiousFunctionClassFactory4.BuiltInFictitiousFunctionClassFactory.add(dependencyNode11);
                    DependencyNode dependencyNode12 = this.MyBillsEntityDataFactory;
                    DependencyNode dependencyNode13 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int i5 = this.getAuthRequestContext.DatabaseTableConfigUtil;
                    dependencyNode12.getErrorConfigVersion.add(dependencyNode13);
                    dependencyNode12.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
                    dependencyNode13.BuiltInFictitiousFunctionClassFactory.add(dependencyNode12);
                    return;
                }
                return;
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].moveToNextValue != null) {
                DependencyNode BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1]);
                if (BuiltInFictitiousFunctionClassFactory5 != null) {
                    DependencyNode dependencyNode14 = this.MyBillsEntityDataFactory;
                    int i6 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].MyBillsEntityDataFactory();
                    dependencyNode14.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory5);
                    dependencyNode14.KClassImpl$Data$declaredNonStaticMembers$2 = i6;
                    BuiltInFictitiousFunctionClassFactory5.BuiltInFictitiousFunctionClassFactory.add(dependencyNode14);
                    DependencyNode dependencyNode15 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    DependencyNode dependencyNode16 = this.MyBillsEntityDataFactory;
                    int i7 = -this.getAuthRequestContext.DatabaseTableConfigUtil;
                    dependencyNode15.getErrorConfigVersion.add(dependencyNode16);
                    dependencyNode15.KClassImpl$Data$declaredNonStaticMembers$2 = i7;
                    dependencyNode16.BuiltInFictitiousFunctionClassFactory.add(dependencyNode15);
                    return;
                }
                return;
            } else if ((this.NetworkUserEntityData$$ExternalSyntheticLambda2 instanceof Helper) || this.NetworkUserEntityData$$ExternalSyntheticLambda2.W == null || this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER).moveToNextValue != null) {
                return;
            } else {
                DependencyNode dependencyNode17 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1;
                DependencyNode dependencyNode18 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int NetworkUserEntityData$$ExternalSyntheticLambda1 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda1();
                dependencyNode18.getErrorConfigVersion.add(dependencyNode17);
                dependencyNode18.KClassImpl$Data$declaredNonStaticMembers$2 = NetworkUserEntityData$$ExternalSyntheticLambda1;
                dependencyNode17.BuiltInFictitiousFunctionClassFactory.add(dependencyNode18);
                DependencyNode dependencyNode19 = this.MyBillsEntityDataFactory;
                DependencyNode dependencyNode20 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i8 = this.getAuthRequestContext.DatabaseTableConfigUtil;
                dependencyNode19.getErrorConfigVersion.add(dependencyNode20);
                dependencyNode19.KClassImpl$Data$declaredNonStaticMembers$2 = i8;
                dependencyNode20.BuiltInFictitiousFunctionClassFactory.add(dependencyNode19);
                return;
            }
        }
        if (this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i9 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.N;
            if (i9 == 2) {
                ConstraintWidget constraintWidget5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W;
                if (constraintWidget5 != null) {
                    DimensionDependency dimensionDependency3 = constraintWidget5.n.getAuthRequestContext;
                    this.getAuthRequestContext.getErrorConfigVersion.add(dimensionDependency3);
                    dimensionDependency3.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    this.getAuthRequestContext.PlaceComponentResult = true;
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.MyBillsEntityDataFactory);
                }
            } else if (i9 == 3) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.K == 3) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
                    this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
                    this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                        this.getAuthRequestContext.getErrorConfigVersion.add(this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.getAuthRequestContext);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
                        this.getAuthRequestContext.getErrorConfigVersion.add(this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        this.getAuthRequestContext.getErrorConfigVersion.add(this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.MyBillsEntityDataFactory);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.newProxyInstance()) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.getAuthRequestContext.getErrorConfigVersion.add(this.getAuthRequestContext);
                        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.getAuthRequestContext);
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.getAuthRequestContext.getErrorConfigVersion.add(this.getAuthRequestContext);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.getAuthRequestContext;
                    this.getAuthRequestContext.getErrorConfigVersion.add(dimensionDependency4);
                    dimensionDependency4.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.n.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    this.getAuthRequestContext.PlaceComponentResult = true;
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.MyBillsEntityDataFactory);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion.add(this.getAuthRequestContext);
                    this.MyBillsEntityDataFactory.getErrorConfigVersion.add(this.getAuthRequestContext);
                }
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].moveToNextValue != null && this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].moveToNextValue != null) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.newProxyInstance()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].MyBillsEntityDataFactory();
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].MyBillsEntityDataFactory();
                return;
            }
            DependencyNode BuiltInFictitiousFunctionClassFactory6 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0]);
            DependencyNode BuiltInFictitiousFunctionClassFactory7 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1]);
            if (BuiltInFictitiousFunctionClassFactory6 != null) {
                BuiltInFictitiousFunctionClassFactory6.BuiltInFictitiousFunctionClassFactory.add(this);
                if (BuiltInFictitiousFunctionClassFactory6.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    lookAheadTest();
                }
            }
            if (BuiltInFictitiousFunctionClassFactory7 != null) {
                BuiltInFictitiousFunctionClassFactory7.BuiltInFictitiousFunctionClassFactory.add(this);
                if (BuiltInFictitiousFunctionClassFactory7.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    lookAheadTest();
                }
            }
            this.scheduleImpl = WidgetRun.RunType.CENTER;
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].moveToNextValue != null) {
            DependencyNode BuiltInFictitiousFunctionClassFactory8 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0]);
            if (BuiltInFictitiousFunctionClassFactory8 != null) {
                DependencyNode dependencyNode21 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int MyBillsEntityDataFactory7 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[0].MyBillsEntityDataFactory();
                dependencyNode21.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory8);
                dependencyNode21.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory7;
                BuiltInFictitiousFunctionClassFactory8.BuiltInFictitiousFunctionClassFactory.add(dependencyNode21);
                BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.getAuthRequestContext);
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].moveToNextValue != null) {
            DependencyNode BuiltInFictitiousFunctionClassFactory9 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1]);
            if (BuiltInFictitiousFunctionClassFactory9 != null) {
                DependencyNode dependencyNode22 = this.MyBillsEntityDataFactory;
                int i10 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[1].MyBillsEntityDataFactory();
                dependencyNode22.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory9);
                dependencyNode22.KClassImpl$Data$declaredNonStaticMembers$2 = i10;
                BuiltInFictitiousFunctionClassFactory9.BuiltInFictitiousFunctionClassFactory.add(dependencyNode22);
                BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.MyBillsEntityDataFactory, -1, this.getAuthRequestContext);
            }
        } else if ((this.NetworkUserEntityData$$ExternalSyntheticLambda2 instanceof Helper) || this.NetworkUserEntityData$$ExternalSyntheticLambda2.W == null) {
        } else {
            DependencyNode dependencyNode23 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1;
            DependencyNode dependencyNode24 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int NetworkUserEntityData$$ExternalSyntheticLambda12 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda1();
            dependencyNode24.getErrorConfigVersion.add(dependencyNode23);
            dependencyNode24.KClassImpl$Data$declaredNonStaticMembers$2 = NetworkUserEntityData$$ExternalSyntheticLambda12;
            dependencyNode23.BuiltInFictitiousFunctionClassFactory.add(dependencyNode24);
            BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.getAuthRequestContext);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else if (i5 == 1) {
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            } else {
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x02cd, code lost:
    
        if (r11 != 1) goto L125;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void lookAheadTest() {
        /*
            Method dump skipped, instructions count: 1121
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.lookAheadTest():void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void PlaceComponentResult() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue(this.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil);
        }
    }
}
