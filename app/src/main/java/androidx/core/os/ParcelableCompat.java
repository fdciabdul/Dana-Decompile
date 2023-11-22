package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: classes6.dex */
public final class ParcelableCompat {

    /* loaded from: classes6.dex */
    static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        private final ParcelableCompatCreatorCallbacks<T> getAuthRequestContext;

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i) {
            return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i);
        }
    }

    private ParcelableCompat() {
    }
}
