package id.dana.feeds.data.reaction;

import com.alibaba.fastjson.JSONObject;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.feeds.data.config.source.FeedsConfigDataFactory;
import id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData;
import id.dana.feeds.data.config.utils.DefaultFriendshipGenerator;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameForRelationshipItem$1;
import id.dana.feeds.data.reaction.source.FeedsReactionDataFactory;
import id.dana.feeds.data.reaction.source.network.NetworkReactionEntityData;
import id.dana.feeds.data.reaction.source.network.mapper.ActivityReactionsResultMapperKt;
import id.dana.feeds.data.reaction.source.network.response.ActivityReactionsResult;
import id.dana.feeds.data.reaction.source.network.response.ActivityReactionsUserResult;
import id.dana.feeds.data.reaction.source.network.response.AddActivityReactionResult;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import id.dana.feeds.domain.reactions.model.ActivityReactions;
import id.dana.feeds.domain.reactions.model.DeleteReactionResult;
import id.dana.feeds.domain.reactions.model.Reaction;
import id.dana.feeds.domain.reactions.model.ReactionResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u001a\u0012\u0006\u0010\u0006\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0007H\u0016¢\u0006\u0004\b\f\u0010\u0014R\u0014\u0010\u0012\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0014\u0010\u000f\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0014\u0010\f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001d"}, d2 = {"Lid/dana/feeds/data/reaction/FeedsReactionEntityRepository;", "Lid/dana/feeds/domain/reactions/FeedsReactionRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "p1", "p2", "Lio/reactivex/Observable;", "Lid/dana/feeds/domain/reactions/model/ReactionResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/reactions/model/DeleteReactionResult;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/reactions/model/ActivityReactions;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/feeds/domain/reactions/model/Reaction;", "getAuthRequestContext", "()Ljava/util/List;", "()Lio/reactivex/Observable;", "Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "Lid/dana/feeds/data/config/source/FeedsConfigDataFactory;", "Lid/dana/feeds/data/config/source/FeedsConfigDataFactory;", "PlaceComponentResult", "Lid/dana/feeds/data/reaction/source/FeedsReactionDataFactory;", "Lid/dana/feeds/data/reaction/source/FeedsReactionDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "p3", "<init>", "(Lid/dana/feeds/data/config/source/FeedsConfigDataFactory;Lid/dana/feeds/data/reaction/source/FeedsReactionDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsReactionEntityRepository implements FeedsReactionRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedsConfigDataFactory PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ContactDeviceNameMapper getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedsReactionDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public FeedsReactionEntityRepository(FeedsConfigDataFactory feedsConfigDataFactory, FeedsReactionDataFactory feedsReactionDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository, ContactDeviceNameMapper contactDeviceNameMapper) {
        Intrinsics.checkNotNullParameter(feedsConfigDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsReactionDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        Intrinsics.checkNotNullParameter(contactDeviceNameMapper, "");
        this.PlaceComponentResult = feedsConfigDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsReactionDataFactory;
        this.MyBillsEntityDataFactory = holdLoginV1EntityRepository;
        this.getAuthRequestContext = contactDeviceNameMapper;
    }

    @Override // id.dana.feeds.domain.reactions.FeedsReactionRepository
    public final List<Reaction> getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        DefaultFriendshipGenerator defaultFriendshipGenerator = DefaultFriendshipGenerator.INSTANCE;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        MapsKt.putAll(linkedHashMap, DefaultFriendshipGenerator.getAuthRequestContext());
        DefaultFriendshipGenerator defaultFriendshipGenerator2 = DefaultFriendshipGenerator.INSTANCE;
        for (String str : DefaultFriendshipGenerator.PlaceComponentResult()) {
            String str2 = (String) linkedHashMap.get(str);
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(new Reaction(str, str2));
        }
        return arrayList;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(new ActivityReactionsResult(null, null, null, false, 15, null));
    }

    public static /* synthetic */ ReactionResult KClassImpl$Data$declaredNonStaticMembers$2(AddActivityReactionResult addActivityReactionResult) {
        Intrinsics.checkNotNullParameter(addActivityReactionResult, "");
        String userId = addActivityReactionResult.getUserId();
        if (userId == null) {
            userId = "";
        }
        String activityId = addActivityReactionResult.getActivityId();
        if (activityId == null) {
            activityId = "";
        }
        String kind = addActivityReactionResult.getKind();
        return new ReactionResult(userId, activityId, kind != null ? kind : "");
    }

    public static /* synthetic */ DeleteReactionResult MyBillsEntityDataFactory(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        String str = baseRpcResult.errorMessage;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return new DeleteReactionResult(str);
    }

    public static /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject, List list) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        if (jSONObject.size() == list.size()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String string = jSONObject.getString(str);
                Intrinsics.checkNotNullExpressionValue(string, "");
                arrayList.add(new Reaction(str, string));
            }
        }
        return arrayList;
    }

    public static /* synthetic */ ActivityReactions getAuthRequestContext(FeedsReactionEntityRepository feedsReactionEntityRepository, ActivityReactionsResult activityReactionsResult) {
        Intrinsics.checkNotNullParameter(feedsReactionEntityRepository, "");
        Intrinsics.checkNotNullParameter(activityReactionsResult, "");
        List<ActivityReactionsUserResult> users = activityReactionsResult.getUsers();
        if (users != null) {
            ContactDeviceNameMapper contactDeviceNameMapper = feedsReactionEntityRepository.getAuthRequestContext;
            Intrinsics.checkNotNullParameter(users, "");
            ContactDeviceNameMapper.PlaceComponentResult(contactDeviceNameMapper, users, new ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameForRelationshipItem$1(contactDeviceNameMapper, users), null, 4);
        }
        return ActivityReactionsResultMapperKt.MyBillsEntityDataFactory(activityReactionsResult);
    }

    @Override // id.dana.feeds.domain.reactions.FeedsReactionRepository
    public final Observable<ReactionResult> BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        FeedsReactionDataFactory feedsReactionDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Observable map = new NetworkReactionEntityData(feedsReactionDataFactory.MyBillsEntityDataFactory, feedsReactionDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, feedsReactionDataFactory.BuiltInFictitiousFunctionClassFactory, feedsReactionDataFactory.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory(p0, p1, p2).map(new Function() { // from class: id.dana.feeds.data.reaction.FeedsReactionEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsReactionEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((AddActivityReactionResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.reactions.FeedsReactionRepository
    public final Observable<DeleteReactionResult> MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FeedsReactionDataFactory feedsReactionDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Observable map = new NetworkReactionEntityData(feedsReactionDataFactory.MyBillsEntityDataFactory, feedsReactionDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, feedsReactionDataFactory.BuiltInFictitiousFunctionClassFactory, feedsReactionDataFactory.getAuthRequestContext).PlaceComponentResult(p0, p1).map(new Function() { // from class: id.dana.feeds.data.reaction.FeedsReactionEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsReactionEntityRepository.MyBillsEntityDataFactory((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.reactions.FeedsReactionRepository
    public final Observable<ActivityReactions> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        FeedsReactionDataFactory feedsReactionDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Observable map = new NetworkReactionEntityData(feedsReactionDataFactory.MyBillsEntityDataFactory, feedsReactionDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, feedsReactionDataFactory.BuiltInFictitiousFunctionClassFactory, feedsReactionDataFactory.getAuthRequestContext).PlaceComponentResult(p0, p1, p2).onErrorResumeNext(new Function() { // from class: id.dana.feeds.data.reaction.FeedsReactionEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsReactionEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj);
            }
        }).map(new Function() { // from class: id.dana.feeds.data.reaction.FeedsReactionEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsReactionEntityRepository.getAuthRequestContext(FeedsReactionEntityRepository.this, (ActivityReactionsResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.reactions.FeedsReactionRepository
    public final Observable<List<Reaction>> MyBillsEntityDataFactory() {
        Observable zipWith = new SplitFeedsConfigEntityData(this.PlaceComponentResult.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory().zipWith(new SplitFeedsConfigEntityData(this.PlaceComponentResult.MyBillsEntityDataFactory).PlaceComponentResult(), new BiFunction() { // from class: id.dana.feeds.data.reaction.FeedsReactionEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return FeedsReactionEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((JSONObject) obj, (List) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }
}
