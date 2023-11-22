package id.dana.cashier.domain.interactor;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.account.interactor.SaveLastTransaction;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ProcessEventCheckoutFinish_Factory implements Factory<ProcessEventCheckoutFinish> {
    private final Provider<Context> contextProvider;
    private final Provider<SaveLastTransaction> saveLastTransactionProvider;
    private final Provider<SplitFacade> splitFacadeProvider;

    public ProcessEventCheckoutFinish_Factory(Provider<Context> provider, Provider<SplitFacade> provider2, Provider<SaveLastTransaction> provider3) {
        this.contextProvider = provider;
        this.splitFacadeProvider = provider2;
        this.saveLastTransactionProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ProcessEventCheckoutFinish get() {
        return newInstance(this.contextProvider.get(), this.splitFacadeProvider.get(), this.saveLastTransactionProvider.get());
    }

    public static ProcessEventCheckoutFinish_Factory create(Provider<Context> provider, Provider<SplitFacade> provider2, Provider<SaveLastTransaction> provider3) {
        return new ProcessEventCheckoutFinish_Factory(provider, provider2, provider3);
    }

    public static ProcessEventCheckoutFinish newInstance(Context context, SplitFacade splitFacade, SaveLastTransaction saveLastTransaction) {
        return new ProcessEventCheckoutFinish(context, splitFacade, saveLastTransaction);
    }
}
