package id.dana.data.home.mapper;

import id.dana.data.home.repository.source.presistence.entity.SingleBalanceDaoEntity;
import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/user/CurrencyAmount;", "", "p0", "Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;", "getAuthRequestContext", "(Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;)Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;)Lid/dana/domain/user/CurrencyAmount;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SingleBalanceMapperKt {
    public static final SingleBalanceDaoEntity getAuthRequestContext(CurrencyAmount currencyAmount, String str) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        Intrinsics.checkNotNullParameter(str, "");
        return new SingleBalanceDaoEntity(str, currencyAmount.getAmount(), currencyAmount.getCurrency(), true);
    }

    public static final CurrencyAmount BuiltInFictitiousFunctionClassFactory(SingleBalanceDaoEntity singleBalanceDaoEntity) {
        Intrinsics.checkNotNullParameter(singleBalanceDaoEntity, "");
        CurrencyAmount currencyAmount = new CurrencyAmount();
        currencyAmount.setAmount(singleBalanceDaoEntity.MyBillsEntityDataFactory);
        currencyAmount.setCurrency(singleBalanceDaoEntity.PlaceComponentResult);
        currencyAmount.setPlaceholder(singleBalanceDaoEntity.getGetAuthRequestContext());
        return currencyAmount;
    }
}
