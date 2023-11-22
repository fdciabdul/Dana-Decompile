package id.dana.myprofile.settingconfig;

import android.content.Context;
import id.dana.R;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import id.dana.model.KybInfo;
import id.dana.model.KycInfo;
import id.dana.model.UserInfo;
import id.dana.myprofile.UserInfoMapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class KybSettingConfigRunner implements SettingConfigurationRunner {
    final UserInfoMapper BuiltInFictitiousFunctionClassFactory;
    private final UserRepository KClassImpl$Data$declaredNonStaticMembers$2;
    final Context PlaceComponentResult;

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public String getSettingName() {
        return "setting_kyb";
    }

    @Inject
    public KybSettingConfigRunner(UserRepository userRepository, Context context, UserInfoMapper userInfoMapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = userRepository;
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = userInfoMapper;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public Observable<SettingModel> performConfiguration(final SettingModel settingModel) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getUserInfo(true).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.KybSettingConfigRunner$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource just;
                Throwable th = (Throwable) obj;
                just = Observable.just(new UserInfoResponse());
                return just;
            }
        }).map(new Function() { // from class: id.dana.myprofile.settingconfig.KybSettingConfigRunner$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                KybSettingConfigRunner kybSettingConfigRunner = KybSettingConfigRunner.this;
                SettingModel settingModel2 = settingModel;
                UserInfo MyBillsEntityDataFactory = kybSettingConfigRunner.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory((UserInfoResponse) obj);
                if (!KybSettingConfigRunner.MyBillsEntityDataFactory(MyBillsEntityDataFactory)) {
                    kybSettingConfigRunner.getAuthRequestContext(settingModel2, MyBillsEntityDataFactory);
                } else {
                    settingModel2.setKycRevoked(true);
                    settingModel2.setKybRevoked(true);
                    settingModel2.setTitle(kybSettingConfigRunner.PlaceComponentResult.getString(R.string.kyb_apply_header));
                    settingModel2.setSubtitle(kybSettingConfigRunner.PlaceComponentResult.getString(R.string.kyb_apply_body));
                }
                return settingModel2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean MyBillsEntityDataFactory(UserInfo userInfo) {
        return userInfo == null || userInfo.DatabaseTableConfigUtil == null || userInfo.NetworkUserEntityData$$ExternalSyntheticLambda0 == null;
    }

    public final void getAuthRequestContext(SettingModel settingModel, UserInfo userInfo) {
        KycInfo kycInfo = userInfo.DatabaseTableConfigUtil;
        KybInfo kybInfo = userInfo.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str = kycInfo.PlaceComponentResult;
        settingModel.setKycRevoked(kybInfo.getAuthRequestContext(str));
        settingModel.setKybRevoked(kybInfo.getAuthRequestContext());
        settingModel.setTitle(kybInfo.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, str));
        settingModel.setSubtitle(kybInfo.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, str));
    }
}
