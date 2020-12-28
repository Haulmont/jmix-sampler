package io.jmix.sampler.config;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SamplerMenuItem {

    protected final SamplerMenuItem parent;
    protected final List<SamplerMenuItem> children = new ArrayList<>();

    protected final String id;
    protected String url;
    protected String splitEnabled;
    protected String image;
    protected List<String> otherFiles;
    protected Map<String, Object> screenParams;

    protected boolean isMenu = false;

    public SamplerMenuItem(SamplerMenuItem parent, String id) {
        this.parent = parent;
        this.id = id;
    }

    public SamplerMenuItem getParent() {
        return parent;
    }

    public String getId() {
        return id;
    }

    public boolean isMenu() {
        return isMenu;
    }

    public void setMenu(boolean isMenu) {
        this.isMenu = isMenu;
    }

    @Nullable
    public String getSplitEnabled() {
        return splitEnabled;
    }

    public void setSplitEnabled(String splitEnabled) {
        this.splitEnabled = splitEnabled;
    }

    public List<String> getOtherFiles() {
        if (otherFiles == null)
            return Collections.emptyList();
        return otherFiles;
    }

    public void setOtherFiles(List<String> otherFiles) {
        this.otherFiles = otherFiles;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<SamplerMenuItem> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(SamplerMenuItem item) {
        children.add(item);
    }

    public Map<String, Object> getScreenParams() {
        return screenParams != null
                ? Collections.unmodifiableMap(screenParams)
                : Collections.emptyMap();
    }

    public void setScreenParams(Map<String, Object> screenParams) {
        this.screenParams = screenParams;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return id;
    }
}
