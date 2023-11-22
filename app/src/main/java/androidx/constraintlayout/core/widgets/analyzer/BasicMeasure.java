package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BasicMeasure {
    public ConstraintWidgetContainer BuiltInFictitiousFunctionClassFactory;
    public final ArrayList<ConstraintWidget> PlaceComponentResult = new ArrayList<>();
    private Measure getAuthRequestContext = new Measure();

    /* loaded from: classes3.dex */
    public static class Measure {
        public static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        public static int MyBillsEntityDataFactory = 1;
        public static int PlaceComponentResult = 2;
        public int BuiltInFictitiousFunctionClassFactory;
        public int DatabaseTableConfigUtil;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ConstraintWidget.DimensionBehaviour NetworkUserEntityData$$ExternalSyntheticLambda1;
        public ConstraintWidget.DimensionBehaviour getAuthRequestContext;
        public int getErrorConfigVersion;
        public int initRecordTimeStamp;
        public boolean lookAheadTest;
        public int moveToNextValue;
        public int scheduleImpl;
    }

    /* loaded from: classes3.dex */
    public interface Measurer {
        void PlaceComponentResult(ConstraintWidget constraintWidget, Measure measure);

        void getAuthRequestContext();
    }

    public final void BuiltInFictitiousFunctionClassFactory(ConstraintWidgetContainer constraintWidgetContainer) {
        this.PlaceComponentResult.clear();
        int size = constraintWidgetContainer.getContainerAuth.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.getContainerAuth.get(i);
            if (constraintWidget.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.PlaceComponentResult.add(constraintWidget);
            }
        }
        constraintWidgetContainer.getAuthRequestContext.PlaceComponentResult = true;
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.BuiltInFictitiousFunctionClassFactory = constraintWidgetContainer;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int GetContactSyncConfig = constraintWidgetContainer.GetContactSyncConfig();
        int initRecordTimeStamp = constraintWidgetContainer.initRecordTimeStamp();
        constraintWidgetContainer.scheduleImpl(0);
        constraintWidgetContainer.NetworkUserEntityData$$ExternalSyntheticLambda0(0);
        constraintWidgetContainer.getErrorConfigVersion(i2);
        constraintWidgetContainer.lookAheadTest(i3);
        constraintWidgetContainer.scheduleImpl(GetContactSyncConfig);
        constraintWidgetContainer.NetworkUserEntityData$$ExternalSyntheticLambda0(initRecordTimeStamp);
        this.BuiltInFictitiousFunctionClassFactory.verifyNotNull = i;
        this.BuiltInFictitiousFunctionClassFactory.BottomSheetCardBindingView$watcherCardNumberView$1();
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Measurer measurer, ConstraintWidget constraintWidget, int i) {
        this.getAuthRequestContext.getAuthRequestContext = constraintWidget.getNameOrBuilderList[0];
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintWidget.getNameOrBuilderList[1];
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = constraintWidget.h == 8 ? 0 : constraintWidget.FlowViewUtil$textChanges$2;
        this.getAuthRequestContext.DatabaseTableConfigUtil = constraintWidget.h == 8 ? 0 : constraintWidget.C;
        this.getAuthRequestContext.lookAheadTest = false;
        this.getAuthRequestContext.scheduleImpl = i;
        boolean z = this.getAuthRequestContext.getAuthRequestContext == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = z && constraintWidget.SubSequence > 0.0f;
        boolean z4 = z2 && constraintWidget.SubSequence > 0.0f;
        if (z3 && constraintWidget.b[0] == 4) {
            this.getAuthRequestContext.getAuthRequestContext = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.b[1] == 4) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.PlaceComponentResult(constraintWidget, this.getAuthRequestContext);
        constraintWidget.getErrorConfigVersion(this.getAuthRequestContext.initRecordTimeStamp);
        constraintWidget.lookAheadTest(this.getAuthRequestContext.moveToNextValue);
        constraintWidget.scheduleImpl = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i2 = this.getAuthRequestContext.getErrorConfigVersion;
        constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7 = i2;
        constraintWidget.scheduleImpl = i2 > 0;
        this.getAuthRequestContext.scheduleImpl = Measure.KClassImpl$Data$declaredNonStaticMembers$2;
        return this.getAuthRequestContext.lookAheadTest;
    }
}
