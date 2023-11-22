package id.dana.sendmoney.ui.globalsend.form.model;

import id.dana.core.ui.model.CurrencyAmountModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0011\u0010\u0007\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "", "Lid/dana/core/ui/model/CurrencyAmountModel;", "MyBillsEntityDataFactory", "Lid/dana/core/ui/model/CurrencyAmountModel;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Lid/dana/sendmoney/ui/globalsend/form/model/TransferUserInfoModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/TransferUserInfoModel;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/SubTransferMethodInfoModel;", "getErrorConfigVersion", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Ljava/util/List;Lid/dana/sendmoney/ui/globalsend/form/model/TransferUserInfoModel;Lid/dana/sendmoney/ui/globalsend/form/model/TransferUserInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalTransferInitModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final CurrencyAmountModel getAuthRequestContext;
    public final CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final CurrencyAmountModel PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final TransferUserInfoModel MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final TransferUserInfoModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<SubTransferMethodInfoModel> NetworkUserEntityData$$ExternalSyntheticLambda0;

    public GlobalTransferInitModel(CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, CurrencyAmountModel currencyAmountModel3, List<SubTransferMethodInfoModel> list, TransferUserInfoModel transferUserInfoModel, TransferUserInfoModel transferUserInfoModel2) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel2, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(transferUserInfoModel, "");
        Intrinsics.checkNotNullParameter(transferUserInfoModel2, "");
        this.getAuthRequestContext = currencyAmountModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = currencyAmountModel2;
        this.PlaceComponentResult = currencyAmountModel3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = list;
        this.BuiltInFictitiousFunctionClassFactory = transferUserInfoModel;
        this.MyBillsEntityDataFactory = transferUserInfoModel2;
    }
}
