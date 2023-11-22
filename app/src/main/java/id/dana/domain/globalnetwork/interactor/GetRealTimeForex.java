package id.dana.domain.globalnetwork.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.model.Forex;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetRealTimeForex extends UseCase<List<Forex>, Params> {
    private final GlobalNetworkRepository globalNetworkRepository;
    private final UserRepository userRepository;

    @Inject
    public GetRealTimeForex(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GlobalNetworkRepository globalNetworkRepository, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.globalNetworkRepository = globalNetworkRepository;
        this.userRepository = userRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<Forex>> buildUseCaseObservable(Params params) {
        return this.globalNetworkRepository.getRealtimeForexList(params.fromCurrencies, params.toCurrencies).flatMap(new Function() { // from class: id.dana.domain.globalnetwork.interactor.GetRealTimeForex$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable balance;
                balance = GetRealTimeForex.this.getBalance((List) obj);
                return balance;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<List<Forex>> getBalance(final List<Forex> list) {
        return this.userRepository.getSingleBalance(true).flatMap(new Function() { // from class: id.dana.domain.globalnetwork.interactor.GetRealTimeForex$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetRealTimeForex.lambda$getBalance$0(list, (CurrencyAmount) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getBalance$0(List list, CurrencyAmount currencyAmount) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Forex) it.next()).setAmount(currencyAmount.getAmount());
        }
        return Observable.just(list);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private List<String> fromCurrencies;
        private List<String> toCurrencies;

        private Params(List<String> list, List<String> list2) {
            this.fromCurrencies = list;
            this.toCurrencies = list2;
        }

        public static Params getRealtimeForex(List<String> list, List<String> list2) {
            return new Params(list, list2);
        }
    }
}
