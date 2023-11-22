package kotlin.reflect.jvm.internal;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import id.dana.cashier.view.InputCardNumberView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001c\u001a\u00020\u001b*\u00060\u0017j\u0002`\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001b*\u00060\u0017j\u0002`\u00182\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "descriptor", "", "renderCallable", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderFunction", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Ljava/lang/String;", BridgeDSL.INVOKE, "renderLambda", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "parameter", "renderParameter", "(Lkotlin/reflect/jvm/internal/KParameterImpl;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderProperty", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "type", LottieParams.KEY_RENDER_TYPE, "(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "receiver", "", "appendReceiverType", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;)V", "callable", "appendReceivers", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;)V", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "<init>", "()V"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    private static final DescriptorRenderer renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
            iArr[KParameter.Kind.INSTANCE.ordinal()] = 2;
            iArr[KParameter.Kind.VALUE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReflectionObjectRenderer() {
    }

    private final void appendReceiverType(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType type = receiverParameterDescriptor.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    private final void appendReceivers(StringBuilder sb, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        appendReceiverType(sb, instanceReceiverParameter);
        boolean z = (instanceReceiverParameter == null || extensionReceiverParameter == null) ? false : true;
        if (z) {
            sb.append("(");
        }
        appendReceiverType(sb, extensionReceiverParameter);
        if (z) {
            sb.append(")");
        }
    }

    private final String renderCallable(CallableDescriptor descriptor) {
        if (descriptor instanceof PropertyDescriptor) {
            return renderProperty((PropertyDescriptor) descriptor);
        }
        if (descriptor instanceof FunctionDescriptor) {
            return renderFunction((FunctionDescriptor) descriptor);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal callable: ");
        sb.append(descriptor);
        throw new IllegalStateException(sb.toString().toString());
    }

    public final String renderProperty(PropertyDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "");
        StringBuilder sb = new StringBuilder();
        sb.append(descriptor.isVar() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, descriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name = descriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        sb.append(descriptorRenderer.renderName(name, true));
        sb.append(": ");
        KotlinType type = descriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "");
        sb.append(reflectionObjectRenderer.renderType(type));
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final String renderFunction(FunctionDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, descriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name = descriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        sb.append(descriptorRenderer.renderName(name, true));
        List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "");
        CollectionsKt.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, new Function1<ValueParameterDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$renderFunction$1$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
                ReflectionObjectRenderer reflectionObjectRenderer2 = ReflectionObjectRenderer.INSTANCE;
                KotlinType type = valueParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(type, "");
                return reflectionObjectRenderer2.renderType(type);
            }
        }, 48, null);
        sb.append(": ");
        KotlinType returnType = descriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final String renderLambda(FunctionDescriptor r15) {
        Intrinsics.checkNotNullParameter(r15, "");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, r15);
        List<ValueParameterDescriptor> valueParameters = r15.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "");
        CollectionsKt.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, new Function1<ValueParameterDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$renderLambda$1$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
                ReflectionObjectRenderer reflectionObjectRenderer2 = ReflectionObjectRenderer.INSTANCE;
                KotlinType type = valueParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(type, "");
                return reflectionObjectRenderer2.renderType(type);
            }
        }, 48, null);
        sb.append(" -> ");
        KotlinType returnType = r15.getReturnType();
        Intrinsics.checkNotNull(returnType);
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final String renderParameter(KParameterImpl parameter) {
        Intrinsics.checkNotNullParameter(parameter, "");
        StringBuilder sb = new StringBuilder();
        int i = WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()];
        if (i == 1) {
            sb.append("extension receiver parameter");
        } else if (i == 2) {
            sb.append("instance parameter");
        } else if (i == 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("parameter #");
            sb2.append(parameter.getIndex());
            sb2.append(InputCardNumberView.DIVIDER);
            sb2.append(parameter.getName());
            sb.append(sb2.toString());
        }
        sb.append(" of ");
        sb.append(INSTANCE.renderCallable(parameter.getCallable().getDescriptor()));
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final String renderType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        return renderer.renderType(kotlinType);
    }
}
