package id.dana.riskChallenges.ui.passkey.main;

import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentPasskeyEnrollmentMainBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$observeState$1", f = "EnrollmentMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EnrollmentMainFragment$observeState$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ EnrollmentMainFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrollmentMainFragment$observeState$1(EnrollmentMainFragment enrollmentMainFragment, Continuation<? super EnrollmentMainFragment$observeState$1> continuation) {
        super(2, continuation);
        this.this$0 = enrollmentMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EnrollmentMainFragment$observeState$1 enrollmentMainFragment$observeState$1 = new EnrollmentMainFragment$observeState$1(this.this$0, continuation);
        enrollmentMainFragment$observeState$1.Z$0 = ((Boolean) obj).booleanValue();
        return enrollmentMainFragment$observeState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((EnrollmentMainFragment$observeState$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        boolean z = this.Z$0;
        VB vb = this.this$0.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentPasskeyEnrollmentMainBinding) vb).MyBillsEntityDataFactory.setEnabled(z);
            if (z) {
                VB vb2 = this.this$0.PlaceComponentResult;
                if (vb2 != 0) {
                    ((FragmentPasskeyEnrollmentMainBinding) vb2).MyBillsEntityDataFactory.setActiveButton(this.this$0.getString(R.string.passkey_activate), null);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                VB vb3 = this.this$0.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentPasskeyEnrollmentMainBinding) vb3).MyBillsEntityDataFactory.setDisabled(this.this$0.getString(R.string.passkey_activate));
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
