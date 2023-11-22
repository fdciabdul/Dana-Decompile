package id.dana.sendmoney.data.api.globalsend.delete;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/delete/DeleteBeneficiaryRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "beneficiaryId", "Ljava/lang/String;", "getBeneficiaryId", "()Ljava/lang/String;", "transferMethod", "getTransferMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteBeneficiaryRequestEntity extends BaseRpcRequest {
    private final String beneficiaryId;
    private final String transferMethod;

    @JvmName(name = "getBeneficiaryId")
    public final String getBeneficiaryId() {
        return this.beneficiaryId;
    }

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    public DeleteBeneficiaryRequestEntity(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.beneficiaryId = str;
        this.transferMethod = str2;
    }
}
