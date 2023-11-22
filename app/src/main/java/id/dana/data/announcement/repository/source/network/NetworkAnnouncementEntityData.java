package id.dana.data.announcement.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.announcement.AnnouncementEntityData;
import id.dana.data.announcement.repository.source.network.request.AnnouncementRequest;
import id.dana.data.announcement.repository.source.network.result.AnnouncementResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f0\bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016"}, d2 = {"Lid/dana/data/announcement/repository/source/network/NetworkAnnouncementEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/announcement/repository/source/network/AnnouncementFacade;", "Lid/dana/data/announcement/AnnouncementEntityData;", "", "type", "", "extendInfo", "Lio/reactivex/Observable;", "Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "getAnnouncements", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "", "getAnnouncementsIdGNSubscription", "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "getTrackedAnnouncementsIdGNSubscription", "id", "", "setAnnouncementIdGNSubscription", "(Ljava/lang/String;)Lio/reactivex/Observable;", "setTrackedAnnouncementIdGNSubscription", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkAnnouncementEntityData extends SecureBaseNetwork<AnnouncementFacade> implements AnnouncementEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<AnnouncementFacade> getFacadeClass() {
        return AnnouncementFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkAnnouncementEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<AnnouncementResult> getAnnouncements(String type, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        final AnnouncementRequest announcementRequest = new AnnouncementRequest(type, extendInfo);
        announcementRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.announcement.repository.source.network.NetworkAnnouncementEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                AnnouncementResult m780getAnnouncements$lambda0;
                m780getAnnouncements$lambda0 = NetworkAnnouncementEntityData.m780getAnnouncements$lambda0(AnnouncementRequest.this, (AnnouncementFacade) obj);
                return m780getAnnouncements$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAnnouncements$lambda-0  reason: not valid java name */
    public static final AnnouncementResult m780getAnnouncements$lambda0(AnnouncementRequest announcementRequest, AnnouncementFacade announcementFacade) {
        Intrinsics.checkNotNullParameter(announcementRequest, "");
        return announcementFacade.getAnnouncements(announcementRequest);
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<List<String>> getAnnouncementsIdGNSubscription() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<Boolean> setAnnouncementIdGNSubscription(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<List<String>> getTrackedAnnouncementsIdGNSubscription() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<Boolean> setTrackedAnnouncementIdGNSubscription(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        throw new UnsupportedOperationException();
    }
}
