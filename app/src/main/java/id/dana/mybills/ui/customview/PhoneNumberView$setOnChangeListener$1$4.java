package id.dana.mybills.ui.customview;

import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewCustomEditTextMyBillsBinding;
import id.dana.mybills.utils.PhoneNumberValidation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/utils/PhoneNumberValidation;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$1$4", f = "PhoneNumberView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
public final class PhoneNumberView$setOnChangeListener$1$4 extends SuspendLambda implements Function2<PhoneNumberValidation, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<String, String, Unit> $listener;
    final /* synthetic */ ViewCustomEditTextMyBillsBinding $this_with;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PhoneNumberView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PhoneNumberView$setOnChangeListener$1$4(ViewCustomEditTextMyBillsBinding viewCustomEditTextMyBillsBinding, PhoneNumberView phoneNumberView, Function2<? super String, ? super String, Unit> function2, Continuation<? super PhoneNumberView$setOnChangeListener$1$4> continuation) {
        super(2, continuation);
        this.$this_with = viewCustomEditTextMyBillsBinding;
        this.this$0 = phoneNumberView;
        this.$listener = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PhoneNumberView$setOnChangeListener$1$4 phoneNumberView$setOnChangeListener$1$4 = new PhoneNumberView$setOnChangeListener$1$4(this.$this_with, this.this$0, this.$listener, continuation);
        phoneNumberView$setOnChangeListener$1$4.L$0 = obj;
        return phoneNumberView$setOnChangeListener$1$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PhoneNumberValidation phoneNumberValidation, Continuation<? super Unit> continuation) {
        return ((PhoneNumberView$setOnChangeListener$1$4) create(phoneNumberValidation, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ViewCustomEditTextMyBillsBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PhoneNumberValidation phoneNumberValidation = (PhoneNumberValidation) this.L$0;
            AppCompatImageView appCompatImageView = this.$this_with.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            String str = phoneNumberValidation.MyBillsEntityDataFactory;
            appCompatImageView2.setVisibility((str == null || str.length() == 0) ^ true ? 0 : 8);
            ImageView imageView = this.$this_with.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility(0);
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(this.$this_with.lookAheadTest.getContext()).getAuthRequestContext(phoneNumberValidation.MyBillsEntityDataFactory).MyBillsEntityDataFactory((ImageView) this.$this_with.KClassImpl$Data$declaredNonStaticMembers$2);
            PhoneNumberView phoneNumberView = this.this$0;
            String str2 = phoneNumberValidation.MyBillsEntityDataFactory;
            boolean z = str2 == null || str2.length() == 0;
            binding = this.this$0.getBinding();
            phoneNumberView.setErrorMessage(z, binding.lookAheadTest.getContext().getString(R.string.my_bills_label_incorrect_phone_number));
            Function2<String, String, Unit> function2 = this.$listener;
            String str3 = phoneNumberValidation.BuiltInFictitiousFunctionClassFactory;
            String str4 = phoneNumberValidation.PlaceComponentResult;
            function2.invoke(str3, str4 != null ? str4 : "");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
