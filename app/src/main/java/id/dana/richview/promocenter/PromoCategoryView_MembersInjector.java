package id.dana.richview.promocenter;

import dagger.MembersInjector;
import id.dana.contract.promocenter.PromoCategoryContract;

/* loaded from: classes5.dex */
public final class PromoCategoryView_MembersInjector implements MembersInjector<PromoCategoryView> {
    public static void PlaceComponentResult(PromoCategoryView promoCategoryView, PromoCategoryContract.Presenter presenter) {
        promoCategoryView.promoCategoryPresenter = presenter;
    }
}
