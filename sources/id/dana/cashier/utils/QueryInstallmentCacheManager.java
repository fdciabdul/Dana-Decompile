package id.dana.cashier.utils;

import id.dana.cashier.model.QueryInstallmentModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0004\u001a\u00020\u0003*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\t"}, d2 = {"Lid/dana/cashier/utils/QueryInstallmentCacheManager;", "", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/lang/String;", "", "Lid/dana/cashier/model/QueryInstallmentModel;", "getAuthRequestContext", "Ljava/util/Map;", "PlaceComponentResult", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryInstallmentCacheManager {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Map<String, QueryInstallmentModel> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Map<String, QueryInstallmentModel> BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();

    public static String KClassImpl$Data$declaredNonStaticMembers$2(List<String> list) {
        String str;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!(((String) obj).length() > 0)) {
                    break;
                }
                arrayList.add(obj);
            }
            str = CollectionsKt.joinToString$default(arrayList, "_", null, null, 0, null, null, 62, null);
        } else {
            str = null;
        }
        return str == null ? "" : str;
    }
}
