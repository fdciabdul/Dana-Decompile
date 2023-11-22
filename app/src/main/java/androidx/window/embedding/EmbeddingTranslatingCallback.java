package androidx.window.embedding;

import androidx.window.embedding.EmbeddingInterfaceCompat;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/window/embedding/EmbeddingTranslatingCallback;", "j$/util/function/Consumer", "", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfoList", "", "accept", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "callback", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "Landroidx/window/embedding/EmbeddingAdapter;", "adapter", "Landroidx/window/embedding/EmbeddingAdapter;", "<init>", "(Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;Landroidx/window/embedding/EmbeddingAdapter;)V", "window_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class EmbeddingTranslatingCallback implements Consumer<List<? extends androidx.window.extensions.embedding.SplitInfo>> {
    private final EmbeddingAdapter BuiltInFictitiousFunctionClassFactory;
    private final EmbeddingInterfaceCompat.EmbeddingCallbackInterface getAuthRequestContext;

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer<List<? extends androidx.window.extensions.embedding.SplitInfo>> andThen(Consumer<? super List<? extends androidx.window.extensions.embedding.SplitInfo>> consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    public EmbeddingTranslatingCallback(EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface, EmbeddingAdapter embeddingAdapter) {
        Intrinsics.checkNotNullParameter(embeddingCallbackInterface, "");
        Intrinsics.checkNotNullParameter(embeddingAdapter, "");
        this.getAuthRequestContext = embeddingCallbackInterface;
        this.BuiltInFictitiousFunctionClassFactory = embeddingAdapter;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(List<? extends androidx.window.extensions.embedding.SplitInfo> list) {
        List<? extends androidx.window.extensions.embedding.SplitInfo> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "");
        EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(list2, "");
        List<? extends androidx.window.extensions.embedding.SplitInfo> list3 = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(EmbeddingAdapter.KClassImpl$Data$declaredNonStaticMembers$2((androidx.window.extensions.embedding.SplitInfo) it.next()));
        }
        embeddingCallbackInterface.getAuthRequestContext(arrayList);
    }
}
