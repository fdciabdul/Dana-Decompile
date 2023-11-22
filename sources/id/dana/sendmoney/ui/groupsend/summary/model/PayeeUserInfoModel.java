package id.dana.sendmoney.ui.groupsend.summary.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\tR\u0011\u0010\u000b\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0011\u0010\f\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\r\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0011\u0010\u000f\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0011\u0010\u0010\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/model/PayeeUserInfoModel;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "lookAheadTest", "Z", "()Z", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "moveToNextValue", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PayeeUserInfoModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getErrorConfigVersion;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String lookAheadTest;

    public PayeeUserInfoModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.lookAheadTest = str;
        this.getErrorConfigVersion = str2;
        this.MyBillsEntityDataFactory = str3;
        this.getAuthRequestContext = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.moveToNextValue = str6;
        this.scheduleImpl = str7;
        this.PlaceComponentResult = z;
        this.BuiltInFictitiousFunctionClassFactory = str8;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
