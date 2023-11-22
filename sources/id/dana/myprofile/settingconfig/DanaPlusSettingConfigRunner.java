package id.dana.myprofile.settingconfig;

import android.content.Context;
import id.dana.domain.investment.AccountInvestmentStatus;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.model.UserInvestmentInfo;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.investment.model.UserInvestmentModel;
import id.dana.investment.model.UserInvestmentModelKt;
import id.dana.myprofile.mapper.InvestmentSummaryMapperKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/myprofile/settingconfig/DanaPlusSettingConfigRunner;", "Lid/dana/domain/profilemenu/settingconfig/SettingConfigurationRunner;", "", "getSettingName", "()Ljava/lang/String;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "Lio/reactivex/Observable;", "performConfiguration", "(Lid/dana/domain/profilemenu/model/SettingModel;)Lio/reactivex/Observable;", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "getAuthRequestContext", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaPlusSettingConfigRunner implements SettingConfigurationRunner {
    private final GetUserInvestmentSummary BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final String getSettingName() {
        return "setting_investment";
    }

    @Inject
    public DanaPlusSettingConfigRunner(Context context, GetUserInvestmentSummary getUserInvestmentSummary) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(getUserInvestmentSummary, "");
        this.getAuthRequestContext = context;
        this.BuiltInFictitiousFunctionClassFactory = getUserInvestmentSummary;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final Observable<SettingModel> performConfiguration(final SettingModel p0) {
        if (p0 == null) {
            Observable<SettingModel> just = Observable.just(SettingModel.empty());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<SettingModel> map = this.BuiltInFictitiousFunctionClassFactory.executeRxInBackground(GetUserInvestmentSummary.Params.INSTANCE.forDanaPlus()).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaPlusSettingConfigRunner.MyBillsEntityDataFactory((Throwable) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaPlusSettingConfigRunner.MyBillsEntityDataFactory((UserInvestmentInfo) obj);
            }
        }, new BiFunction() { // from class: id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DanaPlusSettingConfigRunner.KClassImpl$Data$declaredNonStaticMembers$2((UserInvestmentInfo) obj, (UserInvestmentModel) obj2);
            }
        }).map(new Function() { // from class: id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaPlusSettingConfigRunner.KClassImpl$Data$declaredNonStaticMembers$2(DanaPlusSettingConfigRunner.this, p0, (Pair) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(UserInvestmentInfo userInvestmentInfo) {
        Intrinsics.checkNotNullParameter(userInvestmentInfo, "");
        return Observable.just(UserInvestmentModelKt.KClassImpl$Data$declaredNonStaticMembers$2(userInvestmentInfo));
    }

    public static /* synthetic */ Pair KClassImpl$Data$declaredNonStaticMembers$2(UserInvestmentInfo userInvestmentInfo, UserInvestmentModel userInvestmentModel) {
        Intrinsics.checkNotNullParameter(userInvestmentInfo, "");
        Intrinsics.checkNotNullParameter(userInvestmentModel, "");
        return new Pair(userInvestmentInfo, userInvestmentModel);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(new UserInvestmentInfo(AccountInvestmentStatus.NOT_EXIST));
    }

    public static /* synthetic */ SettingModel KClassImpl$Data$declaredNonStaticMembers$2(DanaPlusSettingConfigRunner danaPlusSettingConfigRunner, SettingModel settingModel, Pair pair) {
        Intrinsics.checkNotNullParameter(danaPlusSettingConfigRunner, "");
        Intrinsics.checkNotNullParameter(pair, "");
        return InvestmentSummaryMapperKt.BuiltInFictitiousFunctionClassFactory((UserInvestmentModel) pair.getSecond(), danaPlusSettingConfigRunner.getAuthRequestContext, (UserInvestmentInfo) pair.getFirst(), settingModel);
    }
}
