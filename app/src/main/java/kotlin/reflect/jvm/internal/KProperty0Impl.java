package kotlin.reflect.jvm.internal;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0012*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\u00110\u0010X\u0088\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "V", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", BranchLinkConstant.PathTarget.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", BranchLinkConstant.OauthParams.SIGNATURE, "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", BridgeDSL.INVOKE, "Getter", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class KProperty0Impl<V> extends KPropertyImpl<V> implements KProperty0<V> {
    private final ReflectProperties.LazyVal<Getter<V>> _getter;
    private final Lazy<Object> delegateValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "");
        Intrinsics.checkNotNullParameter(propertyDescriptor, "");
        ReflectProperties.LazyVal<Getter<V>> lazy = ReflectProperties.lazy(new Function0<Getter<? extends V>>(this) { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$_getter$1
            final /* synthetic */ KProperty0Impl<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty0Impl.Getter<V> invoke() {
                return new KProperty0Impl.Getter<>(this.this$0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazy, "");
        this._getter = lazy;
        this.delegateValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Object>(this) { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$delegateValue$1
            final /* synthetic */ KProperty0Impl<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KPropertyImpl kPropertyImpl = this.this$0;
                return kPropertyImpl.getDelegateImpl(kPropertyImpl.computeDelegateSource(), null, null);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        ReflectProperties.LazyVal<Getter<V>> lazy = ReflectProperties.lazy(new Function0<Getter<? extends V>>(this) { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$_getter$1
            final /* synthetic */ KProperty0Impl<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty0Impl.Getter<V> invoke() {
                return new KProperty0Impl.Getter<>(this.this$0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazy, "");
        this._getter = lazy;
        this.delegateValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Object>(this) { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$delegateValue$1
            final /* synthetic */ KProperty0Impl<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KPropertyImpl kPropertyImpl = this.this$0;
                return kPropertyImpl.getDelegateImpl(kPropertyImpl.computeDelegateSource(), null, null);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public Getter<V> getGetter() {
        Getter<V> invoke = this._getter.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "");
        return invoke;
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return this.delegateValue.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", BridgeDSL.INVOKE, "()Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Getter<R> extends KPropertyImpl.Getter<R> implements KProperty0.Getter<R> {
        private final KProperty0Impl<R> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty0Impl<? extends R> kProperty0Impl) {
            Intrinsics.checkNotNullParameter(kProperty0Impl, "");
            this.property = kProperty0Impl;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        @JvmName(name = "getProperty")
        public final KProperty0Impl<R> getProperty() {
            return this.property;
        }

        @Override // kotlin.jvm.functions.Function0
        public final R invoke() {
            return getProperty().get();
        }
    }
}
