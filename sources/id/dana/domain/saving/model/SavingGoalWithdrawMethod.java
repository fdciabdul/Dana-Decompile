package id.dana.domain.saving.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b"}, d2 = {"Lid/dana/domain/saving/model/SavingGoalWithdrawMethod;", "", "", "enableWithdrawSaveAccount", "Z", "getEnableWithdrawSaveAccount", "()Z", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "errorMsg", "getErrorMsg", "success", "getSuccess", "withdrawMethod", "getWithdrawMethod", "<init>", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavingGoalWithdrawMethod {
    private final boolean enableWithdrawSaveAccount;
    private final String errorCode;
    private final String errorMsg;
    private final boolean success;
    private final String withdrawMethod;

    public SavingGoalWithdrawMethod(String str, boolean z, boolean z2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.withdrawMethod = str;
        this.enableWithdrawSaveAccount = z;
        this.success = z2;
        this.errorCode = str2;
        this.errorMsg = str3;
    }

    public /* synthetic */ SavingGoalWithdrawMethod(String str, boolean z, boolean z2, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3);
    }

    @JvmName(name = "getWithdrawMethod")
    public final String getWithdrawMethod() {
        return this.withdrawMethod;
    }

    @JvmName(name = "getEnableWithdrawSaveAccount")
    public final boolean getEnableWithdrawSaveAccount() {
        return this.enableWithdrawSaveAccount;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getErrorMsg")
    public final String getErrorMsg() {
        return this.errorMsg;
    }
}
