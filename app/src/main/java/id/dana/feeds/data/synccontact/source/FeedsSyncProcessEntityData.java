package id.dana.feeds.data.synccontact.source;

import id.dana.domain.sendmoney.model.UserContact;
import id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse;
import id.dana.feeds.data.synccontact.source.network.response.FeedsUserContact;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityData;", "", "", "", "p0", "Lid/dana/domain/sendmoney/model/UserContact;", "p1", "getAuthRequestContext", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsUserContact;", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsSyncProcessEntityData {
    Object KClassImpl$Data$declaredNonStaticMembers$2(List<FeedsUserContact> list, Continuation<? super FeedsSyncResponse> continuation);

    Object getAuthRequestContext(List<String> list, List<UserContact> list2, Continuation<? super List<String>> continuation);
}
