package id.dana.data.verifytoken.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.verifytoken.repository.model.VerifyToken;

/* loaded from: classes4.dex */
public class VerifyTokenResult extends BaseRpcResult {
    private long expiredTime;
    private long serverTime;
    private VerifyToken verifyToken;

    public VerifyToken getVerifyToken() {
        return this.verifyToken;
    }

    public void setVerifyToken(VerifyToken verifyToken) {
        this.verifyToken = verifyToken;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }
}
