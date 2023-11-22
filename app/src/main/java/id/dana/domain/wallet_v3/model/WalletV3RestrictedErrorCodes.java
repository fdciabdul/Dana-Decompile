package id.dana.domain.wallet_v3.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/wallet_v3/model/WalletV3RestrictedErrorCodes;", "", "", "", "errorCodes", "Ljava/util/List;", "getErrorCodes", "()Ljava/util/List;", "", "isEnable", "Z", "()Z", "", "waitingTime", "I", "getWaitingTime", "()I", "<init>", "(ZLjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletV3RestrictedErrorCodes {
    @SerializedName("error_codes")
    private final List<String> errorCodes;
    @SerializedName("enable")
    private final boolean isEnable;
    @SerializedName("waiting_time")
    private final int waitingTime;

    public WalletV3RestrictedErrorCodes(boolean z, List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.isEnable = z;
        this.errorCodes = list;
        this.waitingTime = i;
    }

    @JvmName(name = "isEnable")
    /* renamed from: isEnable  reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    @JvmName(name = "getErrorCodes")
    public final List<String> getErrorCodes() {
        return this.errorCodes;
    }

    @JvmName(name = "getWaitingTime")
    public final int getWaitingTime() {
        return this.waitingTime;
    }
}
