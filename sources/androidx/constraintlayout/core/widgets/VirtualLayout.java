package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class VirtualLayout extends HelperWidget {
    public int getIndexName = 0;
    public int JsonParseException = 0;
    public int secondaryHash = 0;
    public int getContainerAuth = 0;
    public int onDecodeSuccess = 0;
    public int getDefaultSenderId = 0;
    public int checkRegisteredUserAndSendOtp = 0;

    /* renamed from: reduceIndexed-z1zDJgo  reason: not valid java name */
    public int f7reduceIndexedz1zDJgo = 0;
    private boolean BuiltInFictitiousFunctionClassFactory = false;
    public int getCardNumberOCR = 0;
    public int FlowableReduce$ReduceSubscriber = 0;
    protected BasicMeasure.Measure verifyNotNull = new BasicMeasure.Measure();
    BasicMeasure.Measurer OtpRegistrationPresenter$input$1 = null;

    public void MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void PlaceComponentResult(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        BasicMeasure.Measurer BuiltInFictitiousFunctionClassFactory = this.W != null ? ((ConstraintWidgetContainer) this.W).BuiltInFictitiousFunctionClassFactory() : null;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.FlowableCreate$BufferAsyncEmitter) {
                return true;
            }
            ConstraintWidget constraintWidget = this.z[i];
            if (constraintWidget != null && !(constraintWidget instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getNameOrBuilderList[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getNameOrBuilderList[1];
                if (!(dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.N != 1 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.K != 1)) {
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    this.verifyNotNull.getAuthRequestContext = dimensionBehaviour;
                    this.verifyNotNull.NetworkUserEntityData$$ExternalSyntheticLambda1 = dimensionBehaviour2;
                    this.verifyNotNull.BuiltInFictitiousFunctionClassFactory = constraintWidget.h == 8 ? 0 : constraintWidget.FlowViewUtil$textChanges$2;
                    this.verifyNotNull.DatabaseTableConfigUtil = constraintWidget.h == 8 ? 0 : constraintWidget.C;
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(constraintWidget, this.verifyNotNull);
                    constraintWidget.getErrorConfigVersion(this.verifyNotNull.initRecordTimeStamp);
                    constraintWidget.lookAheadTest(this.verifyNotNull.moveToNextValue);
                    int i2 = this.verifyNotNull.getErrorConfigVersion;
                    constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7 = i2;
                    constraintWidget.scheduleImpl = i2 > 0;
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.OtpRegistrationPresenter$input$1 == null && this.W != null) {
            this.OtpRegistrationPresenter$input$1 = ((ConstraintWidgetContainer) this.W).BuiltInFictitiousFunctionClassFactory();
        }
        this.verifyNotNull.getAuthRequestContext = dimensionBehaviour;
        this.verifyNotNull.NetworkUserEntityData$$ExternalSyntheticLambda1 = dimensionBehaviour2;
        this.verifyNotNull.BuiltInFictitiousFunctionClassFactory = i;
        this.verifyNotNull.DatabaseTableConfigUtil = i2;
        this.OtpRegistrationPresenter$input$1.PlaceComponentResult(constraintWidget, this.verifyNotNull);
        constraintWidget.getErrorConfigVersion(this.verifyNotNull.initRecordTimeStamp);
        constraintWidget.lookAheadTest(this.verifyNotNull.moveToNextValue);
        constraintWidget.scheduleImpl = this.verifyNotNull.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = this.verifyNotNull.getErrorConfigVersion;
        constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7 = i3;
        constraintWidget.scheduleImpl = i3 > 0;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(HashSet<ConstraintWidget> hashSet) {
        for (int i = 0; i < this.FlowableCreate$BufferAsyncEmitter; i++) {
            if (hashSet.contains(this.z[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        for (int i = 0; i < this.FlowableCreate$BufferAsyncEmitter; i++) {
            ConstraintWidget constraintWidget = this.z[i];
            if (constraintWidget != null) {
                constraintWidget.D = true;
            }
        }
    }
}
