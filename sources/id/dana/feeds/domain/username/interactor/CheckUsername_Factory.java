package id.dana.feeds.domain.username.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.username.UserProfileRepository;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes8.dex */
public final class CheckUsername_Factory implements Factory<CheckUsername> {
    private final Provider<CoroutineDispatcher> MyBillsEntityDataFactory;
    private final Provider<UserProfileRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckUsername(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
