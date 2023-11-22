package id.dana.sendmoney.ui.globalsend.form.model.form.receiver;

import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryFormModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;", "MyBillsEntityDataFactory", "", "getAuthRequestContext", "I", "PlaceComponentResult", "p0", "p1", "p2", "<init>", "(ILid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CountryFormModel extends GlobalSendFormModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final CurrencyRateModel MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CountryModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryFormModel(int i, CountryModel countryModel, CurrencyRateModel currencyRateModel) {
        super(4, 0, 2, null);
        Intrinsics.checkNotNullParameter(countryModel, "");
        Intrinsics.checkNotNullParameter(currencyRateModel, "");
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = countryModel;
        this.MyBillsEntityDataFactory = currencyRateModel;
    }
}
