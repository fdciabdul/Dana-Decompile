package id.dana.data.banner.repository.source.network;

import android.content.Context;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.banner.repository.source.BannerEntityData;
import id.dana.data.banner.repository.source.network.request.BannerEntityRequest;
import id.dana.data.banner.repository.source.network.response.BannerListEntityResponse;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/banner/repository/source/network/NetworkBannerEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/banner/repository/source/network/BannerFacade;", "Lid/dana/data/banner/repository/source/BannerEntityData;", "", "placement", "", "page", GriverMonitorConstants.KEY_SIZE, "Lio/reactivex/Observable;", "Lid/dana/data/banner/repository/source/network/response/BannerListEntityResponse;", "getAllBanner", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkBannerEntityData extends SecureBaseNetwork<BannerFacade> implements BannerEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<BannerFacade> getFacadeClass() {
        return BannerFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkBannerEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.banner.repository.source.BannerEntityData
    public final Observable<BannerListEntityResponse> getAllBanner(final String placement, final int page, final int size) {
        Intrinsics.checkNotNullParameter(placement, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.banner.repository.source.network.NetworkBannerEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BannerListEntityResponse m807getAllBanner$lambda1;
                m807getAllBanner$lambda1 = NetworkBannerEntityData.m807getAllBanner$lambda1(placement, page, size, this, (BannerFacade) obj);
                return m807getAllBanner$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAllBanner$lambda-1  reason: not valid java name */
    public static final BannerListEntityResponse m807getAllBanner$lambda1(String str, int i, int i2, NetworkBannerEntityData networkBannerEntityData, BannerFacade bannerFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkBannerEntityData, "");
        BannerEntityRequest bannerEntityRequest = new BannerEntityRequest(str, i, i2);
        bannerEntityRequest.envInfo = networkBannerEntityData.generateMobileEnvInfo();
        return bannerFacade.getAllBanners(bannerEntityRequest);
    }
}
