package id.dana.cashier.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014"}, d2 = {"Lid/dana/cashier/domain/model/CashierHighlightConfig;", "", "", "", "desc", "Ljava/util/List;", "getDesc", "()Ljava/util/List;", "instId", "Ljava/lang/String;", "getInstId", "()Ljava/lang/String;", "mode", "getMode", "subtitle", "getSubtitle", "", "timeShow", "I", "getTimeShow", "()I", "title", "getTitle", "version", "getVersion", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierHighlightConfig {
    private final List<String> desc;
    private final String instId;
    private final String mode;
    private final List<String> subtitle;
    private final int timeShow;
    private final List<String> title;
    private final int version;

    public CashierHighlightConfig() {
        this(null, 0, null, null, null, 0, null, 127, null);
    }

    public CashierHighlightConfig(String str, int i, List<String> list, List<String> list2, String str2, int i2, List<String> list3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        this.mode = str;
        this.version = i;
        this.title = list;
        this.subtitle = list2;
        this.instId = str2;
        this.timeShow = i2;
        this.desc = list3;
    }

    @JvmName(name = "getMode")
    public final String getMode() {
        return this.mode;
    }

    @JvmName(name = "getVersion")
    public final int getVersion() {
        return this.version;
    }

    public /* synthetic */ CashierHighlightConfig(String str, int i, List list, List list2, String str2, int i2, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 16) == 0 ? str2 : "", (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list3);
    }

    @JvmName(name = "getTitle")
    public final List<String> getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final List<String> getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getTimeShow")
    public final int getTimeShow() {
        return this.timeShow;
    }

    @JvmName(name = "getDesc")
    public final List<String> getDesc() {
        return this.desc;
    }
}
