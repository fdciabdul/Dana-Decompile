package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.util.DateTimeUtils;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.constant.TransactionQueryType;
import id.dana.kyb.domain.model.KybTransactionOrderInfo;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\t"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybTransactionHistory;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "Lid/dana/kyb/domain/interactor/GetKybTransactionHistory$Param;", "p0", "Lio/reactivex/Observable;", "getAuthRequestContext", "(Lid/dana/kyb/domain/interactor/GetKybTransactionHistory$Param;)Lio/reactivex/Observable;", "Lid/dana/kyb/domain/KybRepository;", "Lid/dana/kyb/domain/KybRepository;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/kyb/domain/KybRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetKybTransactionHistory extends BaseUseCase<TransactionListQueryInfo, Param> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final KybRepository BuiltInFictitiousFunctionClassFactory;

    @Inject
    public GetKybTransactionHistory(KybRepository kybRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = kybRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public final Observable<TransactionListQueryInfo> buildUseCase(Param p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<TransactionListQueryInfo> zip = Observable.zip(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0.getKClassImpl$Data$declaredNonStaticMembers$2(), "PROCESSING"), this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0.getKClassImpl$Data$declaredNonStaticMembers$2(), TransactionQueryType.COMPLETED), this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(), new Function3() { // from class: id.dana.kyb.domain.interactor.GetKybTransactionHistory$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return GetKybTransactionHistory.MyBillsEntityDataFactory(GetKybTransactionHistory.this, (TransactionListQueryInfo) obj, (TransactionListQueryInfo) obj2, (String) obj3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybTransactionHistory$Param;", "", "", "MyBillsEntityDataFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;

        public Param() {
            this(false, 1, null);
        }

        public Param(boolean z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        public /* synthetic */ Param(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    public static /* synthetic */ TransactionListQueryInfo MyBillsEntityDataFactory(final GetKybTransactionHistory getKybTransactionHistory, TransactionListQueryInfo transactionListQueryInfo, TransactionListQueryInfo transactionListQueryInfo2, String str) {
        int i;
        Intrinsics.checkNotNullParameter(getKybTransactionHistory, "");
        Intrinsics.checkNotNullParameter(transactionListQueryInfo, "");
        Intrinsics.checkNotNullParameter(transactionListQueryInfo2, "");
        Intrinsics.checkNotNullParameter(str, "");
        boolean z = false;
        boolean z2 = transactionListQueryInfo.getHasMore() || transactionListQueryInfo2.getHasMore();
        List sortedWith = CollectionsKt.sortedWith(CollectionsKt.plus((Collection) transactionListQueryInfo.getTransactionItems(), (Iterable) transactionListQueryInfo2.getTransactionItems()), new Comparator() { // from class: id.dana.kyb.domain.interactor.GetKybTransactionHistory$mergeAndSortTransaction$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(GetKybTransactionHistory.getAuthRequestContext(((KybTransactionOrderInfo) t2).getOrderTime())), Long.valueOf(GetKybTransactionHistory.getAuthRequestContext(((KybTransactionOrderInfo) t).getOrderTime())));
            }
        });
        if (!(str.length() == 0) || (!sortedWith.isEmpty()) != true) {
            Iterator it = sortedWith.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(((KybTransactionOrderInfo) it.next()).getOrderId(), str)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            i = sortedWith.size();
        }
        if (z2 && i >= 40) {
            z = true;
        }
        return new TransactionListQueryInfo(z, CollectionsKt.take(sortedWith, 4), i, sortedWith.size());
    }

    public static final /* synthetic */ long getAuthRequestContext(String str) {
        DateTimeUtils dateTimeUtils = DateTimeUtils.INSTANCE;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        return dateTimeUtils.convertDateToTimeMillis(str, "yyyy-MM-dd'T'HH:mm:ssXXX", locale);
    }
}
