package id.dana.sendmoney.ui.globalsend.form.mapper;

import id.dana.sendmoney.domain.globalsend.model.country.Country;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/country/Country;", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/domain/globalsend/model/country/Country;)Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CountryModelMapperKt {
    public static final CountryModel MyBillsEntityDataFactory(Country country) {
        Intrinsics.checkNotNullParameter(country, "");
        return new CountryModel(country.BuiltInFictitiousFunctionClassFactory, country.MyBillsEntityDataFactory, country.getAuthRequestContext, country.KClassImpl$Data$declaredNonStaticMembers$2, country.PlaceComponentResult, country.getErrorConfigVersion, country.NetworkUserEntityData$$ExternalSyntheticLambda0, country.scheduleImpl, country.getLookAheadTest(), country.getMoveToNextValue());
    }
}
