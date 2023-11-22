package fsimpl;

import android.graphics.Shader;
import com.fullstory.util.Log;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class aQ {

    /* renamed from: a  reason: collision with root package name */
    private aI f7832a;
    private Set b = new HashSet();

    public aQ(aI aIVar) {
        this.f7832a = aIVar;
    }

    public int a(Map map, fi fiVar) {
        int i = 0;
        if (map == null) {
            return 0;
        }
        int[] iArr = new int[map.size()];
        for (Map.Entry entry : map.entrySet()) {
            Shader shader = (Shader) entry.getValue();
            int a2 = this.f7832a.a(fiVar, shader);
            if (a2 == 0 && this.b.add(shader.getClass())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered an unhandled shader: ");
                sb.append(shader);
                Log.e(sb.toString());
            }
            iArr[i] = C0295cs.a(fiVar, ((Integer) entry.getKey()).intValue(), a2);
            i++;
        }
        return C0291co.c(fiVar, iArr);
    }
}
