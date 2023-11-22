package id.dana.drawable.merchantdetail.adapter;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.model.ShopOpenHourModel;
import id.dana.utils.DateTimeUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/OpenHourDetailAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopOpenHourModel;", "<init>", "()V", "OpenHourDetailViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OpenHourDetailAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ShopOpenHourModel>, ShopOpenHourModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new OpenHourDetailViewHolder(viewGroup);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/OpenHourDetailAdapter$OpenHourDetailViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopOpenHourModel;", "Landroid/widget/TextView;", "", "p0", "", "PlaceComponentResult", "(Landroid/widget/TextView;Z)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OpenHourDetailViewHolder extends BaseRecyclerViewHolder<ShopOpenHourModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(ShopOpenHourModel shopOpenHourModel) {
            ShopOpenHourModel shopOpenHourModel2 = shopOpenHourModel;
            if (shopOpenHourModel2 != null) {
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.SessionAwareObject);
                if (textView != null) {
                    textView.setText(shopOpenHourModel2.BuiltInFictitiousFunctionClassFactory);
                }
                if (shopOpenHourModel2.getMyBillsEntityDataFactory()) {
                    TextView textView2 = (TextView) view.findViewById(R.id.toCityName);
                    if (textView2 != null) {
                        textView2.setText(view.getContext().getString(R.string.full_day_open_hour));
                    }
                } else if (shopOpenHourModel2.PlaceComponentResult == 0 || shopOpenHourModel2.getAuthRequestContext == 0) {
                    TextView textView3 = (TextView) view.findViewById(R.id.toCityName);
                    if (textView3 != null) {
                        textView3.setText(view.getContext().getString(R.string.close_hour));
                    }
                } else {
                    String BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory(new Date(shopOpenHourModel2.PlaceComponentResult * 1000));
                    String BuiltInFictitiousFunctionClassFactory2 = DateTimeUtil.BuiltInFictitiousFunctionClassFactory(new Date(shopOpenHourModel2.getAuthRequestContext * 1000));
                    TextView textView4 = (TextView) view.findViewById(R.id.toCityName);
                    if (textView4 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(BuiltInFictitiousFunctionClassFactory);
                        sb.append(" - ");
                        sb.append(BuiltInFictitiousFunctionClassFactory2);
                        textView4.setText(sb.toString());
                    }
                }
                TextView textView5 = (TextView) view.findViewById(R.id.SessionAwareObject);
                if (textView5 != null) {
                    Intrinsics.checkNotNullExpressionValue(textView5, "");
                    PlaceComponentResult(textView5, shopOpenHourModel2.getKClassImpl$Data$declaredNonStaticMembers$2());
                }
                TextView textView6 = (TextView) view.findViewById(R.id.toCityName);
                if (textView6 != null) {
                    Intrinsics.checkNotNullExpressionValue(textView6, "");
                    PlaceComponentResult(textView6, shopOpenHourModel2.getKClassImpl$Data$declaredNonStaticMembers$2());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHourDetailViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_open_hour_detail, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }

        private static void PlaceComponentResult(TextView textView, boolean z) {
            Typeface PlaceComponentResult;
            int BuiltInFictitiousFunctionClassFactory;
            if (z) {
                PlaceComponentResult = ResourcesCompat.PlaceComponentResult(textView.getContext(), (int) R.font.f34282131296266);
            } else {
                PlaceComponentResult = ResourcesCompat.PlaceComponentResult(textView.getContext(), (int) R.font.MyBillsEntityDataFactory);
            }
            textView.setTypeface(PlaceComponentResult);
            if (z) {
                BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), R.color.getErrorConfigVersion_res_0x7f0602a3);
            } else {
                BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), R.color.f26762131100391);
            }
            textView.setTextColor(BuiltInFictitiousFunctionClassFactory);
        }
    }
}
