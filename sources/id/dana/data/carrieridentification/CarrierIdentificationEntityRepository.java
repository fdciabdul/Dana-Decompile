package id.dana.data.carrieridentification;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import com.ipification.mobile.sdk.android.IPificationServices;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.response.CoverageResponse;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.carrieridentification.mapper.CarrierIdentificationDataMapperKt;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.carrieridentification.source.CarrierIdentificationDataFactory;
import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.data.login.source.network.result.NetworkUrlRpcResult;
import id.dana.data.registration.RegistrationProcessManager;
import id.dana.data.registration.source.RegistrationEntityDataFactory;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.carrieridentification.model.CheckCoverageResponse;
import id.dana.domain.carrieridentification.model.GetAuthCodeResponse;
import id.dana.domain.carrieridentification.model.VerifySecurityProduct;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import id.dana.network.response.login.VerifyOtpResult;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J(\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\fH\u0002J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\fH\u0016JJ\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00192\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0/H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lid/dana/data/carrieridentification/CarrierIdentificationEntityRepository;", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", HummerConstants.CONTEXT, "Landroid/content/Context;", "regManager", "Lid/dana/data/registration/RegistrationProcessManager;", "carrierIdentificationDataFactory", "Lid/dana/data/carrieridentification/source/CarrierIdentificationDataFactory;", "registrationEntityDataFactory", "Lid/dana/data/registration/source/RegistrationEntityDataFactory;", "(Landroid/content/Context;Lid/dana/data/registration/RegistrationProcessManager;Lid/dana/data/carrieridentification/source/CarrierIdentificationDataFactory;Lid/dana/data/registration/source/RegistrationEntityDataFactory;)V", NetworkUrlRpcResult.ParamsName.CORRELATION_ID, "", "startAuthConversionTime", "", "stopAuthConversionTime", "checkIPificationCoverage", "Lio/reactivex/Single;", "Lid/dana/domain/carrieridentification/model/CheckCoverageResponse;", "phoneNumber", "createCarrierIdentificationEntityData", "Lid/dana/data/carrieridentification/source/CarrierIdentificationEntityData;", "createLocalRegistrationEntityData", "Lid/dana/data/registration/source/RegistrationEntityData;", "getIPificationAuthCode", "Lio/reactivex/Observable;", "Lid/dana/domain/carrieridentification/model/GetAuthCodeResponse;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", BioUtilityBridge.SECURITY_ID, "redirectUri", "trackIpificationAuth", "", "success", "", "errorCode", "errorMessage", "verifyIpificationAuthCode", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "verifySecurityProduct", "Lid/dana/domain/carrieridentification/model/VerifySecurityProduct;", "verifyOtpToRisk", "Lid/dana/domain/otp/model/VerifyOtpRiskResponse;", "otpValue", CashierKeyParams.VERIFICATION_METHOD, "sendOtpStrategy", ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, "", "Companion", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CarrierIdentificationEntityRepository implements CarrierIdentificationRepository {
    public static final Companion PlaceComponentResult = new Companion(null);
    private final CarrierIdentificationDataFactory BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private final RegistrationProcessManager getAuthRequestContext;
    private long getErrorConfigVersion;
    private final RegistrationEntityDataFactory moveToNextValue;
    private long scheduleImpl;

    @Inject
    public CarrierIdentificationEntityRepository(Context context, RegistrationProcessManager registrationProcessManager, CarrierIdentificationDataFactory carrierIdentificationDataFactory, RegistrationEntityDataFactory registrationEntityDataFactory) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(registrationProcessManager, "");
        Intrinsics.checkNotNullParameter(carrierIdentificationDataFactory, "");
        Intrinsics.checkNotNullParameter(registrationEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.getAuthRequestContext = registrationProcessManager;
        this.BuiltInFictitiousFunctionClassFactory = carrierIdentificationDataFactory;
        this.moveToNextValue = registrationEntityDataFactory;
        this.MyBillsEntityDataFactory = "";
    }

    @Override // id.dana.domain.carrieridentification.CarrierIdentificationRepository
    public final Single<CheckCoverageResponse> checkIPificationCoverage(final String phoneNumber) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                CarrierIdentificationEntityRepository.getAuthRequestContext(phoneNumber, this, singleEmitter);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(MyBillsEntityDataFactory, 2L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
        CheckCoverageResponse checkCoverageResponse = new CheckCoverageResponse(false, " ", "INIT");
        ObjectHelper.PlaceComponentResult(checkCoverageResponse, "value is null");
        Single<CheckCoverageResponse> BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory, null, checkCoverageResponse));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        return BuiltInFictitiousFunctionClassFactory2;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, android.net.Uri] */
    @Override // id.dana.domain.carrieridentification.CarrierIdentificationRepository
    public final Observable<GetAuthCodeResponse> getIPificationAuthCode(final Activity activity, String securityId, String phoneNumber, String redirectUri) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(redirectUri, "");
        this.getErrorConfigVersion = System.currentTimeMillis();
        String replace$default = StringsKt.replace$default(phoneNumber, "+", "", false, 4, (Object) null);
        ?? r5 = 0;
        AuthRequest.Builder builder = new AuthRequest.Builder(r5, 1, r5);
        if (TextUtils.isEmpty("openid ip:phone_verify")) {
            builder.getErrorConfigVersion = null;
        } else {
            Object[] array = StringsKt.split$default((CharSequence) "openid ip:phone_verify", new String[]{" +"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            if (strArr == null) {
                strArr = new String[0];
            }
            String joinToString$default = ArraysKt.joinToString$default(strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
            builder.getErrorConfigVersion = joinToString$default;
            Intrinsics.stringPlus("scope: ", joinToString$default);
        }
        builder.KClassImpl$Data$declaredNonStaticMembers$2("login_hint", replace$default);
        final AuthRequest KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        Observable<GetAuthCodeResponse> onErrorReturnItem = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                CarrierIdentificationEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(activity, KClassImpl$Data$declaredNonStaticMembers$2, this, observableEmitter);
            }
        }).onErrorReturnItem(new GetAuthCodeResponse(false, null, " ", "INIT"));
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, String str, String str2) {
        long j = this.scheduleImpl;
        long j2 = this.getErrorConfigVersion;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Success", z);
            jSONObject.put("Source", "Registration");
            jSONObject.put(TrackerDataKey.Property.CONVERSION_TIME, String.valueOf(j - j2));
            jSONObject.put("Error Code", str);
            jSONObject.put("Error Message", str2);
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("HOLD_LOGIN_V2", "Unable to add properties to JSONObject", e);
        }
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, "CI Authentication", jSONObject);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/carrieridentification/CarrierIdentificationEntityRepository$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getAuthRequestContext(CarrierIdentificationEntityRepository carrierIdentificationEntityRepository, String str, String str2, VerifyOtpResult verifyOtpResult) {
        Intrinsics.checkNotNullParameter(carrierIdentificationEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (verifyOtpResult.success) {
            carrierIdentificationEntityRepository.getAuthRequestContext.setVerifyMethod(str);
            carrierIdentificationEntityRepository.moveToNextValue.createData2("local").clearLastOtpChannel(str2);
            carrierIdentificationEntityRepository.moveToNextValue.createData2("local").clearIsFreezeVerifyOtp(str2);
            carrierIdentificationEntityRepository.moveToNextValue.createData2("local").clearResendOtpTimelimit(str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01e9, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1 == null ? null : r1.get("login_hint"), "") == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01eb, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01f5, code lost:
    
        if (com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().getOnBoardingScenario == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01f7, code lost:
    
        r1 = com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().getOnBoardingScenario;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01fd, code lost:
    
        if (r1 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01ff, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0202, code lost:
    
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0214, code lost:
    
        if (com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().getNetworkUserEntityData$$ExternalSyntheticLambda8() == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x021d, code lost:
    
        if (com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().FragmentBottomSheetPaymentSettingBinding.length != 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x021f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0221, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0222, code lost:
    
        if (r1 == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0224, code lost:
    
        r2.PlaceComponentResult(new java.lang.NullPointerException("[IPConfiguration] IM_PRIORITY_APP_LIST is empty"), 1008);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x022e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0231, code lost:
    
        if (r0.initRecordTimeStamp != null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0233, code lost:
    
        r0.initRecordTimeStamp = new java.util.HashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x023a, code lost:
    
        r1 = r0.initRecordTimeStamp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x023c, code lost:
    
        if (r1 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x023e, code lost:
    
        r1.put("channel", kotlin.collections.ArraysKt.joinToString$default(com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().FragmentBottomSheetPaymentSettingBinding, " ", (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 62, (java.lang.Object) null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0258, code lost:
    
        r1 = com.ipification.mobile.sdk.android.utils.IPConstant.INSTANCE;
        r1 = com.ipification.mobile.sdk.android.utils.IPConstant.Companion.PlaceComponentResult();
        r3 = new java.lang.StringBuilder();
        r3.append(r1.DatabaseTableConfigUtil);
        r3.append("channel list");
        r3.append(com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().FragmentBottomSheetPaymentSettingBinding.length);
        r3.append('\n');
        r3 = r3.toString();
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, "");
        r1.DatabaseTableConfigUtil = r3;
        r1 = com.ipification.mobile.sdk.android.utils.IPConstant.Companion.PlaceComponentResult();
        r3 = new java.lang.StringBuilder();
        r3.append(r1.DatabaseTableConfigUtil);
        r3.append("set channel ");
        r3.append(kotlin.collections.ArraysKt.joinToString$default(com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().FragmentBottomSheetPaymentSettingBinding, " ", (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 62, (java.lang.Object) null));
        r3.append('\n');
        r3 = r3.toString();
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, "");
        r1.DatabaseTableConfigUtil = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02bd, code lost:
    
        r1 = r0.initRecordTimeStamp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02bf, code lost:
    
        if (r1 != null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02c1, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02c3, code lost:
    
        r1 = r1.get("channel");
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02c9, code lost:
    
        if (r1 != null) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02cb, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02cc, code lost:
    
        r2.DatabaseTableConfigUtil = r6;
        r2.scheduleImpl = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02d0, code lost:
    
        if (r1 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02d8, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) io.opentelemetry.semconv.trace.attributes.SemanticAttributes.NetTransportValues.IP, false, 2, (java.lang.Object) null) != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02da, code lost:
    
        r3 = com.ipification.mobile.sdk.android.utils.IPConstant.INSTANCE;
        r3 = com.ipification.mobile.sdk.android.utils.IPConstant.Companion.PlaceComponentResult();
        r5 = new java.lang.StringBuilder();
        r5.append(r3.DatabaseTableConfigUtil);
        r5.append("get channel ");
        r5.append((java.lang.Object) r1);
        r5.append(id.dana.cashier.view.InputCardNumberView.DIVIDER);
        r1 = r0.initRecordTimeStamp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02f9, code lost:
    
        if (r1 != null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02fc, code lost:
    
        r8 = java.lang.Integer.valueOf(r1.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0304, code lost:
    
        r5.append(r8);
        r5.append('\n');
        r1 = r5.toString();
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, "");
        r3.DatabaseTableConfigUtil = r1;
        r2.getAuthRequestContext(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0316, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0317, code lost:
    
        r2.PlaceComponentResult(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x031a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b8, code lost:
    
        if ((r1 != null && kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) "ip:profile", false, 2, (java.lang.Object) null)) != false) goto L96;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(android.app.Activity r21, com.ipification.mobile.sdk.android.request.AuthRequest r22, final id.dana.data.carrieridentification.CarrierIdentificationEntityRepository r23, final io.reactivex.ObservableEmitter r24) {
        /*
            Method dump skipped, instructions count: 806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(android.app.Activity, com.ipification.mobile.sdk.android.request.AuthRequest, id.dana.data.carrieridentification.CarrierIdentificationEntityRepository, io.reactivex.ObservableEmitter):void");
    }

    public static /* synthetic */ VerifySecurityInfo BuiltInFictitiousFunctionClassFactory(VerifySecurityProductResult verifySecurityProductResult) {
        Intrinsics.checkNotNullParameter(verifySecurityProductResult, "");
        return CarrierIdentificationDataMapperKt.getAuthRequestContext(verifySecurityProductResult);
    }

    public static /* synthetic */ void getAuthRequestContext(String str, CarrierIdentificationEntityRepository carrierIdentificationEntityRepository, final SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(carrierIdentificationEntityRepository, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        IPificationServices.Companion companion = IPificationServices.INSTANCE;
        IPificationServices.Companion.getAuthRequestContext(str, carrierIdentificationEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2, new CellularCallback<CoverageResponse>() { // from class: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository$checkIPificationCoverage$1$1
            @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
            public final /* synthetic */ void PlaceComponentResult(CoverageResponse coverageResponse) {
                CoverageResponse coverageResponse2 = coverageResponse;
                Intrinsics.checkNotNullParameter(coverageResponse2, "");
                singleEmitter.onSuccess(new CheckCoverageResponse(coverageResponse2.PlaceComponentResult(), " ", " "));
            }

            @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
            public final void BuiltInFictitiousFunctionClassFactory(CellularException p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SingleEmitter<CheckCoverageResponse> singleEmitter2 = singleEmitter;
                String str2 = p0.PlaceComponentResult;
                if (str2 == null) {
                    str2 = " ";
                }
                singleEmitter2.onSuccess(new CheckCoverageResponse(false, str2, p0.PlaceComponentResult()));
                StringBuilder sb = new StringBuilder();
                sb.append("checkCoverage - error : ");
                sb.append(p0.getAuthRequestContext);
                sb.append(" - ");
                sb.append(p0.PlaceComponentResult());
                DanaLog.BuiltInFictitiousFunctionClassFactory("IPificationSDK", sb.toString());
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CarrierIdentificationEntityRepository carrierIdentificationEntityRepository, VerifySecurityInfo verifySecurityInfo) {
        Intrinsics.checkNotNullParameter(carrierIdentificationEntityRepository, "");
        if (verifySecurityInfo.getSuccess()) {
            carrierIdentificationEntityRepository.getAuthRequestContext.setVerifyMethod(VerifyMethod.CARRIER_IDENTIFICATION);
        }
    }

    public static /* synthetic */ VerifyOtpRiskResponse getAuthRequestContext(VerifyOtpResult verifyOtpResult) {
        Intrinsics.checkNotNullParameter(verifyOtpResult, "");
        boolean z = verifyOtpResult.success;
        String str = verifyOtpResult.errorCode;
        String str2 = str == null ? "" : str;
        String str3 = verifyOtpResult.errorMessage;
        String str4 = str3 == null ? "" : str3;
        int i = verifyOtpResult.identFailedCount;
        Map<String, String> map = verifyOtpResult.extendInfo;
        return new VerifyOtpRiskResponse(z, str2, str4, i, map != null ? map.get("riskToken") : null);
    }

    @Override // id.dana.domain.carrieridentification.CarrierIdentificationRepository
    public final Observable<VerifySecurityInfo> verifyIpificationAuthCode(VerifySecurityProduct verifySecurityProduct, String redirectUri) {
        Intrinsics.checkNotNullParameter(verifySecurityProduct, "");
        Intrinsics.checkNotNullParameter(redirectUri, "");
        CarrierIdentificationDataFactory carrierIdentificationDataFactory = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter("network", "");
        Observable<VerifySecurityInfo> doOnNext = carrierIdentificationDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(CarrierIdentificationDataMapperKt.MyBillsEntityDataFactory(verifySecurityProduct), redirectUri).map(new Function() { // from class: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CarrierIdentificationEntityRepository.BuiltInFictitiousFunctionClassFactory((VerifySecurityProductResult) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarrierIdentificationEntityRepository.BuiltInFictitiousFunctionClassFactory(CarrierIdentificationEntityRepository.this, (VerifySecurityInfo) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    @Override // id.dana.domain.carrieridentification.CarrierIdentificationRepository
    public final Observable<VerifyOtpRiskResponse> verifyOtpToRisk(String otpValue, String securityId, final String phoneNumber, final String verificationMethod, String sendOtpStrategy, Map<String, String> extParams) {
        Intrinsics.checkNotNullParameter(otpValue, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(verificationMethod, "");
        Intrinsics.checkNotNullParameter(sendOtpStrategy, "");
        Intrinsics.checkNotNullParameter(extParams, "");
        CarrierIdentificationDataFactory carrierIdentificationDataFactory = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter("network", "");
        Observable map = carrierIdentificationDataFactory.PlaceComponentResult.PlaceComponentResult(phoneNumber, securityId, this.MyBillsEntityDataFactory, otpValue, verificationMethod, sendOtpStrategy, extParams).doOnNext(new Consumer() { // from class: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarrierIdentificationEntityRepository.getAuthRequestContext(CarrierIdentificationEntityRepository.this, verificationMethod, phoneNumber, (VerifyOtpResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.carrieridentification.CarrierIdentificationEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CarrierIdentificationEntityRepository.getAuthRequestContext((VerifyOtpResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
