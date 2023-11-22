package id.dana.sendmoney.ui.globalsend.form.model.common;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012$\u0010\r\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\u00070\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R/\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\u00070\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/common/FormValidatorModel;", "", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "MyBillsEntityDataFactory", "", "Lkotlin/Function1;", "", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FormValidatorModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Map<String, String> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Map<String, List<Function1<String, Boolean>>> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public FormValidatorModel(Map<String, String> map, Map<String, ? extends List<? extends Function1<? super String, Boolean>>> map2) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(map2, "");
        this.MyBillsEntityDataFactory = map;
        this.BuiltInFictitiousFunctionClassFactory = map2;
    }
}
