package id.dana.social.bottomsheet;

import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.config.model.ReportReasons;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/bottomsheet/ReasonReportViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/domain/config/model/ReportReasons;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReasonReportViewHolder extends BaseRecyclerViewHolder<ReportReasons> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ReportReasons reportReasons) {
        ReportReasons reportReasons2 = reportReasons;
        Intrinsics.checkNotNullParameter(reportReasons2, "");
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "en")) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tv_report_reason);
            if (appCompatTextView != null) {
                appCompatTextView.setText(reportReasons2.getEn());
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.itemView.findViewById(R.id.tv_report_reason);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(reportReasons2.getId());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReasonReportViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_reason_report_list, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
