package id.dana.sendmoney.ui.globalsend.landing.model;

import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\n\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;", "", "", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "getAuthRequestContext", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "p0", "p1", "p2", "<init>", "(Ljava/util/List;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryBeneficiaryResultModel {
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<BeneficiaryInfoModel> BuiltInFictitiousFunctionClassFactory;

    public QueryBeneficiaryResultModel() {
        this(null, 0, null, 7, null);
    }

    public QueryBeneficiaryResultModel(List<BeneficiaryInfoModel> list, int i, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = str;
    }

    public /* synthetic */ QueryBeneficiaryResultModel(ArrayList arrayList, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ArrayList() : arrayList, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str);
    }
}
