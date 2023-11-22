package androidx.view.viewmodel;

import androidx.view.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B0\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0002\b\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0002\b\nX\u0001¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b"}, d2 = {"Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "Landroidx/lifecycle/ViewModel;", "T", "", "Ljava/lang/Class;", "getAuthRequestContext", "Ljava/lang/Class;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Function1<CreationExtras, T> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Class<T> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelInitializer(Class<T> cls, Function1<? super CreationExtras, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cls;
        this.MyBillsEntityDataFactory = function1;
    }
}
