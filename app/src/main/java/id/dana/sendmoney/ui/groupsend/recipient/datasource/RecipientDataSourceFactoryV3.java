package id.dana.sendmoney.ui.groupsend.recipient.datasource;

import androidx.paging.PagingSource;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00078\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\u0005\u0010\fR\"\u0010\b\u001a\u00020\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\b\u0010\u0010\"\u0004\b\r\u0010\u0011"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "", "Landroidx/paging/PagingSource;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "PlaceComponentResult", "()Landroidx/paging/PagingSource;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "", "Z", "()Z", "(Z)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RecipientDataSourceFactoryV3 {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    public abstract PagingSource<Integer, RecipientViewModel> PlaceComponentResult();

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
