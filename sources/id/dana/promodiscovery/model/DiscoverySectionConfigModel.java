package id.dana.promodiscovery.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/promodiscovery/model/DiscoverySectionConfigModel;", "", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "p0", "p1", "p2", "<init>", "(IZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiscoverySectionConfigModel {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean getAuthRequestContext;

    public DiscoverySectionConfigModel() {
        this(0, false, null, 7, null);
    }

    public DiscoverySectionConfigModel(int i, boolean z, String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = z;
        this.PlaceComponentResult = str;
    }

    public /* synthetic */ DiscoverySectionConfigModel(int i, boolean z, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 5 : i, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? "PRIORITY" : str);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
