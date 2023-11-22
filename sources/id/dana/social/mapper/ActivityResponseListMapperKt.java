package id.dana.social.mapper;

import android.content.Context;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.social.model.SocialFeedModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Landroid/content/Context;", "p0", "Lid/dana/social/model/SocialFeedModel;", "PlaceComponentResult", "(Ljava/util/List;Landroid/content/Context;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityResponseListMapperKt {
    public static final List<SocialFeedModel> PlaceComponentResult(List<ActivityResponse> list, Context context) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(context, "");
        List<ActivityResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ActivityResponseMapperKt.BuiltInFictitiousFunctionClassFactory((ActivityResponse) it.next(), context));
        }
        return arrayList;
    }
}
