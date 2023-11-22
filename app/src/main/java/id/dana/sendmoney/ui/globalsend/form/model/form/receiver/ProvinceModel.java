package id.dana.sendmoney.ui.globalsend.form.model.form.receiver;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/ProvinceModel;", "", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CityModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProvinceModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<CityModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    public ProvinceModel(String str, String str2, List<CityModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }
}
