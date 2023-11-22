package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.view.MutableLiveData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.textview.MaterialTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantInfoComponent;
import id.dana.di.modules.MerchantInfoModule;
import id.dana.extension.ContextExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import id.dana.nearbyme.merchantdetail.model.MerchantInfoModel;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract;
import id.dana.nearbyme.model.ContactAddressModel;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.handler.ScannerFromViewType;
import id.dana.utils.ResourceUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\b¢\u0006\u0004\b(\u0010)B+\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010*\u001a\u00020\b¢\u0006\u0004\b(\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\""}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoView;", "Lid/dana/base/BaseRichView;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract;", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "merchantDetailViewState", "", "bindViewState", "(Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;)V", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "setup", "()V", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getDistance", "()Ljava/lang/String;", "setDistance", "(Ljava/lang/String;)V", "distance", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$Presenter;", "merchantInfoPresenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$Presenter;", "getMerchantInfoPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$Presenter;", "setMerchantInfoPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$Presenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantInfoView extends BaseRichView implements MerchantDetailContract {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MerchantDetailViewState BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String distance;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public MerchantInfoContract.Presenter merchantInfoPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantInfoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantInfoView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_info;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getMerchantInfoPresenter")
    public final MerchantInfoContract.Presenter getMerchantInfoPresenter() {
        MerchantInfoContract.Presenter presenter = this.merchantInfoPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMerchantInfoPresenter")
    public final void setMerchantInfoPresenter(MerchantInfoContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.merchantInfoPresenter = presenter;
    }

    @JvmName(name = "getDistance")
    public final String getDistance() {
        return this.distance;
    }

    @JvmName(name = "setDistance")
    public final void setDistance(String str) {
        this.distance = str;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMerchantInfoComponent.Builder MyBillsEntityDataFactory = DaggerMerchantInfoComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.getAuthRequestContext = (MerchantInfoModule) Preconditions.getAuthRequestContext(new MerchantInfoModule(new MerchantInfoContract.View() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoView$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
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

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract.View
            public final void BuiltInFictitiousFunctionClassFactory(MerchantInfoModel p0) {
                MerchantDetailViewState merchantDetailViewState;
                Intrinsics.checkNotNullParameter(p0, "");
                merchantDetailViewState = MerchantInfoView.this.BuiltInFictitiousFunctionClassFactory;
                if (merchantDetailViewState == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantDetailViewState = null;
                }
                merchantDetailViewState.getAuthRequestContext.PlaceComponentResult((MutableLiveData<MerchantInfoModel>) p0);
                MerchantInfoView.access$setupMerchantInfo(MerchantInfoView.this, p0.BuiltInFictitiousFunctionClassFactory);
                MerchantInfoView.access$setupMerchantRating(MerchantInfoView.this, p0.NetworkUserEntityData$$ExternalSyntheticLambda2, p0.NetworkUserEntityData$$ExternalSyntheticLambda1);
                MerchantInfoView.access$setupMerchantDistanceAndOpenHours(MerchantInfoView.this, p0.getGetAuthRequestContext(), p0.getErrorConfigVersion, p0.KClassImpl$Data$declaredNonStaticMembers$2);
                MerchantInfoView.access$setupMerchantAddressView(MerchantInfoView.this, p0.PlaceComponentResult, p0.lookAheadTest, p0.MyBillsEntityDataFactory);
                MerchantInfoView.access$setupQrisText(MerchantInfoView.this);
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                MerchantSummaryInfoView merchantSummaryInfoView = (MerchantSummaryInfoView) MerchantInfoView.this._$_findCachedViewById(R.id.summary_info_view);
                if (merchantSummaryInfoView != null) {
                    merchantSummaryInfoView.hideShimmer();
                }
                MerchantDistanceAndOpenHourView merchantDistanceAndOpenHourView = (MerchantDistanceAndOpenHourView) MerchantInfoView.this._$_findCachedViewById(R.id.res_0x7f0a0ea3_r8_lambda_d9liwgkrpmdwmkobhe_ybdklbfo);
                if (merchantDistanceAndOpenHourView != null) {
                    merchantDistanceAndOpenHourView.hideShimmer();
                }
                MerchantAddressView merchantAddressView = (MerchantAddressView) MerchantInfoView.this._$_findCachedViewById(R.id.merchant_address_view);
                if (merchantAddressView != null) {
                    merchantAddressView.hideShimmer();
                }
                MerchantRatingView merchantRatingView = (MerchantRatingView) MerchantInfoView.this._$_findCachedViewById(R.id.merchant_rating_view);
                if (merchantRatingView != null) {
                    merchantRatingView.hideShimmer();
                }
                MerchantInfoView.this._$_findCachedViewById(R.id.setBackgroundTime_res_0x7f0a049f).setVisibility(8);
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<? extends PromoInfoModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantPromoView merchantPromoView = (MerchantPromoView) MerchantInfoView.this._$_findCachedViewById(R.id.merchant_promo_view);
                if (merchantPromoView != null) {
                    MerchantInfoView merchantInfoView = MerchantInfoView.this;
                    if ((!p0.isEmpty()) != false) {
                        merchantPromoView.setPromo(MerchantInfoView.access$getPromoText(merchantInfoView), p0);
                    } else {
                        merchantPromoView.setVisibility(8);
                    }
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, MerchantInfoModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerMerchantInfoComponent.MerchantInfoComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).MyBillsEntityDataFactory(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void bindViewState(id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState r9) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoView.bindViewState(id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState):void");
    }

    public static /* synthetic */ void $r8$lambda$0hLYv_LN5TJAiDz2FyWANf68X1E(MerchantInfoView merchantInfoView, MerchantDetailViewState merchantDetailViewState, View view) {
        Intrinsics.checkNotNullParameter(merchantInfoView, "");
        Intrinsics.checkNotNullParameter(merchantDetailViewState, "");
        Context context = merchantInfoView.getContext();
        if (context != null) {
            ContextExtKt.BuiltInFictitiousFunctionClassFactory(context, merchantDetailViewState.PlaceComponentResult.DatabaseTableConfigUtil, merchantDetailViewState.PlaceComponentResult.PrepareContext);
        }
    }

    public static /* synthetic */ void $r8$lambda$GvFCBVDkdJMdH_c8S_olwOKBwLo(MerchantInfoView merchantInfoView) {
        Intrinsics.checkNotNullParameter(merchantInfoView, "");
        MaterialTextView materialTextView = (MaterialTextView) merchantInfoView._$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (materialTextView == null || materialTextView.getLineCount() <= 1) {
            return;
        }
        Button button = (Button) merchantInfoView._$_findCachedViewById(R.id.setNetAuthId);
        if (button != null) {
            button.setMinimumWidth(0);
        }
        Button button2 = (Button) merchantInfoView._$_findCachedViewById(R.id.setNetAuthId);
        if (button2 != null) {
            button2.setMinWidth(0);
        }
    }

    public static /* synthetic */ void $r8$lambda$sfMETKX6xwQizbOsXRMVtCOjPj4(MerchantInfoView merchantInfoView, double d, double d2, View view) {
        Intrinsics.checkNotNullParameter(merchantInfoView, "");
        Context context = merchantInfoView.getContext();
        if (context != null) {
            ContextExtKt.BuiltInFictitiousFunctionClassFactory(context, d, d2);
        }
    }

    public static /* synthetic */ void $r8$lambda$vELPHK_zAswlDDw0emBmCGJBUto(MerchantInfoView merchantInfoView, View view) {
        Intrinsics.checkNotNullParameter(merchantInfoView, "");
        BaseActivity baseActivity = merchantInfoView.getBaseActivity();
        Intent intent = new Intent(baseActivity, ScannerActivity.class);
        intent.putExtra(ScannerActivity.FROM_VIEW_TYPE, ScannerFromViewType.FOUR_KINGKONG);
        baseActivity.startActivity(intent);
    }

    public static /* synthetic */ void $r8$lambda$xkzvWDsUnNViPmOXriurR0SYpRI(MerchantInfoView merchantInfoView) {
        Button button;
        Intrinsics.checkNotNullParameter(merchantInfoView, "");
        MaterialTextView materialTextView = (MaterialTextView) merchantInfoView._$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (materialTextView == null || materialTextView.getLineCount() <= 1 || (button = (Button) merchantInfoView._$_findCachedViewById(R.id.setNetAuthId)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(button, "");
        ViewExtKt.BuiltInFictitiousFunctionClassFactory(button, Integer.valueOf(merchantInfoView.getContext().getResources().getDimensionPixelSize(R.dimen.f31342131165765)), null, Integer.valueOf(merchantInfoView.getContext().getResources().getDimensionPixelSize(R.dimen.f31342131165765)), null, 10);
    }

    public static final /* synthetic */ String access$getPromoText(MerchantInfoView merchantInfoView) {
        StringBuilder sb = new StringBuilder();
        MerchantDetailViewState merchantDetailViewState = merchantInfoView.BuiltInFictitiousFunctionClassFactory;
        if (merchantDetailViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailViewState = null;
        }
        ShopModel shopModel = merchantDetailViewState.PlaceComponentResult;
        Context context = merchantInfoView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        sb.append(ResourceUtils.PlaceComponentResult(context, shopModel.scheduleImpl(), shopModel.scheduleImpl()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(InputCardNumberView.DIVIDER);
        sb2.append(shopModel.NetworkUserEntityData$$ExternalSyntheticLambda0());
        sb.append(sb2.toString());
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final /* synthetic */ void access$setupMerchantAddressView(final MerchantInfoView merchantInfoView, final double d, final double d2, ContactAddressModel contactAddressModel) {
        MerchantAddressView merchantAddressView = (MerchantAddressView) merchantInfoView._$_findCachedViewById(R.id.merchant_address_view);
        if (merchantAddressView != null) {
            merchantAddressView.hideShimmer();
        }
        MerchantAddressView merchantAddressView2 = (MerchantAddressView) merchantInfoView._$_findCachedViewById(R.id.merchant_address_view);
        if (merchantAddressView2 != null) {
            String str = TextUtils.isEmpty(contactAddressModel.PlaceComponentResult) ? "" : contactAddressModel.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(str, "");
            merchantAddressView2.setMerchantAddress(str);
        }
        MerchantAddressView merchantAddressView3 = (MerchantAddressView) merchantInfoView._$_findCachedViewById(R.id.merchant_address_view);
        if (merchantAddressView3 != null) {
            merchantAddressView3.setOnButtonClick(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantInfoView.$r8$lambda$sfMETKX6xwQizbOsXRMVtCOjPj4(MerchantInfoView.this, d, d2, view);
                }
            });
        }
    }

    public static final /* synthetic */ void access$setupMerchantDistanceAndOpenHours(MerchantInfoView merchantInfoView, boolean z, String str, String str2) {
        String obj;
        MerchantDistanceAndOpenHourView merchantDistanceAndOpenHourView = (MerchantDistanceAndOpenHourView) merchantInfoView._$_findCachedViewById(R.id.res_0x7f0a0ea3_r8_lambda_d9liwgkrpmdwmkobhe_ybdklbfo);
        if (merchantDistanceAndOpenHourView != null) {
            merchantDistanceAndOpenHourView.hideShimmer();
        }
        if (z) {
            MerchantDistanceAndOpenHourView merchantDistanceAndOpenHourView2 = (MerchantDistanceAndOpenHourView) merchantInfoView._$_findCachedViewById(R.id.res_0x7f0a0ea3_r8_lambda_d9liwgkrpmdwmkobhe_ybdklbfo);
            if (merchantDistanceAndOpenHourView2 != null) {
                merchantDistanceAndOpenHourView2.setOpenHoursText(merchantInfoView.getResources().getString(R.string.merchant_info_twenty_four_hour_value));
                return;
            }
            return;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.length() == 0) {
            if (str2.length() == 0) {
                MerchantDistanceAndOpenHourView merchantDistanceAndOpenHourView3 = (MerchantDistanceAndOpenHourView) merchantInfoView._$_findCachedViewById(R.id.res_0x7f0a0ea3_r8_lambda_d9liwgkrpmdwmkobhe_ybdklbfo);
                if (merchantDistanceAndOpenHourView3 != null) {
                    merchantDistanceAndOpenHourView3.setOpenHoursText(merchantInfoView.getResources().getString(R.string.merchant_default_empty_value));
                    return;
                }
                return;
            }
        }
        MerchantDistanceAndOpenHourView merchantDistanceAndOpenHourView4 = (MerchantDistanceAndOpenHourView) merchantInfoView._$_findCachedViewById(R.id.res_0x7f0a0ea3_r8_lambda_d9liwgkrpmdwmkobhe_ybdklbfo);
        if (merchantDistanceAndOpenHourView4 != null) {
            if (Intrinsics.areEqual(str, str2)) {
                obj = merchantInfoView.getResources().getString(R.string.merchant_info_twenty_four_hour_value);
                Intrinsics.checkNotNullExpressionValue(obj, "");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" - ");
                sb.append(str2);
                obj = sb.toString();
            }
            merchantDistanceAndOpenHourView4.setOpenHoursText(obj);
        }
    }

    public static final /* synthetic */ void access$setupMerchantInfo(MerchantInfoView merchantInfoView, String str) {
        MerchantSummaryInfoView merchantSummaryInfoView = (MerchantSummaryInfoView) merchantInfoView._$_findCachedViewById(R.id.summary_info_view);
        if (merchantSummaryInfoView != null) {
            merchantSummaryInfoView.hideShimmer();
        }
        MerchantSummaryInfoView merchantSummaryInfoView2 = (MerchantSummaryInfoView) merchantInfoView._$_findCachedViewById(R.id.summary_info_view);
        if (merchantSummaryInfoView2 != null) {
            merchantSummaryInfoView2.setMerchantLogoUrl(str);
        }
    }

    public static final /* synthetic */ void access$setupMerchantRating(MerchantInfoView merchantInfoView, Double d, Double d2) {
        MerchantRatingView merchantRatingView = (MerchantRatingView) merchantInfoView._$_findCachedViewById(R.id.merchant_rating_view);
        if (merchantRatingView != null) {
            merchantRatingView.hideShimmer();
        }
        MerchantRatingView merchantRatingView2 = (MerchantRatingView) merchantInfoView._$_findCachedViewById(R.id.merchant_rating_view);
        if (merchantRatingView2 != null) {
            merchantRatingView2.setRating(d);
            merchantRatingView2.setNumberOfReviews(d2);
        }
    }

    public static final /* synthetic */ void access$setupQrisText(final MerchantInfoView merchantInfoView) {
        View _$_findCachedViewById = merchantInfoView._$_findCachedViewById(R.id.setBackgroundTime_res_0x7f0a049f);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(0);
        }
        View _$_findCachedViewById2 = merchantInfoView._$_findCachedViewById(R.id.setBackgroundTime_res_0x7f0a049f);
        if (_$_findCachedViewById2 != null) {
            _$_findCachedViewById2.post(new Runnable() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MerchantInfoView.$r8$lambda$GvFCBVDkdJMdH_c8S_olwOKBwLo(MerchantInfoView.this);
                }
            });
        }
        View _$_findCachedViewById3 = merchantInfoView._$_findCachedViewById(R.id.setBackgroundTime_res_0x7f0a049f);
        if (_$_findCachedViewById3 != null) {
            _$_findCachedViewById3.post(new Runnable() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MerchantInfoView.$r8$lambda$xkzvWDsUnNViPmOXriurR0SYpRI(MerchantInfoView.this);
                }
            });
        }
    }
}
