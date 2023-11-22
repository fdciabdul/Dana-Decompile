package id.dana.riskChallenges.ui.missedCallOtp;

import androidx.view.ViewModel;
import dagger.Lazy;
import id.dana.core.ui.util.OSUtil;
import id.dana.domain.citcall.interactor.GetCitcallOtp;
import id.dana.domain.citcall.interactor.GetCitcallPermissionUseCase;
import id.dana.domain.citcall.model.CitcallPermission;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020 0\u0012¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J-\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0012\u0010\u0014\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0014\u0010\r\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0012\u0010\u0018\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "Lid/dana/domain/citcall/model/MiscallConsult;", "p0", "PlaceComponentResult", "(Lid/dana/domain/citcall/model/MiscallConsult;)V", "", "p1", "p2", "p3", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldagger/Lazy;", "Lid/dana/domain/citcall/interactor/GetCitcallOtp;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "getAuthRequestContext", "Lid/dana/domain/citcall/interactor/GetCitcallPermissionUseCase;", "getErrorConfigVersion", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "scheduleImpl", "Lid/dana/domain/otp/interactor/VerifyOtpRisk;", "moveToNextValue", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissedCallOtpViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Lazy<GetCitcallOtp> getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    String getErrorConfigVersion;
    final MutableStateFlow<MissedCallOtpUIState> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetCitcallPermissionUseCase> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final StateFlow<MissedCallOtpUIState> scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<VerifyOtpRisk> moveToNextValue;

    @Inject
    public MissedCallOtpViewModel(Lazy<GetCitcallOtp> lazy, Lazy<GetCitcallPermissionUseCase> lazy2, Lazy<VerifyOtpRisk> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.getAuthRequestContext = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.moveToNextValue = lazy3;
        this.lookAheadTest = "";
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.getErrorConfigVersion = "";
        MutableStateFlow<MissedCallOtpUIState> MutableStateFlow = StateFlowKt.MutableStateFlow(MissedCallOtpUIState.None.INSTANCE);
        this.PlaceComponentResult = MutableStateFlow;
        this.scheduleImpl = FlowKt.asStateFlow(MutableStateFlow);
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.scheduleImpl()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(Unit.INSTANCE, new Function1<CitcallPermission, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$requestCitCallPermission$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CitcallPermission citcallPermission) {
                    invoke2(citcallPermission);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CitcallPermission citcallPermission) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(citcallPermission, "");
                    mutableStateFlow = MissedCallOtpViewModel.this.PlaceComponentResult;
                    do {
                        value = mutableStateFlow.getValue();
                        MissedCallOtpUIState missedCallOtpUIState = (MissedCallOtpUIState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new MissedCallOtpUIState.MissedCallOtpPermission(citcallPermission.getEnableReadCallLog(), citcallPermission.getEnableCallPhone())));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$requestCitCallPermission$2
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
                    Intrinsics.checkNotNullParameter(th, "");
                    mutableStateFlow = MissedCallOtpViewModel.this.PlaceComponentResult;
                    do {
                        value = mutableStateFlow.getValue();
                        MissedCallOtpUIState missedCallOtpUIState = (MissedCallOtpUIState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new MissedCallOtpUIState.MissedCallOtpPermission(true, false)));
                }
            });
            return;
        }
        MutableStateFlow<MissedCallOtpUIState> mutableStateFlow = this.PlaceComponentResult;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new MissedCallOtpUIState.MissedCallOtpPermission(false, true)));
    }

    public final void PlaceComponentResult() {
        MutableStateFlow<MissedCallOtpUIState> mutableStateFlow = this.PlaceComponentResult;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MissedCallOtpUIState.None.INSTANCE));
    }

    public final void PlaceComponentResult(MiscallConsult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<MissedCallOtpUIState> mutableStateFlow = this.PlaceComponentResult;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MissedCallOtpUIState.ShowProgress.INSTANCE));
        this.getAuthRequestContext.get().execute(new GetCitcallOtp.Param(p0), new Function1<MiscallResponse, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$requestOTP$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MiscallResponse miscallResponse) {
                invoke2(miscallResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MiscallResponse miscallResponse) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                Intrinsics.checkNotNullParameter(miscallResponse, "");
                mutableStateFlow2 = MissedCallOtpViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow2.getValue();
                    MissedCallOtpUIState missedCallOtpUIState = (MissedCallOtpUIState) value;
                } while (!mutableStateFlow2.compareAndSet(value, new MissedCallOtpUIState.Success(miscallResponse)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$requestOTP$3
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
                MissedCallOtpViewModel.getAuthRequestContext(MissedCallOtpViewModel.this, th, true);
            }
        });
    }

    public final void MyBillsEntityDataFactory(String p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MutableStateFlow<MissedCallOtpUIState> mutableStateFlow = this.PlaceComponentResult;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MissedCallOtpUIState.ShowProgress.INSTANCE));
        this.moveToNextValue.get().execute(new VerifyOtpRisk.Params(p0, p1, p2, "MISSED_CALL_OTP", p3, this.MyBillsEntityDataFactory), new Function1<VerifyOtpRiskResponse, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$verifyOtp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(VerifyOtpRiskResponse verifyOtpRiskResponse) {
                invoke2(verifyOtpRiskResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyOtpRiskResponse verifyOtpRiskResponse) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                Intrinsics.checkNotNullParameter(verifyOtpRiskResponse, "");
                mutableStateFlow2 = MissedCallOtpViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow2.getValue();
                    MissedCallOtpUIState missedCallOtpUIState = (MissedCallOtpUIState) value;
                } while (!mutableStateFlow2.compareAndSet(value, new MissedCallOtpUIState.VerifySuccess(verifyOtpRiskResponse.getRiskToken())));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$verifyOtp$3
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
                MissedCallOtpViewModel.BuiltInFictitiousFunctionClassFactory(MissedCallOtpViewModel.this, th);
            }
        });
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        super.onCleared();
        this.getAuthRequestContext.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.moveToNextValue.get().dispose();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r0.equals("AE15101858018087") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if (r0.equals(id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode.MAX_ATTEMPTS_REACHED) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        r0 = r13.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r0.compareAndSet(r0.getValue(), id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState.MaxAttemptsReached.INSTANCE) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void getAuthRequestContext(id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel r13, java.lang.Throwable r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel.getAuthRequestContext(id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel, java.lang.Throwable, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r8.equals(id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode.EXCEED_OTP_PERIOD) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r8.equals(id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode.INVALID_OTP) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r8.equals(id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode.VERIFY_OTP_EXPIRED) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r8.equals(id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode.OTP_EXPIRED) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        r8 = r7.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        r7 = r8.getValue();
        r4 = r0.getErrorCode();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        if (r8.compareAndSet(r7, new id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState.VerifyExpired(r4, new id.dana.utils.StringWrapper.ResValue(id.dana.riskChallenges.R.string.res_0x7f130e72_networkuserentitydata_externalsyntheticlambda3, r3, r2, r3))) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (r8.equals(id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode.GENERIC_ERROR) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        r8 = r7.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        r7 = r8.getValue();
        r4 = r0.getErrorCode();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        if (r8.compareAndSet(r7, new id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState.VerifyInvalidOtp(r4, new id.dana.utils.StringWrapper.ResValue(id.dana.riskChallenges.R.string.missed_call_otp_wrong_otp_message, r3, r2, r3))) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel r7, java.lang.Throwable r8) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel.BuiltInFictitiousFunctionClassFactory(id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel, java.lang.Throwable):void");
    }
}
