package com.anggrayudi.storage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.view.ComponentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0011R\u0012\u0010\n\u001a\u00020\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0012\u0010\u0007\u001a\u00020\u0014X\u0087\"¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015"}, d2 = {"Lcom/anggrayudi/storage/ComponentActivityWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "Landroid/content/Intent;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;I)Z", "Landroidx/activity/ComponentActivity;", "MyBillsEntityDataFactory", "Landroidx/activity/ComponentActivity;", "PlaceComponentResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/ActivityResultLauncher;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "()Landroid/content/Context;", "getAuthRequestContext", "I", "Lcom/anggrayudi/storage/SimpleStorage;", "Lcom/anggrayudi/storage/SimpleStorage;", "<init>", "(Landroidx/activity/ComponentActivity;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ComponentActivityWrapper implements ComponentWrapper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public SimpleStorage KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ComponentActivity PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> BuiltInFictitiousFunctionClassFactory;

    public ComponentActivityWrapper(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "");
        this.PlaceComponentResult = componentActivity;
        ActivityResultLauncher<Intent> registerForActivityResult = componentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.anggrayudi.storage.ComponentActivityWrapper$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ComponentActivityWrapper.BuiltInFictitiousFunctionClassFactory(ComponentActivityWrapper.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.BuiltInFictitiousFunctionClassFactory = registerForActivityResult;
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final Context KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Intent p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, null);
            this.MyBillsEntityDataFactory = p1;
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ComponentActivityWrapper componentActivityWrapper, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(componentActivityWrapper, "");
        SimpleStorage simpleStorage = componentActivityWrapper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (simpleStorage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            simpleStorage = null;
        }
        simpleStorage.getAuthRequestContext(componentActivityWrapper.MyBillsEntityDataFactory, activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory);
    }
}
