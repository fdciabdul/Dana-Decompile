package id.dana.data.here.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/data/here/model/HereGeocodeResponse;", "", "", "Lid/dana/data/here/model/Item;", "component1", "()Ljava/util/List;", "hereItems", "copy", "(Ljava/util/List;)Lid/dana/data/here/model/HereGeocodeResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getHereItems", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HereGeocodeResponse {
    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    private final List<Item> hereItems;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HereGeocodeResponse copy$default(HereGeocodeResponse hereGeocodeResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = hereGeocodeResponse.hereItems;
        }
        return hereGeocodeResponse.copy(list);
    }

    public final List<Item> component1() {
        return this.hereItems;
    }

    public final HereGeocodeResponse copy(List<Item> hereItems) {
        return new HereGeocodeResponse(hereItems);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HereGeocodeResponse) && Intrinsics.areEqual(this.hereItems, ((HereGeocodeResponse) other).hereItems);
    }

    public final int hashCode() {
        List<Item> list = this.hereItems;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HereGeocodeResponse(hereItems=");
        sb.append(this.hereItems);
        sb.append(')');
        return sb.toString();
    }

    public HereGeocodeResponse(List<Item> list) {
        this.hereItems = list;
    }

    @JvmName(name = "getHereItems")
    public final List<Item> getHereItems() {
        return this.hereItems;
    }
}
