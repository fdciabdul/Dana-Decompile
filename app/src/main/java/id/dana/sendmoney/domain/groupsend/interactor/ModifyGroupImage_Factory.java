package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ModifyGroupImage_Factory implements Factory<ModifyGroupImage> {
    private final Provider<GroupSendRepository> BuiltInFictitiousFunctionClassFactory;

    private ModifyGroupImage_Factory(Provider<GroupSendRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ModifyGroupImage_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GroupSendRepository> provider) {
        return new ModifyGroupImage_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ModifyGroupImage(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
