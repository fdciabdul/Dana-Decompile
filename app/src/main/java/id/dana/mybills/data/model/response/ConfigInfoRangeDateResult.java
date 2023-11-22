package id.dana.mybills.data.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/mybills/data/model/response/ConfigInfoRangeDateResult;", "", "", "Lid/dana/mybills/data/model/response/RangeDateConfigResult;", "component1", "()Ljava/util/List;", "listRangeDateConfig", "copy", "(Ljava/util/List;)Lid/dana/mybills/data/model/response/ConfigInfoRangeDateResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getListRangeDateConfig", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfigInfoRangeDateResult {
    @SerializedName("configInfo")
    private final List<RangeDateConfigResult> listRangeDateConfig;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ConfigInfoRangeDateResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.model.response.ConfigInfoRangeDateResult.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigInfoRangeDateResult copy$default(ConfigInfoRangeDateResult configInfoRangeDateResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = configInfoRangeDateResult.listRangeDateConfig;
        }
        return configInfoRangeDateResult.copy(list);
    }

    public final List<RangeDateConfigResult> component1() {
        return this.listRangeDateConfig;
    }

    public final ConfigInfoRangeDateResult copy(List<RangeDateConfigResult> listRangeDateConfig) {
        Intrinsics.checkNotNullParameter(listRangeDateConfig, "");
        return new ConfigInfoRangeDateResult(listRangeDateConfig);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConfigInfoRangeDateResult) && Intrinsics.areEqual(this.listRangeDateConfig, ((ConfigInfoRangeDateResult) other).listRangeDateConfig);
    }

    public final int hashCode() {
        return this.listRangeDateConfig.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigInfoRangeDateResult(listRangeDateConfig=");
        sb.append(this.listRangeDateConfig);
        sb.append(')');
        return sb.toString();
    }

    public ConfigInfoRangeDateResult(List<RangeDateConfigResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.listRangeDateConfig = list;
    }

    public /* synthetic */ ConfigInfoRangeDateResult(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getListRangeDateConfig")
    public final List<RangeDateConfigResult> getListRangeDateConfig() {
        return this.listRangeDateConfig;
    }
}
