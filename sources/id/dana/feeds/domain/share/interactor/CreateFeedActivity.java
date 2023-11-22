package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import io.reactivex.Observable;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/feeds/domain/share/interactor/CreateFeedActivity;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/tracker/MixpanelRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/tracker/MixpanelRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "PlaceComponentResult", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateFeedActivity extends BaseUseCaseWithAnalytics<ActivityResponse, Params> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MixpanelRepository MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedsShareRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.createActivity";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(params);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public CreateFeedActivity(FeedsShareRepository feedsShareRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.PlaceComponentResult = feedsShareRepository;
        this.MyBillsEntityDataFactory = mixpanelRepository;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012,\b\u0002\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R5\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\nX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0011\u0010\r\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "lookAheadTest", "moveToNextValue", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "scheduleImpl", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lid/dana/feeds/domain/timeline/model/ActivityWidget;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final HashMap<String, String> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public final String moveToNextValue;
        public final ActivityWidget scheduleImpl;

        public Params(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, ActivityWidget activityWidget) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.moveToNextValue = str;
            this.getAuthRequestContext = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.MyBillsEntityDataFactory = str4;
            this.PlaceComponentResult = str5;
            this.BuiltInFictitiousFunctionClassFactory = hashMap;
            this.scheduleImpl = activityWidget;
        }
    }
}
