package id.dana.core.ui.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007"}, d2 = {"Lid/dana/core/ui/util/QuickTap;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "PlaceComponentResult", "I", "MyBillsEntityDataFactory", "Lid/dana/core/ui/util/QuickTap$OnQuickTapListener;", "getAuthRequestContext", "Lid/dana/core/ui/util/QuickTap$OnQuickTapListener;", "", "J", "BuiltInFictitiousFunctionClassFactory", "OnQuickTapListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuickTap {
    private final int BuiltInFictitiousFunctionClassFactory;
    private long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;
    private final OnQuickTapListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/util/QuickTap$OnQuickTapListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnQuickTapListener {
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0 || System.currentTimeMillis() - this.KClassImpl$Data$declaredNonStaticMembers$2 < this.BuiltInFictitiousFunctionClassFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
            this.MyBillsEntityDataFactory++;
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
            this.MyBillsEntityDataFactory = 0;
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (this.MyBillsEntityDataFactory >= this.PlaceComponentResult) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
            this.MyBillsEntityDataFactory = 0;
        }
    }
}
