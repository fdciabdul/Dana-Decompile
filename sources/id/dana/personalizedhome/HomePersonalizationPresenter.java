package id.dana.personalizedhome;

import android.location.Location;
import dagger.Lazy;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.geocode.interactor.GetIndoProvinceLandmark;
import id.dana.domain.geocode.mapper.ProvinceNameMapper;
import id.dana.domain.personalizedhome.GetHomeLandmarkUrl;
import id.dana.domain.personalizedhome.GetPersonalizedHomeConfig;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.personalizedhome.HomePersonalizationContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0014\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0003\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015"}, d2 = {"Lid/dana/personalizedhome/HomePersonalizationPresenter;", "Lid/dana/personalizedhome/HomePersonalizationContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "Landroid/location/Location;", "p0", "PlaceComponentResult", "(Landroid/location/Location;)V", "", "(Ljava/lang/String;)V", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/personalizedhome/GetHomeLandmarkUrl;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ldagger/Lazy;", "Lid/dana/domain/geocode/interactor/GetIndoProvinceLandmark;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/personalizedhome/GetPersonalizedHomeConfig;", "getAuthRequestContext", "Lid/dana/personalizedhome/HomePersonalizationContract$View;", "Lid/dana/personalizedhome/HomePersonalizationContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/personalizedhome/HomePersonalizationContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomePersonalizationPresenter implements HomePersonalizationContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<GetIndoProvinceLandmark> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<GetHomeLandmarkUrl> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final HomePersonalizationContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<GetPersonalizedHomeConfig> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public HomePersonalizationPresenter(HomePersonalizationContract.View view, Lazy<GetPersonalizedHomeConfig> lazy, Lazy<GetHomeLandmarkUrl> lazy2, Lazy<GetIndoProvinceLandmark> lazy3) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.PlaceComponentResult = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
    }

    @Override // id.dana.personalizedhome.HomePersonalizationContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.personalizedhome.HomePersonalizationPresenter$getHomeLandmarkSettingConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                HomePersonalizationContract.View view;
                view = HomePersonalizationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.personalizedhome.HomePersonalizationPresenter$getHomeLandmarkSettingConfig$2
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
                HomePersonalizationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = HomePersonalizationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.onError(th.getMessage());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.personalizedhome.HomePersonalizationContract.Presenter
    public final void PlaceComponentResult(Location p0) {
        ?? r6 = 0;
        this.MyBillsEntityDataFactory.get().execute(new GetIndoProvinceLandmark.Params(p0, false, new HereMixPanelTrackerData("Home Personalization", null, false, null, r6, 30, null), 2, r6), new Function1<String, Unit>() { // from class: id.dana.personalizedhome.HomePersonalizationPresenter$getIndoSubdivisionByLocation$1
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
                Intrinsics.checkNotNullParameter(str, "");
                HomePersonalizationPresenter.this.MyBillsEntityDataFactory(ProvinceNameMapper.INSTANCE.translateProvinceNameToIndonesian(str));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.personalizedhome.HomePersonalizationPresenter$getIndoSubdivisionByLocation$2
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
                HomePersonalizationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = HomePersonalizationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.personalizedhome.HomePersonalizationContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.get().execute(p0, new Function1<String, Unit>() { // from class: id.dana.personalizedhome.HomePersonalizationPresenter$getUrlBasedOnProvince$1
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
                HomePersonalizationContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = HomePersonalizationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.MyBillsEntityDataFactory(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.personalizedhome.HomePersonalizationPresenter$getUrlBasedOnProvince$2
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
                HomePersonalizationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = HomePersonalizationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.PlaceComponentResult.get().dispose();
    }
}
