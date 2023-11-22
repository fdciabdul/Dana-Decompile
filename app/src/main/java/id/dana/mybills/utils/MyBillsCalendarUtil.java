package id.dana.mybills.utils;

import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u0013\u0010\n\u001a\u00020\bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0017\u0010\f\u001a\u0006*\u00020\u00040\u0004X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\t"}, d2 = {"Lid/dana/mybills/utils/MyBillsCalendarUtil;", "", "Lkotlin/ranges/IntRange;", "p0", "Ljava/util/Calendar;", "MyBillsEntityDataFactory", "(Lkotlin/ranges/IntRange;)Ljava/util/Calendar;", "BuiltInFictitiousFunctionClassFactory", "", "Lkotlin/Lazy;", "getAuthRequestContext", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillsCalendarUtil {
    public static final MyBillsCalendarUtil INSTANCE = new MyBillsCalendarUtil();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Calendar>() { // from class: id.dana.mybills.utils.MyBillsCalendarUtil$today$2
        @Override // kotlin.jvm.functions.Function0
        public final Calendar invoke() {
            return Calendar.getInstance();
        }
    });

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.mybills.utils.MyBillsCalendarUtil$nextMonth$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            MyBillsCalendarUtil myBillsCalendarUtil = MyBillsCalendarUtil.INSTANCE;
            return Integer.valueOf((MyBillsCalendarUtil.KClassImpl$Data$declaredNonStaticMembers$2().get(2) + 1) % 12);
        }
    });

    private MyBillsCalendarUtil() {
    }

    public static Calendar BuiltInFictitiousFunctionClassFactory(IntRange p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Calendar calendar = Calendar.getInstance();
        int i = ((Calendar) KClassImpl$Data$declaredNonStaticMembers$2.getValue()).get(5);
        int i2 = ((Calendar) KClassImpl$Data$declaredNonStaticMembers$2.getValue()).get(5) + 1;
        if (p0.contains(i)) {
            calendar.set(5, i2);
        } else {
            calendar.set(5, p0.getFirst());
            if (i2 > p0.getLast()) {
                calendar.add(2, 1);
            }
        }
        Intrinsics.checkNotNullExpressionValue(calendar, "");
        return calendar;
    }

    public static Calendar MyBillsEntityDataFactory(IntRange p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2, ((Number) getAuthRequestContext.getValue()).intValue());
        calendar.set(1, ((Calendar) KClassImpl$Data$declaredNonStaticMembers$2.getValue()).get(1));
        calendar.set(5, p0.getLast() + 1);
        calendar.add(5, -1);
        Intrinsics.checkNotNullExpressionValue(calendar, "");
        return calendar;
    }

    public static final /* synthetic */ Calendar KClassImpl$Data$declaredNonStaticMembers$2() {
        return (Calendar) KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }
}
