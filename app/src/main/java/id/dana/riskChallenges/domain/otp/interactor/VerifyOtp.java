package id.dana.riskChallenges.domain.otp.interactor;

import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.model.VerifyOtpResponse;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/otp/model/VerifyOtpResponse;", "Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp$Params;", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/login/LoginRepository;", "Lid/dana/domain/login/LoginRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/otp/OtpRepository;", "Lid/dana/domain/otp/OtpRepository;", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(Lid/dana/domain/login/LoginRepository;Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;Lid/dana/domain/otp/OtpRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyOtp extends BaseUseCase<VerifyOtpResponse, Params> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final OtpRepository getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final LoginRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CarrierIdentificationRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        if (r1.equals("REGISTER") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        if (r1.equals("LOGIN") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r4 = r13.KClassImpl$Data$declaredNonStaticMembers$2;
        r5 = r14.MyBillsEntityDataFactory;
        r6 = r14.KClassImpl$Data$declaredNonStaticMembers$2;
        r7 = r14.BuiltInFictitiousFunctionClassFactory;
        r8 = r14.moveToNextValue;
        r9 = r14.lookAheadTest;
        r1 = r14.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r1 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r1.length() != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        if (r3 == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        r14 = kotlin.collections.MapsKt.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        r14 = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to("riskToken", r14.getAuthRequestContext));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        r14 = r4.verifyOtpToRisk(r5, r6, r7, r8, r9, r14).map(new id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda0());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
    
        if (r1.equals("AP_DAPROT_ACTIVITY") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        if (r1.equals("CHANGE_PASSWORD") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
    
        r14 = id.dana.domain.carrieridentification.CarrierIdentificationRepository.CC.verifyOtpToRisk$default(r13.KClassImpl$Data$declaredNonStaticMembers$2, r14.MyBillsEntityDataFactory, r14.KClassImpl$Data$declaredNonStaticMembers$2, r14.BuiltInFictitiousFunctionClassFactory, r14.moveToNextValue, r14.lookAheadTest, null, 32, null).map(new id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda1());
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        if (r1.equals("MODIFY_PASSWORD") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r1.equals("AP_RESET_SIMPLE_PWD") == false) goto L35;
     */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.domain.core.usecase.BaseUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ io.reactivex.Observable<id.dana.domain.otp.model.VerifyOtpResponse> buildUseCase(id.dana.riskChallenges.domain.otp.interactor.VerifyOtp.Params r14) {
        /*
            r13 = this;
            id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$Params r14 = (id.dana.riskChallenges.domain.otp.interactor.VerifyOtp.Params) r14
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r1 = r14.lookAheadTest
            int r2 = r1.hashCode()
            r3 = 1
            switch(r2) {
                case -1903213767: goto La4;
                case -1845462454: goto L7e;
                case -155850886: goto L75;
                case 72611657: goto L31;
                case 92413603: goto L27;
                case 550153776: goto L1d;
                case 1737236608: goto L13;
                default: goto L11;
            }
        L11:
            goto Lc2
        L13:
            java.lang.String r2 = "MODIFY_PASSWORD"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L39
            goto Lc2
        L1d:
            java.lang.String r2 = "AP_RESET_SIMPLE_PWD"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L86
            goto Lc2
        L27:
            java.lang.String r2 = "REGISTER"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L86
            goto Lc2
        L31:
            java.lang.String r2 = "LOGIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lc2
        L39:
            id.dana.domain.carrieridentification.CarrierIdentificationRepository r4 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r5 = r14.MyBillsEntityDataFactory
            java.lang.String r6 = r14.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r7 = r14.BuiltInFictitiousFunctionClassFactory
            java.lang.String r8 = r14.moveToNextValue
            java.lang.String r9 = r14.lookAheadTest
            java.lang.String r1 = r14.getAuthRequestContext
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L53
            int r1 = r1.length()
            if (r1 != 0) goto L52
            goto L53
        L52:
            r3 = 0
        L53:
            if (r3 == 0) goto L5a
            java.util.Map r14 = kotlin.collections.MapsKt.emptyMap()
            goto L66
        L5a:
            java.lang.String r14 = r14.getAuthRequestContext
            java.lang.String r1 = "riskToken"
            kotlin.Pair r14 = kotlin.TuplesKt.to(r1, r14)
            java.util.Map r14 = kotlin.collections.MapsKt.mapOf(r14)
        L66:
            r10 = r14
            io.reactivex.Observable r14 = r4.verifyOtpToRisk(r5, r6, r7, r8, r9, r10)
            id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda0 r1 = new id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda0
            r1.<init>()
            io.reactivex.Observable r14 = r14.map(r1)
            goto Lce
        L75:
            java.lang.String r2 = "AP_DAPROT_ACTIVITY"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L86
            goto Lc2
        L7e:
            java.lang.String r2 = "CHANGE_PASSWORD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lc2
        L86:
            id.dana.domain.carrieridentification.CarrierIdentificationRepository r4 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r5 = r14.MyBillsEntityDataFactory
            java.lang.String r6 = r14.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r7 = r14.BuiltInFictitiousFunctionClassFactory
            java.lang.String r8 = r14.moveToNextValue
            java.lang.String r9 = r14.lookAheadTest
            r10 = 0
            r11 = 32
            r12 = 0
            io.reactivex.Observable r14 = id.dana.domain.carrieridentification.CarrierIdentificationRepository.CC.verifyOtpToRisk$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda1 r1 = new id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda1
            r1.<init>()
            io.reactivex.Observable r14 = r14.map(r1)
            goto Lce
        La4:
            java.lang.String r2 = "AP_LOGIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lc2
            id.dana.domain.login.LoginRepository r1 = r13.BuiltInFictitiousFunctionClassFactory
            java.lang.String r2 = r14.MyBillsEntityDataFactory
            java.lang.String r3 = r14.PlaceComponentResult
            java.lang.String r14 = r14.moveToNextValue
            io.reactivex.Observable r14 = r1.otpLogin(r2, r3, r14)
            id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda2 r1 = new id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda2
            r1.<init>()
            io.reactivex.Observable r14 = r14.map(r1)
            goto Lce
        Lc2:
            kotlin.NotImplementedError r14 = new kotlin.NotImplementedError
            r1 = 0
            r14.<init>(r1, r3, r1)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            io.reactivex.Observable r14 = io.reactivex.Observable.error(r14)
        Lce:
            id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda3 r1 = new id.dana.riskChallenges.domain.otp.interactor.VerifyOtp$$ExternalSyntheticLambda3
            r1.<init>()
            io.reactivex.Observable r14 = r14.doOnNext(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.domain.otp.interactor.VerifyOtp.buildUseCase(java.lang.Object):io.reactivex.Observable");
    }

    @Inject
    public VerifyOtp(LoginRepository loginRepository, CarrierIdentificationRepository carrierIdentificationRepository, OtpRepository otpRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        Intrinsics.checkNotNullParameter(carrierIdentificationRepository, "");
        Intrinsics.checkNotNullParameter(otpRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = loginRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = carrierIdentificationRepository;
        this.getAuthRequestContext = otpRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016BA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\n\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0011\u0010\f\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp$Params;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "lookAheadTest", "getErrorConfigVersion", "moveToNextValue", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        final String moveToNextValue;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        final String lookAheadTest;

        public Params(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.BuiltInFictitiousFunctionClassFactory = str3;
            this.moveToNextValue = str4;
            this.lookAheadTest = str5;
            this.PlaceComponentResult = str6;
            this.getAuthRequestContext = str7;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp$Params$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params getAuthRequestContext(String str, String str2, String str3, String str4, String str5, String str6, int i) {
                String str7 = (i & 4) != 0 ? null : str3;
                String str8 = (i & 8) != 0 ? null : str4;
                String str9 = (i & 16) != 0 ? null : str5;
                return new Params(str == null ? "" : str, str2 == null ? "" : str2, str7 == null ? "" : str7, str8 == null ? "" : str8, str9 == null ? "" : str9, "", (i & 64) != 0 ? null : str6);
            }
        }
    }

    public static /* synthetic */ VerifyOtpResponse PlaceComponentResult(VerifyOtpRiskResponse verifyOtpRiskResponse) {
        Intrinsics.checkNotNullParameter(verifyOtpRiskResponse, "");
        return new VerifyOtpResponse(verifyOtpRiskResponse.getIdentFailedCount(), 0, verifyOtpRiskResponse.getRiskToken(), 2, null);
    }

    public static /* synthetic */ VerifyOtpResponse KClassImpl$Data$declaredNonStaticMembers$2(VerifyOtpRiskResponse verifyOtpRiskResponse) {
        Intrinsics.checkNotNullParameter(verifyOtpRiskResponse, "");
        return new VerifyOtpResponse(verifyOtpRiskResponse.getIdentFailedCount(), 0, verifyOtpRiskResponse.getRiskToken(), 2, null);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerifyOtp verifyOtp) {
        Intrinsics.checkNotNullParameter(verifyOtp, "");
        verifyOtp.getAuthRequestContext.clearOtpRetryManager();
    }

    public static /* synthetic */ VerifyOtpResponse MyBillsEntityDataFactory(LoginResponse loginResponse) {
        Intrinsics.checkNotNullParameter(loginResponse, "");
        VerifyOtpResponse verifyOtpResponse = new VerifyOtpResponse(0, 0, null, 7, null);
        verifyOtpResponse.setFailedCount(loginResponse.getFailedCount());
        Integer maxFailedCount = loginResponse.getMaxFailedCount();
        verifyOtpResponse.setMaxFailedCount(maxFailedCount != null ? maxFailedCount.intValue() : 0);
        verifyOtpResponse.setSuccess(loginResponse.isSuccess());
        return verifyOtpResponse;
    }
}
