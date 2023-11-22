package id.dana.data.banner.repository.source.network.response;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/data/banner/repository/source/network/response/BannerPaginatorEntityResponse;", "", "", "currentPage", "Ljava/lang/Integer;", "getCurrentPage", "()Ljava/lang/Integer;", "currentSize", "getCurrentSize", "totalPage", "getTotalPage", "totalSize", "getTotalSize", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerPaginatorEntityResponse {
    private final Integer currentPage;
    private final Integer currentSize;
    private final Integer totalPage;
    private final Integer totalSize;

    public BannerPaginatorEntityResponse() {
        this(null, null, null, null, 15, null);
    }

    public BannerPaginatorEntityResponse(Integer num, Integer num2, Integer num3, Integer num4) {
        this.currentPage = num;
        this.totalPage = num2;
        this.currentSize = num3;
        this.totalSize = num4;
    }

    public /* synthetic */ BannerPaginatorEntityResponse(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? 0 : num3, (i & 8) != 0 ? 0 : num4);
    }

    @JvmName(name = "getCurrentPage")
    public final Integer getCurrentPage() {
        return this.currentPage;
    }

    @JvmName(name = "getTotalPage")
    public final Integer getTotalPage() {
        return this.totalPage;
    }

    @JvmName(name = "getCurrentSize")
    public final Integer getCurrentSize() {
        return this.currentSize;
    }

    @JvmName(name = "getTotalSize")
    public final Integer getTotalSize() {
        return this.totalSize;
    }
}
