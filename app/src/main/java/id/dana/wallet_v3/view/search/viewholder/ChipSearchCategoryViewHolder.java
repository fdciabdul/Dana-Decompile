package id.dana.wallet_v3.view.search.viewholder;

import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.EllipseTextView;
import id.dana.wallet_v3.view.search.model.SearchCategoryModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B'\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/wallet_v3/view/search/viewholder/ChipSearchCategoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;", "data", "", "bindData", "(Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;)V", "setChipBackground", "()V", "", "setChipTitle", "(Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;)Ljava/lang/String;", "Lkotlin/Function1;", "onClickListener", "Lkotlin/jvm/functions/Function1;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChipSearchCategoryViewHolder extends BaseRecyclerViewHolder<SearchCategoryModel> {
    public static final String LANGUAGE_IN = "in";
    private final Function1<SearchCategoryModel, Unit> onClickListener;

    public /* synthetic */ ChipSearchCategoryViewHolder(ViewGroup viewGroup, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChipSearchCategoryViewHolder(ViewGroup viewGroup, Function1<? super SearchCategoryModel, Unit> function1) {
        super(viewGroup.getContext(), R.layout.view_ellipse_text, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.onClickListener = function1;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(final SearchCategoryModel data) {
        Intrinsics.checkNotNullParameter(data, "");
        EllipseTextView ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
        if (ellipseTextView != null) {
            ellipseTextView.setText(setChipTitle(data));
            setChipBackground();
        }
        setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.wallet_v3.view.search.viewholder.ChipSearchCategoryViewHolder$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ChipSearchCategoryViewHolder.m3113bindData$lambda1(ChipSearchCategoryViewHolder.this, data, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-1  reason: not valid java name */
    public static final void m3113bindData$lambda1(ChipSearchCategoryViewHolder chipSearchCategoryViewHolder, SearchCategoryModel searchCategoryModel, int i) {
        Intrinsics.checkNotNullParameter(chipSearchCategoryViewHolder, "");
        Intrinsics.checkNotNullParameter(searchCategoryModel, "");
        Function1<SearchCategoryModel, Unit> function1 = chipSearchCategoryViewHolder.onClickListener;
        if (function1 != null) {
            function1.invoke(searchCategoryModel);
        }
    }

    private final String setChipTitle(SearchCategoryModel data) {
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), new Locale("in").getLanguage())) {
            return data.getTitleId();
        }
        return data.getTitleEn();
    }

    private final void setChipBackground() {
        EllipseTextView ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
        if (ellipseTextView != null) {
            ellipseTextView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27072131100488));
            ellipseTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f22852131099735));
            ellipseTextView.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27032131100473));
        }
    }
}
