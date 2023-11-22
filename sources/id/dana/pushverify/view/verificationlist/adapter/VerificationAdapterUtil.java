package id.dana.pushverify.view.verificationlist.adapter;

import id.dana.R;
import id.dana.pushverify.model.VerificationDetailModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u000b"}, d2 = {"Lid/dana/pushverify/view/verificationlist/adapter/VerificationAdapterUtil;", "", "", "Lid/dana/pushverify/model/VerificationDetailModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "", "p0", "MyBillsEntityDataFactory", "()Lid/dana/pushverify/model/VerificationDetailModel;", "", "(Ljava/lang/String;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationAdapterUtil {
    public static final VerificationAdapterUtil INSTANCE = new VerificationAdapterUtil();

    private VerificationAdapterUtil() {
    }

    public static int MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return Intrinsics.areEqual(p0, "LOGIN") ? R.string.pushverify_list_login : Intrinsics.areEqual(p0, "PAYMENT") ? R.string.pushverify_list_payment : R.string.pushverify_list_binding;
    }

    public static List<VerificationDetailModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(new VerificationDetailModel("", "", "", "", "", 0, null, null, null, 99, 448, null));
        }
        return arrayList;
    }

    public static VerificationDetailModel MyBillsEntityDataFactory() {
        return new VerificationDetailModel("", "", "", "", "", 0, null, null, null, 98, 448, null);
    }
}
