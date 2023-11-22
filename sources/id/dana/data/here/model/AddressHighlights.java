package id.dana.data.here.model;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J4\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0017\u0010\u0005"}, d2 = {"Lid/dana/data/here/model/AddressHighlights;", "", "", "Lid/dana/data/here/model/Title;", "component1", "()Ljava/util/List;", "component2", Constants.ScionAnalytics.PARAM_LABEL, "city", "copy", "(Ljava/util/List;Ljava/util/List;)Lid/dana/data/here/model/AddressHighlights;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCity", "getLabel", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AddressHighlights {
    @SerializedName("city")
    private final List<Title> city;
    @SerializedName(Constants.ScionAnalytics.PARAM_LABEL)
    private final List<Title> label;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AddressHighlights() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.AddressHighlights.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddressHighlights copy$default(AddressHighlights addressHighlights, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = addressHighlights.label;
        }
        if ((i & 2) != 0) {
            list2 = addressHighlights.city;
        }
        return addressHighlights.copy(list, list2);
    }

    public final List<Title> component1() {
        return this.label;
    }

    public final List<Title> component2() {
        return this.city;
    }

    public final AddressHighlights copy(List<Title> label, List<Title> city) {
        return new AddressHighlights(label, city);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AddressHighlights) {
            AddressHighlights addressHighlights = (AddressHighlights) other;
            return Intrinsics.areEqual(this.label, addressHighlights.label) && Intrinsics.areEqual(this.city, addressHighlights.city);
        }
        return false;
    }

    public final int hashCode() {
        List<Title> list = this.label;
        int hashCode = list == null ? 0 : list.hashCode();
        List<Title> list2 = this.city;
        return (hashCode * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AddressHighlights(label=");
        sb.append(this.label);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(')');
        return sb.toString();
    }

    public AddressHighlights(List<Title> list, List<Title> list2) {
        this.label = list;
        this.city = list2;
    }

    public /* synthetic */ AddressHighlights(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getLabel")
    public final List<Title> getLabel() {
        return this.label;
    }

    @JvmName(name = "getCity")
    public final List<Title> getCity() {
        return this.city;
    }
}
