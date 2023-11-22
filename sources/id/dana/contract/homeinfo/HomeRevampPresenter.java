package id.dana.contract.homeinfo;

import dagger.Lazy;
import id.dana.contract.homeinfo.HomeRevampContract;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature;
import id.dana.domain.permissionprompt.interactor.SaveNumberOfLocationPermissionShownData;
import id.dana.domain.preventscreenshot.interactor.GetPreventScreenshotConfig;
import id.dana.domain.profilemenu.interactor.GetProfileRevampConfig;
import id.dana.domain.transactionhistory.interactor.GetTransactionHistoryConfig;
import id.dana.domain.transactionhistory.model.TransactionHistoryConfig;
import id.dana.domain.wallet_v3.interactor.GetWalletConfig;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.kyb.domain.interactor.IsKybNativeEnabled;
import id.dana.kyb.domain.interactor.IsQrisPaymentEnabled;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0095\u0001\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020 0\u0012\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\t\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00150\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00160\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020 0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014"}, d2 = {"Lid/dana/contract/homeinfo/HomeRevampPresenter;", "Lid/dana/contract/homeinfo/HomeRevampContract$Presenter;", "", "p0", "", "PlaceComponentResult", "(J)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "onDestroy", "", "p1", "(JZ)V", "Ldagger/Lazy;", "Lid/dana/domain/permissionprompt/interactor/CheckLocationPermissionPromptFeature;", "Ldagger/Lazy;", "Lid/dana/explore/domain/globalsearch/interactor/GetGlobalSearchConfig;", "Lid/dana/domain/preventscreenshot/interactor/GetPreventScreenshotConfig;", "Lid/dana/domain/profilemenu/interactor/GetProfileRevampConfig;", "Lid/dana/domain/transactionhistory/interactor/GetTransactionHistoryConfig;", "Lid/dana/domain/wallet_v3/interactor/GetWalletConfig;", "lookAheadTest", "Lid/dana/kyb/domain/interactor/IsKybNativeEnabled;", "moveToNextValue", "Lid/dana/kyb/domain/interactor/IsQrisPaymentEnabled;", "Lid/dana/domain/permissionprompt/interactor/SaveNumberOfLocationPermissionShownData;", "getErrorConfigVersion", "Lid/dana/contract/homeinfo/HomeRevampContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeRevampPresenter implements HomeRevampContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<CheckLocationPermissionPromptFeature> PlaceComponentResult;
    private final Lazy<GetGlobalSearchConfig> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<GetTransactionHistoryConfig> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<GetWalletConfig> lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<GetPreventScreenshotConfig> MyBillsEntityDataFactory;
    private final Lazy<GetProfileRevampConfig> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<HomeRevampContract.View> scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<SaveNumberOfLocationPermissionShownData> getErrorConfigVersion;
    private final Lazy<IsKybNativeEnabled> moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<IsQrisPaymentEnabled> NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public HomeRevampPresenter(Lazy<HomeRevampContract.View> lazy, Lazy<GetGlobalSearchConfig> lazy2, Lazy<GetProfileRevampConfig> lazy3, Lazy<IsKybNativeEnabled> lazy4, Lazy<GetWalletConfig> lazy5, Lazy<IsQrisPaymentEnabled> lazy6, Lazy<CheckLocationPermissionPromptFeature> lazy7, Lazy<SaveNumberOfLocationPermissionShownData> lazy8, Lazy<GetTransactionHistoryConfig> lazy9, Lazy<GetPreventScreenshotConfig> lazy10) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        this.scheduleImpl = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.getAuthRequestContext = lazy3;
        this.moveToNextValue = lazy4;
        this.lookAheadTest = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy6;
        this.PlaceComponentResult = lazy7;
        this.getErrorConfigVersion = lazy8;
        this.BuiltInFictitiousFunctionClassFactory = lazy9;
        this.MyBillsEntityDataFactory = lazy10;
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<GlobalSearchConfig, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getGlobalSearchConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GlobalSearchConfig globalSearchConfig) {
                invoke2(globalSearchConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GlobalSearchConfig globalSearchConfig) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(globalSearchConfig, "");
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(globalSearchConfig.getExploreDanaBottomNav());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getGlobalSearchConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_CATEGORY_EXPLORE_DANA_CONFIG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1<WalletConfig, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getWalletFeatureNewConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(WalletConfig walletConfig) {
                invoke2(walletConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(WalletConfig walletConfig) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(walletConfig, "");
                lazy = HomeRevampPresenter.this.scheduleImpl;
                HomeRevampContract.View view = (HomeRevampContract.View) lazy.get();
                boolean featureWalletNew = walletConfig.getFeatureWalletNew();
                Integer danaDealsVersion = walletConfig.getWalletV3().getDanaDealsVersion();
                view.PlaceComponentResult(featureWalletNew, danaDealsVersion != null ? danaDealsVersion.intValue() : 1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getWalletFeatureNewConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_CATEGORY_EXPLORE_DANA_CONFIG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getGetMePageRevampConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getGetMePageRevampConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_ME_PAGE_CONFIG, th.getMessage(), th);
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(true);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getKybRevampConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).PlaceComponentResult(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getKybRevampConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_KYB_NATIVE_CONFIG, th.getMessage(), th);
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).PlaceComponentResult(true);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getQrisPaymentConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).getAuthRequestContext(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getQrisPaymentConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_QRIS_PAYMENT_CONFIG, th.getMessage(), th);
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).getAuthRequestContext(false);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void scheduleImpl() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<TransactionHistoryConfig, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getTransactionHistoryConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TransactionHistoryConfig transactionHistoryConfig) {
                invoke2(transactionHistoryConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionHistoryConfig transactionHistoryConfig) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(transactionHistoryConfig, "");
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(transactionHistoryConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getTransactionHistoryConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_TRANSACTION_HISTORY_CONFIG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getPreventScreenshotConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(list, "");
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$getPreventScreenshotConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_PREVENT_SCREENSHOT_CONFIG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void PlaceComponentResult(long p0) {
        this.PlaceComponentResult.get().execute(new CheckLocationPermissionPromptFeature.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$checkLocationPermissionPromptEnabled$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                Lazy lazy2;
                if (z) {
                    lazy2 = HomeRevampPresenter.this.scheduleImpl;
                    ((HomeRevampContract.View) lazy2.get()).PlaceComponentResult();
                    return;
                }
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$checkLocationPermissionPromptEnabled$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = HomeRevampPresenter.this.scheduleImpl;
                ((HomeRevampContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeRevampContract.Presenter
    public final void getAuthRequestContext(long p0, boolean p1) {
        SaveNumberOfLocationPermissionShownData saveNumberOfLocationPermissionShownData = this.getErrorConfigVersion.get();
        Intrinsics.checkNotNullExpressionValue(saveNumberOfLocationPermissionShownData, "");
        BaseUseCase.execute$default(saveNumberOfLocationPermissionShownData, new SaveNumberOfLocationPermissionShownData.Params(p0, p1), new Function1<Unit, Unit>() { // from class: id.dana.contract.homeinfo.HomeRevampPresenter$saveLocationPermissionPromptShown$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.lookAheadTest.get().dispose();
        this.moveToNextValue.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
    }
}
