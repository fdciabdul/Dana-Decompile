package id.dana.data.here.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ@\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0005"}, d2 = {"Lid/dana/data/here/model/HereAutoCompleteResponse;", "", "", "Lid/dana/data/here/model/Item;", "component1", "()Ljava/util/List;", "", "component2", "component3", "()Ljava/lang/String;", FirebaseAnalytics.Param.ITEMS, "queryTerms", "errorMessage", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lid/dana/data/here/model/HereAutoCompleteResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorMessage", "Ljava/util/List;", "getItems", "getQueryTerms", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HereAutoCompleteResponse {
    @SerializedName(alternate = {"error"}, value = "title")
    private final String errorMessage;
    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    private final List<Item> items;
    @SerializedName("queryTerms")
    private final List<String> queryTerms;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HereAutoCompleteResponse copy$default(HereAutoCompleteResponse hereAutoCompleteResponse, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = hereAutoCompleteResponse.items;
        }
        if ((i & 2) != 0) {
            list2 = hereAutoCompleteResponse.queryTerms;
        }
        if ((i & 4) != 0) {
            str = hereAutoCompleteResponse.errorMessage;
        }
        return hereAutoCompleteResponse.copy(list, list2, str);
    }

    public final List<Item> component1() {
        return this.items;
    }

    public final List<String> component2() {
        return this.queryTerms;
    }

    /* renamed from: component3  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final HereAutoCompleteResponse copy(List<Item> items, List<String> queryTerms, String errorMessage) {
        return new HereAutoCompleteResponse(items, queryTerms, errorMessage);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HereAutoCompleteResponse) {
            HereAutoCompleteResponse hereAutoCompleteResponse = (HereAutoCompleteResponse) other;
            return Intrinsics.areEqual(this.items, hereAutoCompleteResponse.items) && Intrinsics.areEqual(this.queryTerms, hereAutoCompleteResponse.queryTerms) && Intrinsics.areEqual(this.errorMessage, hereAutoCompleteResponse.errorMessage);
        }
        return false;
    }

    public final int hashCode() {
        List<Item> list = this.items;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.queryTerms;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        String str = this.errorMessage;
        return (((hashCode * 31) + hashCode2) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HereAutoCompleteResponse(items=");
        sb.append(this.items);
        sb.append(", queryTerms=");
        sb.append(this.queryTerms);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(')');
        return sb.toString();
    }

    public HereAutoCompleteResponse(List<Item> list, List<String> list2, String str) {
        this.items = list;
        this.queryTerms = list2;
        this.errorMessage = str;
    }

    public /* synthetic */ HereAutoCompleteResponse(List list, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? "" : str);
    }

    @JvmName(name = "getItems")
    public final List<Item> getItems() {
        return this.items;
    }

    @JvmName(name = "getQueryTerms")
    public final List<String> getQueryTerms() {
        return this.queryTerms;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
