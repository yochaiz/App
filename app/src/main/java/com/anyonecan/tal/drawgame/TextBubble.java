package com.anyonecan.tal.drawgame;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TextBubble {
    private final static int bubbleLayoutID = R.id.bubble;
    private final static int speakerLayoutID = R.id.speakerIcon;
    protected final static int textViewLayoutID = R.id.bubbleTv;
    protected Integer stringID = null;
    protected Integer colorID = null;
    private Integer iconID = null;
    private RelativeLayout bubbleLayout = null;
    private RelativeLayout speakerLayout = null;
    protected RelativeLayout tvLayout = null;
    private BaseActivity actv = null;

    TextBubble(final int stringID, final int colorID, final BaseActivity activity) {
        this.stringID = stringID;
        this.colorID = colorID;
        this.actv = activity;
        tvLayout = (RelativeLayout) activity.findViewById(textViewLayoutID);
    }

    TextBubble(final int stringID, final int colorID, final int iconID, final BaseActivity activity) {
        this(stringID, colorID, activity);
        this.iconID = iconID;
        bubbleLayout = (RelativeLayout) activity.findViewById(bubbleLayoutID);
        speakerLayout = (RelativeLayout) activity.findViewById(speakerLayoutID);
    }

    protected void createTextBubble() {
        if (tvLayout == null) {
            return;
        }

        tvLayout.removeAllViews();
        final int maxHeight = 500; //random big value to assure text will be all over the bubble
        Typewriter textView = new Typewriter(actv.getBaseContext());
        textView.setGravity(Gravity.CENTER);
        textView.setMaxLines(2);
        textView.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, maxHeight, actv.getResources().getDisplayMetrics()));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        // since we use it only once per each click, we don't need to cache the results, ever
        textView.setEnableSizeCache(false);
        textView.setCharacterDelay(100);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.animateText(actv.getText(stringID));
        tvLayout.addView(textView);
    }

    public void setVisible() {
        if (bubbleLayout != null) {
            bubbleLayout.setBackgroundResource(colorID);
        }
        if (speakerLayout != null) {
            speakerLayout.setBackgroundResource(iconID);
        }
        if (tvLayout != null) {
            tvLayout.setTag(textViewLayoutID, stringID);
            tvLayout.setBackgroundResource(0);
        }
        createTextBubble();
    }

    public void setHidden() {
        Integer ID = (Integer) tvLayout.getTag(textViewLayoutID);
        if ((ID != null) && (ID == stringID)) { //this is my bubble
            tvLayout.removeAllViews();
            tvLayout.setBackgroundResource(0);

            if (bubbleLayout != null) {
                bubbleLayout.setBackgroundResource(0);
            }
            if (speakerLayout != null) {
                speakerLayout.setBackgroundResource(0);
            }
        }
    }
}