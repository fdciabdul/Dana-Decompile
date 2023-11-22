package id.dana.data.services.repository.source;

import id.dana.danah5.DanaH5;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.CategoryServices;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00022\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H&¢\u0006\u0004\b\r\u0010\bJ\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0002H&¢\u0006\u0004\b\u000e\u0010\bJ\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u0002H&¢\u0006\u0004\b\u0010\u0010\bJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/services/repository/source/ServicesEntityData;", "", "Lio/reactivex/Observable;", "", "", "", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "getAllServices", "()Lio/reactivex/Observable;", "category", "getCategories", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "getCategoryHighlightedFeature", "getRawServices", "Lid/dana/data/services/repository/source/model/CategoryServices;", "getSections", DanaH5.SERVICE_KEY, "getService"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ServicesEntityData {
    Observable<Map<String, List<ThirdPartyEntity>>> getAllServices();

    Observable<List<String>> getCategories(String category);

    Observable<CategoryHighlightedFeature> getCategoryHighlightedFeature();

    Observable<List<ThirdPartyEntity>> getRawServices();

    Observable<List<CategoryServices>> getSections();

    Observable<ThirdPartyEntity> getService(String serviceKey);
}
