package id.dana.electronicmoney.bank.bri;

import android.content.Intent;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.co.bri.brizzi.Brizzi;
import id.co.bri.brizzi.Callback;
import id.co.bri.brizzi.CardData;
import id.co.bri.brizzi.exception.BrizziException;
import id.dana.electronicmoney.ElectronicMoneyCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "success", "", "ex", "", BridgeDSL.INVOKE, "(ZLjava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BriBrizziManager$readBalance$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ ElectronicMoneyCallback $$callback;
    final /* synthetic */ Intent $$intent;
    final /* synthetic */ BriBrizziManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BriBrizziManager$readBalance$1(BriBrizziManager briBrizziManager, Intent intent, ElectronicMoneyCallback electronicMoneyCallback) {
        super(2);
        this.this$0 = briBrizziManager;
        this.$$intent = intent;
        this.$$callback = electronicMoneyCallback;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Unit invoke(Boolean bool, Throwable th) {
        invoke(bool.booleanValue(), th);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, Throwable th) {
        Brizzi brizzi;
        if (z) {
            brizzi = this.this$0.PlaceComponentResult;
            if (brizzi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                brizzi = null;
            }
            Intent intent = this.$$intent;
            final BriBrizziManager briBrizziManager = this.this$0;
            final ElectronicMoneyCallback electronicMoneyCallback = this.$$callback;
            brizzi.checkBalancePartner(intent, new Callback() { // from class: id.dana.electronicmoney.bank.bri.BriBrizziManager$readBalance$1.1
                @Override // id.co.bri.brizzi.Callback
                public final void onSuccess(CardData<?> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    String pendingBalance = p0.getPendingBalance();
                    if (!(pendingBalance == null || pendingBalance.length() == 0)) {
                        BriBrizziManager.PlaceComponentResult(BriBrizziManager.this);
                    }
                    BriBrizziManager.KClassImpl$Data$declaredNonStaticMembers$2(p0, electronicMoneyCallback);
                }

                @Override // id.co.bri.brizzi.Callback
                public final void onFailure(BrizziException p0) {
                    BriBrizziManager.BuiltInFictitiousFunctionClassFactory(BriBrizziManager.this, p0);
                    BuildersKt__Builders_commonKt.launch$default(r1.getAuthRequestContext, Dispatchers.getMain(), null, new BriBrizziManager$postErrorCallback$$inlined$postToUi$1(null, electronicMoneyCallback, p0, BriBrizziManager.this), 2, null);
                }
            });
            return;
        }
        BriBrizziManager briBrizziManager2 = this.this$0;
        BuildersKt__Builders_commonKt.launch$default(r0.getAuthRequestContext, Dispatchers.getMain(), null, new BriBrizziManager$postErrorCallback$$inlined$postToUi$1(null, this.$$callback, BriBrizziManager.getAuthRequestContext(th), briBrizziManager2), 2, null);
    }
}
