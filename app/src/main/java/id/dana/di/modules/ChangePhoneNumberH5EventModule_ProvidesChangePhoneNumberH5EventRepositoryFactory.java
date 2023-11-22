package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.h5event.repository.ChangePhoneNumberH5EventEntityRepository;
import id.dana.domain.h5event.ChangePhoneNumberH5EventRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChangePhoneNumberH5EventModule_ProvidesChangePhoneNumberH5EventRepositoryFactory implements Factory<ChangePhoneNumberH5EventRepository> {
    private final ChangePhoneNumberH5EventModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ChangePhoneNumberH5EventEntityRepository> getAuthRequestContext;

    public static ChangePhoneNumberH5EventRepository KClassImpl$Data$declaredNonStaticMembers$2(ChangePhoneNumberH5EventModule changePhoneNumberH5EventModule, ChangePhoneNumberH5EventEntityRepository changePhoneNumberH5EventEntityRepository) {
        return (ChangePhoneNumberH5EventRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(changePhoneNumberH5EventModule.BuiltInFictitiousFunctionClassFactory(changePhoneNumberH5EventEntityRepository));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChangePhoneNumberH5EventRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
