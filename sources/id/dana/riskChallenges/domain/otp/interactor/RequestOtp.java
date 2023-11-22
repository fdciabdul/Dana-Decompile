package id.dana.riskChallenges.domain.otp.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.model.OtpWhatsAppConfigModel;
import id.dana.riskChallenges.domain.model.OtpAttempts;
import id.dana.riskChallenges.domain.model.RequestOtpModel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/domain/otp/interactor/RequestOtp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/riskChallenges/domain/model/RequestOtpModel;", "Lid/dana/riskChallenges/domain/otp/interactor/RequestOtp$Params;", "", "", "Lid/dana/riskChallenges/domain/model/OtpAttempts;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "MyBillsEntityDataFactory", "Lid/dana/domain/registration/RegistrationRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/registration/RegistrationRepository;", "Lid/dana/domain/otp/OtpRepository;", "PlaceComponentResult", "Lid/dana/domain/otp/OtpRepository;", "p0", "p1", "<init>", "(Lid/dana/domain/otp/OtpRepository;Lid/dana/domain/registration/RegistrationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestOtp extends BaseUseCase<RequestOtpModel, Params> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final RegistrationRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Map<String, OtpAttempts> MyBillsEntityDataFactory;
    private final OtpRepository PlaceComponentResult;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        if (r1.equals("AP_DAPROT_ACTIVITY") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r1.equals("CHANGE_PASSWORD") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r1.equals("AP_LOGIN") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        if (r11.getScheduleImpl() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        r2 = r10.PlaceComponentResult;
        r3 = r11.moveToNextValue;
        r4 = r11.getErrorConfigVersion;
        r5 = r11.MyBillsEntityDataFactory;
        r1 = r11.getPlaceComponentResult();
        r1 = r2.sendOtp(r3, r4, r5, java.lang.Boolean.valueOf(r1), r11.BuiltInFictitiousFunctionClassFactory, r11.getAuthRequestContext, r11.KClassImpl$Data$declaredNonStaticMembers$2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        r2 = r10.PlaceComponentResult;
        r3 = r11.moveToNextValue;
        r4 = r11.getErrorConfigVersion;
        r5 = r11.MyBillsEntityDataFactory;
        r1 = r11.getPlaceComponentResult();
        r1 = r2.sendOtpWithoutCache(r3, r4, r5, java.lang.Boolean.valueOf(r1), r11.BuiltInFictitiousFunctionClassFactory, r11.getAuthRequestContext, r11.KClassImpl$Data$declaredNonStaticMembers$2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r1.equals("MODIFY_PASSWORD") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        if (r1.equals("AP_RESET_SIMPLE_PWD") == false) goto L26;
     */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.domain.core.usecase.BaseUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ io.reactivex.Observable<id.dana.riskChallenges.domain.model.RequestOtpModel> buildUseCase(id.dana.riskChallenges.domain.otp.interactor.RequestOtp.Params r11) {
        /*
            r10 = this;
            id.dana.riskChallenges.domain.otp.interactor.RequestOtp$Params r11 = (id.dana.riskChallenges.domain.otp.interactor.RequestOtp.Params) r11
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r1 = r11.moveToNextValue
            int r2 = r1.hashCode()
            switch(r2) {
                case -1903213767: goto L52;
                case -1845462454: goto L49;
                case -155850886: goto L40;
                case 92413603: goto L26;
                case 550153776: goto L1c;
                case 1737236608: goto L12;
                default: goto L10;
            }
        L10:
            goto L96
        L12:
            java.lang.String r2 = "MODIFY_PASSWORD"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5a
            goto L96
        L1c:
            java.lang.String r2 = "AP_RESET_SIMPLE_PWD"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5a
            goto L96
        L26:
            java.lang.String r2 = "REGISTER"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L96
            id.dana.domain.registration.RegistrationRepository r1 = r10.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r2 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            io.reactivex.Observable r1 = r1.resendOtpRegister(r2)
            id.dana.riskChallenges.domain.otp.interactor.RequestOtp$$ExternalSyntheticLambda2 r2 = new id.dana.riskChallenges.domain.otp.interactor.RequestOtp$$ExternalSyntheticLambda2
            r2.<init>()
            io.reactivex.Observable r1 = r1.map(r2)
            goto La3
        L40:
            java.lang.String r2 = "AP_DAPROT_ACTIVITY"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L96
            goto L5a
        L49:
            java.lang.String r2 = "CHANGE_PASSWORD"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5a
            goto L96
        L52:
            java.lang.String r2 = "AP_LOGIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L96
        L5a:
            boolean r1 = r11.getScheduleImpl()
            if (r1 == 0) goto L7b
            id.dana.domain.otp.OtpRepository r2 = r10.PlaceComponentResult
            java.lang.String r3 = r11.moveToNextValue
            java.lang.String r4 = r11.getErrorConfigVersion
            java.lang.String r5 = r11.MyBillsEntityDataFactory
            boolean r1 = r11.getPlaceComponentResult()
            java.lang.String r7 = r11.BuiltInFictitiousFunctionClassFactory
            java.lang.String r8 = r11.getAuthRequestContext
            java.lang.String r9 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            io.reactivex.Observable r1 = r2.sendOtp(r3, r4, r5, r6, r7, r8, r9)
            goto La3
        L7b:
            id.dana.domain.otp.OtpRepository r2 = r10.PlaceComponentResult
            java.lang.String r3 = r11.moveToNextValue
            java.lang.String r4 = r11.getErrorConfigVersion
            java.lang.String r5 = r11.MyBillsEntityDataFactory
            boolean r1 = r11.getPlaceComponentResult()
            java.lang.String r7 = r11.BuiltInFictitiousFunctionClassFactory
            java.lang.String r8 = r11.getAuthRequestContext
            java.lang.String r9 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            io.reactivex.Observable r1 = r2.sendOtpWithoutCache(r3, r4, r5, r6, r7, r8, r9)
            goto La3
        L96:
            kotlin.NotImplementedError r1 = new kotlin.NotImplementedError
            r2 = 1
            r3 = 0
            r1.<init>(r3, r2, r3)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            io.reactivex.Observable r1 = io.reactivex.Observable.error(r1)
        La3:
            id.dana.riskChallenges.domain.otp.interactor.RequestOtp$$ExternalSyntheticLambda3 r2 = new id.dana.riskChallenges.domain.otp.interactor.RequestOtp$$ExternalSyntheticLambda3
            r2.<init>()
            io.reactivex.Observable r11 = r1.flatMap(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.domain.otp.interactor.RequestOtp.buildUseCase(java.lang.Object):io.reactivex.Observable");
    }

    @Inject
    public RequestOtp(OtpRepository otpRepository, RegistrationRepository registrationRepository) {
        Intrinsics.checkNotNullParameter(otpRepository, "");
        Intrinsics.checkNotNullParameter(registrationRepository, "");
        this.PlaceComponentResult = otpRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = registrationRepository;
        this.MyBillsEntityDataFactory = new LinkedHashMap();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBQ\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0011\u0010\u000b\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0011\u0010\t\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0011\u0010\u0003\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0011\u0010\u000e\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0011\u0010\u000f\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/riskChallenges/domain/otp/interactor/RequestOtp$Params;", "", "", "moveToNextValue", "Z", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "scheduleImpl", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        private final boolean scheduleImpl;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String moveToNextValue;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        final String lookAheadTest;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        final String getErrorConfigVersion;

        public /* synthetic */ Params(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, z, str5, str6, str7, z2);
        }

        private Params(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, boolean z2) {
            this.lookAheadTest = str;
            this.moveToNextValue = str2;
            this.getErrorConfigVersion = str3;
            this.MyBillsEntityDataFactory = str4;
            this.PlaceComponentResult = z;
            this.BuiltInFictitiousFunctionClassFactory = str5;
            this.getAuthRequestContext = str6;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
            this.scheduleImpl = z2;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getScheduleImpl() {
            return this.scheduleImpl;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/otp/interactor/RequestOtp$Params$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params MyBillsEntityDataFactory(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7) {
                Intrinsics.checkNotNullParameter(str, "");
                return new Params(str, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, z, str5 == null ? "" : str5, str6 == null ? "" : str6, str7 == null ? "" : str7, false, null);
            }
        }
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final RequestOtp requestOtp, Params params, final SendOtpResponse sendOtpResponse) {
        Observable just;
        Intrinsics.checkNotNullParameter(requestOtp, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(sendOtpResponse, "");
        final String str = params.lookAheadTest;
        if (Intrinsics.areEqual(params.KClassImpl$Data$declaredNonStaticMembers$2, OtpChannel.WHATSAPP)) {
            final OtpAttempts otpAttempts = requestOtp.MyBillsEntityDataFactory.get(str);
            just = requestOtp.KClassImpl$Data$declaredNonStaticMembers$2.getOtpWhatsAppConfig().map(new Function() { // from class: id.dana.riskChallenges.domain.otp.interactor.RequestOtp$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RequestOtp.getAuthRequestContext(OtpAttempts.this, requestOtp, str, (OtpWhatsAppConfigModel) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            just = Observable.just(new OtpAttempts(0, 0));
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just.map(new Function() { // from class: id.dana.riskChallenges.domain.otp.interactor.RequestOtp$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RequestOtp.MyBillsEntityDataFactory(SendOtpResponse.this, (OtpAttempts) obj);
            }
        });
    }

    public static /* synthetic */ SendOtpResponse KClassImpl$Data$declaredNonStaticMembers$2(CheckRegistrationResponse checkRegistrationResponse) {
        Intrinsics.checkNotNullParameter(checkRegistrationResponse, "");
        SendOtpResponse sendOtpResponse = new SendOtpResponse();
        sendOtpResponse.setExpirySeconds(checkRegistrationResponse.getExpirySeconds());
        sendOtpResponse.setOtpCodeLength(checkRegistrationResponse.getOtpCodeLength());
        sendOtpResponse.setRetrySendSeconds(checkRegistrationResponse.getRetrySendSeconds());
        sendOtpResponse.setSuccess(checkRegistrationResponse.isSuccess());
        return sendOtpResponse;
    }

    public static /* synthetic */ OtpAttempts getAuthRequestContext(OtpAttempts otpAttempts, RequestOtp requestOtp, String str, OtpWhatsAppConfigModel otpWhatsAppConfigModel) {
        OtpAttempts MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(requestOtp, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(otpWhatsAppConfigModel, "");
        if (otpAttempts == null) {
            MyBillsEntityDataFactory = new OtpAttempts(1, otpWhatsAppConfigModel.getMaxAttemptBeforeFallback() - 1);
        } else {
            int i = otpAttempts.PlaceComponentResult + 1;
            MyBillsEntityDataFactory = OtpAttempts.MyBillsEntityDataFactory(i, otpWhatsAppConfigModel.getMaxAttemptBeforeFallback() - i);
        }
        requestOtp.MyBillsEntityDataFactory.put(str, MyBillsEntityDataFactory);
        return MyBillsEntityDataFactory;
    }

    public static /* synthetic */ RequestOtpModel MyBillsEntityDataFactory(SendOtpResponse sendOtpResponse, OtpAttempts otpAttempts) {
        Intrinsics.checkNotNullParameter(sendOtpResponse, "");
        Intrinsics.checkNotNullParameter(otpAttempts, "");
        return new RequestOtpModel(sendOtpResponse.getOtpCodeLength(), sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getExpirySeconds(), otpAttempts.PlaceComponentResult, otpAttempts.MyBillsEntityDataFactory);
    }
}
