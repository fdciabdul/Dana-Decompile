package id.dana.feeds.domain.detail.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import id.dana.feeds.domain.detail.model.FeedCommentResult;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0013\u0012\u0014B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/feeds/domain/detail/interactor/GetFeedComment;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "Lid/dana/feeds/domain/detail/interactor/GetFeedComment$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/tracker/MixpanelRepository;", "PlaceComponentResult", "Lid/dana/domain/tracker/MixpanelRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/detail/FeedsDetailRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Companion", "CommentType", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFeedComment extends BaseUseCaseWithAnalytics<FeedCommentResult, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsDetailRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MixpanelRepository MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/feeds/domain/detail/interactor/GetFeedComment$CommentType;", "", "<init>", "(Ljava/lang/String;I)V", "FEED_PARENT_COMMENT", "FEED_SUB_COMMENT"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum CommentType {
        FEED_PARENT_COMMENT,
        FEED_SUB_COMMENT
    }

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.fetchActivityComments";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        if (params.BuiltInFictitiousFunctionClassFactory == CommentType.FEED_SUB_COMMENT) {
            params.getAuthRequestContext = 4;
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(params.MyBillsEntityDataFactory, params.PlaceComponentResult, params.KClassImpl$Data$declaredNonStaticMembers$2, params.getAuthRequestContext);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetFeedComment(FeedsDetailRepository feedsDetailRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsDetailRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsDetailRepository;
        this.MyBillsEntityDataFactory = mixpanelRepository;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\t\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/detail/interactor/GetFeedComment$Params;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/detail/interactor/GetFeedComment$CommentType;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/detail/interactor/GetFeedComment$CommentType;", "getAuthRequestContext", "PlaceComponentResult", "", "Ljava/lang/Integer;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lid/dana/feeds/domain/detail/interactor/GetFeedComment$CommentType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final CommentType BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        Integer getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String PlaceComponentResult;

        private Params(String str, String str2, String str3, Integer num, CommentType commentType) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(commentType, "");
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.PlaceComponentResult = str3;
            this.getAuthRequestContext = num;
            this.BuiltInFictitiousFunctionClassFactory = commentType;
        }

        public /* synthetic */ Params(String str, String str2, String str3, Integer num, CommentType commentType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : num, commentType);
        }
    }
}
