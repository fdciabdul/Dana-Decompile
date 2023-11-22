package id.dana.data.autoroute.repository.source.network;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.autoroute.model.AutoRouteInitResult;
import id.dana.data.autoroute.model.UserAutoRouteConfigStoreRequest;
import id.dana.data.autoroute.model.UserAutorouteInitRequest;
import id.dana.network.response.autoroute.UserAutoRouteConfigSwitchResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/autoroute/repository/source/network/AutoRouteFacade;", "", "Lid/dana/data/autoroute/model/UserAutorouteInitRequest;", "request", "Lid/dana/data/autoroute/model/AutoRouteInitResult;", IAPSyncCommand.COMMAND_INIT, "(Lid/dana/data/autoroute/model/UserAutorouteInitRequest;)Lid/dana/data/autoroute/model/AutoRouteInitResult;", "Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;", "switch", "(Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;)Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AutoRouteFacade {
    @OperationType("alipayplus.mobilewallet.user.config.autoroute.init")
    @SignCheck
    AutoRouteInitResult init(UserAutorouteInitRequest request);

    @OperationType("alipayplus.mobilewallet.user.config.autoroute.switch")
    @SignCheck
    /* renamed from: switch  reason: not valid java name */
    UserAutoRouteConfigSwitchResult m803switch(UserAutoRouteConfigStoreRequest request);
}
