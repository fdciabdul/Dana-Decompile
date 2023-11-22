package id.dana.myprofile.settingconfig;

import android.content.Context;
import id.dana.R;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/myprofile/settingconfig/NicknameChangeConfigRunner;", "Lid/dana/domain/profilemenu/settingconfig/SettingConfigurationRunner;", "", "getSettingName", "()Ljava/lang/String;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "Lio/reactivex/Observable;", "performConfiguration", "(Lid/dana/domain/profilemenu/model/SettingModel;)Lio/reactivex/Observable;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "PlaceComponentResult", "Lid/dana/domain/user/repository/UserRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/user/repository/UserRepository;", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/domain/user/repository/UserRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NicknameChangeConfigRunner implements SettingConfigurationRunner {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeatureConfigRepository PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final UserRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final String getSettingName() {
        return "setting_change_name";
    }

    @Inject
    public NicknameChangeConfigRunner(Context context, UserRepository userRepository, FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = userRepository;
        this.PlaceComponentResult = featureConfigRepository;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final Observable<SettingModel> performConfiguration(final SettingModel p0) {
        if (p0 == null) {
            Observable<SettingModel> just = Observable.just(SettingModel.empty());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<SettingModel> onErrorResumeNext = this.KClassImpl$Data$declaredNonStaticMembers$2.getUserInfo(true).flatMap(new Function() { // from class: id.dana.myprofile.settingconfig.NicknameChangeConfigRunner$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NicknameChangeConfigRunner.MyBillsEntityDataFactory(NicknameChangeConfigRunner.this, p0, (UserInfoResponse) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.NicknameChangeConfigRunner$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NicknameChangeConfigRunner.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(SettingModel.empty());
    }

    public static /* synthetic */ SettingModel MyBillsEntityDataFactory(SettingModel settingModel, UserInfoResponse userInfoResponse, NicknameChangeConfigRunner nicknameChangeConfigRunner, Boolean bool) {
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        Intrinsics.checkNotNullParameter(nicknameChangeConfigRunner, "");
        Intrinsics.checkNotNullParameter(bool, "");
        settingModel.setNeedToShow(true);
        settingModel.setEnable(true);
        settingModel.setSubtitle(userInfoResponse.getNickname());
        if (userInfoResponse.isPremiumUser()) {
            settingModel.setTitle(nicknameChangeConfigRunner.BuiltInFictitiousFunctionClassFactory.getString(R.string.change_name));
            settingModel.setViewType(4);
        } else {
            settingModel.setTitle(nicknameChangeConfigRunner.BuiltInFictitiousFunctionClassFactory.getString(R.string.change_name_non_kyc));
            settingModel.setViewType(2);
        }
        if (bool.booleanValue() && !userInfoResponse.isPremiumUser()) {
            settingModel.setNeedToShow(false);
            settingModel.setEnable(false);
        }
        return settingModel;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final NicknameChangeConfigRunner nicknameChangeConfigRunner, final SettingModel settingModel, final UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(nicknameChangeConfigRunner, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return nicknameChangeConfigRunner.PlaceComponentResult.isChangeUsernameEnabled().map(new Function() { // from class: id.dana.myprofile.settingconfig.NicknameChangeConfigRunner$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NicknameChangeConfigRunner.MyBillsEntityDataFactory(SettingModel.this, userInfoResponse, nicknameChangeConfigRunner, (Boolean) obj);
            }
        });
    }
}
