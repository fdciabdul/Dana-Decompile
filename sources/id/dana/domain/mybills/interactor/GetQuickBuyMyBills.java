package id.dana.domain.mybills.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.model.BizProduct;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/mybills/interactor/GetQuickBuyMyBills;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/mybills/model/BizProduct;", "Lid/dana/domain/mybills/interactor/GetQuickBuyMyBills$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/mybills/interactor/GetQuickBuyMyBills$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/MyBillsRepository;", "repository", "Lid/dana/domain/mybills/MyBillsRepository;", "<init>", "(Lid/dana/domain/mybills/MyBillsRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQuickBuyMyBills extends BaseUseCase<List<? extends BizProduct>, Params> {
    private final MyBillsRepository repository;

    @Inject
    public GetQuickBuyMyBills(MyBillsRepository myBillsRepository) {
        Intrinsics.checkNotNullParameter(myBillsRepository, "");
        this.repository = myBillsRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<BizProduct>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.repository.getQuickBuySubscription(params.getProfileKeys()).map(new Function() { // from class: id.dana.domain.mybills.interactor.GetQuickBuyMyBills$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2371buildUseCase$lambda1;
                m2371buildUseCase$lambda1 = GetQuickBuyMyBills.m2371buildUseCase$lambda1((List) obj);
                return m2371buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final List m2371buildUseCase$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.domain.mybills.interactor.GetQuickBuyMyBills$buildUseCase$lambda-1$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((BizProduct) t2).getTransactionDate()), Long.valueOf(((BizProduct) t).getTransactionDate()));
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/mybills/interactor/GetQuickBuyMyBills$Params;", "", "", "", "profileKeys", "Ljava/util/List;", "getProfileKeys", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final List<String> profileKeys;

        public Params(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.profileKeys = list;
        }

        @JvmName(name = "getProfileKeys")
        public final List<String> getProfileKeys() {
            return this.profileKeys;
        }
    }
}
