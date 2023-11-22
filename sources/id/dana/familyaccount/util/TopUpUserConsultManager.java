package id.dana.familyaccount.util;

import id.dana.familyaccount.model.TopUpUserConsultModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/familyaccount/util/TopUpUserConsultManager;", "", "", "MyBillsEntityDataFactory", "()V", "Lid/dana/familyaccount/model/TopUpUserConsultModel;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/familyaccount/model/TopUpUserConsultModel;", "p0", "PlaceComponentResult", "(Lid/dana/familyaccount/model/TopUpUserConsultModel;)V", "Lid/dana/familyaccount/model/TopUpUserConsultModel;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TopUpUserConsultManager {
    public static final TopUpUserConsultManager INSTANCE = new TopUpUserConsultManager();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static TopUpUserConsultModel MyBillsEntityDataFactory;

    private TopUpUserConsultManager() {
    }

    @JvmStatic
    public static final void PlaceComponentResult(TopUpUserConsultModel p0) {
        MyBillsEntityDataFactory = p0;
    }

    @JvmStatic
    public static final TopUpUserConsultModel BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory;
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = null;
    }
}
