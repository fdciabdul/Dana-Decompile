package id.dana.domain.globalnetwork.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.common.ObservableUseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.model.Forex;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Currency;
import java.util.Locale;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetForex extends ObservableUseCase<Forex, String> {
    private static final double DEFAULT_CURRENCY_RATE = 1.0d;
    private static final String INDONESIA_COUNTRY_CODE = "ID";
    private static final String INDONESIA_CURRENCY = "IDR";
    private final GlobalNetworkRepository globalNetworkRepository;
    private final UserRepository userRepository;

    @Inject
    public GetForex(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GlobalNetworkRepository globalNetworkRepository, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.globalNetworkRepository = globalNetworkRepository;
        this.userRepository = userRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.common.ObservableUseCase
    public Observable<Forex> buildUseCaseObservable(String str) {
        if (str == null || str.isEmpty()) {
            return this.globalNetworkRepository.getSelectedCountryCode().flatMap(new Function() { // from class: id.dana.domain.globalnetwork.interactor.GetForex$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Observable balanceByCountryCode;
                    balanceByCountryCode = GetForex.this.getBalanceByCountryCode((String) obj);
                    return balanceByCountryCode;
                }
            });
        }
        return getBalanceByCountryCode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Forex> getBalanceByCountryCode(String str) {
        if (str.isEmpty() || "ID".equals(str)) {
            Forex forex = new Forex();
            forex.setCurrency("IDR");
            forex.setRate(1.0d);
            return getBalance(forex);
        }
        return getForexCache("IDR", getForeignCurrency(str));
    }

    private Observable<Forex> getForexCache(final String str, final String str2) {
        return this.globalNetworkRepository.getForexCache(str, str2).onErrorResumeNext(getForexRate(str, str2)).flatMap(new Function() { // from class: id.dana.domain.globalnetwork.interactor.GetForex$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetForex.this.m2347x84149c33(str, str2, (Forex) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getForexCache$0$id-dana-domain-globalnetwork-interactor-GetForex  reason: not valid java name */
    public /* synthetic */ ObservableSource m2347x84149c33(String str, String str2, Forex forex) throws Exception {
        return isForexInvalid(forex) ? getForexRate(str, str2) : getBalance(forex);
    }

    private Observable<Forex> getForexRate(String str, String str2) {
        return this.globalNetworkRepository.getForexRate(str, str2).flatMap(new Function() { // from class: id.dana.domain.globalnetwork.interactor.GetForex$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable balance;
                balance = GetForex.this.getBalance((Forex) obj);
                return balance;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Forex> getBalance(final Forex forex) {
        return this.userRepository.getSingleBalance(true).flatMap(new Function() { // from class: id.dana.domain.globalnetwork.interactor.GetForex$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetForex.this.m2346xe5c167ae(forex, (CurrencyAmount) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getBalance$1$id-dana-domain-globalnetwork-interactor-GetForex  reason: not valid java name */
    public /* synthetic */ ObservableSource m2346xe5c167ae(Forex forex, CurrencyAmount currencyAmount) throws Exception {
        forex.setAmount(currencyAmount.getAmount());
        this.globalNetworkRepository.saveForex(forex).subscribe();
        return Observable.just(forex);
    }

    private boolean isForexInvalid(Forex forex) {
        return forex == null || forex.shouldRefreshForex();
    }

    private String getForeignCurrency(String str) {
        return Currency.getInstance(new Locale(Locale.ENGLISH.getLanguage(), str)).getCurrencyCode();
    }
}
