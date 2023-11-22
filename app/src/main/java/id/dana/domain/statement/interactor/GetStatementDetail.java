package id.dana.domain.statement.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.model.UserStatementDetail;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/statement/interactor/GetStatementDetail;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/statement/model/UserStatementDetail;", "Lid/dana/domain/statement/interactor/GetStatementDetail$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/statement/interactor/GetStatementDetail$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/statement/UserStatementRepository;", "userStatementRepository", "Lid/dana/domain/statement/UserStatementRepository;", "<init>", "(Lid/dana/domain/statement/UserStatementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetStatementDetail extends BaseUseCase<UserStatementDetail, Params> {
    private final UserStatementRepository userStatementRepository;

    @Inject
    public GetStatementDetail(UserStatementRepository userStatementRepository) {
        Intrinsics.checkNotNullParameter(userStatementRepository, "");
        this.userStatementRepository = userStatementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<UserStatementDetail> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userStatementRepository.getStatementDetail(params.getDateStart(), params.getDateEnd(), params.getStatementType());
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\b"}, d2 = {"Lid/dana/domain/statement/interactor/GetStatementDetail$Params;", "", "", "component1", "()J", "component2", "Lid/dana/domain/statement/StatementType;", "component3", "()Lid/dana/domain/statement/StatementType;", "dateStart", "dateEnd", "statementType", "copy", "(JJLid/dana/domain/statement/StatementType;)Lid/dana/domain/statement/interactor/GetStatementDetail$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getDateEnd", "getDateStart", "Lid/dana/domain/statement/StatementType;", "getStatementType", "<init>", "(JJLid/dana/domain/statement/StatementType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final long dateEnd;
        private final long dateStart;
        private final StatementType statementType;

        public static /* synthetic */ Params copy$default(Params params, long j, long j2, StatementType statementType, int i, Object obj) {
            if ((i & 1) != 0) {
                j = params.dateStart;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = params.dateEnd;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                statementType = params.statementType;
            }
            return params.copy(j3, j4, statementType);
        }

        /* renamed from: component1  reason: from getter */
        public final long getDateStart() {
            return this.dateStart;
        }

        /* renamed from: component2  reason: from getter */
        public final long getDateEnd() {
            return this.dateEnd;
        }

        /* renamed from: component3  reason: from getter */
        public final StatementType getStatementType() {
            return this.statementType;
        }

        public final Params copy(long dateStart, long dateEnd, StatementType statementType) {
            Intrinsics.checkNotNullParameter(statementType, "");
            return new Params(dateStart, dateEnd, statementType);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return this.dateStart == params.dateStart && this.dateEnd == params.dateEnd && this.statementType == params.statementType;
            }
            return false;
        }

        public final int hashCode() {
            return (((Cbor$Arg$$ExternalSyntheticBackport0.m(this.dateStart) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.dateEnd)) * 31) + this.statementType.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(dateStart=");
            sb.append(this.dateStart);
            sb.append(", dateEnd=");
            sb.append(this.dateEnd);
            sb.append(", statementType=");
            sb.append(this.statementType);
            sb.append(')');
            return sb.toString();
        }

        public Params(long j, long j2, StatementType statementType) {
            Intrinsics.checkNotNullParameter(statementType, "");
            this.dateStart = j;
            this.dateEnd = j2;
            this.statementType = statementType;
        }

        @JvmName(name = "getDateStart")
        public final long getDateStart() {
            return this.dateStart;
        }

        @JvmName(name = "getDateEnd")
        public final long getDateEnd() {
            return this.dateEnd;
        }

        @JvmName(name = "getStatementType")
        public final StatementType getStatementType() {
            return this.statementType;
        }
    }
}
