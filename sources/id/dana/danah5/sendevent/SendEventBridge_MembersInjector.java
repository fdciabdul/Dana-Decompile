package id.dana.danah5.sendevent;

import dagger.MembersInjector;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.account.interactor.SaveLastTransaction;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendEventBridge_MembersInjector implements MembersInjector<SendEventBridge> {
    private final Provider<GetContactsUseCase> getContactsUseCaseProvider;
    private final Provider<RemoteGnPaymentEntityData> remoteGnPaymentEntityDataProvider;
    private final Provider<SaveLastTransaction> saveLastTransactionProvider;
    private final Provider<SplitFacade> splitFacadeProvider;

    public SendEventBridge_MembersInjector(Provider<RemoteGnPaymentEntityData> provider, Provider<SplitFacade> provider2, Provider<SaveLastTransaction> provider3, Provider<GetContactsUseCase> provider4) {
        this.remoteGnPaymentEntityDataProvider = provider;
        this.splitFacadeProvider = provider2;
        this.saveLastTransactionProvider = provider3;
        this.getContactsUseCaseProvider = provider4;
    }

    public static MembersInjector<SendEventBridge> create(Provider<RemoteGnPaymentEntityData> provider, Provider<SplitFacade> provider2, Provider<SaveLastTransaction> provider3, Provider<GetContactsUseCase> provider4) {
        return new SendEventBridge_MembersInjector(provider, provider2, provider3, provider4);
    }

    public final void injectMembers(SendEventBridge sendEventBridge) {
        injectRemoteGnPaymentEntityData(sendEventBridge, this.remoteGnPaymentEntityDataProvider.get());
        injectSplitFacade(sendEventBridge, this.splitFacadeProvider.get());
        injectSaveLastTransaction(sendEventBridge, this.saveLastTransactionProvider.get());
        injectGetContactsUseCase(sendEventBridge, this.getContactsUseCaseProvider.get());
    }

    public static void injectRemoteGnPaymentEntityData(SendEventBridge sendEventBridge, RemoteGnPaymentEntityData remoteGnPaymentEntityData) {
        sendEventBridge.remoteGnPaymentEntityData = remoteGnPaymentEntityData;
    }

    public static void injectSplitFacade(SendEventBridge sendEventBridge, SplitFacade splitFacade) {
        sendEventBridge.splitFacade = splitFacade;
    }

    public static void injectSaveLastTransaction(SendEventBridge sendEventBridge, SaveLastTransaction saveLastTransaction) {
        sendEventBridge.saveLastTransaction = saveLastTransaction;
    }

    public static void injectGetContactsUseCase(SendEventBridge sendEventBridge, GetContactsUseCase getContactsUseCase) {
        sendEventBridge.getContactsUseCase = getContactsUseCase;
    }
}
