package id.dana.data.here.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f"}, d2 = {"Lid/dana/data/here/model/HereConfigResponse;", "", "", "", "excludeSource", "Ljava/util/List;", "getExcludeSource", "()Ljava/util/List;", "", "factor", "Ljava/lang/Integer;", "getFactor", "()Ljava/lang/Integer;", "maxBackoff", "getMaxBackoff", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HereConfigResponse {
    public List<String> excludeSource;
    public Integer factor;
    public Integer maxBackoff;

    public HereConfigResponse() {
        this(null, null, null, 7, null);
    }

    public HereConfigResponse(Integer num, Integer num2, List<String> list) {
        this.maxBackoff = num;
        this.factor = num2;
        this.excludeSource = list;
    }

    public /* synthetic */ HereConfigResponse(Integer num, Integer num2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 60 : num, (i & 2) != 0 ? 3 : num2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getMaxBackoff")
    public final Integer getMaxBackoff() {
        return this.maxBackoff;
    }

    @JvmName(name = "getFactor")
    public final Integer getFactor() {
        return this.factor;
    }

    @JvmName(name = "getExcludeSource")
    public final List<String> getExcludeSource() {
        return this.excludeSource;
    }
}
