package id.dana.nearbyme.extension;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.request.target.ViewTarget;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.core.ui.glide.GlideApp;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u000f\u001a\u0016\u0012\b\u0012\u0006*\u00020\u00110\u0011\u0012\b\u0012\u0006*\u00020\u00140\u00140\u0013*\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0015"}, d2 = {"Lid/dana/base/BaseActivity;", "p0", "Lid/dana/nearbyme/model/ShopModel;", "p1", "", "p2", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "p3", "", "PlaceComponentResult", "(Lid/dana/base/BaseActivity;Lid/dana/nearbyme/model/ShopModel;ILjava/util/List;)V", "Landroid/view/View;", "Lkotlin/Lazy;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "(Landroid/view/View;)Lkotlin/Lazy;", "Landroid/widget/ImageView;", "", "Lcom/bumptech/glide/request/target/ViewTarget;", "Landroid/graphics/drawable/Drawable;", "(Landroid/widget/ImageView;Ljava/lang/String;)Lcom/bumptech/glide/request/target/ViewTarget;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NearbyViewExtKt {
    public static final ViewTarget<ImageView, Drawable> MyBillsEntityDataFactory(ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(imageView, "");
        Intrinsics.checkNotNullParameter(str, "");
        ViewTarget<ImageView, Drawable> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(str).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).MyBillsEntityDataFactory(imageView);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static final Lazy<SkeletonScreen> MyBillsEntityDataFactory(final View view) {
        Intrinsics.checkNotNullParameter(view, "");
        final int i = R.layout.view_merchant_promo_skeleton;
        return LazyKt.lazy(new Function0<SkeletonScreen>() { // from class: id.dana.nearbyme.extension.NearbyViewExtKt$skeletonScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SkeletonScreen invoke() {
                return ShimmeringUtil.PlaceComponentResult(view, i);
            }
        });
    }

    public static final void PlaceComponentResult(BaseActivity baseActivity, ShopModel shopModel, int i, List<MerchantImageModel> list) {
        Intrinsics.checkNotNullParameter(baseActivity, "");
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
        FragmentManager supportFragmentManager = baseActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        String str = shopModel.newProxyInstance;
        if (str == null) {
            str = "";
        }
        String str2 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
        MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, new MerchantPhotoViewerModel(str, str2 != null ? str2 : "", new MediaViewerModel(i, 5, 1, 0, false, list, 16, null)));
    }
}
