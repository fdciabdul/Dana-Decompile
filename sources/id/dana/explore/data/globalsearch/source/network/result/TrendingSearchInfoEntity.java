package id.dana.explore.data.globalsearch.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/result/TrendingSearchInfoEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "count", "Ljava/lang/Integer;", "getCount", "()Ljava/lang/Integer;", "", "keyword", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "searchId", "getSearchId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrendingSearchInfoEntity extends BaseRpcResult {
    @SerializedName("count")
    private final Integer count;
    @SerializedName("keyword")
    private final String keyword;
    @SerializedName("searchId")
    private final String searchId;

    public TrendingSearchInfoEntity() {
        this(null, null, null, 7, null);
    }

    @JvmName(name = "getSearchId")
    public final String getSearchId() {
        return this.searchId;
    }

    @JvmName(name = "getKeyword")
    public final String getKeyword() {
        return this.keyword;
    }

    public /* synthetic */ TrendingSearchInfoEntity(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? 0 : num);
    }

    @JvmName(name = "getCount")
    public final Integer getCount() {
        return this.count;
    }

    public TrendingSearchInfoEntity(String str, String str2, Integer num) {
        this.searchId = str;
        this.keyword = str2;
        this.count = num;
    }
}
