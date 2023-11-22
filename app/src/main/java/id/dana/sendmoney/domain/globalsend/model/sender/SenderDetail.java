package id.dana.sendmoney.domain.globalsend.model.sender;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;", "Ljava/io/Serializable;", "", "address", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "email", "getEmail", "setEmail", "", "hasShown", "Z", "getHasShown", "()Z", "setHasShown", "(Z)V", "ktpId", "getKtpId", "setKtpId", "ktpName", "getKtpName", "setKtpName", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SenderDetail implements Serializable {
    public String address;
    public String email;
    public boolean hasShown;
    public String ktpId;
    public String ktpName;

    public SenderDetail() {
        this(false, null, null, null, null, 31, null);
    }

    public SenderDetail(boolean z, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.hasShown = z;
        this.ktpName = str;
        this.ktpId = str2;
        this.address = str3;
        this.email = str4;
    }

    public /* synthetic */ SenderDetail(boolean z, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) == 0 ? str4 : "");
    }

    @JvmName(name = "getHasShown")
    public final boolean getHasShown() {
        return this.hasShown;
    }

    @JvmName(name = "setHasShown")
    public final void setHasShown(boolean z) {
        this.hasShown = z;
    }

    @JvmName(name = "getKtpName")
    public final String getKtpName() {
        return this.ktpName;
    }

    @JvmName(name = "setKtpName")
    public final void setKtpName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.ktpName = str;
    }

    @JvmName(name = "getKtpId")
    public final String getKtpId() {
        return this.ktpId;
    }

    @JvmName(name = "setKtpId")
    public final void setKtpId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.ktpId = str;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "setAddress")
    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.address = str;
    }

    @JvmName(name = "getEmail")
    public final String getEmail() {
        return this.email;
    }

    @JvmName(name = "setEmail")
    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.email = str;
    }
}
