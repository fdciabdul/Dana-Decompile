package id.dana.data.globalnetwork.model;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f"}, d2 = {"Lid/dana/data/globalnetwork/model/UniPaymentEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "", "bizNos", "Ljava/util/List;", "getBizNos", "()Ljava/util/List;", "setBizNos", "(Ljava/util/List;)V", "linkTargetId", "Ljava/lang/String;", "getLinkTargetId", "()Ljava/lang/String;", "setLinkTargetId", "(Ljava/lang/String;)V", "resultBizType", "getResultBizType", "setResultBizType", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UniPaymentEntityRequest extends BaseRpcRequest {
    private List<String> bizNos;
    private String linkTargetId;
    private String resultBizType;

    @JvmName(name = "getBizNos")
    public final List<String> getBizNos() {
        return this.bizNos;
    }

    @JvmName(name = "setBizNos")
    public final void setBizNos(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.bizNos = list;
    }

    @JvmName(name = "getLinkTargetId")
    public final String getLinkTargetId() {
        return this.linkTargetId;
    }

    @JvmName(name = "setLinkTargetId")
    public final void setLinkTargetId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.linkTargetId = str;
    }

    @JvmName(name = "getResultBizType")
    public final String getResultBizType() {
        return this.resultBizType;
    }

    @JvmName(name = "setResultBizType")
    public final void setResultBizType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.resultBizType = str;
    }

    public UniPaymentEntityRequest(List<String> list, String str, String str2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.bizNos = list;
        this.linkTargetId = str;
        this.resultBizType = str2;
    }
}
