package id.dana.globalsearch.adapter;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.view.ViewExtKt;
import id.dana.richview.EllipseTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00062\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/globalsearch/adapter/PopularSearchAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/globalsearch/adapter/PopularSearchAdapter$PopularSearchViewHolder;", "", "<init>", "()V", "Companion", "PopularSearchViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PopularSearchAdapter extends BaseRecyclerViewAdapter<PopularSearchViewHolder, String> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new PopularSearchViewHolder(viewGroup);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/globalsearch/adapter/PopularSearchAdapter$PopularSearchViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PopularSearchViewHolder extends BaseRecyclerViewHolder<String> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(String str) {
            String str2;
            String str3 = str;
            Intrinsics.checkNotNullParameter(str3, "");
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.res_0x7f0a0da5_access_getnativepattern_p);
            if (linearLayout != null) {
                linearLayout.setContentDescription(getContext().getString(R.string.btn_top_searches));
            }
            EllipseTextView ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
            if (ellipseTextView != null) {
                ellipseTextView.setContentDescription(ellipseTextView.getContext().getString(R.string.lbl_top_searches));
                ellipseTextView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27072131100488));
                ellipseTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.black_text));
                ellipseTextView.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27032131100473));
                ellipseTextView.setCornerRadius(ellipseTextView.getContext().getResources().getDimension(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f));
                ViewExtKt.PlaceComponentResult(ellipseTextView, 0, 0, 16, 16);
                if (str3.length() > 20) {
                    StringBuilder sb = new StringBuilder();
                    String substring = str3.substring(0, 20);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    sb.append(substring);
                    sb.append("...");
                    str2 = sb.toString();
                } else {
                    str2 = str3;
                }
                ellipseTextView.setText(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PopularSearchViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_ellipse_text, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}
