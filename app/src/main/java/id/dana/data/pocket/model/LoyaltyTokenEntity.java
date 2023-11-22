package id.dana.data.pocket.model;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b"}, d2 = {"Lid/dana/data/pocket/model/LoyaltyTokenEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "accessToken", "Ljava/lang/String;", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "expiresIn", "getExpiresIn", "setExpiresIn", "refreshToken", "getRefreshToken", "setRefreshToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoyaltyTokenEntity extends BaseRpcResult {
    private String accessToken;
    private String expiresIn;
    private String refreshToken;

    public LoyaltyTokenEntity() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ LoyaltyTokenEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getAccessToken")
    public final String getAccessToken() {
        return this.accessToken;
    }

    @JvmName(name = "setAccessToken")
    public final void setAccessToken(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.accessToken = str;
    }

    @JvmName(name = "getExpiresIn")
    public final String getExpiresIn() {
        return this.expiresIn;
    }

    @JvmName(name = "setExpiresIn")
    public final void setExpiresIn(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.expiresIn = str;
    }

    @JvmName(name = "getRefreshToken")
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @JvmName(name = "setRefreshToken")
    public final void setRefreshToken(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.refreshToken = str;
    }

    public LoyaltyTokenEntity(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.accessToken = str;
        this.expiresIn = str2;
        this.refreshToken = str3;
    }
}
