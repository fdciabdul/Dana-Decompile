package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/DirectDebitInfoResult;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "description", "instIds", "title", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/DirectDebitInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDescription", "Ljava/util/List;", "getInstIds", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DirectDebitInfoResult {
    @SerializedName("description")
    private final String description;
    private final List<String> instIds;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DirectDebitInfoResult copy$default(DirectDebitInfoResult directDebitInfoResult, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = directDebitInfoResult.description;
        }
        if ((i & 2) != 0) {
            list = directDebitInfoResult.instIds;
        }
        if ((i & 4) != 0) {
            str2 = directDebitInfoResult.title;
        }
        return directDebitInfoResult.copy(str, list, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> component2() {
        return this.instIds;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final DirectDebitInfoResult copy(String description, List<String> instIds, String title) {
        return new DirectDebitInfoResult(description, instIds, title);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DirectDebitInfoResult) {
            DirectDebitInfoResult directDebitInfoResult = (DirectDebitInfoResult) other;
            return Intrinsics.areEqual(this.description, directDebitInfoResult.description) && Intrinsics.areEqual(this.instIds, directDebitInfoResult.instIds) && Intrinsics.areEqual(this.title, directDebitInfoResult.title);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.description;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.instIds;
        int hashCode2 = list == null ? 0 : list.hashCode();
        String str2 = this.title;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DirectDebitInfoResult(description=");
        sb.append(this.description);
        sb.append(", instIds=");
        sb.append(this.instIds);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(')');
        return sb.toString();
    }

    public DirectDebitInfoResult(String str, List<String> list, String str2) {
        this.description = str;
        this.instIds = list;
        this.title = str2;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getInstIds")
    public final List<String> getInstIds() {
        return this.instIds;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }
}
