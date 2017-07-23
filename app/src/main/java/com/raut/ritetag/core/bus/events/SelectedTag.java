package com.raut.ritetag.core.bus.events;

import com.raut.ritetag.core.api.response.Tag;

/**
 * Created by Raut Darpan on 05/05/17.
 */

public class SelectedTag {

    public final Tag tag;

    public SelectedTag(Tag tag) {
        this.tag = tag;
    }
}
