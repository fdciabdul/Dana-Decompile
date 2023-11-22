package id.dana.domain.statement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.model.IncomeAndExpenseStatementSummary;
import id.dana.domain.statement.model.UserStatement;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/statement/interactor/GetCustomStatementSummary;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/statement/model/IncomeAndExpenseStatementSummary;", "Lid/dana/domain/statement/interactor/GetCustomStatementSummary$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/statement/interactor/GetCustomStatementSummary$Params;)Lio/reactivex/Observable;", "Ljava/util/ArrayList;", "", "dates", "interval", "statementType", "", "Lid/dana/domain/statement/model/UserStatement;", "getCustomStatementSummary", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/statement/UserStatementRepository;", "userStatementRepository", "Lid/dana/domain/statement/UserStatementRepository;", "<init>", "(Lid/dana/domain/statement/UserStatementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetCustomStatementSummary extends BaseUseCase<IncomeAndExpenseStatementSummary, Params> {
    private final UserStatementRepository userStatementRepository;

    @Inject
    public GetCustomStatementSummary(UserStatementRepository userStatementRepository) {
        Intrinsics.checkNotNullParameter(userStatementRepository, "");
        this.userStatementRepository = userStatementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<IncomeAndExpenseStatementSummary> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<IncomeAndExpenseStatementSummary> zip = Observable.zip(getCustomStatementSummary(params.getDates(), params.getInterval(), StatementType.INCOME.name()), getCustomStatementSummary(params.getDates(), params.getInterval(), StatementType.EXPENSE.name()), new BiFunction() { // from class: id.dana.domain.statement.interactor.GetCustomStatementSummary$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                IncomeAndExpenseStatementSummary m2499buildUseCase$lambda0;
                m2499buildUseCase$lambda0 = GetCustomStatementSummary.m2499buildUseCase$lambda0((List) obj, (List) obj2);
                return m2499buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final IncomeAndExpenseStatementSummary m2499buildUseCase$lambda0(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        return new IncomeAndExpenseStatementSummary(list, list2);
    }

    private final Observable<List<UserStatement>> getCustomStatementSummary(ArrayList<String> dates, String interval, String statementType) {
        ArrayList<String> arrayList = dates;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(this.userStatementRepository.getStatementSummary((String) it.next(), interval, statementType));
        }
        Observable<List<UserStatement>> zip = Observable.zip(arrayList2, new Function() { // from class: id.dana.domain.statement.interactor.GetCustomStatementSummary$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2500getCustomStatementSummary$lambda2;
                m2500getCustomStatementSummary$lambda2 = GetCustomStatementSummary.m2500getCustomStatementSummary$lambda2((Object[]) obj);
                return m2500getCustomStatementSummary$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCustomStatementSummary$lambda-2  reason: not valid java name */
    public static final List m2500getCustomStatementSummary$lambda2(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj instanceof UserStatement) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/statement/interactor/GetCustomStatementSummary$Params;", "", "Ljava/util/ArrayList;", "", "dates", "Ljava/util/ArrayList;", "getDates", "()Ljava/util/ArrayList;", "interval", "Ljava/lang/String;", "getInterval", "()Ljava/lang/String;", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {
        private final ArrayList<String> dates;
        private final String interval;

        public Params(ArrayList<String> arrayList, String str) {
            Intrinsics.checkNotNullParameter(arrayList, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.dates = arrayList;
            this.interval = str;
        }

        @JvmName(name = "getDates")
        public final ArrayList<String> getDates() {
            return this.dates;
        }

        @JvmName(name = "getInterval")
        public final String getInterval() {
            return this.interval;
        }
    }
}
