package id.dana.danapoly.data.dailycheck.repository.source.network;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.danapoly.data.dailycheck.model.response.CampaignInfoResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/data/dailycheck/repository/source/network/DanapolyCheckInFacade;", "it", "Lid/dana/danapoly/data/dailycheck/model/response/CampaignInfoResponse;", BridgeDSL.INVOKE, "(Lid/dana/danapoly/data/dailycheck/repository/source/network/DanapolyCheckInFacade;)Lid/dana/danapoly/data/dailycheck/model/response/CampaignInfoResponse;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class NetworkDanapolyCheckInEntityData$getCampaignInfo$1 extends Lambda implements Function1<DanapolyCheckInFacade, CampaignInfoResponse> {
    final /* synthetic */ NetworkDanapolyCheckInEntityData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkDanapolyCheckInEntityData$getCampaignInfo$1(NetworkDanapolyCheckInEntityData networkDanapolyCheckInEntityData) {
        super(1);
        this.this$0 = networkDanapolyCheckInEntityData;
    }

    @Override // kotlin.jvm.functions.Function1
    public final CampaignInfoResponse invoke(DanapolyCheckInFacade danapolyCheckInFacade) {
        Intrinsics.checkNotNullParameter(danapolyCheckInFacade, "");
        return danapolyCheckInFacade.getCampaignInfo(NetworkDanapolyCheckInEntityData.BuiltInFictitiousFunctionClassFactory(this.this$0));
    }
}
