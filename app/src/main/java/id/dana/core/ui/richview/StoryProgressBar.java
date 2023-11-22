package id.dana.core.ui.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u000223B\u001b\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u000fR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010#R\u0016\u0010\u001f\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010#R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050%j\b\u0012\u0004\u0012\u00020\u0005`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0003\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010 R\u0018\u0010*\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+"}, d2 = {"Lid/dana/core/ui/richview/StoryProgressBar;", "Landroid/widget/LinearLayout;", "", "MyBillsEntityDataFactory", "()V", "Lid/dana/core/ui/richview/PausableProgressBar;", "PlaceComponentResult", "()Lid/dana/core/ui/richview/PausableProgressBar;", "destroy", "pause", "resume", "reverse", "", "storiesCount", "setStoriesCount", "(I)V", "", "durations", "setStoriesCountWithDurations", "([J)V", "Lid/dana/core/ui/richview/StoryProgressBar$StoriesListener;", "storiesListener", "setStoriesListener", "(Lid/dana/core/ui/richview/StoryProgressBar$StoriesListener;)V", "", "duration", "setStoryDuration", "(J)V", HummerConstants.HUMMER_SKIP, "startStories", "from", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "", "Z", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "moveToNextValue", "Ljava/util/ArrayList;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Lid/dana/core/ui/richview/StoryProgressBar$StoriesListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "StoriesListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StoryProgressBar extends LinearLayout {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    private StoriesListener getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ArrayList<PausableProgressBar> PlaceComponentResult;
    private static final LinearLayout.LayoutParams MyBillsEntityDataFactory = new LinearLayout.LayoutParams(0, -2, 1.0f);
    private static final LinearLayout.LayoutParams BuiltInFictitiousFunctionClassFactory = new LinearLayout.LayoutParams(10, -2);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/richview/StoryProgressBar$StoriesListener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface StoriesListener {
        void BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StoryProgressBar(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.richview.StoryProgressBar.<init>(android.content.Context):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = new ArrayList<>();
        this.MyBillsEntityDataFactory = -1;
        this.getAuthRequestContext = -1;
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.storeUserConfig);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(R.styleable.murmurHash64WithSeed, 0);
        obtainStyledAttributes.recycle();
        MyBillsEntityDataFactory();
    }

    public /* synthetic */ StoryProgressBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.clear();
        removeAllViews();
        int i = this.MyBillsEntityDataFactory;
        int i2 = 0;
        while (i2 < i) {
            PausableProgressBar PlaceComponentResult = PlaceComponentResult();
            this.PlaceComponentResult.add(PlaceComponentResult);
            addView(PlaceComponentResult);
            i2++;
            if (i2 < this.MyBillsEntityDataFactory) {
                View view = new View(getContext());
                view.setLayoutParams(BuiltInFictitiousFunctionClassFactory);
                addView(view);
            }
        }
    }

    private final PausableProgressBar PlaceComponentResult() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        PausableProgressBar pausableProgressBar = new PausableProgressBar(context, null, 0, 6, null);
        pausableProgressBar.setLayoutParams(MyBillsEntityDataFactory);
        return pausableProgressBar;
    }

    public final void setStoriesCount(int storiesCount) {
        this.MyBillsEntityDataFactory = storiesCount;
        MyBillsEntityDataFactory();
    }

    public final void setStoriesListener(StoriesListener storiesListener) {
        Intrinsics.checkNotNullParameter(storiesListener, "");
        this.getErrorConfigVersion = storiesListener;
    }

    public final void skip() {
        int i;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 || this.BuiltInFictitiousFunctionClassFactory || (i = this.getAuthRequestContext) < 0) {
            return;
        }
        PausableProgressBar pausableProgressBar = this.PlaceComponentResult.get(i);
        Intrinsics.checkNotNullExpressionValue(pausableProgressBar, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        pausableProgressBar.setMax();
    }

    public final void reverse() {
        int i;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 || this.BuiltInFictitiousFunctionClassFactory || (i = this.getAuthRequestContext) < 0) {
            return;
        }
        PausableProgressBar pausableProgressBar = this.PlaceComponentResult.get(i);
        Intrinsics.checkNotNullExpressionValue(pausableProgressBar, "");
        this.BuiltInFictitiousFunctionClassFactory = true;
        pausableProgressBar.setMin();
    }

    public final void setStoryDuration(long duration) {
        int size = this.PlaceComponentResult.size();
        for (int i = 0; i < size; i++) {
            this.PlaceComponentResult.get(i).setDuration(duration);
            this.PlaceComponentResult.get(i).setCallback(new StoryProgressBar$callback$1(this, i));
        }
    }

    public final void setStoriesCountWithDurations(long[] durations) {
        Intrinsics.checkNotNullParameter(durations, "");
        this.MyBillsEntityDataFactory = durations.length;
        MyBillsEntityDataFactory();
        int size = this.PlaceComponentResult.size();
        for (int i = 0; i < size; i++) {
            this.PlaceComponentResult.get(i).setDuration(durations[i]);
            this.PlaceComponentResult.get(i).setCallback(new StoryProgressBar$callback$1(this, i));
        }
    }

    public final void startStories() {
        this.PlaceComponentResult.get(0).startProgress();
    }

    public final void startStories(int from) {
        for (int i = 0; i < from; i++) {
            this.PlaceComponentResult.get(i).setMaxWithoutCallback();
        }
        this.PlaceComponentResult.get(from).startProgress();
    }

    public final void destroy() {
        Iterator<PausableProgressBar> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public final void pause() {
        int i = this.getAuthRequestContext;
        if (i < 0) {
            return;
        }
        this.PlaceComponentResult.get(i).pauseProgress();
    }

    public final void resume() {
        int i = this.getAuthRequestContext;
        if (i < 0) {
            return;
        }
        this.PlaceComponentResult.get(i).resumeProgress();
    }
}
