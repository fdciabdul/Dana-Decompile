package id.dana.savings.mapper;

import id.dana.domain.saving.model.SavingCategory;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.savings.model.SavingCategoryModelKt;
import id.dana.savings.model.SavingModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/domain/saving/model/SavingGoalView;", "Lid/dana/savings/model/SavingModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/saving/model/SavingGoalView;)Lid/dana/savings/model/SavingModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingModelMapperKt {
    public static final List<SavingModel> KClassImpl$Data$declaredNonStaticMembers$2(List<SavingGoalView> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SavingGoalView> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(BuiltInFictitiousFunctionClassFactory((SavingGoalView) it.next()));
        }
        return arrayList;
    }

    public static final SavingModel BuiltInFictitiousFunctionClassFactory(SavingGoalView savingGoalView) {
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        String savingId = savingGoalView.getSavingId();
        String title = savingGoalView.getTitle();
        String categoryCode = savingGoalView.getCategoryCode();
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult = MoneyViewModel.Companion.PlaceComponentResult(savingGoalView.getCurrentAmount());
        MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult2 = MoneyViewModel.Companion.PlaceComponentResult(savingGoalView.getTargetAmount());
        String orderStatus = savingGoalView.getOrderStatus();
        String orderSubStatus = savingGoalView.getOrderSubStatus();
        String createdTime = savingGoalView.getCreatedTime();
        String achievedTime = savingGoalView.getAchievedTime();
        String completedTime = savingGoalView.getCompletedTime();
        SavingCategory savingCategory = savingGoalView.getSavingCategory();
        return new SavingModel(savingId, title, categoryCode, PlaceComponentResult, PlaceComponentResult2, orderStatus, orderSubStatus, createdTime, achievedTime, completedTime, savingCategory != null ? SavingCategoryModelKt.getAuthRequestContext(savingCategory) : null, savingGoalView.getExtendInfo(), false, 4096, null);
    }
}
