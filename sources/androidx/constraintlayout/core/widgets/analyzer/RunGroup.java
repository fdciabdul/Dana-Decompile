package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* loaded from: classes3.dex */
class RunGroup {
    public static int getAuthRequestContext;
    int BuiltInFictitiousFunctionClassFactory;
    WidgetRun MyBillsEntityDataFactory;
    int PlaceComponentResult;
    WidgetRun getErrorConfigVersion;
    public int scheduleImpl = 0;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    ArrayList<WidgetRun> moveToNextValue = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i) {
        this.MyBillsEntityDataFactory = null;
        this.getErrorConfigVersion = null;
        int i2 = getAuthRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        getAuthRequestContext = i2 + 1;
        this.MyBillsEntityDataFactory = widgetRun;
        this.getErrorConfigVersion = widgetRun;
        this.PlaceComponentResult = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long BuiltInFictitiousFunctionClassFactory(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.scheduleImpl;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.BuiltInFictitiousFunctionClassFactory.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.BuiltInFictitiousFunctionClassFactory.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.scheduleImpl != widgetRun) {
                    j2 = Math.max(j2, BuiltInFictitiousFunctionClassFactory(dependencyNode2, dependencyNode2.KClassImpl$Data$declaredNonStaticMembers$2 + j));
                }
            }
        }
        if (dependencyNode == widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            long authRequestContext = j + widgetRun.getAuthRequestContext();
            return Math.max(Math.max(j2, BuiltInFictitiousFunctionClassFactory(widgetRun.MyBillsEntityDataFactory, authRequestContext)), authRequestContext - widgetRun.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long KClassImpl$Data$declaredNonStaticMembers$2(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.scheduleImpl;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.BuiltInFictitiousFunctionClassFactory.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.BuiltInFictitiousFunctionClassFactory.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.scheduleImpl != widgetRun) {
                    j2 = Math.min(j2, KClassImpl$Data$declaredNonStaticMembers$2(dependencyNode2, dependencyNode2.KClassImpl$Data$declaredNonStaticMembers$2 + j));
                }
            }
        }
        if (dependencyNode == widgetRun.MyBillsEntityDataFactory) {
            long authRequestContext = j - widgetRun.getAuthRequestContext();
            return Math.min(Math.min(j2, KClassImpl$Data$declaredNonStaticMembers$2(widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1, authRequestContext)), authRequestContext - widgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return j2;
    }
}
