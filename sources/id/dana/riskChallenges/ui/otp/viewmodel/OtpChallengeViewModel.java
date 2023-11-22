package id.dana.riskChallenges.ui.otp.viewmodel;

import androidx.view.ViewModel;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker;
import id.dana.analytics.tracker.riskchallenges.model.RiskChallengeTrackerModel;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.model.VerifyOtpResponse;
import id.dana.network.exception.NetworkException;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.domain.model.RequestOtpModel;
import id.dana.riskChallenges.domain.otp.interactor.RequestOtp;
import id.dana.riskChallenges.domain.otp.interactor.VerifyOtp;
import id.dana.riskChallenges.ui.otp.OtpChallengeUIState;
import id.dana.riskChallenges.ui.util.StringWrapperExtKt;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.strategy.FallbackStrategy;
import id.dana.riskChallenges.ui.util.strategy.FallbackStrategyImpl;
import id.dana.riskChallenges.ui.util.tracker.RiskChallengeTrackerUtil;
import id.dana.utils.StringWrapper;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BO\b\u0007\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002010*\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002000*\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020:0*\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020+0*\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bH\u0097\u0001¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bH\u0097\u0001¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0017\u0010\u0014J\r\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0014J\r\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0014J%\u0010\f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u001dJ\u001c\u0010\t\u001a\u00020\u00122\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0004\b\t\u0010\u001eJ\u001a\u0010\f\u001a\u00020\u00122\b\b\u0001\u0010\u001a\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u001eJ\u001c\u0010\u0007\u001a\u00020\u00122\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0004\b\u0007\u0010\u001eJ\u001a\u0010\u000e\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fH\u0096\u0001¢\u0006\u0004\b\u000e\u0010 J\u0018\u0010\f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010!J\u001c\u0010\u000e\u001a\u00020\u00122\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\"H\u0096\u0001¢\u0006\u0004\b\u0007\u0010#J\u0018\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020$H\u0096\u0001¢\u0006\u0004\b\u000e\u0010%J\u0015\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u001eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0012\u0010\u000e\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010.R\u0012\u0010\u0007\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010/R\u0012\u0010\t\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010/R\u0012\u0010\u0015\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010/R\u0012\u0010\u0018\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010/R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002000*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010-R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002010*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010-R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010-R\u0014\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010/R\u0012\u00104\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010/R\u0012\u00105\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b5\u0010/R\u0012\u0010\u0019\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010/R\u0014\u00107\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010/R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020'08X\u0006¢\u0006\u0006\n\u0004\b7\u00109R\u0012\u00106\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b4\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020:0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010-"}, d2 = {"Lid/dana/riskChallenges/ui/otp/viewmodel/OtpChallengeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/util/strategy/FallbackStrategy;", "Lid/dana/analytics/tracker/riskchallenges/RiskChallengeTracker;", "", "MyBillsEntityDataFactory", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/Throwable;", "PlaceComponentResult", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Z", "", "lookAheadTest", "()V", "scheduleImpl", "getErrorConfigVersion", "onCleared", "moveToNextValue", "initRecordTimeStamp", "p0", "p1", "p2", "(Ljava/lang/String;Ljava/lang/String;Z)V", "(Ljava/lang/String;)V", "Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;", "(Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;)V", "(Ljava/lang/Throwable;)V", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;", "(Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;)V", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;", "(Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldagger/Lazy;", "Lid/dana/riskChallenges/ui/util/strategy/FallbackStrategyImpl;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Ldagger/Lazy;", "Z", "Ljava/lang/String;", "Lid/dana/domain/otp/interactor/ReceiveOtp;", "Lid/dana/riskChallenges/domain/otp/interactor/RequestOtp;", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "PrepareContext", "GetContactSyncConfig", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp;", "newProxyInstance", "p3", "p4", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtpChallengeViewModel extends ViewModel implements FallbackStrategy, RiskChallengeTracker {
    public final /* synthetic */ FallbackStrategyImpl BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String PrepareContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final StateFlow<OtpChallengeUIState> NetworkUserEntityData$$ExternalSyntheticLambda7;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ RiskChallengeTracker MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String moveToNextValue;
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final MutableStateFlow<OtpChallengeUIState> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy<RiskChallengeTracker> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy<FallbackStrategyImpl> BuiltInFictitiousFunctionClassFactory;
    public boolean PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final String GetContactSyncConfig;
    public String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;
    public String initRecordTimeStamp;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy<RequestOtp> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Lazy<ReceiveOtp> getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy<VerifyOtp> isLayoutRequested;
    public String scheduleImpl;

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final Throwable getLookAheadTest() {
        return this.MyBillsEntityDataFactory.getLookAheadTest();
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(p0);
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public final int getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory();
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RiskChallengeTrackerModel.RiskChallengeCompleteModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    /* renamed from: MyBillsEntityDataFactory */
    public final int getBuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory();
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    @TrackerKey.RiskChallenge.Source
    public final String PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.PlaceComponentResult();
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void PlaceComponentResult(RiskChallengeTrackerModel.RiskChallengeOpenModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.PlaceComponentResult(p0);
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void PlaceComponentResult(@TrackerKey.RiskChallenge.Source String p0) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(p0);
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    @TrackerKey.RiskChallenge.Type
    public final String getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void getAuthRequestContext(@TrackerKey.RiskChallenge.Type String p0) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(p0);
    }

    public final boolean getErrorConfigVersion() {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void lookAheadTest() {
        this.MyBillsEntityDataFactory.lookAheadTest();
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void scheduleImpl() {
        this.MyBillsEntityDataFactory.scheduleImpl();
    }

    @Inject
    public OtpChallengeViewModel(Lazy<RequestOtp> lazy, Lazy<ReceiveOtp> lazy2, Lazy<VerifyOtp> lazy3, Lazy<FallbackStrategyImpl> lazy4, Lazy<RiskChallengeTracker> lazy5) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy;
        this.getErrorConfigVersion = lazy2;
        this.isLayoutRequested = lazy3;
        this.BuiltInFictitiousFunctionClassFactory = lazy4;
        this.lookAheadTest = lazy5;
        this.BuiltInFictitiousFunctionClassFactory = lazy4.get();
        this.MyBillsEntityDataFactory = lazy5.get();
        MutableStateFlow<OtpChallengeUIState> MutableStateFlow = StateFlowKt.MutableStateFlow(OtpChallengeUIState.None.INSTANCE);
        this.MyBillsEntityDataFactory = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FlowKt.asStateFlow(MutableStateFlow);
        String obj = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        this.GetContactSyncConfig = obj;
        this.DatabaseTableConfigUtil = "";
        this.moveToNextValue = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        this.scheduleImpl = "";
        this.initRecordTimeStamp = "";
        this.getAuthRequestContext = "";
        this.PrepareContext = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public final void initRecordTimeStamp() {
        MutableStateFlow<OtpChallengeUIState> mutableStateFlow = this.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), OtpChallengeUIState.None.INSTANCE));
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MutableStateFlow<OtpChallengeUIState> mutableStateFlow = this.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), OtpChallengeUIState.ShowProgress.INSTANCE));
        RequestOtp requestOtp = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
        RequestOtp.Params.Companion companion = RequestOtp.Params.INSTANCE;
        requestOtp.execute(RequestOtp.Params.Companion.MyBillsEntityDataFactory(this.GetContactSyncConfig, p0, this.initRecordTimeStamp, this.getAuthRequestContext, this.PlaceComponentResult, p1, this.moveToNextValue, this.scheduleImpl), new Function1<RequestOtpModel, Unit>() { // from class: id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel$sendOtp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RequestOtpModel requestOtpModel) {
                invoke2(requestOtpModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RequestOtpModel requestOtpModel) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                MutableStateFlow mutableStateFlow3;
                Object value2;
                MutableStateFlow mutableStateFlow4;
                Object value3;
                Intrinsics.checkNotNullParameter(requestOtpModel, "");
                OtpChallengeViewModel.this.MyBillsEntityDataFactory.lookAheadTest();
                mutableStateFlow2 = OtpChallengeViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow2.getValue();
                    OtpChallengeUIState otpChallengeUIState = (OtpChallengeUIState) value;
                } while (!mutableStateFlow2.compareAndSet(value, OtpChallengeUIState.DismissProgress.INSTANCE));
                mutableStateFlow3 = OtpChallengeViewModel.this.MyBillsEntityDataFactory;
                do {
                    value2 = mutableStateFlow3.getValue();
                    OtpChallengeUIState otpChallengeUIState2 = (OtpChallengeUIState) value2;
                } while (!mutableStateFlow3.compareAndSet(value2, new OtpChallengeUIState.OnSuccessRequestOtp(requestOtpModel)));
                mutableStateFlow4 = OtpChallengeViewModel.this.MyBillsEntityDataFactory;
                do {
                    value3 = mutableStateFlow4.getValue();
                    OtpChallengeUIState otpChallengeUIState3 = (OtpChallengeUIState) value3;
                } while (!mutableStateFlow4.compareAndSet(value3, OtpChallengeUIState.None.INSTANCE));
                OtpChallengeViewModel.KClassImpl$Data$declaredNonStaticMembers$2(OtpChallengeViewModel.this, p2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel$sendOtp$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MutableStateFlow mutableStateFlow2;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                OtpChallengeViewModel.this.MyBillsEntityDataFactory.lookAheadTest();
                OtpChallengeViewModel otpChallengeViewModel = OtpChallengeViewModel.this;
                Intrinsics.checkNotNullParameter(th, "");
                otpChallengeViewModel.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(th);
                mutableStateFlow2 = OtpChallengeViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow2.getValue();
                    OtpChallengeUIState otpChallengeUIState = (OtpChallengeUIState) value;
                } while (!mutableStateFlow2.compareAndSet(value, OtpChallengeUIState.DismissProgress.INSTANCE));
                OtpChallengeViewModel.KClassImpl$Data$declaredNonStaticMembers$2(OtpChallengeViewModel.this, th, p2);
                OtpChallengeViewModel.PlaceComponentResult(OtpChallengeViewModel.this, th, p2);
            }
        });
    }

    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<OtpChallengeUIState> mutableStateFlow = this.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), OtpChallengeUIState.VerifyProgress.INSTANCE));
        VerifyOtp verifyOtp = this.isLayoutRequested.get();
        VerifyOtp.Params.Companion companion = VerifyOtp.Params.INSTANCE;
        verifyOtp.execute(VerifyOtp.Params.Companion.getAuthRequestContext(p0, this.DatabaseTableConfigUtil, this.moveToNextValue, this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda2, 32), new Function1<VerifyOtpResponse, Unit>() { // from class: id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel$verifyOtp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(VerifyOtpResponse verifyOtpResponse) {
                invoke2(verifyOtpResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyOtpResponse verifyOtpResponse) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                Intrinsics.checkNotNullParameter(verifyOtpResponse, "");
                OtpChallengeViewModel.this.MyBillsEntityDataFactory.scheduleImpl();
                mutableStateFlow2 = OtpChallengeViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow2.getValue();
                    OtpChallengeUIState otpChallengeUIState = (OtpChallengeUIState) value;
                } while (!mutableStateFlow2.compareAndSet(value, new OtpChallengeUIState.VerifySuccess(verifyOtpResponse.getRiskToken())));
                OtpChallengeViewModel.MyBillsEntityDataFactory(OtpChallengeViewModel.this);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel$verifyOtp$3
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
                Intrinsics.checkNotNullParameter(th, "");
                OtpChallengeViewModel.this.MyBillsEntityDataFactory.scheduleImpl();
                OtpChallengeViewModel otpChallengeViewModel = OtpChallengeViewModel.this;
                Intrinsics.checkNotNullParameter(th, "");
                otpChallengeViewModel.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(th);
                OtpChallengeViewModel.MyBillsEntityDataFactory(OtpChallengeViewModel.this, th);
            }
        });
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        super.onCleared();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.isLayoutRequested.get().dispose();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpChallengeViewModel otpChallengeViewModel, Throwable th, boolean z) {
        OtpChallengeUIState.OnErrorRequestOtp onErrorRequestOtp;
        OtpChallengeUIState.OnErrorRequestOtp onErrorRequestOtp2;
        OtpChallengeUIState.OnErrorRequestOtp onErrorRequestOtp3;
        int i = 2;
        ?? r3 = 0;
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            if (Intrinsics.areEqual(networkException.getErrorCode(), "AE15112158100410")) {
                String errorCode = networkException.getErrorCode();
                Intrinsics.checkNotNullExpressionValue(errorCode, "");
                String message = th.getMessage();
                onErrorRequestOtp3 = new OtpChallengeUIState.OnErrorDailyLimit(errorCode, message != null ? message : "");
            } else if (z) {
                String errorCode2 = networkException.getErrorCode();
                Intrinsics.checkNotNullExpressionValue(errorCode2, "");
                onErrorRequestOtp3 = new OtpChallengeUIState.OnErrorFirstTimeRequestOtp(errorCode2, StringWrapperExtKt.getAuthRequestContext(networkException, new StringWrapper.ResValue(R.string.general_error_message, r3, i, r3)));
            } else {
                String errorCode3 = networkException.getErrorCode();
                Intrinsics.checkNotNullExpressionValue(errorCode3, "");
                onErrorRequestOtp3 = new OtpChallengeUIState.OnErrorRequestOtp(errorCode3, StringWrapperExtKt.getAuthRequestContext(networkException, new StringWrapper.ResValue(R.string.general_error_message, r3, i, r3)));
            }
            OtpChallengeUIState otpChallengeUIState = onErrorRequestOtp3;
            MutableStateFlow<OtpChallengeUIState> mutableStateFlow = otpChallengeViewModel.MyBillsEntityDataFactory;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), otpChallengeUIState));
        } else if (th instanceof NoInternetConnectionException) {
            if (z) {
                onErrorRequestOtp2 = new OtpChallengeUIState.OnErrorFirstTimeRequestOtp("", new StringWrapper.ResValue(R.string.general_no_connection_error_message, r3, i, r3));
            } else {
                onErrorRequestOtp2 = new OtpChallengeUIState.OnErrorRequestOtp("", new StringWrapper.ResValue(R.string.general_no_connection_error_message, r3, i, r3));
            }
            MutableStateFlow<OtpChallengeUIState> mutableStateFlow2 = otpChallengeViewModel.MyBillsEntityDataFactory;
            do {
            } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), onErrorRequestOtp2));
        } else {
            if (z) {
                onErrorRequestOtp = new OtpChallengeUIState.OnErrorFirstTimeRequestOtp("", new StringWrapper.ResValue(R.string.general_error_message, r3, i, r3));
            } else {
                onErrorRequestOtp = new OtpChallengeUIState.OnErrorRequestOtp("", new StringWrapper.ResValue(R.string.general_error_message, r3, i, r3));
            }
            MutableStateFlow<OtpChallengeUIState> mutableStateFlow3 = otpChallengeViewModel.MyBillsEntityDataFactory;
            do {
            } while (!mutableStateFlow3.compareAndSet(mutableStateFlow3.getValue(), onErrorRequestOtp));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
    
        if (r4.equals("AE15002058020031") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
    
        if (r4.equals("AE15101858018005") != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
    
        r8 = r7.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ae, code lost:
    
        if (r8.compareAndSet(r8.getValue(), id.dana.riskChallenges.ui.otp.OtpChallengeUIState.TooManyVerifyOtp.INSTANCE) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void MyBillsEntityDataFactory(id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel r7, java.lang.Throwable r8) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel.MyBillsEntityDataFactory(id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel, java.lang.Throwable):void");
    }

    public static final /* synthetic */ void PlaceComponentResult(OtpChallengeViewModel otpChallengeViewModel, Throwable th, boolean z) {
        if (!z) {
            String PlaceComponentResult = StringWrapperExtKt.PlaceComponentResult(th);
            if (Intrinsics.areEqual(PlaceComponentResult, "AE15112158100410")) {
                RiskChallengeTrackerModel.RiskChallengeCompleteModel riskChallengeCompleteModel = new RiskChallengeTrackerModel.RiskChallengeCompleteModel(otpChallengeViewModel.MyBillsEntityDataFactory.PlaceComponentResult(), otpChallengeViewModel.MyBillsEntityDataFactory.getAuthRequestContext(), false, false, otpChallengeViewModel.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory(), otpChallengeViewModel.MyBillsEntityDataFactory.getMyBillsEntityDataFactory(), StringWrapperExtKt.MyBillsEntityDataFactory(th), PlaceComponentResult);
                Intrinsics.checkNotNullParameter(riskChallengeCompleteModel, "");
                otpChallengeViewModel.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(riskChallengeCompleteModel);
                return;
            }
            return;
        }
        String PlaceComponentResult2 = otpChallengeViewModel.MyBillsEntityDataFactory.PlaceComponentResult();
        String authRequestContext = otpChallengeViewModel.MyBillsEntityDataFactory.getAuthRequestContext();
        RiskChallengeTrackerUtil riskChallengeTrackerUtil = RiskChallengeTrackerUtil.INSTANCE;
        boolean errorConfigVersion = otpChallengeViewModel.getErrorConfigVersion();
        HistoryFallbackModel historyFallbackModel = otpChallengeViewModel.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        RiskChallengeTrackerModel.RiskChallengeOpenModel riskChallengeOpenModel = new RiskChallengeTrackerModel.RiskChallengeOpenModel(PlaceComponentResult2, authRequestContext, RiskChallengeTrackerUtil.getAuthRequestContext(errorConfigVersion, historyFallbackModel != null ? historyFallbackModel.MyBillsEntityDataFactory : null), false, StringWrapperExtKt.MyBillsEntityDataFactory(th), StringWrapperExtKt.PlaceComponentResult(th));
        Intrinsics.checkNotNullParameter(riskChallengeOpenModel, "");
        otpChallengeViewModel.MyBillsEntityDataFactory.PlaceComponentResult(riskChallengeOpenModel);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpChallengeViewModel otpChallengeViewModel, boolean z) {
        if (z) {
            String PlaceComponentResult = otpChallengeViewModel.MyBillsEntityDataFactory.PlaceComponentResult();
            String authRequestContext = otpChallengeViewModel.MyBillsEntityDataFactory.getAuthRequestContext();
            RiskChallengeTrackerUtil riskChallengeTrackerUtil = RiskChallengeTrackerUtil.INSTANCE;
            boolean errorConfigVersion = otpChallengeViewModel.getErrorConfigVersion();
            HistoryFallbackModel historyFallbackModel = otpChallengeViewModel.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            RiskChallengeTrackerModel.RiskChallengeOpenModel riskChallengeOpenModel = new RiskChallengeTrackerModel.RiskChallengeOpenModel(PlaceComponentResult, authRequestContext, RiskChallengeTrackerUtil.getAuthRequestContext(errorConfigVersion, historyFallbackModel != null ? historyFallbackModel.MyBillsEntityDataFactory : null), true, null, null, 48, null);
            Intrinsics.checkNotNullParameter(riskChallengeOpenModel, "");
            otpChallengeViewModel.MyBillsEntityDataFactory.PlaceComponentResult(riskChallengeOpenModel);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpChallengeViewModel otpChallengeViewModel) {
        RiskChallengeTrackerModel.RiskChallengeCompleteModel riskChallengeCompleteModel = new RiskChallengeTrackerModel.RiskChallengeCompleteModel(otpChallengeViewModel.MyBillsEntityDataFactory.PlaceComponentResult(), otpChallengeViewModel.MyBillsEntityDataFactory.getAuthRequestContext(), true, false, otpChallengeViewModel.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory(), otpChallengeViewModel.MyBillsEntityDataFactory.getMyBillsEntityDataFactory(), null, null, 192, null);
        Intrinsics.checkNotNullParameter(riskChallengeCompleteModel, "");
        otpChallengeViewModel.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(riskChallengeCompleteModel);
    }

    public final void moveToNextValue() {
        String PlaceComponentResult = this.MyBillsEntityDataFactory.PlaceComponentResult();
        String authRequestContext = this.MyBillsEntityDataFactory.getAuthRequestContext();
        int builtInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory();
        int myBillsEntityDataFactory = this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory();
        Throwable lookAheadTest = this.MyBillsEntityDataFactory.getLookAheadTest();
        String PlaceComponentResult2 = lookAheadTest != null ? StringWrapperExtKt.PlaceComponentResult(lookAheadTest) : null;
        Throwable lookAheadTest2 = this.MyBillsEntityDataFactory.getLookAheadTest();
        RiskChallengeTrackerModel.RiskChallengeCompleteModel riskChallengeCompleteModel = new RiskChallengeTrackerModel.RiskChallengeCompleteModel(PlaceComponentResult, authRequestContext, false, true, builtInFictitiousFunctionClassFactory, myBillsEntityDataFactory, lookAheadTest2 != null ? StringWrapperExtKt.MyBillsEntityDataFactory(lookAheadTest2) : null, PlaceComponentResult2);
        Intrinsics.checkNotNullParameter(riskChallengeCompleteModel, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(riskChallengeCompleteModel);
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.FallbackStrategy
    public final void BuiltInFictitiousFunctionClassFactory(@RiskChallengeKey String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FallbackStrategyImpl fallbackStrategyImpl = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        fallbackStrategyImpl.PlaceComponentResult = p0;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.FallbackStrategy
    public final void KClassImpl$Data$declaredNonStaticMembers$2(@RiskChallengeKey String p0) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.FallbackStrategy
    public final void PlaceComponentResult(HistoryFallbackModel p0) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = p0;
    }
}
