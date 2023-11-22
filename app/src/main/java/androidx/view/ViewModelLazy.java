package androidx.view;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BA\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lkotlin/Lazy;", "", "isInitialized", "()Z", "MyBillsEntityDataFactory", "Landroidx/lifecycle/ViewModel;", "getAuthRequestContext", "Lkotlin/Function0;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "PlaceComponentResult", "Landroidx/lifecycle/ViewModelStore;", "Lkotlin/reflect/KClass;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/reflect/KClass;", "p0", "p1", "p2", "p3", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private final KClass<VM> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function0<CreationExtras> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private VM getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function0<ViewModelProvider.Factory> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function0<ViewModelStore> PlaceComponentResult;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function02, Function0<? extends CreationExtras> function03) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function03, "");
        this.BuiltInFictitiousFunctionClassFactory = kClass;
        this.PlaceComponentResult = function0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function02;
        this.MyBillsEntityDataFactory = function03;
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/viewmodel/CreationExtras$Empty;", BridgeDSL.INVOKE, "()Landroidx/lifecycle/viewmodel/CreationExtras$Empty;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.ViewModelLazy$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends Lambda implements Function0<CreationExtras.Empty> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return this.getAuthRequestContext != null;
    }

    @Override // kotlin.Lazy
    public final /* synthetic */ Object getValue() {
        VM vm = this.getAuthRequestContext;
        if (vm == null) {
            VM vm2 = (VM) new ViewModelProvider(this.PlaceComponentResult.invoke(), this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(), this.MyBillsEntityDataFactory.invoke()).MyBillsEntityDataFactory(JvmClassMappingKt.getJavaClass((KClass) this.BuiltInFictitiousFunctionClassFactory));
            this.getAuthRequestContext = vm2;
            return vm2;
        }
        return vm;
    }
}
