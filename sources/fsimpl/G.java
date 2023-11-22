package fsimpl;

import com.alipay.alipaysecuritysdk.rds.constant.DictionaryKeys;
import com.fullstory.FS;
import com.fullstory.FSPage;
import com.fullstory.util.Log;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;

/* loaded from: classes.dex */
public final class G extends FSPage {

    /* renamed from: a  reason: collision with root package name */
    private static final UUID f7803a = new UUID(0, 0);
    private final String b;
    private final Map c;
    private UUID d = f7803a;

    public G(String str, Map map) {
        this.b = str;
        this.c = eS.a(map);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(Object obj, Object obj2) {
        if ((obj instanceof Map) && (obj2 instanceof Map)) {
            Map map = (Map) obj;
            for (Map.Entry entry : ((Map) obj2).entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.put(str, null);
                } else {
                    map.merge(str, value, new BiFunction() { // from class: fsimpl.-$$Lambda$G$X4PkzBaPdqGrVumhiKN0ixLu5ic
                        @Override // java.util.function.BiFunction
                        public final Object apply(Object obj3, Object obj4) {
                            Object a2;
                            a2 = G.this.a(obj3, obj4);
                            return a2;
                        }
                    });
                }
            }
            return map;
        }
        return obj2;
    }

    private void a() {
        if (this.c.containsKey(DictionaryKeys.V2_PAGENAME)) {
            this.c.remove(DictionaryKeys.V2_PAGENAME);
            Log.w(String.format("%s is a reserved property and has been removed.", DictionaryKeys.V2_PAGENAME));
        }
    }

    private void a(Map map) {
        a(this.c, map);
        a();
    }

    @Override // com.fullstory.FSPage
    public final void end() {
        if (this.d == f7803a) {
            Log.e("Called `end` on FSPage that has not been `start`-ed. `end` should be called on the same FSPage instance that the corresponding `start` is called on.");
        }
        FS.__endPage(this.d);
        this.d = f7803a;
    }

    @Override // com.fullstory.FSPage
    public final String getPageName() {
        return this.b;
    }

    @Override // com.fullstory.FSPage
    public final Map getProperties() {
        return this.c;
    }

    @Override // com.fullstory.FSPage
    public final void start() {
        UUID randomUUID = UUID.randomUUID();
        this.d = randomUUID;
        FS.__pageView(randomUUID, this.b, this.c);
    }

    @Override // com.fullstory.FSPage
    public final void start(Map map) {
        a(eS.a(map));
        start();
    }

    @Override // com.fullstory.FSPage
    public final void updateProperties(Map map) {
        if (this.d == f7803a) {
            Log.alwaysWarn("Called `updateProperties` on FSPage that has not been `start`-ed. This may be a mistake. `updateProperties` should be called on the same FSPage instance that the corresponding `start` is called on.");
        }
        a(eS.a(map));
        FS.__updatePageProperties(this.d, map);
    }
}
