package id.dana.myprofile.mepagerevamp.securitysettings;

import android.content.Context;
import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature;
import id.dana.domain.featureconfig.model.ResetAndChangePinNativeEntryConfig;
import id.dana.domain.passkey.model.DanaVizEntryPointConfig;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking;
import id.dana.domain.usercredential.model.QueryCredentialInfoModel;
import id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState;
import id.dana.domain.usersecurityquestions.model.SecuritySettingData;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuGroups;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuItems;
import id.dana.model.UserInfo;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001.BU\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\r\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020\u0017\u0012\u0006\u0010'\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020\u0015\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011\u0012\u0006\u0010+\u001a\u00020\u000f¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004R\u0014\u0010\n\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\f\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00140\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\b\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0018\u001a\u00020#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010$"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsPresenter;", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "getAuthRequestContext", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "MyBillsEntityDataFactory", "onDestroy", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/featureconfig/interactor/GetAuthenticationTypeFeature;", "Lid/dana/domain/featureconfig/interactor/GetAuthenticationTypeFeature;", "Ldagger/Lazy;", "Lid/dana/domain/usercredential/interactor/GetPasswordLastModifiedWithConfigChecking;", "Ldagger/Lazy;", "Lid/dana/domain/resetpin/interactor/GetResetAndChangePinNativeEntryConfig;", "Lid/dana/domain/usersecurityquestions/interactor/GetSecurityQuestionState;", "Lid/dana/domain/usersecurityquestions/interactor/GetSecurityQuestionState;", "Lid/dana/domain/user/interactor/GetUserInfo;", "scheduleImpl", "Lid/dana/domain/user/interactor/GetUserInfo;", "lookAheadTest", "Lid/dana/myprofile/UserInfoMapper;", "getErrorConfigVersion", "Lid/dana/myprofile/UserInfoMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/usersecurityquestions/model/SecuritySettingData;", "moveToNextValue", "Lid/dana/domain/DefaultObserver;", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Landroid/content/Context;Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/myprofile/UserInfoMapper;Lid/dana/domain/usersecurityquestions/interactor/GetSecurityQuestionState;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/domain/featureconfig/interactor/GetAuthenticationTypeFeature;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SecuritySettingsPresenter implements SecuritySettingsContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetAuthenticationTypeFeature KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<GetResetAndChangePinNativeEntryConfig> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetSecurityQuestionState getAuthRequestContext;
    private final Lazy<GetPasswordLastModifiedWithConfigChecking> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final UserInfoMapper NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final SecuritySettingsContract.View scheduleImpl;
    private DefaultObserver<SecuritySettingData> moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetUserInfo lookAheadTest;

    @Inject
    public SecuritySettingsPresenter(Context context, SecuritySettingsContract.View view, GetUserInfo getUserInfo, UserInfoMapper userInfoMapper, GetSecurityQuestionState getSecurityQuestionState, Lazy<GetPasswordLastModifiedWithConfigChecking> lazy, Lazy<GetResetAndChangePinNativeEntryConfig> lazy2, GetAuthenticationTypeFeature getAuthenticationTypeFeature) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        Intrinsics.checkNotNullParameter(getSecurityQuestionState, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(getAuthenticationTypeFeature, "");
        this.MyBillsEntityDataFactory = context;
        this.scheduleImpl = view;
        this.lookAheadTest = getUserInfo;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = userInfoMapper;
        this.getAuthRequestContext = getSecurityQuestionState;
        this.PlaceComponentResult = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getAuthenticationTypeFeature;
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        GetPasswordLastModifiedWithConfigChecking getPasswordLastModifiedWithConfigChecking = this.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(getPasswordLastModifiedWithConfigChecking, "");
        BaseUseCase.execute$default(getPasswordLastModifiedWithConfigChecking, new GetPasswordLastModifiedWithConfigChecking.Params(true, false), new Function1<QueryCredentialInfoModel, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsPresenter$updatePasswordLastModifiedIntoLocal$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryCredentialInfoModel queryCredentialInfoModel) {
                Intrinsics.checkNotNullParameter(queryCredentialInfoModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryCredentialInfoModel queryCredentialInfoModel) {
                invoke2(queryCredentialInfoModel);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.lookAheadTest.execute(new GetUserInfo.Param(true), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsPresenter$getUserInfoOnce$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                UserInfoMapper userInfoMapper;
                SecuritySettingsContract.View view;
                SecuritySettingsContract.View view2;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                userInfoMapper = SecuritySettingsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                UserInfo MyBillsEntityDataFactory = userInfoMapper.MyBillsEntityDataFactory(userInfoResponse);
                view = SecuritySettingsPresenter.this.scheduleImpl;
                view.setFaceLoginState(MyBillsEntityDataFactory.getPlaceComponentResult(), MyBillsEntityDataFactory.getGetAuthRequestContext(), MyBillsEntityDataFactory.getScheduleImpl());
                view2 = SecuritySettingsPresenter.this.scheduleImpl;
                view2.onGetUserInfoSuccess(MyBillsEntityDataFactory);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsPresenter$getUserInfoOnce$2
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
                SecuritySettingsContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SecuritySettingsPresenter.this.scheduleImpl;
                view.onGetUserInfoFailed();
                SecuritySettingsPresenter.PlaceComponentResult(SecuritySettingsPresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSERINFO_PREFIX, th);
            }
        });
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<ResetAndChangePinNativeEntryConfig, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsPresenter$getChangePinNativeEntryConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig) {
                invoke2(resetAndChangePinNativeEntryConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig) {
                SecuritySettingsContract.View view;
                Intrinsics.checkNotNullParameter(resetAndChangePinNativeEntryConfig, "");
                view = SecuritySettingsPresenter.this.scheduleImpl;
                view.onGetChangePinNativeEntryConfig(resetAndChangePinNativeEntryConfig.getFeatureChangePin());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsPresenter$getChangePinNativeEntryConfig$2
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
                SecuritySettingsContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SecuritySettingsPresenter.this.scheduleImpl;
                view.onGetChangePinNativeEntryConfig(false);
            }
        });
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.Presenter
    public final void getAuthRequestContext(SettingModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<DanaVizEntryPointConfig, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsPresenter$getPasskeyFeatureEnabled$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DanaVizEntryPointConfig danaVizEntryPointConfig) {
                invoke2(danaVizEntryPointConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DanaVizEntryPointConfig danaVizEntryPointConfig) {
                SecuritySettingsContract.View view;
                Intrinsics.checkNotNullParameter(danaVizEntryPointConfig, "");
                view = SecuritySettingsPresenter.this.scheduleImpl;
                view.onPasskeyFeatureEnabled(danaVizEntryPointConfig.getPasskeyEnrollment());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsPresenter$getPasskeyFeatureEnabled$2
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
                SecuritySettingsContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SecuritySettingsPresenter.this.scheduleImpl;
                view.onPasskeyFeatureEnabled(false);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.lookAheadTest.dispose();
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }

    public static final /* synthetic */ String getAuthRequestContext(SecuritySettingData securitySettingData) {
        if (securitySettingData != null && securitySettingData.getMenuData() != null && securitySettingData.getMenuData().getMenuGroups() != null) {
            SecuritySettingMenuGroups[] menuGroups = securitySettingData.getMenuData().getMenuGroups();
            Intrinsics.checkNotNullExpressionValue(menuGroups, "");
            for (SecuritySettingMenuGroups securitySettingMenuGroups : menuGroups) {
                if (securitySettingMenuGroups.getMenuItems() != null) {
                    SecuritySettingMenuItems[] menuItems = securitySettingMenuGroups.getMenuItems();
                    Intrinsics.checkNotNullExpressionValue(menuItems, "");
                    for (SecuritySettingMenuItems securitySettingMenuItems : menuItems) {
                        if (securitySettingMenuItems != null && Intrinsics.areEqual("Security Question", securitySettingMenuItems.getTitle())) {
                            return securitySettingMenuItems.getDesc();
                        }
                    }
                }
            }
        }
        return null;
    }

    public static final /* synthetic */ void PlaceComponentResult(SecuritySettingsPresenter securitySettingsPresenter, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(securitySettingsPresenter.getClass().getName());
        sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, sb.toString(), th);
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.Presenter
    public final void PlaceComponentResult() {
        DefaultObserver<SecuritySettingData> defaultObserver = this.moveToNextValue;
        if (defaultObserver != null) {
            if (defaultObserver != null) {
                defaultObserver.dispose();
            }
            this.moveToNextValue = null;
        }
        GetSecurityQuestionState getSecurityQuestionState = this.getAuthRequestContext;
        if (this.moveToNextValue == null) {
            this.moveToNextValue = new SecuritySettingsPresenter$getSecurityQuestionStateObserver$1(this);
        }
        getSecurityQuestionState.execute(this.moveToNextValue, GetSecurityQuestionState.Params.forSecurityQuestionState("1.0.0"));
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.Presenter
    public final void getAuthRequestContext() {
        DefaultObserver<SecuritySettingData> defaultObserver = this.moveToNextValue;
        if (defaultObserver != null) {
            if (defaultObserver != null) {
                defaultObserver.dispose();
            }
            this.moveToNextValue = null;
        }
        GetSecurityQuestionState getSecurityQuestionState = this.getAuthRequestContext;
        if (this.moveToNextValue == null) {
            this.moveToNextValue = new SecuritySettingsPresenter$getSecurityQuestionStateObserver$1(this);
        }
        getSecurityQuestionState.execute(this.moveToNextValue, GetSecurityQuestionState.Params.forSecurityQuestionState("1.0.0"));
    }
}
