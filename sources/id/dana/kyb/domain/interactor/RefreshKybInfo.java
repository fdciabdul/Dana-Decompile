package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.GetKybTransactionHistory;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/kyb/domain/interactor/RefreshKybInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lkotlin/Pair;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/kyb/domain/interactor/GetKybTransactionHistory;", "PlaceComponentResult", "Lid/dana/kyb/domain/interactor/GetKybTransactionHistory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/domain/KybRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/domain/KybRepository;", "p0", "p1", "<init>", "(Lid/dana/kyb/domain/KybRepository;Lid/dana/kyb/domain/interactor/GetKybTransactionHistory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RefreshKybInfo extends BaseUseCase<Pair<? extends KybMerchantInfo, ? extends TransactionListQueryInfo>, NoParams> {
    private final KybRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetKybTransactionHistory BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Pair<? extends KybMerchantInfo, ? extends TransactionListQueryInfo>> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<Pair<? extends KybMerchantInfo, ? extends TransactionListQueryInfo>> zip = Observable.zip(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(true), this.BuiltInFictitiousFunctionClassFactory.buildUseCase(new GetKybTransactionHistory.Param(true)), new BiFunction() { // from class: id.dana.kyb.domain.interactor.RefreshKybInfo$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return RefreshKybInfo.MyBillsEntityDataFactory((KybMerchantInfo) obj, (TransactionListQueryInfo) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    @Inject
    public RefreshKybInfo(KybRepository kybRepository, GetKybTransactionHistory getKybTransactionHistory) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        Intrinsics.checkNotNullParameter(getKybTransactionHistory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = kybRepository;
        this.BuiltInFictitiousFunctionClassFactory = getKybTransactionHistory;
    }

    public static /* synthetic */ Pair MyBillsEntityDataFactory(KybMerchantInfo kybMerchantInfo, TransactionListQueryInfo transactionListQueryInfo) {
        Intrinsics.checkNotNullParameter(kybMerchantInfo, "");
        Intrinsics.checkNotNullParameter(transactionListQueryInfo, "");
        return new Pair(kybMerchantInfo, transactionListQueryInfo);
    }
}
