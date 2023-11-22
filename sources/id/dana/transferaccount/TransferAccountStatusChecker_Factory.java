package id.dana.transferaccount;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.interactor.GetCacheTransferAccountStatus;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TransferAccountStatusChecker_Factory implements Factory<TransferAccountStatusChecker> {
    private final Provider<Runnable> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Runnable> PlaceComponentResult;
    private final Provider<GetCacheTransferAccountStatus> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferAccountStatusChecker(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
