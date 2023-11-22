package id.dana.social.mapper;

import id.dana.feeds.domain.reactions.model.ActivityReactions;
import id.dana.feeds.domain.reactions.model.ActivityReactionsUser;
import id.dana.feeds.ui.model.ActivityReactionsModel;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/domain/reactions/model/ActivityReactions;", "Lid/dana/feeds/ui/model/ActivityReactionsModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/domain/reactions/model/ActivityReactions;)Lid/dana/feeds/ui/model/ActivityReactionsModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionsModelMapperKt {
    public static final ActivityReactionsModel BuiltInFictitiousFunctionClassFactory(ActivityReactions activityReactions) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(activityReactions, "");
        String kind = activityReactions.getKind();
        List<ActivityReactionsUser> users = activityReactions.getUsers();
        if (users != null) {
            ArrayList arrayList2 = new ArrayList();
            for (ActivityReactionsUser activityReactionsUser : users) {
                ActivityReactionsUserModel activityReactionsUserModel = new ActivityReactionsUserModel(null, null, null, null, null, null, null, 127, null);
                activityReactionsUserModel.BuiltInFictitiousFunctionClassFactory = activityReactionsUser.getDisplayName();
                activityReactionsUserModel.getAuthRequestContext = activityReactionsUser.getPhoneNumber();
                activityReactionsUserModel.PlaceComponentResult = activityReactionsUser.getId();
                activityReactionsUserModel.MyBillsEntityDataFactory = activityReactionsUser.getNickName();
                activityReactionsUserModel.KClassImpl$Data$declaredNonStaticMembers$2 = activityReactionsUser.getKycStatus();
                activityReactionsUserModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = activityReactionsUser.getProfilePictureUrl();
                arrayList2.add(activityReactionsUserModel);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new ActivityReactionsModel(kind, arrayList, activityReactions.getMaxId(), activityReactions.getHasNext());
    }
}
