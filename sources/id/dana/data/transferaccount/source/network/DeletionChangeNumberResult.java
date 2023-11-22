package id.dana.data.transferaccount.source.network;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/transferaccount/source/network/DeletionChangeNumberResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", RequestConstants.SecVIKeyTntInstId, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeletionChangeNumberResult extends BaseRpcResult {
    @SerializedName(RequestConstants.SecVIKeyTntInstId)
    private final String tntInstId;

    public DeletionChangeNumberResult(@JSONField(name = "tntInstId") String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.tntInstId = str;
    }
}
