package id.dana.feeds.data.config.source.mapper;

import com.alibaba.fastjson.JSONObject;
import id.dana.data.base.BaseMapper;
import id.dana.feeds.domain.config.model.ReportReasons;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\fB\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/feeds/data/config/source/mapper/ReportReasonsConfigMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lcom/alibaba/fastjson/JSONObject;", "Lid/dana/feeds/domain/config/model/ReportReasons;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "PlaceComponentResult", "(Lcom/alibaba/fastjson/JSONObject;)Lid/dana/feeds/domain/config/model/ReportReasons;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReportReasonsConfigMapper extends BaseMapper<List<? extends JSONObject>, List<? extends ReportReasons>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends ReportReasons> map(List<? extends JSONObject> list) {
        return KClassImpl$Data$declaredNonStaticMembers$2(list);
    }

    @Inject
    public ReportReasonsConfigMapper() {
    }

    public static List<ReportReasons> KClassImpl$Data$declaredNonStaticMembers$2(List<? extends JSONObject> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = p0.iterator();
        while (it.hasNext()) {
            arrayList.add(PlaceComponentResult((JSONObject) it.next()));
        }
        return arrayList;
    }

    private static ReportReasons PlaceComponentResult(JSONObject p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = p0.getString("reason_id");
        if (string == null) {
            string = "";
        }
        String string2 = p0.getString("id");
        if (string2 == null) {
            string2 = "";
        }
        String string3 = p0.getString("en");
        return new ReportReasons(string, string2, string3 != null ? string3 : "");
    }
}
