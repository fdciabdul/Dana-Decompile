package id.dana.bank;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.jakewharton.rxbinding2.widget.RxTextView;
import id.dana.databinding.ActivityAddBankBinding;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00010\u0001*\f\u0012\b\u0012\u0006*\u00020\u00010\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/reactivex/Observable;", "", BridgeDSL.INVOKE, "()Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class BankSelectorActivity$bankSelectedChangeObservable$2 extends Lambda implements Function0<Observable<Boolean>> {
    final /* synthetic */ BankSelectorActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankSelectorActivity$bankSelectedChangeObservable$2(BankSelectorActivity bankSelectorActivity) {
        super(0);
        this.this$0 = bankSelectorActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Observable<Boolean> invoke() {
        ActivityAddBankBinding binding;
        binding = this.this$0.getBinding();
        return RxTextView.textChanges(binding.MyBillsEntityDataFactory.GetContactSyncConfig).map(new Function() { // from class: id.dana.bank.BankSelectorActivity$bankSelectedChangeObservable$2$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m422invoke$lambda0;
                m422invoke$lambda0 = BankSelectorActivity$bankSelectedChangeObservable$2.m422invoke$lambda0((CharSequence) obj);
                return m422invoke$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m422invoke$lambda0(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return Boolean.valueOf(charSequence.toString().length() > 0);
    }
}
