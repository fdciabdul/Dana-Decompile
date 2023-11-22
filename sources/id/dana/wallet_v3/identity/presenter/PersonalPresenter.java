package id.dana.wallet_v3.identity.presenter;

import dagger.Lazy;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.domain.wallet_v3.interactor.CheckKtpConsultPopUp;
import id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved;
import id.dana.domain.wallet_v3.interactor.GetInsuranceAssetList;
import id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo;
import id.dana.domain.wallet_v3.interactor.GetUserKYCStatus;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp;
import id.dana.domain.wallet_v3.model.InsuranceAsset;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.domain.wallet_v3.model.KycInfo;
import id.dana.network.exception.NetworkException;
import id.dana.pocket.mapper.PocketMapperKt;
import id.dana.wallet.mapper.InsuranceAssetModelMapperKt;
import id.dana.wallet.mapper.KtpInfoModelMapperKt;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet.personal.mapper.KycInfoModelMapperKt;
import id.dana.wallet_v3.model.InsuranceAssetModel;
import id.dana.wallet_v3.model.KtpInfoModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u00020\u0001:\u0001AB\u0095\u0001\b\u0007\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u001f\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u001f\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u001f\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001f\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001f\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020%0\u001f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020:0\u001f\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001f¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020%0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010\"R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010\"R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b+\u0010\"R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010\"R\"\u0010/\u001a\u00020.8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020.8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020:0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b<\u0010\"R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b>\u0010\""}, d2 = {"Lid/dana/wallet_v3/identity/presenter/PersonalPresenter;", "Lid/dana/wallet/personal/PersonalContract$Presenter;", "", "isRefresh", "", "checkIsKtpSaved", "(Z)V", "checkKtpPopUp", "()V", "consultAgreementCenter", "", "errorCode", "getAssetReloadIntervalTime", "(Ljava/lang/String;)V", "", "throwable", "getErrorCode", "(Ljava/lang/Throwable;)Ljava/lang/String;", "isNeedToReset", "getInsuranceAssetQueryList", "getKtpInfoQueryList", "getKycStatusQueryList", "onDestroy", "userAgreement", "userIsKyc", "recordAgreement", "(ZZ)V", "userSaveKtp", "saveKtpPopUp", "agreementKey", "Ljava/lang/String;", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/CheckKtpConsultPopUp;", "checkKtpConsultPopUp", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/CheckKtpIsSaved;", "checkKtpIsSaved", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "Lid/dana/domain/wallet_v3/interactor/GetInsuranceAssetList;", "getInsuranceAssetList", "Lid/dana/domain/wallet_v3/interactor/GetIntervalTimeHitWalletApi;", "getIntervalTimeHitWalletApi", "Lid/dana/domain/wallet_v3/interactor/GetKtpInfo;", "getKtpInfo", "Lid/dana/domain/wallet_v3/interactor/GetUserKYCStatus;", "getUserKYCStatus", "", "insuranceAssetPageNumber", "I", "getInsuranceAssetPageNumber", "()I", "setInsuranceAssetPageNumber", "(I)V", "ktpInfoPageNumber", "getKtpInfoPageNumber", "setKtpInfoPageNumber", "needUserAgreement", "Z", "Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;", "Lid/dana/domain/wallet_v3/interactor/SaveKtpConsultPopUp;", "saveKtpConsultPopUp", "Lid/dana/wallet/personal/PersonalContract$View;", "view", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalPresenter implements PersonalContract.Presenter {
    public static final String CERT_TYPE = "certType";
    public static final int INSURANCE_PAGE_SIZE = 10;
    public static final int KTP_PAGE_SIZE = 1;
    public static final String UNKNOWN_ERROR = "Unknown Error";
    public static final String WALLET_KTP_TNC_SPACE_CODE = "wallet_ktp_tnc";
    private String agreementKey;
    private final Lazy<CheckKtpConsultPopUp> checkKtpConsultPopUp;
    private final Lazy<CheckKtpIsSaved> checkKtpIsSaved;
    private final Lazy<ConsultAgreementOnlyParamSpaceCodes> consultAgreementCenter;
    private final Lazy<GetInsuranceAssetList> getInsuranceAssetList;
    private final Lazy<GetIntervalTimeHitWalletApi> getIntervalTimeHitWalletApi;
    private final Lazy<GetKtpInfo> getKtpInfo;
    private final Lazy<GetUserKYCStatus> getUserKYCStatus;
    private int insuranceAssetPageNumber;
    private int ktpInfoPageNumber;
    private boolean needUserAgreement;
    private final Lazy<RecordAgreementOnlyAgreementKey> recordAgreement;
    private final Lazy<SaveKtpConsultPopUp> saveKtpConsultPopUp;
    private final Lazy<PersonalContract.View> view;

    @Inject
    public PersonalPresenter(Lazy<PersonalContract.View> lazy, Lazy<CheckKtpConsultPopUp> lazy2, Lazy<SaveKtpConsultPopUp> lazy3, Lazy<GetUserKYCStatus> lazy4, Lazy<GetKtpInfo> lazy5, Lazy<GetInsuranceAssetList> lazy6, Lazy<CheckKtpIsSaved> lazy7, Lazy<ConsultAgreementOnlyParamSpaceCodes> lazy8, Lazy<RecordAgreementOnlyAgreementKey> lazy9, Lazy<GetIntervalTimeHitWalletApi> lazy10) {
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
        this.view = lazy;
        this.checkKtpConsultPopUp = lazy2;
        this.saveKtpConsultPopUp = lazy3;
        this.getUserKYCStatus = lazy4;
        this.getKtpInfo = lazy5;
        this.getInsuranceAssetList = lazy6;
        this.checkKtpIsSaved = lazy7;
        this.consultAgreementCenter = lazy8;
        this.recordAgreement = lazy9;
        this.getIntervalTimeHitWalletApi = lazy10;
        this.ktpInfoPageNumber = 1;
        this.insuranceAssetPageNumber = 1;
    }

    @JvmName(name = "getKtpInfoPageNumber")
    public final int getKtpInfoPageNumber() {
        return this.ktpInfoPageNumber;
    }

    @JvmName(name = "setKtpInfoPageNumber")
    public final void setKtpInfoPageNumber(int i) {
        this.ktpInfoPageNumber = i;
    }

    @JvmName(name = "getInsuranceAssetPageNumber")
    public final int getInsuranceAssetPageNumber() {
        return this.insuranceAssetPageNumber;
    }

    @JvmName(name = "setInsuranceAssetPageNumber")
    public final void setInsuranceAssetPageNumber(int i) {
        this.insuranceAssetPageNumber = i;
    }

    @Override // id.dana.wallet.personal.PersonalContract.Presenter
    public final void checkKtpPopUp() {
        this.checkKtpConsultPopUp.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$checkKtpPopUp$1
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
                PersonalPresenter personalPresenter = PersonalPresenter.this;
                if (!z) {
                    lazy = personalPresenter.view;
                    ((PersonalContract.View) lazy.get()).onKtpNotSaved();
                    return;
                }
                personalPresenter.checkIsKtpSaved(true);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$checkKtpPopUp$2
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
                String errorCode;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                errorCode = PersonalPresenter.this.getErrorCode(th);
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onCheckKtpPopUpError(errorCode);
            }
        });
    }

    public final void saveKtpPopUp(boolean userSaveKtp, final boolean userIsKyc) {
        this.saveKtpConsultPopUp.get().execute(Boolean.valueOf(userSaveKtp), new Function1<Boolean, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$saveKtpPopUp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (z && userIsKyc) {
                    lazy2 = this.view;
                    ((PersonalContract.View) lazy2.get()).onSaveKtpSuccess();
                } else if ((!z || userIsKyc) && !z) {
                    lazy = this.view;
                    ((PersonalContract.View) lazy.get()).onSaveKtpError();
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$saveKtpPopUp$2
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
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onSaveKtpError();
            }
        });
    }

    public final void getKycStatusQueryList() {
        this.getUserKYCStatus.get().execute(new GetUserKYCStatus.Param(this.ktpInfoPageNumber, 1), new Function1<KycInfo, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getKycStatusQueryList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(KycInfo kycInfo) {
                invoke2(kycInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KycInfo kycInfo) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(kycInfo, "");
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onGetUserKYCStatusSuccess(KycInfoModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(kycInfo).getExtendInfo());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getKycStatusQueryList$2
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
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onGetUserKYCStatusError();
            }
        });
    }

    public final void getKtpInfoQueryList(final boolean isNeedToReset) {
        this.getKtpInfo.get().execute(new GetKtpInfo.Param(this.ktpInfoPageNumber, 1), new Function1<PocketQueryList<KtpInfo>, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getKtpInfoQueryList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PocketQueryList<KtpInfo> pocketQueryList) {
                invoke2(pocketQueryList);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getKtpInfoQueryList$1$1  reason: invalid class name */
            /* loaded from: classes9.dex */
            public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<KtpInfo, KtpInfoModel> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                AnonymousClass1() {
                    super(1, KtpInfoModelMapperKt.class, "toKtpInfoModel", "toKtpInfoModel(Lid/dana/domain/wallet_v3/model/KtpInfo;)Lid/dana/wallet_v3/model/KtpInfoModel;", 1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final KtpInfoModel invoke(KtpInfo ktpInfo) {
                    Intrinsics.checkNotNullParameter(ktpInfo, "");
                    return KtpInfoModelMapperKt.BuiltInFictitiousFunctionClassFactory(ktpInfo);
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PocketQueryList<KtpInfo> pocketQueryList) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(pocketQueryList, "");
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onGetKtpInfoQuerySuccess(PocketMapperKt.PlaceComponentResult(pocketQueryList, AnonymousClass1.INSTANCE), isNeedToReset);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getKtpInfoQueryList$2
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
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onGetKtpInfoQueryError();
            }
        });
    }

    public final void getInsuranceAssetQueryList(final boolean isNeedToReset) {
        if (isNeedToReset) {
            this.insuranceAssetPageNumber = 1;
        }
        this.getInsuranceAssetList.get().execute(new GetInsuranceAssetList.Param(this.insuranceAssetPageNumber, 10, null, 4, null), new Function1<PocketQueryList<InsuranceAsset>, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getInsuranceAssetQueryList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PocketQueryList<InsuranceAsset> pocketQueryList) {
                invoke2(pocketQueryList);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getInsuranceAssetQueryList$1$1  reason: invalid class name */
            /* loaded from: classes9.dex */
            public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<InsuranceAsset, InsuranceAssetModel> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                AnonymousClass1() {
                    super(1, InsuranceAssetModelMapperKt.class, "toInsuranceAssetModel", "toInsuranceAssetModel(Lid/dana/domain/wallet_v3/model/InsuranceAsset;)Lid/dana/wallet_v3/model/InsuranceAssetModel;", 1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final InsuranceAssetModel invoke(InsuranceAsset insuranceAsset) {
                    Intrinsics.checkNotNullParameter(insuranceAsset, "");
                    return InsuranceAssetModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(insuranceAsset);
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PocketQueryList<InsuranceAsset> pocketQueryList) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(pocketQueryList, "");
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onGetInsuranceQueryListSuccess(PocketMapperKt.PlaceComponentResult(pocketQueryList, AnonymousClass1.INSTANCE), isNeedToReset);
                PersonalPresenter personalPresenter = PersonalPresenter.this;
                personalPresenter.setInsuranceAssetPageNumber(personalPresenter.getInsuranceAssetPageNumber() + 1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getInsuranceAssetQueryList$2
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
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onGetInsuranceQueryListError();
            }
        });
    }

    public final void checkIsKtpSaved(boolean isRefresh) {
        this.checkKtpIsSaved.get().execute(new CheckKtpIsSaved.Param(isRefresh), new Function1<Boolean, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$checkIsKtpSaved$1
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
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onKtpSaved(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$checkIsKtpSaved$2
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
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onKtpSaved(false);
            }
        });
    }

    @Override // id.dana.wallet.personal.PersonalContract.Presenter
    public final void recordAgreement(final boolean userAgreement, final boolean userIsKyc) {
        if (this.needUserAgreement) {
            RecordAgreementOnlyAgreementKey recordAgreementOnlyAgreementKey = this.recordAgreement.get();
            String str = this.agreementKey;
            if (str == null) {
                str = "";
            }
            recordAgreementOnlyAgreementKey.execute(new RecordAgreementOnlyAgreementKey.Params(CollectionsKt.listOf(str), userAgreement), new Function1<Boolean, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$recordAgreement$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    PersonalPresenter.this.saveKtpPopUp(userAgreement, userIsKyc);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$recordAgreement$2
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
                    lazy = PersonalPresenter.this.view;
                    ((PersonalContract.View) lazy.get()).onSaveKtpError();
                }
            });
            return;
        }
        saveKtpPopUp(userAgreement, userIsKyc);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    @Override // id.dana.wallet.personal.PersonalContract.Presenter
    public final void consultAgreementCenter() {
        ?? r3 = 0;
        this.consultAgreementCenter.get().execute(new ConsultAgreementOnlyParamSpaceCodes.Params(CollectionsKt.listOf(WALLET_KTP_TNC_SPACE_CODE), r3, 2, r3), new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$consultAgreementCenter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                invoke2(consultAgreementResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                AgreementInfo agreementInfo;
                Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                PersonalPresenter.this.needUserAgreement = consultAgreementResponse.getNeedUserAgreement();
                PersonalPresenter personalPresenter = PersonalPresenter.this;
                List<AgreementInfo> agreementInfos = consultAgreementResponse.getAgreementInfos();
                String agreementKey = (agreementInfos == null || (agreementInfo = (AgreementInfo) CollectionsKt.first((List) agreementInfos)) == null) ? null : agreementInfo.getAgreementKey();
                personalPresenter.agreementKey = agreementKey != null ? agreementKey : "";
                PersonalPresenter.this.getKycStatusQueryList();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$consultAgreementCenter$2
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
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onConsultAgreementCenterError();
            }
        });
    }

    @Override // id.dana.wallet.personal.PersonalContract.Presenter
    public final void getAssetReloadIntervalTime(String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "");
        GetIntervalTimeHitWalletApi getIntervalTimeHitWalletApi = this.getIntervalTimeHitWalletApi.get();
        Intrinsics.checkNotNullExpressionValue(getIntervalTimeHitWalletApi, "");
        BaseUseCase.execute$default(getIntervalTimeHitWalletApi, new GetIntervalTimeHitWalletApi.Param(errorCode), new Function1<Integer, Unit>() { // from class: id.dana.wallet_v3.identity.presenter.PersonalPresenter$getAssetReloadIntervalTime$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Lazy lazy;
                lazy = PersonalPresenter.this.view;
                ((PersonalContract.View) lazy.get()).onGetIdentityReloadIntervalTime(System.currentTimeMillis() + i);
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.checkKtpConsultPopUp.get().dispose();
        this.saveKtpConsultPopUp.get().dispose();
        this.getUserKYCStatus.get().dispose();
        this.getKtpInfo.get().dispose();
        this.getInsuranceAssetList.get().dispose();
        this.checkKtpIsSaved.get().dispose();
        this.getIntervalTimeHitWalletApi.get().dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getErrorCode(Throwable throwable) {
        if (throwable instanceof NetworkException) {
            String errorCode = ((NetworkException) throwable).getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "");
            return errorCode;
        }
        return UNKNOWN_ERROR;
    }
}
