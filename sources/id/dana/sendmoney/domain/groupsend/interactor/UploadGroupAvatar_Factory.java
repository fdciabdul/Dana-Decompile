package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UploadGroupAvatar_Factory implements Factory<UploadGroupAvatar> {
    private final Provider<UploadFilesRepository> BuiltInFictitiousFunctionClassFactory;

    private UploadGroupAvatar_Factory(Provider<UploadFilesRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static UploadGroupAvatar_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<UploadFilesRepository> provider) {
        return new UploadGroupAvatar_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UploadGroupAvatar(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
