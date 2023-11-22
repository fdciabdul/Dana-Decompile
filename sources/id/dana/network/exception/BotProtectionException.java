package id.dana.network.exception;

import com.alipay.imobile.network.quake.exception.ServerException;
import com.huawei.hms.push.e;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/network/exception/BotProtectionException;", "Lcom/alipay/imobile/network/quake/exception/ServerException;", "", "challengeContext", "Ljava/lang/String;", "getChallengeContext", "()Ljava/lang/String;", "", "isChallenged", "Z", "()Z", "", "code", "", e.PlaceComponentResult, "<init>", "(Ljava/lang/Integer;Ljava/lang/Throwable;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BotProtectionException extends ServerException {
    private final String challengeContext;
    private final boolean isChallenged;

    @JvmName(name = "getChallengeContext")
    public final String getChallengeContext() {
        return this.challengeContext;
    }

    @JvmName(name = "isChallenged")
    /* renamed from: isChallenged  reason: from getter */
    public final boolean getIsChallenged() {
        return this.isChallenged;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BotProtectionException(Integer num, Throwable th, String str, boolean z) {
        super(num, th, str);
        Intrinsics.checkNotNullParameter(str, "");
        this.challengeContext = str;
        this.isChallenged = z;
    }
}
