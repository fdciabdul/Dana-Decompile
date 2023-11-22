package id.dana.data.config.source.sharedpreference;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/config/source/sharedpreference/FeedsModelEntityData;", "", "", "Lid/dana/data/config/source/sharedpreference/ActivityModelEntityData;", "activityModelList", "Ljava/util/List;", "getActivityModelList", "()Ljava/util/List;", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "isFirstPage", "", "maxId", "Ljava/lang/String;", "getMaxId", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FeedsModelEntityData {
    private final List<ActivityModelEntityData> activityModelList;
    private final Boolean hasMore;
    private final Boolean isFirstPage;
    private final String maxId;

    public FeedsModelEntityData(List<ActivityModelEntityData> list, Boolean bool, Boolean bool2, String str) {
        this.activityModelList = list;
        this.hasMore = bool;
        this.isFirstPage = bool2;
        this.maxId = str;
    }

    @JvmName(name = "getActivityModelList")
    public final List<ActivityModelEntityData> getActivityModelList() {
        return this.activityModelList;
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "isFirstPage")
    /* renamed from: isFirstPage  reason: from getter */
    public final Boolean getIsFirstPage() {
        return this.isFirstPage;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }
}
