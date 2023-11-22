package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\u001a;\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\r\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\"!\u0010\u0013\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00018G¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"!\u0010\u0016\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00018G¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010\"%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0017*\u0006\u0012\u0002\b\u00030\u00018G¢\u0006\f\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"R", "Lkotlin/reflect/KCallable;", "", "", "args", "callSuspend", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "callSuspendBy", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "name", "findParameterByName", "(Lkotlin/reflect/KCallable;Ljava/lang/String;)Lkotlin/reflect/KParameter;", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "getExtensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "extensionReceiverParameter", "getInstanceParameter", "getInstanceParameter$annotations", "instanceParameter", "", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "getValueParameters$annotations", "valueParameters"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class KCallables {
    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable kCallable) {
    }

    public static /* synthetic */ void getInstanceParameter$annotations(KCallable kCallable) {
    }

    public static /* synthetic */ void getValueParameters$annotations(KCallable kCallable) {
    }

    @JvmName(name = "getInstanceParameter")
    public static final KParameter getInstanceParameter(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.INSTANCE) {
                    if (z) {
                        break;
                    }
                    obj2 = next;
                    z = true;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @JvmName(name = "getExtensionReceiverParameter")
    public static final KParameter getExtensionReceiverParameter(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z) {
                        break;
                    }
                    obj2 = next;
                    z = true;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @JvmName(name = "getValueParameters")
    public static final List<KParameter> getValueParameters(KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "");
        List<KParameter> parameters = kCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final KParameter findParameterByName(KCallable<?> kCallable, String str) {
        Intrinsics.checkNotNullParameter(kCallable, "");
        Intrinsics.checkNotNullParameter(str, "");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (Intrinsics.areEqual(((KParameter) next).getName(), str)) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object callSuspend(kotlin.reflect.KCallable<? extends R> r4, java.lang.Object[] r5, kotlin.coroutines.Continuation<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.KCallables$callSuspend$1
            if (r0 == 0) goto L14
            r0 = r6
            kotlin.reflect.full.KCallables$callSuspend$1 r0 = (kotlin.reflect.full.KCallables$callSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            kotlin.reflect.full.KCallables$callSuspend$1 r0 = new kotlin.reflect.full.KCallables$callSuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r4 = r0.L$0
            kotlin.reflect.KCallable r4 = (kotlin.reflect.KCallable) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L7f
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4d
            int r6 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6)
            java.lang.Object r4 = r4.call(r5)
            return r4
        L4d:
            boolean r6 = r4 instanceof kotlin.reflect.KFunction
            if (r6 == 0) goto La3
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlin.jvm.internal.SpreadBuilder r6 = new kotlin.jvm.internal.SpreadBuilder
            r2 = 2
            r6.<init>(r2)
            r6.addSpread(r5)
            r6.add(r0)
            int r5 = r6.size()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Object[] r5 = r6.toArray(r5)
            java.lang.Object r6 = r4.call(r5)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r5) goto L7c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L7c:
            if (r6 != r1) goto L7f
            return r1
        L7f:
            kotlin.reflect.KType r5 = r4.getReturnType()
            kotlin.reflect.KClassifier r5 = r5.getClassifier()
            java.lang.Class<kotlin.Unit> r0 = kotlin.Unit.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto La2
            kotlin.reflect.KType r4 = r4.getReturnType()
            boolean r4 = r4.isMarkedNullable()
            if (r4 != 0) goto La2
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r4 = (java.lang.Object) r4
            return r4
        La2:
            return r6
        La3:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Cannot callSuspend on a property "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r5.append(r4)
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KCallables.callSuspend(kotlin.reflect.KCallable, java.lang.Object[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object callSuspendBy(kotlin.reflect.KCallable<? extends R> r4, java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.KCallables$callSuspendBy$1
            if (r0 == 0) goto L14
            r0 = r6
            kotlin.reflect.full.KCallables$callSuspendBy$1 r0 = (kotlin.reflect.full.KCallables$callSuspendBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            kotlin.reflect.full.KCallables$callSuspendBy$1 r0 = new kotlin.reflect.full.KCallables$callSuspendBy$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r4 = r0.L$2
            kotlin.reflect.jvm.internal.KCallableImpl r4 = (kotlin.reflect.jvm.internal.KCallableImpl) r4
            java.lang.Object r4 = r0.L$1
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r4 = r0.L$0
            kotlin.reflect.KCallable r4 = (kotlin.reflect.KCallable) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L70
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4c
            java.lang.Object r4 = r4.callBy(r5)
            return r4
        L4c:
            boolean r6 = r4 instanceof kotlin.reflect.KFunction
            if (r6 == 0) goto Lab
            kotlin.reflect.jvm.internal.KCallableImpl r6 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r4)
            if (r6 == 0) goto L94
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            java.lang.Object r6 = r6.callDefaultMethod$kotlin_reflection(r5, r0)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r5) goto L6d
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L6d:
            if (r6 != r1) goto L70
            return r1
        L70:
            kotlin.reflect.KType r5 = r4.getReturnType()
            kotlin.reflect.KClassifier r5 = r5.getClassifier()
            java.lang.Class<kotlin.Unit> r0 = kotlin.Unit.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L93
            kotlin.reflect.KType r4 = r4.getReturnType()
            boolean r4 = r4.isMarkedNullable()
            if (r4 != 0) goto L93
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r4 = (java.lang.Object) r4
            return r4
        L93:
            return r6
        L94:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "This callable does not support a default call: "
            r5.append(r6)
            r5.append(r4)
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r4 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        Lab:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Cannot callSuspendBy on a property "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r5.append(r4)
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KCallables.callSuspendBy(kotlin.reflect.KCallable, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
