package id.dana.data.paylater.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/LoanWhitelistResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/paylater/repository/source/network/result/LoanInfoResult;", "loanInfo", "Ljava/util/List;", "getLoanInfo", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanWhitelistResult extends BaseRpcResult {
    private final List<LoanInfoResult> loanInfo;

    @JvmName(name = "getLoanInfo")
    public final List<LoanInfoResult> getLoanInfo() {
        return this.loanInfo;
    }

    public LoanWhitelistResult(List<LoanInfoResult> list) {
        this.loanInfo = list;
    }
}
