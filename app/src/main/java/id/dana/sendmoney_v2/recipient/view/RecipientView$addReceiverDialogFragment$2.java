package id.dana.sendmoney_v2.recipient.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.sendmoney.bank.AddReceiverDialogFragment;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/sendmoney/bank/AddReceiverDialogFragment;", BridgeDSL.INVOKE, "()Lid/dana/sendmoney/bank/AddReceiverDialogFragment;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientView$addReceiverDialogFragment$2 extends Lambda implements Function0<AddReceiverDialogFragment> {
    final /* synthetic */ RecipientView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecipientView$addReceiverDialogFragment$2(RecipientView recipientView) {
        super(0);
        this.this$0 = recipientView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AddReceiverDialogFragment invoke() {
        AddReceiverDialogFragment addReceiverDialogFragment = new AddReceiverDialogFragment();
        final RecipientView recipientView = this.this$0;
        addReceiverDialogFragment.scheduleImpl = new AddReceiverDialogFragment.OnAddReceiverInformation() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$addReceiverDialogFragment$2$$ExternalSyntheticLambda0
            @Override // id.dana.sendmoney.bank.AddReceiverDialogFragment.OnAddReceiverInformation
            public final void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel) {
                RecipientView$addReceiverDialogFragment$2.m2939invoke$lambda1$lambda0(RecipientView.this, recipientModel);
            }
        };
        return addReceiverDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2939invoke$lambda1$lambda0(RecipientView recipientView, RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        BaseRecipientListener recipientSelectedListener = recipientView.getRecipientSelectedListener();
        if (recipientSelectedListener != null) {
            recipientSelectedListener.onRecipientSelected(recipientModel);
        }
    }
}
