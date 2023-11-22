package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] z = new ConstraintWidget[4];
    public int FlowableCreate$BufferAsyncEmitter = 0;

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public final void MyBillsEntityDataFactory(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i = this.FlowableCreate$BufferAsyncEmitter;
        ConstraintWidget[] constraintWidgetArr = this.z;
        if (i + 1 > constraintWidgetArr.length) {
            this.z = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.z;
        int i2 = this.FlowableCreate$BufferAsyncEmitter;
        constraintWidgetArr2[i2] = constraintWidget;
        this.FlowableCreate$BufferAsyncEmitter = i2 + 1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getAuthRequestContext(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.getAuthRequestContext(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.FlowableCreate$BufferAsyncEmitter = 0;
        int i = helperWidget.FlowableCreate$BufferAsyncEmitter;
        for (int i2 = 0; i2 < i; i2++) {
            MyBillsEntityDataFactory(hashMap.get(helperWidget.z[i2]));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public final void scheduleImpl() {
        this.FlowableCreate$BufferAsyncEmitter = 0;
        Arrays.fill(this.z, (Object) null);
    }

    public final void BuiltInFictitiousFunctionClassFactory(ArrayList<WidgetGroup> arrayList, int i, WidgetGroup widgetGroup) {
        for (int i2 = 0; i2 < this.FlowableCreate$BufferAsyncEmitter; i2++) {
            widgetGroup.BuiltInFictitiousFunctionClassFactory(this.z[i2]);
        }
        for (int i3 = 0; i3 < this.FlowableCreate$BufferAsyncEmitter; i3++) {
            Grouping.getAuthRequestContext(this.z[i3], i, arrayList, widgetGroup);
        }
    }
}
