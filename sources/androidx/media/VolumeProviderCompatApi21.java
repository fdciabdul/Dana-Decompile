package androidx.media;

import android.media.VolumeProvider;

/* loaded from: classes6.dex */
class VolumeProviderCompatApi21 {

    /* loaded from: classes6.dex */
    public interface Delegate {
        void MyBillsEntityDataFactory(int i);

        void getAuthRequestContext(int i);
    }

    /* renamed from: androidx.media.VolumeProviderCompatApi21$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends VolumeProvider {
        final /* synthetic */ Delegate KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.media.VolumeProvider
        public final void onSetVolumeTo(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i);
        }

        @Override // android.media.VolumeProvider
        public final void onAdjustVolume(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(i);
        }
    }

    private VolumeProviderCompatApi21() {
    }
}
