package id.dana.data.here.model;

import com.caverock.androidsvg.SVGParser;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0014J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014J¦\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00112\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b/\u0010\u0004R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b1\u0010\u0014R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\rR\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00100\u001a\u0004\b4\u0010\u0014R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b6\u0010\u0017R\u001c\u0010%\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b8\u0010\u0007R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\b:\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b;\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010\u0010R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00100\u001a\u0004\b>\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b?\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00109\u001a\u0004\b@\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/Item;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/data/here/model/HighlightsResponse;", "component10", "()Lid/dana/data/here/model/HighlightsResponse;", "component11", "component2", "component3", "Lid/dana/data/here/model/Address;", "component4", "()Lid/dana/data/here/model/Address;", "Lid/dana/data/here/model/Position;", "component5", "()Lid/dana/data/here/model/Position;", "", "Lid/dana/data/here/model/Access;", "component6", "()Ljava/util/List;", "", "component7", "()Ljava/lang/Integer;", "Lid/dana/data/here/model/Categories;", "component8", "Lid/dana/data/here/model/References;", "component9", "title", "id", "resultType", "address", "position", "access", "distance", "categories", "references", "highlights", SVGParser.XML_STYLESHEET_ATTR_HREF, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/here/model/Address;Lid/dana/data/here/model/Position;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Lid/dana/data/here/model/HighlightsResponse;Ljava/lang/String;)Lid/dana/data/here/model/Item;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/util/List;", "getAccess", "Lid/dana/data/here/model/Address;", "getAddress", "getCategories", "Ljava/lang/Integer;", "getDistance", "Lid/dana/data/here/model/HighlightsResponse;", "getHighlights", "Ljava/lang/String;", "getHref", "getId", "Lid/dana/data/here/model/Position;", "getPosition", "getReferences", "getResultType", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/here/model/Address;Lid/dana/data/here/model/Position;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Lid/dana/data/here/model/HighlightsResponse;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Item {
    @SerializedName("access")
    private final List<Access> access;
    @SerializedName("address")
    private final Address address;
    @SerializedName("categories")
    private final List<Categories> categories;
    @SerializedName("distance")
    private final Integer distance;
    @SerializedName("highlights")
    private final HighlightsResponse highlights;
    @SerializedName(SVGParser.XML_STYLESHEET_ATTR_HREF)
    private final String href;
    @SerializedName("id")
    private final String id;
    @SerializedName("position")
    private final Position position;
    @SerializedName("references")
    private final List<References> references;
    @SerializedName("resultType")
    private final String resultType;
    @SerializedName("title")
    private final String title;

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component10  reason: from getter */
    public final HighlightsResponse getHighlights() {
        return this.highlights;
    }

    /* renamed from: component11  reason: from getter */
    public final String getHref() {
        return this.href;
    }

    /* renamed from: component2  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3  reason: from getter */
    public final String getResultType() {
        return this.resultType;
    }

    /* renamed from: component4  reason: from getter */
    public final Address getAddress() {
        return this.address;
    }

    /* renamed from: component5  reason: from getter */
    public final Position getPosition() {
        return this.position;
    }

    public final List<Access> component6() {
        return this.access;
    }

    /* renamed from: component7  reason: from getter */
    public final Integer getDistance() {
        return this.distance;
    }

    public final List<Categories> component8() {
        return this.categories;
    }

    public final List<References> component9() {
        return this.references;
    }

    public final Item copy(String title, String id2, String resultType, Address address, Position position, List<Access> access, Integer distance, List<Categories> categories, List<References> references, HighlightsResponse highlights, String href) {
        return new Item(title, id2, resultType, address, position, access, distance, categories, references, highlights, href);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Item) {
            Item item = (Item) other;
            return Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.resultType, item.resultType) && Intrinsics.areEqual(this.address, item.address) && Intrinsics.areEqual(this.position, item.position) && Intrinsics.areEqual(this.access, item.access) && Intrinsics.areEqual(this.distance, item.distance) && Intrinsics.areEqual(this.categories, item.categories) && Intrinsics.areEqual(this.references, item.references) && Intrinsics.areEqual(this.highlights, item.highlights) && Intrinsics.areEqual(this.href, item.href);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.title;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.id;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.resultType;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Address address = this.address;
        int hashCode4 = address == null ? 0 : address.hashCode();
        Position position = this.position;
        int hashCode5 = position == null ? 0 : position.hashCode();
        List<Access> list = this.access;
        int hashCode6 = list == null ? 0 : list.hashCode();
        Integer num = this.distance;
        int hashCode7 = num == null ? 0 : num.hashCode();
        List<Categories> list2 = this.categories;
        int hashCode8 = list2 == null ? 0 : list2.hashCode();
        List<References> list3 = this.references;
        int hashCode9 = list3 == null ? 0 : list3.hashCode();
        HighlightsResponse highlightsResponse = this.highlights;
        int hashCode10 = highlightsResponse == null ? 0 : highlightsResponse.hashCode();
        String str4 = this.href;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item(title=");
        sb.append(this.title);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", resultType=");
        sb.append(this.resultType);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", access=");
        sb.append(this.access);
        sb.append(", distance=");
        sb.append(this.distance);
        sb.append(", categories=");
        sb.append(this.categories);
        sb.append(", references=");
        sb.append(this.references);
        sb.append(", highlights=");
        sb.append(this.highlights);
        sb.append(", href=");
        sb.append(this.href);
        sb.append(')');
        return sb.toString();
    }

    public Item(String str, String str2, String str3, Address address, Position position, List<Access> list, Integer num, List<Categories> list2, List<References> list3, HighlightsResponse highlightsResponse, String str4) {
        this.title = str;
        this.id = str2;
        this.resultType = str3;
        this.address = address;
        this.position = position;
        this.access = list;
        this.distance = num;
        this.categories = list2;
        this.references = list3;
        this.highlights = highlightsResponse;
        this.href = str4;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getResultType")
    public final String getResultType() {
        return this.resultType;
    }

    @JvmName(name = "getAddress")
    public final Address getAddress() {
        return this.address;
    }

    @JvmName(name = "getPosition")
    public final Position getPosition() {
        return this.position;
    }

    @JvmName(name = "getAccess")
    public final List<Access> getAccess() {
        return this.access;
    }

    @JvmName(name = "getDistance")
    public final Integer getDistance() {
        return this.distance;
    }

    @JvmName(name = "getCategories")
    public final List<Categories> getCategories() {
        return this.categories;
    }

    @JvmName(name = "getReferences")
    public final List<References> getReferences() {
        return this.references;
    }

    @JvmName(name = "getHighlights")
    public final HighlightsResponse getHighlights() {
        return this.highlights;
    }

    @JvmName(name = "getHref")
    public final String getHref() {
        return this.href;
    }
}
