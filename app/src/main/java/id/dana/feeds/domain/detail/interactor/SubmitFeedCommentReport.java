package id.dana.feeds.domain.detail.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/feeds/domain/detail/interactor/SubmitFeedCommentReport;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "", "Lid/dana/feeds/domain/detail/interactor/SubmitFeedCommentReport$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/tracker/MixpanelRepository;", "getAuthRequestContext", "Lid/dana/domain/tracker/MixpanelRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/detail/FeedsDetailRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubmitFeedCommentReport extends BaseUseCaseWithAnalytics<Boolean, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsDetailRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MixpanelRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.reportActivityComment";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(params.PlaceComponentResult, params.KClassImpl$Data$declaredNonStaticMembers$2, params.MyBillsEntityDataFactory);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SubmitFeedCommentReport(FeedsDetailRepository feedsDetailRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsDetailRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = feedsDetailRepository;
        this.MyBillsEntityDataFactory = mixpanelRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/detail/interactor/SubmitFeedCommentReport$Params;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public Params(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.MyBillsEntityDataFactory = str3;
        }
    }
}
