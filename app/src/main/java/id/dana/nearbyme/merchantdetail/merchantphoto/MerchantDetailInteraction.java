package id.dana.nearbyme.merchantdetail.merchantphoto;

import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantDetailInteraction;", "", "dismissLoadingDialog", "", "onImageLoaded", "images", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "provideShopModel", "Lid/dana/nearbyme/model/ShopModel;", ZolozEkycH5Handler.HUMMER_FOUNDATION_SHOW_LOADING_DIALOG, "updatePromoBadge", "shopModel", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MerchantDetailInteraction {

    /* renamed from: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        public static void MyBillsEntityDataFactory(ShopModel shopModel) {
            Intrinsics.checkNotNullParameter(shopModel, "");
        }

        public static void PlaceComponentResult() {
        }

        public static ShopModel getAuthRequestContext() {
            return null;
        }
    }

    void dismissLoadingDialog();

    void onImageLoaded(List<MerchantImageModel> images);

    void showLoadingDialog();

    void updatePromoBadge(ShopModel shopModel);
}
