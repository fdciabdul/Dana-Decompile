package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.sendmoney.databinding.ItemDefaultFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B,\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\u001b\b\u0002\u0010\r\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u0005\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00040\u0007X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/AddressFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/DefaultFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddressFormViewHolder extends DefaultFormViewHolder {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Function1<Integer, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.DefaultFormViewHolder, id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        getAuthRequestContext(globalSendFormModel);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.AddressFormViewHolder$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        public final void invoke(int i) {
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AddressFormViewHolder(ItemDefaultFormBinding itemDefaultFormBinding, Function1<? super Integer, Unit> function1) {
        super(itemDefaultFormBinding, 5, 0, false, 0, 28, null);
        Intrinsics.checkNotNullParameter(itemDefaultFormBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.DefaultFormViewHolder
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final void getAuthRequestContext(GlobalSendFormModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.getAuthRequestContext(p0);
        ((ItemDefaultFormBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.setOnImeButtonClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.AddressFormViewHolder$bindData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AddressFormViewHolder.this.BuiltInFictitiousFunctionClassFactory.invoke(Integer.valueOf(AddressFormViewHolder.this.getBindingAdapterPosition()));
            }
        });
    }
}
