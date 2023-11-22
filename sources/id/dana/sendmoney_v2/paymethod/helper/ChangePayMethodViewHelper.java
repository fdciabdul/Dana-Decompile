package id.dana.sendmoney_v2.paymethod.helper;

import id.dana.model.PayMethodModel;
import id.dana.sendmoney.paymethod.PayMethodAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/helper/ChangePayMethodViewHelper;", "", "Lid/dana/model/PayMethodModel;", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Lid/dana/model/PayMethodModel;Ljava/lang/String;)Z", "Lid/dana/sendmoney/paymethod/PayMethodAdapter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/paymethod/PayMethodAdapter;Ljava/lang/String;)Lid/dana/model/PayMethodModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChangePayMethodViewHelper {
    public static final ChangePayMethodViewHelper INSTANCE = new ChangePayMethodViewHelper();

    private ChangePayMethodViewHelper() {
    }

    public static PayMethodModel BuiltInFictitiousFunctionClassFactory(PayMethodAdapter p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        List<PayMethodModel> items = p0.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        for (PayMethodModel payMethodModel : items) {
            Intrinsics.checkNotNullExpressionValue(payMethodModel, "");
            if (MyBillsEntityDataFactory(payMethodModel, p1)) {
                return payMethodModel;
            }
        }
        return null;
    }

    private static boolean MyBillsEntityDataFactory(PayMethodModel p0, String p1) {
        String str = p0.getAuthRequestContext;
        if (str == null) {
            str = "";
        }
        return Intrinsics.areEqual(str, p1);
    }
}
