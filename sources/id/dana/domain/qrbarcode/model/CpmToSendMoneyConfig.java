package id.dana.domain.qrbarcode.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00048\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/domain/qrbarcode/model/CpmToSendMoneyConfig;", "", "", "source", "", "containAnyPrefix", "(Ljava/lang/String;)Z", "isNeedToshowDialog", "Z", "()Z", "setNeedToshowDialog", "(Z)V", "", "qrisCpmPrefixes", "Ljava/util/List;", "getQrisCpmPrefixes", "()Ljava/util/List;", "setQrisCpmPrefixes", "(Ljava/util/List;)V", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CpmToSendMoneyConfig {
    private boolean isNeedToshowDialog;
    private List<String> qrisCpmPrefixes;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CpmToSendMoneyConfig() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.qrbarcode.model.CpmToSendMoneyConfig.<init>():void");
    }

    public CpmToSendMoneyConfig(boolean z, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.isNeedToshowDialog = z;
        this.qrisCpmPrefixes = list;
    }

    @JvmName(name = "isNeedToshowDialog")
    /* renamed from: isNeedToshowDialog  reason: from getter */
    public final boolean getIsNeedToshowDialog() {
        return this.isNeedToshowDialog;
    }

    @JvmName(name = "setNeedToshowDialog")
    public final void setNeedToshowDialog(boolean z) {
        this.isNeedToshowDialog = z;
    }

    public /* synthetic */ CpmToSendMoneyConfig(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getQrisCpmPrefixes")
    public final List<String> getQrisCpmPrefixes() {
        return this.qrisCpmPrefixes;
    }

    @JvmName(name = "setQrisCpmPrefixes")
    public final void setQrisCpmPrefixes(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.qrisCpmPrefixes = list;
    }

    public final boolean containAnyPrefix(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        List<String> list = this.qrisCpmPrefixes;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.startsWith$default(source, (String) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
