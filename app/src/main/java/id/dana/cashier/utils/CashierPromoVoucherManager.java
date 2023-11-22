package id.dana.cashier.utils;

import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.VoucherCashierModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\r\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\u0007\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017"}, d2 = {"Lid/dana/cashier/utils/CashierPromoVoucherManager;", "", "Lid/dana/cashier/model/CashierPayMethodModel;", "p0", "Lkotlin/Pair;", "Lid/dana/cashier/model/VoucherCashierModel;", "", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lkotlin/Pair;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/CashierPayMethodModel;Lid/dana/cashier/model/VoucherCashierModel;)Ljava/util/List;", "", "PlaceComponentResult", "Z", "", "getAuthRequestContext", "J", "Lid/dana/cashier/model/VoucherCashierModel;", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/util/List;", "", "Ljava/util/Set;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPromoVoucherManager {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public VoucherCashierModel BuiltInFictitiousFunctionClassFactory;
    public boolean PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public long MyBillsEntityDataFactory;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public List<VoucherCashierModel> getAuthRequestContext = new ArrayList();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Set<VoucherCashierModel> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashSet();

    /* JADX WARN: Removed duplicated region for block: B:154:0x00d7 A[EDGE_INSN: B:154:0x00d7->B:55:0x00d7 BREAK  A[LOOP:0: B:39:0x00a6->B:157:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[LOOP:0: B:39:0x00a6->B:157:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x011f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[LOOP:1: B:63:0x00ea->B:162:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0193 A[EDGE_INSN: B:164:0x0193->B:118:0x0193 BREAK  A[LOOP:2: B:102:0x0162->B:167:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[LOOP:2: B:102:0x0162->B:167:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[LOOP:3: B:126:0x01a6->B:172:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<id.dana.cashier.model.VoucherCashierModel> KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.CashierPayMethodModel r12, id.dana.cashier.model.VoucherCashierModel r13) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.utils.CashierPromoVoucherManager.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.VoucherCashierModel):java.util.List");
    }

    public final Pair<VoucherCashierModel, List<VoucherCashierModel>> MyBillsEntityDataFactory(CashierPayMethodModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext.clear();
        Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            this.getAuthRequestContext.addAll(KClassImpl$Data$declaredNonStaticMembers$2(p0, (VoucherCashierModel) it.next()));
        }
        return new Pair<>(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
    }
}
