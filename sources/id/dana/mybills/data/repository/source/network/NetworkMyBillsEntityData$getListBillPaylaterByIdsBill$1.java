package id.dana.mybills.data.repository.source.network;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.mybills.data.model.request.ListPaylaterByBillRequest;
import id.dana.mybills.data.model.response.ListBillPaylaterResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/repository/source/network/MyBillsRpcFacade;", "it", "Lid/dana/mybills/data/model/response/ListBillPaylaterResult;", BridgeDSL.INVOKE, "(Lid/dana/mybills/data/repository/source/network/MyBillsRpcFacade;)Lid/dana/mybills/data/model/response/ListBillPaylaterResult;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class NetworkMyBillsEntityData$getListBillPaylaterByIdsBill$1 extends Lambda implements Function1<MyBillsRpcFacade, ListBillPaylaterResult> {
    final /* synthetic */ ListPaylaterByBillRequest $$request;
    final /* synthetic */ NetworkMyBillsEntityData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkMyBillsEntityData$getListBillPaylaterByIdsBill$1(NetworkMyBillsEntityData networkMyBillsEntityData, ListPaylaterByBillRequest listPaylaterByBillRequest) {
        super(1);
        this.this$0 = networkMyBillsEntityData;
        this.$$request = listPaylaterByBillRequest;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ListBillPaylaterResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
        Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
        return myBillsRpcFacade.listPaylaterByBill((ListPaylaterByBillRequest) NetworkMyBillsEntityData.PlaceComponentResult(this.this$0, this.$$request));
    }
}
