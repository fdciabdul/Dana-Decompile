package id.dana.contract.globalsearch;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.viewbinding.ViewBinding;
import dagger.internal.Preconditions;
import id.dana.base.AbstractContractKt;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGlobalSearchComponent;
import id.dana.di.component.GlobalSearchComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.eventbus.base.BaseFragmentWithPageLoadTracker;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.lib.gcontainer.GContainer;
import id.dana.mapper.ThirdPartyServicesUrlMapper;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00178\u0005X\u0085&¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0005X\u0085&¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020!8\u0005X\u0085&¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020&8\u0005X\u0085&¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020+8\u0005X\u0085&¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00101\u001a\u0002008\u0005X\u0085&¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u00106\u001a\u0002058\u0005X\u0085&¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b\u0014\u00108"}, d2 = {"Lid/dana/contract/globalsearch/AbstractGlobalSearchView;", "Landroidx/viewbinding/ViewBinding;", "V", "Lid/dana/eventbus/base/BaseFragmentWithPageLoadTracker;", "Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "PlaceComponentResult", "()Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "Lid/dana/di/component/GlobalSearchComponent;", "l_", "()Lid/dana/di/component/GlobalSearchComponent;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "p0", "", "p1", "p2", "p3", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "getErrorConfigVersion", "Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "g_", "()Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "h5EventPresenter", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "h_", "()Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingServicePresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "i_", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "playStoreReviewPresenter", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "j_", "()Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "presenter", "Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "k_", "()Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "qrPresenter", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbstractGlobalSearchView<V extends ViewBinding> extends BaseFragmentWithPageLoadTracker<V> {
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    @Inject
    protected DeviceInformationProvider deviceInformationProvider;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    protected CheckoutH5EventContract.Presenter h5EventPresenter;
    @Inject
    protected BottomSheetOnBoardingContract.Presenter onBoardingServicePresenter;
    @Inject
    protected PlayStoreReviewContract.Presenter playStoreReviewPresenter;
    @Inject
    protected GlobalSearchContract.Presenter presenter;
    @Inject
    protected ScanQrContract.Presenter qrPresenter;
    @Inject
    protected ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;

    public abstract GlobalSearchContract.View PlaceComponentResult();

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public View _$_findCachedViewById(int i) {
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

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @JvmName(name = "k_")
    public final GlobalSearchContract.Presenter k_() {
        GlobalSearchContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    public final ScanQrContract.Presenter NetworkUserEntityData$$ExternalSyntheticLambda0() {
        ScanQrContract.Presenter presenter = this.qrPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "h_")
    public final CheckoutH5EventContract.Presenter h_() {
        CheckoutH5EventContract.Presenter presenter = this.h5EventPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "j_")
    public final PlayStoreReviewContract.Presenter j_() {
        PlayStoreReviewContract.Presenter presenter = this.playStoreReviewPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "getErrorConfigVersion")
    public final ReadLinkPropertiesContract.Presenter getErrorConfigVersion() {
        ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "i_")
    public final BottomSheetOnBoardingContract.Presenter i_() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingServicePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "g_")
    public final DeviceInformationProvider g_() {
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        if (deviceInformationProvider != null) {
            return deviceInformationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    public final GlobalSearchComponent l_() {
        DaggerGlobalSearchComponent.Builder PlaceComponentResult = DaggerGlobalSearchComponent.PlaceComponentResult();
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        byte b = 0;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2(), b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        PlaceComponentResult.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = getActivity();
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        PlaceComponentResult.moveToNextValue = (GlobalSearchModule) Preconditions.getAuthRequestContext(new GlobalSearchModule(PlaceComponentResult()));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getActivity();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext2 = ScanQrModule.getAuthRequestContext();
        authRequestContext2.MyBillsEntityDataFactory = getActivity();
        PlaceComponentResult.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext2, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getActivity();
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
        PlaceComponentResult.PlaceComponentResult = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.contract.globalsearch.AbstractGlobalSearchView$$ExternalSyntheticLambda0
            @Override // id.dana.h5event.CheckoutH5EventContract.View
            public final void getAuthRequestContext(boolean z) {
                AbstractGlobalSearchView.MyBillsEntityDataFactory(AbstractGlobalSearchView.this, z);
            }
        }));
        PlaceComponentResult.lookAheadTest = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(getActivity())));
        PlaceComponentResult.MyBillsEntityDataFactory = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View(this) { // from class: id.dana.contract.globalsearch.AbstractGlobalSearchView$initInject$2
            final /* synthetic */ AbstractGlobalSearchView<V> PlaceComponentResult;

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                BottomSheetOnBoardingContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.PlaceComponentResult = this;
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1, String p2) {
                Uri.Builder buildUpon = Uri.parse(p1).buildUpon();
                if (p0) {
                    buildUpon.appendQueryParameter(SummaryActivity.FIRST_STATE_SHARE_FEED, SummaryActivity.CHECKED);
                    AbstractGlobalSearchView.PlaceComponentResult(this.PlaceComponentResult, p2);
                }
                DanaH5.startContainerFullUrlWithSendCredentials$default(buildUpon.build().toString(), AbstractGlobalSearchView.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult), null, null, 12, null);
                AbstractGlobalSearchView.getAuthRequestContext((AbstractGlobalSearchView) this.PlaceComponentResult);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append("on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.moveToNextValue, GlobalSearchModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.lookAheadTest, PlayStoreReviewModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, CheckoutH5EventModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.scheduleImpl, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getErrorConfigVersion, OauthModule.class);
        if (PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        DaggerGlobalSearchComponent.GlobalSearchComponentImpl globalSearchComponentImpl = new DaggerGlobalSearchComponent.GlobalSearchComponentImpl(PlaceComponentResult.moveToNextValue, PlaceComponentResult.lookAheadTest, PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.scheduleImpl, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.getErrorConfigVersion, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        Intrinsics.checkNotNullExpressionValue(globalSearchComponentImpl, "");
        return globalSearchComponentImpl;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyServiceResponse p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (GContainer.isOpeningH5()) {
            return;
        }
        String KClassImpl$Data$declaredNonStaticMembers$2 = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(p1, p2, p3, p0);
        Bundle bundle = new Bundle();
        bundle.putString(DanaH5.SERVICE_KEY, p0.getKey());
        CheckoutH5EventContract.Presenter presenter = null;
        CheckoutH5EventContract.Presenter presenter2 = null;
        BottomSheetOnBoardingContract.Presenter presenter3 = null;
        BottomSheetOnBoardingContract.Presenter presenter4 = null;
        BottomSheetOnBoardingContract.Presenter presenter5 = null;
        BottomSheetOnBoardingContract.Presenter presenter6 = null;
        if (Intrinsics.areEqual(p0.getKey(), "service_akulaku")) {
            String authRequestContext = UrlUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "Global Search");
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            bundle.putString("url", DanaH5.correctedUrl(authRequestContext));
            bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
            DanaH5.startContainerFullUrlWithSendCredentials$default(null, new AbstractGlobalSearchView$createH5AppListener$1(this), bundle, null, 9, null);
            this.BuiltInFictitiousFunctionClassFactory = false;
            CheckoutH5EventContract.Presenter presenter7 = this.h5EventPresenter;
            if (presenter7 != null) {
                presenter2 = presenter7;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter2.MyBillsEntityDataFactory();
            return;
        }
        String key = p0.getKey();
        switch (key.hashCode()) {
            case -799331944:
                if (key.equals("service_danafood")) {
                    BottomSheetOnBoardingContract.Presenter presenter8 = this.onBoardingServicePresenter;
                    if (presenter8 != null) {
                        presenter6 = presenter8;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter6.PlaceComponentResult("dana_food", KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                break;
            case 994706502:
                if (key.equals("service_danakaget")) {
                    BottomSheetOnBoardingContract.Presenter presenter9 = this.onBoardingServicePresenter;
                    if (presenter9 != null) {
                        presenter5 = presenter9;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter5.PlaceComponentResult("dana_kaget", KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                break;
            case 1264036702:
                if (key.equals("service_paylater_loan_personal")) {
                    BottomSheetOnBoardingContract.Presenter presenter10 = this.onBoardingServicePresenter;
                    if (presenter10 != null) {
                        presenter4 = presenter10;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter4.PlaceComponentResult("loan_personal", KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                break;
            case 1397883715:
                if (key.equals("service_my_bills")) {
                    BottomSheetOnBoardingContract.Presenter presenter11 = this.onBoardingServicePresenter;
                    if (presenter11 != null) {
                        presenter3 = presenter11;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter3.PlaceComponentResult("my_bills", KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                break;
        }
        DanaH5.startContainerFullUrlWithSendCredentials$default(KClassImpl$Data$declaredNonStaticMembers$2, new AbstractGlobalSearchView$createH5AppListener$1(this), bundle, null, 8, null);
        this.BuiltInFictitiousFunctionClassFactory = false;
        CheckoutH5EventContract.Presenter presenter12 = this.h5EventPresenter;
        if (presenter12 != null) {
            presenter = presenter12;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(AbstractGlobalSearchView abstractGlobalSearchView, boolean z) {
        Intrinsics.checkNotNullParameter(abstractGlobalSearchView, "");
        abstractGlobalSearchView.BuiltInFictitiousFunctionClassFactory = z;
    }

    public static final /* synthetic */ DanaH5Listener BuiltInFictitiousFunctionClassFactory(AbstractGlobalSearchView abstractGlobalSearchView) {
        return new AbstractGlobalSearchView$createH5AppListener$1(abstractGlobalSearchView);
    }

    public static final /* synthetic */ void getAuthRequestContext(AbstractGlobalSearchView abstractGlobalSearchView) {
        abstractGlobalSearchView.BuiltInFictitiousFunctionClassFactory = false;
        CheckoutH5EventContract.Presenter presenter = abstractGlobalSearchView.h5EventPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void PlaceComponentResult(AbstractGlobalSearchView abstractGlobalSearchView, String str) {
        if (Intrinsics.areEqual(str, "loan_personal")) {
            BottomSheetOnBoardingContract.Presenter presenter = abstractGlobalSearchView.onBoardingServicePresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.MyBillsEntityDataFactory("loan_personal");
        }
    }
}
