package id.dana.data.autoroute.repository;

import id.dana.data.autoroute.model.AutoRouteInitResult;
import id.dana.data.autoroute.model.UserAutoRouteConfigStoreRequest;
import id.dana.network.response.autoroute.UserAutoRouteConfigSwitchResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/autoroute/repository/AutoRouteEntityData;", "", "", "needAssetCheck", "Lio/reactivex/Observable;", "Lid/dana/data/autoroute/model/AutoRouteInitResult;", "getInitialSetting", "(Z)Lio/reactivex/Observable;", "Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "userAutoRouteConfigStoreRequest", "isFromCashierFlow", "Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;", "switchConfig", "(Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;Ljava/lang/Boolean;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AutoRouteEntityData {
    Observable<AutoRouteInitResult> getInitialSetting(boolean needAssetCheck);

    Observable<UserAutoRouteConfigSwitchResult> switchConfig(UserAutoRouteConfigStoreRequest userAutoRouteConfigStoreRequest, Boolean isFromCashierFlow);
}
