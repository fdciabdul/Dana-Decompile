package id.dana.cashier.fragment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.model.CashierKybOrderDetailModel;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.view.CashierInputAmountView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.richview.NumpadView;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.FragmentInputAmountBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.CashierComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.utils.ShimmeringUtil;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b&\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u0013\u0010\u0013\u001a\u00020\u0005*\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0013\u0010\u0006\u001a\u00020\u0015*\u00020\u0014H\u0002¢\u0006\u0004\b\u0006\u0010\u0016J\u0013\u0010\b\u001a\u00020\u0005*\u00020\u000fH\u0002¢\u0006\u0004\b\b\u0010\u0011J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u000fH\u0002¢\u0006\u0004\b\u0006\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001b\u001a\u00020\u001aX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/cashier/fragment/InputAmountFragment;", "Lid/dana/cashier/fragment/BaseVBCashierFragment;", "Lid/dana/databinding/FragmentInputAmountBinding;", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "onStart", "whenAvailable", "PlaceComponentResult", "Lid/dana/cashier/model/CashierMerchantModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/CashierMerchantModel;)V", "A", "MyBillsEntityDataFactory", "Landroid/view/View;", "", "(Landroid/view/View;)Z", "Lid/dana/di/component/CashierComponent;", "moveToNextValue", "Lid/dana/di/component/CashierComponent;", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Ljava/util/List;", "scheduleImpl", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "Lid/dana/cashier/model/CashierMerchantModel;", "getErrorConfigVersion", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputAmountFragment extends BaseVBCashierFragment<FragmentInputAmountBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private CashierMerchantModel getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    List<? extends SkeletonScreen> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    List<? extends SkeletonScreen> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    @Inject
    public CashierContract.Presenter cashierPresenter;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private CashierComponent MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentInputAmountBinding PlaceComponentResult = FragmentInputAmountBinding.PlaceComponentResult(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        CashierMerchantModel cashierMerchantModel;
        Bundle arguments = getArguments();
        if (arguments != null) {
            CashierMerchantModel cashierMerchantModel2 = (CashierMerchantModel) arguments.getParcelable("arg_merchant_model");
            CashierContract.Presenter presenter = null;
            if (cashierMerchantModel2 != null) {
                this.getErrorConfigVersion = cashierMerchantModel2;
                if (cashierMerchantModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierMerchantModel = null;
                } else {
                    cashierMerchantModel = cashierMerchantModel2;
                }
                MyBillsEntityDataFactory(cashierMerchantModel);
                String str = cashierMerchantModel2.NetworkUserEntityData$$ExternalSyntheticLambda8;
                this.PlaceComponentResult = !(str == null || str.length() == 0);
            }
            String string = arguments.getString("kyb_order_id");
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "");
                boolean z = string.length() > 0;
                this.BuiltInFictitiousFunctionClassFactory = z;
                if (z) {
                    CashierContract.Presenter presenter2 = this.cashierPresenter;
                    if (presenter2 != null) {
                        presenter = presenter2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter.MyBillsEntityDataFactory(string);
                }
            }
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                InputAmountFragment.this.getAuthRequestContext(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                CashierMerchantModel cashierMerchantModel;
                CashierMerchantModel cashierMerchantModel2;
                cashierMerchantModel = InputAmountFragment.this.getErrorConfigVersion;
                if (cashierMerchantModel != null) {
                    cashierMerchantModel2 = InputAmountFragment.this.getErrorConfigVersion;
                    if (cashierMerchantModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        cashierMerchantModel2 = null;
                    }
                    cashierMerchantModel2.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierMerchantModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                InputAmountFragment.this.getErrorConfigVersion = p0;
                InputAmountFragment.this.MyBillsEntityDataFactory(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                InputAmountFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                InputAmountFragment.this.GetContactSyncConfig();
                InputAmountFragment inputAmountFragment = InputAmountFragment.this;
                ShimmeringUtil.getAuthRequestContext(inputAmountFragment.getAuthRequestContext);
                ShimmeringUtil.getAuthRequestContext(inputAmountFragment.KClassImpl$Data$declaredNonStaticMembers$2);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                InputAmountFragment inputAmountFragment = InputAmountFragment.this;
                if (p0 == null) {
                    p0 = inputAmountFragment.getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                }
                FragmentActivity activity = inputAmountFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                FragmentActivity activity2 = InputAmountFragment.this.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
            public final void DatabaseTableConfigUtil() {
                InputAmountFragment.this.A();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                VB vb = InputAmountFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    ((FragmentInputAmountBinding) vb).PlaceComponentResult.setCurrency(p0);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }));
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$cashierRiskChallengeModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$cashierHighlightModule$1
        }));
        CashierComponent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        this.MyBillsEntityDataFactory = MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        CashierContract.Presenter presenter = this.cashierPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    public static boolean getAuthRequestContext(View view) {
        Rect rect = new Rect();
        return view.getGlobalVisibleRect(rect) && view.getHeight() == rect.height() && view.getWidth() == rect.width();
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        String string = getString(!this.BuiltInFictitiousFunctionClassFactory ? R.string.enter_price_amount : R.string.order_confirmation);
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory(string);
    }

    public final void MyBillsEntityDataFactory(CashierMerchantModel cashierMerchantModel) {
        if (cashierMerchantModel.getBuiltInFictitiousFunctionClassFactory()) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentInputAmountBinding) vb).PlaceComponentResult.setCurrency("");
                String str = cashierMerchantModel.PlaceComponentResult;
                if (str != null) {
                    CashierContract.Presenter presenter = this.cashierPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    presenter.PlaceComponentResult(str);
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2(cashierMerchantModel);
        getAuthRequestContext(cashierMerchantModel);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(CashierMerchantModel cashierMerchantModel) {
        String obj;
        if (cashierMerchantModel.getBuiltInFictitiousFunctionClassFactory()) {
            String str = cashierMerchantModel.DatabaseTableConfigUtil;
            if (str == null || str.length() == 0) {
                cashierMerchantModel.DatabaseTableConfigUtil = getString(R.string.cashier_default_qr_merchant_info_title);
            }
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputAmountBinding) vb).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.setText(cashierMerchantModel.DatabaseTableConfigUtil);
            BuiltInFictitiousFunctionClassFactory(cashierMerchantModel);
            String str2 = cashierMerchantModel.lookAheadTest;
            if (str2 == null || str2.length() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(DanaUrl.MERCHANT_LOGO_BASE_URL);
                sb.append(cashierMerchantModel.GetContactSyncConfig);
                obj = sb.toString();
            } else {
                obj = cashierMerchantModel.lookAheadTest;
            }
            GlideRequest<Drawable> PlaceComponentResult = GlideApp.KClassImpl$Data$declaredNonStaticMembers$2(this).PlaceComponentResult(obj).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_merchant_logo_placeholder).PlaceComponentResult((int) R.drawable.ic_merchant_logo_placeholder);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                PlaceComponentResult.MyBillsEntityDataFactory((ImageView) ((FragmentInputAmountBinding) vb2).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                CashierMerchantModel cashierMerchantModel2 = this.getErrorConfigVersion;
                if (cashierMerchantModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierMerchantModel2 = null;
                }
                String str3 = cashierMerchantModel2.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (str3 != null) {
                    if (str3.length() > 0) {
                        PlaceComponentResult(str3);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void getAuthRequestContext(String p0) {
        CashierMerchantModel cashierMerchantModel;
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            CashierMerchantModel cashierMerchantModel2 = this.getErrorConfigVersion;
            if (cashierMerchantModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierMerchantModel = null;
            } else {
                cashierMerchantModel = cashierMerchantModel2;
            }
            PayActivity.processCashierUrl$default(payActivity, p0, null, null, false, null, cashierMerchantModel, 30, null);
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void A() {
        Pair[] pairArr = new Pair[3];
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            pairArr[0] = new Pair(((FragmentInputAmountBinding) vb).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, Integer.valueOf((int) R.layout.view_skeleton_cashier_merchant_logo));
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                pairArr[1] = new Pair(((FragmentInputAmountBinding) vb2).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, Integer.valueOf((int) R.layout.view_skeleton_cashier_header_title));
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    pairArr[2] = new Pair(((FragmentInputAmountBinding) vb3).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, Integer.valueOf((int) R.layout.view_skeleton_cashier_header_subtitle));
                    HashMap hashMapOf = MapsKt.hashMapOf(pairArr);
                    Pair[] pairArr2 = new Pair[2];
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        pairArr2[0] = new Pair(((FragmentInputAmountBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda1, Integer.valueOf((int) R.layout.view_skeleton_cashier_input_amount));
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            pairArr2[1] = new Pair(((FragmentInputAmountBinding) vb5).scheduleImpl, Integer.valueOf((int) R.layout.view_skeleton_cashier_cta_button));
                            HashMap hashMapOf2 = MapsKt.hashMapOf(pairArr2);
                            this.getAuthRequestContext = ShimmeringUtil.MyBillsEntityDataFactory(hashMapOf, R.color.res_0x7f060349_networkuserentitydata_externalsyntheticlambda2);
                            this.KClassImpl$Data$declaredNonStaticMembers$2 = ShimmeringUtil.MyBillsEntityDataFactory(hashMapOf2, 0);
                            ShimmeringUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
                            ShimmeringUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.setDismissAllowed(false);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/fragment/InputAmountFragment$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ InputAmountFragment PlaceComponentResult(CashierMerchantModel cashierMerchantModel, String str, int i) {
            if ((i & 1) != 0) {
                cashierMerchantModel = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            InputAmountFragment inputAmountFragment = new InputAmountFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_merchant_model", cashierMerchantModel);
            bundle.putString("kyb_order_id", str);
            inputAmountFragment.setArguments(bundle);
            return inputAmountFragment;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(boolean z, InputAmountFragment inputAmountFragment) {
        String str;
        Intrinsics.checkNotNullParameter(inputAmountFragment, "");
        if (z) {
            CashierMerchantModel cashierMerchantModel = null;
            if (inputAmountFragment.BuiltInFictitiousFunctionClassFactory) {
                CashierMerchantModel cashierMerchantModel2 = inputAmountFragment.getErrorConfigVersion;
                if (cashierMerchantModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    cashierMerchantModel = cashierMerchantModel2;
                }
                CashierKybOrderDetailModel cashierKybOrderDetailModel = cashierMerchantModel.moveToNextValue;
                if (cashierKybOrderDetailModel == null || (str = cashierKybOrderDetailModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                    return;
                }
                inputAmountFragment.getAuthRequestContext(str);
                return;
            }
            CashierMerchantModel cashierMerchantModel3 = inputAmountFragment.getErrorConfigVersion;
            if (cashierMerchantModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierMerchantModel3 = null;
            }
            if (cashierMerchantModel3.getPrepareContext()) {
                CashierContract.Presenter presenter = inputAmountFragment.cashierPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                FragmentActivity activity = inputAmountFragment.getActivity();
                if (activity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.pay.PayActivity");
                }
                HashMap<String, String> nativelyDecodedQrResult = ((PayActivity) activity).getNativelyDecodedQrResult();
                CashierMerchantModel cashierMerchantModel4 = inputAmountFragment.getErrorConfigVersion;
                if (cashierMerchantModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierMerchantModel4 = null;
                }
                String str2 = cashierMerchantModel4.NetworkUserEntityData$$ExternalSyntheticLambda2;
                CashierMerchantModel cashierMerchantModel5 = inputAmountFragment.getErrorConfigVersion;
                if (cashierMerchantModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierMerchantModel5 = null;
                }
                presenter.KClassImpl$Data$declaredNonStaticMembers$2(nativelyDecodedQrResult, str2, cashierMerchantModel5.NetworkUserEntityData$$ExternalSyntheticLambda7);
            }
            CashierContract.Presenter presenter2 = inputAmountFragment.cashierPresenter;
            if (presenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter2 = null;
            }
            CashierMerchantModel cashierMerchantModel6 = inputAmountFragment.getErrorConfigVersion;
            if (cashierMerchantModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                cashierMerchantModel = cashierMerchantModel6;
            }
            VB vb = inputAmountFragment.PlaceComponentResult;
            if (vb != 0) {
                presenter2.MyBillsEntityDataFactory(cashierMerchantModel, StringsKt.replace$default(((FragmentInputAmountBinding) vb).PlaceComponentResult.getEditTextAmount().getAmount(), ",", ".", false, 4, (Object) null));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final InputAmountFragment inputAmountFragment, final boolean z) {
        VB vb = inputAmountFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputAmountBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InputAmountFragment.MyBillsEntityDataFactory(z, inputAmountFragment);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void PlaceComponentResult(String p0) {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null && payActivity.getIsQrisCrossBorder()) {
            p0 = p0 != null ? StringsKt.replace$default(p0, ".", ",", false, 4, (Object) null) : null;
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            CashierInputAmountView cashierInputAmountView = ((FragmentInputAmountBinding) vb).PlaceComponentResult;
            cashierInputAmountView.getEditTextAmount().setText(p0);
            cashierInputAmountView.getEditTextAmount().setClickable(false);
            cashierInputAmountView.getEditTextAmount().setFocusable(false);
            cashierInputAmountView.getEditTextAmount().setEnabled(false);
            cashierInputAmountView.setDisableClearIcon(true);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void BuiltInFictitiousFunctionClassFactory(CashierMerchantModel p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            AppCompatTextView appCompatTextView = ((FragmentInputAmountBinding) vb).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            appCompatTextView.setSingleLine(true);
            appCompatTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            appCompatTextView.setMarqueeRepeatLimit(-1);
            appCompatTextView.setMaxWidth(Integer.MAX_VALUE);
            appCompatTextView.setText(p0.KClassImpl$Data$declaredNonStaticMembers$2(appCompatTextView.getContext()));
            appCompatTextView.setSelected(true);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void getAuthRequestContext(CashierMerchantModel cashierMerchantModel) {
        CashierKybOrderDetailModel cashierKybOrderDetailModel = cashierMerchantModel.moveToNextValue;
        if (cashierKybOrderDetailModel != null) {
            MoneyViewModel moneyViewModel = cashierKybOrderDetailModel.PlaceComponentResult;
            PlaceComponentResult(moneyViewModel != null ? moneyViewModel.PlaceComponentResult : null);
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputAmountBinding) vb).PlaceComponentResult.setListener(new CashierInputAmountView.OnAmountChangeListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$initViews$1
                @Override // id.dana.cashier.view.CashierInputAmountView.OnAmountChangeListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, double p1) {
                    VB vb2 = InputAmountFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        ((FragmentInputAmountBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setDanaButtonView(p0 ? 1 : 0, InputAmountFragment.this.getString(R.string.btn_continue), null, null);
                        InputAmountFragment.BuiltInFictitiousFunctionClassFactory(InputAmountFragment.this, p0);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }

                @Override // id.dana.cashier.view.CashierInputAmountView.OnAmountChangeListener
                public final void getAuthRequestContext() {
                    VB vb2 = InputAmountFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        ((FragmentInputAmountBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0.clearAmount();
                        VB vb3 = InputAmountFragment.this.PlaceComponentResult;
                        if (vb3 != 0) {
                            ((FragmentInputAmountBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2.setDanaButtonView(0, InputAmountFragment.this.getString(R.string.btn_continue), null, null);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            });
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity == null || !payActivity.getIsCustomKeyboardEnable() || this.BuiltInFictitiousFunctionClassFactory || this.PlaceComponentResult) {
                return;
            }
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                NumpadView numpadView = ((FragmentInputAmountBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(numpadView, "");
                boolean z = false;
                numpadView.setVisibility(0);
                numpadView.setListener(new NumpadView.NumpadClickListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$setupCustomKeyboard$1$1
                    @Override // id.dana.core.ui.richview.NumpadView.NumpadClickListener
                    public final void MyBillsEntityDataFactory(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p0.length() == 0) {
                            VB vb3 = InputAmountFragment.this.PlaceComponentResult;
                            if (vb3 != 0) {
                                ((FragmentInputAmountBinding) vb3).PlaceComponentResult.clear();
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        VB vb4 = InputAmountFragment.this.PlaceComponentResult;
                        if (vb4 != 0) {
                            ((FragmentInputAmountBinding) vb4).PlaceComponentResult.setPrefixedAmount(p0);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                });
                FragmentActivity activity2 = getActivity();
                PayActivity payActivity2 = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                if (payActivity2 != null && payActivity2.getIsQrisCrossBorder()) {
                    z = true;
                }
                numpadView.setDecimalPointEnabled(z);
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentInputAmountBinding) vb3).PlaceComponentResult.disableSoftKeyboard();
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ViewTreeObserver viewTreeObserver = ((FragmentInputAmountBinding) vb4).moveToNextValue.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.cashier.fragment.InputAmountFragment$autoExpandBottomSheetIfNeeded$1
                                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                                public final void onGlobalLayout() {
                                    boolean authRequestContext;
                                    VB vb5 = InputAmountFragment.this.PlaceComponentResult;
                                    if (vb5 != 0) {
                                        if (((FragmentInputAmountBinding) vb5).moveToNextValue.canScrollVertically(1)) {
                                            VB vb6 = InputAmountFragment.this.PlaceComponentResult;
                                            if (vb6 != 0) {
                                                CashierInputAmountView cashierInputAmountView = ((FragmentInputAmountBinding) vb6).PlaceComponentResult;
                                                Intrinsics.checkNotNullExpressionValue(cashierInputAmountView, "");
                                                authRequestContext = InputAmountFragment.getAuthRequestContext(cashierInputAmountView);
                                                if (!authRequestContext) {
                                                    FragmentActivity activity3 = InputAmountFragment.this.getActivity();
                                                    PayActivity payActivity3 = activity3 instanceof PayActivity ? (PayActivity) activity3 : null;
                                                    if (payActivity3 != null) {
                                                        payActivity3.expandBottomSheet();
                                                    }
                                                }
                                            } else {
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        }
                                        VB vb7 = InputAmountFragment.this.PlaceComponentResult;
                                        if (vb7 != 0) {
                                            ViewTreeObserver viewTreeObserver2 = ((FragmentInputAmountBinding) vb7).moveToNextValue.getViewTreeObserver();
                                            if (viewTreeObserver2 != null) {
                                                viewTreeObserver2.removeOnGlobalLayoutListener(this);
                                                return;
                                            }
                                            return;
                                        }
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
