package id.dana.nearbyme.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.chip.Chip;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.MerchantViewType;
import id.dana.nearbyme.OnCategoryCheckedListener;
import id.dana.nearbyme.adapter.MerchantCategoryAdapter;
import id.dana.nearbyme.model.MerchantCategoryModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes9.dex */
public class MerchantCategoryAdapter extends BaseRecyclerViewAdapter<MerchantCategoryViewHolder, MerchantCategoryModel> {
    public OnCategoryCheckedListener BuiltInFictitiousFunctionClassFactory;
    public MerchantCategoryModel PlaceComponentResult;
    private Set<MerchantCategoryModel> getAuthRequestContext = new HashSet();

    /* loaded from: classes9.dex */
    public class MerchantCategoryViewHolder_ViewBinding implements Unbinder {
        private MerchantCategoryViewHolder BuiltInFictitiousFunctionClassFactory;

        public MerchantCategoryViewHolder_ViewBinding(MerchantCategoryViewHolder merchantCategoryViewHolder, View view) {
            this.BuiltInFictitiousFunctionClassFactory = merchantCategoryViewHolder;
            merchantCategoryViewHolder.chip = (Chip) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.chip, "field 'chip'", Chip.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            MerchantCategoryViewHolder merchantCategoryViewHolder = this.BuiltInFictitiousFunctionClassFactory;
            if (merchantCategoryViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
            merchantCategoryViewHolder.chip = null;
        }
    }

    public MerchantCategoryAdapter() {
        MerchantCategoryModel merchantCategoryModel = new MerchantCategoryModel();
        this.PlaceComponentResult = merchantCategoryModel;
        merchantCategoryModel.MyBillsEntityDataFactory = MerchantViewType.MERCHANT_CAT_ALL;
        this.PlaceComponentResult.getAuthRequestContext = "All";
        this.getAuthRequestContext.add(this.PlaceComponentResult);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: PlaceComponentResult */
    public MerchantCategoryModel getItem(int i) {
        MerchantCategoryModel merchantCategoryModel = this.PlaceComponentResult;
        if (merchantCategoryModel == null) {
            return (MerchantCategoryModel) super.getItem(i);
        }
        return i != 0 ? (MerchantCategoryModel) super.getItem(i - 1) : merchantCategoryModel;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        return super.getPlaceComponentResult() + (MyBillsEntityDataFactory() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (MyBillsEntityDataFactory() && getItem(i) == this.PlaceComponentResult) ? 0 : 1;
    }

    public final void PlaceComponentResult(MerchantCategoryModel merchantCategoryModel) {
        if (merchantCategoryModel == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(merchantCategoryModel);
        if (arrayList.isEmpty()) {
            return;
        }
        this.getAuthRequestContext.clear();
        this.getAuthRequestContext.addAll(arrayList);
        notifyDataSetChanged();
        OnCategoryCheckedListener onCategoryCheckedListener = this.BuiltInFictitiousFunctionClassFactory;
        if (onCategoryCheckedListener != null) {
            onCategoryCheckedListener.onMulitpleCategorySelected(arrayList);
        }
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult != null;
    }

    /* loaded from: classes9.dex */
    class DefaultSelectedMerchantCategoryViewHolder extends MerchantCategoryViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        DefaultSelectedMerchantCategoryViewHolder(Context context, ViewGroup viewGroup) {
            super(context, viewGroup);
            MerchantCategoryAdapter.this = r1;
        }

        @Override // id.dana.nearbyme.adapter.MerchantCategoryAdapter.MerchantCategoryViewHolder
        protected final void getAuthRequestContext(MerchantCategoryModel merchantCategoryModel, boolean z) {
            if (z) {
                MerchantCategoryAdapter.this.getAuthRequestContext.clear();
                MerchantCategoryAdapter.this.getAuthRequestContext.add(merchantCategoryModel);
            } else if (MerchantCategoryAdapter.this.getAuthRequestContext.isEmpty()) {
                MerchantCategoryAdapter.this.getAuthRequestContext.add(merchantCategoryModel);
            }
            MerchantCategoryAdapter.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes9.dex */
    public class MerchantCategoryViewHolder extends BaseRecyclerViewHolder<MerchantCategoryModel> {
        @BindView(R.id.chip)
        Chip chip;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // id.dana.base.BaseRecyclerViewHolder
        public /* synthetic */ void bindData(MerchantCategoryModel merchantCategoryModel) {
            char c;
            int i;
            final MerchantCategoryModel merchantCategoryModel2 = merchantCategoryModel;
            this.chip.setChecked(MerchantCategoryAdapter.this.getAuthRequestContext.contains(merchantCategoryModel2));
            this.chip.setText(merchantCategoryModel2.getAuthRequestContext);
            this.chip.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.MerchantCategoryAdapter$MerchantCategoryViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantCategoryAdapter.MerchantCategoryViewHolder.this.BuiltInFictitiousFunctionClassFactory(merchantCategoryModel2, view);
                }
            });
            if (merchantCategoryModel2.MyBillsEntityDataFactory.equals(MerchantViewType.MERCHANT_CAT_DANA_BISNIS)) {
                this.chip.setChipIconVisible(false);
                return;
            }
            Chip chip = this.chip;
            Context context = getContext();
            String str = merchantCategoryModel2.MyBillsEntityDataFactory;
            int hashCode = str.hashCode();
            switch (hashCode) {
                case -1080034440:
                    if (str.equals(MerchantViewType.MERCHANT_CAT_ALL)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1421842541:
                    if (str.equals(MerchantViewType.MERCHANT_CAT_ORDER_ONLINE)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 1470938172:
                    if (str.equals(MerchantViewType.MERCHANT_CAT_COVID_19)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1471543710:
                    if (str.equals(MerchantViewType.MERCHANT_CAT_DEALS)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 1483026726:
                    if (str.equals(MerchantViewType.MERCHANT_CAT_PROMO)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 3345352:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_FOOD_AND_BEVERAGES)) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3345353:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_RETAIL)) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3345354:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_TOP_UP_AGENT)) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3345355:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_PROFESSIONAL_SERVICES)) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3345356:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_HEALTH)) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3345357:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_ENTERTAINMENT)) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3345358:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_FINANCIAL)) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3345359:
                            if (str.equals(MerchantViewType.MERCHANT_CAT_NON_PROFIT_ORGANIZATION)) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
            }
            switch (c) {
                case 2:
                    i = R.drawable.ic_mc_promo_state;
                    break;
                case 3:
                    i = R.drawable.ic_mc_retail_state;
                    break;
                case 4:
                    i = R.drawable.ic_mc_health_state;
                    break;
                case 5:
                    i = R.drawable.ic_mc_professional_services_state;
                    break;
                case 6:
                    i = R.drawable.ic_mc_food_and_beverages_state;
                    break;
                case 7:
                    i = R.drawable.ic_mc_entertaintment_state;
                    break;
                case '\b':
                    i = R.drawable.ic_mc_financial_state;
                    break;
                case '\t':
                    i = R.drawable.ic_mc_npo_state;
                    break;
                case '\n':
                    i = R.drawable.ic_mc_top_up_agent_state;
                    break;
                case 11:
                    i = R.drawable.ic_mc_covid_state;
                    break;
                case '\f':
                    i = R.drawable.ic_home_shopping_state;
                    break;
                case '\r':
                    i = R.drawable.ic_mc_deals_state;
                    break;
                default:
                    i = R.drawable.ic_mc_all_state;
                    break;
            }
            chip.setChipIcon(ContextCompat.PlaceComponentResult(context, i));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        MerchantCategoryViewHolder(Context context, ViewGroup viewGroup) {
            super(context, R.layout.item_merchant_category, viewGroup);
            MerchantCategoryAdapter.this = r1;
        }

        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MerchantCategoryModel merchantCategoryModel, View view) {
            getAuthRequestContext(merchantCategoryModel, ((Chip) view).isChecked());
            MerchantCategoryAdapter.PlaceComponentResult(MerchantCategoryAdapter.this, merchantCategoryModel);
            MerchantCategoryAdapter.BuiltInFictitiousFunctionClassFactory(MerchantCategoryAdapter.this, new ArrayList(MerchantCategoryAdapter.this.getAuthRequestContext));
        }

        protected void getAuthRequestContext(MerchantCategoryModel merchantCategoryModel, boolean z) {
            if (z) {
                MerchantCategoryAdapter.this.getAuthRequestContext.add(merchantCategoryModel);
                if (MerchantCategoryAdapter.this.MyBillsEntityDataFactory()) {
                    MerchantCategoryAdapter.this.getAuthRequestContext.remove(MerchantCategoryAdapter.this.PlaceComponentResult);
                }
            } else {
                MerchantCategoryAdapter.this.getAuthRequestContext.remove(merchantCategoryModel);
                if (MerchantCategoryAdapter.this.getAuthRequestContext.isEmpty()) {
                    MerchantCategoryAdapter.this.getAuthRequestContext.add(MerchantCategoryAdapter.this.PlaceComponentResult);
                }
            }
            MerchantCategoryAdapter.this.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void PlaceComponentResult(MerchantCategoryAdapter merchantCategoryAdapter, MerchantCategoryModel merchantCategoryModel) {
        merchantCategoryAdapter.BuiltInFictitiousFunctionClassFactory.onCategoryClick(merchantCategoryModel);
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MerchantCategoryAdapter merchantCategoryAdapter, List list) {
        OnCategoryCheckedListener onCategoryCheckedListener = merchantCategoryAdapter.BuiltInFictitiousFunctionClassFactory;
        if (onCategoryCheckedListener != null) {
            onCategoryCheckedListener.onMulitpleCategorySelected(list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new DefaultSelectedMerchantCategoryViewHolder(viewGroup.getContext(), viewGroup);
        }
        return new MerchantCategoryViewHolder(viewGroup.getContext(), viewGroup);
    }
}
