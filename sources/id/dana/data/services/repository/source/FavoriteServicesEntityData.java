package id.dana.data.services.repository.source;

import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.ServiceHighlighted;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import j$.util.Optional;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u001b\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0002H&¢\u0006\u0004\b\u0013\u0010\u0006J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\u0014\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00110\u0002H&¢\u0006\u0004\b\u0018\u0010\u0006J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00022\u0006\u0010\u0014\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/services/repository/source/FavoriteServicesEntityData;", "", "Lio/reactivex/Observable;", "", "", "getFavoriteServices", "()Lio/reactivex/Observable;", "services", "", "saveFavoriteServices", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "favoriteServiceCache", "saveFavoriteServiceCache", "(Lid/dana/domain/services/model/ThirdPartyCategoryService;)Lio/reactivex/Observable;", "getFavoriteServicesCache", "clearCacheFavoriteServices", "Lj$/util/Optional;", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "getCategoryHighlightedFeature", "data", "saveCategoryHighlightedFeature", "(Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;)Lio/reactivex/Observable;", "Lid/dana/data/services/repository/source/model/ServiceHighlighted;", "getServiceHighlighted", "saveServiceHighlighted", "(Lid/dana/data/services/repository/source/model/ServiceHighlighted;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public interface FavoriteServicesEntityData {
    Observable<Boolean> clearCacheFavoriteServices();

    Observable<Optional<CategoryHighlightedFeature>> getCategoryHighlightedFeature();

    Observable<List<String>> getFavoriteServices();

    Observable<ThirdPartyCategoryService> getFavoriteServicesCache();

    Observable<Optional<ServiceHighlighted>> getServiceHighlighted();

    Observable<CategoryHighlightedFeature> saveCategoryHighlightedFeature(CategoryHighlightedFeature data);

    Observable<Boolean> saveFavoriteServiceCache(ThirdPartyCategoryService favoriteServiceCache);

    Observable<Boolean> saveFavoriteServices(List<String> services);

    Observable<ServiceHighlighted> saveServiceHighlighted(ServiceHighlighted data);
}
