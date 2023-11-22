package id.dana.domain.featureconfig.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/domain/featureconfig/model/MccListConfig;", "", "", "", "component1", "()Ljava/util/List;", "mccList", "copy", "(Ljava/util/List;)Lid/dana/domain/featureconfig/model/MccListConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getMccList", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MccListConfig {
    @SerializedName("mcc_list")
    private final List<String> mccList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MccListConfig copy$default(MccListConfig mccListConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mccListConfig.mccList;
        }
        return mccListConfig.copy(list);
    }

    public final List<String> component1() {
        return this.mccList;
    }

    public final MccListConfig copy(List<String> mccList) {
        Intrinsics.checkNotNullParameter(mccList, "");
        return new MccListConfig(mccList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MccListConfig) && Intrinsics.areEqual(this.mccList, ((MccListConfig) other).mccList);
    }

    public final int hashCode() {
        return this.mccList.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MccListConfig(mccList=");
        sb.append(this.mccList);
        sb.append(')');
        return sb.toString();
    }

    public MccListConfig(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.mccList = list;
    }

    @JvmName(name = "getMccList")
    public final List<String> getMccList() {
        return this.mccList;
    }
}
