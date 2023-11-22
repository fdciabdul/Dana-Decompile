package id.dana.cashier.guide.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.cashier.data.CashierUrlUtil;
import id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment;
import id.dana.cashier.guide.contract.GuideContract;
import id.dana.cashier.guide.di.DaggerGuideComponent;
import id.dana.cashier.guide.di.GuideModule;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.promotion.Space;
import id.dana.extension.arguments.LazyProvider;
import id.dana.richview.WebProgressView;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.OSUtil;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\rJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\rR\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0010\u001a\u00020\u0016X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u0019X\u0087\"¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "Landroid/view/View;", "getBottomSheet", "()Landroid/view/View;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "onShow", "scheduleImpl", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment$Params;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Lid/dana/cashier/guide/contract/GuideContract$Presenter;", "presenter", "Lid/dana/cashier/guide/contract/GuideContract$Presenter;", "<init>", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierGuideDialogFragment extends BaseBottomSheetDialogFragment {
    @Inject
    public GuideContract.Presenter presenter;
    static final /* synthetic */ KProperty<Object>[] KClassImpl$Data$declaredNonStaticMembers$2 = {Reflection.property1(new PropertyReference1Impl(CashierGuideDialogFragment.class, "params", "getParams()Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment$Params;", 0))};

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> moveToNextValue = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = new LazyProvider<Fragment, Params>() { // from class: id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment$special$$inlined$argumentDelegate$1
        @Override // id.dana.extension.arguments.LazyProvider
        public final Lazy<CashierGuideDialogFragment.Params> KClassImpl$Data$declaredNonStaticMembers$2(final Fragment p0, final KProperty<?> p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            return LazyKt.lazy(new Function0<CashierGuideDialogFragment.Params>() { // from class: id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment$special$$inlined$argumentDelegate$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final CashierGuideDialogFragment.Params invoke() {
                    Bundle arguments = ((Fragment) p0).getArguments();
                    Object obj = arguments != null ? arguments.get(p1.getName()) : null;
                    if (obj != null) {
                        return (CashierGuideDialogFragment.Params) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment.Params");
                }
            });
        }
    }.KClassImpl$Data$declaredNonStaticMembers$2(this, KClassImpl$Data$declaredNonStaticMembers$2[0]);

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory = "";

    private View PlaceComponentResult(int i) {
        View findViewById;
        Map<Integer, View> map = this.moveToNextValue;
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
        return 0.48f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.fragment_how_to;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final View getPlaceComponentResult() {
        return (ConstraintLayout) PlaceComponentResult(R.id.createSecondaryAnimatorProvider_res_0x7f0a040c);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        DaggerGuideComponent.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DaggerGuideComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getBaseActivity().getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = (GuideModule) Preconditions.getAuthRequestContext(new GuideModule(new GuideContract.View() { // from class: id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment$getGuideModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.cashier.guide.contract.GuideContract.View
            public final void PlaceComponentResult(Space p0) {
                Unit unit;
                Intrinsics.checkNotNullParameter(p0, "");
                String KClassImpl$Data$declaredNonStaticMembers$23 = CashierGuideDialogFragmentKt.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                if (KClassImpl$Data$declaredNonStaticMembers$23 != null) {
                    CashierGuideDialogFragment cashierGuideDialogFragment = CashierGuideDialogFragment.this;
                    cashierGuideDialogFragment.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$23;
                    CashierGuideDialogFragment.MyBillsEntityDataFactory(cashierGuideDialogFragment);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    CashierGuideDialogFragment.getAuthRequestContext(CashierGuideDialogFragment.this);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierGuideDialogFragment.getAuthRequestContext(CashierGuideDialogFragment.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, GuideModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerGuideComponent.GuideComponentImpl(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory, (byte) 0).PlaceComponentResult(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        GuideContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
        AppCompatTextView appCompatTextView = (AppCompatTextView) PlaceComponentResult(R.id.getLogSourceName);
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(((Params) this.getAuthRequestContext.getValue()).scheduleImpl));
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) PlaceComponentResult(R.id.PrepareContext_res_0x7f0a011e);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierGuideDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierGuideDialogFragment.this);
                }
            });
        }
        WebProgressView webProgressView = (WebProgressView) PlaceComponentResult(R.id.res_0x7f0a1bdf_cashieruserrelatedpresenter_consultagreementtnccardpayment_1);
        if (webProgressView != null) {
            webProgressView.getWebView().getSettings().setCacheMode(1);
            webProgressView.setWebProgressViewListener(new WebProgressView.WebProgressViewListener() { // from class: id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment$initViews$2$2
                @Override // id.dana.richview.WebProgressView.WebProgressViewListener
                public final void PlaceComponentResult(WebView p0, String p1) {
                    String str;
                    if (p0 != null) {
                        CashierGuideDialogFragment cashierGuideDialogFragment = CashierGuideDialogFragment.this;
                        str = cashierGuideDialogFragment.MyBillsEntityDataFactory;
                        CashierGuideDialogFragment.getAuthRequestContext(cashierGuideDialogFragment, p0, str);
                    }
                }

                @Override // id.dana.richview.WebProgressView.WebProgressViewListener
                public final void PlaceComponentResult(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                    CashierGuideDialogFragment.getAuthRequestContext(CashierGuideDialogFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        setCancelable(false);
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        GuideContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        Params params = (Params) this.getAuthRequestContext.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(params.MyBillsEntityDataFactory);
        sb.append('_');
        sb.append(params.getAuthRequestContext);
        String obj = sb.toString();
        if (params.PlaceComponentResult) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append("_int");
            obj = sb2.toString();
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        presenter.MyBillsEntityDataFactory(lowerCase);
    }

    private static String getAuthRequestContext(String p0) {
        StringBuilder sb = new StringBuilder();
        sb.append("(function() {try{document.getElementById(\"guide-container\").innerHTML = '");
        sb.append(p0);
        sb.append("';}catch(e){}})()");
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment$Companion;", "", "Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment$Params;", "p0", "Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment;", "getAuthRequestContext", "(Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment$Params;)Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CashierGuideDialogFragment getAuthRequestContext(Params p0) {
            CashierGuideDialogFragment cashierGuideDialogFragment = new CashierGuideDialogFragment();
            cashierGuideDialogFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("params", p0)));
            return cashierGuideDialogFragment;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 #2\u00020\u0001:\u0001#BO\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0012\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0011\u0010\u0017\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/cashier/guide/bottomsheet/CashierGuideDialogFragment$Params;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "Z", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "scheduleImpl", "lookAheadTest", "I", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params implements Parcelable {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final boolean PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        final String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        final int scheduleImpl;
        final String moveToNextValue;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        final String getErrorConfigVersion;
        public static final Parcelable.Creator<Params> CREATOR = new Creator();

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeInt(this.scheduleImpl);
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.moveToNextValue);
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            p0.writeString(this.getErrorConfigVersion);
            p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        }

        public Params(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            this.MyBillsEntityDataFactory = str;
            this.scheduleImpl = i;
            this.getAuthRequestContext = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.moveToNextValue = str4;
            this.BuiltInFictitiousFunctionClassFactory = str5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str6;
            this.getErrorConfigVersion = str7;
            this.PlaceComponentResult = z;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<Params> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Params createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new Params(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Params[] newArray(int i) {
                return new Params[i];
            }
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierGuideDialogFragment cashierGuideDialogFragment) {
        Intrinsics.checkNotNullParameter(cashierGuideDialogFragment, "");
        cashierGuideDialogFragment.dismissAllowingStateLoss();
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierGuideDialogFragment cashierGuideDialogFragment) {
        if (cashierGuideDialogFragment.isAdded()) {
            FragmentActivity activity = cashierGuideDialogFragment.getActivity();
            if (activity == null) {
                return;
            }
            FragmentActivity fragmentActivity = activity;
            Context context = cashierGuideDialogFragment.getContext();
            String string = context != null ? context.getString(R.string.how_to_error) : null;
            if (string == null) {
                string = "";
            }
            CustomToastUtil.PlaceComponentResult(fragmentActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_failed, string, 48, 60, false, null, 384);
        }
        cashierGuideDialogFragment.dismissAllowingStateLoss();
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierGuideDialogFragment cashierGuideDialogFragment, WebView webView, String str) {
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trimIndent(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "\n", "", false, 4, (Object) null), "'", "&#39;", false, 4, (Object) null), "'", "&#39;", false, 4, (Object) null)), "{{intsId}}", ((Params) cashierGuideDialogFragment.getAuthRequestContext.getValue()).getAuthRequestContext, false, 4, (Object) null), "{{instName}}", ((Params) cashierGuideDialogFragment.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2, false, 4, (Object) null), "{{serviceInstId}}", ((Params) cashierGuideDialogFragment.getAuthRequestContext.getValue()).moveToNextValue, false, 4, (Object) null), "{{payAccountNo}}", ((Params) cashierGuideDialogFragment.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory, false, 4, (Object) null), "{{serviceBankCode}}", ((Params) cashierGuideDialogFragment.getAuthRequestContext.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0, false, 4, (Object) null), "{{serviceInstName}}", ((Params) cashierGuideDialogFragment.getAuthRequestContext.getValue()).getErrorConfigVersion, false, 4, (Object) null);
        if (OSUtil.getErrorConfigVersion()) {
            webView.evaluateJavascript(getAuthRequestContext(replace$default), null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(RDConstant.JAVASCRIPT_SCHEME);
        sb.append(getAuthRequestContext(replace$default));
        String obj = sb.toString();
        InstrumentInjector.trackWebView(webView);
        webView.loadUrl(obj);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierGuideDialogFragment cashierGuideDialogFragment) {
        WebProgressView webProgressView = (WebProgressView) cashierGuideDialogFragment.PlaceComponentResult(R.id.res_0x7f0a1bdf_cashieruserrelatedpresenter_consultagreementtnccardpayment_1);
        if (webProgressView != null) {
            webProgressView.loadUrl(CashierUrlUtil.INSTANCE.getGuideCdnUrl());
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.moveToNextValue.clear();
    }
}
