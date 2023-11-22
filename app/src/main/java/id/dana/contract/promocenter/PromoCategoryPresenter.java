package id.dana.contract.promocenter;

import android.content.Context;
import id.dana.base.BasePresenter;
import id.dana.contract.promocenter.PromoCategoryContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.promocenter.interactor.GetPromoCategoryList;
import id.dana.domain.promocenter.model.PromoCategoryInfo;
import id.dana.promocenter.mapper.CategoryModelMapper;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PromoCategoryPresenter extends BasePresenter implements PromoCategoryContract.Presenter {
    private final GetPromoCategoryList BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final CategoryModelMapper MyBillsEntityDataFactory;
    private int PlaceComponentResult = 1;
    private final PromoCategoryContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public PromoCategoryPresenter(PromoCategoryContract.View view, GetPromoCategoryList getPromoCategoryList, CategoryModelMapper categoryModelMapper, Context context) {
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = getPromoCategoryList;
        this.MyBillsEntityDataFactory = categoryModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(PromoCategoryInfo promoCategoryInfo) {
        return promoCategoryInfo == null || promoCategoryInfo.getPromoCategories() == null || promoCategoryInfo.getPromoCategories().isEmpty();
    }

    static /* synthetic */ void MyBillsEntityDataFactory(PromoCategoryPresenter promoCategoryPresenter, boolean z, PromoCategoryInfo promoCategoryInfo) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(promoCategoryInfo)) {
            if (z) {
                return;
            }
            promoCategoryPresenter.getAuthRequestContext.onFailGetCategories();
        } else if (z) {
            promoCategoryPresenter.getAuthRequestContext.onSuccessLoadMoreCategories(promoCategoryInfo.getTotalCategory(), promoCategoryPresenter.MyBillsEntityDataFactory.apply(promoCategoryInfo.getPromoCategories()));
        } else {
            promoCategoryPresenter.getAuthRequestContext.onSuccessGetCategories(promoCategoryInfo.getTotalCategory(), promoCategoryPresenter.MyBillsEntityDataFactory.apply(promoCategoryInfo.getPromoCategories()));
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoCategoryPresenter promoCategoryPresenter, boolean z) {
        if (z) {
            return;
        }
        promoCategoryPresenter.getAuthRequestContext.onFailGetCategories();
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoCategoryPresenter promoCategoryPresenter, boolean z) {
        if (z) {
            promoCategoryPresenter.getAuthRequestContext.hideShimmerView();
        } else {
            promoCategoryPresenter.getAuthRequestContext.dismissProgress();
        }
    }

    @Override // id.dana.contract.promocenter.PromoCategoryContract.Presenter
    public final void getAuthRequestContext(final boolean z) {
        if (z) {
            this.getAuthRequestContext.showShimmerView();
        } else {
            this.getAuthRequestContext.showProgress();
        }
        int i = 1;
        if (z) {
            i = 1 + this.PlaceComponentResult;
            this.PlaceComponentResult = i;
        }
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<PromoCategoryInfo>() { // from class: id.dana.contract.promocenter.PromoCategoryPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                PromoCategoryPresenter.MyBillsEntityDataFactory(PromoCategoryPresenter.this, z, (PromoCategoryInfo) obj);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                PromoCategoryPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PromoCategoryPresenter.this, z);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.PROMO_CENTER_GET_CATEGORY_LIST_PREFIX, DanaLogConstants.ExceptionType.PROMO_CENTER_EXCEPTION, th);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onComplete() {
                PromoCategoryPresenter.BuiltInFictitiousFunctionClassFactory(PromoCategoryPresenter.this, z);
            }
        }, GetPromoCategoryList.Params.forGetCategory(20, this.PlaceComponentResult, z));
    }
}
