package id.dana.cashier.data.repository.source.network.result;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierHighlightConfigResult;", "", "", "", "desc", "Ljava/util/List;", "getDesc", "()Ljava/util/List;", "instId", "Ljava/lang/String;", "getInstId", "()Ljava/lang/String;", "mode", "getMode", "subtitle", "getSubtitle", "", "timeShowInDays", "Ljava/lang/Integer;", "getTimeShowInDays", "()Ljava/lang/Integer;", "title", "getTitle", "version", "getVersion", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierHighlightConfigResult {
    public List<String> desc;
    public String instId;
    public String mode;
    public List<String> subtitle;
    public Integer timeShowInDays;
    public List<String> title;
    public Integer version;

    public CashierHighlightConfigResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public CashierHighlightConfigResult(String str, Integer num, List<String> list, List<String> list2, String str2, Integer num2, List<String> list3) {
        this.mode = str;
        this.version = num;
        this.title = list;
        this.subtitle = list2;
        this.instId = str2;
        this.timeShowInDays = num2;
        this.desc = list3;
    }

    @JvmName(name = "getMode")
    public final String getMode() {
        return this.mode;
    }

    public /* synthetic */ CashierHighlightConfigResult(String str, Integer num, List list, List list2, String str2, Integer num2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) == 0 ? str2 : "", (i & 32) != 0 ? 0 : num2, (i & 64) != 0 ? CollectionsKt.emptyList() : list3);
    }

    @JvmName(name = "getVersion")
    public final Integer getVersion() {
        return this.version;
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

    @JvmName(name = "getTimeShowInDays")
    public final Integer getTimeShowInDays() {
        return this.timeShowInDays;
    }

    @JvmName(name = "getDesc")
    public final List<String> getDesc() {
        return this.desc;
    }
}
