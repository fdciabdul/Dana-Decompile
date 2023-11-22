package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.presenter.RelationshipBottomSheetPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RelationshipBottomSheetModule_ProvidePresenterFactory implements Factory<RelationshipBottomSheetContract.Presenter> {
    private final Provider<RelationshipBottomSheetPresenter> BuiltInFictitiousFunctionClassFactory;
    private final RelationshipBottomSheetModule PlaceComponentResult;

    public static RelationshipBottomSheetContract.Presenter MyBillsEntityDataFactory(RelationshipBottomSheetModule relationshipBottomSheetModule, RelationshipBottomSheetPresenter relationshipBottomSheetPresenter) {
        return (RelationshipBottomSheetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(relationshipBottomSheetModule.BuiltInFictitiousFunctionClassFactory(relationshipBottomSheetPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RelationshipBottomSheetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
