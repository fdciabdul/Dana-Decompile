package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        public final PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public final PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    final long BuiltInFictitiousFunctionClassFactory;
    final long DatabaseTableConfigUtil;
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    List<CustomAction> MyBillsEntityDataFactory;
    final float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Object NetworkUserEntityData$$ExternalSyntheticLambda1;
    final int PlaceComponentResult;
    final long getAuthRequestContext;
    final Bundle getErrorConfigVersion;
    final CharSequence lookAheadTest;
    final long moveToNextValue;
    final int scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Actions {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface State {
    }

    public static int PlaceComponentResult(long j) {
        if (j == 4) {
            return 126;
        }
        if (j == 2) {
            return 127;
        }
        if (j == 32) {
            return 87;
        }
        if (j == 16) {
            return 88;
        }
        if (j == 1) {
            return 86;
        }
        if (j == 64) {
            return 90;
        }
        if (j == 8) {
            return 89;
        }
        return j == 512 ? 85 : 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.scheduleImpl = i;
        this.moveToNextValue = j;
        this.BuiltInFictitiousFunctionClassFactory = j2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
        this.getAuthRequestContext = j3;
        this.PlaceComponentResult = i2;
        this.lookAheadTest = charSequence;
        this.DatabaseTableConfigUtil = j4;
        this.MyBillsEntityDataFactory = new ArrayList(list);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j5;
        this.getErrorConfigVersion = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.scheduleImpl = parcel.readInt();
        this.moveToNextValue = parcel.readLong();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readFloat();
        this.DatabaseTableConfigUtil = parcel.readLong();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readLong();
        this.getAuthRequestContext = parcel.readLong();
        this.lookAheadTest = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.MyBillsEntityDataFactory = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readLong();
        this.getErrorConfigVersion = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.PlaceComponentResult = parcel.readInt();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=");
        sb.append(this.scheduleImpl);
        sb.append(", position=");
        sb.append(this.moveToNextValue);
        sb.append(", buffered position=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", speed=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", updated=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", actions=");
        sb.append(this.getAuthRequestContext);
        sb.append(", error code=");
        sb.append(this.PlaceComponentResult);
        sb.append(", error message=");
        sb.append(this.lookAheadTest);
        sb.append(", custom actions=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", active item id=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.scheduleImpl);
        parcel.writeLong(this.moveToNextValue);
        parcel.writeFloat(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeLong(this.DatabaseTableConfigUtil);
        parcel.writeLong(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeLong(this.getAuthRequestContext);
        TextUtils.writeToParcel(this.lookAheadTest, parcel, i);
        parcel.writeTypedList(this.MyBillsEntityDataFactory);
        parcel.writeLong(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeBundle(this.getErrorConfigVersion);
        parcel.writeInt(this.PlaceComponentResult);
    }

    public final int PlaceComponentResult() {
        return this.scheduleImpl;
    }

    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }

    public final long BuiltInFictitiousFunctionClassFactory() {
        return this.DatabaseTableConfigUtil;
    }

    public final float getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final long MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    public static PlaybackStateCompat getAuthRequestContext(Object obj) {
        List<Object> customActions;
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        customActions = ((PlaybackState) obj).getCustomActions();
        if (customActions != null) {
            ArrayList arrayList2 = new ArrayList(customActions.size());
            Iterator<Object> it = customActions.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.KClassImpl$Data$declaredNonStaticMembers$2(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.scheduleImpl(obj), PlaybackStateCompatApi21.moveToNextValue(obj), PlaybackStateCompatApi21.PlaceComponentResult(obj), PlaybackStateCompatApi21.getErrorConfigVersion(obj), PlaybackStateCompatApi21.getAuthRequestContext(obj), 0, PlaybackStateCompatApi21.BuiltInFictitiousFunctionClassFactory(obj), PlaybackStateCompatApi21.lookAheadTest(obj), arrayList, PlaybackStateCompatApi21.MyBillsEntityDataFactory(obj), Build.VERSION.SDK_INT >= 22 ? ((PlaybackState) obj).getExtras() : null);
        playbackStateCompat.NetworkUserEntityData$$ExternalSyntheticLambda1 = obj;
        return playbackStateCompat;
    }

    /* loaded from: classes6.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
            public final CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public final CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final String BuiltInFictitiousFunctionClassFactory;
        private final CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final Bundle PlaceComponentResult;
        private Object getAuthRequestContext;

        /* loaded from: classes6.dex */
        public static final class Builder {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = charSequence;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = bundle;
        }

        CustomAction(Parcel parcel) {
            this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.MyBillsEntityDataFactory = parcel.readInt();
            this.PlaceComponentResult = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
            TextUtils.writeToParcel(this.KClassImpl$Data$declaredNonStaticMembers$2, parcel, i);
            parcel.writeInt(this.MyBillsEntityDataFactory);
            parcel.writeBundle(this.PlaceComponentResult);
        }

        public static CustomAction KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            String action;
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            action = ((PlaybackState.CustomAction) obj).getAction();
            CustomAction customAction = new CustomAction(action, PlaybackStateCompatApi21.CustomAction.BuiltInFictitiousFunctionClassFactory(obj), PlaybackStateCompatApi21.CustomAction.PlaceComponentResult(obj), PlaybackStateCompatApi21.CustomAction.getAuthRequestContext(obj));
            customAction.getAuthRequestContext = obj;
            return customAction;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Action:mName='");
            sb.append((Object) this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", mIcon=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", mExtras=");
            sb.append(this.PlaceComponentResult);
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        private final List<CustomAction> BuiltInFictitiousFunctionClassFactory;
        private long KClassImpl$Data$declaredNonStaticMembers$2;
        private long MyBillsEntityDataFactory;
        private CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0;
        private long NetworkUserEntityData$$ExternalSyntheticLambda2;
        private long PlaceComponentResult;
        private int getAuthRequestContext;
        private Bundle getErrorConfigVersion;
        private float lookAheadTest;
        private int moveToNextValue;
        private long scheduleImpl;

        public Builder() {
            this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            this.MyBillsEntityDataFactory = -1L;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.BuiltInFictitiousFunctionClassFactory = arrayList;
            this.MyBillsEntityDataFactory = -1L;
            this.moveToNextValue = playbackStateCompat.scheduleImpl;
            this.scheduleImpl = playbackStateCompat.moveToNextValue;
            this.lookAheadTest = playbackStateCompat.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = playbackStateCompat.DatabaseTableConfigUtil;
            this.PlaceComponentResult = playbackStateCompat.BuiltInFictitiousFunctionClassFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = playbackStateCompat.getAuthRequestContext;
            this.getAuthRequestContext = playbackStateCompat.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = playbackStateCompat.lookAheadTest;
            if (playbackStateCompat.MyBillsEntityDataFactory != null) {
                arrayList.addAll(playbackStateCompat.MyBillsEntityDataFactory);
            }
            this.MyBillsEntityDataFactory = playbackStateCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getErrorConfigVersion = playbackStateCompat.getErrorConfigVersion;
        }

        public final Builder getAuthRequestContext(int i, long j, float f, long j2) {
            this.moveToNextValue = i;
            this.scheduleImpl = j;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = j2;
            this.lookAheadTest = f;
            return this;
        }

        public final PlaybackStateCompat KClassImpl$Data$declaredNonStaticMembers$2() {
            return new PlaybackStateCompat(this.moveToNextValue, this.scheduleImpl, this.PlaceComponentResult, this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getErrorConfigVersion);
        }
    }
}
