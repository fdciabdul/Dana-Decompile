package id.dana.data.saving.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b"}, d2 = {"Lid/dana/data/saving/model/SavingLimitEntity;", "Ljava/io/Serializable;", "", "maxSavingAmountKyc", "Ljava/lang/String;", "getMaxSavingAmountKyc", "()Ljava/lang/String;", "setMaxSavingAmountKyc", "(Ljava/lang/String;)V", "maxSavingAmountNonKyc", "getMaxSavingAmountNonKyc", "setMaxSavingAmountNonKyc", "maxSavingCountNonKyc", "getMaxSavingCountNonKyc", "setMaxSavingCountNonKyc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavingLimitEntity implements Serializable {
    public String maxSavingAmountKyc;
    public String maxSavingAmountNonKyc;
    public String maxSavingCountNonKyc;

    public /* synthetic */ SavingLimitEntity() {
    }

    public SavingLimitEntity(@JSONField(name = "max_saving_count_non_kyc") String str, @JSONField(name = "max_saving_amount_non_kyc") String str2, @JSONField(name = "max_saving_amount_kyc") String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.maxSavingCountNonKyc = str;
        this.maxSavingAmountNonKyc = str2;
        this.maxSavingAmountKyc = str3;
    }

    @JvmName(name = "getMaxSavingCountNonKyc")
    public final String getMaxSavingCountNonKyc() {
        return this.maxSavingCountNonKyc;
    }

    @JvmName(name = "setMaxSavingCountNonKyc")
    public final void setMaxSavingCountNonKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingCountNonKyc = str;
    }

    @JvmName(name = "getMaxSavingAmountNonKyc")
    public final String getMaxSavingAmountNonKyc() {
        return this.maxSavingAmountNonKyc;
    }

    @JvmName(name = "setMaxSavingAmountNonKyc")
    public final void setMaxSavingAmountNonKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingAmountNonKyc = str;
    }

    @JvmName(name = "getMaxSavingAmountKyc")
    public final String getMaxSavingAmountKyc() {
        return this.maxSavingAmountKyc;
    }

    @JvmName(name = "setMaxSavingAmountKyc")
    public final void setMaxSavingAmountKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingAmountKyc = str;
    }
}
