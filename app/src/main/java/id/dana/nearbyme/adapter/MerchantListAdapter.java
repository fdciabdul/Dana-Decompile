package id.dana.nearbyme.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.nearbyme.adapter.MerchantListAdapter;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ResourceUtils;
import id.dana.utils.SizeUtil;
import id.dana.utils.TextUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public class MerchantListAdapter extends BaseRecyclerViewAdapter<ViewHolder, ShopModel> {
    public OnTopUpButtonClickListener BuiltInFictitiousFunctionClassFactory;
    public OnOtherStoreButtonClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    public OnPromoRibbonClickListener MyBillsEntityDataFactory;
    public OnMerchantListClickListener PlaceComponentResult;
    public OnHomeShoppingClickListener getAuthRequestContext;
    public boolean lookAheadTest;

    /* loaded from: classes9.dex */
    public interface OnHomeShoppingClickListener {
        void getAuthRequestContext(int i);
    }

    /* loaded from: classes9.dex */
    public interface OnMerchantListClickListener {
        void PlaceComponentResult(int i);
    }

    /* loaded from: classes9.dex */
    public interface OnOtherStoreButtonClickListener {
        void PlaceComponentResult(int i);
    }

    /* loaded from: classes9.dex */
    public interface OnPromoRibbonClickListener {
        void BuiltInFictitiousFunctionClassFactory(List<PromoInfoModel> list);
    }

    /* loaded from: classes9.dex */
    public interface OnTopUpButtonClickListener {
        void MyBillsEntityDataFactory(String str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    /* loaded from: classes9.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = viewHolder;
            viewHolder.clMerchantList = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3666cl_item_merchant_list, "field 'clMerchantList'", ConstraintLayout.class);
            viewHolder.clMerchantListRibbonContainer = (ViewGroup) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3670cl_merchant_list_ribbon_container, "field 'clMerchantListRibbonContainer'", ViewGroup.class);
            viewHolder.dividerPromoRibbon = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3743divider_promo_ribbon, "field 'dividerPromoRibbon'");
            viewHolder.clDanaBusiness = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3642cl_business_icon, "field 'clDanaBusiness'", ConstraintLayout.class);
            viewHolder.tvHomeShopping = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4421tv_home_shopping, "field 'tvHomeShopping'", TextView.class);
            viewHolder.ivMerchantListInfoIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3915iv_merchant_list_info_icon, "field 'ivMerchantListInfoIcon'", ImageView.class);
            viewHolder.ivMerchantLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3916iv_merchant_logo, "field 'ivMerchantLogo'", ImageView.class);
            viewHolder.ivQrisIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3941iv_qris_icon, "field 'ivQrisIcon'", ImageView.class);
            viewHolder.lottieMerchantListNearbyRibbon = (LottieAnimationView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4032lottie_merchant_list_nearby_ribbon, "field 'lottieMerchantListNearbyRibbon'", LottieAnimationView.class);
            viewHolder.tvMerchantAddress = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4434tv_merchant_address, "field 'tvMerchantAddress'", TextView.class);
            viewHolder.tvMerchantCategory = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4435tv_merchant_category, "field 'tvMerchantCategory'", TextView.class);
            viewHolder.tvMerchantListRibbonLineBottom = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4436tv_merchant_list_ribbon_line_bottom, "field 'tvMerchantListRibbonLineBottom'", TextView.class);
            viewHolder.tvMerchantListRibbonLineTop = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4437tv_merchant_list_ribbon_line_top, "field 'tvMerchantListRibbonLineTop'", TextView.class);
            viewHolder.tvMerchantName = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4438tv_merchant_name, "field 'tvMerchantName'", TextView.class);
            viewHolder.tvMerchantStoreDistance = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4439tv_merchant_store_distance, "field 'tvMerchantStoreDistance'", TextView.class);
            viewHolder.tvOpenHours = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4456x32925f84, "field 'tvOpenHours'", TextView.class);
            viewHolder.tvOtherLocation = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_other_location, "field 'tvOtherLocation'", TextView.class);
            viewHolder.tvRatingStar = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.hasValidCountryCallingCode, "field 'tvRatingStar'", TextView.class);
            viewHolder.tvTopUpReady = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4526tv_top_up_ready, "field 'tvTopUpReady'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            ViewHolder viewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            viewHolder.clMerchantList = null;
            viewHolder.clMerchantListRibbonContainer = null;
            viewHolder.dividerPromoRibbon = null;
            viewHolder.clDanaBusiness = null;
            viewHolder.tvHomeShopping = null;
            viewHolder.ivMerchantListInfoIcon = null;
            viewHolder.ivMerchantLogo = null;
            viewHolder.ivQrisIcon = null;
            viewHolder.lottieMerchantListNearbyRibbon = null;
            viewHolder.tvMerchantAddress = null;
            viewHolder.tvMerchantCategory = null;
            viewHolder.tvMerchantListRibbonLineBottom = null;
            viewHolder.tvMerchantListRibbonLineTop = null;
            viewHolder.tvMerchantName = null;
            viewHolder.tvMerchantStoreDistance = null;
            viewHolder.tvOpenHours = null;
            viewHolder.tvOtherLocation = null;
            viewHolder.tvRatingStar = null;
            viewHolder.tvTopUpReady = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean getAuthRequestContext(MerchantListAdapter merchantListAdapter) {
        merchantListAdapter.lookAheadTest = true;
        return true;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.bindData(getItem(i));
        ViewHolder.getAuthRequestContext(viewHolder2, getItem(i));
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        viewHolder2.bindData(getItem(i));
        ViewHolder.getAuthRequestContext(viewHolder2, getItem(i));
    }

    public MerchantListAdapter() {
        super.setItems(new ArrayList());
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void setItems(List<ShopModel> list) {
        getItems().clear();
        getItems().addAll(list);
        notifyDataSetChanged();
    }

    /* loaded from: classes9.dex */
    public class ViewHolder extends BaseRecyclerViewHolder<ShopModel> {
        @BindView(R.id.f3642cl_business_icon)
        ConstraintLayout clDanaBusiness;
        @BindView(R.id.f3666cl_item_merchant_list)
        ConstraintLayout clMerchantList;
        @BindView(R.id.f3670cl_merchant_list_ribbon_container)
        ViewGroup clMerchantListRibbonContainer;
        @BindView(R.id.f3743divider_promo_ribbon)
        View dividerPromoRibbon;
        @BindView(R.id.f3915iv_merchant_list_info_icon)
        ImageView ivMerchantListInfoIcon;
        @BindView(R.id.f3916iv_merchant_logo)
        ImageView ivMerchantLogo;
        @BindView(R.id.f3941iv_qris_icon)
        ImageView ivQrisIcon;
        @BindView(R.id.f4032lottie_merchant_list_nearby_ribbon)
        LottieAnimationView lottieMerchantListNearbyRibbon;
        @BindView(R.id.f4421tv_home_shopping)
        TextView tvHomeShopping;
        @BindView(R.id.f4434tv_merchant_address)
        TextView tvMerchantAddress;
        @BindView(R.id.f4435tv_merchant_category)
        TextView tvMerchantCategory;
        @BindView(R.id.f4436tv_merchant_list_ribbon_line_bottom)
        TextView tvMerchantListRibbonLineBottom;
        @BindView(R.id.f4437tv_merchant_list_ribbon_line_top)
        TextView tvMerchantListRibbonLineTop;
        @BindView(R.id.f4438tv_merchant_name)
        TextView tvMerchantName;
        @BindView(R.id.f4439tv_merchant_store_distance)
        TextView tvMerchantStoreDistance;
        @BindView(R.id.f4456x32925f84)
        TextView tvOpenHours;
        @BindView(R.id.tv_other_location)
        TextView tvOtherLocation;
        @BindView(R.id.hasValidCountryCallingCode)
        TextView tvRatingStar;
        @BindView(R.id.f4526tv_top_up_ready)
        TextView tvTopUpReady;

        ViewHolder(Context context, ViewGroup viewGroup, final Consumer<Integer> consumer, final Consumer<Integer> consumer2, final Consumer<Integer> consumer3, final Consumer<Integer> consumer4, final Consumer<Integer> consumer5) {
            super(context, R.layout.item_merchant_list, viewGroup);
            this.clMerchantList.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    consumer.accept(Integer.valueOf(MerchantListAdapter.ViewHolder.this.getBindingAdapterPosition()));
                }
            });
            this.clMerchantListRibbonContainer.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$ViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    consumer2.accept(Integer.valueOf(MerchantListAdapter.ViewHolder.this.getBindingAdapterPosition()));
                }
            });
            this.tvTopUpReady.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$ViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    consumer3.accept(Integer.valueOf(MerchantListAdapter.ViewHolder.this.getBindingAdapterPosition()));
                }
            });
            this.tvHomeShopping.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$ViewHolder$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    consumer5.accept(Integer.valueOf(MerchantListAdapter.ViewHolder.this.getBindingAdapterPosition()));
                }
            });
            this.tvOtherLocation.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$ViewHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    consumer4.accept(Integer.valueOf(MerchantListAdapter.ViewHolder.this.getBindingAdapterPosition()));
                }
            });
        }

        @Override // id.dana.base.BaseRecyclerViewHolder
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final void bindData(ShopModel shopModel) {
            this.tvMerchantName.setText(shopModel.newProxyInstance);
            this.tvMerchantCategory.setText(shopModel.getAuthRequestContext(false, " | "));
            this.tvMerchantAddress.setText(shopModel.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult);
            this.tvMerchantStoreDistance.setText(TextUtil.BuiltInFictitiousFunctionClassFactory(getContext(), shopModel.getErrorConfigVersion));
            KClassImpl$Data$declaredNonStaticMembers$2(this.ivMerchantLogo, shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
            MyBillsEntityDataFactory(shopModel);
            PlaceComponentResult(shopModel);
            KClassImpl$Data$declaredNonStaticMembers$2(this.ivMerchantLogo, shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
            KClassImpl$Data$declaredNonStaticMembers$2(shopModel);
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(ImageView imageView, String str) {
            Drawable BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), R.drawable.ic_merchant_logo_null);
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new RoundedCorners(SizeUtil.getAuthRequestContext(2))).MyBillsEntityDataFactory(imageView);
        }

        private void MyBillsEntityDataFactory(ShopModel shopModel) {
            this.tvTopUpReady.setText(getContext().getString(R.string.merchant_item_top_up).toUpperCase());
            this.tvTopUpReady.setVisibility(shopModel.newProxyInstance() ? 0 : 8);
            this.ivQrisIcon.setVisibility(shopModel.PrepareContext() ? 0 : 8);
            this.clDanaBusiness.setVisibility(shopModel.getErrorConfigVersion() ? 0 : 8);
            this.tvOtherLocation.setVisibility(shopModel.PlaceComponentResult() ? 0 : 8);
            this.tvHomeShopping.setVisibility(shopModel.initRecordTimeStamp() ? 0 : 8);
        }

        private void BuiltInFictitiousFunctionClassFactory() {
            if (this.tvOpenHours.getVisibility() == 0) {
                this.tvOpenHours.setVisibility(8);
            }
            this.tvMerchantStoreDistance.setText(this.tvMerchantStoreDistance.getText().toString().replace("• ", ""));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void getAuthRequestContext(boolean z) {
            TextView textView = this.tvMerchantListRibbonLineTop;
            if (textView == null) {
                return;
            }
            if (z) {
                textView.postDelayed(new Runnable() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$ViewHolder$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        MerchantListAdapter.ViewHolder viewHolder = MerchantListAdapter.ViewHolder.this;
                        if (viewHolder.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            viewHolder.KClassImpl$Data$declaredNonStaticMembers$2(true);
                        }
                        MerchantListAdapter.getAuthRequestContext(MerchantListAdapter.this);
                    }
                }, 150L);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return (this.tvMerchantListRibbonLineTop == null || this.tvMerchantListRibbonLineBottom == null || this.ivMerchantListInfoIcon == null) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            if (z) {
                this.tvMerchantListRibbonLineTop.animate().alpha(1.0f).start();
                this.tvMerchantListRibbonLineBottom.animate().alpha(1.0f).start();
                this.ivMerchantListInfoIcon.animate().alpha(1.0f).start();
                return;
            }
            this.tvMerchantListRibbonLineTop.setAlpha(1.0f);
            this.tvMerchantListRibbonLineBottom.setAlpha(1.0f);
            this.ivMerchantListInfoIcon.setAlpha(1.0f);
        }

        static /* synthetic */ void getAuthRequestContext(final ViewHolder viewHolder, ShopModel shopModel) {
            boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7();
            viewHolder.clMerchantListRibbonContainer.setVisibility(NetworkUserEntityData$$ExternalSyntheticLambda7 ? 0 : 8);
            viewHolder.dividerPromoRibbon.setVisibility(NetworkUserEntityData$$ExternalSyntheticLambda7 ? 0 : 8);
            if (NetworkUserEntityData$$ExternalSyntheticLambda7) {
                String scheduleImpl = shopModel.scheduleImpl();
                String NetworkUserEntityData$$ExternalSyntheticLambda0 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda0();
                viewHolder.tvMerchantListRibbonLineTop.setText(ResourceUtils.PlaceComponentResult(viewHolder.getContext(), scheduleImpl, scheduleImpl));
                viewHolder.tvMerchantListRibbonLineBottom.setText(NetworkUserEntityData$$ExternalSyntheticLambda0);
                if ((!MerchantListAdapter.this.lookAheadTest) != false) {
                    viewHolder.lottieMerchantListNearbyRibbon.postDelayed(new Runnable() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            MerchantListAdapter.ViewHolder viewHolder2 = MerchantListAdapter.ViewHolder.this;
                            LottieAnimationView lottieAnimationView = viewHolder2.lottieMerchantListNearbyRibbon;
                            if (lottieAnimationView != null) {
                                lottieAnimationView.playAnimation();
                            }
                            viewHolder2.getAuthRequestContext(true);
                        }
                    }, 500L);
                    return;
                }
                LottieAnimationView lottieAnimationView = viewHolder.lottieMerchantListNearbyRibbon;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setFrame(60);
                }
                viewHolder.getAuthRequestContext(false);
            }
        }

        private void PlaceComponentResult(ShopModel shopModel) {
            if (shopModel.readMicros == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.tvRatingStar.setVisibility(8);
                return;
            }
            this.tvRatingStar.setVisibility(0);
            this.tvRatingStar.setText(String.format(Locale.US, "%.1f", Double.valueOf(shopModel.readMicros)));
        }

        private void PlaceComponentResult(String str) {
            if (this.tvOpenHours.getVisibility() == 8) {
                this.tvOpenHours.setVisibility(0);
            }
            if (str.equals(getContext().getResources().getString(R.string.closing_soon)) || str.equals(getContext().getResources().getString(R.string.closed))) {
                TextView textView = this.tvOpenHours;
                getContext();
                textView.setTextColor(-773316);
            } else {
                TextView textView2 = this.tvOpenHours;
                getContext();
                textView2.setTextColor(-13553359);
            }
            this.tvOpenHours.setText(str);
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(ShopModel shopModel) {
            if (shopModel.C.isEmpty() && !shopModel.moveToNextValue()) {
                BuiltInFictitiousFunctionClassFactory();
            } else if (shopModel.moveToNextValue()) {
                PlaceComponentResult(getContext().getString(R.string.open));
            } else {
                String PlaceComponentResult = shopModel.PlaceComponentResult(getContext());
                if (TextUtils.isEmpty(PlaceComponentResult)) {
                    BuiltInFictitiousFunctionClassFactory();
                } else {
                    PlaceComponentResult(PlaceComponentResult);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(viewGroup.getContext(), viewGroup, new Consumer() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                MerchantListAdapter.this.PlaceComponentResult.PlaceComponentResult(((Integer) obj).intValue());
            }
        }, new Consumer() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                MerchantListAdapter merchantListAdapter = MerchantListAdapter.this;
                merchantListAdapter.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(merchantListAdapter.getItem(((Integer) obj).intValue()).getCallingPid);
            }
        }, new Consumer() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                MerchantListAdapter merchantListAdapter = MerchantListAdapter.this;
                merchantListAdapter.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(merchantListAdapter.getItem(((Integer) obj).intValue()).GetContactSyncConfig);
            }
        }, new Consumer() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                MerchantListAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(((Integer) obj).intValue());
            }
        }, new Consumer() { // from class: id.dana.nearbyme.adapter.MerchantListAdapter$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                MerchantListAdapter.this.getAuthRequestContext.getAuthRequestContext(((Integer) obj).intValue());
            }
        });
    }
}
