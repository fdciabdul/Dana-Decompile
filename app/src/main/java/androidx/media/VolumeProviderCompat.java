package androidx.media;

import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public abstract class VolumeProviderCompat {
    private final int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int getAuthRequestContext;

    /* loaded from: classes6.dex */
    public static abstract class Callback {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ControlType {
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
    }

    public void PlaceComponentResult(int i) {
    }

    public final int getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final int PlaceComponentResult() {
        return this.getAuthRequestContext;
    }

    /* renamed from: androidx.media.VolumeProviderCompat$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements VolumeProviderCompatApi21.Delegate {
        final /* synthetic */ VolumeProviderCompat getAuthRequestContext;

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void MyBillsEntityDataFactory(int i) {
            this.getAuthRequestContext.PlaceComponentResult(i);
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void getAuthRequestContext(int i) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }
}
