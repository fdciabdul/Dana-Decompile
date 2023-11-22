package id.dana.mybills.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.mybills.ui.constant.MyBillsServiceKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J`\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\u0016J\r\u0010\"\u001a\u00020\u0019¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0019¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020\u0019¢\u0006\u0004\b%\u0010#J\r\u0010&\u001a\u00020\u0019¢\u0006\u0004\b&\u0010#J\r\u0010'\u001a\u00020\u0019¢\u0006\u0004\b'\u0010#J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b-\u0010.R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b2\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b3\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b4\u0010\u0004R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010/\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u00107R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b8\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/model/MyBillsServiceModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "key", "name", "nameInd", "icon", "link", "userAction", "source", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/ui/model/MyBillsServiceModel;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "getArrayOfBizType", "()[Ljava/lang/String;", "getBizProductCode", "getBizType", "hashCode", "isBpjs", "()Z", "isDigitalVoucher", "isMobilePostpaid", "isPgn", "isTelkom", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getIcon", "getKey", "getLink", "getName", "getNameInd", "getSource", "setSource", "(Ljava/lang/String;)V", "getUserAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MyBillsServiceModel implements Parcelable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    public static final Parcelable.Creator<MyBillsServiceModel> CREATOR;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private static int MyBillsEntityDataFactory = 0;
    private static char[] PlaceComponentResult = null;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    private final String icon;
    private final String key;
    private final String link;
    private final String name;
    private final String nameInd;
    private String source;
    private final String userAction;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<MyBillsServiceModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyBillsServiceModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MyBillsServiceModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyBillsServiceModel[] newArray(int i) {
            return new MyBillsServiceModel[i];
        }
    }

    static {
        PlaceComponentResult();
        CREATOR = new Creator();
        int i = MyBillsEntityDataFactory + 97;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? (char) 23 : '.') != '.') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    static void PlaceComponentResult() {
        PlaceComponentResult = new char[]{39535, 39549, 39534, 39530, 39545, 39551, 39427, 39541, 39539, 39550, 39540, 39544, 39425, 39547};
        KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory = true;
        getAuthRequestContext = 909155296;
    }

    public static /* synthetic */ MyBillsServiceModel copy$default(MyBillsServiceModel myBillsServiceModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            try {
                int i2 = getErrorConfigVersion + 113;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                try {
                    str = myBillsServiceModel.key;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        String str8 = str;
        if ((i & 2) != 0) {
            str2 = myBillsServiceModel.name;
        }
        String str9 = str2;
        if (!((i & 4) == 0)) {
            str3 = myBillsServiceModel.nameInd;
            int i4 = getErrorConfigVersion + 117;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
        }
        String str10 = str3;
        if ((i & 8) != 0) {
            int i6 = MyBillsEntityDataFactory + 125;
            getErrorConfigVersion = i6 % 128;
            int i7 = i6 % 2;
            str4 = myBillsServiceModel.icon;
        }
        String str11 = str4;
        if ((i & 16) != 0) {
            str5 = myBillsServiceModel.link;
        }
        String str12 = str5;
        if (((i & 32) != 0 ? '1' : ':') == '1') {
            int i8 = MyBillsEntityDataFactory + 59;
            getErrorConfigVersion = i8 % 128;
            int i9 = i8 % 2;
            str6 = myBillsServiceModel.userAction;
        }
        String str13 = str6;
        if ((i & 64) != 0) {
            int i10 = getErrorConfigVersion + 19;
            MyBillsEntityDataFactory = i10 % 128;
            int i11 = i10 % 2;
            str7 = myBillsServiceModel.source;
        }
        return myBillsServiceModel.copy(str8, str9, str10, str11, str12, str13, str7);
    }

    public final String component1() {
        int i = MyBillsEntityDataFactory + 23;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String str = this.key;
        try {
            int i3 = getErrorConfigVersion + 9;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 27 : ']') != 27) {
                return str;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String component2() {
        int i = MyBillsEntityDataFactory + 39;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String str = this.name;
        int i3 = MyBillsEntityDataFactory + 57;
        getErrorConfigVersion = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 15 / 0;
            return str;
        }
        return str;
    }

    public final String component3() {
        int i = MyBillsEntityDataFactory + 3;
        getErrorConfigVersion = i % 128;
        if (i % 2 == 0) {
            String str = this.nameInd;
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return this.nameInd;
    }

    public final String component4() {
        int i = getErrorConfigVersion + 39;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? Typography.quote : (char) 23) != '\"') {
            return this.icon;
        }
        String str = this.icon;
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public final String component5() {
        int i = getErrorConfigVersion + 47;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? JSONLexer.EOI : 'Z') != 26) {
            return this.link;
        }
        String str = this.link;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public final String component6() {
        int i = MyBillsEntityDataFactory + 63;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            String str = this.userAction;
            try {
                int i3 = getErrorConfigVersion + 105;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String component7() {
        int i = getErrorConfigVersion + 95;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String str = this.source;
        int i3 = MyBillsEntityDataFactory + 53;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public final MyBillsServiceModel copy(String key, String name, String nameInd, String icon, String link, String userAction, String source) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(source, "");
        MyBillsServiceModel myBillsServiceModel = new MyBillsServiceModel(key, name, nameInd, icon, link, userAction, source);
        try {
            int i = getErrorConfigVersion + 109;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return myBillsServiceModel;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        int i = MyBillsEntityDataFactory + 15;
        getErrorConfigVersion = i % 128;
        return i % 2 == 0 ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if ((r5 != r6) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if ((r6 instanceof id.dana.mybills.ui.model.MyBillsServiceModel) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        r6 = (id.dana.mybills.ui.model.MyBillsServiceModel) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.key, r6.key) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r6 = id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion + 85;
        id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.name, r6.name) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        r0 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        r0 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        if (r0 == '\r') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.nameInd, r6.nameInd) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.icon, r6.icon) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.link, r6.link) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.userAction, r6.userAction) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0083, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.source, r6.source) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
    
        r6 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0087, code lost:
    
        r6 = '5';
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
    
        if (r6 == '5') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
    
        r6 = id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion + 51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0091, code lost:
    
        id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0098, code lost:
    
        r6 = id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory + 39;
        id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a1, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r5 == r6) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L17
            r0 = 58
            int r0 = r0 / r3
            if (r5 != r6) goto L1e
            goto L98
        L15:
            r6 = move-exception
            throw r6
        L17:
            if (r5 != r6) goto L1b
            r0 = 0
            goto L1c
        L1b:
            r0 = 1
        L1c:
            if (r0 == 0) goto L98
        L1e:
            boolean r0 = r6 instanceof id.dana.mybills.ui.model.MyBillsServiceModel
            if (r0 != 0) goto L23
            return r3
        L23:
            id.dana.mybills.ui.model.MyBillsServiceModel r6 = (id.dana.mybills.ui.model.MyBillsServiceModel) r6
            java.lang.String r0 = r5.key
            java.lang.String r4 = r6.key
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L39
            int r6 = id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion
            int r6 = r6 + 85
            int r0 = r6 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory = r0
            int r6 = r6 % r1
            return r3
        L39:
            java.lang.String r0 = r5.name
            java.lang.String r4 = r6.name
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            r4 = 13
            if (r0 != 0) goto L48
            r0 = 26
            goto L4a
        L48:
            r0 = 13
        L4a:
            if (r0 == r4) goto L4d
            return r3
        L4d:
            java.lang.String r0 = r5.nameInd
            java.lang.String r4 = r6.nameInd
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L58
            return r3
        L58:
            java.lang.String r0 = r5.icon
            java.lang.String r4 = r6.icon
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L63
            return r3
        L63:
            java.lang.String r0 = r5.link
            java.lang.String r4 = r6.link
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L6e
            return r3
        L6e:
            java.lang.String r0 = r5.userAction
            java.lang.String r4 = r6.userAction
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L79
            return r3
        L79:
            java.lang.String r0 = r5.source
            java.lang.String r6 = r6.source
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)
            r0 = 53
            if (r6 != 0) goto L87
            r6 = 2
            goto L89
        L87:
            r6 = 53
        L89:
            if (r6 == r0) goto L97
            int r6 = id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion     // Catch: java.lang.Exception -> L95
            int r6 = r6 + 51
            int r0 = r6 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L95
            int r6 = r6 % r1
            return r3
        L95:
            r6 = move-exception
            throw r6
        L97:
            return r2
        L98:
            int r6 = id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory
            int r6 = r6 + 39
            int r0 = r6 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion = r0
            int r6 = r6 % r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.model.MyBillsServiceModel.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = this.key.hashCode();
        String str = this.name;
        int i = 0;
        int hashCode5 = !(str == null) ? str.hashCode() : 0;
        String str2 = this.nameInd;
        if (str2 == null) {
            int i2 = MyBillsEntityDataFactory + 57;
            getErrorConfigVersion = i2 % 128;
            hashCode = i2 % 2 == 0 ? 1 : 0;
        } else {
            hashCode = str2.hashCode();
        }
        String str3 = this.icon;
        if (str3 == null) {
            int i3 = MyBillsEntityDataFactory + 1;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            int i5 = MyBillsEntityDataFactory + 19;
            getErrorConfigVersion = i5 % 128;
            int i6 = i5 % 2;
            hashCode2 = 0;
        } else {
            hashCode2 = str3.hashCode();
        }
        String str4 = this.link;
        if (str4 == null) {
            int i7 = getErrorConfigVersion + 55;
            MyBillsEntityDataFactory = i7 % 128;
            int i8 = i7 % 2;
            hashCode3 = 0;
        } else {
            hashCode3 = str4.hashCode();
        }
        String str5 = this.userAction;
        if (str5 != null) {
            i = str5.hashCode();
            int i9 = MyBillsEntityDataFactory + 29;
            getErrorConfigVersion = i9 % 128;
            int i10 = i9 % 2;
        }
        return (((((((((((hashCode4 * 31) + hashCode5) * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + this.source.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillsServiceModel(key=");
        sb.append(this.key);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", nameInd=");
        sb.append(this.nameInd);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", link=");
        sb.append(this.link);
        sb.append(", userAction=");
        sb.append(this.userAction);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(')');
        String obj = sb.toString();
        int i = getErrorConfigVersion + 125;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return obj;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        int i = getErrorConfigVersion + 19;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.key);
        parcel.writeString(this.name);
        parcel.writeString(this.nameInd);
        parcel.writeString(this.icon);
        parcel.writeString(this.link);
        parcel.writeString(this.userAction);
        parcel.writeString(this.source);
        int i3 = MyBillsEntityDataFactory + 93;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
    }

    public MyBillsServiceModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.key = str;
        this.name = str2;
        this.nameInd = str3;
        this.icon = str4;
        this.link = str5;
        this.userAction = str6;
        this.source = str7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ MyBillsServiceModel(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 64
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8
            r0 = 0
            goto L9
        L8:
            r0 = 1
        L9:
            if (r0 == r2) goto L32
            int r0 = id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion     // Catch: java.lang.Exception -> L30
            int r0 = r0 + 27
            int r3 = r0 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L30
            int r0 = r0 % 2
            if (r0 == 0) goto L18
            r1 = 1
        L18:
            if (r1 == 0) goto L22
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L1f
            goto L22
        L1f:
            r0 = move-exception
            r1 = r0
            throw r1
        L22:
            int r0 = id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            r8 = r0
            goto L34
        L30:
            r0 = move-exception
            throw r0
        L32:
            r8 = r16
        L34:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.model.MyBillsServiceModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        try {
            int i = MyBillsEntityDataFactory + 97;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            try {
                String str = this.key;
                int i3 = MyBillsEntityDataFactory + 7;
                getErrorConfigVersion = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    int i4 = 7 / 0;
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getName")
    public final String getName() {
        String str;
        try {
            int i = MyBillsEntityDataFactory + 79;
            getErrorConfigVersion = i % 128;
            if ((i % 2 == 0 ? '=' : '\\') != '\\') {
                str = this.name;
                int i2 = 65 / 0;
            } else {
                str = this.name;
            }
            int i3 = MyBillsEntityDataFactory + 41;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 == 0 ? 'Y' : (char) 28) != 'Y') {
                return str;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getNameInd")
    public final String getNameInd() {
        int i = MyBillsEntityDataFactory + 43;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String str = this.nameInd;
        int i3 = getErrorConfigVersion + 77;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        int i = getErrorConfigVersion + 65;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 == 0)) {
            String str = this.icon;
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return this.icon;
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        String str;
        int i = getErrorConfigVersion + 7;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? '`' : '*') != '*') {
            str = this.link;
            Object obj = null;
            obj.hashCode();
        } else {
            str = this.link;
        }
        int i2 = MyBillsEntityDataFactory + 7;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
        return str;
    }

    @JvmName(name = "getUserAction")
    public final String getUserAction() {
        int i = getErrorConfigVersion + 53;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String str = this.userAction;
        int i3 = MyBillsEntityDataFactory + 119;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    @JvmName(name = "getSource")
    public final String getSource() {
        int i = getErrorConfigVersion + 5;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String str = this.source;
        int i3 = MyBillsEntityDataFactory + 85;
        getErrorConfigVersion = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x002b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "setSource")
    public final void setSource(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L29
            r2.source = r3     // Catch: java.lang.Exception -> L29
            int r3 = id.dana.mybills.ui.model.MyBillsServiceModel.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L29
            int r3 = r3 + 115
            int r0 = r3 % 128
            id.dana.mybills.ui.model.MyBillsServiceModel.getErrorConfigVersion = r0     // Catch: java.lang.Exception -> L29
            int r3 = r3 % 2
            r0 = 1
            if (r3 != 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r3 == r0) goto L24
            return
        L24:
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L27
            return
        L27:
            r3 = move-exception
            throw r3
        L29:
            r3 = move-exception
            throw r3
        L2b:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.model.MyBillsServiceModel.setSource(java.lang.String):void");
    }

    public final boolean isTelkom() {
        int i = getErrorConfigVersion + 3;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? (char) 15 : (char) 27) != 27) {
            boolean areEqual = Intrinsics.areEqual(this.key, MyBillsServiceKey.TELEPHONE);
            Object[] objArr = null;
            int length = objArr.length;
            return areEqual;
        }
        return Intrinsics.areEqual(this.key, MyBillsServiceKey.TELEPHONE);
    }

    public final boolean isPgn() {
        int i = MyBillsEntityDataFactory + 43;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        boolean areEqual = Intrinsics.areEqual(this.key, MyBillsServiceKey.GAS_PGN);
        int i3 = MyBillsEntityDataFactory + 5;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? 'c' : (char) 21) != 'c') {
            return areEqual;
        }
        Object obj = null;
        obj.hashCode();
        return areEqual;
    }

    public final boolean isBpjs() {
        int i = MyBillsEntityDataFactory + 29;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        boolean areEqual = Intrinsics.areEqual(this.key, MyBillsServiceKey.BPJS);
        int i3 = getErrorConfigVersion + 119;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 != 0 ? '=' : (char) 24) != '=') {
            return areEqual;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return areEqual;
    }

    public final boolean isMobilePostpaid() {
        int i = getErrorConfigVersion + 15;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            return Intrinsics.areEqual(this.key, MyBillsServiceKey.MOBILE_POSTPAID);
        }
        int i2 = 85 / 0;
        return Intrinsics.areEqual(this.key, MyBillsServiceKey.MOBILE_POSTPAID);
    }

    public final boolean isDigitalVoucher() {
        try {
            int i = getErrorConfigVersion + 13;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 == 0) {
                return Intrinsics.areEqual(this.key, MyBillsServiceKey.DIGITAL_VOUCHER);
            }
            int i2 = 8 / 0;
            return Intrinsics.areEqual(this.key, MyBillsServiceKey.DIGITAL_VOUCHER);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00ca A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getBizProductCode() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.model.MyBillsServiceModel.getBizProductCode():java.lang.String");
    }

    public final String getBizType() {
        int i = MyBillsEntityDataFactory + 43;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String str = this.key;
        switch (str.hashCode()) {
            case -2061803349:
                if (str.equals(MyBillsServiceKey.DIGITAL_VOUCHER)) {
                    return "GAME_VOUCHER";
                }
                break;
            case -1844295216:
                if (str.equals(MyBillsServiceKey.INSURANCE)) {
                    int i3 = MyBillsEntityDataFactory + 47;
                    getErrorConfigVersion = i3 % 128;
                    int i4 = i3 % 2;
                    return "INSURANCE";
                }
                break;
            case -1720298739:
                if (!(str.equals(MyBillsServiceKey.WATER) ? false : true)) {
                    return "WATER";
                }
                break;
            case -1134143750:
                if (str.equals(MyBillsServiceKey.TELEPHONE)) {
                    return "PHONE";
                }
                break;
            case -692436776:
                if (str.equals(MyBillsServiceKey.MOBILE_POSTPAID)) {
                    return "MOBILE_POSTPAID";
                }
                break;
            case 359536993:
                if (str.equals(MyBillsServiceKey.BPJS)) {
                    return "BPJS";
                }
                break;
            case 930525159:
                if (str.equals(MyBillsServiceKey.ELECTRICITY)) {
                    int i5 = MyBillsEntityDataFactory + 99;
                    getErrorConfigVersion = i5 % 128;
                    if (i5 % 2 == 0) {
                        int i6 = 42 / 0;
                        return "ELECTRICITY";
                    }
                    return "ELECTRICITY";
                }
                break;
            case 1854830795:
                if (str.equals(MyBillsServiceKey.INTERNET_CABLE_TV)) {
                    return "INTERNET";
                }
                break;
            case 2038502419:
                Object[] objArr = new Object[1];
                a(TextUtils.lastIndexOf("", '0') + 128, new byte[]{-126, -114, -125, -115, -116, -122, -126, -125, -126, -117, -123, -118, -119, -120, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr);
                if (str.equals(((String) objArr[0]).intern())) {
                    return "PULSA_PREPAID";
                }
                break;
            case 2047228072:
                if (!(str.equals(MyBillsServiceKey.GAS_PGN) ? false : true)) {
                    return "PGN";
                }
                break;
            case 2116661999:
                if (str.equals(MyBillsServiceKey.INSTALLMENT)) {
                    return "INSTALLMENT";
                }
                break;
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        if (r0.equals(id.dana.mybills.ui.constant.MyBillsServiceKey.ELECTRICITY) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e4, code lost:
    
        if (r0.equals(id.dana.mybills.ui.constant.MyBillsServiceKey.ELECTRICITY_REVAMP) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return new java.lang.String[]{"ELECTRICITY", "ELECTRICITY_POST"};
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String[] getArrayOfBizType() {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.model.MyBillsServiceModel.getArrayOfBizType():java.lang.String[]");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = PlaceComponentResult;
        if ((cArr3 != null ? '6' : 'H') != 'H') {
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr4[i2] = (char) (cArr3[i2] ^ 4571606982258105150L);
            }
            cArr3 = cArr4;
        }
        int i3 = (int) (getAuthRequestContext ^ 4571606982258105150L);
        if ((BuiltInFictitiousFunctionClassFactory ? '%' : (char) 16) == '%') {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            int i4 = $11 + 15;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        if ((KClassImpl$Data$declaredNonStaticMembers$2 ? (char) 31 : '@') != '@') {
            int i6 = $10 + 79;
            $11 = i6 % 128;
            if ((i6 % 2 == 0 ? '\f' : (char) 7) != '\f') {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 1;
            }
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr2[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr2);
            return;
        }
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                String str = new String(cArr6);
                int i7 = $11 + 3;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                objArr[0] = str;
                return;
            }
            int i9 = $11 + 121;
            $10 = i9 % 128;
            if (i9 % 2 != 0) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 1) + bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >>> i] * i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >>>= 1;
            } else {
                try {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }
}
