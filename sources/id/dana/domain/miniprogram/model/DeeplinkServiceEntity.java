package id.dana.domain.miniprogram.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J2\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/miniprogram/model/DeeplinkServiceEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "variant", "value", "source", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/miniprogram/model/DeeplinkServiceEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSource", "getValue", "getVariant", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class DeeplinkServiceEntity {
    private final String source;
    private final String value;
    private final String variant;

    public static /* synthetic */ DeeplinkServiceEntity copy$default(DeeplinkServiceEntity deeplinkServiceEntity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deeplinkServiceEntity.variant;
        }
        if ((i & 2) != 0) {
            str2 = deeplinkServiceEntity.value;
        }
        if ((i & 4) != 0) {
            str3 = deeplinkServiceEntity.source;
        }
        return deeplinkServiceEntity.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* renamed from: component2  reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public final DeeplinkServiceEntity copy(String variant, String value, String source) {
        Intrinsics.checkNotNullParameter(variant, "");
        return new DeeplinkServiceEntity(variant, value, source);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DeeplinkServiceEntity) {
            DeeplinkServiceEntity deeplinkServiceEntity = (DeeplinkServiceEntity) other;
            return Intrinsics.areEqual(this.variant, deeplinkServiceEntity.variant) && Intrinsics.areEqual(this.value, deeplinkServiceEntity.value) && Intrinsics.areEqual(this.source, deeplinkServiceEntity.source);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.variant.hashCode();
        String str = this.value;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.source;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeeplinkServiceEntity(variant=");
        sb.append(this.variant);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(')');
        return sb.toString();
    }

    public DeeplinkServiceEntity(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        this.variant = str;
        this.value = str2;
        this.source = str3;
    }

    public /* synthetic */ DeeplinkServiceEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getVariant")
    public final String getVariant() {
        return this.variant;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }

    @JvmName(name = "getSource")
    public final String getSource() {
        return this.source;
    }
}
