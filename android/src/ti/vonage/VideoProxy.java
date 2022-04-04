package ti.vonage;

import android.app.Activity;
import android.view.View;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;


@Kroll.proxy(creatableInModule = TiVonageModule.class)
public class VideoProxy extends TiViewProxy {
    private static final String LCAT = "VideoProxy";
    private static final boolean DBG = TiConfig.LOGD;
    private final View vview;

    // Constructor
    public VideoProxy(View view) {
        super();
        vview = view;
    }

    @Override
    public TiUIView createView(Activity activity) {
        TiUIView view = new VideoView(this);
        view.getLayoutParams().autoFillsHeight = true;
        view.getLayoutParams().autoFillsWidth = true;
        return view;
    }

    // Handle creation options
    @Override
    public void handleCreationDict(KrollDict options) {
        super.handleCreationDict(options);

    }

    private class VideoView extends TiUIView {
        public VideoView(TiViewProxy proxy) {
            super(proxy);
            LayoutArrangement arrangement = LayoutArrangement.DEFAULT;

            if (proxy.hasProperty(TiC.PROPERTY_LAYOUT)) {
                String layoutProperty = TiConvert.toString(proxy.getProperty(TiC.PROPERTY_LAYOUT));
                if (layoutProperty.equals(TiC.LAYOUT_HORIZONTAL)) {
                    arrangement = LayoutArrangement.HORIZONTAL;
                } else if (layoutProperty.equals(TiC.LAYOUT_VERTICAL)) {
                    arrangement = LayoutArrangement.VERTICAL;
                }
            }
            if (vview != null) {
                setNativeView(vview);
            } else {
                setNativeView(new TiCompositeLayout(proxy.getActivity(), arrangement));
            }

        }

        @Override
        public void processProperties(KrollDict d) {
            super.processProperties(d);
        }

    }
}
