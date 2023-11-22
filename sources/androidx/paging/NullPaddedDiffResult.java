package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t"}, d2 = {"Landroidx/paging/NullPaddedDiffResult;", "", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "MyBillsEntityDataFactory", "", "Z", "PlaceComponentResult", "()Z", "p0", "p1", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$DiffResult;Z)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NullPaddedDiffResult {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final DiffUtil.DiffResult MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    public NullPaddedDiffResult(DiffUtil.DiffResult diffResult, boolean z) {
        Intrinsics.checkNotNullParameter(diffResult, "");
        this.MyBillsEntityDataFactory = diffResult;
        this.PlaceComponentResult = z;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
