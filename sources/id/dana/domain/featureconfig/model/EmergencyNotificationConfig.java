package id.dana.domain.featureconfig.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0007"}, d2 = {"Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;", "Ljava/io/Serializable;", "", "component1", "()Z", "", "component2", "()J", "", "Lid/dana/domain/featureconfig/model/Content;", "component3", "()Ljava/util/List;", "enable", "endDate", "content", "copy", "(ZJLjava/util/List;)Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getContent", "Z", "getEnable", "J", "getEndDate", "<init>", "(ZJLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class EmergencyNotificationConfig implements Serializable {
    public List<Content> content;
    public boolean enable;
    public long endDate;

    public /* synthetic */ EmergencyNotificationConfig() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmergencyNotificationConfig copy$default(EmergencyNotificationConfig emergencyNotificationConfig, boolean z, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = emergencyNotificationConfig.enable;
        }
        if ((i & 2) != 0) {
            j = emergencyNotificationConfig.endDate;
        }
        if ((i & 4) != 0) {
            list = emergencyNotificationConfig.content;
        }
        return emergencyNotificationConfig.copy(z, j, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final long getEndDate() {
        return this.endDate;
    }

    public final List<Content> component3() {
        return this.content;
    }

    public final EmergencyNotificationConfig copy(boolean enable, long endDate, List<Content> content) {
        Intrinsics.checkNotNullParameter(content, "");
        return new EmergencyNotificationConfig(enable, endDate, content);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EmergencyNotificationConfig) {
            EmergencyNotificationConfig emergencyNotificationConfig = (EmergencyNotificationConfig) other;
            return this.enable == emergencyNotificationConfig.enable && this.endDate == emergencyNotificationConfig.endDate && Intrinsics.areEqual(this.content, emergencyNotificationConfig.content);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.endDate)) * 31) + this.content.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmergencyNotificationConfig(enable=");
        sb.append(this.enable);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(')');
        return sb.toString();
    }

    public EmergencyNotificationConfig(boolean z, long j, List<Content> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.enable = z;
        this.endDate = j;
        this.content = list;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getEndDate")
    public final long getEndDate() {
        return this.endDate;
    }

    @JvmName(name = "getContent")
    public final List<Content> getContent() {
        return this.content;
    }
}
