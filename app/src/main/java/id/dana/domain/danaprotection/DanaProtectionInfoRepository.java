package id.dana.domain.danaprotection;

import id.dana.danah5.danaprotection.DanaProtectionKey;
import id.dana.domain.danaprotection.model.DanaProtectionInfoModel;
import id.dana.domain.danaprotection.model.DanaProtectionRecommendationModel;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;", "", "", "intervalCacheInMinute", "Lio/reactivex/Observable;", "Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "getDanaProtectionInfo", "(I)Lio/reactivex/Observable;", "", "Lid/dana/domain/danaprotection/model/DanaProtectionRecommendationModel;", "getDanaProtectionRecommendationInMemoryCache", "()Ljava/util/List;", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "getDanaProtectionWidgetConfigInCache", "()Lio/reactivex/Observable;", DanaProtectionKey.DanaProtectionResultParamsKey.RECOMMENDATION_DATA, "", "setDanaProtectionRecommendationInMemoryCache", "(Ljava/util/List;)V", "config", "", "setDanaProtectionWidgetConfigInCache", "(Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;)Lio/reactivex/Observable;", "", "it", "trackError", "(Ljava/lang/Throwable;)Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DanaProtectionInfoRepository {
    Observable<DanaProtectionInfoModel> getDanaProtectionInfo(int intervalCacheInMinute);

    List<DanaProtectionRecommendationModel> getDanaProtectionRecommendationInMemoryCache();

    Observable<DanaProtectionWidgetConfig> getDanaProtectionWidgetConfigInCache();

    void setDanaProtectionRecommendationInMemoryCache(List<DanaProtectionRecommendationModel> recommendationData);

    Observable<Boolean> setDanaProtectionWidgetConfigInCache(DanaProtectionWidgetConfig config);

    boolean trackError(Throwable it);
}
