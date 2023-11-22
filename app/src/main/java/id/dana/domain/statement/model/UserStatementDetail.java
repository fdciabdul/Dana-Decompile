package id.dana.domain.statement.model;

import id.dana.domain.statement.StatementType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\"\u0010\n\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/domain/statement/model/UserStatementDetail;", "", "", "Lid/dana/domain/statement/model/StatementDetail;", "component1", "()Ljava/util/List;", "Lid/dana/domain/statement/StatementType;", "component2", "()Lid/dana/domain/statement/StatementType;", "statementDetails", "statementType", "copy", "(Ljava/util/List;Lid/dana/domain/statement/StatementType;)Lid/dana/domain/statement/model/UserStatementDetail;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getStatementDetails", "Lid/dana/domain/statement/StatementType;", "getStatementType", "setStatementType", "(Lid/dana/domain/statement/StatementType;)V", "<init>", "(Ljava/util/List;Lid/dana/domain/statement/StatementType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserStatementDetail {
    private final List<StatementDetail> statementDetails;
    private StatementType statementType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserStatementDetail copy$default(UserStatementDetail userStatementDetail, List list, StatementType statementType, int i, Object obj) {
        if ((i & 1) != 0) {
            list = userStatementDetail.statementDetails;
        }
        if ((i & 2) != 0) {
            statementType = userStatementDetail.statementType;
        }
        return userStatementDetail.copy(list, statementType);
    }

    public final List<StatementDetail> component1() {
        return this.statementDetails;
    }

    /* renamed from: component2  reason: from getter */
    public final StatementType getStatementType() {
        return this.statementType;
    }

    public final UserStatementDetail copy(List<StatementDetail> statementDetails, StatementType statementType) {
        Intrinsics.checkNotNullParameter(statementType, "");
        return new UserStatementDetail(statementDetails, statementType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserStatementDetail) {
            UserStatementDetail userStatementDetail = (UserStatementDetail) other;
            return Intrinsics.areEqual(this.statementDetails, userStatementDetail.statementDetails) && this.statementType == userStatementDetail.statementType;
        }
        return false;
    }

    public final int hashCode() {
        List<StatementDetail> list = this.statementDetails;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.statementType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserStatementDetail(statementDetails=");
        sb.append(this.statementDetails);
        sb.append(", statementType=");
        sb.append(this.statementType);
        sb.append(')');
        return sb.toString();
    }

    public UserStatementDetail(List<StatementDetail> list, StatementType statementType) {
        Intrinsics.checkNotNullParameter(statementType, "");
        this.statementDetails = list;
        this.statementType = statementType;
    }

    @JvmName(name = "getStatementDetails")
    public final List<StatementDetail> getStatementDetails() {
        return this.statementDetails;
    }

    @JvmName(name = "getStatementType")
    public final StatementType getStatementType() {
        return this.statementType;
    }

    @JvmName(name = "setStatementType")
    public final void setStatementType(StatementType statementType) {
        Intrinsics.checkNotNullParameter(statementType, "");
        this.statementType = statementType;
    }
}
