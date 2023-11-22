package androidx.window.embedding;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u00060\nR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend;", "Landroidx/window/embedding/EmbeddingBackend;", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "getAuthRequestContext", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "MyBillsEntityDataFactory", "Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Landroidx/window/embedding/EmbeddingRule;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/concurrent/CopyOnWriteArraySet;", "PlaceComponentResult", "p0", "<init>", "(Landroidx/window/embedding/EmbeddingInterfaceCompat;)V", "Companion", "EmbeddingCallbackImpl", "SplitListenerWrapper"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {
    private static volatile ExtensionEmbeddingBackend PlaceComponentResult;
    final CopyOnWriteArrayList<SplitListenerWrapper> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public EmbeddingInterfaceCompat getAuthRequestContext;
    private final EmbeddingCallbackImpl MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final CopyOnWriteArraySet<EmbeddingRule> PlaceComponentResult;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock getAuthRequestContext = new ReentrantLock();

    public ExtensionEmbeddingBackend(EmbeddingInterfaceCompat embeddingInterfaceCompat) {
        this.getAuthRequestContext = embeddingInterfaceCompat;
        EmbeddingCallbackImpl embeddingCallbackImpl = new EmbeddingCallbackImpl(this);
        this.MyBillsEntityDataFactory = embeddingCallbackImpl;
        this.BuiltInFictitiousFunctionClassFactory = new CopyOnWriteArrayList<>();
        EmbeddingInterfaceCompat embeddingInterfaceCompat2 = this.getAuthRequestContext;
        if (embeddingInterfaceCompat2 != null) {
            embeddingInterfaceCompat2.getAuthRequestContext(embeddingCallbackImpl);
        }
        this.PlaceComponentResult = new CopyOnWriteArraySet<>();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$Companion;", "", "Landroidx/window/embedding/ExtensionEmbeddingBackend;", "PlaceComponentResult", "()Landroidx/window/embedding/ExtensionEmbeddingBackend;", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroidx/window/embedding/EmbeddingInterfaceCompat;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/Integer;)Z", "Landroidx/window/embedding/ExtensionEmbeddingBackend;", "Ljava/util/concurrent/locks/ReentrantLock;", "getAuthRequestContext", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ExtensionEmbeddingBackend PlaceComponentResult() {
            if (ExtensionEmbeddingBackend.PlaceComponentResult == null) {
                ReentrantLock reentrantLock = ExtensionEmbeddingBackend.getAuthRequestContext;
                reentrantLock.lock();
                try {
                    if (ExtensionEmbeddingBackend.PlaceComponentResult == null) {
                        Companion companion = ExtensionEmbeddingBackend.INSTANCE;
                        EmbeddingInterfaceCompat KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                        Companion companion2 = ExtensionEmbeddingBackend.INSTANCE;
                        ExtensionEmbeddingBackend.PlaceComponentResult = new ExtensionEmbeddingBackend(KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
            ExtensionEmbeddingBackend extensionEmbeddingBackend = ExtensionEmbeddingBackend.PlaceComponentResult;
            Intrinsics.checkNotNull(extensionEmbeddingBackend);
            return extensionEmbeddingBackend;
        }

        private static EmbeddingInterfaceCompat KClassImpl$Data$declaredNonStaticMembers$2() {
            EmbeddingCompat embeddingCompat = null;
            try {
                if (MyBillsEntityDataFactory(EmbeddingCompat.MyBillsEntityDataFactory.MyBillsEntityDataFactory()) && EmbeddingCompat.MyBillsEntityDataFactory.PlaceComponentResult()) {
                    embeddingCompat = new EmbeddingCompat();
                }
            } catch (Throwable th) {
                InstrumentInjector.log_d("EmbeddingBackend", Intrinsics.stringPlus("Failed to load embedding extension: ", th));
            }
            if (embeddingCompat == null) {
                InstrumentInjector.log_d("EmbeddingBackend", "No supported embedding extension found");
            }
            return embeddingCompat;
        }

        private static boolean MyBillsEntityDataFactory(Integer p0) {
            return p0 != null && p0.intValue() > 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "", "Landroidx/window/embedding/SplitInfo;", "p0", "", "getAuthRequestContext", "(Ljava/util/List;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "<init>", "(Landroidx/window/embedding/ExtensionEmbeddingBackend;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {
        public List<SplitInfo> KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ ExtensionEmbeddingBackend MyBillsEntityDataFactory;

        public EmbeddingCallbackImpl(ExtensionEmbeddingBackend extensionEmbeddingBackend) {
            Intrinsics.checkNotNullParameter(extensionEmbeddingBackend, "");
            this.MyBillsEntityDataFactory = extensionEmbeddingBackend;
        }

        @Override // androidx.window.embedding.EmbeddingInterfaceCompat.EmbeddingCallbackInterface
        public final void getAuthRequestContext(List<SplitInfo> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            Iterator<SplitListenerWrapper> it = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                final SplitListenerWrapper next = it.next();
                Intrinsics.checkNotNullParameter(p0, "");
                ArrayList arrayList = new ArrayList();
                for (Object obj : p0) {
                    if (((SplitInfo) obj).getAuthRequestContext(next.getAuthRequestContext)) {
                        arrayList.add(obj);
                    }
                }
                final ArrayList arrayList2 = arrayList;
                if (!Intrinsics.areEqual(arrayList2, next.BuiltInFictitiousFunctionClassFactory)) {
                    next.BuiltInFictitiousFunctionClassFactory = arrayList2;
                    next.PlaceComponentResult.execute(new Runnable() { // from class: androidx.window.embedding.ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ExtensionEmbeddingBackend.SplitListenerWrapper.MyBillsEntityDataFactory(ExtensionEmbeddingBackend.SplitListenerWrapper.this, arrayList2);
                        }
                    });
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "", "Landroid/app/Activity;", "PlaceComponentResult", "Landroid/app/Activity;", "getAuthRequestContext", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/core/util/Consumer;", "Ljava/util/concurrent/Executor;", "MyBillsEntityDataFactory", "Ljava/util/concurrent/Executor;", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SplitListenerWrapper {
        public final Consumer<List<SplitInfo>> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final Executor PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final Activity getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        List<SplitInfo> BuiltInFictitiousFunctionClassFactory;

        public static /* synthetic */ void MyBillsEntityDataFactory(SplitListenerWrapper splitListenerWrapper, List list) {
            Intrinsics.checkNotNullParameter(splitListenerWrapper, "");
            Intrinsics.checkNotNullParameter(list, "");
            splitListenerWrapper.KClassImpl$Data$declaredNonStaticMembers$2.accept(list);
        }
    }
}
