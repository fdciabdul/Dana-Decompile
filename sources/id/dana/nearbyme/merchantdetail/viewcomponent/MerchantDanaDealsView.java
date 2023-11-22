package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantDanaDealsComponent;
import id.dana.di.modules.MerchantDanaDealsModule;
import id.dana.nearbyme.merchantdetail.adapter.MerchantDanaDealsAdapter;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.model.MerchantVoucherInfoModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.ProductOrderModel;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\t¢\u0006\u0004\b1\u00102B+\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00100\u001a\u00020\t\u0012\u0006\u00103\u001a\u00020\t¢\u0006\u0004\b1\u00104J*\u0010\u0007\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R:\u0010+\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsView;", "Lid/dana/base/BaseRichView;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantDetailInteraction;", "Lkotlin/ParameterName;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/jvm/functions/Function1;)V", "", "getLayout", "()I", "", "merchantId", FeatureParams.SHOP_ID, "getMerchantDanaDealsVoucher", "(Ljava/lang/String;Ljava/lang/String;)V", "hideSection", "()V", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "setup", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantDanaDealsAdapter;", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantDanaDealsAdapter;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "presenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "getPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "setPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;)V", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "value", "getAuthRequestContext", "Ljava/util/List;", "getVoucherInfo", "()Ljava/util/List;", "setVoucherInfo", "(Ljava/util/List;)V", "voucherInfo", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDanaDealsView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private MerchantDanaDealsAdapter MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<MerchantProductInfoModel> voucherInfo;
    @Inject
    public MerchantDanaDealsContract.Presenter presenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDanaDealsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDanaDealsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_merchant_dana_deals;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDanaDealsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantDanaDealsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDanaDealsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getPresenter")
    public final MerchantDanaDealsContract.Presenter getPresenter() {
        MerchantDanaDealsContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MerchantDanaDealsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getVoucherInfo")
    public final List<MerchantProductInfoModel> getVoucherInfo() {
        return this.voucherInfo;
    }

    @JvmName(name = "setVoucherInfo")
    public final void setVoucherInfo(List<MerchantProductInfoModel> list) {
        this.voucherInfo = list;
        MerchantDanaDealsAdapter merchantDanaDealsAdapter = this.MyBillsEntityDataFactory;
        if (merchantDanaDealsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDanaDealsAdapter = null;
        }
        merchantDanaDealsAdapter.setItems(list);
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMerchantDanaDealsComponent.Builder authRequestContext = DaggerMerchantDanaDealsComponent.getAuthRequestContext();
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.MyBillsEntityDataFactory = (MerchantDanaDealsModule) Preconditions.getAuthRequestContext(new MerchantDanaDealsModule(new MerchantDanaDealsContract.View() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView$injectComponent$1
            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final /* synthetic */ void PlaceComponentResult(boolean z, List list, List list2) {
                MerchantDanaDealsContract.View.CC.MyBillsEntityDataFactory(list, list2);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final /* synthetic */ void getAuthRequestContext() {
                MerchantDanaDealsContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantProductInfoModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.isEmpty()) {
                    MerchantDanaDealsView.this.hideSection();
                } else {
                    MerchantDanaDealsView.this.setVoucherInfo(p0);
                }
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final void MyBillsEntityDataFactory() {
                MerchantDanaDealsView.this.hideSection();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final void PlaceComponentResult(ProductOrderModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantDanaDealsView.this.BuiltInFictitiousFunctionClassFactory(new Function1<MerchantDetailInteraction, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView$dismissLoadingDialogOnActivity$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(MerchantDetailInteraction merchantDetailInteraction) {
                        invoke2(merchantDetailInteraction);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(MerchantDetailInteraction merchantDetailInteraction) {
                        Intrinsics.checkNotNullParameter(merchantDetailInteraction, "");
                        merchantDetailInteraction.dismissLoadingDialog();
                    }
                });
                DanaH5.startContainerFullUrl(p0.getAuthRequestContext);
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final void PlaceComponentResult() {
                MerchantDanaDealsView.this.BuiltInFictitiousFunctionClassFactory(new Function1<MerchantDetailInteraction, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView$dismissLoadingDialogOnActivity$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(MerchantDetailInteraction merchantDetailInteraction) {
                        invoke2(merchantDetailInteraction);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(MerchantDetailInteraction merchantDetailInteraction) {
                        Intrinsics.checkNotNullParameter(merchantDetailInteraction, "");
                        merchantDetailInteraction.dismissLoadingDialog();
                    }
                });
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, MerchantDanaDealsModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerMerchantDanaDealsComponent.MerchantDanaDealsComponentImpl(authRequestContext.MyBillsEntityDataFactory, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).getAuthRequestContext(this);
    }

    public final void getMerchantDanaDealsVoucher(String merchantId, String shopId) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(shopId, "");
        getPresenter().getAuthRequestContext(merchantId, shopId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super MerchantDetailInteraction, Unit> p0) {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof MerchantDetailInteraction) {
                p0.invoke(context);
            }
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, "Parent must implement MerchantDetailInteraction");
    }

    public final void hideSection() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d99_daggermissioncomponent_missioncomponentimpl_providefeedsconfigrepositoryprovider);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r29v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.base.BaseRichView
    public final void setup() {
        new PagerSnapHelper().KClassImpl$Data$declaredNonStaticMembers$2((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a114a_settotalinvestmentassets_app_productionrelease));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        MerchantDanaDealsAdapter merchantDanaDealsAdapter = new MerchantDanaDealsAdapter(context);
        this.MyBillsEntityDataFactory = merchantDanaDealsAdapter;
        Function1<MerchantProductInfoModel, Unit> function1 = new Function1<MerchantProductInfoModel, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView$setupRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantProductInfoModel merchantProductInfoModel) {
                invoke2(merchantProductInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantProductInfoModel merchantProductInfoModel) {
                Intrinsics.checkNotNullParameter(merchantProductInfoModel, "");
                MerchantDanaDealsView.this.BuiltInFictitiousFunctionClassFactory(new Function1<MerchantDetailInteraction, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView$showLoadingDialogOnActivity$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(MerchantDetailInteraction merchantDetailInteraction) {
                        invoke2(merchantDetailInteraction);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(MerchantDetailInteraction merchantDetailInteraction) {
                        Intrinsics.checkNotNullParameter(merchantDetailInteraction, "");
                        merchantDetailInteraction.showLoadingDialog();
                    }
                });
                MerchantDanaDealsView.this.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(merchantProductInfoModel);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        merchantDanaDealsAdapter.BuiltInFictitiousFunctionClassFactory = function1;
        MerchantDanaDealsAdapter merchantDanaDealsAdapter2 = this.MyBillsEntityDataFactory;
        MerchantDanaDealsAdapter merchantDanaDealsAdapter3 = null;
        if (merchantDanaDealsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDanaDealsAdapter2 = null;
        }
        merchantDanaDealsAdapter2.setItems(this.voucherInfo);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a114a_settotalinvestmentassets_app_productionrelease);
        if (recyclerView != null) {
            MerchantDanaDealsAdapter merchantDanaDealsAdapter4 = this.MyBillsEntityDataFactory;
            if (merchantDanaDealsAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                merchantDanaDealsAdapter3 = merchantDanaDealsAdapter4;
            }
            recyclerView.setAdapter(merchantDanaDealsAdapter3);
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a114a_settotalinvestmentassets_app_productionrelease);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        ((ScrollingPagerIndicator) _$_findCachedViewById(R.id.scroll_indicator)).attachToRecyclerView((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a114a_settotalinvestmentassets_app_productionrelease));
        String str = null;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str2 = null;
        String str3 = null;
        int i = 7;
        String str4 = null;
        ?? r29 = 0;
        setVoucherInfo(CollectionsKt.arrayListOf(new MerchantProductInfoModel("", "", "", "", "", new MoneyViewModel("", "", str, 4, defaultConstructorMarker), new MoneyViewModel("", "", null, 4, null), true, "", MapsKt.mapOf(new Pair("", "")), new MerchantVoucherInfoModel("", "", "", "", new MoneyViewModel(str2, str3, str, i, defaultConstructorMarker), new MoneyViewModel(null, null, str4, 7, r29), new MoneyViewModel(str2, str3, str, i, defaultConstructorMarker), new MoneyViewModel(str4, null, r29, 7, null), new MoneyViewModel(null, null, null, 7, null), "", "", "", true), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
    }
}
