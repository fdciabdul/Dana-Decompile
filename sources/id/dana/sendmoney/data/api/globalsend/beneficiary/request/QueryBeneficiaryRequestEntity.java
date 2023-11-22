package id.dana.sendmoney.data.api.globalsend.beneficiary.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "pageNum", "I", "getPageNum", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "", "transferMethod", "Ljava/lang/String;", "getTransferMethod", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryBeneficiaryRequestEntity extends BaseRpcRequest {
    private final int pageNum;
    private final int pageSize;
    private final String transferMethod;

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    public QueryBeneficiaryRequestEntity(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.transferMethod = str;
        this.pageSize = i;
        this.pageNum = i2;
    }
}
