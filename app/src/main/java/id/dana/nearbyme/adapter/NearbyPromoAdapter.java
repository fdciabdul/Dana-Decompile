package id.dana.nearbyme.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.adapter.NearbyPromoAdapter;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.PromoLimitInfoModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class NearbyPromoAdapter extends BaseRecyclerViewAdapter<ViewHolder, PromoInfoModel> {

    /* loaded from: classes9.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder getAuthRequestContext;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.getAuthRequestContext = viewHolder;
            viewHolder.tvNearbyPromoTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_nearby_promo_title, "field 'tvNearbyPromoTitle'", TextView.class);
            viewHolder.tvMaximumCashbackValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_maximum_cashback_value, "field 'tvMaximumCashbackValue'", TextView.class);
            viewHolder.tvPurchaseMinimumValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_purchase_minimum_value, "field 'tvPurchaseMinimumValue'", TextView.class);
            viewHolder.tvPromoExpandSwith = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_nearby_promo_expand_swith, "field 'tvPromoExpandSwith'", TextView.class);
            viewHolder.ivPromoExpandSwithArrow = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_nearby_promo_expand_swith_arrow, "field 'ivPromoExpandSwithArrow'", ImageView.class);
            viewHolder.tvPromoPeriodValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_nearby_promo_period_value, "field 'tvPromoPeriodValue'", TextView.class);
            viewHolder.tvUseLimitValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_nearby_promo_use_limit_value, "field 'tvUseLimitValue'", TextView.class);
            viewHolder.tvPaymentMethodValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_nearby_promo_payment_method_value, "field 'tvPaymentMethodValue'", TextView.class);
            viewHolder.llPromoExpandSwitch = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_nearby_promo_expand_swith, "field 'llPromoExpandSwitch'", LinearLayout.class);
            viewHolder.llPromoExpand = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_nearby_promo_expand, "field 'llPromoExpand'", LinearLayout.class);
            viewHolder.tvNearbyPromoUseLimitTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_nearby_promo_use_limit_title, "field 'tvNearbyPromoUseLimitTitle'", TextView.class);
            viewHolder.tvNearbyPromoPaymentMethodTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_nearby_promo_payment_method_title, "field 'tvNearbyPromoPaymentMethodTitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            ViewHolder viewHolder = this.getAuthRequestContext;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.getAuthRequestContext = null;
            viewHolder.tvNearbyPromoTitle = null;
            viewHolder.tvMaximumCashbackValue = null;
            viewHolder.tvPurchaseMinimumValue = null;
            viewHolder.tvPromoExpandSwith = null;
            viewHolder.ivPromoExpandSwithArrow = null;
            viewHolder.tvPromoPeriodValue = null;
            viewHolder.tvUseLimitValue = null;
            viewHolder.tvPaymentMethodValue = null;
            viewHolder.llPromoExpandSwitch = null;
            viewHolder.llPromoExpand = null;
            viewHolder.tvNearbyPromoUseLimitTitle = null;
            viewHolder.tvNearbyPromoPaymentMethodTitle = null;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).bindData(getItem(i));
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindData(getItem(i));
    }

    /* loaded from: classes5.dex */
    public class ViewHolder extends BaseRecyclerViewHolder<PromoInfoModel> {
        @BindView(R.id.iv_nearby_promo_expand_swith_arrow)
        ImageView ivPromoExpandSwithArrow;
        @BindView(R.id.ll_nearby_promo_expand)
        LinearLayout llPromoExpand;
        @BindView(R.id.ll_nearby_promo_expand_swith)
        LinearLayout llPromoExpandSwitch;
        @BindView(R.id.tv_maximum_cashback_value)
        TextView tvMaximumCashbackValue;
        @BindView(R.id.tv_nearby_promo_payment_method_title)
        TextView tvNearbyPromoPaymentMethodTitle;
        @BindView(R.id.tv_nearby_promo_title)
        TextView tvNearbyPromoTitle;
        @BindView(R.id.tv_nearby_promo_use_limit_title)
        TextView tvNearbyPromoUseLimitTitle;
        @BindView(R.id.tv_nearby_promo_payment_method_value)
        TextView tvPaymentMethodValue;
        @BindView(R.id.tv_nearby_promo_expand_swith)
        TextView tvPromoExpandSwith;
        @BindView(R.id.tv_nearby_promo_period_value)
        TextView tvPromoPeriodValue;
        @BindView(R.id.tv_purchase_minimum_value)
        TextView tvPurchaseMinimumValue;
        @BindView(R.id.tv_nearby_promo_use_limit_value)
        TextView tvUseLimitValue;

        ViewHolder(Context context, ViewGroup viewGroup) {
            super(context, R.layout.item_nearby_promo_list, viewGroup);
        }

        @Override // id.dana.base.BaseRecyclerViewHolder
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final void bindData(PromoInfoModel promoInfoModel) {
            this.tvNearbyPromoTitle.setText(TextUtils.isEmpty(promoInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0) ? "-" : promoInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.tvMaximumCashbackValue.setText(promoInfoModel.BuiltInFictitiousFunctionClassFactory());
            this.tvPurchaseMinimumValue.setText(promoInfoModel.MyBillsEntityDataFactory());
            this.tvPromoPeriodValue.setText(PlaceComponentResult(promoInfoModel.MyBillsEntityDataFactory, promoInfoModel.getAuthRequestContext));
            List<PromoLimitInfoModel> list = promoInfoModel.PlaceComponentResult;
            if (list != null && !list.isEmpty()) {
                this.tvNearbyPromoUseLimitTitle.setVisibility(0);
                this.tvUseLimitValue.setVisibility(0);
                this.tvUseLimitValue.setText(KClassImpl$Data$declaredNonStaticMembers$2(list.get(0)));
            } else {
                this.tvNearbyPromoUseLimitTitle.setVisibility(8);
                this.tvUseLimitValue.setVisibility(8);
            }
            this.tvNearbyPromoPaymentMethodTitle.setVisibility(0);
            this.tvPaymentMethodValue.setVisibility(0);
            this.tvPaymentMethodValue.setText(BuiltInFictitiousFunctionClassFactory(promoInfoModel.lookAheadTest));
            this.llPromoExpandSwitch.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.NearbyPromoAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbyPromoAdapter.ViewHolder viewHolder = NearbyPromoAdapter.ViewHolder.this;
                    if (viewHolder.llPromoExpand.getVisibility() != 0) {
                        viewHolder.tvPromoExpandSwith.setText(R.string.close);
                        InstrumentInjector.Resources_setImageResource(viewHolder.ivPromoExpandSwithArrow, R.drawable.ic_arrow_blue_up);
                        viewHolder.llPromoExpand.setVisibility(0);
                        return;
                    }
                    viewHolder.tvPromoExpandSwith.setText(R.string.more_info_promo);
                    InstrumentInjector.Resources_setImageResource(viewHolder.ivPromoExpandSwithArrow, R.drawable.ic_arrow_blue_down);
                    viewHolder.llPromoExpand.setVisibility(8);
                }
            });
        }

        private static String PlaceComponentResult(long j, long j2) {
            StringBuilder sb = new StringBuilder();
            sb.append(DateTimeUtil.BuiltInFictitiousFunctionClassFactory("d MMM yyyy", LocaleUtil.getAuthRequestContext(), j));
            sb.append(" - ");
            sb.append(DateTimeUtil.BuiltInFictitiousFunctionClassFactory("d MMM yyyy", LocaleUtil.getAuthRequestContext(), j2));
            return sb.toString();
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00e9, code lost:
        
            if (r11.equals(id.dana.nearbyme.NearbyMePromoType.LimitRangeType.DC) != false) goto L59;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0128  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(id.dana.nearbyme.model.PromoLimitInfoModel r11) {
            /*
                Method dump skipped, instructions count: 315
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.adapter.NearbyPromoAdapter.ViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.nearbyme.model.PromoLimitInfoModel):java.lang.String");
        }

        private String BuiltInFictitiousFunctionClassFactory(List<String> list) {
            if (list == null || list.isEmpty()) {
                return BuiltInFictitiousFunctionClassFactory("");
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(it.next());
                if (!TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory) && !arrayList.contains(BuiltInFictitiousFunctionClassFactory)) {
                    arrayList.add(BuiltInFictitiousFunctionClassFactory);
                }
            }
            if (arrayList.size() > 1) {
                String str = (String) arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);
                StringBuilder sb = new StringBuilder();
                sb.append(TextUtils.join(", ", arrayList));
                sb.append(" & ");
                sb.append(str);
                return sb.toString();
            }
            return (String) arrayList.get(0);
        }

        private String BuiltInFictitiousFunctionClassFactory(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String replaceAll = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
            replaceAll.hashCode();
            char c = 65535;
            switch (replaceAll.hashCode()) {
                case -64365875:
                    if (replaceAll.equals("DIRECT_DEBIT_CREDIT_CARD")) {
                        c = 0;
                        break;
                    }
                    break;
                case 0:
                    if (replaceAll.equals("")) {
                        c = 1;
                        break;
                    }
                    break;
                case 341392997:
                    if (replaceAll.equals("ONLINE_CREDIT")) {
                        c = 2;
                        break;
                    }
                    break;
                case 378796732:
                    if (replaceAll.equals("BALANCE")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1079718284:
                    if (replaceAll.equals("DIRECT_DEBIT_DEBIT_CARD")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1280945827:
                    if (replaceAll.equals("DEBIT_CARD")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1878720662:
                    if (replaceAll.equals("CREDIT_CARD")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1883983033:
                    if (replaceAll.equals("VIRTUAL_ACCOUNT")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1993722918:
                    if (replaceAll.equals("COUPON")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 2134027076:
                    if (replaceAll.equals("NET_BANKING")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return getContext().getString(R.string.promo_payment_method_direct_debit_credit_card);
                case 1:
                    return getContext().getString(R.string.all_payment_method);
                case 2:
                    return getContext().getString(R.string.promo_payment_method_online_credit);
                case 3:
                    return getContext().getString(R.string.promo_payment_method_balance);
                case 4:
                    return getContext().getString(R.string.promo_payment_method_direct_debit_debit_card);
                case 5:
                    return getContext().getString(R.string.promo_payment_method_debit_card);
                case 6:
                    return getContext().getString(R.string.promo_payment_method_credit_card);
                case 7:
                    return getContext().getString(R.string.promo_payment_method_virtual_account);
                case '\b':
                    return getContext().getString(R.string.promo_payment_method_coupon);
                case '\t':
                    return getContext().getString(R.string.promo_payment_method_net_banking);
                default:
                    return "";
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(viewGroup.getContext(), viewGroup);
    }
}
