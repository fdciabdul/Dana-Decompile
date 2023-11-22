package id.dana.riskChallenges.ui.passkey.main;

import androidx.view.ViewModel;
import id.dana.analytics.tracker.passkey.PasskeyTracker;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl;
import id.dana.network.exception.NetworkException;
import id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyFinish;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyStart;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCeremony;
import id.dana.riskChallenges.domain.passkey.model.PasskeyEnrollmentWithRiskChallenges;
import id.dana.riskChallenges.ui.passkey.main.EnrollmentMainUiState;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0018\u0012\u0006\u0010\u0006\u001a\u00020\u0015\u0012\u0006\u0010\u0007\u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0012\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0016\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0019\u001a\u00020\u001bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/analytics/tracker/passkey/PasskeyTracker;", "", "p0", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;", "p1", "p2", "", "getAuthRequestContext", "(Ljava/lang/String;Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "scheduleImpl", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/StateFlow;", "PlaceComponentResult", "Lkotlinx/coroutines/flow/StateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyFinish;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyFinish;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyStart;", "getErrorConfigVersion", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyStart;", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData;", "moveToNextValue", "Lkotlin/Lazy;", "Lid/dana/analytics/tracker/passkey/PasskeyTrackerImpl;", "Lid/dana/analytics/tracker/passkey/PasskeyTrackerImpl;", "lookAheadTest", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Factory;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Factory;", "p3", "<init>", "(Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyStart;Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyFinish;Lid/dana/analytics/tracker/passkey/PasskeyTrackerImpl;Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Factory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnrollmentMainViewModel extends ViewModel implements PasskeyTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final PasskeyTrackerImpl lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final StateFlow<EnrollmentMainUiState> moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final PasskeyCeremonyFinish PlaceComponentResult;
    private final PasskeyPreferenceEntityData.Factory NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final StateFlow<Boolean> KClassImpl$Data$declaredNonStaticMembers$2;
    final MutableStateFlow<Boolean> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final PasskeyCeremonyStart MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final MutableStateFlow<EnrollmentMainUiState> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public EnrollmentMainViewModel(PasskeyCeremonyStart passkeyCeremonyStart, PasskeyCeremonyFinish passkeyCeremonyFinish, PasskeyTrackerImpl passkeyTrackerImpl, PasskeyPreferenceEntityData.Factory factory) {
        Intrinsics.checkNotNullParameter(passkeyCeremonyStart, "");
        Intrinsics.checkNotNullParameter(passkeyCeremonyFinish, "");
        Intrinsics.checkNotNullParameter(passkeyTrackerImpl, "");
        Intrinsics.checkNotNullParameter(factory, "");
        this.MyBillsEntityDataFactory = passkeyCeremonyStart;
        this.PlaceComponentResult = passkeyCeremonyFinish;
        this.lookAheadTest = passkeyTrackerImpl;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = factory;
        MutableStateFlow<EnrollmentMainUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(EnrollmentMainUiState.None.INSTANCE);
        this.BuiltInFictitiousFunctionClassFactory = MutableStateFlow;
        this.moveToNextValue = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.getAuthRequestContext = MutableStateFlow2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = FlowKt.asStateFlow(MutableStateFlow2);
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<PasskeyPreferenceEntityData>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainViewModel$passkeyPreference$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // kotlin.jvm.functions.Function0
            public final PasskeyPreferenceEntityData invoke() {
                PasskeyPreferenceEntityData.Factory factory2;
                factory2 = EnrollmentMainViewModel.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (Intrinsics.areEqual("local", "local")) {
                    return factory2.getAuthRequestContext;
                }
                ?? r2 = 0;
                throw new NotImplementedError(r2, 1, r2);
            }
        });
    }

    public final void getAuthRequestContext(String p0, PasskeyCeremony.Type p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.execute(new PasskeyCeremony.Params(p1, null, p0, p2, 2, null), new Function1<Pair<? extends String, ? extends List<? extends VerificationMethodModel>>, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainViewModel$startPasskeyCeremony$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends List<? extends VerificationMethodModel>> pair) {
                invoke2((Pair<String, ? extends List<VerificationMethodModel>>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends List<VerificationMethodModel>> pair) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(pair, "");
                String component1 = pair.component1();
                List<VerificationMethodModel> component2 = pair.component2();
                if (!component2.isEmpty()) {
                    mutableStateFlow2 = EnrollmentMainViewModel.this.BuiltInFictitiousFunctionClassFactory;
                    EnrollmentMainViewModel enrollmentMainViewModel = EnrollmentMainViewModel.this;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        EnrollmentMainUiState enrollmentMainUiState = (EnrollmentMainUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, new EnrollmentMainUiState.OnPasskeyPromptNeedVerificationMethods(new PasskeyEnrollmentWithRiskChallenges(EnrollmentMainViewModel.getAuthRequestContext(enrollmentMainViewModel).NetworkUserEntityData$$ExternalSyntheticLambda0(), component2))));
                    return;
                }
                mutableStateFlow = EnrollmentMainViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    EnrollmentMainUiState enrollmentMainUiState2 = (EnrollmentMainUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new EnrollmentMainUiState.OnPasskeyPromptOpen(component1)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainViewModel$startPasskeyCeremony$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                String message;
                Intrinsics.checkNotNullParameter(th, "");
                if (th instanceof NetworkException) {
                    mutableStateFlow2 = EnrollmentMainViewModel.this.BuiltInFictitiousFunctionClassFactory;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        EnrollmentMainUiState enrollmentMainUiState = (EnrollmentMainUiState) value2;
                        message = th.getMessage();
                        if (message == null) {
                            message = "";
                        }
                    } while (!mutableStateFlow2.compareAndSet(value2, new EnrollmentMainUiState.OnPasskeyEnrollmentStartFailedRisk(message)));
                    return;
                }
                mutableStateFlow = EnrollmentMainViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    EnrollmentMainUiState enrollmentMainUiState2 = (EnrollmentMainUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new EnrollmentMainUiState.OnPasskeyEnrollmentStartFailed()));
            }
        });
    }

    public static final /* synthetic */ PasskeyPreferenceEntityData getAuthRequestContext(EnrollmentMainViewModel enrollmentMainViewModel) {
        return (PasskeyPreferenceEntityData) enrollmentMainViewModel.getErrorConfigVersion.getValue();
    }
}
