package id.dana.nearbyme.merchantdetail.mapper;

import id.dana.domain.merchant.model.MerchantSubcategory;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.nearbyme.model.ContactAddressModel;
import id.dana.nearbyme.model.MerchantSubcategoryModel;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopOpenHourModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\r\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0011"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mapper/MerchantDetailMapper;", "", "Lid/dana/domain/nearbyme/model/ContactAddress;", "p0", "Lid/dana/nearbyme/model/ContactAddressModel;", "getAuthRequestContext", "(Lid/dana/domain/nearbyme/model/ContactAddress;)Lid/dana/nearbyme/model/ContactAddressModel;", "Lid/dana/domain/merchant/model/MerchantSubcategory;", "Lid/dana/nearbyme/model/MerchantSubcategoryModel;", "PlaceComponentResult", "(Lid/dana/domain/merchant/model/MerchantSubcategory;)Lid/dana/nearbyme/model/MerchantSubcategoryModel;", "Lid/dana/domain/nearbyme/model/PromoInfo;", "Lid/dana/nearbyme/model/PromoInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/nearbyme/model/PromoInfo;)Lid/dana/nearbyme/model/PromoInfoModel;", "Lid/dana/domain/nearbyme/model/ShopOpenHour;", "Lid/dana/nearbyme/model/ShopOpenHourModel;", "(Lid/dana/domain/nearbyme/model/ShopOpenHour;)Lid/dana/nearbyme/model/ShopOpenHourModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailMapper {
    @Inject
    public MerchantDetailMapper() {
    }

    public static ContactAddressModel getAuthRequestContext(ContactAddress p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ContactAddressModel contactAddressModel = new ContactAddressModel();
        contactAddressModel.PlaceComponentResult = p0.getAddress1();
        contactAddressModel.BuiltInFictitiousFunctionClassFactory = p0.getAddress2();
        contactAddressModel.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getArea();
        contactAddressModel.getAuthRequestContext = p0.getCity();
        contactAddressModel.MyBillsEntityDataFactory = p0.getContactAddressId();
        contactAddressModel.getErrorConfigVersion = p0.getContactAddressType();
        contactAddressModel.scheduleImpl = p0.getCountry();
        contactAddressModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0.getExtendInfo();
        contactAddressModel.moveToNextValue = p0.getProvince();
        contactAddressModel.initRecordTimeStamp = p0.getZipcode();
        return contactAddressModel;
    }

    public static PromoInfoModel BuiltInFictitiousFunctionClassFactory(PromoInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PromoInfoModel promoInfoModel = new PromoInfoModel();
        promoInfoModel.BuiltInFictitiousFunctionClassFactory = p0.getActivityId();
        promoInfoModel.getErrorConfigVersion = p0.getPrizeType();
        promoInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0.getPromoDescription();
        promoInfoModel.initRecordTimeStamp = p0.getPromoValue();
        promoInfoModel.moveToNextValue = p0.getPromoType();
        return promoInfoModel;
    }

    public static ShopOpenHourModel BuiltInFictitiousFunctionClassFactory(ShopOpenHour p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ShopOpenHourModel shopOpenHourModel = new ShopOpenHourModel(null, 0L, 0L, false, false, 31, null);
        String day = p0.getDay();
        Intrinsics.checkNotNullParameter(day, "");
        shopOpenHourModel.BuiltInFictitiousFunctionClassFactory = day;
        shopOpenHourModel.PlaceComponentResult = p0.getOpenHour();
        shopOpenHourModel.getAuthRequestContext = p0.getCloseHour();
        return shopOpenHourModel;
    }

    public static MerchantSubcategoryModel PlaceComponentResult(MerchantSubcategory p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MerchantSubcategoryModel merchantSubcategoryModel = new MerchantSubcategoryModel();
        merchantSubcategoryModel.getAuthRequestContext = p0.getMcc();
        merchantSubcategoryModel.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getName();
        merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory = p0.getCategoryIds();
        return merchantSubcategoryModel;
    }
}
