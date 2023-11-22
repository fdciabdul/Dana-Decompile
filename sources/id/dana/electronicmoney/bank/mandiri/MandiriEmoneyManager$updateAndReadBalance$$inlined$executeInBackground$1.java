package id.dana.electronicmoney.bank.mandiri;

import android.nfc.Tag;
import id.dana.electronicmoney.ElectronicMoneyCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u008a@¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "id/dana/electronicmoney/ElectronicMoneyCallback$executeInBackground$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1", f = "MandiriEmoneyManager.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"isoDep"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ElectronicMoneyCallback $callback$inlined;
    final /* synthetic */ String $sourceClick$inlined;
    final /* synthetic */ Tag $tag$inlined;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MandiriEmoneyManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1(Continuation continuation, Tag tag, MandiriEmoneyManager mandiriEmoneyManager, String str, ElectronicMoneyCallback electronicMoneyCallback) {
        super(2, continuation);
        this.$tag$inlined = tag;
        this.this$0 = mandiriEmoneyManager;
        this.$sourceClick$inlined = str;
        this.$callback$inlined = electronicMoneyCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1 mandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1 = new MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1(continuation, this.$tag$inlined, this.this$0, this.$sourceClick$inlined, this.$callback$inlined);
        mandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1.L$0 = obj;
        return mandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7 A[Catch: IOException -> 0x00d0, TRY_LEAVE, TryCatch #0 {IOException -> 0x00d0, blocks: (B:6:0x0014, B:18:0x007c, B:20:0x0080, B:22:0x0089, B:25:0x00c1, B:27:0x00c7, B:23:0x00a5, B:11:0x002c, B:13:0x0049, B:14:0x005f), top: B:32:0x000c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
