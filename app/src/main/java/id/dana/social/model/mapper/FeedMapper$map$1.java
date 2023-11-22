package id.dana.social.model.mapper;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/feeds/domain/timeline/model/ActivityResponse;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedMapper$map$1 extends Lambda implements Function1<ActivityResponse, Boolean> {
    public static final FeedMapper$map$1 INSTANCE = new FeedMapper$map$1();

    FeedMapper$map$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(ActivityResponse activityResponse) {
        Intrinsics.checkNotNullParameter(activityResponse, "");
        return Boolean.FALSE;
    }
}
