package id.dana.myprofile.settingconfig;

import android.content.Context;
import id.dana.R;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.domain.social.model.FeedInit;
import id.dana.feeds.domain.activation.FeedInitRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/myprofile/settingconfig/RestrictedContactConfigRunner;", "Lid/dana/domain/profilemenu/settingconfig/SettingConfigurationRunner;", "", "getSettingName", "()Ljava/lang/String;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "Lio/reactivex/Observable;", "performConfiguration", "(Lid/dana/domain/profilemenu/model/SettingModel;)Lio/reactivex/Observable;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "p1", "<init>", "(Lid/dana/feeds/domain/activation/FeedInitRepository;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RestrictedContactConfigRunner implements SettingConfigurationRunner {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedInitRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final String getSettingName() {
        return MyProfileMenuAction.SETTING_RESTRICTED_CONTACT;
    }

    @Inject
    public RestrictedContactConfigRunner(FeedInitRepository feedInitRepository, Context context) {
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedInitRepository;
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final Observable<SettingModel> performConfiguration(final SettingModel p0) {
        if (p0 == null) {
            Observable<SettingModel> just = Observable.just(SettingModel.empty());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<SettingModel> onErrorResumeNext = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0().map(new Function() { // from class: id.dana.myprofile.settingconfig.RestrictedContactConfigRunner$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RestrictedContactConfigRunner.BuiltInFictitiousFunctionClassFactory(SettingModel.this, this, (FeedInit) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.RestrictedContactConfigRunner$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RestrictedContactConfigRunner.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    public static /* synthetic */ SettingModel BuiltInFictitiousFunctionClassFactory(SettingModel settingModel, RestrictedContactConfigRunner restrictedContactConfigRunner, FeedInit feedInit) {
        Intrinsics.checkNotNullParameter(restrictedContactConfigRunner, "");
        Intrinsics.checkNotNullParameter(feedInit, "");
        settingModel.setTitle(restrictedContactConfigRunner.MyBillsEntityDataFactory.getString(R.string.restricted_contact_title));
        settingModel.setEnable(feedInit.toInitFeed().isFinished());
        settingModel.setNeedToShow(settingModel.isEnable());
        return settingModel;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(SettingModel.empty());
    }
}
