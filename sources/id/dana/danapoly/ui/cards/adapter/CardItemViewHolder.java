package id.dana.danapoly.ui.cards.adapter;

import id.dana.danapoly.databinding.ViewholderCardItemBinding;
import id.dana.danapoly.ui.cards.adapter.CardListAdapter;
import id.dana.danapoly.ui.model.CardItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danapoly/ui/cards/adapter/CardItemViewHolder;", "Lid/dana/danapoly/ui/cards/adapter/CardListAdapter$BaseDanapolyCardViewHolder;", "Lid/dana/danapoly/ui/model/CardItemModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/danapoly/ui/model/CardItemModel;)V", "Lid/dana/danapoly/databinding/ViewholderCardItemBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/databinding/ViewholderCardItemBinding;", "PlaceComponentResult", "Lkotlin/Function1;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "p1", "<init>", "(Lid/dana/danapoly/databinding/ViewholderCardItemBinding;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardItemViewHolder extends CardListAdapter.BaseDanapolyCardViewHolder {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ViewholderCardItemBinding PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<CardItemModel, Unit> getAuthRequestContext;

    @Override // id.dana.danapoly.ui.cards.adapter.CardListAdapter.BaseDanapolyCardViewHolder
    public final void getAuthRequestContext(CardItemModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setCard(p0);
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setOnCardItemClicked(this.getAuthRequestContext);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CardItemViewHolder(id.dana.danapoly.databinding.ViewholderCardItemBinding r3, kotlin.jvm.functions.Function1<? super id.dana.danapoly.ui.model.CardItemModel, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r3.BuiltInFictitiousFunctionClassFactory
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            android.view.View r1 = (android.view.View) r1
            r2.<init>(r1)
            r2.PlaceComponentResult = r3
            r2.getAuthRequestContext = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.cards.adapter.CardItemViewHolder.<init>(id.dana.danapoly.databinding.ViewholderCardItemBinding, kotlin.jvm.functions.Function1):void");
    }
}
