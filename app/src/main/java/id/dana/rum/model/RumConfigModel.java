package id.dana.rum.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\n\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/rum/model/RumConfigModel;", "", "", "PlaceComponentResult", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "getAuthRequestContext", "MyBillsEntityDataFactory", "Lid/dana/rum/model/SplunkConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/rum/model/SplunkConfig;", "p0", "p1", "p2", "<init>", "(ZZLid/dana/rum/model/SplunkConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RumConfigModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;
    public final SplunkConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    public RumConfigModel() {
        this(false, false, null, 7, null);
    }

    public RumConfigModel(boolean z, boolean z2, SplunkConfig splunkConfig) {
        Intrinsics.checkNotNullParameter(splunkConfig, "");
        this.getAuthRequestContext = z;
        this.MyBillsEntityDataFactory = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splunkConfig;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public /* synthetic */ RumConfigModel(boolean z, boolean z2, SplunkConfig splunkConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? new SplunkConfig(false, false) : splunkConfig);
    }
}
