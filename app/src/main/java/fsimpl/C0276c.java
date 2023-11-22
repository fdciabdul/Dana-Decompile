package fsimpl;

import android.graphics.Region;
import java.util.HashMap;
import java.util.Map;

/* renamed from: fsimpl.c  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0276c {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f7899a;

    static {
        HashMap hashMap = new HashMap();
        f7899a = hashMap;
        hashMap.put(Region.Op.DIFFERENCE, EnumC0303d.DIFFERENCE);
        f7899a.put(Region.Op.INTERSECT, EnumC0303d.INTERSECT);
        f7899a.put(Region.Op.UNION, EnumC0303d.UNION);
        f7899a.put(Region.Op.XOR, EnumC0303d.XOR);
        f7899a.put(Region.Op.REVERSE_DIFFERENCE, EnumC0303d.REVERSE_DIFFERENCE);
        f7899a.put(Region.Op.REPLACE, EnumC0303d.REPLACE);
    }
}
