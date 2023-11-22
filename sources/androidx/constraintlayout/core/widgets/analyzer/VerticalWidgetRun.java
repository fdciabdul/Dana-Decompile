package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes3.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode BuiltInFictitiousFunctionClassFactory;
    DimensionDependency KClassImpl$Data$declaredNonStaticMembers$2;

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.BuiltInFictitiousFunctionClassFactory = new DependencyNode(this);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest = DependencyNode.Type.TOP;
        this.MyBillsEntityDataFactory.lookAheadTest = DependencyNode.Type.BOTTOM;
        this.BuiltInFictitiousFunctionClassFactory.lookAheadTest = DependencyNode.Type.BASELINE;
        this.getErrorConfigVersion = 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerticalRun ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda4);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory();
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
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
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.NetworkUserEntityData$$ExternalSyntheticLambda2.K == 0;
    }

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void lookAheadTest() {
        float f;
        float f2;
        float f3;
        int i;
        int i2 = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[this.scheduleImpl.ordinal()];
        if (i2 != 1 && i2 != 2 && i2 == 3) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda2.f5939a, this.NetworkUserEntityData$$ExternalSyntheticLambda2.isLayoutRequested, 1);
            return;
        }
        if (this.getAuthRequestContext.moveToNextValue && !this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.K;
            if (i3 != 2) {
                if (i3 == 3 && this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    int c_ = this.NetworkUserEntityData$$ExternalSyntheticLambda2.c_();
                    if (c_ == -1) {
                        f = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.DatabaseTableConfigUtil;
                        f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.SubSequence;
                    } else if (c_ == 0) {
                        f3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.DatabaseTableConfigUtil * this.NetworkUserEntityData$$ExternalSyntheticLambda2.SubSequence;
                        i = (int) (f3 + 0.5f);
                        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i);
                    } else if (c_ == 1) {
                        f = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.DatabaseTableConfigUtil;
                        f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.SubSequence;
                    } else {
                        i = 0;
                        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i);
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i);
                }
            } else {
                ConstraintWidget constraintWidget = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W;
                if (constraintWidget != null && constraintWidget.n.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory((int) ((constraintWidget.n.getAuthRequestContext.DatabaseTableConfigUtil * this.NetworkUserEntityData$$ExternalSyntheticLambda2.R) + 0.5f));
                }
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.moveToNextValue && this.MyBillsEntityDataFactory.moveToNextValue) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return;
            }
            if (!this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.NetworkUserEntityData$$ExternalSyntheticLambda2.N == 0 && !this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                DependencyNode dependencyNode = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion.get(0);
                DependencyNode dependencyNode2 = this.MyBillsEntityDataFactory.getErrorConfigVersion.get(0);
                int i4 = dependencyNode.DatabaseTableConfigUtil + this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2;
                int i5 = dependencyNode2.DatabaseTableConfigUtil + this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(i4);
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i5);
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i5 - i4);
                return;
            }
            if (!this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.moveToNextValue == 1 && this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion.size() > 0 && this.MyBillsEntityDataFactory.getErrorConfigVersion.size() > 0) {
                int i6 = (this.MyBillsEntityDataFactory.getErrorConfigVersion.get(0).DatabaseTableConfigUtil + this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) - (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion.get(0).DatabaseTableConfigUtil + this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2);
                if (i6 < this.getAuthRequestContext.initRecordTimeStamp) {
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i6);
                } else {
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.initRecordTimeStamp);
                }
            }
            if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion.size() > 0 && this.MyBillsEntityDataFactory.getErrorConfigVersion.size() > 0) {
                DependencyNode dependencyNode3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion.get(0);
                DependencyNode dependencyNode4 = this.MyBillsEntityDataFactory.getErrorConfigVersion.get(0);
                int i7 = dependencyNode3.DatabaseTableConfigUtil + this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2;
                int i8 = dependencyNode4.DatabaseTableConfigUtil + this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                float f4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.e;
                if (dependencyNode3 == dependencyNode4) {
                    i7 = dependencyNode3.DatabaseTableConfigUtil;
                    i8 = dependencyNode4.DatabaseTableConfigUtil;
                    f4 = 0.5f;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory((int) (i7 + 0.5f + (((i8 - i7) - this.getAuthRequestContext.DatabaseTableConfigUtil) * f4)));
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil + this.getAuthRequestContext.DatabaseTableConfigUtil);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void BuiltInFictitiousFunctionClassFactory() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.access$throwIllegalArgumentType) {
            DimensionDependency dimensionDependency = this.getAuthRequestContext;
            ConstraintWidget constraintWidget3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            dimensionDependency.BuiltInFictitiousFunctionClassFactory(constraintWidget3.h == 8 ? 0 : constraintWidget3.C);
        }
        if (!this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getNameOrBuilderList[1];
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new BaselineDimensionDependency(this);
            }
            if (this.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.PlaceComponentResult != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || (constraintWidget2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W) == null || constraintWidget2.getNameOrBuilderList[1] != ConstraintWidget.DimensionBehaviour.FIXED) {
                    if (this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.FIXED) {
                        DimensionDependency dimensionDependency2 = this.getAuthRequestContext;
                        ConstraintWidget constraintWidget4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        dimensionDependency2.BuiltInFictitiousFunctionClassFactory(constraintWidget4.h == 8 ? 0 : constraintWidget4.C);
                    }
                } else {
                    int i = constraintWidget2.h != 8 ? constraintWidget2.C : 0;
                    int MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda2.f5939a.MyBillsEntityDataFactory();
                    int MyBillsEntityDataFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.isLayoutRequested.MyBillsEntityDataFactory();
                    DependencyNode dependencyNode = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    DependencyNode dependencyNode2 = constraintWidget2.n.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int MyBillsEntityDataFactory3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.f5939a.MyBillsEntityDataFactory();
                    dependencyNode.getErrorConfigVersion.add(dependencyNode2);
                    dependencyNode.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory3;
                    dependencyNode2.BuiltInFictitiousFunctionClassFactory.add(dependencyNode);
                    DependencyNode dependencyNode3 = this.MyBillsEntityDataFactory;
                    DependencyNode dependencyNode4 = constraintWidget2.n.MyBillsEntityDataFactory;
                    int i2 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.isLayoutRequested.MyBillsEntityDataFactory();
                    dependencyNode3.getErrorConfigVersion.add(dependencyNode4);
                    dependencyNode3.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
                    dependencyNode4.BuiltInFictitiousFunctionClassFactory.add(dependencyNode3);
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory((i - MyBillsEntityDataFactory) - MyBillsEntityDataFactory2);
                    return;
                }
            }
        } else if (this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W) != null && constraintWidget.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
            DependencyNode dependencyNode5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            DependencyNode dependencyNode6 = constraintWidget.n.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int MyBillsEntityDataFactory4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.f5939a.MyBillsEntityDataFactory();
            dependencyNode5.getErrorConfigVersion.add(dependencyNode6);
            dependencyNode5.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory4;
            dependencyNode6.BuiltInFictitiousFunctionClassFactory.add(dependencyNode5);
            DependencyNode dependencyNode7 = this.MyBillsEntityDataFactory;
            DependencyNode dependencyNode8 = constraintWidget.n.MyBillsEntityDataFactory;
            int i3 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.isLayoutRequested.MyBillsEntityDataFactory();
            dependencyNode7.getErrorConfigVersion.add(dependencyNode8);
            dependencyNode7.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            dependencyNode8.BuiltInFictitiousFunctionClassFactory.add(dependencyNode7);
            return;
        }
        if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.NetworkUserEntityData$$ExternalSyntheticLambda2.access$throwIllegalArgumentType) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].moveToNextValue != null && this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].moveToNextValue != null) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].MyBillsEntityDataFactory();
                    this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].MyBillsEntityDataFactory();
                } else {
                    DependencyNode BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2]);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        DependencyNode dependencyNode9 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        int MyBillsEntityDataFactory5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].MyBillsEntityDataFactory();
                        dependencyNode9.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory);
                        dependencyNode9.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory5;
                        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.add(dependencyNode9);
                    }
                    DependencyNode BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3]);
                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                        DependencyNode dependencyNode10 = this.MyBillsEntityDataFactory;
                        int i4 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].MyBillsEntityDataFactory();
                        dependencyNode10.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory2);
                        dependencyNode10.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
                        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory.add(dependencyNode10);
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult = true;
                    this.MyBillsEntityDataFactory.PlaceComponentResult = true;
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                    DependencyNode dependencyNode11 = this.BuiltInFictitiousFunctionClassFactory;
                    DependencyNode dependencyNode12 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    dependencyNode11.getErrorConfigVersion.add(dependencyNode12);
                    dependencyNode11.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
                    dependencyNode12.BuiltInFictitiousFunctionClassFactory.add(dependencyNode11);
                    return;
                }
                return;
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].moveToNextValue != null) {
                DependencyNode BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2]);
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    DependencyNode dependencyNode13 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int MyBillsEntityDataFactory6 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].MyBillsEntityDataFactory();
                    dependencyNode13.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory3);
                    dependencyNode13.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory6;
                    BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory.add(dependencyNode13);
                    DependencyNode dependencyNode14 = this.MyBillsEntityDataFactory;
                    DependencyNode dependencyNode15 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int i6 = this.getAuthRequestContext.DatabaseTableConfigUtil;
                    dependencyNode14.getErrorConfigVersion.add(dependencyNode15);
                    dependencyNode14.KClassImpl$Data$declaredNonStaticMembers$2 = i6;
                    dependencyNode15.BuiltInFictitiousFunctionClassFactory.add(dependencyNode14);
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                        DependencyNode dependencyNode16 = this.BuiltInFictitiousFunctionClassFactory;
                        DependencyNode dependencyNode17 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        int i7 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        dependencyNode16.getErrorConfigVersion.add(dependencyNode17);
                        dependencyNode16.KClassImpl$Data$declaredNonStaticMembers$2 = i7;
                        dependencyNode17.BuiltInFictitiousFunctionClassFactory.add(dependencyNode16);
                        return;
                    }
                    return;
                }
                return;
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].moveToNextValue != null) {
                DependencyNode BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3]);
                if (BuiltInFictitiousFunctionClassFactory4 != null) {
                    DependencyNode dependencyNode18 = this.MyBillsEntityDataFactory;
                    int i8 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].MyBillsEntityDataFactory();
                    dependencyNode18.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory4);
                    dependencyNode18.KClassImpl$Data$declaredNonStaticMembers$2 = i8;
                    BuiltInFictitiousFunctionClassFactory4.BuiltInFictitiousFunctionClassFactory.add(dependencyNode18);
                    DependencyNode dependencyNode19 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    DependencyNode dependencyNode20 = this.MyBillsEntityDataFactory;
                    int i9 = -this.getAuthRequestContext.DatabaseTableConfigUtil;
                    dependencyNode19.getErrorConfigVersion.add(dependencyNode20);
                    dependencyNode19.KClassImpl$Data$declaredNonStaticMembers$2 = i9;
                    dependencyNode20.BuiltInFictitiousFunctionClassFactory.add(dependencyNode19);
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                    DependencyNode dependencyNode21 = this.BuiltInFictitiousFunctionClassFactory;
                    DependencyNode dependencyNode22 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int i10 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    dependencyNode21.getErrorConfigVersion.add(dependencyNode22);
                    dependencyNode21.KClassImpl$Data$declaredNonStaticMembers$2 = i10;
                    dependencyNode22.BuiltInFictitiousFunctionClassFactory.add(dependencyNode21);
                    return;
                }
                return;
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[4].moveToNextValue != null) {
                DependencyNode BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[4]);
                if (BuiltInFictitiousFunctionClassFactory5 != null) {
                    DependencyNode dependencyNode23 = this.BuiltInFictitiousFunctionClassFactory;
                    dependencyNode23.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory5);
                    dependencyNode23.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                    BuiltInFictitiousFunctionClassFactory5.BuiltInFictitiousFunctionClassFactory.add(dependencyNode23);
                    DependencyNode dependencyNode24 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    DependencyNode dependencyNode25 = this.BuiltInFictitiousFunctionClassFactory;
                    int i11 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    dependencyNode24.getErrorConfigVersion.add(dependencyNode25);
                    dependencyNode24.KClassImpl$Data$declaredNonStaticMembers$2 = i11;
                    dependencyNode25.BuiltInFictitiousFunctionClassFactory.add(dependencyNode24);
                    DependencyNode dependencyNode26 = this.MyBillsEntityDataFactory;
                    DependencyNode dependencyNode27 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int i12 = this.getAuthRequestContext.DatabaseTableConfigUtil;
                    dependencyNode26.getErrorConfigVersion.add(dependencyNode27);
                    dependencyNode26.KClassImpl$Data$declaredNonStaticMembers$2 = i12;
                    dependencyNode27.BuiltInFictitiousFunctionClassFactory.add(dependencyNode26);
                    return;
                }
                return;
            } else if ((this.NetworkUserEntityData$$ExternalSyntheticLambda2 instanceof Helper) || this.NetworkUserEntityData$$ExternalSyntheticLambda2.W == null || this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER).moveToNextValue != null) {
                return;
            } else {
                DependencyNode dependencyNode28 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W.n.NetworkUserEntityData$$ExternalSyntheticLambda1;
                DependencyNode dependencyNode29 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int DatabaseTableConfigUtil = this.NetworkUserEntityData$$ExternalSyntheticLambda2.DatabaseTableConfigUtil();
                dependencyNode29.getErrorConfigVersion.add(dependencyNode28);
                dependencyNode29.KClassImpl$Data$declaredNonStaticMembers$2 = DatabaseTableConfigUtil;
                dependencyNode28.BuiltInFictitiousFunctionClassFactory.add(dependencyNode29);
                DependencyNode dependencyNode30 = this.MyBillsEntityDataFactory;
                DependencyNode dependencyNode31 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i13 = this.getAuthRequestContext.DatabaseTableConfigUtil;
                dependencyNode30.getErrorConfigVersion.add(dependencyNode31);
                dependencyNode30.KClassImpl$Data$declaredNonStaticMembers$2 = i13;
                dependencyNode31.BuiltInFictitiousFunctionClassFactory.add(dependencyNode30);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                    DependencyNode dependencyNode32 = this.BuiltInFictitiousFunctionClassFactory;
                    DependencyNode dependencyNode33 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int i14 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    dependencyNode32.getErrorConfigVersion.add(dependencyNode33);
                    dependencyNode32.KClassImpl$Data$declaredNonStaticMembers$2 = i14;
                    dependencyNode33.BuiltInFictitiousFunctionClassFactory.add(dependencyNode32);
                    return;
                }
                return;
            }
        }
        if (!this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i15 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.K;
            if (i15 != 2) {
                if (i15 == 3 && !this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda5() && this.NetworkUserEntityData$$ExternalSyntheticLambda2.N != 3) {
                    DimensionDependency dimensionDependency3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
                    this.getAuthRequestContext.getErrorConfigVersion.add(dimensionDependency3);
                    dimensionDependency3.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    this.getAuthRequestContext.PlaceComponentResult = true;
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.MyBillsEntityDataFactory);
                }
            } else {
                ConstraintWidget constraintWidget5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W;
                if (constraintWidget5 != null) {
                    DimensionDependency dimensionDependency4 = constraintWidget5.n.getAuthRequestContext;
                    this.getAuthRequestContext.getErrorConfigVersion.add(dimensionDependency4);
                    dimensionDependency4.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    this.getAuthRequestContext.PlaceComponentResult = true;
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.MyBillsEntityDataFactory);
                }
            }
        } else {
            DimensionDependency dimensionDependency5 = this.getAuthRequestContext;
            dimensionDependency5.BuiltInFictitiousFunctionClassFactory.add(this);
            if (dimensionDependency5.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                lookAheadTest();
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].moveToNextValue != null && this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].moveToNextValue != null) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].MyBillsEntityDataFactory();
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].MyBillsEntityDataFactory();
            } else {
                DependencyNode BuiltInFictitiousFunctionClassFactory6 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2]);
                DependencyNode BuiltInFictitiousFunctionClassFactory7 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3]);
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
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].moveToNextValue != null) {
            DependencyNode BuiltInFictitiousFunctionClassFactory8 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2]);
            if (BuiltInFictitiousFunctionClassFactory8 != null) {
                DependencyNode dependencyNode34 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int MyBillsEntityDataFactory7 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[2].MyBillsEntityDataFactory();
                dependencyNode34.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory8);
                dependencyNode34.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory7;
                BuiltInFictitiousFunctionClassFactory8.BuiltInFictitiousFunctionClassFactory.add(dependencyNode34);
                BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.getAuthRequestContext);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                    BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.NetworkUserEntityData$$ExternalSyntheticLambda2.SubSequence > 0.0f && this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                    this.getAuthRequestContext.getErrorConfigVersion.add(this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext);
                    this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
                }
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].moveToNextValue != null) {
            DependencyNode BuiltInFictitiousFunctionClassFactory9 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3]);
            if (BuiltInFictitiousFunctionClassFactory9 != null) {
                DependencyNode dependencyNode35 = this.MyBillsEntityDataFactory;
                int i16 = -this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[3].MyBillsEntityDataFactory();
                dependencyNode35.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory9);
                dependencyNode35.KClassImpl$Data$declaredNonStaticMembers$2 = i16;
                BuiltInFictitiousFunctionClassFactory9.BuiltInFictitiousFunctionClassFactory.add(dependencyNode35);
                BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.MyBillsEntityDataFactory, -1, this.getAuthRequestContext);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                    BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[4].moveToNextValue != null) {
            DependencyNode BuiltInFictitiousFunctionClassFactory10 = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2.J[4]);
            if (BuiltInFictitiousFunctionClassFactory10 != null) {
                DependencyNode dependencyNode36 = this.BuiltInFictitiousFunctionClassFactory;
                dependencyNode36.getErrorConfigVersion.add(BuiltInFictitiousFunctionClassFactory10);
                dependencyNode36.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                BuiltInFictitiousFunctionClassFactory10.BuiltInFictitiousFunctionClassFactory.add(dependencyNode36);
                BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.BuiltInFictitiousFunctionClassFactory, -1, this.KClassImpl$Data$declaredNonStaticMembers$2);
                BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.getAuthRequestContext);
            }
        } else if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda2 instanceof Helper) && this.NetworkUserEntityData$$ExternalSyntheticLambda2.W != null) {
            DependencyNode dependencyNode37 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.W.n.NetworkUserEntityData$$ExternalSyntheticLambda1;
            DependencyNode dependencyNode38 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int DatabaseTableConfigUtil2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.DatabaseTableConfigUtil();
            dependencyNode38.getErrorConfigVersion.add(dependencyNode37);
            dependencyNode38.KClassImpl$Data$declaredNonStaticMembers$2 = DatabaseTableConfigUtil2;
            dependencyNode37.BuiltInFictitiousFunctionClassFactory.add(dependencyNode38);
            BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.getAuthRequestContext);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 1, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (this.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.NetworkUserEntityData$$ExternalSyntheticLambda2.SubSequence > 0.0f && this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.add(this.getAuthRequestContext);
                this.getAuthRequestContext.getErrorConfigVersion.add(this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext);
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
            }
        }
        if (this.getAuthRequestContext.getErrorConfigVersion.size() == 0) {
            this.getAuthRequestContext.moveToNextValue = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void PlaceComponentResult() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.GetContactSyncConfig(this.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil);
        }
    }
}
