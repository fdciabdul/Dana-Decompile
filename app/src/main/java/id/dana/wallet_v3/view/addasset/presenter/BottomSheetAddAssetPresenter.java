package id.dana.wallet_v3.view.addasset.presenter;

import com.iap.ac.android.acs.plugin.utils.Constants;
import dagger.Lazy;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.DanaH5;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.pocket.model.LoyaltyToken;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetServices;
import id.dana.domain.wallet_v3.model.BottomSheetAllService;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.miniprogram.ExtensionsKt;
import id.dana.model.ThirdPartyService;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Be\b\u0007\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0012\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0015"}, d2 = {"Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetPresenter;", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$Presenter;", "Lid/dana/model/ThirdPartyService;", "thirdPartyService", "", "doAction", "(Lid/dana/model/ThirdPartyService;)V", "fetchLoyaltyAccessTokenAndKycLevel", "()V", "getAllServices$app_productionRelease", "", HomeTabActivity.WALLET_SECTION, "getBottomSheetServices", "(I)V", "getKycLevel", "getServicesByKey$app_productionRelease", "onDestroy", "postAuthCode", "Ldagger/Lazy;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", Constants.JS_API_GET_AUTH_CODE, "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetBottomSheetAllService;", "getBottomSheetAllService", "Lid/dana/domain/wallet_v3/interactor/GetBottomSheetServices;", "Lid/dana/domain/account/interactor/GetKycLevel;", "Lid/dana/domain/pocket/interactor/GetLoyaltyToken;", "getLoyaltyAccessToken", "Lid/dana/mapper/ThirdPartyServicesMapper;", "mapper", "Lid/dana/mapper/ThirdPartyServicesMapper;", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$View;", "view", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Lid/dana/mapper/ThirdPartyServicesMapper;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BottomSheetAddAssetPresenter implements BottomSheetAddAssetContract.Presenter {
    private final Lazy<GetAuthCode> getAuthCode;
    private final Lazy<GetBottomSheetAllService> getBottomSheetAllService;
    private final Lazy<GetBottomSheetServices> getBottomSheetServices;
    private final Lazy<GetKycLevel> getKycLevel;
    private final Lazy<GetLoyaltyToken> getLoyaltyAccessToken;
    private final ThirdPartyServicesMapper mapper;
    private final Lazy<BottomSheetAddAssetContract.View> view;

    @Inject
    public BottomSheetAddAssetPresenter(Lazy<BottomSheetAddAssetContract.View> lazy, Lazy<GetBottomSheetServices> lazy2, ThirdPartyServicesMapper thirdPartyServicesMapper, Lazy<GetAuthCode> lazy3, Lazy<GetKycLevel> lazy4, Lazy<GetLoyaltyToken> lazy5, Lazy<GetBottomSheetAllService> lazy6) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(thirdPartyServicesMapper, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        this.view = lazy;
        this.getBottomSheetServices = lazy2;
        this.mapper = thirdPartyServicesMapper;
        this.getAuthCode = lazy3;
        this.getKycLevel = lazy4;
        this.getLoyaltyAccessToken = lazy5;
        this.getBottomSheetAllService = lazy6;
    }

    @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.Presenter
    public final void getBottomSheetServices(int section) {
        if (section == 0) {
            getAllServices$app_productionRelease();
        } else {
            getServicesByKey$app_productionRelease(section);
        }
    }

    private final void postAuthCode(final ThirdPartyService thirdPartyService) {
        if (thirdPartyService.getSubSequence()) {
            this.view.get().onActionPost(thirdPartyService, null);
            return;
        }
        GetAuthCode getAuthCode = this.getAuthCode.get();
        GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
        String str = thirdPartyService.getCallingPid;
        if (str == null) {
            str = "";
        }
        String str2 = thirdPartyService.moveToNextValue;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = thirdPartyService.VerifyPinStateManager$executeRiskChallenge$2$1;
        getAuthCode.execute(companion.forGetAuthCode(str, str2, str3 != null ? str3 : "", true), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$postAuthCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                invoke2(authCodeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AuthCodeResult authCodeResult) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(authCodeResult, "");
                lazy = BottomSheetAddAssetPresenter.this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onActionPost(thirdPartyService, authCodeResult.getAuthCode());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$postAuthCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (th instanceof GetAuthCode.MissingRequiredUserInfoException) {
                    GetAuthCode.MissingRequiredUserInfoException missingRequiredUserInfoException = (GetAuthCode.MissingRequiredUserInfoException) th;
                    String str4 = ThirdPartyService.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    String str5 = ThirdPartyService.this.FragmentBottomSheetPaymentSettingBinding;
                    String str6 = str5 == null ? "" : str5;
                    String str7 = ThirdPartyService.this.GetContactSyncConfig;
                    String str8 = ThirdPartyService.this.VerifyPinStateManager$executeRiskChallenge$2$1;
                    ExtensionsKt.BuiltInFictitiousFunctionClassFactory(missingRequiredUserInfoException, str4, str6, str7, str8 == null ? "" : str8, "", "", false);
                }
                lazy = this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onActionFailed(th.getMessage());
            }
        });
    }

    @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.Presenter
    public final void fetchLoyaltyAccessTokenAndKycLevel() {
        this.getLoyaltyAccessToken.get().execute(NoParams.INSTANCE, new Function1<LoyaltyToken, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$fetchLoyaltyAccessTokenAndKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(LoyaltyToken loyaltyToken) {
                invoke2(loyaltyToken);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LoyaltyToken loyaltyToken) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(loyaltyToken, "");
                lazy = BottomSheetAddAssetPresenter.this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onGetLoyaltyAccessToken(loyaltyToken.getAccessToken());
                BottomSheetAddAssetPresenter.this.getKycLevel();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$fetchLoyaltyAccessTokenAndKycLevel$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getKycLevel() {
        this.getKycLevel.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$getKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Lazy lazy;
                boolean z = false;
                if (str != null) {
                    if (str.length() == 0) {
                        z = true;
                    }
                }
                if (z) {
                    str = "KYC0";
                }
                lazy = BottomSheetAddAssetPresenter.this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onGetKycLevel(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$getKycLevel$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    public final void getAllServices$app_productionRelease() {
        this.getBottomSheetAllService.get().execute(NoParams.INSTANCE, new Function1<BottomSheetAllService, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$getAllServices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BottomSheetAllService bottomSheetAllService) {
                invoke2(bottomSheetAllService);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BottomSheetAllService bottomSheetAllService) {
                Lazy lazy;
                ThirdPartyServicesMapper unused;
                ThirdPartyServicesMapper unused2;
                ThirdPartyServicesMapper unused3;
                ThirdPartyServicesMapper unused4;
                ThirdPartyServicesMapper unused5;
                Intrinsics.checkNotNullParameter(bottomSheetAllService, "");
                unused = BottomSheetAddAssetPresenter.this.mapper;
                List<ThirdPartyService> mutableList = CollectionsKt.toMutableList((Collection) ThirdPartyServicesMapper.KClassImpl$Data$declaredNonStaticMembers$2(bottomSheetAllService.getPaymentService()));
                unused2 = BottomSheetAddAssetPresenter.this.mapper;
                List<ThirdPartyService> mutableList2 = CollectionsKt.toMutableList((Collection) ThirdPartyServicesMapper.KClassImpl$Data$declaredNonStaticMembers$2(bottomSheetAllService.getFinancialService()));
                unused3 = BottomSheetAddAssetPresenter.this.mapper;
                List<ThirdPartyService> mutableList3 = CollectionsKt.toMutableList((Collection) ThirdPartyServicesMapper.KClassImpl$Data$declaredNonStaticMembers$2(bottomSheetAllService.getVoucherService()));
                unused4 = BottomSheetAddAssetPresenter.this.mapper;
                List<ThirdPartyService> mutableList4 = CollectionsKt.toMutableList((Collection) ThirdPartyServicesMapper.KClassImpl$Data$declaredNonStaticMembers$2(bottomSheetAllService.getLoyaltyService()));
                unused5 = BottomSheetAddAssetPresenter.this.mapper;
                List<ThirdPartyService> mutableList5 = CollectionsKt.toMutableList((Collection) ThirdPartyServicesMapper.KClassImpl$Data$declaredNonStaticMembers$2(bottomSheetAllService.getIdentityService()));
                lazy = BottomSheetAddAssetPresenter.this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onGetAllThirdPartyServices(mutableList, mutableList2, mutableList3, mutableList4, mutableList5);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$getAllServices$2
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
                lazy = BottomSheetAddAssetPresenter.this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onErrorGetServicesList();
            }
        });
    }

    public final void getServicesByKey$app_productionRelease(final int section) {
        this.getBottomSheetServices.get().execute(Integer.valueOf(section), new Function1<List<? extends ThirdPartyServiceResponse>, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$getServicesByKey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyServiceResponse> list) {
                invoke2((List<ThirdPartyServiceResponse>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<ThirdPartyServiceResponse> list) {
                Lazy lazy;
                ThirdPartyServicesMapper unused;
                Intrinsics.checkNotNullParameter(list, "");
                unused = BottomSheetAddAssetPresenter.this.mapper;
                List<ThirdPartyService> mutableList = CollectionsKt.toMutableList((Collection) ThirdPartyServicesMapper.KClassImpl$Data$declaredNonStaticMembers$2(list));
                lazy = BottomSheetAddAssetPresenter.this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onGetThirdPartyServices(section, mutableList);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter$getServicesByKey$2
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
                lazy = BottomSheetAddAssetPresenter.this.view;
                ((BottomSheetAddAssetContract.View) lazy.get()).onErrorGetServicesList();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        DanaH5.dispose();
        this.getBottomSheetServices.get().dispose();
        this.getAuthCode.get().dispose();
        this.getKycLevel.get().dispose();
        this.getLoyaltyAccessToken.get().dispose();
        this.getBottomSheetAllService.get().dispose();
    }

    @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.Presenter
    public final void doAction(ThirdPartyService thirdPartyService) {
        Intrinsics.checkNotNullParameter(thirdPartyService, "");
        if (thirdPartyService.PlaceComponentResult != null) {
            DanaH5.openApp(thirdPartyService);
        } else if (thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            this.view.get().onDirectOpen(thirdPartyService);
        } else if (Intrinsics.areEqual(thirdPartyService.BuiltInFictitiousFunctionClassFactory, "POST") && thirdPartyService.getCallingPid != null) {
            postAuthCode(thirdPartyService);
        } else if (!Intrinsics.areEqual(thirdPartyService.BuiltInFictitiousFunctionClassFactory, "GET") || thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
        } else {
            this.view.get().onActionGet(thirdPartyService);
        }
    }
}
