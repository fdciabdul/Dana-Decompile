package id.dana.transferaccount;

import id.dana.domain.transferaccount.interactor.GetCacheTransferAccountStatus;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e"}, d2 = {"Lid/dana/transferaccount/TransferAccountStatusChecker;", "Lio/reactivex/disposables/Disposable;", "", "dispose", "()V", "", "isDisposed", "()Z", "Lid/dana/domain/transferaccount/interactor/GetCacheTransferAccountStatus;", "getAuthRequestContext", "Lid/dana/domain/transferaccount/interactor/GetCacheTransferAccountStatus;", "PlaceComponentResult", "Ljava/lang/Runnable;", "MyBillsEntityDataFactory", "Ljava/lang/Runnable;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(Lid/dana/domain/transferaccount/interactor/GetCacheTransferAccountStatus;Ljava/lang/Runnable;Ljava/lang/Runnable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransferAccountStatusChecker implements Disposable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Runnable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Runnable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GetCacheTransferAccountStatus PlaceComponentResult;

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return false;
    }

    @Inject
    public TransferAccountStatusChecker(GetCacheTransferAccountStatus getCacheTransferAccountStatus, Runnable runnable, Runnable runnable2) {
        Intrinsics.checkNotNullParameter(getCacheTransferAccountStatus, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        Intrinsics.checkNotNullParameter(runnable2, "");
        this.PlaceComponentResult = getCacheTransferAccountStatus;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
        this.BuiltInFictitiousFunctionClassFactory = runnable2;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.PlaceComponentResult.dispose();
    }
}
