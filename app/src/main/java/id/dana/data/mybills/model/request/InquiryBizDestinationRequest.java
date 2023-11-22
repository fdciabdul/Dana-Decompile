package id.dana.data.mybills.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/mybills/model/request/InquiryBizDestinationRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "Lid/dana/data/mybills/model/request/BizDestinationParam;", "destinationParams", "Ljava/util/List;", "getDestinationParams", "()Ljava/util/List;", "", "goodsId", "Ljava/lang/String;", "getGoodsId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InquiryBizDestinationRequest extends BaseRpcRequest {
    private final List<BizDestinationParam> destinationParams;
    private final String goodsId;

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getDestinationParams")
    public final List<BizDestinationParam> getDestinationParams() {
        return this.destinationParams;
    }

    public InquiryBizDestinationRequest(String str, List<BizDestinationParam> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.goodsId = str;
        this.destinationParams = list;
    }
}
