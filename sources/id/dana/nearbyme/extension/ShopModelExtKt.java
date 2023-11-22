package id.dana.nearbyme.extension;

import id.dana.domain.nearbyme.model.MerchantInfo;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.model.ShopOpenHourModel;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a&\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\u0018\u0010\t\u001a\u00020\u0004*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\u0018\u0010\n\u001a\u00020\u0004*\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006*\b\u0012\u0004\u0012\u00020\u00020\u0006\u001a \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a4\u0010\u0012\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0014*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f0\u000f0\u0013*\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¨\u0006\u0015"}, d2 = {"getOpenHourType", "Lid/dana/nearbyme/model/ShopOpenHourModel$OpenHourType;", "Lid/dana/nearbyme/model/ShopModel;", "isMatchCategory", "", "merchantListCategories", "", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "merchantMapsCategories", "isMatchMerchantListCategory", "isMatchMerchantMapsCategory", "toMerchantInfo", "Lid/dana/domain/nearbyme/model/MerchantInfo;", "toMerchantInfos", "toRankedShopModel", "", "lastRankedShop", "", "toRankedShopModelsObservable", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopModelExtKt {
    public static final List<MerchantInfo> KClassImpl$Data$declaredNonStaticMembers$2(List<? extends ShopModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends ShopModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ShopModel shopModel : list2) {
            Intrinsics.checkNotNullParameter(shopModel, "");
            arrayList.add(new MerchantInfo(shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3, shopModel.BottomSheetCardBindingView$watcherCardNumberView$1));
        }
        return arrayList;
    }

    public static final boolean PlaceComponentResult(ShopModel shopModel, List<? extends MerchantCategoryModel> list, List<? extends MerchantCategoryModel> list2) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(shopModel, list) && BuiltInFictitiousFunctionClassFactory(shopModel, list2);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(ShopModel shopModel, List<? extends MerchantCategoryModel> list) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.contains(MerchantCategoryModel.BuiltInFictitiousFunctionClassFactory)) {
            return true;
        }
        Iterator<? extends MerchantCategoryModel> it = list.iterator();
        while (it.hasNext()) {
            if (shopModel.BuiltInFictitiousFunctionClassFactory(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(ShopModel shopModel, List<? extends MerchantCategoryModel> list) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            return true;
        }
        Iterator<? extends MerchantCategoryModel> it = list.iterator();
        while (it.hasNext()) {
            if (!shopModel.BuiltInFictitiousFunctionClassFactory(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final List<ShopModel> PlaceComponentResult(List<ShopModel> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        int i2 = 0;
        for (Object obj : list) {
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ShopModel shopModel = (ShopModel) obj;
            shopModel.initRecordTimeStamp = false;
            shopModel.whenAvailable = i2 + i + 1;
            i2++;
        }
        return list;
    }

    public static /* synthetic */ Observable getAuthRequestContext(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        Observable fromCallable = Observable.fromCallable(new ShopModelExtKt$$ExternalSyntheticLambda0(list, 0));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    public static final Observable<List<ShopModel>> BuiltInFictitiousFunctionClassFactory(List<ShopModel> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        Observable<List<ShopModel>> fromCallable = Observable.fromCallable(new ShopModelExtKt$$ExternalSyntheticLambda0(list, i));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    public static /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        return PlaceComponentResult(list, i);
    }

    public static final ShopOpenHourModel.OpenHourType KClassImpl$Data$declaredNonStaticMembers$2(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        List<ShopOpenHourModel> list = shopModel.C;
        if (list == null || list.isEmpty()) {
            return ShopOpenHourModel.OpenHourType.NONE;
        }
        return shopModel.C.get(ShopModel.KClassImpl$Data$declaredNonStaticMembers$2()).MyBillsEntityDataFactory();
    }
}
