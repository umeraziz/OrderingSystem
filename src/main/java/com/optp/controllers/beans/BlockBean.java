package com.optp.controllers.beans;

import javax.validation.constraints.NotNull;

public class BlockBean {

    private int blockId;

    @NotNull
    private String blockName;

    private int blockStatus;

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(int blockStatus) {
        this.blockStatus = blockStatus;
    }
}
