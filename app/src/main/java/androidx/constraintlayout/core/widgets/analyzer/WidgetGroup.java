package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class WidgetGroup {
    static int BuiltInFictitiousFunctionClassFactory;
    int MyBillsEntityDataFactory;
    int getAuthRequestContext;
    ArrayList<ConstraintWidget> NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList<>();
    boolean PlaceComponentResult = false;
    ArrayList<MeasureResult> KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private int moveToNextValue = -1;

    public WidgetGroup(int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = i2 + 1;
        this.MyBillsEntityDataFactory = i2;
        this.getAuthRequestContext = i;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(ConstraintWidget constraintWidget) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.contains(constraintWidget)) {
            return false;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(constraintWidget);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.getAuthRequestContext;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("] <");
        String obj = sb.toString();
        Iterator<ConstraintWidget> it = this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(" ");
            sb2.append(next.NetworkUserEntityData$$ExternalSyntheticLambda4);
            obj = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append(" >");
        return sb3.toString();
    }

    public final void PlaceComponentResult(int i, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.BuiltInFictitiousFunctionClassFactory(next);
            if (i == 0) {
                next.lookAheadTest = widgetGroup.MyBillsEntityDataFactory;
            } else {
                next.OtpRegistrationPresenter$input$2 = widgetGroup.MyBillsEntityDataFactory;
            }
        }
        this.moveToNextValue = widgetGroup.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int PlaceComponentResult(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int KClassImpl$Data$declaredNonStaticMembers$22;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).W;
        linearSystem.BuiltInFictitiousFunctionClassFactory();
        constraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, false);
        }
        if (i == 0 && constraintWidgetContainer.t > 0) {
            Chain.PlaceComponentResult(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.y > 0) {
            Chain.PlaceComponentResult(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.PlaceComponentResult();
        } catch (Exception unused) {
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(new MeasureResult(arrayList.get(i3), i));
        }
        if (i == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidgetContainer.I);
            KClassImpl$Data$declaredNonStaticMembers$22 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidgetContainer.c);
            linearSystem.BuiltInFictitiousFunctionClassFactory();
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidgetContainer.f5939a);
            KClassImpl$Data$declaredNonStaticMembers$22 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidgetContainer.isLayoutRequested);
            linearSystem.BuiltInFictitiousFunctionClassFactory();
        }
        return KClassImpl$Data$declaredNonStaticMembers$22 - KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void getAuthRequestContext(ArrayList<WidgetGroup> arrayList) {
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
        if (this.moveToNextValue != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                WidgetGroup widgetGroup = arrayList.get(i);
                if (this.moveToNextValue == widgetGroup.MyBillsEntityDataFactory) {
                    PlaceComponentResult(this.getAuthRequestContext, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class MeasureResult {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        WeakReference<ConstraintWidget> NetworkUserEntityData$$ExternalSyntheticLambda0;
        int PlaceComponentResult;
        int getAuthRequestContext;
        int moveToNextValue;

        public MeasureResult(ConstraintWidget constraintWidget, int i) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new WeakReference<>(constraintWidget);
            this.getAuthRequestContext = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.I);
            this.moveToNextValue = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.f5939a);
            this.BuiltInFictitiousFunctionClassFactory = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.c);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.isLayoutRequested);
            this.PlaceComponentResult = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.MyBillsEntityDataFactory = i;
        }
    }
}
