package id.dana.bank.contract;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.sendmoney.model.BankModel;
import id.dana.sendmoney.model.BankModelExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "it", "", BridgeDSL.INVOKE, "(Ljava/util/List;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class BankListPresenter$getTopBanks$1 extends Lambda implements Function1<List<? extends String>, Unit> {
    final /* synthetic */ List<BankModel> $$allBanks;
    final /* synthetic */ BankListPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BankListPresenter$getTopBanks$1(BankListPresenter bankListPresenter, List<? extends BankModel> list) {
        super(1);
        this.this$0 = bankListPresenter;
        this.$$allBanks = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
        invoke2((List<String>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.this$0.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(BankModelExtKt.getAuthRequestContext(this.$$allBanks, list));
    }
}
