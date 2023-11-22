package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public final RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    private Object BuiltInFictitiousFunctionClassFactory;
    private final int PlaceComponentResult;
    private final float getAuthRequestContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Style {
    }

    RatingCompat(int i, float f) {
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.PlaceComponentResult);
        sb.append(" rating=");
        float f = this.getAuthRequestContext;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.PlaceComponentResult;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeFloat(this.getAuthRequestContext);
    }

    public static RatingCompat KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat PlaceComponentResult(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat KClassImpl$Data$declaredNonStaticMembers$2(int i, float f) {
        float f2;
        if (i == 3) {
            f2 = 3.0f;
        } else if (i == 4) {
            f2 = 4.0f;
        } else if (i != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid rating style (");
            sb.append(i);
            sb.append(") for a star rating");
            InstrumentInjector.log_e("Rating", sb.toString());
            return null;
        } else {
            f2 = 5.0f;
        }
        if (f < 0.0f || f > f2) {
            InstrumentInjector.log_e("Rating", "Trying to set out of range star-based rating");
            return null;
        }
        return new RatingCompat(i, f);
    }

    public static RatingCompat BuiltInFictitiousFunctionClassFactory(float f) {
        if (f < 0.0f || f > 100.0f) {
            InstrumentInjector.log_e("Rating", "Invalid percentage-based rating value");
            return null;
        }
        return new RatingCompat(6, f);
    }

    public static RatingCompat PlaceComponentResult(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && Build.VERSION.SDK_INT >= 19) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = KClassImpl$Data$declaredNonStaticMembers$2(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompat = PlaceComponentResult(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = KClassImpl$Data$declaredNonStaticMembers$2(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompat = BuiltInFictitiousFunctionClassFactory(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = KClassImpl$Data$declaredNonStaticMembers$2(ratingStyle);
            }
            ratingCompat.BuiltInFictitiousFunctionClassFactory = obj;
        }
        return ratingCompat;
    }
}
