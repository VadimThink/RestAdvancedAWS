package com.epam.esm.link;

import com.epam.esm.controller.UserController;
import com.epam.esm.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class UserLinkProvider extends AbstractLinkProvider<UserResponseDto> {
    private static final Class<UserController> CONTROLLER_CLASS = UserController.class;

    @Override
    public void provideLinks(UserResponseDto dto) {
        long id = dto.getId();
        provideIdLink(CONTROLLER_CLASS, dto, dto.getId(), SELF_LINK);
        dto.add(linkTo(CONTROLLER_CLASS)
                .slash(id)
                .slash("orders")
                .withRel("orders"));
    }
}
