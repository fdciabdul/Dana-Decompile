package com.anggrayudi.storage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultLauncher;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\f\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000eR\u0014\u0010\n\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0007\u001a\u00020\u0014X\u0087\"¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015"}, d2 = {"Lcom/anggrayudi/storage/FragmentWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "Landroid/content/Intent;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;I)Z", "Landroidx/activity/result/ActivityResultLauncher;", "MyBillsEntityDataFactory", "Landroidx/activity/result/ActivityResultLauncher;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "()Landroid/content/Context;", "PlaceComponentResult", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "getAuthRequestContext", "I", "Lcom/anggrayudi/storage/SimpleStorage;", "Lcom/anggrayudi/storage/SimpleStorage;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class FragmentWrapper implements ComponentWrapper {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Fragment MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public SimpleStorage KClassImpl$Data$declaredNonStaticMembers$2;
    public int getAuthRequestContext;

    @Override // com.anggrayudi.storage.ComponentWrapper
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final Context KClassImpl$Data$declaredNonStaticMembers$2() {
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        return requireContext;
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Intent p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, null);
            this.getAuthRequestContext = p1;
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FragmentWrapper fragmentWrapper, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "");
        SimpleStorage simpleStorage = fragmentWrapper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (simpleStorage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            simpleStorage = null;
        }
        simpleStorage.getAuthRequestContext(fragmentWrapper.getAuthRequestContext, activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory);
    }
}
