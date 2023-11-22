package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.nearbyme.model.ShopOpenHourModel;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/mapper/ShopOpenHourListMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/nearbyme/model/ShopOpenHour;", "Lid/dana/nearbyme/model/ShopOpenHourModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopOpenHourListMapper extends BaseMapper<List<? extends ShopOpenHour>, List<? extends ShopOpenHourModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends ShopOpenHourModel> map(List<? extends ShopOpenHour> list) {
        Object obj;
        List<? extends ShopOpenHour> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            String[] weekdays = DateFormatSymbols.getInstance(Locale.ENGLISH).getWeekdays();
            String[] weekdays2 = DateFormatSymbols.getInstance(Locale.getDefault()).getWeekdays();
            Intrinsics.checkNotNullExpressionValue(weekdays, "");
            int length = weekdays.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = weekdays[i];
                Intrinsics.checkNotNullExpressionValue(str, "");
                String str2 = str;
                if (str2.length() > 0) {
                    Iterator<T> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (StringsKt.contains((CharSequence) ((ShopOpenHour) obj).getDay(), (CharSequence) str2, true)) {
                            break;
                        }
                    }
                    ShopOpenHour shopOpenHour = (ShopOpenHour) obj;
                    if (shopOpenHour == null) {
                        shopOpenHour = new ShopOpenHour(null, 0L, 0L, 7, null);
                    }
                    String str3 = weekdays2[i2];
                    Intrinsics.checkNotNullExpressionValue(str3, "");
                    arrayList.add(new ShopOpenHourModel(str3, shopOpenHour.getOpenHour(), shopOpenHour.getCloseHour()));
                }
                i++;
                i2++;
            }
            if (Intrinsics.areEqual(((ShopOpenHourModel) CollectionsKt.first((List) arrayList)).BuiltInFictitiousFunctionClassFactory, weekdays2[1])) {
                arrayList.add((ShopOpenHourModel) CollectionsKt.removeFirst(arrayList));
            }
        }
        return arrayList;
    }

    @Inject
    public ShopOpenHourListMapper() {
    }
}
