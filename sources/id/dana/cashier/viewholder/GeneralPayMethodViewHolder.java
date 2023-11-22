package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.databinding.ItemGeneralPayMethodBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\n\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\u0012\u0010\u0013R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/viewholder/GeneralPayMethodViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemGeneralPayMethodBinding;", "Lkotlin/Function2;", "", "", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function2;", "Lkotlin/Function1;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GeneralPayMethodViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemGeneralPayMethodBinding> {
    private final Function2<Boolean, Integer, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<Integer, Unit> MyBillsEntityDataFactory;

    /* JADX WARN: Code restructure failed: missing block: B:276:0x0132, code lost:
    
        if (r9 == null) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x01ff, code lost:
    
        if (r11 == null) goto L308;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x02bb, code lost:
    
        if (r13 == null) goto L347;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x02dd, code lost:
    
        if (r13 == null) goto L347;
     */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x03e1  */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.GeneralPayMethodViewHolder.bindData(java.lang.Object):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemGeneralPayMethodBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemGeneralPayMethodBinding BuiltInFictitiousFunctionClassFactory = ItemGeneralPayMethodBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GeneralPayMethodViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r4, kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Integer, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559114(0x7f0d02ca, float:1.8743563E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r4
            r2.BuiltInFictitiousFunctionClassFactory = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.GeneralPayMethodViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2):void");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GeneralPayMethodViewHolder generalPayMethodViewHolder) {
        Intrinsics.checkNotNullParameter(generalPayMethodViewHolder, "");
        generalPayMethodViewHolder.MyBillsEntityDataFactory.invoke(Integer.valueOf(generalPayMethodViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void PlaceComponentResult(GeneralPayMethodViewHolder generalPayMethodViewHolder) {
        Intrinsics.checkNotNullParameter(generalPayMethodViewHolder, "");
        generalPayMethodViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(Boolean.valueOf(generalPayMethodViewHolder.getBinding().getAuthRequestContext.isChecked()), Integer.valueOf(generalPayMethodViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void PlaceComponentResult(boolean z, GeneralPayMethodViewHolder generalPayMethodViewHolder) {
        Intrinsics.checkNotNullParameter(generalPayMethodViewHolder, "");
        if (z) {
            generalPayMethodViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(Boolean.valueOf(generalPayMethodViewHolder.getBinding().getAuthRequestContext.isChecked()), Integer.valueOf(generalPayMethodViewHolder.getAbsoluteAdapterPosition()));
            return;
        }
        generalPayMethodViewHolder.MyBillsEntityDataFactory.invoke(Integer.valueOf(generalPayMethodViewHolder.getAbsoluteAdapterPosition()));
    }
}
