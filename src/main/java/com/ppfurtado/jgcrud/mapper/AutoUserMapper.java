package com.ppfurtado.jgcrud.mapper;

import com.ppfurtado.jgcrud.dto.UserDto;
import com.ppfurtado.jgcrud.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUSerDto(User user);

    User mapToUser(UserDto userDto);
}
