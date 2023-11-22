package id.dana.explore.domain.globalsearch;

import android.location.Location;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.explore.domain.globalsearch.enums.RecommendationCategory;
import id.dana.explore.domain.globalsearch.model.AutoCompleteResult;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.explore.domain.globalsearch.model.SearchCondition;
import id.dana.explore.domain.globalsearch.model.SearchResultResponse;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J,\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\b\b\u0002\u0010\u0015\u001a\u00020\fH&J0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u0003H&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H&J*\u0010\u001c\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e`\u001f0\u0003H&J0\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00120\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#H&J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&JN\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00120\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\nH&J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00032\u0006\u0010-\u001a\u00020\u0004H&J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u001eH&J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u00101\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00062À\u0006\u0001"}, d2 = {"Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "", "shouldSuggestLocationPermissionDialog", "Lio/reactivex/Observable;", "", "getShouldSuggestLocationPermissionDialog", "()Lio/reactivex/Observable;", "getAutoComplete", "Lid/dana/explore/domain/globalsearch/model/AutoCompleteResult;", "keyword", "", "page", "", GriverMonitorConstants.KEY_SIZE, "getGlobalSearchConfig", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "getHintSwipeVisibilityState", "getHistoricalSku", "", "Lid/dana/domain/globalsearch/model/ProductBizId;", "profileKeys", "profileKeyMaxResult", "getOnlineMerchant", "Lid/dana/explore/domain/globalsearch/model/SearchResultResponse;", "additionalConditions", "Lid/dana/explore/domain/globalsearch/model/SearchCondition;", "getPopularSearch", "getPopularSearchPlaceholder", "getRecentSearch", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getRecommendationInfo", "Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "category", "Lid/dana/explore/domain/globalsearch/enums/RecommendationCategory;", "getSearchBarAtHomeVisibility", "getSearchResult", "categories", "location", "Landroid/location/Location;", "userId", "isFeatureGlobalSearchEnable", "saveLocationPermissionSuggestionState", "", "neverShow", "saveRecentSearch", "timeSearch", "setHintSwipeVisibilityState", "isVisible", "feature-explore_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GlobalSearchRepository {
    Observable<GlobalSearchConfig> BuiltInFictitiousFunctionClassFactory();

    Observable<AutoCompleteResult> BuiltInFictitiousFunctionClassFactory(String str, int i, int i2);

    Observable<Unit> BuiltInFictitiousFunctionClassFactory(String str, long j);

    Observable<Boolean> BuiltInFictitiousFunctionClassFactory(boolean z);

    Observable<HashMap<String, Long>> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<Boolean> MyBillsEntityDataFactory();

    Observable<List<PaySearchInfo>> MyBillsEntityDataFactory(RecommendationCategory recommendationCategory);

    Observable<SearchResultResponse> MyBillsEntityDataFactory(List<SearchCondition> list, int i, int i2);

    Observable<Unit> MyBillsEntityDataFactory(boolean z);

    Observable<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda0();

    Observable<List<String>> PlaceComponentResult();

    Observable<String> getAuthRequestContext();

    Observable<List<SearchResultResponse>> getAuthRequestContext(String str, int i, int i2, List<String> list, Location location, String str2);

    Observable<List<ProductBizId>> getAuthRequestContext(List<String> list);

    Observable<Boolean> getErrorConfigVersion();

    Observable<Boolean> lookAheadTest();

    /* renamed from: id.dana.explore.domain.globalsearch.GlobalSearchRepository$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
    }
}
