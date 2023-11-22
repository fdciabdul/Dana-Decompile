package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.RelationshipBottomSheetContract;

/* loaded from: classes5.dex */
public final class RelationshipBottomSheetModule_ProvideViewFactory implements Factory<RelationshipBottomSheetContract.View> {
    private final RelationshipBottomSheetModule getAuthRequestContext;

    private RelationshipBottomSheetModule_ProvideViewFactory(RelationshipBottomSheetModule relationshipBottomSheetModule) {
        this.getAuthRequestContext = relationshipBottomSheetModule;
    }

    public static RelationshipBottomSheetModule_ProvideViewFactory PlaceComponentResult(RelationshipBottomSheetModule relationshipBottomSheetModule) {
        return new RelationshipBottomSheetModule_ProvideViewFactory(relationshipBottomSheetModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RelationshipBottomSheetContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getMyBillsEntityDataFactory());
    }
}
