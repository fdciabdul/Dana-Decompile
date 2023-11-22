package id.dana.danah5.tooltip.manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import id.dana.R;
import id.dana.danah5.tooltip.TooltipResultFactory;
import id.dana.danah5.tooltip.entity.ShowcaseEntity;
import id.dana.danah5.tooltip.entity.TooltipEntity;
import id.dana.danah5.tooltip.listener.FragmentResultHandler;
import id.dana.danah5.tooltip.listener.FragmentResultListener;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingActivity;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TooltipPluginManager {
    private static final String DRAWABLE = "drawable";
    private static final String LIST = "list";
    private static final String SLIDESHOW = "slideshow";
    private static final int SPOTLIGHT_SIZE = SizeUtil.getAuthRequestContext(20);
    private static final String VIEW_PAGER = "viewPager";
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private FragmentResultHandler fragmentResultHandler;

    public TooltipPluginManager(Activity activity, BridgeCallback bridgeCallback) {
        this.bridgeCallback = bridgeCallback;
        this.activity = activity;
    }

    public boolean openBottomSheet(TooltipEntity tooltipEntity) {
        return checkEventType(tooltipEntity, tooltipEntity.getType());
    }

    private boolean checkEventType(TooltipEntity tooltipEntity, String str) {
        if ("viewPager".equalsIgnoreCase(str) || "list".equalsIgnoreCase(str) || "slideshow".equalsIgnoreCase(str)) {
            handleBottomSheet(tooltipEntity, str);
            return true;
        }
        return false;
    }

    private void handleBottomSheet(TooltipEntity tooltipEntity, final String str) {
        if (!isTooltipEntityValid(tooltipEntity) || this.activity.isFinishing()) {
            return;
        }
        FragmentResultHandler build = FragmentResultHandler.build(this.activity, createTooltipBundle(tooltipEntity));
        this.fragmentResultHandler = build;
        build.addListener(new FragmentResultListener() { // from class: id.dana.danah5.tooltip.manager.TooltipPluginManager.1
            @Override // id.dana.danah5.tooltip.listener.FragmentResultListener
            public void onFragmentCreated(FragmentResultHandler fragmentResultHandler, Bundle bundle) {
                Intent createOnBoardingIntent;
                OnBoardingModel onBoardingModel = (OnBoardingModel) bundle.getParcelable("data");
                if ("viewPager".equalsIgnoreCase(str) || "slideshow".equalsIgnoreCase(str)) {
                    createOnBoardingIntent = BottomSheetOnBoardingActivity.createOnBoardingIntent(fragmentResultHandler.getActivity(), onBoardingModel);
                } else if (!"list".equalsIgnoreCase(str)) {
                    return;
                } else {
                    createOnBoardingIntent = BottomSheetHelpActivity.createBottomSheetHelpIntent(fragmentResultHandler.getActivity(), onBoardingModel);
                }
                TooltipPluginManager.this.openBottomSheet(createOnBoardingIntent);
            }

            @Override // id.dana.danah5.tooltip.listener.FragmentResultListener
            public void onActivityResult(int i, int i2, Intent intent) {
                TooltipPluginManager.this.sendResult(i2 == -1);
                TooltipPluginManager.this.fragmentResultHandler.destroy(TooltipPluginManager.this.activity);
            }
        });
    }

    public void openShowCase(ShowcaseEntity showcaseEntity) {
        Target createTargetFrom = createTargetFrom(showcaseEntity.getTitle(), showcaseEntity.getBody());
        if (createTargetFrom == null) {
            return;
        }
        createTargetFrom.BuiltInFictitiousFunctionClassFactory = true;
        SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(this.activity);
        simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = createTargetFrom;
        simpleShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(true).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.danah5.tooltip.manager.TooltipPluginManager.2
            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
            public void onFinished(int i) {
                TooltipPluginManager.this.sendResult(true);
            }
        }).PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openBottomSheet(Intent intent) {
        this.fragmentResultHandler.startActivityForResult(intent, 201);
    }

    private Bundle createTooltipBundle(TooltipEntity tooltipEntity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", new OnBoardingModel(tooltipEntity.getTitle(), tooltipEntity.getType(), getContentOnBoardingModels(tooltipEntity), tooltipEntity.getBizType().toLowerCase()));
        return bundle;
    }

    private List<ContentOnBoardingModel> getContentOnBoardingModels(TooltipEntity tooltipEntity) {
        ArrayList arrayList = new ArrayList();
        Iterator<TooltipEntity.Page> it = tooltipEntity.getPages().iterator();
        while (it.hasNext()) {
            arrayList.add(getContentOnBoardingModel(it.next()));
        }
        return arrayList;
    }

    private ContentOnBoardingModel getContentOnBoardingModel(TooltipEntity.Page page) {
        if (isPageImageFromURL(page)) {
            return new ContentOnBoardingModel(page.getImage(), page.getTitle(), page.getBody());
        }
        return new ContentOnBoardingModel(getResourceFromName(page.getImage()), page.getTitle(), page.getBody());
    }

    private boolean isPageImageFromURL(TooltipEntity.Page page) {
        return "URL".equalsIgnoreCase(page.getImageSource());
    }

    private int getResourceFromName(String str) {
        return this.activity.getResources().getIdentifier(str, DRAWABLE, this.activity.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResult(boolean z) {
        this.bridgeCallback.sendJSONResponse(TooltipResultFactory.getResult(z ? "SUCCESS" : "UNKNOWN_ERROR"));
    }

    private boolean isTooltipEntityValid(TooltipEntity tooltipEntity) {
        return (tooltipEntity == null || tooltipEntity.getPages() == null || tooltipEntity.getPages().isEmpty() || TextUtils.isEmpty(tooltipEntity.getBizType())) ? false : true;
    }

    private Target createTargetFrom(String str, String str2) {
        View findViewById = this.activity.findViewById(R.id.h5_bt_options);
        if (findViewById == null) {
            return null;
        }
        return new TargetBuilder(this.activity).BuiltInFictitiousFunctionClassFactory(findViewById).BuiltInFictitiousFunctionClassFactory(new CircleShape(SPOTLIGHT_SIZE)).getAuthRequestContext(new Content(str, str2, 0)).KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
