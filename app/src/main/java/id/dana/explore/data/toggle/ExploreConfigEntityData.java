package id.dana.explore.data.toggle;

import id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse;
import id.dana.explore.domain.globalsearch.model.GlobalSearchCategory;
import id.dana.explore.domain.sku.model.CategoryExploreModel;
import id.dana.explore.domain.sku.model.SkuExploreConfig;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u001b\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\u0013\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/data/toggle/ExploreConfigEntityData;", "", "Lio/reactivex/Observable;", "", "Lid/dana/explore/domain/sku/model/CategoryExploreModel;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "", "", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchCategory;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "Lid/dana/explore/data/globalsearch/model/GlobalSearchConfigResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/sku/model/SkuExploreConfig;", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExploreConfigEntityData {
    Observable<List<CategoryExploreModel>> BuiltInFictitiousFunctionClassFactory();

    Observable<GlobalSearchConfigResponse> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<Map<String, GlobalSearchCategory>> MyBillsEntityDataFactory();

    Observable<List<String>> NetworkUserEntityData$$ExternalSyntheticLambda0();

    Observable<Boolean> PlaceComponentResult();

    Observable<List<SkuExploreConfig>> getAuthRequestContext();

    Observable<Boolean> getErrorConfigVersion();

    Observable<Boolean> lookAheadTest();
}
