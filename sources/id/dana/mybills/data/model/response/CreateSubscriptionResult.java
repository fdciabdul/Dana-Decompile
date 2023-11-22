package id.dana.mybills.data.model.response;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/mybills/data/model/response/CreateSubscriptionResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/mybills/data/model/response/ErrorContextEntity;", "errorContext", "Lid/dana/mybills/data/model/response/ErrorContextEntity;", "getErrorContext", "()Lid/dana/mybills/data/model/response/ErrorContextEntity;", "", "location", "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", BioUtilityBridge.SECURITY_ID, "getSecurityId", "subscriptionId", "getSubscriptionId", "", "verificationMethods", "Ljava/util/List;", "getVerificationMethods", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/mybills/data/model/response/ErrorContextEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateSubscriptionResult extends BaseRpcResultAphome {
    private final ErrorContextEntity errorContext;
    private final String location;
    private final String securityId;
    private final String subscriptionId;
    private final List<String> verificationMethods;

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getVerificationMethods")
    public final List<String> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "getErrorContext")
    public final ErrorContextEntity getErrorContext() {
        return this.errorContext;
    }

    public CreateSubscriptionResult(String str, String str2, List<String> list, String str3, ErrorContextEntity errorContextEntity) {
        this.subscriptionId = str;
        this.securityId = str2;
        this.verificationMethods = list;
        this.location = str3;
        this.errorContext = errorContextEntity;
    }
}
