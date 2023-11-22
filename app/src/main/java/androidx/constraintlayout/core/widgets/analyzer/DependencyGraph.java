package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DependencyGraph {
    private ConstraintWidgetContainer KClassImpl$Data$declaredNonStaticMembers$2;
    private ConstraintWidgetContainer scheduleImpl;
    public boolean PlaceComponentResult = true;
    public boolean getAuthRequestContext = true;
    private ArrayList<WidgetRun> getErrorConfigVersion = new ArrayList<>();
    private ArrayList<RunGroup> NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList<>();
    public BasicMeasure.Measurer BuiltInFictitiousFunctionClassFactory = null;
    private BasicMeasure.Measure lookAheadTest = new BasicMeasure.Measure();
    ArrayList<RunGroup> MyBillsEntityDataFactory = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintWidgetContainer;
        this.scheduleImpl = constraintWidgetContainer;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getAuthRequestContext(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r18, int r19) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.getAuthRequestContext(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int):int");
    }

    public final boolean PlaceComponentResult(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = z & true;
        if (this.PlaceComponentResult || this.getAuthRequestContext) {
            Iterator<ConstraintWidget> it = this.KClassImpl$Data$declaredNonStaticMembers$2.getContainerAuth.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.b_();
                next.access$throwIllegalArgumentType = false;
                next.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
                next.n.MyBillsEntityDataFactory();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.b_();
            this.KClassImpl$Data$declaredNonStaticMembers$2.access$throwIllegalArgumentType = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
            this.KClassImpl$Data$declaredNonStaticMembers$2.n.MyBillsEntityDataFactory();
            this.getAuthRequestContext = false;
        }
        getAuthRequestContext(this.scheduleImpl);
        this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue(0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1];
        if (this.PlaceComponentResult) {
            getAuthRequestContext();
        }
        int NetworkUserEntityData$$ExternalSyntheticLambda1 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1();
        int DatabaseTableConfigUtil = this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil();
        this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.KClassImpl$Data$declaredNonStaticMembers$2.n.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil);
        MyBillsEntityDataFactory();
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            if (z4) {
                Iterator<WidgetRun> it2 = this.getErrorConfigVersion.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!it2.next().NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                        z4 = false;
                        break;
                    }
                }
            }
            if (z4 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                ConstraintWidgetContainer constraintWidgetContainer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                constraintWidgetContainer.getErrorConfigVersion(getAuthRequestContext(constraintWidgetContainer, 0));
                DimensionDependency dimensionDependency = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
                ConstraintWidgetContainer constraintWidgetContainer2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                dimensionDependency.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer2.h == 8 ? 0 : constraintWidgetContainer2.FlowViewUtil$textChanges$2);
            }
            if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                constraintWidgetContainer3.lookAheadTest(getAuthRequestContext(constraintWidgetContainer3, 1));
                DimensionDependency dimensionDependency2 = this.KClassImpl$Data$declaredNonStaticMembers$2.n.getAuthRequestContext;
                ConstraintWidgetContainer constraintWidgetContainer4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                dimensionDependency2.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer4.h == 8 ? 0 : constraintWidgetContainer4.C);
            }
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            ConstraintWidgetContainer constraintWidgetContainer5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = (constraintWidgetContainer5.h == 8 ? 0 : constraintWidgetContainer5.FlowViewUtil$textChanges$2) + NetworkUserEntityData$$ExternalSyntheticLambda1;
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i);
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i - NetworkUserEntityData$$ExternalSyntheticLambda1);
            MyBillsEntityDataFactory();
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                ConstraintWidgetContainer constraintWidgetContainer6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = (constraintWidgetContainer6.h == 8 ? 0 : constraintWidgetContainer6.C) + DatabaseTableConfigUtil;
                this.KClassImpl$Data$declaredNonStaticMembers$2.n.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i2);
                this.KClassImpl$Data$declaredNonStaticMembers$2.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i2 - DatabaseTableConfigUtil);
            }
            MyBillsEntityDataFactory();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<WidgetRun> it3 = this.getErrorConfigVersion.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.NetworkUserEntityData$$ExternalSyntheticLambda2 != this.KClassImpl$Data$declaredNonStaticMembers$2 || next2.lookAheadTest) {
                next2.PlaceComponentResult();
            }
        }
        Iterator<WidgetRun> it4 = this.getErrorConfigVersion.iterator();
        while (it4.hasNext()) {
            WidgetRun next3 = it4.next();
            if (z2 || next3.NetworkUserEntityData$$ExternalSyntheticLambda2 != this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (!next3.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 || ((!next3.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 && !(next3 instanceof GuidelineReference)) || (!next3.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)))) {
                    z3 = false;
                    break;
                }
            }
        }
        z3 = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] = dimensionBehaviour;
        this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] = dimensionBehaviour2;
        return z3;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult) {
            Iterator<ConstraintWidget> it = this.KClassImpl$Data$declaredNonStaticMembers$2.getContainerAuth.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.b_();
                next.access$throwIllegalArgumentType = false;
                next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                next.NetworkUserEntityData$$ExternalSyntheticLambda0.lookAheadTest = false;
                next.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
                next.n.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                next.n.lookAheadTest = false;
                next.n.MyBillsEntityDataFactory();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.b_();
            this.KClassImpl$Data$declaredNonStaticMembers$2.access$throwIllegalArgumentType = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.lookAheadTest = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
            this.KClassImpl$Data$declaredNonStaticMembers$2.n.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.n.lookAheadTest = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.n.MyBillsEntityDataFactory();
            getAuthRequestContext();
        }
        getAuthRequestContext(this.scheduleImpl);
        this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue(0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig(0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.n.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(0);
        return true;
    }

    public final boolean MyBillsEntityDataFactory(boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4 = z & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1];
        int NetworkUserEntityData$$ExternalSyntheticLambda1 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1();
        int DatabaseTableConfigUtil = this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil();
        if (z4 && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
            Iterator<WidgetRun> it = this.getErrorConfigVersion.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.getErrorConfigVersion == i && !next.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    ConstraintWidgetContainer constraintWidgetContainer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    constraintWidgetContainer.getErrorConfigVersion(getAuthRequestContext(constraintWidgetContainer, 0));
                    DimensionDependency dimensionDependency = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    dimensionDependency.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer2.h == 8 ? 0 : constraintWidgetContainer2.FlowViewUtil$textChanges$2);
                }
            } else if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                constraintWidgetContainer3.lookAheadTest(getAuthRequestContext(constraintWidgetContainer3, 1));
                DimensionDependency dimensionDependency2 = this.KClassImpl$Data$declaredNonStaticMembers$2.n.getAuthRequestContext;
                ConstraintWidgetContainer constraintWidgetContainer4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                dimensionDependency2.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer4.h == 8 ? 0 : constraintWidgetContainer4.C);
            }
        }
        if (i == 0) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                ConstraintWidgetContainer constraintWidgetContainer5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = (constraintWidgetContainer5.h == 8 ? 0 : constraintWidgetContainer5.FlowViewUtil$textChanges$2) + NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i2);
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i2 - NetworkUserEntityData$$ExternalSyntheticLambda1);
                z2 = true;
            }
            z2 = false;
        } else {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                ConstraintWidgetContainer constraintWidgetContainer6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i3 = (constraintWidgetContainer6.h == 8 ? 0 : constraintWidgetContainer6.C) + DatabaseTableConfigUtil;
                this.KClassImpl$Data$declaredNonStaticMembers$2.n.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i3);
                this.KClassImpl$Data$declaredNonStaticMembers$2.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i3 - DatabaseTableConfigUtil);
                z2 = true;
            }
            z2 = false;
        }
        MyBillsEntityDataFactory();
        Iterator<WidgetRun> it2 = this.getErrorConfigVersion.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.getErrorConfigVersion == i && (next2.NetworkUserEntityData$$ExternalSyntheticLambda2 != this.KClassImpl$Data$declaredNonStaticMembers$2 || next2.lookAheadTest)) {
                next2.PlaceComponentResult();
            }
        }
        Iterator<WidgetRun> it3 = this.getErrorConfigVersion.iterator();
        while (it3.hasNext()) {
            WidgetRun next3 = it3.next();
            if (next3.getErrorConfigVersion == i && (z2 || next3.NetworkUserEntityData$$ExternalSyntheticLambda2 != this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                if (!next3.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 || !next3.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 || (!(next3 instanceof ChainRun) && !next3.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                    z3 = false;
                    break;
                }
            }
        }
        z3 = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[0] = dimensionBehaviour;
        this.KClassImpl$Data$declaredNonStaticMembers$2.getNameOrBuilderList[1] = dimensionBehaviour2;
        return z3;
    }

    private void PlaceComponentResult(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        this.lookAheadTest.getAuthRequestContext = dimensionBehaviour;
        this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda1 = dimensionBehaviour2;
        this.lookAheadTest.BuiltInFictitiousFunctionClassFactory = i;
        this.lookAheadTest.DatabaseTableConfigUtil = i2;
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(constraintWidget, this.lookAheadTest);
        constraintWidget.getErrorConfigVersion(this.lookAheadTest.initRecordTimeStamp);
        constraintWidget.lookAheadTest(this.lookAheadTest.moveToNextValue);
        constraintWidget.scheduleImpl = this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = this.lookAheadTest.getErrorConfigVersion;
        constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7 = i3;
        constraintWidget.scheduleImpl = i3 > 0;
    }

    private boolean getAuthRequestContext(ConstraintWidgetContainer constraintWidgetContainer) {
        Iterator<ConstraintWidget> it = constraintWidgetContainer.getContainerAuth.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = next.getNameOrBuilderList[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = next.getNameOrBuilderList[1];
            if (next.h == 8) {
                next.access$throwIllegalArgumentType = true;
            } else {
                if (next.S < 1.0f && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.N = 2;
                }
                if (next.R < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.K = 2;
                }
                if (next.SubSequence > 0.0f) {
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.N = 3;
                    } else if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.K = 3;
                    } else if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        if (next.N == 0) {
                            next.N = 3;
                        }
                        if (next.K == 0) {
                            next.K = 3;
                        }
                    }
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.N == 1 && (next.I.moveToNextValue == null || next.c.moveToNextValue == null)) {
                    dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviour;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.K == 1 && (next.f5939a.moveToNextValue == null || next.isLayoutRequested.moveToNextValue == null)) ? ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : dimensionBehaviour2;
                next.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult = dimensionBehaviour3;
                next.NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue = next.N;
                next.n.PlaceComponentResult = dimensionBehaviour4;
                next.n.moveToNextValue = next.K;
                if ((dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (next.N == 3) {
                            if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            }
                            int i = next.h == 8 ? 0 : next.C;
                            int i2 = (int) ((i * next.SubSequence) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                            PlaceComponentResult(next, dimensionBehaviour5, i2, dimensionBehaviour5, i);
                            next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                            next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                            next.access$throwIllegalArgumentType = true;
                        } else if (next.N == 1) {
                            PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour4, 0);
                            next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.initRecordTimeStamp = next.h != 8 ? next.FlowViewUtil$textChanges$2 : 0;
                        } else if (next.N == 2) {
                            if (constraintWidgetContainer.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((next.S * (constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2)) + 0.5f), dimensionBehaviour4, next.h == 8 ? 0 : next.C);
                                next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                                next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                                next.access$throwIllegalArgumentType = true;
                            }
                        } else if (next.J[0].moveToNextValue == null || next.J[1].moveToNextValue == null) {
                            PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour4, 0);
                            next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                            next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                            next.access$throwIllegalArgumentType = true;
                        }
                    }
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (next.K == 3) {
                            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            }
                            int i3 = next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2;
                            float f = next.SubSequence;
                            if (next.c_() == -1) {
                                f = 1.0f / f;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                            PlaceComponentResult(next, dimensionBehaviour6, i3, dimensionBehaviour6, (int) ((i3 * f) + 0.5f));
                            next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                            next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                            next.access$throwIllegalArgumentType = true;
                        } else if (next.K == 1) {
                            PlaceComponentResult(next, dimensionBehaviour3, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            next.n.getAuthRequestContext.initRecordTimeStamp = next.h != 8 ? next.C : 0;
                        } else if (next.K == 2) {
                            if (constraintWidgetContainer.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                PlaceComponentResult(next, dimensionBehaviour3, next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((next.R * (constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.C)) + 0.5f));
                                next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                                next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                                next.access$throwIllegalArgumentType = true;
                            }
                        } else if (next.J[2].moveToNextValue == null || next.J[3].moveToNextValue == null) {
                            PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour4, 0);
                            next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                            next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                            next.access$throwIllegalArgumentType = true;
                        }
                    }
                    if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        if (next.N == 1 || next.K == 1) {
                            PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.initRecordTimeStamp = next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2;
                            next.n.getAuthRequestContext.initRecordTimeStamp = next.h != 8 ? next.C : 0;
                        } else if (next.K == 2 && next.N == 2 && constraintWidgetContainer.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.FIXED && constraintWidgetContainer.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
                            float f2 = next.S;
                            float f3 = next.R;
                            int i4 = (int) ((f2 * (constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2)) + 0.5f);
                            int i5 = constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.C;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
                            PlaceComponentResult(next, dimensionBehaviour7, i4, dimensionBehaviour7, (int) ((f3 * i5) + 0.5f));
                            next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                            next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                            next.access$throwIllegalArgumentType = true;
                        }
                    }
                } else {
                    int i6 = next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2;
                    if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        i6 = ((constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2) - next.I.getAuthRequestContext) - next.c.getAuthRequestContext;
                        dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    int i7 = i6;
                    int i8 = next.h == 8 ? 0 : next.C;
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        i8 = ((constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.C) - next.f5939a.getAuthRequestContext) - next.isLayoutRequested.getAuthRequestContext;
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    PlaceComponentResult(next, dimensionBehaviour3, i7, dimensionBehaviour4, i8);
                    next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h == 8 ? 0 : next.FlowViewUtil$textChanges$2);
                    next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                    next.access$throwIllegalArgumentType = true;
                }
            }
        }
    }

    private void MyBillsEntityDataFactory() {
        Iterator<ConstraintWidget> it = this.KClassImpl$Data$declaredNonStaticMembers$2.getContainerAuth.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.access$throwIllegalArgumentType) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = next.getNameOrBuilderList[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = next.getNameOrBuilderList[1];
                int i = next.N;
                int i2 = next.K;
                boolean z = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                boolean z2 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1);
                boolean z3 = next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0;
                boolean z4 = next.n.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (z3 && z4) {
                    PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.FIXED, next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.DatabaseTableConfigUtil, ConstraintWidget.DimensionBehaviour.FIXED, next.n.getAuthRequestContext.DatabaseTableConfigUtil);
                    next.access$throwIllegalArgumentType = true;
                } else if (z3 && z2) {
                    PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.FIXED, next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.DatabaseTableConfigUtil, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.n.getAuthRequestContext.DatabaseTableConfigUtil);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.n.getAuthRequestContext.initRecordTimeStamp = next.h != 8 ? next.C : 0;
                    } else {
                        next.n.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.C : 0);
                        next.access$throwIllegalArgumentType = true;
                    }
                } else if (z4 && z) {
                    PlaceComponentResult(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.DatabaseTableConfigUtil, ConstraintWidget.DimensionBehaviour.FIXED, next.n.getAuthRequestContext.DatabaseTableConfigUtil);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.initRecordTimeStamp = next.h != 8 ? next.FlowViewUtil$textChanges$2 : 0;
                    } else {
                        next.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(next.h != 8 ? next.FlowViewUtil$textChanges$2 : 0);
                        next.access$throwIllegalArgumentType = true;
                    }
                }
                if (next.access$throwIllegalArgumentType && next.n.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    next.n.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(next.NetworkUserEntityData$$ExternalSyntheticLambda7);
                }
            }
        }
    }

    private void getAuthRequestContext() {
        ArrayList<WidgetRun> arrayList = this.getErrorConfigVersion;
        arrayList.clear();
        HorizontalWidgetRun horizontalWidgetRun = this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0;
        HashSet hashSet = null;
        horizontalWidgetRun.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        horizontalWidgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory();
        horizontalWidgetRun.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        horizontalWidgetRun.getAuthRequestContext.MyBillsEntityDataFactory();
        horizontalWidgetRun.lookAheadTest = false;
        this.scheduleImpl.n.KClassImpl$Data$declaredNonStaticMembers$2();
        arrayList.add(this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0);
        arrayList.add(this.scheduleImpl.n);
        Iterator<ConstraintWidget> it = this.scheduleImpl.getContainerAuth.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.newProxyInstance()) {
                    if (next.moveToNextValue == null) {
                        next.moveToNextValue = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.moveToNextValue);
                } else {
                    arrayList.add(next.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
                if (next.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                    if (next.p == null) {
                        next.p = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.p);
                } else {
                    arrayList.add(next.n);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.NetworkUserEntityData$$ExternalSyntheticLambda2 != this.scheduleImpl) {
                next2.BuiltInFictitiousFunctionClassFactory();
            }
        }
        this.MyBillsEntityDataFactory.clear();
        RunGroup.getAuthRequestContext = 0;
        BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, this.MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.n, 1, this.MyBillsEntityDataFactory);
        this.PlaceComponentResult = false;
    }

    private void getAuthRequestContext(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.scheduleImpl;
        if (widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda0 != null || widgetRun == this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 || widgetRun == this.KClassImpl$Data$declaredNonStaticMembers$2.n) {
            return;
        }
        if (runGroup == null) {
            runGroup = new RunGroup(widgetRun, i2);
            arrayList.add(runGroup);
        }
        widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda0 = runGroup;
        runGroup.moveToNextValue.add(widgetRun);
        runGroup.getErrorConfigVersion = widgetRun;
        for (Dependency dependency : widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory) {
            if (dependency instanceof DependencyNode) {
                getAuthRequestContext((DependencyNode) dependency, i, 0, dependencyNode2, arrayList, runGroup);
            }
        }
        for (Dependency dependency2 : widgetRun.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory) {
            if (dependency2 instanceof DependencyNode) {
                getAuthRequestContext((DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, runGroup);
            }
        }
        if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory) {
                if (dependency3 instanceof DependencyNode) {
                    getAuthRequestContext((DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, runGroup);
                }
            }
        }
        for (DependencyNode dependencyNode3 : widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion) {
            if (dependencyNode3 == dependencyNode2) {
                runGroup.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            getAuthRequestContext(dependencyNode3, i, 0, dependencyNode2, arrayList, runGroup);
        }
        for (DependencyNode dependencyNode4 : widgetRun.MyBillsEntityDataFactory.getErrorConfigVersion) {
            if (dependencyNode4 == dependencyNode2) {
                runGroup.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            getAuthRequestContext(dependencyNode4, i, 1, dependencyNode2, arrayList, runGroup);
        }
        if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
            Iterator<DependencyNode> it = ((VerticalWidgetRun) widgetRun).BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion.iterator();
            while (it.hasNext()) {
                getAuthRequestContext(it.next(), i, 2, dependencyNode2, arrayList, runGroup);
            }
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory) {
            if (dependency instanceof DependencyNode) {
                getAuthRequestContext((DependencyNode) dependency, i, 0, widgetRun.MyBillsEntityDataFactory, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                getAuthRequestContext(((WidgetRun) dependency).NetworkUserEntityData$$ExternalSyntheticLambda1, i, 0, widgetRun.MyBillsEntityDataFactory, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory) {
            if (dependency2 instanceof DependencyNode) {
                getAuthRequestContext((DependencyNode) dependency2, i, 1, widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                getAuthRequestContext(((WidgetRun) dependency2).MyBillsEntityDataFactory, i, 1, widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1, arrayList, null);
            }
        }
        if (i == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory) {
                if (dependency3 instanceof DependencyNode) {
                    getAuthRequestContext((DependencyNode) dependency3, i, 2, null, arrayList, null);
                }
            }
        }
    }
}
