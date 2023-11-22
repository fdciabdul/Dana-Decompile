package id.dana.myprofile.mepagerevamp.profilesettings;

import android.content.Context;
import android.text.TextUtils;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.model.InitFeed;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.useremailaddress.interactor.GetUserEmailAddress;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.model.KycInfo;
import id.dana.model.UserInfo;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 12\u00020\u0001:\u00011BQ\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u000b\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010(\u001a\u00020\u000e\u0012\u0006\u0010)\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020\u0017\u0012\u0006\u0010,\u001a\u00020\u0013\u0012\u0006\u0010-\u001a\u00020!\u0012\u0006\u0010.\u001a\u00020\u0011¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0005\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0014\u0010\u0018\u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsPresenter;", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "onDestroy", "Ljava/io/File;", "p0", "(Ljava/io/File;)V", "Landroid/content/Context;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "PlaceComponentResult", "Lid/dana/domain/useremailaddress/interactor/GetUserEmailAddress;", "Lid/dana/domain/useremailaddress/interactor/GetUserEmailAddress;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;", "Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "getErrorConfigVersion", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "lookAheadTest", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lio/reactivex/subjects/PublishSubject;", "moveToNextValue", "Lid/dana/domain/account/interactor/UploadAvatar;", "Lid/dana/domain/account/interactor/UploadAvatar;", "Lid/dana/myprofile/UserInfoMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/myprofile/UserInfoMapper;", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;", "scheduleImpl", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroid/content/Context;Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;Lid/dana/domain/account/interactor/GetAvatarUrl;Lid/dana/domain/account/interactor/UploadAvatar;Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/myprofile/UserInfoMapper;Lid/dana/domain/useremailaddress/interactor/GetUserEmailAddress;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileSettingsPresenter implements ProfileSettingsContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetUserInfo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final InitFeedWithoutContact getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetAvatarUrl PlaceComponentResult;
    private final UserInfoMapper NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetUserEmailAddress MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final SaveShareFeedConsent lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private PublishSubject<SettingModel> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final UploadAvatar getErrorConfigVersion;
    private final ProfileSettingsContract.View scheduleImpl;

    @Inject
    public ProfileSettingsPresenter(Context context, ProfileSettingsContract.View view, GetAvatarUrl getAvatarUrl, UploadAvatar uploadAvatar, InitFeedWithoutContact initFeedWithoutContact, SaveShareFeedConsent saveShareFeedConsent, GetUserInfo getUserInfo, UserInfoMapper userInfoMapper, GetUserEmailAddress getUserEmailAddress) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getAvatarUrl, "");
        Intrinsics.checkNotNullParameter(uploadAvatar, "");
        Intrinsics.checkNotNullParameter(initFeedWithoutContact, "");
        Intrinsics.checkNotNullParameter(saveShareFeedConsent, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        Intrinsics.checkNotNullParameter(getUserEmailAddress, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.scheduleImpl = view;
        this.PlaceComponentResult = getAvatarUrl;
        this.getErrorConfigVersion = uploadAvatar;
        this.getAuthRequestContext = initFeedWithoutContact;
        this.lookAheadTest = saveShareFeedConsent;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getUserInfo;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = userInfoMapper;
        this.MyBillsEntityDataFactory = getUserEmailAddress;
        PublishSubject<SettingModel> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.moveToNextValue = PlaceComponentResult;
        Observable<SettingModel> observeOn = PlaceComponentResult.debounce(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult());
        final Function1<SettingModel, Unit> function1 = new Function1<SettingModel, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$observeShareFeedSubject$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SettingModel settingModel) {
                invoke2(settingModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SettingModel settingModel) {
                Intrinsics.checkNotNullParameter(settingModel, "");
                ProfileSettingsPresenter.getAuthRequestContext(ProfileSettingsPresenter.this, settingModel);
            }
        };
        observeOn.subscribe(new DefaultObserver<SettingModel>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$createSubscriber$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                SettingModel settingModel = (SettingModel) obj;
                Intrinsics.checkNotNullParameter(settingModel, "");
                function1.invoke(settingModel);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ProfileSettingsPresenter.PlaceComponentResult(this, DanaLogConstants.Prefix.PROFILE_UPLOADAVATARURL_PREFIX, p0);
            }
        });
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$getAvatarUrl$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ProfileSettingsContract.View view;
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                view.showAvatar(str);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                ProfileSettingsContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(p0, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                context = ProfileSettingsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onError(ErrorUtil.PlaceComponentResult(p0, context));
                ProfileSettingsPresenter.PlaceComponentResult(ProfileSettingsPresenter.this, DanaLogConstants.Prefix.PROFILE_GETAVATARURL_PREFIX, p0);
            }
        });
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.Presenter
    public final void getAuthRequestContext(File p0) {
        this.getErrorConfigVersion.execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$uploadAvatar$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ProfileSettingsContract.View view;
                InitFeedWithoutContact initFeedWithoutContact;
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                view.showAvatar(str);
                initFeedWithoutContact = ProfileSettingsPresenter.this.getAuthRequestContext;
                final ProfileSettingsPresenter profileSettingsPresenter = ProfileSettingsPresenter.this;
                Function1<InitFeed, Unit> function1 = new Function1<InitFeed, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$uploadAvatar$1$onNext$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(InitFeed initFeed) {
                        invoke2(initFeed);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(InitFeed initFeed) {
                        Intrinsics.checkNotNullParameter(initFeed, "");
                        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.PROFILE_TAG, initFeed.getStatus().toString());
                    }
                };
                final ProfileSettingsPresenter profileSettingsPresenter2 = ProfileSettingsPresenter.this;
                initFeedWithoutContact.execute(null, function1, new Function1<Exception, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$uploadAvatar$1$onNext$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                        invoke2(exc);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Exception exc) {
                        Intrinsics.checkNotNullParameter(exc, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, Reflection.getOrCreateKotlinClass(ProfileSettingsPresenter.class).getSimpleName(), exc);
                    }
                });
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                ProfileSettingsContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(p02, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                context = ProfileSettingsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onError(ErrorUtil.PlaceComponentResult(p02, context));
                ProfileSettingsPresenter.PlaceComponentResult(ProfileSettingsPresenter.this, DanaLogConstants.Prefix.PROFILE_UPLOADAVATARURL_PREFIX, p02);
            }
        }, UploadAvatar.Params.forUploadAvatar(p0));
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$getUserInfo$1
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
                ProfileSettingsContract.View view;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                userInfoMapper = ProfileSettingsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                UserInfo MyBillsEntityDataFactory = userInfoMapper.MyBillsEntityDataFactory(userInfoResponse);
                ProfileSettingsPresenter.PlaceComponentResult(ProfileSettingsPresenter.this, MyBillsEntityDataFactory);
                String str = MyBillsEntityDataFactory.GetContactSyncConfig;
                if (str != null) {
                    view = ProfileSettingsPresenter.this.scheduleImpl;
                    view.showPhoneNumber(str);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$getUserInfo$2
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
                ProfileSettingsContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                view.onGetUserInfoFailed();
                ProfileSettingsPresenter.PlaceComponentResult(ProfileSettingsPresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSERINFO_PREFIX, th);
            }
        });
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.Presenter
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$getEmailAddress$1
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
                ProfileSettingsContract.View view;
                ProfileSettingsContract.View view2;
                Intrinsics.checkNotNullParameter(str, "");
                if (!TextUtils.isEmpty(str)) {
                    view2 = ProfileSettingsPresenter.this.scheduleImpl;
                    view2.showEmailAddress(str);
                    return;
                }
                view = ProfileSettingsPresenter.this.scheduleImpl;
                view.showEmailAddressUnset();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$getEmailAddress$2
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
                ProfileSettingsContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                context = ProfileSettingsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onError(ErrorUtil.PlaceComponentResult(th, context));
                ProfileSettingsPresenter.PlaceComponentResult(ProfileSettingsPresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSEREMAILADDRESS_PREFIX, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.getErrorConfigVersion.dispose();
        this.getAuthRequestContext.dispose();
        this.lookAheadTest.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(ProfileSettingsPresenter profileSettingsPresenter, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(profileSettingsPresenter.getClass().getName());
        sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, sb.toString(), th);
    }

    public static final /* synthetic */ void PlaceComponentResult(ProfileSettingsPresenter profileSettingsPresenter, SettingModel settingModel) {
        settingModel.setShareFeed(!settingModel.isShareFeed());
        profileSettingsPresenter.scheduleImpl.toggleShareFeedConsentFailed(settingModel);
    }

    public static final /* synthetic */ void PlaceComponentResult(ProfileSettingsPresenter profileSettingsPresenter, UserInfo userInfo) {
        KycInfo kycInfo = userInfo.DatabaseTableConfigUtil;
        if (kycInfo != null) {
            profileSettingsPresenter.scheduleImpl.onUserKycInfo(kycInfo.PlaceComponentResult, userInfo.getMoveToNextValue());
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(final ProfileSettingsPresenter profileSettingsPresenter, final SettingModel settingModel) {
        profileSettingsPresenter.scheduleImpl.showProgress();
        profileSettingsPresenter.lookAheadTest.execute(Boolean.valueOf(settingModel.isShareFeed()), new Function1<Unit, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$toggleShareFeedConsent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                ProfileSettingsContract.View view;
                ProfileSettingsContract.View view2;
                Intrinsics.checkNotNullParameter(unit, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                view.toggleShareFeedConsentSuccess(settingModel);
                view2 = ProfileSettingsPresenter.this.scheduleImpl;
                view2.dismissProgress();
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsPresenter$toggleShareFeedConsent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                ProfileSettingsContract.View view;
                ProfileSettingsContract.View view2;
                Intrinsics.checkNotNullParameter(exc, "");
                view = ProfileSettingsPresenter.this.scheduleImpl;
                view.dismissProgress();
                view2 = ProfileSettingsPresenter.this.scheduleImpl;
                view2.showErrorToast();
                ProfileSettingsPresenter.PlaceComponentResult(ProfileSettingsPresenter.this, settingModel);
                ProfileSettingsPresenter.PlaceComponentResult(ProfileSettingsPresenter.this, DanaLogConstants.Prefix.PROFILE_UPLOADAVATARURL_PREFIX, exc);
            }
        });
    }
}
