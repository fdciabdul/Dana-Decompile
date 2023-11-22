package id.dana.domain.resetpin.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/domain/resetpin/model/ConsultDanaVizModel;", "", "", "isForced", "Z", "()Z", "isShowDanaVizPrompt", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultDanaVizModel {
    private final boolean isForced;
    private final boolean isShowDanaVizPrompt;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ConsultDanaVizModel() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.resetpin.model.ConsultDanaVizModel.<init>():void");
    }

    public ConsultDanaVizModel(boolean z, boolean z2) {
        this.isShowDanaVizPrompt = z;
        this.isForced = z2;
    }

    public /* synthetic */ ConsultDanaVizModel(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    @JvmName(name = "isShowDanaVizPrompt")
    /* renamed from: isShowDanaVizPrompt  reason: from getter */
    public final boolean getIsShowDanaVizPrompt() {
        return this.isShowDanaVizPrompt;
    }

    @JvmName(name = "isForced")
    /* renamed from: isForced  reason: from getter */
    public final boolean getIsForced() {
        return this.isForced;
    }
}
