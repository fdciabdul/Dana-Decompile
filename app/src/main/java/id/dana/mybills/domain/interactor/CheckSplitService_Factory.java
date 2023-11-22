package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class CheckSplitService_Factory implements Factory<CheckSplitService> {
    private final Provider<MyBillsRepository> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckSplitService(this.getAuthRequestContext.get());
    }
}
