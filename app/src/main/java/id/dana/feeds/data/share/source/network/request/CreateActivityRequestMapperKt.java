package id.dana.feeds.data.share.source.network.request;

import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;", "Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;", "toCreateActivityRequest", "(Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;)Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateActivityRequestMapperKt {
    public static final CreateActivityRequest toCreateActivityRequest(CreateFeedActivity.Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return new CreateActivityRequest(params.moveToNextValue, params.KClassImpl$Data$declaredNonStaticMembers$2, params.MyBillsEntityDataFactory, params.PlaceComponentResult, params.BuiltInFictitiousFunctionClassFactory, params.scheduleImpl);
    }
}
