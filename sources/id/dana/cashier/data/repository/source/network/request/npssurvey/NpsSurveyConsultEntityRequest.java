package id.dana.cashier.data.repository.source.network.request.npssurvey;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "merchantName", "Ljava/lang/String;", "getMerchantName", "()Ljava/lang/String;", "merchantTransType", "getMerchantTransType", "", "npsScenario", "Z", "getNpsScenario", "()Z", "transType", "getTransType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveyConsultEntityRequest extends BaseRpcRequest {
    private final String merchantName;
    private final String merchantTransType;
    private final boolean npsScenario;
    @SerializedName("transType")
    private final String transType;

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "getMerchantTransType")
    public final String getMerchantTransType() {
        return this.merchantTransType;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getNpsScenario")
    public final boolean getNpsScenario() {
        return this.npsScenario;
    }

    public NpsSurveyConsultEntityRequest(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.transType = str;
        this.merchantTransType = str2;
        this.merchantName = str3;
        this.npsScenario = z;
    }
}
