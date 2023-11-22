package id.dana.data.promocode.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.promocode.mapper.PromoCodeResultMapperKt;
import id.dana.data.promocode.repository.source.PromoCodeEntityData;
import id.dana.data.promocode.repository.source.PromoCodeEntityDataFactory;
import id.dana.data.promocode.repository.source.network.result.PromoCodeResult;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.promocode.model.PromoCode;
import id.dana.domain.promocode.repository.PromoCodeRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/data/promocode/repository/PromoCodeEntityRepository;", "Lid/dana/domain/promocode/repository/PromoCodeRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "promoCode", "Lio/reactivex/Observable;", "Lid/dana/domain/promocode/model/PromoCode;", "applyPromoCode", "(Ljava/lang/String;)Lio/reactivex/Observable;", "T", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "Lid/dana/data/promocode/repository/source/PromoCodeEntityData;", "createPromoCodeEntityData", "()Lid/dana/data/promocode/repository/source/PromoCodeEntityData;", "Lid/dana/data/geocode/repository/GeocodeEntityRepository;", "geocodeEntityRepository", "Lid/dana/data/geocode/repository/GeocodeEntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/promocode/repository/source/PromoCodeEntityDataFactory;", "promoCodeEntityDataFactory", "Lid/dana/data/promocode/repository/source/PromoCodeEntityDataFactory;", "<init>", "(Lid/dana/data/geocode/repository/GeocodeEntityRepository;Lid/dana/data/promocode/repository/source/PromoCodeEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoCodeEntityRepository implements PromoCodeRepository, HoldLoginV1Repository {
    private final GeocodeEntityRepository geocodeEntityRepository;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final PromoCodeEntityDataFactory promoCodeEntityDataFactory;

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "");
        return this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
    }

    public final AccountEntityData createAccountData() {
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        return createNetworkLogin;
    }

    @Inject
    public PromoCodeEntityRepository(GeocodeEntityRepository geocodeEntityRepository, PromoCodeEntityDataFactory promoCodeEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(geocodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(promoCodeEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.geocodeEntityRepository = geocodeEntityRepository;
        this.promoCodeEntityDataFactory = promoCodeEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    private final PromoCodeEntityData createPromoCodeEntityData() {
        return this.promoCodeEntityDataFactory.createData2("local");
    }

    @Override // id.dana.domain.promocode.repository.PromoCodeRepository
    public final Observable<PromoCode> applyPromoCode(final String promoCode) {
        Intrinsics.checkNotNullParameter(promoCode, "");
        Observable switchMap = this.geocodeEntityRepository.getLatestSubdivisions().switchMap(new Function() { // from class: id.dana.data.promocode.repository.PromoCodeEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1632applyPromoCode$lambda1;
                m1632applyPromoCode$lambda1 = PromoCodeEntityRepository.m1632applyPromoCode$lambda1(PromoCodeEntityRepository.this, promoCode, (LocationSubdisivision) obj);
                return m1632applyPromoCode$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        return switchMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: applyPromoCode$lambda-1  reason: not valid java name */
    public static final ObservableSource m1632applyPromoCode$lambda1(PromoCodeEntityRepository promoCodeEntityRepository, String str, LocationSubdisivision locationSubdisivision) {
        Intrinsics.checkNotNullParameter(promoCodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locationSubdisivision, "");
        return promoCodeEntityRepository.createPromoCodeEntityData().applyPromoCode(str, locationSubdisivision.getIndoSubdivisions().getCityName()).map(new Function() { // from class: id.dana.data.promocode.repository.PromoCodeEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoCode m1633applyPromoCode$lambda1$lambda0;
                m1633applyPromoCode$lambda1$lambda0 = PromoCodeEntityRepository.m1633applyPromoCode$lambda1$lambda0((PromoCodeResult) obj);
                return m1633applyPromoCode$lambda1$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: applyPromoCode$lambda-1$lambda-0  reason: not valid java name */
    public static final PromoCode m1633applyPromoCode$lambda1$lambda0(PromoCodeResult promoCodeResult) {
        Intrinsics.checkNotNullParameter(promoCodeResult, "");
        return PromoCodeResultMapperKt.toPromoCode(promoCodeResult);
    }
}
