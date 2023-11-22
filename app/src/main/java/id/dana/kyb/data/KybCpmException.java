package id.dana.kyb.data;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/kyb/data/KybCpmException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "merchantName", "Ljava/lang/String;", "getMerchantName", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybCpmException extends Exception {
    private final String merchantName;

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybCpmException(String str, String str2) {
        super(str2);
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantName = str;
    }
}
