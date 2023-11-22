package com.anggrayudi.storage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\r"}, d2 = {"Lcom/anggrayudi/storage/ActivityWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "Landroid/content/Intent;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;I)Z", "Landroid/app/Activity;", "Landroid/app/Activity;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "()Landroid/content/Context;", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class ActivityWrapper implements ComponentWrapper {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Activity BuiltInFictitiousFunctionClassFactory;

    @Override // com.anggrayudi.storage.ComponentWrapper
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final Context KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Intent p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            this.BuiltInFictitiousFunctionClassFactory.startActivityForResult(p0, p1);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
