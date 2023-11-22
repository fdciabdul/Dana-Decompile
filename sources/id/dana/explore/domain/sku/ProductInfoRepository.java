package id.dana.explore.domain.sku;

import id.dana.explore.domain.sku.model.CategoryExploreModel;
import id.dana.explore.domain.sku.model.SkuExploreConfig;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u0002H&¢\u0006\u0004\b\f\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/domain/sku/ProductInfoRepository;", "", "Lio/reactivex/Observable;", "", "Lid/dana/explore/domain/sku/model/CategoryExploreModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/explore/domain/sku/model/SkuExploreConfig;", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ProductInfoRepository {
    Observable<String> BuiltInFictitiousFunctionClassFactory(String p0);

    Observable<List<CategoryExploreModel>> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<List<SkuExploreConfig>> PlaceComponentResult();
}
