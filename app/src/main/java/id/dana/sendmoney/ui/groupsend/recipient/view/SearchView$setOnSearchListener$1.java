package id.dana.sendmoney.ui.groupsend.recipient.view;

import android.widget.ImageView;
import id.dana.component.utils.SizeUtil;
import id.dana.sendmoney.databinding.ViewSearchDefaultBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.recipient.view.SearchView$setOnSearchListener$1", f = "SearchView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class SearchView$setOnSearchListener$1 extends SuspendLambda implements Function2<CharSequence, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $listener;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SearchView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchView$setOnSearchListener$1(Function1<? super String, Unit> function1, SearchView searchView, Continuation<? super SearchView$setOnSearchListener$1> continuation) {
        super(2, continuation);
        this.$listener = function1;
        this.this$0 = searchView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchView$setOnSearchListener$1 searchView$setOnSearchListener$1 = new SearchView$setOnSearchListener$1(this.$listener, this.this$0, continuation);
        searchView$setOnSearchListener$1.L$0 = obj;
        return searchView$setOnSearchListener$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CharSequence charSequence, Continuation<? super Unit> continuation) {
        return ((SearchView$setOnSearchListener$1) create(charSequence, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ViewSearchDefaultBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence charSequence = (CharSequence) this.L$0;
            this.$listener.invoke(String.valueOf(charSequence));
            binding = this.this$0.getBinding();
            ImageView imageView = binding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility((charSequence == null || charSequence.length() == 0) ^ true ? 0 : 8);
            SearchView searchView = this.this$0;
            boolean z = !(charSequence == null || charSequence.length() == 0);
            searchView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setPadding(SizeUtil.PlaceComponentResult(16), SizeUtil.PlaceComponentResult(8), SizeUtil.PlaceComponentResult(r4 ? 28 : 16), SizeUtil.PlaceComponentResult(8));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
