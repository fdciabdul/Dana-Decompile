package androidx.work;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Data {
    public static final Data BuiltInFictitiousFunctionClassFactory;
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("Data");
    public Map<String, Object> MyBillsEntityDataFactory;

    static {
        Data data = new Data(new Builder().MyBillsEntityDataFactory);
        getAuthRequestContext(data);
        BuiltInFictitiousFunctionClassFactory = data;
    }

    Data() {
    }

    public Data(Data data) {
        this.MyBillsEntityDataFactory = new HashMap(data.MyBillsEntityDataFactory);
    }

    public Data(Map<String, ?> map) {
        this.MyBillsEntityDataFactory = new HashMap(map);
    }

    public final boolean getAuthRequestContext(String str) {
        Object obj = this.MyBillsEntityDataFactory.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public final boolean[] KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Object obj = this.MyBillsEntityDataFactory.get(str);
        if (obj instanceof Boolean[]) {
            return PlaceComponentResult((Boolean[]) obj);
        }
        return null;
    }

    public static byte[] getAuthRequestContext(Data data) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeInt(data.MyBillsEntityDataFactory.size());
                    for (Map.Entry<String, Object> entry : data.MyBillsEntityDataFactory.entrySet()) {
                        objectOutputStream.writeUTF(entry.getKey());
                        objectOutputStream.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        InstrumentInjector.log_e(getAuthRequestContext, "Error in Data#toByteArray: ", e);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        InstrumentInjector.log_e(getAuthRequestContext, "Error in Data#toByteArray: ", e2);
                    }
                    if (byteArrayOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream2 = objectOutputStream;
                    InstrumentInjector.log_e(getAuthRequestContext, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e4) {
                            InstrumentInjector.log_e(getAuthRequestContext, "Error in Data#toByteArray: ", e4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        InstrumentInjector.log_e(getAuthRequestContext, "Error in Data#toByteArray: ", e5);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            InstrumentInjector.log_e(getAuthRequestContext, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        InstrumentInjector.log_e(getAuthRequestContext, "Error in Data#toByteArray: ", e7);
                        throw th;
                    }
                }
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.work.Data MyBillsEntityDataFactory(byte[] r7) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L82
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L44 java.lang.ClassNotFoundException -> L46 java.io.IOException -> L48
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L44 java.lang.ClassNotFoundException -> L46 java.io.IOException -> L48
            int r7 = r3.readInt()     // Catch: java.lang.Throwable -> L3b java.lang.ClassNotFoundException -> L3d java.io.IOException -> L3f
        L1b:
            if (r7 <= 0) goto L2b
            java.lang.String r4 = r3.readUTF()     // Catch: java.lang.Throwable -> L3b java.lang.ClassNotFoundException -> L3d java.io.IOException -> L3f
            java.lang.Object r5 = r3.readObject()     // Catch: java.lang.Throwable -> L3b java.lang.ClassNotFoundException -> L3d java.io.IOException -> L3f
            r1.put(r4, r5)     // Catch: java.lang.Throwable -> L3b java.lang.ClassNotFoundException -> L3d java.io.IOException -> L3f
            int r7 = r7 + (-1)
            goto L1b
        L2b:
            r3.close()     // Catch: java.io.IOException -> L2f
            goto L35
        L2f:
            r7 = move-exception
            java.lang.String r3 = androidx.work.Data.getAuthRequestContext
            com.fullstory.instrumentation.InstrumentInjector.log_e(r3, r0, r7)
        L35:
            r2.close()     // Catch: java.io.IOException -> L39
            goto L60
        L39:
            r7 = move-exception
            goto L5b
        L3b:
            r7 = move-exception
            goto L69
        L3d:
            r7 = move-exception
            goto L40
        L3f:
            r7 = move-exception
        L40:
            r6 = r3
            r3 = r7
            r7 = r6
            goto L49
        L44:
            r1 = move-exception
            goto L6b
        L46:
            r3 = move-exception
            goto L49
        L48:
            r3 = move-exception
        L49:
            java.lang.String r4 = androidx.work.Data.getAuthRequestContext     // Catch: java.lang.Throwable -> L66
            com.fullstory.instrumentation.InstrumentInjector.log_e(r4, r0, r3)     // Catch: java.lang.Throwable -> L66
            if (r7 == 0) goto L35
            r7.close()     // Catch: java.io.IOException -> L54
            goto L35
        L54:
            r7 = move-exception
            java.lang.String r3 = androidx.work.Data.getAuthRequestContext
            com.fullstory.instrumentation.InstrumentInjector.log_e(r3, r0, r7)
            goto L35
        L5b:
            java.lang.String r2 = androidx.work.Data.getAuthRequestContext
            com.fullstory.instrumentation.InstrumentInjector.log_e(r2, r0, r7)
        L60:
            androidx.work.Data r7 = new androidx.work.Data
            r7.<init>(r1)
            return r7
        L66:
            r1 = move-exception
            r3 = r7
            r7 = r1
        L69:
            r1 = r7
            r7 = r3
        L6b:
            if (r7 == 0) goto L77
            r7.close()     // Catch: java.io.IOException -> L71
            goto L77
        L71:
            r7 = move-exception
            java.lang.String r3 = androidx.work.Data.getAuthRequestContext
            com.fullstory.instrumentation.InstrumentInjector.log_e(r3, r0, r7)
        L77:
            r2.close()     // Catch: java.io.IOException -> L7b
            goto L81
        L7b:
            r7 = move-exception
            java.lang.String r2 = androidx.work.Data.getAuthRequestContext
            com.fullstory.instrumentation.InstrumentInjector.log_e(r2, r0, r7)
        L81:
            throw r1
        L82:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            goto L8b
        L8a:
            throw r7
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.MyBillsEntityDataFactory(byte[]):androidx.work.Data");
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.MyBillsEntityDataFactory.keySet();
        if (keySet.equals(data.MyBillsEntityDataFactory.keySet())) {
            for (String str : keySet) {
                Object obj2 = this.MyBillsEntityDataFactory.get(str);
                Object obj3 = data.MyBillsEntityDataFactory.get(str);
                if (obj2 == null || obj3 == null) {
                    z = obj2 == obj3;
                } else if ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) {
                    z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                } else {
                    z = obj2.equals(obj3);
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.MyBillsEntityDataFactory.isEmpty()) {
            for (String str : this.MyBillsEntityDataFactory.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.MyBillsEntityDataFactory.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static Boolean[] MyBillsEntityDataFactory(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] PlaceComponentResult(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Integer[] KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] BuiltInFictitiousFunctionClassFactory(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static Float[] KClassImpl$Data$declaredNonStaticMembers$2(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Double[] getAuthRequestContext(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    private static boolean[] PlaceComponentResult(Boolean[] boolArr) {
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        public Map<String, Object> MyBillsEntityDataFactory = new HashMap();

        public final Builder BuiltInFictitiousFunctionClassFactory(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                MyBillsEntityDataFactory(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public final Builder MyBillsEntityDataFactory(String str, Object obj) {
            if (obj == null) {
                this.MyBillsEntityDataFactory.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.MyBillsEntityDataFactory.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.MyBillsEntityDataFactory.put(str, Data.MyBillsEntityDataFactory((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.MyBillsEntityDataFactory.put(str, Data.PlaceComponentResult((byte[]) obj));
                } else if (cls == int[].class) {
                    this.MyBillsEntityDataFactory.put(str, Data.KClassImpl$Data$declaredNonStaticMembers$2((int[]) obj));
                } else if (cls == long[].class) {
                    this.MyBillsEntityDataFactory.put(str, Data.BuiltInFictitiousFunctionClassFactory((long[]) obj));
                } else if (cls == float[].class) {
                    this.MyBillsEntityDataFactory.put(str, Data.KClassImpl$Data$declaredNonStaticMembers$2((float[]) obj));
                } else if (cls == double[].class) {
                    this.MyBillsEntityDataFactory.put(str, Data.getAuthRequestContext((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                }
            }
            return this;
        }
    }
}
