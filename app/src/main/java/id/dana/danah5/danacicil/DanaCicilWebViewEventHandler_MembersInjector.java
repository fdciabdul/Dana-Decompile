package id.dana.danah5.danacicil;

import dagger.MembersInjector;
import id.dana.domain.creditscore.interactor.InsertInstalledAppsCreditScore;
import id.dana.domain.installedapp.interactor.IsNeedToSendInstalledApp;
import id.dana.domain.installedapp.interactor.SaveNeedToSendInstalledApp;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaCicilWebViewEventHandler_MembersInjector implements MembersInjector<DanaCicilWebViewEventHandler> {
    private final Provider<InsertInstalledAppsCreditScore> insertInstalledAppsCreditScoreProvider;
    private final Provider<IsNeedToSendInstalledApp> isNeedToSendInstalledAppProvider;
    private final Provider<SaveNeedToSendInstalledApp> saveNeedToSendInstalledAppProvider;

    public DanaCicilWebViewEventHandler_MembersInjector(Provider<IsNeedToSendInstalledApp> provider, Provider<SaveNeedToSendInstalledApp> provider2, Provider<InsertInstalledAppsCreditScore> provider3) {
        this.isNeedToSendInstalledAppProvider = provider;
        this.saveNeedToSendInstalledAppProvider = provider2;
        this.insertInstalledAppsCreditScoreProvider = provider3;
    }

    public static MembersInjector<DanaCicilWebViewEventHandler> create(Provider<IsNeedToSendInstalledApp> provider, Provider<SaveNeedToSendInstalledApp> provider2, Provider<InsertInstalledAppsCreditScore> provider3) {
        return new DanaCicilWebViewEventHandler_MembersInjector(provider, provider2, provider3);
    }

    public final void injectMembers(DanaCicilWebViewEventHandler danaCicilWebViewEventHandler) {
        injectIsNeedToSendInstalledApp(danaCicilWebViewEventHandler, this.isNeedToSendInstalledAppProvider.get());
        injectSaveNeedToSendInstalledApp(danaCicilWebViewEventHandler, this.saveNeedToSendInstalledAppProvider.get());
        injectInsertInstalledAppsCreditScore(danaCicilWebViewEventHandler, this.insertInstalledAppsCreditScoreProvider.get());
    }

    public static void injectIsNeedToSendInstalledApp(DanaCicilWebViewEventHandler danaCicilWebViewEventHandler, IsNeedToSendInstalledApp isNeedToSendInstalledApp) {
        danaCicilWebViewEventHandler.isNeedToSendInstalledApp = isNeedToSendInstalledApp;
    }

    public static void injectSaveNeedToSendInstalledApp(DanaCicilWebViewEventHandler danaCicilWebViewEventHandler, SaveNeedToSendInstalledApp saveNeedToSendInstalledApp) {
        danaCicilWebViewEventHandler.saveNeedToSendInstalledApp = saveNeedToSendInstalledApp;
    }

    public static void injectInsertInstalledAppsCreditScore(DanaCicilWebViewEventHandler danaCicilWebViewEventHandler, InsertInstalledAppsCreditScore insertInstalledAppsCreditScore) {
        danaCicilWebViewEventHandler.insertInstalledAppsCreditScore = insertInstalledAppsCreditScore;
    }
}
