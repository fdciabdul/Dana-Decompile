package id.dana.mybills.ui.model;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.R;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\n\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0010"}, d2 = {"", "T", "obj", "", "", "toMap", "(Ljava/lang/Object;)Ljava/util/Map;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Landroid/content/Context;", HummerConstants.CONTEXT, "getPaymentMethodString", "(Lid/dana/mybills/ui/model/BillPaymentStatusModel;Landroid/content/Context;)Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "toMoneyViewModel", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/mybills/ui/model/MoneyViewModel;", "(Ljava/lang/String;)Lid/dana/mybills/ui/model/MoneyViewModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BillPaymentStatusModelKt {
    public static final MoneyViewModel toMoneyViewModel(MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        return MoneyViewModel.INSTANCE.fromMoneyView(moneyView);
    }

    public static final String getPaymentMethodString(BillPaymentStatusModel billPaymentStatusModel, Context context) {
        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (Intrinsics.areEqual(billPaymentStatusModel.getPaymentMethod(), "BALANCE")) {
            String string = context.getString(R.string.my_bills_label_dana_balance);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        return "-";
    }

    public static final <T> Map<String, Object> toMap(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        Collection<KProperty1> memberProperties = KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(t.getClass()));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(memberProperties, 10)), 16));
        for (KProperty1 kProperty1 : memberProperties) {
            String name = kProperty1.getName();
            Object obj = kProperty1.get(t);
            if (obj == null) {
                obj = null;
            } else if (Reflection.getOrCreateKotlinClass(obj.getClass()).isData()) {
                obj = toMap(obj);
            }
            Pair pair = TuplesKt.to(name, obj);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public static final MoneyViewModel toMoneyViewModel(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            char charAt = str2.charAt(i);
            if (!Character.isDigit(charAt) && charAt != '.') {
                z = false;
            }
            if (z) {
                sb.append(charAt);
            }
            i++;
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        StringBuilder sb2 = new StringBuilder();
        int length2 = str2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char charAt2 = str2.charAt(i2);
            if (Character.isLetter(charAt2)) {
                sb2.append(charAt2);
            }
        }
        String obj2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        String str3 = obj2;
        if (str3.length() == 0) {
            str3 = "Rp.";
        }
        return new MoneyViewModel(obj, str3, null, 4, null);
    }
}
