package com.google.android.gms.internal.auth;

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
public final class zzfy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzfw zzfwVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfwVar, sb, 0);
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
                sb.append(zzgw.zza(zzee.zzl((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzee) {
                sb.append(": \"");
                sb.append(zzgw.zza((zzee) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzeu) {
                sb.append(" {");
                zzd((zzeu) obj, sb, i + 2);
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

    private static void zzd(zzfw zzfwVar, StringBuilder sb, int i) {
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzfwVar.getClass().getDeclaredMethods()) {
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
                    zzb(sb, i, zzc(concat), zzeu.zze(method2, zzfwVar, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String concat2 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1, substring.length() - 3)));
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(concat2), zzeu.zze(method3, zzfwVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(String.valueOf(substring)))) != null && (!substring.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                String concat3 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(String.valueOf(substring)));
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zze = zzeu.zze(method4, zzfwVar, new Object[0]);
                    if (method5 == null) {
                        if (zze instanceof Boolean) {
                            if (((Boolean) zze).booleanValue()) {
                                zzb(sb, i, zzc(concat3), zze);
                            }
                        } else if (zze instanceof Integer) {
                            if (((Integer) zze).intValue() != 0) {
                                zzb(sb, i, zzc(concat3), zze);
                            }
                        } else if (zze instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zze).floatValue()) != 0) {
                                zzb(sb, i, zzc(concat3), zze);
                            }
                        } else if (!(zze instanceof Double)) {
                            if (zze instanceof String) {
                                equals = zze.equals("");
                            } else if (zze instanceof zzee) {
                                equals = zze.equals(zzee.zzb);
                            } else if (zze instanceof zzfw) {
                                if (zze != ((zzfw) zze).zzh()) {
                                    zzb(sb, i, zzc(concat3), zze);
                                }
                            } else {
                                if ((zze instanceof Enum) && ((Enum) zze).ordinal() == 0) {
                                }
                                zzb(sb, i, zzc(concat3), zze);
                            }
                            if (!equals) {
                                zzb(sb, i, zzc(concat3), zze);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zze).doubleValue()) != 0) {
                            zzb(sb, i, zzc(concat3), zze);
                        }
                    } else if (((Boolean) zzeu.zze(method5, zzfwVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzc(concat3), zze);
                    }
                }
            }
        }
        if (!(zzfwVar instanceof zzet)) {
            zzgz zzgzVar = ((zzeu) zzfwVar).zzc;
            if (zzgzVar != null) {
                zzgzVar.zze(sb, i);
                return;
            }
            return;
        }
        zzep zzepVar = ((zzet) zzfwVar).zzb;
        throw null;
    }
}
