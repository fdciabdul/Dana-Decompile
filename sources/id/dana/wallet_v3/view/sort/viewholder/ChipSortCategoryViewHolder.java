package id.dana.wallet_v3.view.sort.viewholder;

import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.EllipseTextView;
import id.dana.wallet_v3.view.sort.model.SortCategoryModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B-\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bR(\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/wallet_v3/view/sort/viewholder/ChipSortCategoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "data", "", "bindData", "(Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;)V", "selectedView", "()V", "", "setChipTitle", "(Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;)Ljava/lang/String;", "unSelectView", "Lkotlin/Function2;", "", "onClickListener", "Lkotlin/jvm/functions/Function2;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChipSortCategoryViewHolder extends BaseRecyclerViewHolder<SortCategoryModel> {
    public static final String LANGUAGE_IN = "in";
    private final Function2<SortCategoryModel, Integer, Unit> onClickListener;

    public /* synthetic */ ChipSortCategoryViewHolder(ViewGroup viewGroup, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : function2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChipSortCategoryViewHolder(ViewGroup viewGroup, Function2<? super SortCategoryModel, ? super Integer, Unit> function2) {
        super(viewGroup.getContext(), R.layout.view_ellipse_text, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.onClickListener = function2;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(final SortCategoryModel data) {
        Intrinsics.checkNotNullParameter(data, "");
        EllipseTextView ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
        if (ellipseTextView != null) {
            ellipseTextView.setText(setChipTitle(data));
            if (data.isSelected()) {
                selectedView();
            } else {
                unSelectView();
            }
        }
        setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.wallet_v3.view.sort.viewholder.ChipSortCategoryViewHolder$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ChipSortCategoryViewHolder.m3116bindData$lambda1(ChipSortCategoryViewHolder.this, data, i);
            }
        });
    }

    /* renamed from: bindData$lambda-1 */
    public static final void m3116bindData$lambda1(ChipSortCategoryViewHolder chipSortCategoryViewHolder, SortCategoryModel sortCategoryModel, int i) {
        Intrinsics.checkNotNullParameter(chipSortCategoryViewHolder, "");
        Intrinsics.checkNotNullParameter(sortCategoryModel, "");
        Function2<SortCategoryModel, Integer, Unit> function2 = chipSortCategoryViewHolder.onClickListener;
        if (function2 != null) {
            function2.invoke(sortCategoryModel, Integer.valueOf(i));
        }
    }

    private final String setChipTitle(SortCategoryModel data) {
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), new Locale("in").getLanguage())) {
            return data.getTitleId();
        }
        return data.getTitleEn();
    }

    public final void selectedView() {
        EllipseTextView ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
        if (ellipseTextView != null) {
            ellipseTextView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.azure));
            ellipseTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27072131100488));
            ellipseTextView.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.azure));
        }
    }

    public final void unSelectView() {
        EllipseTextView ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
        if (ellipseTextView != null) {
            ellipseTextView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27072131100488));
            ellipseTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f22852131099735));
            ellipseTextView.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27032131100473));
        }
    }
}
