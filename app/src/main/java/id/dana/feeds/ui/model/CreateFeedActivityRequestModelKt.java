package id.dana.feeds.ui.model;

import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;", "Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;)Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateFeedActivityRequestModelKt {
    public static final CreateFeedActivity.Params KClassImpl$Data$declaredNonStaticMembers$2(CreateFeedActivityRequestModel createFeedActivityRequestModel) {
        Intrinsics.checkNotNullParameter(createFeedActivityRequestModel, "");
        return new CreateFeedActivity.Params(createFeedActivityRequestModel.scheduleImpl, createFeedActivityRequestModel.getAuthRequestContext, createFeedActivityRequestModel.KClassImpl$Data$declaredNonStaticMembers$2, createFeedActivityRequestModel.BuiltInFictitiousFunctionClassFactory, createFeedActivityRequestModel.PlaceComponentResult, createFeedActivityRequestModel.MyBillsEntityDataFactory, createFeedActivityRequestModel.moveToNextValue);
    }
}
