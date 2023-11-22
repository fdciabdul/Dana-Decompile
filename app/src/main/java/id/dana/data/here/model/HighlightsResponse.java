package id.dana.data.here.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005"}, d2 = {"Lid/dana/data/here/model/HighlightsResponse;", "", "", "Lid/dana/data/here/model/Title;", "component1", "()Ljava/util/List;", "Lid/dana/data/here/model/AddressHighlights;", "component2", "()Lid/dana/data/here/model/AddressHighlights;", "title", "address", "copy", "(Ljava/util/List;Lid/dana/data/here/model/AddressHighlights;)Lid/dana/data/here/model/HighlightsResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/here/model/AddressHighlights;", "getAddress", "Ljava/util/List;", "getTitle", "<init>", "(Ljava/util/List;Lid/dana/data/here/model/AddressHighlights;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HighlightsResponse {
    @SerializedName("address")
    private final AddressHighlights address;
    @SerializedName("title")
    private final List<Title> title;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, id.dana.data.here.model.AddressHighlights, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HighlightsResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.HighlightsResponse.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HighlightsResponse copy$default(HighlightsResponse highlightsResponse, List list, AddressHighlights addressHighlights, int i, Object obj) {
        if ((i & 1) != 0) {
            list = highlightsResponse.title;
        }
        if ((i & 2) != 0) {
            addressHighlights = highlightsResponse.address;
        }
        return highlightsResponse.copy(list, addressHighlights);
    }

    public final List<Title> component1() {
        return this.title;
    }

    /* renamed from: component2  reason: from getter */
    public final AddressHighlights getAddress() {
        return this.address;
    }

    public final HighlightsResponse copy(List<Title> title, AddressHighlights address) {
        return new HighlightsResponse(title, address);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HighlightsResponse) {
            HighlightsResponse highlightsResponse = (HighlightsResponse) other;
            return Intrinsics.areEqual(this.title, highlightsResponse.title) && Intrinsics.areEqual(this.address, highlightsResponse.address);
        }
        return false;
    }

    public final int hashCode() {
        List<Title> list = this.title;
        int hashCode = list == null ? 0 : list.hashCode();
        AddressHighlights addressHighlights = this.address;
        return (hashCode * 31) + (addressHighlights != null ? addressHighlights.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HighlightsResponse(title=");
        sb.append(this.title);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(')');
        return sb.toString();
    }

    public HighlightsResponse(List<Title> list, AddressHighlights addressHighlights) {
        this.title = list;
        this.address = addressHighlights;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ HighlightsResponse(java.util.List r1, id.dana.data.here.model.AddressHighlights r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L8
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r3 = r3 & 2
            if (r3 == 0) goto L13
            id.dana.data.here.model.AddressHighlights r2 = new id.dana.data.here.model.AddressHighlights
            r3 = 3
            r4 = 0
            r2.<init>(r4, r4, r3, r4)
        L13:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.HighlightsResponse.<init>(java.util.List, id.dana.data.here.model.AddressHighlights, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getTitle")
    public final List<Title> getTitle() {
        return this.title;
    }

    @JvmName(name = "getAddress")
    public final AddressHighlights getAddress() {
        return this.address;
    }
}
