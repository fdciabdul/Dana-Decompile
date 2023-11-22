package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes3.dex */
public class Optimizer {
    static boolean[] KClassImpl$Data$declaredNonStaticMembers$2 = new boolean[3];

    public static final boolean PlaceComponentResult(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.getValueOfTouchPositionAbsolute = -1;
        constraintWidget.FillAnimation = -1;
        if (constraintWidgetContainer.getNameOrBuilderList[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.I.getAuthRequestContext;
            int i2 = (constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2) - constraintWidget.c.getAuthRequestContext;
            constraintWidget.I.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearSystem.PlaceComponentResult(constraintWidget.I);
            constraintWidget.c.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearSystem.PlaceComponentResult(constraintWidget.c);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.I.NetworkUserEntityData$$ExternalSyntheticLambda0, i);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.c.NetworkUserEntityData$$ExternalSyntheticLambda0, i2);
            constraintWidget.getValueOfTouchPositionAbsolute = 2;
            constraintWidget.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
        }
        if (constraintWidgetContainer.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.getNameOrBuilderList[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i3 = constraintWidget.f5939a.getAuthRequestContext;
        int i4 = (constraintWidgetContainer.h != 8 ? constraintWidgetContainer.C : 0) - constraintWidget.isLayoutRequested.getAuthRequestContext;
        constraintWidget.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearSystem.PlaceComponentResult(constraintWidget.f5939a);
        constraintWidget.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearSystem.PlaceComponentResult(constraintWidget.isLayoutRequested);
        linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.f5939a.NetworkUserEntityData$$ExternalSyntheticLambda0, i3);
        linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, i4);
        if (constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7 > 0 || constraintWidget.h == 8) {
            constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda8.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearSystem.PlaceComponentResult(constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda8);
            linearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda8.NetworkUserEntityData$$ExternalSyntheticLambda0, constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7 + i3);
        }
        constraintWidget.FillAnimation = 2;
        constraintWidget.moveToNextValue(i3, i4);
    }
}
