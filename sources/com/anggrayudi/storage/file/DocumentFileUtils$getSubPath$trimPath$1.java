package com.anggrayudi.storage.file;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "longPath", "shortPath", BridgeDSL.INVOKE, "(Ljava/util/List;Ljava/util/List;)Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class DocumentFileUtils$getSubPath$trimPath$1 extends Lambda implements Function2<List<? extends String>, List<? extends String>, String> {
    public static final DocumentFileUtils$getSubPath$trimPath$1 INSTANCE = new DocumentFileUtils$getSubPath$trimPath$1();

    DocumentFileUtils$getSubPath$trimPath$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ String invoke(List<? extends String> list, List<? extends String> list2) {
        return invoke2((List<String>) list, (List<String>) list2);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final String invoke2(List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        if (Intrinsics.areEqual(CollectionsKt.take(list, list2.size()), list2)) {
            return list.size() == list2.size() ? "" : CollectionsKt.joinToString$default(CollectionsKt.takeLast(list, list.size() - list2.size()), "/", null, null, 0, null, null, 62, null);
        }
        return null;
    }
}
