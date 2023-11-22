package id.dana.nearbyme.extension;

import android.content.ClipData;
import android.location.Location;
import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.domain.nearbyme.model.MerchantReview;
import id.dana.domain.nearbyme.model.MerchantReviews;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewResultModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.model.ShopModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0006\u001a\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\f\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0006\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0002\u001a \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n*\b\u0012\u0004\u0012\u00020\u00130\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\n*\b\u0012\u0004\u0012\u00020\u00180\n\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u001b\u001a\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\n*\u00020\u001a¨\u0006\u001e"}, d2 = {"distanceToUser", "", "Landroid/location/Location;", "encodeBase64", "", "getDeeplinkUrl", "Lid/dana/nearbyme/model/ShopModel;", "getDeeplinkV2Url", "getDisplayedRating", "getItems", "", "Landroid/net/Uri;", "Landroid/content/ClipData;", "isRatingAndReviewExist", "", "toGoogleLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "toMerchantImageModels", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Lid/dana/domain/nearbyme/model/MerchantImage;", "type", "", "toMerchantReviewModels", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "Lid/dana/domain/nearbyme/model/MerchantReview;", "toMerchantReviewResultModel", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewResultModel;", "Lid/dana/domain/nearbyme/model/MerchantReviews;", "toMerchantReviewViewModel", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyExtensionKt {
    public static /* synthetic */ List getAuthRequestContext(List list) {
        return getAuthRequestContext(list, 0);
    }

    public static final List<MerchantImageModel> getAuthRequestContext(List<MerchantImage> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        List<MerchantImage> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MerchantImage merchantImage : list2) {
            arrayList.add(new MerchantImageModel(merchantImage.getUserId(), merchantImage.getUserName(), merchantImage.getAvatar(), merchantImage.getImageUrl(), i));
        }
        return arrayList;
    }

    public static final List<MerchantReviewModel> MyBillsEntityDataFactory(List<MerchantReview> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<MerchantReview> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MerchantReview merchantReview : list2) {
            arrayList.add(new MerchantReviewModel(merchantReview.getUserId(), merchantReview.getUserName(), merchantReview.getAvatar(), merchantReview.getReview(), merchantReview.getRating(), merchantReview.getModifyDate(), merchantReview.getCreatedDate(), getAuthRequestContext(merchantReview.getImages(), 0), merchantReview.getMerchantName(), merchantReview.getMerchantId(), merchantReview.getEditable(), merchantReview.getPositiveTags(), merchantReview.getNegativeSentiments(), merchantReview.getShopId(), merchantReview.getMainName(), merchantReview.getLogoUrl(), merchantReview.getReviewId()));
        }
        return arrayList;
    }

    public static final MerchantReviewResultModel MyBillsEntityDataFactory(MerchantReviews merchantReviews) {
        Intrinsics.checkNotNullParameter(merchantReviews, "");
        return new MerchantReviewResultModel(merchantReviews.getHasMore(), MyBillsEntityDataFactory(merchantReviews.getReviews()));
    }

    public static final List<Uri> KClassImpl$Data$declaredNonStaticMembers$2(ClipData clipData) {
        Intrinsics.checkNotNullParameter(clipData, "");
        ArrayList arrayList = new ArrayList();
        int itemCount = clipData.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            Uri uri = clipData.getItemAt(i).getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "");
            arrayList.add(uri);
        }
        return arrayList;
    }

    public static final LatLng BuiltInFictitiousFunctionClassFactory(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        return new LatLng(location.getLatitude(), location.getLongitude());
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] encode = Base64.encode(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encode, "");
        return StringsKt.trim((CharSequence) new String(encode, Charsets.UTF_8)).toString();
    }

    public static final String MyBillsEntityDataFactory(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        StringBuilder sb = new StringBuilder();
        sb.append("https://link.dana.id/merchant-detail?params=[s=");
        String str = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(str, "");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2(str));
        sb.append(",m=");
        String str2 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2(str2));
        sb.append(']');
        return sb.toString();
    }

    public static final String PlaceComponentResult(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        StringBuilder sb = new StringBuilder();
        sb.append("params=[s=");
        sb.append(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1);
        sb.append(']');
        String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("https://link.dana.id/shop?e=");
        sb2.append(KClassImpl$Data$declaredNonStaticMembers$2);
        return sb2.toString();
    }

    public static final String BuiltInFictitiousFunctionClassFactory(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        String format = new DecimalFormat("##.0").format(shopModel.readMicros);
        Intrinsics.checkNotNullExpressionValue(format, "");
        return StringsKt.replace$default(format, ",", ".", false, 4, (Object) null);
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        if (shopModel.readMicros == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        return !((shopModel.SubSequence > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (shopModel.SubSequence == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) == 0);
    }

    public static final List<MerchantReviewViewModel> PlaceComponentResult(MerchantReviewResultModel merchantReviewResultModel) {
        Intrinsics.checkNotNullParameter(merchantReviewResultModel, "");
        List<MerchantReviewModel> list = merchantReviewResultModel.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (MerchantReviewModel merchantReviewModel : list) {
            MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
            arrayList.add(MerchantReviewModel.Companion.getAuthRequestContext(merchantReviewModel));
        }
        return arrayList;
    }
}
