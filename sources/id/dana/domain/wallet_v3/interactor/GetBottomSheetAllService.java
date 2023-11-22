package id.dana.domain.wallet_v3.interactor;

import id.dana.animation.HomeTabActivity;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.core.usecase.UseCaseSchedulers;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.wallet_v3.model.BottomSheetAllService;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function5;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetBottomSheetAllService;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/wallet_v3/model/BottomSheetAllService;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "", HomeTabActivity.WALLET_SECTION, "Lkotlin/Function0;", "", "hasSection", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "getBottomSheetServices", "(ILkotlin/jvm/functions/Function0;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "repository", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetBottomSheetAllService extends BaseUseCase<BottomSheetAllService, NoParams> {
    private static final int FINANCIAL_SECTION = 2;
    private static final int IDENTITY_SECTION = 5;
    private static final int LOYALTY_SECTION = 4;
    private static final int PAYMENT_SECTION = 1;
    private static final int VOUCHER_SECTION = 3;
    private final WalletConfigRepository repository;

    @Inject
    public GetBottomSheetAllService(WalletConfigRepository walletConfigRepository) {
        Intrinsics.checkNotNullParameter(walletConfigRepository, "");
        this.repository = walletConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<BottomSheetAllService> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.repository.getWalletConfigFromLocal().flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2527buildUseCase$lambda1;
                m2527buildUseCase$lambda1 = GetBottomSheetAllService.m2527buildUseCase$lambda1(GetBottomSheetAllService.this, (WalletConfig) obj);
                return m2527buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final ObservableSource m2527buildUseCase$lambda1(GetBottomSheetAllService getBottomSheetAllService, WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(getBottomSheetAllService, "");
        Intrinsics.checkNotNullParameter(walletConfig, "");
        final WalletV3Config walletV3 = walletConfig.getWalletV3();
        return Observable.zip(getBottomSheetAllService.getBottomSheetServices(1, new Function0<Boolean>() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$buildUseCase$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(WalletV3Config.this.getCategoryPayment() != null);
            }
        }), getBottomSheetAllService.getBottomSheetServices(2, new Function0<Boolean>() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$buildUseCase$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(WalletV3Config.this.getCategoryFinancial() != null);
            }
        }), getBottomSheetAllService.getBottomSheetServices(3, new Function0<Boolean>() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$buildUseCase$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(WalletV3Config.this.getCategoryVoucherAndTicket() != null);
            }
        }), getBottomSheetAllService.getBottomSheetServices(4, new Function0<Boolean>() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$buildUseCase$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(WalletV3Config.this.getCategoryLoyalty() != null);
            }
        }), getBottomSheetAllService.getBottomSheetServices(5, new Function0<Boolean>() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$buildUseCase$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(WalletV3Config.this.getCategoryIdentity() != null);
            }
        }), new Function5() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function5
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                BottomSheetAllService m2528buildUseCase$lambda1$lambda0;
                m2528buildUseCase$lambda1$lambda0 = GetBottomSheetAllService.m2528buildUseCase$lambda1$lambda0((List) obj, (List) obj2, (List) obj3, (List) obj4, (List) obj5);
                return m2528buildUseCase$lambda1$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1$lambda-0  reason: not valid java name */
    public static final BottomSheetAllService m2528buildUseCase$lambda1$lambda0(List list, List list2, List list3, List list4, List list5) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        Intrinsics.checkNotNullParameter(list4, "");
        Intrinsics.checkNotNullParameter(list5, "");
        return new BottomSheetAllService(list, list2, list3, list4, list5);
    }

    private final Observable<List<ThirdPartyServiceResponse>> getBottomSheetServices(int section, Function0<Boolean> hasSection) {
        Observable<List<ThirdPartyServiceResponse>> just;
        if (hasSection.invoke().booleanValue()) {
            just = this.repository.getBottomSheetServices(section);
        } else {
            just = Observable.just(CollectionsKt.emptyList());
        }
        Observable<List<ThirdPartyServiceResponse>> subscribeOn = just.onErrorReturn(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2529getBottomSheetServices$lambda2;
                m2529getBottomSheetServices$lambda2 = GetBottomSheetAllService.m2529getBottomSheetServices$lambda2((Throwable) obj);
                return m2529getBottomSheetServices$lambda2;
            }
        }).subscribeOn(UseCaseSchedulers.getJobScheduler());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBottomSheetServices$lambda-2  reason: not valid java name */
    public static final List m2529getBottomSheetServices$lambda2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }
}
