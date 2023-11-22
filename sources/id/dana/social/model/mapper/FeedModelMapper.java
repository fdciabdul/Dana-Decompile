package id.dana.social.model.mapper;

import android.content.Context;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import id.dana.feeds.domain.timeline.model.OwnReaction;
import id.dana.feeds.domain.timeline.model.ReactionCount;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.state.FeedCommentModelState;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.social.model.FeedModel;
import id.dana.social.model.OwnReactionModel;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\b\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\r\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0005\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0011\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a"}, d2 = {"Lid/dana/social/model/mapper/FeedModelMapper;", "", "Ljava/util/Date;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/util/Date;)Z", "", "p1", "", "p2", "Lkotlin/Function2;", "p3", "getAuthRequestContext", "(ILjava/util/Date;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/String;", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/social/model/FeedModel;", "PlaceComponentResult", "(Ljava/util/Date;Lid/dana/feeds/domain/timeline/model/ActivityResponse;)Lid/dana/social/model/FeedModel;", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Date;", "BuiltInFictitiousFunctionClassFactory", "Z", "Lid/dana/social/model/mapper/ReactionCountModelMapper;", "Lid/dana/social/model/mapper/ReactionCountModelMapper;", "<init>", "(Landroid/content/Context;Lid/dana/social/model/mapper/ReactionCountModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedModelMapper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    boolean MyBillsEntityDataFactory;
    private Date KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;
    private final ReactionCountModelMapper PlaceComponentResult;

    @Inject
    public FeedModelMapper(Context context, ReactionCountModelMapper reactionCountModelMapper) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(reactionCountModelMapper, "");
        this.getAuthRequestContext = context;
        this.PlaceComponentResult = reactionCountModelMapper;
    }

    public final FeedModel PlaceComponentResult(Date p0, ActivityResponse p1) {
        FeedCommentModel feedCommentModel;
        ActivityWidgetModel activityWidgetModel;
        FeedCommentModel authRequestContext;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        String id2 = p1.getId();
        String str = id2 == null ? "" : id2;
        String content = p1.getContent();
        long createdTime = p1.getCreatedTime();
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this, (int) DateTimeUtil.MyBillsEntityDataFactory(p0, new Date(p1.getCreatedTime())), p1.getCreatedTime());
        String iconUrl = p1.getIconUrl();
        boolean read = p1.getRead();
        HashMap<String, String> extendInfo = p1.getExtendInfo();
        String contentType = p1.getContentType();
        String activityId = p1.getActivityId();
        boolean ownActivity = p1.getOwnActivity();
        int commentCounts = p1.getCommentCounts();
        List<ReactionCount> reactionCounts = p1.getReactionCounts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reactionCounts, 10));
        Iterator<T> it = reactionCounts.iterator();
        while (it.hasNext()) {
            arrayList.add(ReactionCountModelMapper.getAuthRequestContext((ReactionCount) it.next(), p1.getOwnReactions()));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        List<OwnReaction> ownReactions = p1.getOwnReactions();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(ownReactions, 10));
        for (Iterator it2 = ownReactions.iterator(); it2.hasNext(); it2 = it2) {
            OwnReaction ownReaction = (OwnReaction) it2.next();
            arrayList2.add(new OwnReactionModel(ownReaction.getId(), ownReaction.getKind()));
        }
        List mutableList2 = CollectionsKt.toMutableList((Collection) arrayList2);
        String redirectType = p1.getRedirectType();
        String str2 = redirectType == null ? "" : redirectType;
        String redirectValue = p1.getRedirectValue();
        String str3 = redirectValue == null ? "" : redirectValue;
        String caption = p1.getCaption();
        String str4 = caption == null ? "" : caption;
        FeedActivityState state = p1.getState();
        MerchantImageModel.Companion companion = MerchantImageModel.INSTANCE;
        List<MerchantImageModel> authRequestContext2 = MerchantImageModel.Companion.getAuthRequestContext(p1);
        boolean isEmpty = p1.getOwnComment().isEmpty();
        Comment comment = (Comment) CollectionsKt.firstOrNull((List) p1.getLatestComments());
        if (comment != null) {
            FeedCommentModel.Companion companion2 = FeedCommentModel.INSTANCE;
            authRequestContext = FeedCommentModel.Companion.getAuthRequestContext(comment, FeedCommentModelState.SUCCESS);
            feedCommentModel = authRequestContext;
        } else {
            feedCommentModel = null;
        }
        ActivityWidget activityWidget = p1.getActivityWidget();
        if (activityWidget != null) {
            ActivityWidgetModel.Companion companion3 = ActivityWidgetModel.INSTANCE;
            String contentType2 = p1.getContentType();
            activityWidgetModel = ActivityWidgetModel.Companion.getAuthRequestContext(activityWidget, contentType2 != null ? contentType2 : "");
        } else {
            activityWidgetModel = null;
        }
        return new FeedModel(str, null, content, Long.valueOf(createdTime), BuiltInFictitiousFunctionClassFactory, iconUrl, read, extendInfo, contentType, activityId, ownActivity, commentCounts, mutableList, mutableList2, str2, str3, str4, state, activityWidgetModel, authRequestContext2, !isEmpty, feedCommentModel);
    }

    private static /* synthetic */ String BuiltInFictitiousFunctionClassFactory(FeedModelMapper feedModelMapper, int i, long j) {
        Intrinsics.checkNotNullParameter("dd MMMM", "");
        final Date date = new Date(j);
        String authRequestContext = feedModelMapper.getAuthRequestContext(i, date, "dd MMMM", new Function2<String, Date, String>() { // from class: id.dana.social.model.mapper.FeedModelMapper$getContentDate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, Date date2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(date2, "");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(DateTimeUtil.lookAheadTest(date));
                return sb.toString();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(authRequestContext);
        sb.append(", ");
        sb.append(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(new Date(j)));
        return sb.toString();
    }

    public final String getAuthRequestContext(int p0, Date p1, String p2, Function2<? super String, ? super Date, String> p3) {
        String string;
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (p0 == 0) {
            string = this.getAuthRequestContext.getString(R.string.feed_section_today);
        } else if (p0 == 1) {
            string = this.getAuthRequestContext.getString(R.string.feed_section_yesterday);
        } else {
            if (this.MyBillsEntityDataFactory) {
                p2 = "dd MMM";
            }
            string = DateTimeUtil.MyBillsEntityDataFactory(p1, p2);
        }
        if (MyBillsEntityDataFactory(p1)) {
            Intrinsics.checkNotNullExpressionValue(string, "");
            string = p3.invoke(string, p1);
        }
        return string == null ? "" : string;
    }

    private final boolean MyBillsEntityDataFactory(Date p0) {
        int lookAheadTest = DateTimeUtil.lookAheadTest(p0);
        Date date = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (date == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            date = null;
        }
        return lookAheadTest < DateTimeUtil.lookAheadTest(date);
    }
}
