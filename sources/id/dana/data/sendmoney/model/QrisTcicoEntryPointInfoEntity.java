package id.dana.data.sendmoney.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\bR\u0017\u0010\f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/data/sendmoney/model/QrisTcicoEntryPointInfoEntity;", "Ljava/io/Serializable;", "", "component1", "()Z", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "visibleStatus", "enableStatus", "instId", "instName", "instLocalName", "copy", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/sendmoney/model/QrisTcicoEntryPointInfoEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getEnableStatus", "Ljava/lang/String;", "getInstId", "getInstLocalName", "getInstName", "getVisibleStatus", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QrisTcicoEntryPointInfoEntity implements Serializable {
    private final boolean enableStatus;
    private final String instId;
    private final String instLocalName;
    private final String instName;
    private final boolean visibleStatus;

    public static /* synthetic */ QrisTcicoEntryPointInfoEntity copy$default(QrisTcicoEntryPointInfoEntity qrisTcicoEntryPointInfoEntity, boolean z, boolean z2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = qrisTcicoEntryPointInfoEntity.visibleStatus;
        }
        if ((i & 2) != 0) {
            z2 = qrisTcicoEntryPointInfoEntity.enableStatus;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            str = qrisTcicoEntryPointInfoEntity.instId;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = qrisTcicoEntryPointInfoEntity.instName;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = qrisTcicoEntryPointInfoEntity.instLocalName;
        }
        return qrisTcicoEntryPointInfoEntity.copy(z, z3, str4, str5, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getVisibleStatus() {
        return this.visibleStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getEnableStatus() {
        return this.enableStatus;
    }

    /* renamed from: component3  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getInstName() {
        return this.instName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    public final QrisTcicoEntryPointInfoEntity copy(boolean visibleStatus, boolean enableStatus, String instId, String instName, String instLocalName) {
        Intrinsics.checkNotNullParameter(instId, "");
        Intrinsics.checkNotNullParameter(instName, "");
        Intrinsics.checkNotNullParameter(instLocalName, "");
        return new QrisTcicoEntryPointInfoEntity(visibleStatus, enableStatus, instId, instName, instLocalName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QrisTcicoEntryPointInfoEntity) {
            QrisTcicoEntryPointInfoEntity qrisTcicoEntryPointInfoEntity = (QrisTcicoEntryPointInfoEntity) other;
            return this.visibleStatus == qrisTcicoEntryPointInfoEntity.visibleStatus && this.enableStatus == qrisTcicoEntryPointInfoEntity.enableStatus && Intrinsics.areEqual(this.instId, qrisTcicoEntryPointInfoEntity.instId) && Intrinsics.areEqual(this.instName, qrisTcicoEntryPointInfoEntity.instName) && Intrinsics.areEqual(this.instLocalName, qrisTcicoEntryPointInfoEntity.instLocalName);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean z = this.visibleStatus;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        boolean z2 = this.enableStatus;
        return (((((((r0 * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.instId.hashCode()) * 31) + this.instName.hashCode()) * 31) + this.instLocalName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QrisTcicoEntryPointInfoEntity(visibleStatus=");
        sb.append(this.visibleStatus);
        sb.append(", enableStatus=");
        sb.append(this.enableStatus);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", instName=");
        sb.append(this.instName);
        sb.append(", instLocalName=");
        sb.append(this.instLocalName);
        sb.append(')');
        return sb.toString();
    }

    public QrisTcicoEntryPointInfoEntity(boolean z, boolean z2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.visibleStatus = z;
        this.enableStatus = z2;
        this.instId = str;
        this.instName = str2;
        this.instLocalName = str3;
    }

    @JvmName(name = "getVisibleStatus")
    public final boolean getVisibleStatus() {
        return this.visibleStatus;
    }

    @JvmName(name = "getEnableStatus")
    public final boolean getEnableStatus() {
        return this.enableStatus;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstName")
    public final String getInstName() {
        return this.instName;
    }

    @JvmName(name = "getInstLocalName")
    public final String getInstLocalName() {
        return this.instLocalName;
    }
}
