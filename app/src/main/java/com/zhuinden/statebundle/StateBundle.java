package com.zhuinden.statebundle;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class StateBundle implements Parcelable {
    public static final Parcelable.Creator<StateBundle> CREATOR = new Parcelable.Creator<StateBundle>() { // from class: com.zhuinden.statebundle.StateBundle.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StateBundle createFromParcel(Parcel parcel) {
            return new StateBundle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StateBundle[] newArray(int i) {
            return new StateBundle[i];
        }
    };
    public Map<String, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
    public Map<String, Integer> MyBillsEntityDataFactory = new LinkedHashMap();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes2.dex */
    static class TypeElement implements Parcelable {
        public static final Parcelable.Creator<TypeElement> CREATOR = new Parcelable.Creator<TypeElement>() { // from class: com.zhuinden.statebundle.StateBundle.TypeElement.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TypeElement createFromParcel(Parcel parcel) {
                return new TypeElement(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TypeElement[] newArray(int i) {
                return new TypeElement[i];
            }
        };
        int BuiltInFictitiousFunctionClassFactory;
        String PlaceComponentResult;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        TypeElement() {
        }

        TypeElement(String str, int i) {
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        protected TypeElement(Parcel parcel) {
            this.PlaceComponentResult = parcel.readString();
            this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.PlaceComponentResult);
            parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public StateBundle() {
    }

    public StateBundle(Parcel parcel) {
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            TypeElement typeElement = (TypeElement) parcel.readParcelable(TypeElement.class.getClassLoader());
            Object readValue = parcel.readValue(getClass().getClassLoader());
            int i2 = typeElement.BuiltInFictitiousFunctionClassFactory;
            if (i2 == 26) {
                String str = typeElement.PlaceComponentResult;
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(str, (StateBundle) readValue);
                this.MyBillsEntityDataFactory.put(str, 26);
            } else if (i2 == 27) {
                String str2 = typeElement.PlaceComponentResult;
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(str2, (Parcelable) readValue);
                this.MyBillsEntityDataFactory.put(str2, 27);
            } else if (i2 == 29) {
                String str3 = typeElement.PlaceComponentResult;
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(str3, (ArrayList) readValue);
                this.MyBillsEntityDataFactory.put(str3, 29);
            } else if (i2 != 30) {
                switch (i2) {
                    case 0:
                        String str4 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str4, Boolean.valueOf(((Boolean) readValue).booleanValue()));
                        this.MyBillsEntityDataFactory.put(str4, 0);
                        continue;
                    case 1:
                        String str5 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str5, Byte.valueOf(((Byte) readValue).byteValue()));
                        this.MyBillsEntityDataFactory.put(str5, 1);
                        continue;
                    case 2:
                        String str6 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str6, Character.valueOf(((Character) readValue).charValue()));
                        this.MyBillsEntityDataFactory.put(str6, 2);
                        continue;
                    case 3:
                        String str7 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str7, Short.valueOf(((Short) readValue).shortValue()));
                        this.MyBillsEntityDataFactory.put(str7, 3);
                        continue;
                    case 4:
                        String str8 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str8, Integer.valueOf(((Integer) readValue).intValue()));
                        this.MyBillsEntityDataFactory.put(str8, 4);
                        continue;
                    case 5:
                        String str9 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str9, Long.valueOf(((Long) readValue).longValue()));
                        this.MyBillsEntityDataFactory.put(str9, 5);
                        continue;
                    case 6:
                        String str10 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str10, Float.valueOf(((Float) readValue).floatValue()));
                        this.MyBillsEntityDataFactory.put(str10, 6);
                        continue;
                    case 7:
                        String str11 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str11, Double.valueOf(((Double) readValue).doubleValue()));
                        this.MyBillsEntityDataFactory.put(str11, 7);
                        continue;
                    case 8:
                        String str12 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str12, (String) readValue);
                        this.MyBillsEntityDataFactory.put(str12, 8);
                        continue;
                    case 9:
                        String str13 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str13, (CharSequence) readValue);
                        this.MyBillsEntityDataFactory.put(str13, 9);
                        continue;
                    case 10:
                        String str14 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str14, (Serializable) readValue);
                        this.MyBillsEntityDataFactory.put(str14, 10);
                        continue;
                    case 11:
                        String str15 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str15, (ArrayList) readValue);
                        this.MyBillsEntityDataFactory.put(str15, 11);
                        continue;
                    case 12:
                        String str16 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str16, (ArrayList) readValue);
                        this.MyBillsEntityDataFactory.put(str16, 12);
                        continue;
                    case 13:
                        String str17 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str17, (ArrayList) readValue);
                        this.MyBillsEntityDataFactory.put(str17, 13);
                        continue;
                    case 14:
                        String str18 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str18, (boolean[]) readValue);
                        this.MyBillsEntityDataFactory.put(str18, 14);
                        continue;
                    case 15:
                        String str19 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str19, (byte[]) readValue);
                        this.MyBillsEntityDataFactory.put(str19, 15);
                        continue;
                    case 16:
                        String str20 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str20, (short[]) readValue);
                        this.MyBillsEntityDataFactory.put(str20, 16);
                        continue;
                    case 17:
                        String str21 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str21, (char[]) readValue);
                        this.MyBillsEntityDataFactory.put(str21, 17);
                        continue;
                    case 18:
                        String str22 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str22, (int[]) readValue);
                        this.MyBillsEntityDataFactory.put(str22, 18);
                        continue;
                    case 19:
                        String str23 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str23, (long[]) readValue);
                        this.MyBillsEntityDataFactory.put(str23, 19);
                        continue;
                    case 20:
                        String str24 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str24, (float[]) readValue);
                        this.MyBillsEntityDataFactory.put(str24, 20);
                        continue;
                    case 21:
                        String str25 = typeElement.PlaceComponentResult;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(str25, (double[]) readValue);
                        this.MyBillsEntityDataFactory.put(str25, 21);
                        continue;
                }
            } else {
                String str26 = typeElement.PlaceComponentResult;
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(str26, (SparseArray) readValue);
                this.MyBillsEntityDataFactory.put(str26, 30);
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(str);
    }

    @Nonnull
    public final StateBundle BuiltInFictitiousFunctionClassFactory(@Nonnull StateBundle stateBundle) {
        if (stateBundle == null) {
            throw new IllegalArgumentException("The provided bundle should not be null!");
        }
        Map<String, Object> map = stateBundle.KClassImpl$Data$declaredNonStaticMembers$2;
        if (map != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.putAll(map);
            this.MyBillsEntityDataFactory.putAll(stateBundle.MyBillsEntityDataFactory);
        }
        return this;
    }

    @Nullable
    public final StateBundle getAuthRequestContext(@Nullable String str) {
        Object obj = this.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (StateBundle) obj;
        } catch (ClassCastException unused) {
            getAuthRequestContext(str, obj, "Bundle", "<null>");
            return null;
        }
    }

    @Nullable
    public final <T extends Parcelable> ArrayList<T> MyBillsEntityDataFactory(@Nullable String str) {
        Object obj = this.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException unused) {
            getAuthRequestContext(str, obj, "ArrayList", "<null>");
            return null;
        }
    }

    private static void getAuthRequestContext(String str, Object obj, String str2, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(str);
        sb.append(" expected ");
        sb.append(str2);
        sb.append(" but value was a ");
        sb.append(obj.getClass().getName());
        sb.append(".  The default value ");
        sb.append(obj2);
        sb.append(" was returned.");
        System.out.println(sb.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2.keySet().size());
        for (String str : this.KClassImpl$Data$declaredNonStaticMembers$2.keySet()) {
            Integer num = this.MyBillsEntityDataFactory.get(str);
            if (num == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected null in [");
                sb.append(str);
                sb.append("]");
                throw new IllegalStateException(sb.toString());
            }
            parcel.writeParcelable(new TypeElement(str, num.intValue()), 0);
            parcel.writeValue(this.KClassImpl$Data$declaredNonStaticMembers$2.get(str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Object>> entrySet = this.KClassImpl$Data$declaredNonStaticMembers$2.entrySet();
        if (entrySet.isEmpty()) {
            sb.append("[]");
        } else {
            int i = 0;
            for (Map.Entry<String, Object> entry : entrySet) {
                sb.append("{[");
                sb.append(entry.getKey());
                sb.append("]::[");
                Integer num = this.MyBillsEntityDataFactory.get(entry.getKey());
                if (num == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unexpected null in [");
                    sb2.append(entry.getKey());
                    sb2.append("]");
                    throw new IllegalStateException(sb2.toString());
                }
                if (entry.getValue() == null) {
                    sb.append("<null>");
                } else if (num.intValue() == 14) {
                    sb.append(Arrays.toString((boolean[]) entry.getValue()));
                } else if (num.intValue() == 15) {
                    sb.append(Arrays.toString((byte[]) entry.getValue()));
                } else if (num.intValue() == 16) {
                    sb.append(Arrays.toString((short[]) entry.getValue()));
                } else if (num.intValue() == 17) {
                    sb.append(Arrays.toString((char[]) entry.getValue()));
                } else if (num.intValue() == 18) {
                    sb.append(Arrays.toString((int[]) entry.getValue()));
                } else if (num.intValue() == 19) {
                    sb.append(Arrays.toString((long[]) entry.getValue()));
                } else if (num.intValue() == 20) {
                    sb.append(Arrays.toString((float[]) entry.getValue()));
                } else if (num.intValue() == 21) {
                    sb.append(Arrays.toString((double[]) entry.getValue()));
                } else if (num.intValue() == 22) {
                    sb.append(Arrays.toString((String[]) entry.getValue()));
                } else if (num.intValue() == 23) {
                    sb.append(Arrays.toString((CharSequence[]) entry.getValue()));
                } else if (num.intValue() == 28) {
                    sb.append(Arrays.toString((Parcelable[]) entry.getValue()));
                } else {
                    sb.append(entry.getValue());
                }
                sb.append("]}");
                i++;
                if (i < entrySet.size()) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        for (Map.Entry<String, Object> entry : this.KClassImpl$Data$declaredNonStaticMembers$2.entrySet()) {
            int hashCode2 = i + (entry.getKey().hashCode() * 31);
            Integer num = this.MyBillsEntityDataFactory.get(entry.getKey());
            if (num == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected null in hashCode for [");
                sb.append(entry.getKey());
                sb.append("]");
                throw new IllegalStateException(sb.toString());
            } else if (entry.getValue() == null) {
                i = hashCode2 + 0;
            } else {
                if (num.intValue() == 14) {
                    hashCode = Arrays.hashCode((boolean[]) entry.getValue());
                } else if (num.intValue() == 15) {
                    hashCode = Arrays.hashCode((byte[]) entry.getValue());
                } else if (num.intValue() == 16) {
                    hashCode = Arrays.hashCode((short[]) entry.getValue());
                } else if (num.intValue() == 17) {
                    hashCode = Arrays.hashCode((char[]) entry.getValue());
                } else if (num.intValue() == 18) {
                    hashCode = Arrays.hashCode((int[]) entry.getValue());
                } else if (num.intValue() == 19) {
                    hashCode = Arrays.hashCode((long[]) entry.getValue());
                } else if (num.intValue() == 20) {
                    hashCode = Arrays.hashCode((float[]) entry.getValue());
                } else if (num.intValue() == 21) {
                    hashCode = Arrays.hashCode((double[]) entry.getValue());
                } else if (num.intValue() == 22) {
                    hashCode = Arrays.hashCode((String[]) entry.getValue());
                } else if (num.intValue() == 23) {
                    hashCode = Arrays.hashCode((CharSequence[]) entry.getValue());
                } else if (num.intValue() == 28) {
                    hashCode = Arrays.hashCode((Parcelable[]) entry.getValue());
                } else {
                    hashCode = entry.getValue().hashCode();
                }
                i = hashCode2 + (hashCode * 31);
            }
        }
        return i;
    }

    private static boolean PlaceComponentResult(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof StateBundle)) {
            StateBundle stateBundle = (StateBundle) obj;
            if ((!this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() || stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) && ((this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() || !stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) && this.KClassImpl$Data$declaredNonStaticMembers$2.size() == stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.size())) {
                for (Map.Entry<String, Object> entry : this.KClassImpl$Data$declaredNonStaticMembers$2.entrySet()) {
                    if (!stateBundle.KClassImpl$Data$declaredNonStaticMembers$2(entry.getKey()) || !stateBundle.MyBillsEntityDataFactory.containsKey(entry.getKey())) {
                        return false;
                    }
                    Integer num = this.MyBillsEntityDataFactory.get(entry.getKey());
                    if (num == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected null in equals for [");
                        sb.append(entry.getKey());
                        sb.append("]");
                        throw new IllegalStateException(sb.toString());
                    } else if (!PlaceComponentResult(stateBundle.MyBillsEntityDataFactory.get(entry.getKey()), num)) {
                        return false;
                    } else {
                        Object value = entry.getValue();
                        Object obj2 = stateBundle.KClassImpl$Data$declaredNonStaticMembers$2.get(entry.getKey());
                        if (value != null || obj2 != null) {
                            if ((value == null && obj2 != null) || (value != null && obj2 == null)) {
                                return false;
                            }
                            if (num.intValue() == 14) {
                                if (!Arrays.equals((boolean[]) value, (boolean[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 15) {
                                if (!Arrays.equals((byte[]) value, (byte[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 16) {
                                if (!Arrays.equals((short[]) value, (short[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 17) {
                                if (!Arrays.equals((char[]) value, (char[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 18) {
                                if (!Arrays.equals((int[]) value, (int[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 19) {
                                if (!Arrays.equals((long[]) value, (long[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 20) {
                                if (!Arrays.equals((float[]) value, (float[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 21) {
                                if (!Arrays.equals((double[]) value, (double[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 22) {
                                if (!Arrays.equals((String[]) value, (String[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 23) {
                                if (!Arrays.equals((CharSequence[]) value, (CharSequence[]) obj2)) {
                                    return false;
                                }
                            } else if (num.intValue() == 28) {
                                if (!Arrays.equals((Parcelable[]) value, (Parcelable[]) obj2)) {
                                    return false;
                                }
                            } else if (!value.equals(obj2)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
