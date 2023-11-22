package id.dana.data.investment.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006"}, d2 = {"Lid/dana/data/investment/repository/source/network/response/InvestmentUnitResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "Ljava/lang/Long;", "getUnit", "()Ljava/lang/Long;", "unitValue", "getUnitValue", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvestmentUnitResult extends BaseRpcResult {
    private final String type;
    private final Long unit;
    private final String unitValue;

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getUnit")
    public final Long getUnit() {
        return this.unit;
    }

    @JvmName(name = "getUnitValue")
    public final String getUnitValue() {
        return this.unitValue;
    }

    public InvestmentUnitResult(String str, Long l, String str2) {
        this.type = str;
        this.unit = l;
        this.unitValue = str2;
    }
}
