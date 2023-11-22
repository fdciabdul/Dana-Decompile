package id.dana.mybills.data.model.response;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/mybills/data/model/response/IntervalInfo;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntervalInfo {
    private final String type;
    private final int value;

    public IntervalInfo(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        this.type = str;
        this.value = i;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getValue")
    public final int getValue() {
        return this.value;
    }
}
