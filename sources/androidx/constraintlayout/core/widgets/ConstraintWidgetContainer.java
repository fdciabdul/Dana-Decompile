package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    int RequestMoneyQrContract$View;
    int TypefaceCompatApi26Impl;
    public Metrics u;
    int v;
    public int verifyNotNull;
    int x;
    public BasicMeasure BuiltInFictitiousFunctionClassFactory = new BasicMeasure(this);
    public DependencyGraph getAuthRequestContext = new DependencyGraph(this);
    protected BasicMeasure.Measurer q = null;
    public boolean s = false;
    protected LinearSystem setNetAuthId = new LinearSystem();
    public int t = 0;
    public int y = 0;
    ChainHead[] initAnimators = new ChainHead[4];

    /* renamed from: o  reason: collision with root package name */
    ChainHead[] f5941o = new ChainHead[4];
    public boolean PlaceComponentResult = false;
    public boolean SizeSelectors$OrSelector = false;
    public boolean getCardNumberOCR = false;
    public int FlowableReduce$ReduceSubscriber = 0;
    public int OtpRegistrationPresenter$input$1 = 0;
    public int w = DeepRecoverARiverProxy.TYPE_ENTITY_APP;
    public boolean z = false;
    private boolean secondaryHash = false;
    private boolean JsonParseException = false;
    int MyBillsEntityDataFactory = 0;

    /* renamed from: reduceIndexed-z1zDJgo  reason: not valid java name */
    private WeakReference<ConstraintAnchor> f6reduceIndexedz1zDJgo = null;
    private WeakReference<ConstraintAnchor> getDefaultSenderId = null;
    private WeakReference<ConstraintAnchor> checkRegisteredUserAndSendOtp = null;
    private WeakReference<ConstraintAnchor> onDecodeSuccess = null;
    HashSet<ConstraintWidget> FlowableCreate$BufferAsyncEmitter = new HashSet<>();
    public BasicMeasure.Measure r = new BasicMeasure.Measure();

    private boolean BuiltInFictitiousFunctionClassFactory(boolean z) {
        return this.getAuthRequestContext.PlaceComponentResult(z);
    }

    private boolean B() {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
    }

    private boolean PlaceComponentResult(boolean z, int i) {
        return this.getAuthRequestContext.MyBillsEntityDataFactory(z, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x01fb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long PlaceComponentResult(int r22, int r23, int r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 1063
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.PlaceComponentResult(int, int, int, int, int, int, int):long");
    }

    public final void MyBillsEntityDataFactory(BasicMeasure.Measurer measurer) {
        this.q = measurer;
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = measurer;
    }

    public final BasicMeasure.Measurer BuiltInFictitiousFunctionClassFactory() {
        return this.q;
    }

    public final void MyBillsEntityDataFactory(Metrics metrics) {
        this.u = metrics;
        LinearSystem.PlaceComponentResult(metrics);
    }

    public final boolean initRecordTimeStamp(int i) {
        return (this.w & i) == i;
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void whenAvailable() {
        this.setNetAuthId.BuiltInFictitiousFunctionClassFactory();
        this.TypefaceCompatApi26Impl = 0;
        this.x = 0;
        this.RequestMoneyQrContract$View = 0;
        this.v = 0;
        this.z = false;
        super.whenAvailable();
    }

    public final boolean A() {
        return this.secondaryHash;
    }

    public final boolean lookAheadTest() {
        return this.JsonParseException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f6reduceIndexedz1zDJgo;
        if (weakReference != null && weakReference.get() != null) {
            int i = !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult;
            ConstraintAnchor constraintAnchor2 = this.f6reduceIndexedz1zDJgo.get();
            if (i <= (constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? constraintAnchor2.PlaceComponentResult : 0)) {
                return;
            }
        }
        this.f6reduceIndexedz1zDJgo = new WeakReference<>(constraintAnchor);
    }

    public final void BuiltInFictitiousFunctionClassFactory(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.getDefaultSenderId;
        if (weakReference != null && weakReference.get() != null) {
            int i = !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult;
            ConstraintAnchor constraintAnchor2 = this.getDefaultSenderId.get();
            if (i <= (constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? constraintAnchor2.PlaceComponentResult : 0)) {
                return;
            }
        }
        this.getDefaultSenderId = new WeakReference<>(constraintAnchor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.checkRegisteredUserAndSendOtp;
        if (weakReference != null && weakReference.get() != null) {
            int i = !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult;
            ConstraintAnchor constraintAnchor2 = this.checkRegisteredUserAndSendOtp.get();
            if (i <= (constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? constraintAnchor2.PlaceComponentResult : 0)) {
                return;
            }
        }
        this.checkRegisteredUserAndSendOtp = new WeakReference<>(constraintAnchor);
    }

    public final void PlaceComponentResult(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.onDecodeSuccess;
        if (weakReference != null && weakReference.get() != null) {
            int i = !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult;
            ConstraintAnchor constraintAnchor2 = this.onDecodeSuccess.get();
            if (i <= (constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? constraintAnchor2.PlaceComponentResult : 0)) {
                return;
            }
        }
        this.onDecodeSuccess = new WeakReference<>(constraintAnchor);
    }

    private boolean PlaceComponentResult(LinearSystem linearSystem) {
        boolean initRecordTimeStamp = initRecordTimeStamp(64);
        KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, initRecordTimeStamp);
        int size = this.getContainerAuth.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.getContainerAuth.get(i);
            constraintWidget.KClassImpl$Data$declaredNonStaticMembers$2(0, false);
            constraintWidget.KClassImpl$Data$declaredNonStaticMembers$2(1, false);
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget2 = this.getContainerAuth.get(i2);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).lookAheadTest();
                }
            }
        }
        this.FlowableCreate$BufferAsyncEmitter.clear();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget3 = this.getContainerAuth.get(i3);
            if (constraintWidget3.moveToNextValue()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.FlowableCreate$BufferAsyncEmitter.add(constraintWidget3);
                } else {
                    constraintWidget3.KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, initRecordTimeStamp);
                }
            }
        }
        while (this.FlowableCreate$BufferAsyncEmitter.size() > 0) {
            int size2 = this.FlowableCreate$BufferAsyncEmitter.size();
            Iterator<ConstraintWidget> it = this.FlowableCreate$BufferAsyncEmitter.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it.next();
                if (virtualLayout.KClassImpl$Data$declaredNonStaticMembers$2(this.FlowableCreate$BufferAsyncEmitter)) {
                    virtualLayout.KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, initRecordTimeStamp);
                    this.FlowableCreate$BufferAsyncEmitter.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.FlowableCreate$BufferAsyncEmitter.size()) {
                Iterator<ConstraintWidget> it2 = this.FlowableCreate$BufferAsyncEmitter.iterator();
                while (it2.hasNext()) {
                    it2.next().KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, initRecordTimeStamp);
                }
                this.FlowableCreate$BufferAsyncEmitter.clear();
            }
        }
        if (LinearSystem.moveToNextValue) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget4 = this.getContainerAuth.get(i4);
                if (!constraintWidget4.moveToNextValue()) {
                    hashSet.add(constraintWidget4);
                }
            }
            BuiltInFictitiousFunctionClassFactory(this, linearSystem, hashSet, this.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator<ConstraintWidget> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                Optimizer.BuiltInFictitiousFunctionClassFactory(this, linearSystem, next);
                next.KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, initRecordTimeStamp);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget5 = this.getContainerAuth.get(i5);
                if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget5.getNameOrBuilderList[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget5.getNameOrBuilderList[1];
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget5.getNameOrBuilderList[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget5.getNameOrBuilderList[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    constraintWidget5.KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, initRecordTimeStamp);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget5.getNameOrBuilderList[0] = dimensionBehaviour;
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget5.getNameOrBuilderList[1] = dimensionBehaviour2;
                    }
                } else {
                    Optimizer.BuiltInFictitiousFunctionClassFactory(this, linearSystem, constraintWidget5);
                    if (!constraintWidget5.moveToNextValue()) {
                        constraintWidget5.KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, initRecordTimeStamp);
                    }
                }
            }
        }
        if (this.t > 0) {
            Chain.PlaceComponentResult(this, linearSystem, null, 0);
        }
        if (this.y > 0) {
            Chain.PlaceComponentResult(this, linearSystem, null, 1);
        }
        return true;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(boolean[] zArr) {
        zArr[2] = false;
        boolean initRecordTimeStamp = initRecordTimeStamp(64);
        MyBillsEntityDataFactory(initRecordTimeStamp);
        int size = this.getContainerAuth.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.getContainerAuth.get(i);
            constraintWidget.MyBillsEntityDataFactory(initRecordTimeStamp);
            if (constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda8()) {
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void getAuthRequestContext(boolean z, boolean z2) {
        super.getAuthRequestContext(z, z2);
        int size = this.getContainerAuth.size();
        for (int i = 0; i < size; i++) {
            this.getContainerAuth.get(i).getAuthRequestContext(z, z2);
        }
    }

    public final boolean C() {
        return this.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03b2  */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v29 */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BottomSheetCardBindingView$watcherCardNumberView$1() {
        /*
            Method dump skipped, instructions count: 983
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.BottomSheetCardBindingView$watcherCardNumberView$1():void");
    }

    public final LinearSystem KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.setNetAuthId;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void KClassImpl$Data$declaredNonStaticMembers$2(StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.l);
        sb2.append(":{\n");
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("  actualWidth:");
        sb3.append(this.FlowViewUtil$textChanges$2);
        sb.append(sb3.toString());
        sb.append("\n");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("  actualHeight:");
        sb4.append(this.C);
        sb.append(sb4.toString());
        sb.append("\n");
        Iterator<ConstraintWidget> it = this.getContainerAuth.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i) {
        int i2;
        int i3;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.h == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.initRecordTimeStamp = 0;
            measure.moveToNextValue = 0;
            return false;
        }
        measure.getAuthRequestContext = constraintWidget.getNameOrBuilderList[0];
        measure.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintWidget.getNameOrBuilderList[1];
        measure.BuiltInFictitiousFunctionClassFactory = constraintWidget.h == 8 ? 0 : constraintWidget.FlowViewUtil$textChanges$2;
        measure.DatabaseTableConfigUtil = constraintWidget.h == 8 ? 0 : constraintWidget.C;
        measure.lookAheadTest = false;
        measure.scheduleImpl = i;
        boolean z = measure.getAuthRequestContext == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = measure.NetworkUserEntityData$$ExternalSyntheticLambda1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = z && constraintWidget.SubSequence > 0.0f;
        boolean z4 = z2 && constraintWidget.SubSequence > 0.0f;
        if (z && constraintWidget.getAuthRequestContext(0) && constraintWidget.N == 0 && !z3) {
            measure.getAuthRequestContext = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.K == 0) {
                measure.getAuthRequestContext = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z = false;
        }
        if (z2 && constraintWidget.getAuthRequestContext(1) && constraintWidget.K == 0 && !z4) {
            measure.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z && constraintWidget.N == 0) {
                measure.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (constraintWidget.PlaceComponentResult()) {
            measure.getAuthRequestContext = ConstraintWidget.DimensionBehaviour.FIXED;
            z = false;
        }
        if (constraintWidget.getAuthRequestContext()) {
            measure.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (z3) {
            if (constraintWidget.b[0] == 4) {
                measure.getAuthRequestContext = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                if (measure.NetworkUserEntityData$$ExternalSyntheticLambda1 == ConstraintWidget.DimensionBehaviour.FIXED) {
                    i3 = measure.DatabaseTableConfigUtil;
                } else {
                    measure.getAuthRequestContext = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.PlaceComponentResult(constraintWidget, measure);
                    i3 = measure.moveToNextValue;
                }
                measure.getAuthRequestContext = ConstraintWidget.DimensionBehaviour.FIXED;
                measure.BuiltInFictitiousFunctionClassFactory = (int) (constraintWidget.SubSequence * i3);
            }
        }
        if (z4) {
            if (constraintWidget.b[1] == 4) {
                measure.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z) {
                if (measure.getAuthRequestContext == ConstraintWidget.DimensionBehaviour.FIXED) {
                    i2 = measure.BuiltInFictitiousFunctionClassFactory;
                } else {
                    measure.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.PlaceComponentResult(constraintWidget, measure);
                    i2 = measure.initRecordTimeStamp;
                }
                measure.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (constraintWidget.c_() == -1) {
                    measure.DatabaseTableConfigUtil = (int) (i2 / constraintWidget.SubSequence);
                } else {
                    measure.DatabaseTableConfigUtil = (int) (constraintWidget.SubSequence * i2);
                }
            }
        }
        measurer.PlaceComponentResult(constraintWidget, measure);
        constraintWidget.getErrorConfigVersion(measure.initRecordTimeStamp);
        constraintWidget.lookAheadTest(measure.moveToNextValue);
        constraintWidget.scheduleImpl = measure.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i4 = measure.getErrorConfigVersion;
        constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7 = i4;
        constraintWidget.scheduleImpl = i4 > 0;
        measure.scheduleImpl = BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2;
        return measure.lookAheadTest;
    }
}
