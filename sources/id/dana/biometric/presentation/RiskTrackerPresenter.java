package id.dana.biometric.presentation;

import id.dana.biometric.domain.interactor.DeleteScoringDeviceData;
import id.dana.biometric.domain.interactor.GetAccelerometerData;
import id.dana.biometric.domain.interactor.GetGyroscopeData;
import id.dana.biometric.domain.interactor.GetRiskTrackerConfig;
import id.dana.biometric.domain.interactor.PageEndAndZip;
import id.dana.biometric.domain.interactor.SaveAccelerometerData;
import id.dana.biometric.domain.interactor.SaveGyroscopeData;
import id.dana.biometric.domain.interactor.SaveKeystrokeData;
import id.dana.biometric.domain.model.RiskType;
import id.dana.domain.core.usecase.BaseUseCase;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\r¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/biometric/presentation/RiskTrackerPresenter;", "", "Lid/dana/biometric/domain/interactor/DeleteScoringDeviceData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/biometric/domain/interactor/DeleteScoringDeviceData;", "PlaceComponentResult", "Lid/dana/biometric/domain/interactor/GetAccelerometerData;", "getAuthRequestContext", "Lid/dana/biometric/domain/interactor/GetAccelerometerData;", "Lid/dana/biometric/domain/interactor/GetGyroscopeData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/biometric/domain/interactor/GetGyroscopeData;", "MyBillsEntityDataFactory", "Lid/dana/biometric/domain/interactor/GetRiskTrackerConfig;", "Lid/dana/biometric/domain/interactor/GetRiskTrackerConfig;", "Lid/dana/biometric/domain/interactor/PageEndAndZip;", "Lid/dana/biometric/domain/interactor/PageEndAndZip;", "Lid/dana/biometric/domain/interactor/SaveAccelerometerData;", "getErrorConfigVersion", "Lid/dana/biometric/domain/interactor/SaveAccelerometerData;", "lookAheadTest", "Lid/dana/biometric/domain/interactor/SaveGyroscopeData;", "scheduleImpl", "Lid/dana/biometric/domain/interactor/SaveGyroscopeData;", "moveToNextValue", "Lid/dana/biometric/domain/interactor/SaveKeystrokeData;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/biometric/domain/interactor/SaveKeystrokeData;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/biometric/domain/interactor/SaveAccelerometerData;Lid/dana/biometric/domain/interactor/SaveGyroscopeData;Lid/dana/biometric/domain/interactor/SaveKeystrokeData;Lid/dana/biometric/domain/interactor/GetAccelerometerData;Lid/dana/biometric/domain/interactor/GetGyroscopeData;Lid/dana/biometric/domain/interactor/DeleteScoringDeviceData;Lid/dana/biometric/domain/interactor/PageEndAndZip;Lid/dana/biometric/domain/interactor/GetRiskTrackerConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RiskTrackerPresenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final GetGyroscopeData MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final DeleteScoringDeviceData PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final PageEndAndZip KClassImpl$Data$declaredNonStaticMembers$2;
    private final SaveKeystrokeData NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final GetRiskTrackerConfig BuiltInFictitiousFunctionClassFactory;
    final GetAccelerometerData getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final SaveAccelerometerData lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final SaveGyroscopeData moveToNextValue;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[RiskType.values().length];
            iArr[RiskType.ACCELEROMETER.ordinal()] = 1;
            iArr[RiskType.GYROSCOPE.ordinal()] = 2;
            iArr[RiskType.KEYSTROKE.ordinal()] = 3;
            MyBillsEntityDataFactory = iArr;
        }
    }

    @Inject
    public RiskTrackerPresenter(SaveAccelerometerData saveAccelerometerData, SaveGyroscopeData saveGyroscopeData, SaveKeystrokeData saveKeystrokeData, GetAccelerometerData getAccelerometerData, GetGyroscopeData getGyroscopeData, DeleteScoringDeviceData deleteScoringDeviceData, PageEndAndZip pageEndAndZip, GetRiskTrackerConfig getRiskTrackerConfig) {
        Intrinsics.checkNotNullParameter(saveAccelerometerData, "");
        Intrinsics.checkNotNullParameter(saveGyroscopeData, "");
        Intrinsics.checkNotNullParameter(saveKeystrokeData, "");
        Intrinsics.checkNotNullParameter(getAccelerometerData, "");
        Intrinsics.checkNotNullParameter(getGyroscopeData, "");
        Intrinsics.checkNotNullParameter(deleteScoringDeviceData, "");
        Intrinsics.checkNotNullParameter(pageEndAndZip, "");
        Intrinsics.checkNotNullParameter(getRiskTrackerConfig, "");
        this.lookAheadTest = saveAccelerometerData;
        this.moveToNextValue = saveGyroscopeData;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = saveKeystrokeData;
        this.getAuthRequestContext = getAccelerometerData;
        this.MyBillsEntityDataFactory = getGyroscopeData;
        this.PlaceComponentResult = deleteScoringDeviceData;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pageEndAndZip;
        this.BuiltInFictitiousFunctionClassFactory = getRiskTrackerConfig;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(RiskTrackerPresenter riskTrackerPresenter, String str, String str2, RiskType riskType, float f, float f2, float f3, long j, Function0 function0, boolean z, int i) {
        float f4 = (i & 32) != 0 ? 0.0f : f3;
        final Function0 function02 = (i & 128) != 0 ? null : function0;
        boolean z2 = (i & 256) != 0 ? false : z;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(riskType, "");
        int i2 = WhenMappings.MyBillsEntityDataFactory[riskType.ordinal()];
        if (i2 == 1) {
            BaseUseCase.execute$default(riskTrackerPresenter.lookAheadTest, new SaveAccelerometerData.Params(str, str2, f, f2, f4, j), new Function1<Boolean, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$saveAccelerometerData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z3) {
                    Function0<Unit> function03;
                    if (!z3 || (function03 = function02) == null) {
                        return;
                    }
                    function03.invoke();
                }
            }, null, 4, null);
        } else if (i2 == 2) {
            BaseUseCase.execute$default(riskTrackerPresenter.moveToNextValue, new SaveGyroscopeData.Params(str, str2, f, f2, f4, j), new Function1<Boolean, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$saveGyroscopeData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z3) {
                    Function0<Unit> function03;
                    if (!z3 || (function03 = function02) == null) {
                        return;
                    }
                    function03.invoke();
                }
            }, null, 4, null);
        } else if (i2 == 3 && z2) {
            BaseUseCase.execute$default(riskTrackerPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0, new SaveKeystrokeData.Params(str, str2, f, f2, j), new Function1<Unit, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$saveKeystrokeData$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Unit unit) {
                    Intrinsics.checkNotNullParameter(unit, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }
            }, null, 4, null);
        }
    }
}
