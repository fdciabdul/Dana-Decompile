package id.dana.nearbyme.merchantdetail.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.utils.UrlUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewholder/MerchantLatestReviewPhotoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "", "PlaceComponentResult", "Z", "", "Ljava/util/List;", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Ljava/util/List;Lkotlin/jvm/functions/Function1;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLatestReviewPhotoViewHolder extends BaseRecyclerViewHolder<MerchantImageModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<MediaViewerModel, Unit> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<MerchantImageModel> PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantImageModel merchantImageModel) {
        MerchantImageModel merchantImageModel2 = merchantImageModel;
        if (merchantImageModel2 != null) {
            String str = merchantImageModel2.BuiltInFictitiousFunctionClassFactory;
            if (str != null) {
                GlideRequest<Drawable> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(UrlUtil.getAuthRequestContext(str)).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext);
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.getAuthRequestContext(new CenterCrop(), new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28552131165359), 1, RoundedCornersTransformation.CornerType.ALL));
                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) requestOptions).getErrorConfigVersion((int) R.drawable.square_rounded_skeleton).PlaceComponentResult((int) R.drawable.square_rounded_skeleton).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.res_0x7f0a0b3f_lambda_buildusecaseobservable_0_id_dana_domain_synccontact_interactor_synccontact));
            } else {
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.res_0x7f0a0b3f_lambda_buildusecaseobservable_0_id_dana_domain_synccontact_interactor_synccontact);
                if (imageView != null) {
                    InstrumentInjector.Resources_setImageResource(imageView, R.drawable.square_rounded_skeleton);
                }
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                ViewGroup.LayoutParams layoutParams = ((ImageView) this.itemView.findViewById(R.id.res_0x7f0a0b3f_lambda_buildusecaseobservable_0_id_dana_domain_synccontact_interactor_synccontact)).getLayoutParams();
                layoutParams.height = SizeUtil.PlaceComponentResult(80);
                layoutParams.width = SizeUtil.PlaceComponentResult(80);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MerchantLatestReviewPhotoViewHolder(ViewGroup viewGroup, List<MerchantImageModel> list, Function1<? super MediaViewerModel, Unit> function1, boolean z) {
        super(viewGroup.getContext(), R.layout.view_item_latest_review_photo, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = function1;
        this.BuiltInFictitiousFunctionClassFactory = z;
        ((ImageView) this.itemView.findViewById(R.id.res_0x7f0a0b3f_lambda_buildusecaseobservable_0_id_dana_domain_synccontact_interactor_synccontact)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewholder.MerchantLatestReviewPhotoViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantLatestReviewPhotoViewHolder.BuiltInFictitiousFunctionClassFactory(MerchantLatestReviewPhotoViewHolder.this);
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MerchantLatestReviewPhotoViewHolder merchantLatestReviewPhotoViewHolder) {
        Intrinsics.checkNotNullParameter(merchantLatestReviewPhotoViewHolder, "");
        if (merchantLatestReviewPhotoViewHolder.getAdapterPosition() != -1) {
            merchantLatestReviewPhotoViewHolder.getAuthRequestContext.invoke(new MediaViewerModel(merchantLatestReviewPhotoViewHolder.getAdapterPosition(), 10, 0, 0, false, merchantLatestReviewPhotoViewHolder.PlaceComponentResult));
        }
    }
}
