package com.anggrayudi.storage.permission;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lcom/anggrayudi/storage/permission/PermissionResult;", "", "", "MyBillsEntityDataFactory", "()Z", "getAuthRequestContext", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionResult {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<PermissionReport> BuiltInFictitiousFunctionClassFactory;

    public PermissionResult(List<PermissionReport> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final boolean MyBillsEntityDataFactory() {
        List<PermissionReport> list = this.BuiltInFictitiousFunctionClassFactory;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PermissionReport) it.next()).getBuiltInFictitiousFunctionClassFactory()) {
                return false;
            }
        }
        return true;
    }
}
