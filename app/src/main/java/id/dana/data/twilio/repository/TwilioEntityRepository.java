package id.dana.data.twilio.repository;

import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.twilio.mapper.TwilioMapperKt;
import id.dana.data.twilio.mapper.VerifyPushResultMapperKt;
import id.dana.data.twilio.repository.source.TwilioEnrollmentEntityDataFactory;
import id.dana.data.twilio.repository.source.network.result.VerifyPushBindEnrollmentResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushConsultResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushDerollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushEnrollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushRequestChallengeResult;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.model.BindEnrollInfo;
import id.dana.domain.twilio.model.DerollInfo;
import id.dana.domain.twilio.model.EnrollInfo;
import id.dana.domain.twilio.model.RequestChallengeInfo;
import id.dana.domain.twilio.model.TwilioBindEnroll;
import id.dana.domain.twilio.model.TwilioChallenge;
import id.dana.domain.twilio.model.TwilioConsult;
import id.dana.domain.twilio.model.TwilioDeroll;
import id.dana.domain.twilio.model.TwilioEnroll;
import id.dana.domain.twilio.model.TwilioInfo;
import id.dana.domain.twilio.model.TwilioVerify;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020'\u0012\u0006\u0010+\u001a\u00020 \u0012\u0006\u0010,\u001a\u00020$¢\u0006\u0004\b-\u0010.J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0003\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u0003\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0003\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010!\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/data/twilio/repository/TwilioEntityRepository;", "Lid/dana/domain/twilio/TwilioRepository;", "Lid/dana/domain/twilio/model/TwilioConsult;", "p0", "Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioInfo;", "consultEnrollmentStatus", "(Lid/dana/domain/twilio/model/TwilioConsult;)Lio/reactivex/Observable;", "", "", "getNonLogoutScenes", "()Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioChallenge;", "Lid/dana/domain/twilio/model/RequestChallengeInfo;", "requestChallenge", "(Lid/dana/domain/twilio/model/TwilioChallenge;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioBindEnroll;", "Lid/dana/domain/twilio/model/BindEnrollInfo;", "submitBindEnrollment", "(Lid/dana/domain/twilio/model/TwilioBindEnroll;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioDeroll;", "Lid/dana/domain/twilio/model/DerollInfo;", "submitDerollment", "(Lid/dana/domain/twilio/model/TwilioDeroll;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioEnroll;", "Lid/dana/domain/twilio/model/EnrollInfo;", "submitEnrollment", "(Lid/dana/domain/twilio/model/TwilioEnroll;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioVerify;", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "verifySecurityProduct", "(Lid/dana/domain/twilio/model/TwilioVerify;)Lio/reactivex/Observable;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "getAuthRequestContext", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "Lid/dana/data/twilio/repository/source/TwilioEnrollmentEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/twilio/repository/source/TwilioEnrollmentEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(Lid/dana/data/twilio/repository/source/TwilioEnrollmentEntityDataFactory;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/security/source/SecurityEntityDataFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioEntityRepository implements TwilioRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final TwilioEnrollmentEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ConfigEntityDataFactory PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SecurityEntityDataFactory MyBillsEntityDataFactory;

    @Inject
    public TwilioEntityRepository(TwilioEnrollmentEntityDataFactory twilioEnrollmentEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory) {
        Intrinsics.checkNotNullParameter(twilioEnrollmentEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(securityEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = twilioEnrollmentEntityDataFactory;
        this.PlaceComponentResult = configEntityDataFactory;
        this.MyBillsEntityDataFactory = securityEntityDataFactory;
    }

    public static /* synthetic */ RequestChallengeInfo KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushRequestChallengeResult verifyPushRequestChallengeResult) {
        Intrinsics.checkNotNullParameter(verifyPushRequestChallengeResult, "");
        return VerifyPushResultMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(verifyPushRequestChallengeResult);
    }

    public static /* synthetic */ TwilioInfo PlaceComponentResult(VerifyPushConsultResult verifyPushConsultResult) {
        Intrinsics.checkNotNullParameter(verifyPushConsultResult, "");
        return VerifyPushResultMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(verifyPushConsultResult);
    }

    public static /* synthetic */ DerollInfo PlaceComponentResult(VerifyPushDerollResult verifyPushDerollResult) {
        Intrinsics.checkNotNullParameter(verifyPushDerollResult, "");
        return VerifyPushResultMapperKt.getAuthRequestContext(verifyPushDerollResult);
    }

    public static /* synthetic */ VerifySecurityInfo BuiltInFictitiousFunctionClassFactory(VerifySecurityProductResult verifySecurityProductResult) {
        Intrinsics.checkNotNullParameter(verifySecurityProductResult, "");
        return VerifyPushResultMapperKt.PlaceComponentResult(verifySecurityProductResult);
    }

    public static /* synthetic */ EnrollInfo BuiltInFictitiousFunctionClassFactory(VerifyPushEnrollResult verifyPushEnrollResult) {
        Intrinsics.checkNotNullParameter(verifyPushEnrollResult, "");
        return VerifyPushResultMapperKt.BuiltInFictitiousFunctionClassFactory(verifyPushEnrollResult);
    }

    public static /* synthetic */ BindEnrollInfo getAuthRequestContext(VerifyPushBindEnrollmentResult verifyPushBindEnrollmentResult) {
        Intrinsics.checkNotNullParameter(verifyPushBindEnrollmentResult, "");
        return VerifyPushResultMapperKt.PlaceComponentResult(verifyPushBindEnrollmentResult);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(TwilioEntityRepository twilioEntityRepository, TwilioVerify twilioVerify, String str) {
        Intrinsics.checkNotNullParameter(twilioEntityRepository, "");
        Intrinsics.checkNotNullParameter(twilioVerify, "");
        Intrinsics.checkNotNullParameter(str, "");
        return twilioEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.MyBillsEntityDataFactory(TwilioMapperKt.getAuthRequestContext(twilioVerify), str).map(new Function() { // from class: id.dana.data.twilio.repository.TwilioEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEntityRepository.BuiltInFictitiousFunctionClassFactory((VerifySecurityProductResult) obj);
            }
        });
    }

    @Override // id.dana.domain.twilio.TwilioRepository
    public final Observable<TwilioInfo> consultEnrollmentStatus(TwilioConsult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.PlaceComponentResult(TwilioMapperKt.PlaceComponentResult(p0)).map(new Function() { // from class: id.dana.data.twilio.repository.TwilioEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEntityRepository.PlaceComponentResult((VerifyPushConsultResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.twilio.TwilioRepository
    public final Observable<List<String>> getNonLogoutScenes() {
        ConfigEntityData createData2 = this.PlaceComponentResult.createData2("split");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<List<String>> twilioNonLogoutScenes = createData2.getTwilioNonLogoutScenes();
        Intrinsics.checkNotNullExpressionValue(twilioNonLogoutScenes, "");
        return twilioNonLogoutScenes;
    }

    @Override // id.dana.domain.twilio.TwilioRepository
    public final Observable<RequestChallengeInfo> requestChallenge(TwilioChallenge p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getAuthRequestContext(TwilioMapperKt.getAuthRequestContext(p0)).map(new Function() { // from class: id.dana.data.twilio.repository.TwilioEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((VerifyPushRequestChallengeResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.twilio.TwilioRepository
    public final Observable<BindEnrollInfo> submitBindEnrollment(TwilioBindEnroll p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(TwilioMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(p0)).delay(200L, TimeUnit.MILLISECONDS).map(new Function() { // from class: id.dana.data.twilio.repository.TwilioEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEntityRepository.getAuthRequestContext((VerifyPushBindEnrollmentResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.twilio.TwilioRepository
    public final Observable<DerollInfo> submitDerollment(TwilioDeroll p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.PlaceComponentResult(TwilioMapperKt.BuiltInFictitiousFunctionClassFactory(p0)).map(new Function() { // from class: id.dana.data.twilio.repository.TwilioEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEntityRepository.PlaceComponentResult((VerifyPushDerollResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.twilio.TwilioRepository
    public final Observable<EnrollInfo> submitEnrollment(TwilioEnroll p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(TwilioMapperKt.getAuthRequestContext(p0)).map(new Function() { // from class: id.dana.data.twilio.repository.TwilioEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEntityRepository.BuiltInFictitiousFunctionClassFactory((VerifyPushEnrollResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.twilio.TwilioRepository
    public final Observable<VerifySecurityInfo> verifySecurityProduct(final TwilioVerify p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SecurityEntityData createData2 = this.MyBillsEntityDataFactory.createData2("network");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<String> loginKey = createData2.loginKey();
        Intrinsics.checkNotNullExpressionValue(loginKey, "");
        Observable flatMap = loginKey.flatMap(new Function() { // from class: id.dana.data.twilio.repository.TwilioEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEntityRepository.BuiltInFictitiousFunctionClassFactory(TwilioEntityRepository.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }
}
