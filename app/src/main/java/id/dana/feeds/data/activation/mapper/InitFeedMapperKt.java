package id.dana.feeds.data.activation.mapper;

import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.data.activation.source.network.response.InitFeedResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;", "Lid/dana/domain/social/model/InitFeed;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;)Lid/dana/domain/social/model/InitFeed;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InitFeedMapperKt {
    public static final InitFeed BuiltInFictitiousFunctionClassFactory(InitFeedResponse initFeedResponse) {
        Intrinsics.checkNotNullParameter(initFeedResponse, "");
        return new InitFeed(InitStatus.FINISH, initFeedResponse.getInitProgress(), null, false, 12, null);
    }
}
