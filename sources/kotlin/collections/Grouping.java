package kotlin.collections;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/collections/Grouping;", "T", DiskFormatter.KB, "", LottieParams.KEY_ELEMENT_ID, "keyOf", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "sourceIterator", "()Ljava/util/Iterator;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Grouping<T, K> {
    K keyOf(T element);

    Iterator<T> sourceIterator();
}
