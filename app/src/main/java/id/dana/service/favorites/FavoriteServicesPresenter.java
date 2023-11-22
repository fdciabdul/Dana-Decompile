package id.dana.service.favorites;

import id.dana.domain.DefaultObserver;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.interactor.GetFavoriteServices;
import id.dana.domain.services.interactor.SaveFavoriteServices;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.model.ThirdPartyService;
import id.dana.service.favorites.FavoriteServicesContract;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class FavoriteServicesPresenter implements FavoriteServicesContract.Presenter {
    private final ThirdPartyServicesMapper BuiltInFictitiousFunctionClassFactory;
    private final FavoriteServicesContract.View MyBillsEntityDataFactory;
    private final SaveFavoriteServices PlaceComponentResult;
    private final GetFavoriteServices getAuthRequestContext;

    @Inject
    public FavoriteServicesPresenter(FavoriteServicesContract.View view, GetFavoriteServices getFavoriteServices, SaveFavoriteServices saveFavoriteServices, ThirdPartyServicesMapper thirdPartyServicesMapper) {
        this.MyBillsEntityDataFactory = view;
        this.getAuthRequestContext = getFavoriteServices;
        this.PlaceComponentResult = saveFavoriteServices;
        this.BuiltInFictitiousFunctionClassFactory = thirdPartyServicesMapper;
    }

    @Override // id.dana.service.favorites.FavoriteServicesContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.showProgress();
        this.getAuthRequestContext.execute(new DefaultObserver<ThirdPartyCategoryService>() { // from class: id.dana.service.favorites.FavoriteServicesPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                int size;
                ThirdPartyCategoryService thirdPartyCategoryService = (ThirdPartyCategoryService) obj;
                FavoriteServicesPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                if (thirdPartyCategoryService == null || thirdPartyCategoryService.getThirdPartyServices() == null) {
                    return;
                }
                FavoriteServicesContract.View view = FavoriteServicesPresenter.this.MyBillsEntityDataFactory;
                ThirdPartyServicesMapper thirdPartyServicesMapper = FavoriteServicesPresenter.this.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
                ArrayList arrayList = new ArrayList();
                List<ThirdPartyServiceResponse> thirdPartyServices = thirdPartyCategoryService.getThirdPartyServices();
                if (thirdPartyServices != null) {
                    arrayList.add(thirdPartyServicesMapper.BuiltInFictitiousFunctionClassFactory(thirdPartyCategoryService, true));
                    List take = CollectionsKt.take(thirdPartyServices, 8);
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = take.iterator();
                    while (it.hasNext()) {
                        ThirdPartyService MyBillsEntityDataFactory = ThirdPartyServicesMapper.MyBillsEntityDataFactory((ThirdPartyServiceResponse) it.next());
                        if (MyBillsEntityDataFactory != null) {
                            arrayList2.add(MyBillsEntityDataFactory);
                        }
                    }
                    arrayList.addAll(arrayList2);
                }
                if (arrayList.size() <= 8 && (size = arrayList.size()) <= 8) {
                    while (true) {
                        ThirdPartyService.Builder builder = new ThirdPartyService.Builder();
                        builder.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = 6;
                        Intrinsics.checkNotNullParameter("", "");
                        builder.isLayoutRequested = "";
                        arrayList.add(builder.PlaceComponentResult());
                        if (size == 8) {
                            break;
                        }
                        size++;
                    }
                }
                arrayList.add(ThirdPartyServicesMapper.MyBillsEntityDataFactory());
                view.BuiltInFictitiousFunctionClassFactory(arrayList);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                FavoriteServicesPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.FAVORITE_SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.dispose();
    }

    @Override // id.dana.service.favorites.FavoriteServicesContract.Presenter
    public final void getAuthRequestContext(List<String> list) {
        if (list.size() < 7) {
            int size = list.size();
            for (int i = 0; i < 7 - size; i++) {
                list.add("");
            }
        }
        this.MyBillsEntityDataFactory.showProgress();
        this.PlaceComponentResult.execute(new DefaultObserver<Boolean>() { // from class: id.dana.service.favorites.FavoriteServicesPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                FavoriteServicesPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                FavoriteServicesPresenter.this.MyBillsEntityDataFactory.PlaceComponentResult(((Boolean) obj).booleanValue());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                FavoriteServicesPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                FavoriteServicesPresenter.this.MyBillsEntityDataFactory.PlaceComponentResult(false);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.FAVORITE_SERVICES_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
            }
        }, SaveFavoriteServices.Params.forFavoriteServices(list));
    }
}
