package id.dana.sendmoney.data.api.globalsend.beneficiary.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.sendmoney.data.api.globalsend.validate.model.BeneficiaryInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/beneficiary/response/QueryBeneficiaryResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "beneficiaryList", "Ljava/util/List;", "getBeneficiaryList", "()Ljava/util/List;", "", "location", "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", "", "totalCount", "Ljava/lang/Integer;", "getTotalCount", "()Ljava/lang/Integer;", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryBeneficiaryResultEntity extends BaseRpcResult {
    private final List<BeneficiaryInfoEntity> beneficiaryList;
    private final String location;
    private final Integer totalCount;

    @JvmName(name = "getBeneficiaryList")
    public final List<BeneficiaryInfoEntity> getBeneficiaryList() {
        return this.beneficiaryList;
    }

    @JvmName(name = "getTotalCount")
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    public QueryBeneficiaryResultEntity(List<BeneficiaryInfoEntity> list, Integer num, String str) {
        this.beneficiaryList = list;
        this.totalCount = num;
        this.location = str;
    }
}
