package androidx.view.result;

import androidx.core.app.ActivityOptionsCompat;
import androidx.view.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0011\u0010\u0005\u001a\u00028\u0000X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\f"}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", "", "getAuthRequestContext", "()V", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Ljava/lang/Object;", "Landroidx/activity/result/ActivityResultLauncher;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ActivityResultLauncher<I> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final I getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final ActivityResultContract<I, O> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.view.result.ActivityResultLauncher
    public final /* synthetic */ void MyBillsEntityDataFactory(Unit unit, ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics.checkNotNullParameter(unit, "");
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.getAuthRequestContext, activityOptionsCompat);
    }

    @Override // androidx.view.result.ActivityResultLauncher
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.getAuthRequestContext();
    }
}
