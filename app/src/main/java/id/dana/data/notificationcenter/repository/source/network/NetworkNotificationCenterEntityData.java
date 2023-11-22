package id.dana.data.notificationcenter.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.notificationcenter.repository.source.NotificationCenterEntityData;
import id.dana.data.notificationcenter.repository.source.network.request.FetchInboxRequest;
import id.dana.data.notificationcenter.repository.source.network.request.HasNewRequest;
import id.dana.data.notificationcenter.repository.source.network.request.MarkNotificationRequest;
import id.dana.data.notificationcenter.repository.source.network.result.FetchInboxResult;
import id.dana.data.notificationcenter.repository.source.network.result.HasNewResult;
import id.dana.data.notificationcenter.repository.source.network.result.MarkNotificationResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class NetworkNotificationCenterEntityData extends SecureBaseNetwork<NotificationCenterFacade> implements NotificationCenterEntityData {
    public NetworkNotificationCenterEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<NotificationCenterFacade> getFacadeClass() {
        return NotificationCenterFacade.class;
    }

    @Override // id.dana.data.notificationcenter.repository.source.NotificationCenterEntityData
    public Observable<FetchInboxResult> fetchInbox(final int i, final String str, final String str2) {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.notificationcenter.repository.source.network.NetworkNotificationCenterEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkNotificationCenterEntityData.this.m1545x11ca8889(i, str, str2, (NotificationCenterFacade) obj);
            }
        });
    }

    /* renamed from: lambda$fetchInbox$0$id-dana-data-notificationcenter-repository-source-network-NetworkNotificationCenterEntityData */
    public /* synthetic */ FetchInboxResult m1545x11ca8889(int i, String str, String str2, NotificationCenterFacade notificationCenterFacade) {
        FetchInboxRequest fetchInboxRequest = new FetchInboxRequest();
        fetchInboxRequest.envInfo = generateMobileEnvInfo();
        fetchInboxRequest.setPageSize(i);
        fetchInboxRequest.setMaxId(str);
        fetchInboxRequest.setMinId(str2);
        return notificationCenterFacade.fetchInboxNotification(fetchInboxRequest);
    }

    @Override // id.dana.data.notificationcenter.repository.source.NotificationCenterEntityData
    public Observable<HasNewResult> hasNew() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.notificationcenter.repository.source.network.NetworkNotificationCenterEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkNotificationCenterEntityData.this.m1546xf0d6a804((NotificationCenterFacade) obj);
            }
        });
    }

    /* renamed from: lambda$hasNew$1$id-dana-data-notificationcenter-repository-source-network-NetworkNotificationCenterEntityData */
    public /* synthetic */ HasNewResult m1546xf0d6a804(NotificationCenterFacade notificationCenterFacade) {
        HasNewRequest hasNewRequest = new HasNewRequest();
        hasNewRequest.envInfo = generateMobileEnvInfo();
        return notificationCenterFacade.hasNewNotification(hasNewRequest);
    }

    @Override // id.dana.data.notificationcenter.repository.source.NotificationCenterEntityData
    public Observable<MarkNotificationResult> markAsRead(final String str) {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.notificationcenter.repository.source.network.NetworkNotificationCenterEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkNotificationCenterEntityData.this.m1547xbdfc6334(str, (NotificationCenterFacade) obj);
            }
        });
    }

    /* renamed from: lambda$markAsRead$2$id-dana-data-notificationcenter-repository-source-network-NetworkNotificationCenterEntityData */
    public /* synthetic */ MarkNotificationResult m1547xbdfc6334(String str, NotificationCenterFacade notificationCenterFacade) {
        MarkNotificationRequest markNotificationRequest = new MarkNotificationRequest();
        markNotificationRequest.envInfo = generateMobileEnvInfo();
        markNotificationRequest.setId(str);
        return notificationCenterFacade.markAsReadNotification(markNotificationRequest);
    }
}
