package id.dana.cashier.utils;

import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b"}, d2 = {"Lid/dana/cashier/utils/AddOnAttributeCacheManager;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "(Ljava/lang/String;)Ljava/lang/String;", "", "MyBillsEntityDataFactory", "()Ljava/util/List;", "", "p1", "(ZLjava/lang/String;)V", "getAuthRequestContext", "(Ljava/lang/String;)V", "", "Lid/dana/cashier/model/AttributeModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Map;", "PlaceComponentResult", "Ljava/util/ArrayList;", "Lid/dana/cashier/model/CashierOrderGoodModel;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "Ljava/lang/String;", "", "Ljava/util/Set;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddOnAttributeCacheManager {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Map<String, AttributeModel> getAuthRequestContext = new LinkedHashMap();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Map<String, AttributeModel> PlaceComponentResult = new LinkedHashMap();
    public final Set<String> MyBillsEntityDataFactory = new LinkedHashSet();
    public final Set<String> NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedHashSet();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ArrayList<CashierOrderGoodModel> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();

    public final void MyBillsEntityDataFactory(boolean p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0) {
            getAuthRequestContext(p1);
            return;
        }
        this.MyBillsEntityDataFactory.remove(p1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(KClassImpl$Data$declaredNonStaticMembers$2(p1));
    }

    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.add(p0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(KClassImpl$Data$declaredNonStaticMembers$2(p0));
    }

    public final List<String> MyBillsEntityDataFactory() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str == null || str.length() == 0) {
            return CollectionsKt.toList(this.MyBillsEntityDataFactory);
        }
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str2 == null) {
            str2 = "";
        }
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(str2), (Iterable) this.MyBillsEntityDataFactory);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.clear();
        this.PlaceComponentResult.clear();
        this.MyBillsEntityDataFactory.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
        this.BuiltInFictitiousFunctionClassFactory.clear();
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Object obj;
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CashierOrderGoodModel) obj).MyBillsEntityDataFactory, p0)) {
                break;
            }
        }
        CashierOrderGoodModel cashierOrderGoodModel = (CashierOrderGoodModel) obj;
        String str = cashierOrderGoodModel != null ? cashierOrderGoodModel.DatabaseTableConfigUtil : null;
        return str == null ? "" : str;
    }
}
