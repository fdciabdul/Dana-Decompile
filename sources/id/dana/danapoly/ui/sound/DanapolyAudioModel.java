package id.dana.danapoly.ui.sound;

import android.media.MediaPlayer;
import android.os.Parcel;
import android.os.Parcelable;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0010\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\u000b8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0010X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u001e\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0010X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0012\u0010\u0014\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0017\u001a\u00020\u0016X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/danapoly/ui/sound/DanapolyAudioModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "BuiltInFictitiousFunctionClassFactory", "Z", "()Z", "PlaceComponentResult", "Lkotlin/Function1;", "Landroid/media/MediaPlayer;", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "getAuthRequestContext", "I", "", "KClassImpl$Data$declaredNonStaticMembers$2", LogConstants.RESULT_FALSE, "p2", "p3", "p4", "<init>", "(IFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyAudioModel implements Parcelable {
    public static final Parcelable.Creator<DanapolyAudioModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    float KClassImpl$Data$declaredNonStaticMembers$2;
    public Function1<? super MediaPlayer, Unit> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    Function1<? super MediaPlayer, Unit> BuiltInFictitiousFunctionClassFactory;
    int getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.getAuthRequestContext);
        p0.writeFloat(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        p0.writeSerializable((Serializable) this.MyBillsEntityDataFactory);
        p0.writeSerializable((Serializable) this.BuiltInFictitiousFunctionClassFactory);
    }

    public DanapolyAudioModel(int i, float f, boolean z, Function1<? super MediaPlayer, Unit> function1, Function1<? super MediaPlayer, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = function1;
        this.BuiltInFictitiousFunctionClassFactory = function12;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public /* synthetic */ DanapolyAudioModel(int i, float f, boolean z, AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? 1.0f : f, z, (i2 & 8) != 0 ? new Function1<MediaPlayer, Unit>() { // from class: id.dana.danapoly.ui.sound.DanapolyAudioModel.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MediaPlayer mediaPlayer) {
                Intrinsics.checkNotNullParameter(mediaPlayer, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MediaPlayer mediaPlayer) {
                invoke2(mediaPlayer);
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i2 & 16) != 0 ? new Function1<MediaPlayer, Unit>() { // from class: id.dana.danapoly.ui.sound.DanapolyAudioModel.2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MediaPlayer mediaPlayer) {
                Intrinsics.checkNotNullParameter(mediaPlayer, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MediaPlayer mediaPlayer) {
                invoke2(mediaPlayer);
                return Unit.INSTANCE;
            }
        } : anonymousClass2);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<DanapolyAudioModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DanapolyAudioModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new DanapolyAudioModel(parcel.readInt(), parcel.readFloat(), parcel.readInt() != 0, (Function1) parcel.readSerializable(), (Function1) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DanapolyAudioModel[] newArray(int i) {
            return new DanapolyAudioModel[i];
        }
    }
}
