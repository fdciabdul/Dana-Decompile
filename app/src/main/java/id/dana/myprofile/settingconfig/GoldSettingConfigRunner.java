package id.dana.myprofile.settingconfig;

import android.content.Context;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.model.UserInvestmentInfo;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.investment.model.UserInvestmentModel;
import id.dana.investment.model.UserInvestmentModelKt;
import id.dana.myprofile.mapper.GoldInvestmentSummaryMapperKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/myprofile/settingconfig/GoldSettingConfigRunner;", "Lid/dana/domain/profilemenu/settingconfig/SettingConfigurationRunner;", "", "getSettingName", "()Ljava/lang/String;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "Lio/reactivex/Observable;", "performConfiguration", "(Lid/dana/domain/profilemenu/model/SettingModel;)Lio/reactivex/Observable;", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "getAuthRequestContext", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoldSettingConfigRunner implements SettingConfigurationRunner {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetUserInvestmentSummary PlaceComponentResult;

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final String getSettingName() {
        return "setting_emas";
    }

    @Inject
    public GoldSettingConfigRunner(Context context, GetUserInvestmentSummary getUserInvestmentSummary) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(getUserInvestmentSummary, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = getUserInvestmentSummary;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final Observable<SettingModel> performConfiguration(final SettingModel p0) {
        if (p0 == null) {
            Observable<SettingModel> just = Observable.just(SettingModel.empty());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<SettingModel> map = this.PlaceComponentResult.executeRxInBackground(GetUserInvestmentSummary.Params.INSTANCE.forDanaEmas()).map(new Function() { // from class: id.dana.myprofile.settingconfig.GoldSettingConfigRunner$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GoldSettingConfigRunner.PlaceComponentResult((UserInvestmentInfo) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.GoldSettingConfigRunner$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GoldSettingConfigRunner.MyBillsEntityDataFactory((Throwable) obj);
            }
        }).map(new Function() { // from class: id.dana.myprofile.settingconfig.GoldSettingConfigRunner$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GoldSettingConfigRunner.KClassImpl$Data$declaredNonStaticMembers$2(GoldSettingConfigRunner.this, p0, (UserInvestmentModel) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ SettingModel KClassImpl$Data$declaredNonStaticMembers$2(GoldSettingConfigRunner goldSettingConfigRunner, SettingModel settingModel, UserInvestmentModel userInvestmentModel) {
        Intrinsics.checkNotNullParameter(goldSettingConfigRunner, "");
        Intrinsics.checkNotNullParameter(userInvestmentModel, "");
        return GoldInvestmentSummaryMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(userInvestmentModel, goldSettingConfigRunner.BuiltInFictitiousFunctionClassFactory, settingModel);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        UserInvestmentModel.Companion companion = UserInvestmentModel.INSTANCE;
        return Observable.just(UserInvestmentModel.Companion.PlaceComponentResult());
    }

    public static /* synthetic */ UserInvestmentModel PlaceComponentResult(UserInvestmentInfo userInvestmentInfo) {
        Intrinsics.checkNotNullParameter(userInvestmentInfo, "");
        return UserInvestmentModelKt.KClassImpl$Data$declaredNonStaticMembers$2(userInvestmentInfo);
    }
}
