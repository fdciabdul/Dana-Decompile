package id.dana.domain.usercredential.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.util.DateTimeUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\n"}, d2 = {"Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;", "", "", "component1", "()J", "", "component2", "()Z", "", "component3", "()I", "passwordLastModified", "passwordLastModifiedCheck", "pinExpiredInDays", "copy", "(JZI)Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "isPassedPinExpiredTimeLimit", "(IJ)Z", "shouldChangePin", "", "toString", "()Ljava/lang/String;", "J", "getPasswordLastModified", "Z", "getPasswordLastModifiedCheck", "I", "getPinExpiredInDays", "<init>", "(JZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryCredentialInfoModel {
    private final long passwordLastModified;
    private final boolean passwordLastModifiedCheck;
    private final int pinExpiredInDays;

    public QueryCredentialInfoModel() {
        this(0L, false, 0, 7, null);
    }

    public static /* synthetic */ QueryCredentialInfoModel copy$default(QueryCredentialInfoModel queryCredentialInfoModel, long j, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = queryCredentialInfoModel.passwordLastModified;
        }
        if ((i2 & 2) != 0) {
            z = queryCredentialInfoModel.passwordLastModifiedCheck;
        }
        if ((i2 & 4) != 0) {
            i = queryCredentialInfoModel.pinExpiredInDays;
        }
        return queryCredentialInfoModel.copy(j, z, i);
    }

    /* renamed from: component1  reason: from getter */
    public final long getPasswordLastModified() {
        return this.passwordLastModified;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getPasswordLastModifiedCheck() {
        return this.passwordLastModifiedCheck;
    }

    /* renamed from: component3  reason: from getter */
    public final int getPinExpiredInDays() {
        return this.pinExpiredInDays;
    }

    public final QueryCredentialInfoModel copy(long passwordLastModified, boolean passwordLastModifiedCheck, int pinExpiredInDays) {
        return new QueryCredentialInfoModel(passwordLastModified, passwordLastModifiedCheck, pinExpiredInDays);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryCredentialInfoModel) {
            QueryCredentialInfoModel queryCredentialInfoModel = (QueryCredentialInfoModel) other;
            return this.passwordLastModified == queryCredentialInfoModel.passwordLastModified && this.passwordLastModifiedCheck == queryCredentialInfoModel.passwordLastModifiedCheck && this.pinExpiredInDays == queryCredentialInfoModel.pinExpiredInDays;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.passwordLastModified);
        boolean z = this.passwordLastModifiedCheck;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((m * 31) + i) * 31) + this.pinExpiredInDays;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryCredentialInfoModel(passwordLastModified=");
        sb.append(this.passwordLastModified);
        sb.append(", passwordLastModifiedCheck=");
        sb.append(this.passwordLastModifiedCheck);
        sb.append(", pinExpiredInDays=");
        sb.append(this.pinExpiredInDays);
        sb.append(')');
        return sb.toString();
    }

    public QueryCredentialInfoModel(long j, boolean z, int i) {
        this.passwordLastModified = j;
        this.passwordLastModifiedCheck = z;
        this.pinExpiredInDays = i;
    }

    public /* synthetic */ QueryCredentialInfoModel(long j, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1L : j, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 180 : i);
    }

    @JvmName(name = "getPasswordLastModified")
    public final long getPasswordLastModified() {
        return this.passwordLastModified;
    }

    @JvmName(name = "getPasswordLastModifiedCheck")
    public final boolean getPasswordLastModifiedCheck() {
        return this.passwordLastModifiedCheck;
    }

    @JvmName(name = "getPinExpiredInDays")
    public final int getPinExpiredInDays() {
        return this.pinExpiredInDays;
    }

    public final boolean shouldChangePin() {
        return this.passwordLastModifiedCheck && isPassedPinExpiredTimeLimit(this.pinExpiredInDays, this.passwordLastModified);
    }

    private final boolean isPassedPinExpiredTimeLimit(int pinExpiredInDays, long passwordLastModified) {
        return DateTimeUtils.getDifference24HoursTimePeriod(System.currentTimeMillis(), passwordLastModified) > ((long) pinExpiredInDays);
    }
}
