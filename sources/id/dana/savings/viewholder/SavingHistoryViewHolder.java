package id.dana.savings.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.savings.model.TopUpModel;
import id.dana.savings.model.TopUpStatus;
import id.dana.utils.BalanceUtil;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/savings/viewholder/SavingHistoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/savings/model/TopUpModel;", "Lid/dana/savings/model/TopUpStatus;", "p0", "", "p1", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/savings/model/TopUpStatus;II)V", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingHistoryViewHolder extends BaseRecyclerViewHolder<TopUpModel> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[TopUpStatus.values().length];
            iArr[TopUpStatus.FAILED.ordinal()] = 1;
            iArr[TopUpStatus.CLOSE.ordinal()] = 2;
            iArr[TopUpStatus.PENDING.ordinal()] = 3;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(TopUpModel topUpModel) {
        TopUpModel topUpModel2 = topUpModel;
        if (topUpModel2 != null) {
            TopUpStatus topUpStatus = topUpModel2.BuiltInFictitiousFunctionClassFactory;
            int i = topUpStatus == null ? -1 : WhenMappings.BuiltInFictitiousFunctionClassFactory[topUpStatus.ordinal()];
            if (i == 1 || i == 2) {
                BuiltInFictitiousFunctionClassFactory(topUpStatus, R.color.f23962131099992, R.color.f23962131099992);
            } else if (i == 3) {
                BuiltInFictitiousFunctionClassFactory(topUpStatus, R.color.f24002131099997, R.color.f27152131100507);
            } else {
                BuiltInFictitiousFunctionClassFactory(null, R.color.f24002131099997, R.color.f23962131099992);
            }
            TextView textView = (TextView) this.itemView.findViewById(R.id.setDrawValueAboveBar);
            if (textView != null) {
                textView.setText(getContext().getString(R.string.top_up_history_title));
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.In);
            if (textView2 != null) {
                textView2.setText(DateTimeUtil.BuiltInFictitiousFunctionClassFactory("dd MMMM yyy • HH:mm", LocaleUtil.getAuthRequestContext(), Long.parseLong(topUpModel2.MyBillsEntityDataFactory)));
            }
            TextView textView3 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
            if (textView3 != null) {
                textView3.setText(BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(topUpModel2.PlaceComponentResult.PlaceComponentResult));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavingHistoryViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_saving_history, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    private final void BuiltInFictitiousFunctionClassFactory(TopUpStatus p0, int p1, int p2) {
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R.id.setDrawValueAboveBar);
        if (textView != null) {
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), p1));
        }
        TextView textView2 = (TextView) view.findViewById(R.id.In);
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), p1));
        }
        TextView textView3 = (TextView) view.findViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
        if (textView3 != null) {
            textView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), p1));
        }
        TextView textView4 = (TextView) view.findViewById(R.id.writeBigDecimal);
        if (textView4 != null) {
            Intrinsics.checkNotNullExpressionValue(textView4, "");
            textView4.setVisibility(p0 != null ? 0 : 8);
        }
        if (p0 != null) {
            TextView textView5 = (TextView) view.findViewById(R.id.writeBigDecimal);
            if (textView5 != null) {
                textView5.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), p2));
            }
            TextView textView6 = (TextView) view.findViewById(R.id.writeBigDecimal);
            if (textView6 != null) {
                String lowerCase = p0.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                if (lowerCase.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    String upperCase = String.valueOf(lowerCase.charAt(0)).toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "");
                    sb.append((Object) upperCase);
                    String substring = lowerCase.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    sb.append(substring);
                    lowerCase = sb.toString();
                }
                textView6.setText(lowerCase);
            }
        }
    }
}
