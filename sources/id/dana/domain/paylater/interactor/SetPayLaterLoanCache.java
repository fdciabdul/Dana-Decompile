package id.dana.domain.paylater.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.interactor.SetPayLaterLoanCache;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.PayLaterLoanWhitelist;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.domain.paylater.util.PayLaterUtil;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JE\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/domain/paylater/interactor/SetPayLaterLoanCache;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "Lid/dana/domain/paylater/interactor/SetPayLaterLoanCache$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/paylater/interactor/SetPayLaterLoanCache$Params;)Lio/reactivex/Observable;", "payLaterLoanWhitelist", "", "loanStateService", "Lid/dana/domain/paylater/model/LoanInfo;", "loanInfo", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "loanStatus", "serviceName", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "service", "doHighlightSwitching", "(Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;Ljava/lang/String;Lid/dana/domain/paylater/model/LoanInfo;Lid/dana/domain/paylater/model/LoanStatusWhitelist;Ljava/lang/String;Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)Lio/reactivex/Observable;", "Lid/dana/domain/paylater/PaylaterRepository;", "payLaterRepository", "Lid/dana/domain/paylater/PaylaterRepository;", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "<init>", "(Lid/dana/domain/paylater/PaylaterRepository;Lid/dana/domain/services/ServicesRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetPayLaterLoanCache extends BaseUseCase<PayLaterLoanWhitelist, Params> {
    private final PaylaterRepository payLaterRepository;
    private final ServicesRepository servicesRepository;

    @Inject
    public SetPayLaterLoanCache(PaylaterRepository paylaterRepository, ServicesRepository servicesRepository) {
        Intrinsics.checkNotNullParameter(paylaterRepository, "");
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        this.payLaterRepository = paylaterRepository;
        this.servicesRepository = servicesRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PayLaterLoanWhitelist> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<PayLaterLoanWhitelist> doOnNext = Observable.fromCallable(new Callable() { // from class: id.dana.domain.paylater.interactor.SetPayLaterLoanCache$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                PayLaterLoanWhitelist m2392buildUseCase$lambda2;
                m2392buildUseCase$lambda2 = SetPayLaterLoanCache.m2392buildUseCase$lambda2(SetPayLaterLoanCache.Params.this, this);
                return m2392buildUseCase$lambda2;
            }
        }).doOnNext(new Consumer() { // from class: id.dana.domain.paylater.interactor.SetPayLaterLoanCache$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SetPayLaterLoanCache.m2393buildUseCase$lambda5(SetPayLaterLoanCache.this, params, (PayLaterLoanWhitelist) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final PayLaterLoanWhitelist m2392buildUseCase$lambda2(Params params, SetPayLaterLoanCache setPayLaterLoanCache) {
        long timeInMillis;
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(setPayLaterLoanCache, "");
        ArrayList arrayList = new ArrayList();
        PaylaterCicilMethodConfig paylaterCicilConfig = params.getPayLaterLoanWhitelist().getPaylaterCicilConfig();
        int i = 0;
        for (Object obj : params.getPayLaterLoanWhitelist().getLoanWhitelist().getLoanInfo()) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LoanInfo loanInfo = (LoanInfo) obj;
            timeInMillis = Calendar.getInstance().getTimeInMillis();
            String loanServiceState = PayLaterUtil.INSTANCE.getLoanServiceState(loanInfo, timeInMillis, paylaterCicilConfig.getThresholdDueInDay());
            StringBuilder sb = new StringBuilder();
            sb.append("service_paylater_");
            String lowerCase = loanInfo.getType().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            sb.append(lowerCase);
            String obj2 = sb.toString();
            ThirdPartyServiceResponse blockingFirst = setPayLaterLoanCache.servicesRepository.getServiceByKey(obj2).blockingFirst();
            PayLaterUtil payLaterUtil = PayLaterUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            LoanStatusWhitelist loanStatusWhitelist = payLaterUtil.getLoanStatusWhitelist(loanServiceState, loanInfo, timeInMillis, blockingFirst);
            arrayList.add(i, loanStatusWhitelist);
            setPayLaterLoanCache.doHighlightSwitching(params.getPayLaterLoanWhitelist(), loanServiceState, loanInfo, loanStatusWhitelist, obj2, blockingFirst);
            i++;
        }
        PayLaterLoanWhitelist payLaterLoanWhitelist = params.getPayLaterLoanWhitelist();
        if ((!arrayList.isEmpty()) != false) {
            payLaterLoanWhitelist.setStatusWhitelist(arrayList);
        }
        return payLaterLoanWhitelist;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-5  reason: not valid java name */
    public static final void m2393buildUseCase$lambda5(SetPayLaterLoanCache setPayLaterLoanCache, Params params, PayLaterLoanWhitelist payLaterLoanWhitelist) {
        Intrinsics.checkNotNullParameter(setPayLaterLoanCache, "");
        Intrinsics.checkNotNullParameter(params, "");
        Unit unit = (Unit) Observable.zip(setPayLaterLoanCache.payLaterRepository.savePayLaterLoanStatus(payLaterLoanWhitelist.getStatusWhitelist()), setPayLaterLoanCache.payLaterRepository.savePayLaterCacheWhitelistValue(params.getPayLaterLoanWhitelist().getLoanWhitelist()), setPayLaterLoanCache.servicesRepository.getFavoriteServiceFromRemoteSource(), new Function3() { // from class: id.dana.domain.paylater.interactor.SetPayLaterLoanCache$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                Unit m2394buildUseCase$lambda5$lambda3;
                m2394buildUseCase$lambda5$lambda3 = SetPayLaterLoanCache.m2394buildUseCase$lambda5$lambda3((Boolean) obj, (Boolean) obj2, (ThirdPartyCategoryService) obj3);
                return m2394buildUseCase$lambda5$lambda3;
            }
        }).blockingFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-5$lambda-3  reason: not valid java name */
    public static final Unit m2394buildUseCase$lambda5$lambda3(Boolean bool, Boolean bool2, ThirdPartyCategoryService thirdPartyCategoryService) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
        return Unit.INSTANCE;
    }

    private final Observable<PayLaterLoanWhitelist> doHighlightSwitching(final PayLaterLoanWhitelist payLaterLoanWhitelist, String loanStateService, LoanInfo loanInfo, final LoanStatusWhitelist loanStatus, final String serviceName, final ThirdPartyServiceResponse service) {
        Observable<PayLaterLoanWhitelist> zip = Observable.zip(this.payLaterRepository.setLoanServicesState(loanInfo.getType(), loanStateService), this.payLaterRepository.getPaylaterRotationDelayTime(), this.servicesRepository.isFeatureHighlightExist(serviceName), new Function3() { // from class: id.dana.domain.paylater.interactor.SetPayLaterLoanCache$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                PayLaterLoanWhitelist m2395doHighlightSwitching$lambda6;
                m2395doHighlightSwitching$lambda6 = SetPayLaterLoanCache.m2395doHighlightSwitching$lambda6(LoanStatusWhitelist.this, this, service, serviceName, payLaterLoanWhitelist, (Boolean) obj, (Long) obj2, (Boolean) obj3);
                return m2395doHighlightSwitching$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doHighlightSwitching$lambda-6  reason: not valid java name */
    public static final PayLaterLoanWhitelist m2395doHighlightSwitching$lambda6(LoanStatusWhitelist loanStatusWhitelist, SetPayLaterLoanCache setPayLaterLoanCache, ThirdPartyServiceResponse thirdPartyServiceResponse, String str, PayLaterLoanWhitelist payLaterLoanWhitelist, Boolean bool, Long l, Boolean bool2) {
        Integer rotationDelayTime;
        Intrinsics.checkNotNullParameter(loanStatusWhitelist, "");
        Intrinsics.checkNotNullParameter(setPayLaterLoanCache, "");
        Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(payLaterLoanWhitelist, "");
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(l, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        if (loanStatusWhitelist.isUnregisteredUser() && l.longValue() == 0) {
            setPayLaterLoanCache.getDisposable().getAuthRequestContext(setPayLaterLoanCache.payLaterRepository.savePaylaterRotationDelayTime(Calendar.getInstance().getTimeInMillis()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe());
        }
        PayLaterUtil payLaterUtil = PayLaterUtil.INSTANCE;
        long longValue = l.longValue();
        Integer rotationDelayTime2 = thirdPartyServiceResponse.getRotationDelayTime();
        boolean z = false;
        boolean z2 = !PayLaterUtil.isCacheExpire$default(payLaterUtil, null, null, longValue, rotationDelayTime2 != null ? rotationDelayTime2.intValue() : 0, 3, null) || ((rotationDelayTime = thirdPartyServiceResponse.getRotationDelayTime()) != null && rotationDelayTime.intValue() == 0);
        if (loanStatusWhitelist.isDueOrOverdue() || (loanStatusWhitelist.isUnregisteredUser() && z2)) {
            z = true;
        }
        if (bool2.booleanValue() && z) {
            setPayLaterLoanCache.getDisposable().getAuthRequestContext(setPayLaterLoanCache.servicesRepository.overwriteHighlightedService(str).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe());
        }
        return payLaterLoanWhitelist;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/paylater/interactor/SetPayLaterLoanCache$Params;", "", "Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "payLaterLoanWhitelist", "Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "getPayLaterLoanWhitelist", "()Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "<init>", "(Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final PayLaterLoanWhitelist payLaterLoanWhitelist;

        public Params(PayLaterLoanWhitelist payLaterLoanWhitelist) {
            Intrinsics.checkNotNullParameter(payLaterLoanWhitelist, "");
            this.payLaterLoanWhitelist = payLaterLoanWhitelist;
        }

        @JvmName(name = "getPayLaterLoanWhitelist")
        public final PayLaterLoanWhitelist getPayLaterLoanWhitelist() {
            return this.payLaterLoanWhitelist;
        }
    }
}
