package androidx.view;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/Rect;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$2  reason: from Kotlin metadata */
/* loaded from: classes6.dex */
final class Rect<T> implements FlowCollector {
    final /* synthetic */ Activity $getAuthRequestContext;

    @Override // kotlinx.coroutines.flow.FlowCollector
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final Object emit(android.graphics.Rect rect, Continuation<? super Unit> continuation) {
        Api26Impl.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(this.$getAuthRequestContext, rect);
        return Unit.INSTANCE;
    }
}
