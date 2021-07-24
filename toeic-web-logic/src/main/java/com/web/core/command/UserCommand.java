package com.web.core.command;

import com.web.core.dto.UserDTO;
import com.web.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand() {
        this.pojo = new UserDTO();
    }
}
