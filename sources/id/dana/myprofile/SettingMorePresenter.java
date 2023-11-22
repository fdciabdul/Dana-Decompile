package id.dana.myprofile;

import android.content.Context;
import android.text.TextUtils;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.model.AuthenticationTypeOption;
import id.dana.domain.autoroute.model.AutoRouteInit;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.model.InitFeed;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.useremailaddress.interactor.GetUserEmailAddress;
import id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState;
import id.dana.domain.usersecurityquestions.model.SecuritySettingData;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuGroups;
import id.dana.domain.usersecurityquestions.model.SecuritySettingMenuItems;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.model.KycInfo;
import id.dana.model.UserInfo;
import id.dana.myprofile.SettingMoreContract;
import id.dana.myprofile.settingconfig.FeedSharingConfigRunner;
import id.dana.myprofile.settingconfig.NicknameChangeConfigRunner;
import id.dana.myprofile.settingconfig.RestrictedContactConfigRunner;
import id.dana.myprofile.settingconfig.SettingMoreMapper;
import id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner;
import id.dana.myprofile.settingconfig.UsernameChangeConfigRunner;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 f2\u00020\u0001:\u0001fB\u0099\u0001\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0014\u0012\u0006\u0010S\u001a\u00020Q\u0012\u0006\u0010T\u001a\u00020I\u0012\u0006\u0010U\u001a\u00020F\u0012\u0006\u0010V\u001a\u00020>\u0012\u0006\u0010W\u001a\u000204\u0012\u0006\u0010X\u001a\u00020\u0016\u0012\u0006\u0010Y\u001a\u000202\u0012\u0006\u0010Z\u001a\u00020N\u0012\u0006\u0010[\u001a\u00020&\u0012\u0006\u0010\\\u001a\u00020\u001b\u0012\u0006\u0010]\u001a\u00020!\u0012\u0006\u0010^\u001a\u00020$\u0012\u0006\u0010_\u001a\u00020\u001d\u0012\u0006\u0010`\u001a\u000206\u0012\u0006\u0010a\u001a\u00020\u0010\u0012\u0006\u0010b\u001a\u00020\u0018\u0012\u0006\u0010c\u001a\u00020-¢\u0006\u0004\bd\u0010eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0003\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\f\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\"R\u0014\u0010\u0019\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010%R\u0014\u0010\u001e\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0012\u0010'\u001a\u00020\tX\u0096\"¢\u0006\u0006\n\u0004\b\u0006\u00101R\u0014\u0010.\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00103R\u0014\u0010*\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u00105R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020;0:8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b=\u0010?R\u001e\u00107\u001a\f\u0012\b\u0012\u0006*\u00020B0B0A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b@\u0010CR\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020F8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bM\u0010ER\u0014\u0010P\u001a\u00020N8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bH\u0010OR\u0014\u0010M\u001a\u00020Q8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bP\u0010R"}, d2 = {"Lid/dana/myprofile/SettingMorePresenter;", "Lid/dana/myprofile/SettingMoreContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "", "p0", "(Ljava/lang/String;)V", "getErrorConfigVersion", "onDestroy", "Ljava/io/File;", "(Ljava/io/File;)V", "Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;", "Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/myprofile/settingconfig/FeedSharingConfigRunner;", "Lid/dana/myprofile/settingconfig/FeedSharingConfigRunner;", "Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "Lid/dana/domain/usersecurityquestions/interactor/GetSecurityQuestionState;", "scheduleImpl", "Lid/dana/domain/usersecurityquestions/interactor/GetSecurityQuestionState;", "moveToNextValue", "Lid/dana/domain/profilemenu/interactor/GetSettingCollection;", "Lid/dana/domain/profilemenu/interactor/GetSettingCollection;", "lookAheadTest", "Lid/dana/domain/useremailaddress/interactor/GetUserEmailAddress;", "Lid/dana/domain/useremailaddress/interactor/GetUserEmailAddress;", "Lid/dana/domain/user/interactor/GetUserInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/user/interactor/GetUserInfo;", "", "initRecordTimeStamp", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;", "DatabaseTableConfigUtil", "Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;", "GetContactSyncConfig", "Ljava/lang/String;", "Lid/dana/myprofile/settingconfig/NicknameChangeConfigRunner;", "Lid/dana/myprofile/settingconfig/NicknameChangeConfigRunner;", "Lid/dana/myprofile/settingconfig/RestrictedContactConfigRunner;", "Lid/dana/myprofile/settingconfig/RestrictedContactConfigRunner;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "PrepareContext", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "newProxyInstance", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/usersecurityquestions/model/SecuritySettingData;", "()Lid/dana/domain/DefaultObserver;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/myprofile/settingconfig/ShareFeedSettingConfigRunner;", "Lid/dana/myprofile/settingconfig/ShareFeedSettingConfigRunner;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lio/reactivex/subjects/PublishSubject;", "isLayoutRequested", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/account/interactor/UploadAvatar;", "Lid/dana/domain/account/interactor/UploadAvatar;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/myprofile/UserInfoMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/myprofile/UserInfoMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/myprofile/settingconfig/UsernameChangeConfigRunner;", "Lid/dana/myprofile/settingconfig/UsernameChangeConfigRunner;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/myprofile/SettingMoreContract$View;", "Lid/dana/myprofile/SettingMoreContract$View;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "<init>", "(Landroid/content/Context;Lid/dana/myprofile/SettingMoreContract$View;Lid/dana/myprofile/UserInfoMapper;Lid/dana/domain/account/interactor/UploadAvatar;Lid/dana/myprofile/settingconfig/ShareFeedSettingConfigRunner;Lid/dana/myprofile/settingconfig/RestrictedContactConfigRunner;Lid/dana/myprofile/settingconfig/FeedSharingConfigRunner;Lid/dana/myprofile/settingconfig/NicknameChangeConfigRunner;Lid/dana/myprofile/settingconfig/UsernameChangeConfigRunner;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/domain/account/interactor/GetAvatarUrl;Lid/dana/domain/profilemenu/interactor/GetSettingCollection;Lid/dana/domain/useremailaddress/interactor/GetUserEmailAddress;Lid/dana/domain/usersecurityquestions/interactor/GetSecurityQuestionState;Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingMorePresenter implements SettingMoreContract.Presenter {
    private final FeedSharingConfigRunner BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final InitFeedWithoutContact GetContactSyncConfig;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final SettingMoreContract.View NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final NicknameChangeConfigRunner DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CompositeDisposable getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetAutoRouteInitialSetting MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final GetUserInfo scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final RestrictedContactConfigRunner initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final UserInfoMapper NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final UsernameChangeConfigRunner FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private DefaultObserver<SecuritySettingData> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final ShareFeedSettingConfigRunner NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final PublishSubject<SettingModel> PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CheckTwilioEnrollmentStatus KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final SaveShareFeedConsent newProxyInstance;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context PlaceComponentResult;
    private final GetAvatarUrl getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private DefaultObserver<Boolean> isLayoutRequested;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetUserEmailAddress NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetSettingCollection lookAheadTest;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final UploadAvatar NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetSecurityQuestionState moveToNextValue;

    @Inject
    public SettingMorePresenter(Context context, SettingMoreContract.View view, UserInfoMapper userInfoMapper, UploadAvatar uploadAvatar, ShareFeedSettingConfigRunner shareFeedSettingConfigRunner, RestrictedContactConfigRunner restrictedContactConfigRunner, FeedSharingConfigRunner feedSharingConfigRunner, NicknameChangeConfigRunner nicknameChangeConfigRunner, UsernameChangeConfigRunner usernameChangeConfigRunner, GetUserInfo getUserInfo, GetAvatarUrl getAvatarUrl, GetSettingCollection getSettingCollection, GetUserEmailAddress getUserEmailAddress, GetSecurityQuestionState getSecurityQuestionState, SaveShareFeedConsent saveShareFeedConsent, CheckTwilioEnrollmentStatus checkTwilioEnrollmentStatus, GetAutoRouteInitialSetting getAutoRouteInitialSetting, InitFeedWithoutContact initFeedWithoutContact) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        Intrinsics.checkNotNullParameter(uploadAvatar, "");
        Intrinsics.checkNotNullParameter(shareFeedSettingConfigRunner, "");
        Intrinsics.checkNotNullParameter(restrictedContactConfigRunner, "");
        Intrinsics.checkNotNullParameter(feedSharingConfigRunner, "");
        Intrinsics.checkNotNullParameter(nicknameChangeConfigRunner, "");
        Intrinsics.checkNotNullParameter(usernameChangeConfigRunner, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(getAvatarUrl, "");
        Intrinsics.checkNotNullParameter(getSettingCollection, "");
        Intrinsics.checkNotNullParameter(getUserEmailAddress, "");
        Intrinsics.checkNotNullParameter(getSecurityQuestionState, "");
        Intrinsics.checkNotNullParameter(saveShareFeedConsent, "");
        Intrinsics.checkNotNullParameter(checkTwilioEnrollmentStatus, "");
        Intrinsics.checkNotNullParameter(getAutoRouteInitialSetting, "");
        Intrinsics.checkNotNullParameter(initFeedWithoutContact, "");
        this.PlaceComponentResult = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = userInfoMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = uploadAvatar;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = shareFeedSettingConfigRunner;
        this.initRecordTimeStamp = restrictedContactConfigRunner;
        this.BuiltInFictitiousFunctionClassFactory = feedSharingConfigRunner;
        this.DatabaseTableConfigUtil = nicknameChangeConfigRunner;
        this.FragmentBottomSheetPaymentSettingBinding = usernameChangeConfigRunner;
        this.scheduleImpl = getUserInfo;
        this.getErrorConfigVersion = getAvatarUrl;
        this.lookAheadTest = getSettingCollection;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getUserEmailAddress;
        this.moveToNextValue = getSecurityQuestionState;
        this.newProxyInstance = saveShareFeedConsent;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkTwilioEnrollmentStatus;
        this.MyBillsEntityDataFactory = getAutoRouteInitialSetting;
        this.GetContactSyncConfig = initFeedWithoutContact;
        PublishSubject<SettingModel> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.PrepareContext = PlaceComponentResult;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.getAuthRequestContext = compositeDisposable;
        compositeDisposable.getAuthRequestContext(this.PrepareContext.debounce(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.myprofile.SettingMorePresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, (SettingModel) obj);
            }
        }));
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return;
        }
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<AutoRouteInit, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$getAutoSwitchInitialState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AutoRouteInit autoRouteInit) {
                invoke2(autoRouteInit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AutoRouteInit autoRouteInit) {
                SettingMoreContract.View view;
                Intrinsics.checkNotNullParameter(autoRouteInit, "");
                Boolean autorouteFeatureEnable = autoRouteInit.getAutorouteFeatureEnable();
                Boolean autorouteConfigEnable = autoRouteInit.getAutorouteConfigEnable();
                List<AuthenticationTypeOption> component4 = autoRouteInit.component4();
                boolean z = autorouteFeatureEnable != null && autorouteFeatureEnable.booleanValue();
                boolean z2 = autorouteConfigEnable != null && autorouteConfigEnable.booleanValue();
                String authenticationType = (component4 == null || component4.isEmpty()) ? null : component4.get(0).getAuthenticationType();
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.onGetAutoSwitchInitialState(z, z2, authenticationType);
                SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$getAutoSwitchInitialState$2
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
                SettingMoreContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.onGetAutoSwitchInitialState(false, false, null);
                SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.AUTO_ROUTE_INIT, th);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void getErrorConfigVersion() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.showProgress();
        this.scheduleImpl.execute(new GetUserInfo.Param(true), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$getUserInfoOnce$1
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
                SettingMoreContract.View view;
                UserInfoMapper userInfoMapper;
                SettingMoreContract.View view2;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.dismissProgress();
                userInfoMapper = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                UserInfo MyBillsEntityDataFactory = userInfoMapper.MyBillsEntityDataFactory(userInfoResponse);
                view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view2.setFaceLoginState(MyBillsEntityDataFactory.getPlaceComponentResult(), MyBillsEntityDataFactory.getGetAuthRequestContext(), MyBillsEntityDataFactory.getScheduleImpl());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$getUserInfoOnce$2
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
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.dismissProgress();
                view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view2.onGetUserInfoFailed();
                SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSERINFO_PREFIX, th);
            }
        });
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getErrorConfigVersion.execute(new SettingMorePresenter$getAvatarUrl$1(this));
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.showProgress();
        GetSettingCollection getSettingCollection = this.lookAheadTest;
        DefaultObserver<List<? extends SettingModel>> defaultObserver = new DefaultObserver<List<? extends SettingModel>>() { // from class: id.dana.myprofile.SettingMorePresenter$getSettingsCollection$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                List<? extends SettingModel> list = (List) obj;
                Intrinsics.checkNotNullParameter(list, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.dismissProgress();
                view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view2.onGetSettingCollectionSuccess(list);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(p02, "");
                super.onError(p02);
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.dismissProgress();
                view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                context = SettingMorePresenter.this.PlaceComponentResult;
                view2.onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(context));
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        arrayList.add(this.initRecordTimeStamp);
        arrayList.add(this.BuiltInFictitiousFunctionClassFactory);
        arrayList.add(this.DatabaseTableConfigUtil);
        arrayList.add(this.FragmentBottomSheetPaymentSettingBinding);
        getSettingCollection.execute(defaultObserver, GetSettingCollection.Params.forGetSettingCollection(p0, arrayList, new SettingMoreMapper(this.PlaceComponentResult, new SettingMoreMapper.GetAvatarUrl() { // from class: id.dana.myprofile.SettingMorePresenter$$ExternalSyntheticLambda0
            @Override // id.dana.myprofile.settingconfig.SettingMoreMapper.GetAvatarUrl
            public final void MyBillsEntityDataFactory() {
                SettingMorePresenter.getAuthRequestContext(SettingMorePresenter.this);
            }
        })));
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(File p0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.SettingMorePresenter$uploadAvatar$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                SettingMoreContract.View view;
                InitFeedWithoutContact initFeedWithoutContact;
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.showAvatar(str);
                initFeedWithoutContact = SettingMorePresenter.this.GetContactSyncConfig;
                final SettingMorePresenter settingMorePresenter = SettingMorePresenter.this;
                Function1<InitFeed, Unit> function1 = new Function1<InitFeed, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$uploadAvatar$1$onNext$1
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
                final SettingMorePresenter settingMorePresenter2 = SettingMorePresenter.this;
                initFeedWithoutContact.execute(null, function1, new Function1<Exception, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$uploadAvatar$1$onNext$2
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
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, SettingMorePresenter.class.getName(), exc);
                    }
                });
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                SettingMoreContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(p02, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                context = SettingMorePresenter.this.PlaceComponentResult;
                view.onError(ErrorUtil.PlaceComponentResult(p02, context));
                SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.PROFILE_UPLOADAVATARURL_PREFIX, p02);
            }
        }, UploadAvatar.Params.forUploadAvatar(p0));
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.myprofile.SettingMorePresenter$consultEnrollmentStatus$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                if (Intrinsics.areEqual(Boolean.TRUE, Boolean.valueOf(((Boolean) obj).booleanValue()))) {
                    view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    view2.onAlreadyEnrolled();
                    return;
                }
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.onUnenrolled();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                SettingMoreContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.onGetUserInfoFailed();
                SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSERINFO_PREFIX, p0);
            }
        });
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    private final DefaultObserver<SecuritySettingData> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new DefaultObserver<SecuritySettingData>() { // from class: id.dana.myprofile.SettingMorePresenter$securityQuestionStateObserver$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    SettingMoreContract.View view;
                    SettingMoreContract.View view2;
                    SecuritySettingData securitySettingData = (SecuritySettingData) obj;
                    Intrinsics.checkNotNullParameter(securitySettingData, "");
                    if (Intrinsics.areEqual("Set", SettingMorePresenter.KClassImpl$Data$declaredNonStaticMembers$2(securitySettingData))) {
                        view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                        view2.showSecurityQuestionStateOn();
                        return;
                    }
                    view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    view.showSecurityQuestionStateOff();
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    SettingMoreContract.View view;
                    Context context;
                    Intrinsics.checkNotNullParameter(p0, "");
                    view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    context = SettingMorePresenter.this.PlaceComponentResult;
                    view.onError(ErrorUtil.PlaceComponentResult(p0, context));
                    SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.PROFILE_GETSECURITYQUESTIONSTATE_PREFIX, p0);
                }
            };
        }
        DefaultObserver<SecuritySettingData> defaultObserver = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Intrinsics.checkNotNull(defaultObserver);
        return defaultObserver;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.scheduleImpl.dispose();
        this.getErrorConfigVersion.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.dispose();
        this.lookAheadTest.dispose();
        this.moveToNextValue.dispose();
        this.getAuthRequestContext.dispose();
        this.newProxyInstance.dispose();
        this.GetContactSyncConfig.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(final SettingMorePresenter settingMorePresenter, final SettingModel settingModel) {
        Intrinsics.checkNotNullParameter(settingMorePresenter, "");
        Intrinsics.checkNotNullParameter(settingModel, "");
        Intrinsics.checkNotNullParameter(settingModel, "");
        settingMorePresenter.NetworkUserEntityData$$ExternalSyntheticLambda6.showProgress();
        settingMorePresenter.newProxyInstance.execute(Boolean.valueOf(settingModel.isShareFeed()), new Function1<Unit, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$toggleShareFeedConsent$1
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
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                Intrinsics.checkNotNullParameter(unit, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.toggleShareFeedConsentSuccess(settingModel);
                view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view2.dismissProgress();
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$toggleShareFeedConsent$2
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
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                Intrinsics.checkNotNullParameter(exc, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.dismissProgress();
                view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view2.showErrorToast();
                SettingMorePresenter.PlaceComponentResult(SettingMorePresenter.this, settingModel);
                DanaLog.BuiltInFictitiousFunctionClassFactory("SettingMorePresenter", exc.getMessage(), exc);
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(SettingMorePresenter settingMorePresenter) {
        Intrinsics.checkNotNullParameter(settingMorePresenter, "");
        settingMorePresenter.getErrorConfigVersion.execute(new SettingMorePresenter$getAvatarUrl$1(settingMorePresenter));
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(SecuritySettingData securitySettingData) {
        if (securitySettingData != null && securitySettingData.getMenuData() != null && securitySettingData.getMenuData().getMenuGroups() != null) {
            SecuritySettingMenuGroups[] menuGroups = securitySettingData.getMenuData().getMenuGroups();
            Intrinsics.checkNotNullExpressionValue(menuGroups, "");
            for (SecuritySettingMenuGroups securitySettingMenuGroups : menuGroups) {
                if (securitySettingMenuGroups != null && securitySettingMenuGroups.getMenuItems() != null) {
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

    public static final /* synthetic */ void MyBillsEntityDataFactory(SettingMorePresenter settingMorePresenter, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(settingMorePresenter.getClass().getName());
        sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, sb.toString(), th);
    }

    public static final /* synthetic */ void PlaceComponentResult(SettingMorePresenter settingMorePresenter, SettingModel settingModel) {
        settingModel.setShareFeed(!settingModel.isShareFeed());
        settingMorePresenter.NetworkUserEntityData$$ExternalSyntheticLambda6.toggleShareFeedConsentFailed(settingModel);
    }

    public static final /* synthetic */ void PlaceComponentResult(SettingMorePresenter settingMorePresenter, UserInfo userInfo) {
        KycInfo kycInfo = userInfo.DatabaseTableConfigUtil;
        if (kycInfo != null) {
            settingMorePresenter.NetworkUserEntityData$$ExternalSyntheticLambda6.onUserKycInfo(kycInfo.PlaceComponentResult, userInfo.getMoveToNextValue());
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void PlaceComponentResult() {
        this.scheduleImpl.execute(new GetUserInfo.Param(true), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$userInfo$1
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
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                userInfoMapper = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                UserInfo MyBillsEntityDataFactory = userInfoMapper.MyBillsEntityDataFactory(userInfoResponse);
                SettingMorePresenter settingMorePresenter = SettingMorePresenter.this;
                String valueOf = String.valueOf(MyBillsEntityDataFactory.GetContactSyncConfig);
                Intrinsics.checkNotNullParameter(valueOf, "");
                settingMorePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = valueOf;
                SettingMorePresenter.PlaceComponentResult(SettingMorePresenter.this, MyBillsEntityDataFactory);
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                String str = MyBillsEntityDataFactory.GetContactSyncConfig;
                Intrinsics.checkNotNull(str);
                view.showPhoneNumber(str);
                view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view2.setFaceLoginState(MyBillsEntityDataFactory.getPlaceComponentResult(), MyBillsEntityDataFactory.getGetAuthRequestContext(), MyBillsEntityDataFactory.getScheduleImpl());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$userInfo$2
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
                SettingMoreContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.onGetUserInfoFailed();
                SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSERINFO_PREFIX, th);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$emailAddress$1
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
                SettingMoreContract.View view;
                SettingMoreContract.View view2;
                Intrinsics.checkNotNullParameter(str, "");
                if (!TextUtils.isEmpty(str)) {
                    view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    view2.showEmailAddress(str);
                    return;
                }
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                view.showEmailAddressUnset();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.SettingMorePresenter$emailAddress$2
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
                SettingMoreContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                context = SettingMorePresenter.this.PlaceComponentResult;
                view.onError(ErrorUtil.PlaceComponentResult(th, context));
                SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSEREMAILADDRESS_PREFIX, th);
            }
        });
        Unit unit2 = Unit.INSTANCE;
        DefaultObserver<SecuritySettingData> defaultObserver = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (defaultObserver != null) {
            if (defaultObserver != null) {
                defaultObserver.dispose();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
        }
        this.moveToNextValue.execute(NetworkUserEntityData$$ExternalSyntheticLambda0(), GetSecurityQuestionState.Params.forSecurityQuestionState("1.0.0"));
        DefaultObserver<Boolean> defaultObserver2 = this.isLayoutRequested;
        if (defaultObserver2 != null) {
            if (defaultObserver2 != null) {
                defaultObserver2.dispose();
            }
            this.isLayoutRequested = null;
        }
        CheckTwilioEnrollmentStatus checkTwilioEnrollmentStatus = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (this.isLayoutRequested == null) {
            this.isLayoutRequested = new DefaultObserver<Boolean>() { // from class: id.dana.myprofile.SettingMorePresenter$getTrustedDeviceObserver$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    SettingMoreContract.View view;
                    SettingMoreContract.View view2;
                    if (Intrinsics.areEqual(Boolean.TRUE, Boolean.valueOf(((Boolean) obj).booleanValue()))) {
                        view2 = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                        view2.showTrustedDevice();
                        return;
                    }
                    view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    view.showTrustedDeviceUnset();
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    SettingMoreContract.View view;
                    Intrinsics.checkNotNullParameter(p0, "");
                    view = SettingMorePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    view.onGetUserInfoFailed();
                    SettingMorePresenter.MyBillsEntityDataFactory(SettingMorePresenter.this, DanaLogConstants.Prefix.PROFILE_GETUSERINFO_PREFIX, p0);
                }
            };
        }
        checkTwilioEnrollmentStatus.execute(this.isLayoutRequested);
        Unit unit3 = Unit.INSTANCE;
    }

    @Override // id.dana.myprofile.SettingMoreContract.Presenter
    public final void getAuthRequestContext() {
        DefaultObserver<SecuritySettingData> defaultObserver = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (defaultObserver != null) {
            if (defaultObserver != null) {
                defaultObserver.dispose();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
        }
        this.moveToNextValue.execute(NetworkUserEntityData$$ExternalSyntheticLambda0(), GetSecurityQuestionState.Params.forSecurityQuestionState("1.0.0"));
    }
}
