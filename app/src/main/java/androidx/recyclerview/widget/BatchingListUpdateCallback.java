package androidx.recyclerview.widget;

/* loaded from: classes3.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    int BuiltInFictitiousFunctionClassFactory = 0;
    int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    int MyBillsEntityDataFactory = -1;
    Object PlaceComponentResult = null;
    final ListUpdateCallback getAuthRequestContext;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.getAuthRequestContext = listUpdateCallback;
    }

    public final void getAuthRequestContext() {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.getAuthRequestContext.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        } else if (i == 2) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        } else if (i == 3) {
            this.getAuthRequestContext.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
        }
        this.PlaceComponentResult = null;
        this.BuiltInFictitiousFunctionClassFactory = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void PlaceComponentResult(int i, int i2) {
        int i3;
        if (this.BuiltInFictitiousFunctionClassFactory == 1 && i >= (i3 = this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            int i4 = this.MyBillsEntityDataFactory;
            if (i <= i3 + i4) {
                this.MyBillsEntityDataFactory = i4 + i2;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.min(i, i3);
                return;
            }
        }
        getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = i2;
        this.BuiltInFictitiousFunctionClassFactory = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        int i3;
        if (this.BuiltInFictitiousFunctionClassFactory == 2 && (i3 = this.KClassImpl$Data$declaredNonStaticMembers$2) >= i && i3 <= i + i2) {
            this.MyBillsEntityDataFactory += i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            return;
        }
        getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = i2;
        this.BuiltInFictitiousFunctionClassFactory = 2;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void getAuthRequestContext(int i, int i2) {
        getAuthRequestContext();
        this.getAuthRequestContext.getAuthRequestContext(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void getAuthRequestContext(int i, int i2, Object obj) {
        int i3;
        int i4;
        int i5;
        if (this.BuiltInFictitiousFunctionClassFactory == 3 && i <= (i4 = this.MyBillsEntityDataFactory + (i3 = this.KClassImpl$Data$declaredNonStaticMembers$2)) && (i5 = i + i2) >= i3 && this.PlaceComponentResult == obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.min(i, i3);
            this.MyBillsEntityDataFactory = Math.max(i4, i5) - this.KClassImpl$Data$declaredNonStaticMembers$2;
            return;
        }
        getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = i2;
        this.PlaceComponentResult = obj;
        this.BuiltInFictitiousFunctionClassFactory = 3;
    }
}
