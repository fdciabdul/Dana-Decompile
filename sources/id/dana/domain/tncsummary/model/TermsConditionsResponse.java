package id.dana.domain.tncsummary.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\t"}, d2 = {"Lid/dana/domain/tncsummary/model/TermsConditionsResponse;", "", "", "component1", "()Ljava/lang/Boolean;", "", "", "", "component2", "()Ljava/util/Map;", "enable", "spaceCode", "copy", "(Ljava/lang/Boolean;Ljava/util/Map;)Lid/dana/domain/tncsummary/model/TermsConditionsResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getEnable", "Ljava/util/Map;", "getSpaceCode", "<init>", "(Ljava/lang/Boolean;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TermsConditionsResponse {
    private final Boolean enable;
    private final Map<String, List<String>> spaceCode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TermsConditionsResponse copy$default(TermsConditionsResponse termsConditionsResponse, Boolean bool, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = termsConditionsResponse.enable;
        }
        if ((i & 2) != 0) {
            map = termsConditionsResponse.spaceCode;
        }
        return termsConditionsResponse.copy(bool, map);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getEnable() {
        return this.enable;
    }

    public final Map<String, List<String>> component2() {
        return this.spaceCode;
    }

    public final TermsConditionsResponse copy(Boolean enable, Map<String, ? extends List<String>> spaceCode) {
        return new TermsConditionsResponse(enable, spaceCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TermsConditionsResponse) {
            TermsConditionsResponse termsConditionsResponse = (TermsConditionsResponse) other;
            return Intrinsics.areEqual(this.enable, termsConditionsResponse.enable) && Intrinsics.areEqual(this.spaceCode, termsConditionsResponse.spaceCode);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.enable;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Map<String, List<String>> map = this.spaceCode;
        return (hashCode * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TermsConditionsResponse(enable=");
        sb.append(this.enable);
        sb.append(", spaceCode=");
        sb.append(this.spaceCode);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TermsConditionsResponse(Boolean bool, Map<String, ? extends List<String>> map) {
        this.enable = bool;
        this.spaceCode = map;
    }

    @JvmName(name = "getEnable")
    public final Boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getSpaceCode")
    public final Map<String, List<String>> getSpaceCode() {
        return this.spaceCode;
    }
}
