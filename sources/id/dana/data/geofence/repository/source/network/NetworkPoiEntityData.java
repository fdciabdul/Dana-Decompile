package id.dana.data.geofence.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.geofence.model.PoiNotificationInfo;
import id.dana.data.geofence.repository.GeoFenceEntityData;
import id.dana.data.geofence.repository.source.network.request.PoiFetchRequest;
import id.dana.data.geofence.repository.source.network.request.PoiNotificationRequest;
import id.dana.data.geofence.repository.source.network.result.PoiFetchResult;
import id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\fJ#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u0015"}, d2 = {"Lid/dana/data/geofence/repository/source/network/NetworkPoiEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/geofence/repository/source/network/PoiFacade;", "Lid/dana/data/geofence/repository/GeoFenceEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "name", "Lio/reactivex/Observable;", "Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "getListPoi", "(Ljava/lang/String;)Lio/reactivex/Observable;", "poiId", "", "hasNotifiedToday", "", "Lid/dana/data/geofence/model/PoiNotificationInfo;", "poiNotificationInfos", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "notifyPois", "(Ljava/util/List;)Lio/reactivex/Observable;", "poiIds", "", "saveLastPoiNotificationDate", "Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "pois", "", "saveListPoi", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkPoiEntityData extends SecureBaseNetwork<PoiFacade> implements GeoFenceEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<PoiFacade> getFacadeClass() {
        return PoiFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkPoiEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListPoi$lambda-0  reason: not valid java name */
    public static final PoiFetchResult m1323getListPoi$lambda0(String str, PoiFacade poiFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        return poiFacade.getPois(new PoiFetchRequest(str));
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<PoiFetchResult> getListPoi(final String name) {
        Intrinsics.checkNotNullParameter(name, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.geofence.repository.source.network.NetworkPoiEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PoiFetchResult m1323getListPoi$lambda0;
                m1323getListPoi$lambda0 = NetworkPoiEntityData.m1323getListPoi$lambda0(name, (PoiFacade) obj);
                return m1323getListPoi$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notifyPois$lambda-2  reason: not valid java name */
    public static final BaseRpcResult m1324notifyPois$lambda2(List list, NetworkPoiEntityData networkPoiEntityData, PoiFacade poiFacade) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(networkPoiEntityData, "");
        PoiNotificationRequest poiNotificationRequest = new PoiNotificationRequest(list);
        poiNotificationRequest.envInfo = networkPoiEntityData.generateMobileEnvInfo();
        return poiFacade.notify(poiNotificationRequest);
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<BaseRpcResult> notifyPois(final List<PoiNotificationInfo> poiNotificationInfos) {
        Intrinsics.checkNotNullParameter(poiNotificationInfos, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.geofence.repository.source.network.NetworkPoiEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BaseRpcResult m1324notifyPois$lambda2;
                m1324notifyPois$lambda2 = NetworkPoiEntityData.m1324notifyPois$lambda2(poiNotificationInfos, this, (PoiFacade) obj);
                return m1324notifyPois$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<long[]> saveListPoi(List<RecentPoiEntity> pois) {
        Intrinsics.checkNotNullParameter(pois, "");
        Observable<long[]> just = Observable.just(new long[0]);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<Integer> saveLastPoiNotificationDate(List<String> poiIds) {
        Intrinsics.checkNotNullParameter(poiIds, "");
        Observable<Integer> just = Observable.just(0);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<Boolean> hasNotifiedToday(String poiId) {
        Intrinsics.checkNotNullParameter(poiId, "");
        Observable<Boolean> just = Observable.just(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
