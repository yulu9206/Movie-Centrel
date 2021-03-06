package cmpe275.dos.mapper;

import cmpe275.dos.entity.User;
import cmpe275.dos.dto.*;

public class UserMapper extends GenericMapper {
    public UserDto toDto(User pojo){
        return mapT1toT2(pojo, new UserDto());
    }

    public User toPojo (UserDto dto) {
        return mapT1toT2(dto, new User());
    }

    public User toPojo (ParamCreateUserDto dto) {
        return mapT1toT2(dto, new User());
    }

    public UserSimpleDto toSimpleDto(User pojo){
        return mapT1toT2(pojo, new UserSimpleDto());
    }

    public User updPojo (UserDto dto, User pojo){
        if ( dto == null ) return pojo;
        updateValue(pojo::setRole, dto.getRole());
        updateValue(pojo::setCity, dto.getCity());
        updateValue(pojo::setEmail, dto.getEmail());
        updateValue(pojo::setFirstName, dto.getFirstName());
        updateValue(pojo::setLastName, dto.getLastName());
        updateValue(pojo::setPassword, dto.getPassword());
        updateValue(pojo::setPhone, dto.getPhone());
        updateValue(pojo::setState, dto.getState());
        updateValue(pojo::setStreet, dto.getStreet());
        updateValue(pojo::setUsername, dto.getUsername());
        updateValue(pojo::setZipcode, dto.getZipcode());
        updateValue(pojo::setSubexpiredate, dto.getSubexpiredate());
        return pojo;
    }
}
