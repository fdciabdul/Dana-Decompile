package androidx.constraintlayout.core.widgets.analyzer;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DependencyNode implements Dependency {
    public int DatabaseTableConfigUtil;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    WidgetRun scheduleImpl;
    public Dependency NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
    public boolean PlaceComponentResult = false;
    public boolean moveToNextValue = false;
    Type lookAheadTest = Type.UNKNOWN;
    int MyBillsEntityDataFactory = 1;
    DimensionDependency getAuthRequestContext = null;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    List<Dependency> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    List<DependencyNode> getErrorConfigVersion = new ArrayList();

    /* loaded from: classes3.dex */
    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.scheduleImpl = widgetRun;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(":");
        sb.append(this.lookAheadTest);
        sb.append("(");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? Integer.valueOf(this.DatabaseTableConfigUtil) : "unresolved");
        sb.append(") <t=");
        sb.append(this.getErrorConfigVersion.size());
        sb.append(":d=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory.size());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    public void BuiltInFictitiousFunctionClassFactory(int i) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.DatabaseTableConfigUtil = i;
        Iterator<Dependency> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            it.next().lookAheadTest();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void lookAheadTest() {
        Iterator<DependencyNode> it = this.getErrorConfigVersion.iterator();
        while (it.hasNext()) {
            if (!it.next().NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return;
            }
        }
        this.moveToNextValue = true;
        Dependency dependency = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (dependency != null) {
            dependency.lookAheadTest();
        }
        if (this.PlaceComponentResult) {
            this.scheduleImpl.lookAheadTest();
            return;
        }
        DependencyNode dependencyNode = null;
        int i = 0;
        for (DependencyNode dependencyNode2 : this.getErrorConfigVersion) {
            if (!(dependencyNode2 instanceof DimensionDependency)) {
                i++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i == 1 && dependencyNode.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            DimensionDependency dimensionDependency = this.getAuthRequestContext;
            if (dimensionDependency != null) {
                if (!dimensionDependency.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory * this.getAuthRequestContext.DatabaseTableConfigUtil;
            }
            BuiltInFictitiousFunctionClassFactory(dependencyNode.DatabaseTableConfigUtil + this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        Dependency dependency2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (dependency2 != null) {
            dependency2.lookAheadTest();
        }
    }

    public final void MyBillsEntityDataFactory() {
        this.getErrorConfigVersion.clear();
        this.BuiltInFictitiousFunctionClassFactory.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.DatabaseTableConfigUtil = 0;
        this.moveToNextValue = false;
        this.PlaceComponentResult = false;
    }
}
