package id.dana.feeds.data.timeline;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.domain.timeline.model.GroupedActivity;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/domain/timeline/model/SocialFeed;", "socialFeed", BridgeDSL.INVOKE, "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)Lid/dana/feeds/domain/timeline/model/SocialFeed;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1 extends Lambda implements Function1<SocialFeed, SocialFeed> {
    final /* synthetic */ FeedsTimelineEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1(FeedsTimelineEntityRepository feedsTimelineEntityRepository) {
        super(1);
        this.this$0 = feedsTimelineEntityRepository;
    }

    @Override // kotlin.jvm.functions.Function1
    public final SocialFeed invoke(SocialFeed socialFeed) {
        ContactDeviceNameMapper contactDeviceNameMapper;
        Intrinsics.checkNotNullParameter(socialFeed, "");
        contactDeviceNameMapper = this.this$0.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(socialFeed, "");
        if (socialFeed.isFeedNotVersionTwo()) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = socialFeed.getGroupedActivities().iterator();
            while (it.hasNext()) {
                arrayList.addAll(((GroupedActivity) it.next()).getActivities());
            }
            arrayList.addAll(socialFeed.getActivities());
            contactDeviceNameMapper.getAuthRequestContext(arrayList, socialFeed.getFeedVersion() >= 5);
        } else {
            contactDeviceNameMapper.getAuthRequestContext(socialFeed.getActivities(), false);
        }
        return socialFeed;
    }
}
