package com.web.core.command;

import com.web.core.dto.ListenGuidelineDTO;
import com.web.core.web.command.AbstractCommand;

public class ListenguidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenguidelineCommand() {
        this.pojo = new ListenGuidelineDTO();
    }
}
