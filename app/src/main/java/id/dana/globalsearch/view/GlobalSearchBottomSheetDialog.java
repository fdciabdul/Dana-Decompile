package id.dana.globalsearch.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.kernel.RVEvents;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iap.ac.android.mpm.base.model.hook.HookConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetModule;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGlobalSearchBottomSheetComponent;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.extension.ContextExtKt;
import id.dana.extension.lang.StringExtKt;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$bottomSheetCallback$2;
import id.dana.lib.gcontainer.GContainer;
import id.dana.nearbyme.merchantdetail.model.MerchantInfoModel;
import id.dana.scanner.ScannerActivity;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b,\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\tJ\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\tR\u0013\u0010\u0006\u001a\u00020\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001f\u001a\u00020\u001dX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0015\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0012\u0010$\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b$\u0010%R\u0012\u0010'\u001a\u00020&X\u0087\"¢\u0006\u0006\n\u0004\b'\u0010(R\u0012\u0010*\u001a\u00020)X\u0087\"¢\u0006\u0006\n\u0004\b*\u0010+"}, d2 = {"Lid/dana/globalsearch/view/GlobalSearchBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "dismissProgress", "()V", "", "getDimAmount", "()F", "", "getLayout", "()I", "p1", "initBottomSheet", "(II)V", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;)V", "onResume", "onShow", "showProgress", "Lid/dana/globalsearch/view/GlobalSearchBottomSheetDialog$bottomSheetCallback$2$1;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "Lid/dana/dialog/DanaLoadingDialog;", "getErrorConfigVersion", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "scheduleImpl", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$Presenter;", "presenter", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$Presenter;", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "qrPresenter", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSearchBottomSheetDialog extends BaseBottomSheetDialogFragment implements GlobalSearchBottomSheetContract.View {
    @Inject
    public GlobalSearchBottomSheetContract.Presenter presenter;
    @Inject
    public ScanQrContract.Presenter qrPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    PaySearchInfoModel getAuthRequestContext;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(GlobalSearchBottomSheetDialog.this.requireActivity());
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<GlobalSearchBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1>() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$bottomSheetCallback$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$bottomSheetCallback$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog = GlobalSearchBottomSheetDialog.this;
            return new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$bottomSheetCallback$2.1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onSlide(View p0, float p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onStateChanged(View p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (5 == p1) {
                        GlobalSearchBottomSheetDialog.this.dismissAllowingStateLoss();
                    }
                }
            };
        }
    });

    private View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.bottomsheet_globalsearch_container;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void initBottomSheet(int p0, int p1) {
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        super.initBottomSheet(p0, p1);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        LatLng latLng;
        Map<String, Object> map;
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setBottomSheetCallback((GlobalSearchBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
        }
        FrameLayout frameLayout = (FrameLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GlobalSearchBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchBottomSheetDialog.this);
                }
            });
        }
        DaggerGlobalSearchBottomSheetComponent.Builder PlaceComponentResult = DaggerGlobalSearchBottomSheetComponent.PlaceComponentResult();
        PlaceComponentResult.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getBaseActivity().getApplicationComponent());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
        byte b = 0;
        PlaceComponentResult.getAuthRequestContext = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getActivity();
        PlaceComponentResult.moveToNextValue = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        PlaceComponentResult.PlaceComponentResult = (GlobalSearchBottomSheetModule) Preconditions.getAuthRequestContext(new GlobalSearchBottomSheetModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, GlobalSearchBottomSheetModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.moveToNextValue, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, OauthModule.class);
        if (PlaceComponentResult.lookAheadTest == null) {
            PlaceComponentResult.lookAheadTest = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerGlobalSearchBottomSheetComponent.GlobalSearchBottomSheetComponentImpl(PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult.moveToNextValue, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.lookAheadTest, PlaceComponentResult.MyBillsEntityDataFactory, (byte) 0).PlaceComponentResult(this);
        PaySearchInfoModel paySearchInfoModel = this.getAuthRequestContext;
        ScanQrContract.Presenter presenter = null;
        if (paySearchInfoModel != null && (map = paySearchInfoModel.getErrorConfigVersion) != null) {
            GlobalSearchBottomSheetContract.Presenter presenter2 = this.presenter;
            if (presenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter2 = null;
            }
            presenter2.MyBillsEntityDataFactory(String.valueOf(map.get(FeatureParams.SHOP_ID)), String.valueOf(map.get("merchantId")));
        }
        PaySearchInfoModel paySearchInfoModel2 = this.getAuthRequestContext;
        String MyBillsEntityDataFactory2 = paySearchInfoModel2 != null ? paySearchInfoModel2.MyBillsEntityDataFactory() : null;
        Context context = getContext();
        if (context != null) {
            GlideApp.getAuthRequestContext(context).PlaceComponentResult(MyBillsEntityDataFactory2).getErrorConfigVersion((int) R.drawable.ic_merchant_logo_placeholder).PlaceComponentResult((int) R.drawable.ic_merchant_logo_placeholder).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) MyBillsEntityDataFactory(R.id.requiresTunnel)));
        }
        TextView textView = (TextView) MyBillsEntityDataFactory(R.id.res_0x7f0a14d0_amountformuistate_onsuccesstransfersubmit);
        if (textView != null) {
            PaySearchInfoModel paySearchInfoModel3 = this.getAuthRequestContext;
            textView.setText(paySearchInfoModel3 != null ? paySearchInfoModel3.GetContactSyncConfig : null);
        }
        TextView textView2 = (TextView) MyBillsEntityDataFactory(R.id.res_0x7f0a14cf_pagedlist_loadstatemanager);
        if (textView2 != null) {
            PaySearchInfoModel paySearchInfoModel4 = this.getAuthRequestContext;
            textView2.setText(paySearchInfoModel4 != null ? paySearchInfoModel4.NetworkUserEntityData$$ExternalSyntheticLambda2 : null);
        }
        TextView textView3 = (TextView) MyBillsEntityDataFactory(R.id.executeDoubleFunction);
        if (textView3 != null) {
            textView3.setText("");
        }
        TextView textView4 = (TextView) MyBillsEntityDataFactory(R.id.getISOCountries);
        if (textView4 != null) {
            PaySearchInfoModel paySearchInfoModel5 = this.getAuthRequestContext;
            textView4.setText(paySearchInfoModel5 != null ? paySearchInfoModel5.PlaceComponentResult : null);
        }
        TextView textView5 = (TextView) MyBillsEntityDataFactory(R.id.createProfileProvider);
        if (textView5 != null) {
            PaySearchInfoModel paySearchInfoModel6 = this.getAuthRequestContext;
            textView5.setText(paySearchInfoModel6 != null ? paySearchInfoModel6.MyBillsEntityDataFactory : null);
        }
        PaySearchInfoModel paySearchInfoModel7 = this.getAuthRequestContext;
        if (paySearchInfoModel7 != null && (latLng = paySearchInfoModel7.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            final double latitude = latLng.getLatitude();
            final double longitude = latLng.getLongitude();
            ((DanaButtonSecondaryView) MyBillsEntityDataFactory(R.id.btnDirection)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GlobalSearchBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchBottomSheetDialog.this, latitude, longitude);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.btnError);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GlobalSearchBottomSheetDialog.getAuthRequestContext(GlobalSearchBottomSheetDialog.this);
                }
            });
        }
        final PaySearchInfoModel paySearchInfoModel8 = this.getAuthRequestContext;
        if (paySearchInfoModel8 != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) MyBillsEntityDataFactory(R.id.btnSeeDetails);
            if (danaButtonSecondaryView != null) {
                danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GlobalSearchBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(GlobalSearchBottomSheetDialog.this, paySearchInfoModel8, view);
                    }
                });
            }
            DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.btnPayMerchant);
            if (danaButtonPrimaryView2 != null) {
                danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchBottomSheetDialog$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GlobalSearchBottomSheetDialog.getAuthRequestContext(PaySearchInfoModel.this, this, view);
                    }
                });
            }
        }
        ScanQrContract.Presenter presenter3 = this.qrPresenter;
        if (presenter3 != null) {
            if (presenter3 != null) {
                presenter = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.getAuthRequestContext();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) MyBillsEntityDataFactory(R.id.btnSeeDetails);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setEnabled(true);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.btnPayMerchant);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(true);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        ScanQrContract.Presenter presenter;
        ReadLinkPropertiesContract.Presenter presenter2 = null;
        if (p0 == null || !StringsKt.contains$default((CharSequence) StringExtKt.PlaceComponentResult(p0), (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null)) {
            if (Patterns.WEB_URL.matcher(p0).matches()) {
                if (GContainer.isOpeningH5()) {
                    return;
                }
                String authRequestContext = UrlUtil.getAuthRequestContext(String.valueOf(p0));
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext);
                return;
            }
            ScanQrContract.Presenter presenter3 = this.qrPresenter;
            if (presenter3 != null) {
                presenter = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.MyBillsEntityDataFactory(p0, "Global Search", "", false, true);
            return;
        }
        ReadLinkPropertiesContract.Presenter presenter4 = this.readDeepLinkPropertiesPresenter;
        if (presenter4 != null) {
            presenter2 = presenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        String PlaceComponentResult = TextUtil.PlaceComponentResult(p0, "");
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        presenter2.MyBillsEntityDataFactory(PlaceComponentResult);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchBottomSheetContract.View
    public final void getAuthRequestContext(MerchantInfoModel p0) {
        String obj;
        Context context;
        Resources resources;
        Intrinsics.checkNotNullParameter(p0, "");
        boolean getAuthRequestContext = p0.getGetAuthRequestContext();
        String str = p0.getErrorConfigVersion;
        String str2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        if (getAuthRequestContext) {
            TextView textView = (TextView) MyBillsEntityDataFactory(R.id.executeDoubleFunction);
            if (textView != null) {
                textView.setText(getResources().getString(R.string.merchant_info_twenty_four_hour_value));
            }
        } else {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            if (str.length() == 0) {
                if (str2.length() == 0) {
                    TextView textView2 = (TextView) MyBillsEntityDataFactory(R.id.executeDoubleFunction);
                    if (textView2 != null) {
                        textView2.setText(getResources().getString(R.string.merchant_default_empty_value));
                    }
                }
            }
            TextView textView3 = (TextView) MyBillsEntityDataFactory(R.id.executeDoubleFunction);
            if (textView3 != null) {
                if (Intrinsics.areEqual(str, str2)) {
                    obj = getResources().getString(R.string.merchant_info_twenty_four_hour_value);
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" - ");
                    sb.append(str2);
                    obj = sb.toString();
                }
                textView3.setText(obj);
            }
        }
        TextView textView4 = (TextView) MyBillsEntityDataFactory(R.id.res_0x7f0a152f_splitconfigentitydata_getmerchanttopups_lambda_100_inlined_getconfigonceready_1);
        String str3 = null;
        if (textView4 != null) {
            Double d = p0.NetworkUserEntityData$$ExternalSyntheticLambda2;
            textView4.setText(d != null ? Integer.valueOf(MathKt.roundToInt(d.doubleValue())).toString() : null);
        }
        TextView textView5 = (TextView) MyBillsEntityDataFactory(R.id.res_0x7f0a1548_newwalletpresenter_getinvestmentcardassets_1);
        if (textView5 != null) {
            Double d2 = p0.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Integer valueOf = d2 != null ? Integer.valueOf((int) d2.doubleValue()) : null;
            if (valueOf != null && (context = getContext()) != null && (resources = context.getResources()) != null) {
                str3 = resources.getQuantityString(R.plurals.f46652131820549, valueOf.intValue());
            }
            if (str3 == null) {
                str3 = "";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(str3, Arrays.copyOf(new Object[]{valueOf}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView5.setText(format);
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        ((ConstraintLayout) MyBillsEntityDataFactory(R.id.checkMarmotConfig_res_0x7f0a0347)).setVisibility(8);
        ((ConstraintLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a0373_emergencynotifactivity_getemergencynotifmodule_1)).setVisibility(0);
    }

    public static /* synthetic */ void getAuthRequestContext(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(globalSearchBottomSheetDialog, "");
        globalSearchBottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog, double d, double d2) {
        Intrinsics.checkNotNullParameter(globalSearchBottomSheetDialog, "");
        Context context = globalSearchBottomSheetDialog.getContext();
        if (context != null) {
            ContextExtKt.BuiltInFictitiousFunctionClassFactory(context, d, d2);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog, PaySearchInfoModel paySearchInfoModel, View view) {
        Intrinsics.checkNotNullParameter(globalSearchBottomSheetDialog, "");
        Intrinsics.checkNotNullParameter(paySearchInfoModel, "");
        globalSearchBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(String.valueOf(paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7.get("DETAIL")));
        view.setEnabled(false);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(globalSearchBottomSheetDialog, "");
        globalSearchBottomSheetDialog.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void getAuthRequestContext(PaySearchInfoModel paySearchInfoModel, GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(paySearchInfoModel, "");
        Intrinsics.checkNotNullParameter(globalSearchBottomSheetDialog, "");
        Object obj = paySearchInfoModel.getErrorConfigVersion.get("qris");
        if (obj == null) {
            obj = paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7.get(HookConstants.HookAction.HOOK_ACTION_PAY);
        }
        String valueOf = String.valueOf(obj);
        if ((valueOf.length() == 0) || Intrinsics.areEqual(valueOf, "null")) {
            globalSearchBottomSheetDialog.getBaseActivity().startActivity(new Intent(globalSearchBottomSheetDialog.getBaseActivity(), ScannerActivity.class));
        } else {
            globalSearchBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(valueOf);
        }
        view.setEnabled(false);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        ((DanaLoadingDialog) this.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.BuiltInFictitiousFunctionClassFactory.getValue();
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }
}
