package com.google.android.gms.internal.measurement;

import id.dana.cashier.view.InputCardNumberView;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzln {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzll zzllVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzllVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
        } else if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(InputCardNumberView.DIVIDER);
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzml.zza(zzjd.zzm((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzjd) {
                sb.append(": \"");
                sb.append(zzml.zza((zzjd) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzke) {
                sb.append(" {");
                zzd((zzke) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(InputCardNumberView.DIVIDER);
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, "key", entry.getKey());
                zzb(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(InputCardNumberView.DIVIDER);
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void zzd(zzll zzllVar, StringBuilder sb, int i) {
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzllVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String concat = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1, substring.length() - 4)));
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(concat), zzke.zzbH(method2, zzllVar, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String concat2 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1, substring.length() - 3)));
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(concat2), zzke.zzbH(method3, zzllVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(String.valueOf(substring)))) != null && (!substring.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                String concat3 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(String.valueOf(substring)));
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzbH = zzke.zzbH(method4, zzllVar, new Object[0]);
                    if (method5 == null) {
                        if (zzbH instanceof Boolean) {
                            if (((Boolean) zzbH).booleanValue()) {
                                zzb(sb, i, zzc(concat3), zzbH);
                            }
                        } else if (zzbH instanceof Integer) {
                            if (((Integer) zzbH).intValue() != 0) {
                                zzb(sb, i, zzc(concat3), zzbH);
                            }
                        } else if (zzbH instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbH).floatValue()) != 0) {
                                zzb(sb, i, zzc(concat3), zzbH);
                            }
                        } else if (!(zzbH instanceof Double)) {
                            if (zzbH instanceof String) {
                                equals = zzbH.equals("");
                            } else if (zzbH instanceof zzjd) {
                                equals = zzbH.equals(zzjd.zzb);
                            } else if (zzbH instanceof zzll) {
                                if (zzbH != ((zzll) zzbH).zzbO()) {
                                    zzb(sb, i, zzc(concat3), zzbH);
                                }
                            } else {
                                if ((zzbH instanceof Enum) && ((Enum) zzbH).ordinal() == 0) {
                                }
                                zzb(sb, i, zzc(concat3), zzbH);
                            }
                            if (!equals) {
                                zzb(sb, i, zzc(concat3), zzbH);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzbH).doubleValue()) != 0) {
                            zzb(sb, i, zzc(concat3), zzbH);
                        }
                    } else if (((Boolean) zzke.zzbH(method5, zzllVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzc(concat3), zzbH);
                    }
                }
            }
        }
        if (!(zzllVar instanceof zzkb)) {
            zzmo zzmoVar = ((zzke) zzllVar).zzc;
            if (zzmoVar != null) {
                zzmoVar.zzg(sb, i);
                return;
            }
            return;
        }
        zzjv zzjvVar = ((zzkb) zzllVar).zza;
        throw null;
    }
}
