package id.dana.social.v2.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.social.v2.adapter.FeedActivityAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/v2/viewholder/FeedShareActivityBannerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Lid/dana/social/v2/adapter/FeedActivityAdapter;", "getAuthRequestContext", "Lid/dana/social/v2/adapter/FeedActivityAdapter;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedShareActivityBannerViewHolder extends BaseRecyclerViewHolder<Integer> {
    public final FeedActivityAdapter getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Integer num) {
        super.bindData(num);
        View view = this.itemView;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tlActivityPager);
        if (tabLayout != null) {
            Intrinsics.checkNotNullExpressionValue(tabLayout, "");
            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.dispatchNestedPrePerformAccessibilityAction);
            Intrinsics.checkNotNullExpressionValue(viewPager2, "");
            ViewPagerExtKt.getAuthRequestContext(tabLayout, viewPager2, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: INVOKE 
                  (r0v2 'tabLayout' com.google.android.material.tabs.TabLayout)
                  (r4v4 'viewPager2' androidx.viewpager2.widget.ViewPager2)
                  (wrap: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1 : 0x0000: SGET  A[WRAPPED] (LINE:27) id.dana.extension.view.ViewPagerExtKt$attachViewPager$1.INSTANCE id.dana.extension.view.ViewPagerExtKt$attachViewPager$1)
                 type: STATIC call: id.dana.extension.view.ViewPagerExtKt.getAuthRequestContext(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2):void A[MD:(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2<? super com.google.android.material.tabs.TabLayout$Tab, ? super java.lang.Integer, kotlin.Unit>):void (m)] (LINE:25) in method: id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder.bindData(java.lang.Integer):void, file: classes5.dex
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
                	... 23 more
                */
            /*
                this = this;
                java.lang.Integer r4 = (java.lang.Integer) r4
                super.bindData(r4)
                android.view.View r4 = r3.itemView
                int r0 = id.dana.R.id.tlActivityPager
                android.view.View r0 = r4.findViewById(r0)
                com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
                if (r0 == 0) goto L24
                java.lang.String r1 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                int r2 = id.dana.R.id.dispatchNestedPrePerformAccessibilityAction
                android.view.View r4 = r4.findViewById(r2)
                androidx.viewpager2.widget.ViewPager2 r4 = (androidx.viewpager2.widget.ViewPager2) r4
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
                id.dana.extension.view.ViewPagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r0, r4)
            L24:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder.bindData(java.lang.Object):void");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedShareActivityBannerViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1) {
            super(viewGroup.getContext(), R.layout.view_share_activity_banner, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(function1, "");
            FeedActivityAdapter feedActivityAdapter = new FeedActivityAdapter();
            this.getAuthRequestContext = feedActivityAdapter;
            final View view = this.itemView;
            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.dispatchNestedPrePerformAccessibilityAction);
            if (viewPager2 != null) {
                viewPager2.setAdapter(feedActivityAdapter);
            }
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) view.findViewById(R.id.btnShareActivity);
            if (danaButtonPrimaryView != null) {
                danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FeedShareActivityBannerViewHolder.BuiltInFictitiousFunctionClassFactory(Function1.this, view);
                    }
                });
            }
            MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.cvActivityContainer);
            final Group group = (Group) view.findViewById(R.id.share_activity_content_group);
            if (materialCardView != null) {
                materialCardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FeedShareActivityBannerViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(group, this);
                    }
                });
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(android.view.View r4, id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder r5) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                r0 = 0
                r1 = 1
                if (r4 == 0) goto L16
                int r2 = r4.getVisibility()
                if (r2 != 0) goto L11
                r2 = 1
                goto L12
            L11:
                r2 = 0
            L12:
                if (r2 != r1) goto L16
                r2 = 1
                goto L17
            L16:
                r2 = 0
            L17:
                r3 = 0
                if (r2 == 0) goto L36
                android.view.View r2 = r5.itemView
                if (r2 == 0) goto L27
                int r3 = id.dana.R.id.ivToggleBanner
                android.view.View r2 = r2.findViewById(r3)
                r3 = r2
                androidx.appcompat.widget.AppCompatImageView r3 = (androidx.appcompat.widget.AppCompatImageView) r3
            L27:
                android.content.Context r5 = r5.getContext()
                r2 = 2130772047(0x7f01004f, float:1.7147201E38)
                android.view.animation.Animation r5 = android.view.animation.AnimationUtils.loadAnimation(r5, r2)
                r3.startAnimation(r5)
                goto L51
            L36:
                android.view.View r2 = r5.itemView
                if (r2 == 0) goto L43
                int r3 = id.dana.R.id.ivToggleBanner
                android.view.View r2 = r2.findViewById(r3)
                r3 = r2
                androidx.appcompat.widget.AppCompatImageView r3 = (androidx.appcompat.widget.AppCompatImageView) r3
            L43:
                android.content.Context r5 = r5.getContext()
                r2 = 2130772049(0x7f010051, float:1.7147205E38)
                android.view.animation.Animation r5 = android.view.animation.AnimationUtils.loadAnimation(r5, r2)
                r3.startAnimation(r5)
            L51:
                if (r4 == 0) goto L65
                int r5 = r4.getVisibility()
                if (r5 != 0) goto L5b
                r5 = 1
                goto L5c
            L5b:
                r5 = 0
            L5c:
                r5 = r5 ^ r1
                if (r5 == 0) goto L60
                goto L62
            L60:
                r0 = 8
            L62:
                r4.setVisibility(r0)
            L65:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(android.view.View, id.dana.social.v2.viewholder.FeedShareActivityBannerViewHolder):void");
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function1 function1, View view) {
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(view, "");
            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.dispatchNestedPrePerformAccessibilityAction);
            function1.invoke(Integer.valueOf(viewPager2 != null ? viewPager2.getCurrentItem() : -1));
        }
    }
