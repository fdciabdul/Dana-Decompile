package id.dana.contract.promocenter;

import id.dana.base.AbstractContract;
import id.dana.richview.category.model.CategoryModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface PromoCategoryContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void getAuthRequestContext(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void hideShimmerView();

        void onFailGetCategories();

        void onSuccessGetCategories(long j, List<CategoryModel> list);

        void onSuccessLoadMoreCategories(long j, List<CategoryModel> list);

        void showShimmerView();
    }
}
