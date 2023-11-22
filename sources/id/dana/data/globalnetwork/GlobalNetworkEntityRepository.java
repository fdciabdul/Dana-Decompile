package id.dana.data.globalnetwork;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.Source;
import id.dana.data.geocode.repository.source.GeocodeEntityData;
import id.dana.data.geocode.repository.source.GeocodeEntityDataFactory;
import id.dana.data.globalnetwork.mapper.ForexResultMapper;
import id.dana.data.globalnetwork.mapper.GnAuthMapper;
import id.dana.data.globalnetwork.mapper.GnConsultMapper;
import id.dana.data.globalnetwork.model.ForexResult;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.globalnetwork.model.GnHereLocationConfig;
import id.dana.data.globalnetwork.model.PayRequest;
import id.dana.data.globalnetwork.model.UniPaymentEntityResult;
import id.dana.data.globalnetwork.source.GlobalNetworkDataFactory;
import id.dana.data.globalnetwork.source.GnConfigDataFactory;
import id.dana.data.globalnetwork.source.GnConfigEntityData;
import id.dana.data.globalnetwork.source.GnPaymentDataFactory;
import id.dana.data.globalnetwork.source.GnPaymentEntityData;
import id.dana.data.globalnetwork.source.UniPaymentDataFactory;
import id.dana.data.globalnetwork.source.UniPaymentEntityData;
import id.dana.data.globalnetwork.source.local.PreferenceGnPaymentEntityData;
import id.dana.data.globalnetwork.source.local.UserLocation;
import id.dana.data.globalnetwork.source.mapper.GnPaymentMapper;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.risk.riskevent.SendRiskEventEntityData;
import id.dana.data.risk.riskevent.SendRiskEventEntityDataFactory;
import id.dana.domain.geocode.LocationOutOfBoundsException;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.model.Auth;
import id.dana.domain.globalnetwork.model.Forex;
import id.dana.domain.globalnetwork.model.GnConsultInfo;
import id.dana.domain.globalnetwork.model.Pay;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.model.f2fpay.response.F2FPayResultResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class GlobalNetworkEntityRepository implements GlobalNetworkRepository {
    private static final int PAYMENT_RESULT_DELAY_IN_SECONDS = 3;
    private final Context context;
    private final ForexResultMapper forexResultMapper;
    private final GeocodeEntityDataFactory geocodeEntityDataFactory;
    private final GlobalNetworkDataFactory globalNetworkDataFactory;
    private final GnConfigDataFactory gnConfigDataFactory;
    private final GnConsultMapper gnConsultMapper;
    private final GnPaymentDataFactory gnPaymentDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final PreferenceGnPaymentEntityData preferenceGnPaymentEntityData;
    private final SendRiskEventEntityDataFactory sendRiskEventEntityDataFactory;
    private final UniPaymentDataFactory uniPaymentDataFactory;
    private final UserLocation userLocation;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer lambda$sendRiskEvent$5(Throwable th, Integer num) throws Exception {
        return num;
    }

    @Inject
    public GlobalNetworkEntityRepository(GlobalNetworkDataFactory globalNetworkDataFactory, ForexResultMapper forexResultMapper, GnConsultMapper gnConsultMapper, GnPaymentDataFactory gnPaymentDataFactory, UniPaymentDataFactory uniPaymentDataFactory, PreferenceGnPaymentEntityData preferenceGnPaymentEntityData, UserLocation userLocation, SendRiskEventEntityDataFactory sendRiskEventEntityDataFactory, GnConfigDataFactory gnConfigDataFactory, GeocodeEntityDataFactory geocodeEntityDataFactory, Context context, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.globalNetworkDataFactory = globalNetworkDataFactory;
        this.forexResultMapper = forexResultMapper;
        this.gnConsultMapper = gnConsultMapper;
        this.gnPaymentDataFactory = gnPaymentDataFactory;
        this.uniPaymentDataFactory = uniPaymentDataFactory;
        this.preferenceGnPaymentEntityData = preferenceGnPaymentEntityData;
        this.userLocation = userLocation;
        this.sendRiskEventEntityDataFactory = sendRiskEventEntityDataFactory;
        this.gnConfigDataFactory = gnConfigDataFactory;
        this.geocodeEntityDataFactory = geocodeEntityDataFactory;
        this.context = context;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<String> getCountryCodeByLocation() {
        LatLng userLocation = this.userLocation.getUserLocation(this.context);
        if (this.userLocation.validateLocation(userLocation)) {
            return createGeocodeLocationDataLocal().getCountryCodeByLocation(userLocation).onErrorResumeNext(getCountryCodeByLocationWithNetwork(userLocation)).doOnNext(new Consumer() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    GlobalNetworkEntityRepository.this.saveCurrentCountryCode((String) obj);
                }
            });
        }
        return Observable.error(new LocationOutOfBoundsException());
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<String> getSelectedCountryCode() {
        return createSessionData().getSelectedCountryCode();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Forex> getForexRate(final String str, final String str2) {
        Observable<ForexResult> forexRate = createPaymentData().getForexRate(str, str2);
        final ForexResultMapper forexResultMapper = this.forexResultMapper;
        Objects.requireNonNull(forexResultMapper);
        return forexRate.map(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ForexResultMapper.this.map((ForexResult) obj);
            }
        }).doOnError(new Consumer() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalNetworkEntityRepository.this.m1330xd19eabd3(str2, str, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getForexRate$0$id-dana-data-globalnetwork-GlobalNetworkEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1330xd19eabd3(String str, String str2, Throwable th) throws Exception {
        getForexCache(str, str2);
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<List<Forex>> getRealtimeForexList(List<String> list, List<String> list2) {
        Observable<List<ForexResult>> listRealTimeForexRate = createPaymentData().getListRealTimeForexRate(list, list2);
        final ForexResultMapper forexResultMapper = this.forexResultMapper;
        Objects.requireNonNull(forexResultMapper);
        return listRealTimeForexRate.map(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ForexResultMapper.this.transform((List) obj);
            }
        });
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Forex> getForexCache(String str, String str2) {
        return createLocalPaymentData().getForexCache(str, str2);
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> saveForex(Forex forex) {
        return createLocalPaymentData().saveForex(forex);
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Auth> getGlobalNetworkAuth() {
        return createPaymentData().getGlobalNetworkAuth().map(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GnAuthMapper.transform((GnAuthResult) obj);
            }
        });
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> clearGlobalNetwork() {
        return createPaymentData().clearGlobalNetwork();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> savePaymentCode(String str) {
        return createCachePaymentData().saveGnPaymentCode(str);
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> clearAllPaymentCodes() {
        return this.preferenceGnPaymentEntityData.clearAllPaymentCodes().repeatWhen(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource delay;
                delay = ((Observable) obj).delay(3L, TimeUnit.SECONDS);
                return delay;
            }
        });
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<F2FPayResultResponse> getUniPaymentResult(final String str) {
        return this.preferenceGnPaymentEntityData.getAllPaymentCodes().flatMap(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalNetworkEntityRepository.this.m1332x32fde26(str, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getUniPaymentResult$4$id-dana-data-globalnetwork-GlobalNetworkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1332x32fde26(final String str, final List list) throws Exception {
        if (!list.isEmpty()) {
            Observable map = this.holdLoginV1EntityRepository.createAccountData().getUserId().flatMap(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda15
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GlobalNetworkEntityRepository.this.m1331xe955afe8(list, str, (String) obj);
                }
            }).map(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda16
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    String bizModelsJsonStr;
                    bizModelsJsonStr = ((UniPaymentEntityResult) obj).getBizModelsJsonStr();
                    return bizModelsJsonStr;
                }
            }).map(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda17
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GnPaymentMapper.map((String) obj);
                }
            });
            final PreferenceGnPaymentEntityData preferenceGnPaymentEntityData = this.preferenceGnPaymentEntityData;
            Objects.requireNonNull(preferenceGnPaymentEntityData);
            return map.doOnNext(new Consumer() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda18
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PreferenceGnPaymentEntityData.this.invalidatePaymentCode((F2FPayResultResponse) obj);
                }
            });
        }
        return Observable.just(new F2FPayResultResponse());
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> getAlipayConnectServiceFirstTime() {
        return createSessionData().getAlipayConnectServiceFirstTime();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> saveAlipayConnectServiceFirstTime(Boolean bool) {
        return createSessionData().saveAlipayConnectServiceFirstTime(bool.booleanValue());
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> sendRiskEvent(String str, String str2) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createNetworkRiskEventData().sendRiskEvent(str2, str).retryWhen(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource flatMap;
                flatMap = ((Observable) obj).zipWith(Observable.range(1, 3), new BiFunction() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda13
                    @Override // io.reactivex.functions.BiFunction
                    public final Object apply(Object obj2, Object obj3) {
                        return GlobalNetworkEntityRepository.lambda$sendRiskEvent$5((Throwable) obj2, (Integer) obj3);
                    }
                }).flatMap(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda14
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj2) {
                        ObservableSource timer;
                        Integer num = (Integer) obj2;
                        timer = Observable.timer((long) Math.pow(5.0d, num.intValue()), TimeUnit.SECONDS);
                        return timer;
                    }
                });
                return flatMap;
            }
        }).map(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((BaseRpcResult) obj).success);
                return valueOf;
            }
        }));
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<String> decodeGnQr(String str, String str2, boolean z) {
        return createPaymentData().decodeGnQr(str, str2, z);
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Pay> getPayRequest() {
        return createPaymentData().getPayRequest().map(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GnPaymentMapper.transform((PayRequest) obj);
            }
        });
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> openMerchantCashier() {
        return createPaymentData().openMerchantCashier();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> isCScanBEnabled() {
        return createLocationData().isCScanBEnabled();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<List<String>> getGnCScanBBlacklistedCountry() {
        return createConfigData().getGnCScanBBlacklistedCountry();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<List<String>> getMerchantBlockRegistration() {
        return createConfigData().getMerchantBlockRegistration();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public Observable<Boolean> isGoogleBlockRegistration() {
        return createConfigData().isGoogleBlockRegistration();
    }

    @Override // id.dana.domain.globalnetwork.GlobalNetworkRepository
    public GnConsultInfo doGnConsult(Map<String, String> map, String str) {
        return this.gnConsultMapper.transform(createLocationData().doGnConsult(map, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Boolean> saveCurrentCountryCode(final String str) {
        return createSessionData().saveCurrentCountryCode(str).doOnNext(new Consumer() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalNetworkEntityRepository.this.m1333xe8a92349(str, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveCurrentCountryCode$9$id-dana-data-globalnetwork-GlobalNetworkEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1333xe8a92349(String str, Boolean bool) throws Exception {
        this.userLocation.setCurrentCountryCode(str);
    }

    private Observable<String> getCurrentCountryCode() {
        return createSessionData().getCurrentCountryCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUniPaymentResult  reason: merged with bridge method [inline-methods] */
    public Observable<UniPaymentEntityResult> m1331xe955afe8(List<String> list, String str, String str2) {
        return createNetworkUniPayment().getUniPaymentResult(list, str, str2);
    }

    private Observable<String> getCountryCodeByLocationWithNetwork(final LatLng latLng) {
        return createConfigData().isHereLocationEnabled().flatMap(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalNetworkEntityRepository.this.m1329x3b65e711(latLng, (GnHereLocationConfig) obj);
            }
        }).onErrorResumeNext(createGeocodeLocationDataWithGoogle().getCountryCodeByLocation(latLng));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCountryCodeByLocationWithNetwork$10$id-dana-data-globalnetwork-GlobalNetworkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1329x3b65e711(LatLng latLng, GnHereLocationConfig gnHereLocationConfig) throws Exception {
        if (gnHereLocationConfig.getEnable()) {
            return checkLastTimeCallHere(latLng, gnHereLocationConfig.getTimeRefreshLocation());
        }
        return createGeocodeLocationDataWithGoogle().getCountryCodeByLocation(latLng);
    }

    private Observable<String> checkLastTimeCallHere(final LatLng latLng, final long j) {
        return getCurrentCountryCode().flatMap(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalNetworkEntityRepository.this.m1327x4d7b7979(latLng, j, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkLastTimeCallHere$12$id-dana-data-globalnetwork-GlobalNetworkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1327x4d7b7979(final LatLng latLng, final long j, final String str) throws Exception {
        if (str.isEmpty()) {
            return getCountryCodeByLocationWithHere(latLng);
        }
        return createSessionData().getLastTimeGetLocation().flatMap(new Function() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalNetworkEntityRepository.this.m1326xc08e625a(j, latLng, str, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkLastTimeCallHere$11$id-dana-data-globalnetwork-GlobalNetworkEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1326xc08e625a(long j, LatLng latLng, String str, Long l) throws Exception {
        if (new Date().getTime() - new Date(l.longValue()).getTime() > TimeUnit.MILLISECONDS.convert(j, TimeUnit.MINUTES)) {
            return getCountryCodeByLocationWithHere(latLng);
        }
        return Observable.just(str);
    }

    private Observable<String> getCountryCodeByLocationWithHere(LatLng latLng) {
        return createGeocodeLocationDataWithHere().getCountryCodeByLocation(latLng).doOnNext(new Consumer() { // from class: id.dana.data.globalnetwork.GlobalNetworkEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalNetworkEntityRepository.this.m1328x71059228((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCountryCodeByLocationWithHere$13$id-dana-data-globalnetwork-GlobalNetworkEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1328x71059228(String str) throws Exception {
        createSessionData().saveLastTimeGetLocation(System.currentTimeMillis());
    }

    private GlobalNetworkEntityData createSessionData() {
        return this.globalNetworkDataFactory.createData2("local");
    }

    private GlobalNetworkEntityData createLocationData() {
        return this.globalNetworkDataFactory.createData2("network");
    }

    private GeocodeEntityData createGeocodeLocationDataLocal() {
        return this.geocodeEntityDataFactory.createData2("local");
    }

    private GeocodeEntityData createGeocodeLocationDataWithHere() {
        return this.geocodeEntityDataFactory.createData2(Source.HERE);
    }

    private GeocodeEntityData createGeocodeLocationDataWithGoogle() {
        return this.geocodeEntityDataFactory.createData2(Source.GOOGLE);
    }

    private GnConfigEntityData createConfigData() {
        return this.gnConfigDataFactory.createData2("split");
    }

    private GnPaymentEntityData createPaymentData() {
        return this.gnPaymentDataFactory.createData2("network");
    }

    private GnPaymentEntityData createCachePaymentData() {
        return this.gnPaymentDataFactory.createData2("local");
    }

    private GnPaymentEntityData createLocalPaymentData() {
        return this.gnPaymentDataFactory.createData2("local");
    }

    private UniPaymentEntityData createNetworkUniPayment() {
        return this.uniPaymentDataFactory.createData2("local");
    }

    private SendRiskEventEntityData createNetworkRiskEventData() {
        return this.sendRiskEventEntityDataFactory.createData2("network");
    }
}
