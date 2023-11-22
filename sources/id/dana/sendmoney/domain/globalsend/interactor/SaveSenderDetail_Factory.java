package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveSenderDetail_Factory implements Factory<SaveSenderDetail> {
    private final Provider<GlobalSendRepository> PlaceComponentResult;

    private SaveSenderDetail_Factory(Provider<GlobalSendRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SaveSenderDetail_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalSendRepository> provider) {
        return new SaveSenderDetail_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveSenderDetail(this.PlaceComponentResult.get());
    }
}
