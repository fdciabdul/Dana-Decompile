package id.dana.data.services.repository.source.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/data/services/repository/source/model/ServiceHighlighted;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "", "component3", "()Ljava/lang/Integer;", "key", "createdAt", "index", "copy", "(Ljava/lang/String;JLjava/lang/Integer;)Lid/dana/data/services/repository/source/model/ServiceHighlighted;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "J", "getCreatedAt", "Ljava/lang/Integer;", "getIndex", "Ljava/lang/String;", "getKey", "<init>", "(Ljava/lang/String;JLjava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ServiceHighlighted {
    public long createdAt;
    public Integer index;
    public String key;

    public /* synthetic */ ServiceHighlighted() {
    }

    public static /* synthetic */ ServiceHighlighted copy$default(ServiceHighlighted serviceHighlighted, String str, long j, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serviceHighlighted.key;
        }
        if ((i & 2) != 0) {
            j = serviceHighlighted.createdAt;
        }
        if ((i & 4) != 0) {
            num = serviceHighlighted.index;
        }
        return serviceHighlighted.copy(str, j, num);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2  reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getIndex() {
        return this.index;
    }

    public final ServiceHighlighted copy(String key, long createdAt, Integer index) {
        return new ServiceHighlighted(key, createdAt, index);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ServiceHighlighted) {
            ServiceHighlighted serviceHighlighted = (ServiceHighlighted) other;
            return Intrinsics.areEqual(this.key, serviceHighlighted.key) && this.createdAt == serviceHighlighted.createdAt && Intrinsics.areEqual(this.index, serviceHighlighted.index);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.key;
        int hashCode = str == null ? 0 : str.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.createdAt);
        Integer num = this.index;
        return (((hashCode * 31) + m) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceHighlighted(key=");
        sb.append(this.key);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", index=");
        sb.append(this.index);
        sb.append(')');
        return sb.toString();
    }

    public ServiceHighlighted(String str, long j, Integer num) {
        this.key = str;
        this.createdAt = j;
        this.index = num;
    }

    public /* synthetic */ ServiceHighlighted(String str, long j, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? null : num);
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "getCreatedAt")
    public final long getCreatedAt() {
        return this.createdAt;
    }

    @JvmName(name = "getIndex")
    public final Integer getIndex() {
        return this.index;
    }
}
