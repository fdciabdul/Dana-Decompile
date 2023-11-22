package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.glide.DanaAppGlideModule;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes3.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final DanaAppGlideModule KClassImpl$Data$declaredNonStaticMembers$2 = new DanaAppGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            InstrumentInjector.log_d("Glide", "Discovered AppGlideModule from annotation: id.dana.core.ui.glide.DanaAppGlideModule");
        }
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Glide glide, Registry registry) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(context, glide, registry);
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public final boolean MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final Set<Class<?>> getAuthRequestContext() {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final /* synthetic */ RequestManagerRetriever.RequestManagerFactory KClassImpl$Data$declaredNonStaticMembers$2() {
        return new GeneratedRequestManagerFactory();
    }
}
