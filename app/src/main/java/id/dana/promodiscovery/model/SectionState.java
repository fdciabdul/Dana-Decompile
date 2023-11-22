package id.dana.promodiscovery.model;

import id.dana.oauth.OauthConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e"}, d2 = {"Lid/dana/promodiscovery/model/SectionState;", "", "", OauthConstant.PathParams.STATE_CODE, "I", "getStateCode", "()I", "<init>", "(Ljava/lang/String;II)V", "LOADING", "ACTIVE", "ERROR_NETWORK", "ERROR_GENERAL", "ERROR_LOCATION_PERMISSION", "HIDDEN"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum SectionState {
    LOADING(1),
    ACTIVE(2),
    ERROR_NETWORK(3),
    ERROR_GENERAL(4),
    ERROR_LOCATION_PERMISSION(5),
    HIDDEN(6);

    private final int stateCode;

    SectionState(int i) {
        this.stateCode = i;
    }

    @JvmName(name = "getStateCode")
    public final int getStateCode() {
        return this.stateCode;
    }
}
