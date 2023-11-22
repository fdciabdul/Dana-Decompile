package id.dana.requestmoney.balance;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.databinding.CardQrRequestMoneyBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerRequestMoneyQrComponent;
import id.dana.di.modules.RequestMoneyQrModule;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.HomeInfo;
import id.dana.myprofile.model.QrisTciCoConfigModel;
import id.dana.requestmoney.BaseRequestMoneyQrCardFragment;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.requestmoney.RequestMoneyTrackingHelperKt;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import id.dana.richview.QRView;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.MaskedTextUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0013\u0010\u000b\u001a\u00020\u001fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0012\u0010\"\u001a\u00020!X\u0087\"¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0017"}, d2 = {"Lid/dana/requestmoney/balance/RequestMoneyBalanceQrCardFragment;", "Lid/dana/requestmoney/BaseRequestMoneyQrCardFragment;", "", "PrepareContext", "()V", "FragmentBottomSheetPaymentSettingBinding", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "p0", "", "lookAheadTest", "(Ljava/lang/String;)Z", "onDestroy", "NetworkUserEntityData$$ExternalSyntheticLambda2", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZJ)V", "p2", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "scheduleImpl", "PlaceComponentResult", "moveToNextValue", "Z", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "Lkotlin/Lazy;", "Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "staticQrPresenter", "Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "DatabaseTableConfigUtil", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyBalanceQrCardFragment extends BaseRequestMoneyQrCardFragment {

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public GetStaticQrContract.Presenter staticQrPresenter;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String scheduleImpl = "";
    private String MyBillsEntityDataFactory = "";

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        super.FragmentBottomSheetPaymentSettingBinding();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("source") : null;
        if (string == null) {
            string = "";
        }
        this.MyBillsEntityDataFactory = string;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            FloatingActionButton floatingActionButton = ((CardQrRequestMoneyBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(floatingActionButton, "");
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(floatingActionButton, false);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment
    public final void initRecordTimeStamp() {
        DaggerRequestMoneyQrComponent.Builder authRequestContext = DaggerRequestMoneyQrComponent.getAuthRequestContext();
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (RequestMoneyQrModule) Preconditions.getAuthRequestContext(new RequestMoneyQrModule(new RequestMoneyQrContract.View() { // from class: id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment$getRequestMoneyModule$1
            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Long l) {
                RequestMoneyBalanceQrCardFragment.this.getAuthRequestContext(l.longValue());
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(Long l) {
                RequestMoneyBalanceQrCardFragment.this.BuiltInFictitiousFunctionClassFactory(l.longValue());
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment.this.scheduleImpl = p0;
                RequestMoneyBalanceQrCardFragment.this.MyBillsEntityDataFactory(p0);
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                long myBillsEntityDataFactory;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment = RequestMoneyBalanceQrCardFragment.this;
                myBillsEntityDataFactory = requestMoneyBalanceQrCardFragment.getMyBillsEntityDataFactory();
                requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(false, myBillsEntityDataFactory);
                RequestMoneyBalanceQrCardFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void PlaceComponentResult(HomeInfo p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                RequestMoneyBalanceQrCardFragment.MyBillsEntityDataFactory(RequestMoneyBalanceQrCardFragment.this, p0, p1);
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(RequestMoneyInfoModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void getAuthRequestContext(boolean p0) {
                RequestMoneyBalanceQrCardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(QrisTciCoConfigModel p0) {
                boolean z;
                boolean z2;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getBuiltInFictitiousFunctionClassFactory();
                VB vb = RequestMoneyBalanceQrCardFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    AppCompatImageView appCompatImageView = ((CardQrRequestMoneyBinding) vb).moveToNextValue;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    z = RequestMoneyBalanceQrCardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    appCompatImageView2.setVisibility(z ? 0 : 8);
                    RequestMoneyBalanceQrCardFragment.moveToNextValue(RequestMoneyBalanceQrCardFragment.this).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    z2 = RequestMoneyBalanceQrCardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    GetStaticQrContract.Presenter presenter = null;
                    if (z2) {
                        GetStaticQrContract.Presenter presenter2 = RequestMoneyBalanceQrCardFragment.this.staticQrPresenter;
                        if (presenter2 != null) {
                            presenter = presenter2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        presenter.getAuthRequestContext();
                        return;
                    }
                    GetStaticQrContract.Presenter presenter3 = RequestMoneyBalanceQrCardFragment.this.staticQrPresenter;
                    if (presenter3 != null) {
                        presenter = presenter3;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void getAuthRequestContext(String p0, String p1, String p2, String p3, String p4) {
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyBalanceQrCardFragment.this.getContext(), p3, p0, p2, p1, TrackerDataKey.Source.REQUEST_MONEY, p4);
            }
        }));
        authRequestContext.getAuthRequestContext = (GetStaticQrModule) Preconditions.getAuthRequestContext(new GetStaticQrModule(new GetStaticQrContract.View() { // from class: id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment$getGetStaticQrModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final void getAuthRequestContext(QrisTciCoConfigModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final /* synthetic */ void getAuthRequestContext(Long l) {
                RequestMoneyBalanceQrCardFragment.this.getAuthRequestContext(l.longValue());
            }

            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                boolean z;
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment.newProxyInstance(RequestMoneyBalanceQrCardFragment.this);
                RequestMoneyBalanceQrCardFragment.this.getAuthRequestContext = p0;
                RequestMoneyBalanceQrCardFragment.this.getAuthRequestContext(TrackerKey.RequestMoneyProperties.QR_USER);
                z = RequestMoneyBalanceQrCardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (z) {
                    RequestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(RequestMoneyBalanceQrCardFragment.this);
                }
                RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment = RequestMoneyBalanceQrCardFragment.this;
                str = requestMoneyBalanceQrCardFragment.getAuthRequestContext;
                requestMoneyBalanceQrCardFragment.BuiltInFictitiousFunctionClassFactory(str);
            }

            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final void PlaceComponentResult(String p0, String p1, String p2, String p3, String p4) {
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyBalanceQrCardFragment.this.getContext(), p3, p0, p2, p1, TrackerDataKey.Source.REQUEST_MONEY, p4);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                long GetContactSyncConfig;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment = RequestMoneyBalanceQrCardFragment.this;
                GetContactSyncConfig = requestMoneyBalanceQrCardFragment.GetContactSyncConfig();
                requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(false, GetContactSyncConfig);
                RequestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(RequestMoneyBalanceQrCardFragment.this);
                ((SendMoneyFeatureTime) RequestMoneyBalanceQrCardFragment.this.lookAheadTest.getValue()).moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                RequestMoneyBalanceQrCardFragment.isLayoutRequested(RequestMoneyBalanceQrCardFragment.this);
                RequestMoneyBalanceQrCardFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
            }
        }));
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (GenerateDeepLinkModule) Preconditions.getAuthRequestContext(new GenerateDeepLinkModule(new GenerateDeepLinkContract.ProfileView() { // from class: id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment$getGenerateDeepLinkModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final /* synthetic */ void MyBillsEntityDataFactory(Long l) {
                RequestMoneyBalanceQrCardFragment.this.MyBillsEntityDataFactory(l.longValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    boolean r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.GetContactSyncConfig(r0)
                    r1 = 1
                    if (r0 == 0) goto L1c
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.scheduleImpl(r0)
                    boolean r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getErrorConfigVersion(r0)
                    if (r0 != 0) goto L1c
                    r0 = 0
                    goto L1d
                L1c:
                    r0 = 1
                L1d:
                    if (r0 == 0) goto L5a
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.MyBillsEntityDataFactory(r0, r6)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r2 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.scheduleImpl(r0)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r3 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r3 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getAuthRequestContext(r3)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r4 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r4 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(r4)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.MyBillsEntityDataFactory(r0, r2, r3, r4)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    boolean r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.PlaceComponentResult(r0)
                    if (r0 == 0) goto L4b
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    long r2 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(r0)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getAuthRequestContext(r0, r1, r2)
                    goto L50
                L4b:
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(r0)
                L50:
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.BuiltInFictitiousFunctionClassFactory(r0)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.isLayoutRequested(r0)
                L5a:
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getAuthRequestContext(r0, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment$getGenerateDeepLinkModule$1.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):void");
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void PlaceComponentResult() {
                GetStaticQrContract.Presenter presenter = RequestMoneyBalanceQrCardFragment.this.staticQrPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                long scheduleImpl;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment = RequestMoneyBalanceQrCardFragment.this;
                scheduleImpl = requestMoneyBalanceQrCardFragment.scheduleImpl();
                requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(false, scheduleImpl);
                ((SendMoneyFeatureTime) RequestMoneyBalanceQrCardFragment.this.lookAheadTest.getValue()).moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                RequestMoneyBalanceQrCardFragment.isLayoutRequested(RequestMoneyBalanceQrCardFragment.this);
                RequestMoneyBalanceQrCardFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
            }
        }, new GenerateDeepLinkContract.TransferView() { // from class: id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment$getGenerateDeepLinkModule$2
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.TransferView
            public final /* synthetic */ void getAuthRequestContext(Long l) {
                RequestMoneyBalanceQrCardFragment.this.MyBillsEntityDataFactory(l.longValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
            /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.TransferView
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void BuiltInFictitiousFunctionClassFactory(java.lang.String r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    boolean r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.GetContactSyncConfig(r0)
                    r1 = 1
                    if (r0 == 0) goto L1c
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.scheduleImpl(r0)
                    boolean r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getErrorConfigVersion(r0)
                    if (r0 != 0) goto L1c
                    r0 = 0
                    goto L1d
                L1c:
                    r0 = 1
                L1d:
                    if (r0 == 0) goto L21
                    r0 = r6
                    goto L27
                L21:
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.initRecordTimeStamp(r0)
                L27:
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r2 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r3 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getAuthRequestContext(r2)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r4 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    java.lang.String r4 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(r4)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.MyBillsEntityDataFactory(r2, r0, r3, r4)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    boolean r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.PlaceComponentResult(r0)
                    if (r0 == 0) goto L48
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    long r2 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.lookAheadTest(r0)
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getAuthRequestContext(r0, r1, r2)
                    goto L4d
                L48:
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(r0)
                L4d:
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.this
                    id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment.getAuthRequestContext(r0, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment$getGenerateDeepLinkModule$2.BuiltInFictitiousFunctionClassFactory(java.lang.String):void");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                long DatabaseTableConfigUtil;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment = RequestMoneyBalanceQrCardFragment.this;
                DatabaseTableConfigUtil = requestMoneyBalanceQrCardFragment.DatabaseTableConfigUtil();
                requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(false, DatabaseTableConfigUtil);
                RequestMoneyBalanceQrCardFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, RequestMoneyQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, GetStaticQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, GenerateDeepLinkModule.class);
        if (authRequestContext.PlaceComponentResult == null) {
            authRequestContext.PlaceComponentResult = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerRequestMoneyQrComponent.RequestMoneyQrComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.getAuthRequestContext, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult, authRequestContext.MyBillsEntityDataFactory, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        PrepareContext();
    }

    private final void PrepareContext() {
        isLayoutRequested();
        RequestMoneyQrContract.Presenter presenter = this.requestMoneyQrPresenter;
        RequestMoneyQrContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.BuiltInFictitiousFunctionClassFactory();
        RequestMoneyQrContract.Presenter presenter3 = this.requestMoneyQrPresenter;
        if (presenter3 != null) {
            presenter2 = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(String p0, String p1, String p2) {
        if (StringsKt.isBlank(p0)) {
            p0 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
        if (StringsKt.isBlank(p1)) {
            p1 = this.PlaceComponentResult;
        }
        this.PlaceComponentResult = p1;
        if (StringsKt.isBlank(p2)) {
            p2 = this.BuiltInFictitiousFunctionClassFactory;
        }
        this.BuiltInFictitiousFunctionClassFactory = p2;
        if ((!StringsKt.isBlank(r0)) == true) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                QRView qRView = ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp;
                Intrinsics.checkNotNullExpressionValue(qRView, "");
                String str = this.PlaceComponentResult;
                qRView.setKycView(this.BuiltInFictitiousFunctionClassFactory);
                qRView.displayUserAvatar(str);
                String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    str2 = RequestMoneyTrackingHelperKt.MyBillsEntityDataFactory(str2, "request_money");
                }
                PlaceComponentResult(str2);
                VB vb2 = this.PlaceComponentResult;
                if (vb2 != 0) {
                    ((CardQrRequestMoneyBinding) vb2).GetContactSyncConfig.setSharingMessage(getString(R.string.share_request_money_link), this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean lookAheadTest(String p0) {
        return StringsKt.startsWith$default(p0, SemanticAttributes.FaasTriggerValues.HTTP, false, 2, (Object) null);
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        RequestMoneyQrContract.Presenter presenter = this.requestMoneyQrPresenter;
        GenerateDeepLinkContract.ProfilePresenter profilePresenter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.onDestroy();
        GenerateDeepLinkContract.TransferPresenter transferPresenter = this.transferDeepLinkPresenter;
        if (transferPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transferPresenter = null;
        }
        transferPresenter.onDestroy();
        GetStaticQrContract.Presenter presenter2 = this.staticQrPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        presenter2.onDestroy();
        GenerateDeepLinkContract.ProfilePresenter profilePresenter2 = this.profileDeeplinkPresenter;
        if (profilePresenter2 != null) {
            profilePresenter = profilePresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        profilePresenter.onDestroy();
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, long p1) {
        MyBillsEntityDataFactory(p0, p1, this.KClassImpl$Data$declaredNonStaticMembers$2 ? false : getBuiltInFictitiousFunctionClassFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static final /* synthetic */ SendMoneyFeatureTime moveToNextValue(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment) {
        return (SendMoneyFeatureTime) requestMoneyBalanceQrCardFragment.lookAheadTest.getValue();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment, HomeInfo homeInfo, String str) {
        if (StringsKt.isBlank(str)) {
            str = homeInfo.BuiltInFictitiousFunctionClassFactory;
        }
        String str2 = requestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str3 = homeInfo.getAuthRequestContext.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(str3, "");
        requestMoneyBalanceQrCardFragment.getAuthRequestContext(str2, str, str3);
        VB vb = requestMoneyBalanceQrCardFragment.PlaceComponentResult;
        if (vb != 0) {
            CardQrRequestMoneyBinding cardQrRequestMoneyBinding = (CardQrRequestMoneyBinding) vb;
            cardQrRequestMoneyBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setText(homeInfo.PlaceComponentResult);
            cardQrRequestMoneyBinding.newProxyInstance.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(homeInfo.MyBillsEntityDataFactory, false));
            TextView textView = cardQrRequestMoneyBinding.newProxyInstance;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            if ((!StringsKt.isBlank(requestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0)) == true) {
                requestMoneyBalanceQrCardFragment.PlaceComponentResult(requestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getAuthRequestContext(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment, String str) {
        VB vb = requestMoneyBalanceQrCardFragment.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).GetContactSyncConfig.setSharingMessage(requestMoneyBalanceQrCardFragment.getString(R.string.share_request_money_link), str);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment) {
        if (requestMoneyBalanceQrCardFragment.getAuthRequestContext.length() > 0) {
            requestMoneyBalanceQrCardFragment.getAuthRequestContext(requestMoneyBalanceQrCardFragment.getAuthRequestContext, requestMoneyBalanceQrCardFragment.PlaceComponentResult, requestMoneyBalanceQrCardFragment.BuiltInFictitiousFunctionClassFactory);
        } else {
            requestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda7();
        }
        requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(requestMoneyBalanceQrCardFragment.getAuthRequestContext.length() > 0, requestMoneyBalanceQrCardFragment.GetContactSyncConfig());
        ((SendMoneyFeatureTime) requestMoneyBalanceQrCardFragment.lookAheadTest.getValue()).moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = requestMoneyBalanceQrCardFragment.sendMoneyAnalyticalTracker;
        if (sendMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneyAnalyticTracker = null;
        }
        sendMoneyAnalyticTracker.MyBillsEntityDataFactory(requestMoneyBalanceQrCardFragment.MyBillsEntityDataFactory, requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda8(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment) {
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) requestMoneyBalanceQrCardFragment.lookAheadTest.getValue();
        sendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        sendMoneyFeatureTime.MyBillsEntityDataFactory = false;
    }

    public static final /* synthetic */ void newProxyInstance(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment) {
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) requestMoneyBalanceQrCardFragment.lookAheadTest.getValue();
        sendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        sendMoneyFeatureTime.MyBillsEntityDataFactory = true;
    }

    public static final /* synthetic */ void isLayoutRequested(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment) {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = requestMoneyBalanceQrCardFragment.sendMoneyAnalyticalTracker;
        if (sendMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneyAnalyticTracker = null;
        }
        sendMoneyAnalyticTracker.MyBillsEntityDataFactory(requestMoneyBalanceQrCardFragment.MyBillsEntityDataFactory, requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        RequestMoneyQrContract.Presenter presenter = this.requestMoneyQrPresenter;
        RequestMoneyQrContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        GetStaticQrContract.Presenter presenter3 = this.staticQrPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.PlaceComponentResult();
        if (getKClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext > 0) {
            String obj = getKClassImpl$Data$declaredNonStaticMembers$2().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            String scheduleImpl = getScheduleImpl();
            isLayoutRequested();
            getAuthRequestContext(TrackerKey.RequestMoneyProperties.QR_TRANSFER);
            RequestMoneyQrContract.Presenter presenter4 = this.requestMoneyQrPresenter;
            if (presenter4 != null) {
                presenter2 = presenter4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter2.MyBillsEntityDataFactory(obj, scheduleImpl);
            PlaceComponentResult(false);
            MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        } else if ((!StringsKt.isBlank(this.getAuthRequestContext)) != false) {
            getAuthRequestContext(TrackerKey.RequestMoneyProperties.QR_USER);
            getAuthRequestContext(this.getAuthRequestContext, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
            PlaceComponentResult(false);
            BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        } else {
            PrepareContext();
        }
        getErrorConfigVersion();
    }
}
