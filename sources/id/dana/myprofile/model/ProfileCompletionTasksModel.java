package id.dana.myprofile.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\n\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0012\u0010\u000b\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004"}, d2 = {"Lid/dana/myprofile/model/ProfileCompletionTasksModel;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "", "MyBillsEntityDataFactory", "Z", "()Z", "PlaceComponentResult", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ProfileCompletionTasksModel {
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String getAuthRequestContext;

    public ProfileCompletionTasksModel() {
        this(null, null, false, null, 15, null);
    }

    public ProfileCompletionTasksModel(String str, String str2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.MyBillsEntityDataFactory = z;
        this.BuiltInFictitiousFunctionClassFactory = str3;
    }

    public /* synthetic */ ProfileCompletionTasksModel(String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
