package id.dana.social.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.social.common.FeedOnboardingListener;
import id.dana.social.onboarding.adapter.FeedOnboardingAdapter;
import id.dana.utils.SafeClickListenerExtensionKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aB+\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007R.\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/social/v2/view/FeedOnboardingView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "renderButtonDisabled", "()V", "renderButtonEnabled", "renderButtonError", "setup", "Lid/dana/social/common/FeedOnboardingListener;", "value", "getAuthRequestContext", "Lid/dana/social/common/FeedOnboardingListener;", "getListener", "()Lid/dana/social/common/FeedOnboardingListener;", "setListener", "(Lid/dana/social/common/FeedOnboardingListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedOnboardingView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FeedOnboardingListener listener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_feed_onboarding_v2;
    }

    @JvmName(name = "getListener")
    public final FeedOnboardingListener getListener() {
        return this.listener;
    }

    @JvmName(name = "setListener")
    public final void setListener(final FeedOnboardingListener feedOnboardingListener) {
        this.listener = feedOnboardingListener;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.isLayoutRequested_res_0x7f0a011f);
        if (danaButtonPrimaryView != null) {
            SafeClickListenerExtensionKt.MyBillsEntityDataFactory(danaButtonPrimaryView, new Function1<View, Unit>() { // from class: id.dana.social.v2.view.FeedOnboardingView$listener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    FeedOnboardingListener feedOnboardingListener2 = FeedOnboardingListener.this;
                    if (feedOnboardingListener2 != null) {
                        feedOnboardingListener2.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FeedOnboardingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void renderButtonDisabled() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.deletePluginInfoById);
        if (textView != null) {
            textView.setVisibility(8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.isLayoutRequested_res_0x7f0a011f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(false);
            Context context = danaButtonPrimaryView.getContext();
            String string = context != null ? context.getString(R.string.social_feeds_loading) : null;
            if (string == null) {
                string = "";
            }
            danaButtonPrimaryView.setDanaButtonView(0, string, "", null);
        }
    }

    public final void renderButtonError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.deletePluginInfoById);
        if (textView != null) {
            textView.setVisibility(0);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.isLayoutRequested_res_0x7f0a011f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(true);
            Context context = danaButtonPrimaryView.getContext();
            String string = context != null ? context.getString(R.string.try_again) : null;
            if (string == null) {
                string = "";
            }
            danaButtonPrimaryView.setDanaButtonView(1, string, "", null);
        }
    }

    public final void renderButtonEnabled() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.deletePluginInfoById);
        if (textView != null) {
            textView.setVisibility(8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.isLayoutRequested_res_0x7f0a011f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(true);
            Context context = danaButtonPrimaryView.getContext();
            String string = context != null ? context.getString(R.string.feed_onboarding_activate) : null;
            if (string == null) {
                string = "";
            }
            danaButtonPrimaryView.setDanaButtonView(1, string, "", null);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.increaseTrafficTypeCount);
        if (viewPager2 != null) {
            Context context = viewPager2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            viewPager2.setAdapter(new FeedOnboardingAdapter(context, true));
        }
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(R.id.getmOuterPage);
        if (tabLayout != null) {
            ViewPager2 viewPager22 = (ViewPager2) _$_findCachedViewById(R.id.increaseTrafficTypeCount);
            Intrinsics.checkNotNullExpressionValue(viewPager22, "");
            ViewPagerExtKt.getAuthRequestContext(tabLayout, viewPager22, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: INVOKE 
                  (r0v5 'tabLayout' com.google.android.material.tabs.TabLayout)
                  (r2v4 'viewPager22' androidx.viewpager2.widget.ViewPager2)
                  (wrap: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1 : 0x0000: SGET  A[WRAPPED] (LINE:27) id.dana.extension.view.ViewPagerExtKt$attachViewPager$1.INSTANCE id.dana.extension.view.ViewPagerExtKt$attachViewPager$1)
                 type: STATIC call: id.dana.extension.view.ViewPagerExtKt.getAuthRequestContext(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2):void A[MD:(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2<? super com.google.android.material.tabs.TabLayout$Tab, ? super java.lang.Integer, kotlin.Unit>):void (m)] (LINE:25) in method: id.dana.social.v2.view.FeedOnboardingView.setup():void, file: classes5.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                	... 21 more
                */
            /*
                this = this;
                int r0 = id.dana.R.id.increaseTrafficTypeCount
                android.view.View r0 = r5._$_findCachedViewById(r0)
                androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
                java.lang.String r1 = ""
                if (r0 == 0) goto L1e
                android.content.Context r2 = r0.getContext()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
                id.dana.social.onboarding.adapter.FeedOnboardingAdapter r3 = new id.dana.social.onboarding.adapter.FeedOnboardingAdapter
                r4 = 1
                r3.<init>(r2, r4)
                androidx.recyclerview.widget.RecyclerView$Adapter r3 = (androidx.recyclerview.widget.RecyclerView.Adapter) r3
                r0.setAdapter(r3)
            L1e:
                int r0 = id.dana.R.id.getmOuterPage
                android.view.View r0 = r5._$_findCachedViewById(r0)
                com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
                if (r0 == 0) goto L38
                int r2 = id.dana.R.id.increaseTrafficTypeCount
                android.view.View r2 = r5._$_findCachedViewById(r2)
                androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
                id.dana.extension.view.ViewPagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r0, r2)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
            L38:
                int r0 = id.dana.R.id.PayAssetMapper_Factory
                android.view.View r0 = r5._$_findCachedViewById(r0)
                androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
                if (r0 == 0) goto L5d
                android.widget.TextView r0 = (android.widget.TextView) r0
                android.content.Context r2 = r5.getContext()
                r3 = 2131957500(0x7f1316fc, float:1.9551586E38)
                java.lang.String r2 = r2.getString(r3)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
                r1 = 0
                id.dana.social.v2.view.FeedOnboardingView$setupTnc$1 r3 = new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: id.dana.social.v2.view.FeedOnboardingView$setupTnc$1
                    static {
                        /*
                            id.dana.social.v2.view.FeedOnboardingView$setupTnc$1 r0 = new id.dana.social.v2.view.FeedOnboardingView$setupTnc$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:id.dana.social.v2.view.FeedOnboardingView$setupTnc$1) id.dana.social.v2.view.FeedOnboardingView$setupTnc$1.INSTANCE id.dana.social.v2.view.FeedOnboardingView$setupTnc$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.view.FeedOnboardingView$setupTnc$1.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 0
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.view.FeedOnboardingView$setupTnc$1.<init>():void");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ kotlin.Unit invoke() {
                        /*
                            r1 = this;
                            r1.invoke2()
                            kotlin.Unit r0 = kotlin.Unit.INSTANCE
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.view.FeedOnboardingView$setupTnc$1.invoke():java.lang.Object");
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        /*
                            r2 = this;
                            java.lang.String r0 = "/m/standalone/tnc"
                            java.lang.String r0 = id.dana.utils.UrlUtil.getAuthRequestContext(r0)
                            java.lang.String r1 = ""
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                            id.dana.danah5.DanaH5.startContainerFullUrl(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.view.FeedOnboardingView$setupTnc$1.invoke2():void");
                    }
                }
                kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
                r4 = 4
                id.dana.extension.view.InputExtKt.PlaceComponentResult(r0, r2, r1, r3, r4)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
            L5d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.view.FeedOnboardingView.setup():void");
        }
    }
