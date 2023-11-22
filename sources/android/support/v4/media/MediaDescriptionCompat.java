package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

/* loaded from: classes6.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public final MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.PlaceComponentResult(MediaDescriptionCompatApi21.BuiltInFictitiousFunctionClassFactory(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public final MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private Object BuiltInFictitiousFunctionClassFactory;
    private final Uri KClassImpl$Data$declaredNonStaticMembers$2;
    private final CharSequence MyBillsEntityDataFactory;
    private final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Bitmap PlaceComponentResult;
    private final Bundle getAuthRequestContext;
    private final CharSequence getErrorConfigVersion;
    private final Uri moveToNextValue;
    private final String scheduleImpl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.scheduleImpl = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = charSequence;
        this.getErrorConfigVersion = charSequence2;
        this.MyBillsEntityDataFactory = charSequence3;
        this.PlaceComponentResult = bitmap;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uri;
        this.getAuthRequestContext = bundle;
        this.moveToNextValue = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.scheduleImpl = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.getErrorConfigVersion = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.MyBillsEntityDataFactory = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.PlaceComponentResult = (Bitmap) parcel.readParcelable(classLoader);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (Uri) parcel.readParcelable(classLoader);
        this.getAuthRequestContext = parcel.readBundle(classLoader);
        this.moveToNextValue = (Uri) parcel.readParcelable(classLoader);
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        return this.scheduleImpl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.scheduleImpl);
            TextUtils.writeToParcel(this.NetworkUserEntityData$$ExternalSyntheticLambda0, parcel, i);
            TextUtils.writeToParcel(this.getErrorConfigVersion, parcel, i);
            TextUtils.writeToParcel(this.MyBillsEntityDataFactory, parcel, i);
            parcel.writeParcelable(this.PlaceComponentResult, i);
            parcel.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
            parcel.writeBundle(this.getAuthRequestContext);
            parcel.writeParcelable(this.moveToNextValue, i);
            return;
        }
        MediaDescriptionCompatApi21.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(), parcel, i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", ");
        sb.append((Object) this.getErrorConfigVersion);
        sb.append(", ");
        sb.append((Object) this.MyBillsEntityDataFactory);
        return sb.toString();
    }

    public final Object KClassImpl$Data$declaredNonStaticMembers$2() {
        Object build;
        if (this.BuiltInFictitiousFunctionClassFactory != null || Build.VERSION.SDK_INT < 21) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        Object PlaceComponentResult = MediaDescriptionCompatApi21.Builder.PlaceComponentResult();
        MediaDescriptionCompatApi21.Builder.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, this.scheduleImpl);
        MediaDescriptionCompatApi21.Builder.MyBillsEntityDataFactory(PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        MediaDescriptionCompatApi21.Builder.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, this.getErrorConfigVersion);
        MediaDescriptionCompatApi21.Builder.PlaceComponentResult(PlaceComponentResult, this.MyBillsEntityDataFactory);
        MediaDescriptionCompatApi21.Builder.getAuthRequestContext(PlaceComponentResult, this.PlaceComponentResult);
        MediaDescriptionCompatApi21.Builder.getAuthRequestContext(PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        Bundle bundle = this.getAuthRequestContext;
        if (Build.VERSION.SDK_INT < 23 && this.moveToNextValue != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.moveToNextValue);
        }
        ((MediaDescription.Builder) PlaceComponentResult).setExtras(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.PlaceComponentResult(PlaceComponentResult, this.moveToNextValue);
        }
        build = ((MediaDescription.Builder) PlaceComponentResult).build();
        this.BuiltInFictitiousFunctionClassFactory = build;
        return build;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.support.v4.media.MediaDescriptionCompat PlaceComponentResult(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L7f
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L7f
            android.support.v4.media.MediaDescriptionCompat$Builder r1 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.MediaDescriptionCompatApi21.BuiltInFictitiousFunctionClassFactory(r8)
            r1.getAuthRequestContext(r2)
            java.lang.CharSequence r2 = android.support.v4.media.MediaDescriptionCompatApi21.getErrorConfigVersion(r8)
            r1.PlaceComponentResult(r2)
            java.lang.CharSequence r2 = android.support.v4.media.MediaDescriptionCompatApi21.lookAheadTest(r8)
            r1.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            java.lang.CharSequence r2 = android.support.v4.media.MediaDescriptionCompatApi21.KClassImpl$Data$declaredNonStaticMembers$2(r8)
            r1.getAuthRequestContext(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.MediaDescriptionCompatApi21.PlaceComponentResult(r8)
            r1.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            android.net.Uri r2 = android.support.v4.media.MediaDescriptionCompatApi21.MyBillsEntityDataFactory(r8)
            r1.MyBillsEntityDataFactory(r2)
            android.os.Bundle r2 = android.support.v4.media.MediaDescriptionCompatApi21.getAuthRequestContext(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L4a
            android.support.v4.media.session.MediaSessionCompat.PlaceComponentResult(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L4b
        L4a:
            r4 = r0
        L4b:
            if (r4 == 0) goto L62
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L5c
            int r6 = r2.size()
            r7 = 2
            if (r6 == r7) goto L63
        L5c:
            r2.remove(r3)
            r2.remove(r5)
        L62:
            r0 = r2
        L63:
            r1.MyBillsEntityDataFactory(r0)
            if (r4 == 0) goto L6c
            r1.PlaceComponentResult(r4)
            goto L79
        L6c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L79
            android.net.Uri r0 = android.support.v4.media.MediaDescriptionCompatApi23.getAuthRequestContext(r8)
            r1.PlaceComponentResult(r0)
        L79:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.BuiltInFictitiousFunctionClassFactory()
            r0.BuiltInFictitiousFunctionClassFactory = r8
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.PlaceComponentResult(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        private String BuiltInFictitiousFunctionClassFactory;
        private Bundle KClassImpl$Data$declaredNonStaticMembers$2;
        private CharSequence MyBillsEntityDataFactory;
        private Uri NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Uri PlaceComponentResult;
        private Bitmap getAuthRequestContext;
        private CharSequence getErrorConfigVersion;
        private CharSequence lookAheadTest;

        public final Builder getAuthRequestContext(String str) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            return this;
        }

        public final Builder PlaceComponentResult(CharSequence charSequence) {
            this.getErrorConfigVersion = charSequence;
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            this.lookAheadTest = charSequence;
            return this;
        }

        public final Builder getAuthRequestContext(CharSequence charSequence) {
            this.MyBillsEntityDataFactory = charSequence;
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap) {
            this.getAuthRequestContext = bitmap;
            return this;
        }

        public final Builder MyBillsEntityDataFactory(Uri uri) {
            this.PlaceComponentResult = uri;
            return this;
        }

        public final Builder MyBillsEntityDataFactory(Bundle bundle) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
            return this;
        }

        public final Builder PlaceComponentResult(Uri uri) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = uri;
            return this;
        }

        public final MediaDescriptionCompat BuiltInFictitiousFunctionClassFactory() {
            return new MediaDescriptionCompat(this.BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion, this.lookAheadTest, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
    }
}
