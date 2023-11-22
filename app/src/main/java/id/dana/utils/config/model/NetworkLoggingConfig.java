package id.dana.utils.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u000e\b\u0003\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0007¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/utils/config/model/NetworkLoggingConfig;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "MyBillsEntityDataFactory", "()Z", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "getAuthRequestContext", "", "PlaceComponentResult", "Ljava/lang/Long;", "p0", "p1", "p2", "<init>", "(ZLjava/util/List;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkLoggingConfig {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public List<String> getAuthRequestContext;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Long PlaceComponentResult;

    public /* synthetic */ NetworkLoggingConfig() {
    }

    private NetworkLoggingConfig(boolean z, @JSONField(name = "excluded_errors") List<String> list, Long l) {
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.getAuthRequestContext = list;
        this.PlaceComponentResult = l;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public /* synthetic */ NetworkLoggingConfig(boolean z, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : l);
    }
}
