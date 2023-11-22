package id.dana.sendmoney.ui.globalsend.form.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemSimpleFormOptionBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B*\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0019\u0010\r\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/SimpleFormOptionViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemSimpleFormOptionBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemSimpleFormOptionBinding;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SimpleFormOptionViewHolder extends BaseGlobalSendFormViewHolder<ItemSimpleFormOptionBinding, GlobalSendFormOptionModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<GlobalSendFormOptionModel, Unit> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleFormOptionViewHolder(ItemSimpleFormOptionBinding itemSimpleFormOptionBinding, Function1<? super GlobalSendFormOptionModel, Unit> function1) {
        super(itemSimpleFormOptionBinding);
        Intrinsics.checkNotNullParameter(itemSimpleFormOptionBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = function1;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/SimpleFormOptionViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemSimpleFormOptionBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemSimpleFormOptionBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemSimpleFormOptionBinding KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemSimpleFormOptionBinding PlaceComponentResult = ItemSimpleFormOptionBinding.PlaceComponentResult(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            return PlaceComponentResult;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(SimpleFormOptionViewHolder simpleFormOptionViewHolder, GlobalSendFormOptionModel globalSendFormOptionModel) {
        Intrinsics.checkNotNullParameter(simpleFormOptionViewHolder, "");
        Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
        simpleFormOptionViewHolder.MyBillsEntityDataFactory.invoke(globalSendFormOptionModel);
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final void getAuthRequestContext(final GlobalSendFormOptionModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ((ItemSimpleFormOptionBinding) this.MyBillsEntityDataFactory).getAuthRequestContext.setText(p0.BuiltInFictitiousFunctionClassFactory);
        ((ItemSimpleFormOptionBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory.setBackgroundResource(p0.getKClassImpl$Data$declaredNonStaticMembers$2() ? R.color.KClassImpl$Data$declaredNonStaticMembers$2 : R.color.moveToNextValue);
        ((ItemSimpleFormOptionBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.SimpleFormOptionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleFormOptionViewHolder.PlaceComponentResult(SimpleFormOptionViewHolder.this, p0);
            }
        });
    }
}
