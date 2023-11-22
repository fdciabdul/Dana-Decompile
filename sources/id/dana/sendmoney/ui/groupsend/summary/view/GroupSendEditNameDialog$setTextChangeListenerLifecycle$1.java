package id.dana.sendmoney.ui.groupsend.summary.view;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ViewDialogEditGroupNameBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.summary.view.GroupSendEditNameDialog$setTextChangeListenerLifecycle$1", f = "GroupSendEditNameDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class GroupSendEditNameDialog$setTextChangeListenerLifecycle$1 extends SuspendLambda implements Function2<CharSequence, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GroupSendEditNameDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSendEditNameDialog$setTextChangeListenerLifecycle$1(GroupSendEditNameDialog groupSendEditNameDialog, Continuation<? super GroupSendEditNameDialog$setTextChangeListenerLifecycle$1> continuation) {
        super(2, continuation);
        this.this$0 = groupSendEditNameDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GroupSendEditNameDialog$setTextChangeListenerLifecycle$1 groupSendEditNameDialog$setTextChangeListenerLifecycle$1 = new GroupSendEditNameDialog$setTextChangeListenerLifecycle$1(this.this$0, continuation);
        groupSendEditNameDialog$setTextChangeListenerLifecycle$1.L$0 = obj;
        return groupSendEditNameDialog$setTextChangeListenerLifecycle$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CharSequence charSequence, Continuation<? super Unit> continuation) {
        return ((GroupSendEditNameDialog$setTextChangeListenerLifecycle$1) create(charSequence, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ViewDialogEditGroupNameBinding binding;
        String str;
        Context context;
        Context context2;
        ViewDialogEditGroupNameBinding binding2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence charSequence = (CharSequence) this.L$0;
            this.this$0.MyBillsEntityDataFactory = String.valueOf(charSequence);
            GroupSendEditNameDialog.access$setMaxCharCounterTextView(this.this$0);
            binding = this.this$0.getBinding();
            DanaButtonPrimaryView danaButtonPrimaryView = binding.getAuthRequestContext;
            final GroupSendEditNameDialog groupSendEditNameDialog = this.this$0;
            str = groupSendEditNameDialog.MyBillsEntityDataFactory;
            if (StringsKt.isBlank(str)) {
                danaButtonPrimaryView.setEnabled(false);
                context2 = groupSendEditNameDialog.getBinding().scheduleImpl.getContext();
                danaButtonPrimaryView.setDisabled(context2.getString(R.string.res_0x7f1313a5_securitysettingsactivity_createpinlauncher_2_2));
                binding2 = groupSendEditNameDialog.getBinding();
                Editable text = binding2.PlaceComponentResult.getText();
                if (text != null) {
                    text.clear();
                }
            } else {
                danaButtonPrimaryView.setEnabled(true);
                context = groupSendEditNameDialog.getBinding().scheduleImpl.getContext();
                danaButtonPrimaryView.setActiveButton(context.getString(R.string.res_0x7f1313a5_securitysettingsactivity_createpinlauncher_2_2), null);
                danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.GroupSendEditNameDialog$setTextChangeListenerLifecycle$1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GroupSendEditNameDialog$setTextChangeListenerLifecycle$1.m2925invokeSuspend$lambda1$lambda0(GroupSendEditNameDialog.this, view);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2925invokeSuspend$lambda1$lambda0(GroupSendEditNameDialog groupSendEditNameDialog, View view) {
        Function1 function1;
        String str;
        function1 = groupSendEditNameDialog.BuiltInFictitiousFunctionClassFactory;
        str = groupSendEditNameDialog.MyBillsEntityDataFactory;
        function1.invoke(str);
        groupSendEditNameDialog.dismiss();
    }
}
