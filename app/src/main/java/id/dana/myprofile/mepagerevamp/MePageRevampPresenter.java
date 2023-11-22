package id.dana.myprofile.mepagerevamp;

import android.content.Context;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.settingconfig.FeedSharingConfigRunner;
import id.dana.myprofile.settingconfig.NicknameChangeConfigRunner;
import id.dana.myprofile.settingconfig.RestrictedContactConfigRunner;
import id.dana.myprofile.settingconfig.SettingMoreMapper;
import id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner;
import id.dana.myprofile.settingconfig.UsernameChangeConfigRunner;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\u0006\u0010%\u001a\u00020\u0010\u0012\u0006\u0010&\u001a\u00020\r\u0012\u0006\u0010'\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020\u0015\u0012\u0006\u0010*\u001a\u00020\u001e¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0014\u0010\u000e\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0018\u001a\u00020\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001c\u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u001f\u001a\u00020!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\""}, d2 = {"Lid/dana/myprofile/mepagerevamp/MePageRevampPresenter;", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "onDestroy", "()V", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/myprofile/settingconfig/FeedSharingConfigRunner;", "getAuthRequestContext", "Lid/dana/myprofile/settingconfig/FeedSharingConfigRunner;", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "PlaceComponentResult", "Lid/dana/domain/profilemenu/interactor/GetSettingCollection;", "Lid/dana/domain/profilemenu/interactor/GetSettingCollection;", "Lid/dana/myprofile/settingconfig/NicknameChangeConfigRunner;", "Lid/dana/myprofile/settingconfig/NicknameChangeConfigRunner;", "Lid/dana/myprofile/settingconfig/RestrictedContactConfigRunner;", "scheduleImpl", "Lid/dana/myprofile/settingconfig/RestrictedContactConfigRunner;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/myprofile/settingconfig/ShareFeedSettingConfigRunner;", "getErrorConfigVersion", "Lid/dana/myprofile/settingconfig/ShareFeedSettingConfigRunner;", "Lid/dana/myprofile/settingconfig/UsernameChangeConfigRunner;", "moveToNextValue", "Lid/dana/myprofile/settingconfig/UsernameChangeConfigRunner;", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$View;", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$View;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroid/content/Context;Lid/dana/myprofile/mepagerevamp/MePageRevampContract$View;Lid/dana/domain/profilemenu/interactor/GetSettingCollection;Lid/dana/domain/account/interactor/GetAvatarUrl;Lid/dana/myprofile/settingconfig/FeedSharingConfigRunner;Lid/dana/myprofile/settingconfig/ShareFeedSettingConfigRunner;Lid/dana/myprofile/settingconfig/RestrictedContactConfigRunner;Lid/dana/myprofile/settingconfig/NicknameChangeConfigRunner;Lid/dana/myprofile/settingconfig/UsernameChangeConfigRunner;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MePageRevampPresenter implements MePageRevampContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final NicknameChangeConfigRunner getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final GetAvatarUrl PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final MePageRevampContract.View moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetSettingCollection MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedSharingConfigRunner KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final ShareFeedSettingConfigRunner scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final UsernameChangeConfigRunner getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final RestrictedContactConfigRunner NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public MePageRevampPresenter(Context context, MePageRevampContract.View view, GetSettingCollection getSettingCollection, GetAvatarUrl getAvatarUrl, FeedSharingConfigRunner feedSharingConfigRunner, ShareFeedSettingConfigRunner shareFeedSettingConfigRunner, RestrictedContactConfigRunner restrictedContactConfigRunner, NicknameChangeConfigRunner nicknameChangeConfigRunner, UsernameChangeConfigRunner usernameChangeConfigRunner) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSettingCollection, "");
        Intrinsics.checkNotNullParameter(getAvatarUrl, "");
        Intrinsics.checkNotNullParameter(feedSharingConfigRunner, "");
        Intrinsics.checkNotNullParameter(shareFeedSettingConfigRunner, "");
        Intrinsics.checkNotNullParameter(restrictedContactConfigRunner, "");
        Intrinsics.checkNotNullParameter(nicknameChangeConfigRunner, "");
        Intrinsics.checkNotNullParameter(usernameChangeConfigRunner, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.moveToNextValue = view;
        this.MyBillsEntityDataFactory = getSettingCollection;
        this.PlaceComponentResult = getAvatarUrl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedSharingConfigRunner;
        this.scheduleImpl = shareFeedSettingConfigRunner;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = restrictedContactConfigRunner;
        this.getAuthRequestContext = nicknameChangeConfigRunner;
        this.getErrorConfigVersion = usernameChangeConfigRunner;
    }

    @Override // id.dana.myprofile.mepagerevamp.MePageRevampContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.moveToNextValue.showProgress();
        GetSettingCollection getSettingCollection = this.MyBillsEntityDataFactory;
        DefaultObserver<List<? extends SettingModel>> defaultObserver = new DefaultObserver<List<? extends SettingModel>>() { // from class: id.dana.myprofile.mepagerevamp.MePageRevampPresenter$getSettingsCollection$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                MePageRevampContract.View view;
                MePageRevampContract.View view2;
                List<? extends SettingModel> list = (List) obj;
                Intrinsics.checkNotNullParameter(list, "");
                view = MePageRevampPresenter.this.moveToNextValue;
                view.dismissProgress();
                view2 = MePageRevampPresenter.this.moveToNextValue;
                view2.getAuthRequestContext(list);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                MePageRevampContract.View view;
                MePageRevampContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(p02, "");
                super.onError(p02);
                view = MePageRevampPresenter.this.moveToNextValue;
                view.dismissProgress();
                view2 = MePageRevampPresenter.this.moveToNextValue;
                context = MePageRevampPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(context));
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.scheduleImpl);
        arrayList.add(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        arrayList.add(this.KClassImpl$Data$declaredNonStaticMembers$2);
        arrayList.add(this.getAuthRequestContext);
        arrayList.add(this.getErrorConfigVersion);
        getSettingCollection.execute(defaultObserver, GetSettingCollection.Params.forGetSettingCollection(p0, arrayList, new SettingMoreMapper(this.BuiltInFictitiousFunctionClassFactory, new SettingMoreMapper.GetAvatarUrl() { // from class: id.dana.myprofile.mepagerevamp.MePageRevampPresenter$$ExternalSyntheticLambda0
            @Override // id.dana.myprofile.settingconfig.SettingMoreMapper.GetAvatarUrl
            public final void MyBillsEntityDataFactory() {
                final MePageRevampPresenter mePageRevampPresenter = MePageRevampPresenter.this;
                mePageRevampPresenter.PlaceComponentResult.execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.mepagerevamp.MePageRevampPresenter$getAvatarUrl$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj) {
                        MePageRevampContract.View view;
                        String str = (String) obj;
                        Intrinsics.checkNotNullParameter(str, "");
                        view = MePageRevampPresenter.this.moveToNextValue;
                        view.KClassImpl$Data$declaredNonStaticMembers$2(str);
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p02) {
                        MePageRevampContract.View view;
                        Context context;
                        Intrinsics.checkNotNullParameter(p02, "");
                        view = MePageRevampPresenter.this.moveToNextValue;
                        context = MePageRevampPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view.onError(ErrorUtil.PlaceComponentResult(p02, context));
                        MePageRevampPresenter.MyBillsEntityDataFactory(MePageRevampPresenter.this, DanaLogConstants.Prefix.PROFILE_GETAVATARURL_PREFIX, p02);
                    }
                });
            }
        })));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MePageRevampPresenter mePageRevampPresenter, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(mePageRevampPresenter.getClass().getName());
        sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, sb.toString(), th);
    }
}
