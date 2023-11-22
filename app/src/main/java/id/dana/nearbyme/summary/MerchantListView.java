package id.dana.nearbyme.summary;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.HorizontalEvenlyItemDecoration;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.common.DividerItemDecoration;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantComponent;
import id.dana.di.component.MerchantComponent;
import id.dana.di.modules.MerchantModule;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.nearbyme.MerchantContract;
import id.dana.nearbyme.NearbyMerchantLocationSearchView;
import id.dana.nearbyme.OnCategoryCheckedListener;
import id.dana.nearbyme.adapter.MerchantCategoryAdapter;
import id.dana.nearbyme.adapter.MerchantListAdapter;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;

/* loaded from: classes9.dex */
public class MerchantListView extends BaseRichView implements MerchantContract.View, OnCategoryCheckedListener {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private MerchantCategoryAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    private MerchantComponent MyBillsEntityDataFactory;
    private List<ShopModel> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean PlaceComponentResult;
    @BindView(R.id.cl_merchant_list)
    CoordinatorLayout clMerchantList;
    @BindView(R.id.cl_toolbar_content)
    ConstraintLayout clToolbarContent;
    @BindView(R.id.et_nearby_search)
    EditText etNearbySearch;
    private boolean getAuthRequestContext;
    private OnCategoryCheckedListener getErrorConfigVersion;
    @BindView(R.id.ll_merchant_list_empty_state)
    LinearLayout llMerchantListEmptyState;
    private String lookAheadTest;
    private SkeletonScreen moveToNextValue;
    @BindView(R.id.view_nearby_merchant_location_search)
    NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView;
    @BindView(R.id.f4055nested_scroll_view)
    NestedScrollView nestedScrollView;
    @Inject
    MerchantContract.Presenter presenter;
    @BindView(R.id.rv_merchant_category)
    RecyclerView rvMerchantCategory;
    @BindView(R.id.rv_merchants_list)
    RecyclerView rvMerchantList;
    private MerchantListAdapter scheduleImpl;
    @BindView(R.id.view_divider)
    View viewDivider;
    @BindView(R.id.view_spacing)
    View viewSpacer;

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_merchant_list;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.nearbyme.MerchantContract.View
    public /* synthetic */ void onErrorGetNewMerchantCategories(MerchantCategoryType merchantCategoryType) {
        MerchantContract.View.CC.BuiltInFictitiousFunctionClassFactory(merchantCategoryType);
    }

    public /* synthetic */ void onFinishInitMerchantCategories() {
        MerchantContract.View.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.nearbyme.MerchantContract.View
    public /* synthetic */ void onGetNewMerchantListCategories(List list) {
        MerchantContract.View.CC.MyBillsEntityDataFactory(list);
    }

    @Override // id.dana.nearbyme.MerchantContract.View
    public /* synthetic */ void onGetNewMerchantMapsCategories(List list) {
        MerchantContract.View.CC.PlaceComponentResult(list);
    }

    @Override // id.dana.nearbyme.OnCategoryCheckedListener
    public /* synthetic */ void onMulitpleCategorySelected(List list, boolean z) {
        OnCategoryCheckedListener.CC.PlaceComponentResult(list);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public MerchantListView(Context context) {
        super(context);
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public MerchantListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public MerchantListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public MerchantListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.MyBillsEntityDataFactory == null) {
            DaggerMerchantComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMerchantComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (MerchantModule) Preconditions.getAuthRequestContext(new MerchantModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, MerchantModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            this.MyBillsEntityDataFactory = new DaggerMerchantComponent.MerchantComponentImpl(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, b);
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
        if (z) {
            this.presenter.BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showCategoryLineDivider$0$id-dana-nearbyme-summary-MerchantListView  reason: not valid java name */
    public /* synthetic */ void m2734x16eedab2(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        this.viewDivider.setVisibility(i2 == 0 ? 8 : 0);
    }

    @Override // id.dana.nearbyme.MerchantContract.View
    public void onGetMerchantCategories(List<MerchantCategoryModel> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setItems(list);
        int i = 0;
        this.rvMerchantCategory.setVisibility(((this.PlaceComponentResult ^ true) && this.BuiltInFictitiousFunctionClassFactory) ? 0 : 8);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setItems(list);
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(getCateoriesById(this.lookAheadTest));
        MerchantCategoryModel cateoriesById = getCateoriesById(this.lookAheadTest);
        if (cateoriesById != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(cateoriesById);
            MerchantCategoryAdapter merchantCategoryAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (cateoriesById == null || merchantCategoryAdapter.getItems() == null) {
                i = -1;
            } else if (merchantCategoryAdapter.MyBillsEntityDataFactory()) {
                if (!cateoriesById.equals(merchantCategoryAdapter.PlaceComponentResult)) {
                    i = merchantCategoryAdapter.getItems().indexOf(cateoriesById) + 1;
                }
            } else {
                i = merchantCategoryAdapter.getItems().indexOf(cateoriesById);
            }
            if (i >= 0) {
                this.rvMerchantCategory.smoothScrollToPosition(i);
            }
        }
    }

    public MerchantCategoryModel getCateoriesById(String str) {
        List<MerchantCategoryModel> items;
        MerchantCategoryAdapter merchantCategoryAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantCategoryAdapter == null || (items = merchantCategoryAdapter.getItems()) == null) {
            return null;
        }
        for (MerchantCategoryModel merchantCategoryModel : items) {
            if (TextUtils.equals(merchantCategoryModel.MyBillsEntityDataFactory, str)) {
                return merchantCategoryModel;
            }
        }
        return null;
    }

    @Override // id.dana.nearbyme.OnCategoryCheckedListener
    public void onMulitpleCategorySelected(List<MerchantCategoryModel> list) {
        MerchantCategoryModel merchantCategoryModel = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
        if (merchantCategoryModel != null && list.contains(merchantCategoryModel)) {
            this.rvMerchantCategory.smoothScrollToPosition(0);
        }
        OnCategoryCheckedListener onCategoryCheckedListener = this.getErrorConfigVersion;
        if (onCategoryCheckedListener != null) {
            onCategoryCheckedListener.onMulitpleCategorySelected(list);
        }
    }

    @Override // id.dana.nearbyme.OnCategoryCheckedListener
    public void onCategoryClick(MerchantCategoryModel merchantCategoryModel) {
        this.getErrorConfigVersion.onCategoryClick(merchantCategoryModel);
    }

    public ShopModel getMerchantItem(int i) {
        return getMerchantList().get(i);
    }

    public List<ShopModel> getMerchantList() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public void setMerchantList(List<ShopModel> list) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = list;
        if (list.isEmpty() && !this.getAuthRequestContext) {
            PlaceComponentResult(true);
            hideShimmerMerchantList();
            return;
        }
        if (!this.getAuthRequestContext) {
            PlaceComponentResult(false);
        }
        this.scheduleImpl.setItems(list);
        this.scheduleImpl.notifyDataSetChanged();
        hideShimmerMerchantList();
    }

    private void PlaceComponentResult(boolean z) {
        this.llMerchantListEmptyState.setVisibility(z ? 0 : 8);
        this.rvMerchantList.setVisibility(z ? 8 : 0);
    }

    public void hideShimmerMerchantList() {
        SkeletonScreen skeletonScreen = this.moveToNextValue;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public void displayLocationSearchView() {
        this.getAuthRequestContext = true;
        hideShimmerMerchantList();
        this.clToolbarContent.setVisibility(8);
        this.etNearbySearch.setVisibility(8);
        this.rvMerchantList.setVisibility(8);
        this.llMerchantListEmptyState.setVisibility(8);
        this.rvMerchantCategory.setVisibility(8);
        this.nearbyMerchantLocationSearchView.setVisibility(0);
        this.nearbyMerchantLocationSearchView.displayInitialLocationState();
    }

    public void displayLocationMerchantSearchView() {
        this.getAuthRequestContext = true;
        hideShimmerMerchantList();
        this.clToolbarContent.setVisibility(8);
        this.etNearbySearch.setVisibility(8);
        this.rvMerchantList.setVisibility(8);
        this.llMerchantListEmptyState.setVisibility(8);
        this.rvMerchantCategory.setVisibility(8);
        this.nearbyMerchantLocationSearchView.setVisibility(0);
        this.nearbyMerchantLocationSearchView.displayInitialMerchantState();
    }

    public void resetLocationMerchantSearchView() {
        this.getAuthRequestContext = false;
        this.clToolbarContent.setVisibility(0);
        this.nearbyMerchantLocationSearchView.setVisibility(8);
        this.nearbyMerchantLocationSearchView.resetState();
        this.etNearbySearch.setVisibility(0);
        this.etNearbySearch.setText("");
        this.rvMerchantCategory.setVisibility(((this.PlaceComponentResult ^ true) && this.BuiltInFictitiousFunctionClassFactory) ? 0 : 8);
    }

    public void setOnCategoryCheckedListener(OnCategoryCheckedListener onCategoryCheckedListener) {
        this.getErrorConfigVersion = onCategoryCheckedListener;
    }

    public void setOnTopUpButtonClickListener(MerchantListAdapter.OnTopUpButtonClickListener onTopUpButtonClickListener) {
        MerchantListAdapter merchantListAdapter = this.scheduleImpl;
        if (merchantListAdapter != null) {
            merchantListAdapter.BuiltInFictitiousFunctionClassFactory = onTopUpButtonClickListener;
        }
    }

    public void setOnHomeShoppingClickListener(MerchantListAdapter.OnHomeShoppingClickListener onHomeShoppingClickListener) {
        MerchantListAdapter merchantListAdapter = this.scheduleImpl;
        if (merchantListAdapter != null) {
            merchantListAdapter.getAuthRequestContext = onHomeShoppingClickListener;
        }
    }

    public void setOnMerchantClickListener(MerchantListAdapter.OnMerchantListClickListener onMerchantListClickListener) {
        MerchantListAdapter merchantListAdapter = this.scheduleImpl;
        if (merchantListAdapter != null) {
            merchantListAdapter.PlaceComponentResult = onMerchantListClickListener;
        }
    }

    public void setOnPromoRibbonClickListener(MerchantListAdapter.OnPromoRibbonClickListener onPromoRibbonClickListener) {
        MerchantListAdapter merchantListAdapter = this.scheduleImpl;
        if (merchantListAdapter != null) {
            merchantListAdapter.MyBillsEntityDataFactory = onPromoRibbonClickListener;
        }
    }

    public void setOnOtherStoreButtonClickListener(MerchantListAdapter.OnOtherStoreButtonClickListener onOtherStoreButtonClickListener) {
        MerchantListAdapter merchantListAdapter = this.scheduleImpl;
        if (merchantListAdapter != null) {
            merchantListAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = onOtherStoreButtonClickListener;
        }
    }

    public void showShimmerMerchantList() {
        SkeletonScreen skeletonScreen = this.moveToNextValue;
        if (skeletonScreen == null) {
            this.moveToNextValue = ShimmeringUtil.PlaceComponentResult(this.rvMerchantList, R.layout.view_merchant_list_skeleton);
        } else {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    public void setPreSelectedCategoryId(String str) {
        this.lookAheadTest = str;
    }

    public void clearPreSelectedCategory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.lookAheadTest = null;
            this.llMerchantListEmptyState.setVisibility(8);
            this.rvMerchantCategory.scrollToPosition(0);
        }
    }

    public void forceHideCategory() {
        this.PlaceComponentResult = true;
    }

    public void updateShopModelsWithPromo(List<ShopModel> list, Function1<ShopModel, ShopModel> function1) {
        MerchantListAdapter merchantListAdapter = this.scheduleImpl;
        if (merchantListAdapter.getItems() == null || merchantListAdapter.getItems().isEmpty()) {
            return;
        }
        merchantListAdapter.lookAheadTest = false;
        for (ShopModel shopModel : list) {
            int indexOf = merchantListAdapter.getItems().indexOf(shopModel);
            if (indexOf >= 0) {
                function1.invoke(shopModel);
                List<PromoInfoModel> list2 = shopModel.getCallingPid;
                if (merchantListAdapter.getItems().get(indexOf) != null) {
                    merchantListAdapter.getItems().get(indexOf).MyBillsEntityDataFactory(list2);
                    merchantListAdapter.notifyItemChanged(indexOf);
                }
            }
        }
    }

    public void showSpacer(boolean z) {
        this.viewSpacer.setVisibility(z ? 0 : 8);
    }

    @Override // id.dana.nearbyme.MerchantContract.View
    public void onCheckMerchantFilterFeatureEnableSuccess(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.presenter.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        MerchantListAdapter merchantListAdapter = new MerchantListAdapter();
        this.scheduleImpl = merchantListAdapter;
        this.rvMerchantList.setAdapter(merchantListAdapter);
        this.rvMerchantList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvMerchantList.addItemDecoration(new DividerItemDecoration(getContext(), ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157), 0.5f));
        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) this.rvMerchantList, false);
        MerchantCategoryAdapter merchantCategoryAdapter = new MerchantCategoryAdapter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantCategoryAdapter;
        merchantCategoryAdapter.BuiltInFictitiousFunctionClassFactory = this;
        this.rvMerchantCategory.setAdapter(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.rvMerchantCategory.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvMerchantCategory.addItemDecoration(new HorizontalEvenlyItemDecoration());
        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) this.rvMerchantCategory, false);
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.nearbyme.summary.MerchantListView$$ExternalSyntheticLambda0
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                MerchantListView.this.m2734x16eedab2(nestedScrollView, i, i2, i3, i4);
            }
        });
    }
}
