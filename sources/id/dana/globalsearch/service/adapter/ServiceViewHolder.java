package id.dana.globalsearch.service.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.ContextExtKt;
import id.dana.globalsearch.mapper.ConvertMapToPojoKt;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.richview.imageview.ImageWithHorizontalDescriptionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/globalsearch/service/adapter/ServiceViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceViewHolder extends BaseRecyclerViewHolder<PaySearchInfoModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PaySearchInfoModel paySearchInfoModel) {
        ImageWithHorizontalDescriptionView imageWithHorizontalDescriptionView;
        PaySearchInfoModel paySearchInfoModel2 = paySearchInfoModel;
        if (paySearchInfoModel2 == null || (imageWithHorizontalDescriptionView = (ImageWithHorizontalDescriptionView) this.itemView.findViewById(R.id.res_0x7f0a0c78_callerimpl_method_jvmstaticinobject)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(imageWithHorizontalDescriptionView, "");
        imageWithHorizontalDescriptionView.showImage(paySearchInfoModel2.moveToNextValue);
        imageWithHorizontalDescriptionView.setTitleText(paySearchInfoModel2.GetContactSyncConfig);
        String str = ConvertMapToPojoKt.BuiltInFictitiousFunctionClassFactory(paySearchInfoModel2.getErrorConfigVersion).getAuthRequestContext;
        if (str == null) {
            str = "";
        }
        imageWithHorizontalDescriptionView.setUpperLineFirstText(str);
        imageWithHorizontalDescriptionView.setUpperLineRedNoteText(paySearchInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2);
        Context context = imageWithHorizontalDescriptionView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Drawable PlaceComponentResult = ContextExtKt.PlaceComponentResult(context, (int) R.drawable.ic_verify_blue);
        Intrinsics.checkNotNull(PlaceComponentResult);
        imageWithHorizontalDescriptionView.setTitleBadge(PlaceComponentResult);
        imageWithHorizontalDescriptionView.getStatusMaintenanceService(paySearchInfoModel2.getLookAheadTest());
        String string = imageWithHorizontalDescriptionView.getContext().getString(R.string.btnServices);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = imageWithHorizontalDescriptionView.getContext().getString(R.string.lblServicesName);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = imageWithHorizontalDescriptionView.getContext().getString(R.string.lblServicesCategory);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        imageWithHorizontalDescriptionView.setItemContentDescription(string, string2, string3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_search_result, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
