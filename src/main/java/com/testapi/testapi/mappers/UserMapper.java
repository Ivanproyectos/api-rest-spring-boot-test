package com.testapi.testapi.mappers;

import com.testapi.testapi.contracts.dtos.UserDto;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import com.testapi.testapi.models.User;
import com.testapi.testapi.Dtos.PagedResult;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class );

    @Mapping(source="content", target="data")
    @Mapping(source="totalElements", target="totalRecords")
    @Mapping(source = "pageable.pageNumber", target = "pageNumber")
    @Mapping(source = "pageable.pageSize", target = "pageSize")
    PagedResult<UserDto> userPageToUsersPageResult(Page<User> users);

    UserDto userToUserDto(User user);
}
