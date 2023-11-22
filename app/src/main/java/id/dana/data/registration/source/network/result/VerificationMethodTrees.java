package id.dana.data.registration.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/registration/source/network/result/VerificationMethodTrees;", "", "", "fallback", "Ljava/util/List;", "getFallback", "()Ljava/util/List;", "", CashierKeyParams.VERIFICATION_METHOD, "Ljava/lang/String;", "getVerificationMethod", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VerificationMethodTrees {
    @SerializedName("fallback")
    private final List<VerificationMethodTrees> fallback;
    @SerializedName(CashierKeyParams.VERIFICATION_METHOD)
    private final String verificationMethod;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VerificationMethodTrees() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.registration.source.network.result.VerificationMethodTrees.<init>():void");
    }

    public VerificationMethodTrees(@JSONField(name = "verificationMethod") String str, @JSONField(name = "fallback") List<VerificationMethodTrees> list) {
        this.verificationMethod = str;
        this.fallback = list;
    }

    public /* synthetic */ VerificationMethodTrees(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getFallback")
    public final List<VerificationMethodTrees> getFallback() {
        return this.fallback;
    }
}
