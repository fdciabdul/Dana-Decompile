package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Grouping {
    private static boolean getAuthRequestContext(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        return (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT));
    }

    private static WidgetGroup KClassImpl$Data$declaredNonStaticMembers$2(ArrayList<WidgetGroup> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            WidgetGroup widgetGroup = arrayList.get(i2);
            if (i == widgetGroup.MyBillsEntityDataFactory) {
                return widgetGroup;
            }
        }
        return null;
    }

    public static WidgetGroup getAuthRequestContext(ConstraintWidget constraintWidget, int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        int i2;
        int i3;
        if (i == 0) {
            i2 = constraintWidget.lookAheadTest;
        } else {
            i2 = constraintWidget.OtpRegistrationPresenter$input$2;
        }
        if (i2 != -1 && (widgetGroup == null || i2 != widgetGroup.MyBillsEntityDataFactory)) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = arrayList.get(i4);
                if (widgetGroup2.MyBillsEntityDataFactory == i2) {
                    if (widgetGroup != null) {
                        widgetGroup.PlaceComponentResult(i, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i4++;
                }
            }
        } else if (i2 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if (constraintWidget instanceof HelperWidget) {
                HelperWidget helperWidget = (HelperWidget) constraintWidget;
                int i5 = 0;
                while (true) {
                    if (i5 >= helperWidget.FlowableCreate$BufferAsyncEmitter) {
                        i3 = -1;
                        break;
                    }
                    ConstraintWidget constraintWidget2 = helperWidget.z[i5];
                    if (i == 0 && constraintWidget2.lookAheadTest != -1) {
                        i3 = constraintWidget2.lookAheadTest;
                        break;
                    } else if (i == 1 && constraintWidget2.OtpRegistrationPresenter$input$2 != -1) {
                        i3 = constraintWidget2.OtpRegistrationPresenter$input$2;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i3 != -1) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= arrayList.size()) {
                            break;
                        }
                        WidgetGroup widgetGroup3 = arrayList.get(i6);
                        if (widgetGroup3.MyBillsEntityDataFactory == i3) {
                            widgetGroup = widgetGroup3;
                            break;
                        }
                        i6++;
                    }
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.BuiltInFictitiousFunctionClassFactory(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                guideline.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(guideline.BuiltInFictitiousFunctionClassFactory == 0 ? 1 : 0, arrayList, widgetGroup);
            }
            if (i == 0) {
                constraintWidget.lookAheadTest = widgetGroup.MyBillsEntityDataFactory;
                constraintWidget.I.KClassImpl$Data$declaredNonStaticMembers$2(i, arrayList, widgetGroup);
                constraintWidget.c.KClassImpl$Data$declaredNonStaticMembers$2(i, arrayList, widgetGroup);
            } else {
                constraintWidget.OtpRegistrationPresenter$input$2 = widgetGroup.MyBillsEntityDataFactory;
                constraintWidget.f5939a.KClassImpl$Data$declaredNonStaticMembers$2(i, arrayList, widgetGroup);
                constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2(i, arrayList, widgetGroup);
                constraintWidget.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2(i, arrayList, widgetGroup);
            }
            constraintWidget.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(i, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:205:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03ba A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean MyBillsEntityDataFactory(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r18, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r19) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.MyBillsEntityDataFactory(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):boolean");
    }
}
