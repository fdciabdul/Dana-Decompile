package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/feeds/domain/share/interactor/GetPreviewActivity;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "Lid/dana/feeds/domain/share/interactor/GetPreviewActivity$Params;", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;Lid/dana/feeds/domain/config/FeedsConfigRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetPreviewActivity extends BaseUseCase<PreviewActivityData, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedsShareRepository getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsConfigRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<PreviewActivityData> buildUseCase(Params params) {
        final Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        Observable flatMap = this.PlaceComponentResult.PlaceComponentResult().flatMap(new Function() { // from class: id.dana.feeds.domain.share.interactor.GetPreviewActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetPreviewActivity.PlaceComponentResult(GetPreviewActivity.this, params2, (FeedConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public GetPreviewActivity(FeedsShareRepository feedsShareRepository, FeedsConfigRepository feedsConfigRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        Intrinsics.checkNotNullParameter(feedsConfigRepository, "");
        this.getAuthRequestContext = feedsShareRepository;
        this.PlaceComponentResult = feedsConfigRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0011\u0010\n\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/share/interactor/GetPreviewActivity$Params;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static class Params {
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        Map<String, ? extends Object> MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        String PlaceComponentResult;

        public Params(String str, String str2, String str3, Map<String, ? extends Object> map, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(map, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = str2;
            this.getAuthRequestContext = str3;
            this.MyBillsEntityDataFactory = map;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        }

        public /* synthetic */ Params(String str, String str2, String str3, Map map, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? null : str4);
        }
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetPreviewActivity getPreviewActivity, Params params, FeedConfig feedConfig) {
        Observable<PreviewActivityData> just;
        Intrinsics.checkNotNullParameter(getPreviewActivity, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(feedConfig, "");
        if (feedConfig.isCreateActivityEnabled() && feedConfig.getShareActivity().getPaymentSuccess()) {
            just = getPreviewActivity.getAuthRequestContext.getAuthRequestContext(params.BuiltInFictitiousFunctionClassFactory, params.PlaceComponentResult, params.getAuthRequestContext, params.MyBillsEntityDataFactory, feedConfig.getFeedVersion(), params.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            just = Observable.just(new PreviewActivityData(false, "", "", "", new HashMap(), "", false, null, 192, null));
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }
}
