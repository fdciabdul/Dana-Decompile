package id.dana.feeds.domain.username.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.username.UserProfileRepository;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes8.dex */
public final class ChangeUsername_Factory implements Factory<ChangeUsername> {
    private final Provider<CoroutineDispatcher> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UserProfileRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ChangeUsername(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
