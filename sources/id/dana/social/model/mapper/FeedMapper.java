package id.dana.social.model.mapper;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import id.dana.feeds.domain.timeline.model.OwnReaction;
import id.dana.feeds.domain.timeline.model.ReactionCount;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.state.FeedCommentModelState;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.social.mapper.RecentFriendsShareFeedsMapperKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.OwnReactionModel;
import id.dana.social.model.ReactionCountModel;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001>B\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J&\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J&\u0010\u001e\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,H\u0002J \u0010.\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0018\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J<\u00101\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u00102\u001a\u00020\u000e2\u0018\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e04H\u0002J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J:\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t07H\u0002J\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u00109\u001a\u00020\u000eJ\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010;\u001a\u00020\u0018J\u001a\u0010<\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010=\u001a\u00020,H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006?"}, d2 = {"Lid/dana/social/model/mapper/FeedMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/social/model/FeedViewHolderModel;", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "isFeedRevamp", "", "()Z", "setFeedRevamp", "(Z)V", "<set-?>", "", "lastDateSection", "getLastDateSection", "()Ljava/lang/String;", "setLastDateSection", "(Ljava/lang/String;)V", "activityResponseToFriendModel", "Lid/dana/feeds/ui/model/FriendModel;", "activities", "addFeed", "", "feedViewModels", "", "activityResponse", "feedType", "", "addFeedWithoutDateSection", "apply", "oldItem", "applyWithoutDateSection", "checkIfFeedsIsPastYear", MaintenanceBroadcastResult.KEY_DATE, "Ljava/util/Date;", "composeDateAndYear", "calculatedDate", "generateFormattedReactionCounts", "Lid/dana/social/model/ReactionCountModel;", "getContentDate", "diffDay", "dateTime", "", "getDayDiff", "getFeedViewHolderModel", "getSectionFeed", "Lid/dana/social/model/FeedModel;", "getSectionText", "dateFormat", "composeDIfferentYear", "Lkotlin/Function2;", "map", "takeUntilFunction", "Lkotlin/Function1;", "mapLatestFeedByMinId", "minId", "mapWithoutDateSection", "resetLastDiffDay", "checkAndAddDateSection", "createdTime", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedMapper extends BaseMapper<List<? extends ActivityResponse>, List<? extends FeedViewHolderModel>> {
    public static final Companion getAuthRequestContext = new Companion(null);
    public String BuiltInFictitiousFunctionClassFactory;
    private final Context MyBillsEntityDataFactory;
    public boolean PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends FeedViewHolderModel> map(List<? extends ActivityResponse> list) {
        List<? extends ActivityResponse> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "");
        return BuiltInFictitiousFunctionClassFactory(list2, 9, FeedMapper$map$1.INSTANCE);
    }

    @Inject
    public FeedMapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    public final List<FeedViewHolderModel> BuiltInFictitiousFunctionClassFactory(List<ActivityResponse> list, int i, Function1<? super ActivityResponse, Boolean> function1) {
        ArrayList arrayList = new ArrayList();
        for (ActivityResponse activityResponse : list) {
            if (function1.invoke(activityResponse).booleanValue()) {
                break;
            }
            long MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(Companion.MyBillsEntityDataFactory(), new Date(activityResponse.getCreatedTime()));
            long createdTime = activityResponse.getCreatedTime();
            int MyBillsEntityDataFactory2 = (int) DateTimeUtil.MyBillsEntityDataFactory(Companion.MyBillsEntityDataFactory(), new Date(createdTime));
            if (MyBillsEntityDataFactory2 >= 0) {
                Date date = new Date(createdTime);
                FeedModel.Companion companion = FeedModel.INSTANCE;
                FeedModel KClassImpl$Data$declaredNonStaticMembers$2 = FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2, date, "dd MMMM", new FeedMapper$getSectionFeed$1(this)));
                String str = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4, this.BuiltInFictitiousFunctionClassFactory)) {
                    arrayList.add(new FeedViewHolderModel(1, KClassImpl$Data$declaredNonStaticMembers$2, null, null, null, false, 60, null));
                    String str2 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4;
                    if (str2 == null) {
                        str2 = "";
                    }
                    this.BuiltInFictitiousFunctionClassFactory = str2;
                }
            }
            arrayList.add(PlaceComponentResult(i, (int) MyBillsEntityDataFactory, activityResponse));
        }
        return arrayList;
    }

    private final FeedViewHolderModel PlaceComponentResult(int i, int i2, ActivityResponse activityResponse) {
        FeedCommentModel feedCommentModel;
        ActivityWidgetModel activityWidgetModel;
        FeedCommentModel authRequestContext;
        Object obj;
        String id2 = activityResponse.getId();
        String str = id2 == null ? "" : id2;
        String content = activityResponse.getContent();
        long createdTime = activityResponse.getCreatedTime();
        long createdTime2 = activityResponse.getCreatedTime();
        final Date date = new Date(createdTime2);
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i2, date, "dd MMMM", new Function2<String, Date, String>() { // from class: id.dana.social.model.mapper.FeedMapper$getContentDate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str2, Date date2) {
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(date2, "");
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(DateTimeUtil.lookAheadTest(date));
                return sb.toString();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(BuiltInFictitiousFunctionClassFactory);
        sb.append(", ");
        sb.append(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(new Date(createdTime2)));
        String obj2 = sb.toString();
        String iconUrl = activityResponse.getIconUrl();
        boolean read = activityResponse.getRead();
        HashMap<String, String> extendInfo = activityResponse.getExtendInfo();
        String contentType = activityResponse.getContentType();
        String activityId = activityResponse.getActivityId();
        boolean ownActivity = activityResponse.getOwnActivity();
        int commentCounts = activityResponse.getCommentCounts();
        List<ReactionCount> reactionCounts = activityResponse.getReactionCounts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reactionCounts, 10));
        Iterator it = reactionCounts.iterator();
        while (true) {
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            ReactionCount reactionCount = (ReactionCount) it.next();
            String kind = reactionCount.getKind();
            Iterator it2 = it;
            int count = reactionCount.getCount();
            int i3 = commentCounts;
            List<OwnReaction> ownReactions = activityResponse.getOwnReactions();
            boolean z = ownActivity;
            String str3 = contentType;
            String str4 = activityId;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(ownReactions, 10));
            Iterator<T> it3 = ownReactions.iterator();
            while (it3.hasNext()) {
                arrayList2.add(((OwnReaction) it3.next()).getKind());
            }
            boolean contains = arrayList2.contains(reactionCount.getKind());
            Iterator it4 = activityResponse.getOwnReactions().iterator();
            while (true) {
                if (!it4.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it4.next();
                Iterator it5 = it4;
                if (Intrinsics.areEqual(((OwnReaction) obj).getKind(), reactionCount.getKind())) {
                    break;
                }
                it4 = it5;
            }
            OwnReaction ownReaction = (OwnReaction) obj;
            if (ownReaction != null) {
                str2 = ownReaction.getId();
            }
            arrayList.add(new ReactionCountModel(kind, count, contains, str2));
            it = it2;
            ownActivity = z;
            commentCounts = i3;
            activityId = str4;
            contentType = str3;
        }
        String str5 = contentType;
        String str6 = activityId;
        boolean z2 = ownActivity;
        int i4 = commentCounts;
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        List<OwnReaction> ownReactions2 = activityResponse.getOwnReactions();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(ownReactions2, 10));
        for (OwnReaction ownReaction2 : ownReactions2) {
            arrayList3.add(new OwnReactionModel(ownReaction2.getId(), ownReaction2.getKind()));
        }
        List mutableList2 = CollectionsKt.toMutableList((Collection) arrayList3);
        String redirectType = activityResponse.getRedirectType();
        String str7 = redirectType == null ? "" : redirectType;
        String redirectValue = activityResponse.getRedirectValue();
        String str8 = redirectValue == null ? "" : redirectValue;
        String caption = activityResponse.getCaption();
        String str9 = caption == null ? "" : caption;
        FeedActivityState state = activityResponse.getState();
        MerchantImageModel.Companion companion = MerchantImageModel.INSTANCE;
        List<MerchantImageModel> authRequestContext2 = MerchantImageModel.Companion.getAuthRequestContext(activityResponse);
        boolean isEmpty = activityResponse.getOwnComment().isEmpty();
        Comment comment = (Comment) CollectionsKt.firstOrNull((List) activityResponse.getLatestComments());
        if (comment != null) {
            FeedCommentModel.Companion companion2 = FeedCommentModel.INSTANCE;
            authRequestContext = FeedCommentModel.Companion.getAuthRequestContext(comment, FeedCommentModelState.SUCCESS);
            feedCommentModel = authRequestContext;
        } else {
            feedCommentModel = null;
        }
        ActivityWidget activityWidget = activityResponse.getActivityWidget();
        if (activityWidget != null) {
            ActivityWidgetModel.Companion companion3 = ActivityWidgetModel.INSTANCE;
            String contentType2 = activityResponse.getContentType();
            if (contentType2 == null) {
                contentType2 = "";
            }
            activityWidgetModel = ActivityWidgetModel.Companion.getAuthRequestContext(activityWidget, contentType2);
        } else {
            activityWidgetModel = null;
        }
        return new FeedViewHolderModel(i, new FeedModel(str, null, content, Long.valueOf(createdTime), obj2, iconUrl, read, extendInfo, str5, str6, z2, i4, mutableList, mutableList2, str7, str8, str9, state, activityWidgetModel, authRequestContext2, !isEmpty, feedCommentModel), null, null, null, false, 60, null);
    }

    private final String BuiltInFictitiousFunctionClassFactory(int i, Date date, String str, Function2<? super String, ? super Date, String> function2) {
        String string;
        if (i == 0) {
            string = this.MyBillsEntityDataFactory.getString(R.string.feed_section_today);
        } else if (i == 1) {
            string = this.MyBillsEntityDataFactory.getString(R.string.feed_section_yesterday);
        } else {
            if (this.PlaceComponentResult) {
                str = "dd MMM";
            }
            string = DateTimeUtil.MyBillsEntityDataFactory(date, str);
        }
        if (MyBillsEntityDataFactory(date)) {
            Intrinsics.checkNotNullExpressionValue(string, "");
            string = function2.invoke(string, date);
        }
        return string == null ? "" : string;
    }

    private static boolean MyBillsEntityDataFactory(Date date) {
        return DateTimeUtil.lookAheadTest(date) < Companion.PlaceComponentResult(Companion.MyBillsEntityDataFactory()).get(1);
    }

    public static List<FriendModel> PlaceComponentResult(List<ActivityResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ActivityResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(RecentFriendsShareFeedsMapperKt.PlaceComponentResult((ActivityResponse) it.next()));
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/social/model/mapper/FeedMapper$Companion;", "", "Ljava/util/Date;", "MyBillsEntityDataFactory", "()Ljava/util/Date;", "Ljava/util/Calendar;", "PlaceComponentResult", "(Ljava/util/Date;)Ljava/util/Calendar;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Date MyBillsEntityDataFactory() {
            return new Date();
        }

        public static Calendar PlaceComponentResult(Date date) {
            Intrinsics.checkNotNullParameter(date, "");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Intrinsics.checkNotNullExpressionValue(calendar, "");
            return calendar;
        }
    }

    public static final /* synthetic */ String getAuthRequestContext(FeedMapper feedMapper, String str, Date date) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(date));
        return sb.toString();
    }

    public final List<FeedViewHolderModel> MyBillsEntityDataFactory(List<ActivityResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (ActivityResponse activityResponse : list) {
            arrayList.add(PlaceComponentResult(9, (int) DateTimeUtil.MyBillsEntityDataFactory(Companion.MyBillsEntityDataFactory(), new Date(activityResponse.getCreatedTime())), activityResponse));
        }
        return arrayList;
    }
}
