package id.dana.feeds.data.relationship.source.network.response;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\t¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J¢\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\u0018\b\u0002\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\tHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0014\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b/\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b1\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b3\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b4\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b5\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b6\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b7\u0010\u0004R*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010\u000b"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;", "", "", "component1", "()I", "component10", "component11", "component12", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "component13", "()Ljava/util/ArrayList;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "beginIndex", "endIndex", "firstPage", FirebaseAnalytics.Param.ITEMS, "itemsPerPage", "lastPage", "length", "nextPage", "offset", "page", SecurityConstants.KEY_PAGES, "previousPage", "slider", "copy", "(IIIIIIIIIIIILjava/util/ArrayList;)Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getBeginIndex", "getEndIndex", "getFirstPage", "getItems", "getItemsPerPage", "getLastPage", "getLength", "getNextPage", "getOffset", "getPage", "getPages", "getPreviousPage", "Ljava/util/ArrayList;", "getSlider", "<init>", "(IIIIIIIIIIIILjava/util/ArrayList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaginatorResponse {
    private final int beginIndex;
    private final int endIndex;
    private final int firstPage;
    private final int items;
    private final int itemsPerPage;
    private final int lastPage;
    private final int length;
    private final int nextPage;
    private final int offset;
    private final int page;
    private final int pages;
    private final int previousPage;
    private final ArrayList<Integer> slider;

    public PaginatorResponse() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 8191, null);
    }

    /* renamed from: component1  reason: from getter */
    public final int getBeginIndex() {
        return this.beginIndex;
    }

    /* renamed from: component10  reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component11  reason: from getter */
    public final int getPages() {
        return this.pages;
    }

    /* renamed from: component12  reason: from getter */
    public final int getPreviousPage() {
        return this.previousPage;
    }

    public final ArrayList<Integer> component13() {
        return this.slider;
    }

    /* renamed from: component2  reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    /* renamed from: component3  reason: from getter */
    public final int getFirstPage() {
        return this.firstPage;
    }

    /* renamed from: component4  reason: from getter */
    public final int getItems() {
        return this.items;
    }

    /* renamed from: component5  reason: from getter */
    public final int getItemsPerPage() {
        return this.itemsPerPage;
    }

    /* renamed from: component6  reason: from getter */
    public final int getLastPage() {
        return this.lastPage;
    }

    /* renamed from: component7  reason: from getter */
    public final int getLength() {
        return this.length;
    }

    /* renamed from: component8  reason: from getter */
    public final int getNextPage() {
        return this.nextPage;
    }

    /* renamed from: component9  reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    public final PaginatorResponse copy(int beginIndex, int endIndex, int firstPage, int items, int itemsPerPage, int lastPage, int length, int nextPage, int offset, int page, int pages, int previousPage, ArrayList<Integer> slider) {
        Intrinsics.checkNotNullParameter(slider, "");
        return new PaginatorResponse(beginIndex, endIndex, firstPage, items, itemsPerPage, lastPage, length, nextPage, offset, page, pages, previousPage, slider);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaginatorResponse) {
            PaginatorResponse paginatorResponse = (PaginatorResponse) other;
            return this.beginIndex == paginatorResponse.beginIndex && this.endIndex == paginatorResponse.endIndex && this.firstPage == paginatorResponse.firstPage && this.items == paginatorResponse.items && this.itemsPerPage == paginatorResponse.itemsPerPage && this.lastPage == paginatorResponse.lastPage && this.length == paginatorResponse.length && this.nextPage == paginatorResponse.nextPage && this.offset == paginatorResponse.offset && this.page == paginatorResponse.page && this.pages == paginatorResponse.pages && this.previousPage == paginatorResponse.previousPage && Intrinsics.areEqual(this.slider, paginatorResponse.slider);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((this.beginIndex * 31) + this.endIndex) * 31) + this.firstPage) * 31) + this.items) * 31) + this.itemsPerPage) * 31) + this.lastPage) * 31) + this.length) * 31) + this.nextPage) * 31) + this.offset) * 31) + this.page) * 31) + this.pages) * 31) + this.previousPage) * 31) + this.slider.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaginatorResponse(beginIndex=");
        sb.append(this.beginIndex);
        sb.append(", endIndex=");
        sb.append(this.endIndex);
        sb.append(", firstPage=");
        sb.append(this.firstPage);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(", itemsPerPage=");
        sb.append(this.itemsPerPage);
        sb.append(", lastPage=");
        sb.append(this.lastPage);
        sb.append(", length=");
        sb.append(this.length);
        sb.append(", nextPage=");
        sb.append(this.nextPage);
        sb.append(", offset=");
        sb.append(this.offset);
        sb.append(", page=");
        sb.append(this.page);
        sb.append(", pages=");
        sb.append(this.pages);
        sb.append(", previousPage=");
        sb.append(this.previousPage);
        sb.append(", slider=");
        sb.append(this.slider);
        sb.append(')');
        return sb.toString();
    }

    public PaginatorResponse(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "");
        this.beginIndex = i;
        this.endIndex = i2;
        this.firstPage = i3;
        this.items = i4;
        this.itemsPerPage = i5;
        this.lastPage = i6;
        this.length = i7;
        this.nextPage = i8;
        this.offset = i9;
        this.page = i10;
        this.pages = i11;
        this.previousPage = i12;
        this.slider = arrayList;
    }

    @JvmName(name = "getBeginIndex")
    public final int getBeginIndex() {
        return this.beginIndex;
    }

    @JvmName(name = "getEndIndex")
    public final int getEndIndex() {
        return this.endIndex;
    }

    @JvmName(name = "getFirstPage")
    public final int getFirstPage() {
        return this.firstPage;
    }

    @JvmName(name = "getItems")
    public final int getItems() {
        return this.items;
    }

    @JvmName(name = "getItemsPerPage")
    public final int getItemsPerPage() {
        return this.itemsPerPage;
    }

    @JvmName(name = "getLastPage")
    public final int getLastPage() {
        return this.lastPage;
    }

    @JvmName(name = "getLength")
    public final int getLength() {
        return this.length;
    }

    @JvmName(name = "getNextPage")
    public final int getNextPage() {
        return this.nextPage;
    }

    @JvmName(name = "getOffset")
    public final int getOffset() {
        return this.offset;
    }

    @JvmName(name = "getPage")
    public final int getPage() {
        return this.page;
    }

    @JvmName(name = "getPages")
    public final int getPages() {
        return this.pages;
    }

    @JvmName(name = "getPreviousPage")
    public final int getPreviousPage() {
        return this.previousPage;
    }

    public /* synthetic */ PaginatorResponse(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, ArrayList arrayList, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i, (i13 & 2) != 0 ? 0 : i2, (i13 & 4) != 0 ? 0 : i3, (i13 & 8) != 0 ? 0 : i4, (i13 & 16) != 0 ? 0 : i5, (i13 & 32) != 0 ? 0 : i6, (i13 & 64) != 0 ? 0 : i7, (i13 & 128) != 0 ? 0 : i8, (i13 & 256) != 0 ? 0 : i9, (i13 & 512) != 0 ? 0 : i10, (i13 & 1024) != 0 ? 0 : i11, (i13 & 2048) == 0 ? i12 : 0, (i13 & 4096) != 0 ? new ArrayList() : arrayList);
    }

    @JvmName(name = "getSlider")
    public final ArrayList<Integer> getSlider() {
        return this.slider;
    }
}
