package id.dana.data.twilio.repository;

import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.twilio.TwilioSdkEntityRepository;
import id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesDataFactory;
import id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesEntityData;
import id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository;
import id.dana.domain.twilio.model.TwilioConsult;
import id.dana.domain.twilio.model.TwilioInfo;
import id.dana.domain.util.DateTimeUtils;
import id.dana.twilio.onboarding.TwilioIntroductionActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0013\u0010\f\u001a\u00020\nX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014"}, d2 = {"Lid/dana/data/twilio/repository/TwilioEnrollmentEligibilityEntityRepository;", "Lid/dana/domain/twilio/TwilioEnrollmentEligibilityRepository;", "Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioInfo;", "getTwilioIsEligibleForEnrollment", "()Lio/reactivex/Observable;", "Lid/dana/data/config/repository/FeatureConfigEntityRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/config/repository/FeatureConfigEntityRepository;", "PlaceComponentResult", "Lid/dana/data/twilio/repository/source/TwilioConsultBackendPreferencesEntityData;", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/data/twilio/repository/source/TwilioConsultBackendPreferencesDataFactory;", "Lid/dana/data/twilio/repository/source/TwilioConsultBackendPreferencesDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/twilio/repository/TwilioEntityRepository;", "MyBillsEntityDataFactory", "Lid/dana/data/twilio/repository/TwilioEntityRepository;", "Lid/dana/data/twilio/TwilioSdkEntityRepository;", "Lid/dana/data/twilio/TwilioSdkEntityRepository;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/data/config/repository/FeatureConfigEntityRepository;Lid/dana/data/twilio/TwilioSdkEntityRepository;Lid/dana/data/twilio/repository/TwilioEntityRepository;Lid/dana/data/twilio/repository/source/TwilioConsultBackendPreferencesDataFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioEnrollmentEligibilityEntityRepository implements TwilioEnrollmentEligibilityRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeatureConfigEntityRepository PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final TwilioSdkEntityRepository BuiltInFictitiousFunctionClassFactory;
    private final TwilioEntityRepository MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final TwilioConsultBackendPreferencesDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public TwilioEnrollmentEligibilityEntityRepository(FeatureConfigEntityRepository featureConfigEntityRepository, TwilioSdkEntityRepository twilioSdkEntityRepository, TwilioEntityRepository twilioEntityRepository, TwilioConsultBackendPreferencesDataFactory twilioConsultBackendPreferencesDataFactory) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(twilioEntityRepository, "");
        Intrinsics.checkNotNullParameter(twilioConsultBackendPreferencesDataFactory, "");
        this.PlaceComponentResult = featureConfigEntityRepository;
        this.BuiltInFictitiousFunctionClassFactory = twilioSdkEntityRepository;
        this.MyBillsEntityDataFactory = twilioEntityRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = twilioConsultBackendPreferencesDataFactory;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<TwilioConsultBackendPreferencesEntityData>() { // from class: id.dana.data.twilio.repository.TwilioEnrollmentEligibilityEntityRepository$localTwilioConsultBackEndEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TwilioConsultBackendPreferencesEntityData invoke() {
                TwilioConsultBackendPreferencesDataFactory twilioConsultBackendPreferencesDataFactory2;
                twilioConsultBackendPreferencesDataFactory2 = TwilioEnrollmentEligibilityEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return twilioConsultBackendPreferencesDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
    }

    @Override // id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository
    public final Observable<TwilioInfo> getTwilioIsEligibleForEnrollment() {
        Observable flatMap = this.PlaceComponentResult.isTwilioEnrollmentEnable().flatMap(new Function() { // from class: id.dana.data.twilio.repository.TwilioEnrollmentEligibilityEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioEnrollmentEligibilityEntityRepository.PlaceComponentResult(TwilioEnrollmentEligibilityEntityRepository.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final TwilioEnrollmentEligibilityEntityRepository twilioEnrollmentEligibilityEntityRepository, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(twilioEnrollmentEligibilityEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (!bool.booleanValue()) {
            just = Observable.just(new TwilioInfo(false, false, null, null, 12, null));
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            Single<Boolean> checkEnrollmentStatus = twilioEnrollmentEligibilityEntityRepository.BuiltInFictitiousFunctionClassFactory.checkEnrollmentStatus();
            Function function = new Function() { // from class: id.dana.data.twilio.repository.TwilioEnrollmentEligibilityEntityRepository$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return TwilioEnrollmentEligibilityEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(TwilioEnrollmentEligibilityEntityRepository.this, (Boolean) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function, "mapper is null");
            just = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMapObservable(checkEnrollmentStatus, function));
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(TwilioEnrollmentEligibilityEntityRepository twilioEnrollmentEligibilityEntityRepository, TwilioInfo twilioInfo) {
        Intrinsics.checkNotNullParameter(twilioEnrollmentEligibilityEntityRepository, "");
        Intrinsics.checkNotNullParameter(twilioInfo, "");
        TwilioInfo twilioInfo2 = new TwilioInfo(false, twilioInfo.getRegisterAllowed(), twilioInfo.getSecurityId(), twilioInfo.getVerificationMethodInfos());
        ((TwilioConsultBackendPreferencesEntityData) twilioEnrollmentEligibilityEntityRepository.getAuthRequestContext.getValue()).getAuthRequestContext(twilioInfo.getRegisterAllowed()).blockingFirst();
        ((TwilioConsultBackendPreferencesEntityData) twilioEnrollmentEligibilityEntityRepository.getAuthRequestContext.getValue()).MyBillsEntityDataFactory(System.currentTimeMillis()).blockingFirst();
        return Observable.just(twilioInfo2);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final TwilioEnrollmentEligibilityEntityRepository twilioEnrollmentEligibilityEntityRepository, Long l) {
        ObservableSource flatMap;
        Intrinsics.checkNotNullParameter(twilioEnrollmentEligibilityEntityRepository, "");
        Intrinsics.checkNotNullParameter(l, "");
        if (DateTimeUtils.getDifference24HoursTimePeriod(System.currentTimeMillis(), l.longValue()) < 10 && l.longValue() > 0) {
            flatMap = Observable.just(new TwilioInfo(false, ((TwilioConsultBackendPreferencesEntityData) twilioEnrollmentEligibilityEntityRepository.getAuthRequestContext.getValue()).MyBillsEntityDataFactory(), null, null, 12, null));
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
        } else {
            flatMap = twilioEnrollmentEligibilityEntityRepository.MyBillsEntityDataFactory.consultEnrollmentStatus(new TwilioConsult(TwilioIntroductionActivity.SETTING_PAGE)).flatMap(new Function() { // from class: id.dana.data.twilio.repository.TwilioEnrollmentEligibilityEntityRepository$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return TwilioEnrollmentEligibilityEntityRepository.MyBillsEntityDataFactory(TwilioEnrollmentEligibilityEntityRepository.this, (TwilioInfo) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
        }
        return flatMap;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final TwilioEnrollmentEligibilityEntityRepository twilioEnrollmentEligibilityEntityRepository, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(twilioEnrollmentEligibilityEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            just = Observable.just(new TwilioInfo(true, true, null, null, 12, null));
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            just = ((TwilioConsultBackendPreferencesEntityData) twilioEnrollmentEligibilityEntityRepository.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.twilio.repository.TwilioEnrollmentEligibilityEntityRepository$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return TwilioEnrollmentEligibilityEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(TwilioEnrollmentEligibilityEntityRepository.this, (Long) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }
}
