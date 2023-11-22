package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ChainRun extends WidgetRun {
    private int BuiltInFictitiousFunctionClassFactory;
    ArrayList<WidgetRun> KClassImpl$Data$declaredNonStaticMembers$2;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        ConstraintWidget constraintWidget2;
        WidgetRun widgetRun;
        int i2;
        WidgetRun widgetRun2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
        this.getErrorConfigVersion = i;
        ConstraintWidget constraintWidget3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        ConstraintWidget MyBillsEntityDataFactory = constraintWidget3.MyBillsEntityDataFactory(this.getErrorConfigVersion);
        while (true) {
            ConstraintWidget constraintWidget4 = MyBillsEntityDataFactory;
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            if (constraintWidget3 == null) {
                break;
            }
            MyBillsEntityDataFactory = constraintWidget3.MyBillsEntityDataFactory(this.getErrorConfigVersion);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = constraintWidget2;
        ArrayList<WidgetRun> arrayList = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = this.getErrorConfigVersion;
        if (i3 == 0) {
            widgetRun = constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        } else {
            widgetRun = i3 == 1 ? constraintWidget2.n : null;
        }
        arrayList.add(widgetRun);
        ConstraintWidget PlaceComponentResult = constraintWidget2.PlaceComponentResult(this.getErrorConfigVersion);
        while (PlaceComponentResult != null) {
            ArrayList<WidgetRun> arrayList2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i4 = this.getErrorConfigVersion;
            if (i4 == 0) {
                widgetRun2 = PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0;
            } else {
                widgetRun2 = i4 == 1 ? PlaceComponentResult.n : null;
            }
            arrayList2.add(widgetRun2);
            PlaceComponentResult = PlaceComponentResult.PlaceComponentResult(this.getErrorConfigVersion);
        }
        Iterator<WidgetRun> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            if (this.getErrorConfigVersion == 0) {
                next.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = this;
            } else if (this.getErrorConfigVersion == 1) {
                next.NetworkUserEntityData$$ExternalSyntheticLambda2.p = this;
            }
        }
        if ((this.getErrorConfigVersion == 0 && ((ConstraintWidgetContainer) this.NetworkUserEntityData$$ExternalSyntheticLambda2.W).C()) && this.KClassImpl$Data$declaredNonStaticMembers$2.size() > 1) {
            ArrayList<WidgetRun> arrayList3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = arrayList3.get(arrayList3.size() - 1).NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        if (this.getErrorConfigVersion == 0) {
            i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.E;
        } else {
            i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.f;
        }
        this.BuiltInFictitiousFunctionClassFactory = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.getErrorConfigVersion == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(next);
            sb.append("> ");
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = 0; i < size; i++) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final long getAuthRequestContext() {
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = j + r4.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2 + this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).getAuthRequestContext() + r4.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return j;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        Iterator<WidgetRun> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:374:0x00c3, code lost:
    
        if (r3.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 != false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x03c9, code lost:
    
        r2 = r2 - r9;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void lookAheadTest() {
        /*
            Method dump skipped, instructions count: 1009
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.lookAheadTest():void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void PlaceComponentResult() {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).PlaceComponentResult();
        }
    }

    private ConstraintWidget scheduleImpl() {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            WidgetRun widgetRun = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
            if (widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda2.h != 8) {
                return widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        }
        return null;
    }

    private ConstraintWidget moveToNextValue() {
        for (int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
            if (widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda2.h != 8) {
                return widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void BuiltInFictitiousFunctionClassFactory() {
        Iterator<WidgetRun> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            it.next().BuiltInFictitiousFunctionClassFactory();
        }
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        if (size <= 0) {
            return;
        }
        ConstraintWidget constraintWidget = this.KClassImpl$Data$declaredNonStaticMembers$2.get(0).NetworkUserEntityData$$ExternalSyntheticLambda2;
        ConstraintWidget constraintWidget2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size - 1).NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (this.getErrorConfigVersion == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.I;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.c;
            DependencyNode authRequestContext = getAuthRequestContext(constraintAnchor, 0);
            int MyBillsEntityDataFactory = constraintAnchor.MyBillsEntityDataFactory();
            ConstraintWidget scheduleImpl = scheduleImpl();
            if (scheduleImpl != null) {
                MyBillsEntityDataFactory = scheduleImpl.I.MyBillsEntityDataFactory();
            }
            if (authRequestContext != null) {
                DependencyNode dependencyNode = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                dependencyNode.getErrorConfigVersion.add(authRequestContext);
                dependencyNode.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory;
                authRequestContext.BuiltInFictitiousFunctionClassFactory.add(dependencyNode);
            }
            DependencyNode authRequestContext2 = getAuthRequestContext(constraintAnchor2, 0);
            int MyBillsEntityDataFactory2 = constraintAnchor2.MyBillsEntityDataFactory();
            ConstraintWidget moveToNextValue = moveToNextValue();
            if (moveToNextValue != null) {
                MyBillsEntityDataFactory2 = moveToNextValue.c.MyBillsEntityDataFactory();
            }
            if (authRequestContext2 != null) {
                DependencyNode dependencyNode2 = this.MyBillsEntityDataFactory;
                dependencyNode2.getErrorConfigVersion.add(authRequestContext2);
                dependencyNode2.KClassImpl$Data$declaredNonStaticMembers$2 = -MyBillsEntityDataFactory2;
                authRequestContext2.BuiltInFictitiousFunctionClassFactory.add(dependencyNode2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.f5939a;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.isLayoutRequested;
            DependencyNode authRequestContext3 = getAuthRequestContext(constraintAnchor3, 1);
            int MyBillsEntityDataFactory3 = constraintAnchor3.MyBillsEntityDataFactory();
            ConstraintWidget scheduleImpl2 = scheduleImpl();
            if (scheduleImpl2 != null) {
                MyBillsEntityDataFactory3 = scheduleImpl2.f5939a.MyBillsEntityDataFactory();
            }
            if (authRequestContext3 != null) {
                DependencyNode dependencyNode3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                dependencyNode3.getErrorConfigVersion.add(authRequestContext3);
                dependencyNode3.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory3;
                authRequestContext3.BuiltInFictitiousFunctionClassFactory.add(dependencyNode3);
            }
            DependencyNode authRequestContext4 = getAuthRequestContext(constraintAnchor4, 1);
            int MyBillsEntityDataFactory4 = constraintAnchor4.MyBillsEntityDataFactory();
            ConstraintWidget moveToNextValue2 = moveToNextValue();
            if (moveToNextValue2 != null) {
                MyBillsEntityDataFactory4 = moveToNextValue2.isLayoutRequested.MyBillsEntityDataFactory();
            }
            if (authRequestContext4 != null) {
                DependencyNode dependencyNode4 = this.MyBillsEntityDataFactory;
                dependencyNode4.getErrorConfigVersion.add(authRequestContext4);
                dependencyNode4.KClassImpl$Data$declaredNonStaticMembers$2 = -MyBillsEntityDataFactory4;
                authRequestContext4.BuiltInFictitiousFunctionClassFactory.add(dependencyNode4);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
    }
}
