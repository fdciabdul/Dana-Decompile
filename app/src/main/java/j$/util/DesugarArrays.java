package j$.util;

import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;

/* loaded from: classes6.dex */
public class DesugarArrays {
    public static <T> Stream<T> MyBillsEntityDataFactory(T[] tArr) {
        return StreamSupport.PlaceComponentResult(Spliterators.MyBillsEntityDataFactory(tArr, 0, tArr.length), false);
    }
}
