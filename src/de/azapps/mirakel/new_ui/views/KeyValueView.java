/*******************************************************************************
 * Mirakel is an Android App for managing your ToDo-Lists
 *
 *   Copyright (c) 2013-2015 Anatolij Zelenin, Georg Semmler.
 *
 *       This program is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       any later version.
 *
 *       This program is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU General Public License for more details.
 *
 *       You should have received a copy of the GNU General Public License
 *       along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package de.azapps.mirakel.new_ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.azapps.material_elements.utils.ThemeManager;
import de.azapps.mirakelandroid.R;

public class KeyValueView extends LinearLayout {
    @InjectView(R.id.title)
    TextView titleView;
    @InjectView(R.id.value)
    TextView valueView;

    private int iconId;
    private CharSequence keyText;


    public KeyValueView(final Context context) {
        this(context, null);
    }

    public KeyValueView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KeyValueView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_key_value, this);
        ButterKnife.inject(this, this);
    }

    public void setup(final int iconId, final CharSequence keyText) {
        this.iconId = iconId;
        this.keyText = keyText;
    }
    public void setColor(final int color) {
        final Drawable dueIcon = ThemeManager.getColoredIcon(iconId, color);
        titleView.setCompoundDrawablesWithIntrinsicBounds(dueIcon, null, null, null);
        titleView.setTextColor(color);
        valueView.setTextColor(color);
    }

    public void setValue(final CharSequence value) {
        titleView.setText(keyText);
        valueView.setText(value);
        valueView.setVisibility(VISIBLE);
    }

    public void setNoValue(final String text) {
        titleView.setText(text);
        valueView.setVisibility(GONE);
    }
}
