package id.dana.animation;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.animation.model.EddQuestionInfoDTOModel;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/home/KycAmlEddHeaderViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/home/model/EddQuestionInfoDTOModel;", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "getAuthRequestContext", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KycAmlEddHeaderViewHolder extends BaseRecyclerViewHolder<EddQuestionInfoDTOModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ViewGroup getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(EddQuestionInfoDTOModel eddQuestionInfoDTOModel) {
        Intrinsics.checkNotNullParameter(eddQuestionInfoDTOModel, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KycAmlEddHeaderViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.kyc_aml_edd_header_view_holder, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = viewGroup;
    }
}
