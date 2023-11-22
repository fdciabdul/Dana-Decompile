package id.dana.danapoly.data.play.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BE\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/danapoly/data/play/model/response/RollDiceResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "currencyType", "Ljava/lang/String;", "getCurrencyType", "()Ljava/lang/String;", "", "Lid/dana/danapoly/data/play/model/response/PlayResponse;", "results", "Ljava/util/List;", "getResults", "()Ljava/util/List;", "", "userCurrentFund", "Ljava/lang/Integer;", "getUserCurrentFund", "()Ljava/lang/Integer;", "userCurrentLap", "getUserCurrentLap", "", "usingFreeAttempt", "Ljava/lang/Boolean;", "getUsingFreeAttempt", "()Ljava/lang/Boolean;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RollDiceResponse extends BaseRpcResult {
    private final String currencyType;
    @SerializedName("results")
    private final List<PlayResponse> results;
    private final Integer userCurrentFund;
    private final Integer userCurrentLap;
    private final Boolean usingFreeAttempt;

    @JvmName(name = "getResults")
    public final List<PlayResponse> getResults() {
        return this.results;
    }

    @JvmName(name = "getUsingFreeAttempt")
    public final Boolean getUsingFreeAttempt() {
        return this.usingFreeAttempt;
    }

    @JvmName(name = "getCurrencyType")
    public final String getCurrencyType() {
        return this.currencyType;
    }

    public /* synthetic */ RollDiceResponse(List list, Boolean bool, String str, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, bool, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? 0 : num, (i & 16) != 0 ? null : num2);
    }

    @JvmName(name = "getUserCurrentFund")
    public final Integer getUserCurrentFund() {
        return this.userCurrentFund;
    }

    @JvmName(name = "getUserCurrentLap")
    public final Integer getUserCurrentLap() {
        return this.userCurrentLap;
    }

    public RollDiceResponse(List<PlayResponse> list, Boolean bool, String str, Integer num, Integer num2) {
        this.results = list;
        this.usingFreeAttempt = bool;
        this.currencyType = str;
        this.userCurrentFund = num;
        this.userCurrentLap = num2;
    }
}
