package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DimensionDependency extends DependencyNode {
    public int initRecordTimeStamp;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.lookAheadTest = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.lookAheadTest = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
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
}
