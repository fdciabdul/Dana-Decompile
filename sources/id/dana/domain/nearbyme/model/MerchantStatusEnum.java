package id.dana.domain.nearbyme.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantStatusEnum;", "", "", "code", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "PENDING", "ACTIVE", "FROZEN"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum MerchantStatusEnum {
    PENDING("PENDING", "merchant is initial status"),
    ACTIVE("ACTIVE", "merchant is active status"),
    FROZEN("FROZEN", "merchant is frozen status");

    private String code;
    private String description;

    MerchantStatusEnum(String str, String str2) {
        this.code = str;
        this.description = str2;
    }

    @JvmName(name = "getCode")
    public final String getCode() {
        return this.code;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setCode")
    public final void setCode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.code = str;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.description = str;
    }
}
