package id.dana.contract.oauth;

import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.contract.oauth.OauthGrantContract;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetShowAlipayConnectBrandConfig;
import id.dana.domain.oauth.interactor.ConfirmScopes;
import id.dana.domain.oauth.interactor.GetGnBindingBenefits;
import id.dana.domain.oauth.interactor.GetScopes;
import id.dana.domain.oauth.interactor.GnAuthAgreement;
import id.dana.domain.oauth.interactor.GnAuthApply;
import id.dana.domain.oauth.model.GnBindingBenefit;
import id.dana.domain.oauth.model.OauthConfirmation;
import id.dana.domain.oauth.model.OauthInit;
import id.dana.oauth.OauthConstant;
import id.dana.oauth.mapper.BindingBenefitModelMapper;
import id.dana.oauth.mapper.OauthInitModelMapper;
import id.dana.oauth.mapper.OauthModelMapperKt;
import id.dana.oauth.model.OauthInitModel;
import id.dana.oauth.model.OauthParamsModel;
import id.dana.oauth.tracker.OauthGrantTimer;
import id.dana.oauth.tracker.OauthGrantTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u001aH\u0002J\u001a\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u0016\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\u001a\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\b\u001a\u00020\u001cH\u0016J\u0014\u0010%\u001a\u0004\u0018\u00010\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u0012\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J0\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u00020-2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\u001cH\u0002J<\u00104\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u00105\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u00010\u001a2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u000108H\u0016J\f\u00109\u001a\u00020-*\u000201H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lid/dana/contract/oauth/OauthGrantPresenter;", "Lid/dana/contract/oauth/OauthGrantContract$Presenter;", "getScopes", "Lid/dana/domain/oauth/interactor/GetScopes;", "view", "Lid/dana/contract/oauth/OauthGrantContract$View;", "oauthInitModelMapper", "Lid/dana/oauth/mapper/OauthInitModelMapper;", "getPhoneNumber", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "confirmScopes", "Lid/dana/domain/oauth/interactor/ConfirmScopes;", "gnAuthAgreement", "Lid/dana/domain/oauth/interactor/GnAuthAgreement;", "gnAuthApply", "Lid/dana/domain/oauth/interactor/GnAuthApply;", "getGnBindingBenefits", "Lid/dana/domain/oauth/interactor/GetGnBindingBenefits;", "getShowAlipayConnectBrandConfig", "Lid/dana/domain/featureconfig/interactor/GetShowAlipayConnectBrandConfig;", "oauthGrantTracker", "Lid/dana/oauth/tracker/OauthGrantTracker;", "getAvatarUrl", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "(Lid/dana/domain/oauth/interactor/GetScopes;Lid/dana/contract/oauth/OauthGrantContract$View;Lid/dana/oauth/mapper/OauthInitModelMapper;Lid/dana/domain/account/interactor/GetPhoneNumber;Lid/dana/domain/oauth/interactor/ConfirmScopes;Lid/dana/domain/oauth/interactor/GnAuthAgreement;Lid/dana/domain/oauth/interactor/GnAuthApply;Lid/dana/domain/oauth/interactor/GetGnBindingBenefits;Lid/dana/domain/featureconfig/interactor/GetShowAlipayConnectBrandConfig;Lid/dana/oauth/tracker/OauthGrantTracker;Lid/dana/domain/account/interactor/GetAvatarUrl;)V", "merchantSiteNameTemp", "", "confirmScope", "", "oauthParamsModel", "Lid/dana/oauth/model/OauthParamsModel;", "bindingType", "formatWhitespaceWithPlus", "value", "getAuthAgreement", "getBindingBenefits", "getOauthScope", "getRequestResourceType", BranchLinkConstant.OauthParams.BIND_DANA_TYPE, "oauthInitModel", "Lid/dana/oauth/model/OauthInitModel;", "handleError", "throwable", "", BranchLinkConstant.ActionTarget.QR_BIND, "", "googleMerchant", "isQueryAuthInfoNotSuccess", "authCodeResult", "Lid/dana/domain/authcode/AuthCodeResult;", "onDestroy", "stopTrackerBinding", "submitAuthApply", "qrBinding", BioUtilityBridge.SECURITY_ID, "verificationMethods", "", "requiresRiskChallenge", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class OauthGrantPresenter implements OauthGrantContract.Presenter {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int DatabaseTableConfigUtil = 1;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {35513, 35540};
    private static int initRecordTimeStamp;
    private final ConfirmScopes BuiltInFictitiousFunctionClassFactory;
    private final OauthInitModelMapper GetContactSyncConfig;
    private final GetGnBindingBenefits KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetPhoneNumber MyBillsEntityDataFactory;
    private final GnAuthAgreement NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final OauthGrantContract.View NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final GetScopes PlaceComponentResult;
    private final GetAvatarUrl getAuthRequestContext;
    private final OauthGrantTracker getErrorConfigVersion;
    private String lookAheadTest;
    private final GetShowAlipayConnectBrandConfig moveToNextValue;
    private final GnAuthApply scheduleImpl;

    @Inject
    public OauthGrantPresenter(GetScopes getScopes, OauthGrantContract.View view, OauthInitModelMapper oauthInitModelMapper, GetPhoneNumber getPhoneNumber, ConfirmScopes confirmScopes, GnAuthAgreement gnAuthAgreement, GnAuthApply gnAuthApply, GetGnBindingBenefits getGnBindingBenefits, GetShowAlipayConnectBrandConfig getShowAlipayConnectBrandConfig, OauthGrantTracker oauthGrantTracker, GetAvatarUrl getAvatarUrl) {
        Intrinsics.checkNotNullParameter(getScopes, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(oauthInitModelMapper, "");
        Intrinsics.checkNotNullParameter(getPhoneNumber, "");
        Intrinsics.checkNotNullParameter(confirmScopes, "");
        Intrinsics.checkNotNullParameter(gnAuthAgreement, "");
        Intrinsics.checkNotNullParameter(gnAuthApply, "");
        Intrinsics.checkNotNullParameter(getGnBindingBenefits, "");
        Intrinsics.checkNotNullParameter(getShowAlipayConnectBrandConfig, "");
        Intrinsics.checkNotNullParameter(oauthGrantTracker, "");
        Intrinsics.checkNotNullParameter(getAvatarUrl, "");
        this.PlaceComponentResult = getScopes;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = view;
        this.GetContactSyncConfig = oauthInitModelMapper;
        this.MyBillsEntityDataFactory = getPhoneNumber;
        this.BuiltInFictitiousFunctionClassFactory = confirmScopes;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = gnAuthAgreement;
        this.scheduleImpl = gnAuthApply;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getGnBindingBenefits;
        this.moveToNextValue = getShowAlipayConnectBrandConfig;
        this.getErrorConfigVersion = oauthGrantTracker;
        this.getAuthRequestContext = getAvatarUrl;
        this.lookAheadTest = "";
    }

    public static final /* synthetic */ OauthGrantTracker BuiltInFictitiousFunctionClassFactory(OauthGrantPresenter oauthGrantPresenter) {
        int i = DatabaseTableConfigUtil + 83;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        OauthGrantTracker oauthGrantTracker = oauthGrantPresenter.getErrorConfigVersion;
        int i3 = initRecordTimeStamp + 47;
        DatabaseTableConfigUtil = i3 % 128;
        if (i3 % 2 != 0) {
            return oauthGrantTracker;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return oauthGrantTracker;
    }

    public static final /* synthetic */ OauthGrantContract.View KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter oauthGrantPresenter) {
        int i = DatabaseTableConfigUtil + 41;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            OauthGrantContract.View view = oauthGrantPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2;
            int i3 = DatabaseTableConfigUtil + 85;
            initRecordTimeStamp = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 22 : 'W') != 'W') {
                Object[] objArr = null;
                int length = objArr.length;
                return view;
            }
            return view;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(AuthCodeResult authCodeResult) {
        int i = initRecordTimeStamp + 67;
        DatabaseTableConfigUtil = i % 128;
        boolean z = i % 2 == 0;
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(authCodeResult);
        if (z) {
            int i2 = 77 / 0;
        }
        int i3 = initRecordTimeStamp + 87;
        DatabaseTableConfigUtil = i3 % 128;
        if ((i3 % 2 == 0 ? '6' : '1') != '6') {
            return MyBillsEntityDataFactory;
        }
        Object obj = null;
        obj.hashCode();
        return MyBillsEntityDataFactory;
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory(OauthGrantPresenter oauthGrantPresenter) {
        int i = initRecordTimeStamp + 7;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
        String str = oauthGrantPresenter.lookAheadTest;
        int i3 = DatabaseTableConfigUtil + 21;
        initRecordTimeStamp = i3 % 128;
        if ((i3 % 2 != 0 ? 'Z' : '`') != '`') {
            int i4 = 93 / 0;
            return str;
        }
        return str;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OauthGrantPresenter oauthGrantPresenter, String str) {
        int i = initRecordTimeStamp + 15;
        DatabaseTableConfigUtil = i % 128;
        if ((i % 2 == 0 ? '+' : '6') == '6') {
            oauthGrantPresenter.lookAheadTest = str;
            return;
        }
        try {
            oauthGrantPresenter.lookAheadTest = str;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ OauthInitModelMapper PlaceComponentResult(OauthGrantPresenter oauthGrantPresenter) {
        try {
            int i = initRecordTimeStamp + 11;
            DatabaseTableConfigUtil = i % 128;
            boolean z = i % 2 == 0;
            OauthInitModelMapper oauthInitModelMapper = oauthGrantPresenter.GetContactSyncConfig;
            if (z) {
                Object obj = null;
                obj.hashCode();
            }
            return oauthInitModelMapper;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult() {
        int i = DatabaseTableConfigUtil + 1;
        initRecordTimeStamp = i % 128;
        if (i % 2 != 0) {
            BuiltInFictitiousFunctionClassFactory();
            int i2 = 73 / 0;
        } else {
            BuiltInFictitiousFunctionClassFactory();
        }
        int i3 = DatabaseTableConfigUtil + 29;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ boolean PlaceComponentResult(AuthCodeResult authCodeResult) {
        int i = DatabaseTableConfigUtil + 53;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        boolean authRequestContext = getAuthRequestContext(authCodeResult);
        try {
            int i3 = initRecordTimeStamp + 37;
            DatabaseTableConfigUtil = i3 % 128;
            int i4 = i3 % 2;
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.Presenter
    public final void PlaceComponentResult(final OauthParamsModel oauthParamsModel, final String str) {
        boolean z;
        try {
            Intrinsics.checkNotNullParameter(oauthParamsModel, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.showProgress();
            GetScopes getScopes = this.PlaceComponentResult;
            DefaultObserver<OauthInit> defaultObserver = new DefaultObserver<OauthInit>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$getOauthScope$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    OauthInit oauthInit = (OauthInit) obj;
                    Intrinsics.checkNotNullParameter(oauthInit, "");
                    OauthGrantPresenter.PlaceComponentResult(OauthGrantPresenter.this).KClassImpl$Data$declaredNonStaticMembers$2 = oauthParamsModel.isLayoutRequested;
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).onGetOauthScopeSuccess(OauthGrantPresenter.PlaceComponentResult(OauthGrantPresenter.this).apply(oauthInit));
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissProgress();
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onError(p0);
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this, p0, str, false, false, 12);
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissProgress();
                }
            };
            String str2 = oauthParamsModel.MyBillsEntityDataFactory;
            String str3 = oauthParamsModel.BuiltInFictitiousFunctionClassFactory;
            List<String> list = oauthParamsModel.isLayoutRequested;
            String str4 = oauthParamsModel.DatabaseTableConfigUtil;
            Boolean bool = oauthParamsModel.getErrorConfigVersion;
            if ((bool != null ? 'I' : JSONLexer.EOI) == 26) {
                z = false;
                int i = initRecordTimeStamp + 35;
                DatabaseTableConfigUtil = i % 128;
                int i2 = i % 2;
            } else {
                int i3 = initRecordTimeStamp + 33;
                DatabaseTableConfigUtil = i3 % 128;
                int i4 = i3 % 2;
                z = bool.booleanValue();
            }
            getScopes.execute(defaultObserver, GetScopes.Params.forGetScopeList(str2, str3, list, str4, z));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.Presenter
    public final void MyBillsEntityDataFactory(OauthParamsModel oauthParamsModel, final String str) {
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(oauthParamsModel, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.showConfirmProgress();
        ConfirmScopes confirmScopes = this.BuiltInFictitiousFunctionClassFactory;
        DefaultObserver<OauthConfirmation> defaultObserver = new DefaultObserver<OauthConfirmation>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$confirmScope$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                OauthConfirmation oauthConfirmation = (OauthConfirmation) obj;
                Intrinsics.checkNotNullParameter(oauthConfirmation, "");
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissConfirmProgress();
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).onConfirmOauthScopeSuccess(oauthConfirmation.getMobileAuthCode(), oauthConfirmation.getServerAuthCode());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this, p0, str, false, false, 12);
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissConfirmProgress();
            }
        };
        String str2 = oauthParamsModel.MyBillsEntityDataFactory;
        String str3 = oauthParamsModel.BuiltInFictitiousFunctionClassFactory;
        List<String> list = oauthParamsModel.isLayoutRequested;
        String str4 = oauthParamsModel.DatabaseTableConfigUtil;
        Boolean bool = oauthParamsModel.getErrorConfigVersion;
        boolean z = false;
        if (!(bool == null)) {
            int i = DatabaseTableConfigUtil + 71;
            initRecordTimeStamp = i % 128;
            if ((i % 2 != 0 ? 'L' : 'R') != 'R') {
                booleanValue = bool.booleanValue();
                int i2 = 95 / 0;
            } else {
                booleanValue = bool.booleanValue();
            }
            z = booleanValue;
        }
        confirmScopes.execute(defaultObserver, ConfirmScopes.Params.forConfirmScopes(str2, str3, list, str4, z));
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final OauthParamsModel oauthParamsModel, final String str) {
        try {
            Intrinsics.checkNotNullParameter(oauthParamsModel, "");
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.showProgress();
                OauthGrantTimer.MyBillsEntityDataFactory();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<AuthCodeResult>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$getAuthAgreement$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj) {
                        AuthCodeResult authCodeResult = (AuthCodeResult) obj;
                        Intrinsics.checkNotNullParameter(authCodeResult, "");
                        OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissProgress();
                        OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).onGetOauthScopeSuccess(OauthGrantPresenter.PlaceComponentResult(OauthGrantPresenter.this).getAuthRequestContext(authCodeResult));
                        OauthGrantTimer.getErrorConfigVersion();
                        OauthInitModel authRequestContext = OauthGrantPresenter.PlaceComponentResult(OauthGrantPresenter.this).getAuthRequestContext(authCodeResult);
                        OauthGrantPresenter oauthGrantPresenter = OauthGrantPresenter.this;
                        String str2 = authRequestContext.getAuthRequestContext;
                        if (str2 == null) {
                            str2 = "";
                        }
                        OauthGrantPresenter.MyBillsEntityDataFactory(oauthGrantPresenter, str2);
                        OauthGrantPresenter.BuiltInFictitiousFunctionClassFactory(OauthGrantPresenter.this).MyBillsEntityDataFactory(null);
                        OauthGrantTracker BuiltInFictitiousFunctionClassFactory = OauthGrantPresenter.BuiltInFictitiousFunctionClassFactory(OauthGrantPresenter.this);
                        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(authRequestContext);
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        super.onError(p0);
                        OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this, p0, str, false, oauthParamsModel.BuiltInFictitiousFunctionClassFactory(), 4);
                        OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissProgress();
                        OauthGrantTimer.getErrorConfigVersion();
                        OauthGrantPresenter.BuiltInFictitiousFunctionClassFactory(OauthGrantPresenter.this).MyBillsEntityDataFactory(p0.getMessage());
                    }
                }, new GnAuthAgreement.Params(oauthParamsModel.BuiltInFictitiousFunctionClassFactory, oauthParamsModel.isLayoutRequested, oauthParamsModel.DatabaseTableConfigUtil, oauthParamsModel.scheduleImpl, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda0, BuiltInFictitiousFunctionClassFactory(oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda7), oauthParamsModel.initRecordTimeStamp));
                int i = DatabaseTableConfigUtil + 21;
                initRecordTimeStamp = i % 128;
                if (!(i % 2 != 0)) {
                    return;
                }
                int i2 = 63 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.Presenter
    public final void PlaceComponentResult(OauthParamsModel oauthParamsModel, final String str, final boolean z, String str2, final List<String> list) {
        Intrinsics.checkNotNullParameter(oauthParamsModel, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.showConfirmProgress();
        OauthGrantTimer.getAuthRequestContext();
        this.scheduleImpl.execute(new DefaultObserver<AuthCodeResult>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$submitAuthApply$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AuthCodeResult authCodeResult = (AuthCodeResult) obj;
                Intrinsics.checkNotNullParameter(authCodeResult, "");
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissConfirmProgress();
                if (OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(authCodeResult)) {
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).onGetAuthCodeRiskFailed(authCodeResult.getSecurityId(), authCodeResult.getVerificationMethods());
                } else if (OauthGrantPresenter.PlaceComponentResult(authCodeResult)) {
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this, null, str, z, false, 8);
                } else {
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).onGetAuthCodeSuccess(OauthModelMapperKt.PlaceComponentResult(authCodeResult));
                    OauthGrantPresenter.PlaceComponentResult();
                    OauthGrantTracker BuiltInFictitiousFunctionClassFactory = OauthGrantPresenter.BuiltInFictitiousFunctionClassFactory(OauthGrantPresenter.this);
                    String MyBillsEntityDataFactory = OauthGrantPresenter.MyBillsEntityDataFactory(OauthGrantPresenter.this);
                    boolean isSuccess = authCodeResult.isSuccess();
                    String errorMessage = authCodeResult.getErrorMessage();
                    List<String> list2 = list;
                    if (list2 == null) {
                        list2 = CollectionsKt.emptyList();
                    }
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(MyBillsEntityDataFactory, isSuccess, errorMessage, list2);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this, p0, str, z, false, 8);
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).dismissConfirmProgress();
                OauthGrantPresenter.PlaceComponentResult();
                OauthGrantPresenter.BuiltInFictitiousFunctionClassFactory(OauthGrantPresenter.this).PlaceComponentResult(OauthGrantPresenter.MyBillsEntityDataFactory(OauthGrantPresenter.this), false, p0.getMessage(), CollectionsKt.emptyList());
            }
        }, new GnAuthApply.Params(oauthParamsModel.newProxyInstance, oauthParamsModel.BuiltInFictitiousFunctionClassFactory, oauthParamsModel.isLayoutRequested, oauthParamsModel.DatabaseTableConfigUtil, oauthParamsModel.scheduleImpl, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda0, str2, KClassImpl$Data$declaredNonStaticMembers$2(str), z));
        int i = DatabaseTableConfigUtil + 43;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, ((java.lang.String) r5[0]).intern()) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004f, code lost:
    
        r6 = id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp + 13;
        id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
    
        if ((r6 % 2) != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        r0 = 13 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        r6 = id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp + 21;
        id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return "ALIPAY";
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if ((kotlin.jvm.internal.Intrinsics.areEqual(r6, ((java.lang.String) r5[0]).intern())) != true) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r6) {
        /*
            int r0 = id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L32
            int[] r0 = new int[r2]
            r0 = {x006e: FILL_ARRAY_DATA , data: [0, 2, 0, 0} // fill-array
            byte[] r2 = new byte[r1]
            r2 = {x007a: FILL_ARRAY_DATA , data: [0, 1} // fill-array
            java.lang.Object[] r5 = new java.lang.Object[r4]
            a(r0, r3, r2, r5)
            r0 = r5[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            if (r6 == 0) goto L2e
            r6 = 1
            goto L2f
        L2e:
            r6 = 0
        L2f:
            if (r6 == r4) goto L4f
            goto L6b
        L32:
            int[] r0 = new int[r2]
            r0 = {x0080: FILL_ARRAY_DATA , data: [0, 2, 0, 0} // fill-array
            byte[] r2 = new byte[r1]
            r2 = {x008c: FILL_ARRAY_DATA , data: [0, 1} // fill-array
            java.lang.Object[] r5 = new java.lang.Object[r4]
            a(r0, r4, r2, r5)
            r0 = r5[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            if (r6 == 0) goto L6b
        L4f:
            int r6 = id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp
            r0 = 13
            int r6 = r6 + r0
            int r2 = r6 % 128
            id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil = r2
            int r6 = r6 % r1
            if (r6 != 0) goto L5f
            int r0 = r0 / r3
            goto L5f
        L5d:
            r6 = move-exception
            throw r6
        L5f:
            int r6 = id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp
            int r6 = r6 + 21
            int r0 = r6 % 128
            id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil = r0
            int r6 = r6 % r1
            java.lang.String r6 = "ALIPAY"
            goto L6c
        L6b:
            r6 = 0
        L6c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.oauth.OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):java.lang.String");
    }

    private static boolean getAuthRequestContext(AuthCodeResult authCodeResult) {
        int i = initRecordTimeStamp + 79;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
        boolean areEqual = Intrinsics.areEqual(authCodeResult.isQueryAuthInfoSuccess(), Boolean.FALSE);
        int i3 = DatabaseTableConfigUtil + 99;
        initRecordTimeStamp = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return areEqual;
        }
        Object obj = null;
        obj.hashCode();
        return areEqual;
    }

    private static void BuiltInFictitiousFunctionClassFactory() {
        int i = initRecordTimeStamp + 75;
        DatabaseTableConfigUtil = i % 128;
        char c = i % 2 == 0 ? (char) 18 : '`';
        OauthGrantTimer.moveToNextValue();
        if (c != '`') {
            int i2 = 77 / 0;
        }
        try {
            int i3 = DatabaseTableConfigUtil + 87;
            initRecordTimeStamp = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<String>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$getPhoneNumber$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).onGetPhoneNumberSuccess(str);
            }
        });
        int i = DatabaseTableConfigUtil + 95;
        initRecordTimeStamp = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<List<? extends GnBindingBenefit>, Unit>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$getBindingBenefits$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends GnBindingBenefit> list) {
                    invoke2((List<GnBindingBenefit>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<GnBindingBenefit> list) {
                    Intrinsics.checkNotNullParameter(list, "");
                    OauthGrantContract.View KClassImpl$Data$declaredNonStaticMembers$2 = OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this);
                    new BindingBenefitModelMapper();
                    ArrayList arrayList = new ArrayList(list);
                    Intrinsics.checkNotNullParameter(arrayList, "");
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BindingBenefitModelMapper.KClassImpl$Data$declaredNonStaticMembers$2((GnBindingBenefit) it.next()));
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.onGetBindingBenefitsSuccess(arrayList2);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$getBindingBenefits$2
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
                    Intrinsics.checkNotNullParameter(th, "");
                    OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).onError(th.getMessage());
                }
            });
            int i = DatabaseTableConfigUtil + 31;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        int i = initRecordTimeStamp + 91;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
        try {
            this.PlaceComponentResult.dispose();
            this.MyBillsEntityDataFactory.dispose();
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
            this.scheduleImpl.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            this.moveToNextValue.dispose();
            int i3 = initRecordTimeStamp + 63;
            DatabaseTableConfigUtil = i3 % 128;
            if ((i3 % 2 == 0 ? ']' : 'X') != ']') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (((r9 | 4) == 0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        if (((r9 & 4) != 0 ? 21 : '6') != 21) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.contract.oauth.OauthGrantPresenter r4, java.lang.Throwable r5, java.lang.String r6, boolean r7, boolean r8, int r9) {
        /*
            int r0 = id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil = r1
            int r0 = r0 % 2
            r1 = 42
            r2 = 0
            if (r0 != 0) goto L11
            r0 = 0
            goto L13
        L11:
            r0 = 42
        L13:
            r3 = 1
            if (r0 == r1) goto L20
            r0 = r9 | 4
            if (r0 == 0) goto L1c
            r0 = 0
            goto L1d
        L1c:
            r0 = 1
        L1d:
            if (r0 == 0) goto L2e
            goto L2f
        L20:
            r0 = r9 & 4
            r1 = 21
            if (r0 == 0) goto L29
            r0 = 21
            goto L2b
        L29:
            r0 = 54
        L2b:
            if (r0 == r1) goto L2e
            goto L2f
        L2e:
            r7 = 0
        L2f:
            r9 = r9 & 8
            if (r9 == 0) goto L43
            int r8 = id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil
            int r8 = r8 + 81
            int r9 = r8 % 128
            id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp = r9
            int r8 = r8 % 2
            if (r8 == 0) goto L41
            r8 = 0
            goto L42
        L41:
            r8 = 1
        L42:
            r8 = 0
        L43:
            r4.getAuthRequestContext(r5, r6, r7, r8)
            int r4 = id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil
            int r4 = r4 + 95
            int r5 = r4 % 128
            id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp = r5
            int r4 = r4 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.oauth.OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.contract.oauth.OauthGrantPresenter, java.lang.Throwable, java.lang.String, boolean, boolean, int):void");
    }

    private final void getAuthRequestContext(Throwable th, String str, boolean z, boolean z2) {
        if ((th != null ? '1' : '?') != '?') {
            this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(th, str, z, z2);
        }
        if (!z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.onOauthError(null, OauthConstant.ErrorPathOauth.TRY_AGAIN);
            int i = initRecordTimeStamp + 61;
            DatabaseTableConfigUtil = i % 128;
            if (i % 2 == 0) {
                int i2 = 16 / 0;
                return;
            }
            return;
        }
        int i3 = initRecordTimeStamp + 113;
        DatabaseTableConfigUtil = i3 % 128;
        int i4 = i3 % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.onQrBindingError();
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.Presenter
    public final void getAuthRequestContext() {
        this.getAuthRequestContext.execute(new DefaultObserver<String>() { // from class: id.dana.contract.oauth.OauthGrantPresenter$getAvatarUrl$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                OauthGrantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantPresenter.this).showAvatar(str);
            }
        });
        int i = DatabaseTableConfigUtil + 101;
        initRecordTimeStamp = i % 128;
        if (!(i % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean MyBillsEntityDataFactory(id.dana.domain.authcode.AuthCodeResult r4) {
        /*
            java.lang.String r0 = r4.getSecurityId()     // Catch: java.lang.Exception -> L58
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L58
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2c
            int r0 = r0.length()
            if (r0 == 0) goto L12
            r0 = 0
            goto L13
        L12:
            r0 = 1
        L13:
            if (r0 == 0) goto L16
            goto L2c
        L16:
            int r0 = id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil
            int r0 = r0 + 125
            int r3 = r0 % 128
            id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp = r3
            int r0 = r0 % 2
            int r0 = id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil
            int r0 = r0 + 103
            int r3 = r0 % 128
            id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp = r3
            int r0 = r0 % 2
            r0 = 0
            goto L2d
        L2c:
            r0 = 1
        L2d:
            r3 = 9
            if (r0 != 0) goto L34
            r0 = 9
            goto L36
        L34:
            r0 = 21
        L36:
            if (r0 == r3) goto L3a
        L38:
            r1 = 0
            goto L57
        L3a:
            java.util.List r4 = r4.getVerificationMethods()
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L54
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L54
            int r4 = id.dana.contract.oauth.OauthGrantPresenter.initRecordTimeStamp
            int r4 = r4 + 115
            int r0 = r4 % 128
            id.dana.contract.oauth.OauthGrantPresenter.DatabaseTableConfigUtil = r0
            int r4 = r4 % 2
            r4 = 0
            goto L55
        L54:
            r4 = 1
        L55:
            if (r4 != 0) goto L38
        L57:
            return r1
        L58:
            r4 = move-exception
            goto L5b
        L5a:
            throw r4
        L5b:
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.oauth.OauthGrantPresenter.MyBillsEntityDataFactory(id.dana.domain.authcode.AuthCodeResult):boolean");
    }

    private static String BuiltInFictitiousFunctionClassFactory(String str) {
        String str2 = str;
        boolean z = false;
        if (!(str2 != null) || str2.length() == 0) {
            int i = DatabaseTableConfigUtil + 5;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            z = true;
        }
        if ((z ? 'F' : 'T') != 'T') {
            int i3 = DatabaseTableConfigUtil + 17;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            return "";
        }
        return StringsKt.replace$default(str, " ", "+", false, 4, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r18[r0.BuiltInFictitiousFunctionClassFactory] == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        if (r18[r0.BuiltInFictitiousFunctionClassFactory] == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) (((r9[r0.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
    
        r2[r0.BuiltInFictitiousFunctionClassFactory] = (char) ((r9[r0.BuiltInFictitiousFunctionClassFactory] * 2) - r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int[] r16, boolean r17, byte[] r18, java.lang.Object[] r19) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.oauth.OauthGrantPresenter.a(int[], boolean, byte[], java.lang.Object[]):void");
    }
}
