package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.data.h5event.repository.ChangePhoneNumberH5EventEntityRepository;
import id.dana.domain.h5event.ChangePhoneNumberH5EventRepository;
import id.dana.h5event.ChangePhoneNumberH5EventContract;
import id.dana.h5event.ChangePhoneNumberH5EventPresenter;

@Module
/* loaded from: classes4.dex */
public class ChangePhoneNumberH5EventModule {
    private final ChangePhoneNumberH5EventContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public ChangePhoneNumberH5EventRepository BuiltInFictitiousFunctionClassFactory(ChangePhoneNumberH5EventEntityRepository changePhoneNumberH5EventEntityRepository) {
        return changePhoneNumberH5EventEntityRepository;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public ChangePhoneNumberH5EventContract.Presenter MyBillsEntityDataFactory(ChangePhoneNumberH5EventPresenter changePhoneNumberH5EventPresenter) {
        return changePhoneNumberH5EventPresenter;
    }

    public ChangePhoneNumberH5EventModule(ChangePhoneNumberH5EventContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public ChangePhoneNumberH5EventContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
