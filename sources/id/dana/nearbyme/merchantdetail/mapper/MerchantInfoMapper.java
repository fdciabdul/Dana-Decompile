package id.dana.nearbyme.merchantdetail.mapper;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.nearbyme.merchantdetail.model.MerchantInfoModel;
import id.dana.nearbyme.model.ContactAddressModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mapper/MerchantInfoMapper;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(J)Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/Shop;", "p1", "Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/nearbyme/model/Shop;Ljava/lang/String;)Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantInfoMapper {
    @Inject
    public MerchantInfoMapper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MerchantInfoModel MyBillsEntityDataFactory(Shop p0, String p1) {
        ContactAddress contactAddress;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        List<ShopOpenHour> shopOpenHours = p0.getShopOpenHours();
        ShopOpenHour shopOpenHour = null;
        if (shopOpenHours != null) {
            boolean z = false;
            Iterator<T> it = shopOpenHours.iterator();
            ShopOpenHour shopOpenHour2 = null;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    String day = ((ShopOpenHour) next).getDay();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String upperCase = p1.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "");
                    if (Intrinsics.areEqual(day, upperCase)) {
                        if (z) {
                            break;
                        }
                        z = true;
                        shopOpenHour2 = next;
                    }
                } else if (z) {
                    shopOpenHour = shopOpenHour2;
                }
            }
            shopOpenHour = shopOpenHour;
        }
        String merchantId = p0.getMerchantId();
        String str = merchantId == null ? "" : merchantId;
        String shopId = p0.getShopId();
        String str2 = shopId == null ? "" : shopId;
        String mainName = p0.getMainName();
        String str3 = mainName == null ? "" : mainName;
        String shopDesc = p0.getShopDesc();
        String shopType = p0.getShopType();
        String logoUrl = p0.getLogoUrl();
        boolean fullDay = p0.getFullDay();
        double rating = p0.getRating();
        double reviewNumbers = p0.getReviewNumbers();
        List<String> officeNumbers = p0.getOfficeNumbers();
        if (officeNumbers == null) {
            officeNumbers = CollectionsKt.emptyList();
        }
        List<String> list = officeNumbers;
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(shopOpenHour != null ? shopOpenHour.getCloseHour() : 0L);
        String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(shopOpenHour != null ? shopOpenHour.getOpenHour() : 0L);
        double latitude = p0.getLatitude();
        double longtitude = p0.getLongtitude();
        List<ContactAddress> contactAddresses = p0.getContactAddresses();
        if (contactAddresses == null || (contactAddress = (ContactAddress) CollectionsKt.lastOrNull((List) contactAddresses)) == null) {
            contactAddress = new ContactAddress(null, null, null, null, null, null, null, false, null, null, false, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
        }
        ContactAddressModel contactAddressModel = new ContactAddressModel();
        contactAddressModel.PlaceComponentResult = contactAddress.getAddress1();
        contactAddressModel.BuiltInFictitiousFunctionClassFactory = contactAddress.getAddress2();
        contactAddressModel.KClassImpl$Data$declaredNonStaticMembers$2 = contactAddress.getArea();
        contactAddressModel.getAuthRequestContext = contactAddress.getCity();
        contactAddressModel.MyBillsEntityDataFactory = contactAddress.getContactAddressId();
        contactAddressModel.getErrorConfigVersion = contactAddress.getContactAddressType();
        contactAddressModel.scheduleImpl = contactAddress.getCountry();
        contactAddressModel.lookAheadTest = contactAddress.isDefaultAddress();
        contactAddressModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = contactAddress.getExtendInfo();
        contactAddressModel.moveToNextValue = contactAddress.getProvince();
        contactAddressModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = contactAddress.isVerified();
        contactAddressModel.initRecordTimeStamp = contactAddress.getZipcode();
        return new MerchantInfoModel(str, str2, str3, shopDesc, shopType, logoUrl, fullDay, latitude, longtitude, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory, Double.valueOf(rating), Double.valueOf(reviewNumbers), list, contactAddressModel);
    }

    private static String BuiltInFictitiousFunctionClassFactory(long p0) {
        if (p0 == 0) {
            return "";
        }
        String format = new SimpleDateFormat("HH.mm", Locale.getDefault()).format(new Date(p0 * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }
}
