package id.dana.feeds.data.reaction.source.network.mapper;

import id.dana.feeds.data.reaction.source.network.response.ActivityReactionsResult;
import id.dana.feeds.data.reaction.source.network.response.ActivityReactionsUserResult;
import id.dana.feeds.domain.reactions.model.ActivityReactions;
import id.dana.feeds.domain.reactions.model.ActivityReactionsUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsResult;", "Lid/dana/feeds/domain/reactions/model/ActivityReactions;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsResult;)Lid/dana/feeds/domain/reactions/model/ActivityReactions;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionsResultMapperKt {
    public static final ActivityReactions MyBillsEntityDataFactory(ActivityReactionsResult activityReactionsResult) {
        String str;
        ArrayList arrayList;
        String str2 = "";
        Intrinsics.checkNotNullParameter(activityReactionsResult, "");
        String kind = activityReactionsResult.getKind();
        List<ActivityReactionsUserResult> users = activityReactionsResult.getUsers();
        if (users != null) {
            ArrayList arrayList2 = new ArrayList();
            for (ActivityReactionsUserResult activityReactionsUserResult : users) {
                ActivityReactionsUser activityReactionsUser = new ActivityReactionsUser(null, null, null, null, null, null, null, 127, null);
                activityReactionsUser.setDisplayName(activityReactionsUserResult.getDisplayName());
                activityReactionsUser.setPhoneNumber(activityReactionsUserResult.getPhoneNumber());
                activityReactionsUser.setId(activityReactionsUserResult.getId());
                activityReactionsUser.setNickName(activityReactionsUserResult.getNickName());
                activityReactionsUser.setKycStatus(activityReactionsUserResult.getKycStatus());
                activityReactionsUser.setProfilePictureUrl(activityReactionsUserResult.getProfilePictureUrl());
                activityReactionsUser.setUsername(activityReactionsUserResult.getUsername());
                arrayList2.add(activityReactionsUser);
                str2 = str2;
            }
            str = str2;
            arrayList = arrayList2;
        } else {
            str = "";
            arrayList = null;
        }
        String maxId = activityReactionsResult.getMaxId();
        if (maxId == null) {
            maxId = str;
        }
        return new ActivityReactions(kind, arrayList, maxId, activityReactionsResult.getHasNext());
    }
}
