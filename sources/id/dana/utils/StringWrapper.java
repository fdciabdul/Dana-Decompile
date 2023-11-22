package id.dana.utils;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \u00042\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\t\n\u000b\f"}, d2 = {"Lid/dana/utils/StringWrapper;", "Landroid/os/Parcelable;", "<init>", "()V", "Companion", "ResValue", "ResValuePlurals", "StringLocaleValue", "StringValue", "Lid/dana/utils/StringWrapper$StringValue;", "Lid/dana/utils/StringWrapper$ResValue;", "Lid/dana/utils/StringWrapper$ResValuePlurals;", "Lid/dana/utils/StringWrapper$StringLocaleValue;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class StringWrapper implements Parcelable {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final StringValue PlaceComponentResult = new StringValue("");

    public /* synthetic */ StringWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StringWrapper() {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/utils/StringWrapper$StringValue;", "Lid/dana/utils/StringWrapper;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class StringValue extends StringWrapper {
        public static final Parcelable.Creator<StringValue> CREATOR = new Creator();

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String PlaceComponentResult;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof StringValue) && Intrinsics.areEqual(this.PlaceComponentResult, ((StringValue) p0).PlaceComponentResult);
        }

        public final int hashCode() {
            String str = this.PlaceComponentResult;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StringValue(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.PlaceComponentResult);
        }

        public StringValue(String str) {
            super(null);
            this.PlaceComponentResult = str;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<StringValue> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StringValue createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new StringValue(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StringValue[] newArray(int i) {
                return new StringValue[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013¢\u0006\u0002\b\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013¢\u0006\u0002\b\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/utils/StringWrapper$ResValue;", "Lid/dana/utils/StringWrapper;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lkotlinx/parcelize/RawValue;", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "I", "<init>", "(ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ResValue extends StringWrapper {
        public static final Parcelable.Creator<ResValue> CREATOR = new Creator();

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final List<Object> BuiltInFictitiousFunctionClassFactory;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof ResValue) {
                ResValue resValue = (ResValue) p0;
                return this.PlaceComponentResult == resValue.PlaceComponentResult && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, resValue.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ResValue(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeInt(this.PlaceComponentResult);
            List<Object> list = this.BuiltInFictitiousFunctionClassFactory;
            p0.writeInt(list.size());
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                p0.writeValue(it.next());
            }
        }

        public /* synthetic */ ResValue(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResValue(int i, List<? extends Object> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = list;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<ResValue> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ResValue createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList.add(parcel.readValue(ResValue.class.getClassLoader()));
                }
                return new ResValue(readInt, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ResValue[] newArray(int i) {
                return new ResValue[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B.\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013¢\u0006\u0002\b\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013¢\u0006\u0002\b\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018"}, d2 = {"Lid/dana/utils/StringWrapper$ResValuePlurals;", "Lid/dana/utils/StringWrapper;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lkotlinx/parcelize/RawValue;", "PlaceComponentResult", "Ljava/util/List;", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "p2", "<init>", "(IILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ResValuePlurals extends StringWrapper {
        public static final Parcelable.Creator<ResValuePlurals> CREATOR = new Creator();

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final List<Object> MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final int BuiltInFictitiousFunctionClassFactory;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof ResValuePlurals) {
                ResValuePlurals resValuePlurals = (ResValuePlurals) p0;
                return this.getAuthRequestContext == resValuePlurals.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory == resValuePlurals.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.MyBillsEntityDataFactory, resValuePlurals.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.getAuthRequestContext * 31) + this.BuiltInFictitiousFunctionClassFactory) * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ResValuePlurals(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeInt(this.getAuthRequestContext);
            p0.writeInt(this.BuiltInFictitiousFunctionClassFactory);
            List<Object> list = this.MyBillsEntityDataFactory;
            p0.writeInt(list.size());
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                p0.writeValue(it.next());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResValuePlurals(int i, int i2, List<? extends Object> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.MyBillsEntityDataFactory = list;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<ResValuePlurals> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ResValuePlurals createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt3);
                for (int i = 0; i != readInt3; i++) {
                    arrayList.add(parcel.readValue(ResValuePlurals.class.getClassLoader()));
                }
                return new ResValuePlurals(readInt, readInt2, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ResValuePlurals[] newArray(int i) {
                return new ResValuePlurals[i];
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014"}, d2 = {"Lid/dana/utils/StringWrapper$StringLocaleValue;", "Lid/dana/utils/StringWrapper;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class StringLocaleValue extends StringWrapper {
        public static final Parcelable.Creator<StringLocaleValue> CREATOR = new Creator();

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;
        public final String getAuthRequestContext;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof StringLocaleValue) {
                StringLocaleValue stringLocaleValue = (StringLocaleValue) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, stringLocaleValue.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, stringLocaleValue.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.BuiltInFictitiousFunctionClassFactory;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.getAuthRequestContext;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StringLocaleValue(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.getAuthRequestContext);
        }

        public StringLocaleValue(String str, String str2) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = str2;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<StringLocaleValue> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StringLocaleValue createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new StringLocaleValue(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StringLocaleValue[] newArray(int i) {
                return new StringLocaleValue[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/utils/StringWrapper$Companion;", "", "Lid/dana/utils/StringWrapper$StringValue;", "PlaceComponentResult", "Lid/dana/utils/StringWrapper$StringValue;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/utils/StringWrapper$StringValue;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
