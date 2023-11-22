package id.dana.savings.view;

import id.dana.savings.model.SavingCategoryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class CategorySelectorView$setupRecyclerView$1$1$1 extends FunctionReferenceImpl implements Function1<SavingCategoryModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CategorySelectorView$setupRecyclerView$1$1$1(Object obj) {
        super(1, obj, CategorySelectorView.class, "onCategorySelected", "onCategorySelected(Lid/dana/savings/model/SavingCategoryModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SavingCategoryModel savingCategoryModel) {
        invoke2(savingCategoryModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SavingCategoryModel savingCategoryModel) {
        r0.getCategorySavingSelectedSubject().onNext(Boolean.valueOf(((CategorySelectorView) this.receiver).BuiltInFictitiousFunctionClassFactory(savingCategoryModel)));
    }
}
