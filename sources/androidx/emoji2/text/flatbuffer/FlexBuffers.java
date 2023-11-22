package androidx.emoji2.text.flatbuffer;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.UShort;
import kotlin.text.Typography;

/* loaded from: classes6.dex */
public class FlexBuffers {
    private static final ReadBuf KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayReadWriteBuf(new byte[]{0}, (byte) 0);

    static boolean PlaceComponentResult(int i) {
        return (i >= 11 && i <= 15) || i == 36;
    }

    static int getAuthRequestContext(int i) {
        return (i - 11) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long moveToNextValue(ReadBuf readBuf, int i, int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 8) {
                        return -1L;
                    }
                    return readBuf.MyBillsEntityDataFactory(i);
                }
                return Unsigned.KClassImpl$Data$declaredNonStaticMembers$2(readBuf.KClassImpl$Data$declaredNonStaticMembers$2(i));
            }
            return Unsigned.BuiltInFictitiousFunctionClassFactory(readBuf.NetworkUserEntityData$$ExternalSyntheticLambda0(i));
        }
        return Unsigned.getAuthRequestContext(readBuf.BuiltInFictitiousFunctionClassFactory(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long scheduleImpl(ReadBuf readBuf, int i, int i2) {
        int BuiltInFictitiousFunctionClassFactory;
        if (i2 == 1) {
            BuiltInFictitiousFunctionClassFactory = readBuf.BuiltInFictitiousFunctionClassFactory(i);
        } else if (i2 == 2) {
            BuiltInFictitiousFunctionClassFactory = readBuf.NetworkUserEntityData$$ExternalSyntheticLambda0(i);
        } else if (i2 != 4) {
            if (i2 != 8) {
                return -1L;
            }
            return readBuf.MyBillsEntityDataFactory(i);
        } else {
            BuiltInFictitiousFunctionClassFactory = readBuf.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes6.dex */
    public static class Reference {
        private static final Reference getAuthRequestContext = new Reference(FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2, 0, 1, 0);
        private int BuiltInFictitiousFunctionClassFactory;
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        private ReadBuf MyBillsEntityDataFactory;
        private int NetworkUserEntityData$$ExternalSyntheticLambda0;
        private int PlaceComponentResult;

        Reference(ReadBuf readBuf, int i, int i2, int i3) {
            this(readBuf, i, i2, 1 << (i3 & 3), i3 >> 2);
        }

        Reference(ReadBuf readBuf, int i, int i2, int i3, int i4) {
            this.MyBillsEntityDataFactory = readBuf;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.PlaceComponentResult = i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i4;
        }

        private boolean DatabaseTableConfigUtil() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 26;
        }

        private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 5;
        }

        private boolean initRecordTimeStamp() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 4;
        }

        private boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            return i == 10 || i == 9;
        }

        private boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 9;
        }

        private boolean GetContactSyncConfig() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 25;
        }

        private long moveToNextValue() {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i == 2) {
                return FlexBuffers.moveToNextValue(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (i != 1) {
                if (i != 3) {
                    if (i != 10) {
                        if (i != 26) {
                            if (i != 5) {
                                if (i == 6) {
                                    ReadBuf readBuf = this.MyBillsEntityDataFactory;
                                    return FlexBuffers.scheduleImpl(readBuf, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
                                } else if (i == 7) {
                                    ReadBuf readBuf2 = this.MyBillsEntityDataFactory;
                                    return FlexBuffers.moveToNextValue(readBuf2, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf2, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
                                } else if (i != 8) {
                                    return 0L;
                                } else {
                                    ReadBuf readBuf3 = this.MyBillsEntityDataFactory;
                                    return (long) FlexBuffers.PlaceComponentResult(readBuf3, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf3, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.KClassImpl$Data$declaredNonStaticMembers$2);
                                }
                            }
                            return Long.parseLong(NetworkUserEntityData$$ExternalSyntheticLambda0());
                        }
                        return FlexBuffers.getAuthRequestContext(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    return scheduleImpl().KClassImpl$Data$declaredNonStaticMembers$2();
                }
                return (long) FlexBuffers.PlaceComponentResult(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return FlexBuffers.scheduleImpl(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        private long lookAheadTest() {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i == 1) {
                return FlexBuffers.scheduleImpl(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (i != 2) {
                if (i != 3) {
                    if (i == 5) {
                        try {
                            return Long.parseLong(NetworkUserEntityData$$ExternalSyntheticLambda0());
                        } catch (NumberFormatException unused) {
                            return 0L;
                        }
                    } else if (i == 6) {
                        ReadBuf readBuf = this.MyBillsEntityDataFactory;
                        return FlexBuffers.scheduleImpl(readBuf, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
                    } else if (i == 7) {
                        ReadBuf readBuf2 = this.MyBillsEntityDataFactory;
                        return FlexBuffers.moveToNextValue(readBuf2, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf2, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.KClassImpl$Data$declaredNonStaticMembers$2);
                    } else if (i == 8) {
                        ReadBuf readBuf3 = this.MyBillsEntityDataFactory;
                        return (long) FlexBuffers.PlaceComponentResult(readBuf3, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf3, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
                    } else if (i != 10) {
                        if (i != 26) {
                            return 0L;
                        }
                        return FlexBuffers.getAuthRequestContext(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    } else {
                        return scheduleImpl().KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }
                return (long) FlexBuffers.PlaceComponentResult(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return FlexBuffers.moveToNextValue(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        private double BuiltInFictitiousFunctionClassFactory() {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i == 3) {
                return FlexBuffers.PlaceComponentResult(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        return Double.parseDouble(NetworkUserEntityData$$ExternalSyntheticLambda0());
                    }
                    if (i == 6) {
                        ReadBuf readBuf = this.MyBillsEntityDataFactory;
                        return FlexBuffers.getAuthRequestContext(readBuf, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
                    } else if (i == 7) {
                        ReadBuf readBuf2 = this.MyBillsEntityDataFactory;
                        return FlexBuffers.moveToNextValue(readBuf2, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf2, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
                    } else if (i == 8) {
                        ReadBuf readBuf3 = this.MyBillsEntityDataFactory;
                        return FlexBuffers.PlaceComponentResult(readBuf3, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf3, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
                    } else if (i == 10) {
                        return scheduleImpl().KClassImpl$Data$declaredNonStaticMembers$2();
                    } else {
                        if (i != 26) {
                            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                    }
                }
                return FlexBuffers.moveToNextValue(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return FlexBuffers.getAuthRequestContext(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        private Key getAuthRequestContext() {
            if (initRecordTimeStamp()) {
                ReadBuf readBuf = this.MyBillsEntityDataFactory;
                return new Key(readBuf, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
            }
            return Key.BuiltInFictitiousFunctionClassFactory();
        }

        private String NetworkUserEntityData$$ExternalSyntheticLambda0() {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                int KClassImpl$Data$declaredNonStaticMembers$2 = FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                ReadBuf readBuf = this.MyBillsEntityDataFactory;
                int i = this.PlaceComponentResult;
                return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, (int) FlexBuffers.moveToNextValue(readBuf, KClassImpl$Data$declaredNonStaticMembers$2 - i, i));
            } else if (initRecordTimeStamp()) {
                int KClassImpl$Data$declaredNonStaticMembers$22 = FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
                int i2 = KClassImpl$Data$declaredNonStaticMembers$22;
                while (this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i2) != 0) {
                    i2++;
                }
                return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$22, i2 - KClassImpl$Data$declaredNonStaticMembers$22);
            } else {
                return "";
            }
        }

        private Map getErrorConfigVersion() {
            if (NetworkUserEntityData$$ExternalSyntheticLambda2()) {
                ReadBuf readBuf = this.MyBillsEntityDataFactory;
                return new Map(readBuf, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
            }
            return Map.getAuthRequestContext();
        }

        private Vector scheduleImpl() {
            if (NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                ReadBuf readBuf = this.MyBillsEntityDataFactory;
                return new Vector(readBuf, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
            }
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i == 15) {
                ReadBuf readBuf2 = this.MyBillsEntityDataFactory;
                return new TypedVector(readBuf2, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf2, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult, 4);
            } else if (FlexBuffers.PlaceComponentResult(i)) {
                ReadBuf readBuf3 = this.MyBillsEntityDataFactory;
                return new TypedVector(readBuf3, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf3, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult, FlexBuffers.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            } else {
                return Vector.BuiltInFictitiousFunctionClassFactory();
            }
        }

        private Blob MyBillsEntityDataFactory() {
            if (GetContactSyncConfig() || NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                ReadBuf readBuf = this.MyBillsEntityDataFactory;
                return new Blob(readBuf, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(readBuf, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2), this.PlaceComponentResult);
            }
            return Blob.BuiltInFictitiousFunctionClassFactory();
        }

        private boolean PlaceComponentResult() {
            return DatabaseTableConfigUtil() ? this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory) != 0 : moveToNextValue() != 0;
        }

        public String toString() {
            return MyBillsEntityDataFactory(new StringBuilder(128)).toString();
        }

        final StringBuilder MyBillsEntityDataFactory(StringBuilder sb) {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i != 36) {
                switch (i) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        sb.append(lookAheadTest());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(moveToNextValue());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(BuiltInFictitiousFunctionClassFactory());
                        return sb;
                    case 4:
                        Key authRequestContext = getAuthRequestContext();
                        sb.append(Typography.quote);
                        StringBuilder MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory(sb);
                        MyBillsEntityDataFactory.append(Typography.quote);
                        return MyBillsEntityDataFactory;
                    case 5:
                        sb.append(Typography.quote);
                        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda0());
                        sb.append(Typography.quote);
                        return sb;
                    case 9:
                        return getErrorConfigVersion().MyBillsEntityDataFactory(sb);
                    case 10:
                        return scheduleImpl().MyBillsEntityDataFactory(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("not_implemented:");
                        sb2.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        throw new FlexBufferException(sb2.toString());
                    case 25:
                        return MyBillsEntityDataFactory().MyBillsEntityDataFactory(sb);
                    case 26:
                        sb.append(PlaceComponentResult());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(scheduleImpl());
            return sb;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class Object {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        ReadBuf getAuthRequestContext;

        public abstract StringBuilder MyBillsEntityDataFactory(StringBuilder sb);

        Object(ReadBuf readBuf, int i, int i2) {
            this.getAuthRequestContext = readBuf;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        }

        public String toString() {
            return MyBillsEntityDataFactory(new StringBuilder(128)).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class Sized extends Object {
        protected final int MyBillsEntityDataFactory;

        Sized(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
            this.MyBillsEntityDataFactory = FlexBuffers.getAuthRequestContext(this.getAuthRequestContext, i - i2, i2);
        }

        public int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes6.dex */
    public static class Blob extends Sized {
        static final Blob PlaceComponentResult = new Blob(FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2, 1, 1);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public final /* bridge */ /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        Blob(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Blob BuiltInFictitiousFunctionClassFactory() {
            return PlaceComponentResult;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, super.KClassImpl$Data$declaredNonStaticMembers$2());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final StringBuilder MyBillsEntityDataFactory(StringBuilder sb) {
            sb.append(Typography.quote);
            sb.append(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, super.KClassImpl$Data$declaredNonStaticMembers$2()));
            sb.append(Typography.quote);
            return sb;
        }
    }

    /* loaded from: classes6.dex */
    public static class Key extends Object {
        private static final Key MyBillsEntityDataFactory = new Key(FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2, 0, 0);

        Key(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Key BuiltInFictitiousFunctionClassFactory() {
            return MyBillsEntityDataFactory;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final StringBuilder MyBillsEntityDataFactory(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            while (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i) != 0) {
                i++;
            }
            return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, i - this.BuiltInFictitiousFunctionClassFactory);
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                return key.BuiltInFictitiousFunctionClassFactory == this.BuiltInFictitiousFunctionClassFactory && key.KClassImpl$Data$declaredNonStaticMembers$2 == this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return false;
        }

        public int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory ^ this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes6.dex */
    public static class Map extends Vector {
        private static final Map PlaceComponentResult = new Map(FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2, 1, 1);

        Map(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Map getAuthRequestContext() {
            return PlaceComponentResult;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public final StringBuilder MyBillsEntityDataFactory(StringBuilder sb) {
            Key key;
            sb.append("{ ");
            int i = this.BuiltInFictitiousFunctionClassFactory - (this.KClassImpl$Data$declaredNonStaticMembers$2 * 3);
            KeyVector keyVector = new KeyVector(new TypedVector(this.getAuthRequestContext, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, i, this.KClassImpl$Data$declaredNonStaticMembers$2), FlexBuffers.getAuthRequestContext(this.getAuthRequestContext, i + this.KClassImpl$Data$declaredNonStaticMembers$2, this.KClassImpl$Data$declaredNonStaticMembers$2), 4));
            int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            Vector vector = new Vector(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            for (int i2 = 0; i2 < KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                sb.append(Typography.quote);
                if (i2 >= keyVector.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    key = Key.MyBillsEntityDataFactory;
                } else {
                    key = new Key(keyVector.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2(keyVector.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, keyVector.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + (keyVector.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 * i2), keyVector.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2), 1);
                }
                sb.append(key.toString());
                sb.append("\" : ");
                sb.append(vector.KClassImpl$Data$declaredNonStaticMembers$2(i2).toString());
                if (i2 != KClassImpl$Data$declaredNonStaticMembers$2 - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }
    }

    /* loaded from: classes6.dex */
    public static class Vector extends Sized {
        private static final Vector PlaceComponentResult = new Vector(FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2, 1, 1);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public final /* bridge */ /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        Vector(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Vector BuiltInFictitiousFunctionClassFactory() {
            return PlaceComponentResult;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder MyBillsEntityDataFactory(StringBuilder sb) {
            sb.append("[ ");
            int KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
            for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                KClassImpl$Data$declaredNonStaticMembers$2(i).MyBillsEntityDataFactory(sb);
                if (i != KClassImpl$Data$declaredNonStaticMembers$2 - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        public Reference KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            long KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
            long j = i;
            if (j >= KClassImpl$Data$declaredNonStaticMembers$2) {
                return Reference.getAuthRequestContext;
            }
            return new Reference(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory + (i * this.KClassImpl$Data$declaredNonStaticMembers$2), this.KClassImpl$Data$declaredNonStaticMembers$2, Unsigned.getAuthRequestContext(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory((int) (this.BuiltInFictitiousFunctionClassFactory + (KClassImpl$Data$declaredNonStaticMembers$2 * this.KClassImpl$Data$declaredNonStaticMembers$2) + j))));
        }
    }

    /* loaded from: classes6.dex */
    public static class TypedVector extends Vector {
        private static final TypedVector PlaceComponentResult = new TypedVector(FlexBuffers.KClassImpl$Data$declaredNonStaticMembers$2, 1, 1, 1);
        private final int getErrorConfigVersion;

        TypedVector(ReadBuf readBuf, int i, int i2, int i3) {
            super(readBuf, i, i2);
            this.getErrorConfigVersion = i3;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public final Reference KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            if (i >= KClassImpl$Data$declaredNonStaticMembers$2()) {
                return Reference.getAuthRequestContext;
            }
            return new Reference(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory + (i * this.KClassImpl$Data$declaredNonStaticMembers$2), this.KClassImpl$Data$declaredNonStaticMembers$2, 1, this.getErrorConfigVersion);
        }
    }

    /* loaded from: classes6.dex */
    public static class KeyVector {
        final TypedVector BuiltInFictitiousFunctionClassFactory;

        KeyVector(TypedVector typedVector) {
            this.BuiltInFictitiousFunctionClassFactory = typedVector;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(); i++) {
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i).MyBillsEntityDataFactory(sb);
                if (i != this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Unsigned {
        static int BuiltInFictitiousFunctionClassFactory(short s) {
            return s & UShort.MAX_VALUE;
        }

        static long KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return i & 4294967295L;
        }

        static int getAuthRequestContext(byte b) {
            return b & 255;
        }

        Unsigned() {
        }
    }

    static /* synthetic */ int getAuthRequestContext(ReadBuf readBuf, int i, int i2) {
        return (int) scheduleImpl(readBuf, i, i2);
    }

    static /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(ReadBuf readBuf, int i, int i2) {
        return (int) (i - moveToNextValue(readBuf, i, i2));
    }

    static /* synthetic */ double PlaceComponentResult(ReadBuf readBuf, int i, int i2) {
        if (i2 != 4) {
            if (i2 != 8) {
                return -1.0d;
            }
            return readBuf.PlaceComponentResult(i);
        }
        return readBuf.getAuthRequestContext(i);
    }
}
