package id.dana.social.presenter;

import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.contract.RelationshipBottomSheetContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001"}, d2 = {"Lid/dana/social/presenter/RelationshipBottomSheetPresenter$getSearchObserver$1;", "Lid/dana/domain/DefaultObserver;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RelationshipBottomSheetPresenter$getSearchObserver$1 extends DefaultObserver<String> {
    final /* synthetic */ RelationshipBottomSheetPresenter BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RelationshipBottomSheetPresenter$getSearchObserver$1(RelationshipBottomSheetPresenter relationshipBottomSheetPresenter) {
        this.BuiltInFictitiousFunctionClassFactory = relationshipBottomSheetPresenter;
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        Lazy lazy;
        Lazy lazy2;
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, "");
        if ((!this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp.isEmpty()) == true) {
            String str2 = str;
            if (StringsKt.contains$default((CharSequence) StringsKt.trim((CharSequence) str2).toString(), (CharSequence) "*", false, 2, (Object) null)) {
                return;
            }
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) str2).toString(), "")) {
                lazy2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ((RelationshipBottomSheetContract.View) lazy2.get()).PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp);
                return;
            }
            lazy = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2;
            RelationshipBottomSheetContract.View view = (RelationshipBottomSheetContract.View) lazy.get();
            List<RelationshipItemModel> list = this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                RelationshipItemModel relationshipItemModel = (RelationshipItemModel) obj2;
                if (StringsKt.contains((CharSequence) relationshipItemModel.scheduleImpl, (CharSequence) str2, true) || StringsKt.contains((CharSequence) relationshipItemModel.initRecordTimeStamp, (CharSequence) str2, true)) {
                    arrayList.add(obj2);
                }
            }
            view.PlaceComponentResult(arrayList);
        }
    }
}
