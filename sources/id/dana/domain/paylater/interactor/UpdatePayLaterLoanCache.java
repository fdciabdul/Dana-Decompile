package id.dana.domain.paylater.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.domain.paylater.model.PayLaterLoanWhitelist;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.domain.paylater.util.PayLaterUtil;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0019\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache$Params;)Lio/reactivex/Observable;", "", "loanStateService", "Lid/dana/domain/paylater/model/LoanInfo;", "loanInfo", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "loanStatus", "serviceName", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "service", "doHighlightSwitching", "(Ljava/lang/String;Lid/dana/domain/paylater/model/LoanInfo;Lid/dana/domain/paylater/model/LoanStatusWhitelist;Ljava/lang/String;Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)Lio/reactivex/Observable;", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "payLaterCicilConfig", "Lid/dana/domain/paylater/model/LoanWhitelist;", "loanWhitelist", "", "handleLoanCache", "(Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;Lid/dana/domain/paylater/model/LoanWhitelist;)Ljava/util/List;", "Lid/dana/domain/paylater/PaylaterRepository;", "payLaterRepository", "Lid/dana/domain/paylater/PaylaterRepository;", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "<init>", "(Lid/dana/domain/paylater/PaylaterRepository;Lid/dana/domain/services/ServicesRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UpdatePayLaterLoanCache extends BaseUseCase<PayLaterLoanWhitelist, Params> {
    private final PaylaterRepository payLaterRepository;
    private final ServicesRepository servicesRepository;

    @Inject
    public UpdatePayLaterLoanCache(PaylaterRepository paylaterRepository, ServicesRepository servicesRepository) {
        Intrinsics.checkNotNullParameter(paylaterRepository, "");
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        this.payLaterRepository = paylaterRepository;
        this.servicesRepository = servicesRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PayLaterLoanWhitelist> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<PayLaterLoanWhitelist> doOnNext = Observable.zip(this.payLaterRepository.getPaylaterCicilConfig(), this.payLaterRepository.getLoanConsultWhitelist(params.getWithBill()), new BiFunction() { // from class: id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                PayLaterLoanWhitelist m2397buildUseCase$lambda0;
                m2397buildUseCase$lambda0 = UpdatePayLaterLoanCache.m2397buildUseCase$lambda0(UpdatePayLaterLoanCache.this, (PaylaterCicilMethodConfig) obj, (LoanWhitelist) obj2);
                return m2397buildUseCase$lambda0;
            }
        }).doOnNext(new Consumer() { // from class: id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdatePayLaterLoanCache.m2398buildUseCase$lambda3(UpdatePayLaterLoanCache.this, (PayLaterLoanWhitelist) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final PayLaterLoanWhitelist m2397buildUseCase$lambda0(UpdatePayLaterLoanCache updatePayLaterLoanCache, PaylaterCicilMethodConfig paylaterCicilMethodConfig, LoanWhitelist loanWhitelist) {
        Intrinsics.checkNotNullParameter(updatePayLaterLoanCache, "");
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        return new PayLaterLoanWhitelist(loanWhitelist, updatePayLaterLoanCache.handleLoanCache(paylaterCicilMethodConfig, loanWhitelist), paylaterCicilMethodConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final void m2398buildUseCase$lambda3(UpdatePayLaterLoanCache updatePayLaterLoanCache, PayLaterLoanWhitelist payLaterLoanWhitelist) {
        Intrinsics.checkNotNullParameter(updatePayLaterLoanCache, "");
        Unit unit = (Unit) Observable.zip(updatePayLaterLoanCache.payLaterRepository.savePayLaterLoanStatus(payLaterLoanWhitelist.getStatusWhitelist()), updatePayLaterLoanCache.payLaterRepository.savePayLaterCacheWhitelistValue(payLaterLoanWhitelist.getLoanWhitelist()), updatePayLaterLoanCache.servicesRepository.getFavoriteServiceFromRemoteSource(), new Function3() { // from class: id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                Unit m2399buildUseCase$lambda3$lambda1;
                m2399buildUseCase$lambda3$lambda1 = UpdatePayLaterLoanCache.m2399buildUseCase$lambda3$lambda1((Boolean) obj, (Boolean) obj2, (ThirdPartyCategoryService) obj3);
                return m2399buildUseCase$lambda3$lambda1;
            }
        }).blockingFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-1  reason: not valid java name */
    public static final Unit m2399buildUseCase$lambda3$lambda1(Boolean bool, Boolean bool2, ThirdPartyCategoryService thirdPartyCategoryService) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
        return Unit.INSTANCE;
    }

    private final List<LoanStatusWhitelist> handleLoanCache(PaylaterCicilMethodConfig payLaterCicilConfig, LoanWhitelist loanWhitelist) {
        long timeInMillis;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : loanWhitelist.getLoanInfo()) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LoanInfo loanInfo = (LoanInfo) obj;
            timeInMillis = Calendar.getInstance().getTimeInMillis();
            String loanServiceState = PayLaterUtil.INSTANCE.getLoanServiceState(loanInfo, timeInMillis, payLaterCicilConfig.getThresholdDueInDay());
            StringBuilder sb = new StringBuilder();
            sb.append("service_paylater_");
            String lowerCase = loanInfo.getType().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            sb.append(lowerCase);
            String obj2 = sb.toString();
            ThirdPartyServiceResponse blockingFirst = this.servicesRepository.getServiceByKey(obj2).blockingFirst();
            PayLaterUtil payLaterUtil = PayLaterUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            LoanStatusWhitelist loanStatusWhitelist = payLaterUtil.getLoanStatusWhitelist(loanServiceState, loanInfo, timeInMillis, blockingFirst);
            arrayList.add(i, loanStatusWhitelist);
            doHighlightSwitching(loanServiceState, loanInfo, loanStatusWhitelist, obj2, blockingFirst);
            i++;
        }
        return arrayList;
    }

    private final Observable<LoanInfo> doHighlightSwitching(String loanStateService, final LoanInfo loanInfo, final LoanStatusWhitelist loanStatus, final String serviceName, final ThirdPartyServiceResponse service) {
        Observable<LoanInfo> zip = Observable.zip(this.payLaterRepository.setLoanServicesState(loanInfo.getType(), loanStateService), this.payLaterRepository.getPaylaterRotationDelayTime(), this.servicesRepository.isFeatureHighlightExist(serviceName), new Function3() { // from class: id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                LoanInfo m2400doHighlightSwitching$lambda5;
                m2400doHighlightSwitching$lambda5 = UpdatePayLaterLoanCache.m2400doHighlightSwitching$lambda5(LoanStatusWhitelist.this, this, service, serviceName, loanInfo, (Boolean) obj, (Long) obj2, (Boolean) obj3);
                return m2400doHighlightSwitching$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doHighlightSwitching$lambda-5  reason: not valid java name */
    public static final LoanInfo m2400doHighlightSwitching$lambda5(LoanStatusWhitelist loanStatusWhitelist, UpdatePayLaterLoanCache updatePayLaterLoanCache, ThirdPartyServiceResponse thirdPartyServiceResponse, String str, LoanInfo loanInfo, Boolean bool, Long l, Boolean bool2) {
        Integer rotationDelayTime;
        Intrinsics.checkNotNullParameter(loanStatusWhitelist, "");
        Intrinsics.checkNotNullParameter(updatePayLaterLoanCache, "");
        Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(loanInfo, "");
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(l, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        if (loanStatusWhitelist.isUnregisteredUser() && l.longValue() == 0) {
            updatePayLaterLoanCache.getDisposable().getAuthRequestContext(updatePayLaterLoanCache.payLaterRepository.savePaylaterRotationDelayTime(Calendar.getInstance().getTimeInMillis()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe());
        }
        PayLaterUtil payLaterUtil = PayLaterUtil.INSTANCE;
        long longValue = l.longValue();
        Integer rotationDelayTime2 = thirdPartyServiceResponse.getRotationDelayTime();
        boolean z = false;
        boolean z2 = !PayLaterUtil.isCacheExpire$default(payLaterUtil, null, null, longValue, rotationDelayTime2 != null ? rotationDelayTime2.intValue() : 0, 3, null) || ((rotationDelayTime = thirdPartyServiceResponse.getRotationDelayTime()) != null && rotationDelayTime.intValue() == 0);
        new Pair(Boolean.valueOf(z2), bool2);
        if (loanStatusWhitelist.isDueOrOverdue() || (loanStatusWhitelist.isUnregisteredUser() && z2)) {
            z = true;
        }
        if (bool2.booleanValue() && z) {
            updatePayLaterLoanCache.getDisposable().getAuthRequestContext(updatePayLaterLoanCache.servicesRepository.overwriteHighlightedService(str).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe());
        }
        return loanInfo;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache$Params;", "", "", "withBill", "Z", "getWithBill$domain_productionRelease", "()Z", "<init>", "(Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean withBill;

        public /* synthetic */ Params(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(z);
        }

        @JvmStatic
        public static final Params withBill() {
            return INSTANCE.withBill();
        }

        private Params(boolean z) {
            this.withBill = z;
        }

        @JvmName(name = "getWithBill$domain_productionRelease")
        /* renamed from: getWithBill$domain_productionRelease  reason: from getter */
        public final boolean getWithBill() {
            return this.withBill;
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache$Params$Companion;", "", "Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache$Params;", "withBill", "()Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params withBill() {
                return new Params(true, null);
            }
        }
    }
}
