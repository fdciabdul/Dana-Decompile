package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/ViewConfigInfoResult;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "shortDescription", "iconList", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/cashier/data/repository/source/network/result/ViewConfigInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getIconList", "Ljava/lang/String;", "getShortDescription", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ViewConfigInfoResult {
    private final List<String> iconList;
    @SerializedName("shortDescription")
    private final String shortDescription;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewConfigInfoResult copy$default(ViewConfigInfoResult viewConfigInfoResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = viewConfigInfoResult.shortDescription;
        }
        if ((i & 2) != 0) {
            list = viewConfigInfoResult.iconList;
        }
        return viewConfigInfoResult.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final List<String> component2() {
        return this.iconList;
    }

    public final ViewConfigInfoResult copy(String shortDescription, List<String> iconList) {
        return new ViewConfigInfoResult(shortDescription, iconList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ViewConfigInfoResult) {
            ViewConfigInfoResult viewConfigInfoResult = (ViewConfigInfoResult) other;
            return Intrinsics.areEqual(this.shortDescription, viewConfigInfoResult.shortDescription) && Intrinsics.areEqual(this.iconList, viewConfigInfoResult.iconList);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.shortDescription;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.iconList;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewConfigInfoResult(shortDescription=");
        sb.append(this.shortDescription);
        sb.append(", iconList=");
        sb.append(this.iconList);
        sb.append(')');
        return sb.toString();
    }

    public ViewConfigInfoResult(String str, List<String> list) {
        this.shortDescription = str;
        this.iconList = list;
    }

    public /* synthetic */ ViewConfigInfoResult(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list);
    }

    @JvmName(name = "getShortDescription")
    public final String getShortDescription() {
        return this.shortDescription;
    }

    @JvmName(name = "getIconList")
    public final List<String> getIconList() {
        return this.iconList;
    }
}
