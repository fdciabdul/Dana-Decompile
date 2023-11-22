package id.dana.domain.requestmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.requestmoney.model.BankSelectorConfig;
import id.dana.domain.requestmoney.model.NameCheckConfig;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/requestmoney/interactor/GetBankSelectorConfig;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/requestmoney/model/BankSelectorConfig;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/requestmoney/RequestMoneyRepository;", "requestMoneyRepository", "Lid/dana/domain/requestmoney/RequestMoneyRepository;", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "sendMoneyRepository", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "<init>", "(Lid/dana/domain/requestmoney/RequestMoneyRepository;Lid/dana/domain/sendmoney/repository/SendMoneyRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetBankSelectorConfig extends BaseUseCase<BankSelectorConfig, NoParams> {
    @Deprecated
    private static final String BANK = "BANK_TRANSFER";
    private static final Companion Companion = new Companion(null);
    private final RequestMoneyRepository requestMoneyRepository;
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public GetBankSelectorConfig(RequestMoneyRepository requestMoneyRepository, SendMoneyRepository sendMoneyRepository) {
        Intrinsics.checkNotNullParameter(requestMoneyRepository, "");
        Intrinsics.checkNotNullParameter(sendMoneyRepository, "");
        this.requestMoneyRepository = requestMoneyRepository;
        this.sendMoneyRepository = sendMoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<BankSelectorConfig> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<BankSelectorConfig> zip = Observable.zip(this.sendMoneyRepository.getTransferOption(null), this.requestMoneyRepository.getNamecheckConfig(), this.requestMoneyRepository.getTopFeaturedBanks().onErrorReturn(new Function() { // from class: id.dana.domain.requestmoney.interactor.GetBankSelectorConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2458buildUseCase$lambda0;
                m2458buildUseCase$lambda0 = GetBankSelectorConfig.m2458buildUseCase$lambda0((Throwable) obj);
                return m2458buildUseCase$lambda0;
            }
        }), this.sendMoneyRepository.getEWalletsBankAccountPrefix().onErrorReturn(new Function() { // from class: id.dana.domain.requestmoney.interactor.GetBankSelectorConfig$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2459buildUseCase$lambda1;
                m2459buildUseCase$lambda1 = GetBankSelectorConfig.m2459buildUseCase$lambda1((Throwable) obj);
                return m2459buildUseCase$lambda1;
            }
        }), new Function4() { // from class: id.dana.domain.requestmoney.interactor.GetBankSelectorConfig$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                BankSelectorConfig m2460buildUseCase$lambda2;
                m2460buildUseCase$lambda2 = GetBankSelectorConfig.m2460buildUseCase$lambda2((TransferInit) obj, (NameCheckConfig) obj2, (List) obj3, (List) obj4);
                return m2460buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final List m2458buildUseCase$lambda0(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final List m2459buildUseCase$lambda1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final BankSelectorConfig m2460buildUseCase$lambda2(TransferInit transferInit, NameCheckConfig nameCheckConfig, List list, List list2) {
        Intrinsics.checkNotNullParameter(transferInit, "");
        Intrinsics.checkNotNullParameter(nameCheckConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        return new BankSelectorConfig(transferInit, nameCheckConfig, list, list2);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/requestmoney/interactor/GetBankSelectorConfig$Companion;", "", "", "BANK", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
