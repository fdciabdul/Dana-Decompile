package id.dana.globalsearch.view.sku.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.view.ViewExtKt;
import id.dana.globalsearch.view.sku.model.SKUModel;
import id.dana.richview.imageview.ImageWithDescriptionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/globalsearch/view/sku/adapter/SKUItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/globalsearch/view/sku/model/SKUModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SKUItemViewHolder extends BaseRecyclerViewHolder<SKUModel> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[SKUModel.MerchantState.values().length];
            iArr[SKUModel.MerchantState.CLOSED.ordinal()] = 1;
            iArr[SKUModel.MerchantState.OUT_OF_STOCK.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SKUModel sKUModel) {
        String str;
        String string;
        SKUModel sKUModel2 = sKUModel;
        Intrinsics.checkNotNullParameter(sKUModel2, "");
        ImageWithDescriptionView imageWithDescriptionView = (ImageWithDescriptionView) this.itemView.findViewById(R.id.res_0x7f0a0920_streambitmapdecoder_untrustedcallbacks);
        imageWithDescriptionView.showImage(sKUModel2.MyBillsEntityDataFactory);
        imageWithDescriptionView.setTitle(sKUModel2.KClassImpl$Data$declaredNonStaticMembers$2);
        if (sKUModel2.getAuthRequestContext.length() == 0) {
            str = sKUModel2.BuiltInFictitiousFunctionClassFactory;
        } else {
            str = sKUModel2.getAuthRequestContext;
        }
        imageWithDescriptionView.setDescription(str);
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[sKUModel2.lookAheadTest.ordinal()];
        if (i == 1) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) imageWithDescriptionView._$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat);
            if (appCompatImageView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView);
            }
            string = imageWithDescriptionView.getContext().getString(R.string.closed);
        } else if (i == 2) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) imageWithDescriptionView._$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat);
            if (appCompatImageView2 != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView2);
            }
            string = imageWithDescriptionView.getContext().getString(R.string.out_of_stock);
        } else {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) imageWithDescriptionView._$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat);
            if (appCompatImageView3 != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
                ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView3);
            }
            string = null;
        }
        imageWithDescriptionView.setNote(string);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SKUItemViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_sku, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
