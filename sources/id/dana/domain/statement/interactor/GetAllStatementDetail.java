package id.dana.domain.statement.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.model.UserStatementDetail;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/statement/interactor/GetAllStatementDetail;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/statement/model/UserStatementDetail;", "Lid/dana/domain/statement/interactor/GetAllStatementDetail$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/statement/interactor/GetAllStatementDetail$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/statement/StatementType;", "type", "getStatementDetail", "(Lid/dana/domain/statement/interactor/GetAllStatementDetail$Params;Lid/dana/domain/statement/StatementType;)Lio/reactivex/Observable;", "incomes", "expenses", "toUserStatementDetail", "(Lid/dana/domain/statement/model/UserStatementDetail;Lid/dana/domain/statement/model/UserStatementDetail;)Ljava/util/List;", "Lid/dana/domain/statement/UserStatementRepository;", "userStatementRepository", "Lid/dana/domain/statement/UserStatementRepository;", "<init>", "(Lid/dana/domain/statement/UserStatementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetAllStatementDetail extends BaseUseCase<List<? extends UserStatementDetail>, Params> {
    private final UserStatementRepository userStatementRepository;

    @Inject
    public GetAllStatementDetail(UserStatementRepository userStatementRepository) {
        Intrinsics.checkNotNullParameter(userStatementRepository, "");
        this.userStatementRepository = userStatementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<UserStatementDetail>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable zipWith = getStatementDetail(params, StatementType.INCOME).zipWith(getStatementDetail(params, StatementType.EXPENSE), new BiFunction() { // from class: id.dana.domain.statement.interactor.GetAllStatementDetail$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                List userStatementDetail;
                userStatementDetail = GetAllStatementDetail.this.toUserStatementDetail((UserStatementDetail) obj, (UserStatementDetail) obj2);
                return userStatementDetail;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }

    private final Observable<UserStatementDetail> getStatementDetail(Params params, StatementType type) {
        return this.userStatementRepository.getStatementDetail(params.getDateStart(), params.getDateEnd(), type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<UserStatementDetail> toUserStatementDetail(UserStatementDetail incomes, UserStatementDetail expenses) {
        ArrayList arrayList = new ArrayList();
        incomes.setStatementType(StatementType.INCOME);
        expenses.setStatementType(StatementType.EXPENSE);
        arrayList.add(incomes);
        arrayList.add(expenses);
        return arrayList;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/domain/statement/interactor/GetAllStatementDetail$Params;", "", "", "component1", "()J", "component2", "dateStart", "dateEnd", "copy", "(JJ)Lid/dana/domain/statement/interactor/GetAllStatementDetail$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getDateEnd", "getDateStart", "<init>", "(JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final long dateEnd;
        private final long dateStart;

        public static /* synthetic */ Params copy$default(Params params, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = params.dateStart;
            }
            if ((i & 2) != 0) {
                j2 = params.dateEnd;
            }
            return params.copy(j, j2);
        }

        /* renamed from: component1  reason: from getter */
        public final long getDateStart() {
            return this.dateStart;
        }

        /* renamed from: component2  reason: from getter */
        public final long getDateEnd() {
            return this.dateEnd;
        }

        public final Params copy(long dateStart, long dateEnd) {
            return new Params(dateStart, dateEnd);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return this.dateStart == params.dateStart && this.dateEnd == params.dateEnd;
            }
            return false;
        }

        public final int hashCode() {
            return (Cbor$Arg$$ExternalSyntheticBackport0.m(this.dateStart) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.dateEnd);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(dateStart=");
            sb.append(this.dateStart);
            sb.append(", dateEnd=");
            sb.append(this.dateEnd);
            sb.append(')');
            return sb.toString();
        }

        public Params(long j, long j2) {
            this.dateStart = j;
            this.dateEnd = j2;
        }

        @JvmName(name = "getDateStart")
        public final long getDateStart() {
            return this.dateStart;
        }

        @JvmName(name = "getDateEnd")
        public final long getDateEnd() {
            return this.dateEnd;
        }
    }
}
