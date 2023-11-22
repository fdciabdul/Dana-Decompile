package id.dana.data.donation.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.donation.repository.DonationCampaignEntityData;
import id.dana.data.donation.repository.source.network.result.DonationCampaignResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/donation/repository/source/network/NetworkDonationCampaignEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/donation/repository/source/network/DonationCampaignFacade;", "Lid/dana/data/donation/repository/DonationCampaignEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/donation/repository/source/network/result/DonationCampaignResult;", "getDonationCampaigns", "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkDonationCampaignEntityData extends SecureBaseNetwork<DonationCampaignFacade> implements DonationCampaignEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<DonationCampaignFacade> getFacadeClass() {
        return DonationCampaignFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDonationCampaignEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.donation.repository.DonationCampaignEntityData
    public final Observable<DonationCampaignResult> getDonationCampaigns() {
        final BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.donation.repository.source.network.NetworkDonationCampaignEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                DonationCampaignResult m1209getDonationCampaigns$lambda0;
                m1209getDonationCampaigns$lambda0 = NetworkDonationCampaignEntityData.m1209getDonationCampaigns$lambda0(BaseRpcRequest.this, (DonationCampaignFacade) obj);
                return m1209getDonationCampaigns$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDonationCampaigns$lambda-0  reason: not valid java name */
    public static final DonationCampaignResult m1209getDonationCampaigns$lambda0(BaseRpcRequest baseRpcRequest, DonationCampaignFacade donationCampaignFacade) {
        Intrinsics.checkNotNullParameter(baseRpcRequest, "");
        return donationCampaignFacade.getCampaigns(baseRpcRequest);
    }
}
