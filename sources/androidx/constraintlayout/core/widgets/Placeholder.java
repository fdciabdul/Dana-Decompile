package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

/* loaded from: classes3.dex */
public class Placeholder extends VirtualLayout {
    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void KClassImpl$Data$declaredNonStaticMembers$2(LinearSystem linearSystem, boolean z) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, z);
        if (this.FlowableCreate$BufferAsyncEmitter > 0) {
            ConstraintWidget constraintWidget = this.z[0];
            constraintWidget.getCallingPid();
            constraintWidget.PlaceComponentResult(ConstraintAnchor.Type.LEFT, this, ConstraintAnchor.Type.LEFT, 0);
            constraintWidget.PlaceComponentResult(ConstraintAnchor.Type.RIGHT, this, ConstraintAnchor.Type.RIGHT, 0);
            constraintWidget.PlaceComponentResult(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP, 0);
            constraintWidget.PlaceComponentResult(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public final void MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
        int i5 = this.checkRegisteredUserAndSendOtp + this.f7reduceIndexedz1zDJgo + 0;
        int i6 = this.getIndexName + this.JsonParseException + 0;
        if (this.FlowableCreate$BufferAsyncEmitter > 0) {
            ConstraintWidget constraintWidget = this.z[0];
            i5 += constraintWidget.h == 8 ? 0 : constraintWidget.FlowViewUtil$textChanges$2;
            ConstraintWidget constraintWidget2 = this.z[0];
            i6 += constraintWidget2.h == 8 ? 0 : constraintWidget2.C;
        }
        int max = Math.max(GetContactSyncConfig(), i5);
        int max2 = Math.max(initRecordTimeStamp(), i6);
        if (i != 1073741824) {
            if (i == Integer.MIN_VALUE) {
                i2 = Math.min(max, i2);
            } else {
                i2 = i == 0 ? max : 0;
            }
        }
        if (i3 != 1073741824) {
            if (i3 == Integer.MIN_VALUE) {
                i4 = Math.min(max2, i4);
            } else {
                i4 = i3 == 0 ? max2 : 0;
            }
        }
        this.getCardNumberOCR = i2;
        this.FlowableReduce$ReduceSubscriber = i4;
        getErrorConfigVersion(i2);
        lookAheadTest(i4);
        PlaceComponentResult(this.FlowableCreate$BufferAsyncEmitter > 0);
    }
}
