package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.ConfigInfoRangeDate;
import id.dana.mybills.domain.model.RangeDateConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\t\u0010\n\"\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/mybills/data/model/response/ConfigInfoRangeDateResult;", "Lid/dana/mybills/domain/model/ConfigInfoRangeDate;", "toConfigInfoRangeDate", "(Lid/dana/mybills/data/model/response/ConfigInfoRangeDateResult;)Lid/dana/mybills/domain/model/ConfigInfoRangeDate;", "", "Lid/dana/mybills/data/model/response/RangeDateConfigResult;", "Lid/dana/mybills/domain/model/RangeDateConfig;", "toListRangeDateConfig", "(Ljava/util/List;)Ljava/util/List;", "toRangeDateConfig", "(Lid/dana/mybills/data/model/response/RangeDateConfigResult;)Lid/dana/mybills/domain/model/RangeDateConfig;", "configInfoList", "Ljava/util/List;", "getConfigInfoList", "()Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfigInfoRangeDateResultKt {
    private static final List<RangeDateConfigResult> configInfoList = CollectionsKt.listOf((Object[]) new RangeDateConfigResult[]{new RangeDateConfigResult("PULSA_PREPAID", "1", "31"), new RangeDateConfigResult("BPJS", "3", "20"), new RangeDateConfigResult("INSURANCE", "6", "20"), new RangeDateConfigResult("PGN", "6", "18"), new RangeDateConfigResult("INSTALLMENT", "6", "20"), new RangeDateConfigResult("INTERNET", "1", "31"), new RangeDateConfigResult("PHONE", "6", "17"), new RangeDateConfigResult("ELECTRICITY", "1", "31"), new RangeDateConfigResult("MOBILE_POSTPAID", "1", "31"), new RangeDateConfigResult("WATER", "1", "31"), new RangeDateConfigResult("ELECTRICITY_POST", "2", "17"), new RangeDateConfigResult("GAME_VOUCHER", "1", "31")});

    public static final ConfigInfoRangeDate toConfigInfoRangeDate(ConfigInfoRangeDateResult configInfoRangeDateResult) {
        Intrinsics.checkNotNullParameter(configInfoRangeDateResult, "");
        return new ConfigInfoRangeDate(toListRangeDateConfig(configInfoRangeDateResult.getListRangeDateConfig()));
    }

    public static final List<RangeDateConfig> toListRangeDateConfig(List<RangeDateConfigResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RangeDateConfigResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRangeDateConfig((RangeDateConfigResult) it.next()));
        }
        return arrayList;
    }

    public static final RangeDateConfig toRangeDateConfig(RangeDateConfigResult rangeDateConfigResult) {
        Intrinsics.checkNotNullParameter(rangeDateConfigResult, "");
        return new RangeDateConfig(rangeDateConfigResult.getGoodsType(), rangeDateConfigResult.getDatePickerStart(), rangeDateConfigResult.getDatePickerEnd());
    }

    @JvmName(name = "getConfigInfoList")
    public static final List<RangeDateConfigResult> getConfigInfoList() {
        return configInfoList;
    }
}
