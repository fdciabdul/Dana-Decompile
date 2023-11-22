package id.dana.domain.autoroute.repository;

import id.dana.domain.autoroute.model.AutoRouteInit;
import id.dana.domain.autoroute.model.UserAutoRouteConfigStore;
import id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0007J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/autoroute/repository/AutoRouteRepository;", "", "", "needAssetCheck", "Lio/reactivex/Observable;", "Lid/dana/domain/autoroute/model/AutoRouteInit;", "getInitialSetting", "(Z)Lio/reactivex/Observable;", "isHavingAutoRouteAsset", "()Lio/reactivex/Observable;", "isAssetExist", "saveAutoRouteAssetState", "Lid/dana/domain/autoroute/model/UserAutoRouteConfigStore;", "userAutoRouteConfigStore", "Lid/dana/domain/autoroute/model/UserAutoRouteConfigSwitch;", "switchConfig", "(Lid/dana/domain/autoroute/model/UserAutoRouteConfigStore;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AutoRouteRepository {
    Observable<AutoRouteInit> getInitialSetting(boolean needAssetCheck);

    Observable<Boolean> isHavingAutoRouteAsset();

    Observable<Boolean> saveAutoRouteAssetState(boolean isAssetExist);

    Observable<UserAutoRouteConfigSwitch> switchConfig(UserAutoRouteConfigStore userAutoRouteConfigStore);
}
