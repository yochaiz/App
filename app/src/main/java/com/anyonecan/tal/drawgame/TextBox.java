package com.anyonecan.tal.drawgame;

public class TextBox extends TextBubble {

    TextBox(final int stringID, final int colorID, final BaseActivity activity) {
        super(stringID, colorID, activity);
    }

    @Override
    public void setVisible() {
        if (tvLayout != null) {
            tvLayout.setTag(textViewLayoutID, stringID); //detects collision between 2 different characters
            tvLayout.setBackgroundResource(colorID);
            createTextBubble();
        }
    }

    @Override
    public void setHidden() {
        if (tvLayout != null) {
            Integer bckgrndID = (Integer) tvLayout.getTag(textViewLayoutID);
            if ((bckgrndID != null) && (bckgrndID.equals(stringID))) {
                tvLayout.setBackgroundResource(0);
                tvLayout.removeAllViews();
            }
        }
    }
}