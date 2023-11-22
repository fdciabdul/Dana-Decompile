package id.dana.danapoly.domain.rewards.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b"}, d2 = {"Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;", "", "Lid/dana/danapoly/domain/rewards/model/CardsSourcePage;", "cardsSourcePage", "Lid/dana/danapoly/domain/rewards/model/CardsSourcePage;", "getCardsSourcePage", "()Lid/dana/danapoly/domain/rewards/model/CardsSourcePage;", "", "eventId", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "", "pageNum", "I", "getPageNum", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "sort", "getSort", "", "statuses", "Ljava/util/List;", "getStatuses", "()Ljava/util/List;", "types", "getTypes", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;IILid/dana/danapoly/domain/rewards/model/CardsSourcePage;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRewardsParams {
    private final CardsSourcePage cardsSourcePage;
    private String eventId;
    private final int pageNum;
    private final int pageSize;
    private final String sort;
    private final List<String> statuses;
    private final List<String> types;

    public GetRewardsParams(String str, List<String> list, List<String> list2, String str2, int i, int i2, CardsSourcePage cardsSourcePage) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(cardsSourcePage, "");
        this.eventId = str;
        this.types = list;
        this.statuses = list2;
        this.sort = str2;
        this.pageNum = i;
        this.pageSize = i2;
        this.cardsSourcePage = cardsSourcePage;
    }

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "setEventId")
    public final void setEventId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.eventId = str;
    }

    public /* synthetic */ GetRewardsParams(String str, List list, List list2, String str2, int i, int i2, CardsSourcePage cardsSourcePage, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? 1 : i, (i3 & 32) != 0 ? 10 : i2, cardsSourcePage);
    }

    @JvmName(name = "getTypes")
    public final List<String> getTypes() {
        return this.types;
    }

    @JvmName(name = "getStatuses")
    public final List<String> getStatuses() {
        return this.statuses;
    }

    @JvmName(name = "getSort")
    public final String getSort() {
        return this.sort;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getCardsSourcePage")
    public final CardsSourcePage getCardsSourcePage() {
        return this.cardsSourcePage;
    }
}
