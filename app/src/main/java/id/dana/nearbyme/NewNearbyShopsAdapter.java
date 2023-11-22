package id.dana.nearbyme;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.base.BaseAsyncRecyclerViewAdapter;
import id.dana.base.BaseAsyncRecyclerViewHolder;
import id.dana.base.BaseAsyncRecyclerViewHolder$$ExternalSyntheticLambda0;
import id.dana.base.BaseAsyncView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.TextUtil;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class NewNearbyShopsAdapter extends BaseAsyncRecyclerViewAdapter<BaseAsyncRecyclerViewHolder<ShopModel>, ShopModel> {
    HashMap<String, Integer> PlaceComponentResult;
    boolean getAuthRequestContext;
    private final BaseAsyncRecyclerViewHolder.OnItemClickListener getErrorConfigVersion;

    public NewNearbyShopsAdapter(RecyclerView recyclerView, BaseAsyncRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        super(recyclerView);
        this.PlaceComponentResult = new HashMap<>();
        this.getAuthRequestContext = false;
        this.getErrorConfigVersion = onItemClickListener;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.base.BaseAsyncRecyclerViewAdapter
    public final void getAuthRequestContext(List<ShopModel> list) {
        super.getAuthRequestContext(list);
        for (int i = 0; i < list.size(); i++) {
            this.PlaceComponentResult.put(list.get(i).BottomSheetCardBindingView$watcherCardNumberView$1, Integer.valueOf(i));
        }
    }

    /* loaded from: classes5.dex */
    class NearbyShopCellView extends BaseAsyncView {
        @Override // id.dana.base.BaseAsyncView
        public int getLayoutId() {
            return R.layout.new_layout_custom_gridview_nearby_me;
        }

        public NearbyShopCellView(Context context) {
            super(context);
        }
    }

    /* loaded from: classes5.dex */
    class NearbyShopListEntryPointViewHolder extends BaseAsyncRecyclerViewHolder<ShopModel> {
        ImageView KClassImpl$Data$declaredNonStaticMembers$2;
        ImageView MyBillsEntityDataFactory;
        private final Context NetworkUserEntityData$$ExternalSyntheticLambda0;
        TextView PlaceComponentResult;
        LinearLayout getAuthRequestContext;
        TextView getErrorConfigVersion;
        TextView lookAheadTest;
        private final boolean moveToNextValue;
        TextView scheduleImpl;

        @Override // id.dana.base.BaseAsyncRecyclerViewHolder
        public final /* synthetic */ void MyBillsEntityDataFactory(ShopModel shopModel) {
            ShopModel shopModel2 = shopModel;
            if (shopModel2 == null || shopModel2.getErrorConfigVersion < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return;
            }
            this.MyBillsEntityDataFactory = (ImageView) this.itemView.findViewById(R.id.f3916iv_merchant_logo);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (ImageView) this.itemView.findViewById(R.id.iv_nearby_tag);
            this.getAuthRequestContext = (LinearLayout) this.itemView.findViewById(R.id.ll_rating);
            this.PlaceComponentResult = (TextView) this.itemView.findViewById(R.id.f4375tv_category);
            this.getErrorConfigVersion = (TextView) this.itemView.findViewById(R.id.tv_distance);
            this.scheduleImpl = (TextView) this.itemView.findViewById(R.id.f4438tv_merchant_name);
            this.lookAheadTest = (TextView) this.itemView.findViewById(R.id.f4484tv_rating);
            this.getErrorConfigVersion.setText(TextUtil.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, shopModel2.getErrorConfigVersion));
            this.scheduleImpl.setText(shopModel2.newProxyInstance);
            this.PlaceComponentResult.setText(shopModel2.getAuthRequestContext(true, " "));
            List<PromoInfoModel> list = shopModel2.getCallingPid;
            byte b = 0;
            if (!shopModel2.lookAheadTest()) {
                if (!this.moveToNextValue && (list == null || list.isEmpty())) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
                } else {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(ContextCompat.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, (int) R.drawable.ic_img_promo_label));
                }
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                this.KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(ContextCompat.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, (int) R.drawable.ic_img_deals_label));
            }
            double d = shopModel2.readMicros;
            if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double round = Math.round(d * 100.0d);
                Double.isNaN(round);
                String d2 = Double.toString(round / 100.0d);
                this.getAuthRequestContext.setVisibility(0);
                this.lookAheadTest.setText(d2);
            } else {
                this.getAuthRequestContext.setVisibility(8);
            }
            String str = shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (SvgLoader.getAuthRequestContext(str)) {
                SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_merchant_logo_null;
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = this.MyBillsEntityDataFactory;
                new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                return;
            }
            GlideApp.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_merchant_logo_null).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
        }

        public NearbyShopListEntryPointViewHolder(BaseAsyncView baseAsyncView, BaseAsyncRecyclerViewHolder.OnItemClickListener onItemClickListener, boolean z) {
            super(baseAsyncView);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = baseAsyncView.getContext();
            this.moveToNextValue = z;
            if (onItemClickListener != null) {
                this.itemView.setOnClickListener(new BaseAsyncRecyclerViewHolder$$ExternalSyntheticLambda0(this, onItemClickListener));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        NearbyShopCellView nearbyShopCellView = new NearbyShopCellView(viewGroup.getContext());
        nearbyShopCellView.setLayoutParams(-2, -2);
        return new NearbyShopListEntryPointViewHolder(nearbyShopCellView, this.getErrorConfigVersion, this.getAuthRequestContext);
    }
}
