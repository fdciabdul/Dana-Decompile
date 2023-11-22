package id.dana.contract.services;

import android.content.Context;
import id.dana.contract.services.ServiceCategoryContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.services.interactor.GetCategory;
import id.dana.domain.services.model.CategoryServicesModel;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ServiceCategoryPresenter implements ServiceCategoryContract.Presenter {
    private final ServiceCategoryContract.View BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final ServiceCategoryMapper PlaceComponentResult;
    private final GetCategory getAuthRequestContext;

    @Inject
    public ServiceCategoryPresenter(ServiceCategoryContract.View view, GetCategory getCategory, ServiceCategoryMapper serviceCategoryMapper, Context context) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.getAuthRequestContext = getCategory;
        this.PlaceComponentResult = serviceCategoryMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    /* renamed from: id.dana.contract.services.ServiceCategoryPresenter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 extends DefaultObserver<List<CategoryServicesModel>> {
        final /* synthetic */ ServiceCategoryPresenter KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.dismissProgress();
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.PlaceComponentResult((List) obj));
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.dismissProgress();
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.onError(ErrorUtil.PlaceComponentResult(th, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2));
            CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.CATEGORY_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
        }
    }

    @Override // id.dana.contract.services.ServiceCategoryContract.Presenter
    public final void MyBillsEntityDataFactory(final List<String> list) {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.getAuthRequestContext.execute(new DefaultObserver<List<CategoryServicesModel>>() { // from class: id.dana.contract.services.ServiceCategoryPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                List list2 = (List) obj;
                ServiceCategoryPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    Iterator it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            CategoryServicesModel categoryServicesModel = (CategoryServicesModel) it.next();
                            if (str.equals(categoryServicesModel.getCategory())) {
                                arrayList.add(categoryServicesModel);
                                break;
                            }
                        }
                    }
                }
                ServiceCategoryPresenter.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(ServiceCategoryPresenter.this.PlaceComponentResult.PlaceComponentResult(arrayList));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                ServiceCategoryPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                ServiceCategoryPresenter.this.BuiltInFictitiousFunctionClassFactory.onError(ErrorUtil.PlaceComponentResult(th, ServiceCategoryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2));
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.CATEGORY_LIFESTYLE_PREFIX, DanaLogConstants.ExceptionType.LIFESTYLE_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
