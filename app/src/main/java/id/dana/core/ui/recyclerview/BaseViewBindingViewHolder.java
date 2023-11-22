package id.dana.core.ui.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;I)V", "Lkotlin/Function2;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function2;", "PlaceComponentResult", "Landroidx/viewbinding/ViewBinding;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/viewbinding/ViewBinding;", "<init>", "(Landroidx/viewbinding/ViewBinding;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseViewBindingViewHolder<T> extends RecyclerView.ViewHolder {
    private final ViewBinding BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function2<T, Integer, Unit> PlaceComponentResult;

    public /* synthetic */ BaseViewBindingViewHolder(ViewBinding viewBinding, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewBinding, (i & 2) != 0 ? new Function2<T, Integer, Unit>() { // from class: id.dana.core.ui.recyclerview.BaseViewBindingViewHolder.1
            public final void invoke(T t, int i2) {
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Object obj, Integer num) {
                invoke((AnonymousClass1) obj, num.intValue());
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseViewBindingViewHolder(ViewBinding viewBinding, Function2<? super T, ? super Integer, Unit> function2) {
        super(viewBinding.KClassImpl$Data$declaredNonStaticMembers$2());
        Intrinsics.checkNotNullParameter(viewBinding, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.BuiltInFictitiousFunctionClassFactory = viewBinding;
        this.PlaceComponentResult = function2;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseViewBindingViewHolder baseViewBindingViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(baseViewBindingViewHolder, "");
        if (baseViewBindingViewHolder.getAbsoluteAdapterPosition() >= 0) {
            baseViewBindingViewHolder.PlaceComponentResult.invoke(obj, Integer.valueOf(baseViewBindingViewHolder.getAbsoluteAdapterPosition()));
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(final T p0, int p1) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.recyclerview.BaseViewBindingViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseViewBindingViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(BaseViewBindingViewHolder.this, p0);
            }
        });
    }
}
