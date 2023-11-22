package id.dana.data.webviewinterceptor.model;

import id.dana.domain.webviewinterceptor.model.WebviewInterceptorData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/data/webviewinterceptor/model/WebviewInterceptorEntity;", "Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebviewInterceptorEntityKt {
    public static final List<WebviewInterceptorData> BuiltInFictitiousFunctionClassFactory(List<WebviewInterceptorEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<WebviewInterceptorEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (WebviewInterceptorEntity webviewInterceptorEntity : list2) {
            Intrinsics.checkNotNullParameter(webviewInterceptorEntity, "");
            String str = webviewInterceptorEntity.PlaceComponentResult;
            if (str == null) {
                str = "";
            }
            String str2 = webviewInterceptorEntity.MyBillsEntityDataFactory;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = webviewInterceptorEntity.BuiltInFictitiousFunctionClassFactory;
            if (str3 == null) {
                str3 = "";
            }
            arrayList.add(new WebviewInterceptorData(str, str2, str3));
        }
        return arrayList;
    }
}
