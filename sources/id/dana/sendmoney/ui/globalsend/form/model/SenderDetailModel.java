package id.dana.sendmoney.ui.globalsend.form.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\u0003\u0010\tR\u0012\u0010\u000b\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Z", "()Z", "PlaceComponentResult", "MyBillsEntityDataFactory", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SenderDetailModel {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    public SenderDetailModel(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.PlaceComponentResult = false;
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
