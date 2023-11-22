package id.dana.domain.transferaccount;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/domain/transferaccount/TransferAccountStatus;", "", "", "balanceTransfer", "Ljava/lang/String;", "getBalanceTransfer", "()Ljava/lang/String;", "setBalanceTransfer", "(Ljava/lang/String;)V", "changeMobile", "getChangeMobile", "setChangeMobile", "changePin", "getChangePin", "setChangePin", "deleteUser", "getDeleteUser", "setDeleteUser", "errorMessage", "getErrorMessage", "setErrorMessage", "status", "getStatus", "setStatus", "token", "getToken", "setToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransferAccountStatus {
    private String balanceTransfer;
    private String changeMobile;
    private String changePin;
    private String deleteUser;
    private String errorMessage;
    private String status;
    private String token;

    public TransferAccountStatus(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.status = str;
        this.token = str2;
        this.deleteUser = str3;
        this.changeMobile = str4;
        this.changePin = str5;
        this.balanceTransfer = str6;
        this.errorMessage = str7;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = str;
    }

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "setToken")
    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.token = str;
    }

    @JvmName(name = "getDeleteUser")
    public final String getDeleteUser() {
        return this.deleteUser;
    }

    @JvmName(name = "setDeleteUser")
    public final void setDeleteUser(String str) {
        this.deleteUser = str;
    }

    @JvmName(name = "getChangeMobile")
    public final String getChangeMobile() {
        return this.changeMobile;
    }

    @JvmName(name = "setChangeMobile")
    public final void setChangeMobile(String str) {
        this.changeMobile = str;
    }

    @JvmName(name = "getChangePin")
    public final String getChangePin() {
        return this.changePin;
    }

    @JvmName(name = "setChangePin")
    public final void setChangePin(String str) {
        this.changePin = str;
    }

    @JvmName(name = "getBalanceTransfer")
    public final String getBalanceTransfer() {
        return this.balanceTransfer;
    }

    @JvmName(name = "setBalanceTransfer")
    public final void setBalanceTransfer(String str) {
        this.balanceTransfer = str;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @JvmName(name = "setErrorMessage")
    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
