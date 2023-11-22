package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* loaded from: classes.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> function1) {
        Intrinsics.checkNotNullParameter(collection, "");
        Intrinsics.checkNotNullParameter(function1, "");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (true) {
            LinkedList linkedList2 = linkedList;
            if ((!linkedList2.isEmpty()) != false) {
                Object first = CollectionsKt.first((List<? extends Object>) linkedList);
                final SmartSet create2 = SmartSet.Companion.create();
                Collection<? super H> extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList2, function1, new Function1<H, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2((OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1<H>) obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(H h) {
                        SmartSet<H> smartSet = create2;
                        Intrinsics.checkNotNullExpressionValue(h, "");
                        smartSet.add(h);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(extractMembersOverridableInBothWays, "");
                if (extractMembersOverridableInBothWays.size() == 1 && create2.isEmpty()) {
                    Object single = CollectionsKt.single(extractMembersOverridableInBothWays);
                    Intrinsics.checkNotNullExpressionValue(single, "");
                    create.add(single);
                } else {
                    Object obj = (Object) OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, function1);
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    CallableDescriptor invoke = function1.invoke(obj);
                    for (Object obj2 : extractMembersOverridableInBothWays) {
                        Intrinsics.checkNotNullExpressionValue(obj2, "");
                        if (!OverridingUtil.isMoreSpecific(invoke, function1.invoke(obj2))) {
                            create2.add(obj2);
                        }
                    }
                    SmartSet smartSet = create2;
                    if ((!smartSet.isEmpty()) != false) {
                        create.addAll(smartSet);
                    }
                    create.add(obj);
                }
            } else {
                return create;
            }
        }
    }
}
