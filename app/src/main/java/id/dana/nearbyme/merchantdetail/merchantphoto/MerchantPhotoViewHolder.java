package id.dana.nearbyme.merchantdetail.merchantphoto;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotoViewHolder extends BaseRecyclerViewHolder<MerchantImageModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantImageModel merchantImageModel) {
        MerchantImageModel merchantImageModel2 = merchantImageModel;
        if (merchantImageModel2 != null) {
            byte b = 0;
            if (SvgLoader.getAuthRequestContext(merchantImageModel2.BuiltInFictitiousFunctionClassFactory)) {
                SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = merchantImageModel2.BuiltInFictitiousFunctionClassFactory;
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ImageView) this.itemView.findViewById(R.id.iv_merchant_photo);
                new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                return;
            }
            GlideRequest<Drawable> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(merchantImageModel2.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.getAuthRequestContext(new CenterCrop(), new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28552131165359), 1, RoundedCornersTransformation.CornerType.ALL));
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) requestOptions).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.iv_merchant_photo));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPhotoViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_merchant_photo, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
    }
}
