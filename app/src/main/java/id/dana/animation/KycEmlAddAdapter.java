package id.dana.animation;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.animation.model.EddQuestionInfoDTOModel;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B/\u0012&\u0010\u0005\u001a\"\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R4\u0010\u000e\u001a\"\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u0004\u0012\u00020\u000b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/home/KycEmlAddAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/home/model/EddQuestionInfoDTOModel;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function2;", "PlaceComponentResult", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KycEmlAddAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<EddQuestionInfoDTOModel>, EddQuestionInfoDTOModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function2<String, String, Unit> PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        KycAmlEddItemViewHolder kycAmlEddItemViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            kycAmlEddItemViewHolder = new KycAmlEddHeaderViewHolder(viewGroup);
        } else {
            kycAmlEddItemViewHolder = new KycAmlEddItemViewHolder(viewGroup, this.PlaceComponentResult);
        }
        return kycAmlEddItemViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KycEmlAddAdapter(Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.PlaceComponentResult = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).PlaceComponentResult;
    }
}
