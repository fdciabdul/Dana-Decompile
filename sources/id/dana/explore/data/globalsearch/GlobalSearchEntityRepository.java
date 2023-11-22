package id.dana.explore.data.globalsearch;

import android.content.Context;
import android.location.Location;
import com.alipay.mobile.map.model.MapConstant;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.danah5.DanaH5;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.content.SpaceCode;
import id.dana.data.content.mapper.ContentsMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.services.repository.ServicesEntityRepository;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.util.SingleShotLocationProvider;
import id.dana.explore.constants.ExploreTrackerEvent;
import id.dana.explore.data.globalsearch.mapper.ProductBizMapperKt;
import id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse;
import id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponseKt;
import id.dana.explore.data.globalsearch.model.PopularSearchCache;
import id.dana.explore.data.globalsearch.source.GlobalSearchCacheEntityDataFactory;
import id.dana.explore.data.globalsearch.source.GlobalSearchEntityDataFactory;
import id.dana.explore.data.globalsearch.source.GlobalSearchPreferenceCacheEntityData;
import id.dana.explore.data.globalsearch.source.local.PreferenceLocationPermissionSuggestionEntityData;
import id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData;
import id.dana.explore.data.globalsearch.source.network.request.AutoCompleteRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.RecommendationExploreRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.SearchConditionEntity;
import id.dana.explore.data.globalsearch.source.network.request.SearchConditionEntityKt;
import id.dana.explore.data.globalsearch.source.network.request.SearchRequestEntity;
import id.dana.explore.data.globalsearch.source.network.request.SortEntity;
import id.dana.explore.data.globalsearch.source.network.result.AutoCompleteResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.HistoricalSkuResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.PaginatorEntity;
import id.dana.explore.data.globalsearch.source.network.result.PaySearchInfoEntity;
import id.dana.explore.data.globalsearch.source.network.result.ProductBizIdEntity;
import id.dana.explore.data.globalsearch.source.network.result.SearchResultEntity;
import id.dana.explore.data.globalsearch.source.network.result.TrendingSearchInfoEntity;
import id.dana.explore.data.globalsearch.source.network.result.TrendingSearchResultEntity;
import id.dana.explore.data.sku.repository.source.network.response.ProductMappingEntityResult;
import id.dana.explore.data.toggle.ExploreConfigEntityData;
import id.dana.explore.data.toggle.source.ExploreConfigEntityDataFactory;
import id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData;
import id.dana.explore.data.tracker.GlobalSearchMixpanelTracker;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.enums.RecommendationCategory;
import id.dana.explore.domain.globalsearch.model.AutoCompleteResult;
import id.dana.explore.domain.globalsearch.model.GlobalSearchCategory;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.explore.domain.globalsearch.model.Paginator;
import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.explore.domain.globalsearch.model.SearchCondition;
import id.dana.explore.domain.globalsearch.model.SearchResultResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZBY\b\u0007\u0012\u0006\u0010\b\u001a\u00020<\u0012\u0006\u0010\n\u001a\u00020A\u0012\u0006\u0010\u000b\u001a\u000206\u0012\u0006\u0010!\u001a\u00020>\u0012\u0006\u0010#\u001a\u00020N\u0012\u0006\u0010$\u001a\u00020J\u0012\u0006\u0010T\u001a\u000208\u0012\u0006\u0010U\u001a\u00020:\u0012\u0006\u0010V\u001a\u00020C\u0012\u0006\u0010W\u001a\u00020F¢\u0006\u0004\bX\u0010YJ\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J1\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J1\u0010\u001c\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a`\u001b0\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0007J3\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u0011\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u0016¢\u0006\u0004\b \u0010\u0007JU\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00040\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u0016¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010'J\u0019\u0010\u0018\u001a\u00020)2\b\u0010\b\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b\u0018\u0010*J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020+0\u0004¢\u0006\u0004\b\u0011\u0010,J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020-2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010.J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020/0\u00032\u0006\u0010\b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u00100J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u00101J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020/0\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\r\u00102J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\r\u00100R\u001e\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020403X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u00105R\u0014\u0010\u001c\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00107R\u0014\u0010\r\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00109R\u0014\u0010\u0013\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010;R\u0014\u0010\u0011\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010\u0006\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010BR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010DR\u0014\u0010 \u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010GR\u001e\u0010&\u001a\u00020H2\u0006\u0010\b\u001a\u00020H8\u0002@BX\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010IR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00100\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0007R\u0013\u0010K\u001a\u00020RX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bM\u0010S"}, d2 = {"Lid/dana/explore/data/globalsearch/GlobalSearchEntityRepository;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Observable;", "", "", "scheduleImpl", "()Lio/reactivex/Observable;", "p0", "", "p1", "p2", "Lid/dana/explore/domain/globalsearch/model/AutoCompleteResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "", "MyBillsEntityDataFactory", "Lid/dana/domain/globalsearch/model/ProductBizId;", "getAuthRequestContext", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/explore/domain/globalsearch/model/SearchCondition;", "Lid/dana/explore/domain/globalsearch/model/SearchResultResponse;", "(Ljava/util/List;II)Lio/reactivex/Observable;", "PlaceComponentResult", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/globalsearch/enums/RecommendationCategory;", "Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "(Lid/dana/explore/domain/globalsearch/enums/RecommendationCategory;)Lio/reactivex/Observable;", "getErrorConfigVersion", "p3", "Landroid/location/Location;", "p4", "p5", "(Ljava/lang/String;IILjava/util/List;Landroid/location/Location;Ljava/lang/String;)Lio/reactivex/Observable;", "lookAheadTest", "(Ljava/lang/String;)Z", "Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "Lid/dana/explore/domain/globalsearch/model/Paginator;", "(Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;)Lid/dana/explore/domain/globalsearch/model/Paginator;", "Lid/dana/explore/data/globalsearch/source/network/result/PaySearchInfoEntity;", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/explore/data/globalsearch/model/PopularSearchCache;", "(Lid/dana/explore/data/globalsearch/model/PopularSearchCache;I)Lio/reactivex/Observable;", "", "(Z)Lio/reactivex/Observable;", "(JILjava/util/List;)Lio/reactivex/Observable;", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchCategory;", "Ljava/util/Map;", "Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;", "Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/data/content/mapper/ContentsMapper;", "Lid/dana/data/content/mapper/ContentsMapper;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/explore/data/globalsearch/source/GlobalSearchCacheEntityDataFactory;", "moveToNextValue", "Lid/dana/explore/data/globalsearch/source/GlobalSearchCacheEntityDataFactory;", "Lid/dana/explore/data/globalsearch/source/GlobalSearchEntityDataFactory;", "Lid/dana/explore/data/globalsearch/source/GlobalSearchEntityDataFactory;", "Lid/dana/explore/data/tracker/GlobalSearchMixpanelTracker;", "Lid/dana/explore/data/tracker/GlobalSearchMixpanelTracker;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/domain/globalsearch/model/LatLng;", "Lid/dana/domain/globalsearch/model/LatLng;", "Lid/dana/explore/data/globalsearch/source/local/PreferenceLocationPermissionSuggestionEntityData;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/explore/data/globalsearch/source/local/PreferenceLocationPermissionSuggestionEntityData;", "initRecordTimeStamp", "Lid/dana/data/services/repository/ServicesEntityRepository;", "DatabaseTableConfigUtil", "Lid/dana/data/services/repository/ServicesEntityRepository;", "GetContactSyncConfig", "Lid/dana/explore/data/toggle/ExploreConfigEntityData;", "Lkotlin/Lazy;", "p6", "p7", "p8", "p9", "<init>", "(Landroid/content/Context;Lid/dana/explore/data/globalsearch/source/GlobalSearchEntityDataFactory;Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;Lid/dana/explore/data/globalsearch/source/GlobalSearchCacheEntityDataFactory;Lid/dana/data/services/repository/ServicesEntityRepository;Lid/dana/explore/data/globalsearch/source/local/PreferenceLocationPermissionSuggestionEntityData;Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;Lid/dana/data/content/mapper/ContentsMapper;Lid/dana/explore/data/tracker/GlobalSearchMixpanelTracker;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSearchEntityRepository implements GlobalSearchRepository, HoldLoginV1Repository {
    private final ContentDeliveryEntityDataFactory BuiltInFictitiousFunctionClassFactory;
    private final ServicesEntityRepository DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ContentsMapper getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private LatLng lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final PreferenceLocationPermissionSuggestionEntityData initRecordTimeStamp;
    public Map<String, GlobalSearchCategory> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ExploreConfigEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GlobalSearchEntityDataFactory scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GlobalSearchMixpanelTracker NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GlobalSearchCacheEntityDataFactory moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository getErrorConfigVersion;

    @Inject
    public GlobalSearchEntityRepository(Context context, GlobalSearchEntityDataFactory globalSearchEntityDataFactory, ExploreConfigEntityDataFactory exploreConfigEntityDataFactory, GlobalSearchCacheEntityDataFactory globalSearchCacheEntityDataFactory, ServicesEntityRepository servicesEntityRepository, PreferenceLocationPermissionSuggestionEntityData preferenceLocationPermissionSuggestionEntityData, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ContentsMapper contentsMapper, GlobalSearchMixpanelTracker globalSearchMixpanelTracker, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(globalSearchEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(exploreConfigEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(globalSearchCacheEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(preferenceLocationPermissionSuggestionEntityData, "");
        Intrinsics.checkNotNullParameter(contentDeliveryEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(contentsMapper, "");
        Intrinsics.checkNotNullParameter(globalSearchMixpanelTracker, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = context;
        this.scheduleImpl = globalSearchEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = exploreConfigEntityDataFactory;
        this.moveToNextValue = globalSearchCacheEntityDataFactory;
        this.DatabaseTableConfigUtil = servicesEntityRepository;
        this.initRecordTimeStamp = preferenceLocationPermissionSuggestionEntityData;
        this.BuiltInFictitiousFunctionClassFactory = contentDeliveryEntityDataFactory;
        this.getAuthRequestContext = contentsMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = globalSearchMixpanelTracker;
        this.getErrorConfigVersion = holdLoginV1EntityRepository;
        this.lookAheadTest = new LatLng(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 3, null);
        this.PlaceComponentResult = MapsKt.emptyMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = LazyKt.lazy(new Function0<ExploreConfigEntityData>() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$splitExploreEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExploreConfigEntityData invoke() {
                ExploreConfigEntityDataFactory exploreConfigEntityDataFactory2;
                exploreConfigEntityDataFactory2 = GlobalSearchEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter("split", "");
                SplitExploreConfigEntityData splitExploreConfigEntityData = exploreConfigEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get();
                Intrinsics.checkNotNullExpressionValue(splitExploreConfigEntityData, "");
                return splitExploreConfigEntityData;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Paginator PlaceComponentResult(PaginatorEntity p0) {
        return new Paginator(p0 != null ? p0.getOffset() : null, p0 != null ? p0.getPageNum() : null, p0 != null ? p0.getTotalCount() : null, p0 != null ? p0.getTotalPage() : null, p0 != null ? p0.getPageSize() : null);
    }

    private static List<PaySearchInfo> MyBillsEntityDataFactory(List<PaySearchInfoEntity> p0) {
        Iterator it;
        String str;
        LatLng latLng;
        String str2 = "";
        Intrinsics.checkNotNullParameter(p0, "");
        List<PaySearchInfoEntity> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            PaySearchInfoEntity paySearchInfoEntity = (PaySearchInfoEntity) it2.next();
            String address = paySearchInfoEntity.getAddress();
            String str3 = address == null ? str2 : address;
            String category = paySearchInfoEntity.getCategory();
            String str4 = category == null ? str2 : category;
            String description = paySearchInfoEntity.getDescription();
            String str5 = description == null ? str2 : description;
            String id2 = paySearchInfoEntity.getId();
            String str6 = id2 == null ? str2 : id2;
            Map<String, String> info = paySearchInfoEntity.getInfo();
            if (info == null) {
                info = MapsKt.emptyMap();
            }
            Map<String, String> map = info;
            String infoType = paySearchInfoEntity.getInfoType();
            String str7 = infoType == null ? str2 : infoType;
            String logo = paySearchInfoEntity.getLogo();
            String str8 = logo == null ? str2 : logo;
            List<String> mcc = paySearchInfoEntity.getMcc();
            if (mcc == null) {
                mcc = CollectionsKt.emptyList();
            }
            List<String> list2 = mcc;
            String name = paySearchInfoEntity.getName();
            String str9 = name == null ? str2 : name;
            Double rating = paySearchInfoEntity.getRating();
            double doubleValue = rating != null ? rating.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            Integer score = paySearchInfoEntity.getScore();
            int intValue = score != null ? score.intValue() : 0;
            String subCategory = paySearchInfoEntity.getSubCategory();
            String str10 = subCategory == null ? str2 : subCategory;
            String tag = paySearchInfoEntity.getTag();
            String str11 = tag == null ? str2 : tag;
            Map<String, String> url = paySearchInfoEntity.getUrl();
            Map<String, String> location = paySearchInfoEntity.getLocation();
            if (location != null) {
                it = it2;
                str = str2;
                latLng = new LatLng(location.get("lat"), location.get(MapConstant.EXTRA_LON));
            } else {
                it = it2;
                str = str2;
                latLng = null;
            }
            Boolean trendingFlag = paySearchInfoEntity.getTrendingFlag();
            boolean booleanValue = trendingFlag != null ? trendingFlag.booleanValue() : false;
            Boolean newFlag = paySearchInfoEntity.getNewFlag();
            arrayList.add(new PaySearchInfo(str6, str9, list2, str4, str10, url, str8, str11, str5, intValue, doubleValue, str3, str7, latLng, null, map, booleanValue, newFlag != null ? newFlag.booleanValue() : false, 16384, null));
            it2 = it;
            str2 = str;
        }
        return arrayList;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<List<SearchResultResponse>> getAuthRequestContext(final String p0, final int p1, final int p2, final List<String> p3, final Location p4, final String p5) {
        Observable just;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (this.PlaceComponentResult.isEmpty()) {
            just = ((ExploreConfigEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GlobalSearchEntityRepository.PlaceComponentResult(GlobalSearchEntityRepository.this, (Map) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            just = Observable.just(this.PlaceComponentResult);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        Observable<List<SearchResultResponse>> subscribeOn = just.flatMap(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.getAuthRequestContext(GlobalSearchEntityRepository.this, p4, p3, p0, booleanRef, p5, p1, p2, (Map) obj);
            }
        }).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.BuiltInFictitiousFunctionClassFactory((List) obj);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }

    private final Observable<String> getAuthRequestContext(PopularSearchCache p0, int p1) {
        PlaceComponentResult(p0.getLastFetchDate(), p1 + 1, p0.getPopularSearch());
        Observable<String> just = Observable.just(p0.getPopularSearch().get(p1));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<Unit> MyBillsEntityDataFactory(final boolean p0) {
        final PreferenceLocationPermissionSuggestionEntityData preferenceLocationPermissionSuggestionEntityData = this.initRecordTimeStamp;
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.explore.data.globalsearch.source.local.PreferenceLocationPermissionSuggestionEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceLocationPermissionSuggestionEntityData.getAuthRequestContext(PreferenceLocationPermissionSuggestionEntityData.this, p0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    public final Observable<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        final PreferenceLocationPermissionSuggestionEntityData preferenceLocationPermissionSuggestionEntityData = this.initRecordTimeStamp;
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.explore.data.globalsearch.source.local.PreferenceLocationPermissionSuggestionEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceLocationPermissionSuggestionEntityData.getAuthRequestContext(PreferenceLocationPermissionSuggestionEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<SearchResultResponse> MyBillsEntityDataFactory(List<SearchCondition> p0, int p1, int p2) {
        List mutableListOf = CollectionsKt.mutableListOf(new SearchConditionEntity("CATEGORY", CollectionsKt.listOf("ONLINE_MERCHANT")));
        if (p0 != null) {
            mutableListOf.addAll(SearchConditionEntityKt.toSearchConditionEntity(p0));
        }
        NetworkGlobalSearchEntityData networkGlobalSearchEntityData = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        Integer valueOf = Integer.valueOf(p1);
        Integer valueOf2 = Integer.valueOf(p2);
        ?? r14 = 0;
        Observable map = networkGlobalSearchEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new SearchRequestEntity(mutableListOf, valueOf, valueOf2, new SortEntity(r14, r14, 3, r14), null, 16, null)).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.PlaceComponentResult(GlobalSearchEntityRepository.this, (SearchResultEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchEntityRepository globalSearchEntityRepository, SearchResultEntity searchResultEntity) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(searchResultEntity, "");
        return MyBillsEntityDataFactory(searchResultEntity.getSearchResultList());
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final GlobalSearchEntityRepository globalSearchEntityRepository, PopularSearchCache popularSearchCache) {
        Observable<String> subscribeOn;
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(popularSearchCache, "");
        if (popularSearchCache.getLastFetchDate() == -1 || DateTimeUtil.isPastToday(popularSearchCache.getLastFetchDate())) {
            subscribeOn = globalSearchEntityRepository.scheduleImpl().flatMap(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GlobalSearchEntityRepository.getAuthRequestContext(GlobalSearchEntityRepository.this, (List) obj);
                }
            }).subscribeOn(Schedulers.MyBillsEntityDataFactory());
        } else if (popularSearchCache.getLastIndex() >= popularSearchCache.getPopularSearch().size()) {
            subscribeOn = globalSearchEntityRepository.getAuthRequestContext(popularSearchCache, 0);
        } else {
            subscribeOn = globalSearchEntityRepository.getAuthRequestContext(popularSearchCache, popularSearchCache.getLastIndex());
        }
        return subscribeOn;
    }

    public static /* synthetic */ SearchResultEntity PlaceComponentResult(GlobalSearchEntityRepository globalSearchEntityRepository, SearchResultEntity searchResultEntity, List list) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(searchResultEntity, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ThirdPartyServiceResponse) obj).isEnable()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ThirdPartyServiceResponse) it.next()).getKey());
        }
        ArrayList arrayList4 = arrayList3;
        List<PaySearchInfoEntity> searchResultList = searchResultEntity.getSearchResultList();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : searchResultList) {
            ArrayList arrayList6 = arrayList4;
            Map<String, String> info = ((PaySearchInfoEntity) obj2).getInfo();
            if (CollectionsKt.contains(arrayList6, info != null ? info.get(DanaH5.SERVICE_KEY) : null)) {
                arrayList5.add(obj2);
            }
        }
        return searchResultEntity;
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(HistoricalSkuResultEntity historicalSkuResultEntity) {
        Intrinsics.checkNotNullParameter(historicalSkuResultEntity, "");
        return historicalSkuResultEntity.getBizIds();
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(GlobalSearchEntityRepository globalSearchEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        globalSearchEntityRepository.PlaceComponentResult(System.currentTimeMillis(), 1, list).blockingFirst();
        return Observable.just(list.get(0));
    }

    public static /* synthetic */ SearchResultResponse MyBillsEntityDataFactory(GlobalSearchEntityRepository globalSearchEntityRepository, boolean z, SearchResultEntity searchResultEntity) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(searchResultEntity, "");
        return new SearchResultResponse(MyBillsEntityDataFactory(searchResultEntity.getSearchResultList()), PlaceComponentResult(searchResultEntity.getPaginator()), z);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(GlobalSearchEntityRepository globalSearchEntityRepository, Throwable th) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(th, "");
        return globalSearchEntityRepository.scheduleImpl();
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(GlobalSearchEntityRepository globalSearchEntityRepository, List list, LatLng latLng) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(latLng, "");
        globalSearchEntityRepository.lookAheadTest = latLng;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List<PaySearchInfo> searchResultList = ((SearchResultResponse) it.next()).getSearchResultList();
            if (searchResultList != null) {
                Iterator<T> it2 = searchResultList.iterator();
                while (it2.hasNext()) {
                    ((PaySearchInfo) it2.next()).setUserLocation(latLng);
                }
            }
        }
        return list;
    }

    public static /* synthetic */ GlobalSearchConfig KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchConfigResponse globalSearchConfigResponse) {
        Intrinsics.checkNotNullParameter(globalSearchConfigResponse, "");
        return GlobalSearchConfigResponseKt.toGlobalSearchConfig(globalSearchConfigResponse);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchEntityRepository globalSearchEntityRepository, TrendingSearchResultEntity trendingSearchResultEntity) {
        Observable<List<String>> just;
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(trendingSearchResultEntity, "");
        List<TrendingSearchInfoEntity> searchResultList = trendingSearchResultEntity.getSearchResultList();
        if (searchResultList == null || searchResultList.isEmpty()) {
            just = globalSearchEntityRepository.scheduleImpl();
        } else {
            List<String> PlaceComponentResult = globalSearchEntityRepository.moveToNextValue.PlaceComponentResult.PlaceComponentResult();
            List<TrendingSearchInfoEntity> searchResultList2 = trendingSearchResultEntity.getSearchResultList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(searchResultList2, 10));
            Iterator<T> it = searchResultList2.iterator();
            while (it.hasNext()) {
                String keyword = ((TrendingSearchInfoEntity) it.next()).getKeyword();
                if (keyword == null) {
                    keyword = "";
                }
                arrayList.add(keyword);
            }
            ArrayList arrayList2 = arrayList;
            if (!Intrinsics.areEqual(PlaceComponentResult, arrayList2) && (!arrayList2.isEmpty()) != false) {
                GlobalSearchMixpanelTracker globalSearchMixpanelTracker = globalSearchEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullParameter(arrayList2, "");
                Context context = globalSearchMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TrackerDataKey.Property.KEYWORD_LIST, CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null));
                Unit unit = Unit.INSTANCE;
                MixPanelDataTracker.PlaceComponentResult(context, ExploreTrackerEvent.GLOBAL_SEARCH_TRENDING_KEYWORD, jSONObject);
                globalSearchEntityRepository.moveToNextValue.PlaceComponentResult.getAuthRequestContext(arrayList2);
            }
            List<TrendingSearchInfoEntity> searchResultList3 = trendingSearchResultEntity.getSearchResultList();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(searchResultList3, 10));
            Iterator<T> it2 = searchResultList3.iterator();
            while (it2.hasNext()) {
                String keyword2 = ((TrendingSearchInfoEntity) it2.next()).getKeyword();
                if (keyword2 == null) {
                    keyword2 = "";
                }
                arrayList3.add(keyword2);
            }
            just = Observable.just(arrayList3);
        }
        return just;
    }

    public static /* synthetic */ String PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        CdpContent cdpContent = (CdpContent) CollectionsKt.getOrNull(list, 0);
        String contentValue = cdpContent != null ? cdpContent.getContentValue() : null;
        return contentValue == null ? "" : contentValue;
    }

    public static /* synthetic */ List PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (str.length() > 2) {
            String substring = str.substring(1, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            List split$default = StringsKt.split$default((CharSequence) substring, new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((CharSequence) ((String) it.next())).toString());
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list, Map map) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(map, "");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ProductBizIdEntity productBizIdEntity = (ProductBizIdEntity) it.next();
            ProductMappingEntityResult productMappingEntityResult = (ProductMappingEntityResult) map.get(productBizIdEntity.getProfileKey());
            if (productMappingEntityResult == null || (str = productMappingEntityResult.getProductCode()) == null) {
                str = "";
            }
            productBizIdEntity.setProductCode(str);
            ProductMappingEntityResult productMappingEntityResult2 = (ProductMappingEntityResult) map.get(productBizIdEntity.getProfileKey());
            if (productMappingEntityResult2 == null || (str2 = productMappingEntityResult2.getProductDesc()) == null) {
                str2 = "";
            }
            productBizIdEntity.setProductDesc(str2);
        }
        return CollectionsKt.sortedWith(ProductBizMapperKt.PlaceComponentResult(list), new Comparator() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$getHistoricalSku$lambda-36$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ProductBizId) t).getTransactionDate(), ((ProductBizId) t2).getTransactionDate());
            }
        });
    }

    public static /* synthetic */ List getAuthRequestContext(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.explore.domain.globalsearch.model.SearchResultResponse");
            }
            arrayList.add((SearchResultResponse) obj);
        }
        return arrayList;
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            List<PaySearchInfo> searchResultList = ((SearchResultResponse) obj).getSearchResultList();
            if ((!(searchResultList == null || searchResultList.isEmpty())) != false) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ Map PlaceComponentResult(GlobalSearchEntityRepository globalSearchEntityRepository, Map map) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(map, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (((GlobalSearchCategory) entry.getValue()).getEnable()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        globalSearchEntityRepository.PlaceComponentResult = linkedHashMap2;
        return linkedHashMap2;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final GlobalSearchEntityRepository globalSearchEntityRepository, String str, final SearchResultEntity searchResultEntity) {
        Observable just;
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(searchResultEntity, "");
        if (Intrinsics.areEqual(str, "SERVICE")) {
            just = globalSearchEntityRepository.DatabaseTableConfigUtil.getRawServices().map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda18
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GlobalSearchEntityRepository.PlaceComponentResult(GlobalSearchEntityRepository.this, searchResultEntity, (List) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            just = Observable.just(searchResultEntity);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(int i, int i2, RecommendationCategory recommendationCategory, GlobalSearchEntityRepository globalSearchEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(recommendationCategory, "");
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return globalSearchEntityRepository.scheduleImpl.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(new RecommendationExploreRequestEntity(i, i2, str, recommendationCategory.getType()));
    }

    public static /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchEntityRepository globalSearchEntityRepository, SpaceRpcResult spaceRpcResult) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        return globalSearchEntityRepository.getAuthRequestContext.apply(spaceRpcResult);
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v5 */
    public static /* synthetic */ ObservableSource getAuthRequestContext(final GlobalSearchEntityRepository globalSearchEntityRepository, Location location, List list, String str, Ref.BooleanRef booleanRef, String str2, int i, int i2, Map map) {
        ?? r8;
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(map, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        while (true) {
            r8 = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((list.isEmpty() || list.contains((String) entry.getKey())) ? 1 : 0) != 0) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        ArrayList arrayList = new ArrayList(linkedHashMap2.size());
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            final String str3 = (String) entry2.getKey();
            GlobalSearchCategory globalSearchCategory = (GlobalSearchCategory) entry2.getValue();
            String str4 = (globalSearchEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(str) || !booleanRef.element) ? null : str2;
            booleanRef.element = r8;
            List<String> permission = globalSearchCategory.getPermission();
            final boolean z = permission != null && permission.contains("location");
            SearchConditionEntity searchConditionEntity = new SearchConditionEntity("NAME", CollectionsKt.listOf(str));
            SearchConditionEntity searchConditionEntity2 = new SearchConditionEntity("CATEGORY", CollectionsKt.listOf(str3));
            SearchConditionEntity[] searchConditionEntityArr = new SearchConditionEntity[2];
            searchConditionEntityArr[r8] = searchConditionEntity;
            searchConditionEntityArr[1] = searchConditionEntity2;
            Observable map2 = globalSearchEntityRepository.scheduleImpl.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(new SearchRequestEntity(CollectionsKt.listOf((Object[]) searchConditionEntityArr), Integer.valueOf(i), Integer.valueOf(i2), null, str4, 8, null)).flatMap(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GlobalSearchEntityRepository.MyBillsEntityDataFactory(GlobalSearchEntityRepository.this, str3, (SearchResultEntity) obj);
                }
            }).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GlobalSearchEntityRepository.MyBillsEntityDataFactory(GlobalSearchEntityRepository.this, z, (SearchResultEntity) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map2, "");
            arrayList.add(map2.subscribeOn(Schedulers.MyBillsEntityDataFactory()));
            r8 = 0;
        }
        return Observable.zipIterable(arrayList, new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.getAuthRequestContext((Object[]) obj);
            }
        }, true, 1).zipWith(SingleShotLocationProvider.requestSingleUpdateObservable(globalSearchEntityRepository.MyBillsEntityDataFactory, location).onErrorReturnItem(globalSearchEntityRepository.lookAheadTest), new BiFunction() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return GlobalSearchEntityRepository.MyBillsEntityDataFactory(GlobalSearchEntityRepository.this, (List) obj, (LatLng) obj2);
            }
        });
    }

    public static /* synthetic */ SearchResultResponse PlaceComponentResult(GlobalSearchEntityRepository globalSearchEntityRepository, SearchResultEntity searchResultEntity) {
        Intrinsics.checkNotNullParameter(globalSearchEntityRepository, "");
        Intrinsics.checkNotNullParameter(searchResultEntity, "");
        return new SearchResultResponse(MyBillsEntityDataFactory(searchResultEntity.getSearchResultList()), PlaceComponentResult(searchResultEntity.getPaginator()), false);
    }

    private final Observable<List<String>> scheduleImpl() {
        ContentDeliveryEntityData createData2 = this.BuiltInFictitiousFunctionClassFactory.createData2("network");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<SpaceRpcResult> observable = createData2.get(SpaceCode.GLOBAL_SEARCH_POPULAR);
        Intrinsics.checkNotNullExpressionValue(observable, "");
        Intrinsics.checkNotNullParameter(observable, "");
        Observable authenticatedRequest = this.getErrorConfigVersion.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        Observable<List<String>> map = authenticatedRequest.map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchEntityRepository.this, (SpaceRpcResult) obj);
            }
        }).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.PlaceComponentResult((List) obj);
            }
        }).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.PlaceComponentResult((String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        List<String> blockingFirst = ((ExploreConfigEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        Iterator<T> it = blockingFirst.iterator();
        while (it.hasNext()) {
            if (new Regex((String) it.next()).matches(p0)) {
                return true;
            }
        }
        return false;
    }

    private final Observable<Boolean> PlaceComponentResult(long p0, int p1, List<String> p2) {
        GlobalSearchPreferenceCacheEntityData globalSearchPreferenceCacheEntityData = this.moveToNextValue.PlaceComponentResult;
        if (p2 == null) {
            p2 = CollectionsKt.emptyList();
        }
        return globalSearchPreferenceCacheEntityData.PlaceComponentResult("POPULAR_SEARCH_PLACEHOLDER", new PopularSearchCache(p0, p1, p2));
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<AutoCompleteResult> BuiltInFictitiousFunctionClassFactory(String p0, int p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<AutoCompleteResult> subscribeOn = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new AutoCompleteRequestEntity(null, "NAME", p0, p1, p2)).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AutoCompleteResultEntity autoCompleteResultEntity = (AutoCompleteResultEntity) obj;
                Intrinsics.checkNotNullParameter(autoCompleteResultEntity, "");
                List<PaySearchInfoEntity> searchResultList = autoCompleteResultEntity.getSearchResultList();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(searchResultList, 10));
                for (PaySearchInfoEntity paySearchInfoEntity : searchResultList) {
                    PaySearchInfo paySearchInfo = new PaySearchInfo(null, null, null, null, null, null, null, null, null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, false, false, 262143, null);
                    String address = paySearchInfoEntity.getAddress();
                    if (address == null) {
                        address = "";
                    }
                    paySearchInfo.setAddress(address);
                    String category = paySearchInfoEntity.getCategory();
                    if (category == null) {
                        category = "";
                    }
                    paySearchInfo.setCategory(category);
                    String description = paySearchInfoEntity.getDescription();
                    if (description == null) {
                        description = "";
                    }
                    paySearchInfo.setDescription(description);
                    String id2 = paySearchInfoEntity.getId();
                    if (id2 == null) {
                        id2 = "";
                    }
                    paySearchInfo.setId(id2);
                    Map<String, String> info = paySearchInfoEntity.getInfo();
                    if (info == null) {
                        info = MapsKt.emptyMap();
                    }
                    paySearchInfo.setInfo(info);
                    String infoType = paySearchInfoEntity.getInfoType();
                    if (infoType == null) {
                        infoType = "";
                    }
                    paySearchInfo.setInfoType(infoType);
                    String logo = paySearchInfoEntity.getLogo();
                    if (logo == null) {
                        logo = "";
                    }
                    paySearchInfo.setLogo(logo);
                    List<String> mcc = paySearchInfoEntity.getMcc();
                    if (mcc == null) {
                        mcc = CollectionsKt.emptyList();
                    }
                    paySearchInfo.setMcc(mcc);
                    String name = paySearchInfoEntity.getName();
                    if (name == null) {
                        name = "";
                    }
                    paySearchInfo.setName(name);
                    Double rating = paySearchInfoEntity.getRating();
                    paySearchInfo.setRating(rating != null ? rating.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    Integer score = paySearchInfoEntity.getScore();
                    paySearchInfo.setScore(score != null ? score.intValue() : 0);
                    String subCategory = paySearchInfoEntity.getSubCategory();
                    if (subCategory == null) {
                        subCategory = "";
                    }
                    paySearchInfo.setSubCategory(subCategory);
                    String tag = paySearchInfoEntity.getTag();
                    if (tag == null) {
                        tag = "";
                    }
                    paySearchInfo.setTag(tag);
                    paySearchInfo.setUrlMap(paySearchInfoEntity.getUrl());
                    arrayList.add(paySearchInfo);
                }
                return new AutoCompleteResult(arrayList, GlobalSearchEntityRepository.PlaceComponentResult(autoCompleteResultEntity.getPaginator()), autoCompleteResultEntity.success);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<GlobalSearchConfig> BuiltInFictitiousFunctionClassFactory() {
        Observable map = ((ExploreConfigEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((GlobalSearchConfigResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<Boolean> MyBillsEntityDataFactory() {
        Observable<Boolean> subscribeOn = this.moveToNextValue.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("GLOBAL_SEARCH_HINT_SWIPE_VISIBILITY", Boolean.TYPE).onErrorReturnItem(Boolean.TRUE).subscribeOn(Schedulers.MyBillsEntityDataFactory());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<List<ProductBizId>> getAuthRequestContext(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        Observable<List<ProductBizId>> zipWith = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(list).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.BuiltInFictitiousFunctionClassFactory((HistoricalSkuResultEntity) obj);
            }
        }).zipWith(this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(), new BiFunction() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return GlobalSearchEntityRepository.BuiltInFictitiousFunctionClassFactory((List) obj, (Map) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<List<String>> PlaceComponentResult() {
        Observable<TrendingSearchResultEntity> MyBillsEntityDataFactory = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        Observable authenticatedRequest = this.getErrorConfigVersion.authenticatedRequest(MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        Observable<List<String>> subscribeOn = authenticatedRequest.flatMap(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchEntityRepository.this, (TrendingSearchResultEntity) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.BuiltInFictitiousFunctionClassFactory(GlobalSearchEntityRepository.this, (Throwable) obj);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<String> getAuthRequestContext() {
        Observable flatMap = this.moveToNextValue.PlaceComponentResult.getAuthRequestContext().flatMap(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchEntityRepository.this, (PopularSearchCache) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<HashMap<String, Long>> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<List<PaySearchInfo>> MyBillsEntityDataFactory(final RecommendationCategory recommendationCategory) {
        Intrinsics.checkNotNullParameter(recommendationCategory, "");
        AccountEntityData createAccountData = this.getErrorConfigVersion.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        final int i = 1;
        final int i2 = 10;
        Observable<List<PaySearchInfo>> map = createAccountData.getUserId().flatMap(new Function(i, i2, recommendationCategory, this) { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda14
            public final /* synthetic */ RecommendationCategory BuiltInFictitiousFunctionClassFactory;
            public final /* synthetic */ GlobalSearchEntityRepository KClassImpl$Data$declaredNonStaticMembers$2;
            public final /* synthetic */ int MyBillsEntityDataFactory = 1;
            public final /* synthetic */ int PlaceComponentResult = 10;

            {
                this.BuiltInFictitiousFunctionClassFactory = recommendationCategory;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, (String) obj);
            }
        }).map(new Function() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GlobalSearchEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchEntityRepository.this, (SearchResultEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<Boolean> getErrorConfigVersion() {
        return ((ExploreConfigEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).PlaceComponentResult();
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<Boolean> lookAheadTest() {
        return ((ExploreConfigEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).lookAheadTest();
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory(String p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        HashMap<String, Long> blockingFirst = this.moveToNextValue.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().blockingFirst();
        if (p1 != -1) {
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            blockingFirst.put(p0, Long.valueOf(p1));
        } else {
            blockingFirst.remove(p0);
        }
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return this.moveToNextValue.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new HashMap<>(MapsKt.toMap(CollectionsKt.take(CollectionsKt.sortedWith(MapsKt.toList(blockingFirst), new Comparator() { // from class: id.dana.explore.data.globalsearch.GlobalSearchEntityRepository$saveRecentSearch$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Long) ((Pair) t2).getSecond(), (Long) ((Pair) t).getSecond());
            }
        }), 5))));
    }

    @Override // id.dana.explore.domain.globalsearch.GlobalSearchRepository
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(boolean p0) {
        Observable<Boolean> subscribeOn = this.moveToNextValue.PlaceComponentResult.PlaceComponentResult("GLOBAL_SEARCH_HINT_SWIPE_VISIBILITY", Boolean.valueOf(p0)).subscribeOn(Schedulers.MyBillsEntityDataFactory());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }
}
