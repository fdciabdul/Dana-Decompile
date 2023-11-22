package com.anggrayudi.storage.file;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.Grouping;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0003\u001a\u00028\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¸\u0006\b"}, d2 = {"Lkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1;", "Lkotlin/collections/Grouping;", "p0", "keyOf", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "sourceIterator", "()Ljava/util/Iterator;", "kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class DocumentFileUtils$compressToZip$$inlined$groupingBy$1 implements Grouping<DocumentFileUtils$compressToZip$EntryFile, DocumentFileUtils$compressToZip$EntryFile> {
    final /* synthetic */ Iterable KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // kotlin.collections.Grouping
    public final Iterator<DocumentFileUtils$compressToZip$EntryFile> sourceIterator() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
    }

    @Override // kotlin.collections.Grouping
    public final DocumentFileUtils$compressToZip$EntryFile keyOf(DocumentFileUtils$compressToZip$EntryFile p0) {
        return p0;
    }
}
