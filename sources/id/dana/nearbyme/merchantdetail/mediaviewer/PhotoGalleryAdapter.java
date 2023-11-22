package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function1;", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "PhotoPreviewViewHolderr"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhotoGalleryAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantImageModel>, MerchantImageModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<Integer, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PhotoPreviewViewHolderr photoPreviewViewHolderr;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1 || i == 2) {
            PhotoPreviewViewHolderr photoPreviewViewHolderr2 = new PhotoPreviewViewHolderr(viewGroup);
            final Function1<Integer, Unit> function1 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            photoPreviewViewHolderr2.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryAdapter$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i2) {
                    PhotoGalleryAdapter.KClassImpl$Data$declaredNonStaticMembers$2(Function1.this, i2);
                }
            });
            photoPreviewViewHolderr = photoPreviewViewHolderr2;
        } else {
            PhotoGalleryViewHolder photoGalleryViewHolder = new PhotoGalleryViewHolder(viewGroup);
            final Function1<Integer, Unit> function12 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            photoGalleryViewHolder.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryAdapter$$ExternalSyntheticLambda1
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i2) {
                    PhotoGalleryAdapter.getAuthRequestContext(Function1.this, i2);
                }
            });
            photoPreviewViewHolderr = photoGalleryViewHolder;
        }
        return photoPreviewViewHolderr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoGalleryAdapter(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).MyBillsEntityDataFactory;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryAdapter$PhotoPreviewViewHolderr;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PhotoPreviewViewHolderr extends BaseRecyclerViewHolder<MerchantImageModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantImageModel merchantImageModel) {
            String string;
            MerchantImageModel merchantImageModel2 = merchantImageModel;
            if (merchantImageModel2 != null) {
                Context context = getContext();
                if (context != null) {
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(context).getAuthRequestContext(merchantImageModel2.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory((int) R.color.f23952131099990).BuiltInFictitiousFunctionClassFactory(R.color.f23952131099990).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.res_0x7f0a0a13_audiomanager_onmodechangedlistener));
                }
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.res_0x7f0a0a13_audiomanager_onmodechangedlistener);
                if (merchantImageModel2.MyBillsEntityDataFactory == 2) {
                    string = getContext().getString(R.string.btnMerchantGallery);
                } else {
                    string = getContext().getString(R.string.btnMerchantImages);
                }
                imageView.setContentDescription(string);
                TextView textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a155d_paymentcardsview_1);
                if (textView != null) {
                    textView.setVisibility(merchantImageModel2.MyBillsEntityDataFactory == 2 ? 0 : 8);
                }
                ImageView imageView2 = (ImageView) this.itemView.findViewById(R.id.getRssi);
                if (imageView2 != null) {
                    imageView2.setVisibility(merchantImageModel2.MyBillsEntityDataFactory == 2 ? 0 : 8);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PhotoPreviewViewHolderr(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_photo_preview, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    public static /* synthetic */ void getAuthRequestContext(Function1 function1, int i) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(Integer.valueOf(i));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, int i) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(Integer.valueOf(i));
    }
}
